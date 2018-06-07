/*
SQLyog Trial v12.2.4 (32 bit)
MySQL - 5.1.73 : Database - cmdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cmdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cmdemo`;

/*Table structure for table `department_info` */

DROP TABLE IF EXISTS `department_info`;

CREATE TABLE `department_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `department_info` */

insert  into `department_info`(`id`,`dept_name`,`description`) values 
(1,'测试11111','描述111111');

/*Table structure for table `employee_info` */

DROP TABLE IF EXISTS `employee_info`;

CREATE TABLE `employee_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dept_id` (`dept_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `department_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `employee_info` */

insert  into `employee_info`(`id`,`full_name`,`birthday`,`phone_number`,`dept_id`) values 
(1,'张三','1990-09-09 00:00:00','13465259956',1),
(2,'李四','2018-06-07 09:56:01','13930563325',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
