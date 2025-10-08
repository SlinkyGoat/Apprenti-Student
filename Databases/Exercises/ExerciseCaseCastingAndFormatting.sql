DROP DATABASE IF EXISTS CaseExercise;

USE CaseExercise;

DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
	customer_id INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50)
);

INSERT INTO customers (customer_ID, First_Name, Last_Name) VALUES
(101, 'john', 'DOE'),
(102, 'SARAH', 'smith');

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
	order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATETIME,
    order_total VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO orders (order_id, customer_id, order_date, order_total) VALUES 
(1, 101, '2025-07-01 14:33:00', '1234.5'), 
(2, 102, '2025-07-03 10:15:22', '8899.99'); 


-- --------------------
-- Exercise Questions
-- --------------------


-- --------------------
-- Part 1: Case Sensitivity & Case Formatting
-- --------------------

-- 1
SELECT 
CONCAT(
	UPPER(LEFT(First_Name, 1)), LOWER(SUBSTRING(First_Name, 2)),
	' ',
	UPPER(LEFT(Last_Name, 1)), LOWER(SUBSTRING(Last_Name, 2))
) AS FullName
FROM customers;

-- 2
SELECT * FROM customers WHERE First_Name = 'JOHN'; 
-- '101', 'john', 'DOE'
-- database is NOT case-sensitive


-- --------------------
-- Part 2: Casting
-- --------------------
-- 1: order_total should be a decimal, not a string
-- 2
SELECT 
CAST(order_total AS DECIMAL(10,2)) AS formatted_total
FROM orders;


-- --------------------
-- Part 3: Formatting
-- --------------------

-- 1
SELECT 
DATE_FORMAT(order_date, '%M %d, %Y') AS formatted_date
FROM orders;
-- 'July 01, 2025'
-- 'July 03, 2025'

-- 2
SELECT 
FORMAT(CAST(order_total AS DECIMAL(10,2)), 2) AS formatted_total
FROM orders;
-- '1,234.50'
-- '8,899.99'


-- --------------------
-- Part 4: Combined Query - Business Report
-- --------------------

SELECT 
    CONCAT(
        UPPER(LEFT(c.First_Name, 1)), LOWER(SUBSTRING(c.First_Name, 2)),
        ' ',
        UPPER(LEFT(c.Last_Name, 1)), LOWER(SUBSTRING(c.Last_Name, 2))
    ) AS customer_name,
    DATE_FORMAT(o.order_date, '%M %d, %Y') AS formatted_order_date,
    FORMAT(CAST(o.order_total AS DECIMAL(18,2)), 2) AS formatted_order_total
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id;

-- customer_name, formatted_order_date, formatted_order_total
-- 'John Doe',    'July 01, 2025',      '1,234.50'
-- 'Sarah Smith', 'July 03, 2025',      '8,899.99'

-- --------------------
-- Reflection Questions
-- --------------------

-- Q: What potential issues would arise from leaving order_total as a string?
-- A: Many issues can arise because we are storing a numeric value as a string. Therefore any sort of formatting
-- 		or mathematical operations could fail or cause further issues when trying to execute ona  string
-- 		rather than a number

-- Q: How does your database's case sensitivity impact query design? 
-- A: My database is NOT can sensitive which means I have more leeway when calling columns. If my database had
-- 		case sensitivity then I would have to be strict about how I call columns so that they match exactly as they are spelled
-- 		in the database as "JOHN" and "john" would not equate to the same value.alter

-- Q: What are the risks of relying solely on implicit casting? 
-- A: When relying on implicit casting you are trusting the database will convert values to what you expect. If it happens
-- 		to convert to something else then issues may arise in the future whether it is formatting, math, or even failing
-- 		to convert as a whole.

-- Q: Why is formatting critical in customer-facing reports? 
-- A: It makes it easier to read the data and informs them of how the data should be read, ex. Is '123' supposed to be a string
-- 		such as a text someone posted on social media, or is '123' actually supposed to be a number representing some piece of data?