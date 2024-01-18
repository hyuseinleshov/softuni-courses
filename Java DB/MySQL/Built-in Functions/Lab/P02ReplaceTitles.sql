SELECT REPLACE(`title`, 'The', '***')
AS 'Title'
FROM books
WHERE SUBSTRING(`title`, 1, 4) = 'The ';