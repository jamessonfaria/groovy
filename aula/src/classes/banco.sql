1. Script create.
CREATE TABLE cliente (
   id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
   nome VARCHAR(100),
   email VARCHAR(100)
);

2. Script inserts.
insert into cliente (nome, email) values ('Jo�o da Silva', 'jojo@gmail.com');
insert into cliente (nome, email) values ('Sergio Fonseca', 'sergio@bol.com');