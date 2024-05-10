-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: equipo7
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detallep`
--

DROP TABLE IF EXISTS `detallep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallep` (
  `idProducto` int NOT NULL,
  `idPedido` int NOT NULL,
  `CantidadP` int DEFAULT NULL,
  `SubtotalP` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`,`idPedido`),
  KEY `fk_Producto_has_Pedido_Pedido1_idx` (`idPedido`),
  KEY `fk_Producto_has_Pedido_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Pedido_Pedido1` FOREIGN KEY (`idPedido`) REFERENCES `proyecto`.`pedido` (`idPedido`),
  CONSTRAINT `fk_Producto_has_Pedido_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `proyecto`.`producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallep`
--

LOCK TABLES `detallep` WRITE;
/*!40000 ALTER TABLE `detallep` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallev`
--

DROP TABLE IF EXISTS `detallev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallev` (
  `idProducto` int NOT NULL,
  `Folio` int NOT NULL,
  `Cantidad` int DEFAULT NULL,
  `Subtotal` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`,`Folio`),
  KEY `fk_Producto_has_Venta_Venta1_idx` (`Folio`),
  KEY `fk_Producto_has_Venta_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Venta_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `proyecto`.`producto` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Venta_Venta1` FOREIGN KEY (`Folio`) REFERENCES `proyecto`.`venta` (`Folio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallev`
--

LOCK TABLES `detallev` WRITE;
/*!40000 ALTER TABLE `detallev` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallev` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL,
  `NombreE` varchar(45) DEFAULT NULL,
  `ApellidoE` varchar(30) DEFAULT NULL,
  `Horario` int DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `FechaContrato` date DEFAULT NULL,
  `tipoEmpleado` varchar(20) DEFAULT NULL,
  `almacen` tinyint DEFAULT NULL,
  `administracion` tinyint DEFAULT NULL,
  `direccionG` tinyint DEFAULT NULL,
  `ventas` tinyint DEFAULT NULL,
  `Compras` tinyint DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `idProducto` int NOT NULL,
  `idInventario` int NOT NULL,
  `FechaEntrada` date DEFAULT NULL,
  `FechaSalida` date DEFAULT NULL,
  `Existencia` int DEFAULT NULL,
  `cantAñadida` int DEFAULT NULL,
  `CantRetirada` int DEFAULT NULL,
  `tipoMovimiento` varchar(10) DEFAULT NULL,
  `Compra` tinyint DEFAULT NULL,
  `Venta` tinyint DEFAULT NULL,
  `Ajuste` tinyint DEFAULT NULL,
  PRIMARY KEY (`idProducto`,`idInventario`),
  KEY `fk_RegInventario_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_RegInventario_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `proyecto`.`producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idPedido` int NOT NULL,
  `FechaP` date DEFAULT NULL,
  `total` int DEFAULT NULL,
  `idProveedor` int NOT NULL,
  `idEmpleado` int NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fk_Pedido_Proveedor1_idx` (`idProveedor`),
  KEY `fk_Pedido_Empleado1_idx` (`idEmpleado`),
  CONSTRAINT `fk_Pedido_Empleado1` FOREIGN KEY (`idEmpleado`) REFERENCES `proyecto`.`empleado` (`idEmpleado`),
  CONSTRAINT `fk_Pedido_Proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `proyecto`.`proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL,
  `NombreP` varchar(40) DEFAULT NULL,
  `Descripcion` varchar(60) DEFAULT NULL,
  `PrecioCompra` int DEFAULT NULL,
  `PrecioVenta` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL,
  `NombrePV` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Compañia` varchar(20) DEFAULT NULL,
  `Mercancia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonoe`
--

DROP TABLE IF EXISTS `telefonoe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonoe` (
  `idEmpleado` int NOT NULL,
  `TelefonoE` int NOT NULL,
  PRIMARY KEY (`idEmpleado`,`TelefonoE`),
  KEY `fk_Telefono_Empleado_idx` (`idEmpleado`),
  CONSTRAINT `fk_Telefono_Empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `proyecto`.`empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonoe`
--

LOCK TABLES `telefonoe` WRITE;
/*!40000 ALTER TABLE `telefonoe` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonoe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonop`
--

DROP TABLE IF EXISTS `telefonop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonop` (
  `idProveedor` int NOT NULL,
  `TelefonoP` int NOT NULL,
  PRIMARY KEY (`idProveedor`,`TelefonoP`),
  KEY `fk_TelefonoE_Proveedor1_idx` (`idProveedor`),
  CONSTRAINT `fk_TelefonoE_Proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `proyecto`.`proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonop`
--

LOCK TABLES `telefonop` WRITE;
/*!40000 ALTER TABLE `telefonop` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `Folio` int NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Total` int DEFAULT NULL,
  `idEmpleado` int NOT NULL,
  PRIMARY KEY (`Folio`),
  KEY `fk_Venta_Empleado1_idx` (`idEmpleado`),
  CONSTRAINT `fk_Venta_Empleado1` FOREIGN KEY (`idEmpleado`) REFERENCES `proyecto`.`empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-01 11:48:48
