package com.rokomari.authlib.okhttp.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by user on 15/12/14.
 */
public abstract class StringCallback extends Callback<String> {
    @Override
    public Response parseNetworkResponse(Response response, int id) throws IOException {
        return response;
    }
}
