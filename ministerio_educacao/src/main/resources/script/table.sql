CREATE DATABASE ministerio;

use ministerio;


CREATE TABLE ALUNO (
nif integer UNIQUE NOT NULL PRIMARY KEY,
nome varchar(200) NOT NULL,
idade integer,
escolaridade integer
);


CREATE TABLE DISCIPLINA (
disciplina_id integer not null auto_increment PRIMARY KEY,
nome_disciplina varchar(50) NOT NULL,
area varchar(40) NOT NULL
);

