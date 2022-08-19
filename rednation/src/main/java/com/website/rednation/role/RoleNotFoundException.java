package com.website.rednation.role;

public class RoleNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RoleNotFoundException(String message) {
        super(message);
    }
}