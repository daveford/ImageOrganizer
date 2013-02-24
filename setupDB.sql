/*
user: image
password: ImageOrganizer
*/

USE imageorganizerdb;

CREATE TABLE IF NOT EXISTS Image_Directories(
	ID			INT		AUTO_INCREMENT		PRIMARY KEY,
	Dir_Path	VARCHAR(100)	NOT NULL
);


CREATE TABLE IF NOT EXISTS Image_Meta(
	ID				int				auto_increment		primary key,
	Name			varchar(25) 	NOT NULL,
	Filename		varchar(29)		NOT NULL,
	Description		varchar(500)	NOT NULL,
	Location		INT				NOT NULL,
	Insert_Date		DATETIME,
	FOREIGN KEY 	(Location) 		REFERENCES 			Image_Directories(ID)
);