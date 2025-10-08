-- Exercise: Selects

USE simpleschool;


-- -------------
-- Selecting Literal Values
-- -------------

-- 1
SELECT 'All for one'; -- 'All for one'
SELECT 'one for all'; -- 'one for all'


-- 2
SELECT concat('All for one', 'one for all'); -- 'All for oneone for all'

-- 3
SELECT 6 + 6; -- '12'

-- 4
SELECT 5/2; -- '2.5000'

-- 5
SELECT 5.0/2.0; -- '2.50000'

-- 6
SELECT 6/4, 6%4; -- '1.5000', '2'

-- 7
SELECT POW(6, 2); -- '36'


-- -------------
-- Selecting Against Tables
-- -------------

-- 1
SELECT * FROM building;
-- '1', 'Main Campus'
-- '2', 'Vocational Tech Campus'

-- 2
SELECT PeriodName, StartTime, EndTime FROM period;
-- '1st Period', '08:00:00', '08:45:00'
-- '2nd Period', '09:00:00', '09:45:00'
-- '3rd Period', '10:00:00', '10:45:00'
-- '4th Period', '11:00:00', '11:45:00'
-- '5th Period', '12:00:00', '12:45:00'
-- '6th Period', '13:00:00', '13:45:00'
-- '7th Period', '14:00:00', '14:45:00'
-- '8th Period', '15:00:00', '15:45:00'

-- 3
SELECT count(*) FROM building; -- 2
SELECT count(*) FROM course; -- 23
SELECT count(*) FROM grade; -- 0
-- The grade table is empty

-- 4
SELECT concat(CourseName, " (", CreditHours, ")") FROM course;
-- 'English 1 (3.00)'
-- 'English 2 (3.00)'
-- 'English 3 (3.00)'
-- 'AP English (3.00)'
-- 'Algebra 1 (4.00)'
-- 'Geometry (4.00)'
-- 'Algebra 2 (4.00)'
-- 'Statistics (3.00)'
-- 'Calculus (4.00)'
-- 'Biology (4.00)'
-- 'Chemistry (4.00)'
-- 'Anatomy (4.00)'
-- 'Geology (4.00)'
-- 'Art 1 (3.00)'
-- 'Art 2 (3.00)'
-- 'Choir (3.00)'
-- 'Band (3.00)'
-- 'Theater (3.00)'
-- 'European History (3.00)'
-- 'American History (3.00)'
-- 'African History (3.00)'
-- 'Middle Eastern History (3.00)'
-- 'Asian History (3.00)'

-- 5
SELECT CONCAT(LastName, ', ', LEFT(FirstName, 1)) AS TeacherName FROM teacher LIMIT 5;
-- 'Eatherton, M'
-- 'Standish-Brooks, S'
-- 'Arnaldo, S'
-- 'Banting, A'
-- 'Doblin, D'

-- 6
SELECT count(*) FROM room; -- 13 rooms

-- 7
SELECT RoomNumber, BuildingID FROM room; -- RommNumber ranges from 100 - 204

-- 8
SELECT Description FROM room;
-- It describes what type of room it is. It can be null

-- 9
SELECT count(distinct(SubjectID)) FROM course; -- 5 unique subject ids

-- 10
SELECT count(distinct(GradeTypeName)) from gradeType; -- 4 unique grade types

-- 11
SELECT GradeTypeID AS ID, GradeTypeName AS Name from gradeType;
-- '1', 'Homework'
-- '2', 'Quiz'
-- '3', 'Project'
-- '4', 'Exam'

-- 12
SELECT distinct(GradeTypeID) FROM gradeItem -- 3 and 4, therefore, Project and Exam

-- 13
-- 1 and 2 aka Homework and Quiz are not used
