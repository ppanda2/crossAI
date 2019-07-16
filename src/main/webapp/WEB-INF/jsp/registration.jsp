<%@ page language="java" contentType="text/html;  charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset=ISO-8859-1>
<title>Welcome to Registration</title>

<style>
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

</style>


</head>
<body>

<h1>Registration</h1>
<form action="newuser"  method ="post">
<fieldset>
	
	<p><label>userId :</label> <input type = "text" name ="userId">  <button onclick="chekUserFunction()">checkUser</button> <br>
	<label>Password:</label> <input type = "text" name ="password"> <br>
	
	<label>First name :</label> <input type = "text" name ="firstName"> <br>
	<label>Last name  :</label> <input type = "text" name ="lastName"> <br>
	<label>Age :</label> <input type = "text" name ="age"> <br>
	<label>Gender :</label> <input type = "radio" name ="gender"> <br>
	<label>Email :</label> <input type = "text" name ="email"> <br>
	<label>Phone :</label> <input type = "text" name ="phone"> <br>
	<label>Weight :</label> <input type = "text" name ="weight"> <br>
	<label>Fat Percentage :</label> <input type = "text" name ="fat"> <br>
	<label>Height :</label> <input type = "text" name ="height"> <br>
	<label>Bmi :</label> <input type = "text" name ="bmi"> <br>
	<label>Goal :</label> <input type = "checkbox" name ="goal"> <br>
	
	<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>

</fieldset>

</form>

	<button onclick="backLoginFunc()">backtoLogin</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>

</body>


<script>
function chekUserFunction() {
	
	
	//location.replace
}
</script>


</html>