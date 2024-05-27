<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<!-- Spring 폼 태그 사용!! -->
<h2>상품 등록</h2>

<form:form modelAttribute="p" action="${pageContext.request.contextPath}/register" method="post">
    <form:hidden path="productNum"/>
    
    <form:label path="productTarget">가입 대상:</form:label>
    <form:radiobutton path="productTarget" value="0" label="개인"/>
    <form:radiobutton path="productTarget" value="1" label="법인"/><br/>
    
    <form:label path="productName">상품명:</form:label>
    <form:input path="productName" /><br/>
    
    <form:label path="description">상품 설명:</form:label>
    <form:textarea path="description" /><br/>
    
    <form:label path="interestRate">금리:</form:label>
    <form:input path="interestRate" /><br/>
    
    <form:label path="initialDeposit">초기 가입금액:</form:label>
    <form:input path="initialDeposit" /><br/>
    
    <form:label path="dateOfDeposit">가입 기간:</form:label>
    <form:input path="dateOfDeposit" /><br/>
    
    <form:label path="available">신규 가입 가능 여부:</form:label>
    <form:radiobutton path="available" value="1" label="가능"/>
    <form:radiobutton path="available" value="0" label="불가능"/><br/>
    
    <input type="submit" value="상품 등록"/>
</form:form>

</body>
</html>