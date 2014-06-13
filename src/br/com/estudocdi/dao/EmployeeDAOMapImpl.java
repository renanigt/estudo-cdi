package br.com.estudocdi.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.estudocdi.annotation.DaoMAP;
import br.com.estudocdi.model.Employee;

@DaoMAP
public class EmployeeDAOMapImpl implements EmployeeDAO {

	private List<Employee> employeeDB = new ArrayList<Employee>();
	private Integer sequence = 1;
	
	@Override
	public Employee save(Employee employee) {
		employee.setId(sequence);
		employeeDB.add(employee);
		
		return employee;
	}

	@Override
	public Employee findById(Integer id) {
		for(Employee employeeReturn: employeeDB) {
			if(employeeReturn.getId() == id) {
				return employeeReturn;
			}
		}
		
		return null;
	}

}
