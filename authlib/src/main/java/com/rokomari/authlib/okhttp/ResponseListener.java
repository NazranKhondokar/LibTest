package com.rokomari.authlib.okhttp;

import okhttp3.Response;


/**
 * Created by user on 6/25/2019.
 * @param <T> response object
 */
public interface ResponseListener<T> {
    /**
     * @param response callback response with contains all response contents
     */
    void onResponse(Response response);
    /**
     * @param responseObject callback the response object cast from json object
     */
    void onResponseObject(T responseObject);
}
