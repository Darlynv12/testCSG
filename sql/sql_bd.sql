-- Create database

CREATE DATABASE IF NOT EXISTS company;

USE company;

-- Create tables

CREATE TABLE IF NOT EXISTS department (
	id INT PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	location VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
	id INT PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	salary FLOAT(10,4) NOT NULL,
	depto_id INT NOT NULL,
	FOREIGN KEY (depto_id)
        REFERENCES department (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);

-- insert information

INSERT INTO department VALUES (1,'Executive','Sydney');
INSERT INTO department VALUES (2,'Production','Sydney');
INSERT INTO department VALUES (3,'Resources','Cape Town');
INSERT INTO department VALUES (4,'Technical','Texas');
INSERT INTO department VALUES (5,'Management','Paris');

INSERT INTO employee VALUES (1,'Candice',4685,1);
INSERT INTO employee VALUES (2,'Julia',2259,2);
INSERT INTO employee VALUES (3,'Bob',4405,4);
INSERT INTO employee VALUES (4,'Scarlet',2350,1);
INSERT INTO employee VALUES (5,'Ilena',1151,4);