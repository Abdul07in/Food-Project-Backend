package com.food.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.food.dao.CartImpl;
import com.food.dao.FoodDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.pojo.Cart;
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

            LoginDaoImpl limpl = new LoginDaoImpl();
            CartImpl cImpl = new CartImpl();
            List<Cart> clist = null;

            String login = null;
            boolean flag = false;

            while (true) {
                System.out.print("\nEnter username : ");
                String username = sc.nextLine();
                System.out.print("Enter password : ");
                String password = sc.nextLine();

                if (limpl.checkAdmin(username, password)) {
                    System.out.println("You are logged in as admin");
                    login = "admin";
                } else {
                    if (limpl.checkCustomer(username, password)) {
                        System.out.println("You are logged in as user");
                        login = "customer";
                    } else {
                        throw new CrediantialsException(username);
                    }
                }

                if (login.equals("admin")) {

                    clist = cImpl.showAllCart();
                    if (clist != null) {
                        Iterator<Cart> iterator = clist.iterator();
                        while (iterator.hasNext()) {
                            c = iterator.next();
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("There is no cart");
                    }

                } else if (login.equals("customer")) {

                } else {
                    throw new CrediantialsException(username);
                }

            }

        }
    }
}
