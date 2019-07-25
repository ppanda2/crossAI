<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home page</title>

<style>
label {
    display: inline-block;
    width:100px;
    text-align: right;
   
    
}

button {
font-size: 15px;
box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);

}

input {
font-size: 15px;
box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);

}




</style>

</head>
<body>

	<h1 align= center >Admin Home</h1> <h2>Welcome  ${userId}</h2>

	
	<button onclick="addExcercise()">Add Exercises</button>

	<!-- <button action = "storeJsoninDatbase">Completed Class</button>  -->
	<%-- <button action = "generateJson">CheckIn Complete</button> --%>
	<%-- This is JSP comment --%>

	<%--<input type="button"  onclick="location.href= generateJson" value="CheckIn Complete" >--%>

	<br>
	<br>
	
	
	<form action="startCheckIn">
		<input type="submit" value="Start CheckIn">
	</form>
	

	<br> Search user Details:
	<br>
	<form action="getUserDetails">
		<label>enter userid: </label> <input type="text" name=uid>
		<input type="submit" value = "Search"><br>

	</form>
	<br>

	
	<br> Edit user Details:
	<form action="edituserdetails">
		<label>enter UserId: </label> <input type="text" name=userd>
		<input type="submit" value = "Edit"><br>

	</form>
	

<br><br>

	<form action="getfeedback">
		<input type="submit" value = "Gather Feedback"><br>
	</form>
	<br>




	<button onclick="backLoginFunc()">Back to Login Page</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>

	<script>
		function addUsersFunc() {
			location.replace("http://localhost:8080/registration")
		}
	</script>

	<script>
		function addExcercise() {
			location.replace("http://localhost:8080/addExercise")
		}
	</script>


<br>
<br>


	<form action="AnalyzeTwitter">
		<input type="submit" value = "Analyze Twitter"><br>
	</form>
	<br>
	
	<form action="analyzefeedback">
		<input type="submit" value = "Analyze Feedback"><br>
	</form>
	<br>
				
				
</body>
</html>