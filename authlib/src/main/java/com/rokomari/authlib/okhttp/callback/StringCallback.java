package com.rokomari.authlib.okhttp.callback;

import android.util.Log;

import com.google.gson.Gson;
import com.rokomari.authlib.okhttp.ResponseListener;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by user on 15/12/14.
 */
public abstract class StringCallback<T> extends Callback<String> {

    private ResponseListener<T> responseListener;
    private T responseObject;

    public StringCallback(T responseObject, ResponseListener<T> responseListener) {
        this.responseObject = responseObject;
        this.responseListener = responseListener;
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        responseListener.onResponse(response);
        String responseToString = response.body().string();
        responseObject = new Gson().fromJson(responseToString, (Class<T>) responseObject.getClass());
        responseListener.onResponseObject(responseObject);
        return responseToString;
    }
}
