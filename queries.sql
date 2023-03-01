/* Query 1 */
SELECT 
  CASE 
    WHEN e.salary < 3500 THEN 'SEGMENTO A' 
    WHEN e.salary >= 3500 AND e.salary < 8000 THEN 'SEGMENTO B' 
    ELSE 'SEGMENTO C' 
  END AS segmento, 
  COUNT(*) AS cantidad 
FROM myhotel_test.employees AS e 
GROUP BY segmento;

/* Query 2 */
SELECT
  d.department_name AS departamento,
  CASE
    WHEN e.salary < 3500 THEN 'SEGMENTO A'
    WHEN e.salary >= 3500 AND e.salary < 8000 THEN 'SEGMENTO B'
    ELSE 'SEGMENTO C'
  END AS segmento,
  COUNT(*) AS cantidad
FROM myhotel_test.employees AS e
JOIN myhotel_test.departments AS d ON e.department_id = d.department_id
GROUP BY departamento, segmento;

/* Query 3 */
SELECT 
  d.department_name AS departamento, 
  e.* 
FROM 
  myhotel_test.employees AS e 
  JOIN myhotel_test.departments AS d ON e.department_id = d.department_id 
  JOIN (SELECT department_id, MAX(salary) AS max_salary FROM myhotel_test.employees GROUP BY department_id) AS e2 
    ON e.department_id = e2.department_id AND e.salary = e2.max_salary;

/* Query 4 */
SELECT e.* 
FROM myhotel_test.employees AS e
WHERE SUBSTRING_INDEX(e.job_id, '_', -1) = 'MGR' AND
e.hire_date < DATE_SUB(NOW(), INTERVAL 15 YEAR)

/* Query 5 */
SELECT 
  d.department_name AS departamento, 
  AVG(e.salary) AS salario_promedio
FROM 
  myhotel_test.employees AS e 
  JOIN myhotel_test.departments AS d ON e.department_id = d.department_id 
GROUP BY 
  d.department_name 
HAVING 
  COUNT(*) > 10;

/* Query 6 */
SELECT 
  c.country_name AS pais, 
  COUNT(e.employee_id) AS cantidad_empleados, 
  AVG(e.salary) AS salario_promedio, 
  MAX(e.salary) AS salario_mas_alto, 
  MIN(e.salary) AS salario_mas_bajo, 
  AVG(DATEDIFF(NOW(), e.hire_date)/365) AS antiguedad_promedio 
FROM 
  myhotel_test.employees AS e 
  JOIN myhotel_test.departments AS d ON e.department_id = d.department_id 
  JOIN myhotel_test.locations AS l ON d.location_id = l.location_id 
  JOIN myhotel_test.countries AS c ON l.country_id = c.country_id 
GROUP BY 
  c.country_name;