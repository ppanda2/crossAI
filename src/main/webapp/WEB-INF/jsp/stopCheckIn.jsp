<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src=https://cdn.jsdelivr.net/npm/pretty-print-json@0.1/dist/pretty-print-json.min.js></script>
<head>
<meta charset="ISO-8859-1">
<title>stopChekinJSp page</title>
</head>
<body>
<h1 align = "center"> Recommended exercises </h1>
<form>
<pre>
<code>

${jsonexer}

</code>
</pre>
</form>
 <button onclick="backtoadminscreen()">backtoAdminHome</button>

	<script>
		function backtoadminscreen() {
			location.replace("http://localhost:8080/adminhome")
		}
	</script>

</body>
</html>