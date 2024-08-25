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


@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullname=request.getParameter("fullname");
			String dob=request.getParameter("dob");
			String qualification=request.getParameter("quali");
			String specialist=request.getParameter("spec");
			String email=request.getParameter("email");
			String mobNo=request.getParameter("mobno");
			int id=Integer.parseInt(request.getParameter("id"));
			
			Doctor d=new Doctor(id,fullname, dob, qualification, specialist, email, mobNo, "");
			DoctorDao dao=new DoctorDao(DBConnect.getConn());
			
			HttpSession session=request.getSession();
			
			if(dao.editDoctorProfile(d)) {
				Doctor updateDoctor= dao.getDoctorById(id);
				session.setAttribute("sucMsgd", "Doctor Succesfully Updated");
				session.setAttribute("docObj", updateDoctor);
				response.sendRedirect("doctor/edit_profile.jsp");
			}else {
				session.setAttribute("erroMsgd", "Error To Insert Doctor");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
