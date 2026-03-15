# Write your MySQL query statement below

-- Self join: Employee table is used twice
-- e = employee
-- m = manager
select e.name as Employee from Employee e
Join Employee m

    -- Join condition
    -- e.managerId = m.id
    -- Meaning: Employee.managerId = Manager.id

on e.managerId=m.id

where e.salary>m.salary AND e.managerId IS NOT NULL;
