<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>first page</title>
</head>
<body>
	<h1>CrossAi</h1>
	<form>
		<fieldset>
			<p>
				<label>User Name</label> <input type="text" id="uid" />
			</p>
			<p>
				<label>Password</label> <input type="password" id="myPwd" />
			</p>
			<input type="submit" />
		</fieldset>
	</form>

	<h2>Redirect to AboutUS</h2>
	
	<button onclick="myFunction()">About Us</button>

	<script>
		function myFunction() {
			location.replace("http://localhost:8080/Aboutus")
			
		}
	</script>

	<h2>Redirect to a Registration</h2>
	<button onclick="callRegistartion()">Registration</button>

	<script>
		function callRegistartion() {
			location.replace("http://localhost:8080/registration")
			
		}
	</script>

</body>
</html>