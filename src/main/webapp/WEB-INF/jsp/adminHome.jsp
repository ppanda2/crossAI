<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home page</title>
</head>
<body>

	<h1 allign=centre>Admin Home</h1>

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
		<label>enter userid here: </label> <input type="text" name=uid>
		<input type="submit" value = "Search"><br>

	</form>
	<br>

	
	<br> Edit user Details:
	<form action="edituserdetails">
		<label>enter UserId to be edited: </label> <input type="text" name=userd>
		<input type="submit" value = "Find"><br>

	</form>
	

<br>

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


	
				
		<button>
			ANALYZ SOCIAL MEDIA DATA
			<button />
		<button>
			All stats
			<button />
			
	
	<form action="analyzefeedback">
		<input type="submit" value = "ANALYZE FEEDBACK"><br>
	</form>
	<br>
				
				
</body>
</html>