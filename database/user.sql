CREATE DATABASE IF NOT EXISTS example;

DROP TABLE IF EXISTS 'user';
CREATE TABLE 'user'(
    'id' INT NOT NULL AUTO_INCREMENT,
    'username' varchar(30) NOT NULL,
    'password' varchar(20) NOT NULL,
    PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=0;