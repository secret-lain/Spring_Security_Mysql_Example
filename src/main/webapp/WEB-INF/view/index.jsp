<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<form method="post" action="/login/submit">
			<input type="text" name="id" />
			<input type="password" name="password" />
			<button type="submit">Submit</button>
		</form>
		<c:url value="${msg}" />
		<c:if test="${not empty nickname}">
			<c:out value="${nickname}"/>님 반갑습니다.
			<a href="/logout">로그아웃</a>
		</c:if>
	</body>
</html>
