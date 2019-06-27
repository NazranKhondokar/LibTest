package com.rokomari.authlib.okhttp;

import java.net.HttpURLConnection;

/**
 * Created by user on 6/23/2019.
 */

public class StatusCode {

    private int responseCode;

    /**
     * @param responseCode receive response.code() like 200, 500, 400
     */
    public StatusCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return message for specific code
     */
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
