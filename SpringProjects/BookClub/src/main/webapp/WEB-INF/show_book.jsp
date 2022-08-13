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
<title>Book Club - show book</title>
</head>
<body>
	<div class="page-container">
		<div class="show-header">
			<h1><c:out value="${book.title}" /></h1>
			<a href="/books">back to the shelves</a>
		</div>
		
		<div class="show-body">
			<c:choose>
				<c:when test="${!userName.equals(book.user.userName)}">
					<h3><c:out value="${book.title}" /> by <c:out value="${book.author}" />.</h3>
				</c:when>
				<c:otherwise>
					<h3><c:out value="${userName}" /> read <c:out value="${book.title}" /> by <c:out value="${book.author}" />.</h3>
					<h4>Here are <c:out value="${book.user.userName}"/> thoughts:</h4>
					<hr />
						<p><c:out value="${book.thoughts}" /></p>
					<hr />
					<a href="/books/<c:out value="${book.id}"/>/edit" class="btn btn-primary">edit</a>
				
				</c:otherwise>
			</c:choose>	
		</div>
	
	</div>
</body>
</html>