<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>LANG Dictionary</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand">LANG</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">Users List</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/userOpenPage" class="btn btn-success">New User</a>
				<a href="<%=request.getContextPath()%>/menu" class="btn btn-danger">Menu</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="display:none">ID</th>
						<th>NAME</th>
						<th>SURNAME</th>
						<th>USERNAME</th>
						<th>PASSWORD</th>
						<th>STATE</th>
						<th>STATUS</th>
						<th></th>						
					</tr>
				</thead>
				<tbody>
					<!--   for Hissesi  -->
					<c:forEach var="users" items="${listUsers}">
							<tr>
								<td style="display:none"><c:out value="${users.id}" /></td>
								<td><c:out value="${users.name}" /></td>
								<td><c:out value="${users.surname}" /></td>
								<td><c:out value="${users.username}" /></td>
								<td><c:out value="${users.password}" /></td>
								<td><c:out value="${users.state}" /></td>
								<td><c:out value="${users.status}" /></td>
								
								<td><a href="userOpenUpdatePage?id=<c:out value='${users.id}' />" class="btn btn-warning">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="userDelete?id=<c:out value='${users.id}' />" class="btn btn-danger">Delete</a>
								</td>
							</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
