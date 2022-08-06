<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="/js/script.js"></script>
<title>Omikuji-Form</title>
</head>
<body>
	<div>
		<h1>Send an Omikuji!</h1>
		<form action="/omikuji/process" method="post">
			<label for="number">Pick any number from 5 to 25</label>
			<input type="number" name="number" id="number" />
	
			<label for="city">Enter the name of any city</label>
			<input type="text" name="city" id="city" />
		
	
			<label for="person">Enter the name of any real person</label>
			<input type="text" name="person" id="person" />
		
	
			<label for="endeavor">Enter professional endeavor or hobby</label>
			<input type="text" name="endeavor" id="endeavor" />
		
	
			<label for="thing">Enter any type of living thing</label>
			<input type="text" name="thing" id="thing" />
		
			<label for="description">Say something nice to someone</label>
			<textarea name="description" id="description" cols="30" rows="10"></textarea>
			
			<p>Send and show a friend</p>
			
			<input type="submit" value="Send" />
		
		</form>
	</div>

</body>
</html>