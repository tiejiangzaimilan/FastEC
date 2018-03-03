package com.liweqnaun.latte.delegates.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.liweqnaun.latte.R;
import com.liweqnaun.latte.delegates.LatteDelegate;

/**
 * Created by liweqnaun on 2018/1/31.
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener{
    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if(rootView != null) {
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    //用来处理双击两次退出的情况
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if((System.currentTimeMillis()-mExitTime)>mExitTime) {
                Toast.makeText(getContext(),"双击退出"+getString(R.string.app_name),Toast.LENGTH_LONG);
                mExitTime = System.currentTimeMillis();
            }else {
                _mActivity.finish();
                if(mExitTime!=0) {
                    mExitTime = 0;
                }
            }
            return true;
        }
        return false;
    }
}
