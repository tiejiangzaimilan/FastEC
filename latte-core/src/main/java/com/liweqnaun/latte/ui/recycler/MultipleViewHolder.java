package com.liweqnaun.latte.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by liweqnaun on 2018/2/1.
 */

public class MultipleViewHolder extends BaseViewHolder {
    private MultipleViewHolder(View view) {
        super(view);
    }
    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }
}
