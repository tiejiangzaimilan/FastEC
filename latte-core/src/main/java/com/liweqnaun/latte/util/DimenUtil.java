package com.liweqnaun.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.liweqnaun.latte.app.Latte;

/**
 * Created by liweqnaun on 2018/1/28.
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
