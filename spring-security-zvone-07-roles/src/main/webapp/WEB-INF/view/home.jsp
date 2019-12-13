<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zvone Spring Security CRM - Home</title>
</head>
<body>

<h3>Zvone Spring Security CRM - Home</h3>

<hr>

<p>
Welcome to the Home page of Zvone Spring Security CRM
</p>

<hr>

<p>
User: <security:authentication property="principal.username"/>
<br><br>
Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>

<security:authorize access="hasRole('MANAGER')">
 <a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a> (Only for leaders)
<hr>
 </security:authorize>
 
 <security:authorize access="hasRole('ADMIN')">
 <a href="${pageContext.request.contextPath}/systems">IT Systems Meetings</a> (Only for admins)
<hr>
 </security:authorize>

<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
		<input type="submit" value="logout" />
</form:form>

</body>
</html>