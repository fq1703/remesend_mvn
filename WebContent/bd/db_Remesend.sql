CREATE DATABASE IF NOT EXISTS remesend_db;
USE remesend_db;

CREATE TABLE `tbusuarios` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
   `USUARIO` varchar(255) DEFAULT NULL,
   `PASSWORD` varchar(255) DEFAULT NULL,
   `NOMBRE` varchar(255) DEFAULT NULL,
   `TIPOU` varchar(255) DEFAULT NULL,
         
  PRIMARY KEY (`ID_USUARIO`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `tbcompletardatos` (
  `ID_DATOS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` int(11),
   `NOMBRE` varchar(255) DEFAULT NULL,
   `CORREO` varchar(255) DEFAULT NULL,
   `PAIS` varchar(255) DEFAULT NULL,
   `CIUDAD` varchar(255) DEFAULT NULL,
   `DIRECCION` varchar(255) DEFAULT NULL,
   `COD_POST` varchar(255) DEFAULT NULL,
   `DNI` int(11) DEFAULT NULL,
   `DNAC` int(11) DEFAULT NULL,
   `MNAC` int(11) DEFAULT NULL,
   `ANAC` int(11) DEFAULT NULL,
   `TELEF` int(11) DEFAULT NULL,
      
  PRIMARY KEY (`ID_DATOS`),
  FOREIGN KEY (`ID_USUARIO`) references `tbusuarios` (`ID_USUARIO`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `tbusuarios` values (1, "jflores", "jflores", "JUAN DIEGO FLORES", 0);
INSERT INTO `tbusuarios` values (2, "gbram", "gbram", "GIACOMO BRAMBILLA", 0);
