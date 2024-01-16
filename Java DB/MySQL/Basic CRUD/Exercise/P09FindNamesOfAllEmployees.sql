SELECT CONCAT(first_name, ' ', middle_name, ' ', last_name) AS 'Full Name' FROM employees
WHERE SALARY IN (25000, 14000, 12500, 23600);