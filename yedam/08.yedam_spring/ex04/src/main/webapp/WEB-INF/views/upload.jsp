<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<div>
		<input name="uploadFiles" type="file" multiple>
		<button class="uploadBtn">Upload</button>
	</div>
	<script>
		//자바 스크립트 -> 파일을 ajax로 넘기기가 쉽지가 않음 (formData)
		document.querySelector('.uploadBtn')
		        .addEventListener('click', function(e) {
		        	let formData = new FormData();
		        	
		        	let inputTag = document.querySelector('input[name="uploadFiles"]');
		        	
		        	let files = inputTag.files;
		        	
		        	for(let i=0; i<files.length; i++) {
		        		console.log(files[i]);
		        		formData.append("uploadFiles", files[i]);
		        	}
		        	
/* 		        	fetch('uploadsAjax', {
		        		method : 'post',
		        		body : formData
		        	})
		        	.then(response => response.json())
		        	.then(data => console.log(data))
		        	.catch(err => console.log(err));
 */		        	

		        	//jQuery.ajax
		            $.ajax({
		                url: 'uploadsAjax',	
		                type: 'POST',
		                processData: false,	//기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다.
		                contentType: false,	// multipart/form-data타입을 사용하기위해 false 로 지정합니다.
		                data: formData,               
		                success: function(result){
		                    for(let images of result) {
		                    	let path = '${pageContext.request.contextPath}/images/' + result;
		                    	let imgTag = $('<img/>').prop('src', path);
		                    	$('div').append(imgTag);
		                    }
		                },
		                error: function(reject){	
		                    console.log(reject);
		                }
		            }); 
		        });
	</script>
</body>
</html>