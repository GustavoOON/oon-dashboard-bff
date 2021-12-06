package com.dashboardbff.utility.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class Unauthorized extends Throwable {

    private final String message;
    private final HttpStatus httpStatus;

    public Unauthorized(HttpStatus httpStatus) {

        JSONObject jsonObject = new JSONObject()
                .put("error: ", httpStatus)
                .put("message", "Login ".concat(httpStatus.getReasonPhrase()));

        this.message = jsonObject.toString();
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
