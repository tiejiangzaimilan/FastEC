package com.liweqnaun.latte.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class BaseDecoration extends DividerItemDecoration {
    private BaseDecoration (@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color,size));
    }
    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color,size);

    }
}
