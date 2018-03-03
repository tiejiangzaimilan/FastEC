package com.liweqnaun.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.net.RestClient;
import com.liweqnaun.latte.net.callback.ISuccess;
import com.liweqnaun.latte.ui.recycler.DataConverter;
import com.liweqnaun.latte.ui.recycler.MultipleRecyclerAdapter;

/**
 * Created by liweqnaun on 2018/2/1.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener ,BaseQuickAdapter.RequestLoadMoreListener{
    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLEVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout,RecyclerView recyclerView,
                          DataConverter converter,PagingBean bean) {
        this.REFRESH_LAYOUT = swipeRefreshLayout;
        this.RECYCLEVIEW = recyclerView;
        this.CONVERTER = converter;
        this.BEAN = bean;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }
    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,RecyclerView recyclerView,
                                        DataConverter converter) {
        return new RefreshHandler(swipeRefreshLayout,recyclerView,converter,new PagingBean());
    }
    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        //告诉他我们要开始加载了，下面应该开始网络请求了
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
              REFRESH_LAYOUT.setRefreshing(false);
            }
        },2000);
    }
    public void firstPage(String url) {
        BEAN.setDelayed(1000);
        RestClient.builder().url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        //设置Adapter
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        //上拉刷新
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this,RECYCLEVIEW);
                        RECYCLEVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                }).build().get();

    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
