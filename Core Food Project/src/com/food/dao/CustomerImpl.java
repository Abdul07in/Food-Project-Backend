package com.food.dao;

import com.food.pojo.Customer;
import com.food.utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerImpl implements CustomerDao {

  Scanner sc = new Scanner(System.in);
  Connection con = null;
  String sql = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  Customer customer = null;
  List<Customer> clist = null;

  @Override
  public boolean addCustomer(Customer c) {
    try {
      con = DBConnection.makeConnection();
      sql =
        "INSERT INTO `Customer_Maj`(`customerName`, `customerAddress`, `customerEmail`, `customerPhone`, `customerPassword`) VALUES (?,?,?,?,?)";
      pst = con.prepareStatement(sql);
      pst.setString(1, c.getCustomerName());
      pst.setString(2, c.getCustomerAddress());
      pst.setString(3, c.getCustomerEmail());
      pst.setLong(4, c.getCustomerPhone());
      pst.setString(5, c.getCustomerPassword());

      int i = pst.executeUpdate();

      if (i > 0) return true;
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
    return false;
  }

  @Override
  public boolean updateCustomer(Customer c) {
    con = DBConnection.makeConnection();
    sql =
      "UPDATE `Customer_Maj` SET  `customerName`=?,`customerAddress`=?,`customerEmail`=?,`customerPhone`=?,`customerPassword`=? WHERE customerId = ?";

    try {
      pst = con.prepareStatement(sql);

      pst.setString(1, c.getCustomerName());
      pst.setString(2, c.getCustomerAddress());
      pst.setString(3, c.getCustomerEmail());
      pst.setLong(4, c.getCustomerPhone());
      pst.setString(5, c.getCustomerPassword());
      pst.setInt(6, c.getCustomerId());

      if (pst.executeUpdate() > 0) return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  @Override
  public boolean deleteCustomer(Customer c) {
    con = DBConnection.makeConnection();
    sql = "DELETE * FROM `Customer_Maj` WHERE customerId = ? ";
    try {
      pst = con.prepareStatement(sql);
      pst.setInt(1, c.getCustomerId());
      if (pst.executeUpdate() > 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Customer searchCustomerById(Integer customerId) {
    try {
      con = DBConnection.makeConnection();
      sql = "SELECT * FROM `Customer_Maj` where customerId = ?";
      pst = con.prepareStatement(sql);
      pst.setInt(1, customerId);
      rs = pst.executeQuery();
      customer = new Customer();
      while (rs != null & rs.next()) {
        customer.setCustomerId(customerId);
        customer.setCustomerName(rs.getString("customerName"));
        customer.setCustomerEmail(rs.getString("customerEmail"));
        customer.setCustomerPassword(rs.getString("customerPassword"));
        customer.setCustomerAddress(rs.getString("customerAddress"));
        customer.setCustomerPhone(rs.getLong("customerPhone"));
      }
      return customer;
    } catch (Exception e) {
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

  @Override
  public List<Customer> searchCustomerByName(String customerName) {
    clist = new ArrayList<>();
    con = DBConnection.makeConnection();
    sql =
      "SELECT * FROM Customer_Maj WHERE customerName LIKE '%" +
      customerName +
      "%'";
    try {
      pst = con.prepareStatement(sql);
      rs = pst.executeQuery();
      while (rs != null && rs.next()) {
        customer =
          new Customer(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getLong(5),
            rs.getString(6)
          );
        clist.add(customer);
      }
      return clist;
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

  @Override
  public Customer searchCustomerByEmail(String customerEmail) {
    con = DBConnection.makeConnection();
    sql =
      "SELECT * FROM Customer_Maj WHERE customerEmail LIKE '%" +
      customerEmail +
      "%'";
    try {
      pst = con.prepareStatement(sql);
      rs = pst.executeQuery();
      while (rs != null && rs.next()) {
        customer =
          new Customer(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getLong(5),
            rs.getString(6)
          );
      }
      return customer;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Customer> showAllCustomer() {
    clist = new ArrayList<>();
    con = DBConnection.makeConnection();
    sql = "SELECT * FROM `Customer_Maj`";
    try {
      pst = con.prepareStatement(sql);
      rs = pst.executeQuery();
      while (rs != null && rs.next()) {
        customer =
          new Customer(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getLong(5),
            rs.getString(6)
          );
        clist.add(customer);
      }
      return clist;
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

  @Override
  public boolean checkEmail(String customerEmail) {
    con = DBConnection.makeConnection();
    sql = "SELECT * FROM `Customer_Maj` where customerEmail = ?";
    try {
      pst = con.prepareStatement(sql);
      pst.setString(1, customerEmail);
      rs = pst.executeQuery();
      while (rs.next()) return true;
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

    return false;
  }

  @Override
  public boolean checkPassword(String customerPassword) {
    con = DBConnection.makeConnection();
    sql = "SELECT * FROM `Customer_Maj` where customerPassword = ?";
    try {
      pst = con.prepareStatement(sql);
      pst.setString(1, customerPassword);
      rs = pst.executeQuery();
      while (rs.next()) return true;
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
    return false;
  }

  @Override
  public boolean checkPhone(Long customerPhone) {
    con = DBConnection.makeConnection();
    sql = "SELECT * FROM `Customer_Maj` where customerPhone = ?";
    try {
      pst = con.prepareStatement(sql);
      pst.setLong(1, customerPhone);
      rs = pst.executeQuery();
      while (rs.next()) return true;
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
    return false;
  }
}
