package com.food.utility;

import java.sql.*;

public class DBConnection {

    public static Connection makConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://dbpanel.squadinfotech.in:3306/testuser_abdul?user=testuser&password=testuser");
            if (connection != null) {
                return connection;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
