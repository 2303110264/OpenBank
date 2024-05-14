<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 알림창 라인 (style="display:none") -->
    <div class="messages-section">
    
    <!-- 알림창 헤더
     -->
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