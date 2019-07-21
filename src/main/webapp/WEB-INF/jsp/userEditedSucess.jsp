<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User edited Successfully</title>

<style>
label {
    display: inline-block;
    width:150px;
    text-align: right;
}
</style>

</head>
<body>
	<h1>User edited Successfully</h1>


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
				<label>age</label> <input type="text" name="age"  readonly value="${age}" />
			</p>
			<p>
				<label>height</label> <input type="text" name="height" readonly
					value="${height}" />
			</p>
		</fieldset>
	</form>
	
	
		<button onclick="backLoginFunc()">backtoLogin</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>

</body>
</html>