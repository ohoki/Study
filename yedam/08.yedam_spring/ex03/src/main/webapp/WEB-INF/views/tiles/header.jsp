<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link href="${pageContext.request.contextPath}/resources/headers.css" rel="stylesheet">

<header>
  <div class="px-3 py-2 text-bg-dark border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
          <li>
            <a href="${pageContext.request.contextPath}/" class="nav-link text-secondary">Home</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/empList" class="nav-link text-white">사원 관리</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/deptList" class="nav-link text-white">부서 관리</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  
  <div class="px-3 py-2 border-bottom mb-3">
    <div class="container d-flex flex-wrap justify-content-center">
      <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto" role="search">
        <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
      </form>

      <div class="text-end">
        <button type="button" class="btn btn-light text-dark me-2">Login</button>
        <button type="button" class="btn btn-light text-dark me-2">Sign-up</button>
      </div>
    </div>
  </div>
</header>