<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form action="wordUpdate" method="post">

					<caption>
						<h2>
	            			Edit User Detail
						</h2>
					</caption>
	
					<input type="hidden" name="id" value="<c:out value='${word.id}' />" />
					
					<!-- BASLADI -->
					<fieldset class="form-group">
						<label>Word (Eng)</label> <input type="text" value="<c:out value='${word.wordEng}' />" class="form-control" name="wordEng" required="required">
						<label>Speak (Eng)</label> <input type="text" value="<c:out value='${word.speaksEng}' />" class="form-control" name="speakEng">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Word (Ger)</label> <input type="text" value="<c:out value='${word.wordGer}' />" class="form-control" name="wordGer" required="required">
						<label>Speak (Ger)</label> <input type="text" value="<c:out value='${word.speaksGer}' />" class="form-control" name="speakGer">
					</fieldset>				
					
					<fieldset class="form-group">
						<label>Word (Rus)</label> <input type="text" value="<c:out value='${word.wordRus}' />" class="form-control" name="wordRus" required="required">
						<label>Speak (Rus)</label> <input type="text" value="<c:out value='${word.speaksRus}' />" class="form-control" name="speakRus">
					</fieldset>		
					
					<fieldset class="form-group">
						<label>Translate (Az)</label> <input type="text" value="<c:out value='${word.translateAz}' />" class="form-control" name="translateAz" required="required">
						<label>Translate (Tr)</label> <input type="text" value="<c:out value='${word.translateTr}' />" class="form-control" name="translateTr">
					</fieldset>		
					<!-- BITDI -->
	
					<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
