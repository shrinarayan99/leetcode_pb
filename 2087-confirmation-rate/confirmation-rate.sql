# Write your MySQL query statement below

#https://www.youtube.com/watch?v=W1opL0UgiIs



#AGAR ACTION CONFIRM HAI TO 1 NHI TO 0
# AVERAGE ACTION DIVIDE KRTA HAI Y KAREGA GRP BY SE KYUKI BO TOTAL TIME USER_ID OCCURANCE CHECK KR RHA HAI AND NUMERATOR ME IF FUNCTION KA COUNT RHEGA

#ROUND(VALUE, UPTO DECIMAL)

SELECT  S.user_id , ROUND(AVG( IF(C.action='confirmed',1,0)),2) AS confirmation_rate 
FROM Signups S
LEFT JOIN Confirmations C
ON S.user_id =C.user_id 
GROUP BY S.user_id
