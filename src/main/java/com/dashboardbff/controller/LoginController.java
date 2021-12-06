package com.dashboardbff.controller;

import com.dashboardbff.request.LoginRequest;
import com.dashboardbff.response.LoginResponse;
import com.dashboardbff.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse>
    login(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {

        LoginResponse loginResponse = loginService.login(loginRequest);

        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }
}
