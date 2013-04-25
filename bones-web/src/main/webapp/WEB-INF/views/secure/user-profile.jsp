<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><c:out value="${sessionScope.user.username}" /></h3>
	<table>
	<tr>
       	<td>Name:<td>
       	<td><c:out value="${sessionScope.user.firstname}" />&nbsp;
		<c:out value="${sessionScope.user.lastname}" /><td>
    </tr>
    <tr>
       	<td>Nickname:<td>
       	<td><c:out value="${sessionScope.user.nickname}" /><td>
    </tr>
    <tr>
       	<td>Email:<td>
       	<td><c:out value="${sessionScope.user.email}" /><td>
    </tr>
    <tr>
       	<td>Class year:<td>
       	<td><c:out value="${sessionScope.user.classYear}" /><td>
    </tr>
    <tr>
       	<td>Position:<td>
       	<td><c:out value="${sessionScope.user.position}" /><td>
    </tr>
    </table>
</body>
</html>