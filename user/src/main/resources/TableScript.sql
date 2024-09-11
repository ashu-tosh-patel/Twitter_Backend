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

INSERT INTO userMS (name, username, email, password, profile_pic, cover_pic, bio, location, website) VALUES
('Alice Johnson', 'alicej', 'alice.johnson@example.com', 'password123', 'profile1.jpg', 'cover1.jpg', 'Love programming and coffee.', 'New York, NY', 'http://alicejohnson.com'),
('Bob Smith', 'bobsmith', 'bob.smith@example.com', 'password123', 'profile2.jpg', 'cover2.jpg', 'Enjoys hiking and music.', 'Los Angeles, CA', 'http://bobsmith.com'),
('Carol Davis', 'carold', 'carol.davis@example.com', 'password123', 'profile3.jpg', 'cover3.jpg', 'Avid reader and traveler.', 'Chicago, IL', 'http://caroldavis.com'),
('David Brown', 'davidb', 'david.brown@example.com', 'password123', 'profile4.jpg', 'cover4.jpg', 'Tech enthusiast and gamer.', 'San Francisco, CA', 'http://davidbrown.com'),
('Eva Martinez', 'evam', 'eva.martinez@example.com', 'password123', 'profile5.jpg', 'cover5.jpg', 'Food lover and photographer.', 'Seattle, WA', 'http://evamartinez.com'),
('Frank Wilson', 'frankw', 'frank.wilson@example.com', 'password123', 'profile6.jpg', 'cover6.jpg', 'Fitness junkie and blogger.', 'Austin, TX', 'http://frankwilson.com'),
('Grace Lee', 'gracelee', 'grace.lee@example.com', 'password123', 'profile7.jpg', 'cover7.jpg', 'Creative writer and artist.', 'Denver, CO', 'http://gracelee.com'),
('Henry Harris', 'henryh', 'henry.harris@example.com', 'password123', 'profile8.jpg', 'cover8.jpg', 'Music producer and DJ.', 'Miami, FL', 'http://henryharris.com'),
('Isabella Clark', 'isabellac', 'isabella.clark@example.com', 'password123', 'profile9.jpg', 'cover9.jpg', 'Nature enthusiast and blogger.', 'Portland, OR', 'http://isabellaclark.com'),
('Jack Robinson', 'jackr', 'jack.robinson@example.com', 'password123', 'profile10.jpg', 'cover10.jpg', 'Entrepreneur and mentor.', 'Boston, MA', 'http://jackrobinson.com');

commit;

select * from userMS;