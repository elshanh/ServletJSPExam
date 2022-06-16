<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<a href="" class="navbar-brand"> EH Developer </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="noteUpdate" method="post">
				<caption>
					<h2>
            			Edit Note Detail
					</h2>
				</caption>
				

				<input type="hidden" name="id" value="<c:out value='${note.id}' />" />
				
				<!-- BASLADI -->
				<fieldset class="form-group">
					<label>Language:</label> <input type="text" value="<c:out value='${note.lang}' />" class="form-control" name="pLang" required="required">
					<label>Note:</label> <input type="text" value="<c:out value='${note.note}' />" class="form-control" name="pNote">
				</fieldset>
				<!-- BITDI -->

				<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
