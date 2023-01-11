package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.CustomerImpl;
import com.food.pojo.Customer;

public class CustomerTest {

	static {
		System.out.println("--------------------------------");
		System.out.println("----------FOOD SHOP-------------");
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer c = null;
		List<Customer> clist = null;
		CustomerImpl cimpl = new CustomerImpl();

		Integer customerId;
		String customerName;
		String customerAddress;
		String customerEmail;
		Long customerPhone;
		String customerPassword;
		boolean flag = false;

		while (true) {
			System.out.println("1. Add Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer");
			System.out.println("4. Show All Customer");
			System.out.println("5. Exit");
			System.out.print("=>\t");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("ADD CUSTOMER");

				System.out.print("Enter Customer Name : ");
				customerName = sc.nextLine();

				System.out.print("Enter Customer Address : ");
				System.out.print("Enter Customer Email : ");
				System.out.print("Enter Customer Phone : ");
				System.out.print("Enter Customer Password : ");

				break;

			case 2:

				break;

			case 3:
				break;

			case 4:
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option.");
				break;
			}
		}

	}
}
