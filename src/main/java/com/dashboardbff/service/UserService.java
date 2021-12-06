package com.dashboardbff.service;

import com.dashboardbff.gateway.UserClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public String getAllUser() throws JsonProcessingException {
        return userClient.getAllUsers();
    }
}
