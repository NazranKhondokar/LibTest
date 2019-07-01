/*
 *  Copyright (c), Onnorokom Web Services Ltd (OWSL) and/or its affiliates. All rights reserved.
 *  OWSL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.rokomari.authlib.okhttp;

import okhttp3.Response;


/**
 * Created by user on 6/25/2019.
 */
public interface ResponseListListener {
    /**
     * @param response callback response with contains all response contents
     */
    void onResponse(Response response);
}
