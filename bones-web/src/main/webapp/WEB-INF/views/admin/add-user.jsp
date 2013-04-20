<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 	Page to directly add a user without user application -->
    <form action="addUser.htm" method="post">
    	Username: <input type="text" name="username">
    	Password: <input type="password" name="password">
        First name: <input type="text" name="firstname">
        Last name: <input type="text" name="lastname">
        Nickname: <input type="text" name="nickname">
        Email: <input type="text" name="email">
        Class Year: <input type="text" name="classYear">
        Position(s): <input type="text" name="position">
        <input type="submit" value="Save">
    </form>
</body>
</html>