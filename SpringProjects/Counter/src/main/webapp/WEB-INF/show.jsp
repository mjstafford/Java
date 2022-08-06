<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>
	
	<p>you have visited <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${count}"/> times.</p>	
	<a href="http://localhost:8080/">Test another visit?</a>
	
	<a href="/reset">reset count</a>
</body>
</html>