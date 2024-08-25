<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="component/navebar.jsp"%>
	
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card point-card">
					<div class="card-body">
						<p class="fs-3 text-center"> User Appointment</p>

						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${sucMsg}</p>
							<c:remove var="sucMsg" />
						</c:if>
						<c:if test="${not empty erroMsg}">
							<p class="text-center text-denger fs-3">${erroMsg}</p>
							<c:remove var="erroMsg" />
						</c:if>
						<form class="row g-3" action="Appointment" method="post">
						<input type="hidden" name="userid" value="${userObj.id}">
							<div class="col-md-6">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="col-md-6">
								<label>Gender</label>
								<select name="gender"
									required class="form-control">
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label class="form-label">Age</label><input
									type="number" required name="age" class="form-control">
							</div>

							<div class="col-md-6">
								<label class="form-label">Appointment Date</label><input type="date"
									required name="appoin_date" class="form-control">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Email</label><input
									type="email" required name="email" class="form-control">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Mob No</label><input
									type="number" maxlength="10" name="mobno" class="form-control">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Diseases</label><input
									type="text" required name="diseases" class="form-control">
							</div>
							<div class="col-md-6">
								<label class="form-label">Doctor</label><br>
								<select name="doct"
									required class="form-control">
									<option >--select--</option>
									<%
									DoctorDao dao=new DoctorDao(DBConnect.getConn());
									List <Doctor> list=dao.getAllDoctor();
									for(Doctor d:list) { %>
										
										<option  value="<%=d.getId()%>"><%=d.getFullname() %>(<%=d.getSpecialist() %>)</option>	
										
									<%}
									%>
								</select>
							</div>
							
							<div class="md-3">
								<label class="form-label">Full Address</label><br>
								<textarea required name="address" class="form-control" rows="3" cols=""></textarea>
							</div>
							
							<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>
							
							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
							
							
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="component/footer.jsp"%>
</body>
</html>