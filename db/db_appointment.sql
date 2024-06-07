-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2024 at 06:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_appointment`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_appointment`
--

CREATE TABLE `tbl_appointment` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Doctor` varchar(255) NOT NULL,
  `Room` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_appointment`
--

INSERT INTO `tbl_appointment` (`ID`, `Name`, `Doctor`, `Room`) VALUES
(5, 'guri', 'dr.gagan', 205),
(6, 'Alex S', 'Dr Baljinder', 207),
(23, 'Karan', 'Dr.Arman', 201);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_appointment`
--
ALTER TABLE `tbl_appointment`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_appointment`
--
ALTER TABLE `tbl_appointment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
