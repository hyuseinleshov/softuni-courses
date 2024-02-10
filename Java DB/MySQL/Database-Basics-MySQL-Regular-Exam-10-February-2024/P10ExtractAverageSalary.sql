DELIMITER //

CREATE FUNCTION udf_average_salary_by_position_name (`name` VARCHAR(40))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	DECLARE average_salary DECIMAL(19, 2);
    SET average_salary := (
    SELECT AVG(salary)
	FROM workers w
	JOIN positions p ON w.position_id = p.id
	WHERE p.`name` = `name`
    );
    RETURN average_salary;
END //

DELIMITER ;

SELECT AVG(salary)
FROM workers w
JOIN positions p ON w.position_id = p.id
WHERE p.`name` = 'Forester';

SELECT p.name, udf_average_salary_by_position_name('Forester') as position_average_salary FROM positions p 
WHERE p.name = 'Forester';
