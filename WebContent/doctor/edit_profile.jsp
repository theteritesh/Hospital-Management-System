<%@page import="com.dao.SpecialistDao"%>
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
<title>Insert title here</title>
<%@include file="../component/allCss.jsp"%>
<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navebar.jsp"%>
	<c:if test="${empty docObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 ">
				<div class="card point-card"> s
					<p class="fs-3 text-center">Change Password</p>
					<c:if test="${not empty sucMsg}">
						<p class="text-center text-success fs-3">${sucMsg}</p>
						<c:remove var="sucMsg" />
					</c:if>

					<c:if test="${not empty erroMsg}">
						<p class="text-center text-danger fs-5">${erroMsg}</p>
						<c:remove var="erroMsg" />
					</c:if>
					<div class="card-body">
						<form action="../DoctorPasswordChange" method="post">
							<div>
								<label class="mb-3">Enter New Password</label><input type="text"
									name="newPassword" class="form-control" required>
							</div>
							<div>
								<label class="mb-3">Enter Old Password</label><input type="text"
									name="oldPassword" class="form-control" required>
							</div>
							<br> <input type="hidden" value="${docObj.id}" name="id">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-5 offset-md-2" >
					<div class="card point-card">
						<div class="card-body">
						<p class="text-center fs-3">Edit profile</p>
						<c:if test="${not empty sucMsgd}">
						<p class="text-center text-success fs-3">${sucMsgd}</p>
						<c:remove var="sucMsgd" />
					</c:if>

					<c:if test="${not empty erroMsgd}">
						<p class="text-center text-danger fs-5">${erroMsgd}</p>
						<c:remove var="erroMsgd" />
					</c:if>
						<form action="../EditProfile" method="post">
							<div class="md-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control" value="${docObj.fullname }">
							</div>

							<div class="md-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" class="form-control" value="${docObj.dob }">
							</div>

							<div class="md-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="quali" class="form-control" value="${docObj.qualification}">
							</div>

							<div class="md-3">
								<label class="form-label">Specialist</label><br>
								<select name="spec"
									required class="form-control">
									<option>${docObj.specialist}</option>
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
									type="email" required name="email" readonly class="form-control" value="${docObj.email}">
							</div>
							
							<div class="md-3">
								<label class="form-label">Mob No</label><input
									type="text" required name="mobno" class="form-control" value="${docObj.mobNo }">
							</div><br> 
							<input type="hidden" name="id" value="${docObj.id }">
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
						</div>
					</div>
				
				</div>
		</div>
	</div> 

</body>
</html>