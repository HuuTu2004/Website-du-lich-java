<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="resources/index2.html"><b>Admin</b>LTE</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<c:if test="${scc!=null}">
										<div class="alert alert-success">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">&times;</button>
											<strong>alert!</strong> ${scc }
										</div>
									</c:if>
									<c:if test="${mess!=null}">
										<div class="alert alert-success">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">&times;</button>
											<strong>alert!</strong> ${mess }
										</div>
									</c:if>
			<p class="login-box-msg">Sign in to start your session</p>

			<form name='formLogin'
				action="<c:url value='/j_spring_security_login' />" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="username"
						placeholder="username"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password"
						name='password'> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="row">

					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<a href="#">I forgot my password</a><br> <a href="register"
				class="text-center">Register a new membership</a>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.0 -->
	<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/plugins/iCheck/icheck.min.js"></script>

</body>
</html>
