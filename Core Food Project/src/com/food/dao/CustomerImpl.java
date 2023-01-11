package com.food.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	Customer f = new Customer();
	List<Customer> flist = null;

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
	public List<Customer> searchAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUnique(String chkItem, String value) {

		try {

			con = DBConnection.makeConnection();
			sql = "SELECT ? FROM `Customer_Maj` where ? = ?";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
