<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC Customer Registration</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<h2>Spring MVC Customer Registration</h2>
	<hr>
	<br />
	<br />
	<br />

	<form:form action="processForm" modelAttribute="BeanCustomer">
First Name: <form:input path="firstName" />
		<br />
Last name (*):<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
Free Pass :<form:input path="freePass" />
		<form:errors path="freePass" cssClass="error" />
		<br />
Post Code:<form:input path="postCode" />
		<form:errors path="postCode" cssClass="error" />
		<br />
Course Code:<form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		<br />
		<br />

		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>