<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The form should list all user ids to be selected.</title>

<script>
function check()
{
 if ( document.myForm.date.value == "" )
 {
	 alert("Please fill a date ");
	   return false;
 }
 else if ( document.myForm.time.value == "" )
{
        	alert('please fill out a time'); 
        	return false;
}
 else if ( document.myForm.nameofclass.value == "" )
 {
         	alert('please fill out namof of the class'); 
         	return false;
 }
else
 {
   return true;
 }
}
</script>

<style>
label {
    display: inline-block;
    width:230px;
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

input[type=reset] {
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

	<!-- // This is drop down

	<select name="database1">
		<c:forEach items="${allusers}" var="databaseValue">
			<option value="${databaseValue}">${databaseValue}</option>
		</c:forEach>
	</select>
 -->

	<!-- This is check boxes -->
	<form action="stopCheckIn" method="POST" name="myForm" onSubmit="return check()">
<fieldset>
		<h3>Choose Users :</h3>
		<c:forEach var="Users" items="${allusers}">
			<input type="checkbox" value="${Users}" name="userIds">
			<c:out value="${Users}" />
			<br>
		</c:forEach>

<p>	<label>Enter date in Month, Date, Year</label>  <input type="text" name=date></p>
<p>	<label>Enter time in 24 hours format</label>  <input type="text" name=time></p>
<p>	<label>Enter name of class</label>  <input type="text" name=nameofclass></p>
	
		<input type="submit" value="Submit"><input type="reset" value="Reset" />
		</fieldset>
	</form>
 <button onclick="backtoadminscreen()" >backtoAdminHome</button> 
	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>
</body>
</html>