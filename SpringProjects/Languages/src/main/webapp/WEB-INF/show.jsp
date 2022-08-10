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
<title>show page</title>
</head>
<body>
	<div class="page-container">
		<a href="/languages">Dashboard</a>
		<div>
			<h2>
				Name: <c:out value="${language.name}" />
			</h2>
			<h2>
				Creator: <c:out value="${language.creator}" />
			</h2>
			<h2>
				Version: <c:out value="${language.version}" />
			</h2>
		</div>
		
		<div id="actions">
			<a href="/languages/edit/<c:out value="${language.id}"/>">edit</a>
			<!--  delete option, hidden input -->
			<form:form action="/languages/${language.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete" class="btn btn-link"/>
			</form:form>	
		</div>
	
	</div>
</body>
</html>