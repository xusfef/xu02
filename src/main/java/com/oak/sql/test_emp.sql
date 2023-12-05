SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_emp
-- ----------------------------
DROP TABLE IF EXISTS `test_emp`;
CREATE TABLE `test_emp`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职员ID\r\n',
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职员姓名',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别,可选范围[男，女]',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称,可选范围[业务部，后勤部，人事部]',
  `emp_degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历,可选范围[大专，本科，研究生]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_emp
-- ----------------------------
INSERT INTO `test_emp` VALUES (1, '张一', '男', 25, '1', '5');
INSERT INTO `test_emp` VALUES (2, '张二', '女', 26, '3', '5');
INSERT INTO `test_emp` VALUES (3, '张三', '男', 27, '2', '4');
INSERT INTO `test_emp` VALUES (4, '张四', '女', 28, '3', '4');
INSERT INTO `test_emp` VALUES (5, '张五', '男', 29, '2', '4');
INSERT INTO `test_emp` VALUES (6, '张六', '女', 29, '2', '5');
INSERT INTO `test_emp` VALUES (7, '张七', '男', 33, '1', '6');
INSERT INTO `test_emp` VALUES (8, '张八', '男', 32, '1', '5');
INSERT INTO `test_emp` VALUES (9, '张九', '女', 33, '1', '4');
INSERT INTO `test_emp` VALUES (10, '李一', '女', 45, '1', '6');
INSERT INTO `test_emp` VALUES (11, '李二', '女', 19, '3', '5');
INSERT INTO `test_emp` VALUES (12, '李三', '男', 28, '1', '6');
INSERT INTO `test_emp` VALUES (13, '李四', '女', 46, '2', '6');
INSERT INTO `test_emp` VALUES (14, '李五', '男', 58, '1', '4');
INSERT INTO `test_emp` VALUES (15, '李六', '女', 22, '3', '6');
INSERT INTO `test_emp` VALUES (16, '李七', '男', 26, '2', '4');
INSERT INTO `test_emp` VALUES (17, '李八', '男', 25, '3', '6');
INSERT INTO `test_emp` VALUES (18, '李九', '女', 29, '2', '6');
INSERT INTO `test_emp` VALUES (19, '王一', '男', 45, '2', '5');
INSERT INTO `test_emp` VALUES (20, '王二', '女', 21, '1', '5');
INSERT INTO `test_emp` VALUES (21, '王三', '男', 21, '1', '4');
INSERT INTO `test_emp` VALUES (22, '王四', '男', 23, '1', '4');
INSERT INTO `test_emp` VALUES (23, '王五', '女', 33, '1', '4');
INSERT INTO `test_emp` VALUES (24, '王六', '男', 45, '3', '5');
INSERT INTO `test_emp` VALUES (25, '王七', '男', 35, '1', '6');
INSERT INTO `test_emp` VALUES (26, '王八', '男', 41, '2', '5');
INSERT INTO `test_emp` VALUES (27, '王九', '女', 25, '1', '4');
INSERT INTO `test_emp` VALUES (28, '赵一', '男', 26, '3', '6');
INSERT INTO `test_emp` VALUES (29, '赵二', '男', 20, '2', '5');
INSERT INTO `test_emp` VALUES (30, '赵三', '女', 21, '3', '6');
INSERT INTO `test_emp` VALUES (31, '赵四', '男', 19, '2', '6');
INSERT INTO `test_emp` VALUES (32, '赵五', '女', 35, '2', '4');
INSERT INTO `test_emp` VALUES (34, '赵六', '男', 24, '1', '6');
INSERT INTO `test_emp` VALUES (35, '赵七', '男', 29, '1', '4');
INSERT INTO `test_emp` VALUES (36, '赵八', '女', 33, '1', '6');
INSERT INTO `test_emp` VALUES (37, '赵九', '男', 45, '1', '4');

SET FOREIGN_KEY_CHECKS = 1;
