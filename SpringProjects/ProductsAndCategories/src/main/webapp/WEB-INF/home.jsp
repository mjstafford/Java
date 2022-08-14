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
<title>Home</title>
</head>
<body>
	<div class="page-container">
		<div class="home-header">
			<h1>Home Page</h1>
			<div>
				<a href="/products/new">New Product</a>
				<a href="/categories/new">New Category</a>
			</div>		
		</div>
		<hr />
		<div class="home-body">
			<div class="home-l">
				<h2>Products</h2>
				<ul>
					<c:forEach var="product" items="${products}">
						<li>
							<a href="/products/${product.id}">${product.name}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="home-r">
				<h2>Categories</h2>
				<ul>
					<c:forEach var="category" items="${categories}">
						<li><a href="/categories/${category.id}">${category.name}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	
</body>
</html>