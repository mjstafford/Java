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
<title>Insert title here</title>
</head>
<body>
	<div id="show-header">
		<h1>Expense Details</h1>
		<a href="/">Go back</a>
	</div>
	<div id="show-body">
		<div>
			<p>Expense Name:</p>
			<p><c:out value="${expense.name}" /></p>
		</div>
		<div>
			<p>Expense Description:</p>
			<p><c:out value="${expense.description}" /></p>
		</div>
		<div>
			<p>Vendor:</p>
			<p><c:out value="${expense.vendor}" /></p>
		</div>
		<div>
			<p>Amount Spent:</p>
			<p>$<c:out value="${expense.amount}" /></p>
		</div>
	</div>

</body>
</html>