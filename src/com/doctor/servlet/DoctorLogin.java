package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;


@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		Doctor d=dao.login(email, password);
		
		if (d != null) {
			session.setAttribute("docObj", d);
			response.sendRedirect("doctor/index.jsp");
		} else {
			session.setAttribute("erroMsg", "Invalid User Or Password");
			response.sendRedirect("doctor_login.jsp");
		}

	}

}
