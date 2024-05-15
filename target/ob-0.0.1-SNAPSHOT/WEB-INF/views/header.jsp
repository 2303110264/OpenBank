<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="app-header">
    <div class="app-header-left">
      	<span class="app-icon">
      	</span>
     	<p class="app-name">
	     <a href="<%=request.getContextPath() %>/">
	     	Maybe Open Bank.
	     </a>
	   	</p>
      <div class="search-wrapper">
        <input class="search-input" type="text" placeholder="Search">
        
          <!-- [검색창 돋보기 버튼]
           -->
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-search" viewBox="0 0 24 24">
           <circle cx="11" cy="11" r="8"></circle>
          <path d="M21 21l-4.35-4.35"></path>
        </svg>
           
      </div>
    </div>
    <div class="app-header-right">
      <!-- [다크모드 - 버튼(클래스) 외 교체해도 무관할 것 같음] --mode-switch 1개 지우면 나머지도 작동안됨
       -->
      <button class="mode-switch" title="Switch Theme">
        <svg class="moon" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" width="24" height="24" viewBox="0 0 24 24">
          <defs></defs>
          <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z"></path>
        </svg>
      </button>
       
       <!-- [추가 버튼] -아무런 트리거도 걸려있지 않음.
      <button class="add-btn" title="Add New Project">
        <svg class="btn-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
          <line x1="12" y1="5" x2="12" y2="19" />
          <line x1="5" y1="12" x2="19" y2="12" />
        </svg>
      </button>
        -->
        
       <!-- [알림 버튼] -역시 모양만 있음
      <button class="notification-btn">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell">
          <path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9" />
          <path d="M13.73 21a2 2 0 0 1-3.46 0" />
        </svg>
      </button>
        -->
        
        <!-- [우상단 프로필] -->
        <!-- link 단위로 가면됨 -->
      <button class="profile-btn" onclick='location.href="/ob/user/signUp"'>
        <img src="https://assets.codepen.io/3306515/IMG_2025.jpg" />
        <span>우상단프로필</span>
      </button>
    </div>
    
    
    	<!-- [뭐야 이건]
    	 -->
    <button class="messages-btn"> 얜 뭐야대체 왜 화면 좁아지면 나오는건데
      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-message-circle">
        <path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z" />
      </svg>
    </button>
  </div>