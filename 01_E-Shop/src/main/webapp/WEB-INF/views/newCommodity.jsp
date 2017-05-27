<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${exceptions}
<br>

<c:forEach var="commodity" items="${commodities}">
	<div style="background-color: red">	
		${commodity.name} ${commodity.pricePerOne} 
		<a href="deleteCommodity/${commodity.id}">delete</a>
	</div>
	<br>
</c:forEach>


new Good
<br>

<%-- @ModelAttribute --%>
<sf:form modelAttribute="commodity" action="saveCommodity" method="post">
	<sf:input path="name" placeholder="name"/>
	<sf:input path="description" placeholder="description"/>
	<sf:input path="pricePerOne" placeholder="price per one"/>

<button>save commodity</button>
</sf:form>




<%-- <form action="saveCommodity" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input name="commodityName" placeholder="commodity name">
	<br>
	<input name="commodityDescription" placeholder="commodity Description">
	<br>
	<input name="commodityPricePerOne" placeholder="commodity Price Per One">
	<br>
	<button>save commodity</button>
</form> --%>

</body>
</html>