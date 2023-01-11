package com.food.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.food.pojo.Customer;
import com.food.utility.DBConnection;

public class CustomerImpl implements CustomerDao {

	Scanner sc = new Scanner(System.in);
	Connection con = null;
	String sql = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Customer customer = new Customer();
	List<Customer> clist = null;

	@Override
	public boolean addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer searchCustomerById(Integer custoomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByEmail(String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> showAllCustomer() {
		clist = new ArrayList<>();
		con = DBConnection.makeConnection();
		sql = "SELECT * FROM `Customer_Maj`";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			while (rs != null && rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6));
				clist.add(customer);
			}
			return clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean checkEmail(String customerEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPassword(String customerPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPhone(Long customerPhone) {
		// TODO Auto-generated method stub
		return false;
	}

}
