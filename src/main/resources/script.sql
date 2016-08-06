CREATE DATABASE IF NOT EXISTS test;

USE test;

DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  `id`          INT(8)      NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(25) NOT NULL,
  `age`         INT(3)      NOT NULL,
  `isAdmin`     BIT                  DEFAULT NULL,
  `createdDate` TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET = utf8;

INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Vaser', 15, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Caser', 25, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Daser', 30, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Iaser', 30, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Zaser', 23, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Kaser', 18, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Maser', 25, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Aaser', 18, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Naser', 30, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Oaser', 20, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Paser', 18, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Yaser', 21, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Qaser', 32, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Gaser', 32, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Raser', 25, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Saser', 30, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Baser', 32, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Taser', 32, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Jaser', 20, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Xaser', 19, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Uaser', 44, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Laser', 32, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Faser', 18, 1);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Waser', 18, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Haser', 25, 0);
INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES ('Easer', 20, 0);