<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- YOUR own local js -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Save Travels</title>
</head>
<body>
	<div>
		<h2>Save Travels</h2>
		<table class="table table-hover">
		  <thead>
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions</th>
			</tr>
		  </thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td scope="row">	<c:out value="${expense.name}"/>	</td>		
						<td>	<c:out value="${expense.vendor}"/>	</td>		
						<td>	$<c:out value="${expense.amount}"/>	</td>			
						<td>
							<a href="/expense/<c:out value="${expense.id}"/>/edit"> 
								edit/delete	
							</a> 
						</td>			
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="form-container">
		<h2>Add an expense</h2>
		<form:form action="/new" method="post" modelAttribute="expense">
			<div id="errors">
				<form:errors path="name" class="text-danger" />
				<form:errors path="vendor" class="text-danger" />
				<form:errors path="amount" class="text-danger" />
				<form:errors path="description" class="text-danger" />			
			</div>
			
			<form:label path="name">Expense Name:</form:label>
			<form:input type="text" path="name" id="name" />

			<form:label path="vendor">Vendor</form:label>
			<form:input type="text" path="vendor" id="vendor" />
			

			<form:label path="amount">Amount</form:label>
			<form:input type="text" path="amount" id="amount" />

			<form:label path="description">Description</form:label>
			<form:textarea path="description" id="description" cols="30" rows="10"></form:textarea>
			
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>