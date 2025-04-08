<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date today = new Date();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>두원 잔량관리</title>
  <script src="/dw/js/remains/remainsQty.js?v=<%=fmt.format(today)%>" charset="UTF-8"></script>
  <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
  <script src="/dw/js/function.js"></script>
</head>
<body class="flex flex-col max-h-fit">
<main class="p-2 grow flex flex-col gap-2">
  <form class="w-full shrink-0 grid grid-rows-3 grid-cols-[auto_repeat(5,1fr)_auto_repeat(5,1fr)]
    			row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg
    			border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base
    			items-center">
    <div class="row-start-1 col-span-6 col-end-13 flex flex-row gap-2 items-end justify-end">
      <button type="button" id="btnSearch" onclick="fn_searchRemainsView()"
        	  class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300 row-start-1">
        <i class="fa-regular fa-search mr-1"></i>
        	검색
      </button>
      <button type="button" onclick="fn_remainsQtyClear()" class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300">
        <i class="fa-regular fa-times mr-1"></i>
        	초기화
      </button>
    </div>
    
    <label class="col-start-1 row-start-1 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
      	잔량여부
    </label>
    <div class="flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-1 items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900">
      <label for="default-radio-1">
        <input id="default-radio-1" type="radio" value="01"
          	   name="remainsView_srch1" checked="checked"
          	   class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>전체</span>
      </label>
      <label for="default-radio-2">
        <input id="default-radio-2" type="radio" value="02"
          	   name="remainsView_srch1" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
         <span>유</span>
      </label>
      <label for="default-radio-3">
        <input id="default-radio-3" type="radio" value="03"
          	   name="remainsView_srch1" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>무</span>
      </label>
      <!-- <label for="default-radio-4">
        <input id="default-radio-4" type="radio" value="04"
          	   name="remainsView_srch1" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>신고 전</span>
      </label>
      <label for="default-radio-5">
        <input id="default-radio-5" type="radio" value="05"
          	   name="remainsView_srch1" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>신고 후</span>
      </label> -->
    </div>
    
    <label class="col-start-1 row-start-2 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
      	검색기간
    </label>
    <select id="remainsDtType" class="row-start-2 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
      <option value="01" selected>신고일자</option>
      <option value="02">수리일자</option>
    </select>
    <div class="col-start-3 row-start-2 col-span-4 flex flex-wrap md:flex-nowrap items-center gap-1">
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
			   id="remainsView_srch2" name="remainsView1_date"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" 
			   autocomplete="off"> 
      </div>
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
			   id="remainsView_srch3" name="remainsView2_date"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" 
			   onkeyUp="fn_dateInputForm($(this))"
			   autocomplete="off">
      </div>
    </div>
    <div id="exportView_div1" class="col-start-7 row-start-2 col-span-4 flex items-center gap-1">
      <button id="today-button" type="button" onclick="fn_todayBtn()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700">
       	  당일
      </button>
      <button id="week-button" type="button" onclick="fn_weekBtn()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700">
		  이번주
      </button>
      <button id="last-month-button" type="button" onclick="fn_monthBtn()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700">
                    당월
      </button>
      <button id="this-month-button" type="button" onclick="fn_lastMonthBtn()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700">
                   전월
      </button>
    </div>
    
    <label for="n0" class="row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2">
      	신고번호
    </label>
    <input type="text" id="remainsView_srch4" onkeyup="enterkey()" class="row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
       	   placeholder="수출신고번호를 입력해주세요.">
    <label for="n2" class="row-start-3 col-start-7 flex items-center font-medium text-gray-900 px-2">INVOICE 번호</label>
    <input type="text" id="remainsView_srch5" onkeyup="enterkey()" 
           class="row-start-3 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
           placeholder="INVOICE번호를 입력해주세요.">
           
    <select id="remainsSrchType1" style="width:100px;" class="row-start-4 col-start-1 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-1 py-1">
    	<option value="" selected>조건선택</option>
      	<option value="rpt_no">수출신고번호</option>
      	<option value="buy_firm">해외거래처</option>
      	<option value="ran_no">란번호</option>
      	<option value="sil">규격번호</option>
      	<option value="hs">HS CODE</option>
      	<option value="gnm1">규격1</option>
      	<option value="qty">수출수량</option>
    </select>
    <input type="text" id="remainsSrchText1"
           class="row-start-4 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
      	   onkeyup="enterkey()">
      	   
    <select id="remainsSrchType2" style="width:100px;" class="row-start-4 col-start-7 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-1 py-1">
    	<option value="" selected>조건선택</option>
      	<option value="exp_firm">수출화주</option>
      	<option value="Ta_St_iso">목적국</option>
      	<option value="caseType">용기 Type</option>
      	<option value="importer">수입자</option>
    </select>
    <select id="remainsSrchType3" class="row-start-4 col-span-5 col-start-8 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1">
    	<option value="" selected></option>
	</select>
  </form>
  


<div id="transInfo-container" class="mx-auto p-3 border border-gray-300 w-full">
  <div class="flex items-center justify-between mb-3">
    <p class="card-title inline"><i class="fa-duotone fa-chart-network text-primary-900"></i>&nbsp;
    	전체 결과: <span id="remainsViewCnt">0</span>
    </p>
    <div class="flex items-center gap-2">
      <button type="button" onclick="fn_remainsViewExcelDown()"
        class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-none duration-300 row-start-1 text-base">
        <i class="fa-regular fa-download"></i>Excel 다운로드
      </button>
      <select id="remainsViewPageRow" name="remainsViewPageRow"
        class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
        <option value="50">ROWS[50]</option>
        <option value="100">ROWS[100]</option>
        <option value="150">ROWS[150]</option>
        <option value="200">ROWS[200]</option>
      </select>
    </div>
  </div>
  <div id="remainsViewTable" class="grow bg-white shadow-sm rounded-lg border border-slate-200 z-0"></div>
</div>
 

<div id="remainsRptNoListPopUp" class="modal fade fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" style="display: none; ">
	<div class="modal-close absolute top-0 left-0 w-full h-full"></div>
		<div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); width:800px;" >
			<div class="modal-content bg-white shadow-lg relative rounded min-w-80 overflow-hidden">
				<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center justify-between">
					<h1 class="remainsModal-title">
						<span></span> <!-- rptNo Title -->
					</h1>
					<button type="button" onclick="remainsRptNoPopUpClose()" class="modal-close text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
				</div>
				<div class="pl-7 pr-5 py-2 flex items-center justify-end">
					<button type="button" onclick="fn_remainsRptNoDown()" class="px-3 py-2 rounded-lg text-white hover:opacity-50 border-2 border-transparent duration-150 bg-primary-700 ">
				        <i class="fa-regular fa-download"></i>&nbsp;다운로드
				    </button>
				</div>
				 <div class="modal-body">
					 <div id="remainsRptNoPopUpTable" class="grow bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200 z-0"></div>
					  <form name="remainsRptNoZipDownForm" method="post" action="/remains/downloadFile.do">
						<input type="hidden" name="docuPath" id="docuPath" />
						<input type="hidden" name="docuFile" id="docuFile" />
						<input type="hidden" name="docuOrgFile" id="docuOrgFile" />
						<input type="hidden" name="remainsRptNoZipDown" id="remainsRptNoZipDown" />
					  </form>
				</div> 
			</div>
		</div>
	</div>
<form id="exportViewForm" action="" method="post"></form>

<div id="transInfo-container" class="mx-auto p-3 border border-gray-300 w-full" style="height: 230px;">
	<div class="flex items-center justify-between w-full shrink-0">
    	<div class="flex items-center gap-4">
    		<p class="card-title inline"><i class="fa-duotone fa-chart-network text-primary-900"></i>&nbsp;
	    		보정 정보<!-- : <span id="tradeGapLanPageCnt">0</span> -->
	    	</p>
      		<label for="default-radio-6" style="margin-left:20px;">
      			<input id="default-radio-6" type="radio" name="remainsInputType" value="read" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      			<span>읽기</span>
      		</label>
      		<label for="default-radio-7" style="margin-left:20px;">
      			<input id="default-radio-7" type="radio" name="remainsInputType" value="enrol" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      			<span>등록</span>
      		</label>
      		<!-- <label for="default-radio-8" style="margin-left:20px;">
      			<input id="default-radio-8" type="radio" name="remainsInputType" value="del" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      			<span>삭제</span>
      		</label> -->
    	</div>
    	<div class="flex items-center gap-2 ml-auto">
		    <button type="button" id="remainsInputSave" onclick="fn_remainsInputSave()" 
		      class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
		      <i class="fa-regular fa-floppy-disk"></i>
		      	저장
		    </button>
		    <button type="button" id="remainsInputDel" onclick="fn_remainsInputDel()" 
		      class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
		      <i class="fa-regular fa-floppy-disk"></i>
		      	삭제
		    </button>
		</div>
    </div>
    <input type="hidden" id="rptNo">
    <input type="hidden" id="expFirm">
    <input type="hidden" id="lanNo">
    <input type="hidden" id="sil">
	<div id="remainsInputTable" class="grow bg-white shadow-sm rounded-lg border border-slate-200 z-0"></div>
</div>
</main>
</body>
</html>
