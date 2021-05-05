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
  `adminID` varchar(20) NOT NULL,
  `adminPw` varchar(45) NOT NULL,
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `adminID_UNIQUE` (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','1111');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptitudequestion`
--

DROP TABLE IF EXISTS `aptitudequestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aptitudequestion` (
  `aqNum` int(10) NOT NULL AUTO_INCREMENT,
  `aqQuestion` varchar(100) DEFAULT NULL,
  `aqAnswer1` varchar(100) DEFAULT NULL,
  `aqAnswer2` varchar(100) DEFAULT NULL,
  `aqScore1` int(10) DEFAULT NULL,
  `aqScore2` int(10) DEFAULT NULL,
  PRIMARY KEY (`aqNum`),
  UNIQUE KEY `idaptitudequestion_UNIQUE` (`aqNum`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptitudequestion`
--

LOCK TABLES `aptitudequestion` WRITE;
/*!40000 ALTER TABLE `aptitudequestion` DISABLE KEYS */;
INSERT INTO `aptitudequestion` VALUES (1,'TV를 켰는데 머리쓰는 프로그램을 하고있다(ex 문제적남자) 나의 행동은?','직접 풀어보며 재미를 느낀다.','별 재미를 느끼지 못 한다.',1,0),(2,'현재 나는 프로그래밍 수업을 다니고있다. 너무 어려운 수업을 마친 후 나의 생각은?','어려워서 힘들고 지친다.','어렵더라도 새로운 것을 배우는것이 즐겁고 재밌다.',0,1),(3,'현재 나는 과제를 부여받았고, 시간이 오래걸리지만 하는 방법은 알고 있다. 나의 처리 방식은?','생각을 해서 조금이라도 쉽게 처리 할 수 있는 방법을 고안한다.','무념무상 그냥 처리한다.',1,0),(4,'나는 검색을?','기깔나게 잘한다.','잘못한다.',1,0),(5,'생각을 정리해야될 때 당신은?','노트에 그림을 그리며 정리한다','머릿속으로 정리를 한다',1,0),(6,'오래 앉아서 작업하는 일을 선호하나요?','오래 앉아있는 일은 질색이다','움직이는게싫고 앉아있는 게 좋다',0,1),(7,'전자제품 신상 프로모션을 자주 챙겨본다? (핸드폰, 패드 등)','관심있게 찾아보는 편이다.','관심없다.',1,0),(8,'내일까지 완료해야 하는 숙제가 있다.','내일 숙제는 내일의 내가 한다.','숙제는 오늘 끝내 버린다.',0,1),(9,'잘 만들어진 프로그램을 찾았다. 나는?','어떻게 만들었는지 궁금하다','무념무상',1,0),(10,'나의 평상시 책상은?','남들이 봐도 깔끔한 편이다.','남들이 봤을때 정신이 없어보인다.',1,0);
/*!40000 ALTER TABLE `aptitudequestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptituderesult`
--

DROP TABLE IF EXISTS `aptituderesult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aptituderesult` (
  `arNum` int(10) NOT NULL AUTO_INCREMENT,
  `arName` varchar(100) DEFAULT NULL,
  `arExplain` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`arNum`),
  UNIQUE KEY `arNum_UNIQUE` (`arNum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptituderesult`
--

LOCK TABLES `aptituderesult` WRITE;
/*!40000 ALTER TABLE `aptituderesult` DISABLE KEYS */;
INSERT INTO `aptituderesult` VALUES (1,'직업으로!','완벽하다 바로 개발자의 길을 걷자! 혹시 근무자?'),(2,'잘맞는편이다!','개발자를 직업으로 생각해볼만하다!'),(3,'평범하다','경험을 많이 해보고 결정을 추천한다.'),(4,'음....','개발자를 다시 생각해보는건 어떨까?');
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
  `mqQuestion` varchar(100) DEFAULT NULL,
  `mqType` varchar(10) DEFAULT NULL,
  `mqAnswer1` varchar(100) DEFAULT NULL,
  `mqAnswer2` varchar(100) DEFAULT NULL,
  `mqScore1` int(10) DEFAULT NULL,
  `mqScore2` int(10) DEFAULT NULL,
  PRIMARY KEY (`mqNum`),
  UNIQUE KEY `idmbtiquestion_UNIQUE` (`mqNum`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbtiquestion`
--

LOCK TABLES `mbtiquestion` WRITE;
/*!40000 ALTER TABLE `mbtiquestion` DISABLE KEYS */;
INSERT INTO `mbtiquestion` VALUES (1,'다른사람에게 자신을 소개하는 것을 어려워 한다.','EI','예','아니요',0,1),(2,'대화를 먼저 시작하지 않는다.','EI','예','아니요',0,1),(3,'책이나 게임이 사교모임보다 좋다.','EI','예','아니요',0,1),(4,'의욕적이고 활동적이다.','EI','예','아니요',1,0),(5,'주목받는 일에는 관심이 없습니다.','EI','예','아니요',0,1),(6,'창의적 이기 보다는 현실적.','SN','예','아니요',1,0),(7,'꿈이 현실 세계와 사건에 중점을 둔다.','SN','예','아니요',0,1),(8,'종종 공상과 망상을 할 때가 있습니다.','SN','예','아니요',0,1),(9,'종종 비현실적이고 터무니없지만 흥미로운 생각을 하며 시간을 보냅니다.','SN','예','아니요',0,1),(10,'공상과 아이디어 때문에 흥분하는 일은 없습니다.','SN','예','아니요',1,0),(11,'사람 때매 화나는일 없다.','TF','예','아니요',0,1),(12,'이메일에 회신을 하지 않으면 말 실수했나 걱정한다.','TF','예','아니요',0,1),(13,'다른사람 감정에 공감이 어렵다.','TF','예','아니요',1,0),(14,'토론 시 반응보다 진실이 중요하다.','TF','예','아니요',1,0),(15,'내 행동이 남에게 영향은 관심 없다.','TF','예','아니요',1,0),(16,'순전히 호기심 때문에 행동을 하는 경우는 없다.','JP','예','아니요',1,0),(17,'약속은 상황에 따라 미룰 수 있다 생각한다.','JP','예','아니요',0,1),(18,'집이 잘 정돈되어 있다.','JP','예','아니요',1,0),(19,'다른사람이 내 행동에 영향주는걸 싫어한다.','JP','예','아니요',1,0),(20,'일을 하다 관련된 다른 생각에 잠기곤 한다.','JP','예','아니요',0,1),(21,NULL,NULL,'',NULL,NULL,NULL);
/*!40000 ALTER TABLE `mbtiquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mbtiresult`
--

DROP TABLE IF EXISTS `mbtiresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mbtiresult` (
  `mrNum` int(10) NOT NULL AUTO_INCREMENT,
  `mrType` varchar(45) DEFAULT NULL,
  `mrName` varchar(45) DEFAULT NULL,
  `mrExplain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mrNum`),
  UNIQUE KEY `idnew_table_UNIQUE` (`mrNum`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mbtiresult`
--

LOCK TABLES `mbtiresult` WRITE;
/*!40000 ALTER TABLE `mbtiresult` DISABLE KEYS */;
INSERT INTO `mbtiresult` VALUES (1,'ISTJ','소금형','한번 시작한 일은 끝까지 해내는 성격'),(2,'ISFJ','권력형','성실하고 온화하며 협조를 잘하는 사람'),(3,'ISTP','백과사전형','논리적이고 뛰어난 상황 적응력'),(4,'ISFP','성인군자형','따듯한 감성을 가지고 있는 겸손한 사람'),(5,'ESTP','활동가형','친구,운동,음식 등 다양함을 선호'),(6,'ESFP','사교형','분위기를 고조시키는 우호적인 성격'),(7,'ESTJ','사업가형','사무적,실용적,현실적인 스타일'),(8,'ESFJ','친선도모형','친절,현실감을 바탕으로 타인에게 봉사'),(9,'INFJ','예언자형','사람에 관한 뛰어난 통찰력을 가진 사람'),(10,'INTJ','과학자형','전체를 조합하여 비전을 제시하는 사람'),(11,'INFP','잔다르크형','이상적인 세상을 만들어가는 사람들'),(12,'INTP','아이디어형','비평적인 관점을 가진 뛰어난 전략가'),(13,'ENFP','스파크형','열정적으로 새 관계를 만드는 사람'),(14,'ENTP','발명가형','풍부한 상상력으로 새로운 것에 도전'),(15,'ENFJ','언변능숙형','타인의 성장을 도모하고 협동하는 사람'),(16,'ENTJ','지도자형','비전을 갖고 타인을 활력적으로 인도');
/*!40000 ALTER TABLE `mbtiresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userNum` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `userState` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `userPw` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userResultM` varchar(45) DEFAULT NULL,
  `userResultA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userNum`),
  UNIQUE KEY `userNum_UNIQUE` (`userNum`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'양현준','회원','YHJ','1234','YHJ@naver.com',NULL,NULL),(2,'이도희','회원','LDH','1234','LDH@naver.com','INTP',NULL),(3,'양서린','회원','YSL','1234','YSL@naver.com','INFJ',NULL),(4,'윤재필','회원','YJP','1234','YJP@naver.com','ENFJ',NULL),(5,'이승연','회원','LSY','1234','LSY@naver.com','ESFJ',NULL),(6,'박찬수','회원','PCS','1234','PCS@naver.com',NULL,NULL),(7,'김민재','회원','KMJ','1234','KMJ@naver.com','ENFJ',NULL),(8,'김득수','회원','KDS','1234','KDS@naver.com','ENFP',NULL),(9,'강예진','회원','KYJ','1234','KYJ@naver.com','INFJ',NULL),(10,'최지연','회원','CJY','1234','CJY@naver.com','ENTJ',NULL),(11,'문정형','회원','MJH','1234','MJH@naver.com','ENTP',NULL),(12,'이찬호','회원','LCH','1234','LCH@naver.com','ENFJ',NULL),(13,'한경호','회원','HKH','1234','HKH@naver.com','',NULL),(14,'임현진','회원','IHJ','1234','IHJ@naver.com',NULL,NULL),(15,'조효경','회원','JHK','1234','JHK@naver.com','ENFP',NULL),(16,'오영준','회원','OYJ','1234','OYJ@naver.com','ENFJ',NULL);
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

-- Dump completed on 2021-04-30  0:38:18
