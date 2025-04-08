 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
		integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
		crossorigin="anonymous">
</script>
<script type="module" crossorigin src="/dw/assets/logingreen.js"></script>
<link rel="stylesheet" crossorigin href="/dw/assets/style.css">
<style>
    #id-container.on {
      border-color: #1878d1;
      z-index: 2;
    }
    #password-container.on {
      border-color: #1878d1;
      border-top-width: 1px;
      z-index: 2;
    }
</style>
<script type="text/javascript">
  	
  $(document).ready(function(){
		var key = getCookie("idChk"); //user1
		console.log("key"+key);
		if(key!=""){
			$("#id").val(key); 
		}
		if($("#id").val() != ""){ 
			$("#idSaveCheck").attr("checked", true); 
		}
		 
		$("#idSaveCheck").change(function(){ 
			if($("#idSaveCheck").is(":checked")){ 
				setCookie("idChk", $("#id").val(), 7); 
			}else{ 
				deleteCookie("idChk");
			}
		});
		 
		$("#id").keyup(function(){ 
			if($("#idSaveCheck").is(":checked")){
				setCookie("idChk", $("#id").val(), 7); 
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
		 var id = $("#id");
		var password = $("#password");

		if(id.val() == ""){
			alert("Please enter your email address");
			id.focus();
			return;
		}

		if(password.val() == ""){
			alert("Please enter a password");
			password.focus();
			return;
		}
		var param = {};
		param["id"] = id.val();
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

    <div class="w-5/6 max-w-lg p-10 pt-6 bg-white rounded-xl
			      border border-[#1878d1]
			      hover:border-[#1878d1]
			      has-[:focus]:border-[#1878d1]
			      shadow-2xl
			      transition-border
			      hover:shadow-xl
			      has-[:focus]:shadow-xl
			      hover:shadow-[#1878d133]
			      has-[:focus]:shadow-[#1878d133]
			      hover:scale-[1.02]
			      has-[:focus]:scale-[1.02]
			      duration-500
			      transition-all
			      ">
		<h1 class="pt-6 flex flex-col mt-auto items-center justify-center gap-2 text-xl font-semibold pb-2">
        	<a href=""><img src="/images/egovframework/cmmn/Doowon_logo.png" class="h-16" alt="Doowon Logo"></a>
      	</h1>
      
      	<h2 class="text-2xl font-bold flex items-baseline gap-2">Login</h2>
      	<form action="./main">
        	<div id="id-container" class="flex items-center justify-start gap-3 border border-slate-400 rounded-t-lg px-5 py-3 relative">
          		<label for="id" class="text-gray-900 dark:text-white shrink-0"><i class="fa-regular fa-user"></i></label>
          		<input type="text" name="id" id="id" onkeyup="enterkey()" class="text-lg text-gray-900 block w-full p-0 border-none shadow-none appearance-none focus:ring-0" placeholder="Username">
        	</div>
        	<div id="password-container" class="flex items-center justify-start gap-3 border border-slate-400 rounded-b-lg px-5 py-3 -mt-[1px] relative">
        		<label for="password" class="text-gray-900 dark:text-white shrink-0"><i class="fa-regular fa-lock-keyhole"></i></label>
          		<input type="password" name="password" id="password" placeholder="Password" onkeyup="enterkey()" class="text-lg text-gray-900 block w-full p-0 border-none shadow-none appearance-none focus:ring-0 [font-family:Pretendard] placeholder:font-[NanumSquare]">
        	</div>
        	<div class="flex items-center gap-2 pt-4 pb-8 text-lg">
            	<input id="idSaveCheck" aria-describedby="remember" name="remember" type="checkbox" class="w-4 h-4 border-gray-300 rounded bg-gray-50 checked:focus:ring-3 focus:ring-primary-300 dark:focus:ring-primary-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600">
            	<label for="remember" class="font-light">ID저장</label>
        	</div>
        	<button type="button" onclick="login()" class="block w-full px-5 py-3 text-xl font-semibold text-center text-black border border-slate-400 rounded-lg">
        		로그인
        	</button>
      	</form>

    	<div class="text-lg pt-6 font-light text-primary-500 hover:text-primary-700 flex items-center justify-center gap-3"></div>
		<script>
		 	const id = document.getElementById('id');
		 	const password = document.getElementById('password');
		  	const idContainer = document.getElementById('id-container');
		  	const passwordContainer = document.getElementById('password-container');
		  	id.addEventListener('focusin', function() {
		  		idContainer.classList.add('on');
		  	});
		  	id.addEventListener('focusout', function() {
		    	idContainer.classList.remove('on');
		  	});
		  	password.addEventListener('focusin', function() {
		    	passwordContainer.classList.add('on');
		  	});
		  	password.addEventListener('focusout', function() {
		    	passwordContainer.classList.remove('on');
		  	});
		</script>
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