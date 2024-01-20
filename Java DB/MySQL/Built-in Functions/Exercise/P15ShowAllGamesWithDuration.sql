SELECT * FROM games;

SELECT 
	`name`,
	CASE
		WHEN TIME(`start`) BETWEEN '00:00:00' AND '11:59:59' THEN 'Morning'
		WHEN TIME(`start`) BETWEEN '12:00:00' AND '17:59:59' THEN 'Afternoon'
        WHEN TIME(`start`) BETWEEN '18:00:00' AND '23:59:59' THEN 'Evening'
	END AS 'Part of the Day',
    CASE
		WHEN duration BETWEEN 1 AND 3 THEN 'Extra Short'
        WHEN duration BETWEEN 3 AND 6 THEN 'Short'
        WHEN duration BETWEEN 6 AND 10 THEN 'Long'
        ELSE 'Extra Long'
        END AS Duration
    FROM games;