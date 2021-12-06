package com.dashboardbff.utility.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class ServerError extends Throwable {

    private HttpStatus httpStatus;
    private String message;

    public ServerError(Exception exception) {
        JSONObject jsonObject = new JSONObject()
                .put("error: ", exception.getCause())
                .put("message", exception.getMessage());

        this.message = jsonObject.toString();
        this.httpStatus = HttpStatus.BAD_GATEWAY;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
