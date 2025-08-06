package com.Employee.Service;

import java.util.List;

import com.Employee.Model.Employee;

public interface EmployeeServices {
	List<Employee> getEmployee();
	void save(Employee employee);
	Employee getById(long id);
	void deleteById(long id);

}
