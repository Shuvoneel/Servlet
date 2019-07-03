-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.43-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema imamiapub
--

CREATE DATABASE IF NOT EXISTS imamiapub;
USE imamiapub;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) NOT NULL,
  `cat_desc` varchar(200) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_id`,`cat_name`,`cat_desc`) VALUES 
 (1,'Book','Production'),
 (2,'Electronic Devices','Purchase'),
 (3,'Automotive & Motorbike','Purchase'),
 (4,'Electronic Accessories','Purchase'),
 (5,'Electronic Devices','Purchase'),
 (6,'Health & Beauty','Purchase'),
 (7,'Sports & Outdoor','Purchase'),
 (8,'TV & Home Appliances','Purchase'),
 (9,'Watches & Jewellery','Purchase');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `delivary_cost`
--

DROP TABLE IF EXISTS `delivary_cost`;
CREATE TABLE `delivary_cost` (
  `delivary_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zone_name` varchar(45) NOT NULL,
  `delivary_cost` double NOT NULL,
  PRIMARY KEY (`delivary_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivary_cost`
--

/*!40000 ALTER TABLE `delivary_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivary_cost` ENABLE KEYS */;


--
-- Definition of table `pro_order`
--

DROP TABLE IF EXISTS `pro_order`;
CREATE TABLE `pro_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pro_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  `order_qty` int(10) unsigned NOT NULL,
  `order_price` double NOT NULL,
  `total_price` double NOT NULL,
  `order_status` varchar(45) NOT NULL DEFAULT '"N"',
  `delivary_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_pro_order_user_id` (`user_id`),
  KEY `FK_pro_order_delivary_id` (`delivary_id`),
  CONSTRAINT `FK_pro_order_delivary_id` FOREIGN KEY (`delivary_id`) REFERENCES `delivary_cost` (`delivary_id`),
  CONSTRAINT `FK_pro_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro_order`
--

/*!40000 ALTER TABLE `pro_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order` ENABLE KEYS */;


--
-- Definition of table `pro_order_details`
--

DROP TABLE IF EXISTS `pro_order_details`;
CREATE TABLE `pro_order_details` (
  `order_details_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `pro_id` int(10) unsigned NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_details_id`),
  KEY `FK_pro_order_details_order_id` (`order_id`),
  KEY `FK_pro_order_details_pro_id` (`pro_id`),
  CONSTRAINT `FK_pro_order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `pro_order` (`order_id`),
  CONSTRAINT `FK_pro_order_details_pro_id` FOREIGN KEY (`pro_id`) REFERENCES `product` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro_order_details`
--

/*!40000 ALTER TABLE `pro_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order_details` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pro_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sub_cat_id` int(10) unsigned NOT NULL,
  `pro_name` varchar(45) NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  `pro_price` double NOT NULL,
  `pro_url` varchar(45) NOT NULL,
  `pro_desc` varchar(200) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FK_product_sub_cat_id` (`sub_cat_id`),
  CONSTRAINT `FK_product_sub_cat_id` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pro_id`,`sub_cat_id`,`pro_name`,`pro_qty`,`pro_price`,`pro_url`,`pro_desc`) VALUES 
 (10,10,'Xiaomi Redmi Note 7',20,19999,'Xiaomi Redmi Note 7.jpg','Xiaomi Redmi Note 7 - 6.3\" - 4GB RAM - 64GB ROM - 48MP + 5MP AI Dual Rear Camera'),
 (11,10,'Nokia 4.2 Smart Phone',20,13999,'Nokia 4.2 Smart Phone.jpg','Nokia 4.2 Smart Phone 3/32 GB - Black'),
 (12,10,'Infinix Smart 2 Pro X5514D',20,7999,'Infinix Smart 2 Pro X5514D.jpg','nfinix Smart 2 Pro X5514D - Smartphone 5.5\" 2GB RAM - 16GB ROM - 13MP + 8MP Camera - Sandstone Black'),
 (13,10,'Symphony Z15',20,49999,'Symphony-Z15-300x300.jpg','Symphony-Z15-300x300 4GB Ram'),
 (14,10,'Samsung Galaxy A50',20,24999,'Samsung-Galaxy-A50-Black-600x508.jpg','First Release: March 2019 Status: ? Available Colors: Black, White, Blue'),
 (15,10,'Samsung Galaxy A6+',20,26999,'Samsung-Galaxy-A6-Plus-new-300x300.jpg','First Release: March 2019 Status: ? Available Colors: Black, White, Blue'),
 (16,10,'vivo-y12_thumb',20,15999,'vivo-y12_thumb.jpg','Network Type GSM / HSPA / LTE Network 2G GSM 850 / 900 / 1800 / 1900 - SIM 1 & SIM 2 Network 3G HSDPA 850 / 900 / 2100 Network 4G LTE band 1(2100), 3(1800), 5(850), 40(2300), 41(2500)'),
 (17,10,'Nokia 2.2',20,15999,'nokia-22.jpg','Network Type GSM / HSPA / LTE Network 2G GSM 850 / 900 / 1800 / 1900 - SIM 1 & SIM 2 (Dual SIM model only) Network 3G HSDPA 850 / 900 / 2100 Network 4G LTE'),
 (18,10,'giant_77118',20,14999,'giant_77118.jpg','Xiaomi redmi note 6 pro smart phone has octa core processor, 4GB RAM, 64 GB internal memory'),
 (19,9,'Asus E203',20,35000,'Asus E203.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (20,9,'Dell Optiplex 780 Desktop PC',20,35000,'Dell Optiplex 780 Desktop PC.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (21,9,'HP Folio 9480m',20,45000,'HP Folio 9480m.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (22,9,'HP Pavilion 15',20,55000,'HP Pavilion 15.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (23,9,'HP Pavilion All-in-One',20,65000,'HP Pavilion All-in-One.png','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (24,9,'HP Pavilion',20,40000,'HP Pavilion.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (25,9,'Huawei MateBook X Signature',20,80000,'Huawei MateBook X Signature.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (26,9,'VivoBook S Series',20,35000,'VivoBook S Series.jpg','Product Type Computers > Laptop Warranty Call for warranty service Terms & condition applied.  Payment Mode ? Cash On Delivery (COD) Delivery Time Estimated Delivery in 48-72 Hours'),
 (27,1,'QuranDarshanPart-1',20,250,'QuranDarshanPart-1.png','Writter : Sufi Sador Uddin Ahmed Chisty'),
 (28,1,'QuranDarshanPart-1',20,250,'QuranDarshanPart-1.png','Writter : Sufi Sador Uddin Ahmed Chisty Publication : Imamia Chisti Publication'),
 (29,1,'QuranDarshanPart-2',20,250,'QuranDarshanPart-2.png','Writter : Sufi Sador Uddin Ahmed Chisty Publication : Imamia Chisti Publication'),
 (30,1,'QuranDarshanPart-3',20,250,'QuranDarshanPart-3.png','Writter : Sufi Sador Uddin Ahmed Chisty Publication : Imamia Chisti Publication'),
 (31,1,'Qurbani',20,150,'Qurbani.png','Writter : Sufi Sador Uddin Ahmed Chisty Publication : Imamia Chisti Publication'),
 (32,1,'SiamDarson',20,150,'SiamDarson.png','Writter : Sufi Sador Uddin Ahmed Chisty Publication : Imamia Chisti Publication'),
 (33,1,'ChistiUdan',20,200,'ChistiUdan.png','Writter : Shapir  Chisty Publication : Imamia Chisti Publication'),
 (34,1,'JillurQuran',20,200,'JillurQuran.png','Writter : Liacot Ali Publication : Imamia Chisti Publication'),
 (35,4,'UM Runner Renegade',20,250000,'um-runner-renegade-sport-image2.jpg','Engine	150cc (liquid-cooled) Top Speed	120 Kmph (approx) Mileage	35 Kmpl (combined)'),
 (36,4,'UM Runner Renegade Command',20,240000,'runner_royal_plus_image2.jpg','Engine	150cc (liquid-cooled) Top Speed	120 Kmph (approx) Mileage	35 Kmpl (combined)'),
 (37,4,'UM Runner Xtreet R150',20,160000,'runner_turbo_125_image2.jpg','Engine	150 cc (air-cooled) Top Speed	98 Kmph (approx) Mileage	45 Kmpl (combined)'),
 (38,4,'Runner Knight Rider 150',20,140000,'um-runner-renegade-commando-image2.jpg','Engine	150 cc (air-cooled) Top Speed	130 Kmph (approx) Mileage	50 Kmpl (combined)'),
 (39,4,'Runner Turbo 125',20,142000,'um-runner-renegade-sport-image2.jpg','Engine	150 cc (air-cooled) Top Speed	130 Kmph (approx) Mileage	50 Kmpl (combined)'),
 (40,4,'Runner Royal Plus',20,91000,'um-runner-xtreet-r150-image2.jpg','Engine	110 cc (air-cooled) Top Speed	85 Kmph (approx) Mileage	50 Kmpl (combined)'),
 (41,4,'Runner Bullet',20,95000,'um-runner-xtreet-r150-image2.jpg','Engine	110 cc (air-cooled) Top Speed	85 Kmph (approx) Mileage	50 Kmpl (combined)'),
 (42,4,'Runner Cheeta',20,79000,'runner_cheeta_image2.jpg','Engine	110 cc (air-cooled) Top Speed	85 Kmph (approx) Mileage	50 Kmpl (combined)');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `req_date` date NOT NULL,
  `contact_no` varchar(11) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_shop_user_role_id` (`role_id`),
  CONSTRAINT `FK_shop_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shop_user`
--

/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;


--
-- Definition of table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `sub_cat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cat_id` int(10) unsigned NOT NULL,
  `sub_cat_name` varchar(45) NOT NULL,
  `sub_cat_desc` varchar(45) NOT NULL,
  PRIMARY KEY (`sub_cat_id`),
  KEY `FK_sub_category_cat_id` (`cat_id`),
  CONSTRAINT `FK_sub_category_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_category`
--

/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` (`sub_cat_id`,`cat_id`,`sub_cat_name`,`sub_cat_desc`) VALUES 
 (1,1,'Darson','Sufi Sadur Uddin Ahmed Chisti'),
 (2,2,'Console Gaming','Video, Gaming & Wearables'),
 (3,2,'Cameras','DSLR'),
 (4,3,'Motorcycle','Bick'),
 (5,4,'Audio','Audio Accessories'),
 (6,4,'Computer Accessories','Computer Accessories'),
 (7,4,'Mobile Accessories','Mobile Accessories'),
 (8,4,'Printers & Accessories','Printers & Accessories'),
 (9,2,'Computer','Laptop & Desktop'),
 (10,2,'Mobile','Mobile & Tab'),
 (11,6,'Hair Care','Hair Care'),
 (12,6,'Makeup','Makeup'),
 (13,7,'Outdoor Recreation','Outdoor Recreation'),
 (14,7,'Shoes & Clothing','Shoes & Clothing'),
 (15,7,'Team Sports','Team Sports'),
 (16,8,'Cooling & Heating','Cooling & Heating'),
 (17,8,'Televisions','Televisions'),
 (18,9,'Jewellery','Jewellery'),
 (19,9,'Watches','Watches'),
 (20,3,'Automotive','car');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
