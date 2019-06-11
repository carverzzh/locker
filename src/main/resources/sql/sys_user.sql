/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mixture

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-10 17:11:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) default NULL,
  `useralias` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `phone` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `status` int(11) default NULL,
  `parentId` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
