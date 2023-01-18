package com.food.dao;

import java.sql.*;
import java.util.Scanner;

import com.food.utility.DBConnection;

public class LoginDaoImpl implements LoginDao {

    Scanner sc = new Scanner(System.in);
    Connection con = null;
    String sql = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public boolean checkCustomer(String username, String password) {
        con = DBConnection.makeConnection();
        sql = "select * from Customer_Maj where customerEmail=? && customerPassword=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkAdmin(String username, String password) {

        con = DBConnection.makeConnection();
        sql = "select * from Admin_Maj where adminEmail=? && adminPassword=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changeCustomerPassword(String username, String oldpassword, String newpassword) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean changeAdminPassword(String username, String oldpassword, String newpassword) {
        // TODO Auto-generated method stub
        return false;
    }

}
