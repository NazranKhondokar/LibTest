package com.rokomari.authlib.okhttp;

import java.net.HttpURLConnection;

/**
 * Created by user on 6/23/2019.
 */

public class StatusCode {

    private int responseCode;

    public StatusCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String checkStatusCode() {
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return "Success";
        } else if (responseCode == HttpURLConnection.HTTP_CREATED) {
            return "Created";
        } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
            return "Bad Request";
        } else if (responseCode == HttpURLConnection.HTTP_INTERNAL_ERROR) {
            return "Internal Server Error";
        }
        return null;
    }
}
