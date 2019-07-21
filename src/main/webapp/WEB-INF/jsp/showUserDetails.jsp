<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
label {
    display: inline-block;
    width:150px;
    text-align: right;
}

</style>

</head>
<body>

	<h1 align="center">User Details</h1>

	<form>
		<fieldset>
			<p>
				<label>userId:</label> <input type="text" name="userid" readonly
					value="${userid}" />
			</p>
			<p>
				<label>firstName:</label> <input type="text" name="firstName" readonly
					value="${firstName}" />
			</p>
			<p>
				<label>lastName:</label> <input type="text" name="lastName" readonly
					value="${lastName}" />
			</p>
			<p>
				<label>email</label> <input type="text" name="email" readonly
					value="${email}" />
			</p>
			<p>
				<label>phone</label> <input type="text" name="phone" readonly
					value="${phone}" />
			</p>
			<p>
				<label>gender</label> <input type="text" name="gender" readonly
					value="${gender}" />
			</p>
			<p>
				<label>age</label> <input type="text" name="age" readonly value="${age}" />
			</p>
			<p>
				<label>height</label> <input type="text" name="height" readonly
					value="${height}" />
			</p>
		</fieldset>
	</form>


	<h1 align="center">History</h1>

	<table border="1" cellpadding="10">
		<tr>
			<th>date</th>
			<th>time</th>
			<th>exerciseName</th>
			<th>exercise</th>

		</tr>
		<c:forEach items="${history}" var="us">
			<tr>
				<td>${us.date}</td>
				<td>${us.time}</td>
				<td>${us.exerciseName}</td>
				<td>${us.exercise}</td>
			</tr>
		</c:forEach>

	</table>

	<button onclick="backtoadminscreen()">backtoadmin</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>

</body>
</html>