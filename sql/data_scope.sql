/*
Navicat MySQL Data Transfer

Source Server         : 192.168.31.33
Source Server Version : 50718
Source Host           : 192.168.31.33:3306
Source Database       : data_scope

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2021-07-07 09:45:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_user` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(100) DEFAULT NULL,
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '科室',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', null, '2021-07-06 05:28:15', null, '2021-07-06 05:28:15', '总科室', null, '0');
INSERT INTO `t_dept` VALUES ('2', null, '2021-07-06 05:28:24', null, '2021-07-06 05:28:24', '科室一', null, '1');
INSERT INTO `t_dept` VALUES ('3', null, '2021-07-06 05:28:30', null, '2021-07-06 05:28:30', '科室二', null, '1');
INSERT INTO `t_dept` VALUES ('4', null, '2021-07-06 05:28:47', null, '2021-07-06 05:28:47', '科室一（1）', null, '2');
INSERT INTO `t_dept` VALUES ('5', null, '2021-07-06 05:29:03', null, '2021-07-06 05:29:03', '科室一（2）', null, '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_user` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modify_user` varchar(100) DEFAULT NULL,
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `data_scope` varchar(11) DEFAULT '0' COMMENT '数据类型',
  `dept_id` bigint(20) DEFAULT '0' COMMENT '科室',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', null, '2021-07-06 05:29:17', null, '2021-07-06 05:29:17', '张三', null, '0', '1', '1');
INSERT INTO `t_user` VALUES ('2', null, '2021-07-06 05:29:24', null, '2021-07-06 05:29:24', '李四', null, '0', '3', '2');
INSERT INTO `t_user` VALUES ('3', null, '2021-07-06 05:29:33', null, '2021-07-06 05:29:33', '王五', null, '0', '2', '3');
INSERT INTO `t_user` VALUES ('4', null, '2021-07-06 05:29:43', null, '2021-07-06 05:29:43', '小明', null, '0', '5', '4');
INSERT INTO `t_user` VALUES ('5', null, '2021-07-06 05:29:49', null, '2021-07-06 05:29:49', '小红', null, '0', '2', '5');
INSERT INTO `t_user` VALUES ('6', null, '2021-07-06 11:09:32', null, '2021-07-06 11:09:32', '小白', null, '0', '4', '2');
INSERT INTO `t_user` VALUES ('8', null, '2021-07-06 11:10:41', null, '2021-07-06 11:10:41', '小黑', null, '0', '5', '2');
