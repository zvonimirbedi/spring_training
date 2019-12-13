<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC Customer Registration Confirmation</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<h2>Spring MVC Customer Registration Confirmation</h2>
	<hr>
	<br />
	<br />
	<br /> 
	The Customer First and Last Name: ${BeanCustomer.firstName}
	${BeanCustomer.lastName}
	<br /> 
	The Customer Free Passes: ${BeanCustomer.freePass}
	<br /> 
	The Customer Post Code: ${BeanCustomer.postCode}
	<br /> 
	The Customer Post Code: ${BeanCustomer.courseCode}
	
	



</body>
</html>
