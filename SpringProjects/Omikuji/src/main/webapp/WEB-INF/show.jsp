<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="/js/script.js"></script>
<title>Show Omikuji</title>
</head>
<body>


<div id="fortune-container">
	<h1>Here's Your Omikijui!</h1>
	
	<div id="fortune">
		<p>
		In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with 
		<c:out value="${person}"/> as your roommate, <c:out value="${endeavor}"/> for a living. The next time you see a 
		<c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${description}"/>.
		</p>
	</div>
	
	<a href="/omikuji">go back</a>
</div>
</body>
</html>