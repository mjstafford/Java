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
<title>Dashboard</title>
</head>
<body>
	<div class="page-container">
		<div class="dashboard-header">
			<h1>Welcome, ${userName}!</h1>
			<a href="/logout">log out</a>
		</div>
		
		<div class="all-projects">
			<table class="table table-stripped tabled-hover">
				<thead>
					<tr>
						<th scope="col">Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td>
								<a href="/projects/${project.id}">${project.title}</a>
							</td>
							<td>${project.lead.firstName} ${project.lead.lastName} </td>
							<td>${project.dueDate}</td>
							<td>
								<a href="/projects/${project.id}/join"> Join Team</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</div>
	
	</div>
</body>
</html>




