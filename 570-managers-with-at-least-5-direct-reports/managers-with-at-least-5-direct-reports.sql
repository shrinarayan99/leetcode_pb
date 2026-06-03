# Write your MySQL query statement below
select p.name
from Employee e
Inner Join Employee p
on e.managerId=p.id
GROUP BY p.id
HAVING COUNT(*) >= 5;