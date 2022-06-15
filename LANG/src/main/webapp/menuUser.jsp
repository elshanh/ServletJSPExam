<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>LANG Menu</title>
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
			<h3 class="text-center">Menu</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/dictionaryList" class="btn btn-success">Dictionary</a>
				<a href="<%=request.getContextPath()%>/sentenceList" class="btn btn-success">Sentence</a>
				<a href="<%=request.getContextPath()%>/noteList" class="btn btn-success">Note</a>
			</div>
		</div>
	</div>
</body>
</html>
