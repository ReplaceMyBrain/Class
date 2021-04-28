-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: swing_project_team3
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` varchar(20) NOT NULL,
  `adminPw` varchar(45) NOT NULL,
  UNIQUE KEY `adminId_UNIQUE` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','1234');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptitudequestion`
--

DROP TABLE IF EXISTS `aptitudequestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aptitudequestion` (
  `aqNum` int(11) NOT NULL,
  `aqQuestion` varchar(45) DEFAULT NULL,
  `aqAnswer1` varchar(10) DEFAULT NULL,
  `aqAnswer2` varchar(10) DEFAULT NULL,
  `aqScore1` varchar(10) DEFAULT NULL,
  `aqScore` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`aqNum`),
  UNIQUE KEY `qqNum_UNIQUE` (`aqNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptitudequestion`
--

LOCK TABLES `aptitudequestion` WRITE;
/*!40000 ALTER TABLE `aptitudequestion` DISABLE KEYS */;
INSERT INTO `aptitudequestion` VALUES (1,'1','1','2','1','0'),(2,'2','1','2','0','1');
/*!40000 ALTER TABLE `aptitudequestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptituderesult`
--

DROP TABLE IF EXISTS `aptituderesult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aptituderesult` (
  `arNum` int(11) NOT NULL,
  `arName` varchar(45) DEFAULT NULL,
  `arExplain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`arNum`),
  UNIQUE KEY `QuizNum_UNIQUE` (`arNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptituderesult`
--

LOCK TABLES `aptituderesult` WRITE;
/*!40000 ALTER TABLE `aptituderesult` DISABLE KEYS */;
/*!40000 ALTER TABLE `aptituderesult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbtiquestion`
--

DROP TABLE IF EXISTS `mbtiquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mbtiquestion` (
  `mqNum` int(11) NOT NULL AUTO_INCREMENT,
  `mqQuestion` varchar(45) DEFAULT NULL,
  `mqType` varchar(10) DEFAULT NULL,
  `mqAnswer1` varchar(10) DEFAULT NULL,
  `mqAnswer2` varchar(10) DEFAULT NULL,
  `mqScore1` varchar(45) DEFAULT NULL,
  `mqScore2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mqNum`),
  UNIQUE KEY `qNum_UNIQUE` (`mqNum`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbtiquestion`
--

LOCK TABLES `mbtiquestion` WRITE;
/*!40000 ALTER TABLE `mbtiquestion` DISABLE KEYS */;
INSERT INTO `mbtiquestion` VALUES (1,'1','1','1','2','1','0'),(2,'2','2','1','2','1','0');
/*!40000 ALTER TABLE `mbtiquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbtiresult`
--

DROP TABLE IF EXISTS `mbtiresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mbtiresult` (
  `mrNum` int(11) NOT NULL AUTO_INCREMENT,
  `mrType` varchar(10) DEFAULT NULL,
  `mrName` varchar(12) DEFAULT NULL,
  `mrExplain` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`mrNum`),
  UNIQUE KEY `MbtiNum_UNIQUE` (`mrNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbtiresult`
--

LOCK TABLES `mbtiresult` WRITE;
/*!40000 ALTER TABLE `mbtiresult` DISABLE KEYS */;
/*!40000 ALTER TABLE `mbtiresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userNum` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `userPw` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userResultM` varchar(45) DEFAULT NULL,
  `userResultQ` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userNum`),
  UNIQUE KEY `userNum_UNIQUE` (`userNum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'김도우','kdw','1234','kdw@naver.com',NULL,NULL),(2,'최수훈','csh','1234','csh@naver.com',NULL,NULL),(3,'오성아','osa','1234','osa@naver.com',NULL,NULL),(4,'양현준','yhj','1234','yhj@naver.com',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 14:56:49
