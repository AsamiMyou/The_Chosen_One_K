/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.2.0.1.0

Source Server         : 西安文理
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : XAWL

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-06-11 18:59:59
*/


-- ----------------------------
-- Table structure for XAWL_CITY
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_CITY" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"CITY_NAME" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"DEL_FLAG" VARCHAR2(2 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_COM
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_COM" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"U_ID" VARCHAR2(64 BYTE) NULL ,
"C_NAME" VARCHAR2(64 BYTE) NULL ,
"C_PERSON" VARCHAR2(64 BYTE) NULL ,
"C_PERSON_ID" VARCHAR2(64 BYTE) NULL ,
"C_MONEY" NUMBER(6,2) NULL ,
"C_ADDRESS" VARCHAR2(64 BYTE) NULL ,
"C_BANK_ADDRESS" VARCHAR2(64 BYTE) NULL ,
"C_BANK_ACCOUNT" VARCHAR2(64 BYTE) NULL ,
"C_COM_NUM" VARCHAR2(64 BYTE) NULL ,
"C_COM_DATE" DATE NULL ,
"C_IMG_URL" VARCHAR2(64 BYTE) NULL ,
"C_CREATETIME" DATE NULL ,
"C_DELFLAG" VARCHAR2(2 BYTE) NULL ,
"C_MAIN_BUSSINESS" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_EDITOR

CREATE TABLE "XAWL"."XAWL_EDITOR" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"U_ID" VARCHAR2(64 BYTE) NULL ,
"E_TITLE" VARCHAR2(64 BYTE) NULL ,
"E_STATUS" VARCHAR2(2 BYTE) NULL ,
"E_SEETIME" NUMBER(8) NULL ,
"E_DELFLAG" VARCHAR2(2 BYTE) NULL ,
"U_NAME" VARCHAR2(64 BYTE) NULL ,
"E_TYPE" VARCHAR2(2 BYTE) NULL ,
"E_CREATETIME" DATE NULL ,
"E_CONTENT" VARCHAR2(3000 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_JOB
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_JOB" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"JOB_NAME" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"DEL_FLAG" VARCHAR2(2 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_MAJOY
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_MAJOY" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"MAJOY_NAME" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"DEL_FLAG" VARCHAR2(2 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_STU
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_STU" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"U_ID" VARCHAR2(64 BYTE) NULL ,
"S_SEX" VARCHAR2(10 BYTE) NULL ,
"S_BIRTHDAY" DATE NULL ,
"S_PERSON_ID" VARCHAR2(64 BYTE) NULL ,
"S_MAJOR" VARCHAR2(64 BYTE) NULL ,
"S_LEVEL" VARCHAR2(64 BYTE) NULL ,
"S_STATUS" VARCHAR2(10 BYTE) NULL ,
"S_JOB_CITY" VARCHAR2(64 BYTE) NULL ,
"S_JOB_TYPE" VARCHAR2(64 BYTE) NULL ,
"S_MONEY" VARCHAR2(64 BYTE) NULL ,
"S_IMG_URL" VARCHAR2(64 BYTE) NULL ,
"S_CREATETIME" DATE NULL ,
"S_DELFLAG" VARCHAR2(2 BYTE) NULL ,
"S_NAME" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for XAWL_USER
-- ----------------------------

CREATE TABLE "XAWL"."XAWL_USER" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"U_ACCOUNT" VARCHAR2(64 BYTE) NOT NULL ,
"U_PASSWORD" VARCHAR2(64 BYTE) NOT NULL ,
"U_PHONE" VARCHAR2(64 BYTE) NULL ,
"U_EMAIL" VARCHAR2(64 BYTE) NULL ,
"U_TYPE" VARCHAR2(2 BYTE) NULL ,
"U_CREATETIME" DATE NULL ,
"U_DELFLAG" VARCHAR2(2 BYTE) NULL ,
"U_STATUS" VARCHAR2(2 BYTE) NULL ,
"U_AVATAR" VARCHAR2(64 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Indexes structure for table XAWL_CITY
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_CITY
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_CITY" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_COM
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_COM
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_COM" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_EDITOR
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_EDITOR
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_EDITOR" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_JOB
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_JOB
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_JOB" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_MAJOY
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_MAJOY
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_MAJOY" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_STU
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table XAWL_STU
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_STU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table XAWL_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table XAWL_USER
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_USER" ADD CHECK ("U_ACCOUNT" IS NOT NULL);
ALTER TABLE "XAWL"."XAWL_USER" ADD CHECK ("U_PASSWORD" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table XAWL_USER
-- ----------------------------
ALTER TABLE "XAWL"."XAWL_USER" ADD PRIMARY KEY ("ID");


INSERT INTO "XAWL"."XAWL_USER" ("ID", "U_ACCOUNT", "U_PASSWORD", "U_PHONE", "U_EMAIL", "U_TYPE", "U_CREATETIME", "U_DELFLAG", "U_STATUS", "U_AVATAR") VALUES ('1aab9a46a09c4941b0870d2029f8d900', 'admin', '21232f297a57a5a743894a0e4a801fc3', '18309224483', 'jskfm1995@gmail.com', '0', TO_DATE('2018-03-30 17:07:58', 'SYYYY-MM-DD HH24:MI:SS'), '0', '1', NULL);

