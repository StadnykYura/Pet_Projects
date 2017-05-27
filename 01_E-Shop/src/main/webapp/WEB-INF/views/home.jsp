<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <sec:authentication property="name"/>
<br> --%>



<sec:authorize access="hasRole('ROLE_CUSTOMER')">
	<a href="profile">profile</a>
</sec:authorize>
<br>


<br>
<sec:authorize access="isAnonymous()">
<a href="loginpage">login</a>
</sec:authorize>
<br>

<sec:authorize access="isAuthenticated()">
<form:form action="logout" method="post">
	<button>logout</button>
</form:form>
</sec:authorize>
<br>

<sec:authorize access="isAnonymous()">
<a href="registration">registration</a>
</sec:authorize>
<br>
<br>

<sec:authorize access="hasRole('ROLE_CUSTOMER')">
<a href="basket">basket</a>
</sec:authorize>
<br>
<br>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<br>
	<a href="newCustomer">manage customers</a>
	<br>
	<a href="newCommodity">add good</a>
	<br>
<!-- 	<a href="newCart">add cart</a>
	<br> -->
	</sec:authorize>
	<br>
	<br>
	<br>
<br>


<a href="listOfProducts">List of products</a>


<%-- <c:forEach var="commodity" items="${commodities}">
		${commodity.name} ${commodity.pricePerOne}
			<sec:authorize access="isAuthenticated()">
				<a href="buyCommodity/${commodity.id}">buy</a>
			</sec:authorize>
		<br>
	</c:forEach> --%>




</body>
</html>