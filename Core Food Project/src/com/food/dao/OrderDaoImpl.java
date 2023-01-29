package com.food.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Order;
import com.food.utility.DBConnection;

public class OrderDaoImpl implements OrderDao {

	Connection con = null;
	String sql = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	List<Order> oList;
	Order order;

	@Override
	public Order placeOrder(Order order) {

		con = DBConnection.makeConnection();
		sql = "INSERT INTO `Order_Maj`( `billingAmount`, `orderDate`, `customerEmail`, `dropLocation`, `deliveryDate`, `orderStatus`) VALUES (?,?,?,?,?,?)";

		try {
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setDouble(1, order.getBillingAmount());
			pst.setDate(2, Date.valueOf(order.getOrderDate()));
			pst.setString(3, order.getCustomerEmail());
			pst.setString(4, order.getDropLocation());
			pst.setTimestamp(5, Timestamp.valueOf(order.getDeliveryDate()));
			pst.setString(6, order.getOrderStatus());

			if (pst.executeUpdate() > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int orderId = rs.getInt(1);
					order = searchOrderById(orderId);
					return order;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String checkStatus(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeStatus(Integer orderId, String orderStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> showOrderHistory(String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showAllOrders() {

		oList = new ArrayList<>();
		con = DBConnection.makeConnection();
		sql = "SELECT * FROM `Order_Maj`";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setBillingAmount(rs.getDouble(2));
				order.setOrderDate(rs.getDate(3).toLocalDate());
				order.setCustomerEmail(rs.getString(4));
				order.setDropLocation(rs.getString(5));
				order.setDeliveryDate(rs.getTimestamp(6).toLocalDateTime());
				order.setOrderStatus(rs.getString(7));
				oList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oList;
	}

	public Order searchOrderById(Integer orderId) {

		con = DBConnection.makeConnection();
		sql = "SELECT * FROM `Order_Maj` WHERE `orderId` = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, orderId);
			rs = pst.executeQuery();

			if (rs.next()) {
				order = new Order();

				order.setOrderId(rs.getInt(1));
				order.setBillingAmount(rs.getDouble(2));
				order.setOrderDate(rs.getDate(3).toLocalDate());
				order.setCustomerEmail(rs.getString(4));
				order.setDropLocation(rs.getString(5));
				order.setDeliveryDate(rs.getTimestamp(6).toLocalDateTime());
				order.setOrderStatus(rs.getString(7));

				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
