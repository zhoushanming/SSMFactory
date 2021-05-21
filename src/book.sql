/*
Navicat MySQL Data Transfer

Source Server         : EE
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-07-04 17:10:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coatingmachine
-- ----------------------------
DROP TABLE IF EXISTS `coatingmachine`;
CREATE TABLE `coatingmachine` (
  `id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `itemId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of coatingmachine
-- ----------------------------

-- ----------------------------
-- Table structure for drawingmachine
-- ----------------------------
DROP TABLE IF EXISTS `drawingmachine`;
CREATE TABLE `drawingmachine` (
  `id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `itemId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of drawingmachine
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int primary key auto_increment,
  `state` int DEFAULT NULL,
  `mouldId` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `drawingMachineId` int DEFAULT NULL,
  `coatingMachineId` int DEFAULT NULL,
  `curentState` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for mould
-- ----------------------------
DROP TABLE IF EXISTS `mould`;
CREATE TABLE `mould` (
  `id` int auto_increment,
  `radius` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mould
-- ----------------------------

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int primary key auto_increment,
  `amount` int DEFAULT NULL,
  `spec` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of plan
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int primary key auto_increment,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('116', '12345', '骆世尧');
INSERT INTO `staff` VALUES ('113', '12345', '周善明');
INSERT INTO `staff` VALUES ('114', '12345', '赵叶勇');


insert into drawingmachine(id,status)values(1,0);
insert into drawingmachine(id,status)values(2,0);
insert into drawingmachine(id,status)values(3,0);
insert into drawingmachine(id,status)values(4,0);
insert into drawingmachine(id,status)values(5,0);
insert into drawingmachine(id,status)values(6,0);
insert into drawingmachine(id,status)values(7,0);
insert into drawingmachine(id,status)values(8,0);
insert into drawingmachine(id,status)values(9,0);
insert into drawingmachine(id,status)values(10,0);
insert into drawingmachine(id,status)values(11,0);
insert into drawingmachine(id,status)values(12,0);
insert into drawingmachine(id,status)values(13,0);
insert into drawingmachine(id,status)values(14,0);
insert into drawingmachine(id,status)values(15,0);
insert into drawingmachine(id,status)values(16,0);
insert into drawingmachine(id,status)values(17,0);
insert into drawingmachine(id,status)values(18,0);
insert into drawingmachine(id,status)values(19,0);
insert into drawingmachine(id,status)values(20,0);

delete from coatingmachine;
insert into coatingmachine(id,status)values(1,0);
insert into coatingmachine(id,status)values(2,0);
insert into coatingmachine(id,status)values(3,0);
insert into coatingmachine(id,status)values(4,0);
insert into coatingmachine(id,status)values(5,0);
insert into coatingmachine(id,status)values(6,0);
insert into coatingmachine(id,status)values(7,0);
insert into coatingmachine(id,status)values(8,0);
insert into coatingmachine(id,status)values(9,0);
insert into coatingmachine(id,status)values(10,0);
insert into coatingmachine(id,status)values(11,0);
insert into coatingmachine(id,status)values(12,0);
insert into coatingmachine(id,status)values(13,0);
insert into coatingmachine(id,status)values(14,0);
insert into coatingmachine(id,status)values(15,0);
