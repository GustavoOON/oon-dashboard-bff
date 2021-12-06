package com.dashboardbff.service;

import com.dashboardbff.gateway.LoginClient;
import com.dashboardbff.request.LoginRequest;
import com.dashboardbff.response.LoginResponse;
import com.dashboardbff.utility.authorization.AuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginClient loginClient;

    public LoginService(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    public LoginResponse login(LoginRequest loginRequest) throws JsonProcessingException {

        loginClient.authenticator(loginRequest);

        return new LoginResponse(AuthToken.getJWTToken(loginRequest));
    }
}
