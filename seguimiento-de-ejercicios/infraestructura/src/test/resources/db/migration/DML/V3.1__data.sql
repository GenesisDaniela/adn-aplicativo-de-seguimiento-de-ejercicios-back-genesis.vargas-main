insert into usuario(id_usuario,nombre, peso, fecha_nacimiento, correo, contrasenia)
values(1,'genesis',64,'2002-05-15','genesis@gmail.com','2342233332223');

insert into rutina(id_rutina,descripcion,objetivo,usuario)
values (1,'Rutina bicep','Ganancia muscular',1);

insert into rutina(id_rutina,descripcion,objetivo,usuario)
values (2,'Rutina tricep','Ganancia muscular',1);

insert into ejercicio(nombre,seccion_cuerpo)
values ('martillo','bicpes');

insert into ejercicio(nombre,seccion_cuerpo)
values ('copa','triceps');
alter table plan rename column id_plan to id;
insert into plan(rutina,ejercicio,peso,series,repeticiones)
values (1,1,34,15,10);