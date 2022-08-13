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
<title>Book Club - home</title>
</head>
<body>
	<div class="page-container">
		<div class="home-header">
			<div class="home-l">
				<h1>Welcome, <c:out value="${userName}" /></h1>
				<p>Books from eveyone's shelves:</p>
			</div>
			<div class="home-r">
				<a href="/logout">logout</a>
				<a href="books/new">+ Add a book to my shelf!</a>
			</div>
		</div>
		
	 	<table class="table table-striped table-primary table-hover table-bordered">
	 		<thead>
	 			<tr>
	 				<th scope="col">ID</th>
	 				<th scope="col">Title</th>
	 				<th scope="col">Author Name</th>
	 				<th scope="col">Posted By</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:forEach var="book" items="${books}">
					<tr>
						<td scope="row">${book.id}</td>		
						<td>
							<a href="/books/${book.id}">${book.title}</a>
						</td>		
						<td>${book.author}</td>					
						<td>${book.user.userName}</td>					
					</tr>
				</c:forEach>
	 		</tbody>
	 	
	 	
		</table>
	
	</div>
</body>
</html>