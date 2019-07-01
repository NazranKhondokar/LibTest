/*
 *  Copyright (c), Onnorokom Web Services Ltd (OWSL) and/or its affiliates. All rights reserved.
 *  OWSL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.rokomari.authlib.okhttp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by user on 7/1/2019.
 */

public class ListOfJson<T> implements ParameterizedType {

    private Class<?> wrapped;

    public ListOfJson(Class<T> wrapper) {
        this.wrapped = wrapper;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{wrapped};
    }

    @Override
    public Type getRawType() {
        return List.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
