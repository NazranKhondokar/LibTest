package com.rokomari.authlib.okhttp.callback;

/**
 * Created by user on 2016/6/23.
 */
public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
