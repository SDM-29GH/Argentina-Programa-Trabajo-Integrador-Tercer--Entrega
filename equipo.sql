DROP DATABASE IF EXISTS pronostico_deportivo3;
CREATE DATABASE pronostico_deportivo3;
USE pronostico_deportivo3;

CREATE TABLE equipo (
	equipoId INT AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    PRIMARY KEY (equipoId)
);

INSERT INTO equipo (nombre, descripcion) VALUES ("Argentina", "Equipo Campeon Mundial 1978, 1986, 2023"),
("Francia", "Equipo Campeon Mundial 1978, 1986, 2023"),
("Brasil", "Equipo Campeon Mundial 1978, 1986, 2023"),
("España", "Equipo Campeon Mundial 1978, 1986, 2023"),
("Alemania", "Equipo Campeon Mundial 1978, 1986, 2023");

SELECT * FROM pronostico_deportivo3.equipo;