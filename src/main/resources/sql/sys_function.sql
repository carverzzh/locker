/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-12 11:14:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_function`
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `id` varchar(50) NOT NULL,
  `functionName` varchar(50) default NULL,
  `functionCode` varchar(50) default NULL,
  `functionUrl` varchar(50) default NULL,
  `menuId` varchar(50) default NULL,
  `createUser` varchar(50) default NULL,
  `createDate` datetime default NULL,
  `modifyUser` varchar(50) default NULL,
  `modifyDate` datetime default NULL,
  `version` int(11) default NULL,
  `status` int(11) default NULL,
  `remark` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
