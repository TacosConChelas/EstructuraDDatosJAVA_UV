-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: pruebapooj
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `celular`
--

DROP TABLE IF EXISTS `celular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celular` (
  `idCelular` int NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `marcaProducto` varchar(100) NOT NULL,
  `precioProducto` decimal(10,2) NOT NULL,
  `cantidadExistencia` int NOT NULL,
  `descuentoProducto` decimal(6,2) NOT NULL,
  `camaraPrincipal` decimal(6,2) NOT NULL,
  `camaraFrontal` decimal(6,2) NOT NULL,
  `memoriaRAM` decimal(6,2) NOT NULL,
  `almacenamientoGB` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idCelular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `celular`
--

LOCK TABLES `celular` WRITE;
/*!40000 ALTER TABLE `celular` DISABLE KEYS */;
INSERT INTO `celular` VALUES (1,'poco f4','poco ',30000.00,100,0.00,1.00,1.00,32.00,250.00),(2,'samsung p4','Samsung',3000.00,3,0.00,1.00,1.00,4.00,124.00);
/*!40000 ALTER TABLE `celular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `television`
--

DROP TABLE IF EXISTS `television`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `television` (
  `idTelevision` int NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `marcaProducto` varchar(100) NOT NULL,
  `precioProducto` decimal(10,2) NOT NULL,
  `cantidadExistencia` int NOT NULL,
  `descuentoProducto` decimal(6,2) NOT NULL,
  `pulgadasTelevision` decimal(6,2) NOT NULL,
  `tipoPantalla` varchar(45) NOT NULL,
  `numPuertosHDMI` int NOT NULL,
  `numPuertosUSB` int NOT NULL,
  PRIMARY KEY (`idTelevision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `television`
--

LOCK TABLES `television` WRITE;
/*!40000 ALTER TABLE `television` DISABLE KEYS */;
INSERT INTO `television` VALUES (2,'television pro','Pro marca',22000.00,500,0.00,30.00,'OLED',5,5);
/*!40000 ALTER TABLE `television` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-30 22:02:09
