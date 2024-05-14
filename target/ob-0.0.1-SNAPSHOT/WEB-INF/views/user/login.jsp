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
<body>

<div class="app-container">
  <jsp:include page="../header2.jsp"/>
  <div class="app-content">
	  <%@include file="../sidebar.jsp" %>
    
    화면 표시 테스트<br/>
    <div class="login-form-wrapper">
	    <form:form method="post" modelAttribute="m">
        <table border="1" style="width:80%">
				<tr>
					<th width="25%">아이디</th>
					<td>
				        <form:input path="id" class="login-form-input" type="text" placeholder="아이디" style="text-transform: lowercase;"/>
						<!-- == getter -->
						<form:input path="title"/>
						<form:errors path="title" class="error"/>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><form:input path="writer"/>
						<form:errors path="writer" class="error"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><form:textarea path="content" rows="7" cols="60"/></td>
				</tr>
			</table>
           <button type="submit">등록</button>
		</form:form>
      </div>
    </div>
    <div class="app-header-right">
    
	 </div>
</div>
</body>
</html>