/*
 Navicat Premium Data Transfer

 Source Server         : ET
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : info

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/11/2023 20:00:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_dict
-- ----------------------------
DROP TABLE IF EXISTS `test_dict`;
CREATE TABLE `test_dict`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键\r\n',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `value` int(0) NULL DEFAULT NULL COMMENT '字典值',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_dict
-- ----------------------------
INSERT INTO `test_dict` VALUES (1, 'dept', '业务部', 1, 1);
INSERT INTO `test_dict` VALUES (2, 'dept', '后勤部', 2, 2);
INSERT INTO `test_dict` VALUES (3, 'dept', '人事部', 3, 3);
INSERT INTO `test_dict` VALUES (4, 'degree', '大专', 4, 1);
INSERT INTO `test_dict` VALUES (5, 'degree', '本科', 5, 2);
INSERT INTO `test_dict` VALUES (6, 'degree', '研究生', 6, 3);

SET FOREIGN_KEY_CHECKS = 1;
