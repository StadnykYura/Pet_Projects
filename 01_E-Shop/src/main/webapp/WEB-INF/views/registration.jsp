<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${exception}
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<c:forEach var="customer" items="${customers}">
		<div style="background-color: red">
		
<%-- 		${customer} --%>
			${customer.name} ${customer.surname} ${customer.telephone}
		<a href="deleteCustomer/${customer.id}">delete customer</a>
		</div>
	</c:forEach>
</sec:authorize>



new Customer
<br>

<%-- @ModelAttribute --%>
<sf:form modelAttribute="customer" action="saveCustomer" method="post">
	<sf:input path="name" placeholder="name"/>
	<sf:input path="surname" placeholder="surname"/>
	<sf:input path="password" type="password" placeholder="password"/>
	<sf:input path="email" placeholder="email"/>
	<sf:input path="telephone" placeholder="telephone number"/>
	<sf:input path="address" placeholder="address" />
	
	<button>save customer</button>
</sf:form>

<br>
<a href="mainPage">Main page</a>


</body>
</html>