<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>We are Alpha</title>
</head>
<body>
<h1 align = "center"> About us </h1>
<table border = "1" cellpadding = "10">
	<tr>
	<th>name</th>
	<th>netid</th>
	</tr>
	<c:forEach items = "${aboutus}" var = "us">
		<tr>
			<td>${us.name}</td>
			<td>${us.netid}</td>	
		</tr>
	</c:forEach>
	
</table>

<button onclick="backLoginFunc()">backtoLogin</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>




</body>
</html>