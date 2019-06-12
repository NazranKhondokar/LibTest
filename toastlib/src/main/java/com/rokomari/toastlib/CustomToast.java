package com.rokomari.toastlib;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 6/12/2019.
 */

public class CustomToast {

    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
