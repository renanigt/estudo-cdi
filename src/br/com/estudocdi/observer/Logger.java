package br.com.estudocdi.observer;

import javax.enterprise.event.Observes;

import br.com.estudocdi.dao.EmployeeDAO;

public class Logger {

	public void showLog(@Observes EmployeeDAO employeeDAO) {
		System.out.println("Initializing the log for: " + employeeDAO.getClass().getSimpleName());
	}
	
}
