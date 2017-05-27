<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="change" value="${cookies}"/>
<c:choose>
		<c:when test="${change}">
	There is no commodities chosen. Please go to List of Products and choose<br>
		</c:when>
		
		 <c:otherwise>
		 
<sf:form modelAttribute="cartInfo" action="confirmOrder" method="post">
	<c:forEach var="commodity" items="${commodities}">
    ${commodity.name} ${commodity.pricePerOne}
    <input name="quantity" type="number" placeholder="quantity to order">
    <a href="deleteFromOrder/${commodity.id}">delete from order</a>
    
    <br>
    <br>
	</c:forEach>
<br>
		 
		 <sec:authorize access="isAuthenticated()">
			<button>confirm order</button>
		</sec:authorize>
</sf:form>
		 
		 </c:otherwise>
		
</c:choose>
<%-- 	<c:if test="${cookie.value.value == null}">
	
	</c:if> --%>



<%-- <%
Cookie cookie = null;
Cookie[] cookies = null;
cookies = request.getCookies();

if( cookies == null ) {
		      No ITEMS found to buy. PLS Go to List of products and choose something to buy
}

%> --%>





<br>
<a href="mainPage">Main page</a>

</body>
</html>