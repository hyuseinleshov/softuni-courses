SELECT
    continent_code,
    currency_code,
    currency_usage
FROM (
    SELECT
        c.continent_code,
        c.currency_code,
        COUNT(c.currency_code) AS currency_usage,
        DENSE_RANK() OVER (PARTITION BY c.continent_code ORDER BY COUNT(c.currency_code) DESC) AS rnk
    FROM
        countries c
    GROUP BY
        c.continent_code, c.currency_code
    HAVING
        currency_usage > 1
) Subquery
WHERE
    rnk = 1
ORDER BY
    continent_code, currency_code;