package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;


@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int did=Integer.parseInt(request.getParameter("did"));
			String comm=request.getParameter("comm");
			AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
			HttpSession session=request.getSession();
			
			if(dao.updateComment(id, did, comm)) {
				session.setAttribute("sucMsg", "Comment Updated");
				response.sendRedirect("doctor/patient.jsp");
			}else {
				session.setAttribute("erroMsg", " Something Wents Wrong");
				response.sendRedirect("doctor/ patient.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
