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
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand">EH Developer</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">English, German and Russian Dictionary</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/wordOpenPage" class="btn btn-success">New Word</a>
				<a href="<%=request.getContextPath()%>/menu" class="btn btn-danger">Menu</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="display:none">ID</th>
						<th>Word-Eng</th>
						<th>Speak-Eng</th>
						<th>Word-Ger</th>
						<th>Speak-Ger</th>
						<th>Word-Rus</th>
						<th>Speak-Rus</th>
						<th>Translate Az</th>
						<th>Translate Tr</th>
						<th></th>						
					</tr>
				</thead>
				<tbody>
					<!--   for Hissesi  -->
					<c:forEach var="words" items="${listWords}">
							<tr>
								<td style="display:none"><c:out value="${words.id}" /></td>
								<td><c:out value="${words.wordEng}" /></td>
								<td><c:out value="${words.speaksEng}" /></td>
								<td><c:out value="${words.wordGer}" /></td>
								<td><c:out value="${words.speaksGer}" /></td>
								<td><c:out value="${words.wordRus}" /></td>
								<td><c:out value="${words.speaksRus}" /></td>
								<td><c:out value="${words.translateAz}" /></td>
								<td><c:out value="${words.translateTr}" /></td>
								
								
								<td><a href="wordOpenUpdatePage?id=<c:out value='${words.id}' />" class="btn btn-warning">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="wordDelete?id=<c:out value='${words.id}' />" class="btn btn-danger">Delete</a>
								</td>
							</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
