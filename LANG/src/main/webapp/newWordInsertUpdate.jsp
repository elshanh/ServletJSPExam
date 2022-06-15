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
				<c:if test="${dic != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${dic == null}">
					<form action="insertNewWord" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${dic != null}">
            			Düzəliş
            		</c:if>
						<c:if test="${dic == null}">
            			Yeni Soz
            		</c:if>
					</h2>
				</caption>

				<c:if test="${dic != null}">
					<input type="hidden" name="id" value="<c:out value='${dic.id}' />" />
				</c:if>
				
				<!-- BASLADI -->
				<fieldset class="form-group">
					<label>Soz (Eng)</label> <input type="text" value="<c:out value='${dic.wordEng}' />" class="form-control" name="wordEng" required="required">
					<label>Oxunus (Eng)</label> <input type="text" value="<c:out value='${dic.speaksEng}' />" class="form-control" name="speakEng">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Soz (Ger)</label> <input type="text" value="<c:out value='${dic.wordGer}' />" class="form-control" name="wordGer" required="required">
					<label>Oxunus (Ger)</label> <input type="text" value="<c:out value='${dic.speaksGer}' />" class="form-control" name="speakGer">
				</fieldset>				
				
				<fieldset class="form-group">
					<label>Soz (Rus)</label> <input type="text" value="<c:out value='${dic.wordRus}' />" class="form-control" name="wordRus" required="required">
					<label>Oxunus (Rus)</label> <input type="text" value="<c:out value='${dic.speaksRus}' />" class="form-control" name="speakRus">
				</fieldset>		
				
				<fieldset class="form-group">
					<label>Tercume (Az)</label> <input type="text" value="<c:out value='${dic.translateAz}' />" class="form-control" name="translateAz" required="required">
					<label>Tercume (Tr)</label> <input type="text" value="<c:out value='${dic.translateTr}' />" class="form-control" name="translateTr">
				</fieldset>		
				<!-- BITDI -->

				<button type="submit" class="btn btn-success">QƏBUL</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
