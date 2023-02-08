package com.food.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.food.dao.CartDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.dao.OrderDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Order;
import com.food.utility.CrediantialsException;

public class OrderTest {

	static {
		System.out.println("--------------------------------");
		System.out.println("----------ORDER MENU------------");
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			LoginDaoImpl limpl = new LoginDaoImpl();
			OrderDaoImpl oImpl = new OrderDaoImpl();

			List<Order> olist = null;

			Order order;

			Integer orderId;
			Double billingAmount = 0.0;
			LocalDate orderDate;
			String dropLocation;
			LocalDateTime deliveryDate;
			String orderStatus;
			Integer year;
			Integer month;
			Integer dayOfMonth;
			Integer hour;
			Integer minute;

			String username;
			String password;
			String login = "";
			boolean exit = true;
			int option;
			int choice;

			while (true) {
				System.out.print("\nEnter username : ");
				username = sc.nextLine();
				System.out.print("Enter your password: ");
				password = sc.nextLine();

				if (limpl.checkAdmin(username, password)) {
					login = "admin";
					System.out.println("\nYou are logged in as admin");

				} else {
					if (limpl.checkCustomer(username, password)) {
						login = "customer";
						System.out.println("\nYou are logged in as user");

					} else {
						try {
							throw new CrediantialsException(username);
						} catch (CrediantialsException e) {
							System.out.println(e);
						}
					}
				}

				if (login.equals("admin")) {
					do {
						System.out.println("1. Show All Orders.");
						System.out.println("2. Change Orders Status");
						System.out.println("3. Logout");
						System.out.print("=>\t");
						option = sc.nextInt();

						switch (option) {
						case 1:
							System.out.println("\nShow All Orders.");

							olist = oImpl.showAllOrders();

							if (olist != null && !olist.isEmpty()) {
								olist.forEach(o -> {
									System.out.println("Order Id : " + o.getOrderId());
									System.out.println("Billing Amount : " + o.getBillingAmount());
									System.out.println("Order Date : " + o.getOrderDate());
									System.out.println("Customer Email : " + o.getCustomerEmail());
									System.out.println("Drop Location : " + o.getDropLocation());
									System.out.println("Delivery Date : " + o.getDeliveryDate());
									System.out.println("Order Status : " + o.getOrderStatus());
									System.out.println("--------------------------------\n");
								});
							}
							break;

						case 2:
							System.out.print("\nEnter Order Id : ");
							orderId = sc.nextInt();
							sc.nextLine();
							System.out.print("Enter New Order Status : ");
							orderStatus = sc.nextLine();

							if (oImpl.changeStatus(orderId, orderStatus)) {
								System.out.println("Status Changes Successfully");
							} else {
								System.out.println("Error While changing Status");
							}
							break;

						case 3:
							System.out.println("Thank You");
							login = "";
							exit = false;
							break;
						default:
							System.out.println("\nInvalid Option");
							break;
						}
					} while (exit);

				} else if (login.equals("customer")) {
					do {
						exit = false;
						System.out.println("1. Place Order");
						System.out.println("2. Cancel Order");
						System.out.println("3. Show Order");
						System.out.println("4. Check Order Status");
						System.out.println("5. Logout");
						System.out.print("=>\t");
						choice = sc.nextInt();

						switch (choice) {
						case 1:
							System.out.println("\nPLACE ORDER");
							List<Cart> clist = new CartDaoImpl().showMyCart(username);
							Iterator<Cart> itr = clist.iterator();

							if (clist != null && !clist.isEmpty()) {
								while (itr.hasNext()) {
									Cart s = itr.next();
									System.out.println("\nCart id : " + s.getCartId());
									System.out.println("Food id : " + s.getFoodId());
									System.out.println("Food name : " + s.getF().getFoodName());
									System.out.println("Food price : " + s.getPrice());
									System.out.println("Food quantity : " + s.getFoodQuantity());
									System.out.println("Subtotal : " + s.getSubtotal());
									billingAmount += s.getSubtotal();

								}
								System.out.println("Your Total Billing Amount is " + billingAmount);
							} else {
								System.out.println("Your Cart is empty");
								break;
							}
							sc.nextLine();
							System.out.println("\nDo you want to checkout ? [YES | NO]");
							System.out.print("=>\t");
							String ans = sc.nextLine();

							if (ans.equalsIgnoreCase("yes")) {
								System.out.print("\nEnter Drop Location :");
								dropLocation = sc.nextLine();

								System.out.println("Enter Delivery Date as Follows . ");
								System.out.print("Enter Year : ");
								year = sc.nextInt();
								System.out.print("Enter Month : ");
								month = sc.nextInt();
								System.out.print("Enter Day Of Month : ");
								dayOfMonth = sc.nextInt();
								System.out.print("Enter Hours : ");
								hour = sc.nextInt();
								System.out.print("Enter Minutes : ");
								minute = sc.nextInt();
								deliveryDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

								orderDate = LocalDate.now();

								orderStatus = "CONFIRMED";

								order = new Order(billingAmount, orderDate, username, dropLocation, deliveryDate,
										orderStatus);

								Order o1 = oImpl.placeOrder(order);

								if (o1 != null) {
									System.out.println("\nOrder Placed SuccessFully.");
									System.out.println("\n----------------DETAILS----------------");
									System.out.println("Order Id : " + o1.getOrderId());
									System.out.println("Billing Amount : " + o1.getBillingAmount());
									System.out.println("Order Date : " + o1.getOrderDate());
									System.out.println("Customer Email : " + o1.getCustomerEmail());
									System.out.println("Drop Location : " + o1.getDropLocation());
									System.out.println("Delivery Date : " + o1.getDeliveryDate());
									System.out.println("Order Status : " + o1.getOrderStatus());
									System.out.println("---------------------------------------\n");
									new CartDaoImpl().clearMyCart(o1.getCustomerEmail());
								}

							}

							break;

						case 2:
							System.out.println("CANCEL ORDER");
							System.out.print("\nEnter Order Id: ");
							orderId = sc.nextInt();
							if (oImpl.cancelOrder(orderId))
								System.out.println("Your Order Has Been canceled");
							else
								System.out.println("Error While Cancelling");
							break;

						case 3:
							System.out.println("Show My Orders");
							olist = oImpl.showOrderHistory(username);
							if (olist != null && !olist.isEmpty()) {
								for (Order o1 : olist) {
									System.out.println("\n----------------DETAILS----------------");
									System.out.println("Order Id : " + o1.getOrderId());
									System.out.println("Billing Amount : " + o1.getBillingAmount());
									System.out.println("Order Date : " + o1.getOrderDate());
									System.out.println("Drop Location : " + o1.getDropLocation());
									System.out.println("Delivery Date : " + o1.getDeliveryDate());
									System.out.println("Order Status : " + o1.getOrderStatus());
									System.out.println("---------------------------------------\n");
								}
							} else {
								System.out.println("Order History is Empty.");
							}
							break;
						case 4:
							System.out.println("Check Order Status");
							System.out.print("\nEnter Order Id");
							orderId = sc.nextInt();
							String status = oImpl.checkStatus(orderId);
							if (status != null) {
								System.out.println("---------STATUS----------");
								System.out.println("Order Id : " + orderId);
								System.out.println("Order Status : " + status);
							} else {
								System.out.println("No Order found. Please Check Your Order Id.");
							}
							break;
						case 5:
							login = "";
							exit = false;
							System.out.println("Thank You For Using ....😀");
							sc.nextLine();
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}

					} while (exit);

				} else {
					System.out.println("\nInvalid Login.");
				}

			}
		}
	}
}
