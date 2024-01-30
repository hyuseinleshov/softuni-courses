SELECT 
    c.country_code, COUNT(*) AS mountain_range
FROM
    countries c
        JOIN
    mountains_countries mc ON c.country_code = mc.country_code
GROUP BY mc.country_code
HAVING c.country_code IN ('US' , 'RU', 'BG')
ORDER BY mountain_range DESC;