<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/top-bar.css'/>" type="text/css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/top-bar.js'/>"></script>
</head>
<body>
	
	<!-- 	Nav links -->
	<div style="position:absolute;right:20px;">
		<authz:authorize access="!isAuthenticated()">
			<a href="<c:url value="/addUserForm.htm" />" > Create Account</a>
			|
	        <a href="<c:url value="/login.htm" />" > Login</a>
	    </authz:authorize>
	    
	    <authz:authorize access="isAuthenticated()">
	    	Welcome, <c:out value="${sessionScope.user.username}" />
			|
	    	<a href="<c:url value="/secure/" />" > User Home</a>
	    	|
	        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	    </authz:authorize>
	    
	    
	</div>
	
	<!-- 	Tabs -->
	<ul class='tabs'>
		<li><a href='#tab1'>Welcome</a></li>
		<li><a href='#tab2'>Info</a></li>
		<li><a href='#tab3'>Contacts</a></li>
	</ul>
	
	<iframe id="tab1" src="<c:url value='/welcome.htm'/>" ></iframe>
    <iframe id="tab2" src="<c:url value='/info.htm'/>"></iframe>
    <iframe id="tab3" src="<c:url value='/contacts.htm'/>"></iframe>
    
</body>
</html>