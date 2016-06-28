<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Students</title>
</head>
<body>
<h1>List Students</h1>
<h3><a href="add.html">Add More Students</a></h3>

<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student FirstName</th>
			<th>Student LastName</th>
			<th>Student Age</th>
			<th>Student Email_id</th>
			<th>Student Password</th>
			<th>Student MobileNumber</th>
			<th>Student Address</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<td><c:out value="${employee.lname}"/></td>
				<td><c:out value="${employee.age}"/></td>
				<td><c:out value="${employee.email}"/></td>
				<td><c:out value="${employee.password}"/></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.address}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>