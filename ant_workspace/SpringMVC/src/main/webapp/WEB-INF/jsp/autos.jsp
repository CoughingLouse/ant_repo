<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />

	<ul>
	<c:forEach var="auto" items="${lista}">
    	<li>
    			${auto.modello} ${auto.cilindrata }
    	</li>
	</c:forEach>
	</ul>
	
</body>

</html>
