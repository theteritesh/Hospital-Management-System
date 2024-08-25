<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<%@ include file="component/allCss.jsp"%>
<style type="text/css">
.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="component/navebar.jsp"%>
	

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card point-card">
					<div class="card-body">
						<p class="fs-4 text-center">Admin Login</p>
						<form action=admin_login method="post">
							<c:if test="${not empty sucMsg}">
								<p class="text-center text-success fs-3">${sucMsg}</p>
								<c:remove var="sucMsg" />
							</c:if>

							<c:if test="${not empty erroMsg}">
								<p class="text-center text-danger fs-5">${erroMsg}</p>
								<c:remove var="erroMsg" />
							</c:if>
							<div class="md-3">
								<label class="form-label">Email Address</label><input required
									name="email" type="email" class="form-control">
							</div>
							<div class="md-3">
								<label class="form-label">Password</label><input required
									name="password" type="password" class="form-control">
							</div>
							<br>
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>