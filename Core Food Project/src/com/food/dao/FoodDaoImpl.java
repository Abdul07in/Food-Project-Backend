package com.food.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class FoodDaoImpl implements FoodDao {

	Scanner sc = new Scanner(System.in);
	Connection con = null;
	String sql = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Food f = new Food();
	List<Food> flist = null;

	Integer foodId;
	String foodName;
	String foodType;
	Double foodPrice;
	Integer foodQuantity;
	String foodCategory;
	String foodDescription;
	Integer foodRating;

	@Override
	public boolean addFood(Food f) {

		try {
			con = DBConnection.makeConnection();
			sql = "INSERT INTO `Food_Maj`(`foodName`, `foodType`, `foodPrice`, `foodQuantity`, `foodCategory`, `foodDescription`, `foodRating`)"
					+ " VALUES (?,?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);

			pst.setString(1, f.getFoodName());
			pst.setString(2, f.getFoodType());
			pst.setDouble(3, f.getFoodPrice());
			pst.setInt(4, f.getFoodQuantity());
			pst.setString(5, f.getFoodCategory());
			pst.setString(6, f.getFoodDescription());
			pst.setInt(7, f.getFoodRating());

			int i = pst.executeUpdate();

			if (i > 0)
				return true;

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

		return false;
	}

	@Override
	public boolean updateFood(Food f) {

		try {
			con = DBConnection.makeConnection();
			sql = "UPDATE `Food_Maj` SET `foodName`=?,`foodType`=?,`foodPrice`=?,`foodQuantity`=?,`foodCategory`=?,`foodDescription`= ?,`foodRating`=? WHERE `foodId`= ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, f.getFoodName());
			pst.setString(2, f.getFoodType());
			pst.setDouble(3, f.getFoodPrice());
			pst.setInt(4, f.getFoodQuantity());
			pst.setString(5, f.getFoodCategory());
			pst.setString(6, f.getFoodDescription());
			pst.setInt(7, f.getFoodRating());
			pst.setInt(8, f.getFoodId());

			if (pst.executeUpdate() > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFood(Integer foodId) {

		try {
			con = DBConnection.makeConnection();
			sql = "delete from `Food_Maj` where foodId = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, foodId);
			if (pst.executeUpdate() > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Food> searchFoodByCategory(String foodCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> searchFoodByName(String foodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> searchFoodByType(String foodType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food searchFoodById(Integer foodId) {
		try {
			con = DBConnection.makeConnection();
			sql = "SELECT * FROM `Food_Maj` WHERE foodId = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, foodId);
			rs = pst.executeQuery();

			if (rs != null && rs.next()) {
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
				f.setFoodDescription(rs.getString("foodDescription"));
				f.setFoodQuantity(rs.getInt("foodQuantity"));
				f.setFoodRating(rs.getInt("foodRating"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<Food> fetchAllFood() {

		try {
			con = DBConnection.makeConnection();
			sql = "SELECT * FROM `Food_Maj`";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			flist = new ArrayList<>();

			while (rs != null && rs.next()) {
				f = new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
				flist.add(f);
			}

			return flist;

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
	public void updateFoodMenu() {

		System.out.println("Enter the option given in menu");
		System.out.println("1. Update Food Name.");
		System.out.println("2. Update Food Type.");
		System.out.println("3. Update Food Price.");
		System.out.println("4. Update Food Quantity.");
		System.out.println("5. Update Food Category.");
		System.out.println("6. Update Food Description.");
		System.out.println("7. Update Food Rating.");
		System.out.print("=>\t");
		int option = sc.nextInt();

		sc.nextLine();
		switch (option) {
		case 1:
			System.out.println("1. Update Food Name.");
			System.out.print("Enter Food Name : ");
			foodName = sc.nextLine();
			f.setFoodName(foodName);

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");

			break;
		case 2:
			System.out.println("2. Update Food Type.");
			System.out.print("Enter Food Type : ");
			foodType = sc.nextLine();
			f.setFoodType(foodType);

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;
		case 3:
			System.out.println("3. Update Food Price.");
			System.out.print("Enter Food Price : ");
			foodPrice = sc.nextDouble();
			f.setFoodPrice(foodPrice);
			;

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;
		case 4:
			System.out.println("4. Update Food Quantity.");
			System.out.print("Enter Food Quantity : ");
			foodQuantity = sc.nextInt();
			f.setFoodQuantity(foodQuantity);
			;

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;
		case 5:
			System.out.println("5. Update Food Category.");
			System.out.print("Enter Food Category : ");
			foodCategory = sc.nextLine();
			f.setFoodCategory(foodCategory);
			;

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;
		case 6:
			System.out.println("6. Update Food Description.");
			System.out.print("Enter Food Description : ");
			foodDescription = sc.nextLine();
			f.setFoodDescription(foodDescription);

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;
		case 7:
			System.out.println("7. Update Food Rating.");
			System.out.print("Enter Food Rating : ");
			foodRating = sc.nextInt();
			f.setFoodRating(foodRating);

			if (updateFood(f))
				System.out.println("SucessFully Updated");
			else
				System.out.println("Error");
			break;

		default:
			System.out.println("Invalid Option.");
			break;
		}

	}

}
