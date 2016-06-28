<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=test method="post">
<form:form   modelAttribute="dto">
<form:label path="id">Id</form:label>
<form:input path="id" value="${dto.id}"/>

<form:label path="fname">First Name</form:label>
<form:input path="fname" value="${dto.fname}"/>

<form:label path="lname">Last Name</form:label>
<form:input path="lname" value="${dto.lname}"/>

<input type="submit" value="update" />

</form:form>
</form>
</body>
</html>