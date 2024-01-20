USE soft_uni;

SELECT * FROM towns
WHERE name NOT REGEXP '^[rbdRBD]'
ORDER BY name;