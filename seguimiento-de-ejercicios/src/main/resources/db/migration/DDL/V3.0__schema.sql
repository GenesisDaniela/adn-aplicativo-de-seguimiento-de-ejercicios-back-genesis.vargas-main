CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `peso` float DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `ejercicio` (
  `id_ejercicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `seccion_cuerpo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio`)
);

CREATE TABLE `rutina` (
  `id_rutina` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` longtext NOT NULL,
  `objetivo` text NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_rutina`),
  KEY `rutina_usuario_FK` (`usuario`),
  CONSTRAINT `rutina_usuario_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `plan` (
  `id_plan` int(11) NOT NULL AUTO_INCREMENT,
  `rutina` int(11) NOT NULL,
  `ejercicio` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `series` tinyint(4) NOT NULL,
  `repeticiones` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_plan`),
  KEY `plan_rutina_FK` (`rutina`),
  KEY `plan_ejercicio_FK` (`ejercicio`),
  CONSTRAINT `plan_ejercicio_FK` FOREIGN KEY (`ejercicio`) REFERENCES `ejercicio` (`id_ejercicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `plan_rutina_FK` FOREIGN KEY (`rutina`) REFERENCES `rutina` (`id_rutina`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
