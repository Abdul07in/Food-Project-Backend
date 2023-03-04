# Food Ordering System
A console-based food ordering application built using Core Java and MySQL.

##  Features
      - User can view menu items
      - User can place an order
      - User can view order history
      - User can update order
      - User can cancel order

##  Requirements
      - Java 8 or higher
      - MySQL
      
##  Setup
     - Clone the repository and import it into your preferred Java IDE
     - Create a database named "foodorder" in MySQL
     - Run the SQL script "setup.sql" to create the necessary tables
     - Update the database connection details in the "DbConnection.java" file
     - Run the "Main.java" file to launch the application.
     
##  Usage
     - Upon launch, the application will prompt the user to login or register.
     - Once logged in, the user can view the menu and place an order.
     - The user can also view their order history, update their order or cancel their order.


##  Note
- The application use the mysql connector version mysql-connector-j-8.0.31.jar , if you are using the different version please change the connector version in the classpath of your project accordingly.
       

##  Conclusion
     This is a basic food ordering system that demonstrates the use of Core Java and MySQL. 
     It can be used as a starting point for more advanced food ordering systems with additional 
     features such as payment integration, delivery tracking, and more.

