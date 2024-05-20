<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="nav-down" style="background:black;">
	<nav id="main_nav" class="navbar navbar-expand-lg navbar-light bg-white shadow">
	        <div class="container d-flex justify-content-between align-items-center">
	            <a class="navbar-brand h1" href="index">
	                <i class='bx bx-money bx-sm text-dark'></i>
	                <span class="text-dark h4">Open</span> <span class="text-primary h4">bank</span>
	            </a>
	            <button class="navbar-toggler border-0 " type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler-success" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	
	            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="navbar-toggler-success">
	                <div class="flex-fill mx-xl-5 mb-2">
	                    <ul class="nav navbar-nav d-flex justify-content-between mx-xl-5 text-center text-dark">
	                        <li class="nav-item">
	                            <a class="nav-link btn-outline-primary rounded-pill px-3" href="${path}/ob/bank/">Home</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link btn-outline-primary rounded-pill px-3" href="${path}/ob/about">모아보기(About)</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link btn-outline-primary rounded-pill px-3" href="${path}/ob/work">이체(Work)</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link btn-outline-primary rounded-pill px-3" href="${path}/ob/pricing">상품가입(Pricing)</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link btn-outline-primary rounded-pill px-3" href="${path}/ob/contact">고객센터(Contact)</a>
	                        </li>
	                    </ul>
	                </div>
	                <div class="navbar align-self-center d-flex">
	                    <a class="nav-link" href="#"><i class='bx bx-bell bx-sm bx-tada-hover text-primary'></i></a>
	                    <a class="nav-link" href="#"><i class='bx bx-cog bx-sm text-primary'></i></a>
	                    <a class="nav-link" href="${path}/ob/member/signUp"><i class='bx bx-user-circle bx-sm text-primary'></i></a>
	                </div>
	            </div>
	        </div>
	 </nav>
</header>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	var didScroll;
	var lastScrollTop = 0;
	var delta = 5;
	var navbarHeight = $('header').outerHeight();
	
	$(window).scroll(function(event){
	    didScroll = true;
	});
	
	setInterval(function() {
	    if (didScroll) {
	        hasScrolled();
	        didScroll = false;
	    }
	}, 250);
	
	function hasScrolled() {
	    var st = $(this).scrollTop();
	    
	    // Make sure they scroll more than delta
	    if(Math.abs(lastScrollTop - st) <= delta)
	        return;
	    
	    // If they scrolled down and are past the navbar, add class .nav-up.
	    // This is necessary so you never see what is "behind" the navbar.
	    if (st > lastScrollTop && st > navbarHeight){
	        // Scroll Down
	        $('header').removeClass('nav-down').addClass('nav-up');
	    } else {
	        // Scroll Up
	        if(st + $(window).height() < $(document).height()) {
	            $('header').removeClass('nav-up').addClass('nav-down');
	        }
	    }
	    
	    lastScrollTop = st;
	}
</script>