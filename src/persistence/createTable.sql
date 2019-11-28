/*
Escola Agrícola de Jundiaí - POO2k19.2
Autores: @Luan Souza
         @Lucas Gabriel
*/
CREATE TABLE IF NOT EXISTS TRABALHO (
    nome varchar(255) NOT NULL PRIMARY KEY, 
    altura double,
    peso double, 
    idade int,
    novaconsulta double,
    antigaconsulta double
);
