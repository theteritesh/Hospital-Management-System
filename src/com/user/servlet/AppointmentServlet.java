package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@WebServlet("/Appointment")
public class AppointmentServlet extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userid"));
		String fullName=request.getParameter("fullname");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String appoinDate=request.getParameter("appoin_date");
		String email=request.getParameter("email");
		String mobNo=request.getParameter("mobno");
		String diseases=request.getParameter("diseases");
		int doctorId=Integer.parseInt(request.getParameter("doct"));
		String address=request.getParameter("address");
		
		Appointment ap=new Appointment(userId, fullName, gender, age, appoinDate, email, mobNo, diseases, doctorId, address, "Pending");
		AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
		
		HttpSession session=request.getSession();
		
		if(dao.addAppointment(ap)) {
			session.setAttribute("sucMsg", "Appoinment Added");
			response.sendRedirect("user_appointment.jsp");
		}else {
			session.setAttribute("erroMsg", " Something Wents Wrong");
			response.sendRedirect("user_appointment.jsp");
		}
	}

}
