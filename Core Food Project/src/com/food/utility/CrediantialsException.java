package com.food.utility;

public class CrediantialsException extends RuntimeException {

    public CrediantialsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Please check your credentials";
    }

    @Override
    public String toString() {
        System.out.println("Entered the crediantials didnt match");
        return super.toString();
    }

}
