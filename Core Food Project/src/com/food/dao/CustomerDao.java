package com.food.dao;

import java.util.List;

import com.food.pojo.Customer;

public interface CustomerDao {

	public boolean addCustomer(Customer c);

	public boolean updateCustomer(Customer c);

	public boolean deleteCustomer(Customer c);

	public Customer searchCustomerById(Integer custoomerId);

	public List<Customer> searchCustomerByName(String customerName);

	public Customer searchCustomerByEmail(String customerEmail);

	public List<Customer> searchAllCustomer();

	public boolean checkUnique(String chkItem, String value);

}
