-- ------------
-- SETUP
-- ------------

DROP DATABASE IF EXISTS updatingexercise;
CREATE DATABASE updatingexercise;
USE updatingexercise;
 CREATE TABLE ProductCategory ( 
CategoryId INT PRIMARY KEY, 
CategoryName VARCHAR(50) 
); 
CREATE TABLE Product ( 
ProductId INT PRIMARY KEY, 
ProductName VARCHAR(100), 
CategoryId INT, 
Price DECIMAL(10, 2), 
EndDate DATE, 
FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId) 
); 
INSERT INTO ProductCategory VALUES 
(1, 'Books'), 
(2, 'Stationery'), 
(3, 'Clearance'); 
INSERT INTO Product VALUES 
(101, 'Notebook', 2, 5.00, NULL),
(102, 'Pen Set', 2, 7.50, NULL), 
(103, 'Calendar 2023', 2, 9.99, NULL), 
(104, 'Mystery Novel', 1, 15.00, NULL), 
(105, 'Classic Fiction', 1, 12.50, NULL); 


-- ------------
-- UPDATING EXERCISE
-- ------------

-- Part 1: Update a Single Record

UPDATE Product
SET Price = 8.99
WHERE ProductName = 'Notebook';


-- Part 2: Update Multiple Columns
UPDATE Product
SET 
ProductName = 'Executive Pen Set',
Price = 8.99
WHERE ProductName = 'Pen Set';

-- Part 3: Update Multiple Records
UPDATE Product
SET EndDate = '2024-12-31'
WHERE CategoryId = (
	SELECT CategoryId 
    FROM ProductCategory 
    WHERE CategoryName = 'Stationery'
);