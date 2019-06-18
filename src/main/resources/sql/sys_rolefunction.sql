/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-15 09:58:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_rolefunction`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rolefunction`;
CREATE TABLE `sys_rolefunction` (
  `id` varchar(50) NOT NULL,
  `functionId` varchar(50) default NULL,
  `roleMenuId` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_rolefunction
-- ----------------------------
