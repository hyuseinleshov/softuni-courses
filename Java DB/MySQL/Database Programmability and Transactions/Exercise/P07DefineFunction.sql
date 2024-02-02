DELIMITER //

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE set_length INT;
    DECLARE word_length INT;
    DECLARE i INT DEFAULT 1;
    DECLARE current_letter CHAR(1);
    
	SET set_length = LENGTH(set_of_letters);
    SET word_length = LENGTH(word);
    
	WHILE i <= word_length DO
	SET current_letter = SUBSTRING(word, i, 1);
	IF LOCATE(current_letter, set_of_letters) = 0 THEN
	RETURN 0;
        END IF;
        SET i = i + 1;
    END WHILE;
    RETURN 1;
END //

DELIMITER ;

SELECT ufn_is_word_comprised('oistmiahf', 'halves');