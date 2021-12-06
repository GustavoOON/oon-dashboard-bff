package com.dashboardbff.utility.exception;

public class Timeout extends Throwable{
    public Timeout() {
        super("Login expired");
    }
}
