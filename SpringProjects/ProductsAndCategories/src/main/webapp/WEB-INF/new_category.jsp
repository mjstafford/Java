<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<title>New Category</title>
</head>
<body>
	<div class="page-container">
		<h1>New Category</h1>
		<a href="/">Home</a>
		<hr />
		
		<div class="new-category-body">
			<form:form action="/categories/new" method="post" modelAttribute="newCategory">
				
				<form:errors path="name" class="text-danger"/>
				<div class="lab-in">
					<form:label path="name">Name:</form:label>
					<form:input path="name" />
				</div>
				
				<input type="submit" value="submit" />
			
			</form:form>
		</div>
	</div>

</body>
</html>