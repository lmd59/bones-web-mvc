<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello!  
</h1>

<p>Welcome to the website of the Big Red Bones</p>
<P>  The time on the server is ${serverTime}. </P>
<p>Check out how much da <a href="<c:url value="/bones-rock.htm" />" >bones rock</a>. Woo!</p>
<p><a href="<c:url value="/info.htm" />" >Learn More</a> about Da Bones!</p>
<p><a href="<c:url value="/login.htm" />" > Login</a> to see more awesome content!</p>
</body>
</html>
