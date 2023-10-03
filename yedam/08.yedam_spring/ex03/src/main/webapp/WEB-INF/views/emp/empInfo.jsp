<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
	body {
		text-align: center;
	}
</style>
</head>
<body>
	<form action="empUpdate" method="post">
		<div>
			<label>id : <input type="number" name="employeeId" value="${empInfo.employeeId }" readonly="readonly"></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName }"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName" value="${empInfo.lastName }"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email" value="${empInfo.email }"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId" value="${empInfo.jobId }"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary" value="${empInfo.salary }"></label>
		</div>
		<button type="submit" class="btn btn-secondary mt-3">수정</button>
		<button type="button" class="btn btn-secondary mt-3">취소</button>
	</form> 
	<script>
		//1) form 태그의 submit 이벤트 stop
		$('form').on('submit', ajaxUpdateEmp);
		
		//2) form 태그 내의 정보를 가져옴
		function serializeObject() {
			let formData = $('form').serializeArray();
			
			let objectData = {};
			$.each(formData, function(idx, obj){
				objectData[obj.name] = obj.value;
			});
			
			return objectData;
		}	
		//3) ajax를 통해 통신을 요청함
		function ajaxUpdateEmp(e) {
			e.preventDefault();
			
			let object = serializeObject();
			$.ajax({
				url : 'empUpdate',
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(object)
			})
			.done( data => {
				if(data != null && data['결과'] == 'Success') {
					alert('사원번호 : ' + data['사원번호'] + '의 정보가 수정되었습니다.');
				} else {
					alert('해당 사원의 정보가 정상적으로 수정되지 않았습니다.');
				}
			})
			.fail( reject => console.log(reject));
		};
		
	</script>
</body>
</html>