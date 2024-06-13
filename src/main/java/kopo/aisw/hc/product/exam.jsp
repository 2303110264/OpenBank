<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ stats[0].PRODUCTNUM }
	<c:forEach var="stat" items="${stats}">
    	${stat['producNum']}
    	${stat['productName']}
    	${stat['subscriberCount']}
    	${stat['totalDeposit']}
    	${stat['totalWithdraw']}
    	${stat['newSubscribers']}
	</c:forEach>

</body>
</html>