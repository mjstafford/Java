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
<title>New Book Form</title>
</head>
<body>
	<div id="form-page-container">
		<h1>New Book</h1>
		<form action="/books/new" method="post" id="form-container">
			<label for="title">Title</label>
			<input type="text" name="title" id="title" />

			<label for="description">Description</label>
			<textarea name="description" id="description" cols="30" rows="10"></textarea>

			<label for="language">Language</label>
			<input type="text" name="language" id="language" />

			<label for="numberOfPages">Pages</label>
			<input type="number" name="numberOfPages" id="numberOfPages" />
			
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>