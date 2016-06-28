<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DD Player List</title>
</head>
<body>
	<form action="playerlist" method="post">
		<table border="1" cellpadding="2" width="70%">
			<tr>
				<th>Name</th>
				<th>Role</th>
				<th>Batting</th>
				<th>Bowlling</th>
				<th>Nation</th>
				<th>Date Of Birth</th>
			</tr>
			<c:forEach var="playerlist" items="${playerlist}">

				<tr>
					<td>${playerlist.name}</td>
					<td>${playerlist.role}</td>
					<td>${playerlist.batting}</td>
					<td>${playerlist.bowler}</td>
					<td>${playerlist.nation}</td>
					<td>${playerlist.dob}</td>

					<%-- <td><a href="editemp/${playerlist.id}">Edit</a></td>
<td><a href="deleteemp/${playerlist.id}">Delete</a></td> --%>
				</tr>

			</c:forEach>
		</table>
		<br />
</body>
</html>