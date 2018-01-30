package com.liweqnaun.fastec;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.ec.icon.FontEcModule;
import com.liweqnaun.latte.ec.icon.database.DatabaseManager;
import com.liweqnaun.latte.net.interceptors.DebugInterceptor;

/**
 * Created by liweqnaun on 2018/1/27.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withIcon(new FontAwesomeModule()).withApiHost("http://127.0.0.1")
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);

    }
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
