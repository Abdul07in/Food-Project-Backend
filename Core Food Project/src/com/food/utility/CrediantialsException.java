package com.food.utility;

public class CrediantialsException extends RuntimeException {

    String username = "";

    public CrediantialsException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Please check your credentials , " + username + " Not Found or Incorrect Password .";
    }

    @Override
    public String toString() {
        System.out.println("Entered the crediantials didnt match");
        return super.toString();
    }

}
