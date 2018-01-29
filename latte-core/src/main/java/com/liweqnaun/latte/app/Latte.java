package com.liweqnaun.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by liweqnaun on 2018/1/27.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    //得到所有配置的值
    public static HashMap<String,Object> getConfigurations() {
        return getConfigurator().getLatteConfigs();
    }
    //加上.name才是key
    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
