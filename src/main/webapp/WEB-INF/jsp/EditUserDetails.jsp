<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Details</title>
</head>
<body>

	<h1 align="center">Edit User Details</h1>

	<form action="saveEditedUser"  method ="post" name="myForm">
		<fieldset>
			<p>
				<label>userId:</label> <input type="text" name="userid" id ="userId"
					value="${userid}"  />
			</p>
			<p>
				<label>Password:</label> <input type="text" name="password"
					value="${password}" />
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
				<label>Gender :${gender} </label> 	<br>
  <input type="radio" name="gender" value="male"> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other<br> 
  
			</p>
			<p>
				<label>age</label> <input type="text" name="age" value="${age}" />
			</p>
			<p>
				<label>height</label> <input type="text" name="height"
					value="${height}" />
			</p>
			<p>
				<label>weight</label> <input type="text" name="weight"
					value="${weight}" />
			</p>
			<p>
				<label>BMI</label> <input type="text" name="bmi"
					value="${bmi}" />
			</p>
			<p>
				<label>fit Score</label> <input type="text" name="fitScore"
					value="${fitScore}" />
			</p>
			
			<p>
				<label>Fat Percentage :</label> <input type="text" name="fat"
					value="${fat}" />
			</p>
			<p>
			<label>Goal :${goal}</label> <br>
	<input type="radio" name="goal" value=1>(1)weight loss<br>
  	<input type="radio" name="goal" value=2>(2)muscle gain<br>
  	<input type="radio" name="goal" value=3>(3)stay fit<br> 
	</p>
			<p>
			<label>User Status(Active/Delete)  : ${status}</label> <br>
	<input type="radio" name="status" value="Active">Active<br>
  	<input type="radio" name="status" value="InActive">InActive<br>
  	</p>

	
		<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	
			
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