-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2014 at 04:59 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE DATABASE IF NOT EXISTS hotelDB;

USE hotelDB;
--
-- Database: `hotelDB`
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `predracun`
--

CREATE TABLE IF NOT EXISTS `predracun` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POPUST` double DEFAULT NULL,
  `REZERVACIJA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lkfuriaufo795amryuiuknc8i` (`REZERVACIJA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID`, `BROJSOBE`, `SPRAT`, `BALKON`, `BROJKREVETA`, `CIJENA`, `ZAUZETA`) VALUES
(1, 1, 4, NULL, 1, 100, b'0');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `zaposlenik`
--

CREATE TABLE IF NOT EXISTS `zaposlenik` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boravak`
--
ALTER TABLE `boravak`
  ADD CONSTRAINT `FK_ee34fstw55nxnadbah0oi8eb7` FOREIGN KEY (`REZERVACIJA`) REFERENCES `rezervacija` (`ID`),
  ADD CONSTRAINT `FK_b253pgyj16a93uql81a2ph1cw` FOREIGN KEY (`GOST`) REFERENCES `gost` (`ID`);

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
  ADD CONSTRAINT `FK_qtetcoxihgf4rvadw1auqw6yw` FOREIGN KEY (`KREIRAOZAPOSLENIK`) REFERENCES `zaposlenik` (`ID`),
  ADD CONSTRAINT `FK_6sknp7ixg72fl1ktr1ji3qtp5` FOREIGN KEY (`SOBA`) REFERENCES `soba` (`ID`);

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
-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2014 at 04:59 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE DATABASE IF NOT EXISTS hotelDB;

USE hotelDB;
--
-- Database: `hotelDB`
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `predracun`
--

CREATE TABLE IF NOT EXISTS `predracun` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POPUST` double DEFAULT NULL,
  `REZERVACIJA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lkfuriaufo795amryuiuknc8i` (`REZERVACIJA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID`, `BROJSOBE`, `SPRAT`, `BALKON`, `BROJKREVETA`, `CIJENA`, `ZAUZETA`) VALUES
(1, 1, 4, NULL, 1, 100, b'0');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `zaposlenik`
--

CREATE TABLE IF NOT EXISTS `zaposlenik` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boravak`
--
ALTER TABLE `boravak`
  ADD CONSTRAINT `FK_ee34fstw55nxnadbah0oi8eb7` FOREIGN KEY (`REZERVACIJA`) REFERENCES `rezervacija` (`ID`),
  ADD CONSTRAINT `FK_b253pgyj16a93uql81a2ph1cw` FOREIGN KEY (`GOST`) REFERENCES `gost` (`ID`);

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
  ADD CONSTRAINT `FK_qtetcoxihgf4rvadw1auqw6yw` FOREIGN KEY (`KREIRAOZAPOSLENIK`) REFERENCES `zaposlenik` (`ID`),
  ADD CONSTRAINT `FK_6sknp7ixg72fl1ktr1ji3qtp5` FOREIGN KEY (`SOBA`) REFERENCES `soba` (`ID`);

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
