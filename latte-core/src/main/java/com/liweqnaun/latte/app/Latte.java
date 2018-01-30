package com.liweqnaun.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by liweqnaun on 2018/1/27.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    //得到所有配置的值
    public static HashMap<Object,Object> getConfigurations() {
        return getConfigurator().getLatteConfigs();
    }
    public static Context getApplication() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
    //加不加name取决于初始化的时候加不加name，本来是key是string，现在改为object了
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

}
