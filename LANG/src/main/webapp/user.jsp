<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LANG User</title>
	</head>

	<body>
	
	<h2>User Page</h2>
	
	<form action="user" method="post">
		<label for="name">Name:</label>
		<input type="text" placeholder="Enter name" name="pName">
		<br>
		<label for="surname">Surname:</label>
		<input type="text" placeholder="Enter surname" name="pSname">
		<br>
		<label for="username">Username:</label>
		<input type="text" placeholder="Enter username" name="pUsr">
		<br>
		<label for="password">Password:</label>
		<input type="password" placeholder="Enter password" name="pPsw">
		<br>
		<button type="submit">Insert</button>
	</form>

	</body>
</html>