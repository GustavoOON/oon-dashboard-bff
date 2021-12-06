package com.dashboardbff.utility.exception;

public class ItemAlreadyExists extends Throwable {
    public ItemAlreadyExists(String item) {
        super(item.concat(" already exists"));
    }
}
