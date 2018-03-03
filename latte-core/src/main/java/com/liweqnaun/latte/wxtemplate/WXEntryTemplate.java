package com.liweqnaun.latte.wxtemplate;

import com.liweqnaun.latte.activities.ProxyActivity;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.wechat.BaseWXEntryActivity;
import com.liweqnaun.latte.wechat.LatteWeChat;

/**
 * Created by liweqnaun on 2018/1/31.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {
    //微信登陆完后会回到这个activity，用以下的处理方式让这个Activity消失
    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
