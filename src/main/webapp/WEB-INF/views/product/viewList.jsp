<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
<h2>상품 목록</h2>
<table border="1">
    <tr>
        <th>상품 번호</th>
        <th>상품명</th>
        <th>가입 대상</th>
        <th>금리</th>
        <th>초기 가입금액</th>
        <th>가입 기간</th>
        <th>신규 가입 가능 여부</th>
        <th>상세보기</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productNum}</td>
            <td>${product.productName}</td>
            <td>${product.productTarget == 0 ? '개인' : '법인'}</td>
            <td>${product.interestRate}</td>
            <td>${product.initialDeposit}</td>
            <td>${product.dateOfDeposit}</td>
            <td>${product.available == 1 ? '가능' : '불가능'}</td>
            <td><a href="${pageContext.request.contextPath}/product/view/${product.productNum}">상세보기</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/">홈으로</a>
</body>
</html>
