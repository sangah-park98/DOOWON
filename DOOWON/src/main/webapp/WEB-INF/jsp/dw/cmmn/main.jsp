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
<body class="flex flex-col justify-between">
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
	
	<div class="loading-back fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300 hidden" id="lodingBack">
		<img class="loading-img" id="loadingImg" src="/dw/css/images/loader_backinout.gif" />
	</div>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</body>
</html>