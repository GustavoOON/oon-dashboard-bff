package com.dashboardbff.controller;

import com.dashboardbff.request.LoginRequest;
import com.dashboardbff.response.LoginResponse;
import com.dashboardbff.service.LoginService;
import com.dashboardbff.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<String>
    getAllUser() throws JsonProcessingException {

        String allUser = userService.getAllUser();

        return new ResponseEntity(allUser, HttpStatus.OK);
    }
}
