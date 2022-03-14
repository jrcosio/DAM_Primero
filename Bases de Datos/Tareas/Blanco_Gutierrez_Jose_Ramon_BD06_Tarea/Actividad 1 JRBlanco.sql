/*                             Actividad 1.
Crear un procedimiento que permita cambiar a todos los agentes de una familia 
determinada (familia origen) a otra familia (familia destino).

El procedimiento tendr� la siguiente cabecera 
CambiarAgentesFamilia( id_FamiliaOrigen, id_FamiliaDestino),  donde cada uno 
de los argumentos corresponde a un identificador de Familia. Cambiar� la columna  
Identificador de Familia de todos los agentes, de la tabla AGENTES, que 
pertenecen a la Familia con c�digo id_FamiliaOrigen por el c�digo id_FamiliaDestino

Previamente comprobar� que ambas familias existen y que no son iguales.

Para la comprobaci�n de la existencia de las familias se puede utilizar un 
cursor variable, o contar el n�mero de filas y en caso de que no exista, 
se visualizar� el mensaje correspondiente mediante una excepci�n del tipo 
RAISE_APPLICATION_ERROR. Tambi�n se mostrar� un mensaje en caso de que ambos 
argumentos tengan el mismo valor.         

El procedimiento visualizar�  el mensaje "Se han trasladado XXX agentes 
de la familia  XXXXXX a la familia ZZZZZZ" donde XXX es el n�mero de agentes 
que se han cambiado de familia, XXXXXX es el nombre de la familia origen y 
ZZZZZZ es el nombre de la familia destino. */

-- Jos� Ram�n Blanco Guti�rrez

create or replace procedure CambiarAgentesFamilia( id_FamiliaOrigen familias.identificador%TYPE, id_FamiliaDestino familias.identificador%TYPE) 
is
    -- Declaraci�n de variables y cursores --
    type c_compruebaFamilia is ref cursor return FAMILIAS%ROWTYPE; --Cursor variable
    c_familia c_compruebaFamilia;
    filaFamilia FAMILIAS%rowtype;
    
    nombreFamiliaOrigen familias.nombre%TYPE;   -- Para guardar el nombre de la familia de Origen
    nombreFamiliaDestino familias.nombre%TYPE;  -- Para guardar el nombre de la familia de Destino
    contadorCambios number;                     -- Para guardar el numero de cambios que se hacen
    
begin
    -- Comprobamos que son diferentes los ID
    if id_FamiliaOrigen = id_FamiliaDestino then
        raise_application_error(-20000, 'Los parametros son iguales');
    end if;
    -- Comprobamos que el id_familiaOrigen existe
    open c_familia for select * from FAMILIAS where identificador=id_familiaorigen;
        fetch c_familia into filaFamilia;
        if c_familia%notfound then 
            raise_application_error(-20001, 'Id Origen no existe'); 
        end if;
        nombreFamiliaOrigen := filaFamilia.nombre; -- Obtener el nombre de la Familia Origen
    close c_familia;
     -- Comprobamos que el id_familiaDestino existe
    open c_familia for select * from FAMILIAS where identificador=id_FamiliaDestino;
        fetch c_familia into filaFamilia;
        if c_familia%notfound then 
            raise_application_error(-20002, 'Id Destino no existe'); 
        end if;
        nombreFamiliaDestino  := filaFamilia.nombre; -- Obtener el nombre de la Familia Destino
    close c_familia;
    -- Contamos los registros que tiene Agentes que familia son igual al parametro Origen
    select count(*) into contadorCambios from AGENTES where familia=id_FamiliaOrigen;
    if contadorcambios > 0 then 
        -- Cambiamos la familia de la tabla agentes
        update AGENTES set familia=id_FamiliaDestino where familia=id_FamiliaOrigen;
        dbms_output.put_line('-------------------------------------------------------------------------------');
        dbms_output.put_line('Se han trasladado ' || contadorCambios || 
                             ' agentes de la familia ' || nombrefamiliaorigen || 
                             ' a la familia ' || nombrefamiliadestino);
        dbms_output.put_line('-------------------------------------------------------------------------------');
    else
        dbms_output.put_line('-------------------------------------------------------------------------------');
        dbms_output.put_line('En la tabla Agentes no hay ning�n registro de la familia ' || nombrefamiliaorigen);
        dbms_output.put_line('-------------------------------------------------------------------------------'); 
    end if;
end;


-- Prueba del procedimiento --
set SERVEROUTPUT on;

begin
    CambiarAgentesFamilia(211,21);
    -- CambiarAgentesFamilia(11,212);
end;


