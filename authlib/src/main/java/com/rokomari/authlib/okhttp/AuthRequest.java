/*
 *  Copyright (c), Onnorokom Web Services Ltd (OWSL) and/or its affiliates. All rights reserved.
 *  OWSL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.rokomari.authlib.okhttp;

import com.google.gson.Gson;
import com.rokomari.authlib.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.MediaType;

/**
 *
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
    private ListCallback listCallback;

    /**
     * @param mBaseUrl       base url of your API call
     * @param endPoint       rest of part without base url of restAPI
     * @param headers        add request header or headers
     * @param mediaType      content type like "application/json; charset=utf-8"
     * @param object         request object
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
     * when no request object and parameters available
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, StringCallback stringCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.stringCallback = stringCallback;
    }

    /**
     * @param mBaseUrl       base url of your API call
     * @param endPoint       rest of part without base url of restAPI
     * @param headers        add request header or headers
     * @param params         add request param or params
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
     * @param mBaseUrl     base url of your API call
     * @param endPoint     rest of part without base url of restAPI
     * @param headers      add request header or headers
     * @param mediaType    content type like "application/json; charset=utf-8"
     * @param object       request object
     * @param listCallback if request return json array of objects it will call back the json array object lists
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, String mediaType, T object, ListCallback listCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.mediaType = mediaType;
        this.object = object;
        this.listCallback = listCallback;
    }

    /**
     * @param mBaseUrl     base url of your API call
     * @param endPoint     rest of part without base url of restAPI
     * @param headers      add request header or headers
     * @param listCallback if request return json array of objects it will call back the json array object lists
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, ListCallback listCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.listCallback = listCallback;
    }

    /**
     * @param mBaseUrl     base url of your API call
     * @param endPoint     rest of part without base url of restAPI
     * @param headers      add request header or headers
     * @param params       add request param or params
     * @param listCallback if request return json array of objects it will call back the json array object lists
     */
    public AuthRequest(String mBaseUrl, String endPoint, Map<String, String> headers, Map<String, String> params, ListCallback listCallback) {
        this.mBaseUrl = mBaseUrl;
        this.endPoint = endPoint;
        this.headers = headers;
        this.params = params;
        this.listCallback = listCallback;
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
     * if request return json array of objects it will call back the json array object lists
     */
    public void callPOSTJsonArrayObjects() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .postString()
                .url(url)
                .headers(headers)
                .content(new Gson().toJson(object))
                .mediaType(MediaType.parse(mediaType))
                .build()
                .execute(listCallback);
    }

    /**
     * for GET request content type added to header
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
     * if request return json array of objects it will call back the json array object lists, for GET request content type added to header
     */
    public void callGETJsonArrayObjects() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .build()
                .execute(listCallback);
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
     * if request return json array of objects it will call back the json array object lists
     */
    public void callPOSJsonArrayObjectsTWithParams() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .post()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(listCallback);
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

    /**
     * if request return json array of objects it will call back the json array object lists, for GET request content type added to header
     */
    public void callGETJsonArrayObjectsWithParams() {
        String url = mBaseUrl + endPoint;
        OkHttpUtils
                .get()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(listCallback);
    }

}
