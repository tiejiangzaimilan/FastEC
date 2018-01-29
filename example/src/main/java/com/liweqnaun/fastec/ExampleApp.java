package com.liweqnaun.fastec;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.ec.icon.FontEcModule;

/**
 * Created by liweqnaun on 2018/1/27.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontEcModule())
                .withIcon(new FontAwesomeModule()).withApiHost("http://127.0.0.1")
                .configure();
    }
}
