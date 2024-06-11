<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer</title>
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
<%--
원본 파일명: index.html
--%>
</head>
<style>
	.error {
	    color: red;
	}
</style>
<body>
    <%-- Header --%>
    <jsp:include page="../header.jsp"></jsp:include>
    <%-- Close Header --%>
    
    <%-- Start Contact --%>
    <section class="container py-5 text-center">
        <h1 class="col-12 col-xl-8 h2 text-primary pt-3 margin-auto">
		<a class="navbar-brand" href="${path}/bank/">
        Transfer
		</a>
        </h1>
        <h2 class="col-12 col-xl-8 h4 regular-400 margin-auto">계좌 이체</h2>
        <p class="col-12 col-xl-8 text-muted pb-5 light-300 margin-auto">
            
        </p>

        <div class="row pb-4 sign-up">

            <%-- Start Contact Form --%>
            <div class="col-lg-8 sign-in-div">
                <form:form class="contact-form row sign-in-form" method="POST" action="/ob/transaction/transfer" id="form" name="form" role="form" modelAttribute="t">
                    <!-- 응답테스트 -->
                    <form:input path="withdrawName" id="wName" type="hidden"/>
                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <form:select path="withdrawAcc" type="text" class="form-control form-control-lg light-300 formSelect" id="wAcc" name="withdrawAcc" placeholder="withdraw Account" required="true">
                            	<c:forEach items="${accList}" var="a">
                            		<form:option value="${a.accNum}">${a.accName}(${a.accNum})</form:option>
                            	</c:forEach>
                            </form:select>
                            <label for="floatingID light-300">출금할 계좌</label>
                            <form:errors path="withdrawName" class="error"/>
                        </div>
                    </div>
                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <form:input path="depositAcc" type="text" class="formSelect form-control form-control-lg light-300 " id="dAcc" name="depositAcc" placeholder="deposit Account" required="true"/>
                            <label for="floatingPassword light-300">입금될 계좌</label>
                            <form:errors path="depositAcc" class="error"/>
                            <span id="accErr" class="error"></span>
                        </div>
                    </div>
                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <form:input path="amount" type="text" class="form-control form-control-lg light-300 " id="amt" name="amount" placeholder="Amount" required="true"/>
                            <label for="floatingPassword light-300">금액</label>
                            <form:errors path="amount" class="error"/>
                        </div>
                    </div>
                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <form:input path="depositName" type="text" class="form-control form-control-lg light-300 " id="dName" name="depositName" placeholder="Name" value="${userVO.name }"/>
                            <label for="floatingPassword light-300">보내는 사람 이름</label>
                            <form:errors path="depositName" class="error"/>
                        </div>
                    </div>
					
					
                    <div class="col-md-12 col-12 m-auto text-center">
                        <button type="submit" class="btn sign-in-btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">송금하기</button>
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
    
    
    <%-- Bootstrap --%>
    <script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
    <%-- Templatemo --%>
    <script src="${path}/assets/js/templatemo.js"></script>
    <%-- Custom --%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${path}/assets/js/custom.js"></script>
	<script>
		var ready = false;
	$(document).ready(function() {
		$('#dAcc').on('change', function(){ 
			ready=false
		})
		$('#form').on('submit', function(event) {
			if(!ready){
		    	event.preventDefault();
		
		        var dAcc = $('#dAcc').val();
		        var wAcc = $('#wAcc').val();
		
		        if (wAcc == dAcc) {
		            $('#accErr').text('동일한 계좌끼리는 이체할 수 없습니다.');
		        } else{
			            $.ajax({
			                type: 'GET',
			                url: '/ob/account/accCheck',
			                data: { accNum: dAcc },
			                success: function(result) {
			                    $('#wName').val(result);
			                    ready=true;
			                    console.log(ready)
			                    return true;
			                },
			                error: function(error) {
			                    $('#accErr').text('존재하지 않는 계좌입니다.');
			                    console.error(error);
			                }
			            });
        		}
			}
	    });
	});
	</script>
    <%-- Load jQuery require for isotope --%>
    <script src="${path}/assets/js/jquery.min.js"></script>
    <%-- Isotope --%>
    <script src="${path}/assets/js/isotope.pkgd.js"></script>
	<script>
		document.getElementById("dAcc").value = "";
	</script>
</body>

</html>