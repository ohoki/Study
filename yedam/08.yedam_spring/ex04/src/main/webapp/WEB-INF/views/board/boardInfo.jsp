<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board info</title>
</head>
<body>
	<div>
		<h3>게시글 보기</h3>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<td>${board.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="contents" rows="3" cols="2"
					style="width: 100px;" readonly="readonly">${board.contents }</textarea></td>
		</tr>
		<tr>
			<th>첨부 이미지</th>
			<c:choose>
				<c:when test="${not empty board.image }">
					<td><img alt="첨부 이미지"
						src='<c:url value="/resources/${board.image}" />' width="240px"></td>
				</c:when>
				<c:otherwise>
					<td>파일 없음</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${board.regidate}"
					pattern="yyyy/MM/dd" /></td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
</body>
</html>