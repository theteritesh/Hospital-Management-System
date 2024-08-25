<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor</title>
<%@ include file="../component/allCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navebar.jsp"%>

	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>

						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${sucMsg}</p>
							<c:remove var="sucMsg" />
						</c:if>
						<c:if test="${not empty erroMsg}">
							<p class="text-center text-denger fs-3">${erroMsg}</p>
							<c:remove var="erroMsg" />
						</c:if>
						<form action="../AddDoctor" method="post">
							<div class="md-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="md-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" class="form-control">
							</div>

							<div class="md-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="quali" class="form-control">
							</div>

							<div class="md-3">
								<label class="form-label">Specialist</label><br>
								<select name="spec"
									required class="form-control">
									<option>--select--</option>
									<% SpecialistDao dao=new SpecialistDao(DBConnect.getConn());
									List<Specalist>list=dao.getAllSpecialist();
									for(Specalist s:list){%>
									<option><%=s.getSpecialistName() %>
									<%}
									%>
								</select>
							</div>
							
							<div class="md-3">
								<label class="form-label">Email</label><input
									type="email" required name="email" class="form-control">
							</div>
							
							<div class="md-3">
								<label class="form-label">Mob No</label><input
									type="text" required name="mobno" class="form-control">
							</div>
							
							<div class="md-3">
								<label class="form-label">Password</label><input
									type="password" required name="password" class="form-control">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		
			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								
								<%
									DoctorDao dao2=new DoctorDao(DBConnect.getConn());
									List<Doctor> list2=dao2.getAllDoctor();
									for(Doctor d:list2){%>
										<tr>
										<td><%=d.getFullname() %></td>
										<td><%=d.getDob() %></td>
										<td><%=d.getQualification() %></td>
										<td><%=d.getSpecialist() %></td>
										<td><%=d.getEmail() %></td>
										<td><%=d.getMobNo() %></td>
										<td>
										<a href="edit_doctor.jsp?id=<%=d.getId() %>" class="btn btn-sm btn-primary">Edit</a>
										<a href="../DeleteDoctor?id=<%=d.getId() %>" class="btn btn-sm btn-danger">Delete</a>
										</td>										
										</tr>
									<%}
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