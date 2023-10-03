<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> JSTL 표현식 </h1>
	<c:set var="name" value="micol"></c:set> <!-- jstl 변수선언 -->
	<c:if test="${name ne null }">
		<h1>${name}</h1>
	</c:if>
	
	<c:choose>
		<c:when test="${name eq '김철수'}">김철수 입니다.</c:when>
		<c:when test="${name eq '박영희'}">박영희 입니다.</c:when>
		<c:otherwise>${name}</c:otherwise>
	</c:choose>
	
	<c:forEach var = "i" begin="0" end="10" step="2">
		<h1>${i}</h1>
	</c:forEach>
	
	<c:forEach var="names" items="${name}">
		<h1>${names}</h1>
	</c:forEach>
</body>
</html>