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
	
	<div style="position:absolute;right:20px;">
		<authz:authorize access="!hasRole('ROLE_USER')">
	        <a href="<c:url value="/login.htm" />" > Login</a>
	    </authz:authorize>
	</div>
	
	<ul class='tabs'>
		<li><a href='#tab1'>Tab 1</a></li>
		<li><a href='#tab2'>Tab 2</a></li>
		<li><a href='#tab3'>Tab 3</a></li>
	</ul>
	
	<iframe id="tab1" src="<c:url value='/bones-rock.htm'/>" ></iframe>
    <iframe id="tab2" src="/tab2" style="width:100%;"></iframe>
    <iframe id="tab3" src="/tab3" style="width:100%;"></iframe>
    
        
<!-- 	<div id='tab1'> -->
<!-- 		<h3>Section 1</h3> -->
<!-- 		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis placerat dolor id aliquet. Sed a orci in justo blandit commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p> -->
<!-- 	</div> -->
<!-- 	<div id='tab2'> -->
<!-- 		<h3>Section 2</h3> -->
<!-- 		<p>Aenean et est tortor. In pharetra pretium convallis. Mauris sollicitudin ligula non mi hendrerit varius. Fusce convallis hendrerit mauris, eu accumsan nisl aliquam eu.</p> -->
<!-- 	</div> -->
<!-- 	<div id='tab3'> -->
<!-- 		<h3>Section 3</h3> -->
<!-- 		<p>Suspendisse potenti. Morbi laoreet magna vitae est mollis ultricies. Mauris eget enim ac justo eleifend malesuada. Proin non consectetur est. Integer semper laoreet porta. Praesent facilisis leo nec libero tincidunt blandit.</p> -->
<!-- 	</div> -->
</body>
</html>