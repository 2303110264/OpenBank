<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="row pb-4 sign-up">
            <%-- Start Contact Form --%>
            <div class="col-lg-8 sign-in-div">
                <form:form class="contact-form row sign-in-form" method="post" name="form" role="form" modelAttribute="openAcc">
                    <form:input path="customerId" type="hidden"/>
                    <form:input path="customerName" type="hidden"/>
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
                            <form:input path="accName" type="text" class="form-control form-control-lg light-300" id="accName" name="accName" placeholder="Account Name" value="통장 별명을 설정해주세요"/>
                            <label for="floatingname light-300">Account Name</label>
                            <form:errors path="accName" class="error"/>
                        </div>
                    </div>

                    <div class="col-lg-4 mb-4 sign-in-div2">
                        <div class="form-floating">
                            <input type="password" class="form-control form-control-lg light-300" id="password" name="password" placeholder="Account Password"/>
                            <label for="floatingname light-300">Account Password</label>
                        </div>
                    </div>
                    

                    <button type="submit" id="submitButton" class="btn sign-in-btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">상품 가입</button>
                </form:form>
            </div>
            <%-- End Contact Form --%>
        </div>