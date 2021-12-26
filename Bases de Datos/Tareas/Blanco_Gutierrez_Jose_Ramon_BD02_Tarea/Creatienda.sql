-- José Ramón Blanco Gutiérrez - Bases de Datos - DAM
-- Ejercicio 1
-- Vamos a crear las tablas para una tienda virtual que distribuye productos agrupados en familias en varias tiendas.
-- Realiza un script llamado Creatienda.sql que implemente los ejercicios descritos a continuación.

-- TABLA FAMILIA => Contiene las familias a las que pertenecen los productos, como por ejemplo ordenadores, impresoras,etc.
CREATE TABLE FAMILIA ( 
    Codfamilia      NUMBER(3)       NOT NULL,
    Denofamilia     VARCHAR2(50)    NOT NULL UNIQUE,
    CONSTRAINT pk_fam_cod           PRIMARY KEY (Codfamilia)
);


-- TABLA PRODUCTO => contendrá información general sobre los productos que distribuye la empresa a las tiendas.
CREATE TABLE PRODUCTO (
    Codproducto     NUMBER(5)       NOT NULL,
    Denoproducto    VARCHAR2(20)    NOT NULL,
    Descripcion     VARCHAR2(100)           ,
    PrecioBase      NUMBER(8,2)     NOT NULL,
    PorcReposicion  NUMBER(3)               ,
    UnidadesMinimas NUMBER(4)       NOT NULL,
    Codfamilia      NUMBER(3)       NOT NULL,
    
    CONSTRAINT ck_preciobase        CHECK (PrecioBase > 0),
    CONSTRAINT ck_reposicion        CHECK (PorcReposicion > 0),
    CONSTRAINT ck_unidades_min      CHECK (UnidadesMinimas > 0),
    
    CONSTRAINT pk_pro_cod           PRIMARY KEY (Codproducto),
    
    CONSTRAINT fk_cod_fam           FOREIGN KEY (Codfamilia) REFERENCES FAMILIA(Codfamilia)
);

-- TABLA TIENDA=> contendrá información básica sobre las tiendas que distribuyen los productos.
CREATE TABLE TIENDA (
    Codtienda       NUMBER(3)       NOT NULL,
    Denotienda      VARCHAR2(20)    NOT NULL,
    Telefono        VARCHAR2(11)            ,
    CodigoPostal    VARCHAR2(5)     NOT NULL,
    Provincia       VARCHAR2(5)     NOT NULL,
    
    CONSTRAINT pk_tie_cod           PRIMARY KEY (Codtienda)
);

-- TABLA STOCK => Contendrá para cada tienda el número de unidades disponibles de cada producto.
--                La clave primaria está formada por la concatenación de los campos Codtienda y Codproducto.
CREATE TABLE STOCK (
    Codtienda       NUMBER(3)       NOT NULL,
    Codproducto     NUMBER(5)       NOT NULL,
    Unidades        NUMBER(6)       NOT NULL,
    
    CONSTRAINT ck_unidades CHECK (Unidades >= 0),
    
    CONSTRAINT pk_st_tienda_produc  PRIMARY KEY (Codtienda, Codproducto),
    
    CONSTRAINT fk_sto_codtienda     FOREIGN KEY (Codtienda)     REFERENCES TIENDA(Codtienda),
    CONSTRAINT fk_sti_codproduc     FOREIGN KEY (Codproducto)   REFERENCES PRODUCTO(Codproducto)
);

























