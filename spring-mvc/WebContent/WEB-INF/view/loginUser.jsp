<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC Hello World Login</title>
</head>
<body>

	<h2>Spring MVC Hello World Login</h2>
	<hr>
	<br />
	<br />
	<br />
	<form:form action="processForm" modelAttribute="userLogin" >
	First Name: <form:input path="firstName" />
		<br />
		<br />
	Last Name: <form:input path="lastName" />
		<br />
		<br />
	Country: 
		<form:select path="country">
			<form:options items="${countryList}" />
		</form:select>
		<br />
		<br />
		Favourite programming language:
		<br />
		<form:radiobuttons path="favouriteProgrammingLanguage" items="${userLogin.programmingLanguageList}"/>
		<br />
		Used Operations systems:
		<br />
		<form:checkboxes path="usedOSs" items="${userLogin.OSList}"/>
		<br />
		<input type="submit" value="Submit" />
	</form:form>
	<br />


</body>
</html>