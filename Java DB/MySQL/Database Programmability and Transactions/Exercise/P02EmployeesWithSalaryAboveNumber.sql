DELIMITER $

CREATE PROCEDURE usp_get_employees_salary_above(IN treshold DECIMAL(10,4))
BEGIN
SELECT first_name, last_name
FROM employees
WHERE salary >= treshold
ORDER BY first_name, last_name, employee_id;
END $

DELIMITER ;

CALL usp_get_employees_salary_above(45000);

DROP PROCEDURE usp_get_employees_salary_above;