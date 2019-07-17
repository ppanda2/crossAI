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

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">

function chekUserFunction() {
    var userId = jQuery("#userId").val();
    
     jQuery.ajax({
        url : "GetUserAvailibility", 
        method: "GET", 
        type : "String", 
        data : "userId="+userId,// query parameters 1st 
        success : function(response){
        	$('#ajaxGetUserServletResponse').text(response);
        }
    });
}

</script>

</head>
<body>
 
<h1>Registration</h1>
<button onclick="chekUserFunction()">checkUser</button> <br>
    <div id="ajaxGetUserServletResponse" ></div><br>

<form action="newuser"  method ="post">
<fieldset>
	
	<p><label>userId :</label> <input type = "text" name ="userId" id ="userId">  <br>
	
	<label>Password:</label> <input type = "text" name ="password"> <br>
	<label>First name :</label> <input type = "text" name ="firstName"> <br>
	<label>Last name  :</label> <input type = "text" name ="lastName"> <br>
	<label>Age :</label> <input type = "text" name ="age"> <br>
	<label>Gender :</label> 	<br>
  <input type="radio" name="gender" value="male"> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other<br> 
  
	<label>Email :</label> <input type = "text" name ="email"> <br>
	<label>Phone :</label> <input type = "text" name ="phone"> <br>
	<label>Weight :</label> <input type = "text" name ="weight"> <br>
	<label>Fat Percentage :</label> <input type = "text" name ="fat"> <br>
	<label>Height :</label> <input type = "text" name ="height"> <br>
	<label>Bmi :</label> <input type = "text" name ="bmi"> <br>
	<label>Goal :</label> <br>
	<input type="radio" name="goal" value=1>weight loss<br>
  	<input type="radio" name="goal" value=2>muscle gain<br>
  	<input type="radio" name="goal" value=3>stay fit<br> 
	
	<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>

</fieldset>
</form>

<br>	<button onclick="backLoginFunc()">backtoLogin</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>

</body>

</html>