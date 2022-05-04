CREATE DATABASE Concesionario;

USE Concesionario;
  
create table Propietarios(
  id_prop INT PRIMARY KEY auto_increment,
  nombre_prop VARCHAR(100),
  dni_prop VARCHAR(9)
);
  
  
  
create table Vehiculos(
  mat_veh CHAR(7) PRIMARY KEY DEFAULT "",
  marca_veh VARCHAR(50) DEFAULT "",
  kms_veh INT,
  precio_veh FLOAT,
  desc_veh VARCHAR(300),
  id_prop INT, 
  foreign key (id_prop) references Propietarios (id_prop) on delete set null on update cascade
);



INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'José Ramón Blanco', '12345678A');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'Pablo Blanco Blanco', '13453921K');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'JoseRa Blanco', '12332121D');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'Sandra Díaz', '72345675F');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'Carmen Gutiérrez', '75654312P');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'Pedro Manuel Blanco', '56432111I');
INSERT INTO propietarios (id_prop, nombre_prop, dni_prop) VALUES (NULL, 'Emma Gutiérrez', '92934944G');



INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('2134KKK', 'Renaul Scenic', '230000', '5000', 'Coche familiar', '1');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('5555SSD', 'Suzuki', '10000', '1000', 'Moto de Carreras', '1');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('6778LKJ', 'Renaul Megane', '10000', '12000', 'Coche turismo', '4');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('6555PPP', 'Ferrari', '500', '100000', 'Coche de Alta gama', '2');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('4322SDS', 'Porche', '6000', '50000', 'Coche Deportivo', '3');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('6599UYT', 'Renaul Clio', '546000', '500', 'Coche clásico', '6');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('6776LKJ', 'Nissan', '10000', '2000', 'Coche sustitución', '4');
INSERT INTO vehiculos (mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) VALUES ('2345ASD', 'Ford', '29800', '1200', 'Coche familiar', '7');




