CREATE DATABASE mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use mybatis;


CREATE TABLE Country(
    id int(15) NOT NULL AUTO_INCREMENT,
    countryname varchar(255) NOT NULL,
    countrycode varchar(255) NOT NULL,
    PRIMARY KEY(id)
);


insert INTO country(countryname,countrycode)values('中国','CN'),('美国','US'),('英国','GB'),('法国','FR');