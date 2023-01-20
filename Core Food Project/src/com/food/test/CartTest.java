package com.food.test;

import java.io.Console;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.food.dao.CartImpl;
import com.food.dao.CustomerImpl;
import com.food.dao.FoodDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Customer;
import com.food.pojo.Food;
import com.food.utility.CrediantialsException;

public class CartTest {

    static {
        System.out.println("--------------------------------");
        System.out.println("----------CART LIST-------------");
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Food f = null;
            Cart c = null;
            Customer customer = null;

            LoginDaoImpl limpl = new LoginDaoImpl();
            FoodDaoImpl fimpl = new FoodDaoImpl();
            CustomerImpl cusimpl = new CustomerImpl();
            CartImpl cImpl = new CartImpl();
            List<Cart> clist = null;
            List<Food> flist = null;
            Map<Double, Double> map = new HashMap<Double, Double>();
            Console console = System.console();

            String login = null;
            Integer cartId;
            Integer foodId;
            Integer foodQuantity;
            Double price = 0.0;
            Double subtotal = 0.0;
            String customerEmail;

            boolean flag = false;
            int choice;

            while (true) {
                System.out.print("\nEnter username : ");
                String username = sc.nextLine();
                char[] cpassword = console.readPassword("Enter your password: ");
                String password = new String(cpassword);

                if (limpl.checkAdmin(username, password)) {
                    System.out.println("You are logged in as admin");
                    login = "admin";
                    break;
                } else {
                    if (limpl.checkCustomer(username, password)) {
                        login = "customer";
                        customer = cusimpl.searchCustomerByEmail(username);
                        System.out.println("You are logged in as user");
                        break;
                    } else {
                        throw new CrediantialsException(username);
                    }
                }
            }

            if (login.equals("admin")) {

                clist = cImpl.showAllCart();
                if (clist != null) {
                    clist.forEach(s -> System.out.println(s));
                } else {
                    System.out.println("There is no cart");
                }
            } else if (login.equals("customer")) {

                System.out.println("\n\nWelcome , " + customer.getCustomerName());
                while (true) {
                    System.out.println("Cart Menu");
                    System.out.println("1. Add to cart");
                    System.out.println("2. Remove from cart");
                    System.out.println("3. Show cart");
                    System.out.println("9. Exit");
                    System.out.print("=>");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Add to cart");
                            flist = fimpl.fetchAllFood();
                            if (flist != null && !flist.isEmpty()) {
                                for (Food f1 : flist) {
                                    System.out.println("Food id : " + f1.getFoodId());
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

                        case 9:
                            System.exit(0);
                        default:
                            System.out.println("Enter valid choice");
                            break;
                    }

                }
            }

        }
    }
}
