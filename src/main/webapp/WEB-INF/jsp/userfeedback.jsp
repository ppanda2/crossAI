<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Provide FeedBack</h2>
<br>

<form action="addfeedback" method ="post">
	
	<label>UserId</label> <input type ="text" name ="userid"><br>
	<label>feedback</label> <input type ="text" name ="feedbac"><br>
	<label>DateTime</label> <input type ="text" name ="datetime"><br>
	<label>Score</label> <input type ="text" name ="score"><br>
	<input type ="submit" value="Submit">

</form>

</body>
</html>