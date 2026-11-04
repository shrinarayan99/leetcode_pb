# Write your MySQL query statement below
SELECT MAX(num) AS num
FROM (SELECT num AS num
FROM MyNumbers
GROUP BY num
HAVING COUNT(*)=1) AS RESULT

--  (SELECT num
-- FROM MyNumbers
-- GROUP BY num
-- HAVING COUNT(*)=(SELECT MIN(freq) FROM 
-- (SELECT num ,COUNT(num) AS freq
-- FROM MyNumbers
-- GROUP BY num
-- ORDER BY freq  ASC) AS temp) ) AS resul