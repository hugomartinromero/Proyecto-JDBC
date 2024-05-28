-- Consultas
-- 1. Consulta para obtener el nombre del alumno y el nombre del curso de todos los alumnos matriculados.
SELECT persona.nombre AS Alumno, cursoescolar.nombre AS Curso
FROM persona
JOIN alumno ON persona.dni = alumno.dni
JOIN matricula ON alumno.dni = matricula.alumnodni
JOIN cursoescolar ON matricula.cursoescolarid = cursoescolar.idcursoescolar;

-- 2. Consulta para contar el número de alumnos matriculados en cada curso escolar y ordenar por el número de alumnos en orden descendente
SELECT cursoescolar.nombre AS 'Curso', COUNT(matricula.alumnodni) AS 'Nº Alumnos'
FROM cursoescolar
LEFT JOIN matricula ON cursoescolar.idcursoescolar = matricula.cursoescolarid
GROUP BY cursoescolar.nombre
ORDER BY 'Nº Alumnos' DESC;

-- 3. Consulta para obtener el número de módulos por curso.
SELECT cursoescolar.nombre AS Curso, COUNT(modulosCurso.codigoModulo) AS 'Nº Módulos'
FROM cursoescolar
LEFT JOIN modulosCurso ON cursoescolar.idcursoescolar = modulosCurso.idcursoescolar
GROUP BY cursoescolar.nombre;

-- 4. Consulta para obtener los nombres de los profesores que imparten módulos en un curso.
SELECT DISTINCT persona.nombre AS 'Profesor'
FROM persona
JOIN profesor ON persona.dni = profesor.dni
JOIN modulo ON profesor.dni = modulo.profesordni
JOIN modulosCurso ON modulo.codigoModulo = modulosCurso.codigoModulo
WHERE modulosCurso.idcursoescolar = (SELECT idcursoescolar FROM cursoescolar WHERE nombre = '1DAM');

-- 5. Consulta para obtener el número de exámenes por módulo.
SELECT modulo.nombre AS 'Módulo', COUNT(examen.idexamen) AS 'Total exámenes'
FROM examen
JOIN modulo ON examen.codigoModulo = modulo.codigoModulo
GROUP BY modulo.nombre;

-- Updates
-- 1. Actualizar del teléfono de un alumno.
UPDATE persona
SET telefono = '123121212'
WHERE dni = '7777777G';

-- 2. Actualizar el número de horas de un módulo.
UPDATE modulo
JOIN modulosCurso ON modulo.codigoModulo = modulosCurso.codigoModulo
SET numerohoras = '400'
WHERE modulo.nombre = 'Base de datos';

-- Delete
-- 1. Borra las matrículas de un alumno.
DELETE matricula
FROM matricula
JOIN persona ON matricula.alumnodni = persona.dni
WHERE persona.nombre = 'Pablo';

-- Vistas
-- 1. Vista con el nombre del alumno y el nombre del curso de los alumnos matriculados.
CREATE VIEW AlumnosMatriculadosCurso AS
SELECT persona.nombre AS Alumno, cursoescolar.nombre AS Curso
FROM persona
JOIN alumno ON persona.dni = alumno.dni
JOIN matricula ON alumno.dni = matricula.alumnodni
JOIN cursoescolar ON matricula.cursoescolarid = cursoescolar.idcursoescolar;
SELECT * FROM AlumnosMatriculadosCurso;

-- 2. Vista con el número de alumnos matriculados en cada curso.
CREATE VIEW NumeroAlumnosPorCurso AS
SELECT cursoescolar.nombre AS Curso, COUNT(matricula.alumnodni) AS 'Nº Alumnos'
FROM cursoescolar
LEFT JOIN matricula ON cursoescolar.idcursoescolar = matricula.cursoescolarid
GROUP BY cursoescolar.nombre
ORDER BY 'Nº Alumnos' DESC;
SELECT * FROM NumeroAlumnosPorCurso;

-- Procedimientos y funciones
-- 1. Procedimiento para insertar un nuevo alumno.
DELIMITER $$
CREATE PROCEDURE insertarAlumno (IN dni VARCHAR(9), IN nombre VARCHAR(50), IN apellidos VARCHAR(50), IN telefono VARCHAR(9), IN fechanacimiento DATE)
BEGIN
    INSERT INTO persona VALUES (dni, nombre, apellidos, telefono);
    INSERT INTO alumno VALUES (dni, fechanacimiento);
END $$
DELIMITER ;
CALL insertarAlumno('12341234B', 'Pepito', 'Caraalpargata', '123121212', '2000-01-01');

-- 2. Procedimiento que actualiza el nombre de un alumno.
DELIMITER $$
CREATE PROCEDURE actualizarNombrePersona(IN dniPersona VARCHAR(9), IN nombreNuevo VARCHAR(50))
BEGIN
    UPDATE persona
    SET nombre = nombreNuevo
    WHERE dni = dniPersona;
END $$
DELIMITER ;
CALL actualizarNombrePersona('12341234B', 'Pepa');

-- 3. Función para calcular la edad de un alumno.
DELIMITER $$
CREATE FUNCTION calcularEdad (dnibUSCAR VARCHAR(9))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN YEAR(CURRENT_DATE()) - YEAR((SELECT fechaNacimiento FROM alumno WHERE dni = dniBuscar));
END $$
DELIMITER ;
SELECT calcularEdad('77777777G');

-- Triggers
-- 1. Trigger que asegura que el número de alumnos matriculados en un curso se corresponda con el número de alumnos de la tabla cursoescolar.
DELIMITER $$
CREATE TRIGGER actualizarNumeroAlumnosDespuesDeleteMatricula
AFTER DELETE ON matricula
FOR EACH ROW
BEGIN
    UPDATE cursoescolar
    SET numAlumnos = (SELECT COUNT(*) FROM matricula WHERE cursoescolarid = OLD.cursoescolarid)
    WHERE idcursoescolar = OLD.cursoescolarid;
END $$
DELIMITER ;

-- 2. Trigger qeu verifica que la fecha de nacimiento no sea futura
DELIMITER $$
CREATE TRIGGER verificaFechaAntesInsertAlumno
BEFORE INSERT ON alumno
FOR EACH ROW
BEGIN
    IF NEW.fechaNacimiento > CURDATE() THEN
        SET NEW.fechaNacimiento = CURDATE();
    END IF;
END $$
DELIMITER ;