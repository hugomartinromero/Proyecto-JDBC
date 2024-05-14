DROP DATABASE IF EXISTS proyectoJDBC;
CREATE DATABASE proyectoJDBC;

USE proyectoJDBC;

-- Tabla alumno
CREATE TABLE alumno (
    dni VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    fechanacimiento DATE
);

-- Tabla Curso Escolar
CREATE TABLE cursoescolar (
    idcursoescolar INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    anioinicio INT,
    aniofin INT
);

-- Tabla Profesor
CREATE TABLE profesor (
    idprofesor INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    especialidad VARCHAR(50)
);

-- Tabla Módulo
CREATE TABLE modulo (
    codigoModulo VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100),
    numerohoras INT,
    cursoescolarid INT,
    profesorid INT,
    FOREIGN KEY (cursoescolarid) REFERENCES cursoescolar(idcursoescolar),
    FOREIGN KEY (profesorid) REFERENCES profesor(idprofesor)
);

-- Tabla Matrícula
CREATE TABLE matricula (
    alumnodni VARCHAR(20),
    cursoescolarid INT,
    PRIMARY KEY (alumnodni, cursoescolarid),
    FOREIGN KEY (alumnodni) REFERENCES alumno(dni),
    FOREIGN KEY (cursoescolarid) REFERENCES cursoescolar(idcursoescolar)
);

-- Tabla Examen
CREATE TABLE examen (
    idexamen INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    numeropreguntas INT,
    fecharealizacion DATE,
    codigoModulo VARCHAR(20),
    FOREIGN KEY (codigoModulo) REFERENCES modulo(codigoModulo)
);

-- Tabla Preguntas
CREATE TABLE preguntas (
    idpregunta INT AUTO_INCREMENT PRIMARY KEY,
    examenid INT,
    enunciado VARCHAR(1000),
    respuestacorrecta VARCHAR(1000),
    FOREIGN KEY (examenid) REFERENCES examen(idexamen)
);

-- Tabla Respuestas Alumno
CREATE TABLE respuestasAlumno (
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

INSERT INTO alumno (dni, nombre, apellidos, telefono, fechanacimiento) 
VALUES 
('11111111A', 'Rubén', 'Camacho Gómez', '654987321', '2002-03-15'),
('22222222B', 'Manuel', 'Castro Fernández', '654987321', '2003-08-20'),
('33333333C', 'Francisco Javier', 'Coronel Chaves', '654987321', '2001-11-25'),
('55555555E', 'Ricardo', 'Delgado Vaquero', '654987321', '2000-06-10'),
('66666666F', 'Pablo', 'Forero León', '654987321', '2002-09-18'),
('77777777G', 'Jaime', 'López San José', '654987321', '2003-02-28'),
('88888888H', 'Hugo', 'Martín Romero', '654987321', '2001-04-05'),
('99999999I', 'Patricia', 'Martínez Fernández', '654987321', '2000-10-15'),
('11111111J', 'Alejandro', 'Molina Tendero', '654987321', '2003-07-20'),
('22222222K', 'Pedro', 'Ramírez González', '654987321', '2002-11-12'),
('33333333L', 'Carlos', 'Rasero Martínez', '654987321', '2001-08-25'),
('44444444M', 'Manuel', 'Santos Rivero', '654987321', '2000-05-30'),
('55555555N', 'María', 'Solís Rodríguez', '654987321', '1999-10-20');

INSERT INTO cursoescolar (nombre, anioinicio, aniofin) 
VALUES 
('1DAM', 2023, 2024),
('2DAM', 2024, 2025);

INSERT INTO profesor (dni, nombre, apellidos, telefono, especialidad) 
VALUES 
('11111111A', 'Angélica', 'Mora Núñez', '654987321', "Base de datos"),
('22222222B', 'Gema', 'Godínez Ramírez', '654987321', "Sistemas informáticos");

INSERT INTO modulo (codigoModulo, nombre, numerohoras, cursoescolarid, profesorid) 
VALUES 
('0484', 'Base de datos', 192, 1, 1),
('0487', 'Entornos de desarrollo', 96, 1, 1),
('0373', 'Lenguajes de marcas y sistemas de gestión de información', 128, 1, 2),
('0485', 'Programación', 256, 1, 1),
('0483', 'Sistemas informáticos', 192, 1, 2);

INSERT INTO matricula (alumnodni, cursoescolarid) 
VALUES 
('11111111A', 1),
('22222222B', 1),
('33333333C', 1),
('55555555E', 1),
('66666666F', 1),
('77777777G', 1),
('88888888H', 1),
('99999999I', 1),
('11111111J', 1),
('22222222K', 1),
('33333333L', 1),
('44444444M', 1),
('55555555N', 1);

INSERT INTO examen (titulo, numeropreguntas, fecharealizacion, codigoModulo) 
VALUES 
('Examen de Base de datos', 3, now(), '0484'),
('Examen de Entornos de desarrollo', 3, now(), '0487'),
('Examen de Lenguajes de marcas y sistemas de gestión de información', 3, now(), '0373'),
('Examen de Programación', 3, now(), '0485'),
('Examen de Sistemas informáticos', 3, now(), '0483');

INSERT INTO preguntas (examenid, enunciado, respuestacorrecta) 
VALUES 
(1, '¿Qué es una clave primaria en una base de datos relacional?', 'Un campo que identifica de manera única a cada registro en una tabla'),
(1, '¿Cuál es el lenguaje estándar para realizar consultas a bases de datos relacionales?', 'SQL'),
(1, '¿Qué tipo de relación existe entre dos tablas cuando un registro de una tabla se relaciona con varios registros de otra tabla, pero un registro de la segunda tabla se relaciona con solo un registro de la primera tabla?', 'Relación uno a muchos'),
(2, '¿Qué es un IDE?', 'Entorno de Desarrollo Integrado'),
(2, '¿Qué es Git?', 'Un sistema de control de versiones'),
(2, '¿Qué es Docker?', 'Una plataforma de contenedores'),
(3, '¿Qué es XML?', 'Un lenguaje de marcado extensible'),
(3, '¿Cuál es la función principal de un sistema de gestión de bases de datos?', 'Almacenar y gestionar grandes volúmenes de datos'),
(3, '¿Qué es un DTD en XML?', 'Un tipo de documento que define la estructura y el tipo de datos que se pueden utilizar en un documento XML'),
(4, '¿Qué es un bucle?', 'Una estructura de control que repite un bloque de código varias veces'),
(4, '¿Cuál es el lenguaje de programación más utilizado en el desarrollo web del lado del cliente?', 'JavaScript'),
(4, '¿Qué es una función en programación?', 'Un bloque de código reutilizable que realiza una tarea específica'),
(5, '¿Qué es un sistema operativo?', 'Un software que actúa como intermediario entre el hardware y los programas de aplicación'),
(5, '¿Qué es un virus informático?', 'Un programa diseñado para infectar otros programas o archivos'),
(5, '¿Qué es la memoria RAM?', 'Una memoria de acceso aleatorio utilizada para almacenar datos y programas en ejecución');

select * from alumno;
select * from cursoescolar;
select * from profesor;
select * from modulo;
select * from matricula;
select * from examen;
select * from preguntas;