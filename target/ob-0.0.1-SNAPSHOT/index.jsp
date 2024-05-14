<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
	Spring Test Index
	</h3>
	<br>
<%-- 
	<a href="<%=request.getContextPath()%>/ajax/resBody.json"> JSON 응답
	</a>
	<br>
	<a href="<%=request.getContextPath()%>/ajax/resVOBody.json"> JSON
		VO 응답 </a>
	<br>
	<a href="<%=request.getContextPath()%>/ajax/resStringListBody.json">
		JSON List(문자열) 응답 </a> 
	<br />
--%>
	<a href="<%=request.getContextPath()%>/ajax/resVOListBody.json"> JSON List(VO) 응답 </a>
	<br />
	<a href="<%=request.getContextPath()%>/test"> log4j2 Test?? </a>
	<br />
	<a href="<%=request.getContextPath()%>/bank/"> Sample Main page </a>
	<br />
	
</body>
</html>