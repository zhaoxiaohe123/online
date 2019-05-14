/*
 Navicat Premium Data Transfer

 Source Server         : 212.64.58.50
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : 212.64.58.50:3306
 Source Schema         : online_examination_system

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 29/03/2019 20:25:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` varchar(32) NOT NULL,
  `subjectId` int(11) DEFAULT NULL,
  `option` varchar(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `flag` bit(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paperSubject
-- ----------------------------
DROP TABLE IF EXISTS `paperSubject`;
CREATE TABLE `paperSubject` (
  `id` varchar(32) NOT NULL,
  `paperId` varchar(32) DEFAULT NULL,
  `subjectId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `difficulty` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `stem` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for testPaper
-- ----------------------------
DROP TABLE IF EXISTS `testPaper`;
CREATE TABLE `testPaper` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `publicTime` datetime DEFAULT NULL,
  `totalScore` int(11) DEFAULT NULL,
  `passScore` int(11) DEFAULT NULL,
  `explain` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `account` varchar(50) DEFAULT NULL,
  `passWord` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userPaper
-- ----------------------------
DROP TABLE IF EXISTS `userPaper`;
CREATE TABLE `userPaper` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `userId` varchar(32) DEFAULT NULL,
  `paperId` varchar(32) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `totalScore` int(11) DEFAULT NULL,
  `actualScore` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userPaperDetail
-- ----------------------------
DROP TABLE IF EXISTS `userPaperDetail`;
CREATE TABLE `userPaperDetail` (
  `id` varchar(32) NOT NULL,
  `userPaperId` varchar(32) DEFAULT NULL,
  `subjectId` int(11) DEFAULT NULL,
  `answer` varchar(10) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
