<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>


<h3>Feedback saved successfully.</h3>
</form>

 <button onclick="backtoadminscreen()">backtoAdminHome</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>
</body>
</html>