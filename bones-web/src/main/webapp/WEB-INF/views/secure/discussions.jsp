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
	

	<h4>All discussions</h4>
	<table>
	<c:forEach items="${discussions}" var="current">
		<tr>
        	<td><c:out value="${current.title}" />:</td>
        	<td><a href="<c:url value="/secure/viewDiscussion/${current.discussionID}" />" > View discussion</a></td>
		</tr>
    </c:forEach>
    </table>
    
    Create new discussion link or form
    
    <h4>My messages</h4>
	<table>
	<c:forEach items="${userMessages}" var="current">
		<tr>
			<td><c:out value="${current.title}" /></td>
        	<td><a href="<c:url value="/secure/viewDiscussion/${current.discussion.discussionID}" />" > View discussion</a></td>
        	
		</tr>
<!-- 		<tr> -->
<%-- 			<td><c:out value="${current.content}" /></td> --%>
<!-- 		</tr> -->
    </c:forEach>
    </table>
	<!--     View discussion for each message -->
    
    
    
</body>
</html>