-- EJERCICIO 2:
-- A)  Modificar las tablas creadas en el ejercicio anterior siguiendo las indicaciones. 
--     Los ejercicios se incluirán en un script llamado ModificaTienda.sql.
--     Cada uno de ellos, como en el ejercicio anterior, irá precedido de un comentario con el enunciado.

-- Añadir a la tabla STOCK --
-- Una columna de tipo fecha llamada FechaUltimaEntrada que por defecto tome el valor de la fecha actual.
ALTER TABLE STOCK ADD FechaUltimaEntrada DATE DEFAULT SYSDATE;

-- Una columna llamada Beneficio que contendrá el tipo de porcentaje de beneficio que esa tienda aplica en ese producto.
-- Se debe controlar que el valor que almacene sea 1,2, 3, 4 o 5.
ALTER TABLE STOCK ADD Beneficio NUMBER(1) CHECK (Beneficio BETWEEN 1 AND 5);

-- En la tabla PRODUCTO --
-- Eliminar de la tabla producto la columna Descripción.
ALTER TABLE PRODUCTO DROP COLUMN Descripcion;

-- Añadir una columna llamada perecedero que únicamente acepte los valores: S o N.
ALTER TABLE PRODUCTO ADD Perecedero CHAR(1) CONSTRAINT ck_perecedero CHECK (Perecedero = 'S' OR Perecedero = 'N');

-- Modificar el tamaño de la columna Denoproducto a 50.
ALTER TABLE PRODUCTO MODIFY (Denoproducto VARCHAR2(50));

-- En la tabla FAMILIA --
-- Añadir una columna llamada IVA, que represente el porcentaje de IVA y únicamente pueda contener los valores 21,10,ó 4.
ALTER TABLE FAMILIA ADD IVA NUMBER(2) CONSTRAINT ck_iva CHECK (IVA=21 OR IVA=10 OR IVA=4);

-- En la tabla tienda
-- La empresa desea restringir el número de tiendas con las que trabaja,
-- de forma que no pueda haber más de una tienda en una misma zona (la zona se identifica por el código postal).
-- Definir mediante DDL las restricciones necesarias para que se cumpla en el campo correspondiente..
ALTER TABLE TIENDA MODIFY (CodigoPostal VARCHAR2(5) UNIQUE);

-- B) Renombra la tabla STOCK por PRODXTIENDAS.
RENAME STOCK TO PRODXTIENDAS;

-- C) Elimina la tabla FAMILIA y su contenido si lo tuviera.
DROP TABLE FAMILIA CASCADE CONSTRAINTS;

-- D) Crea un usuario llamado C##INVITADO siguiendo los pasos de la unidad 1 
CREATE USER C##INVITADO IDENTIFIED BY invitado;

-- y dale todos los privilegios sobre la tabla PRODUCTO.
GRANT ALL ON PRODUCTO TO C##INVITADO;


-- E) Retira los permisos de modificar la estructura de la tabla y borrar contenido de la tabla PRODUCTO al usuario anterior.
REVOKE DELETE, ALTER, UPDATE ON PRODUCTO FROM C##INVITADO;















    
