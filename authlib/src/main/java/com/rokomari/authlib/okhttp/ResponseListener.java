package com.rokomari.authlib.okhttp;

import okhttp3.Response;

/**
 * Created by user on 6/25/2019.
 */

public interface ResponseListener {
    void onResponse(Response response);
}
