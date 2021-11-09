create database if not exists mysql_database;
use mysql_database;
DROP TABLE IF EXISTS customer ;
CREATE TABLE if not exists `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;

INSERT INTO customer (id, first_name, last_name, password, email)
VALUES (1, "Peter", "Curry", "12345", "email@email.com");
INSERT INTO customer (id, first_name, last_name, password, email)
VALUES (2, "Paul", "Rice", "678910", "paulrocks@email.com");

SELECT * FROM customer;
SELECT COUNT(*) FROM customer where first_name = "" AND last_name = "" AND password = "" ;	
