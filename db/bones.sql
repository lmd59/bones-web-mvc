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
  `ENABLED` tinyint(1) NOT NULL default 1,
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
INSERT INTO `users` (`USERID`,`USERNAME`,`PASSWORD`, `ENABLED`, `FIRSTNAME`, `LASTNAME`, `NICKNAME`, `EMAIL`, `CLASSYEAR`, `POSITION`) VALUES 
 (0000000001,'alex','aardvark',1, 'Alex', 'Archer', 'Gator', 'alex@cornell.edu', '2001', 'secretary'),
 (0000000002,'becca','bear',1, 'Becca', 'Burrows', 'Bex', 'becca@cornell.edu', '2002', 'section leader'),
 (0000000003,'chris','cat',1, 'Chris', 'Castle', 'Masta', 'chris@cornell.edu', '2003', 'conductor'),
 (0000000004,'david','dog',1, 'David', 'Dover', 'Davy', 'david@cornell.edu', '2004', 'head manager'),
 (0000000005,'eric','elephant',1, 'Eric', 'Evans', 'Eman', 'eric@cornell.edu', '2005', 'none');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

--
-- Definition of table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `ROLEID` INT(10) unsigned zerofill NOT NULL auto_increment,
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

--
-- Definition of table `discussions`
--

DROP TABLE IF EXISTS `discussions`;
CREATE TABLE `discussions` (
  `DISCUSSIONID` INT(10) unsigned zerofill NOT NULL auto_increment,
  `TITLE` VARCHAR(45) NOT NULL,
  `STARTDATE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DISCUSSIONID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `discussions`
--

/*!40000 ALTER TABLE `discussions` DISABLE KEYS */;
INSERT INTO `discussions` (DISCUSSIONID, TITLE, STARTDATE)
VALUES (1, 'Homecoming 2013', '4/25/2013 09:10:22'),
  (2, 'Kathryn Emails', '4/25/2013 09:11:22'),
  (3, 'Food Science', '4/25/2013 09:12:22');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `MESSAGEID` INT(10) unsigned zerofill NOT NULL auto_increment,
  `USERID` INT(10) unsigned NOT NULL,
  `DISCUSSIONID` INT(10) unsigned NOT NULL,
  `TITLE` VARCHAR(45) NOT NULL,
  `CONTENT` VARCHAR(500) NOT NULL,
  `CREATEDATE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MESSAGEID`),
  KEY `FK_messages` (`USERID`),
  CONSTRAINT `FK_messages` FOREIGN KEY (`USERID`) REFERENCES `users` (`USERID`),
  KEY `FK_messages2` (`DISCUSSIONID`),
  CONSTRAINT `FK_messages2` FOREIGN KEY (`DISCUSSIONID`) REFERENCES `discussions` (`DISCUSSIONID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- data for table `messages`
--

/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` (MESSAGEID, USERID, DISCUSSIONID, TITLE, CONTENT, CREATEDATE)
VALUES (1, 1, 1, 'Kids Activities', 'There should be things for kids to do.', '04/25/2013 09:22:22'),
  (2, 2, 1, '', 'There should also be wine.', '04/25/2013 09:23:22'),
  (3, 3, 1, 'Chapter House', 'When are we going to Chapter House?', '04/25/2013 09:24:22'),
  (4, 1, 1, '', 'Always!', '04/25/2013 09:25:22'),
  (5, 2, 2, 'Too long', 'Kathryn writes really long emails.', '04/25/2013 09:26:22'),
  (6, 1, 2, '', 'Kathryn can write whatever she wants.', '04/25/2013 09:27:22'),
  (7, 4, 3, 'Bananas', 'Fake banana flavor is subpar.', '04/25/2013 09:28:22');

/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
