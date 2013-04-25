<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 	Page to add a user -->
	<p>Use the form below to create an account.</p>
	<p>Accounts must be approved by an administrator before they can be used to log in.</p>
<!-- 	TODO: mark some fields as required? -->
    <form action="addUser.htm" method="post">
    <table>
    	<tr><td>Username: </td><td><input type="text" name="username"></td></tr>
    	<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
    	<tr><td>First name: </td><td><input type="text" name="firstname"></td></tr>
    	<tr><td>Last name: </td><td><input type="text" name="lastname"></td></tr>
    	<tr><td>Nickname: </td><td><input type="text" name="nickname"></td></tr>
    	<tr><td>Email: </td><td><input type="text" name="email"></td></tr>
    	<tr><td>Class Year: </td><td><input type="text" name="classYear"></td></tr>
    	<tr><td>Position(s): </td><td><input type="text" name="position"></td></tr>
    	<tr><td><input type="submit" value="Save"></td></tr>
    </table>
    </form>
</body>
</html>