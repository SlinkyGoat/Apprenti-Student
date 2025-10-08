USE simpleschool;

-- 1
SELECT StudentID, LastName, FirstName FROM student WHERE LastName LIKE 'Cr%';
-- '36', 'Crutchfield', 'Marci'
-- '50', 'Crooks', 'Baudoin'


-- 2
SELECT * FROM course
WHERE SubjectID = 1
OR SubjectID = 2
OR SubjectID = 4;
-- '1', '1', 'English 1', '3.00'
-- '2', '1', 'English 2', '3.00'
-- '3', '1', 'English 3', '3.00'
-- '4', '1', 'AP English', '3.00'
-- '5', '2', 'Algebra 1', '4.00'
-- '6', '2', 'Geometry', '4.00'
-- '7', '2', 'Algebra 2', '4.00'
-- '8', '2', 'Statistics', '3.00'
-- '9', '2', 'Calculus', '4.00'
-- '14', '4', 'Art 1', '3.00'
-- '15', '4', 'Art 2', '3.00'
-- '16', '4', 'Choir', '3.00'
-- '17', '4', 'Band', '3.00'
-- '18', '4', 'Theater', '3.00'


-- 3
SELECT * FROM course
WHERE SubjectID IN (1, 2, 4);
-- '1', '1', 'English 1', '3.00'
-- '2', '1', 'English 2', '3.00'
-- '3', '1', 'English 3', '3.00'
-- '4', '1', 'AP English', '3.00'
-- '5', '2', 'Algebra 1', '4.00'
-- '6', '2', 'Geometry', '4.00'
-- '7', '2', 'Algebra 2', '4.00'
-- '8', '2', 'Statistics', '3.00'
-- '9', '2', 'Calculus', '4.00'
-- '14', '4', 'Art 1', '3.00'
-- '15', '4', 'Art 2', '3.00'
-- '16', '4', 'Choir', '3.00'
-- '17', '4', 'Band', '3.00'
-- '18', '4', 'Theater', '3.00'


-- 4
SELECT * FROM student WHERE StudentID = 42;
-- '42', 'Eal', 'Morphew', '2026'


-- 5
SELECT FirstName FROM student 
WHERE FirstName LIKE 'C%';
-- 'Carlita'
-- 'Chiquita'
-- 'Cecily'
-- 'Clemens'
-- 'Corrie'


-- 6
SELECT FirstName FROM student 
WHERE FirstName BETWEEN 'Ce%' AND 'Cf%';
-- 'Cecily'


-- 7
SELECT DISTINCT(LastName) FROM student LIMIT 10;
-- 'Charon'
-- 'Lowing'
-- 'Fitzjohn'
-- 'Ellicott'
-- 'Daveren'
-- 'Wickson'
-- 'Van Halen'
-- 'Casaccia'
-- 'Aiton'
-- 'McAdam'


-- 8
SELECT * FROM student LIMIT 10;
-- '1', 'Carlita', 'Charon', '2025'
-- '2', 'Deborah', 'Lowing', '2027'
-- '3', 'Rennie', 'Fitzjohn', '2026'
-- '4', 'Pam', 'Ellicott', '2024'
-- '5', 'Gisella', 'Daveren', '2028'
-- '6', 'Hazlett', 'Wickson', '2027'
-- '7', 'Jaquelin', 'Van Halen', '2025'
-- '8', 'Loralyn', 'Casaccia', '2027'
-- '9', 'Hailey', 'Aiton', '2027'
-- '10', 'Melonie', 'McAdam', '2024'


-- 9
SELECT * FROM student
ORDER BY LastName DESC
LIMIT 5;
-- '6', 'Hazlett', 'Wickson', '2027'
-- '22', 'Jocelyne', 'Walak', '2023'
-- '7', 'Jaquelin', 'Van Halen', '2025'
-- '34', 'Elwin', 'Truss', '2023'
-- '18', 'Fletcher', 'Tomczynski', '2023'
