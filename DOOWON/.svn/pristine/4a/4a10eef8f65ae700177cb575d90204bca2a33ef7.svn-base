 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html lang="ko">

<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
			  src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
			  integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
			  crossorigin="anonymous"></script>
  <script type="module" crossorigin src="/pf/assets/logingreen.js"></script>
  <link rel="stylesheet" crossorigin href="/pf/assets/style.css">
  
  <script type="text/javascript">
  	
  
  $(document).ready(function(){
		var key = getCookie("idChk"); //user1
		console.log("key"+key);
		if(key!=""){
			$("#email").val(key); 
		}
		if($("#email").val() != ""){ 
			$("#idSaveCheck").attr("checked", true); 
		}
		 
		$("#idSaveCheck").change(function(){ 
			if($("#idSaveCheck").is(":checked")){ 
				setCookie("idChk", $("#email").val(), 7); 
			}else{ 
				deleteCookie("idChk");
			}
		});
		 
		$("#email").keyup(function(){ 
			if($("#idSaveCheck").is(":checked")){
				setCookie("idChk", $("#email").val(), 7); 
			}
		});
	});
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	 
	function deleteCookie(cookieName){
		var expireDate = new Date();
		expireDate.setDate(expireDate.getDate() - 1);
		document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
		 
	function getCookie(cookieName) {
		cookieName = cookieName + '=';
		var cookieData = document.cookie;
		var start = cookieData.indexOf(cookieName);
		var cookieValue = '';
		if(start != -1){
			start += cookieName.length;
			var end = cookieData.indexOf(';', start);
			if(end == -1)end = cookieData.length;
			cookieValue = cookieData.substring(start, end);
		}
		return unescape(cookieValue);
	}
  
  
  
  
  
  function login(){
		 var email = $("#email");
		var password = $("#password");

		if(email.val() == ""){
			alert("Please enter your email address");
			email.focus();
			return;
		}

		if(password.val() == ""){
			alert("Please enter a password");
			password.focus();
			return;
		}
		//fn_loading(true);
		var param = {};
		param["id"] = email.val();
		param["pwd"] = password.val();
		param["lang"] = $("#lang").val();

		$.ajax({
			type : "POST",
			url : "/loginCheck.do",
			data : param,
			dataType: "json",
	        success : function(data) {
	        	if(data.result == "SUCCESS"){
	        		document.loginForm.submit();
	        	}else{
	        		alert("등록된 사용자가 없습니다.");
	        	}
	        	//fn_loading(false);
	        },
	        error : function(e, textStatus, errorThrown) {
	        	console.log(errorThrown);
	        }
		}); 

	}
	
	function enterkey() {
		if (window.event.keyCode == 13) {
			login();
	    }
	}
  
  </script>
  
  
</head>
<body class="bg-white flex flex-col items-center justify-center">
<form action="/cmmn/main.do" name="loginForm" id="loginForm" method="post"></form>
  <main class="relative w-full h-full flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen pt:mt-0 dark:bg-gray-900 backdrop-blur-sm">
    <!-- <a class="absolute right-6 top-8" href="http://www.customsservice.co.kr">
      <img src="/assets/img/shinhanlogo.svg" class="h-11" alt="Platform Logo">
    </a> -->

    <!-- Card -->
    <div class="w-5/6 max-w-lg p-10 pt-6 bg-white rounded-xl
      border
      border-primary-100
      hover:border-primary-300
      has-[:focus]:border-primary-300
      shadow-2xl
      transition-border
      hover:shadow-xl
      has-[:focus]:shadow-xl
      hover:shadow-primary-100
      has-[:focus]:shadow-primary-100
      hover:scale-[1.02]
      has-[:focus]:scale-[1.02]
      duration-500
      transition-all
      ">
      <h1 class="pt-6 flex flex-col mt-auto items-center justify-center gap-2 text-xl font-semibold pb-2">
        <a href="">
          <img src="data:image/svg+xml,%3c?xml%20version='1.0'%20encoding='UTF-8'?%3e%3csvg%20id='Layer_1'%20xmlns='http://www.w3.org/2000/svg'%20viewBox='0%200%20587.75%20180'%3e%3cpath%20d='M28.99,36.85H0V0h41.27v26.38c0,7.05-4.03,10.47-12.28,10.47ZM.4,180V52.95h40.67v112.95c0,8.25-7.45,14.09-16.11,14.09H.4Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M426.67,180V5.64h45.3l35.23,100.27,35.03-100.27h45.5v160.27c0,8.25-7.45,14.09-16.11,14.09h-24.76v-82.15c0-.6,0-2.21.2-4.63.2-2.62.2-4.23.2-5.03l-.81,4.23c-.2,2.21-.6,3.83-.81,4.43l-19.53,56.78c-2.21,6.64-7.25,10.47-14.3,10.47h-19.53l-22.95-68.46c-.6-1.81-1.21-7.85-2.01-9.66.2,1.21.2,3.22.2,5.84v74.09c0,8.25-7.45,14.09-16.11,14.09h-24.76Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M318.23,180c-31.16,0-58.88-30.95-69.64-44.69-2.94-3.75-3.21-8.95-.71-13l11.83-19.15c.76-1.23,2.5-1.33,3.4-.19,7.32,9.3,35.19,42.95,55.13,42.95,29.11,0,52.79-23.68,52.79-52.79s-23.68-52.79-52.79-52.79c-10.54,0-26.53,10.63-43.88,29.17-15.17,16.21-26.15,32.81-26.26,32.98,0,0-19.46,25.96-29.92,37.18-24.95,26.77-48.21,40.34-69.12,40.34-47.9,0-86.88-38.97-86.88-86.88S101.15,6.25,149.05,6.25c34.14,0,59.41,25.94,72.99,42.63,3.57,4.39,3.64,10.65.14,15.09l-14.41,18.29c-.69.87-2,.89-2.71.03-6.58-8.02-35.61-41.96-56-41.96-29.11,0-52.79,23.68-52.79,52.79s23.68,52.79,52.79,52.79c10.54,0,26.53-10.63,43.88-29.17,15.17-16.21,26.15-32.81,26.26-32.98l5.76-7.68c5.16-7.13,13.69-18.28,24.16-29.5,24.95-26.77,48.21-40.34,69.12-40.34,47.9,0,86.88,38.97,86.88,86.88s-38.97,86.88-86.88,86.88Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3c/svg%3e" class="h-16" alt="Platform Logo">
        </a>
      </h1>
      <h2 class="text-primary-800 pb-2 text-2xl font-bold flex items-baseline gap-2">Login</h2>
      <form action="./main">
        <div id="email-container" class="flex items-center justify-start gap-3 border border-slate-400 rounded-t-lg px-5 py-3 relative">
          <label for="email" class="text-gray-900 dark:text-white shrink-0"><i class="fa-regular fa-user"></i></label>
          <input type="text" name="email" id="email" onkeyup="enterkey()" class="text-lg text-gray-900 block w-full p-0 border-none shadow-none appearance-none focus:ring-0" placeholder="Username" required="" value="">
        </div>
        <div id="password-container" class="flex items-center justify-start gap-3 border border-slate-400 rounded-b-lg px-5 py-3 -mt-[1px] relative">
          <label for="password" class="text-gray-900 dark:text-white shrink-0"><i class="fa-regular fa-lock-keyhole"></i></label>
          <input type="password" name="password" id="password" placeholder="Password" onkeyup="enterkey()" class="text-lg text-gray-900 block w-full p-0 border-none shadow-none appearance-none focus:ring-0 [font-family:Pretendard] placeholder:font-[NanumSquare]" required="" value="">
        </div>
        <div class="flex items-center gap-2 pt-4 pb-8 text-lg">
            <input id="idSaveCheck" aria-describedby="remember" name="remember" type="checkbox" class="w-4 h-4 border-gray-300 rounded bg-gray-50 checked:bg-primary-800 focus:ring-3 focus:ring-primary-300 dark:focus:ring-primary-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600">
            <label for="remember" class="font-light
            text-primary-500 hover:text-primary-700">ID저장</label>
        </div>
        <button type="button" onclick="login()" class="block w-full px-5 py-3 text-xl font-semibold text-center text-white bg-primary-700 rounded-lg hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">로그인</button>
      </form>

      <div class="text-lg pt-6 font-light text-primary-500 hover:text-primary-700 flex items-center justify-center gap-3">
        <a href="/member/searchIdAndPw.do" class="hover:underline hover:font-medium">
        	아이디/비밀번호 찾기
		</a>
        <p class="text-gray-400">|</p>
        <a href="member/insertMember.do" class="hover:underline hover:font-medium">회원가입</a>
      </div>
      <script>
        const email = document.getElementById('email');
        const password = document.getElementById('password');
        const emailContainer = document.getElementById('email-container');
        const passwordContainer = document.getElementById('password-container');
        email.addEventListener('focusin', function() {
          emailContainer.classList.add('on');
        });
        email.addEventListener('focusout', function() {
          emailContainer.classList.remove('on');
        });
        password.addEventListener('focusin', function() {
          passwordContainer.classList.add('on');
        });
        password.addEventListener('focusout', function() {
          passwordContainer.classList.remove('on');
        });

      </script>
      <style>
        #email-container.on {
          border-color: #1b9c07;
          z-index: 2;
        }
        #password-container.on {
          border-color: #1b9c07;
          border-top-width: 1px;
          z-index: 2;
        }
      </style>
    </div>
</main>

<footer class="w-full flex flex-col items-center justify-center px-6 py-4 text-gray-400 shrink-0">
  <div class="flex gap-2 items-center justify-center">
    <p>KORD Systems Inc.</p>
      <p>Copyright KORD Systems Inc. All rights reserved.</p>
  </div>
  <div class="flex items-center justify-center gap-3 leading-relaxed">
    <a class="block" href="mailto:ioom@kordsystems.com">
      <i class="fa-regular fa-envelopes"></i>
      ioom@kordsystems.com
    </a>
    <span>|</span>
    <a class="block">
      <i class="fa-regular fa-phone-volume"></i>
      +82-2-2038-8299
    </a>
  </div>
</footer>
</body>
</html>
