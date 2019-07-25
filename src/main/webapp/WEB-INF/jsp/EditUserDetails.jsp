<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Details</title>

<style>
label {
    display: inline-block;
    width:150px;
    text-align: right;
}

.radio {
    display: inline-block;
    width:150px;
    text-align: right;
}


input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: left;
}
</style>


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
				<label>Gender</label> 	<br>
  <label></label><input type="radio" name="gender" value="male" ${gender=='male'?'checked':''}> Male<br>
  <label></label><input type="radio" name="gender" value="female" ${gender=='female'?'checked':''}> Female<br>
  <label></label><input type="radio" name="gender" value="other" ${gender=='other'?'checked':''}> Other<br> 
  
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
				<label>Fat Percentage</label> <input type="text" name="fat"
					value="${fat}" />
			</p>
			<p>
			<label>Goal</label> <br>
	<label></label><input type="radio" name="goal" value=1 ${goal=='1'?'checked':''}>weight loss<br>
  	<label></label><input type="radio" name="goal" value=2 ${goal=='2'?'checked':''}>muscle gain<br>
  	<label></label><input type="radio" name="goal" value=3 ${goal=='3'?'checked':''}>stay fit<br> 
	</p>
			<p>
			<label>User Status</label> <br>
	<label></label><input type="radio" name="status" value="Active" ${status=='Active'?'checked':''}>Active<br>
  	<label></label><input type="radio" name="status" value="InActive" ${status=='InActive'?'checked':''}>InActive<br>
  	</p>
		<p><input type="submit" value="Submit" /> </p>
	
		</fieldset>
	</form>
	
		<form action="saveRoleUser"  method ="post" name="roleForm">
		<fieldset>
		
			
				<input type="hidden"  name="userRoleid" id ="userRoleId"
					value="${userIdRoleRel}"   />
			
		<p>
				<label>Current Role:  </label> <br>
		<label></label><input type="radio" name="status" value="Admin" ${currRole=='Admin'?'checked':''}> Admin<br>
  		<label></label><input type="radio" name="status" value="NonAdmin" ${currRole=='NonAdmin'?'checked':''}>NonAdmin<br>
  		</p>
		
		<p><input type="submit" value="Submit" /> </p>
	
		
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