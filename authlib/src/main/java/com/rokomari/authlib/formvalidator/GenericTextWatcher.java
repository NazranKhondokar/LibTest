package com.rokomari.authlib.formvalidator;

import android.text.Editable;
import android.text.TextWatcher;

import com.rokomari.authlib.formvalidator.widget.FormEditText;

/**
 * Created by user on 6/18/2019.
 */

public class GenericTextWatcher implements TextWatcher {

    private FormEditText mFormEditText;
    public GenericTextWatcher(FormEditText mFormEditText) {
        this.mFormEditText = mFormEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    public void afterTextChanged(Editable editable) {
        mFormEditText.validate();
    }
}