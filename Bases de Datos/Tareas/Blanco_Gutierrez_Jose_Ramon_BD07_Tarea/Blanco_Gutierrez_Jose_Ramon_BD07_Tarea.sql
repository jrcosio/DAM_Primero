/*
1.Crea el tipo de objetos "Personal" con los siguientes atributos:
    codigo INTEGER,
    dni VARCHAR2(10),
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    sexo VARCHAR2(1),
    fecha_nac DATE
*/
create or replace type Personal as object (
    codigo INTEGER,
    dni VARCHAR2(10),
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    sexo VARCHAR2(1),
    fecha_nac DATE
) not final;
/
/*
Crea, como tipo heredado de "Personal", el tipo de objeto "Responsable" con los siguientes atributos:

    tipo  CHAR ,
    antiguedad INTEGER 
*/
create or replace type Responsable under Personal(
    tipo  CHAR,
    antiguedad INTEGER,
    -- Defini�n de Constructor del punto 2
    constructor function Responsable(codigo INTEGER, nombre VARCHAR2, apellido1 VARCHAR2,  apellido2 VARCHAR2, tipo CHAR) return self as result,
    -- Definici�n de la funci�n del punto3
    member function getNombreCompleto return varchar2    
);
/
/*
Crea el tipo de objeto "Zonas" con los siguientes atributos:

    codigo INTEGER, 
    nombre VARCHAR2(20), 
    refRespon REF Responsable, 
    codigoPostal CHAR(5),
*/
create or replace type Zonas as object (
    codigo INTEGER, 
    nombre VARCHAR2(20), 
    refRespon REF Responsable, 
    codigoPostal CHAR(5),
    -- 9. Crea un m�todo MAP ordenarZonas para el tipo Zonas.
    map member function ordenarZonas return varchar2    
);
/
/*
Crea, como tipo heredado de "Personal", el tipo de objeto "Comercial" con los siguientes atributos:

    zonaComercial Zonas
*/
create or replace type Comercial under Personal(
    zonaComercial Zonas
);
/

/*
2.Crea un m�todo constructor para el tipo de objetos "Responsable", en el que se indiquen como par�metros el 
c�digo, nombre, primer apellido, segundo apellido y tipo. Este m�todo debe asignar al atributo apellidos los 
datos de primer apellido y segundo apellido que se han pasado como par�metros, uni�ndolos con un espacio entre ellos.
*/
create or replace type body Responsable as
    constructor function Responsable(codigo INTEGER, nombre VARCHAR2, apellido1 VARCHAR2,  apellido2 VARCHAR2, tipo CHAR) 
    return self as result
    is
        begin
            self.codigo := codigo;
            self.nombre := nombre;
            self.apellidos := apellido1 || ' ' || apellido2;
            self.tipo := tipo;
            return;
        end;
    -- 3. Crea un m�todo getNombreCompleto para el tipo de objetos Responsable que permita obtener su nombre completo con el formato apellidos nombre
    member function getNombreCompleto return varchar2
    is
        begin
            return (self.apellidos || ' ' || self.nombre);
        end;
end;
/
 
/*
4. Crea un tabla TablaResponsables de objetos  Responsable. Inserta en dicha tabla dos objetos  Responsable. 
codigo:  5
nombre: ELENA
apellidos:  POSTA LLANOS
sexo: F
dni: 51083099F
fecha_nac: 31/03/1975
tipo: N
antiguedad: 4

El segundo objeto "Responsable" debes crearlo usando el m�todo constructor que has realizado anteriormente. Debes usar los siguientes datos:

codigo: 6
nombre: JAVIER
apellidos: JARAMILLO HERNANDEZ
tipo: C
*/
create table TablaResponsables of Responsable (codigo PRIMARY KEY);

insert into TablaResponsables values(5,'51083099F','ELENA','POSTA LLANOS','F','31/03/1975','N',4);
-- Constructor definido
insert into TablaResponsables values(Responsable(6,'JAVIER','JARAMILLO','HERNANDEZ','C'));
/
/*-------------------------------------------------------------------------------------------------------------------*/

-- 5. Crea una colecci�n VARRAY llamada ListaZonas en la que se puedan almacenar hasta 10 objetos Zonas.
create or replace type ListaZonas is VARRAY(10) of Zonas;
-- 6. Crea una tabla TablaComerciales de objetos Comercial.
create table TablaComerciales of Comercial;

/
declare
    /*
    5. Guarda en una instancia listaZonas1 de dicha lista, dos Zonas
    codigo: 1 nombre: zona 1 refResponsable: Referencia al responsable  cuyo codigo es 5
    codigo postal: 06834
    
    codigo: 2 nombre: zona 2 refResponsable: Referencia al responsable cuyo DNI es 51083099F.
    codigo postal: 28003 
    */
    
    listaZonas1 ListaZonas; -- Instancia al VARRAY
    refRespon1 REF Responsable; -- Puntero a un Objeto Responsable
    refRespon2 REF Responsable; -- Puntero a un Objeto Responsable

    unComercial Comercial; -- Variable para almacenar un Comercial (ejecicio 7 y 8)
begin
    select REF(tr) into refRespon1 from tablaresponsables tr where tr.codigo=5;
    select REF(tr) into refRespon2 from tablaresponsables tr where tr.dni = '51083099F';
    
    listaZonas1 := ListaZonas(Zonas(1,'zona 1',refRespon1,'06834'),
                              Zonas(2,'zona 2',refrespon2,28003));        
    /* 
    6. Inserta en dicha tabla las siguientes filas:
    codigo: 100 dni: 23401092Z nombre: MARCOS apellidos: SUAREZ LOPEZ sexo: M fecha_nac: 30/3/1990
    zonacomercial: objeto creado anteriormente para la zona 1

    codigo: 102 dni: 6932288V nombre: ANASTASIA apellidos:  GOMES PEREZ sexo: F fecha_nac: 28/11/1984
    zonacomercial: objeto que se encuentre en la segunda posici�n de "listaZonas1" 
    */
    
    insert into TablaComerciales values(100,'23401092Z','MARCOS','SUAREZ LOPEZ','M','30/3/1990',listaZonas1(1));
    insert into TablaComerciales values(102,'6932288V','ANASTASIA','GOMES PEREZ','F','28/11/1984',listaZonas1(2));
    
    /*
    7. Obtener, de la tabla TablaComerciales, el Comercial que tiene el c�digo 100, asign�ndoselo a una variable unComercial 
    */
    select value(t) into unComercial from TablaComerciales t where t.codigo = 100;
     
    /*
    8. Modifica el c�digo del Comercial guardado en esa variable unComercial asignando el valor 101, 
    y su zona debe ser la segunda que se hab�a creado anteriormente. Inserta ese Comercial en la tabla TablaComerciales  
    */
    unComercial.codigo := 101;
    unComercial.zonaComercial := listazonas1(2);
    
    insert into tablacomerciales values(unComercial);
   
end;
/
/*
9. Crea un m�todo MAP ordenarZonas para el tipo Zonas. Este m�todo debe retornar el nombre completo del Responsable 
al que hace referencia cada zona. Para obtener el nombre debes utilizar el m�todo getNombreCompleto que se ha creado anteriormente 
*/
create or replace type body Zonas as
    map member function ordenarZonas return varchar2
    is
        responsable_temp Responsable;
    begin
        select Deref(self.refRespon) into responsable_temp from dual;  -- Leemos la el REF
        return responsable_temp.getNombreCompleto();
    end;
end;
/
/*
10.Realiza una consulta de la tabla TablaComerciales ordenada por zonaComercial para comprobar el funcionamiento del m�todo MAP.
*/
select * from tablacomerciales order by zonacomercial;



/*---- Zona de pruebas---*/
-- set SERVEROUTPUT on;
-- dbms_output.put_line(xxxxx);





