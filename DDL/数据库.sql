create database blogs;

use blogs;

CREATE TABLE `user` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `IDENTITY` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `log` (
  `LOID` int(11) NOT NULL AUTO_INCREMENT,
  `USER` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `RESULT` varchar(255) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `OBJECT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LOID`),
  KEY `FK_h7y4a33wlgeyeb2qviyi15vb1` (`USER`),
  CONSTRAINT `FK_h7y4a33wlgeyeb2qviyi15vb1` FOREIGN KEY (`USER`) REFERENCES `user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `category` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `article` (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `TEXT` longtext,
  `CATEGORY` int(11) DEFAULT NULL,
  `VIEW` int(11) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AID`),
  KEY `FK_s9o4skwe6gu5sy1khbke121sg` (`CATEGORY`),
  CONSTRAINT `FK_s9o4skwe6gu5sy1khbke121sg` FOREIGN KEY (`CATEGORY`) REFERENCES `category` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `message` (
  `MID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `TEXT` varchar(255) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `ARTICLE` int(11) DEFAULT NULL,
  `parentmid` int(11) DEFAULT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  PRIMARY KEY (`MID`),
  KEY `FK_qxwgmm0fp9k31s5a73njrlc74` (`ARTICLE`),
  KEY `FK_r5o6e80n21yavydsxhhc16nvi` (`parentmid`),
  CONSTRAINT `FK_qxwgmm0fp9k31s5a73njrlc74` FOREIGN KEY (`ARTICLE`) REFERENCES `article` (`AID`),
  CONSTRAINT `FK_r5o6e80n21yavydsxhhc16nvi` FOREIGN KEY (`parentmid`) REFERENCES `message` (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `label` (
  `LID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `article_label` (
  `Article_ID` int(11) NOT NULL,
  `Label_ID` int(11) NOT NULL,
  PRIMARY KEY (`Article_ID`,`Label_ID`),
  KEY `FK_ehubpgk3i4roo3su0jsm1f40q` (`Label_ID`),
  CONSTRAINT `FK_ehubpgk3i4roo3su0jsm1f40q` FOREIGN KEY (`Label_ID`) REFERENCES `label` (`LID`),
  CONSTRAINT `FK_rtoi08lbaadw0wvuubow0e5pr` FOREIGN KEY (`Article_ID`) REFERENCES `article` (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into user(uid,name,password,identity) values(1,'admin','21232f297a57a5a743894a0e4a801fc3','π‹¿Ì‘±');
insert into user(uid,name,password,identity) values(2,'test','098f6bcd4621d373cade4e832627b4f6','≤‚ ‘');