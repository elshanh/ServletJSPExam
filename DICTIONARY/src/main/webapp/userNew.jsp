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
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand"> LANG </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="userInsert" method="post">
				<caption>
					<h2>
            			Add New User
					</h2>
				</caption>
				
				<!-- BASLADI -->
				<fieldset class="form-group">
					<label>Name:</label> <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="pName" required="required">
					<label>Surname:</label> <input type="text" value="<c:out value='${user.surname}' />" class="form-control" name="pSurname">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Username:</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="pUsername" required="required">
					<label>Password</label> <input type="password" value="<c:out value='${user.password}' />" class="form-control" name="pPassword">
				</fieldset>
				<!-- BITDI -->

				<button type="submit" class="btn btn-success">Enter</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
