/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 26/02/2022 18:29:34
*/
DROP DATABASE IF EXISTS SupplyChain;
CREATE DATABASE SupplyChain;
use SupplyChain;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carbon_quota_pledge_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_quota_pledge_records`;
CREATE TABLE `carbon_quota_pledge_records`  (
                                                `ID` int NOT NULL AUTO_INCREMENT,
                                                `quota_quantity` int NULL DEFAULT NULL,
                                                `quota_owner` varchar(255)  NULL DEFAULT NULL,
                                                `company` varchar(255)  NULL DEFAULT NULL,
                                                `pledge_rate` float NULL DEFAULT NULL,
                                                `pledge_amount` int NULL DEFAULT NULL,
                                                `loan_term` datetime NULL DEFAULT NULL,
                                                `loan_interest_rate` float NULL DEFAULT NULL,
                                                `operation_data` datetime NULL DEFAULT NULL,
                                                `control_chain` varchar(255)  NULL DEFAULT NULL,
                                                `fund_use` varchar(255)  NULL DEFAULT NULL,
                                                `condition` int NULL DEFAULT NULL COMMENT '0：提交；1：完成审批；2：完成签约',
                                                PRIMARY KEY (`ID`) USING BTREE
) AUTO_INCREMENT = 1 ENGINE = InnoDB;

-- ----------------------------
-- Records of carbon_quota_pledge_records
-- ----------------------------

-- ----------------------------
-- Table structure for carbon_ticket_financing_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_ticket_financing_records`;
CREATE TABLE `carbon_ticket_financing_records`  (
                                                    `ID` int NOT NULL AUTO_INCREMENT,
                                                    `company` varchar(255)  NULL DEFAULT NULL,
                                                    `factoring_company` varchar(255)  NULL DEFAULT NULL,
                                                    `amount_carbon_ticket` int NULL DEFAULT NULL,
                                                    `financing_amount` int NULL DEFAULT NULL,
                                                    `financing_term` datetime NULL DEFAULT NULL,
                                                    `operation_time` datetime NULL DEFAULT NULL,
                                                    `service_rate` float NULL DEFAULT NULL,
                                                    `interest_rate` float NULL DEFAULT NULL,
                                                    `condition` int NULL DEFAULT NULL COMMENT '1:申请中，2:通过审核，3:正在签约，4:完成签约，5:失败',
                                                    `fund_use` varchar(255)  NULL DEFAULT NULL,
                                                    `bank` varchar(255)  NULL DEFAULT NULL,
                                                    `account` varchar(255)  NULL DEFAULT NULL,
                                                    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of carbon_ticket_financing_records
-- ----------------------------

-- ----------------------------
-- Table structure for carbon_ticket_records
-- ----------------------------
DROP TABLE IF EXISTS `carbon_ticket_records`;
CREATE TABLE `carbon_ticket_records`  (
                                          `ID` int NOT NULL AUTO_INCREMENT,
                                          `amount_carbon_ticket` int NULL DEFAULT NULL,
                                          `initiator_supply_chain` varchar(255)  NULL DEFAULT NULL,
                                          `receiver_supply_chain` varchar(255)  NULL DEFAULT NULL,
                                          `initiator_name` varchar(255)  NULL DEFAULT NULL,
                                          `receiver_name` varchar(255)  NULL DEFAULT NULL,
                                          `operation` int NULL DEFAULT NULL COMMENT '1:创建/2:发行/3:转让/4:回购/5:融资/6:销毁',
                                          `condition` int NULL DEFAULT NULL COMMENT '1:成功，2:取消，3:被拒收，4.已签收',
                                          `fund_use` varchar(255)  NULL DEFAULT NULL,
                                          `operation_data` datetime NULL DEFAULT NULL,
                                          PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of carbon_ticket_records
-- ----------------------------

-- ----------------------------
-- Table structure for control_affiliated_company
-- ----------------------------
DROP TABLE IF EXISTS `control_affiliated_company`;
CREATE TABLE `control_affiliated_company`  (
                                               `name` varchar(255)  NOT NULL,
                                               `email` varchar(255)  NULL DEFAULT NULL,
                                               `login` varchar(255)  NULL DEFAULT NULL,
                                               `pledge_application` varchar(255)  NULL DEFAULT NULL,
                                               `pledge_signing` varchar(255)  NULL DEFAULT NULL,
                                               `carbon_ticket_issue` varchar(255)  NULL DEFAULT NULL,
                                               `carbon_ticket_repurchase` varchar(255)  NULL DEFAULT NULL,
                                               `control_chain` varchar(255)  NULL DEFAULT NULL,
                                               `number_carbon_emission` int NULL DEFAULT NULL,
                                               `catbon_ticket` int NULL DEFAULT NULL,
                                               `unissued_carbon_ticket` int NULL DEFAULT NULL,
                                               `repurchased_carbon_ticket` int NULL DEFAULT NULL,
                                               `blockchain_wallet_key` varchar(255)  NULL DEFAULT NULL,
                                               PRIMARY KEY (`name`) USING BTREE,
                                               UNIQUE INDEX `name`(`name` ASC) USING BTREE,
                                               UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of control_affiliated_company
-- ----------------------------
INSERT INTO `control_affiliated_company` VALUES ('创浦机械有限公司', 'abcdwacaa@163.com', '12345', '12345', '1235', '12345', '12345', '阳光牌大理石瓷砖', 0, 0, 0, 0, 'asdf456');
INSERT INTO `control_affiliated_company` VALUES ('光大石材工程有限公司', 'qwewcadad@163.com', '23456', '2334df', '45634', '3455', '23453', '阳光牌大理石瓷砖', 0, 0, 0, 0, 'dfgjw4587');

-- ----------------------------
-- Table structure for control_chain
-- ----------------------------
DROP TABLE IF EXISTS `control_chain`;
CREATE TABLE `control_chain`  (
                                  `ID` int NOT NULL AUTO_INCREMENT,
                                  `name` varchar(255)  NULL DEFAULT NULL,
                                  `chain_company` varchar(255)  NULL DEFAULT NULL,
                                  `creation_carbon_ticket` int NULL DEFAULT NULL,
                                  `member_add` int NULL DEFAULT NULL COMMENT '1:可增减成员；2：不可增减成员',
                                  `date` datetime NULL DEFAULT NULL,
                                  PRIMARY KEY (`ID`) USING BTREE,
                                  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of control_chain
-- ----------------------------
INSERT INTO `control_chain` VALUES (1, '阳光牌大理石瓷砖', '阳关建材有限公司', 0, 2, '2022-12-31 20:39:49');

-- ----------------------------
-- Table structure for control_core_company
-- ----------------------------
DROP TABLE IF EXISTS `control_core_company`;
CREATE TABLE `control_core_company`  (
                                         `name` varchar(255)  NOT NULL,
                                         `email` varchar(255)  NOT NULL,
                                         `login` varchar(255)  NULL DEFAULT NULL,
                                         `control_chain` varchar(255)  NULL DEFAULT NULL,
                                         `Chain_relationship` varchar(255)  NULL DEFAULT NULL,
                                         `emission_reduction_plan` varchar(255)  NULL DEFAULT NULL,
                                         `carbon_ticket_creation` varchar(255)  NULL DEFAULT NULL,
                                         `carbon_ticket_destruction` varchar(255)  NULL DEFAULT NULL,
                                         `pledge_application` varchar(255)  NULL DEFAULT NULL,
                                         `pledge_signing` varchar(255)  NULL DEFAULT NULL,
                                         `carbon_ticket_issue` varchar(255)  NULL DEFAULT NULL,
                                         `carbon_ticket_repurchase` varchar(255)  NULL DEFAULT NULL,
                                         `number_carbon_emission` int NULL DEFAULT NULL,
                                         `carbont_ticket` int NULL DEFAULT NULL,
                                         `unissued_carbon_ticket` int NULL DEFAULT NULL,
                                         `repurchased_carbon_ticket` int NULL DEFAULT NULL,
                                         `blockchain_wallet_key` varchar(255)  NULL DEFAULT NULL,
                                         PRIMARY KEY (`name`) USING BTREE,
                                         UNIQUE INDEX `name`(`name` ASC) USING BTREE,
                                         UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of control_core_company
-- ----------------------------
INSERT INTO `control_core_company` VALUES ('阳光建材有限公司', '123456us78@163.com', '12345', '阳光牌大理石瓷砖', '12345', '12345', '12345', '12345', '12345', '12345', '12345', '12345', 0, 0, 0, 0, 'ABC123');

-- ----------------------------
-- Table structure for financial_institution
-- ----------------------------
DROP TABLE IF EXISTS `financial_institution`;
CREATE TABLE `financial_institution`  (
                                          `Company_Name` varchar(255)  NOT NULL,
                                          `Email` varchar(255)  NULL DEFAULT NULL,
                                          `Login_password` varchar(255)  NULL DEFAULT NULL,
                                          `Classification` varchar(255)  NULL DEFAULT NULL,
                                          `Pledge_approval` varchar(255)  NULL DEFAULT NULL,
                                          `Pledge_signing` varchar(255)  NULL DEFAULT NULL,
                                          `Factoring_compliance_review` varchar(255)  NULL DEFAULT NULL,
                                          `Factoring_purchase_signing` varchar(255)  NULL DEFAULT NULL,
                                          `Carbon_ticket_number` int NULL DEFAULT NULL,
                                          `Blockchain_wallet_key` varchar(255)  NULL DEFAULT NULL,
                                          PRIMARY KEY (`Company_Name`) USING BTREE,
                                          UNIQUE INDEX `Company Name`(`Company_Name` ASC) USING BTREE,
                                          UNIQUE INDEX `Contact email`(`Email` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of financial_institution
-- ----------------------------
INSERT INTO `financial_institution` VALUES ('中信实业银行', 'xyzswasz@163.com', '123123', '国有', '12312', '123123', '123123', '1233123', 0, '123dsf');
INSERT INTO `financial_institution` VALUES ('梅林银行', 'wzxcdssaw@163.com', 'ww', '外资', 'ww', 'ww', 'ww', 'ww', 0, '3567safv');

-- ----------------------------
-- Table structure for reduce_affiliated_company
-- ----------------------------
DROP TABLE IF EXISTS `reduce_affiliated_company`;
CREATE TABLE `reduce_affiliated_company`  (
                                              `name` varchar(255)  NULL DEFAULT NULL,
                                              `email` varchar(255)  NULL DEFAULT NULL,
                                              `login` varchar(255)  NULL DEFAULT NULL,
                                              `carbon_ticket_tranfer` varchar(255)  NULL DEFAULT NULL,
                                              `carbon_ticket_sign` varchar(255)  NULL DEFAULT NULL,
                                              `financing_application` varchar(255)  NULL DEFAULT NULL,
                                              `financing_contract` varchar(255)  NULL DEFAULT NULL,
                                              `reduce_chain` varchar(255)  NULL DEFAULT NULL,
                                              `carbon_ticket_balance` int NULL DEFAULT NULL,
                                              `blockchain_wallet_key` varchar(255)  NULL DEFAULT NULL,
                                              UNIQUE INDEX `name`(`name` ASC) USING BTREE,
                                              UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of reduce_affiliated_company
-- ----------------------------
INSERT INTO `reduce_affiliated_company` VALUES ('码农之家信息技术服务有限公司', 'pafdsan@163.com', '555', '555', '555', '12455', '12433', '智能碳核算系统', 0, 'dahjd86A');
INSERT INTO `reduce_affiliated_company` VALUES ('云石物联网有限公司', 'nadfaf@163.com', '666', '666', '666', '23435', '12345', '智能碳核算系统', 0, 'sgdyuge239dh');

-- ----------------------------
-- Table structure for reduce_chain
-- ----------------------------
DROP TABLE IF EXISTS `reduce_chain`;
CREATE TABLE `reduce_chain`  (
                                 `ID` int NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255)  NULL DEFAULT NULL,
                                 `company` varchar(255)  NULL DEFAULT NULL,
                                 `member_add` int NULL DEFAULT NULL COMMENT '1:可增减成员；2：不可增减成员',
                                 PRIMARY KEY (`ID`) USING BTREE,
                                 INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of reduce_chain
-- ----------------------------
INSERT INTO `reduce_chain` VALUES (1, '智能碳核算系统', '绿色管家有限公司', 2);

-- ----------------------------
-- Table structure for reduce_core_company
-- ----------------------------
DROP TABLE IF EXISTS `reduce_core_company`;
CREATE TABLE `reduce_core_company`  (
                                        `Name` varchar(255)  NULL DEFAULT NULL,
                                        `Email` varchar(255)  NULL DEFAULT NULL,
                                        `reduce_chain` varchar(255)  NULL DEFAULT NULL,
                                        `Login` varchar(255)  NULL DEFAULT NULL,
                                        `carbon_ticket_sign` varchar(255)  NULL DEFAULT NULL,
                                        `carbon_ticket_transfer` varchar(255)  NULL DEFAULT NULL,
                                        `financial_application` varchar(255)  NULL DEFAULT NULL,
                                        `financing_contract` varchar(255)  NULL DEFAULT NULL,
                                        `chain_affiliate_relationship` varchar(255)  NULL DEFAULT NULL,
                                        `carbon_ticket_balance` int NULL DEFAULT NULL,
                                        `blockchain_wallet_key` varchar(255)  NULL DEFAULT NULL,
                                        UNIQUE INDEX `name`(`Name` ASC) USING BTREE,
                                        UNIQUE INDEX `email`(`Email` ASC) USING BTREE
) ENGINE = InnoDB;

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
                                `control_chain` varchar(255)  NULL DEFAULT NULL,
                                `company` varchar(255)  NULL DEFAULT NULL,
                                `amount_reduce` int NULL DEFAULT NULL,
                                `declaration_carbon_ticket` int NULL DEFAULT NULL,
                                `year` date NULL DEFAULT NULL,
                                PRIMARY KEY (`ID`) USING BTREE,
                                UNIQUE INDEX `name`(`control_chain` ASC) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of reduce_plan
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
set character_set_results=gb2312;
