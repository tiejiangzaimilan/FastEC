package com.liweqnaun.latte.ec.icon.main;

import android.graphics.Color;

import com.liweqnaun.latte.delegates.bottom.BaseBottomDelegate;
import com.liweqnaun.latte.delegates.bottom.BottomItemDelegate;
import com.liweqnaun.latte.delegates.bottom.BottomTabBean;
import com.liweqnaun.latte.delegates.bottom.ItemBuilder;
import com.liweqnaun.latte.ec.icon.main.index.IndexDelegate;
import com.liweqnaun.latte.ec.icon.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by liweqnaun on 2018/1/31.
 */

public class ECBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
