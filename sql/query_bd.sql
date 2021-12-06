use company;

SELECT department.name as departmentName , count(employee.depto_id) AS numEmployees FROM department LEFT JOIN employee ON employee.depto_id=department.id group by department.name ORDER BY numEmployees DESC;
