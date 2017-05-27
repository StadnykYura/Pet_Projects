<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${customer.name} 
<br>
<img src="${customer.pathImage}" alt="add foto" width="500px" height="500px">
<br>

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data"
	onsubmit="if (!this.image.value) return false">
	<input type="file" name="image">
	<button>save image</button>
</form:form>
<br>


<c:forEach var="commodity" items="${commodities}">
    ${commodity.name}
    <a href="deleteFromOrder/${commodity.id}">delete From Cookie</a>
    <br>
</c:forEach>

<br>
<a href="mainPage">Main page</a>



