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
                .withInterceptor(new DebugInterceptor("haha", R.raw.test))
//                .withWeChatAppId("wxb6152ed38d9f292e")
//                .withWeChatAppSecret("f45d2af4c2c7e24e22d0afd519189c80")
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://192.168.1.105/zerg/public/RestServer/api/")
                .configure();
//        initStetho();没有这一句是不是就没有拦截器了？
        DatabaseManager.getInstance().init(this);

    }
}
//    private void initStetho() {
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
//    }
//}
