CREATE DATABASE  IF NOT EXISTS `draconomicon` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `draconomicon`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: draconomicon
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id_blog` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(25) NOT NULL,
  `contenu` text NOT NULL,
  `date_blog` datetime(6) DEFAULT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_blog`),
  KEY `fk_user_blog_idx` (`id_user`),
  CONSTRAINT `fk_user_blog` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (9,'Game of Throne','«Les Targaryen ne sont pas immunisés contre le feu. La naissance des dragons de Daenerys était événement unique, magique, miraculeux. Elle est surnommée l\'Imbrûlée parce qu\'elle a marché dans les flammes et qu\'elle y a survécu. Mais son frère n\'était certainement pas immunisé à cet or fondu»','2023-08-14 14:40:37.719992',1),(10,'Dragons','Hiccup est un adolescent viking de l\'île de Berk, où se battre avec des dragons est un mode de vie. Ses idées progressistes et son sens de l\'humour étrange le tiennent à part des autres, malgré le fait que son père est le chef du clan.','2023-08-14 14:41:36.585815',1),(11,'Mon Amour de Wyverne','Mon copain adore les dragons ! Même si il se trompe souvent sur la race ^^\', je compte lui montrer l\'encyclopédie de ce site internet !','2023-08-15 08:37:14.931212',12);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentaire` (
  `id_comment` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(250) NOT NULL,
  `date_comments` date DEFAULT NULL,
  `id_user` int NOT NULL,
  `id_blog` int NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `fk_user_commentaire_idx` (`id_user`),
  KEY `fk_blog_commentaire_idx` (`id_blog`),
  CONSTRAINT `fk_blog_commentaire` FOREIGN KEY (`id_blog`) REFERENCES `blog` (`id_blog`),
  CONSTRAINT `fk_user_commentaire` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encyclopedie`
--

DROP TABLE IF EXISTS `encyclopedie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encyclopedie` (
  `id_encyclopedie` int NOT NULL AUTO_INCREMENT,
  `espece` varchar(35) NOT NULL,
  `caract_text` text NOT NULL,
  `caract_image` varchar(25) NOT NULL,
  `myths_text` varchar(255) DEFAULT NULL,
  `myths_image` varchar(25) NOT NULL,
  `carac_image` varchar(25) DEFAULT NULL,
  `carac_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_encyclopedie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encyclopedie`
--

LOCK TABLES `encyclopedie` WRITE;
/*!40000 ALTER TABLE `encyclopedie` DISABLE KEYS */;
/*!40000 ALTER TABLE `encyclopedie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id_genre` int NOT NULL AUTO_INCREMENT,
  `genre` varchar(15) NOT NULL,
  PRIMARY KEY (`id_genre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'female'),(2,'male'),(3,'other');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `media` (
  `id_media` int NOT NULL AUTO_INCREMENT,
  `media_text` varchar(255) DEFAULT NULL,
  `media_image` varchar(25) NOT NULL,
  `media_date` date DEFAULT NULL,
  `id_encyclopedie` int NOT NULL,
  PRIMARY KEY (`id_media`),
  KEY `fk_encyclopedie_media_idx` (`id_encyclopedie`),
  CONSTRAINT `fk_encyclopedie_media` FOREIGN KEY (`id_encyclopedie`) REFERENCES `encyclopedie` (`id_encyclopedie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user'),(2,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `id_genre` int NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_role_user_idx` (`id_role`),
  KEY `fk_genre_user_idx` (`id_genre`),
  CONSTRAINT `fk_genre_user` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id_genre`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'The Doctor','johnsmith@email.uk','i am the doctor',911,3,'dragon.jfif',2),(3,'Lyrael Droppy','droopygirl@email.fr','mylovekitten',69,3,'dragon.jfif',1),(4,'benoit','benoit@droopy.fr','$2a$10$FD5PVrN3LQci3fpsKz46keE4QPtkPkR/d1rpXyg7JZNGElOQ0Pljy',35,2,'kirin.jpg',1),(12,'Lyrael','lisou-lisa_diana@hotmail.fr','$2a$10$6qYfjUzTqYUjWiMCzVXIyOcqf4J7B.NqxdnDI7kJqwiIKl92LqPEO',24,1,'dragon.jfif',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'draconomicon'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-15 16:43:48
