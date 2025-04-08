<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>KPI</title>

<script type="module" src="/pf/assets/dropdown-init.js"></script>
<script src="/pf/js/function.js"></script>
<script src="/pf/js/rpt/kpi.js" charset="UTF-8"></script>
<script src="/pf/js/rpt/kpiCalendar.js" charset="UTF-8"></script>

<script type="text/javascript">

 	/* 메시지 */
 	var msgSearchError = "${searchError}"; //조회중 에러가 발생하였습니다.
 	

</script>
<style>
</style>
</head>
<body class="flex flex-col max-h-fit">
<main class="p-2 grow flex flex-col gap-2">
  <form
    class="w-full shrink-0 grid grid-rows-3 grid-cols-[auto_repeat(5,1fr)_auto_repeat(5,1fr)]
    row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg
    border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base
    items-center
  ">
    <div
      class="row-start-1 col-span-6 col-end-13 flex flex-row gap-2 items-end justify-end"
    >
      <button
      type="button"
      onclick="fn_searchKpi()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
        <i class="fa-regular fa-search mr-1"></i>
			검색
      </button>
      <button
      type="button"
      onclick="fn_kpiClearSerachOption()"
        class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300
      ">
        <i class="fa-regular fa-times mr-1"></i>
			초기화
      </button>
    </div>
    <!-- 검색구분 -->
    <label class="col-start-1 row-start-1 col-span-1 row-span-1
       flex items-center font-medium text-gray-900 pr-2">
		검색구분
    </label>
    <div
      class="flex flex-row flex-wrap gap-4 col-start-2 col-span-5 row-start-1
      items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900
    ">
      <label for="import-mode">
        <input
          type="radio"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
          value="01" 
          name="kpiView_srch1"
          onclick="fn_searchKpi()"
          checked="checked"
        >
        <span>수입 정확성 관리</span>
      </label>
      <label for="export-mode">
        <input
          type="radio"
          value="02"
          name="kpiView_srch1"
          onclick="fn_searchKpi()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>수출 정확성 관리</span>
      </label>
      <label for="export-mode">
        <input
          type="radio"
          value="03"
          name="kpiView_srch1"
          onclick="fn_searchKpi()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>수입신고 Lead time</span>
      </label>
    </div>
    <!-- 검색기간 -->
    <label
      class="col-start-1 row-start-2 col-span-1 row-span-1 flex items-center font-medium text-gray-900 pr-2"
    >
		등록일자
    </label>
    <select
      id="kpiView_srch2"
      class="row-start-2 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
    >
      <option selected  value="petDay">승인일자</option>
      <option value="rptDay">신청일자</option>
      <option value="lisDay">수리일자</option>
    </select>
    <!-- Calendar -->
    <div
      date-rangepicker31
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
        <input name="kpiView1_date" 
        		id="kpiView_srch3"
        		type="text"
                class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
                placeholder="시작일자">
      </div>
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                fill="currentColor" viewBox="0 0 20 20">
            <path
                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input 
        name="kpiView2_date"
        type="text"
        id="kpiView_srch4"
        class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
        placeholder="종료일자">
      </div>
    </div>
    <!-- Range Button -->
    <div class="col-start-7 row-start-2 col-span-4 flex items-center gap-1">
      <button
          type="button"
          onclick="fn_kpiChgDate1()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		6개월
      </button>
      <button
          type="button"
          onclick="fn_kpiChgDate2()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		1년
      </button>
      <button
          type="button"
          onclick="fn_kpiChgDate3()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		3년
      </button>
      <button
          type="button"
          onclick="fn_kpiChgDate4()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        5년
      </button>
    </div>

    <!-- 범위 선택 스크립트 로딩 -->
    <!-- / 범위 선택 스크립트 로딩 -->
    <!-- 신고번호 -->
    <label
      for="n2"
      class="row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2"
    >
		신고번호
    </label>
    <input
      type="text"
      onkeyup="kpiEnterkey()"
      id="kpiView_srch5"
      class="row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="신고번호를 입력해주세요."
    >
    <!-- B/L 번호 -->
    <label
      for="n3"
      class="row-start-3 col-start-7 flex items-center font-medium text-gray-900 px-2 import-view"
    >
		B/L 번호
    </label>
    <input
      type="text"
      onkeyup="kpiEnterkey()"
      id="kpiView_srch6"
      class="row-start-3 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 import-view"
      placeholder="B/L번호를 입력해주세요."
    >
    <!-- IV 번호 -->
    <label
      for="n3"
      class="row-start-3 col-start-7 flex items-center font-medium text-gray-900 px-2 export-view hidden"
    >
		Invoice 번호
    </label>
    <input
      type="text"
      id="kpiView_srch7"
      onkeyup="kpiEnterkey()"
      class="row-start-3 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 export-view hidden"
      placeholder="Invoice 번호를 입력해주세요."
    >
    <!-- 공장코드 -->
    <label 
    	for="n4" 
    	class="row-start-4 col-start-1 flex items-center font-medium text-gray-900 pr-2">공장코드 </label
    >
    <input
      type="text"
      id="kpiView_srch8"
      onkeyup="kpiEnterkey()"
      class="row-start-4 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 import-view"
      placeholder="공장 코드를 입력해주세요."
    >
    <!-- PO 번호 -->
	<label
	  for="n5"
	  class="row-start-4 col-start-7 flex items-center font-medium text-gray-900 px-2 import-view"
	>
		PO 번호
	</label>
	<input
	  type="text"
	  id="kpiView_srch9"
	  onkeyup="kpiEnterkey()"
	  class="row-start-4 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 import-view"
	  placeholder="PO번호를 입력해주세요."
	>
    <!-- SO 번호 -->
	<label
	  for="n5"
	  class="row-start-4 col-start-7 flex items-center font-medium text-gray-900 px-2 export-view hidden"
	>
		SO 번호
	</label>
	<input
	  type="text"
	  id="kpiView_srch10"
	  onkeyup="kpiEnterkey()"
	  class="row-start-4 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 export-view hidden"
	  placeholder="SO번호를 입력해주세요."
	>
  </form>
  <!-- import table -->
  	<article class="h-full w-full kpi-management-import-view" id="importTableDiv">
      <div class="flex items-center justify-between w-full shrink-0 p-1">
        <div class="flex items-center gap-4">
          <h2 class="shrink-0 flex items-center gap-1">
            <i class="fa-duotone fa-feather text-primary-900"></i>
            수입 정확성 관리
          </h2>
          <p class="text-gray-500 text-base">결과:<span id="importViewCnt">0</span>
        </div>
        <div class="flex items-center gap-2">
          <!-- <a href="#" class="text-base text-primary-600 hover:underline" onClick="fn_kpiExcleDownload('import')">Excel 다운로드</a> -->
          <button
	      	type="button"
	      	onclick="fn_kpiExcleDownload('import')"
	        class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        	Excel 다운로드
      	</button>	
          <select class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
          		  id="kpiImportViewPageCnt">
            <option value="50">ROWS[50]</option>
            <option value="100">ROWS[100]</option>
            <option value="200">ROWS[200]</option>
            <option value="500">ROWS[500]</option>
          </select>
        </div>
      </div>
      <div class="grow bg-white shadow-sm max-h-[40rem] rounded-lg overflow-auto z-0">
        <div id="kpiImportTable"></div>
      </div> 
    </article>
    <!-- export table -->
    <article class="h-full w-full kpi-management-export-view" id="exportTableDiv">
      <div class="flex items-center justify-between w-full shrink-0 p-1">
        <div class="flex items-center gap-4">
          <h2 class="shrink-0 flex items-center gap-1">
            <i class="fa-duotone fa-feather text-primary-900"></i>
            수출 정확성 관리
          </h2>
          <p class="text-gray-500 text-base">결과:<span id="exportViewCnt">0</span>
        </div>
        <div class="flex items-center gap-2">
          <!-- <a href="#" class="text-base text-primary-600 hover:underline" onClick="fn_kpiExcleDownload('export')">Excel 다운로드</a> -->
          <button
	      	type="button"
	      	onclick="fn_kpiExcleDownload('export')"
	        class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        	Excel 다운로드
      	</button>	
          <select class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
          		  id="kpiExportViewPageCnt">
          	<option value="50">ROWS[50]</option>
            <option value="100">ROWS[100]</option>
            <option value="200">ROWS[200]</option>
            <option value="500">ROWS[500]</option>
          </select>
        </div>
      </div>
      <div class="grow bg-white shadow-sm max-h-[40rem] rounded-lg border border-slate-200 overflow-auto z-0">
        <div id="kpiExportTable"></div>
      </div> 
    </article>
  <!-- Lead Time Table -->
  <article class="h-full w-full kpi-management-export-view" id="leadTimeTableDiv">
    <div class="flex items-center justify-between w-full shrink-0 py-1">
      <div class="flex items-center gap-4">
        <h2 class="shrink-0 flex items-center gap-1">
          <i class="fa-duotone fa-feather text-primary-900"></i>
          수입신고 Lead-Time
        </h2>
        <p class="text-gray-500 text-base">결과:<span id="leadtimeViewCnt">0</span>
      </div>
      <div class="flex items-center gap-2">
        <!-- <a href="#" class="text-base text-primary-600 hover:underline" onClick="fn_kpiExcleDownload('leadtime')">Excel 다운로드</a> -->
        <button
	      	type="button"
	      	onclick="fn_kpiExcleDownload('leadtime')"
	        class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        	Excel 다운로드
      	</button>	
        <select class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
          		  id="kpiLeadtimeViewPageCnt">
            <option value="50">ROWS[50]</option>
          </select>
      </div>
    </div>

    <div class="grow bg-white shadow-sm h-full max-h-[40rem] rounded-lg border border-slate-200 overflow-auto z-0">
      <div id="kpiLeadtimeTable"></div>
    </div>
  </article>
  
</main>

</body>
</html>
