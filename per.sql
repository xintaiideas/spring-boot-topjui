DROP TABLE IF EXISTS per;
CREATE TABLE per
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  age int(11) NOT NULL,
  address varchar(255) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO per (name, age, address) VALUES ( 'wch', 21, 'NanJing, NJFU');
INSERT INTO per (name, age, address) VALUES ( 'Andrew Garfield', 23, 'AM');
INSERT INTO per (name, age, address) VALUES ( 'Pili Groyne', 13, 'BR');
INSERT INTO per (name, age, address) VALUES ( 'Hayley Atwell', 24, 'AM');
INSERT INTO per (name, age, address) VALUES ( 'Wagner Moura', 25, 'BR');
INSERT INTO per (name, age, address) VALUES ( 'Claire Danes', 31, 'AM');
INSERT INTO per (name, age, address) VALUES ('Rose Byrne', 23, 'AM');
INSERT INTO per (name, age, address) VALUES ('Daniel Brühl', 22, 'AM');
INSERT INTO per (name, age, address) VALUES ('Uma Thurman', 32, 'BR');
INSERT INTO per (name, age, address) VALUES ('Haruka Ayase', 14, 'BR');
INSERT INTO per (name, age, address) VALUES ('Rosamund Pike', 33, 'AM');
INSERT INTO per (name, age, address) VALUES ('Ewan McGregor', 34, 'AM');
INSERT INTO per (name, age, address) VALUES ('Saoirse Ronan', 18, 'AM');
INSERT INTO per (name, age, address)VALUES ('Quentin Tarantino', 39, 'AM');