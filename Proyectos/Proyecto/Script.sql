USE master;
GO
CREATE DATABASE Example;
GO
USE Example;
GO
create TABLE Person
(
	personID int identity,
	name varchar(255),
	lastName varchar(255),
	country varchar(255),
	address varchar(255),
	Primary key(personID),
);
GO
SET DATEFORMAT YMD;
GO

BULK
Insert Person
from "C:\Users\diego\Documents\2014 - Primer Periodo\Bases de Datos 1\Proyectos\BD-TP2\TP2\datos.txt"
WITH
(
-- seteamos el separador de campos
FIELDTERMINATOR = ',',
--seteamos el separador de registro
ROWTERMINATOR = '\n'
);
GO

Select * from Person

alter table Person
alter column personID int identity not null