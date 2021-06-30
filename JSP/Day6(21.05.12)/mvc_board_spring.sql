CREATE DATABASE  IF NOT EXISTS `mvc` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mvc`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: mvc
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mvc_board`
--

DROP TABLE IF EXISTS `mvc_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mvc_board` (
  `bId` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `bName` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `bTitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `bContent` text,
  `bDate` datetime DEFAULT NULL,
  PRIMARY KEY (`bId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvc_board`
--

LOCK TABLES `mvc_board` WRITE;
/*!40000 ALTER TABLE `mvc_board` DISABLE KEYS */;
INSERT INTO `mvc_board` VALUES (0000000002,'아델','인기1위 아델','스틸범들... 쩜디 그만!','2021-05-12 16:15:35'),(0000000003,'카인','중2병카인','얜.. 궁수면서 되게 도적같음... 잘생겼으나 넘 중2병 느낌','2021-05-12 11:33:06'),(0000000004,'패스파인더','궁수가 궁수했다','4연속 너프맞고 맛탱이감','2021-05-12 11:33:41'),(0000000006,'일리움','일리움은 대머리','대머리가 되어버린 일리움...\r\n괜찮아...\r\n아마도...','2021-05-12 16:16:10'),(0000000007,'호영','최.강.호.영','우리 호영이가 제일 쎄!\r\n반박 거절','2021-05-12 16:16:52'),(0000000008,'카데나','카데나는 노바공주님','카데나는 노바...공주\r\n노바가 나란가?\r\n걍 종족인가?','2021-05-12 16:23:27'),(0000000009,'아란','영웅 아란','아란은 유니온 하려면 무조건 키워야지\r\n아란의 유니온 효과는\r\n경험치 콤보 구슬 ... 500%였나 ? 400%였나?','2021-05-12 16:25:27');
/*!40000 ALTER TABLE `mvc_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-30 12:03:41
