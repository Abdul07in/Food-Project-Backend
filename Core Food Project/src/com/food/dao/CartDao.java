package com.food.dao;

import java.util.List;

import com.food.pojo.Cart;

public interface CartDao {

    public boolean addCart(Cart cart);

    public boolean deleteCart(Integer cartId);

    public boolean updateQuantity(Integer cartId, Integer foodQuantity);

    public boolean clearMyCart(String customerEmail);

    public List<Cart> showMyCart(String customerEmail);

    public List<Cart> showAllCart();

    public double getSubtotal(Double foodPrice, Integer foodQuantity);

}
