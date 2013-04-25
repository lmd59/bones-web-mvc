<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Pending users:</h4>
	<table>
	<c:forEach items="${pendingUsers}" var="current">
		<tr>
        	<td><c:out value="${current.username}" /></td>
        	<td><c:out value="${current.firstname}" /></td>
        	<td><c:out value="${current.lastname}" /></td>
        	<td><c:out value="${current.email}" /></td>
        	<td><a href="<c:url value="/admin/confirmPending/${current.userID}" />" > Confirm pending user</a></td>
      	</tr>
    </c:forEach>
    </table>
    <h4>Basic users:</h4>
    <table>
	<c:forEach items="${basicUsers}" var="current">
		<tr>
        	<td><c:out value="${current.username}" /></td>
        	<td><c:out value="${current.firstname}" /></td>
        	<td><c:out value="${current.lastname}" /></td>
        	<td><c:out value="${current.email}" /></td>
        	<td><a href="<c:url value="/admin/makeAdmin/${current.userID}" />" > Make admin user</a></td>
		</tr>
    </c:forEach>
    </table>
    <h4>Admin users:</h4>
	<table>
	<c:forEach items="${adminUsers}" var="current">
		<tr>
        	<td><c:out value="${current.username}" /></td>
        	<td><c:out value="${current.firstname}" /></td>
        	<td><c:out value="${current.lastname}" /></td>
        	<td><c:out value="${current.email}" /></td>
      	</tr>
    </c:forEach>
    </table>
	
</body>
</html>