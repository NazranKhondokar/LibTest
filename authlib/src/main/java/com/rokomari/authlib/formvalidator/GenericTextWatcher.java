package com.rokomari.authlib.formvalidator;

import android.text.Editable;
import android.text.TextWatcher;

import com.rokomari.authlib.formvalidator.widget.FormEditText;

/**
 * Created by user on 6/18/2019.
 * a common text watcher for different custom editText
 */

public class GenericTextWatcher implements TextWatcher {

    private FormEditText mFormEditText;

    /**
     * @param mFormEditText receive a custom editText to validate character by character
     */
    public GenericTextWatcher(FormEditText mFormEditText) {
        this.mFormEditText = mFormEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    public void afterTextChanged(Editable editable) {
        mFormEditText.validate();
    }
}