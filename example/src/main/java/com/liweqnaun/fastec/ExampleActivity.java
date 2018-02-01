package com.liweqnaun.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.liweqnaun.latte.activities.ProxyActivity;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.ec.icon.launcher.LauncherDelegate;
import com.liweqnaun.latte.ec.icon.main.ECBottomDelegate;
import com.liweqnaun.latte.ec.icon.sign.ISignListener;
import com.liweqnaun.latte.ec.icon.sign.SignInDelegate;
import com.liweqnaun.latte.ec.icon.sign.SignUpDelegate;
import com.liweqnaun.latte.ui.launcher.ILauncherListener;
import com.liweqnaun.latte.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener,ILauncherListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);

    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this,"启动结束，用户登录",Toast.LENGTH_LONG).show();
                startWithPop(new ECBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，用户没登陆",Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
