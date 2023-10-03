<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/resources/headers.css" rel="stylesheet">
    
    
<div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath }/" class="nav-link active" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardList" class="nav-link">게시판</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardInsert" class="nav-link">게시글 등록</a></li>
      </ul>
    </header>
 </div>