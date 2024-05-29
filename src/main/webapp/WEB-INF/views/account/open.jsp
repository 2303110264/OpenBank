<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<%-- 
    <title>Purple Buzz HTML Template with Bootstrap 5 Beta 1</title>
 --%>
	<title>Open An Account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="${path}/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${path}/assets/img/favicon.ico">
    <%-- Load Require CSS --%>
    <link href="${path}/assets/css/bootstrap.min.css" rel="stylesheet">
    <%-- Font CSS --%>
    <link href="${path}/assets/css/boxicon.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
    <%-- Load Tempalte CSS --%>
    <link rel="stylesheet" href="${path}/assets/css/templatemo.css">
    <%-- Custom CSS --%>
    <link rel="stylesheet" href="${path}/assets/css/custom.css">
<!--
	원본 템플릿:
	TemplateMo 561 Purple Buzz
	https://templatemo.com/tm-561-purple-buzz
-->
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<%-- Start Contact --%>
    <section class="container py-5 text-center">
        <h1 class="col-12 col-xl-8 h2 text-primary pt-3 margin-auto">
        상품 가입 페이지
		<a class="navbar-brand" href="${path}/bank/">
		</a>
        </h1>
        <h2 class="col-12 col-xl-8 h4 regular-400 margin-auto">${product.interestRate}%</h2>
        <p class="col-12 col-xl-8 text-muted pb-5 light-300 margin-auto">
            ${product.description}
        </p>

        <div class="row pb-4 sign-up">

            <%-- Start Contact Form --%>
            <div class="col-lg-8 sign-in-div">
                <form:form class="contact-form row sign-in-form" method="post" name="form" role="form" modelAttribute="openAcc">

                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <div class="form-control form-control-lg light-300">${product.productName}</div>
                            <label for="floatingPassword light-300">Product name</label>
                        </div>
                    </div><%-- 표시용 --%>

                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <div class="form-control form-control-lg light-300">${openAcc.customerName}</div>
                            <label for="floatingPassword light-300">Customer name</label>
                        </div>
                    </div><%-- 표시용 --%>

                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <form:input path="accName" type="text" class="form-control form-control-lg light-300" id="accName" name="accName" placeholder="Account Name"/>
                            <label for="floatingname light-300">Account Name</label>
                            <form:errors path="accName" class="error"/>
                        </div>
                    </div>

                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <input path="password" type="password" class="form-control form-control-lg light-300" id="password" name="password" placeholder="password"/>
                            <label for="floatingname light-300">Password</label>
                        </div>
                    </div>
<%--
                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="name" type="text" class="form-control form-control-lg light-300" id="floatingname" name="name" placeholder="Name"/>
                            <label for="floatingname light-300">Name</label>
                            <form:errors path="name" class="error"/>
                            <c:if test="${humanDuplicationCheck}">
                            	<br/><span class='error'>이미 등록된 회원입니다.</span>
                            </c:if>
                        </div>
                    </div>
 --%>
					<button type="submit" class="btn sign-in-btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">상품 가입</button>

                </form:form>
            </div>
            <%-- End Contact Form --%>

        </div>
    </section>
    <%-- End Contact --%>

	
	<%-- Start Footer --%>
    <jsp:include page="../footer.jsp"></jsp:include>
    <%-- End Footer --%>
	
	<%-- Custom --%>
	<script>
	    var accmsg = ${openAnAcc}
	</script>
	<script src="${path}/assets/js/custom.js"></script>
	<%-- Bootstrap --%>
    <script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
    <%-- Templatemo --%>
    <script src="${path}/assets/js/templatemo.js"></script>
</body>
</html>