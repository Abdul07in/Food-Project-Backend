package com.food.test;

import com.food.dao.CartDaoImpl;
import com.food.dao.CustomerImpl;
import com.food.dao.FoodDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Customer;
import com.food.pojo.Food;
import com.food.utility.CrediantialsException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CartTest {

	static {
		System.out.println("--------------------------------");
		System.out.println("----------CART LIST-------------");
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Cart c;
			Customer customer = null;

			LoginDaoImpl limpl = new LoginDaoImpl();
			FoodDaoImpl fimpl = new FoodDaoImpl();
			CustomerImpl cusimpl = new CustomerImpl();
			CartDaoImpl cImpl = new CartDaoImpl();
			List<Cart> clist;
			List<Food> flist;
			Map<Double, Double> map;

			String ans;
			String login;
			Integer foodId;
			Integer foodQuantity;
			Double price = 0.0;
			Double subtotal = 0.0;
			String customerEmail;
			Integer cartId;

			String username;
			String password;
			int choice;

			while (true) {
				System.out.print("\nEnter username : ");
				username = sc.nextLine();
				System.out.print("Enter your password: ");
				password = sc.nextLine();

				if (limpl.checkAdmin(username, password)) {
					System.out.println("\nYou are logged in as admin");
					login = "admin";
					break;
				} else {
					if (limpl.checkCustomer(username, password)) {
						login = "customer";
						customer = cusimpl.searchCustomerByEmail(username);
						System.out.println("\nYou are logged in as user");
						break;
					} else {
						try {
							throw new CrediantialsException(username);
						} catch (CrediantialsException e) {
							e.printStackTrace();
						}
					}
				}
			}

			if (login.equals("admin")) {

				clist = cImpl.showAllCart();
				if (clist != null) {
					clist.forEach(s -> {
						System.out.println("\nCart Id  : " + s.getCartId());
						System.out.println("Food id : " + s.getFoodId());
						System.out.println("Food name : " + s.getF().getFoodName());
						System.out.println("Food price : " + s.getPrice());
						System.out.println("Food quantity : " + s.getFoodQuantity());
						System.out.println("Subtotal : " + s.getSubtotal());
						System.out.println("Customer Email : " + s.getCustomerEmail());
						System.out.println("--------------------------------\n");
					});
				} else {
					System.out.println("There is no cart");
				}
			} else {

				System.out.println("\n\nWelcome , " + customer.getCustomerName());
				while (true) {
					System.out.println("\nCart Menu");
					System.out.println("1. Add to cart.");
					System.out.println("2. Remove from cart.");
					System.out.println("3. Show cart.");
					System.out.println("4. Update Quantity.");
					System.out.println("5. Clear My Cart.");
					System.out.println("9. Logout.");
					System.out.print("=>\t");
					choice = sc.nextInt();
					sc.nextLine();

					switch (choice) {
					case 1:
						System.out.println("\nAdd to cart");
						flist = fimpl.fetchAllFood();
						if (flist != null && !flist.isEmpty()) {
							for (Food f1 : flist) {
								System.out.println("\nFood id : " + f1.getFoodId());
								System.out.println("Food name : " + f1.getFoodName());
								System.out.println("Food price : " + f1.getFoodPrice());
								System.out.println("Food Type : " + f1.getFoodType());
								System.out.println("--------------------------------");
							}

							System.out.print("\n\nEnter food id : ");
							foodId = sc.nextInt();
							sc.nextLine();
							System.out.print("Enter food quantity : ");
							foodQuantity = sc.nextInt();

							map = cImpl.getSubtotalMap(foodId, foodQuantity);
							for (Map.Entry<Double, Double> entry : map.entrySet()) {
								price = entry.getKey();
								subtotal = entry.getValue();
							}
							customerEmail = customer.getCustomerEmail();
							c = new Cart();
							c.setCustomerEmail(customerEmail);
							c.setFoodId(foodId);
							c.setFoodQuantity(foodQuantity);
							c.setPrice(price);
							c.setSubtotal(subtotal);
							cImpl.addCart(c);

						} else {
							System.out.println("Food List is empty");
						}
						break;
					case 2:
						System.out.println("\nRemove from cart");
						clist = cImpl.showMyCart(username);
						if (clist != null) {
							clist.forEach(s -> {
								System.out.println("\nCart id : " + s.getCartId());
								System.out.println("Food id : " + s.getFoodId());
								System.out.println("Food name : " + s.getF().getFoodName());
								System.out.println("Food price : " + s.getPrice());
								System.out.println("Food quantity : " + s.getFoodQuantity());
								System.out.println("Subtotal : " + s.getSubtotal());
								System.out.println("--------------------------------\n");
							});
							System.out.print("\n\nEnter Cart id : ");
							cartId = sc.nextInt();
							sc.nextLine();
							if (cImpl.deleteCart(cartId))
								System.out.println("Cart deleted successfully");
							else
								System.out.println("Cart not deleted");
						}
						break;

					case 3:
						System.out.println("\nSHOW MY CART");
						clist = cImpl.showMyCart(username);
						if (clist != null) {
							clist.forEach(s -> {
								System.out.println("\nCart id : " + s.getCartId());
								System.out.println("Food id : " + s.getFoodId());
								System.out.println("Food name : " + s.getF().getFoodName());
								System.out.println("Food price : " + s.getPrice());
								System.out.println("Food quantity : " + s.getFoodQuantity());
								System.out.println("Subtotal : " + s.getSubtotal());
								System.out.println("--------------------------------\n");
							});
						}
						break;

					case 4:
						System.out.println("\nUpdate Quantity");
						clist = cImpl.showMyCart(username);
						if (clist != null) {
							clist.forEach(s -> {
								System.out.println("\nCart id : " + s.getCartId());
								System.out.println("Food id : " + s.getFoodId());
								System.out.println("Food name : " + s.getF().getFoodName());
								System.out.println("Food price : " + s.getPrice());
								System.out.println("Food quantity : " + s.getFoodQuantity());
								System.out.println("Subtotal : " + s.getSubtotal());
								System.out.println("--------------------------------\n");
							});
						}
						System.out.println("Do you want to update ? [YES|NO]");
						System.out.print("==>\t");
						ans = sc.nextLine();

						if (ans.equalsIgnoreCase("yes")) {
							System.out.print("\nEnter Cart Id : ");
							cartId = sc.nextInt();
							System.out.print("Enter Quantity : ");
							foodQuantity = sc.nextInt();
							if (foodQuantity == 0) {
								cImpl.deleteCart(cartId);
								System.out.println("Item Removed Successfully.");
								break;
							}
							if (cImpl.updateQuantity(cartId, foodQuantity))
								System.out.println("Cart Updated SuccessFully");
							else
								System.out.println("Error While Updating.");
						} else {
							System.out.println("Thank You.");
						}

						break;

					case 5:
						System.out.println("\n CLEAR MY CART");
						System.out.println("Are you sure you want to clear your cart ?");
						System.out.print("==>\t");
						ans = sc.nextLine();
						if (ans.equalsIgnoreCase("yes")) {
							cImpl.clearMyCart(username);
							System.out.println("Cart Clear SuccessFully");
						} else
							System.out.println("Error While Clearing");
						break;
					case 9:
						System.out.println("Thank You For Using...😀");
						System.exit(0);
						break;
					default:
						System.out.println("Enter valid choice");
						break;
					}

				}
			}

		}
	}
}
