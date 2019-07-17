<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercise added successfully</title>
</head>
<body>
 Exercise added successfully with exercise id = ${uid} 
 <br>
 
 <button onclick="backtoadminscreen()">backtoLogin</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>
</body>
</html>