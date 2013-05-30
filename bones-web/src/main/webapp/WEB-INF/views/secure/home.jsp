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
		Welcome, <c:out value="${sessionScope.user.username}" />
		|
    	<a href="<c:url value="/" />" > Public Home</a>
    	|
        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		
	</div>

	<!-- 	Tabs -->
	<ul class='tabs'>
		<li><a href='#tab1'>Profile</a></li>
		<li><a href='#tab2'>Discussions</a></li>
		<li><a href='#tab3'>Pictures</a></li>
		<li><a href='#tab4'>Calendar</a></li>
		<authz:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href='#tab5'>Admin</a></li>
		</authz:authorize>
	</ul>
	
	<iframe id="tab1" src="<c:url value='/secure/user-profile.htm'/>" ></iframe>
    <iframe id="tab2" src="<c:url value='/secure/discussions.htm'/>"></iframe>
    <iframe id="tab3" src="<c:url value='/secure/pictures.htm'/>"></iframe>
<!--     <iframe id="tab4" src="http://www.google.com/calendar/embed?src=lmd59%40cornell.edu&ctz=America/New_York" style="border: 0" width="800" height="600" frameborder="0" scrolling="no"></iframe> -->
    <iframe id="tab4" src="https://www.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=cornell.edu_3fh8e346t0q11m5sro6e4lh6b8%40group.calendar.google.com&amp;color=%232952A3&amp;ctz=America%2FNew_York" style=" border-width:0 " width="800" height="600" frameborder="0" scrolling="no"></iframe>
<%--     <iframe id="tab4" src="<c:url value='/secure/calendar.htm'/>"></iframe> --%>
    <authz:authorize access="hasRole('ROLE_ADMIN')">
    	<iframe id="tab5" src="<c:url value="/admin/listAdmin.htm"/>"></iframe>
	</authz:authorize>
    
</body>
</html>