package com.rokomari.authlib.okhttp.callback;

import com.rokomari.authlib.okhttp.ResponseListener;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by user on 15/12/14.
 */
public abstract class StringCallback extends Callback<String> {

    private ResponseListener responseListener;

    StringCallback(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        responseListener.onResponse(response);
        return response.body().string();
    }
}
