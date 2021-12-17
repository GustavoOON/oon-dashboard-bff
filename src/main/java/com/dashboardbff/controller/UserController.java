package com.dashboardbff.controller;

import com.dashboardbff.response.UserResponse;
import com.dashboardbff.response.UserResponses;
import com.dashboardbff.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<UserResponses> getAllUser() throws JsonProcessingException {
        List<UserResponse> allUser = userService.getAllUser();

        return new ResponseEntity(new UserResponses(allUser), HttpStatus.OK);
    }
}
