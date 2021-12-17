package com.dashboardbff.response;

import java.util.List;

public class UserResponses {
    private List<UserResponse> userResponses;

    public UserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }
}
