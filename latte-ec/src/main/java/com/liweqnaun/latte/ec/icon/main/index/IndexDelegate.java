package com.liweqnaun.latte.ec.icon.main.index;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.delegates.bottom.BottomItemDelegate;
import com.liweqnaun.latte.ec.R;
import com.liweqnaun.latte.ec.R2;
import com.liweqnaun.latte.ec.icon.main.ECBottomDelegate;
import com.liweqnaun.latte.net.RestClient;
import com.liweqnaun.latte.net.callback.ISuccess;
import com.liweqnaun.latte.ui.recycler.BaseDecoration;
import com.liweqnaun.latte.ui.recycler.MultipleFields;
import com.liweqnaun.latte.ui.recycler.MultipleItemEntity;
import com.liweqnaun.latte.ui.refresh.RefreshHandler;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by liweqnaun on 2018/1/31.
 */

public class IndexDelegate extends BottomItemDelegate {
    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconTextView = null;
    @BindView(R2.id.et_search_view)
    AppCompatTextView mAppCompatTextView = null;

    private RefreshHandler mRefreshHandler = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mRefreshHandler = RefreshHandler.create(mRefreshLayout,mRecyclerView,new IndexDataConverter());

    }

    private void initRefreshLayout() {
        //设置颜色
        mRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        //设置表现
        mRefreshLayout.setProgressViewOffset(true,120,300);

    }
    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(manager);
        //各个Item之间加虚线
        mRecyclerView.addItemDecoration(BaseDecoration.create(ContextCompat.getColor(getContext(),
                R.color.app_background),5));
        //得到父级元素
        final ECBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerView.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        mRefreshHandler.firstPage("index.php");
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }


}
