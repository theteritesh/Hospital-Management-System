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


@WebServlet("/DoctorPasswordChange")
public class DoctorPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("id"));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		
		HttpSession session=request.getSession();
		
		if(dao.checkOldPassword(uid, oldPassword)) {
			if(dao.changePassword(uid, newPassword)) {
				session.setAttribute("sucMsg", "Password Changed");
				response.sendRedirect("doctor/edit_profile.jsp");
			}else {
				session.setAttribute("erroMsg", "Something Wents Wrong");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
			
		}else {
			session.setAttribute("erroMsg", "Old Password Incorrect");
			response.sendRedirect("doctor/edit_profile.jsp");
		}
	
	}

}
