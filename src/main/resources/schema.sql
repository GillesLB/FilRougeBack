
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `police_app`
--
CREATE DATABASE IF NOT EXISTS `police_app` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `police_app`;

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentary` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `fingerprint`
--

CREATE TABLE IF NOT EXISTS `fingerprint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `fingerprint` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `people_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjy0onbj48525u07mvnkyv011` (`people_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `people`
--

CREATE TABLE IF NOT EXISTS `people` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `dna` varchar(255) DEFAULT NULL,
  `eye_color` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `hair_color` varchar(255) DEFAULT NULL,
  `hair_style` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `postal_zip` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `size` double DEFAULT NULL,
  `skin_color` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `tatoo` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE IF NOT EXISTS `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `big` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `piece_of_evidence`
--

CREATE TABLE IF NOT EXISTS `piece_of_evidence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case`
--

CREATE TABLE IF NOT EXISTS `police_case` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creating_date` datetime DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status_case` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_people`
--

CREATE TABLE IF NOT EXISTS `police_case_people` (
  `police_case_id` bigint(20) NOT NULL,
  `people_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`people_id`),
  KEY `FKfbrasipvsxh1ffgymmtrfbk1h` (`people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_photo`
--

CREATE TABLE IF NOT EXISTS `police_case_photo` (
  `police_case_id` bigint(20) NOT NULL,
  `photo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`photo_id`),
  KEY `FK6owspcu8dewyk5kyuxbnghol1` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_piece_of_evidence`
--

CREATE TABLE IF NOT EXISTS `police_case_piece_of_evidence` (
  `police_case_id` bigint(20) NOT NULL,
  `piece_of_evidence_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`piece_of_evidence_id`),
  KEY `FK768ayehick4uk6uinillrs65y` (`piece_of_evidence_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_user`
--

CREATE TABLE IF NOT EXISTS `police_case_user` (
  `police_case_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`user_id`),
  KEY `FK566wwbt8yef8jsyorjawc9668` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_vehicule`
--

CREATE TABLE IF NOT EXISTS `police_case_vehicule` (
  `police_case_id` bigint(20) NOT NULL,
  `vehicule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`vehicule_id`),
  KEY `FKtpwav5urw3rmynp3lpnlpeaix` (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `police_case_weapon`
--

CREATE TABLE IF NOT EXISTS `police_case_weapon` (
  `police_case_id` bigint(20) NOT NULL,
  `weapon_id` bigint(20) NOT NULL,
  PRIMARY KEY (`police_case_id`,`weapon_id`),
  KEY `FKdgs21n7kpc8hpwdagybrn1q5d` (`weapon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rule` varchar(10) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `license_plate` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `weapon`
--

CREATE TABLE IF NOT EXISTS `weapon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modele` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

