<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LANG Menu</title>
<style>
.button {
background-color: white;
border: 2px solid #4CAF50; /* Green */
color: black;
padding: 15px 32px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 16px;
}

</style>
	</head>

	<body>
	
	<h2>Menu</h2>
	
	<div class="centered">
	<a href="<%=request.getContextPath()%>/user"><button class="button" type="submit">User</button></a>
	<a href="<%=request.getContextPath()%>/dictionary"><button class="button" type="submit">Dictionary</button></a>
	<a href="<%=request.getContextPath()%>/sentence" class="nav-link"><button class="button" type="submit">Sentence</button></a>
	<a href="<%=request.getContextPath()%>/note" class="nav-link"><button class="button" type="submit">Note</button></a>
	</div>
	
	</body>
</html>