package br.com.estudocdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudocdi.annotation.DaoMAP;
import br.com.estudocdi.dao.EmployeeDAO;
import br.com.estudocdi.model.Employee;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject @DaoMAP
	private EmployeeDAO dao;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setAge(Integer.valueOf(request.getParameter("age")));
		
		dao.save(employee);
	}
	
}
