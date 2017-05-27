<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<c:forEach var="commodity" items="${commodities}">
		${commodity.name} ${commodity.pricePerOne}
			<sec:authorize access="hasRole('ROLE_CUSTOMER')">
				<a href="buyCommodity/${commodity.id}">buy</a>
			</sec:authorize>
		<br>
	</c:forEach>
	<br>
	<br>
	<br>
<sec:authorize access="hasRole('ROLE_CUSTOMER')">
	<a href="basket">basket</a>
	</sec:authorize>
	
	<br>
<a href="mainPage">Main page</a>