<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor</title>
<%@ include file="../component/allCss.jsp"%>
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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor Details</p>

						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${sucMsg}</p>
							<c:remove var="sucMsg" />
						</c:if>
						<c:if test="${not empty erroMsg}">
							<p class="text-center text-denger fs-3">${erroMsg}</p>
							<c:remove var="erroMsg" />
						</c:if>
						
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						DoctorDao dao2=new DoctorDao(DBConnect.getConn());
						Doctor d=dao2.getDoctorById(id);
						%>
						
						
						<form action="../UpdateDoctor" method="post">
							<div class="md-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control" value="<%=d.getFullname()%>">
							</div>

							<div class="md-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" class="form-control" value="<%=d.getDob()%>">
							</div>

							<div class="md-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="quali" class="form-control" value="<%=d.getQualification()%>">
							</div>

							<div class="md-3">
								<label class="form-label">Specialist</label><br>
								<select name="spec"
									required class="form-controll">
									<option><%=d.getSpecialist()%></option>
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
									type="email" required name="email" class="form-control" value="<%=d.getEmail()%>">
							</div>
							
							<div class="md-3">
								<label class="form-label">Mob No</label><input
									type="text" required name="mobno" class="form-control" value="<%=d.getMobNo()%>">
							</div>
							
							<div class="md-3">
								<label class="form-label">Password</label><input
									type="text" required name="password" class="form-control" value="<%=d.getPassword()%>">
							</div><br>
							<input type="hidden" name="id" value="<%=d.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		
		
		
		</div>
	</div>

</body>
</html>