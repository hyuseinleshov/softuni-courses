USE soft_uni;

DELIMITER //

CREATE PROCEDURE usp_get_employees_by_salary_level(IN p_salary_level VARCHAR(50))
BEGIN
	SELECT first_name, last_name
    FROM employees
    WHERE CASE
        WHEN salary < 30000 THEN 'Low'
        WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
        WHEN salary > 50000 THEN 'High'
        ELSE NULL
    END = p_salary_level
    ORDER BY first_name DESC, last_name DESC;
END //

DELIMITER ;

CALL usp_get_employees_by_salary_level('High');