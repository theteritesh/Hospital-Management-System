package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;


@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		
		UserDao dao=new UserDao(DBConnect.getConn());
		
		HttpSession session=request.getSession();
		
		if(dao.checkOldPassword(uid, oldPassword)) {
			if(dao.changePassword(uid, newPassword)) {
				session.setAttribute("sucMsg", "Password Changed");
				response.sendRedirect("change_password.jsp");
			}else {
				session.setAttribute("erroMsg", "Something Wents Wrong");
				response.sendRedirect("change_password.jsp");
			}
			
		}else {
			session.setAttribute("erroMsg", "Old Password Incorrect");
			response.sendRedirect("change_password.jsp");
		}
	}

}
