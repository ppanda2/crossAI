<!DOCTYPE html>
<html>
<body>
	<h1>welcome CrossAi</h1>


	<h3>welcome ${name}, your age is ${age}</h3>

	<form>
		<fieldset>
			<p>
				<label>User Name</label> <input type="text" id="uid" />
			</p>
			<p>
				<label>Password</label> <input type="password" id="myPwd" />
			</p>

			<label>Name</label>
			<textarea>${name}</textarea>

		</fieldset>
	</form>
	
	
	<h2>Redirect to a AboutUS</h2>
<p>The replace() method replaces the current page with a new one:</p>

<button onclick="myFunction()">About Us</button>

<script>
function myFunction() {
	location.replace("http://localhost:8080/Aboutus")
	//location.replace
}
</script>
	
</body>
</html>




