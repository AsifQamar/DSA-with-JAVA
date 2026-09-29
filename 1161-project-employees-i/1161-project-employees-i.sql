# Write your MySQL query statement below
select project_id, ROUND(AVG(experience_years),2) as average_years
from employee  inner join project on project.employee_id=employee.employee_id
group by project_id