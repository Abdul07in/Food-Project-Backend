package com.food.utility;

import java.sql.*;

public class DBConnection {

	public static Connection makeConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://148.72.215.41/testuser_MajeedProject41?user=testuser&password=testuser");

			if (con != null)
				return con;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
