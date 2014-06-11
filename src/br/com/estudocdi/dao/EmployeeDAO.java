package br.com.estudocdi.dao;

import br.com.estudocdi.model.Employee;

public interface EmployeeDAO {

	Employee save(Employee employee);

	Employee findById(Integer id);
	
}
