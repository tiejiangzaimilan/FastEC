package com.liweqnaun.latte.ec.icon.main.cart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.liweqnaun.latte.delegates.bottom.BottomItemDelegate;
import com.liweqnaun.latte.ec.R;
import com.liweqnaun.latte.ec.R2;
import com.liweqnaun.latte.net.RestClient;
import com.liweqnaun.latte.net.callback.ISuccess;
import com.liweqnaun.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by liweqnaun on 2018/2/3.
 */

public class ShopCartDelegate extends BottomItemDelegate implements ISuccess{
    @BindView(R2.id.rv_shop_cart)
    RecyclerView mRecyclerView = null;
    private ShopCartAdapter mAdapter = null;
    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder().url("shop_cart.php").loader(getContext())
                .success(this).build().get();
    }

    @Override
    public void onSuccess(String response) {
        final ArrayList<MultipleItemEntity> data = new ShopCartDataConverter().setJsonData(response).convert();
        mAdapter = new ShopCartAdapter(data);
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
