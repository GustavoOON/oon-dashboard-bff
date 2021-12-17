package com.dashboardbff.service;

import com.dashboardbff.gateway.UserClient;
import com.dashboardbff.response.UserResponse;
import com.dashboardbff.response.UserResponses;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public List<UserResponse> getAllUser() throws JsonProcessingException {
        return userClient.getAllUsers();
    }
}
