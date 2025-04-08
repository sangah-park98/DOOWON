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
  <title>비용정산</title>
  <script src="/pf/js/function.js"></script>
  <script src="/pf/js/rpt/calculate2.js?v=<%=fmt.format(today)%>" charset="UTF-8"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.18.4/xlsx.full.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.4/xlsx.full.min.js"></script>
  
  <style type="text/css">
	.boldText {
    font-weight: bold; /* 굵게 */
}
  </style>
<!--     <style>
        .custom-time-dropdown, .custom-minute-dropdown {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            z-index: 10;
            max-height: 200px;
            overflow-y: auto;
            width: 100%;
        }

        .custom-time-dropdown.active, .custom-minute-dropdown.active {
            display: block;
        }

        .custom-time-option, .custom-minute-option {
            padding: 10px;
            cursor: pointer;
            background-color: white;
            border-bottom: 1px solid #eee;
        }

        .custom-time-option:hover, .custom-minute-option:hover {
            background-color: #f0f0f0;
        }

        .hidden {
            display: none;
        }
    </style> -->
</head>
<body class="flex flex-col max-h-fit">

<main class="p-2 grow flex flex-col gap-2">
  <form
    class="w-full shrink-0 grid grid-rows-3 grid-cols-[auto_repeat(5,1fr)_auto_repeat(5,1fr)]
    row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg
    border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base
    items-center">
    <div class="row-start-1 col-span-6 col-end-13 flex flex-row gap-2 items-end justify-end">
      <button 
      	type="button"
        onclick="fn_searchCalView()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1">
        <i class="fa-regular fa-search mr-1"></i>
       	 검색
      </button>
      <button
      	type="button"
      	onclick="fn_clearCalView()"
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
    
    <div
      id="item-radio"
      class="flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-1
      items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900">
      <label for="default-radio-2">
        <input
          id="default-radio-2"
          type="radio"
          value="01"
          name="calculate_srch1"
          checked
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>수입</span>
      </label>
<!--       <input type="time" class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400">
     
<div class="custom-time-picker relative w-20">
    <input type="text" class="custom-time-input bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 w-full" maxlength="2">
    <div class="custom-time-dropdown bg-white border border-gray-300 rounded-lg shadow-lg py-1 px-2.5 w-full">
        JavaScript로 시간 옵션 동적 생성
    </div>
</div>

Tailwind 클래스 사용한 분 선택기
<div class="custom-minute-picker relative w-20">
    <input type="text" class="custom-minute-input bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 w-full" maxlength="2">
    <div class="custom-minute-dropdown bg-white border border-gray-300 rounded-lg shadow-lg py-1 px-2.5 w-full">
        JavaScript로 분 옵션 동적 생성
    </div>
</div> -->
	     
      <!-- <label for="default-radio-3">
        <input
          id="default-radio-3"
          type="radio"
          value="02"
          name="calculate_srch1"
          onclick="handleRadioChange()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>수출</span>
      </label> -->
    </div>
    
    <!-- 검색기간 -->
    <label
      class="col-start-1 row-start-2 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2"
    >
      등록일자
    </label>
    <select
      id="calculate_day"
      name="calculate_day"
      class="row-start-2 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
      <option value="01" selected>신고일자</option>
      <option value="02">수리일자</option>
    </select>
    <!-- Calendar -->
    <div
      id="calculate_div1"
      class="col-start-3 row-start-2 col-span-4 flex flex-wrap md:flex-nowrap items-center gap-1
    ">
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                fill="currentColor" viewBox="0 0 20 20">
            <path
                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        
        <input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
			id="calculate_srch2" name="calculate1_date"
			onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" 
			placeholder="시작일자" autocomplete="off">   
      </div>
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                fill="currentColor" viewBox="0 0 20 20">
            <path
                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input type="text" class="form-control band-calendar text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
				id="calculate_srch3" name="calculate2_date"
				onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" 
				onkeyUp="fn_dateInputForm($(this))"
				placeholder="종료일자" autocomplete="off">
      </div>
      <!-- Range Button -->

    </div>

    <div id="calculate_div1" class="col-start-7 row-start-2 col-span-4 flex items-center gap-1">
      <button
          type="button"
          onclick="fn_calculChgDate1()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        당일
      </button>
      <button
          type="button"
          onclick="fn_calculChgDate2()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        이번주
      </button>
        <button
          type="button"
          onclick="fn_calculChgDate3()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        당월
      </button>
      <button
          type="button"
         onclick="fn_calculChgDate4()"
          class="py-2 px-4 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        전월
      </button>
    </div>
    <!-- 신고번호 -->
    <label for="n2" class="row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2">
      	신고번호
    </label>
    <input
      type="text"
      id="calculate_srch6"
      onkeyup="enterkey()"
      class="row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="신고번호를 입력해주세요."
    >
    <!-- B/L 번호 -->
    <label for="n3" id="blNoLabel" class="row-start-3 col-start-7 flex items-center font-medium text-gray-900 px-2">
      B/L 번호
    </label>
    <input
      type="text"
      id="calculate_srch7"
      onkeyup="enterkey()"
      class="row-start-3 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="B/L번호를 입력해주세요."
    >
    <!-- 부서코드 -->
    <!-- <label for="n1" class="row-start-4 col-start-1 flex items-center font-medium text-gray-900 pr-2">부서코드 </label>
	   <input
	      type="text"
	      id="calculate_srch8"
	      onkeyup="enterkey()"
	      class="row-start-4 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
	      placeholder="부서코드를 입력해주세요."
	    >
    PO 번호
    <label for="n5" id="poNoLabel" class="row-start-4 col-start-7 flex items-center font-medium text-gray-900 px-2">
      PO 번호
    </label>
    <input
      type="text"
      id="calculate_srch9"
      onkeyup="enterkey()"
      class="row-start-4 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="PO번호를 입력해주세요."> -->
  </form>

  <div class="flex items-center justify-between w-full shrink-0">
    <div class="flex items-center gap-4">
      <h2 id="calculTextView" class="shrink-0 flex items-center gap-1">
      </h2>
      <p class="card-title inline" style="line-height: 39px">결과: <span id="calculateCnt">0</span>
      </p>
    </div>
    
    <div class="flex items-center gap-2">

      
      <button
        type="button"
        class="download-button-docu h-9 text-white bg-primary-700 hover:bg-secondary-800 font-medium rounded px-2.5 py-2 text-base border border-primary-700 hover:border-secondary-400"
      	onclick="fn_excelUploadPopUp()"
      >
        <i class="fa-regular fa-upload"></i>
        Excel 업로드
      </button>
      
         <button
      	 type="button"
      	 onclick="fn_calculateExcelDownload(this)"
      	 data-download-type="01"
         class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-2 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        Excel 다운로드
      </button>
      <select 
        id="calculatePageCnt"
      	name="calculatePageCnt"
      	class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
        <option value="50" selected>ROWS [50]</option>
        <option value="100">ROWS [100]</option>
        <option value="200">ROWS [200]</option>
        <option value="500">ROWS [500]</option>
      </select>
    </div>
  </div>
  <!-- MainTable -->
  <div id="calculateTable"
       class="grow bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200 z-0">
  </div>
  
  <div class="grow grid grid-cols-22">
	   <div class="flex items-center justify-between w-full shrink-0">
	    <div class="flex items-center gap-4">
	      <h2 class="shrink-0 flex items-center gap-1">
	        <i class="fa-duotone fa-feather text-primary-900"></i>
	       		 비용요약
	      </h2>
	       <button
      	 type="button"
      	 onclick="fn_calculateExcelDownload(this)"
      	 data-download-type="02"
         class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        Excel 다운로드
      </button>
	    </div>
	    </div>
	   <div class="flex items-center justify-between w-full shrink-0">
	    <div class="flex items-center gap-4">
	      <h2 class="shrink-0 flex items-center gap-1">
	        <i class="fa-duotone fa-feather text-primary-900"></i>
	      		  이체정보
	      </h2>
	       <!-- <label for="default-radio-7">
		      <input id="default-radio-7" type="radio" name="calculateViewType" value="read" checked
		            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
		      <span>읽기</span>
		    </label>
		    <label for="default-radio-8">
		      <input id="default-radio-8" type="radio" name="calculateViewType" value="enrol"
		            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
		      <span>등록</span>
		    </label>
		    <label for="default-radio-9">
		      <input id="default-radio-9" type="radio" name="calculateViewType" value="edit"
		            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
		      <span>편집</span>
		    </label> -->
		    
		 <!--    <button
		        type="button"
		        id="btnCalculateViewSave" onclick="fn_saveBankInsertCheck()"
		        class="upload-button h-9 text-white bg-secondary-700 hover:bg-primary-800 font-medium rounded px-2.5 py-2 text-base border border-secondary-700 hover:border-primary-400"
		      >
		        <i class="fa-regular fa-floppy-disk"></i>
		        저장
      	</button> -->
      	  <button
      	 type="button"
      	 onclick="fn_calculateExcelDownload(this)"
      		data-download-type="03"
         class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        Excel 다운로드
      </button>
	    </div>
	    </div>
    </div>
   <div class="grow grid grid-cols-22 min-h-[10rem] grid-rows-[1fr] gap-0">
    <div class="bg-white shadow-sm rounded-lg border border-slate-200" id="calculateDetailTable"></div>
    <div class="bg-white shadow-sm rounded-lg border border-slate-200" id="calculateDetailTable2"></div>
  </div>
  <!-- MainTable -->
</main>




<!-- Download Modal -->
   <div class="modal fade fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300" id="excelUploadPopUp"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true" style="display: none;">
		<div class="modal-close absolute top-0 left-0 w-full h-full"></div>
		<div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); width:1200px;" >
			<div class="modal-content bg-white shadow-lg relative rounded min-w-80 overflow-hidden">
				<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center">
						 <label
						      class="col-span-1 row-span-1 flex items-center font-medium pr-2 text-white"
						    >
						      Verder
						    </label>
						     <input
							      type="text"
							      id="calculate_vender"
							      onkeyup="enterkey()"
							      class="row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
							      placeholder="Verder를 입력해주세요."
							    >
							    <!--  <select
						      id="partn_type"
						      name="partn_type"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
						      <option value="" selected>선택</option>
						      <option value="01" >세관</option>
						      <option value="02" >관세사</option>
						      <option value="03" >창고</option>
						      <option value="04" >포워더</option>
						    </select> -->
						 <div id="cal1" style="width:340px; display: flex; align-items: center; margin-left:30px;">
						
						 <button type="button" class="excel-upload-button px-3 py-2 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700" style="margin-right: 10px;">
        				<i class="fa-regular fa-floppy-disk"></i>
        				업로드
	      				</button>
	      				<input id="excelUploadFile" type="file" accept=".xlsx, .xls" class="absolute top-0 left-0 opacity-0" style="display:none;">
	      				
	      				<button type="button" class="excel-save-button px-3 py-2 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
	        				<i class="fa-regular fa-floppy-disk"></i>
	        				저장
	      				</button>
						
						<!-- <label style="margin-left:10px;"
						      class="col-span-1 row-span-1 flex items-center font-medium pr-2 text-white"
						    >
						     판매업자
						    </label>
						     <select
						      id="partn_cmpny"
						      name="partn_cmpny"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
						      <option value="" selected>선택</option>
						    </select>
						     <input
							      type="text"
							      id="calculate_vender"
							      onkeyup="enterkey()"
							      class="row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
							      placeholder="판매업자를 입력해주세요."
							    > -->
						    
						     <!-- <input
						      type="text"
						      id="partnCmpnyInsert"
						      style="display:none;"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
						      placeholder="회사명을  입력해주세요.">
						    <button type="button" id="partnCmpnySaveBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				저장
		      				</button>
						    <button type="button" id="partnCmpnyCancelBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-rose-600">
		        				취소
		      				</button>
						    <button type="button" id="partnCmpnyBtn" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				추가
		      				</button>
						 </div>
						 <div id="cal2" style="width:950px; display: flex; align-items: center;">
						 <label style="margin-left:10px;"
						      class="col-span-1 row-span-1 flex items-center font-medium pr-2 text-white"
						    >
						      공통코드
						    </label>
						    <select
						      id="cmmn_code"
						      name="cmmn_code"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
						      <option value="" selected>선택</option>
						    </select> -->
						    
						   <!--  <input
						      type="text"
						      id="cmmnCodeInsert"
						      style="display:none;"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
						      placeholder="비용명을 입력해주세요.">
						    <button type="button" id="cmmnCodeSaveBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				저장
		      				</button>
						    <button type="button" id="cmmnCodeCancelBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-rose-600">
		        				취소
		      				</button>
		      				
						     <button type="button" id="cmmnCodeBtn" class="calcul-code-button px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				추가
		      				</button> -->
		      				
						<!--  <label style="margin-left:10px;"
						      class="col-span-1 row-span-1 flex items-center font-medium pr-2 text-white"
						    >
						      비용코드
						    </label>
						    <select
						      id="calcul_code"
						      name="calcul_code"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5">
						      <option value="" selected>선택</option>
						    </select> -->
						    
						    <!-- <input
						      type="text"
						      id="calCodeInsert"
						      style="display:none;"
						      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
						      placeholder="비용명을 입력해주세요.">
						    <button type="button" id="calcodeSaveBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				저장
		      				</button>
						    <button type="button" id="calcodeCancelBtn" style="display:none;" class="px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-rose-600">
		        				취소
		      				</button>
		      				
						     <button type="button" id="calculCodeBtn" class="calcul-code-button px-2 py-1 rounded-lg text-white hover:opacity-50 duration-150 bg-primary-700">
		        				추가
		      				</button> -->
						 </div>
				<div style="flex-grow: 1;"></div> 
    
				    <div>
				        <button type="button" onclick="excelUploadClose()" class="modal-close text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
				    </div>		
				</div>
				 <div class="modal-body">
					 <div class="grow
						  bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200
						  z-0" id="excelUploadPopUpTable">
					</div>
				</div> 
			</div>
		</div>
	</div>
<form id="calculateExcelForm" action="" method="post"></form>

</body>
</html>
