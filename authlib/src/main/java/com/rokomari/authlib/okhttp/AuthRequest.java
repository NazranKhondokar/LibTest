package com.rokomari.authlib.okhttp;

import com.google.gson.Gson;
import com.rokomari.authlib.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by user on 6/25/2019.
 * @param <T> request object
 */

public class AuthRequest<T> {

    private String mBaseUrl;
    private String endPoint;
    private String mediaType;
    private Map<String, String> headers;
    private Map<String, String> params;
    private T object;
    private StringCallback stringCallback;

    /**
     *
     * @param mBaseUrl base url of your API call
     * @param endPoint rest of part without base url of restAPI
     * @param headers add request header or headers
     * @param mediaType content type like "application/json; charset=utf-8"
     * @param object request object
     * @param stringCallback if request return json object it will call back the json response object
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, String mediaType, T object, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.mediaType = mediaType;
        this.object = object;
        this.stringCallback = stringCallback;
    }

    /**
     * when no request object available
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.stringCallback = stringCallback;
    }

    /**
     *
     * @param mBaseUrl base url of your API call
     * @param endPoint rest of part without base url of restAPI
     * @param headers add request header or headers
     * @param params add request param or params
     * @param stringCallback if request return json object it will call back the json response object
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, Map<String, String> params, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.params = params;
        this.stringCallback = stringCallback;
    }

    /**
     * for POST request
     */
    public void callPOST() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .postString()
                .url(url)
                .headers(headers)
                .content(new Gson().toJson(object))
                .mediaType(MediaType.parse(mediaType))
                .build()
                .execute(stringCallback);
    }

    /**
     * for GET request
     */
    public void callGET() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .build()
                .execute(stringCallback);
    }

    /**
     * for POST request with params
     */
    public void callPOSTWithParams() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .post()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(stringCallback);
    }

    /**
     * for GET request with params
     */
    public void callGETWithParams() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(stringCallback);
    }
}
