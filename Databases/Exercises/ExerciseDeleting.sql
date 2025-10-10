-- ----------------
-- SETUP
-- ----------------
DROP DATABASE IF EXISTS deletingExercise;
CREATE DATABASE deletingExercise;
use deletingExercise;

CREATE TABLE ProductCategory ( 
CategoryId INT PRIMARY KEY, 
CategoryName VARCHAR(50) 
); 
CREATE TABLE Product ( 
ProductId INT PRIMARY KEY, 
ProductName VARCHAR(100), 
CategoryId INT, 
Price DECIMAL(10, 2), 
FOREIGN KEY (CategoryId) REFERENCES ProductCategory(CategoryId) 
); 
INSERT INTO ProductCategory VALUES 
(1, 'Books'), 
(2, 'Stationery'), 
(3, 'Clearance'); 
INSERT INTO Product VALUES 
(101, 'Notebook', 2, 5.00), 
(102, 'Pen Set', 2, 7.50), 
(103, 'Calendar 2023', 2, 9.99), 
(104, 'Mystery Novel', 1, 15.00), 
(105, 'Classic Fiction', 1, 12.50), 
(106, 'Sticker Pack', 3, 2.99); 


-- ----------------
-- DELETING EXERCISE
-- ----------------

-- Part 1: Delete A Single Record
SELECT * FROM Product WHERE ProductName = 'Calendar 2023';
DELETE FROM Product WHERE ProductName = 'Calendar 2023';

-- Part 2: Delete Multiple Records
SELECT * FROM Product WHERE CategoryId = (
	SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Stationery'
);
DELETE FROM Product WHERE CategoryId = (
	SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Stationery'
);

-- Part 3: Handle Foreign Key Dependencies
DELETE FROM ProductCategory WHERE CategoryName = 'Books';
-- It errors because there exists a Product that uses the categoryId related to 'Books'
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails 
-- (`deletingexercise`.`product`, CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `productcategory` (`CategoryId`))
DELETE FROM Product WHERE CategoryId = (
	SELECT CategoryId FROM ProductCategory WHERE CategoryName = 'Books'
);
DELETE FROM ProductCategory WHERE CategoryName = 'Books';

-- Part 4: Bonus Challenge
DELETE FROM ProductCategory
WHERE categoryId NOT IN (
    SELECT categoryId FROM Product
);


-- ----------------
-- REFLECTION QUESTIONS
-- ----------------

-- 1. Why is it important to use SELECT before DELETE? 
-- 		Suppose you wrote your query wrong. If you didn't check it with SELECT beforehand you could accidentally DELETE many more records
-- 		or even the wrong data.

-- 2. What happens if you try to delete a parent record that is referenced by a foreign key?
-- 		It will cause an error because you are deleting a parent record that contains a value being used by some other table. If you deleted
-- 		the parent foreign key value then the child record would be pointing to nothing likely causing many errors in the future.alter

-- 3. How would you protect critical records in a production environment? 
-- 		I could use a table such as "Importance" that holds values of importance. The highest level such as "critical" would be set to all the child
-- 		records which would mean we could never delete them as long as we keep our "critical" value in our "Importance" table and all the records
-- 		keep their "critical" value stored in their columns.
