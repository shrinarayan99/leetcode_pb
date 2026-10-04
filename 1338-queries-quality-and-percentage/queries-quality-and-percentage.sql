# Write your MySQL query statement below
SELECT query_name,ROUND(AVG(rating/position),2) AS quality ,
#IF RATING <3 THEN COUNT++, ELSE COUNT+=0
ROUND(AVG(IF(rating<3,1,0))*100,2)AS poor_query_percentage
FROM Queries
GROUP BY query_name  