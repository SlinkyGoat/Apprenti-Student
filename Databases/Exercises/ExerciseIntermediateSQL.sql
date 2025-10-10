USE simpleschool;

-- 1. Add a new subject to the database named "Comp. Science"
INSERT INTO `Subject` (SubjectName) VALUES ('Comp. Science');


-- 2. Modify the new subject's name to "Computer Science"
UPDATE `Subject`
SET SubjectName = 'Computer Science'
WHERE SubjectName = 'Comp. Science';


-- 3. Add the following courses to the database, all in the Computer Science Subject
-- A) Java - 3 credit hours
-- B) C# - 3 credit hours
-- C) JavaScript - 3 credit hours
-- D) Advanced Java - 3 credit hours
INSERT INTO Course (SubjectID, CourseName, CreditHours) VALUES
(6, 'Java', 3.0),
(6, 'C#', 3.0),
(6, 'JavaScript', 3.0),
(6, 'Advanced Java', 3.0);


-- 4. Rename the course "Java" to "Java 101"
UPDATE Course
SET CourseName = 'Java 101'
WHERE CourseName = 'Java';


-- 5. Rename the course "Advanced Java" to "Java 201", and credit hours should be 4. Do this in one statement.
UPDATE Course
SET CourseName = 'Java 201', CreditHours = 4
WHERE CourseName = 'Advanced Java';


-- 6. Delete the "Computer Science" subject.
DELETE FROM `Subject` WHERE SubjectName = 'Computer Science';
-- A) What error message did you get?
-- 		Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails 
-- 		(`simpleschool`.`course`, CONSTRAINT `fk_Course_Subject_id` FOREIGN KEY (`SubjectID`) REFERENCES `subject` (`SubjectID`))
-- B) Why did you get that error message
-- 		Course contains a foreign key for Subject. In this case Course contains at least some number of records that have the foreign key
-- 		value for "Computer Science". This means the computer science subject CANNOT be deleted as it is being "used" elsewhere


-- 7. Delete the "Java 101" course
DELETE FROM Course WHERE CourseName = 'Java 101';


-- 8. Delete the remaining "Computer Science" courses with one statement
DELETE FROM Course WHERE SubjectId = (SELECT SubjectId FROM `Subject` WHERE SubjectName = 'Computer Science');


-- 9. Delete the "Computer Science" subject.
DELETE FROM `Subject` WHERE SubjectName = 'Computer Science';
-- We can not delete this because the "Computer Science" subject ID is no longer used anywhere