<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Login Page</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form method="post" action="LoginServlet" >
			<h2>Login Page</h2>
			Please provide your credential to use this website
			<br><br>
			Client ID(Govt): <input name="userId" /><br>
			Password: <input name="password" type="password"/>
			<br/>
			New User?  <a href="Register.jsp" style="margin-left:30px;">Register Here</a>
			<br/><br/>
			<input style="margin-left:100px;" type="submit" value="Login" />
		</form>
	</body>
</html>