<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
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
<title>New Ninja</title>
</head>
<body>
	<div class="page-container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja" id="ninja-form">
			<div>
				<form:label path="dojo">Dojo: </form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}" path="dojo">
							<c:out value="${dojo.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:errors path="firstName" class="text-danger ninja-errors"/>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" />
			</div>
			<div>
				<form:errors path="lastName" class="text-danger ninja-errors"/>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" />
			</div>
			<div>
				<form:errors path="age" class="text-danger ninja-errors"/>
				<form:label path="age">Age</form:label>
				<form:input type="number" path="age" />
			</div>
			<input type="submit" value="Create" />
		</form:form>
	</div>
</body>
</html>