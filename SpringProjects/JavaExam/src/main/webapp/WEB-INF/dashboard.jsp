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
<title>Exam - Dashboard</title>
</head>
<body>
	<div class="page-container">
		<div class="home-header">
			<div class="header-l">
				<h1>Welcome, <c:out value="${user.userName}" />! </h1>
				<p>All somethings:</p>			
			</div>
			
			<div class="header-r">
				<a href="/logout">logout</a>
				<a href="/somethings/new">+ new something</a>
			</div>
		</div>
		
		<div class="home-body">
			<h2>All my things:</h2>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="thing" items="${things}">
						<tr>
							<td scope="row">
								<c:out value="${thing.firstName}"/>							
							</td>		
							<td>	
								<c:out value="${thing.lastName}"/>	
							</td>		
							<td>
								<c:out value="${thing.age}"/>	
							</td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>
</body>
</html>