<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LANG Login</title>
	</head>

	<body>
	
	<h2>Login Page</h2>
	
	<form action="login" method="post">
		<label for="username">Username:</label>
		<input type="text" placeholder="Enter username" name="pUsr">
		<label for="password">Password:</label>
		<input type="password" placeholder="Enter Password" name="pPsw">
		
		<button type="submit">Login</button>
	</form>

	</body>
</html>