/*
Navicat MySQL Data Transfer

Source Server         : 本地环境DB
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-04-20 01:12:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', 'ae005ceb7e9a217cced2f8aa354187c7', 'sy', '0001', '1');
INSERT INTO `tb_admin` VALUES ('2', 'Admin_2', '3a300c48b47b714d9821dc473304aa84', 'AAA', '0002', '0');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
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

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_history_order
-- ----------------------------
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_history_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_promotion
-- ----------------------------
DROP TABLE IF EXISTS `tb_promotion`;
CREATE TABLE `tb_promotion` (
  `promotion_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `pub_date` datetime NOT NULL,
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_promotion
-- ----------------------------
INSERT INTO `tb_promotion` VALUES ('2', '探索澳门金沙度假区', '澳门金沙度假区坐拥7家国际级酒店，包括澳门威尼斯人、澳门巴黎人、澳门金沙城中心康莱德酒店、澳门四季酒店、澳门喜来登金沙城中心大酒店及澳门瑞吉金沙城中心酒店等，合共提供超过12,500间客房及套房。加上位于澳门半岛的澳门金沙，让您随预算选择至合意的住宿，享受更多的快乐！', '2020-04-17 01:58:38');
INSERT INTO `tb_promotion` VALUES ('3', '桔子水晶上海虹桥国展中心纪翟路酒店优惠促销', ' Crystal Orange Hotel (Shanghai Hongqiao National Convention and Exhibition Center Jidi Road)桔子水晶上海虹桥国展中心纪翟路酒店位于闵行区新虹桥板块，距离国家会展中心出租车约5分钟，毗邻临空SOHO商业圈、虹桥商务中心、上海西郊商务区和江桥万达广场大型购物广场。 　　酒店拥有百余间客房，桔子水晶是中国知名的设计师酒店，客房按照高星级配置，包括飞利浦65寸液晶电视、科技智能小度音箱、房间智能客控系统具有人体感应效果，干净舒适，让您舒心安睡整晚。', '2020-04-17 22:42:48');

-- ----------------------------
-- Table structure for tb_reservation
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reservation
-- ----------------------------
INSERT INTO `tb_reservation` VALUES ('1', '0', '2020-04-16 01:04:38', '1', '2020-05-01 12:00:00', 'sy', '1', '1', '1');
INSERT INTO `tb_reservation` VALUES ('2', '2', '2020-04-16 23:34:31', '1', '2020-05-12 12:00:00', 'ww', '1111', '1', '1');
INSERT INTO `tb_reservation` VALUES ('3', '1', '2020-04-18 12:13:37', '1', '2020-05-19 12:20:00', '刘军', '123123123', '1', '8');

-- ----------------------------
-- Table structure for tb_room_catalog
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_catalog`;
CREATE TABLE `tb_room_catalog` (
  `room_catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog` varchar(32) NOT NULL,
  PRIMARY KEY (`room_catalog_id`),
  UNIQUE KEY `catalog` (`catalog`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_catalog
-- ----------------------------
INSERT INTO `tb_room_catalog` VALUES ('5', '主题房');
INSERT INTO `tb_room_catalog` VALUES ('10', '单人床房');
INSERT INTO `tb_room_catalog` VALUES ('1', '双床房');
INSERT INTO `tb_room_catalog` VALUES ('8', '多床房');
INSERT INTO `tb_room_catalog` VALUES ('9', '大床房');
INSERT INTO `tb_room_catalog` VALUES ('6', '特价房');
INSERT INTO `tb_room_catalog` VALUES ('7', '钟点房');

-- ----------------------------
-- Table structure for tb_room_info
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_info
-- ----------------------------
INSERT INTO `tb_room_info` VALUES ('1', '001', '100', '00ec2b2611457ca321366bc10e3775de5b9fa612.png', '豪华双床房', '9999.00', '1', '2', '5');
INSERT INTO `tb_room_info` VALUES ('6', 'B3U7ZD', '27', '6943d00d588c15d69bdd447f934a2fea46acf8dd.jpg', '钟点房', '580.00', '7', '0', '1');
INSERT INTO `tb_room_info` VALUES ('7', 'B8V42', '25', 'e09d7e2ffb3db4bb0f0c16701751e942d17ea0ae.jpg', '特价房', '258.00', '6', '0', '1');
INSERT INTO `tb_room_info` VALUES ('8', 'DDNJ8V', '29', '8f8ae8d460402ad129b189a0e0cd15b056521da4.jpg', '舒适大床房', '2075.00', '9', '1', '2');
INSERT INTO `tb_room_info` VALUES ('9', 'DDNZUA', '46', '3334b3108334560295f0a2be079fa9289125ddd9.jpg', '奇妙大床房', '2192.00', '9', '0', '1');
INSERT INTO `tb_room_info` VALUES ('10', 'D5F0ND', '49', 'e238453ecd63f7baaf07fbc0a7ee02a88aff874d.jpg', '费尔蒙单人床房', '2188.00', '10', '0', '1');
INSERT INTO `tb_room_info` VALUES ('11', '海景大床房', '35', 'default.jpg', '大床房', '699.00', '9', '0', '1');

-- ----------------------------
-- Table structure for tb_room_photo
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_photo`;
CREATE TABLE `tb_room_photo` (
  `room_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_path` varchar(255) NOT NULL,
  `room_info_id` int(11) NOT NULL,
  PRIMARY KEY (`room_photo_id`),
  KEY `room_info_photo_fk` (`room_info_id`),
  CONSTRAINT `room_info_photo_fk` FOREIGN KEY (`room_info_id`) REFERENCES `tb_room_info` (`room_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_photo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'Sy5_aaa', 'e8371eee91fa44d7b05ee79ac850adc3', '754133233@qq.com', '18621278619', 'suny', '男', 'default.jpg', '1');
INSERT INTO `tb_user` VALUES ('2', 'Hq8q_888', '3bdb27b30a846452851a27eb3e22e157', 'hq@qq.con', '18621278619', '黄呗', '女', 'default.jpg', '1');
