package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.pojo.Cart;
import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class CartImpl implements CartDao {

    Scanner sc = new Scanner(System.in);
    Connection con = null;
    String sql = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public boolean addCart(Cart cart) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteCart(Integer cartId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateQuantity(Integer cartId, Integer foodQuantity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean clearMyCart(String customerEmail) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Cart> showMyCart(String customerEmail) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Cart> showAllCart() {

        con = DBConnection.makeConnection();
        sql = "SELECT * FROM `Cart_Maj`";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setCustomerEmail(rs.getString("customerEmail"));

                int foodId = rs.getInt("foodId");
                Food f = new FoodDaoImpl().searchFoodById(foodId);
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
