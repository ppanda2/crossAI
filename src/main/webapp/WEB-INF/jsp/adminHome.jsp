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


<button/> EDIT DETAILS <button/>
<button onclick="addExcercise()">Add Exercises</button>

<button action = "storeJsoninDatbase">Completed Class</button>
<%-- <button action = "generateJson">CheckIn Complete</button> --%>
<%-- This is JSP comment --%>

<%--<input type="button"  onclick="location.href= generateJson" value="CheckIn Complete" >--%>

<form action="startCheckIn">
	<input type ="submit" value="startCheckIn" >
</form>



<br>
<br>

Search user Details<br>
	<form action="getUserDetails">
		<label>enter userid here</label>  <input type="text" name=uid><br> <input type="submit"><br>

	</form>
<br>
<br>


<button> EDIT/DELETE <button/>
<button> VIEW HISTORY <button/>
<button> ANALYZ SOCIAL MEDIA DATA <button/>
<button> CHECK IN <button/>
<button> GATHER FEEDBACK <button/>
<button> ANALYZE FEEDBACK <button/>

	<button onclick="backLoginFunc()">backtoLogin</button>

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


</body>
</html>