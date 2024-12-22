-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: gom
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nomeCompleto_cliente` varchar(100) NOT NULL,
  `endereco_cliente` varchar(255) DEFAULT NULL,
  `cpf_cliente` varchar(14) NOT NULL,
  `email_cliente` varchar(100) DEFAULT NULL,
  `telefone_cliente` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf_cliente` (`cpf_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'victor santos','rua do senai, 123','111.222.333-44','victor@email.com','21912345698'),(8,'lucas daniel cataldo siqueira','rua sabino barroso 318','11122233344','lucas@gmail.com','21971182454');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devedores`
--

DROP TABLE IF EXISTS `devedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devedores` (
  `id_devedores` int NOT NULL AUTO_INCREMENT,
  `total_divida` decimal(10,2) NOT NULL,
  `data_limite` date NOT NULL,
  `observacoes` text,
  `status_pagamento` varchar(20) NOT NULL,
  `fk_id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_devedores`),
  KEY `fk_cliente_devedores` (`fk_id_cliente`),
  CONSTRAINT `fk_cliente_devedores` FOREIGN KEY (`fk_id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devedores`
--

LOCK TABLES `devedores` WRITE;
/*!40000 ALTER TABLE `devedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `devedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabricante` (
  `id_fabricante` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricante`
--

LOCK TABLES `fabricante` WRITE;
/*!40000 ALTER TABLE `fabricante` DISABLE KEYS */;
INSERT INTO `fabricante` VALUES (1,'Fiat'),(2,'Volkswagen'),(3,'Chevrolet'),(4,'Ford'),(5,'Honda'),(6,'Toyota'),(7,'Renault'),(8,'Hyundai'),(9,'Nissan'),(10,'Jeep'),(11,'Peugeot'),(12,'Kia'),(13,'BMW'),(14,'Mercedes-Benz'),(15,'Audi'),(16,'Abarth'),(17,'Range Rover'),(18,'Mitsubishi'),(19,'Chery'),(20,'Citroën'),(21,'Suzuki');
/*!40000 ALTER TABLE `fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_os`
--

DROP TABLE IF EXISTS `itens_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_os` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `valor_unitario` double NOT NULL,
  `quantidade` int NOT NULL,
  `fk_id_OS` int DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `fk_id_OS` (`fk_id_OS`),
  CONSTRAINT `itens_os_ibfk_1` FOREIGN KEY (`fk_id_OS`) REFERENCES `ordem_de_servico` (`id_OS`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_os`
--

LOCK TABLES `itens_os` WRITE;
/*!40000 ALTER TABLE `itens_os` DISABLE KEYS */;
INSERT INTO `itens_os` VALUES (1,'velas',1000,3,NULL),(2,'kit gás',100,2,4),(3,'vidro',100,3,4),(4,'teste',100,3,4),(5,'teste 01',100,3,4),(6,'teste 02',100,3,4),(7,'teste 03',100,3,4),(8,'teste 04',100,3,4),(9,'n aguento mais',100,3,4),(10,'teste 05',100,3,4),(11,'teste 06',100,4,4),(12,'filtro de combustivel',535,1,4),(13,'volante',122,1,4),(14,'catalizador',234,1,4),(15,'pintura',2350,1,4),(17,'fodase',250,2,5),(18,'chocolate',10,1,5),(20,'troca de óleo',150,1,6),(21,'troca de pneu',80,4,7);
/*!40000 ALTER TABLE `itens_os` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_os_temp`
--

DROP TABLE IF EXISTS `itens_os_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_os_temp` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `valor_unitario` double NOT NULL,
  `quantidade` int NOT NULL,
  `fk_id_OS` int DEFAULT NULL,
  PRIMARY KEY (`id_item`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_os_temp`
--

LOCK TABLES `itens_os_temp` WRITE;
/*!40000 ALTER TABLE `itens_os_temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_os_temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelo` (
  `id_modelo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `fk_id_fabricante` int DEFAULT NULL,
  PRIMARY KEY (`id_modelo`),
  KEY `fk_fabricante_modelo` (`fk_id_fabricante`),
  CONSTRAINT `fk_fabricante_modelo` FOREIGN KEY (`fk_id_fabricante`) REFERENCES `fabricante` (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=351 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'Fiat Uno',1),(2,'Fiat Palio',1),(3,'Fiat Argo',1),(4,'Fiat Mobi',1),(5,'Fiat Toro',1),(6,'Fiat Strada',1),(7,'Fiat Punto',1),(8,'Fiat 500',1),(9,'Fiat Doblo',1),(10,'Fiat Idea',1),(11,'Fiat Linea',1),(12,'Fiat Siena',1),(13,'Fiat Grand Siena',1),(14,'Fiat Freemont',1),(15,'Fiat Stilo',1),(16,'Fiat Panda',1),(17,'Fiat Fiorino',1),(18,'Fiat Cronos',1),(19,'Fiat Bravo',1),(20,'Fiat 147',1),(21,'Fiat Tempra',1),(22,'Fiat Elba',1),(23,'Fiat Prêmio',1),(24,'Fiat Croma',1),(25,'Volkswagen Gol',2),(26,'Volkswagen Fox',2),(27,'Volkswagen Polo',2),(28,'Volkswagen Virtus',2),(29,'Volkswagen Saveiro',2),(30,'Volkswagen Tiguan',2),(31,'Volkswagen Jetta',2),(32,'Volkswagen Passat',2),(33,'Volkswagen Up!',2),(34,'Volkswagen Voyage',2),(35,'Volkswagen Crossfox',2),(36,'Volkswagen SpaceFox',2),(37,'Volkswagen Golf',2),(38,'Volkswagen Arteon',2),(39,'Volkswagen T-Cross',2),(40,'Volkswagen Nivus',2),(41,'Volkswagen Amarok',2),(42,'Volkswagen Brasilia',2),(43,'Volkswagen Beetle',2),(44,'Volkswagen Parati',2),(45,'Volkswagen Fox Cross',2),(46,'Volkswagen Kombi',2),(47,'Volkswagen SP2',2),(48,'Volkswagen TL',2),(49,'Volkswagen Golf Variant',2),(50,'Chevrolet Onix',3),(51,'Chevrolet Prisma',3),(52,'Chevrolet Tracker',3),(53,'Chevrolet S10',3),(54,'Chevrolet Cruze',3),(55,'Chevrolet Spin',3),(56,'Chevrolet Trailblazer',3),(57,'Chevrolet Montana',3),(58,'Chevrolet Aveo',3),(59,'Chevrolet Malibu',3),(60,'Chevrolet Sonic',3),(61,'Chevrolet Tracker',3),(62,'Chevrolet Cobalt',3),(63,'Chevrolet Equinox',3),(64,'Chevrolet Spin',3),(65,'Chevrolet Spark',3),(66,'Chevrolet Chevette',3),(67,'Chevrolet Opala',3),(68,'Chevrolet Kadett',3),(69,'Chevrolet Astra',3),(70,'Chevrolet Corvette',3),(71,'Chevrolet Camaro',3),(72,'Chevrolet Sonic',3),(73,'Chevrolet Suburban',3),(74,'Chevrolet Blazer',3),(75,'Ford Ka',4),(76,'Ford Fiesta',4),(77,'Ford Focus',4),(78,'Ford EcoSport',4),(79,'Ford Ranger',4),(80,'Ford Mustang',4),(81,'Ford Fusion',4),(82,'Ford Edge',4),(83,'Ford Territory',4),(84,'Ford Escort',4),(85,'Ford Mondeo',4),(86,'Ford F-150',4),(87,'Ford Expedition',4),(88,'Ford F-250',4),(89,'Ford F-350',4),(90,'Ford Bronco',4),(91,'Ford Maverick',4),(92,'Ford GT',4),(93,'Ford Ka Sedan',4),(94,'Ford T',4),(95,'Ford Crown Victoria',4),(96,'Ford Galaxy',4),(97,'Honda Civic',5),(98,'Honda HR-V',5),(99,'Honda Fit',5),(100,'Honda CR-V',5),(101,'Honda City',5),(102,'Honda Accord',5),(103,'Honda WR-V',5),(104,'Honda Odyssey',5),(105,'Honda Pilot',5),(106,'Honda Crosstour',5),(107,'Honda Element',5),(108,'Honda Ridgeline',5),(109,'Honda Insight',5),(110,'Honda Prelude',5),(111,'Honda CR-Z',5),(112,'Honda Passport',5),(113,'Honda Acty',5),(114,'Honda BR-V',5),(115,'Toyota Corolla',6),(116,'Toyota Hilux',6),(117,'Toyota Etios',6),(118,'Toyota Yaris',6),(119,'Toyota SW4',6),(120,'Toyota Prius',6),(121,'Toyota RAV4',6),(122,'Toyota Land Cruiser',6),(123,'Toyota Camry',6),(124,'Toyota Avalon',6),(125,'Toyota FJ Cruiser',6),(126,'Toyota Tacoma',6),(127,'Toyota C-HR',6),(128,'Toyota Corolla Cross',6),(129,'Toyota Prius Plug-in',6),(130,'Toyota Supra',6),(131,'Toyota 86',6),(132,'Toyota Sienna',6),(133,'Toyota Highlander',6),(134,'Renault Kwid',7),(135,'Renault Logan',7),(136,'Renault Sandero',7),(137,'Renault Captur',7),(138,'Renault Duster',7),(139,'Renault Oroch',7),(140,'Renault Fluence',7),(141,'Renault Koleos',7),(142,'Renault Twingo',7),(143,'Renault Zoe',7),(144,'Renault Mégane',7),(145,'Renault Scenic',7),(146,'Renault Clio',7),(147,'Renault Laguna',7),(148,'Renault Espace',7),(149,'Renault Safrane',7),(150,'Hyundai HB20',8),(151,'Hyundai Creta',8),(152,'Hyundai Tucson',8),(153,'Hyundai Santa Fe',8),(154,'Hyundai i30',8),(155,'Hyundai Kona',8),(156,'Hyundai Elantra',8),(157,'Hyundai Azera',8),(158,'Hyundai Sonata',8),(159,'Hyundai Veloster',8),(160,'Hyundai i20',8),(161,'Hyundai Staria',8),(162,'Hyundai Veracruz',8),(163,'Hyundai Accent',8),(164,'Hyundai iX35',8),(165,'Hyundai Elantra GT',8),(166,'Hyundai H1',8),(167,'Nissan Versa',9),(168,'Nissan Kicks',9),(169,'Nissan Frontier',9),(170,'Nissan Altima',9),(171,'Nissan March',9),(172,'Nissan Leaf',9),(173,'Nissan Pathfinder',9),(174,'Nissan X-Trail',9),(175,'Nissan Maxima',9),(176,'Nissan Sentra',9),(177,'Nissan Juke',9),(178,'Nissan 350Z',9),(179,'Nissan 370Z',9),(180,'Nissan Murano',9),(181,'Nissan GT-R',9),(182,'Nissan Cube',9),(183,'Nissan Qashqai',9),(184,'Jeep Renegade',10),(185,'Jeep Compass',10),(186,'Jeep Cherokee',10),(187,'Jeep Gladiator',10),(188,'Jeep Wrangler',10),(189,'Jeep Grand Cherokee',10),(190,'Jeep Commander',10),(191,'Jeep Wagoneer',10),(192,'Jeep Liberty',10),(193,'Jeep Patriot',10),(194,'Jeep Cherokee XJ',10),(195,'Peugeot 208',11),(196,'Peugeot 2008',11),(197,'Peugeot 3008',11),(198,'Peugeot 5008',11),(199,'Peugeot Partner',11),(200,'Peugeot 408',11),(201,'Peugeot 307',11),(202,'Peugeot 504',11),(203,'Peugeot 508',11),(204,'Peugeot 406',11),(205,'Kia Seltos',12),(206,'Kia Sportage',12),(207,'Kia Stonic',12),(208,'Kia Cerato',12),(209,'Kia Picanto',12),(210,'Kia Sorento',12),(211,'Kia Cadenza',12),(212,'Kia Soul',12),(213,'Kia Optima',12),(214,'Kia Stinger',12),(215,'Kia Mohave',12),(216,'Kia K2500',12),(217,'Kia Carnival',12),(218,'Kia Forte',12),(219,'Kia K900',12),(220,'BMW 320i',13),(221,'BMW 330i',13),(222,'BMW X1',13),(223,'BMW X3',13),(224,'BMW X5',13),(225,'BMW 520i',13),(226,'BMW 530i',13),(227,'BMW M4',13),(228,'BMW M3',13),(229,'BMW Série 7',13),(230,'BMW 118i',13),(231,'BMW Z4',13),(232,'BMW X6',13),(233,'BMW X7',13),(234,'BMW i3',13),(235,'BMW i4',13),(236,'BMW iX',13),(237,'BMW 325i',13),(238,'BMW 525i',13),(239,'BMW 528i',13),(240,'BMW 335i',13),(241,'BMW 740i',13),(242,'Mercedez C-Class',14),(243,'Mercedez E-Class',14),(244,'Mercedez S-Class',14),(245,'Mercedez A-Class',14),(246,'Mercedez GLA',14),(247,'Mercedez GLC',14),(248,'Mercedez G-Class',14),(249,'Mercedez CLA',14),(250,'Mercedez EQB',14),(251,'Mercedez EQS',14),(252,'Mercedez GLE',14),(253,'Mercedez V-Class',14),(254,'Mercedez SL',14),(255,'Mercedez AMG GT',14),(256,'Mercedez A45 AMG',14),(257,'Mercedez B-Class',14),(258,'Mercedez CLS',14),(259,'Mercedez M-Class',14),(260,'Audi A3',15),(261,'Audi A4',15),(262,'Audi A6',15),(263,'Audi A8',15),(264,'Audi Q3',15),(265,'Audi Q5',15),(266,'Audi Q7',15),(267,'Audi Q8',15),(268,'Audi TT',15),(269,'Audi RS7',15),(270,'Audi RS3',15),(271,'Audi R8',15),(272,'Audi Q2',15),(273,'Audi S3',15),(274,'Audi S5',15),(275,'Audi E-Tron',15),(276,'Abarth 500',16),(277,'Abarth 124 Spider',16),(278,'Abarth 595',16),(279,'Abarth 695',16),(280,'Abarth Punto',16),(281,'Abarth 850 TC',16),(282,'Abarth 1000',16),(283,'Abarth 750 GT',16),(284,'Range Rover',17),(285,'Range Rover Sport',17),(286,'Range Rover Velar',17),(287,'Range Rover Evoque',17),(288,'Range Rover Classic',17),(289,'Range Rover Sentinel',17),(290,'Range Rover Discovery',17),(291,'Range Rover Discovery Sport',17),(292,'Range Rover Defender',17),(293,'Range Rover Long Wheelbase (LWB)',17),(294,'Mitsubishi L200',18),(295,'Mitsubishi Outlander',18),(296,'Mitsubishi ASX',18),(297,'Mitsubishi Eclipse Cross',18),(298,'Mitsubishi Pajero',18),(299,'Mitsubishi Triton',18),(300,'Mitsubishi Colt',18),(301,'Mitsubishi Lancer',18),(302,'Mitsubishi Galant',18),(303,'Mitsubishi 3000GT',18),(304,'Mitsubishi Mirage',18),(305,'Mitsubishi Outlander PHEV',18),(306,'Mitsubishi Montero',18),(307,'Mitsubishi Endeavor',18),(308,'Chery Tiggo 2',19),(309,'Chery Tiggo 3',19),(310,'Chery Tiggo 5',19),(311,'Chery Tiggo 7',19),(312,'Chery Tiggo 8',19),(313,'Chery Celer',19),(314,'Chery QQ',19),(315,'Chery Arrizo 5',19),(316,'Chery Arrizo 6',19),(317,'Chery Face',19),(318,'Chery S18',19),(319,'Chery X1',19),(320,'Citroën C3',20),(321,'Citroën C4',20),(322,'Citroën C5',20),(323,'Citroën C6',20),(324,'Citroën Aircross',20),(325,'Citroën Berlingo',20),(326,'Citroën Jumpy',20),(327,'Citroën Jumper',20),(328,'Citroën DS3',20),(329,'Citroën DS4',20),(330,'Citroën DS5',20),(331,'Citroën Picasso',20),(332,'Citroën Ami',20),(333,'Citroën Saxo',20),(334,'Citroën Xsara',20),(335,'Citroën ZX',20),(336,'Suzuki Swift',21),(337,'Suzuki Vitara',21),(338,'Suzuki Jimny',21),(339,'Suzuki Baleno',21),(340,'Suzuki S-Cross',21),(341,'Suzuki Ertiga',21),(342,'Suzuki Alto',21),(343,'Suzuki SX4',21),(344,'Suzuki Grand Vitara',21),(345,'Suzuki Splash',21),(346,'Suzuki Wagon R',21),(347,'Suzuki Kizashi',21),(348,'Suzuki Celerio',21),(349,'Suzuki Liana',21),(350,'Suzuki Forenza',21);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_de_servico`
--

DROP TABLE IF EXISTS `ordem_de_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_de_servico` (
  `id_OS` int NOT NULL AUTO_INCREMENT,
  `data` varchar(10) DEFAULT NULL,
  `valor_total` varchar(30) DEFAULT NULL,
  `fk_id_veiculo` int DEFAULT NULL,
  `forma_pagamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_OS`),
  KEY `fk_id_veiculo` (`fk_id_veiculo`),
  CONSTRAINT `ordem_de_servico_ibfk_1` FOREIGN KEY (`fk_id_veiculo`) REFERENCES `veiculo` (`id_carro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_de_servico`
--

LOCK TABLES `ordem_de_servico` WRITE;
/*!40000 ALTER TABLE `ordem_de_servico` DISABLE KEYS */;
INSERT INTO `ordem_de_servico` VALUES (2,NULL,'400.0',1,'Dinheiro'),(3,NULL,'1291.0',1,'Dinheiro'),(4,NULL,'2350.0',1,'Dinheiro'),(5,NULL,'510.0',1,'Dinheiro'),(6,NULL,'150.0',6,'Dinheiro'),(7,NULL,'470.0',1,'Pix');
/*!40000 ALTER TABLE `ordem_de_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'patrick','AstonMartin14'),(2,'victor','101201'),(3,'lucas','43961'),(4,'gabriel','071830'),(5,'matheus','221-137');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `id_carro` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(10) NOT NULL,
  `motor` varchar(20) DEFAULT NULL,
  `fk_id_cliente` int DEFAULT NULL,
  `fk_id_modelo` int DEFAULT NULL,
  `ano` int DEFAULT NULL,
  PRIMARY KEY (`id_carro`),
  UNIQUE KEY `placa` (`placa`),
  KEY `fk_cliente_veiculo` (`fk_id_cliente`),
  KEY `fk_modelo_veiculo` (`fk_id_modelo`),
  CONSTRAINT `fk_cliente_veiculo` FOREIGN KEY (`fk_id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_modelo_veiculo` FOREIGN KEY (`fk_id_modelo`) REFERENCES `modelo` (`id_modelo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,'aaaaaa','2.0',1,138,2020),(6,'kkk-lsk','4.0',8,97,2025),(7,'asd-asda','3.0',8,261,2024);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-18 14:42:05
