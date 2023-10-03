<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
		.home-box {
			width: 70%;
			margin: 0 auto;
			text-align: center;
		}
	</style>
</head>
<body>
<div class="home-box">
	<h1>Hi, Hello~</h1>
	<img alt="짱구" src="${pageContext.request.contextPath}/resources/img/짱구 움짤.gif">
</div>
</body>
</html>
