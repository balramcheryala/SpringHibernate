<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="text" method="post">
<table border="1" cellpadding="2" width="70%">
<c:forEach var="emp" items="${listuser}">
<tr><th>Id </th><th>First Name</th><th>Last Name</th></tr>
<tr>
<td>${emp.id}</td>
<td>${emp.fname}</td>
<td>${emp.lname}</td>

<td><a href="editemp/${emp.id}">Edit</a></td>
<td><a href="deleteemp/${emp.id}">Delete</a></td>
</tr>

</c:forEach> 
</table>
<br/>
</form>

</body>
</html>