DROP DATABASE IF EXISTS proyectoJDBC;
CREATE DATABASE proyectoJDBC;

USE proyectoJDBC;

CREATE TABLE persona (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(9)
);

CREATE TABLE alumno (
    dni VARCHAR(9) PRIMARY KEY,
    fechanacimiento DATE,
    FOREIGN KEY (dni) REFERENCES persona(dni) ON DELETE CASCADE
);

CREATE TABLE profesor (
    dni VARCHAR(9) PRIMARY KEY,
    administrador BOOLEAN,
    FOREIGN KEY (dni) REFERENCES persona(dni) ON DELETE CASCADE
);

CREATE TABLE cursoescolar (
    idcursoescolar INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    anioinicio INT,
    aniofin INT
);

CREATE TABLE matricula (
    alumnodni VARCHAR(9),
    cursoescolarid INT,
    PRIMARY KEY (alumnodni, cursoescolarid),
    FOREIGN KEY (alumnodni) REFERENCES alumno(dni),
    FOREIGN KEY (cursoescolarid) REFERENCES cursoescolar(idcursoescolar)
);

CREATE TABLE modulo (
    codigoModulo INT PRIMARY KEY,
    nombre VARCHAR(100),
    numerohoras INT,
    profesordni VARCHAR(9),
    FOREIGN KEY (profesordni) REFERENCES profesor(dni)
);

CREATE TABLE modulosCurso (
    codigoModulo INT,
    idcursoescolar INT,
    PRIMARY KEY (codigoModulo, idcursoescolar),
    FOREIGN KEY (idcursoescolar) REFERENCES cursoescolar(idcursoescolar),
    FOREIGN KEY (codigoModulo) REFERENCES modulo(codigoModulo)
);

CREATE TABLE examen (
    idexamen INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    tema INT,
    codigoModulo INT,
    FOREIGN KEY (codigoModulo) REFERENCES modulo(codigoModulo)
);

CREATE TABLE preguntas (
    idpregunta INT AUTO_INCREMENT PRIMARY KEY,
    examenid INT,
    enunciado VARCHAR(1000),
    respuestacorrecta VARCHAR(1000),
    FOREIGN KEY (examenid) REFERENCES examen(idexamen)
);

CREATE TABLE respuestasAlumno (
    alumnodni VARCHAR(9),
    preguntaid INT,
    respuestadada VARCHAR(1000),
    nota DECIMAL(5, 2),
    PRIMARY KEY (alumnodni, preguntaid),
    FOREIGN KEY (alumnodni) REFERENCES alumno(dni),
    FOREIGN KEY (preguntaid) REFERENCES preguntas(idpregunta)
);
