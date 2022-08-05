<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grace Hopper</title>
</head>
<body>
<h1>Name: <c:out value="${name}"/> </h1>
<h1>item name: <c:out value="${itemName}"/> </h1>
<h1>price: $<c:out value="${price}"/> </h1>
<h1>description: <c:out value="${description}"/> </h1>
<h1>vendor: <c:out value="${vendor}"/> </h1>

</body>
</html>