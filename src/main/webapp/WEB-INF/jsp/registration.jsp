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

button {
font-size: 15px;
box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);

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
 
<h1 align= center >Registration</h1>
<button onclick="chekUserFunction()">checkUser</button> <br>
    <div id="ajaxGetUserServletResponse" ></div><br>

<form action="newuser"  method ="post" Submit="return EmailValidation()" >
<fieldset>
	
	<p><label>userId</label> <input type = "text" name ="userId" id ="userId">  </p>
	
	<p><label for="pass">Password</label>  
	<input type = "text" name ="password" id="pass" pattern ="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,15}"
	title = "Password must contain at least one number and one uppercase and lowercase letter, and between 5 and 15 characters" >
	</p>
	
	
	<p><label> First name </label>
	<input type = "text" name ="firstName" id="fnln" pattern = "([a-z]).{5,50}"
	title = "first name should be between 5-50 characters" > </p>
	
	<p><label> Last name</label> 
	<input type = "text" name ="lastName" id="fnln" pattern = "([a-z]).{1,50}"
	title = "last name should be between 1-50 characters"  > </p>
	
	<p><label for="age" >Age</label> 
	<input type = "text" name ="age" id="age" pattern = "(?=.*[0-9]).{2,3}" 
	title = "Age should be between 10-99" > </p>
	
	<p><label>Gender</label> <br>
	<label></label><input type="radio" name="gender" value="male"> Male <br>
  	<label></label><input type="radio" name="gender" value="female"> Female <br>
  	<label></label><input type="radio" name="gender" value="other"> Other <br>
  	</p> 
  	
  	<p>
  	<label>Email: </label> 
  	<input type = "text" name ="email" title = "Enter email"> </p>
	
	 <p>
	 <label for="phone">Phone</label>
	<input type = "text" name ="phone" id="phone" pattern = "(?=.*[0-9]).{5,10}"
	title = "Phone should be between 5 and 10 integer numbers" > </p>
	
	
	<p>
	<label for="weight"> Weight</label>
	 <input type = "text" name ="Weight" id ="weight" pattern = "(?=.*[0-9]).{2,3}"
	 title = "Weight should be between at most 3 integer numbers"> </p>
	
	<p> 
	<label>Fat Percentage</label> <input type = "text" name ="fat" 
	title = "Enter Fat percentage"> 
	</p>
	
	<p>
	<label for="height" >Height</label>
	<input type = "text" name ="height" id="height" pattern = "(?=.*[0-9]).{1,4}"
	title = "Height should be between at most 4 integer numbers"> </P> 
	
	<p>
	<label> Bmi</label> <input type = "text" name ="bmi"
	title = "Enter BMI"> </p>
	
	<p><label>Goal</label> <br>
	<label></label><input type="radio" name="goal" value=1>weight loss<br>
  	<label></label><input type="radio" name="goal" value=2>muscle gain<br>
  	<label></label><input type="radio" name="goal" value=3>stay fit<br> </p>
	
	<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>

</fieldset>
</form>

<br>	<button onclick="backLoginFunc()">backtoLogin</button>

	<script>
		function backLoginFunc() {
			location.replace("http://localhost:8080/login")
		}
	</script>

<script>
var passInput = document.getElementById("pass");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");


myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}


myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}


myInput.passwordValidation = function() {
  
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) { 
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}

 
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) { 
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

 
  var number = /[0-9]/g;
  if(myInput.value.match(number)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }


  if(myInput.value.length >= 5) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

<script>
var FnLnInput = document.getElementById("fnln");
var letter = document.getElementById("letter");
var length = document.getElementById("length");

FnLnInput.FirstLastNameValidation = function() {
	<!--var lowerCaseLetters = /[a-z]/g;
	if(FnLnInput.value.match(lowerCaseLetters)) 
	{
	letter.classList.remove("invalid");
	letter.classList.add("valid");
	} 
	else {
	letter.classList.remove("valid");
	letter.classList.add("invalid");
	}
	-->
	if(FnLnInput.value.length >= 50){
	 length.classList.remove("valid");
    length.classList.add("invalid");
  } else {
    length.classList.remove("invalid");
    length.classList.add("valid");
  }
  }

</script>

<script>

var ageInput = document.getElementById("age");
var number = document.getElementById("number");
var length = document.getElementById("length");

ageInput.AgeValidation = function() {
 
 var number = /[0-9]/g;
  if(myInput.value.match(number)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  if(FnLnInput.value.length >= 2){
	 length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }

</script>

<script>

function EmailValidation(){
var emailInput = document.getElementById("email");
var atpostion = x.indexOf("@");
var dotpostion = x.lastIndexOf(".");

if(atpostion < 1 || dotpostion < atpostion + 2 || dotpostion + 2 >= x.length){
	alert("Enter a valid e-mail address \n +atpostion:"+atpostion + "\ dotpostion:" +dotpostion);
	return false;
	}
}
</script>

<script>

var phoneInput = document.getElementById("phone");
var number = document.getElementById("number");
var length = document.getElementById("length");

phoneInput.phoneValidation = function() {
 
 var number = /[0-9]/g;
  if(myInput.value.match(number)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  if(FnLnInput.value.length >= 10){
	 length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }

</script>

<script>

var weightInput = document.getElementById("weight");
var number = document.getElementById("number");
var length = document.getElementById("length");

weightInput.weightValidation = function() {
 
 var number = /[0-9]/g;
  if(myInput.value.match(number)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  if(FnLnInput.value.length >= 3){
	 length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }

</script>

<script>
var heightInput = document.getElementById("height");
var number = document.getElementById("number");
var length = document.getElementById("length");

heightInput.heightValidation = function() {
 
 var number = /[0-9]/g;
  if(myInput.value.match(number)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  if(FnLnInput.value.length >= 4){
	 length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }

</script>


</body>

</html>