package com.liweqnaun.latte.ec.icon.main.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.liweqnaun.latte.delegates.bottom.BottomItemDelegate;
import com.liweqnaun.latte.ec.R;

/**
 * Created by liweqnaun on 2018/1/31.
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
