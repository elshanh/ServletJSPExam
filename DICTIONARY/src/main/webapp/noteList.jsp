<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>LANG</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand">EH Developer</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">Note List</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/noteOpenPage" class="btn btn-success">New Note</a>
				<a href="<%=request.getContextPath()%>/menu" class="btn btn-danger">Menu</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="display:none">ID</th>
						<th>Language</th>
						<th>Note</th>
						<th></th>						
					</tr>
				</thead>
				<tbody>
					<!--   for Hissesi  -->
					<c:forEach var="notes" items="${listNotes}">
							<tr>
								<td style="display:none"><c:out value="${notes.id}" /></td>
								<td><c:out value="${notes.lang}" /></td>
								<td><c:out value="${notes.note}" /></td>
								
								<td><a href="noteOpenUpdatePage?id=<c:out value='${notes.id}' />" class="btn btn-warning">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="noteDelete?id=<c:out value='${notes.id}' />" class="btn btn-danger">Delete</a>
								</td>
							</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
