/*
 Navicat Premium Data Transfer

 Source Server         : 本地127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 30/03/2021 12:40:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客内容',
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客首图',
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标志',
  `views` int(11) NULL DEFAULT 0 COMMENT '博客浏览次数',
  `appreciation` tinyint(1) NULL DEFAULT 1 COMMENT '是否开启赞赏',
  `commentabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否开启评论',
  `recommend` tinyint(1) NULL DEFAULT 1 COMMENT '是否推荐',
  `share_statement` tinyint(1) NULL DEFAULT 1 COMMENT '是否可转载',
  `published` tinyint(1) NULL DEFAULT 1 COMMENT '是否发布',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `type_id` bigint(20) NOT NULL COMMENT '分类id',
  `tags_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'tagsId',
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1373985196284583939 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (1, '苹果的故事更新测试', '我爱吃苹果吗,爱', 'https://picsum.photos/100/100/?blur=2', '', 0, 1, 1, 1, 1, 1, NULL, '2021-03-22 21:02:02', 1361898722605244417, '', NULL);
INSERT INTO `t_blog` VALUES (1362406420065091586, '测试博客新增保存', '[TOC]\r\n\r\n#### Disabled options\r\n\r\n- TeX (Based on KaTeX);\r\n- Emoji;\r\n- Task lists;\r\n- HTML tags decode;\r\n- Flowchart and Sequence Diagram;\r\n\r\n#### Editor.md directory\r\n\r\n    editor.md/\r\n            lib/\r\n            css/\r\n            scss/\r\n            tests/\r\n            fonts/\r\n            images/\r\n            plugins/\r\n            examples/\r\n            languages/\r\n            editormd.js\r\n            ...\r\n\r\n```html\r\n<!-- English -->\r\n<script src=\"../dist/js/languages/en.js\"></script>\r\n\r\n<!-- 繁體中文 -->\r\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\r\n```\r\n', '', NULL, 0, 1, 1, 1, 1, 1, '2021-02-18 22:19:37', '2021-02-18 22:19:37', 1, '', NULL);
INSERT INTO `t_blog` VALUES (1362682663029239810, '明天就要上班了', '## 明天就要上班了，感觉有点小压力\r\n### 难道这就是传说中的上班前焦虑吗', 'https://picsum.photos/100/100/?blur=2', '原创', 0, 1, 1, 1, 1, 1, '2021-02-19 16:37:19', '2021-02-19 16:37:19', 1361610415828709378, '', 1);
INSERT INTO `t_blog` VALUES (1362686692182511617, '数据库学习', '## mysql数据库学习\r\n###crud\r\n### rucd', 'https://picsum.photos/100/100/?blur=2', '原创', 0, 1, 1, 1, 1, 1, '2021-02-19 16:53:20', '2021-02-19 16:53:20', 1361701653311463425, '', 1);
INSERT INTO `t_blog` VALUES (1362686839842983937, 'redisredis学习', '##reids缓存学习机制\r\n### redis缓存的学习', 'https://picsum.photos/100/100/?blur=2', '原创', 0, 1, 1, 1, 1, 1, '2021-02-19 16:53:55', '2021-02-19 16:53:55', 1361610415828709378, '0,1', 1);
INSERT INTO `t_blog` VALUES (1362689951890788353, '分页测试', '撒的放士大夫', 'https://picsum.photos/100/100/?blur=2', '原创', 0, 1, 1, 1, 1, 1, '2021-02-19 17:06:17', '2021-02-19 17:06:17', 1361705995389112321, '', 1);
INSERT INTO `t_blog` VALUES (1373985196284583938, '陋室铭', '###### 刘禹锡（唐）\r\n山不在高，有仙则名。\r\n水不在深，有龙则灵。\r\n斯是陋室，惟吾德馨。\r\n苔痕上阶绿，草色入帘青。\r\n谈笑有鸿儒，往来无白丁。\r\n可以调素琴，阅金经。\r\n无丝竹之乱耳，无案牍之劳形。\r\n南阳诸葛庐，西蜀子云亭。\r\n孔子云：何陋之有？', 'https://picsum.photos/100/100/?blur=2', '原创', 0, 1, 1, 1, 1, 0, '2021-03-22 21:09:33', '2021-03-22 21:41:56', 1373983643263836162, '1373983584644243457,1373976421955829761', 1);

-- ----------------------------
-- Table structure for t_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_comment`;
CREATE TABLE `t_blog_comment`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `blog_id` int(11) NOT NULL COMMENT '博客id',
  `comment_id` int(11) NOT NULL COMMENT '评论id',
  `create_time` datetime(0)  DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一uid',
  PRIMARY KEY (`uid`, `oid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客评论中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tag`;
CREATE TABLE `t_blog_tag`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `blog_id` int(11) NOT NULL COMMENT '博客id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一uid',
  PRIMARY KEY (`uid`, `oid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客标签中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for t_blog_user
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_user`;
CREATE TABLE `t_blog_user`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `blog_id` int(11) NOT NULL COMMENT '博客id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一uid',
  PRIMARY KEY (`uid`, `oid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客用户中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `parent_comment_id` int(11) NULL DEFAULT NULL COMMENT '父级评论',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1373983584644243458 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1373976421955829761, '分类测试', NULL, '2021-03-22 20:34:40');
INSERT INTO `t_tag` VALUES (1373979214447972353, '1', NULL, NULL);
INSERT INTO `t_tag` VALUES (1373980560555257858, '1234', NULL, NULL);
INSERT INTO `t_tag` VALUES (1373980657233965057, '123456', NULL, NULL);
INSERT INTO `t_tag` VALUES (1373980737890430978, '3442', NULL, NULL);
INSERT INTO `t_tag` VALUES (1373982960695386114, '123667', NULL, NULL);
INSERT INTO `t_tag` VALUES (1373983584644243457, 'tony', NULL, NULL);

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1373983643263836163 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '测试博客列1', NULL, '2021-03-22 19:55:36');
INSERT INTO `t_type` VALUES (1361610415828709378, 'JavaScript', NULL, '2021-02-16 22:55:48');
INSERT INTO `t_type` VALUES (1361694163836395522, 'hrkq', NULL, NULL);
INSERT INTO `t_type` VALUES (1361695115825909762, 'test', NULL, NULL);
INSERT INTO `t_type` VALUES (1361699861441904642, 'contract', NULL, NULL);
INSERT INTO `t_type` VALUES (1361701653311463425, 'ewew', NULL, NULL);
INSERT INTO `t_type` VALUES (1361705995389112321, 'ceshiid', NULL, NULL);
INSERT INTO `t_type` VALUES (1361898722605244417, '1', NULL, NULL);
INSERT INTO `t_type` VALUES (1361898738157723650, '2', NULL, NULL);
INSERT INTO `t_type` VALUES (1373983643263836162, 'tony随笔', NULL, NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '唯一oid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `type` tinyint(1) NULL DEFAULT 1 COMMENT '用户类型',
  `create_time` datetime(0)  DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'sonia', 'sonia', 'e10adc3949ba59abbe56e057f20f883e', 'https://picsum.photos/100/100/?blur=2', 'soniachoo@163.com', 1, NULL, '2021-02-16 11:34:48');

SET FOREIGN_KEY_CHECKS = 1;


STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION