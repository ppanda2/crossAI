<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add feedback</title>
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

	<h2>Provide FeedBack</h2>
	<br>

	<form action="addfeedback" name="myForm" method="post">
		<fieldset>
			<p>
				<label>UserId</label> <input type="text" name="userid"><br>
			</P>
			<p>
				<label>Feedback</label> <input type="text" name="feedbac"><br>
			</P>
			<p>
				<label>DateTime</label> <input type="text" name="datetime"><br>
			</P>
			<p>
				<label>Score</label> <input type="text" name="score"><br>
			</P>
			<input type="submit" value="Submit"> <input type="reset" value="Reset" />
		</fieldset>
	</form>

</body>
</html>