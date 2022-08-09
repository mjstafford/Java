<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<script type="text/javascript" src="/js/app.js"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>New Book Form</title>
</head>
<body>
	<div id="form-page-container">
		<h1>New Book</h1>
		<form:form action="/books/new" method="post" modelAttribute="book" id="form-container">
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title" id="title" />

			<form:label path="description">Description</form:label>
			<form:textarea path="description" id="description" cols="30" rows="10"></form:textarea>

			<form:label path="language">Language</form:label>
			<form:input type="text" path="language" id="language" />

			<form:label path="numberOfPages">Pages</form:label>
			<form:input type="number" path="numberOfPages" id="numberOfPages" />
			
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>