/*
SQLyog Community Edition- MySQL GUI v8.14 
MySQL - 5.1.31-community-log : Database - stocknotice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stocknotice` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stocknotice`;

/*Table structure for table `sn_notice` */

DROP TABLE IF EXISTS `sn_notice`;

CREATE TABLE `sn_notice` (
  `notice_id` int(11) NOT NULL COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `stock_id` int(11) NOT NULL COMMENT '股票ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` varchar(500) NOT NULL COMMENT '内容',
  `flag` smallint(6) NOT NULL COMMENT '通知标记：0未发送，1已发送',
  `email_result` tinyint(1) NOT NULL COMMENT '邮件发送结果：0发送失败，1发送成功',
  `sms_result` tinyint(1) NOT NULL COMMENT '短信通知发送结果：0发送失败，1发送成功',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`notice_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sn_notice` */

/*Table structure for table `sn_stock` */

DROP TABLE IF EXISTS `sn_stock`;

CREATE TABLE `sn_stock` (
  `stock_id` int(11) NOT NULL COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `stock_name` varchar(100) DEFAULT NULL COMMENT '股票名',
  `stock_code` varchar(10) NOT NULL COMMENT '股票代码',
  `min_price` float DEFAULT NULL COMMENT '买入价格',
  `max_price` float DEFAULT NULL COMMENT '卖出价格',
  `buy_notice_flag` smallint(6) NOT NULL COMMENT '买入通知标记：0未通知，1已通知',
  `sell_notice_flag` smallint(6) NOT NULL COMMENT '卖出通知标记：0未通知，1已通知',
  PRIMARY KEY (`stock_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sn_stock` */

insert  into `sn_stock`(`stock_id`,`user_id`,`stock_name`,`stock_code`,`min_price`,`max_price`,`buy_notice_flag`,`sell_notice_flag`) values (1,1,'招商银行','SHA:600036',15,20,0,0),(2,1,'华侨城A','SHE:000069',14.5,16,0,0),(3,1,'中国联通','SHA:600050',6,8,0,0),(4,1,'厦门空港','SHA:600897',16,19,0,0),(5,2,'招商银行','SHA:600036',13,20,0,0),(6,3,'马钢股份','SHA:600808',3.56,4.5,0,0);

/*Table structure for table `sn_user` */

DROP TABLE IF EXISTS `sn_user`;

CREATE TABLE `sn_user` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `login` varchar(30) NOT NULL COMMENT '登录帐号',
  `password` varchar(40) NOT NULL COMMENT '登录密码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `mobile_phone_number` varchar(20) NOT NULL COMMENT '手机号码',
  `registered` datetime NOT NULL COMMENT '注册日期',
  `active_code` varchar(20) DEFAULT NULL COMMENT '激活码',
  `state` smallint(6) NOT NULL COMMENT '状态：0未激活，1已激活',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '最后登录IP',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sn_user` */

insert  into `sn_user`(`user_id`,`login`,`password`,`email`,`mobile_phone_number`,`registered`,`active_code`,`state`,`last_login_time`,`last_login_ip`) values (1,'micstart','123456','wangyao1981@gmail.com','13570813200','2009-12-28 09:46:49',NULL,1,NULL,NULL),(2,'lyz','123456','gigi.luck@gmail.com','13570813200','2010-02-22 19:38:15',NULL,1,NULL,NULL),(3,'sunny','123456','sunny@eminentsky.com','13570813200','2010-02-22 19:38:15',NULL,1,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
