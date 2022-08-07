<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="/js/script.js"></script>
<title>Ninja Gold JAVA</title>
</head>
<body>

<div id="gold-container">
	<p>Your gold: 
		<span id="gold-amount">
			<c:out value="${currGold}"/> 
		</span> 
	</p>
</div>

<div id="earn-container">
		<div class="building">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<form action="/Gold/process" method="post">
				<input type="hidden" name="building" value="Farm"/>
				<input type="submit" value="Find Gold!" />
			</form>	
		</div>
		
		<div class="building">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<form action="/Gold/process" method="post">
				<input type="hidden" name="building" value="Cave"/>
				<input type="submit" value="Find Gold!" />
			</form>	
		</div>
		
		<div class="building">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<form action="/Gold/process" method="post">
				<input type="hidden" name="building" value="House"/>
				<input type="submit" value="Find Gold!" />
			</form>	
		</div>
		
		<div class="building">
			<h2>Quest</h2>
			<p>(earns/takes 0-50 gold)</p>
			<form action="/Gold/process" method="post">
				<input type="hidden" name="building" value="Quest"/>
				<input type="submit" value="Find Gold!" />
			</form>	
		</div>
</div>
	
<div id="activites-container">
	<div>
		<c:if test="${!empty activities}">
			<c:forEach var="activity" items="${activities}">
				<p><c:out value="${activity}"/></p>
			</c:forEach>		
		</c:if>
	</div>
</div>


</body>
</html>