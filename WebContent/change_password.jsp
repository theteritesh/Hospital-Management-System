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
	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card point-card"> 
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
						<form action="ChangePassword" method="post">
							<div>
								<label class="mb-3">Enter New Password</label><input type="text"
									name="newPassword" class="form-control" required>
							</div>
							<div>
								<label class="mb-3">Enter Old Password</label><input type="text"
									name="oldPassword" class="form-control" required>
							</div>
							<br> <input type="hidden" value="${userObj.id}" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>