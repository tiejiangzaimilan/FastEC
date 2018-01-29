package com.liweqnaun.fastec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.liweqnaun.latte.activities.ProxyActivity;
import com.liweqnaun.latte.app.Latte;
import com.liweqnaun.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
