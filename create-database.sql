DROP DATABASE IF EXISTS Shippable;
CREATE DATABASE Shippable;

GRANT USAGE ON *.* TO 'username'@'localhost' IDENTIFIED BY 'password';
DROP USER 'username'@'localhost';
CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
GRANT USAGE ON *.* TO 'username'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON Shippable.* to 'username'@'localhost';

CREATE TABLE Shippable.test (city VARCHAR(20), state VARCHAR(2));

