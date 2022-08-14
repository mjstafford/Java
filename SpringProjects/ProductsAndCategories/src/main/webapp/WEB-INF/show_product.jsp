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
<title>Show Product</title>
</head>
<body>
	<div class="page-container">
		<h1> <c:out value="${product.name}" /></h1>
		<a href="/">Home</a>
		<hr />
		<div>
			<h2>Categories:</h2>
			<ul>
				<c:forEach var="category" items="${categories}">
					<li>
						${category.name}
					</li>
				</c:forEach>			
			</ul>
		</div>
		
		<hr />
		
		<div>
			<h2>Add a Category</h2>
			<form:form action="/products/${product.id}/new_category" method="post" modelAttribute="newCategoryProduct">
			
				<form:errors path="product" class="text-danger"/>
				<form:input path="product" type="hidden" value="${product.id}" />
				
				<form:errors path="category" class="text-danger"/>
				<form:select path="category">
					<c:forEach var="category" items="${availableCategories}">
						<form:option value="${category.id}" path="category">${category.name}</form:option>
					</c:forEach>
				</form:select>
				
				<input type="submit" value="submit" />
			</form:form>
		</div>
		
	</div>
</body>
</html>