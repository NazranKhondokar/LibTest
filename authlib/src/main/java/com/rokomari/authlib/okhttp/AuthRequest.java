package com.rokomari.authlib.okhttp;

import com.google.gson.Gson;
import com.rokomari.authlib.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by user on 6/23/2019.
 */

public class AuthRequest<T> {

    private String mBaseUrl;
    private String endPoint;
    private String mediaType;
    private Map<String, String> headers;
    private Map<String, String> params;
    private T obj;
    private StringCallback stringCallback;

    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, String mediaType, T obj, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.mediaType = mediaType;
        this.obj = obj;
        this.stringCallback = stringCallback;
    }

    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
    }

    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, Map<String, String> params) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.params = params;
    }

    public void callPOST() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .postString()
                .url(url)
                .headers(headers)
                .content(new Gson().toJson(obj))
                .mediaType(MediaType.parse(mediaType))
                .build()
                .execute(stringCallback);
    }

    public void callGET() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .build()
                .execute(stringCallback);
    }

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
