package com.liweqnaun.latte.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.liweqnaun.latte.R;
import com.liweqnaun.latte.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by liweqnaun on 2018/1/28.
 */

public class LatteLoader {
    private static final int LOADER_SIZE_SCALE = 8;
    //loade的缩放比例
    private static final int LOADER_OFFSET_SCALE = 10;
    //loader的相对偏移量
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    //loader的集合方便管理
    public static void showLoading(Context context,Enum<LoaderStyle> type) {
        showLoading(context,type.name());
    }
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();
    public static void showLoading(Context context,String type){
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        //新建一个自己风格的对话框
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type,context);
        dialog.setContentView(avLoadingIndicatorView);
        //把这种风格的东西加到我新建的对话框上
        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if(dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth/LOADER_SIZE_SCALE;
            lp.height = deviceHeight/LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight/LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }
    private static void showLoading(Context context) {
        showLoading(context,DEFAULT_LOADER);
    }
    public static void stopLoading() {
        for (AppCompatDialog dialog:LOADERS) {
            if(dialog != null) {
                if(dialog.isShowing()){
                    dialog.cancel();
                }
            }
        }
    }
}
