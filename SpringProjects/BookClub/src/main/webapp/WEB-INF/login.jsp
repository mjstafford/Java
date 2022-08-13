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
<title>Book Club - Login/Registration</title>
</head>
<body>
	<div class="page-container">
		<div class="login-header">
			<h1>Book Club</h1>
			<p>A place for friends to share thoughts on books</p>
		</div>

		<div class="log-reg-container">
			<div class="register">
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<form:errors path="userName" class="text-danger"/>
					<div class="lab-in">
						<form:label path="userName">User Name: </form:label>
						<form:input path="userName" />
					</div>
					
					<form:errors path="email" class="text-danger" />
					<div class="lab-in">
						<form:label path="email">Email: </form:label>
						<form:input path="email" />
					</div>
					
					<form:errors path="password"  class="text-danger"/>
					<div class="lab-in">
						<form:label path="password">Password: </form:label>
						<form:input path="password" />
					</div>
					
					<form:errors path="confirm"  class="text-danger"/>
					<div class="lab-in">
						<form:label path="confirm">Confirm: </form:label>
						<form:input path="confirm" />
					</div>
					
					<input type="submit" value="Submit" />
				</form:form>
			</div>

			<div class="login">
				<h2>Log in</h2>
				<form:form action="/login" method="post" modelAttribute="newLoginUser">
					<form:errors path="email"  class="text-danger"/>
					<div class="lab-in">
						<form:label path="email">Email: </form:label>
						<form:input path="email" />
					</div>
					
					<form:errors path="password"  class="text-danger"/>
					<div class="lab-in">
						<form:label path="password">Password: </form:label>
						<form:input path="password" />
					</div>
					<input type="submit" value="Log in" />
				</form:form>
			</div>		
		</div>
	</div>
</body>
</html>