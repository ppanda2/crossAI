<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align = "center"> User Details </h1>

	<form>
		<fieldset>
			<p>
				<label>userId:</label> <input type="text" name="userid"
					value="${userid}" />
			</p>
			<p>
				<label>firstName:</label> <input type="text" name="firstName"
					value="${firstName}" />
			</p>
			<p>
				<label>lastName:</label> <input type="text" name="lastName"
					value="${lastName}" />
			</p>
			<p>
				<label>email</label> <input type="text" name="email"
					value="${email}" />
			</p>
			<p>
				<label>phone</label> <input type="text" name="phone"
					value="${phone}" />
			</p>
			<p>
				<label>gender</label> <input type="text" name="gender"
					value="${gender}" />
			</p>
			<p>
				<label>age</label> <input type="text" name="age" 
				value="${age}" />
			</p>
			<p>
				<label>height</label> <input type="text" name="height"
					value="${height}" />
			</p>
		</fieldset>
	</form>

<button onclick="backtoadminscreen()">backtoadmin</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>

</body>
</html>