# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.35)
# Database: Bourse
# Generation Time: 2017-04-06 19:15:21 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table societe
# ------------------------------------------------------------

DROP TABLE IF EXISTS `societe`;

CREATE TABLE `societe` (
`id_societe` bigint(20) NOT NULL AUTO_INCREMENT,
`code_societe` varchar(255) NOT NULL DEFAULT '',
`nom_societe` varchar(255) NOT NULL DEFAULT '',
PRIMARY KEY (`id_societe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table ordre
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ordre`;

CREATE TABLE `ordre` (
  `id_ordre` bigint(20) NOT NULL AUTO_INCREMENT,
  `nbre_actions` int(11) NOT NULL,
  `prix_action` double NOT NULL,
  `qte` int(11) NOT NULL,
  `type_ordre` varchar(255) NOT NULL DEFAULT '',
  `id_societe` bigint(20) NOT NULL,
  `date_ordre` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_ordre`),
  KEY `id_societe` (`id_societe`),
  CONSTRAINT `ordre_ibfk_1` FOREIGN KEY (`id_societe`) REFERENCES `societe` (`id_societe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;







/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
