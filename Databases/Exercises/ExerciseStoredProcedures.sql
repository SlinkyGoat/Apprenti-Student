-- ----------------
-- SETUP
-- ----------------

DROP DATABASE IF EXISTS StoredProceduresExercise;
CREATE DATABASE StoredProceduresExercise;
USE StoredProceduresExercise;

CREATE TABLE Customers(
	CustomerId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(50),
    Status VARCHAR(20)
);

INSERT INTO Customers (CustomerName, `Status`) VALUES
('Adam', 'Active'),
('Barry', 'Away'),
('Brian', 'Away'),
('Henok', 'Active'),
('Jaha', 'Away'),
('Spencer', 'Active'),
('Gloria', 'Active'),
('Anthony', 'Away');

-- ----------------
-- STORED PROCEDURES EXERCISE
-- ----------------

-- Task 1: Create a Simple Stored Procedure
DELIMITER // 
CREATE PROCEDURE GetActiveCustomers() 
BEGIN 
	SELECT * FROM Customers 
	WHERE `Status` = 'Active'; 
END // 
DELIMITER ; 

CALL GetActiveCustomers();


-- Task 2: Create A Stored Procedure With A Single Parameter
DELIMITER // 
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT) 
BEGIN 
	SELECT * FROM Customers 
	WHERE CustomerId = CustomerIdIn; 
END // 
DELIMITER ;

CALL GetCustomerDetails(1); 


-- Task 3: Create A Stored Procedure With Multiple Parameters

DELIMITER // 
CREATE PROCEDURE GetCustomerInfo(IN CustomerIdIn INT, IN CustomerNameIn VARCHAR(255)) 
BEGIN 
	SELECT * FROM Customers 
    WHERE CustomerId = CustomerIdIn AND CustomerName = CustomerNameIn; 
END // 
DELIMITER ; 

CALL GetCustomerInfo(1, 'Adam'); 


-- Task 4: Modify A Stored Procedure
DROP PROCEDURE IF EXISTS GetCustomerDetails; 
DELIMITER // 
CREATE PROCEDURE GetCustomerDetails(IN CustomerIdIn INT) 
BEGIN 
	SELECT * FROM Customers 
	WHERE CustomerId = CustomerIdIn AND Status = 'Active'; 
END // 
DELIMITER ; 

CALL GetCustomerDetails(1); 


-- Task 5: Remove A Stored Procedure
DROP PROCEDURE IF EXISTS GetCustomerInfo; 



-- ----------------
-- REFLECTION QUESTIONS
-- ----------------

-- 1. Why are stored procedures useful in maintaining consistency across database operations?
-- 		It will always guarantee the same query will execute as it removes human error from having to repeat the query
-- 		multiple times.

-- 2. How can stored procedures improve performance and security in database systems? 
-- 		Stored procedures are precompiled which reduces traffic over the network when sending and receiving from the server.
-- 		It also controls data access so that improper values cannot be inputted.

-- 3. What are the key differences between writing stored procedures in MySQL and SQL Server? 
-- 		The main difference is syntax. MySQL and SQL Server are very similar and the flow is nearly identical, but the
-- 		keywords used are often slightly different