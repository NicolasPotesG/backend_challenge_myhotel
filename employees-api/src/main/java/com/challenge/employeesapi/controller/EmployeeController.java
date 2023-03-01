package com.challenge.employeesapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.employeesapi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/salary-segments-quantity")
	public ResponseEntity<List<Map<String, Object>>> getQuantityEmployeesBySalarySegment(@RequestParam int minSalary,
			@RequestParam int maxSalary) {
		List<Map<String, Object>> salarySegmentsQuantity = employeeService
				.getQuantityEmployeesBySalarySegment(minSalary, maxSalary);
		return new ResponseEntity<>(salarySegmentsQuantity, HttpStatus.OK);
	}

	@GetMapping("/salary-segments-quantity-by-department")
	public ResponseEntity<List<Map<String, Object>>> getQuantityEmployeesByDepartmentAndSalarySegment(
			@RequestParam int minSalary, @RequestParam int maxSalary) {
		List<Map<String, Object>> salarySegmentsQuantityByDepartment = employeeService
				.getQuantityEmployeesByDepartmentAndSalarySegment(minSalary, maxSalary);
		return new ResponseEntity<>(salarySegmentsQuantityByDepartment, HttpStatus.OK);
	}

	@GetMapping("/highest-salary-by-department")
	public ResponseEntity<List<Map<String, Object>>> getEmployeesWithHighestSalaryByDepartment() {
		List<Map<String, Object>> employeesHighestSalaryByDepartment = employeeService
				.getEmployeesWithHighestSalaryByDepartment();
		return new ResponseEntity<>(employeesHighestSalaryByDepartment, HttpStatus.OK);
	}

	@GetMapping("/managers-older-than")
	public ResponseEntity<List<Map<String, Object>>> getManagersOlderThan(@RequestParam int years) {
		List<Map<String, Object>> managersOlderThan = employeeService.getManagersOlderThan(years);
		return new ResponseEntity<>(managersOlderThan, HttpStatus.OK);
	}

	@GetMapping("/departments-salary-avg-having-more-than")
	public ResponseEntity<List<Map<String, Object>>> getDepartmentsSalaryAverageHavingMoreThan(
			@RequestParam int count) {
		List<Map<String, Object>> departmentsSalaryAvgHavingMoreThan = employeeService
				.getDepartmentsSalaryAverageHavingMoreThan(count);
		return new ResponseEntity<>(departmentsSalaryAvgHavingMoreThan, HttpStatus.OK);
	}

	@GetMapping("/stats-by-country")
	public ResponseEntity<List<Map<String, Object>>> getEmployeeStatsByCountry() {
		List<Map<String, Object>> employeeStatsByCountry = employeeService.getEmployeeStatsByCountry();
		return new ResponseEntity<>(employeeStatsByCountry, HttpStatus.OK);
	}

}
