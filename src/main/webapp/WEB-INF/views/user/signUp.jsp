<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenBank</title>
</head>
<link rel="stylesheet" href="${path}/css/styles.css" />
<script src="${path}/js/scripts.js"></script>
<style>
	.error{
		color:red;
		font-size:14px;
		font-weight: bold;
	}
</style>
<body>

<div class="app-container">
  <jsp:include page="../header2.jsp"/>
  <div class="app-content">
 	<%@include file="../sidebar.jsp" %>
 	<div class="projects-section">
 	<div class="projects-section-header">
        <p>Accounts</p>
        </div>
        <div class="form-box">
	    <div class="form-wrapper">
		    <form:form method="post" modelAttribute="m">
	        <table style="width:100%">
					<tr>
						<th width="20%">아이디</th>
						<td>
					        <form:input path="userId" class="login-form-input" type="text" placeholder="아이디" style="text-transform: lowercase;"/>
							<%-- == getter 
							<form:input path="title"/>
							<form:errors path="title" class="error"/>
							--%>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><form:input path="password" class="login-form-input" type="password" placeholder="비밀번호"/>
							<form:errors path="password" class="error"/>
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><form:input path="name" class="login-form-input" type="text" placeholder="이름"/></td>
					</tr>
				</table>
	           <button type="submit">회원가입</button>
			</form:form>
	      </div>
    </div>
   	<div class="app-header-right">
   
 	</div>
</div>
</div>
</div>
</body>
</html>