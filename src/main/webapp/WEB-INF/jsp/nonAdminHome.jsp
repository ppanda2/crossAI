<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">This is Non Admin Home </h1>

<h2>Welcome  ${userId}</h2>


<br>
<br>

	<button onclick="backLoginFunc()">Back to Login Page</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>
	

<form>
<button/> CHANGE PASSWORD <button/>

<button/> EDIT DETAILS <button/>

<button> VIEW HISTORY <button/>

<button> FEEDBACK <button/>

</form>

</body>
</html>