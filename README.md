# FilRougeBack
API REST SPRING BOOT + JPA + SCRIPT SQL + PREPARESTATEMENT

### Installation du Projet Fil Rouge
 ###### Prérequis 
1. ![Alt Text](https://img.shields.io/badge/JDK-1.8.0__151-blue.svg)
2. ![Alt Text](https://img.shields.io/badge/Maven-3.5.2-green.svg)
3. ![Alt Text](https://img.shields.io/badge/MySQL-5.6-red.svg)
4. IDE Eclipse ou IntelliJ
 ###### Démarrage
1. Ouvrir le projet avec l'IDE
2. Update des dépendances avec MAVEN
3. Modifier les propriétés MySQL du fichier `application.properties` en fonction de l'environnement du poste d'execution
4. Démarrer l'application
###### Ou
Démmarrer directement le fichier `filRouge-0.0.1-SNAPSHOT.jar` dans le dossier target avec la commande  
`java -jar .\filRouge-0.0.1-SNAPSHOT.jar`


### Initialisation
 ###### Schema.sql
 * La Base de Données est créée si elle n'existe pas et la base est selectionnée
 
 ```SQL
 CREATE DATABASE IF NOT EXISTS `police_app` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `police_app`;
 ```
 
* Les Tables sont crées si elle n'existe pas  
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
 ###### Data.sql
 * Un jeux de données de test est chargé en base par défaut  
 Exemple :
 ```SQL
 INSERT IGNORE INTO `police_case` (`id`,`name`,`description`) VALUES (1,'avion détouné','mi, ac mattis velit justo nec')
 ```
 
 ### Utilisation des API
 ##### Routes
 ###### CASE
 * http://localhost:8080/api/case
 * http://localhost:8080/api/case/{id}
 ###### VEHICULE
 * http://localhost:8080/api/vehicule
 * http://localhost:8080/api/vehicule/{id}
 ###### PEOPLE
 * http://localhost:8080/api/people
 * http://localhost:8080/api/people/{id}
 ###### WEAPON
 * http://localhost:8080/api/weapon
 * http://localhost:8080/api/weapon/{id}
 ###### PIECE OF EVIDENCE
 * http://localhost:8080/api/piece
 * http://localhost:8080/api/piece/{id}
 

## Schema Base de Données MySql
 
Schema: ![Alt Text](https://github.com/stephp30/FilRougeBack/blob/master/img/SchemaBDD.PNG)


