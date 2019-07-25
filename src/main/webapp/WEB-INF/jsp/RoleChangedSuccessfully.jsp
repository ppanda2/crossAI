<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 align = "center"> Role changed successfully  </h1>


<button onclick="backtoadminscreen()">backtoadmin</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script> 
</body>
</html>