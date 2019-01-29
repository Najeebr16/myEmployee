package  web_maven_proj.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.trining.day7.jdbc.DataAccessException;

import web_maven_proj.EmployeeDao;
import web_maven_proj.dto.Emp;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		String name =request.getParameter("name");
		int empno=Integer.parseInt(request.getParameter("empno"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		Emp e= new Emp();
		e.setEmp_id(empno);
		e.setName(name);
		e.setSalary(salary);
		EmployeeDao ed= new EmployeeDao();
			try {
				ed.storeAll(e);
			} catch (DataAccessException e1) {
				e1.printStackTrace();
			}
			
			HttpSession session =request.getSession();
			session.setAttribute("message", "Record added Successfully");
		response.sendRedirect("addEmp.jsp");
		
		
		
	}

}
