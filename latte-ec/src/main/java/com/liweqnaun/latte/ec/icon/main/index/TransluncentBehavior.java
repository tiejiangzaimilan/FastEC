package com.liweqnaun.latte.ec.icon.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import com.liweqnaun.latte.R;
import com.liweqnaun.latte.ec.R2;
import com.liweqnaun.latte.ui.recycler.RgbValue;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class TransluncentBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    //顶部距离
    private int mDistanceY = 0;
    //颜色变化的速度
    private static final int SHOW_SPEED = 3;
    //定义我们的颜色
    private final RgbValue RGB_VALUE = null;
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        //它所依赖的view
        return dependency.getId() == R2.id.rv_index;
    }

    public TransluncentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        //增加滑动距离
        mDistanceY+=dy;
        //toolbar的高度
        final int targetHeight = child.getBottom();

        //当滑动时并且距离小于toolbar高度的时候，调整渐变色
        if(mDistanceY>0&&mDistanceY<=targetHeight){
            final float scale = (float) mDistanceY/targetHeight;
            final float alpha = scale*255;
            child.setBackgroundColor(Color.argb((int) alpha,255,124,2));
        }else if (mDistanceY>targetHeight) {
            child.setBackgroundColor(Color.rgb(255,124,2));
        }
    }
}
