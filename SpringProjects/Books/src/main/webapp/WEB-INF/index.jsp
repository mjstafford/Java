<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

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
<title>Books - java</title>
</head>

<body>
	<table class="table table-hover">
	  <thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Title</th>
			<th scope="col">Language</th>
			<th scope="col"># Pages</th>
		</tr>
	  </thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<th scope="row">	<c:out value="${book.id}"/>	</th>		
					<td>	
						<a href="/books/<c:out value="${book.id}"/>" >
							<c:out value="${book.title}"/>	
						</a>
					</td>		
					<td>	<c:out value="${book.language}"/>	</td>		
					<td>	<c:out value="${book.numberOfPages}"/>	</td>		
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>

</html>