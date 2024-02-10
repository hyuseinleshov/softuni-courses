SELECT id, `name`,
	CASE
		WHEN area <= 100 THEN 'very small'
        WHEN area > 100 AND area <= 1000 THEN 'small'
        WHEN area > 1000 AND area <= 10000 THEN 'medium'
        WHEN area > 10000 AND area <= 50000 THEN 'large'
        ELSE 'very large'
	END AS category
FROM preserves
ORDER BY area DESC;