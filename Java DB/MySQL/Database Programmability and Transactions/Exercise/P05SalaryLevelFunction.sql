USE soft_uni;

DELIMITER //

CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	DECLARE level VARCHAR(50);
    
	CASE
        WHEN salary < 30000 THEN SET level = 'Low';
        WHEN salary BETWEEN 30000 AND 50000 THEN SET level = 'Average';
        ELSE SET level = 'High';
    END CASE;
    
    RETURN level;
END //

DELIMITER ;

SELECT ufn_get_salary_level(13500.00);

DROP FUNCTION ufn_get_salary_level;