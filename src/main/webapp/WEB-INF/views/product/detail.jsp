<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <td>${p.productNum}</td>
    </tr>
    <tr>
        <th>가입 대상</th>
        <td>${p.productTarget == 0 ? '개인' : '법인'}</td>
    </tr>
    <tr>
        <th>상품명</th>
        <td>${p.productName}</td>
    </tr>
    <tr>
        <th>상품 설명</th>
        <td>${p.description}</td>
    </tr>
    <tr>
        <th>금리</th>
        <td>${p.interestRate}</td>
    </tr>
    <tr>
        <th>초기 가입금액</th>
        <td>${p.initialDeposit}</td>
    </tr>
    <tr>
        <th>가입 기간</th>
        <td>${p.dateOfDeposit}</td>
    </tr>
    <tr>
        <th>신규 가입 가능 여부</th>
        <td>${p.available == 1 ? '가능' : '불가능'}</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/product/list">목록으로</a>
</body>
</html>
