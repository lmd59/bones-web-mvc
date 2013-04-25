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
	<p><a href="<c:url value="/secure/discussions.htm" />" > Return to Discussions List</a></p>
	<br/>
	<h3>Discussion: <c:out value="${currentDiscussion.title}" /></h3>
	
	
	<c:forEach items="${discussionMessages}" var="current">
		<hr/>
		<p><b><c:out value="${current.title}" /></b> on <c:out value="${current.createdate}" /></p>
     	<p><c:out value="${current.content}" /></p>
    </c:forEach>
    <hr/>
    Reply to Discussion Thread:
    <form method="post" action="replyDiscussion.htm">
    <table>
    	<tr><td>Title: </td><td><input type="text" name="title"></td></tr>
    	
<!--     	<tr><td>Body: </td><td><input type="text" name="content"></td></tr> -->
		<tr><td>Body: </td><td><textarea rows="4" cols="50" name="content"></textarea></td></tr>
    	
    	<tr><td><input type="hidden" name="discussionID" value="${currentDiscussion.discussionID}"></td></tr>
    	
    	<tr><td><input type="submit" value="Reply"></td></tr>
    </table>
    </form>
	
</body>
</html>