package com.food.dao;

import java.util.List;

import com.food.pojo.Order;

public interface OrderDao {

	public Order placeOrder(Order order);

	public String checkStatus(Integer orderId);

	public boolean cancelOrder(Integer orderId);

	public boolean changeStatus(Integer orderId , String orderStatus);

	public List<Order> showOrderHistory(String customerEmail);

	public List<Order> showAllOrders();
}
