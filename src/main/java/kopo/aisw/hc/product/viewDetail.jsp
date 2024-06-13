<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
</head>
<body>
<h2>상품 상세정보</h2>
<table border="1">
    <tr>
        <th>상품 번호</th>
        <td>${product.productNum}</td>
    </tr>
    <tr>
        <th>상품명</th>
        <td>${product.productName}</td>
    </tr>
    <tr>
        <th>가입 대상</th>
        <td>${product.productTarget == 0 ? '개인' : '법인'}</td>
    </tr>
    <tr>
        <th>금리</th>
        <td>${product.interestRate}</td>
    </tr>
    <tr>
        <th>초기 가입금액</th>
        <td>${product.initialDeposit}</td>
    </tr>
    <tr>
        <th>가입 기간</th>
        <td>${product.dateOfDeposit}</td>
    </tr>
    <tr>
        <th>신규 가입 가능 여부</th>
        <td>${product.available == 1 ? '가능' : '불가능'}</td>
    </tr>
    <tr>
    	<td colspan="2" style="text-align:center;">
    		<input type="button" onclick="location.href='/ob/account/openAcc/${product.productNum}'" value="가입하기"/>
    	</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/product/view">목록으로</a>
<a href="${pageContext.request.contextPath}/">홈으로</a>
</body>
</html>
