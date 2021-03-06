package com.liweqnaun.latte.ec.icon.main.sort.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.ec.R;
import com.liweqnaun.latte.ec.R2;
import com.liweqnaun.latte.ec.icon.main.sort.SortDelegate;
import com.liweqnaun.latte.net.RestClient;
import com.liweqnaun.latte.net.callback.ISuccess;
import com.liweqnaun.latte.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class VerticalListDelegate extends LatteDelegate {
    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView = null;
    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }
private void initRecyclerView() {
    final LinearLayoutManager manager = new LinearLayoutManager(getContext());
    mRecyclerView.setLayoutManager(manager);
    //屏蔽动画效果
    mRecyclerView.setItemAnimator(null);
}
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initRecyclerView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder().url("sort_list.php")
                .loader(getContext()).success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                final List<MultipleItemEntity> data = new VerticalListDataConvert().
                        setJsonData(response).convert();
                final SortDelegate delegate = getParentDelegate();
                final SortRecyclerAdapter adapter = new SortRecyclerAdapter(data,delegate);
                mRecyclerView.setAdapter(adapter);
            }
        }).build().get();
    }
}
