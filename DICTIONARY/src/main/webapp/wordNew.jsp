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
				<a href="" class="navbar-brand"> EH Developer </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="wordInsert" method="post">
					<caption>
						<h2>
	            			Add New Word
						</h2>
					</caption>
					
					<!-- BASLADI -->
					<fieldset class="form-group">
						<label>Soz (Eng)</label> <input type="text" value="" class="form-control" name="wordEng" required="required">
						<label>Oxunus (Eng)</label> <input type="text" value="" class="form-control" name="speakEng">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Soz (Ger)</label> <input type="text" value="" class="form-control" name="wordGer" required="required">
						<label>Oxunus (Ger)</label> <input type="text" value="" class="form-control" name="speakGer">
					</fieldset>				
					
					<fieldset class="form-group">
						<label>Soz (Rus)</label> <input type="text" value="" class="form-control" name="wordRus" required="required">
						<label>Oxunus (Rus)</label> <input type="text" value="" class="form-control" name="speakRus">
					</fieldset>		
					
					<fieldset class="form-group">
						<label>Tercume (Az)</label> <input type="text" value="" class="form-control" name="translateAz" required="required">
						<label>Tercume (Tr)</label> <input type="text" value="" class="form-control" name="translateTr">
					</fieldset>		
					<!-- BITDI -->
	
					<button type="submit" class="btn btn-success">Enter</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
