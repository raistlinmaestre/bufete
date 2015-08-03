# bufete
Este programa gestiona una base de datos MySQL de un bufete de abogados. El programa asume que dicha base de datos exista localmente, por tanto para su uso abrá primero que crearla. Los pasos para crearla son los siguientes (desde MySQL o MariaDB):

CREATE DATABASE bufete;

USE bufete;

CREATE TABLE clientes (identificador CHAR(9) PRIMARY KEY, nombre VARCHAR(40) NOT NULL, apellido1 VARCHAR(40), apellido2 VARCHAR(40), juridica BOOL NOT NULL DEFAULT 0, anotaciones TINYTEXT);

CREATE TABLE domicilios (tipoVia TINYINT(2) UNSIGNED NOT NULL DEFAULT 0, domicilio VARCHAR(100) BINARY, portal SMALLINT UNSIGNED NULL, escalera CHAR NULL, letra CHAR NULL, codigo INT(5), localidad VARCHAR(40), provincia VARCHAR(30), identificador CHAR(9), FOREIGN KEY (identificador) REFERENCES clientes (identificador) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE procedimientos (archivo INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, numero VARCHAR(30), juzgado VARCHAR(30), tipo VARCHAR(30), judicial BOOL DEFAULT 0, anotaciones TINYTEXT, abierto BOOL, minuta FLOAT(8,2), pagado FLOAT(8,2), procurador VARCHAR(90), procuradorContrario VARCHAR(90), identificador CHAR(9), FOREIGN KEY (identificador) REFERENCES clientes (identificador) ON DELETE CASCADE ON UPDATE CASCADE);

Nota: No todos campos son utilizados en la presente versión del programa pero pueden ser usados en versiones posteriores.

El programa también hace uso del controlador JDBC, por lo cual deberá de estar instalado en la máquina que haga uso del mismo.
