package com.example.travel.security;

public enum ApplicationUserPermission {
    TRAVEL_READ("travel:read"), TRAVEL_WRITE("travel:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}
