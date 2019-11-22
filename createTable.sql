
CREATE TABLE IF NOT EXISTS PROJETO (
    nome varchar(255) NOT NULL PRIMARY KEY, 
    altura double,
    peso double, 
    idade int,
    sexo varchar(50),
    novaconsulta double,
    antigaconsulta double
);