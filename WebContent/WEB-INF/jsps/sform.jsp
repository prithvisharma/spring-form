<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>THIS IS SPRING FORM</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/process-spring-sign-up" modelAttribute="user"> 
<%-- modelAttribute contains User class obj --%>
Full Name : <sf:input type="text" path="name" required="required"/>	<sf:errors path="name" />		
<%-- use PATH instead of name; path is the variable of class User 
	 required is a validation which will not let user leave the field empty 
	 sf:error will display the message will which given to each variable of user
	 path is given so that message of that variable will be displayed		--%>
<br><br>
Username : <sf:input type="text" path="username" required="required"/> <sf:errors path="username"/>
<br><br>
Password : <sf:input type="password" path="password" required="required"/> <sf:errors path="password"/>
<br><br>
<input type="submit" value="Sign Up">
<br><br>
</sf:form>
</body>
</html>