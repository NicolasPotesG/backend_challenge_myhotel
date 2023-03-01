package com.challenge.employeesapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.employeesapi.Employee;
//import com.challenge.employeesapi.dtos.SegmentSalaryQuantityDTO;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT CASE WHEN e.salary < :minSalary THEN CONCAT('SEGMENTO A:', ' <', :minSalary)  WHEN e.salary >= :minSalary AND e.salary < :maxSalary THEN CONCAT('SEGMENTO B:', ' >=', :minSalary, ' AND', ' <', :maxSalary) ELSE CONCAT('SEGMENTO C:', ' >', :maxSalary) END AS segmento, COUNT(*) AS cantidad FROM Employee e GROUP BY segmento")
	List<Map<String, Object>> getQuantityEmployeesBySalarySegment(@Param("minSalary") int minSalary,
			@Param("maxSalary") int maxSalary);

	@Query("SELECT d.departmentName AS departamento, CASE WHEN e.salary < :minSalary THEN CONCAT('SEGMENTO A:', ' <', :minSalary)  WHEN e.salary >= :minSalary AND e.salary < :maxSalary THEN CONCAT('SEGMENTO B:', ' >=', :minSalary, ' AND', ' <', :maxSalary) ELSE CONCAT('SEGMENTO C:', ' >', :maxSalary) END AS segmento, COUNT(*) AS cantidad FROM Employee e JOIN e.department d GROUP BY d.departmentName, segmento")
	List<Map<String, Object>> getQuantityEmployeesByDepartmentAndSalarySegment(@Param("minSalary") int minSalary,
			@Param("maxSalary") int maxSalary);

	@Query("SELECT d.departmentName AS departmentName, e.employeeId AS employeeId, e.firstName AS firstName, e.lastName AS lastName, e.email AS email, e.phoneNumber AS phoneNumber, e.hireDate AS hireDate, e.salary AS salary, e.commissionPCT AS commissionPCT, e.managerId AS managerId, d.departmentId AS departmentId FROM Employee e, Department d WHERE e.department.id = d.id AND (e.department.id, e.salary) IN (SELECT e2.department.id, MAX(e2.salary) FROM Employee e2 GROUP BY e2.department.id)")
	List<Map<String, Object>> getEmployeesWithHighestSalaryByDepartment();

	@Query("SELECT e.employeeId AS employeeId, e.firstName AS firstName, e.lastName AS lastName, e.email AS email, e.phoneNumber AS phoneNumber, e.hireDate AS hireDate, j.jobId AS jobId, e.salary AS salary, e.commissionPCT AS commissionPCT, e.managerId AS managerId, d.departmentId AS departmentId FROM Employee e JOIN e.job j JOIN e.department d WHERE SUBSTRING_INDEX(j.jobId, '_', -1) = 'MGR' AND e.hireDate < DATEADD(YEAR, - :years, CURRENT_DATE)")
	List<Map<String, Object>> getManagersOlderThan(@Param("years") int years);

	@Query("SELECT d.departmentName AS departamento, AVG(e.salary) AS salarioPromedio "
			+ "FROM Employee e JOIN e.department d " + "GROUP BY d.departmentName " + "HAVING COUNT(*) > :count")
	List<Map<String, Object>> getDepartmentsSalaryAverageHavingMoreThan(@Param("count") int count);

	@Query("SELECT c.countryName AS pais, COUNT(e.employeeId) AS cantidad_empleados, AVG(e.salary) AS salario_promedio, MAX(e.salary) AS salario_mas_alto, MIN(e.salary) AS salario_mas_bajo, AVG(DATEDIFF(NOW(), e.hireDate)/365) AS antiguedad_promedio FROM Employee e JOIN e.department d JOIN d.location l JOIN l.country c GROUP BY c.countryName")
	List<Map<String, Object>> getEmployeeStatsByCountry();

}
