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
	<title>Sign Up</title>
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

        <h1 class="col-12 col-xl-8 h2 text-primary pt-3 margin-auto">Welcome!</h1>
        <h2 class="col-12 col-xl-8 h4 regular-400 margin-auto">ID랑 PW는 왜 말썽인가.</h2>
        <p class="col-12 col-xl-8 text-muted pb-5 light-300 margin-auto">
            헤더랑 푸터를 날릴지 고민중
        </p>

        <div class="row pb-4 sign-up">

            <%-- Start Contact Form --%>
            <div class="col-lg-8 ">
                <form:form class="contact-form row" method="post" name="form" role="form" modelAttribute="m">

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="userId" type="text" class="form-control form-control-lg light-300" id="floatingID" name="userId" placeholder="ID"/>
                            <label for="floatingID light-300">ID</label>
                            <form:errors path="userId" class="error"/>
                        </div>
                    </div><%-- End Input userId --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="password" type="password" class="form-control form-control-lg light-300" id="floatingPassword" name="password" placeholder="Password"/>
                            <label for="floatingPassword light-300">Password</label>
                            <form:errors path="password" class="error"/>
                        </div>
                    </div><%-- End Input Password --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="name" type="text" class="form-control form-control-lg light-300" id="floatingname" name="name" placeholder="Name"/>
                            <label for="floatingname light-300">Name</label>
                            <form:errors path="name" class="error"/>
                        </div>
                    </div><%-- End Input Name --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="email" type="text" class="form-control form-control-lg light-300" id="floatingmail" name="email" placeholder="Phone"/>
                            <label for="floatingmail light-300">Email</label>
                            <form:errors path="email" class="error"/>
                        </div>
                    </div><%-- End Input Email --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="phoneNum" type="text" class="form-control form-control-lg light-300" id="phoneNum" name="phoneNum" placeholder="phoneNum"/>
                            <label for="floatingPhone light-300">Phone</label>
                            <form:errors path="phoneNum" class="error"/>
                        </div>
                    </div><%-- End Input phoneNum --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <form:input path="rrn" type="text" class="form-control form-control-lg light-300" id="rrn" name="rrn" placeholder="rrn"/>
                            <label for="floatingRrn light-300">RRN</label>
                            <form:errors path="rrn" class="error"/>
                        </div>
                    </div><%-- End Input phoneNum --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                        	<input type="hidden" id="confmKey" name="confmKey" value=""  >
                            <form:input  path="zipCode" type="text" class="form-control form-control-lg light-300" id="zipNo" name="zipNo" readonly="true" placeholder="zipCode"/>
                            <label for="floatingZip light-300">Zip code</label>
                            <form:errors path="zipCode" class="error"/>
                        </div>
                    </div><%-- End Input zipCode --%>

                    <div class="col-12">
                        <div class="form-floating mb-4">
                            <form:input path="address" type="text" class="form-control form-control-lg light-300" id="roadAddrPart1" name="roadAddrPart1" placeholder="address"/>
                            <label for="floatingAddress light-300">Address</label>
                        </div>
                    </div><%-- End Input Address --%>
                    <div class="col-12">
                        <div class="form-floating mb-4">
                            <form:input path="addressDetail" type="text" class="form-control form-control-lg light-300" id="addrDetail" name="addrDetail" placeholder="address detail"/>
                            <label for="floatingAddress light-300">Address detail</label>
                        </div>
                    </div><%-- End Input Address Detail --%>

                    <div class="col-md-12 col-12 m-auto text-center">
                        <button type="submit" class="btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">Sign Up</button>
                    </div>

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
	<script src="${path}/assets/js/custom.js"></script>
	<%-- Bootstrap --%>
    <script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
    <%-- Templatemo --%>
    <script src="${path}/assets/js/templatemo.js"></script>
    
</body>
</html>