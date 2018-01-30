package com.liweqnaun.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.net.RestClient;
import com.liweqnaun.latte.net.callback.IError;
import com.liweqnaun.latte.net.callback.IFailure;
import com.liweqnaun.latte.net.callback.ISuccess;

/**
 * Created by liweqnaun on 2018/1/28.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }
    private void testRestClient() {
        RestClient.builder().url("http://127.0.0.1/index").loader(getContext())
                .success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).build().get();
    }
}
