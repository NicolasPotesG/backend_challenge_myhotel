package com.challenge.employeesapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.challenge.employeesapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Map<String, Object>> getQuantityEmployeesBySalarySegment(int minSalary, int maxSalary) {
		return employeeRepository.getQuantityEmployeesBySalarySegment(minSalary, maxSalary);
	}

	public List<Map<String, Object>> getQuantityEmployeesByDepartmentAndSalarySegment(int minSalary, int maxSalary) {
		return employeeRepository.getQuantityEmployeesByDepartmentAndSalarySegment(minSalary, maxSalary);
	}

	public List<Map<String, Object>> getEmployeesWithHighestSalaryByDepartment() {
		return employeeRepository.getEmployeesWithHighestSalaryByDepartment();
	}

	public List<Map<String, Object>> getManagersOlderThan(int years) {
		return employeeRepository.getManagersOlderThan(years);
	}

	public List<Map<String, Object>> getDepartmentsSalaryAverageHavingMoreThan(int count) {
		return employeeRepository.getDepartmentsSalaryAverageHavingMoreThan(count);
	}

	public List<Map<String, Object>> getEmployeeStatsByCountry() {
		return employeeRepository.getEmployeeStatsByCountry();
	}
}
