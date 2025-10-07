-- ------------------------
-- Create Database
-- ------------------------
DROP DATABASE IF EXISTS MovieCatalog;

CREATE DATABASE MovieCatalog;

USE MovieCatalog;


-- ------------------------
-- Create Tables
-- ------------------------
CREATE TABLE movies (
	MovieId int primary key auto_increment,
    Title varchar(50) not null,
    ReleaseDate year not null,
    Rating varchar(20),
    unique (Title, ReleaseDate)
);

CREATE TABLE actors (
	ActorId int primary key auto_increment,
    FirstName varchar(50),
    LastName varchar(50),
    unique (FirstName, LastName)
);

CREATE TABLE credits (
	CreditId int primary key auto_increment,
    ActorId int not null,
    MovieId int not null,
    RoleName varchar(50),
    foreign key (ActorId) references actors(ActorId),
    foreign key (MovieId) references movies(MovieId),
    unique (ActorId, MovieId, RoleName)
);

CREATE TABLE genres (
	GenreId int primary key auto_increment,
    MovieId int not null,
    GenreName varchar(50),
    foreign key (MovieId) references movies(MovieId),
    unique (MovieId, GenreName)
);

-- ------------------------
-- Insert Data
-- ------------------------
insert into movies (Title, ReleaseDate, Rating)
values ('The Fast and the Furious', 2009, 'PG-13'), -- 1
	   ('Wonder Woman', 2017, 'PG-13'), -- 2
	   ('Guardians of the Galaxy', 2014, 'PG-13'), -- 3
       ('Encanto', 2021, 'PG'); -- 4
       
insert into actors (FirstName, LastName)
values ('Vin', 'Diesel'), -- 1
       ('Gal', 'Gadot'), -- 2
       ('Chris', 'Pine'), -- 3
       ('Chris', 'Pratt'), -- 4
       ('Zoe', 'Saldana'), -- 5
       ('Stephanie', 'Beatriz'), -- 6
       ('John', 'Leguizamo'); -- 7
       
insert into credits (ActorId, MovieId, RoleName)
values (1, 1, 'Dominic Toretto'),
	   (2, 1, 'Gisele'),
	   (2, 2, 'Diana, Wonder Woman'),
       (3, 2, 'Steve Trevor'),
       (4, 3, 'Peter Quill'),
       (1, 3, 'Groot'),
       (5, 3, 'Gamora'),
       (6, 4, 'Mirabel'),
       (7, 4, 'Bruno');
       
insert into genres (MovieId, GenreName)
values (1, 'Action'),
	   (1, 'Crime'),
       (1, 'Thriller'),
       (2, 'Action'),
       (2, 'Adventure'),
       (2, 'Fantasy'),
       (3, 'Animation'),
       (3, 'Comedy'),
       (3, 'Family'),
       (4, 'Action'),
       (4, 'Sci-Fi'),
       (4, 'Superhero');