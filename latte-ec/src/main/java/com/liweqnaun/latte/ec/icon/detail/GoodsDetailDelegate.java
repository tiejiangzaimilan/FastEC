package com.liweqnaun.latte.ec.icon.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.ec.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class GoodsDetailDelegate extends LatteDelegate{
    public static GoodsDetailDelegate create() {
        return new GoodsDetailDelegate();
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
