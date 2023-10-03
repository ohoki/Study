<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin: 0;
	}
	#nav{
		background-color: black;
		padding: 20px;
	}
	a{
		text-decoration: none;
		color: white;
		font-weight: bold;
	}
	ul{
		padding: 0 40px;
		margin : 0;
		display: flex;
		justify-content: space-between;
	}
	
</style>
</head>
<body>
	<div id="nav">
		<ul>
			<li><a href="main.do">홈으로</a></li>
			<li><a href="noticeList.do">게시물 목록 보기</a></li>
			<c:if test="${empty id }">
				<li><a href="memberJoin.do">회원가입</a></li>
			</c:if>
			<li><a href="memberList.do">멤버 목록 보기</a></li>
			<c:if test="${empty id }">
				<li><a href="memberLoginForm.do">로그인</a></li>
			</c:if>
			<c:if test="${not empty id }">
				<li><a href="#">로그아웃</a></li>
			</c:if>
			<c:if test="${not empty name }">
				<li><a href="#">${name}님 로그인</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>