/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : work_daily

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-06-18 18:14:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `level` varchar(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `assignuser` varchar(255) DEFAULT NULL,
  `createtime` double DEFAULT NULL,
  `executetime` double DEFAULT NULL,
  `completetime` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('3cab2c52-2523-4035-b3cc-ae6e5886ed14', '正常任务', '111', '完成事项', 'A', 'yuanshuai', 'yuanshuai', '1464870833074', '1464872635993', '1464873441146', '1111');
INSERT INTO `schedule` VALUES ('61f290e3-ec0a-486e-97ec-0608474df392', '紧急任务', 'jjj', '正在进行', 'A', 'yuanshuai', 'yuanshuai', '1464872633656', '1464873438355', '0', '');
INSERT INTO `schedule` VALUES ('9c32ed46-1b80-4c12-80a2-a49e17b5b5d0', '正常任务', '111', '待办事项', 'A', 'yuanshuai', 'yuanshuai', '1464873409669', '0', '0', '111');
INSERT INTO `schedule` VALUES ('d7fd38ac-cc94-4da5-9223-478ad83674d3', '正常任务', '111', '待办事项', 'A', 'yuanshuai', 'yuanshuai', '1464870637156', '0', '0', '1111');
INSERT INTO `schedule` VALUES ('f6f7f9b1-516f-46db-aada-df97bb60e52b', '正常任务', 'sssss', '待办事项', 'A', 'yuanshuai', 'yuanshuai', '1464873298738', '0', '0', 'ssss');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yuanshuai', '1', '23');
