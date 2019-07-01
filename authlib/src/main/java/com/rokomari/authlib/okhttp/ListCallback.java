/*
 *  Copyright (c), Onnorokom Web Services Ltd (OWSL) and/or its affiliates. All rights reserved.
 *  OWSL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.rokomari.authlib.okhttp;

import com.google.gson.Gson;
import com.rokomari.authlib.okhttp.callback.Callback;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;

/**
 * Created by user on 6/30/2019.
 */

public abstract class ListCallback<T> extends Callback<List<T>> {

    private ResponseListListener responseListener;
    private T responseObject;

    public ListCallback(T responseObject, ResponseListListener responseListener) {
        this.responseObject = responseObject;
        this.responseListener = responseListener;
    }

    @Override
    public List<T> parseNetworkResponse(Response response, int id) throws IOException {
        responseListener.onResponse(response);
        String responseToString = response.body().string();
        return toList(responseToString, (Class<T>) responseObject.getClass());
    }

    public static <T> List<T> toList(String json, Class<T> typeClass) {
        return new Gson().fromJson(json, new ListOfJson<T>(typeClass));
    }
}
