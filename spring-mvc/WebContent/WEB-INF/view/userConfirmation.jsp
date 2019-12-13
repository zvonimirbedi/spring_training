<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Spring MVC Hello World Confirmation</title>
</head>
<body>

	<h2>Spring MVC Hello World Confirmation</h2>
	<hr/>
	<br />
	<br />
	<br />
	The User First and Last Name: ${BeanUser.firstName} ${BeanUser.lastName} 
	<br />
	The User Country: ${BeanUser.country}
	<br />
	The User Favourite Programming Language: ${BeanUser.favouriteProgrammingLanguage}
	<br />
	The User Used OSs: 
	<c:forEach var="temp" items="${BeanUser.usedOSs}">
	${temp} 	
	</c:forEach>

</body>
</html>