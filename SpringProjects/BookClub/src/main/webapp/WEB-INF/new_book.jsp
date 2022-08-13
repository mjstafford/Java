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
<title>Book Club - new book</title>
</head>
<body>
	<div class="page-container">
		<div class="new-book-header">
			<h1>Add a Book to Your shelf!</h1>
			<a href="/books">back to the shelves</a>
		</div>
		
		<form:form action="/books/new" method="post" modelAttribute="newBook">

			<!-- //need to make it so that the user id gets added to the book (in the service/controller) -->
			<!-- <form:input type="hidden" path="user" value="${user.id}"/> -->
			<form:errors path="user" />
			<form:input type="hidden" path="user" value="${user.id}"/>
		
			<form:errors path="title" />
			<div class="lab-in">
				<form:label path="title">Title</form:label>
				<form:input path="title" />
			</div>
			
			<form:errors path="author" />
			<div class="lab-in">
				<form:label path="author">Author</form:label>
				<form:input path="author" />
			</div>
			
			<form:errors path="thoughts" />
			<div class="lab-in">
				<form:label path="thoughts">My thoughts</form:label>
				<form:textarea path="thoughts"></form:textarea>
			</div>
		
			<input type="submit" value="Submit" />
		</form:form>
		
		
	</div>
</body>
</html>