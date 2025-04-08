<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date today = new Date();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
%>
<!DOCTYPE html>
<html lang="ko">

<head xmlns="http://www.w3.org/1999/xhtml">
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>DOOWON</title>
    
    <link type="text/css" rel="stylesheet" href="https://gcore.jsdelivr.net/gh/handsontable/handsontable@latest/dist/handsontable.full.css">
    <link rel="stylesheet" type="text/css" href="https://gcore.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.css">
    <script src="https://gcore.jsdelivr.net/npm/handsontable@latest/dist/handsontable.full.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/datepicker.min.js"></script>
    <script src="https://gcore.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//unpkg.com/alpinejs" defer></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js" integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0=" crossorigin="anonymous"></script> 
    
    <script type="text/javascript" src="https://gcore.jsdelivr.net/npm/handsontable/dist/handsontable.full.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>			  
    <script type="module" crossorigin src="/dw/assets/main-font.js"></script>
    <link rel="stylesheet" crossorigin href="/dw/assets/main-font.css">
    <link rel="stylesheet" crossorigin href="/dw/assets/style.css">
    <script type="module" crossorigin src="/dw/assets/modulepreload-polyfill.js"></script>
    <script type="module" crossorigin src="/dw/assets/dropdown-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://gcore.jsdelivr.net/npm/chart.js"></script>
    <script src="/dw/js/3rd/plugins/echarts.min.js"></script>
    <script src="/dw/js/3rd/scripts/echarts.script.min.js"></script>
    <script src="/dw/js/3rd/plugins/apexcharts.min.js"></script>
    <script src="/dw/js/3rd/plugins/apexcharts.dataseries.js"></script>
    <script src="/dw/js/calendar.full.min.js?v=<%=fmt.format(today)%>"></script>
    <script src="/dw/js/3rd/plugins/bootstrap.bundle.min.js"></script>
    <link href="/dw/css/calendar.css" rel="stylesheet" />
    <script src="/dw/js/base/main.js?v=<%=fmt.format(today)%>" charset="UTF-8"></script>
    <script src="/dw/js/cmmn/comUtil.js"></script>
</head>

 <!-- 회원정보 -->
<c:forEach var="userInfo" items="${userInfo}">
	<c:set var="MEMBER_ID" value="${userInfo.MEMBER_ID}"/>
	<c:set var="MEMBER_NAME" value="${userInfo.MEMBER_NAME}"/>
	<c:set var="MEMBER_EMAIL" value="${userInfo.MEMBER_EMAIL}"/>
	<c:set var="grpCd" value="${userInfo.grpCd}"/>
</c:forEach>

<style>
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
    body, html {
       height: 100%;
       margin: 0;
       display: flex;
       flex-direction: column;
    }
   .content {
       flex: 1;
   }
   #footer {
   	bottom: 0;
    left: 0;
    width: 100%;
    background-color: rgb(45, 126, 98); /* RGB 값 올바르게 수정 */
    color: #fff;
    text-align: center;
    padding: 10px;
    z-index: 1000;
    font-size: 1rem; /* 기본 폰트 크기 */
	}
</style>
<body class="flex flex-col justify-between bg-slate-50">
	<div class="col-end-13 col-span-3 flex flex-wrap gap-2 justify-between items-center text-base lg:order-2">
  	    <div class="w-300 flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded"></div>
	  	<form action="/cmmn/saveCmpnySession.do" name="mainForm" id="mainForm" method="post"></form>
	</div>
    <form action="/logout.do" name="logoutForm" id="logoutForm" method="post"></form>
  
<div class="main-content">
	<div id="tabs">
		<ul class="nav nav-tabs z-1 w-full shrink-0 bg-primary-50 relative tab-button px-4 gap-2 flex flex-wrap text-base font-medium text-center text-gray-500 dark:text-gray-400 border-b border-b-primary-800" id="myTab" role="tablist">
			<li class="nav-item z-1 shrink-0 bg-primary-50 relative">
				<a href="/remains/remainsQty.do"></a>
			</li>
		</ul>
	</div> 
</div>
	
	<!-- 공통팝업 start -->
<!-- <div class="modal fade bd-example-modal-lg" id="cmmnPopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" style="display: none;">
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
					handson table
					<div id="cmmnCdPopup" style="margin-top: 3px"></div>
				</div>
			</div>
		</div>
	</div>
</div> -->
<div class="loading-back fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300 hidden" id="lodingBack">
	<img class="loading-img" id="loadingImg" src="/dw/css/images/loader_backinout.gif" />
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- <footer id="footer" class="w-full mx-auto flex justify-between justify-self-end items-center bg-primary-900 text-gray-200 px-6 py-2 gap-4 h-10">
    <span>KORD Systems Inc.</span>
    <span class="mr-auto">Copyright KORD Systems Inc. All rights reserved.</span>
    <a href="mailto:ioom@kordsystems.com"><i class="fa-regular fa-envelopes"></i>
      ioom@kordsystems.com
    </a>
    <p><i class="fa-regular fa-phone-volume"></i>
      +82-2-2038-8299
    </p>
    <div class="relative inline-flex" x-data="{ open: false, selected: 0 }">
      <button
          class="btn justify-between min-w-40 bg-white/30 dark:bg-slate-800 border-slate-200 hover:border-slate-300 text-white hover:text-slate-200 py-1"
          aria-label="Select date range"
          aria-haspopup="true"
          @click.prevent="open = !open"
          :aria-expanded="open">
        <span class="flex items-center">
            <span>참고사이트</span>
        </span>
        <svg class="shrink-0 ml-1 fill-current text-slate-400" width="11" height="7" viewBox="0 0 11 7">
          <path d="M5.4 6.8L0 1.4 1.4 0l4 4 4-4 1.4 1.4z"/>
        </svg>
      </button>
      <div
          class="z-10 absolute bottom-full left-0 w-full bg-white dark:bg-slate-800 border border-slate-200 dark:border-slate-700 py-1.5 rounded shadow-lg overflow-hidden mt-1"
          @click.outside="open = false"
          @keydown.escape.window="open = false"
          x-show="open"
          x-transition:enter="transition ease-out duration-100 transform"
          x-transition:enter-start="opacity-0 -translate-y-2"
          x-transition:enter-end="opacity-100 translate-y-0"
          x-transition:leave="transition ease-out duration-100"
          x-transition:leave-start="opacity-100"
          x-transition:leave-end="opacity-0"
          x-cloak>
        <div class="font-medium text-sm text-slate-600 dark:text-slate-300" x-ref="options">
		  <a href="https://www.customsservice.co.kr/" target="_blank" @click="open = false">
		    <button
		      tabindex="0"
		      class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
		      :class="selected === 1 && 'text-primary-900'"
		      @click="selected = 1; open = false"
		      @focus="open = false"
		      @focusout="open = false">
		      <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 1 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
		        <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
		      </svg>
		      <span>신한관세법인</span>
		    </button>
		  </a>
		  <a href="https://www.kordsystems.com/" target="_blank" @click="open = false">
		    <button
		      tabindex="0"
		      class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
		      :class="selected === 2 && 'text-primary-900'"
		      @click="selected = 2; open = false"
		      @focus="open = false"
		      @focusout="open = false">
		      <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 2 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
		        <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
		      </svg>
		      <span>코드시스템즈</span>
		    </button>
		  </a>
		  <a href="https://kordpartners.co.kr/" target="_blank" @click="open = false">
		    <button
		      tabindex="0"
		      class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
		      :class="selected === 3 && 'text-primary-900'"
		      @click="selected = 3; open = false"
		      @focus="open = false"
		      @focusout="open = false">
		      <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 3 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
		        <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
		      </svg>
		      <span>코드파트너스</span>
		    </button>
		  </a>
	  </div>
     </div>
    </div>
</footer> -->
</body>
</html>