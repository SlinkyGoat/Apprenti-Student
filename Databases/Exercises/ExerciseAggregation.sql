DROP DATABASE IF EXISTS BookBarn;

CREATE DATABASE BookBarn;

USE BookBarn;

-- Create the Book table
-- CREATE TABLE Book (
--     BookId INT PRIMARY KEY,
--     GenreId INT,
--     Title VARCHAR(255),
--     Price DECIMAL(10, 2)
-- );

-- Insert data into the Book table
-- INSERT INTO Book (BookId, GenreId, Title, Price) VALUES
-- (1, 1, 'Into the Woods', 14.99),
-- (2, 2, 'Startup Fundamentals', 22.00),
-- (3, 1, 'Ghost Leaves', 11.50);

-- Create the Genre table
CREATE TABLE Genre (
    GenreId INT PRIMARY KEY,
    GenreName VARCHAR(100)
);

-- Insert data into the Genre table
INSERT INTO Genre (GenreId, GenreName) VALUES
(1, 'Fiction'),
(2, 'Business');

-- Create the Book table
CREATE TABLE Book (
    BookId INT PRIMARY KEY,
    GenreId INT,
    Title VARCHAR(255),
    Price DECIMAL(10, 2),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);

-- Insert data into the Book table
INSERT INTO Book (BookId, GenreId, Title, Price) VALUES
(1, 1, 'Into the Woods', 14.99),
(2, 2, 'Startup Fundamentals', 22.00),
(3, 1, 'Ghost Leaves', 11.50);

-- Create the Staff table
CREATE TABLE Staff (
    StaffId INT PRIMARY KEY,
    LastName VARCHAR(100),
    HireDate DATE
);

-- Insert data into the Staff table
INSERT INTO Staff (StaffId, LastName, HireDate) VALUES
(1, 'Nguyen', '2020-01-01'),
(2, 'Smith', '2021-03-15');

-- Create the Sale table
CREATE TABLE Sale (
    SaleId INT PRIMARY KEY,
    StaffId INT,
    Total DECIMAL(10, 2),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);

-- Insert data into the Sale table
INSERT INTO Sale (SaleId, StaffId, Total) VALUES
(101, 1, 295.75),
(102, 2, 840.20);


-- --------------------
-- Exercise Questions
-- --------------------


-- --------------------
-- Part 1: Book Pricing Summary
-- --------------------

-- 1
SELECT
	MIN(Price) AS Lowest_Price,
	MAX(Price) AS Highest_Price,
	AVG(Price) AS Average_Price
FROM book;
-- '11.50', '22.00', '16.163333'


-- 2
SELECT
	genre.GenreName AS Genre_Name,
	AVG(Price) AS Average_Price
FROM book
INNER JOIN genre ON book.GenreId = genre.GenreId
GROUP BY book.GenreId;

-- 'Fiction', '13.245000'
-- 'Business', '22.000000'

-- 3
SELECT
	genre.GenreName AS Genre_Name,
	AVG(Price) AS Average_Price
FROM book
INNER JOIN genre ON book.GenreId = genre.GenreId
GROUP BY book.GenreId
HAVING Average_Price > 15;
-- 'Business', '22.000000'


-- --------------------
-- Part 2: Staff Sales Performance
-- --------------------

-- 1
SELECT 
    s.LastName AS Staff_LastName,
    COUNT(sale.SaleId) AS Total_Sales
FROM staff s
LEFT JOIN sale ON s.StaffId = sale.StaffId
GROUP BY s.LastName;

-- 'Nguyen', '1'
-- 'Smith', '1'

-- 2
SELECT 
    s.LastName AS Staff_LastName,
    SUM(sale.Total) AS Total_Sales_Value
FROM staff s
LEFT JOIN sale ON s.StaffId = sale.StaffId
GROUP BY s.LastName;

-- 'Nguyen', '295.75'
-- 'Smith', '840.20'

-- 3
SELECT 
    s.LastName AS Staff_LastName,
    SUM(sale.Total) AS Total_Sales_Value
FROM staff s
LEFT JOIN sale ON s.StaffId = sale.StaffId
GROUP BY s.LastName
HAVING SUM(sale.Total) > 800;

-- 'Smith', '840.20'


-- 4
SELECT 
    s.LastName AS Staff_LastName,
    SUM(sale.Total) AS Total_Sales_Value
FROM staff s
LEFT JOIN sale ON s.StaffId = sale.StaffId
GROUP BY s.LastName
ORDER BY Total_Sales_Value DESC;

-- 'Smith', '840.20'
-- 'Nguyen', '295.75'


-- --------------------
-- Part 3: Staff Hire Summary
-- --------------------

SELECT 
    HireDate,
    GROUP_CONCAT(LastName) AS Staff_Names
FROM staff
GROUP BY HireDate;

-- '2020-01-01', 'Nguyen'
-- '2021-03-15', 'Smith'
