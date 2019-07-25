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


#button {
     line-height: 12px;
     width: 18px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 2px;
     position:absolute;
     top:0;
     right:0;
 }

</style>



<script>
function check()
{
if (document.myForm.userid.value.length < 3 || document.myForm.userid.value.length > 10)
{
        	alert('userid can be between 3 and 10 characters'); 
        	return false;
}
else if (document.myForm.feedbac.value.length >145)
 {
	alert('feedback cannot be more than 145 characters'); 
	return false;
   
 }
else if(document.myForm.score.value < 0 || document.myForm.score.value > 10)
 {
	alert('score must be between 0 and 10'); 
	return false;
   
 } 
else
{
	   return true;
	 }

}
</script>

</head>

<body>

	<h2 align= center>Provide FeedBack</h2>
	
	

	<br>
 <div class="container">
	<form action="addfeedback" name="myForm" method="POST" onSubmit="return check()">
	
		<fieldset>
			<p>
				<label>UserId	</label> <input type="text"  name="userid" class="input" title="Must be between 3 and 10 characters"><br>
			</P>
			<p>
				<label>Feedback</label> <input type="text" name="feedbac" class="input" title="Must be between 0 and 145 characters"><br>
			</P>
			<p>
				<label>DateTime</label> <input type="text" name="datetime" class="input" title="select a date"><br>
			</P>
			<p>
				<label>Score	</label> <input type="text" name="score" class="input" title="Must be a value between 0 and 10"><br>
			</P>
			<input type="submit" value="Submit"> <input type="reset" value="Reset" />
		</fieldset>
	</form>
</div>

<p> <button onclick="backtoadminscreen()" >backtoAdminHome</button> </p>
	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>

	
</body>
</html>