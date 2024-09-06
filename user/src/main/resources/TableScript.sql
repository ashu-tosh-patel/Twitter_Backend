DROP SCHEMA IF EXISTS userMS_db;

CREATE SCHEMA userMS_db;
USE userMS_db;
   
create table userMS (

   id INT AUTO_INCREMENT,   
   name VARCHAR(50) not null,
   username VARCHAR(30),
   email VARCHAR(50) not null,
   password VARCHAR(30) not null,
   profile_pic VARCHAR(100),
   cover_pic VARCHAR(100),
   bio VARCHAR(100),
   location VARCHAR(100),
   website VARCHAR(100),
   CONSTRAINT ps_user_id_pk PRIMARY KEY (id)
);

INSERT INTO userMS VALUES(1,'Sachin','sachin55','sachin555@gmail.com','admin123@','','','','','');
INSERT INTO userMS VALUES(2,'Arnav','arnav55','arnav55@gmail.com','arnav123@','','','','','');
INSERT INTO userMS VALUES(3,'Nikhil','nikhil55','nikhil55@gmail.com','nikhil123@','','','','','');
INSERT INTO userMS VALUES(4,'Nipun','nipun55','nipun55@gmail.com','nipun123@','','','','','');
INSERT INTO userMS VALUES(5,'Tushar','tushar55','tushar55@gmail.com','tushar123@','','','','','');

commit;

select * from userMS;