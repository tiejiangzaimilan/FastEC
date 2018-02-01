package com.liweqnaun.latte.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * Created by liweqnaun on 2018/1/27.
 * 全局配置的而一个类
 */

public class Configurator {
    private static final HashMap<Object,Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();
    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY,false);
    }
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }
    public HashMap<Object,Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY,true);
    }
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST,host);
        return this;
    }
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }
    private void initIcons() {
        if(ICONS.size()>0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i=0;i<ICONS.size();i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR,INTERCEPTORS);
        return this;
    }
    public final Configurator withInterceptor( ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR,INTERCEPTORS);
        return this;
    }
    public final Configurator withWeChatAppId(String appId) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_ID,appId);
        return this;
    }
    public final Configurator withWeChatAppSecret(String appSecret) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET,appSecret);
        return this;
    }
    public final Configurator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigType.ACTIVITY,activity);
        return this;
    }
    private void checkConfigutation() {
        final boolean isReady = (boolean)LATTE_CONFIGS.get(ConfigType.CONFIG_READY);
        if(!isReady) {
            throw new RuntimeException("Configuration is not ready ,call configure");
        }
    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfigutation();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTE_CONFIGS.get(key);
    }
}
