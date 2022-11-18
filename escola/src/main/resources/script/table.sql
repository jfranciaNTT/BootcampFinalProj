CREATE DATABASE escola;

use escola;

CREATE TABLE LOGIN (
username varchar(10) UNIQUE NOT NULL PRIMARY KEY,
pass varchar(200) NOT NULL
);


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

CREATE TABLE PROFESSOR (
nif_professor integer NOT NULL PRIMARY KEY,
nome_professor varchar(200) NOT NULL,
idade_professor integer,
tempo_ensino integer,
salario double,
disciplina_id integer NOT NULL,
FOREIGN KEY(disciplina_id) REFERENCES DISCIPLINA (disciplina_id)
);


CREATE TABLE AULA (
aula_id integer not null auto_increment PRIMARY KEY,
professor_nif integer,
aluno_nif integer,
data date,
duracao double,
FOREIGN KEY(professor_nif) REFERENCES PROFESSOR (nif_professor),
FOREIGN KEY(aluno_nif) REFERENCES ALUNO (nif)
);