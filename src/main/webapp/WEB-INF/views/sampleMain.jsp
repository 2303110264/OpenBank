<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenBank</title>
</head>
<link rel="stylesheet" href="${path}/css/styles.css" />
<script src="${path}/js/scripts.js"></script>
<body>

<div class="app-container">
  <%@include file="header.jsp" %>
  <div class="app-content">
	  <%@include file="sidebar.jsp" %>
    
	
	<!-- Accounts 섹션 헤더 -->    
    <div class="projects-section">
      <div class="projects-section-header">
        <p>Accounts</p>
        
        <!-- 날짜 불러오기?
         <p class="time">December, 12</p> 
         -->
        
        <!-- view 버튼 2종 -->
        <div class="view-actions">
          <button class="view-btn list-view" title="List View">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-list">
              <line x1="8" y1="6" x2="21" y2="6" />
              <line x1="8" y1="12" x2="21" y2="12" />
              <line x1="8" y1="18" x2="21" y2="18" />
              <line x1="3" y1="6" x2="3.01" y2="6" />
              <line x1="3" y1="12" x2="3.01" y2="12" />
              <line x1="3" y1="18" x2="3.01" y2="18" />
            </svg>
          </button>
          <button class="view-btn grid-view active" title="Grid View">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid">
              <rect x="3" y="3" width="7" height="7" />
              <rect x="14" y="3" width="7" height="7" />
              <rect x="14" y="14" width="7" height="7" />
              <rect x="3" y="14" width="7" height="7" />
            </svg>
          </button>
        </div>
      </div>
      
      <!-- 
      <div class="projects-section-line">
        <div class="projects-status">
          <div class="item-status">
            <span class="status-number">45</span>
            <span class="status-type">In Progress</span>
          </div>
          <div class="item-status">
            <span class="status-number">24</span>
            <span class="status-type">Upcoming</span>
          </div>
          <div class="item-status">
            <span class="status-number">62</span>
            <span class="status-type">Total Projects</span>
          </div>
        </div>
        
      </div>
       -->
      
      
      <div class="project-boxes jsGridView">
      
      <!-- Account 섹션 바디 -->
        <div class="project-box-wrapper">
          <div class="project-box" style="background-color: #fee4cb;">
            <div class="project-box-header">
              <span>December 10, 2020</span>
              <div class="more-wrapper">
                <button class="project-btn-more">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                    <circle cx="12" cy="12" r="1" />
                    <circle cx="12" cy="5" r="1" />
                    <circle cx="12" cy="19" r="1" />
                  </svg>
                </button>
              </div>
            </div>
            <div class="project-box-content-header">
              <p class="box-content-header">SAMPLE 1</p>
              <p class="box-content-subheader">sample text</p>
            </div>
            <div class="box-progress-wrapper">
              <p class="box-progress-header">Progress</p>
              <div class="box-progress-bar">
                <span class="box-progress" style="width: 60%; background-color: #ff942e"></span>
              </div>
              <p class="box-progress-percentage">60%</p>
            </div>
            <div class="project-box-footer">
              <div class="participants">
                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80" alt="participant">
                <img src="https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTB8fG1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60" alt="participant">
                <button class="add-participant" style="color: #ff942e;">
                  <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
                    <path d="M12 5v14M5 12h14" />
                  </svg>
                </button>
              </div>
              <div class="days-left" style="color: #ff942e;">
                2 Days Left
              </div>
            </div>
          </div>
        </div>
        
        
        <div class="project-box-wrapper">
          <div class="project-box" style="background-color: #e9e7fd;">
            <div class="project-box-header">
              <span>December 10, 2020</span>
              <div class="more-wrapper">
                <button class="project-btn-more">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                    <circle cx="12" cy="12" r="1" />
                    <circle cx="12" cy="5" r="1" />
                    <circle cx="12" cy="19" r="1" />
                  </svg>
                </button>
              </div>
            </div>
            <div class="project-box-content-header">
              <p class="box-content-header">SAMPLE 2</p>
              <p class="box-content-subheader">sample text</p>
            </div>
            <div class="box-progress-wrapper">
              <p class="box-progress-header">Progress</p>
              <div class="box-progress-bar">
                <span class="box-progress" style="width: 50%; background-color: #4f3ff0"></span>
              </div>
              <p class="box-progress-percentage">50%</p>
            </div>
            <div class="project-box-footer">
              <div class="participants">
                <img src="https://images.unsplash.com/photo-1596815064285-45ed8a9c0463?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1215&q=80" alt="participant">
                <img src="https://images.unsplash.com/photo-1583195764036-6dc248ac07d9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2555&q=80" alt="participant">
                <button class="add-participant" style="color: #4f3ff0;">
                  <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
                    <path d="M12 5v14M5 12h14" />
                  </svg>
                </button>
              </div>
              <div class="days-left" style="color: #4f3ff0;">
                2 Days Left
              </div>
            </div>
          </div>
        </div>
        
        <div class="project-box-wrapper">
          <div class="project-box" style="background-color: #c8f7dc;">
            <div class="project-box-header">
              <span>December 10, 2020</span>
              <div class="more-wrapper">
                <button class="project-btn-more">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                    <circle cx="12" cy="12" r="1" />
                    <circle cx="12" cy="5" r="1" />
                    <circle cx="12" cy="19" r="1" />
                  </svg>
                </button>
              </div>
            </div>
            <div class="project-box-content-header">
              <p class="box-content-header">SAMPLE 3</p>
              <p class="box-content-subheader">sample text</p>
            </div>
            <div class="box-progress-wrapper">
              <p class="box-progress-header">123,456</p>
              <div class="box-progress-bar">
                <span class="box-progress" style="width: 60%; background-color: #34c471"></span>
              </div>
            </div>
            <div class="project-box-footer">
              <div class="days-left" style="color: #34c471;">
                2 Days Left
              </div>
            </div>
          </div>
        </div>
        
        
        <!-- 1박스 -->
        <div class="project-box-wrapper">
          <div class="project-box" style="background-color: #d5deff;">
            <div class="project-box-header">
              <span>Message</span>
              <div class="more-wrapper">
                <button class="project-btn-more">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                    <circle cx="12" cy="12" r="1" />
                    <circle cx="12" cy="5" r="1" />
                    <circle cx="12" cy="19" r="1" />
                  </svg>
                </button>
              </div>
            </div>
            <div class="project-box-content-header">
              <p class="box-content-header">SAMPLE 4</p>
            </div>
            <div class="box-progress-wrapper">
              <p class="box-progress-header">111,111,111</p>
              <div class="box-progress-bar">
                <span class="box-progress" style="width: 40%; background-color: #4067f9"></span>
              </div>
            </div>
            <div class="project-box-footer">
              <div class="participants">
                <img src="https://images.unsplash.com/photo-1600486913747-55e5470d6f40?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80" alt="participant">
                <img src="https://images.unsplash.com/photo-1583195764036-6dc248ac07d9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2555&q=80" alt="participant">
                <!-- +버튼 -->
                <button class="add-participant" style="color: #4067f9;">
                  <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
                    <path d="M12 5v14M5 12h14" />
                  </svg>
                </button>
              </div>
              <div class="days-left" style="color: #4067f9;">
                N Days Left
              </div>
            </div>
          </div>
        </div>
        
        
      </div>
    </div>
    
    
    <!-- 알림창 라인 (style="display:none") -->
    <div class="messages-section">
    
    <!-- 알림창 헤더
      <div class="projects-section-header">
        <p>Client Messages</p>
      </div>
      <button class="messages-close">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x-circle">
          <circle cx="12" cy="12" r="10" />
          <line x1="15" y1="9" x2="9" y2="15" />
          <line x1="9" y1="9" x2="15" y2="15" />
        </svg>
      </button>
     -->
      
      <div class="messages">
      
      <!-- BOX1 -->
        <div class="message-box">
          <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80" alt="profile image">
          <div class="message-content">
            <div class="message-header">
              <div class="name">Alarm 1</div>
              <div class="star-checkbox">
                <input type="checkbox" id="star-1">
                <label for="star-1">
			        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x-circle">
			          <circle cx="12" cy="12" r="10" />
			          <line x1="15" y1="9" x2="9" y2="15" />
			          <line x1="9" y1="9" x2="15" y2="15" />
			        </svg>
                </label>
              </div>
            </div>
            <p class="message-line">
            	sample text message.
            </p>
            <p class="message-line time">
              Dec, 12
            </p>
          </div>
        </div>
        
        
        
        
        <div class="message-box">
          <div class="message-content">
            <div class="message-header">
              <div class="name">Alarm 2</div>
              <div class="star-checkbox">
                <input type="checkbox" id="star-2">
                <label for="star-2">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star">
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </label>
              </div>
            </div>
            <p class="message-line">
              It's a beautiful day.<br/> and br test.
            </p>
            <p class="message-line time">
              Dec, 12
            </p>
          </div>
        </div>
        
        
        <!-- 
        
        <div class="message-box">
          <img src="https://images.unsplash.com/photo-1543965170-4c01a586684e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDZ8fG1hbnxlbnwwfDB8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60" alt="profile image">
          <div class="message-content">
            <div class="message-header">
              <div class="name">David</div>
              <div class="star-checkbox">
                <input type="checkbox" id="star-3">
                <label for="star-3">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star">
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </label>
              </div>
            </div>
            <p class="message-line">
              Awesome! 🤩 I like it. We can schedule a meeting for the next one.
            </p>
            <p class="message-line time">
              Dec, 12
            </p>
          </div>
        </div>
        
        
        
        
        <div class="message-box">
          <img src="https://images.unsplash.com/photo-1533993192821-2cce3a8267d1?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTl8fHdvbWFuJTIwbW9kZXJufGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60" alt="profile image">
          <div class="message-content">
            <div class="message-header">
              <div class="name">Jessica</div>
              <div class="star-checkbox">
                <input type="checkbox" id="star-4">
                <label for="star-4">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-star">
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </label>
              </div>
            </div>
            <p class="message-line">
              I am really impressed! Can't wait to see the final result.
            </p>
            <p class="message-line time">
              Dec, 11
            </p>
          </div>
        </div>
        
         -->
        
        
      </div>
      
    </div>
  </div>
</div>
</body>
</html>