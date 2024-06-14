<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Detail</title>
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
	th{
		background-color:#9396e8;
		color:white;
		text-align:center;
	}
	table{
		width:100%;
	}
</style>
<body>
    <%-- Header --%>
    <jsp:include page="../header.jsp"></jsp:include>
    <%-- Close Header --%>
    

    <!-- Start Work Sigle -->
    <section class="container py-5">
		<div class="row pt-5">
	            <div class="worksingle-content col-lg-8 m-auto text-left justify-content-center">
	                <h2 class="worksingle-heading h3 pb-3 light-300 typo-space-line">${account.accName }</h2>
	                <p class="worksingle-footer py-3 text-muted light-300">
	                	<table border="0" style="width:100%;">
			    <tr>
			        <th width=20%>계좌번호</th>
			        <td>${account.accNum}</td>
			    </tr>
			    <tr>
			        <th>잔액</th>
			        <td>${String.format("%,d", account.balance)}원</td>
			    </tr>
			    <tr>
			        <th>가입일</th>
			        <td>${account.regDate}</td>
			    </tr>
			    <tr>
			        <th>만료일</th>
			        <td>${account.retDate}</td>
			    </tr>
			    <%-- 
			    <tr>
			        <th>최근 거래일</th>
			        <td>${account.lastTradeDate}</td>
			    </tr>
			     --%>
		        <tr>
		            <!-- 
		             <td>${product.productTarget == 0 ? '개인' : '법인'}</td>
		             -->
		        </tr>
			</table>	
	                	
	                		
	                </p>
	            </div>
	        </div>
<%--
accNum,acc_name accName,
		product_num productNum, balance,
		to_char(reg_date, 'yyyy-mm-dd') regDate,
		to_char(ret_date, 'yyyy-mm-dd') retDate,
		to_char(last_trade_date, 'yyyy-mm-dd') lastTradeDate
 --%>
       <div class="row pt-5">
           <div class="worksingle-content col-lg-8 m-auto text-left justify-content-center">
			<table border="0">
			    <tr>
			        <th >거래일자</th>
			        <%-- 
			        <th >거래유형</th>
			         --%>
			        <th >거래명</th>
			        <th >입금 금액</th>
			        <th >출금 금액</th>
			        <th >잔액</th>
			    </tr>
			    <c:forEach var="t" items="${transaction}">
			        <tr>
			            <td>${t.transactionDate}</td>
			            <%--
			            <td>${t.transactionType}</td>
			             --%>

			            <td>${t.withdrawName}</td>
			        <c:if test="${ t.transactionType.equals('입금')}">
			            <td>${String.format("%,d", t.amount)}</td>
			            <td></td>
			        </c:if>
			        <c:if test="${ t.transactionType.equals('출금')}">
			            <td></td>
			            <td>${String.format("%,d", t.amount)}</td>
			        </c:if>
						<td>${String.format("%,d", t.WAfterBalance)}</td>
			        </tr>
			    </c:forEach>	
			</table>	
        </div><!-- End Blog Cover -->
	</div>

    </section>
    
    <!-- End Work Sigle -->

<%--
    <!-- Start Related Post -->
    <article class="container-fluid bg-light">
        <div class="container">
            <div class="worksingle-related-header row">
                <h1 class="h2 py-5">Related Post</h1>
                <div class="col-md-12 text-left justify-content-center">
                    <div class="row gx-5">


                        <div class="col-sm-6 col-lg-4 mb-5">
                            <a href="#" class="related-content card text-decoration-none overflow-hidden h-100">
                                <img class="related-img card-img-top" src="${path}/assets/img/related-post-01.jpg" alt="Card image cap">
                                <div class="related-body card-body p-4">
                                    <h5 class="card-title h6 m-0 semi-bold-600 text-dark">Digital Marketing</h5>
                                    <p class="card-text pt-2 mb-1 light-300 text-dark">
                                        Lorem ipsum dolor sit amet, consectetur.
                                    </p>
                                    <div class="d-flex justify-content-between">
                                        <span class="text-primary light-300">Read more</span>
                                        <div class="light-300">
                                            <i class='bx-fw bx bx-heart me-1'></i>5
                                            <i class='bx-fw bx bx-chat    ms-1 me-1'></i>3
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-6 col-lg-4 mb-5">
                            <a href="#" class="related-content card text-decoration-none overflow-hidden h-100">
                                <img class="related-img card-img-top" src="${path}/assets/img/related-post-02.jpg" alt="Card image cap">
                                <div class="related-body card-body p-4">
                                    <h5 class="card-title h6 m-0 semi-bold-600 text-dark">App Development</h5>
                                    <p class="card-text pt-2 mb-1 light-300 text-dark">
                                        Tempor incididunt ut labore et dolore.
                                    </p>
                                    <div class="d-flex justify-content-between">
                                        <span class="text-primary light-300">Read more</span>
                                        <div class="light-300">
                                            <i class='bx-fw bx bx-heart me-1'></i>11
                                            <i class='bx-fw bx bx-chat    ms-1 me-1'></i>9
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-6 col-lg-4 mb-5">
                            <a href="#" class="related-content card text-decoration-none overflow-hidden h-100">
                                <img class="related-img card-img-top" src="${path}/assets/img/related-post-03.jpg" alt="Card image cap">
                                <div class="related-body card-body p-4">
                                    <h5 class="card-title h6 m-0 semi-bold-600 text-dark">Digital Marketing</h5>
                                    <p class="card-text pt-2 mb-1 light-300 text-dark">
                                        Consectetur adipiscing elit.
                                    </p>
                                    <div class="d-flex justify-content-between">
                                        <span class="text-primary light-300">Read more</span>
                                        <div class="light-300">
                                            <i class='bx-fw bx bx-heart me-1'></i>31
                                            <i class='bx-fw bx bx-chat    ms-1 me-1'></i>2
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

    </article>
    <!-- End Related Post -->
 --%>
    
    
    <%-- Start Footer --%>
    <jsp:include page="../footer.jsp"></jsp:include>
    <%-- End Footer --%>
    
    
    <%-- Bootstrap --%>
    <script src="${path}/assets/js/bootstrap.bundle.min.js"></script>
    <%-- Templatemo --%>
    <script src="${path}/assets/js/templatemo.js"></script>
    <%-- Custom --%>
    <script src="${path}/assets/js/custom.js"></script>
    <%-- Load jQuery require for isotope --%>
    <script src="${path}/assets/js/jquery.min.js"></script>
    <%-- Page Script --%>
    <script>
        $(window).load(function() {
            // Slide
            $('.templatemo-slide-link').click(function() {
                var this_href = $(this).attr('href');
                $('#templatemo-slide-link-target img').attr('src', this_href);
                return false;
            });
            // End Slide
        });
    </script>

</body>

</html>