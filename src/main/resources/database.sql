/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : supplychain

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 04/03/2022 19:23:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carbon_quota_pledge_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_quota_pledge_records`;
CREATE TABLE `carbon_quota_pledge_records`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `quota_quantity` int NULL DEFAULT NULL,
  `quota_owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pledge_rate` float NULL DEFAULT NULL,
  `pledge_amount` int NULL DEFAULT NULL,
  `loan_term` datetime NULL DEFAULT NULL,
  `loan_interest_rate` float NULL DEFAULT NULL,
  `operation_data` datetime NULL DEFAULT NULL,
  `control_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fund_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL COMMENT '0：提交；1：完成审批；2：机构签约/开具条件；3：完成签约',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carbon_quota_pledge_records
-- ----------------------------
INSERT INTO `carbon_quota_pledge_records` VALUES (1, 10000, '光大石材工程有限公司', '阳光建材有限公司', 0.1, 1000, '2022-03-18 01:00:06', 0.2, '2022-04-01 01:00:19', '阳光牌大理石瓷砖', '1', 0);
INSERT INTO `carbon_quota_pledge_records` VALUES (2, 100002, '光大石材工程有限公司', '阳光建材有限公司', 0.1, 10003, '2022-03-18 01:00:06', 0.2, '2022-04-22 01:00:19', '阳光牌大理石瓷砖', '1', 1);
INSERT INTO `carbon_quota_pledge_records` VALUES (3, 100008, '光大石材工程有限公司', '阳光建材有限公司', 0.1, 1000, '2022-03-29 01:00:06', 0.2, '2022-04-01 01:00:19', '阳光牌大理石瓷砖', '1', 2);
INSERT INTO `carbon_quota_pledge_records` VALUES (4, 100008, '光大石材工程有限公司', '中信实业银行', 0.1, 1000, '2022-03-30 01:00:06', 0.2, '2022-04-01 01:00:19', '阳光牌大理石瓷砖', '1', 0);
INSERT INTO `carbon_quota_pledge_records` VALUES (10, 100, '光大石材工程有限公司', '中信实业银行', 0.1, 1002, '2022-03-08 16:00:00', 0.2, '2022-03-04 07:00:38', '阳光牌大理石瓷砖', NULL, 1);
INSERT INTO `carbon_quota_pledge_records` VALUES (11, 100, '光大石材工程有限公司', '中信实业银行', NULL, NULL, NULL, NULL, NULL, '阳光牌大理石瓷砖', NULL, 0);
INSERT INTO `carbon_quota_pledge_records` VALUES (12, 100, '光大石材工程有限公司', '中信实业银行', NULL, NULL, NULL, NULL, NULL, '阳光牌大理石瓷砖', NULL, 0);
INSERT INTO `carbon_quota_pledge_records` VALUES (13, 100, '光大石材工程有限公司', '中信实业银行', NULL, NULL, NULL, NULL, NULL, '阳光牌大理石瓷砖', NULL, 0);

-- ----------------------------
-- Table structure for carbon_ticket_financing_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_ticket_financing_records`;
CREATE TABLE `carbon_ticket_financing_records`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factoring_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `amount_carbon_ticket` int NULL DEFAULT NULL,
  `financing_amount` int NULL DEFAULT NULL,
  `financing_term` datetime NULL DEFAULT NULL,
  `operation_time` datetime NULL DEFAULT NULL,
  `service_rate` float NULL DEFAULT NULL,
  `interest_rate` float NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL COMMENT '0:申请中，1:通过审核，2:正在签约，3:完成签约，4:失败',
  `fund_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bank` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carbon_ticket_financing_records
-- ----------------------------
INSERT INTO `carbon_ticket_financing_records` VALUES (1, '光大石材工程有限公司', '中信实业银行', 1000, 100, '2022-03-09 01:16:20', '2022-03-11 01:16:23', 0.1, 0.2, 1, '1', '中信实业银行', '光大石材工程有限公司');
INSERT INTO `carbon_ticket_financing_records` VALUES (2, '光大石材工程有限公司', '中信实业银行', 10000, 1002, '2022-03-09 01:16:20', '2022-04-02 01:16:23', 0.1, 0.2, 2, '1', '中信实业银行', '光大石材工程有限公司');
INSERT INTO `carbon_ticket_financing_records` VALUES (3, '光大石材工程有限公司', '中信实业银行', 100005, 1002, '2022-03-21 01:16:20', '2022-04-17 01:16:23', 0.1, 0.2, 3, '1', '中信实业银行', '光大石材工程有限公司');
INSERT INTO `carbon_ticket_financing_records` VALUES (4, '光大石材工程有限公司', '中信实业银行', 100004, 1002, '2022-03-09 01:16:20', '2022-04-23 01:16:23', 0.1, 0.2, 4, '1', '中信实业银行', '光大石材工程有限公司');
INSERT INTO `carbon_ticket_financing_records` VALUES (5, '光大石材工程有限公司', '中信实业银行', 100007, 1002, '2022-03-09 01:16:20', '2022-04-22 01:16:23', 0.1, 0.2, 0, '1', '中信实业银行', '光大石材工程有限公司');
INSERT INTO `carbon_ticket_financing_records` VALUES (6, '云石物联网有限公司', '中信实业银行', 100, 1000, '2022-04-21 16:00:00', '2022-03-04 09:49:03', 0.2, 0.1, 1, NULL, '中信实业银行', '中信实业银行');
INSERT INTO `carbon_ticket_financing_records` VALUES (18, '云石物联网有限公司', '中信实业银行', 100, NULL, NULL, NULL, NULL, NULL, 0, NULL, '中信实业银行', '中信实业银行');
INSERT INTO `carbon_ticket_financing_records` VALUES (19, '云石物联网有限公司', '中信实业银行', 100, NULL, NULL, NULL, NULL, NULL, 0, NULL, '中信实业银行', '中信实业银行');
INSERT INTO `carbon_ticket_financing_records` VALUES (20, '云石物联网有限公司', '中信实业银行', 100, NULL, NULL, NULL, NULL, NULL, 0, NULL, '中信实业银行', '中信实业银行');

-- ----------------------------
-- Table structure for carbon_ticket_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_ticket_records`;
CREATE TABLE `carbon_ticket_records`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `amount_carbon_ticket` int NULL DEFAULT NULL,
  `initiator_supply_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_supply_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `initiator_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operation` int NULL DEFAULT NULL COMMENT '1:创建/2:发行/3:转让/4:回购/5:融资/6:销毁',
  `status` int NULL DEFAULT NULL COMMENT '0:成功，1:取消，2:被拒收，3.已签收',
  `fund_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operation_data` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carbon_ticket_records
-- ----------------------------
INSERT INTO `carbon_ticket_records` VALUES (1, 10, '智能碳核算系统', '智能碳核算系统', '云石物联网有限公司', '绿色管家有限公司', 3, 0, '1', '2023-03-02 01:02:01');
INSERT INTO `carbon_ticket_records` VALUES (2, 50, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '绿色管家有限公司', 3, 1, '2', '2022-03-20 01:01:57');
INSERT INTO `carbon_ticket_records` VALUES (3, 100, '智能碳核算系统', '智能碳核算系统', '云石物联网有限公司', '码农之家信息技术服务有限公司', 3, 1, '3', '2022-01-04 01:01:52');
INSERT INTO `carbon_ticket_records` VALUES (4, 105, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '云石物联网有限公司', 3, 2, '4', '2022-02-16 01:01:47');
INSERT INTO `carbon_ticket_records` VALUES (5, 502, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '绿色管家有限公司', 3, 2, '5', '2022-03-26 01:01:43');
INSERT INTO `carbon_ticket_records` VALUES (6, 150, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '绿色管家有限公司', 3, 3, '6', '2022-04-01 01:01:40');
INSERT INTO `carbon_ticket_records` VALUES (7, 50, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '码农之家信息技术服务有限公司', 6, 1, '7', '2022-03-29 01:01:36');
INSERT INTO `carbon_ticket_records` VALUES (8, 500, '智能碳核算系统', '智能碳核算系统', '码农之家信息技术服务有限公司', '云石物联网有限公司', 4, 0, '888', '2022-03-02 01:01:33');
INSERT INTO `carbon_ticket_records` VALUES (9, 100, '智能碳核算系统', '金融业', '云石物联网有限公司', '中信实业银行', 5, 4, NULL, '2022-03-04 09:45:56');
INSERT INTO `carbon_ticket_records` VALUES (10, 100, '智能碳核算系统', '金融业', '云石物联网有限公司', '中信实业银行', 5, 4, NULL, '2022-03-04 09:49:03');
INSERT INTO `carbon_ticket_records` VALUES (11, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 1, 4, NULL, '2022-03-04 10:53:30');
INSERT INTO `carbon_ticket_records` VALUES (12, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 2, 0, NULL, '2022-03-04 10:54:10');
INSERT INTO `carbon_ticket_records` VALUES (13, 10, '智能碳核算系统', '智能碳核算系统', '绿色管家有限公司', '云石物联网有限公司', 3, 0, NULL, '2022-03-04 10:55:23');
INSERT INTO `carbon_ticket_records` VALUES (14, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 4, 0, NULL, '2022-03-04 11:06:03');
INSERT INTO `carbon_ticket_records` VALUES (15, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 6, 0, NULL, '2022-03-04 11:07:26');
INSERT INTO `carbon_ticket_records` VALUES (16, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 1, 0, NULL, '2022-03-04 11:09:17');
INSERT INTO `carbon_ticket_records` VALUES (17, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 2, 0, NULL, '2022-03-04 11:09:18');
INSERT INTO `carbon_ticket_records` VALUES (18, 10, '智能碳核算系统', '智能碳核算系统', '绿色管家有限公司', '云石物联网有限公司', 3, 0, NULL, '2022-03-04 11:09:37');
INSERT INTO `carbon_ticket_records` VALUES (19, 10, '阳光牌大理石瓷砖', '智能碳核算系统', '阳光建材有限公司', '绿色管家有限公司', 4, 0, NULL, '2022-03-04 11:11:10');

-- ----------------------------
-- Table structure for control_affiliated_company
-- ----------------------------
DROP TABLE IF EXISTS `control_affiliated_company`;
CREATE TABLE `control_affiliated_company`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pledge_application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pledge_signing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_issue` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_repurchase` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `control_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number_carbon_emission` int NULL DEFAULT NULL,
  `catbon_ticket` int NULL DEFAULT NULL,
  `unissued_carbon_ticket` int NULL DEFAULT NULL,
  `repurchased_carbon_ticket` int NULL DEFAULT NULL,
  `blockchain_wallet_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of control_affiliated_company
-- ----------------------------
INSERT INTO `control_affiliated_company` VALUES ('光大石材工程有限公司', 'qwewcadad@163.com', '23456', '2334df', '45634', '3455', '23453', '阳光牌大理石瓷砖', 0, 0, 0, 0, 'dfgjw4587');
INSERT INTO `control_affiliated_company` VALUES ('创浦机械有限公司', 'abcdwacaa@163.com', '12345', '12345', '1235', '12345', '12345', '阳光牌大理石瓷砖', 0, 0, 0, 0, 'asdf456');

-- ----------------------------
-- Table structure for control_chain
-- ----------------------------
DROP TABLE IF EXISTS `control_chain`;
CREATE TABLE `control_chain`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chain_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creation_carbon_ticket` int NULL DEFAULT NULL,
  `member_add` int NULL DEFAULT NULL COMMENT '1:可增减成员；2：不可增减成员',
  `date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of control_chain
-- ----------------------------
INSERT INTO `control_chain` VALUES (1, '阳光牌大理石瓷砖', '阳关建材有限公司', 600042, 2, '2022-12-31 20:39:49');

-- ----------------------------
-- Table structure for control_core_company
-- ----------------------------
DROP TABLE IF EXISTS `control_core_company`;
CREATE TABLE `control_core_company`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `login` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `control_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Chain_relationship` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emission_reduction_plan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_creation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_destruction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pledge_application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pledge_signing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_issue` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_repurchase` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number_carbon_emission` int NULL DEFAULT NULL,
  `carbont_ticket` int NULL DEFAULT NULL,
  `unissued_carbon_ticket` int NULL DEFAULT NULL,
  `repurchased_carbon_ticket` int NULL DEFAULT NULL,
  `blockchain_wallet_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of control_core_company
-- ----------------------------
INSERT INTO `control_core_company` VALUES ('阳光建材有限公司', '123456us78@163.com', '12345', '阳光牌大理石瓷砖', '12345', '12345', '12345', '12345', '12345', '12345', '12345', '12345', 0, 0, -10, 10, 'ABC123');

-- ----------------------------
-- Table structure for financial_institution
-- ----------------------------
DROP TABLE IF EXISTS `financial_institution`;
CREATE TABLE `financial_institution`  (
  `Company_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Login_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Pledge_approval` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Pledge_signing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Factoring_compliance_review` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Factoring_purchase_signing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Carbon_ticket_number` int NULL DEFAULT NULL,
  `Blockchain_wallet_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Company_Name`) USING BTREE,
  UNIQUE INDEX `Company Name`(`Company_Name` ASC) USING BTREE,
  UNIQUE INDEX `Contact email`(`Email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financial_institution
-- ----------------------------
INSERT INTO `financial_institution` VALUES ('中信实业银行', 'xyzswasz@163.com', '123123', '国有', '12312', '123123', '123123', '1233123', 20, '123dsf');
INSERT INTO `financial_institution` VALUES ('梅林银行', 'wzxcdssaw@163.com', 'ww', '外资', 'ww', 'ww', 'ww', 'ww', 0, '3567safv');

-- ----------------------------
-- Table structure for reduce_affiliated_company
-- ----------------------------
DROP TABLE IF EXISTS `reduce_affiliated_company`;
CREATE TABLE `reduce_affiliated_company`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_tranfer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `financing_application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `financing_contract` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reduce_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_balance` int NULL DEFAULT NULL,
  `blockchain_wallet_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reduce_affiliated_company
-- ----------------------------
INSERT INTO `reduce_affiliated_company` VALUES ('云石物联网有限公司', 'nadfaf@163.com', '666', '666', '666', '23435', '12345', '智能碳核算系统', 0, 'sgdyuge239dh');
INSERT INTO `reduce_affiliated_company` VALUES ('码农之家信息技术服务有限公司', 'pafdsan@163.com', '555', '555', '555', '12455', '12433', '智能碳核算系统', 0, 'dahjd86A');

-- ----------------------------
-- Table structure for reduce_chain
-- ----------------------------
DROP TABLE IF EXISTS `reduce_chain`;
CREATE TABLE `reduce_chain`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `member_add` int NULL DEFAULT NULL COMMENT '1:可增减成员；2：不可增减成员',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reduce_chain
-- ----------------------------
INSERT INTO `reduce_chain` VALUES (1, '智能碳核算系统', '绿色管家有限公司', 2);

-- ----------------------------
-- Table structure for reduce_core_company
-- ----------------------------
DROP TABLE IF EXISTS `reduce_core_company`;
CREATE TABLE `reduce_core_company`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reduce_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Login` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_transfer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `financial_application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `financing_contract` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chain_affiliate_relationship` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carbon_ticket_balance` int NULL DEFAULT NULL,
  `blockchain_wallet_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reduce_core_company
-- ----------------------------
INSERT INTO `reduce_core_company` VALUES ('绿色管家有限公司', 'zdsafa@163.com', '智能碳核算系统', '12355', '12455', '12355', '12345', '12345', '1234', 0, 'dhe346');

-- ----------------------------
-- Table structure for reduce_plan
-- ----------------------------
DROP TABLE IF EXISTS `reduce_plan`;
CREATE TABLE `reduce_plan`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `control_chain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `amount_reduce` int NULL DEFAULT NULL,
  `declaration_carbon_ticket` int NULL DEFAULT NULL,
  `year` date NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reduce_plan
-- ----------------------------
INSERT INTO `reduce_plan` VALUES (10, '阳光牌大理石瓷', NULL, 3, 2, '2022-03-03');
INSERT INTO `reduce_plan` VALUES (11, '阳光牌大理石瓷砖', NULL, 3, 2, '2022-03-03');
INSERT INTO `reduce_plan` VALUES (13, '阳光牌大理石瓷砖', 'X', 3, 2, '2022-03-15');
INSERT INTO `reduce_plan` VALUES (14, '阳光牌大理石瓷砖', 'null', 3, 2, '2022-03-03');
INSERT INTO `reduce_plan` VALUES (15, '阳光牌大理石瓷砖', 'n', 3, 2, '2022-03-03');
INSERT INTO `reduce_plan` VALUES (16, '阳光牌大理石瓷砖', NULL, 3, 2, '2022-03-03');
INSERT INTO `reduce_plan` VALUES (17, '阳光牌大理石瓷砖', NULL, 3, 2, '2022-03-15');

SET FOREIGN_KEY_CHECKS = 1;
