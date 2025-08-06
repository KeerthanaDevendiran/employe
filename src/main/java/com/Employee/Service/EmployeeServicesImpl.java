package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;

public class EmployeeServicesImpl implements EmployeeServices {
 
	@Autowired EmployeeRepository empRepo;
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.save(employee);
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional=empRepo.findById(id);
		Employee employee=null;
		if(optional.isPresent())
			employee=optional.get();
		else
			throw new RuntimeException("Employee not found in this id"+id);
		return employee;
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
	empRepo.deleteById(id);	
	}

}
