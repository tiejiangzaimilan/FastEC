package com.liweqnaun.latte.delegates;

/**
 * Created by liweqnaun on 2018/1/28.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
