package com.food.test;

import com.food.dao.CustomerImpl;
import com.food.pojo.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerTest {

    static {
        System.out.println("------FOOD SHOP--------------------------");
        System.out.println("--------------CUSTOMER ------------------");
        System.out.println("----------------------MANAGEMENT---------");
    }

    public static void main(String[] args) {
        try (var sc = new Scanner(System.in)) {
            Customer c = null;
            List<Customer> clist = null;
            CustomerImpl cimpl = new CustomerImpl();

            Integer customerId;
            String customerName;
            String customerAddress;
            String customerEmail = "";
            Long customerPhone = 1L;
            String customerPassword = "";

            while (true) {
                boolean flag = true;
                System.out.println("\n1. Add Customer");
                System.out.println("2. Update Customer");
                System.out.println("3. Delete Customer");
                System.out.println("4. Show All Customer");
                System.out.println("5. Search By Name");
                System.out.println("6. Search By Email");
                System.out.println("9. Exit");
                System.out.print("=>\t");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("ADD CUSTOMER");

                        sc.nextLine();
                        System.out.print("Enter Customer Name : ");
                        customerName = sc.nextLine();

                        while (flag) {
                            System.out.print("Enter Customer Email : ");
                            customerEmail = sc.nextLine();
                            flag = cimpl.checkEmail(customerEmail);
                            if (flag) {
                                System.out.println("Email already exist , please enter a new Email-id");
                            } else
                                break;

                        }

                        flag = true;
                        while (flag) {
                            System.out.print("Enter Customer Password : ");
                            customerPassword = sc.nextLine();
                            flag = cimpl.checkPassword(customerPassword);
                            if (flag) {
                                System.out.println("Password already exist , please enter a new Password.");
                            } else
                                break;
                        }

                        flag = true;
                        while (flag) {
                            System.out.print("Enter Customer Phone : ");
                            customerPhone = sc.nextLong();
                            if (customerPhone != 0L)
                                flag = cimpl.checkPhone(customerPhone);
                            if (flag) {
                                System.out.println("PhoneNumber already exist , please enter a new PhoneNumber.");
                            } else
                                break;
                        }
                        sc.nextLine();
                        System.out.print("Enter Customer Address : ");
                        customerAddress = sc.nextLine();

                        if (customerEmail != "" && customerPassword != "" && customerPhone != 1L)
                            c = new Customer(customerName, customerAddress, customerEmail, customerPhone,
                                    customerPassword);
                        else {
                            System.out.println("Error : Feilds are Empty");
                            break;
                        }

                        if (c != null && cimpl.addCustomer(c))
                            System.out.println("\nCustomer Added Successful\n");
                        else
                            System.out.println("Error While Adding");

                        break;

                    case 2:
                        System.out.println("UPDATE CUSTOMER");
                        System.out.print("\nEnter Customer Id : ");
                        customerId = sc.nextInt();

                        c = cimpl.searchCustomerById(customerId);

                        if (c.getCustomerId() != null) {
                            System.out.println(c + "\n-------------------------------------------\n");
                            sc.nextLine();
                            System.out.println("🟠 Do you want to Update ? [YES/NO]");
                            System.out.print("=>\t");
                            String choice2 = sc.nextLine();
                            if (choice2.equalsIgnoreCase("yes")) {

                                System.out.println("\n\t Update Menu.");
                                System.out.println("\t1. Name.");
                                System.out.println("\t2. Email.");
                                System.out.println("\t3. Password");
                                System.out.println("\t4. Phone");
                                System.out.println("\t5. Address.");
                                System.out.print("=>\t");
                                int cho = sc.nextInt();

                                switch (cho) {
                                    case 1:
                                        sc.nextLine();
                                        System.out.print("\nEnter new name : ");
                                        customerName = sc.nextLine();
                                        c.setCustomerName(customerName);
                                        if (cimpl.updateCustomer(c))
                                            System.out.println("Name Updated Successfully");
                                        else
                                            System.out.println("Error While Updating Name.");
                                        break;
                                    case 2:
                                        sc.nextLine();
                                        System.out.print("\nEnter New Email : ");
                                        customerEmail = sc.nextLine();
                                        while (cimpl.checkEmail(customerEmail)) {
                                            System.out.println("Email already exist , please enter a new Email-id");
                                            System.out.print("Enter New Email : ");
                                            customerEmail = sc.nextLine();
                                            flag = cimpl.checkEmail(customerEmail);
                                            if (!flag)
                                                break;

                                        }
                                        c.setCustomerEmail(customerEmail);
                                        if (cimpl.updateCustomer(c))
                                            System.out.println("Email Updated Successfully");
                                        else
                                            System.out.println("Error While Updating Email.");
                                        break;
                                    case 3:
                                        sc.nextLine();
                                        System.out.print("Enter old password : ");
                                        String oldpass = sc.nextLine();
                                        if (!cimpl.checkPassword(oldpass)) {
                                            System.out.println("Old password Incorrect.");
                                            break;
                                        }
                                        System.out.print("\nEnter New Password : ");
                                        customerPassword = sc.nextLine();
                                        while (cimpl.checkPassword(customerPassword)) {
                                            System.out.println("Password already exist , please enter a new Password");
                                            System.out.print("Enter New Password : ");
                                            customerEmail = sc.nextLine();
                                            flag = cimpl.checkPassword(customerPassword);
                                            if (!flag)
                                                break;

                                        }
                                        c.setCustomerPassword(customerPassword);
                                        if (cimpl.updateCustomer(c))
                                            System.out.println("Password Updated Successfully");
                                        else
                                            System.out.println("Error While Updating Password.");
                                        break;
                                    case 4:
                                        sc.nextLine();
                                        System.out.print("\nEnter New Phone Number : ");
                                        customerPhone = sc.nextLong();
                                        while (cimpl.checkPhone(customerPhone)) {
                                            System.out.println(
                                                    "Phone Number already exist , please enter a new Phone Number");
                                            System.out.print("Enter New Phone Number : ");
                                            customerEmail = sc.nextLine();
                                            flag = cimpl.checkPhone(customerPhone);
                                            if (!flag)
                                                break;

                                        }
                                        c.setCustomerPhone(customerPhone);
                                        if (cimpl.updateCustomer(c))
                                            System.out.println("Phone Updated Successfully");
                                        else
                                            System.out.println("Error While Updating Phone.");
                                        break;
                                    case 5:
                                        sc.nextLine();
                                        System.out.print("\nEnter new address : ");
                                        customerAddress = sc.nextLine();
                                        c.setCustomerAddress(customerAddress);
                                        if (cimpl.updateCustomer(c))
                                            System.out.println("Address Updated Successfully");
                                        else
                                            System.out.println("Error While Updating Address.");
                                        break;

                                    default:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                            }
                        } else
                            System.out.println("\nCustomer Not Found , please enter a valid Customer Id.");

                        break;

                    case 3:

                        System.out.println("DELETE CUSTOMER");
                        System.out.print("\nEnter Customer Id : ");
                        customerId = sc.nextInt();

                        c = cimpl.searchCustomerById(customerId);

                        if (c.getCustomerId() != null) {
                            System.out.println(c + "---------------------------------------\n");
                            sc.nextLine();
                            System.out.println("🟠 Do you want to Delete ? [YES/NO]");
                            System.out.print("=>\t");
                            String choice2 = sc.nextLine();
                            if (choice2.equalsIgnoreCase("yes")) {
                                if (cimpl.deleteCustomer(c))
                                    System.out.println("Customer Deleted Sucessfully");
                                else
                                    System.out.println("Error while deleteing");
                            }
                        } else
                            System.out.println("\nCustomer Not Found ,please enter a valid Customer Id.");

                        break;

                    case 4:
                        System.out.println("Show All Customers.");
                        clist = cimpl.showAllCustomer();

                        if (clist != null)
                            clist.forEach(s -> System.out
                                    .println(s + "\n------------------------------------------------------------\n"));
                        else
                            System.out.println("DataBase is Empty");

                        break;
                    case 5:
                        System.out.println("Search By Name");
                        sc.nextLine();
                        System.out.print("Enter Customer Name : ");
                        customerName = sc.nextLine();

                        clist = cimpl.searchCustomerByName(customerName);

                        if (clist != null)
                            clist.forEach(s -> System.out
                                    .println(s + "\n------------------------------------------------------------\n"));
                        else
                            System.out.println("DataBase is Empty");

                        break;

                    case 6:
                        System.out.println("\nSearch By Email");
                        sc.nextLine();
                        System.out.print("Enter Customer Email : ");
                        customerEmail = sc.nextLine();
                        c = cimpl.searchCustomerByEmail(customerEmail);
                        if (c!= null)
                        {
                            System.out.println(c + "\n------------------------------------------------------------\n");
                        }
                        else
                        {
                            System.out.println("Customer Not Found");
                        }

                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }
            }
        }

    }
}
