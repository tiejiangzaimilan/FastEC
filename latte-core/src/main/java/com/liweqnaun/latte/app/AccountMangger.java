package com.liweqnaun.latte.app;

import com.liweqnaun.latte.util.storage.LattePreference;

/**
 * Created by liweqnaun on 2018/1/30.
 */

public class AccountMangger {
    private enum SignTag {
        SIGN_TAG
    }
    //保存登录状态，登陆后调用
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }
    public static void checkAccount(IUserChecker checker) {
        if(isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }
}
