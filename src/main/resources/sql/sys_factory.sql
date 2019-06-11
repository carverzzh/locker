/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-10 17:29:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_factory`
-- ----------------------------
DROP TABLE IF EXISTS `sys_factory`;
CREATE TABLE `sys_factory` (
  `id` varchar(50) NOT NULL,
  `factoryName` varchar(50) default NULL,
  `factoryCode` varchar(50) default NULL,
  `manager` varchar(50) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_factory
-- ----------------------------
