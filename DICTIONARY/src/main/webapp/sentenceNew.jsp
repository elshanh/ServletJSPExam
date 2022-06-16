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
				<a href="" class="navbar-brand"> Developer EH  </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="sentenceInsert" method="post">
				<caption>
					<h2>
            			Add New Sentence
					</h2>
				</caption>
				
				<!-- BASLADI -->
				<fieldset class="form-group">
					<label>Sentence:</label> <input type="text" value="" class="form-control" name="pSentence" required="required">
					<label>Lang:</label> <input type="text" value="" class="form-control" name="pLang">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Translate AZ:</label> <input type="text" value="" class="form-control" name="pTranslateAz" required="required">
					<label>Translate TR</label> <input type="text" value="" class="form-control" name="pTranslateTr">
				</fieldset>
				<!-- BITDI -->

				<button type="submit" class="btn btn-success">Enter</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
