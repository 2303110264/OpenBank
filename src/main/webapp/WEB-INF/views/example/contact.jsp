<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Purple Buzz - Contact Page</title>
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
원본 파일명: about.html
--%>
</head>
<body>
    <%-- Header --%>
    <jsp:include page="../header.jsp"></jsp:include>
    <%-- Close Header --%>
    
    
     <%-- Start Banner Hero --%>
    <section class="bg-light">
        <div class="container py-4">
            <div class="row align-items-center justify-content-between">
                <div class="contact-header col-lg-4">
                    <h1 class="h2 pb-3 text-primary">Contact</h1>
                    <h3 class="h4 regular-400">Elit, sed do eiusmod tempor</h3>
                    <p class="light-300">
                        Vector illustration is from <a rel="nofollow" href="https://storyset.com/" target="_blank">StorySet</a>.
                        Incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida.
                    </p>
                </div>
                <div class="contact-img col-lg-5 align-items-end col-md-4">
                    <img src="${path}/assets/img/banner-img-01.svg">
                </div>
            </div>
        </div>
    </section>
    <%-- End Banner Hero --%>


    <%-- Start Contact --%>
    <section class="container py-5">

        <h1 class="col-12 col-xl-8 h2 text-left text-primary pt-3">Create success campaign with us!</h1>
        <h2 class="col-12 col-xl-8 h4 text-left regular-400">Elit, sed do eiusmod tempor </h2>
        <p class="col-12 col-xl-8 text-left text-muted pb-5 light-300">
            Incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices
            gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. Laboris
            nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit
            in voluptate.
        </p>

        <div class="row pb-4">
            <div class="col-lg-4">

                <div class="contact row mb-4">
                    <div class="contact-icon col-lg-3 col-3">
                        <div class="py-3 mb-2 text-center border rounded text-secondary">
                            <i class='display-6 bx bx-news'></i>
                        </div>
                    </div>
                    <ul class="contact-info list-unstyled col-lg-9 col-9  light-300">
                        <li class="h5 mb-0">Media Contact</li>
                        <li class="text-muted">Mr. John Doe</li>
                        <li class="text-muted">010-020-0340</li>
                    </ul>
                </div>

                <div class="contact row mb-4">
                    <div class="contact-icon col-lg-3 col-3">
                        <div class="border py-3 mb-2 text-center border rounded text-secondary">
                            <i class='bx bx-laptop display-6' ></i>
                        </div>
                    </div>
                    <ul class="contact-info list-unstyled col-lg-9 col-9 light-300">
                        <li class="h5 mb-0">Technical Contact</li>
                        <li class="text-muted">Mr. John Stiles</li>
                        <li class="text-muted">010-020-0340</li>
                    </ul>
                </div>

                <div class="contact row mb-4">
                    <div class="contact-icon col-lg-3 col-3">
                        <div class="border py-3 mb-2 text-center border rounded text-secondary">
                            <i class='bx bx-money display-6'></i>
                        </div>
                    </div>
                    <ul class="contact-info list-unstyled col-lg-9 col-9 light-300">
                        <li class="h5 mb-0">Billing Contact</li>
                        <li class="text-muted">Mr. Richard Miles</li>
                        <li class="text-muted">010-020-0340</li>
                    </ul>
                </div>

            </div>


            <%-- Start Contact Form --%>
            <div class="col-lg-8 ">
                <form class="contact-form row" method="post" action="#" role="form">

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <input type="text" class="form-control form-control-lg light-300" id="floatingname" name="inputname" placeholder="Name">
                            <label for="floatingname light-300">Name</label>
                        </div>
                    </div><%-- End Input Name --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <input type="text" class="form-control form-control-lg light-300" id="floatingemail" name="inputemail" placeholder="Email">
                            <label for="floatingemail light-300">Email</label>
                        </div>
                    </div><%-- End Input Email --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <input type="text" class="form-control form-control-lg light-300" id="floatingphone" name="inputphone" placeholder="Phone">
                            <label for="floatingphone light-300">Phone</label>
                        </div>
                    </div><%-- End Input Phone --%>

                    <div class="col-lg-6 mb-4">
                        <div class="form-floating">
                            <input type="text" class="form-control form-control-lg light-300" id="floatingcompany" name="inputcompany" placeholder="Company Name">
                            <label for="floatingcompany light-300">Company Name</label>
                        </div>
                    </div><%-- End Input Company Name --%>

                    <div class="col-12">
                        <div class="form-floating mb-4">
                            <input type="text" class="form-control form-control-lg light-300" id="floatingsubject" name="inputsubject" placeholder="Subject">
                            <label for="floatingsubject light-300">Subject</label>
                        </div>
                    </div><%-- End Input Subject --%>

                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <textarea class="form-control light-300" rows="8" placeholder="Message" id="floatingtextarea"></textarea>
                            <label for="floatingtextarea light-300">Message</label>
                        </div>
                    </div><%-- End Textarea Message --%>

                    <div class="col-md-12 col-12 m-auto text-end">
                        <button type="submit" class="btn btn-secondary rounded-pill px-md-5 px-4 py-2 radius-0 text-light light-300">Send Message</button>
                    </div>

                </form>
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
    <script src="${path}/assets/js/custom.js"></script>
</body>
</html>