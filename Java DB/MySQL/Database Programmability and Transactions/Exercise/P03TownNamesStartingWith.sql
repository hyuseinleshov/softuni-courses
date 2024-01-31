DELIMITER //

CREATE PROCEDURE usp_get_towns_starting_with(IN prefix VARCHAR(255))
BEGIN
SELECT `name`
FROM towns
WHERE `name` LIKE CONCAT(prefix, '%')
ORDER BY `name`;
END //

DELIMITER ;

CALL usp_get_towns_starting_with('b');