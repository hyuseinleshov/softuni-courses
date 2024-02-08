DELIMITER //

CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE offers_count INT;
    SET offers_count := (
		SELECT COUNT(*)
		FROM cities c
		JOIN properties p ON c.id = p.city_id
		JOIN property_offers po ON p.id = po.property_id
		WHERE c.`name` = cityName
    );
	RETURN offers_count;
END //

DELIMITER ;

SELECT udf_offers_from_city_name('Vienna');