package com.dashboardbff.utility.exception;

public class UserAlreadyExists extends Throwable{
    public UserAlreadyExists(String identifier) {
        super(identifier);
    }
}
