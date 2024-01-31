USE soft_uni;

DELIMITER $

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20)) RETURNS INT
DETERMINISTIC
BEGIN
		DECLARE e_count INT;
        SET e_count := (SELECT COUNT(employee_id) FROM employees e
        JOIN addresses a ON a.address_id = e.address_id
        JOIN towns t ON t.town_id = a.town_id
        WHERE t.`name` = town_name);
        RETURN e_count;
END $

DELIMITER ;

DROP FUNCTION ufn_count_employees_by_town;

SELECT ufn_count_employees_by_town('Sofia');