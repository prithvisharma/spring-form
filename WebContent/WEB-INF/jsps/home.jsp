<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME HOME</h1>
<hr><hr>
<br>
Click the link below to go to our plain form
<br>
<a href="${pageContext.request.contextPath}/sign-up">Way to plain form</a>
<hr>
Click the link below to go to our spring form
<br>
<a href="${pageContext.request.contextPath}/spring-sign-up">Way to spring form</a>
<hr>
<p style="font-size:14px"><b>List of All Users</b></p>
<hr>
<c:forEach items="${list}" var="list">
<c:out value="${list.getId() }"/>	<c:out value="${list.getName()}"/>	<c:out value="${list.getUsername()}"/>	<c:out value="${list.getPassword()}"/><br>
</c:forEach>
</body>
</html>