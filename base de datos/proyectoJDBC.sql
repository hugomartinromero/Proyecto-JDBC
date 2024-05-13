DROP DATABASE IF EXISTS proyectoJDBC;
CREATE DATABASE proyectoJDBC;

USE proyectoJDBC;

CREATE TABLE alumno (
    dni VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    fechanacimiento DATE
);

CREATE TABLE cursoescolar (
    idcursoescolar INT AUTO_INCREMENT PRIMARY KEY,
    anioinicio INT,
    aniofin INT
);

CREATE TABLE profesor (
    idprofesor INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    especialidad VARCHAR(50)
);

CREATE TABLE modulo (
    codigoModulo VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    numerohoras INT,
    cursoescolarid INT,
    profesorid INT,
    FOREIGN KEY (cursoescolarid) REFERENCES cursoescolar(idcursoescolar),
    FOREIGN KEY (profesorid) REFERENCES profesor(idprofesor)
);

CREATE TABLE matricula (
    alumnodni VARCHAR(20),
    cursoescolarid INT,
    PRIMARY KEY (alumnodni, cursoescolarid),
    FOREIGN KEY (alumnodni) REFERENCES alumno(dni),
    FOREIGN KEY (cursoescolarid) REFERENCES cursoescolar(idcursoescolar)
);

CREATE TABLE examen (
    idexamen INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50),
    numeropreguntas INT,
    fecharealizacion DATE,
    codigoModulo VARCHAR(20),
    FOREIGN KEY (codigoModulo) REFERENCES modulo(codigoModulo)
);

CREATE TABLE preguntas (
    idpregunta INT AUTO_INCREMENT PRIMARY KEY,
    examenid INT,
    enunciado VARCHAR(50),
    respuestacorrecta VARCHAR(50),
    FOREIGN KEY (examenid) REFERENCES examen(idexamen)
);

CREATE TABLE respuestas_alumno (
    alumnoid VARCHAR(20),
    examenid INT,
    preguntaid INT,
    respuestadada VARCHAR(50),
    nota DECIMAL(5, 2),
    PRIMARY KEY (alumnoid, examenid, preguntaid),
    FOREIGN KEY (alumnoid) REFERENCES alumno(dni),
    FOREIGN KEY (examenid) REFERENCES examen(idexamen),
    FOREIGN KEY (preguntaid) REFERENCES preguntas(idpregunta)
);