-- Crea el esquema libreria
CREATE SCHEMA libreria;

-- Usa el esquema libreria
USE libreria;

-- Borra la tabla si existe
drop table if exists roles;

-- Crea la tabla 
create table roles(
id integer  primary key,
nombre char(28) not null
);

-- Inserts
insert into roles(id, nombre)  values (1, "Docente");
insert into roles(id, nombre)  values (2,	"Estudiante");

-- Consultas
select * from roles;
select * from roles r where r.id = 1;
