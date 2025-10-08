USE simpleschool;

-- QUESTION 1
SELECT
	course.CourseName,
    course.CreditHours,
    subject.SubjectName
FROM course
INNER JOIN subject
ON course.subjectID = subject.subjectID
WHERE subject.SubjectName = 'History'
ORDER BY course.CourseName;

-- 'African History', '3.00', 'History'
-- 'American History', '3.00', 'History'
-- 'Asian History', '3.00', 'History'
-- 'European History', '3.00', 'History'
-- 'Middle Eastern History', '3.00', 'History'


-- QUESTION 2
SELECT
	C.CourseName,
    C.CreditHours,
    S.SubjectName
FROM course C
LEFT JOIN subject S
ON C.SubjectID = S.SubjectID
WHERE S.SubjectName = 'History'
ORDER BY C.CourseName;

-- 'African History', '3.00', 'History'
-- 'American History', '3.00', 'History'
-- 'Asian History', '3.00', 'History'
-- 'European History', '3.00', 'History'
-- 'Middle Eastern History', '3.00', 'History'


-- QUESTION 3
SELECT
	C.CourseName,
    C.CreditHours,
    S.SubjectName
FROM course C
INNER JOIN subject S
ON C.subjectID = S.subjectID
WHERE S.SubjectName = 'History'
ORDER BY C.CourseName;

-- 'African History', '3.00', 'History'
-- 'American History', '3.00', 'History'
-- 'Asian History', '3.00', 'History'
-- 'European History', '3.00', 'History'
-- 'Middle Eastern History', '3.00', 'History'


-- QUESTION 4
SELECT
	C.CourseName,
    C.CreditHours,
    S.SubjectName
FROM course C
INNER JOIN subject S
ON C.subjectID = S.subjectID
WHERE S.SubjectName LIKE '%Art%'
ORDER BY S.SubjectName, C.CourseName;

-- 'Art 1', '3.00', 'Arts'
-- 'Art 2', '3.00', 'Arts'
-- 'Band', '3.00', 'Arts'
-- 'Choir', '3.00', 'Arts'
-- 'Theater', '3.00', 'Arts'
-- 'AP English', '3.00', 'Language Arts'
-- 'English 1', '3.00', 'Language Arts'
-- 'English 2', '3.00', 'Language Arts'
-- 'English 3', '3.00', 'Language Arts'



-- QUESTION 5
SELECT
	R.RoomNumber,
    R.Description,
    B.BuildingName
FROM room R
INNER JOIN building B
ON R.BuildingID = B.BuildingID
WHERE R.Description IS NULL;


-- QUESTION 6
SELECT
	C.CourseName AS "Courses more than 3.0 credits by Geno Booy"
FROM Teacher T
INNER JOIN Section S
ON T.TeacherID = S.TeacherID
INNER JOIN Course C
ON S.CourseID = C.CourseID
WHERE T.FirstName = 'Geno' AND T.LastName = 'Booy' AND C.CreditHours > 3;

-- 'Anatomy'
-- 'Chemistry'
