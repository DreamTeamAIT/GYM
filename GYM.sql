CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE classes (
  classID INT NOT NULL  AUTO_INCREMENT ,
  classname varchar(45) DEFAULT NULL,
  instructor varchar(45) DEFAULT NULL,
  classtime varchar(45) DEFAULT NULL,
PRIMARY KEY(classID)
);
SELECT * FROM gym.classes;
DROP TABLE classes;
