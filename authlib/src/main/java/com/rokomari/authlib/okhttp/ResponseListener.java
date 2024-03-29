/*
 *  Copyright (c), Onnorokom Web Services Ltd (OWSL) and/or its affiliates. All rights reserved.
 *  OWSL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.rokomari.authlib.okhttp;

import okhttp3.Response;


/**
 *
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
