-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 17, 2023 at 07:43 AM
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
(1, 'Abdul Majeed Kanoor', 'B/101 Rajmahal , Pooja Nagar , Mira Road East.', 'abdulkanoor@gmail.com', 7021011652, 'abdul123'),
(2, 'Aniket Gupta', 'Kandivali East , Mumbai', 'aniket@gmail.com', 985654423, 'abdul@123'),
(3, 'Dheeraj Kumar', 'Andheri East , Mumbai', 'dheeraj@gmail.com', 8744555215, 'dheeraj123'),
(5, 'Vijay Sharma', 'Jogeshwari East', 'vijay@gmail.com', 9877544562, 'asdfg1234');

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
  `foodDescription` varchar(255) DEFAULT NULL,
  `foodRating` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Food_Maj`
--

INSERT INTO `Food_Maj` (`foodId`, `foodName`, `foodType`, `foodPrice`, `foodQuantity`, `foodCategory`, `foodDescription`, `foodRating`) VALUES
(1, 'Masala Dosa', 'Veg', 85.20, 10, 'Lunch', 'It is a thin pancake in South Indian cuisine made from a fermented batter of ground black lentils and rice.', 4),
(2, 'Vada Pav', 'Veg', 25.20, 20, 'Fast Food', 'It consists of a spicy potato fritter (vada) served in a small, pav (a type of Indian bread roll). ', 5),
(4, 'Samosa Pav', 'Veg', 25.36, 20, 'Fast Food', 'a fried South Asian pastry with a savory filling, including ingredients such as spiced potatoes, onions, and peas.', 4),
(5, 'Pani Puri', 'Veg', 35.00, 25, 'Fast Food', 'Gol gappa (also known as pani puri) is a popular bite-size chaat consisting of a hollow, crispy-fried puffed ball that is filled with potato, chickpeas, onions, spices, and flavoured water, usually tamarind or mint, and popped into one\'s mouth whole.', 5);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Customer_Maj`
--
ALTER TABLE `Customer_Maj`
  MODIFY `customerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `Food_Maj`
--
ALTER TABLE `Food_Maj`
  MODIFY `foodId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
