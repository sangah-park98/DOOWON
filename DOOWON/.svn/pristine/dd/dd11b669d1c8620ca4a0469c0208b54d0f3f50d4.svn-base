<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Sign In</title>
<link type="text/css" rel="stylesheet" href="https://gcore.jsdelivr.net/gh/handsontable/handsontable@latest/dist/handsontable.full.css">
<link rel="stylesheet" type="text/css" 	href="https://gcore.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.css">
<script 	src="https://gcore.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.js"></script>

<script src="https://gcore.jsdelivr.net/npm/handsontable@7.4.2/dist/handsontable.full.min.js"></script>
<link type="text/css" rel="stylesheet" href="https://gcore.jsdelivr.net/npm/handsontable@7.4.2/dist/handsontable.full.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/datepicker.min.js"></script>
<link href="https://releases.transloadit.com/uppy/v3.23.0/uppy.min.css" rel="stylesheet">
<script src="/pf/js/cmmn/comUtil.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><script
			  src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
			  integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
			  crossorigin="anonymous"></script> 

<script type="text/javascript" src="https://gcore.jsdelivr.net/npm/handsontable/dist/handsontable.full.min.js"></script>
<link rel="stylesheet" href="https://gcore.jsdelivr.net/npm/handsontable/dist/handsontable.full.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>			  
<script type="module" crossorigin src="/pf/assets/main-font.js"></script>
<!-- <script type="module" crossorigin src="/pf/assets/datepicker-init.js"></script> -->
<link rel="stylesheet" crossorigin href="/pf/assets/main-font.css">
<script type="module" crossorigin src="/pf/assets/modulepreload-polyfill.js"></script>
<!-- <script type="module" crossorigin src="/pf/assets/vendor.js"></script> -->
<script type="module" crossorigin src="/pf/assets/dropdown-init.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<script type="module" crossorigin src="/pf/assets/signIn.js"></script>
<link rel="stylesheet" href="/pf/assets/style.css">
<script type="text/javascript" src="/pf/js/member/join.js"></script>
</head>

  <style type="text/css">
  input[readonly] {
    background-color: #D3D3D3; /* 진한 회색 */
}
  </style>
<body class="bg-[#f7f7f7]">
  <main class="w-5/6 max-w-3xl mx-auto relative px-6 py-8 dark:bg-gray-900 backdrop-blur-sm">
  <%
    int count = 0; // 초기 count 값
   %>
  
    <!-- <a class="absolute right-6 top-8" href="http://www.customsservice.co.kr">
      <img src="/assets/img/shinhanlogo.svg" class="h-11" alt="Platform Logo">
    </a> -->
    <div class="w-full flex items-end justify-between px-4 pb-8">
      <h1>
        <a href="/login.do">
          <img src="data:image/svg+xml,%3c?xml%20version='1.0'%20encoding='UTF-8'?%3e%3csvg%20id='Layer_1'%20xmlns='http://www.w3.org/2000/svg'%20viewBox='0%200%20587.75%20180'%3e%3cpath%20d='M28.99,36.85H0V0h41.27v26.38c0,7.05-4.03,10.47-12.28,10.47ZM.4,180V52.95h40.67v112.95c0,8.25-7.45,14.09-16.11,14.09H.4Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M426.67,180V5.64h45.3l35.23,100.27,35.03-100.27h45.5v160.27c0,8.25-7.45,14.09-16.11,14.09h-24.76v-82.15c0-.6,0-2.21.2-4.63.2-2.62.2-4.23.2-5.03l-.81,4.23c-.2,2.21-.6,3.83-.81,4.43l-19.53,56.78c-2.21,6.64-7.25,10.47-14.3,10.47h-19.53l-22.95-68.46c-.6-1.81-1.21-7.85-2.01-9.66.2,1.21.2,3.22.2,5.84v74.09c0,8.25-7.45,14.09-16.11,14.09h-24.76Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M318.23,180c-31.16,0-58.88-30.95-69.64-44.69-2.94-3.75-3.21-8.95-.71-13l11.83-19.15c.76-1.23,2.5-1.33,3.4-.19,7.32,9.3,35.19,42.95,55.13,42.95,29.11,0,52.79-23.68,52.79-52.79s-23.68-52.79-52.79-52.79c-10.54,0-26.53,10.63-43.88,29.17-15.17,16.21-26.15,32.81-26.26,32.98,0,0-19.46,25.96-29.92,37.18-24.95,26.77-48.21,40.34-69.12,40.34-47.9,0-86.88-38.97-86.88-86.88S101.15,6.25,149.05,6.25c34.14,0,59.41,25.94,72.99,42.63,3.57,4.39,3.64,10.65.14,15.09l-14.41,18.29c-.69.87-2,.89-2.71.03-6.58-8.02-35.61-41.96-56-41.96-29.11,0-52.79,23.68-52.79,52.79s23.68,52.79,52.79,52.79c10.54,0,26.53-10.63,43.88-29.17,15.17-16.21,26.15-32.81,26.26-32.98l5.76-7.68c5.16-7.13,13.69-18.28,24.16-29.5,24.95-26.77,48.21-40.34,69.12-40.34,47.9,0,86.88,38.97,86.88,86.88s-38.97,86.88-86.88,86.88Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3c/svg%3e" class="h-12" alt="Platform Logo">
        </a>
      </h1>
     <!--  <a href="#">
        <img src="/pf/assets/shinhanlogo.svg" class="h-12" alt="Shinhan Logo">
      </a> -->
    </div>
    <!-- Card -->
    <div class="w-full p-10 pt-6 bg-white rounded-xl
      border
      border-primary-300
      shadow-2xl
      duration-500
      transition-all
      ">
      <form id="joinFrm" name="joinFrm" method="post" action="/member/memberjoin.do" class="text-lg grid grid-cols-[1fr_2.4fr_1fr] gap-x-2 gap-y-1 items-center py-3">
        <!-- Account Information -->
        <h2 class="text-primary-800 pb-1 font-bold flex items-center gap-2 text-2xl px-2 col-span-3"><i class="fa-duotone fa-feather"></i>계정정보</h2>
        <label for="account_id" class="text-primary-700 font-semibold px-2 text-left">*아이디</label>
        <input
          type="text"
          name="MEMBER_ID" 
          id="MEMBER_ID"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="ID를 입력해주세요."
           oninput="checkInput()"
        >
       <!--  <p class="text-gray-500 text-base"> -->
        <button 
          type="button"
          class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-secondary-700 bg-secondary-700 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
          onclick="idCheck()"	        
        >중복체크</button>
         <input type="hidden" id="MEMBER_ID_CHK" name="MEMBER_ID_CHK" value="none"/>
         <p class="member-id-text txt_help_email text-primary-500 pb-1 flex items-center gap-2 text-1 px-2 col-span-3" style="color:red;">
                  ● 중복체크를 해주세요</p>
        
        <label for="MEMBER_PASS" class="text-primary-700 font-semibold px-2 text-left">*비밀번호</label>
        <input
          type="password"
          onkeyup="memberPassChk('pw')"
          name="MEMBER_PASS" 
          id="MEMBER_PASS"
          class="font-['Pretendard'] bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="비밀번호를 입력해주세요."
        >
        <p class="passCheck1 text-primary-500 pb-1 flex items-center gap-2 text-1 px-2 col-span-3" style="color:red;">
                  ● 비밀번호(대문자, 소문자, 특수기호, 숫자 포함, 5~20자리)를 입력해주세요</p>
        <!-- Blank -->
        <!-- /Blank -->
        <label for="account_password_check" class="text-primary-700 font-semibold px-2 text-left">*비밀번호 확인</label>
        <input
          type="password"
          name="MEMBER_PASS_CHK" 
          id="MEMBER_PASS_CHK" 
          onkeyup="memberPassChk('pw_re')"
          class="font-['Pretendard'] bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="비밀번호를 한번 더 입력해주세요."
        >
        <!-- Checking Password indicator -->
        <p class="block text-green-500 text-2xl" id="passwordIndicator">
        <!-- <i class="fa-duotone fa-check bg-primary-200 rounded-full flex items-center justify-center p-1"></i>
        <svg xmlns="http://www.w3.org/2000/svg" height="25" width="25" viewBox="0 0 512 512"><path fill="#990f0f" d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM175 175c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z"/></svg>
         -->
        </p>
        
        <p class="passCheck2 text-primary-500 pb-1 flex items-center gap-2 text-1 px-2 col-span-3" style="color:red;">
                  ● 비밀번호를 획인해주세요</p>
        <!-- <p class="text-sm text-red-700 px-2">비밀번호를 확인해주세요</p> -->
        <!-- line -->
        <div id="companySets" class="col-span-3 my-3 h-[1px] bg-gray-200 mx-10"></div>
        <label for="MEMBER_NAME" class="text-primary-700 font-semibold px-2 text-left">*이름</label>
        <input
          type="text"
          name="MEMBER_NAME" 
          id="MEMBER_NAME"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="이름을 입력해주세요."
        >
        <!-- Blank -->
        <p></p>
        <!-- /Blank -->
        <label for="MEMBER_TEL" class="text-primary-700 font-semibold px-2 text-left">*전화번호</label>
        <input
          type="text"
          name="MEMBER_TEL" 
          id="MEMBER_TEL"
          oninput="removeHyphen(event)"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="전화번호를 입력해주세요."
        >
        <p class=" text-primary-500 pb-1 flex items-center gap-2 text-1 px-2 col-span-3" style="color:red;">
                  ●SMS 또는 카카오톡으로 알림을 받으시려면 핸드폰번호를 입력해주세요 </p>
        <!-- Blank -->
       
        
        <!-- /Blank -->
        <label for="MEMBER_EMAIL" class="text-primary-700 font-semibold px-2 text-left">*이메일</label>
        <input
          type="text"
          name="MEMBER_EMAIL" 
          id="MEMBER_EMAIL"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="이메일을 입력해주세요."
        >
        <button 
          type="button"
          class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-secondary-700 bg-secondary-700 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
          onclick="emailValidation()"
        >인증번호 발송</button>
        
        <label for="CERT_NUM" class="text-primary-700 font-semibold px-2 text-left">*인증번호 입력</label>
        <input
          type="text"
          name="CERT_NUM" 
          id="CERT_NUM"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="인증번호를 입력해주세요."
        >
        <input type="hidden" id="CERT_CHECK" name="CERT_CHECK" value="N"/>
        <button 
          type="button"
          class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-gray-300 bg-gray-300 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
          onclick="certNumberConfirm()"
        >인증하기</button>
        <p class="timer text-primary-500 pb-1 flex items-center gap-2 text-1 px-2 col-span-3" style="color:#55A5B7;"></p>
        
        <!-- <h2 class="text-primary-700 font-semibold px-2 text-left">회원 구분</h2>
        <div class="col-span-2 flex items-center gap-4">
          <div class="flex items-center py-2">
            <input id="Client_Basic" name="clientType" value="true" type="radio" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="Client_Basic" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Basic</label>
          </div>
          <div class="flex items-center py-2">
            <input id="Client_Advanced" name="clientType" type="radio" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="Client_Advanced" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Advanced</label>
          </div>
          <div class="flex items-center py-2">
            <input id="Client_Pro" name="clientType" type="radio" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="Client_Pro" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Pro</label>
          </div>
        </div>
        <h2 id="paymentName"class="text-primary-700 font-semibold px-2 text-left">지불 방법</h2>
        <div id="paymentOptions" class="paymentOptions col-span-2 flex items-center gap-4">
          <div class="flex items-center py-2">
            <input id="include" name="payment" value="true" type="radio" value="" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="include" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">통관 수수료 포함 청구</label>
          </div>
          <div class="flex items-center py-2">
            <input id="seperate" name="payment" type="radio" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="seperate" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">별도 청구</label>
          </div>
        </div> -->
         
           <h2 class="text-primary-700 font-semibold px-2 text-left">수리 알림 방식</h2>
        <div class="col-span-2 flex items-center gap-4">
          <div class="flex items-center py-2">
            <input id="alarmEmail" name="alarmEmail" value="true" type="checkbox" value="" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="alarmEmail" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">이메일</label>
          </div>
          <div class="flex items-center py-2">
            <input id="alarmSMS" name="alarmSMS" type="checkbox" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="alarmSMS" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">SMS</label>
          </div>
          <div class="flex items-center py-2">
            <input id="alarmKakao" name="alarmKakao" type="checkbox" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
            <label for="alarmKakao" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">카카오톡</label>
          </div>
        </div>
        
        <label for="account_id" class="text-primary-700 font-semibold px-2 text-left">신한 담당자</label>
        <input
          type="text"
          name="COMP_PERSON" 
          id="COMP_PERSON"
          class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
          placeholder="신한담당자를 입력해주세요."
        >
        
       <!--  <h2 class="text-primary-700 font-semibold px-2 text-left">신한 담당자</h2>
		<div class="col-span-2 flex items-center gap-4">
		    <div class="flex items-center py-2">
		        <input id="COMP_PERSON" name="COMP_PERSON" type="radio" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
		        <label for="COMP_PERSON1" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Y</label>
		    </div>
		    <div class="flex items-center py-2">
		        <input id="COMP_PERSON" name="COMP_PERSON" type="radio" value="false" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
		        <label for="COMP_PERSON2" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">N</label>
		    </div>
		</div> -->

        <!-- active -->
        <!-- <button 
          type="button"
          class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-primary-700 bg-primary-700 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
        >인증하기</button> -->
        <!-- line -->
        <div class="col-span-3 my-3 h-[1px] bg-gray-200 mx-10"></div>
        <h2 class="text-primary-800 pt-4 pb-1 font-bold flex items-center gap-2 text-2xl px-2 col-span-3"><i class="fa-duotone fa-building"></i>업체정보</h2>
        <!-- 사업자 1세트 -->
        <div class="companySets-container col-span-3 pt-2">
        
        <div class="companySets grid grid-cols-[1fr_2.4fr_1fr] gap-x-2 gap-y-1 items-center">
          <label for="COMP_REG_NO" class="text-primary-700 font-semibold px-2 text-left">*사업자 번호</label>
          <input
            type="text"
            name="COMP_REG_NO[<%= count %>]" 
            id="COMP_REG_NO"
            oninput="removeHyphen(event)"
            class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
            placeholder="사업자 번호를 입력해주세요."
          >
          
          <label for="COMP_NAME" class="text-primary-700 font-semibold px-2 text-left row-start-2">사업자 명</label>
          <input
            type="text"
            name="COMP_NAME[<%= count %>]" id="COMP_NAME"
            readonly
            class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg row-start-2"
            placeholder="사업자 명을 입력해주세요."
          >
        
           <input type="hidden" id="REGNO_CHECK[<%= count %>]" name="REGNO_CHECK[<%= count %>]" value="N"/>
         <button 
          type="button"
          class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-secondary-700 bg-secondary-700 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
          onclick="regNoValidation(count)"
        >사업자 번호 인증</button>
          <div class="col-span-3 my-3 h-[1px] bg-gray-200 mx-10 row-start-3"></div>
        </div>
      </div>
      <div id="companySet1" class="companySets-container col-span-3 pt-2">
      </div>
      <div class="col-span-3 flex justify-center">
        <button 
          onclick="addRow()"
          type="button"
          class="py-1 px-8 font-semibold text-center text-white border border-red-500 bg-red-500 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6"
        >추  가</button>
        </div>
        
        <div class="flex items-center py-2 col-span-2">
          <input id="agree-site-policy" name="allAgree" value="allAgree" onclick="toggleAllAgree()" type="checkbox" value="" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
          <label for="agree-site-policy" class="ms-2 font-medium text-gray-900 dark:text-gray-300">모든 약관에 동의합니다.</label>
        </div>
        <div class="flex items-center py-2 col-span-2">
          <input id="SHINHAN_AGREE" name="SHINHAN_AGREE" type="checkbox" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
          <label for="SHINHAN_AGREE" class="ms-2 font-medium text-gray-900 dark:text-gray-300">플랫폼 이용 약관에 동의합니다.</label>
        </div >
        <a href="#" onclick="showDetails('Details')" class="underline hover:opacity-50 duration-150 text-primary-500">상세보기</a>
        <div class="items-center col-span-3" id="Details" style="display: none; overflow-y: scroll; max-height: 300px;">
	    <pre class="text-gray-500" style="font-size: 12px">
		<p>
		iOOM는 회원서비스 처리를 위하여 고객으로부터 최소한의 필수정보를 수집하며, 제공한 모든 개인정보는 별도의 동의가 없는 한 해당 목적 이외의 다른 목적으로 사용하지 않습니다.
	        • 수집항목
	        1. 최초 회원가입 시 회원 식별 및 최적화된 서비스 제공을 위해 아래와 같은 정보를 수집합니다.
	        - 필수 항목: 아이디, 비밀번호, 이름/기업명, 사업자등록번호, 담당자명(기업회원의 경우), 이메일 주소, 휴대전화번호, CI
	        2. 소셜 회원가입 시 SNS 연결 및 원활한 서비스 제공을 위해 아래와 같은 정보를 수집합니다.
	        - 필수 수집 항목: 이름, 소셜 이메일 주소, 소셜 고유 키 값
	        - 선택 수집 항목: [카카오] 프로필 정보(프로필 사진)
	        * 선택 수집 항목은 정보를 제공받으나 저장하지 않습니다.
	        • 수집 및 목적
	        1. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산
	        콘텐츠 제공, 물품배송 또는 청구서 등 발송, 본인 인증 및 구매, 요금 결제, 요금추심
	        2. 회원 관리
	        회원제 서비스 이용에 따른 본인 확인, 개인식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입 의사 확인, 가입 및 가입횟수 제한, 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달
	    </p>
	    </pre>
		</div>
        <div class="flex items-center py-2 col-span-2">
          <input id="PRIVACY_AGREE" name="PRIVACY_AGREE" type="checkbox" value="true" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
          <label for="PRIVACY_AGREE" class="ms-2 font-medium text-gray-900 dark:text-gray-300">개인정보 수집 및 이용에 동의합니다.</label>
        </div>
        <a href="#"  onclick="showDetails('privacyDetails')" class="underline hover:opacity-50 duration-150 text-primary-500">상세보기</a>
        <div class="items-center col-span-3" id="privacyDetails" style="display: none; overflow-y: scroll; max-height: 300px;">
	    <pre class="text-gray-500" style="font-size: 12px">
		<p>
		iOOM는 회원서비스 처리를 위하여 고객으로부터 최소한의 필수정보를 수집하며, 제공한 모든 개인정보는 별도의 동의가 없는 한 해당 목적 이외의 다른 목적으로 사용하지 않습니다.
	        • 수집항목
	        1. 최초 회원가입 시 회원 식별 및 최적화된 서비스 제공을 위해 아래와 같은 정보를 수집합니다.
	        - 필수 항목: 아이디, 비밀번호, 이름/기업명, 사업자등록번호, 담당자명(기업회원의 경우), 이메일 주소, 휴대전화번호, CI
	        2. 소셜 회원가입 시 SNS 연결 및 원활한 서비스 제공을 위해 아래와 같은 정보를 수집합니다.
	        - 필수 수집 항목: 이름, 소셜 이메일 주소, 소셜 고유 키 값
	        - 선택 수집 항목: [카카오] 프로필 정보(프로필 사진)
	        * 선택 수집 항목은 정보를 제공받으나 저장하지 않습니다.
	        • 수집 및 목적
	        1. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산
	        콘텐츠 제공, 물품배송 또는 청구서 등 발송, 본인 인증 및 구매, 요금 결제, 요금추심
	        2. 회원 관리
	        회원제 서비스 이용에 따른 본인 확인, 개인식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입 의사 확인, 가입 및 가입횟수 제한, 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달
	    </p>
	    </pre>
      </div>
        <!-- line -->
        <div class="col-span-3 my-3 h-[1px] bg-gray-200 mx-10"></div>
        <button 
        type="button" 
        onclick="joinDataConfirm()" 
        class="col-span-3 block w-full px-5 py-3 text-xl font-semibold text-center text-white bg-primary-700 rounded-lg hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">가입하기</button>
      </form>
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
    <!-- <a class="block" href="tel:+82-02-2038-8299"> -->
    <a class="block">
      <i class="fa-regular fa-phone-volume"></i>
      +82-2-2038-8299
    </a>
  </div>
</footer>
	   <div class="modal fade fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300" id="searchCmpnyPopUp"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" style="display: none; ">
	 <div class="modal-close absolute top-0 left-0 w-full h-full"></div>
		<div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); width:800px;" >
			<div class="modal-content bg-white shadow-lg relative rounded min-w-80 overflow-hidden">
				<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center justify-between">
					<h4 class="modal-title">
						<span>회사 검색</span>
					</h4>
					<button type="button" onclick="cmpnySearchPopupClose()" class="modal-close text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
					</div>
					<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center justify-between">
						<div class="p-3" style="width: 300px;" align="center">
			                <label for="currency-group-search" class="sr-only">Search</label>
			                <div class="relative">
			                  <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
			                    <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
			                      <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
			                    </svg>
			                  </div>
			                  <input type="text" id="cmpnySrch1" onkeyUp="enterKeyPopUp();" class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
			                </div>
	              		</div>
					</div>
					<div class="modal-body">
						<div id="cmpnyPopupTable" class="grow bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200 z-0"></div>
				    </div> 
		    </div>
	   </div>
  </div>
</body>
</html>
