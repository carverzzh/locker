/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-05 16:42:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_demo`
-- ----------------------------
DROP TABLE IF EXISTS `sys_demo`;
CREATE TABLE `sys_demo` (
  `id` varchar(50) NOT NULL,
  `demo` varchar(50) default NULL,
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
-- Records of sys_demo
-- ----------------------------
INSERT INTO `sys_demo` VALUES ('1', '1', '1', '2019-06-05 16:40:54', '1', '2019-06-05 16:40:57', '1', '1', '1');
