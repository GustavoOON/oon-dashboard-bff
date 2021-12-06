package com.dashboardbff.response;

public class LoginResponse {

    private String token;

    public LoginResponse(String session) {
        this.token = session;
    }

    public String getToken() {
        return token;
    }
}