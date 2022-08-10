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
<title>Edit Page</title>
</head>
<body>
	<div class="page-container">
		<div id="actions">
			<form:form action="/languages/${language.id}" method="post" >
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete" class="btn btn-link"/>
			</form:form>	
			<a href="/languages">Dashboard</a>
		</div>
	
	
		<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language" id="language-form"> 
			<input type="hidden" name="_method" value="put">
			<div id="errors">
				<form:errors path="name" class="text-danger" />
				<form:errors path="creator" class="text-danger" />
				<form:errors path="version" class="text-danger" />		
			</div>
			
			<div>
				<form:label path="name">Name</form:label>
				<form:input type="text" path="name" id="name" />
			</div>
			
			<div>
				<form:label path="creator">Creator</form:label>
				<form:input type="text" path="creator" id="creator" />		
			</div>
			
			<div>
				<form:label path="version">Version</form:label>
				<form:input type="text" path="version" id="version" />
			</div>
			
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>