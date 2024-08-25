<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>


<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="component/navebar.jsp"%>
	<c:if test="${empty userObj }">
	<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9 offset-md-3">
				<div class="card point-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text Success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
									User user = (User) session.getAttribute("userObj");
									AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
									DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
									List<Appointment> list = dao.getAllAppoinmentByLoginUser(user.getId());
									for (Appointment ap : list) {
										Doctor d = dao2.getDoctorById(ap.getDoctorId());
								%>

								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppoinDate()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=d.getFullname()%></td>
									<td>
										<%
											if ("Pending".equals(ap.getStatus())) {
										%> <a href="#"
										class="btn btn-sm btn-warning">Pending </a> <%
 	} else {
 %> <%=ap.getStatus()%>
										<%
											}
										%>

									</td>
								</tr>

								<%
									}
								%>

							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>