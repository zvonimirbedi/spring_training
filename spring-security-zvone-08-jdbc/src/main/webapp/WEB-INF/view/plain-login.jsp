<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Zvone Spring Security CRM - Login</title>
<style>
.failed{
color: red;}
</style>
</head>
<body>
<h3>Zvone Spring Security CRM - Login</h3>
<hr>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			method="POST">
			
			<c:if test="${param.error !=null}">
				<i class="failed">Sorry! wrong username/password! Try again!</i>
			</c:if>
			<p>
			User Name: <input type="text" name="username"/> 
			</p>
			<p>
			Password: <input type="password" name="password"/> 
			</p>
			
			<input type="submit" value="Login"/>
			
</form:form>

</body>
</html>