package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String ssn);
	
	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

}
