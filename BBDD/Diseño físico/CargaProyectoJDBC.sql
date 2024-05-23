USE proyectoJDBC;
INSERT INTO persona (dni, nombre, apellidos, telefono) 
VALUES 
('11111111A', 'Rubén', 'Camacho Gómez', '654987321'),
('22222222B', 'Manuel', 'Castro Fernández', '654987321'),
('33333333C', 'Francisco Javier', 'Coronel Chaves', '654987321'),
('44444444D', 'Ricardo', 'Delgado Vaquero', '654987321'),
('55555555E', 'Pablo', 'Forero León', '654987321'),
('66666666F', 'Jaime', 'López San José', '654987321'),
('77777777G', 'Hugo', 'Martín Romero', '654987321'),
('88888888H', 'Patricia', 'Martínez Fernández', '654987321'),
('99999999I', 'Alejandro', 'Molina Tendero', '654987321'),
('11111111J', 'Pedro', 'Ramírez González', '654987321'),
('22222222K', 'Carlos', 'Rasero Martínez', '654987321'),
('33333333L', 'Manuel', 'Santos Rivero', '654987321'),
('44444444M', 'María', 'Solís Rodríguez', '654987321'),
('55555555N', 'Angélica', 'Mora Núñez', '654987321'),
('66666666O', 'Gema', 'Godínez Ramírez', '654987321');

INSERT INTO alumno (dni, fechanacimiento) 
VALUES 
('11111111A', '2002-03-15'),
('22222222B', '2003-08-20'),
('33333333C', '2001-11-25'),
('44444444D', '2000-06-10'),
('55555555E', '2002-09-18'),
('66666666F', '2003-02-28'),
('77777777G', '2001-04-05'),
('88888888H', '2000-10-15'),
('99999999I', '2003-07-20'),
('11111111J', '2002-11-12'),
('22222222K', '2001-08-25'),
('33333333L', '2000-05-30'),
('44444444M', '1999-10-20');

INSERT INTO profesor (dni, administrador) 
VALUES 
('55555555N', TRUE),
('66666666O', FALSE);

INSERT INTO cursoescolar (nombre, anioinicio, aniofin) 
VALUES 
('1DAM', 2023, 2024),
('2DAM', 2024, 2025);

INSERT INTO modulo (codigoModulo, nombre, numerohoras, profesordni) 
VALUES 
(0484, 'Base de datos', 192, '55555555N'),
(0487, 'Entornos de desarrollo', 96, '55555555N'),
(0373, 'Lenguajes de marcas y sistemas de gestión de información', 128, '66666666O'),
(0485, 'Programación', 256, '55555555N'),
(0483, 'Sistemas informáticos', 192, '66666666O');

INSERT INTO modulosCurso (codigoModulo, idcursoescolar) 
VALUES 
(0484, 1),
(0487, 1),
(0373, 1),
(0485, 1),
(0483, 1);

INSERT INTO matricula (alumnodni, cursoescolarid) 
VALUES 
('11111111A', 1),
('22222222B', 1),
('33333333C', 1),
('44444444D', 1),
('55555555E', 1),
('66666666F', 1),
('77777777G', 1),
('88888888H', 1),
('99999999I', 1),
('11111111J', 1),
('22222222K', 1),
('33333333L', 1),
('44444444M', 1);

INSERT INTO examen (titulo, tema, codigoModulo) 
VALUES 
('Examen de Base de datos', 1, '0484'),
('Examen de Entornos de desarrollo', 3, '0487'),
('Examen de Lenguajes de marcas y sistemas de gestión de información', 2, '0373'),
('Examen de Programación', 5, '0485'),
('Examen de Sistemas informáticos', 4, '0483');

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
