/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-11 17:21:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL,
  `menuName` varchar(50) default NULL,
  `menuCode` varchar(50) default NULL,
  `menuUrl` varchar(50) default NULL,
  `parentId` varchar(50) default NULL,
  `sequence` int(11) default NULL,
  `level` int(11) default NULL,
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
-- Records of sys_menu
-- ----------------------------
