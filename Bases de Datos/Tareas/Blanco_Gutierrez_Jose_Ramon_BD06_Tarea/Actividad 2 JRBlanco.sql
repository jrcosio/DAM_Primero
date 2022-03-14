/*
Actividad 2.
Queremos controlar algunas restricciones a la hora de trabajar con agentes:

- La longitud de la clave de un agente no puede ser inferior a 6.
- La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
- La categor�a de un agente s�lo puede ser igual a 0, 1 o 2.
- Si un agente tiene categor�a 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
- Si un agente tiene categor�a 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia.  
- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.

Se pide crear un disparador para asegurar estas restricciones. El disparador deber� lanzar todos los errores 
que se puedan producir en su ejecuci�n mediante errores que identifiquen con un mensaje adecuado por qu� se ha producido dicho error.

Algunas de las restricciones implementadas con el disparador se pueden incorporar a la 
definici�n del esquema de la tabla utilizando el Lenguaje de Definici�n de Datos (Check,Unique,..).
Identifica cu�les son y con qu� tipo de restricciones las implementar�as.
*/

create or replace trigger res_agentes before insert or update on AGENTES
for each row
    
begin
    -- ----------------------------------------------------------------
    -- La longitud de la clave de un agente no puede ser inferior a 6.
    -- ----------------------------------------------------------------
    if (length(:new.clave) < 6) then
        raise_application_error(-20101,'{La clave no puede ser inferior de 6 caracteres}');
    end if;
    
    -- -------------------------------------------------------------------------------
    --La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
    -- -------------------------------------------------------------------------------
    if (:new.habilidad < 0 or :new.habilidad > 9) then
        raise_application_error(-20102,'{La habilidad tiene que estar entre 0 y 9}');
    end if;
    
    -- -----------------------------------------------------------
    -- La categor�a de un agente s�lo puede ser igual a 0, 1 o 2.
    -- -----------------------------------------------------------
    if (:new.categoria < 0 or :new.categoria > 2) then
        raise_application_error(-20103,'{La categoria solo puede ser 0, 1 o 2}');
    end if;
    
    -- Si un agente tiene categor�a 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
    if (:new.categoria=2) then
        if (:new.familia is not null) then 
            raise_application_error(-20104,'{Si la categoria es 2, NO puede tener familia}');
        end if;    
        if (:new.oficina is null) then
            raise_application_error(-20105, '{Si la categoria es 2 debe de pertener a una ofinina}');
        end if;
    end if;
   
    -- ------------------------------------------------------------------------------------------------------
    -- Si un agente tiene categor�a 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia.  
    -- ------------------------------------------------------------------------------------------------------
    if (:new.categoria=1) then
        if (:new.oficina is not null) then
            raise_application_error(-20106,'{Si la categoria es 1 no pude de pertener a una ofinina}');
        end if;
        if (:new.familia is null) then
            raise_application_error(-20107,'{Si la categoria es 1 debe de pertener a una familia}');
        end if;
    end if;
    
    -- -----------------------------------------------------------------------------------------------
    -- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.
    -- -----------------------------------------------------------------------------------------------
    if (:new.oficina is null) and (:new.familia is null) then
        raise_application_error(-20108,'{Un agente tiene que pertenecer a una familia y a una oficina}');
    elsif (:new.oficina is not null) and (:new.familia is not null) then
        raise_application_error(-20109,'{Un agente no puede pertenecer a una familia y a una oficina a la vez}');
    end if;    
    
end;







