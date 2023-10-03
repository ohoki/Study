<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>구구단</h1></div>
		<div>
			<%
				for(int i=1; i<10; i++) { %>
					2 * <%= i %> = <%=2*i %><br>
			<% 	} %>
		</div>
	</div>
</body>
</html>