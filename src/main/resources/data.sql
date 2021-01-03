DROP TABLE IF EXISTS sensordata;
DROP TABLE IF EXISTS district;
DROP TABLE IF EXISTS sensor;
DROP TABLE IF EXISTS cityhall;


CREATE TABLE cityhall (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    username VARCHAR(100) NOT NULL

);

INSERT INTO cityhall (name, username) VALUES
    ('Barcelona', 'enrique'),
    ('Wien', 'stephan'),
    ('München', 'thomas');


CREATE TABLE district (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    cityhall_id INT NOT NULL,
    sensor_id INT NOT NULL
);

INSERT INTO district (name, cityhall_id, sensor_id) VALUES
    ('Gràcia',1,1),
    ('Eixample',1,2),
    ('Währing',2,3),
    ('Penzing',2,4),
    ('Maxvorstadt',3,5);

CREATE TABLE sensor (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    username VARCHAR(100) NOT NULL,
    district_id INT NOT NULL
);

INSERT INTO sensor (name, username, district_id) VALUES
('Gràcia CO2','sen1',1),
('Eixample CO2','sen2',2),
('Währing CO2','sen3',3),
('Penzing CO2','sen4',4),
('Maxvorstadt CO2','sen5',5);


CREATE TABLE sensordata (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    sensor_id INT NOT NULL,
    level VARCHAR(250) NOT NULL,
    read_timestamp Timestamp NOT NULL
);

INSERT INTO sensordata (sensor_id, level, read_timestamp) VALUES
    (1,35, '2020-09-17 18:47:52.650'),
    (1,38, '2020-09-17 18:47:52.670'),
    (1,42, '2020-09-17 18:47:52.690');