package com.liweqnaun.latte.ec.icon.main.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.liweqnaun.latte.delegates.bottom.BottomItemDelegate;
import com.liweqnaun.latte.ec.R;
import com.liweqnaun.latte.ec.icon.main.sort.content.ContentDelegate;
import com.liweqnaun.latte.ec.icon.main.sort.list.VerticalListDelegate;

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

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        loadRootFragment(R.id.vertical_list_container,listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        replaceLoadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1),false);
    }
}
