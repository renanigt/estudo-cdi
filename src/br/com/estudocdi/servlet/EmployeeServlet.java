package br.com.estudocdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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
		String action = request.getParameter("action");
		
		Employee employee = new Employee();
		
		if("add".equals(action)) {
			employee.setName(request.getParameter("name"));
			employee.setAge(Integer.valueOf(request.getParameter("age")));
			
			dao.save(employee);
			
			request.setAttribute("notice", "Successfully added.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/index.jsp");
			dispatcher.forward(request, response);
		} else if("show".equals(action)) {
			employee.setId(Integer.valueOf(request.getParameter("id")));
			
			request.setAttribute("employee", dao.findById(employee.getId()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/show.jsp");
			dispatcher.forward(request, response);
		}
	}
	
}
