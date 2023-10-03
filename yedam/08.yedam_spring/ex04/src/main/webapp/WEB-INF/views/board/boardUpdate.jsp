<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board update</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<form name="updateForm">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" value="${boardInfo.bno }" name="bno" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="${boardInfo.title }" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" value="${boardInfo.writer}" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" rows="3" cols="2" style="width : 300px">${boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부 이미지</th>
				<c:choose>
					<c:when test="${not empty boardInfo.image }">
						<td><input type="text" value="${boardInfo.image}" name="image"></td>
					</c:when>
					<c:otherwise>
						<td><input type="text" name="image"></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>수정일자</th>
				<td><input type="date" name="updatedate" value='<fmt:formatDate value="${boardInfo.regidate}" pattern="yyyy-MM-dd" />'></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='boardInfo?bno=${boardInfo.bno}'">취소</button>
	</form>
	<script>
		$('form').on('submit', function(e) {
			let objData = serializeObject();
			
			$.ajax({
				url : 'boardUpdate',
				method : 'post',
				data : objData 
			})
			.done(data => {
				if(data.result) {
					let message = '수정되었습니다.\n사원번호 : ' + data.boardInfo.bno;
					alert(message);
				}else {
					alert('수정되지 않았습니다. \n 정보를 다시 확인해 주세요.');
				}
			})
			.fail(reject => {
				console.log(reject);
			});
			return false;
		});
		
		//serializeArray() => form태그에만 사용가능
		function serializeObject() {
			let formData = $('form').serializeArray();
			// [ {name : 'title', value : 'Hello'}, {name : 'writer', value : '여행자'}, ...]
			
			let formObject = {};
			$.each(formData, function(idx, obj) {
				let field = obj.name;
				let val = obj.value;
				
				formObject[field] = val;
			});
			
			return formObject;
		}
	</script>
</body>
</html>