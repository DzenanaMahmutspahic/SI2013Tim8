-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2014 at 02:01 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `boravak`
--

CREATE TABLE IF NOT EXISTS `boravak` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GOST` bigint(20) DEFAULT NULL,
  `REZERVACIJA` bigint(20) DEFAULT NULL,
  `VRIJEMEDOLASKA` datetime DEFAULT NULL,
  `VRIJEMEODLASKA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_b253pgyj16a93uql81a2ph1cw` (`GOST`),
  KEY `FK_ee34fstw55nxnadbah0oi8eb7` (`REZERVACIJA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `boravak`
--

INSERT INTO `boravak` (`ID`, `GOST`, `REZERVACIJA`, `VRIJEMEDOLASKA`, `VRIJEMEODLASKA`) VALUES
(22, 1, 57, '2014-05-01 00:57:00', '2014-05-08 00:57:00'),
(23, 3, 58, '2014-06-05 01:15:56', '2014-06-13 01:15:56');

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE IF NOT EXISTS `gost` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RBRPRIJAVE` int(11) DEFAULT NULL,
  `MJESTORODJENJA` varchar(255) DEFAULT NULL,
  `PRIMJEDBA` varchar(255) DEFAULT NULL,
  `OSOBA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_6a2mtfrxfy0y3jax6v1u34dyi` (`OSOBA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Dumping data for table `gost`
--

INSERT INTO `gost` (`ID`, `RBRPRIJAVE`, `MJESTORODJENJA`, `PRIMJEDBA`, `OSOBA`) VALUES
(1, 1, 'Mostar', 'Nema primjedbi', 3),
(3, 0, 'Mostar', NULL, 5);

-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE IF NOT EXISTS `osoba` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IMEPREZIME` varchar(255) DEFAULT NULL,
  `DATUMRODJENJA` datetime DEFAULT NULL,
  `ADRESA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=83 ;

--
-- Dumping data for table `osoba`
--

INSERT INTO `osoba` (`ID`, `IMEPREZIME`, `DATUMRODJENJA`, `ADRESA`) VALUES
(1, 'Dzenana Mahmutspahic', '1992-05-01 00:00:00', 'adresa1'),
(2, 'Tajma Kovacevic', '1992-06-20 00:00:00', 'adresa1'),
(3, 'Dinoooo Kraljusic', '1987-05-07 01:31:42', 'adresa3'),
(5, 'Ajla Kovacevic', NULL, 'adresa8'),
(13, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(18, 'Dzena Mahmut', '1992-10-21 00:00:00', 'Otoka'),
(20, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(38, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(43, 'Dzena Mahmut', '1992-10-21 00:00:00', 'Otoka'),
(45, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(69, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(72, 'Test Test', NULL, NULL),
(74, 'Dzena Mahmut', '1992-10-21 00:00:00', 'Otoka'),
(75, 'Alen Kopic', '1992-10-21 00:00:00', 'Vitkovac 166'),
(76, 'Alen Kopic', '3892-11-21 00:00:00', 'Vitkovac 166'),
(80, 'admin admin', '2014-06-11 00:00:15', 'neka'),
(81, 'admina admina', '2014-06-11 00:02:15', '0'),
(82, 'tajma tajma', '2014-06-11 00:17:03', '333');

-- --------------------------------------------------------

--
-- Table structure for table `predracun`
--

CREATE TABLE IF NOT EXISTS `predracun` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POPUST` double DEFAULT NULL,
  `UKUPNACIJENA` double DEFAULT NULL,
  `REZERVACIJA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lkfuriaufo795amryuiuknc8i` (`REZERVACIJA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

-- --------------------------------------------------------

--
-- Table structure for table `racun`
--

CREATE TABLE IF NOT EXISTS `racun` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BROJRACUNA` int(11) DEFAULT NULL,
  `VRIJEMEIZDAVANJA` datetime DEFAULT NULL,
  `BORAVISNATAKSA` double DEFAULT NULL,
  `PREDRACUN` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hbxtp7arsuh306ryiksxcowyf` (`PREDRACUN`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE IF NOT EXISTS `rezervacija` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SOBA` bigint(20) DEFAULT NULL,
  `REZERVISANOOD` datetime DEFAULT NULL,
  `REZERVISANODO` datetime DEFAULT NULL,
  `BROJREZERVACIJE` int(11) DEFAULT NULL,
  `POTVRDJENA` bit(1) DEFAULT NULL,
  `KREIRAOZAPOSLENIK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_6sknp7ixg72fl1ktr1ji3qtp5` (`SOBA`),
  KEY `FK_qtetcoxihgf4rvadw1auqw6yw` (`KREIRAOZAPOSLENIK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`ID`, `SOBA`, `REZERVISANOOD`, `REZERVISANODO`, `BROJREZERVACIJE`, `POTVRDJENA`, `KREIRAOZAPOSLENIK`) VALUES
(57, 1, '2014-05-01 00:57:00', '2014-05-08 00:57:00', 1, b'1', NULL),
(58, 5, '2014-06-05 01:15:56', '2014-06-13 01:15:56', 1, b'1', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE IF NOT EXISTS `soba` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BROJSOBE` int(11) DEFAULT NULL,
  `SPRAT` int(11) DEFAULT NULL,
  `BALKON` bit(1) DEFAULT NULL,
  `BROJKREVETA` int(11) DEFAULT NULL,
  `CIJENA` double DEFAULT NULL,
  `ZAUZETA` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID`, `BROJSOBE`, `SPRAT`, `BALKON`, `BROJKREVETA`, `CIJENA`, `ZAUZETA`) VALUES
(1, 1, 1, b'0', 1, 25, b'0'),
(2, 2, 1, b'0', 1, 25, b'0'),
(3, 3, 1, b'0', 1, 27, b'0'),
(4, 4, 1, b'0', 1, 25, b'0'),
(5, 5, 1, b'0', 1, 25, b'0'),
(6, 6, 1, b'0', 1, 28, b'0'),
(7, 7, 1, b'0', 1, 25, b'0'),
(8, 8, 1, b'0', 1, 25, b'0'),
(9, 9, 2, b'0', 2, 50, b'0'),
(10, 10, 2, b'0', 2, 50, b'0'),
(11, 11, 2, b'0', 2, 50, b'0'),
(12, 12, 2, b'0', 2, 50, b'0'),
(13, 13, 2, b'0', 2, 50, b'0'),
(14, 14, 2, b'0', 2, 50, b'0'),
(15, 15, 2, b'0', 2, 50, b'0'),
(16, 16, 2, b'0', 2, 50, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `stranigost`
--

CREATE TABLE IF NOT EXISTS `stranigost` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DRZAVLJANSTVO` varchar(255) DEFAULT NULL,
  `VRSTAPUTNEISPRAVE` varchar(255) DEFAULT NULL,
  `BROJPUTNEISPRAVE` varchar(255) DEFAULT NULL,
  `VRSTAVIZE` varchar(255) DEFAULT NULL,
  `BROJVIZE` varchar(255) DEFAULT NULL,
  `DATUMDOZVOLEBORAVKA` datetime DEFAULT NULL,
  `DATUMULASKAUBIH` datetime DEFAULT NULL,
  `GOST` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_rqgaqao4lja3i7drea07sqtbj` (`GOST`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

-- --------------------------------------------------------

--
-- Table structure for table `zaposlenik`
--

CREATE TABLE IF NOT EXISTS `zaposlenik` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `JMB` varchar(255) DEFAULT NULL,
  `DRZAVLJANSTVO` varchar(255) DEFAULT NULL,
  `TITULA` varchar(255) DEFAULT NULL,
  `OBRAZOVANJE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEFON` varchar(255) DEFAULT NULL,
  `MOBITEL` varchar(255) DEFAULT NULL,
  `ULOGA` varchar(255) DEFAULT NULL,
  `ISADMINISTRATOR` bit(1) DEFAULT NULL,
  `OSOBA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_48nonbbyvt31kob4hajgmpicw` (`OSOBA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `zaposlenik`
--

INSERT INTO `zaposlenik` (`ID`, `USERNAME`, `PASSWORD`, `JMB`, `DRZAVLJANSTVO`, `TITULA`, `OBRAZOVANJE`, `EMAIL`, `TELEFON`, `MOBITEL`, `ULOGA`, `ISADMINISTRATOR`, `OSOBA`) VALUES
(1, 'admin', 'admin', '200699200033', 'BIH', 'ing', 'VSS', 'tajma.kovacevic@yahoo.com', '000-000-000', '000-000-000', '', b'1', 2),
(2, 'radnik', 'radnik', '2006992000000', 'BIH', 'neka', 'SSS', 'email', '000-000-000', '000-000-000', '', b'0', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boravak`
--
ALTER TABLE `boravak`
  ADD CONSTRAINT `FK_b253pgyj16a93uql81a2ph1cw` FOREIGN KEY (`GOST`) REFERENCES `gost` (`ID`),
  ADD CONSTRAINT `FK_ee34fstw55nxnadbah0oi8eb7` FOREIGN KEY (`REZERVACIJA`) REFERENCES `rezervacija` (`ID`);

--
-- Constraints for table `gost`
--
ALTER TABLE `gost`
  ADD CONSTRAINT `FK_6a2mtfrxfy0y3jax6v1u34dyi` FOREIGN KEY (`OSOBA`) REFERENCES `osoba` (`ID`);

--
-- Constraints for table `predracun`
--
ALTER TABLE `predracun`
  ADD CONSTRAINT `FK_lkfuriaufo795amryuiuknc8i` FOREIGN KEY (`REZERVACIJA`) REFERENCES `rezervacija` (`ID`);

--
-- Constraints for table `racun`
--
ALTER TABLE `racun`
  ADD CONSTRAINT `FK_hbxtp7arsuh306ryiksxcowyf` FOREIGN KEY (`PREDRACUN`) REFERENCES `predracun` (`ID`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `FK_6sknp7ixg72fl1ktr1ji3qtp5` FOREIGN KEY (`SOBA`) REFERENCES `soba` (`ID`),
  ADD CONSTRAINT `FK_qtetcoxihgf4rvadw1auqw6yw` FOREIGN KEY (`KREIRAOZAPOSLENIK`) REFERENCES `zaposlenik` (`ID`);

--
-- Constraints for table `stranigost`
--
ALTER TABLE `stranigost`
  ADD CONSTRAINT `FK_rqgaqao4lja3i7drea07sqtbj` FOREIGN KEY (`GOST`) REFERENCES `gost` (`ID`);

--
-- Constraints for table `zaposlenik`
--
ALTER TABLE `zaposlenik`
  ADD CONSTRAINT `FK_48nonbbyvt31kob4hajgmpicw` FOREIGN KEY (`OSOBA`) REFERENCES `osoba` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
