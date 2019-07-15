<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The form should list all user ids to be selected.</title>
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
	<form action="stopCheckIn" method="POST">

		Choose Users : <br>
		<c:forEach var="Users" items="${allusers}">
			<input type="checkbox" value="${Users}" name="userIds">
			<c:out value="${Users}" />
			<br>
		</c:forEach>

	<label>Enter date in Month, Date, Year</label>  <input type="text" name=date><br>
	<label>Enter time in 24 hours format</label>  <input type="text" name=time><br>
	<label>Enter name of class</label>  <input type="text" name=nameofclass><br>
	
	
	
	
		<input type="submit" value="Submit">
	</form>

</body>
</html>