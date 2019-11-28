/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : security_test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/11/2019 15:22:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mgt_group
-- ----------------------------
DROP TABLE IF EXISTS `mgt_group`;
CREATE TABLE `mgt_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '团队id',
  `group_name` varchar(45) DEFAULT NULL COMMENT '团队名称',
  `user_create` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `user_modified` bigint(20) DEFAULT NULL COMMENT '修改用户',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `mark_deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_group_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `mgt_group_user_role_relation`;
CREATE TABLE `mgt_group_user_role_relation` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '群组id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id\nrole_id = 0 owner 为群主',
  `user_create` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `user_modified` bigint(20) DEFAULT NULL COMMENT '修改用户',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`group_id`,`user_id`,`role_id`) USING BTREE,
  KEY `_group_user_id_idx` (`user_id`) USING BTREE,
  KEY `_group_role_id_idx` (`role_id`) USING BTREE,
  CONSTRAINT `mgt_group_user_role_relation_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `mgt_group` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mgt_group_user_role_relation_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `mgt_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mgt_group_user_role_relation_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `mgt_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_operation
-- ----------------------------
DROP TABLE IF EXISTS `mgt_operation`;
CREATE TABLE `mgt_operation` (
  `operation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operation_name` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `operation_desc` varchar(50) DEFAULT NULL,
  `request_url` varchar(100) DEFAULT NULL COMMENT '请求路径',
  `permission_id` bigint(20) DEFAULT NULL,
  `perm` varchar(50) DEFAULT NULL COMMENT '接口注解',
  `route` varchar(45) DEFAULT NULL,
  `type` tinyint(4) DEFAULT '1' COMMENT '0路由,1按钮',
  `operation_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`operation_id`) USING BTREE,
  KEY `_operation_permission_id_idx` (`permission_id`) USING BTREE,
  CONSTRAINT `mgt_operation_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `mgt_permission` (`permission_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_permission
-- ----------------------------
DROP TABLE IF EXISTS `mgt_permission`;
CREATE TABLE `mgt_permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `user_create` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `user_modified` bigint(20) DEFAULT NULL COMMENT '修改用户',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `dependency_id` bigint(20) DEFAULT NULL COMMENT '依赖id',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `permission_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_role
-- ----------------------------
DROP TABLE IF EXISTS `mgt_role`;
CREATE TABLE `mgt_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id\n\n超级管理员\nowner\n',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(50) DEFAULT NULL,
  `user_create` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `user_modified` bigint(20) DEFAULT NULL COMMENT '修改用户',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `permission_code_set` int(11) DEFAULT NULL COMMENT '权限2进制和',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `mgt_role_permission_relation`;
CREATE TABLE `mgt_role_permission_relation` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `user_create` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `user_modified` bigint(20) DEFAULT NULL COMMENT '修改用户',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE,
  KEY `_role_permission_id_idx` (`permission_id`) USING BTREE,
  CONSTRAINT `mgt_role_permission_relation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `mgt_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mgt_role_permission_relation_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `mgt_permission` (`permission_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mgt_user
-- ----------------------------
DROP TABLE IF EXISTS `mgt_user`;
CREATE TABLE `mgt_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `area_code` varchar(45) DEFAULT '+86',
  `phone` varchar(45) DEFAULT NULL,
  `regist_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态：1，正常；2，试用；3，失效',
  `mark_deleted` tinyint(1) DEFAULT '0',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最近更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_pic` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
