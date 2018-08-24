<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>Student Registration Form</h3>
	<form action="RegisterServlet" method="POST">
		<table align="center" cellpadding = "10">
		<tr>
			<td>Name</td>
			<td><input type="text" name="userName" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="password" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</td>
		</tr>
		<tr>
			<td>Email ID</td>
			<td><input type="text" name="emailId" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" name="phoneNo" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</td>
		</tr>
		<tr>
			<td>Govt ID</td>
			<td><input type="text" name="govtId" maxlength="100" /></td>
		</tr>
		<tr>
			<td>Bank Account Number</td>
			<td><input type="text" name="bankNo" maxlength="100" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>