<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
			
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="first_name"/> </td>
					</tr>
					
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="last_name"/> </td>
					</tr>
					
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email"/> </td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>	
		</form:form>
		
		
		<div style="clear;both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a> 
		</p>
	</div>


		

</body>
</html>