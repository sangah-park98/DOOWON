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
 <title>타관세사 데이터(수입)</title>
 <script src="/pf/js/import/cusImpUpload.js?v=<%=fmt.format(today)%>" charset="UTF-8"></script>
 <script src="/pf/js/function.js"></script>
 <script src="/pf/js/3rd/plugins/dropzone.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.70/jquery.blockUI.min.js"></script>
 <link href="/pf/css/3rd/plugins/dropzone.min.css" rel="stylesheet" /> 
 
 <style type="text/css">

 
 
 
 </style>
 
 
</head>
<body class="flex flex-col max-h-fit">
<main class="p-2 grow flex flex-col gap-2">
  <!-- Search Form -->
  <form
    class="w-full shrink-0 grid grid-rows-5 grid-cols-[auto_repeat(5,1fr)_auto_repeat(5,1fr)]
    row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg
    border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base
    items-center">
    <input type="hidden" id="grpCd" value="${grpCd}">
    <div class="row-start-1 col-span-6 col-end-13 flex flex-row gap-2 items-end justify-end">
      <button type="button" id="cusImpSearch"
      onclick="fn_searchCusImpView()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1">
        <i class="fa-regular fa-search mr-1"></i>
        	검색
      </button>
      <button type="button" id="cusImpClear"
        onclick="fn_clearCusImpView()"
        class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300">
        <i class="fa-regular fa-times mr-1"></i>
        	초기화
      </button>
    </div>
    <!-- 검색구분 -->
    <label class="col-start-1 row-start-1 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
      	검색구분
    </label>
	<div class="flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-1 items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900">
       <label>
       <input id="default-radio-1" type="radio" value="01" name="cusImpView_srch1" checked
               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>읽기</span>
      </label>
      <label for="default-radio-2">
        <input id="default-radio-2" type="radio" value="02" name="cusImpView_srch1"
               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>등록</span>
      </label>
    </div>
    <br>
     
    
  <label class="cusImp_div1 col-start-1 row-start-2 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
      	검색기간
    </label>
    <select
      id="cusViewDateType"
      class="cusImp_div1 row-start-2 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
      <option value="01" selected>신고일자</option>
      <option value="02">수리일자</option>
    </select>
    <div class="cusImp_div1 col-start-3 row-start-2 col-span-4 flex flex-wrap md:flex-nowrap items-center gap-1">
		 <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
			<input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
				id="cusImpView_srch2" name="cusImpView1_date"
				onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" 
				placeholder="시작일자" autocomplete="off">
		</div>
		 <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
			<input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
				id="cusImpView_srch3" name="cusImpView2_date"
				onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" 
				onkeyUp="fn_dateInputForm($(this))"
				placeholder="종료일자" autocomplete="off">
		</div>  
    </div> 
 
    <!-- Range Button -->
    <div class="flex items-center gap-1 col-start-7 row-start-2 col-span-4" id="cusImp_div2">
      <button
          type="button"
          onclick="fn_cusViewchgDate1()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        당일
      </button>
      <button
          type="button"
          onclick="fn_cusViewchgDate2()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        이번주
      </button>
        <button
          type="button"
          onclick="fn_cusViewchgDate3()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        당월
      </button>
      <button
          type="button"
         onclick="fn_cusViewchgDate4()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        전월
      </button>
    </div>
    <!-- / Range Button -->
    <!-- 신고번호 -->
    <label for="n0" class="cusImp_div3 row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2">
      신고번호
    </label>
    <input
      type="text"
      id="cusImpView_srch4"
      onkeyup="enterkey()"
      class="cusImp_div3 row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="수입신고번호를 입력해주세요.
    ">
    <!-- B/L 번호 -->
    <label for="n2" class="cusImp_div4 row-start-3 col-start-7 flex items-center font-medium text-gray-900 px-2">
    	B/L 번호
    </label>
    <input type="text" id="cusImpView_srch5" onkeyup="enterkey()"
            class="cusImp_div4 row-start-3 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="B/L번호를 입력해주세요.">
    <select
      id="cusViewSrchType1" style="width:100px;"
      class="cusImp_div5 row-start-4 col-start-1 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-1 py-1">
      <option value="" selected>조건선택</option>
      <option value="nab_firm">납세의무자</option>
      <option value="sup_firm">무역거래처</option>
      <option value="Exc_Cot">거래구분</option>
      <option value="Con_Ki_Cot">결제방법</option>
      <option value="Con_Cod">인코텀즈</option>
      <option value="sup_st">해외공급자부호</option>
      <option value="fod_mark">적출국(부호)</option>
      <option value="ori_st_prf_yn">FTA적용여부</option>
      <option value="rmv">감면여부</option>
      <option value="rpt_yn">확정신고대상여부</option>
      <option value="plnt_cd">부서코드</option>
      <option value="pr_ordr">PO</option>
      <option value="reporter">신고인</option>
    </select>
    <input
      type="text"
      id="cusViewSrchText1"
      onkeyup="enterkey()" 
      class="cusImp_div6 row-start-4 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
      placeholder=""
    >
    <select
      id="cusViewSrchType2" style="width:100px;"
      class="cusImp_div6 row-start-4 col-start-7 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-1 py-1">
      <option value="" selected>조건선택</option>
      <option value="nab_firm">납세의무자</option>
      <option value="sup_firm">무역거래처</option>
      <option value="Exc_Cot">거래구분</option>
      <option value="Con_Ki_Cot">결제방법</option>
      <option value="Con_Cod">인코텀즈</option>
      <option value="sup_st">해외공급자부호</option>
      <option value="fod_mark">적출국(부호)</option>
      <option value="ori_st_prf_yn">FTA적용여부</option>
      <option value="rmv">감면여부</option>
      <option value="rpt_yn">확정신고대상여부</option>
      <option value="plnt_cd">부서코드</option>
      <option value="pr_ordr">PO</option>
      <option value="reporter">신고인</option>
    </select>
    <input
      type="text"
      id="cusViewSrchText2"
      onkeyup="enterkey()"
      class="cusImp_div6 row-start-4 col-span-5 col-start-8 bg-gray-50 border border-gray-300 text-gray-900
      text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
      placeholder=""
    >
  </form>
  
  <!--업로드  -->
 <div id = "cusImpUp_div1">
	<div class="card-header header-elements-inline">
	      <h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0">
	          <a class="text-default" data-toggle="collapse" href="#accordion-upload-1" aria-expanded="true">데이터 업로드</a>
	          <small style="color:red;">엑셀파일이 아닌 데이터는 파일업로드가 안됩니다.</small>
		         <div class="col-lg-12 rowflex">
		              <button type="button"
				        onclick="fn_dropzoneReset()"
				        class="cancel text-primary-600 bg-primary-100 border border-primary-400 hover:bg-secondary-300
				        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-0.5 py-0.5 focus:outline-none duration-300
				      "style = "margin-left: 10px; margin-top: 10px;">
				      <i class="fa fa-minus"></i>
				       	전체삭제
				      </button>
		             <button type="button"
				      	onclick="fn_submitFileUpload()"
				        class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-1.5 py-1 focus:outline-noneduration-300 row-start-1 text-base"
				        style = "margin-left: 20px;margin-top: 10px;">
			         <i class="fa-regular fa-upload"></i>
			        	파일업로드
	      			</button>
	      			<div class="mx-5 py-4 border-t-2 flex gap-2 border-t" style="z-index: 2;">	
	      			<label class="cusImp_div7 col-start-1 row-start-3 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
						    일반구분
						</label>
						<div class="cusImp_div7 flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-3 items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900">
						    <label>
						        <input id="default-radio-1" type="radio" value="04" name="cusImpView_srch6" 
						               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
						        <span>레디</span>
						    </label>
						    <label>
						        <input id="default-radio-2" type="radio" value="05" name="cusImpView_srch6"
						               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
						        <span>엔컴</span>
						    </label>
						</div>
							      			 
						 </div>
	<div class="mx-5 py-4 border-t-2 flex gap-2 border-t" style="z-index: 2;">	
	<label class="cusImp_div7 col-start-1 row-start-3 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2">
	    특송구분
	</label>
	<div class="cusImp_div7 flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-3 items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900">
	    <label>
	        <input id="default-radio-1" type="radio" value="01" name="cusImpView_srch6" 
	               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <span>FEDEX</span>
	    </label>
	    <label>
	        <input id="default-radio-2" type="radio" value="02" name="cusImpView_srch6"
	               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <span>DHL</span>
	    </label>
	    <label>
	        <input id="default-radio-3" type="radio" value="03" name="cusImpView_srch6"
	               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <span>UPS</span>
	    </label>
	    <!-- <label>
        <input id="default-radio-2" type="radio" value="04" name="cusImpView_srch6"
               class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>TNT</span>
    </label> -->
</div>
	      			 
 </div>
		     </div>
	      </h6>
	  </div>
	  
		 <!-- 프로그래스 바  -->
		<div id="total-progress" class="progress" style="background-color:#ffdead00">
		    <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
		    </div>
		</div>
	    <!-- 드롭박스  -->
		<form class="dropzone" id="dropzone-file-imp" enctype="multipart/form-data" method="POST" action="${contextPath}/data/fileUpload" style="border: 1px soild #006E51 !important; border-radius: 15px !important; background: #EFF5F2 !important;">
		    <div class="fallback">
		        <input name="file" type="file" multiple  />
		    </div>
		</form> 
		<div class="mx-5 py-4 border-t-2 flex justify-end gap-2 border-t" style="z-index: 1;">
	     <input type="hidden" name="invoiceNo" id="invoiceNo" />
	     <input type="hidden" name="rptNo" id="rptNo" />
	   </div> 
	  
	  <!-- 성공 실패 여부 -->
   </div>
  
  <!-- / Search Form -->
  <!-- Table Label -->
  <div class="flex items-center justify-between">
    <div class="flex items-center gap-4" id="cusView_div6">
      <h2 id="cusViewTextView" class="shrink-0 flex items-center gap-1"></h2>
      <p class="card-title inline cusImpResult" style="line-height: 39px">결과: <span id="cusViewCnt">0</span>
	  </p>
    </div>
   <div class="flex items-center gap-2">
      <!-- <a href="#" class="text-base text-primary-600 hover:underline" onclick="fn_cusViewExcelDownload()">Excel 다운로드</a> -->
      <button
      	 type="button" id="dataDelete"
      	 onclick="fn_cusImpViewdelete()"
         class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-solid fa-minus"></i>
                 데이터 삭제
      </button>	
      
      <button
      	 type="button" id="excelDownload"
      	 onclick="fn_cusImpViewExcelDownload()"
         class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        Excel 다운로드
      </button>	
      <select 
      id="cusImpViewPageCnt"
      name="cusImpViewPageCnt"
      class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
        <option value="50" >ROWS[50]</option>
        <option value="100" >ROWS[100]</option>
        <option value="150" >ROWS[150]</option>
        <option value="200" >ROWS[200]</option>
      </select>
    </div>
  </div>
  <!-- / Table Label -->
  <!-- Main Table -->
  <div id="cusImpViewTable" class="grow bg-white shadow-sm rounded-lg border border-slate-200 z-0"></div>
  <!-- Sub Table -->
  <div class="grow grid grid-cols-2 min-h-[7rem] grid-rows-[1fr] gap-0">
    <div class="bg-white shadow-sm rounded-lg border border-slate-200" id="cusImpViewLanTable"></div>
    <div class="bg-white shadow-sm rounded-lg border border-slate-200" id="cusImpViewSpecTable"></div>
  </div>
  
  <!-- rptNo file popup -->
  <div class="modal fade fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300" id="cusViewFileListPopUp"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true" style="display: none; ">
		<div class="modal-close absolute top-0 left-0 w-full h-full"></div>
		<div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); width:800px;" >
			<div class="modal-content bg-white shadow-lg relative rounded min-w-80 overflow-hidden">
				<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center justify-between">
					<h1 class="impModal-title">
						<span></span>
					</h1>
					<button type="button" onclick="cusViewFileListClose()" class="modal-close text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
				</div>
				<div class="pl-7 pr-5 py-2 flex items-center justify-end">
				    <button type="button" onclick="fn_cusViewFileDown()" class="px-3 py-2 rounded-lg text-white hover:opacity-50 border-2 border-transparent duration-150 bg-primary-700 ">
			        <i class="fa-regular fa-download"></i>&nbsp;다운로드
			        </button>
				</div>
				 <div class="modal-body">
					 <div class="grow
						  bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200
						  z-0" id="customsImpViewListPopupTable">
					</div>
					  <form name="cusViewZipDownForm" method="post">
						<input type="hidden" name="cusViewZipDown" id="cusViewZipDown" />
						<input type="hidden" name="docuOrgFile" id="docuOrgFile" />
						<input type="hidden" name="docuFile" id="docuFile" />
					  </form>
				</div> 
			</div>
		</div>
	</div>
</main>

<div class="modal-popup-cusImpUpl fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300 hidden">
  <div class="modal-close absolute top-0 left-0 w-full h-full"></div>
  <!-- Uploader Modal content -->
  <div class="modal-cusImpUpl hidden modal-content bg-white shadow-xl relative rounded min-w-96 overflow-hidden">
    <div class="pl-3 pr-3 py-2 text-white bg-primary-900 flex items-center justify-between">
      <h2 class="font-bold text-lg">업로드 결과입니다. <br>*데이터 상태에 따라 결과가 다를 수 있습니다.</h2>
      <button type="button" class="modal-close-cusImpUpl text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
    </div>
	<div class="flex items-center justify-center w-full">
	 		 <table class="anaylsis-table w-full">
              <thead id="dashHead1" style=" position: sticky; top: 0;">
				<tr>
					<th>파일명</th>
					<th>업로드 여부</th>
					<th>공통 건수</th>
					<th>란 건수</th>    
					<th>규격 건수</th>    
					<th>실패 사유</th>
				</tr>
              </thead>
              <tbody id="cusImpUplInfo">
              </tbody>
            </table>
	  
	  
	</div>

  </div>
</div>

<form id="cusViewForm" action="" method="post"></form>
<script>
Dropzone.autoDiscover = false;

var alertTriggered = false;

var totalMain = 0;  // 공통 건수 누적 변수
var totalLan = 0;   // 란 건수 누적 변수
var totalSpec = 0;  // 규격 건수 누적 변수
var failCount = 0;  // 실패건수
var successCount = 0; //성공건수
var serverResponses = [];




var dropzone = new Dropzone("#dropzone-file-imp", {
    url: "/cusImp/fileUploadTemp.do",
    method: "POST",
    paramName: "files",
    timeout: 6000000,
    autoQueue: false, // 드래그 드랍 후 바로 서버로 전송하지 않음
    autoProcessQueue: true,
    autoDiscover: false,
    parallelUploads: 10,
    previewsContainer: "#dropzone-file-imp",
    acceptedFiles: ".xlsx,.xls", // 포맷 가능한 파일
    dictInvalidFileType: "not Format.",
    addRemoveLinks: true, // 파일 업로드 취소 링크 표시 여부
    dictCancelUpload: "cancel", // 파일 업로드 취소 버튼 레이블
    dictRemoveFile: "delete", // 파일 삭제 버튼 레이블
    clickable: "#dropzone-file-imp",
    addRemoveLinks: true,
    maxFiles: 10,
    params: function() {
        // 최신의 라디오 버튼 값을 가져와서 type으로 설정
        var type = $("input:radio[name=cusImpView_srch6]:checked").val();
        // 선택되지 않았을 경우 기본값을 0으로 설정
        if (typeof type === 'undefined') {
            alert("타입을 선택해주세요.");
            return; // type이 없을 때 업로드를 막음
        }
        return {
            type: type
        };
    },
    init: function() {
    	
    	document.querySelector('.modal-close-cusImpUpl').style.display = 'none';
    	
    	this.on("sending", function(file) {
            // 파일 업로드가 시작될 때 로딩 애니메이션 표시
             var tableBody = document.getElementById('cusImpUplInfo');
            var row = document.createElement('tr');
            row.setAttribute('data-file-name', file.name);
            
            var fileNameCell = document.createElement('td'); //파일명
            var statusCell = document.createElement('td'); //진행상태
            
            fileNameCell.textContent = file.name; 
            statusCell.innerHTML = "<img class='loadingTable' src='/pf/css/images/loading-table-unscreen.gif' style='width: 25px; height: 25px; display: block; margin: auto;' />";

            row.appendChild(fileNameCell);
            row.appendChild(statusCell);
            tableBody.appendChild(row);
        });

    	this.on("success", function(file, response) {
    	  
    	    var serverResponse;
    	    
    	    try {
    	        if (typeof response === 'string') {
    	            serverResponse = JSON.parse(response);
    	        } else {
    	            serverResponse = response;
    	        }
    	    } catch (e) {
    	        console.error("Error parsing response:", e);
    	        serverResponse = {}; // Set to an empty object to avoid breaking the code
    	    }

    	    // Proceed with processing the response
    	    var tableBody = document.getElementById('cusImpUplInfo');
    	    var row = tableBody.querySelector('tr[data-file-name="' + file.name + '"]');

    	    if (row) {
    	        var statusCell = row.children[1]; // 진행상태 열 (두 번째 <td>)
    	        if (statusCell) {
    	            if (serverResponse.fail && serverResponse.fail === 1) {
    	                statusCell.innerHTML = "<img class='completeTable' src='/pf/css/images/error.png' style='width: 17px; height: 17px; display: block; margin: auto;' />";
    	            } else {
    	                statusCell.innerHTML = "<img class='completeTable' src='/pf/css/images/complete.png' style='width: 25px; height: 25px; display: block; margin: auto;' />";
    	            }

    	            // 결과 테이블 업데이트
    	            var fileNameCell = row.children[0]; // 파일명 열 (첫 번째 <td>)
    	            //var successCell = document.createElement('td'); // 성공여부
    	            var mainCell = document.createElement('td'); // 공통
    	            var lanCell = document.createElement('td'); // 란
    	            var specCell = document.createElement('td'); // 규격
    	            var reasonCell = document.createElement('td'); // 실패사유

    	            if (serverResponse.fail && serverResponse.fail === 1) {
    	               // successCell.innerHTML = "<span style='color: red; font-weight: bold;'>X</span>";
    	                mainCell.textContent = "-";
    	                lanCell.textContent = "-";
    	                specCell.textContent = "-";
    	                reasonCell.textContent = serverResponse.failReason;
    	            } else {
    	                //successCell.innerHTML = "<span style='color: blue; font-weight: bold;'>O</span>";
    	                mainCell.textContent = serverResponse.main || 0;
    	                lanCell.textContent = serverResponse.lan || 0;
    	                specCell.textContent = serverResponse.spec || 0;
    	                reasonCell.textContent = "-";
    	            }

    	           // row.appendChild(successCell);
    	            row.appendChild(mainCell);
    	            row.appendChild(lanCell);
    	            row.appendChild(specCell);
    	            row.appendChild(reasonCell);
    	        }
    	    }
    	});

         this.on("addedfile", function(file) {
             var duplicateFiles = this.files.filter(function(existingFile) {
                 return existingFile.name === file.name;
             });

             if (duplicateFiles.length > 1) {
                 this.removeFile(file);
                 alert(uploadArray[10]["CODE_NAME"]);
             }
         });

         this.on("maxfilesexceeded", function(file) {
             this.removeFile(file); // 초과한 파일 제거

             if (!alertTriggered) {
                 alert("최대 10개 파일만 업로드할 수 있습니다."); // 경고 메시지
                 alertTriggered = true; // 경고창이 떴음을 기록
             }
         });
     },
     queuecomplete: function() {
    	 
    	 document.querySelector('.modal-close-cusImpUpl').style.display = 'block';
     }
    
 });
	/* 모달 닫기 로직 */
	
	
    /* 프로그래스 바 */
    dropzone.on("uploadprogress", function(file, progress, bytesSent) {
        var totalProgress = Math.round((bytesSent / file.size) * 100);
        // 전체 진행 상태를 업데이트합니다.
        var totalProgressBar = $("#total-progress .progress-bar");
        totalProgressBar.attr("aria-valuenow", totalProgress);
        totalProgressBar.css("width", totalProgress + "%");
    }); 

    /* 프로그래스 바 */
    dropzone.on("queuecomplete", function() {
        // 전체 진행 상태를 초기화합니다.
        var totalProgressBar = $("#total-progress .progress-bar");
        totalProgressBar.attr("aria-valuenow", 0);
        totalProgressBar.css("width", "0%");
    }); 
    
    
    function fn_resultCusImpUpload() {
    	
    	//업로드 Modal Action
    	const modalCusImpUpload = document.querySelector('.modal-popup-cusImpUpl')
    	const modalCusImp = document.querySelector('.modal-cusImpUpl')
    	modalCusImpUpload.classList.remove('hidden')
    	modalCusImpUpload.classList.add('flex')
    	modalCusImp.classList.remove('hidden')
    	modalCusImp.classList.add('block')


    }


    function fn_CloseCusImpUpload() {
    	const modalCusImpUpload = document.querySelector('.modal-popup-cusImpUpl')
    	//const contactModal = document.querySelector('.contact-modal')
    	const modalCusImp = document.querySelector('.modal-cusImpUpl')
    	modalCusImpUpload.classList.remove('flex')
    	modalCusImpUpload.classList.add('hidden')
    	modalCusImp.classList.remove('block')
    	modalCusImp.classList.add('hidden')
    	dropzone.removeAllFiles(true);
    	$("input:radio[name=cusImpView_srch1]:input[value='02']").trigger("click");
    	fn_searchCusImpView();
    	popupState = false;
    }


    const modalCloseCusImpUpload = document.querySelector('.modal-close-cusImpUpl');
    modalCloseCusImpUpload.addEventListener('click', fn_CloseCusImpUpload);
    
    
</script>
</body>
</html>
