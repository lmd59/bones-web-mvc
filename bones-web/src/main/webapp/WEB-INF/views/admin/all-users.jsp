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
	Pending users:
	<table>
	<c:forEach items="${pendingUsers}" var="current">
		<tr>
        	<td><c:out value="${current.username}" /><td>
        	<td><c:out value="${current.firstname}" /><td>
        	<td><a href="<c:url value="/admin/confirmPending/${current.userID}" />" > Confirm pending user</a></td>
      	</tr>
    </c:forEach>
    </table>
    Basic users:
    (Can make admin)
    Admin users:
	
</body>
</html>