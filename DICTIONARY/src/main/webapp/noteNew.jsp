<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form action="noteInsert" method="post">
				<caption>
					<h2>
            			Add New Note
					</h2>
				</caption>
				
				<!-- BASLADI -->
				<fieldset class="form-group">
					<label>Language:</label> <input type="text" value="" class="form-control" name="pLang" required="required">
					<label>Note:</label> <input type="text" value="" class="form-control" name="pNote">
				</fieldset>
				<!-- BITDI -->

				<button type="submit" class="btn btn-success">Enter</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
