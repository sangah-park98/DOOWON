<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tiles/inc/taglib.jsp"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>searchId</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><script
			  src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
			  integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
			  crossorigin="anonymous"></script>
  <script type="module" crossorigin src="/pf/assets/find.js"></script>
  
  <link rel="modulepreload" crossorigin href="/pf/assets/modulepreload-polyfill.js">
  <link rel="modulepreload" crossorigin href="/pf/assets/vendor.js">
  <link rel="stylesheet" crossorigin href="/pf/assets/style.css">
  
  <script type="text/javascript" src="/pf/js/member/searchIdAndPw.js"></script>
</head>
<body class="bg-[#f7f7f7]">
  <main class="w-5/6 max-w-2xl mx-auto relative px-6 py-8 dark:bg-gray-900 backdrop-blur-sm">
    <!-- <a class="absolute right-6 top-8" href="http://www.customsservice.co.kr">
      <img src="/assets/img/shinhanlogo.svg" class="h-11" alt="Platform Logo">
    </a> -->

    <div class="w-full flex items-end justify-between px-4 pb-8">
      <h1>
        <a href="/login.do">
          <img src="data:image/svg+xml,%3c?xml%20version='1.0'%20encoding='UTF-8'?%3e%3csvg%20id='Layer_1'%20xmlns='http://www.w3.org/2000/svg'%20viewBox='0%200%20587.75%20180'%3e%3cpath%20d='M28.99,36.85H0V0h41.27v26.38c0,7.05-4.03,10.47-12.28,10.47ZM.4,180V52.95h40.67v112.95c0,8.25-7.45,14.09-16.11,14.09H.4Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M426.67,180V5.64h45.3l35.23,100.27,35.03-100.27h45.5v160.27c0,8.25-7.45,14.09-16.11,14.09h-24.76v-82.15c0-.6,0-2.21.2-4.63.2-2.62.2-4.23.2-5.03l-.81,4.23c-.2,2.21-.6,3.83-.81,4.43l-19.53,56.78c-2.21,6.64-7.25,10.47-14.3,10.47h-19.53l-22.95-68.46c-.6-1.81-1.21-7.85-2.01-9.66.2,1.21.2,3.22.2,5.84v74.09c0,8.25-7.45,14.09-16.11,14.09h-24.76Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M318.23,180c-31.16,0-58.88-30.95-69.64-44.69-2.94-3.75-3.21-8.95-.71-13l11.83-19.15c.76-1.23,2.5-1.33,3.4-.19,7.32,9.3,35.19,42.95,55.13,42.95,29.11,0,52.79-23.68,52.79-52.79s-23.68-52.79-52.79-52.79c-10.54,0-26.53,10.63-43.88,29.17-15.17,16.21-26.15,32.81-26.26,32.98,0,0-19.46,25.96-29.92,37.18-24.95,26.77-48.21,40.34-69.12,40.34-47.9,0-86.88-38.97-86.88-86.88S101.15,6.25,149.05,6.25c34.14,0,59.41,25.94,72.99,42.63,3.57,4.39,3.64,10.65.14,15.09l-14.41,18.29c-.69.87-2,.89-2.71.03-6.58-8.02-35.61-41.96-56-41.96-29.11,0-52.79,23.68-52.79,52.79s23.68,52.79,52.79,52.79c10.54,0,26.53-10.63,43.88-29.17,15.17-16.21,26.15-32.81,26.26-32.98l5.76-7.68c5.16-7.13,13.69-18.28,24.16-29.5,24.95-26.77,48.21-40.34,69.12-40.34,47.9,0,86.88,38.97,86.88,86.88s-38.97,86.88-86.88,86.88Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3c/svg%3e" class="h-10" alt="Platform Logo">
        </a>
      </h1>
<!--       <a href="#">
        <img src="/pf/assets/shinhanlogo.svg" class="h-10" alt="Shinhan Logo">
      </a> -->
    </div>
    <!-- tab -->

    <div class="flex bg-gray-200 rounded-t-xl card-tab">
      <button id="searchIdBtn" onclick="fn_searchIdBtn()" class="card-tab__button w-1/2 font-semibold py-3 text-xl bg-gray-200 border border-gray-200 border-b-primary-300 rounded-t-xl duration-200 active">아이디 찾기</button>
      <button id="searchPwBtn" onclick="fn_searchPwBtn()" class="card-tab__button w-1/2 font-semibold py-3 text-xl bg-gray-200 border border-gray-200 border-b-primary-300 rounded-t-xl duration-200">비밀번호 찾기</button>
    </div>
    <!-- Card -->
    <div class="w-full p-10 pt-6 bg-white rounded-b-xl border-x border-b border-primary-300 shadow-2xl duration-500 transition-all text-xl">

      <form id="searchIdAndPwFrm" name="searchIdAndPwFrm" action="./main.html" class="form-container py-8 grid grid-cols-[1fr_3fr] gap-x-2 gap-y-4 items-center active">
        <label for="input_register_number" class="text-primary-700 font-semibold px-2 text-left">사업자 번호</label>
        <input
          type="text"
          id="input_register_number"
          name="COMP_REG_NO"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="사업자 번호를 입력해주세요."
        >
        <label for="input_email" class="text-primary-700 font-semibold px-2 text-left">이메일 주소</label>
        <input
          type="text"
          id="input_email"
          name="MEMBER_EMAIL"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="이메일 주소를 입력해주세요."
        >
        <!-- line -->
        <div class="my-3 h-[1px] bg-gray-200 mx-10 col-span-2"></div>
        <div class="w-full flex gap-2 col-span-2">
          <button 
            type="button"
            onclick="fn_clearIdAndPwd()"
            class="w-1/5 block px-5 py-3 text-xl font-semibold text-center text-white bg-secondary-600 rounded-lg hover:bg-secondary-500 focus:ring-4 focus:ring-secondary-600 dark:bg-gray-600 dark:hover:bg-gray-700 dark:focus:ring-primary-800"
          >
            <i class="fa-solid fa-xmark"></i>
            초기화
          </button>
          <button
	        id="searchIdAndPwButton" 
	        value="searchId" 
	        onclick="searchIdAndPwSubmit()" 
            type="button"
            class="w-4/5 col-span-3 block px-5 py-3 text-xl font-semibold text-center text-white bg-primary-700 rounded-lg hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
          >
            <i class="fa-solid fa-magnifying-glass"></i>
            아이디 찾기
          </button>
        </div>
      </form>
      <form id="searchPwFrm" action="./main.html" class="form-container py-8 grid grid-cols-[1fr_3fr] gap-x-2 gap-y-4 items-center">
        <!-- <label for="input_id" class="text-primary-700 font-semibold px-2 text-left">사용자 ID</label>
        <input
          type="text"
          id="input_id"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="ID를 입력해주세요."
        > -->
        <label for="input_register_number" class="text-primary-700 font-semibold px-2 text-left">사업자 번호</label>
        <input
          type="text"
          name="COMP_REG_NO"
          id="input_register_number2"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="사업자 번호를 입력해주세요."
        >
        <label for="input_email" class="text-primary-700 font-semibold px-2 text-left">이메일 주소</label>
        <input
          type="text"
          id="input_email2"
          name="MEMBER_EMAIL"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="이메일 주소를 입력해주세요."
        >
        <!-- line -->
        <div class="my-3 h-[1px] bg-gray-200 mx-10 col-span-2"></div>
        <div class="w-full flex gap-2 col-span-2">
          <button 
            type="button"
            onclick="fn_clearIdAndPwd()"
            class="w-1/5 block px-5 py-3 text-xl font-semibold text-center text-white bg-secondary-600 rounded-lg hover:bg-secondary-500 focus:ring-4 focus:ring-secondary-600 dark:bg-gray-600 dark:hover:bg-gray-700 dark:focus:ring-primary-800"
          >
            <i class="fa-solid fa-xmark"></i>
            초기화
          </button>
          <button 
          	id="searchIdAndPwButton" 
	        value="searchId" 
	        onclick="searchIdAndPwSubmit()" 
            type="button"
            class="w-4/5 col-span-3 block px-5 py-3 text-xl font-semibold text-center text-white bg-primary-700 rounded-lg hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
          >
            <i class="fa-solid fa-magnifying-glass"></i>
            비밀번호 찾기
          </button>
        </div>
      </form>
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
      <!-- <a class="block" href="tel:+82-02-2038-8299"> -->
      <a class="block">
        <i class="fa-regular fa-phone-volume"></i>
        +82-2-2038-8299
      </a>
    </div>
  </footer>

  <style>
    .card-tab button.active{
      background: white;
      border-top: 1px solid rgb(163 197 182);
      border-right: 1px solid rgb(163 197 182);
      border-left: 1px solid rgb(163 197 182);
      border-bottom: 1px solid white;
      color: rgb(71 140 114);
    }
    .form-container{
      display: none;
    }

    .form-container.active{
      display: grid;
    }
  </style>
  
</body>
</html>

