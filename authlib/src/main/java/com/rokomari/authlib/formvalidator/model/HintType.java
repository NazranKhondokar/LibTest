package com.rokomari.authlib.formvalidator.model;

import com.annimon.stream.Optional;
import com.annimon.stream.Stream;

public enum HintType {
    REGEX(0),
    FIRST_NAME(1),
    MIDDLE_NAME(2),
    LAST_NAME(3),
    EMAIL(4),
    PHONE_NUMBER(5),
    PASSWORD(6),
    CONFIRM_PASSWORD(7),
    NOT_EMPTY(8),
    NOT_DETECTABLE(2000);

    public int value;

    HintType(int value) {
        this.value = value;
    }

    public static HintType fromValue(int value){
        Optional<HintType> opt = Stream.of(values())
                .filter(item -> item.value == value)
                .findFirst();
       return opt.isPresent() ? opt.get() : NOT_DETECTABLE;
    }
}
