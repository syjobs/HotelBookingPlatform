drop database if exists hotel;
create database hotel default charset=utf8;
use hotel;

-- 用户实体表
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(18) NOT NULL,
  `userpass` char(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` char(11) NOT NULL,
  `realname` varchar(32) NOT NULL,
  `gender` char(3) NOT NULL,
  `photo_path` varchar(255) NOT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 管理员实体表
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(18) NOT NULL,
  `userpass` char(32) NOT NULL,
  `realname` varchar(32) NOT NULL,
  `empnum` varchar(12) NOT NULL,
  `super_admin` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `empnum` (`empnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 酒店类别实体表
DROP TABLE IF EXISTS `tb_room_catalog`;
CREATE TABLE `tb_room_catalog` (
  `room_catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog` varchar(32) NOT NULL,
  PRIMARY KEY (`room_catalog_id`),
  UNIQUE KEY `catalog` (`catalog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 房型实体表
DROP TABLE IF EXISTS `tb_room_info`;
CREATE TABLE `tb_room_info` (
  `room_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(32) NOT NULL,
  `area` int(11) NOT NULL,
  `photo_path` varchar(255) NOT NULL,
  `intro` varchar(255) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `room_catalog_id` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`room_info_id`),
  UNIQUE KEY `room_name` (`room_name`),
  KEY `room_info_catalog_fk` (`room_catalog_id`),
  CONSTRAINT `room_info_catalog_fk` FOREIGN KEY (`room_catalog_id`) REFERENCES `tb_room_catalog` (`room_catalog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 存放酒店的展示图片实体表
DROP TABLE IF EXISTS `tb_room_photo`;
CREATE TABLE `tb_room_photo` (
  `room_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_path` varchar(255) NOT NULL,
  `room_info_id` int(11) NOT NULL,
  PRIMARY KEY (`room_photo_id`),
  KEY `room_info_photo_fk` (`room_info_id`),
  CONSTRAINT `room_info_photo_fk` FOREIGN KEY (`room_info_id`) REFERENCES `tb_room_info` (`room_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 酒店预订信息表
DROP TABLE IF EXISTS `tb_reservation`;
CREATE TABLE `tb_reservation` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL,
  `order_time` datetime NOT NULL,
  `days` int(11) NOT NULL DEFAULT '1',
  `check_in_time` datetime NOT NULL,
  `check_in_name` varchar(32) NOT NULL,
  `check_in_phone` char(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `room_info_id` int(11) NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `reservation_user_fk` (`user_id`),
  KEY `reservation_room_info_id_fk` (`room_info_id`),
  CONSTRAINT `reservation_room_info_id_fk` FOREIGN KEY (`room_info_id`) REFERENCES `tb_room_info` (`room_info_id`),
  CONSTRAINT `reservation_user_fk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 历史订单
DROP TABLE IF EXISTS `tb_history_order`;
CREATE TABLE `tb_history_order` (
  `histoty_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  `checkOutDate` datetime NOT NULL,
  PRIMARY KEY (`histoty_order_id`),
  KEY `history_order_admin_fk` (`admin_id`),
  KEY `history_order_reservation_fk` (`reservation_id`),
  CONSTRAINT `history_order_admin_fk` FOREIGN KEY (`admin_id`) REFERENCES `tb_admin` (`admin_id`),
  CONSTRAINT `history_order_reservation_fk` FOREIGN KEY (`reservation_id`) REFERENCES `tb_reservation` (`reservation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 评论实体表
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `pub_date` datetime NOT NULL,
  `room_info_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_user_fk` (`user_id`),
  KEY `comment_room_info_fk` (`room_info_id`),
  CONSTRAINT `comment_room_info_fk` FOREIGN KEY (`room_info_id`) REFERENCES `tb_room_info` (`room_info_id`),
  CONSTRAINT `comment_user_fk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 公告实体表
DROP TABLE IF EXISTS `tb_promotion`;
CREATE TABLE `tb_promotion` (
  `promotion_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `pub_date` datetime NOT NULL,
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8;