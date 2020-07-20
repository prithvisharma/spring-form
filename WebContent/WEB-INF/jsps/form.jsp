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
<h1>THIS IS PLAIN FORM</h1>
<hr><hr>
<br>
<form method="post" action="${pageContext.request.contextPath}/process-sign-up">
Full Name : <input type="text" name="fname" required>
<%-- required is a validation which will not let user leave the field empty --%>
<br><br>
Username : <input type="text" name="username" required>
<br><br>
Password : <input type="password" name="password" required>
<br><br>
<input type="submit" value="Sign Up">
<br><br>
</form>
</body>
</html>