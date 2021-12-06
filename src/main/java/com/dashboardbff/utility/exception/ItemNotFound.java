package com.dashboardbff.utility.exception;

public class ItemNotFound extends Throwable {
    public ItemNotFound(String item) {
        super(item.concat(" not found"));
    }
}
