package com.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Employee.Model.Employee;
import com.Employee.Service.EmployeeServicesImpl;

public class EmployeeController {
@Autowired
EmployeeServicesImpl employeeServicesImpl;

@GetMapping("/")
public String viewHomePage(Model model) {
	model.addAttribute("allemplist",employeeServicesImpl.getEmployee());
	return "index";
}

@GetMapping("/addnew")
public String addNewEmployee(Model model) {
	Employee employee=new Employee();
	model.addAttribute("employee",employee);
	return "newemployee";
}

@PostMapping("/save")
public String saveEmployee(@ModelAttribute ("employee")Employee employee) {
	employeeServicesImpl.save(employee);
	return "redirect:/";
	
}

@GetMapping("/showformfotupdate/{id}")
public String showUpdate(@PathVariable (value="id") long id, Model model) {
	Employee employee=employeeServicesImpl.getById(id);
	model.addAttribute("employee",employee);
	return "update";
}

@GetMapping("/deleteEmployee/{id}")
public String deleteThroughtId(@PathVariable(value="id")long id) {
	employeeServicesImpl.deleteById(id);
	return "redirect:/";
	
}
}
