CREATE DATABASE  IF NOT EXISTS `travel_agency` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `travel_agency`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_agency
-- ------------------------------------------------------
-- Server version	5.7.17-log

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES
  (1,'Ivan','Delon'),
  (2,'Ivo','Bobul'),
  (3,'Jan','Jack'),
  (4,'Stepan','Spilberg'),
  (5,'Anton','Ketcher'),
  (6,'Igor','Crud');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelname` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `free_rooms` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` VALUES
  (1,'Sharaga','Guadeloupe','Basse-Terre',2),
  (2,'Pryton','Kosovo','Pristina',300),
  (3,'True Imam','Irak','Baghdad',600),
  (4,'Hogwarts','Great Britain','Nowhereland',0),
  (5,'Narnia','Shkaf','Bedroom',1);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `date_in` date DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES
  (1,1,1,'2017-07-10','2017-07-15'),
  (2,5,2,'2017-03-14','2017-03-19'),
  (3,2,3,'2017-05-17','2017-07-22'),
  (4,4,2,'2017-05-07','2017-07-26'),
  (5,2,3,'2017-03-02','2017-06-24'),
  (6,1,1,'2017-01-12','2017-05-28'),
  (7,6,3,'2017-02-09','2017-06-29'),
  (8,4,2,'2017-06-15','2017-07-27'),
  (9,3,1,'2017-03-12','2017-05-22'),
  (10,1,1,'2017-01-14','2017-03-21'),
  (11,6,2,'2017-02-11','2017-05-23'),
  (12,5,3,'2017-06-10','2017-07-26'),
  (13,3,2,'2017-04-17','2017-06-29'),
  (14,4,1,'2017-02-14','2017-04-20'),
  (15,2,2,'2017-01-11','2017-02-29'),
  (16,1,5,'2017-03-12','2017-04-21');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
