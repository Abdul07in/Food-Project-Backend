package com.food.test;

import java.sql.*;

import com.food.utility.DBConnection;

public class App {
    public static void main(String[] args) {

        try (Connection con = DBConnection.makConnection()) {
            if (con != null)
                System.out.println("Connenction Successfull");
            else
                System.out.println("Error");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
