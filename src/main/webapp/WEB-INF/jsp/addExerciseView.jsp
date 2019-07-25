<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Exercise</title>

<script>
function check()
{
 if( document.myForm.exercise.value == "" )
 {
   alert("Please fill out userid field");
   return false;
 }
 else if ( document.myForm.exercisedesc.value == "" )
 {
	 alert("Please fill out password field");
	   return false;
 }
else
 {
   return true;
 }
}
</script>


<style>
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: left;
}

input[type=reset] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

label {
    display: inline-block;
    width:100px;
    text-align: right;
}
</style>

</head>
<body>

	<h2 align= center>Add Exercise</h2>
	<form action="addexercise" name="myForm" onSubmit="return check()">
		<fieldset>
			<p>
				<label>Exercise Name</label> <input type="text" name="exercise">
			</p>
			<p>
				<label>Exercise Description</label> <input type="text"
					name="exercisedesc">
			</p>
		<input type="submit" value="Submit"> <input type="reset" value="Reset" />
		</fieldset>
	</form>

 <button onclick="backtoadminscreen()">backtoAdminHome</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>

</body>
</body>
</html>