<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
		<input type="submit" value="logout" />
</form:form>

</body>
</html>