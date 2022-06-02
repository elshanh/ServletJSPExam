<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>LANG Dictionary</title>
		
	<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
	</head>

	<body>
	
	<h2>Dictionary Page</h2>
	
	<form action="dictionary" method="post">
		<table>
			<tr>
				<th>No</th>
				<th>Word-Eng</th>
				<th>Speak-Eng</th>
				<th>Word-Ger</th>
				<th>Speak-Ger</th>
				<th>Word-Rus</th>
				<th>Speak-Rus</th>
				<th>Translate Az</th>
				<th>Translate Tr</th>
			</tr>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>8</td>
				<td>9</td>
			</tr>
		</table>
		
		<br>
		
		<button type="submit">Insert</button>
		<button type="submit">Update</button>
		<button type="submit">Delete</button>
		<button type="submit">Select</button>
	</form>

	</body>
</html>