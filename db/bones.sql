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
  `USERID` int(10) unsigned zerofill NOT NULL auto_increment,
  `USERNAME` varchar(20) NOT NULL default '',
  `PASSWORD` varchar(20) NOT NULL default '',
  `ENABLED` tinyint(1) NOT NULL default 0,
  `FIRSTNAME` varchar(20) NOT NULL default '',
  `LASTNAME` varchar(20) NOT NULL default '',
  `NICKNAME` varchar(45) NOT NULL default '',
  `EMAIL` varchar(20) NOT NULL default '',
  `CLASSYEAR` varchar(20) NOT NULL default '',
  `POSITION` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`USERID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`USERID`,`USERNAME`,`PASSWORD`, `ENABLED`) VALUES 
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
  `ROLEID` INT(10) unsigned NOT NULL,
  `USERID` INT(10) unsigned NOT NULL,
  `AUTHORITY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ROLEID`),
  KEY `FK_user_roles` (`USERID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USERID`) REFERENCES `users` (`USERID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `user_roles`
--

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (ROLEID, USERID, AUTHORITY)
VALUES (1, 1, 'ROLE_USER'),
  (2, 1, 'ROLE_ADMIN'),
  (3, 1, 'ROLE_SYS_ADMIN'),
  (4, 2, 'ROLE_USER'),
  (5, 2, 'ROLE_ADMIN'),
  (6, 3, 'ROLE_USER'),
  (7, 4, 'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
