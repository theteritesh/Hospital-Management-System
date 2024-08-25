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
import com.entity.Doctor;


@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullname=request.getParameter("fullname");
			String dob=request.getParameter("dob");
			String qualification=request.getParameter("quali");
			String specialist=request.getParameter("spec");
			String email=request.getParameter("email");
			String mobNo=request.getParameter("mobno");
			String password=request.getParameter("password");
			int id=Integer.parseInt(request.getParameter("id"));
			
			Doctor d=new Doctor(id,fullname, dob, qualification, specialist, email, mobNo, password);
			DoctorDao dao=new DoctorDao(DBConnect.getConn());
			
			HttpSession session=request.getSession();
			
			if(dao.updateDoctor(d)) {
				session.setAttribute("sucMsg", "Doctor Succesfully Updated");
				response.sendRedirect("admin/Doctor.jsp");
			}else {
				session.setAttribute("erroMsg", "Error To Insert Doctor");
				response.sendRedirect("admin/Doctor.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
