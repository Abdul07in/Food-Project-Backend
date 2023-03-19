-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 19, 2023 at 12:53 PM
-- Server version: 5.7.40-0ubuntu0.18.04.1
-- PHP Version: 7.2.34-36+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testuser_MajeedProject41`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin_Maj`
--

CREATE TABLE `Admin_Maj` (
  `adminId` int(11) NOT NULL,
  `adminEmail` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin_Maj`
--

INSERT INTO `Admin_Maj` (`adminId`, `adminEmail`, `adminPassword`) VALUES
(1, 'admin@gmail.com', 'admin123'),
(2, 'squad@gmail.com', 'squ@d123');

-- --------------------------------------------------------

--
-- Table structure for table `Cart_Admin`
--

CREATE TABLE `Cart_Admin` (
  `foodId` int(11) DEFAULT NULL,
  `foodQuantity` int(11) DEFAULT NULL,
  `price` double(15,2) DEFAULT NULL,
  `subtotal` double(15,2) DEFAULT NULL,
  `customerEmail` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart_Admin`
--

INSERT INTO `Cart_Admin` (`foodId`, `foodQuantity`, `price`, `subtotal`, `customerEmail`) VALUES
(1, 3, 80.20, 240.60, 'abdulkanoor@gmail.com'),
(15, 2, 85.23, 170.46, 'abdulkanoor@gmail.com'),
(9, 1, 250.23, 250.23, 'abdulkanoor@gmail.com'),
(6, 10, 80.20, 802.00, 'abdulkanoor@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Cart_Maj`
--

CREATE TABLE `Cart_Maj` (
  `cartId` int(11) NOT NULL,
  `foodId` int(11) DEFAULT NULL,
  `foodQuantity` int(11) DEFAULT NULL,
  `price` double(15,2) DEFAULT NULL,
  `subtotal` double(15,2) DEFAULT NULL,
  `customerEmail` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart_Maj`
--

INSERT INTO `Cart_Maj` (`cartId`, `foodId`, `foodQuantity`, `price`, `subtotal`, `customerEmail`) VALUES
(8, 9, 2, 250.23, 500.46, 'aniket@gmail.com'),
(9, 2, 1, 120.20, 120.20, 'aniket@gmail.com'),
(10, 5, 2, 120.00, 240.00, 'aniket@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Customer_Maj`
--

CREATE TABLE `Customer_Maj` (
  `customerId` int(11) NOT NULL,
  `customerName` varchar(20) DEFAULT NULL,
  `customerAddress` varchar(500) DEFAULT NULL,
  `customerEmail` varchar(100) DEFAULT NULL,
  `customerPhone` bigint(20) DEFAULT NULL,
  `customerPassword` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer_Maj`
--

INSERT INTO `Customer_Maj` (`customerId`, `customerName`, `customerAddress`, `customerEmail`, `customerPhone`, `customerPassword`) VALUES
(1, 'Abdul  Kanoor', 'Mira Road East', 'abdulkanoor@gmail.com', 7020101654, 'majeed123'),
(2, 'Aniket Gupta', 'Kandavali East', 'aniket@gmail.com', 7854655213, 'aniket123'),
(3, 'Dheeraj Kumar', 'Andheri East', 'dheeraj@gmail.com', 7844544781, 'dheeraj123'),
(4, 'Chaman Singh', 'Mira Road East', 'chaman@gmail.com', 9856233214, 'chaman123'),
(5, 'Shubham Haryan', 'Ram Mandir West', 'shubham@gmail.com', 8562321457, 'shubham123'),
(7, 'Reshpal Kumavat', 'Jogeshwari East', 'reshpal@gmail.com', 9022226754, 'reshpal123'),
(9, 'Vijay Sharma', 'Jogeshwari West', 'vjsharma@gmail.com', 7020101656, 'vj123');

-- --------------------------------------------------------

--
-- Table structure for table `Food_Maj`
--

CREATE TABLE `Food_Maj` (
  `foodId` int(10) NOT NULL,
  `foodName` varchar(100) DEFAULT NULL,
  `foodType` varchar(100) DEFAULT NULL,
  `foodPrice` double(20,2) DEFAULT NULL,
  `foodQuantity` int(10) DEFAULT NULL,
  `foodCategory` varchar(100) DEFAULT NULL,
  `foodDescription` text,
  `foodRating` int(10) DEFAULT NULL,
  `foodImage` varchar(255) NOT NULL DEFAULT 'default.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Food_Maj`
--

INSERT INTO `Food_Maj` (`foodId`, `foodName`, `foodType`, `foodPrice`, `foodQuantity`, `foodCategory`, `foodDescription`, `foodRating`, `foodImage`) VALUES
(1, 'Bell Pepper', 'Vegetable', 80.20, 10, 'Vegetable', 'Bell peppers are a delicious and vibrant vegetable, perfect for adding flavor and texture to any meal. They come in a range of colors, from the familiar green to yellow, orange, and even red. They can be eaten raw or cooked, making them a versatile addition to any dish. Bell peppers are low in calories and high in vitamin C, with a sweet and slightly spicy flavor. They are also a great source of dietary fiber, making them a healthy and nutritious choice. Bell peppers can be used in salads, sandwiches, soups, stews, stir-fries, and more. They are also a popular choice for pickling and roasting. Whether you add them to your favorite recipes or snack on them raw, bell peppers are a delicious way to add a burst of flavor to your meals.', 4, 'bellpeper.jpg'),
(2, 'Strawberries', 'Fruit', 120.20, 20, 'Fruit', 'Strawberries are a loved summer favorite that can be enjoyed in many ways! They are a vibrant, red, and sweet fruit packed with essential vitamins and minerals. With their juicy and tart flesh, these berries make a delicious and healthy snack, perfect for adding to salads, smoothies, and desserts. They are also an excellent source of antioxidants, dietary fiber, and other plant compounds that can help protect against heart disease and cancer. Enjoy the mouth-watering flavor of fresh strawberries for a sweet and healthy treat that\'s sure to please!', 5, 'strawberry.jpg'),
(4, 'Green Beans', 'Vegetable', 120.00, 20, 'Vegetable', 'Green beans are a nutritious, delicious vegetable enjoyed around the world. They are a great source of vitamins and minerals, including folate, potassium, iron, and vitamin A. Green beans are versatile and can be prepared in a variety of ways, from steaming and sautéing to roasting and baking. They have a crisp, yet tender texture and a mild, earthy flavor. Enjoy them as a side dish, or add them to salads, soups, casseroles, and more. Green beans are an easy and convenient way to add nutrition to any meal.', 4, 'greenbeans.jpg'),
(5, 'Purple Cabbage', 'Vegetable', 120.00, 25, 'Vegetable', 'Purple Cabbage is a unique and vibrant variety of cabbage with a deep purple hue. Its crisp texture and sweet flavor make it a popular choice for coleslaws, salads, and stir-fries. It is also full of vitamins, minerals, and antioxidants, making it a great addition to any healthy diet. Purple Cabbage is a versatile vegetable that can be cooked in a variety of ways, from roasting to sautéing to pickling. Its flavor is enhanced when cooked with other vegetables and herbs, such as onions, garlic, and oregano. Its color stands out in dishes, making it a beautiful and tasty addition to any meal. Get creative and enjoy the nutritional benefits of Purple Cabbage today!', 5, 'purple.jpg'),
(6, 'Tomato', 'Vegetable', 80.20, 20, 'Vegetable', 'Tomato is a delicious, nutritious, and versatile fruit (technically a vegetable) that comes in many different shapes, sizes, and colors. It is a great source of Vitamin C, potassium, and fiber, and can be used in a variety of dishes. Tomato sauce, salsa, and tomato soup are all popular dishes that incorporate tomatoes. Tomatoes can also be used in salads, sandwiches, and even raw! Tomatoes are a great addition to any meal and their bright and vibrant colors are sure to make any plate look beautiful and appetizing.', 4, 'tamato.jpg'),
(7, 'Brocolli', 'Vegetable', 120.20, 20, 'Vegetable', 'Brocolli is a superfood with a crunchy texture and vibrant green color. It is a cruciferous vegetable that is high in vitamin C and dietary fiber, making it a great addition to any healthy diet. Brocolli can be enjoyed cooked, raw, or even juiced and is great for adding to salads, stir-fries, soups, casseroles, and more. This versatile vegetable is low in calories, making it a great way to add flavor and nutrition to any meal.', 5, 'brocoli.jpg'),
(8, 'Carrots', 'Vegetable', 120.20, 25, 'Vegetable', 'Carrots are a nutritious root vegetable with a crunchy texture and sweet flavor. They can be eaten raw, cooked, juiced, and are a popular ingredient in soups, stews, salads, and other dishes. Carrots are an excellent source of beta-carotene, dietary fiber, and vitamins A, C, and K. They also contain minerals such as potassium, phosphorus, magnesium, and calcium. Carrots are low in calories and fat, making them a healthy snack for people of all ages. With their sweet flavor and crunchy texture, carrots are a great way to add flavor and nutrition to any dish.', 4, 'carrot.jpg'),
(9, 'Pack of 3 Fruit Juice', 'Juice', 250.23, 30, 'Juice', 'This pack of 3 Fruit Juice is perfect for those who want to get a daily dose of healthy vitamins and minerals! Our juice is made from the freshest and highest quality fruits, which are carefully selected to ensure the highest quality and flavor. Our juices are 100% natural, and contain no added sugar, preservatives or artificial colors. Each pack contains three bottles of delicious fruit juice in a variety of flavors – Mango, Apple and Orange. Enjoy a healthy and refreshing drink at any time of the day!', 5, 'juices.jpg'),
(15, 'Garlic', 'Vegetable', 85.23, 25, 'Vegetable', 'sdasd', 5, 'garlic.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `Order_Maj`
--

CREATE TABLE `Order_Maj` (
  `orderId` int(11) NOT NULL,
  `billingAmount` double(15,2) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `customerEmail` varchar(255) DEFAULT NULL,
  `dropLocation` varchar(255) DEFAULT NULL,
  `deliveryDate` datetime DEFAULT NULL,
  `orderStatus` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Order_Maj`
--

INSERT INTO `Order_Maj` (`orderId`, `billingAmount`, `orderDate`, `customerEmail`, `dropLocation`, `deliveryDate`, `orderStatus`) VALUES
(1, 391.00, '2023-03-19', 'abdulkanoor@gmail.com', 'Mira Road East', '2023-03-20 16:30:30', 'Pending'),
(2, 230.00, '2023-03-19', 'abdulkanoor@gmail.com', 'Mira Road East', '2023-03-20 16:30:11', 'Pending'),
(3, 782.00, '2023-03-19', 'abdulkanoor@gmail.com', 'Mira Road East', '2023-03-20 16:30:58', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin_Maj`
--
ALTER TABLE `Admin_Maj`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `Cart_Maj`
--
ALTER TABLE `Cart_Maj`
  ADD PRIMARY KEY (`cartId`),
  ADD KEY `foodId` (`foodId`);

--
-- Indexes for table `Customer_Maj`
--
ALTER TABLE `Customer_Maj`
  ADD PRIMARY KEY (`customerId`),
  ADD KEY `email_index` (`customerEmail`);

--
-- Indexes for table `Food_Maj`
--
ALTER TABLE `Food_Maj`
  ADD PRIMARY KEY (`foodId`);

--
-- Indexes for table `Order_Maj`
--
ALTER TABLE `Order_Maj`
  ADD PRIMARY KEY (`orderId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin_Maj`
--
ALTER TABLE `Admin_Maj`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Cart_Maj`
--
ALTER TABLE `Cart_Maj`
  MODIFY `cartId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `Customer_Maj`
--
ALTER TABLE `Customer_Maj`
  MODIFY `customerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `Food_Maj`
--
ALTER TABLE `Food_Maj`
  MODIFY `foodId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `Order_Maj`
--
ALTER TABLE `Order_Maj`
  MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cart_Maj`
--
ALTER TABLE `Cart_Maj`
  ADD CONSTRAINT `Cart_Maj_ibfk_1` FOREIGN KEY (`foodId`) REFERENCES `Food_Maj` (`foodId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
