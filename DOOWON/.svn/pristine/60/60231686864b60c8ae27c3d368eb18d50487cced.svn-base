<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head xmlns="http://www.w3.org/1999/xhtml">
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>iOOM PLATFORM</title>



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
<link rel="stylesheet" crossorigin href="/pf/assets/style.css">
<script type="module" crossorigin src="/pf/assets/modulepreload-polyfill.js"></script>
<!-- <script type="module" crossorigin src="/pf/assets/vendor.js"></script> -->
<script type="module" crossorigin src="/pf/assets/dropdown-init.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
 <script src="https://gcore.jsdelivr.net/npm/chart.js"></script>

<!-- <script src="/fta/js/3rd/plugins/nuslider.min.js"></script> -->
<!-- <script src="/fta/js/3rd/scripts/nuslider.script.min.js"></script> -->

<script src="/pf/js/base/main.js" charset="UTF-8"></script>

</head>

 <!-- 회원정보 -->
<c:forEach var="userInfo" items="${userInfo}">
	<c:set var="MEMBER_ID" value="${userInfo.MEMBER_ID}"/>
	<c:set var="MEMBER_NAME" value="${userInfo.MEMBER_NAME}"/>
	<c:set var="MEMBER_EMAIL" value="${userInfo.MEMBER_EMAIL}"/>
	<c:set var="grpCd" value="${userInfo.grpCd}"/>
</c:forEach>



<script type="text/javascript">

	var colLang = "${lang}";
	var colLogoutMsg = "${logoutMsg}";
	var colCurrCmpnyCd = "${currCmpnyCd}";
	var msgdateComparison = "${dateComparison}";
	var msgAfterToday = "${msgAfterToday}";
	var colAuthor = "${author}";
	var colNation = "NATION";
</script>
<style>

	.loading-back {
	    width: 100%;
	    height: 1060px;
	    background-color: #000000;
	    position: absolute;
	    z-index: 9999;
	    opacity: 0.5;
	    display: none;
    }
    
    .loading-img {
    	margin: auto;
	    width: 10%;
	    height: 15%;
	    display: table-cell;
	    align-items: center;
	    vertical-align: middle;
	    margin-top: 15%;
    }
    
    header {
    margin: 0;
    padding: 0;
	}
    
    .main-content {
         margin: 0;
   		 padding: 0;
   		 height : 100%;
   		 z-index: 1;
      }
      
    ul.nav-tabs {
    	list-style: none;
    }
    
    li.nav-item {
    	float: left;
    }
    
    body {
    
    height: 100%;
    
    }
    
    
    
</style>

<body class="flex flex-col justify-between bg-slate-50">
  <header class="z-10 w-full shrink-0 bg-primary-50 relative">
    <!-- Navbar -->
    <div class="w-full pt-3 pb-1 px-4 flex flex-row gap-4 justify-between items-center relative z-50">
      <!-- Logo -->
      <a href="/cmmn/main.do" class="grow-0 flex items-center justify-start">
        <img src="data:image/svg+xml,%3c?xml%20version='1.0'%20encoding='UTF-8'?%3e%3csvg%20id='Layer_1'%20xmlns='http://www.w3.org/2000/svg'%20viewBox='0%200%20587.75%20180'%3e%3cpath%20d='M28.99,36.85H0V0h41.27v26.38c0,7.05-4.03,10.47-12.28,10.47ZM.4,180V52.95h40.67v112.95c0,8.25-7.45,14.09-16.11,14.09H.4Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M426.67,180V5.64h45.3l35.23,100.27,35.03-100.27h45.5v160.27c0,8.25-7.45,14.09-16.11,14.09h-24.76v-82.15c0-.6,0-2.21.2-4.63.2-2.62.2-4.23.2-5.03l-.81,4.23c-.2,2.21-.6,3.83-.81,4.43l-19.53,56.78c-2.21,6.64-7.25,10.47-14.3,10.47h-19.53l-22.95-68.46c-.6-1.81-1.21-7.85-2.01-9.66.2,1.21.2,3.22.2,5.84v74.09c0,8.25-7.45,14.09-16.11,14.09h-24.76Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3cpath%20d='M318.23,180c-31.16,0-58.88-30.95-69.64-44.69-2.94-3.75-3.21-8.95-.71-13l11.83-19.15c.76-1.23,2.5-1.33,3.4-.19,7.32,9.3,35.19,42.95,55.13,42.95,29.11,0,52.79-23.68,52.79-52.79s-23.68-52.79-52.79-52.79c-10.54,0-26.53,10.63-43.88,29.17-15.17,16.21-26.15,32.81-26.26,32.98,0,0-19.46,25.96-29.92,37.18-24.95,26.77-48.21,40.34-69.12,40.34-47.9,0-86.88-38.97-86.88-86.88S101.15,6.25,149.05,6.25c34.14,0,59.41,25.94,72.99,42.63,3.57,4.39,3.64,10.65.14,15.09l-14.41,18.29c-.69.87-2,.89-2.71.03-6.58-8.02-35.61-41.96-56-41.96-29.11,0-52.79,23.68-52.79,52.79s23.68,52.79,52.79,52.79c10.54,0,26.53-10.63,43.88-29.17,15.17-16.21,26.15-32.81,26.26-32.98l5.76-7.68c5.16-7.13,13.69-18.28,24.16-29.5,24.95-26.77,48.21-40.34,69.12-40.34,47.9,0,86.88,38.97,86.88,86.88s-38.97,86.88-86.88,86.88Z'%20style='fill:%23006e51;%20stroke-width:0px;'/%3e%3c/svg%3e" class="h-8" alt="Platform Logo">
      </a>
      <!-- /Logo -->
      <!--  Navbar Links -->
      
      <nav class="grow flex items-center justify-center max-w-5xl @container group/navigation hover:shadow-xl duration-300 rounded-lg text-xs sm:text-sm md:text-base relative gap-0 md:gap-1 px-2 xl:gap-2 *:grow">
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer pb-1 pt-2 px-2 font-bold">
                <i class="fa-duotone fa-bullhorn"></i>공지사항</span>
            <span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="mainNotice" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/mainNotice.do">공지사항</span></a>
            <a href="#" id="news" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/news.do">관세뉴스</span></a>
          </div>
        </div>
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer pb-1 pt-2 px-2 font-bold"><i class="fa-duotone fa-inbox-in fa-rotate-270"></i>수입신고</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="importBl" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/import/importBl.do">BL등록</span> </a>
            <a href="#" id="importView" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/import/importView.do">수입 신고 현황</span></a>
            <a href="#" id="importUpdate" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/import/importUpdate.do">수입 신고 정정</span></a>
          </div>
        </div>
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer pb-1 pt-2 px-2 font-bold"><i class="fa-duotone fa-inbox-out fa-rotate-90"></i>수출신고</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="exportIn" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/export/exportIn.do">INVOICE 등록</span></a>
            <a href="#" id="exportView" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/export/exportView.do">수출 신고 현황</span></a>
            <a href="#" id="exportUpdate" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/export/exportUpdate.do">수출 신고 정정</span></a>
          </div>
        </div>
         
         
         <c:if test="${!grpCd.equals('Client Basic')}">
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer
    pb-1 pt-2 px-2
    font-bold"><i class="fa-duotone fa-cart-flatbed-boxes"></i>ITEM 관리</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="itemInfo" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/item/itemInfo.do">ITEM 정보</span></a>
          </div>
        </div>
      
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer
  font-bold
    pb-1 pt-2 px-2
    "><i class="fa-duotone fa-file-circle-check"></i>서류관리</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="documentView" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/docu/documentView.do">서류관리</span></a>
          </div>
        </div>
          </c:if>

        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer
        font-bold
    pb-1 pt-2 px-2
    "><i class="fa-duotone fa-display-chart-up-circle-currency"></i>분석 및 리스크</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
           <a href="#" id="deadLine" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/rpt/deadLine.do">기한 관리</span></a>
           
            <c:if test="${!grpCd.equals('Client Basic')}">
            <a href="#" id="kpi" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/rpt/kpi.do">KPI 관리</span></a>
            <a href="#" id="analysis" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/rpt/analysis.do">통계 분석</span></a>
            </c:if>
            <c:if test="${!grpCd.equals('Client Basic') && !grpCd.equals('Client Advanced')}">
            <a href="#" id="calculate" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/rpt/calculate.do">비용정산</span></a>
          	</c:if>
          </div>
        </div>
        
      <c:if test="${grpCd eq 'KORD Mgr'}">
        <div class="group/button duration-200 relative z-10">
          <div class="py-1 duration-200 hover:text-primary-600 relative block rounded overflow-hidden"><span class="
          font-bold
          flex items-center justify-center gap-2 duration-200 text-nowrap cursor-pointer pb-1 pt-2 px-2"><i class="fa-duotone fa-gears"></i>시스템 관리</span><span class="block h-1 bg-primary-500 w-full scale-x-0 group-hover/button:scale-x-100 duration-200"></span></div>
          <div class="absolute top-[100%] left-0 w-full h-0 group-hover/navigation:h-[260px] flex items-center justify-start flex-col overflow-hidden duration-200 ease-in-out px-1 group-hover/button:bg-primary-400/10">
            <a href="#" id="pfUser" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfuser.do">사용자 관리</span></a>
            <a href="#" id="pfCmpny"class="rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfcompny.do">사업자 관리</span></a>
            <a href="#" id="pfMenu"class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfmenu.do">메뉴</span></a>
            <a href="#" id="pfauthor" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfauthor.do">권한</span></a>
            <a href="#" id="pfCmmncd"class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfcmmncd.do">시스템 코드</span></a>
            <a href="#" id="pfConect"class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/conectinfo.do">접속 정보</span></a>
            <a href="#" id="pfMsg" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/pfmsg.do">메시지</span></a>
            <!-- <a href="#" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/cmmn/notice.do">공지사항</span></a> -->
          </div>
        </div>
      </c:if>
        
        <div class="absolute left-0 top-0 z-0 w-full h-0 group-hover/navigation:h-[310px] group-hover/navigation:bg-white roup-hover/navigation:shadow-2xl rounded-xl duration-300"></div>
      </nav>
      <!--  // Navbar Links -->
      <div class="col-end-13 col-span-3 flex flex-wrap gap-2 justify-between items-center text-base
  lg:order-2">
		
  	    <div class="w-300 flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
	     
          <div class="relative w-full col-span-2">
		      <button
		        id="cmpnyButton"
		        onclick="fn_searchCmpny()"
		        class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
		        type="button">
		        ${currCmpnyCd}
		        <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
		          <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
		        </svg>
		      </button>
	      <div id="popup" class="hidden absolute top-0 left-0 right-0 bottom-0 bg-white border rounded-lg shadow-xl dark:bg-gray-700 overflow-auto">
	        <!-- 팝업 내용 -->
	        <div class="p-3">
	          <label for="final-group-search" class="sr-only">Search</label>
	          <div class="relative">
	            <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
	              <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
	                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
	              </svg>
	            </div>
	            <input type="text" id="final-group-search" class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
	          </div>
	        </div>
		        <ul 
		        	class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="termsOfTradeButton">
		        </ul>
		      </div>
		    </div>
		  </div>
		  <form action="/cmmn/saveCmpnySession.do" name="mainForm" id="mainForm"
			method="post">
			<input type="hidden" name="usrtaxNo" id="usrtaxNo" />
			<input type="hidden" name="usrCmpnyCd" id="usrCmpnyCd" />
		</form>
		
        <button type="button"
                class="flex mx-3 text-sm bg-gray-800 rounded-full md:mr-0 flex-shrink-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600"
                id="userMenuDropdownButton" aria-expanded="false" data-dropdown-toggle="userMenuDropdown">
          <span class="sr-only">Open user menu</span>
          <img class="w-6 h-6 rounded-full" src="/pf/assets/shinhanlogo.svg"
              alt="user photo">
        </button>

      <!-- User menu dropdown -->
      <div
        class="hidden z-50 my-4 w-56 text-base list-none bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700 dark:divide-gray-600"
        id="userMenuDropdown"
        data-popper-placement="bottom">
      <div class="py-3 px-4">
        <span class="block text-sm font-semibold text-gray-900 dark:text-white">${MEMBER_ID}</span>
        <span class="block text-sm font-semibold text-gray-900 dark:text-white">${grpCd}</span>
        
        
		<%-- <c:set var="COMP_NAME" value="${cmpnyInfo.COMP_NAME2}"/> --%>
		
        <c:forEach var="cmpnyInfo" items="${cmpnyInfo}">
        <span class="block text-sm text-primary-700 truncate dark:text-gray-400">${cmpnyInfo.COMP_NAME2}</span>
        </c:forEach>
        <span class="block text-sm font-light text-gray-500 truncate dark:text-gray-400">${MEMBER_EMAIL}</span>
      </div>
      <ul class="py-1 font-light text-gray-500 dark:text-gray-400 text-sm" aria-labelledby="userMenuDropdownButton">
        <li>
          <a href="#" id="myPage"
            class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-400 dark:hover:text-white">
            <span class="/member/myPage.do">계정 정보</span></a>
          <!--   <a href="#" id="importBl" class="py-1 rounded hover:bg-primary-500/30 text-nowrap duration-200 px-3 first:mt-3 last:mb-3 hover:font-bold"><span class="/import/importBl.do">BL등록</span> </a> -->
        </li>
        <li>
          <a href="#"
            class="block text-rose-600 font-semibold py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-400 dark:hover:text-white">계정
            전월 Report 출력 (PDF)</a>
		</li>
       <!--  <li class="company-selector">
          <button id="company-selector__dropdown" class="w-full px-4 py-2 flex items-center justify-start gap-2 hover:bg-gray-100">본지사 구분<span class="icon duration-150"><i class="fa-solid fa-chevron-down"></i></span></button>
          <ul class="company-selector__list mx-4 py-0 px-1.5 bg-slate-100 rounded text-slate-700 overflow-hidden">
            <li><button class="px-1.5 py-0.5 rounded hover:bg-slate-600 hover:text-white duration-150 block w-full text-left active">KORD SYSTEMS</button></li>
            <li><button class="px-1.5 py-0.5 rounded hover:bg-slate-600 hover:text-white duration-150 block w-full text-left">CONG TV TNHH AMO VINA</button></li>
            <li><button class="px-1.5 py-0.5 rounded hover:bg-slate-600 hover:text-white duration-150 block w-full text-left">ESTEC PHU THO CO.LTD</button></li>
            <li><button class="px-1.5 py-0.5 rounded hover:bg-slate-600 hover:text-white duration-150 block w-full text-left">KSV</button></li>
            <li><button class="px-1.5 py-0.5 rounded hover:bg-slate-600 hover:text-white duration-150 block w-full text-left">Test SIS</button></li>
          </ul>
        </li> -->
        <li>
          <a href="#"
            class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white" onclick="fn_logout()">로그아웃 </a>
        </li>
      </ul>
    </div>
    <!-- / User menu dropdown -->


     <!--    <button type="button"
                class="ml-3 text-gray-500 rounded-lg hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 dark:hover:text-white dark:hover:bg-gray-700 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600 flex itmes-center">
          <span class="sr-only">언어선택</span>
          <i class="fa-regular fa-globe text-[1.5rem]"></i>
        </button> -->

      </div>
	
		 <script>
        $("#userMenuDropdown").slideUp(0)
        $("#userMenuDropdownButton").on("click", function () {
       	 event.stopPropagation(); // 이벤트 전파 방지
          $('.dropdown-component').stop().slideUp(200)
          $("#userMenuDropdown").stop().slideToggle(200)
        });
        $("#company-selector").slideUp(0)
        $("#company-selector__dropdown").on("click", function () {
        	event.stopPropagation(); // 이벤트 전파 방지
          $('.dropdown-component').stop().slideUp(200)
          $("#company-selector").stop().slideToggle(200)
        });
       /*  $("#language-selector").slideUp(0)
        $("#language-selector-button").on("click", function () {
          $('.dropdown-component').stop().slideUp(200)
          $("#language-selector").stop().slideToggle(200)
        }); */
        $(document).on("click", function(event) {
            // 클릭된 요소가 토글 버튼이 아니면 토글 창을 닫음
            if (!$(event.target).is("#userMenuDropdownButton") || !$(event.target).is("#company-selector")) {
                $("#userMenuDropdown").slideUp(200);
            }
        });
      </script>
		
    </div>
 <!--     <div class="tab-button px-4 gap-2 flex flex-wrap text-base font-medium text-center text-gray-500 dark:text-gray-400 border-b border-b-primary-800">
      <a href="/pf/feedbacked/main"
        class="tab-button inline-flex w-44 bg-gray-200 border-gray-300 rounded-t-lg border-t border-l border-r items-center justify-center p-2 t-lg hover:text-gray-600 hover:border-primary-800 group gap-2 active"
        aria-current="page">
        <i class="fa-duotone fa-grid-2"></i>Dashboar </a>
    </div> -->
    <form action="/logout.do" name="logoutForm" id="logoutForm"
		method="post"></form>
		</header>
		

			<!-- ============ Body content START ============= -->
			<div class="main-content">
					<div id="tabs">
						<ul class="nav nav-tabs z-1 w-full shrink-0 bg-primary-50 relative tab-button px-4 gap-2 flex flex-wrap text-base font-medium text-center text-gray-500 dark:text-gray-400 border-b border-b-primary-800" id="myTab" role="tablist">
							<c:forEach var="basic" items="${basicMenuList}"
								varStatus="status">
								<li class="nav-item z-1 shrink-0 bg-primary-50 relative"><a class="nav-link tab-button inline-flex w-44 bg-gray-200 border-gray-300 rounded-t-lg border-t border-l border-r items-center justify-center p-2 t-lg hover:text-gray-600 hover:border-primary-800 group gap-2 active"
									id="tabs-${basic.menuId}" data-toggle="tab" href="${basic.url}"
									role="tab" aria-controls="" aria-selected="true">${basic.menuNm}</a></li>
							</c:forEach>
						</ul>
					</div> 
			</div>
	
	
	<!-- 공통팝업 start -->
	<div class="modal fade bd-example-modal-lg" id="cmmnPopup"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg modal-custom">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitleCmmn">
						<span id="txtCmmnPop1">공통코드</span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="flexWrapper">
							<div class="flexContent">
								<div class="flexInput">
									<div>
										<span id="txtCmmnPop3">코드</span></label> <input class="form-control"
											id="cmmnPop_srch1" type="text" placeholder="코드를 입력해주세요" />
									</div>
									<div>
										<span id="txtCmmnPop4">코드명</span></label> <input class="form-control"
											id="cmmnPop_srch2" type="text" placeholder="코드명을 입력해주세요" />
									</div>
								</div>

							</div>
							<div class="flexContent flexBtn">
								<button class="btn btn-primary m-1" type="button"
									id="btnCmmnPop" onclick="fn_searchCmmnPop();">
									<span id="txtCmmnPop6">검색</span>
								</button>
							</div>
						</div>

						<!-- handson table -->
						<div id="cmmnCdPopup" style="margin-top: 3px"></div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 공통팝업 end -->
	<div class="loading-back" id="lodingBack">
		<img class="loading-img" id="loadingImg" src="/pf/css/images/loader_backinout.gif" />
	</div>
	
	
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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>