create database if not exists tpJava;

use tpJava;

CREATE TABLE winners (
  id int not null auto_increment primary key;
  player VARCHAR(30) NOT NULL,
  points INT NOT NULL,
  cards VARCHAR(200) NOT NULL
)
