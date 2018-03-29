# FilRougeBack
API REST SPRING BOOT + JPA + SCRIPT SQL + PREPARESTATEMENT

### Installation du Projet Fil Rouge
 ###### Prérequis 
1. ![Alt Text](https://img.shields.io/badge/JDK-1.8.0__151-blue.svg)
2. ![Alt Text](https://img.shields.io/badge/Maven-3.5.2-green.svg)
3. ![Alt Text](https://img.shields.io/badge/MySQL-5.6-red.svg)
4. IDE Eclipse ou IntelliJ
 ###### Installation
1. Ouvrir le projet avec l'IDE
2. Update des dépendances avec MAVEN
3. Démarrer le fichier `FilRougeApplication`
 ###### Déroulement
 La Base de Données est créée si elle n'existe pas et la base est selectionnée
 
 ```SQL
 CREATE DATABASE IF NOT EXISTS `police_app` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `police_app`;
 ```
 
 Les Tables sont crées si elle n'existe pas
 Exemple :
 
 ```SQL
 CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentary` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 ```

## Schema Base de Données MySql
 
Schema: ![Alt Text](https://github.com/stephp30/FilRougeBack/blob/master/img/SchemaBDD.PNG)


