<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Ware Management</title>
	<style>
		.error
		{
			color: #ff0000;
			font-weight: bold;
		}
		#listOfWares tr:first-child{
			font-weight: bold;
		}
	</style>
</head>

<body>

<h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>
<br/>

<table id="listOfWares" border="1">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>Short Name</td>
		<td>Image</td>
		<td>Catalog</td>
	</tr>
	<c:forEach items="${allWares}" var="ware">
		<tr>
			<td>${ware.id}</td>
			<td>${ware.name}</td>
			<td>${ware.shortName}</td>
			<td>${ware.image}</td>
			<td>${ware.catalog.name}</td>
		</tr>
	</c:forEach>
</table>

<h2><spring:message code="lbl.page" text="Add New Ware" /></h2>
<br/>
<form:form method="post" modelAttribute="ware">
	<table>
		<tr>
			<td><spring:message code="lbl.firstName" text="First Name" /></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td><spring:message code="lbl.lastName" text="Last Name" /></td>
			<td><form:input path="shortName" /></td>
			<td><form:errors path="shortName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><spring:message code="lbl.email" text="Email Id" /></td>
			<td><form:input path="image" /></td>
			<td><form:errors path="image" cssClass="error" /></td>
		</tr>
		<tr>
			<td><spring:message code="lbl.department" text="Department" /></td>
			<td><form:select path="catalog" items="${allDepartments}" itemValue="id" itemLabel="name" /></td>
			<td><form:errors path="catalog" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Add Ware"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>