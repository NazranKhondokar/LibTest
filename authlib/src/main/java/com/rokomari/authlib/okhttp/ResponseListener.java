package com.rokomari.authlib.okhttp;

import okhttp3.Response;

/**
 * Created by user on 6/25/2019.
 */

public interface ResponseListener<T> {
    void onResponse(Response response);
    void onResponseObject(T responseObject);
}
