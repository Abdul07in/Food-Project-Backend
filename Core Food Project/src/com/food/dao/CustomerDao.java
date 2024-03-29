package com.food.dao;

import com.food.pojo.Customer;

import java.util.List;

public interface CustomerDao {

    public boolean addCustomer(Customer c);

    public boolean updateCustomer(Customer c);

    public boolean deleteCustomer(Customer c);

    public Customer searchCustomerById(Integer customerId);

    public List<Customer> searchCustomerByName(String customerName);

    public Customer searchCustomerByEmail(String customerEmail);

    public List<Customer> showAllCustomer();

    public boolean checkEmail(String customerEmail);

    public boolean checkPassword(String customerPassword);

    public boolean checkPhone(Long customerPhone);


}
