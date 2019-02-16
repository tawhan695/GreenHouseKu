-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2019 at 04:53 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `date` datetime NOT NULL,
  `fan` tinyint(1) NOT NULL,
  `light` tinyint(1) NOT NULL,
  `pump` tinyint(1) NOT NULL,
  `temp_in` int(3) NOT NULL,
  `temp_out` int(3) NOT NULL,
  `humidity_in` int(3) NOT NULL,
  `huminity_out` int(3) NOT NULL,
  `soil` int(3) NOT NULL,
  `light_sun` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`date`, `fan`, `light`, `pump`, `temp_in`, `temp_out`, `humidity_in`, `huminity_out`, `soil`, `light_sun`) VALUES
('2019-01-23 00:00:00', 0, 0, 0, 30, 29, 20, 40, 80, 50);

-- --------------------------------------------------------

--
-- Table structure for table `datacontrol`
--

CREATE TABLE `datacontrol` (
  `id` int(1) NOT NULL,
  `temp_max` int(3) NOT NULL,
  `temp_min` int(3) NOT NULL,
  `soli_max` int(3) NOT NULL,
  `soil_min` int(3) NOT NULL,
  `sun_max` int(3) DEFAULT NULL,
  `sun_min` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `datacontrol`
--

INSERT INTO `datacontrol` (`id`, `temp_max`, `temp_min`, `soli_max`, `soil_min`, `sun_max`, `sun_min`) VALUES
(1, 34, 34, 70, 20, 80, 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `datacontrol`
--
ALTER TABLE `datacontrol`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
