package com.food.dao;

import java.util.List;

import com.food.pojo.Cart;

public class CartImpl implements CartDao {

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
        // TODO Auto-generated method stub
        return null;
    }

}
