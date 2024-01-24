SELECT DISTINCT department_id, salary
FROM (
    SELECT
        department_id,
        salary,
        DENSE_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS salary_rank
    FROM
        employees
) ranked_salaries
WHERE salary_rank = 3;