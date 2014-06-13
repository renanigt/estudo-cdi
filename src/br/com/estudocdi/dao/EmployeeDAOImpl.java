package br.com.estudocdi.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.estudocdi.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Map<Integer, Employee> employeeDB = new HashMap<Integer, Employee>();
	private Integer sequence = 1;
	
	@Override
	public Employee save(Employee employee) {
		employee.setId(sequence);
		employeeDB.put(sequence, employee);
		
		sequence++;
		
		return employee;
	}

	@Override
	public Employee findById(Integer id) {
		return employeeDB.get(id);
	}

}
