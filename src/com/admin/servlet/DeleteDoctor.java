package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;


@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		HttpSession session=request.getSession();
		
		if(dao.deleteDoctor(id)) {
			session.setAttribute("sucMsg", "Doctor Succesfully Deleted");
			response.sendRedirect("admin/Doctor.jsp");
		}else {
			session.setAttribute("erroMsg", "Error To Insert Doctor");
			response.sendRedirect("admin/Doctor.jsp");
		}
		
	}

}
