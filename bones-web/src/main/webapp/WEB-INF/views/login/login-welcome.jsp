<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Message : ${message}</h3>	
	<h3>Username : ${username}</h3>	
 
 	<p>You have successfully logged in!</p>
 	
 	<authz:authorize access="!hasRole('ROLE_USER')">
        <p>Your user level authorization is pending.</p>
        <p>Feel free to peruse the 
        <a href="<c:url value="/" />" > public pages</a>
        while awaiting authorization!</p>
    </authz:authorize>
 
 	<authz:authorize access="hasRole('ROLE_USER')">
		<p>You are an authorized user:
		<a href="<c:url value="/secure/user-profile.htm" />" > View profile</a></p>
	</authz:authorize>
 	
	
	<!-- 	Check for admin -->
	<authz:authorize access="hasRole('ROLE_ADMIN')">
		<p>You are an administrator:
		<a href="<c:url value="/admin/listAdmin.htm" />" > See administrator actions</a></p>
	</authz:authorize>
	
	
	<p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a><p>
 
</body>
</html>