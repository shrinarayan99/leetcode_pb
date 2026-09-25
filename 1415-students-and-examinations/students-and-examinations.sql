# Write your MySQL query statement below
# cross (jab dono table k pura pura data lena ho and if koi same attribute n ho)
select S.student_id ,S.student_name,sub.subject_name,
count(e.subject_name) as attended_exams

FROM Students S
cross join Subjects sub
left join Examinations e
on S.student_id=e.student_id and sub.subject_name=e.subject_name
group by  S.student_id ,S.student_name,sub.subject_name
order  by S.student_id,sub.subject_name