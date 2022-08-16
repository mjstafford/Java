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
<title>Exam - edit</title>
</head>
<body>
	<div class="page-container">
		<div class="edit-header">
			<h1>Change Your Entry</h1>
			<a href="/home">Home</a>
		</div>
		
		<form:form action="/things/${thing.id}/edit" method="post" modelAttribute="thing">
			<!-- need for EDIT (AKA PUT) functionality -->
			<input type="hidden" name="_method" value="put"/> 
			
			<!-- //need to make it so that the user id gets added to the book (in the service/controller) -->
			<!-- <form:input type="hidden" path="user" value="${user.id}"/> -->
			<!-- if needing relationship between classes -->
			<form:errors path="user" />
			<form:input type="hidden" path="user" value="${thing.user.id}"/>
		
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
		
			<a href="/things" class="btn btn-danger">Cancel</a>
			<input type="submit" value="Submit" />
		</form:form>
	</div>


</body>
</html>