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
<title>Login</title>
</head>
<body>
<div class="page-container">
		<div class="login-header">
			<h1>Project Manager</h1>
			<p>A place for teams to manage projects</p>
		</div>

		<div class="log-reg-container">
			<div class="register">
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<form:errors path="firstName" class="text-danger"/>
					<div class="lab-in">
						<form:label path="firstName">First Name: </form:label>
						<form:input path="firstName" />
					</div>
					
					<form:errors path="lastName" class="text-danger"/>
					<div class="lab-in">
						<form:label path="lastName">Last Name: </form:label>
						<form:input path="lastName" />
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