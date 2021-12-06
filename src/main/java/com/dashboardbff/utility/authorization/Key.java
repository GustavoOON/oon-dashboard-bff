package com.dashboardbff.utility.authorization;

public enum Key {
    AUTH_TOKEN_SECRET("123456");

    private final String description;

    Key(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
