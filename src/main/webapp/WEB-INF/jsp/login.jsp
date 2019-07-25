<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>first page which is login</title>

<script>
function check()
{
 if( document.myForm.userId.value == "" )
 {
   alert("Please fill out userid field");
   return false;
 }
 else if ( document.myForm.password.value == "" )
 {
	 alert("Please fill out password field");
	   return false;
 }
 else if (document.myForm.userId.value.length < 3 || document.myForm.userId.value.length > 10)
{
        	alert('userid can be between 3 and 10 characters'); 
        	return false;
}
else
 {
   return true;
 }
}
</script>

  <script src="http://cdn.jquerytools.org/1.2.6/full/jquery.tools.min.js"></script>
  
  <link rel="stylesheet" type="text/css"
        href="/media/css/standalone.css"/>

  <link rel="stylesheet" type="text/css"
      href="/media/css/tooltip-generic.css"/>
<style>

label {
    display: inline-block;
    width:100px;
    text-align: right;
}

  #myForm {
  border:1px outset #ccc;
  background:#fff url(/media/img/gradient/h600.png) repeat-x;
  padding:20px;
  margin:20px auto;
  width:350px;
  font-size:12px;
  -moz-border-radius:4px;
  }

  #myform h3 {
  text-align:center;
  margin:0 0 10px 0;
  }

  /* http://www.quirksmode.org/css/forms.html */
  #inputs label, #inputs input, #inputs textarea, #inputs select {
  display: block;
  width: 150px;
  float: left;
  margin-bottom: 20px;
  }

  #inputs label {
  text-align: right;
  width: 75px;
  padding-right: 20px;
  }

  #inputs br {
  clear: left;
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

button {
font-size: 15px;
box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);

}
</style>



</head>
<body>
	<h1 align = "center">CrossAi</h1>
	<form action = "checklogin" method="POST"  name="myForm" onSubmit="return check()">
		<fieldset>
			<p>
				<label>User Name</label> <input type="text" name="userId" title="Must be between 3 and 10 characters">
			</p>
			<p>
				<label>Password</label> <input type="password" name="password" title="Make it hard to guess.">
			</p>
			<input type="submit" value="Submit"> <input type="reset" value="Reset" />
		</fieldset>
	</form>
	
	${InvalidUserOrPassword}
	
	<br>
	<br>

	

	
	<button onclick="callRegistartion()">Registration</button>
	<script>
		function callRegistartion() {
			location.replace("http://localhost:8080/registration")
			
		}
	</script>
	
	<button onclick="myFunction()">About Us</button>
	<script>
		function myFunction() {
			location.replace("http://localhost:8080/Aboutus")
			
		}
	</script>
	
	<button onclick="callHelp()">Help!</button>
	<script>
		function callHelp() {
			location.replace("http://localhost:8080/help")
			
		}
	</script>
	
	
	<script>
  $(function() {

        // select all desired input fields and attach tooltips to them
      $("#myForm :input").tooltip({

      // place tooltip on the right edge
      position: "center right",

      // a little tweaking of the position
      offset: [-2, 10],

      // use the built-in fadeIn/fadeOut effect
      effect: "fade",

      // custom opacity setting
      opacity: 0.7

      });
    });
</script>

</body>
</html>