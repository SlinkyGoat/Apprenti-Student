-- ---------------
-- SETUP
-- ---------------

DROP DATABASE IF EXISTS retail;
CREATE DATABASE IF NOT EXISTS retail;
use retail;

 CREATE TABLE Customer ( 
CustomerId INT AUTO_INCREMENT PRIMARY KEY, 
CustomerName VARCHAR(100) 
); 

CREATE TABLE CustomerOrder ( 
OrderId INT AUTO_INCREMENT PRIMARY KEY, 
CustomerId INT, 
OrderDate DATE, 
FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId) 
); 

CREATE TABLE PaymentMethod ( 
PaymentMethodId INT PRIMARY KEY, 
MethodName VARCHAR(50) 
); 

CREATE TABLE Payment ( 
PaymentId INT AUTO_INCREMENT PRIMARY KEY,
OrderId INT, 
PaymentMethodId INT, 
Amount DECIMAL(10, 2), 
FOREIGN KEY (OrderId) REFERENCES CustomerOrder(OrderId), 
FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)
); 

INSERT INTO PaymentMethod VALUES  
(1, 'Credit Card'), 
(2, 'Cash'), 
(3, 'Mobile Payment'); 

-- ---------------
-- EXERCISE
-- ---------------


-- Part 1: Insert Single Records
INSERT INTO Customer (CustomerName) VALUES 
('Emma Rivera');
INSERT INTO Customer (CustomerName) VALUES 
('Noah Gray');

INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES
(1, CURRENT_DATE());
INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES
(2, CURRENT_DATE());


-- Part 2: Insert with Auto-Increment Key
INSERT INTO Payment (OrderId, PaymentMethodId, Amount) VALUES
(1, 1, 49.99);


-- Part 3: Handle Foreign Keys
INSERT INTO Payment (OrderId, PaymentMethodId, Amount) VALUES
(1, 999, 49.99);
-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails 
-- (`retail`.`payment`, CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`))


-- Part 4: Bulk Insert
INSERT INTO Customer (CustomerName) VALUES 
('Liam Davis'),
('Olivia Brooks'),
('Sophia Martinez');

INSERT INTO CustomerOrder (CustomerId, OrderDate) VALUES
(4, CURRENT_DATE()),
(3, CURRENT_DATE());



-- ---------------
-- REFLECTION QUESTIONS
-- ---------------

-- 1. What happens if you try to insert a record that violates a foreign key constraint? 
-- It will error telling you that a foreign key restraint fails 

-- 2. Why is using auto-increment helpful for primary keys? 
-- It is useful because we don't have to specify the ID (or whatever value you use) if all we need is a unique identifier

-- 3. What are the benefits of bulk inserting records? 
-- It reduces the amount you need to type and acts faster as you are sending a single statement to execute rather than several