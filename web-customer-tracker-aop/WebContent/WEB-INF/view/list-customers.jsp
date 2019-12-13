<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List Customers</title>
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
			
		</div>
		
		

	</div>
			<div id="container">
				<div id="content">
				
				
					<!-- add 'add customer' button here -->
				
				<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class = "add-button"
				/>
				
				
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
						<!-- loop over and print our customers -->
						<c:forEach var="tempCustomer" items="${customers}">
							<tr>
							
							<c:url var="updateLink" value="/customer/showFormForUpdate">
								<c:param name="customerId" value ="${tempCustomer.id}"></c:param>							
							</c:url>
							
							<c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value ="${tempCustomer.id}"></c:param>							
							</c:url>
							
								<th>${tempCustomer.first_name}</th>
								<th>${tempCustomer.last_name}</th>
								<th>${tempCustomer.email}</th>
								<th>
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</th>
							</tr>

						</c:forEach>

					</table>

				</div>
			</div>



</body>
</html>