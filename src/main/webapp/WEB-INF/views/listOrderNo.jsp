<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>index</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="/Spring01/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="/Spring01/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="/Spring01/resources/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<!-- resources wrapper -->
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b>LTE</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<!-- Notifications: style can be found in dropdown.less -->


						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="/Spring01/resources/dist/img/user2-160x160.jpg"
								class="user-image" alt="User Image"> <span
								class="hidden-xs">
									${pageContext.request.userPrincipal.name}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="/Spring01/resources/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image">

									<p>
										${pageContext.request.userPrincipal.name} - Web Developer <small>Member
											since Nov. 2012</small>
									</p></li>

							</ul></li>

					</ul>
				</div>
			</nav>
		</header>



		<aside class="main-sidebar">

			<section class="sidebar">
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/Spring01/resources/ dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${pageContext.request.userPrincipal.name}</p>
						<form action="<c:url value='/j_spring_security_logout' />"
							method="post">

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout" />

						</form>
					</div>
				</div>
				<!-- search form -->




				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>Danh Mục</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a
								href="<c:url value='/admin/listCategory'/>"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
							<li><a href="<c:url value='/admin/insertCategory'/>"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
						</ul></li>
					<li class=" treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>Quản lý Tour</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a
								href="<c:url value='/admin/listProduct'/>"><i
									class="fa fa-circle-o"></i> Danh sách</a></li>
							<li><a href="<c:url value='/admin/insertProduct'/>"><i
									class="fa fa-circle-o"></i> Thêm mới</a></li>
						</ul></li>

					<li class="treeview "><a href="#"> <i class="fa fa-th"></i>
							<span>Quản Lý Khách Hàng</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a
								href="<c:url value='/admin/listAccount'/>"><i
									class="fa fa-circle-o"></i> Danh sách Tài Khoản Hoạt Động</a></li>
							<li><a href="<c:url value='/admin/listAccountNo'/>"><i
									class="fa fa-circle-o"></i> Danh sách Tài Khoản Chưa Xác Thực</a></li>
						</ul></li>

					<li class="active treeview "><a href="#"> <i
							class="fa fa-th"></i> <span>Quản Lý Đơn Hàng</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li ><a
								href="<c:url value='/admin/listOrder'/>"><i
									class="fa fa-circle-o"></i> Danh sách Đơn hàng đã xác nhận</a></li>
							<li class="active"><a href="<c:url value='/admin/listOrderNo'/>"><i
									class="fa fa-circle-o"></i> Danh sách Đơn hàng chưa xác nhận</a></li>
						</ul></li>




				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1></h1>

			</section>

			<!-- Main content -->
			<section class="content">

				<!-- Default box -->
				<div class="box">

					<div class="box-body">

						<div class="row">

							<div class="col-md-12">
								<c:if test="${param.scc!=null}">
									<div class="alert alert-success">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										<strong>WARNING!</strong> ${param.scc }
									</div>
								</c:if>
								<c:if test="${err!=null}">
									<div class="alert alert-danger">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										<strong>WARNING!</strong> ${err }
									</div>
								</c:if>



<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

								<br>
								<h2>Danh sách đơn hàng chưa xác nhận</h2>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Số thứ tự</th>
											<th>Tên Khách Hàng</th>
											<th>Tên gói</th>
											<th>Ngày đặt hàng</th>
											<th>Giá</th>
											<th>Ảnh</th>
											<th>Trạng thái</th>
											<th> </th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${order }" var="orderDetail" varStatus="loop">
											<tr>
												<td>${loop.index+1}</td>
												<td>${orderDetail.user.fullName}</td>
												<td>${orderDetail.tour.tourName}</td>
												<td>${orderDetail.orderDate}</td>
												<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber
														value="${orderDetail.tour.price}" type="currency" /></td>
												<td><img
													src="/Spring01/resources/img/${orderDetail.tour.image}"
													width="60px" /></td>
												<td>${orderDetail.status?"Xác nhận":"Chưa Xác Nhận"}</td>
												<td><a href="confirmOrder?id=${orderDetail.orderDetailId}" class="btn btn-primary">Xác nhận Đơn hàng</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>


							</div>
						</div>


					</div>


				</div>
				<!-- /.box -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.3
			</div>
			<strong>Copyright &copy; 2014-2015 <a
				href="http://almsaeedstudio.com">Almsaeed Studio</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>

				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>

									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>

									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>

									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked>
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript:void(0)" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.0 -->
	<script src="/Spring01/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="/Spring01/resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="/Spring01/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="/Spring01/resources/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="/Spring01/resources/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/Spring01/resources/dist/js/demo.js"></script>

</body>

</html>