-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema contacts
--

CREATE DATABASE IF NOT EXISTS bones;
USE bones;

--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` int(10) unsigned zerofill NOT NULL auto_increment,
  `userName` varchar(20) NOT NULL default '',
  `userPassword` varchar(20) NOT NULL default '',
  `enabled` tinyint(1) NOT NULL default 0,
  PRIMARY KEY  (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userID`,`userName`,`userPassword`, `enabled`) VALUES 
 (0000000001,'alex','aardvark',1),
 (0000000002,'becca','bear',1),
 (0000000003,'chris','cat',1),
 (0000000004,'david','dog',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

--
-- Definition of table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `roleID` int(10) unsigned NOT NULL,
  `userID` int(10) unsigned NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`roleID`),
  KEY `FK_user_roles` (`userID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `user_roles`
--

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (roleID, userID, authority)
VALUES (1, 1, 'role_user'),
  (2, 1, 'role_admin'),
  (3, 1, 'role_sys_admin'),
  (4, 2, 'role_user'),
  (5, 2, 'role_admin'),
  (6, 3, 'role_user'),
  (7, 4, 'role_user');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
