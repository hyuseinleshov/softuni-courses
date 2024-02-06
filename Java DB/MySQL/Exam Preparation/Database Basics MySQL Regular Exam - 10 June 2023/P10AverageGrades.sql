USE universities_db;

DELIMITER //

CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	DECLARE average_alumni_grade DECIMAL(19, 2);
    SET average_alumni_grade := (
		SELECT ROUND(AVG(sc.grade), 2)
		FROM students_courses sc
		LEFT JOIN students s ON sc.student_id = s.id
		JOIN courses c ON sc.course_id = c.id
		WHERE s.is_graduated = 1 AND c.`name` = course_name
    );
    RETURN average_alumni_grade;
END //

DELIMITER ;

SELECT udf_average_alumni_grade_by_course_name('Quantum Physics');

DROP FUNCTION udf_average_alumni_grade_by_course_name;
 
SELECT ROUND(AVG(sc.grade), 2)
FROM students_courses sc
LEFT JOIN students s ON sc.student_id = s.id
JOIN courses c ON sc.course_id = c.id
WHERE s.is_graduated = 1 AND c.`name` = 'Quantum Physics';