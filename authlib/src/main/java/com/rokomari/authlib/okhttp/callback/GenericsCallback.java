package com.rokomari.authlib.okhttp.callback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Response;

/**
 * Created by user on 2016/6/23.
 */

public abstract class GenericsCallback<T> extends Callback<T> {
    IGenericsSerializator mGenericsSerializator;

    public GenericsCallback(IGenericsSerializator serializator) {
        mGenericsSerializator = serializator;
    }

    @Override
    public Response parseNetworkResponse(Response response, int id) throws IOException {
        /*String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = mGenericsSerializator.transform(string, entityClass);*/
        return response;
    }

}
