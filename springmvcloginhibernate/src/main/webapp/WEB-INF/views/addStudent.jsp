<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring</title>
	</head>
	<script>
function validateForm() {
    var x = document.forms["myForm"]["name"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Please fill all ");
        return false;
    }
}
</script>
	<body>
	
		<h2>Student Registration Form</h2>
		<form:form name="myForm" method="POST" action="/sdnext/save.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Student ID:</form:label></td>
			        <td><form:input path="id" value="${employee.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Student FirstName:</form:label></td>
			        <td><form:input path="name" value="${employee.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="lname">Student LastName:</form:label></td>
			        <td><form:input path="lname" value="${employee.lname}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="age">Student Age:</form:label></td>
			        <td><form:input path="age" value="${employee.age}"/></td>
			    </tr>
			     <tr>
			        <td><form:label path="email">Student Email_Id:</form:label></td>
			        <td><form:input path="email" value="${employee.email}"/></td>
			    </tr>
			   
			     <tr>
			        <td><form:label path="password">Student Password:</form:label></td>
			        <td><form:input path="password" value="${employee.password}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="salary">Student MobileNumber:</form:label></td>
			        <td><form:input path="salary" value="${employee.salary}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address">Student Address:</form:label></td>
                    <td><form:input path="address" value="${employee.address}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty employees}">
		<h2>List Students</h2>
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student FirstName</th>
			<th>Student LastName</th>
			<th>Student Age</th>
			<th>Student Email_id</th>
			<!-- <th>Student Password</th> -->
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
				<%-- <td><c:out value="${employee.password}"/></td> --%>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.address}"/></td>
			
				<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>