-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 13, 2018 at 07:15 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `workstation`
--

-- --------------------------------------------------------

--
-- Table structure for table `handover`
--

DROP TABLE IF EXISTS `handover`;
CREATE TABLE IF NOT EXISTS `handover` (
  `Sr` int(128) NOT NULL AUTO_INCREMENT,
  `LocoNo` int(5) NOT NULL,
  `Base` varchar(5) NOT NULL,
  `DEAD_OR_FAIL` varchar(4) NOT NULL,
  `Reason` varchar(254) NOT NULL,
  `TOver_Place` varchar(128) NOT NULL,
  `TOver_DateTime` datetime NOT NULL,
  `HOver_Place` varchar(128) NOT NULL,
  `HOver_DateTime` datetime NOT NULL,
  `Transit_time` varchar(10) NOT NULL,
  PRIMARY KEY (`Sr`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `handover`
--

INSERT INTO `handover` (`Sr`, `LocoNo`, `Base`, `DEAD_OR_FAIL`, `Reason`, `TOver_Place`, `TOver_DateTime`, `HOver_Place`, `HOver_DateTime`, `Transit_time`) VALUES
(40, 56897, 'BHVJN', 'FAIL', 'FGCH', 'NGP DIV-ASD', '2018-03-12 05:00:00', 'SCR', '2018-03-13 00:00:00', '19:00'),
(39, 23459, 'ET', 'DEAD', 'SCH. O/DUE 06/02', 'SECR', '2018-01-23 01:00:00', 'SECR', '2018-01-23 01:02:00', '00:02');

-- --------------------------------------------------------

--
-- Table structure for table `initial`
--

DROP TABLE IF EXISTS `initial`;
CREATE TABLE IF NOT EXISTS `initial` (
  `LocoNo` int(5) NOT NULL,
  `Base` varchar(5) NOT NULL,
  `DEAD_OR_FAIL` varchar(4) NOT NULL,
  `Reason` varchar(254) NOT NULL,
  `TOver_Place` varchar(128) NOT NULL,
  `TOver_DateTime` datetime NOT NULL,
  `CURRENT_LOCATION` varchar(128) NOT NULL,
  PRIMARY KEY (`LocoNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `initial`
--

INSERT INTO `initial` (`LocoNo`, `Base`, `DEAD_OR_FAIL`, `Reason`, `TOver_Place`, `TOver_DateTime`, `CURRENT_LOCATION`) VALUES
(25684, 'SDF', 'DEAD', 'SDF', 'NGP DIV-FAS', '2018-03-14 00:00:00', 'SDF');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
