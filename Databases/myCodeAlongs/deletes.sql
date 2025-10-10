use code_along;

-- SELECT * FROM product;

-- SELECT * FROM productCategory

-- Safe Individual Record Delete
DELETE FROM product
WHERE productId = 103;

-- DELETE MULTIPLE RECORDS
DELETE FROM product WHERE CategoryId = 2;

-- DELETE FROM ProductCategory
DELETE FROM ProductCategory WHERE CategoryId = 1;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails 
-- (`code_along`.`product`, CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `productcategory` (`CategoryId`))

-- 1. You are deleting using a foreign key
-- 2. The foreign key value is ACTIVELY being used by other records within "product"

DELETE FROM ProductCategory WHERE CategoryId IN (2, 3);
-- This works because no products contain productId 2 or 3 so it executes

-- Proper Delete Across Foreign Keys
DELETE FROM product WHERE CategoryId = 1; -- Delete dependant values before we can delete category id
DELETE FROM productCategory WHERE CategoryId = 1;