USE simpleschool;

-- Part 1: Using NOT EXISTS
--  Write a query to list all Students that are not registerd for a class 
-- Hint(Check the Section Roster) 

SELECT *
FROM Student
WHERE NOT EXISTS (
	SELECT *
    FROM SectionRoster
    WHERE SectionRoster.StudentId = Student.StudentId
);
-- '33', 'Annabel', 'Snow', '2028'


-- Part 2: Subqueries in the WHERE Clause
-- Find the name(s) of classes that have the most students registered

SELECT c.CourseName
FROM Course c
JOIN Section s ON c.CourseID = s.CourseID
WHERE s.SectionID IN (
    SELECT sr.SectionID
    FROM SectionRoster sr
    GROUP BY sr.SectionID
    HAVING COUNT(sr.StudentID) = (
        SELECT MAX(StudentCount)
        FROM (
            SELECT COUNT(StudentID) AS StudentCount
            FROM SectionRoster
            GROUP BY SectionID
        ) AS Counts
    )
);
-- 'Band'


-- Part 3: Subquery in the SELECT Clause
-- Select all Classes Show:
-- The Teacher That is assigned to Instruct
-- The Room That the class is in
-- No Joins Allowed

SELECT 
  c.CourseName,
  (SELECT CONCAT(t.FirstName, ' ', t.LastName)
   FROM Teacher t
   WHERE t.TeacherID = s.TeacherID) AS TeacherName,
  (SELECT r.RoomNumber
   FROM Room r
   WHERE r.RoomID = s.RoomID) AS RoomInfo
FROM Section s, Course c
WHERE s.CourseID = c.CourseID;

-- 'English 1', 'Auroora Huntriss', '201'
-- 'English 2', 'Edsel Lilleyman', '204'
-- 'English 2', 'Auroora Huntriss', '104'
-- 'English 2', 'Geno Booy', '103'
-- 'English 3', 'Amil Banting', '104'
-- 'English 3', 'Edsel Lilleyman', '103'
-- 'English 3', 'Geno Booy', '200'
-- 'AP English', 'Auroora Huntriss', '200'
-- 'Geometry', 'Ahmad Enticknap', '202'
-- 'Geometry', 'Michail Eatherton', '104'
-- 'Geometry', 'Ahmad Enticknap', '202'
-- 'Geometry', 'Amil Banting', '103'
-- 'Geometry', 'Sybille Standish-Brooks', '203'
-- 'Statistics', 'Dimitri Doblin', '103'
-- 'Calculus', 'Edsel Lilleyman', '204'
-- 'Calculus', 'Edsel Lilleyman', '204'
-- 'Biology', 'Salomi Arnaldo', '204'
-- 'Chemistry', 'Sybille Standish-Brooks', '101'
-- 'Chemistry', 'Dimitri Doblin', '103'
-- 'Chemistry', 'Bradly Toun', '201'
-- 'Chemistry', 'Geno Booy', '103'
-- 'Anatomy', 'Geno Booy', '101'
-- 'Anatomy', 'Salomi Arnaldo', '104'
-- 'Geology', 'Salomi Arnaldo', '201'
-- 'Geology', 'Michail Eatherton', '100'
-- 'Art 1', 'Auroora Huntriss', '204'
-- 'Art 1', 'Sybille Standish-Brooks', '105'
-- 'Art 1', 'Edsel Lilleyman', '105'
-- 'Art 2', 'Bradly Toun', '105'
-- 'Choir', 'Geno Booy', '101'
-- 'Choir', 'Auroora Huntriss', '201'
-- 'Choir', 'Ahmad Enticknap', '100'
-- 'Band', 'Michail Eatherton', '102'
-- 'Band', 'Bradly Toun', '101'
-- 'Band', 'Michail Eatherton', '202'
-- 'Band', 'Sybille Standish-Brooks', '100'
-- 'Theater', 'Bradly Toun', '101'
-- 'Theater', 'Auroora Huntriss', '202'
-- 'Theater', 'Geno Booy', '100'
-- 'European History', 'Dimitri Doblin', '105'
-- 'American History', 'Auroora Huntriss', '100'
-- 'American History', 'Dimitri Doblin', '200'
-- 'American History', 'Auroora Huntriss', '200'
-- 'African History', 'Auroora Huntriss', '200'
-- 'African History', 'Dimitri Doblin', '203'
-- 'African History', 'Geno Booy', '201'
-- 'African History', 'Michail Eatherton', '202'
-- 'African History', 'Salomi Arnaldo', '103'
-- 'Middle Eastern History', 'Bradly Toun', '203'
-- 'Asian History', 'Auroora Huntriss', '102'



-- Part 4: Subquery in the HAVING Clause
-- Use the Query from Part 2. Use Having to determine which class(s)
-- Has the least amount of Students (Must Be in a Subquery)

SELECT c.CourseName
FROM Course c
JOIN Section s ON c.CourseID = s.CourseID
WHERE s.SectionID IN (
    SELECT sr.SectionID
    FROM SectionRoster sr
    GROUP BY sr.SectionID
    HAVING COUNT(sr.StudentID) = (
        SELECT MIN(StudentCount)
        FROM (
            SELECT COUNT(StudentID) AS StudentCount
            FROM SectionRoster
            GROUP BY SectionID
        ) AS Counts
    )
);

-- 'Chemistry'
-- 'Chemistry'
-- 'American History'




-- Part 5: Correlated Subquery
-- Return the top 3 Teachers that have the most students to teach 
-- across all classes and semesters

SELECT t.TeacherID, 
	CONCAT(t.FirstName, ' ', t.LastName) AS TeacherName,
	(
	 SELECT COUNT(*)
	 FROM SectionRoster sr
	 JOIN Section s2 ON sr.SectionID = s2.SectionID
	 WHERE s2.TeacherID = t.TeacherID
	) AS TotalStudents
FROM Teacher t
ORDER BY TotalStudents DESC
LIMIT 3;

-- '6', 'Auroora Huntriss', '40'
-- '1', 'Michail Eatherton', '27'
-- '7', 'Geno Booy', '25'


-- Reflection Questions
-- 1. IN checks for value while EXISTS checks for existence. This means EXISTS runs faster because it is only looking
-- 	for whether something exists while IN has to check for a specific value as well.
--     
-- 2. It can only return one value because it is comparing all of them via some expression meaning you can't have multiple
-- 	results with making the comparison ambiguous
--     
-- 3. Normal subqueries run once while correlated subqueries run once PER ROW of the outer query