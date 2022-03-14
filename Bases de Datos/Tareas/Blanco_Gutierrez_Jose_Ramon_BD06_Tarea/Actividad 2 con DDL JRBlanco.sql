-- ----------------------------------------------------------------
-- La longitud de la clave de un agente no puede ser inferior a 6.
-- ----------------------------------------------------------------
alter table AGENTES add constraint chk_tam_clave check(length(ltrim(rtrim(clave)))>6);
-- -------------------------------------------------------------------------------
--La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
-- -------------------------------------------------------------------------------
alter table AGENTES add constraint chk_habilidad check(habilidad between 0 and 9);

-- -------------------------------------------------------------------------------------------------------------
-- La categoría de un agente sólo puede ser igual a 0, 1 o 2.
-- Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
-- Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia.  
-- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.
-- -------------------------------------------------------------------------------------------------------------
alter table AGENTES add constraint chk_cat_ofi_fam check((categoria=2 and familia is null and oficina is not null) 
                                                      or (categoria=1 and familia is not null and oficina is null) 
                                                      or (categoria=0) and ((oficina is not null and familia is null) or 
                                                                            (oficina is null and familia is not null)));
                                                                            
-- -----------------------------------------------------------------------------------------------------------------------------------------------
-- ESTÁN TODOS AGRUPADOS EN EL CHECK ANTERIOR
-- -----------------------------------------------------------
-- La categoría de un agente sólo puede ser igual a 0, 1 o 2.
-- -----------------------------------------------------------
-- alter table AGENTES add constraint chk_categoria check(categoria between 0 and 2);
-- ------------------------------------------------------------------------------------------------------
-- Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
-- ------------------------------------------------------------------------------------------------------
-- alter table AGENTES add constraint chk_cat2 check(categoria=2 and familia is null and oficina is not null);
-- ------------------------------------------------------------------------------------------------------
-- Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia.  
-- ------------------------------------------------------------------------------------------------------
-- alter table AGENTES add constraint chk_cat1 check(categoria=1 and familia is not null and oficina is null);
-- -----------------------------------------------------------------------------------------------
-- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.
-- -----------------------------------------------------------------------------------------------
-- alter table AGENTES add constraint chk_pertene check ((oficina is not null and familia is null) or (oficina is null and familia is not null));


