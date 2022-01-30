create database library;

use library;

CREATE TABLE `library`.`books` (
  `callno` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `publisher` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`callno`));
  
  select * from books;
  
  CREATE TABLE IF NOT EXISTS `issuebooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookcallno` varchar(50) NOT NULL,
  `studentid` int(11) NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  `issueddate` date not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

select * from issuebooks;
