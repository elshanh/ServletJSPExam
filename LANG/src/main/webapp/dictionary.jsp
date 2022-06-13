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
			<h3 class="text-center">İngiliscə, Almanca və Rusca Lüğət</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/newWord" class="btn btn-success">Yeni söz</a>
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
						<th>ƏMƏLİYYAT</th>						
					</tr>
				</thead>
				<tbody>
					<!--   for Hissesi  -->
					<c:forEach var="dic" items="${listDictionary}">
							<tr>
								<td style="display:none"><c:out value="${dic.id}" /></td>
								<td><c:out value="${dic.wordEng}" /></td>
								<td><c:out value="${dic.speaksEng}" /></td>
								<td><c:out value="${dic.wordGer}" /></td>
								<td><c:out value="${dic.speaksGer}" /></td>
								<td><c:out value="${dic.wordRus}" /></td>
								<td><c:out value="${dic.speaksRus}" /></td>
								<td><c:out value="${dic.translateAz}" /></td>
								<td><c:out value="${dic.translateTr}" /></td>
								
								
								<td><a href="edit?id=<c:out value='${dic.id}' />" class="btn btn-warning">DÜZƏLİŞ</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${dic.id}' />" class="btn btn-danger">SİL</a>
								</td>
							</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
