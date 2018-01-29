package com.liweqnaun.latte.net;

import android.content.Context;

import com.liweqnaun.latte.net.callback.IError;
import com.liweqnaun.latte.net.callback.IFailure;
import com.liweqnaun.latte.net.callback.IRequest;
import com.liweqnaun.latte.net.callback.ISuccess;
import com.liweqnaun.latte.net.callback.RequestCallbacks;
import com.liweqnaun.latte.ui.LatteLoader;
import com.liweqnaun.latte.ui.LoaderStyle;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by liweqnaun on 2018/1/28.
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams() ;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;

    public RestClient(String url, WeakHashMap<String, Object> params,
                      IRequest request, ISuccess success, IFailure failure,
                      IError error, RequestBody body,Context context,LoaderStyle loaderStyle) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
    }

    public static RestClientBuilder builder () {
        return new RestClientBuilder();
    }
    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if(REQUEST != null) {
            REQUEST.onRequestStart();
        }
        if(LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT,LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL,PARAMS);
                break;
            case POST:
                call = service.post(URL,PARAMS);
                break;
            case PUT:
                call = service.put(URL,PARAMS);
                break;
            case DELETE:
                call = service.delete(URL,PARAMS);
                break;
            default:
                break;
        }
        if(call != null) {
            call.enqueue(getRequestCallback());
        }
    }
    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST,SUCCESS,FAILURE,ERROR,LOADER_STYLE);
    }
    public final void get() {
        request(HttpMethod.GET);
    }
    public final void post() {
        request(HttpMethod.POST);
    }
    public final void put() {
        request(HttpMethod.PUT);
    }
    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
