# Write your MySQL query statement below
SELECT e.employee_id ,e.name,COUNT(DISTINCT(s.employee_id)) AS reports_count , ROUND(AVG(s.age),0) AS average_age
FROM Employees e
INNER JOIN Employees s
ON e.employee_id=s.reports_to 
-- WHERE e.reports_to IS NULL
GROUP BY employee_id, e.name
ORDER BY employee_id 
