package com.rokomari.authlib.okhttp.builder;

import com.rokomari.authlib.okhttp.OkHttpUtils;
import com.rokomari.authlib.okhttp.request.OtherRequest;
import com.rokomari.authlib.okhttp.request.RequestCall;

/**
 * Created by user on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
