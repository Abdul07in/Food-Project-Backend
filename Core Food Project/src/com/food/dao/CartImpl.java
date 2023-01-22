package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Cart cart = null;
    List<Cart> cartList = null;

    @Override
    public boolean addCart(Cart cart) {
        con = DBConnection.makeConnection();
        sql = "insert into Cart_Maj(foodId,foodQuantity,price,subtotal,customerEmail) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cart.getFoodId());
            pst.setInt(2, cart.getFoodQuantity());
            pst.setDouble(3, cart.getPrice());
            pst.setDouble(4, cart.getSubtotal());
            pst.setString(5, cart.getCustomerEmail());
            if (pst.executeUpdate() > 0)
                return true;

        } catch (SQLException e) {

        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    @Override
    public boolean deleteCart(Integer cartId) {
        con = DBConnection.makeConnection();
        sql = "DELETE FROM `Cart_Maj` WHERE `cartId` = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cartId);
            if (pst.executeUpdate() > 0)
                return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
        cartList = new ArrayList<Cart>();
        con = DBConnection.makeConnection();
        sql = "select * from Cart_Maj where customerEmail =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, customerEmail);
            rs = pst.executeQuery();
            while (rs.next()) {
                int foodId = rs.getInt("foodId");
                Food f = new FoodDaoImpl().searchFoodById(foodId);
                cart = new Cart(
                        f,
                        rs.getInt("cartId"),
                        foodId,
                        rs.getInt("foodQuantity"),
                        rs.getDouble("price"), rs.getDouble("subtotal"), rs.getString("customerEmail"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }

    @Override
    public List<Cart> showAllCart() {
        cartList = new ArrayList<>();
        con = DBConnection.makeConnection();
        sql = "SELECT * FROM `Cart_Maj` ORDER BY `customerEmail` DESC";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int foodId = rs.getInt("foodId");
                Food f = new FoodDaoImpl().searchFoodById(foodId);
                cart = new Cart(
                        f,
                        rs.getInt("cartId"),
                        foodId,
                        rs.getInt("foodQuantity"),
                        rs.getDouble("price"), rs.getDouble("subtotal"), rs.getString("customerEmail"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }

    @Override
    public double getSubtotal(Double foodPrice, Integer foodQuantity) {
        return foodPrice * foodQuantity;
    }

    public Map<Double, Double> getSubtotalMap(Integer foodId, Integer foodQuantity) {
        con = DBConnection.makeConnection();
        sql = "SELECT foodPrice FROM `Food_Maj` WHERE foodId = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            Map<Double, Double> map = new HashMap<>();
            if (rs.next()) {
                double price = rs.getDouble("foodPrice");
                map.put(price, price * foodQuantity);
                return map;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

}
