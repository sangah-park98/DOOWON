<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>통계분석</title>

<script type="module" src="/pf/assets/dropdown-init.js"></script>
<script src="/pf/js/function.js"></script>
<script src="/pf/js/rpt/analysis.js" charset="UTF-8"></script>
<script src="/pf/js/rpt/analysisCalendar.js" charset="UTF-8"></script>

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
      onclick="fn_searchWithCallbackAnalysis()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
        <i class="fa-regular fa-search mr-1"></i>
			검색
      </button>
      <button
      type="button"
      onclick="fn_analysisClearSerachOption()"
        class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300
      ">
        <i class="fa-regular fa-times mr-1"></i>
			초기화
      </button>
      <button
      type="button"
      onclick="fn_ananlysisExcleDownload()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
        <i class="fa-regular fa-search mr-1"></i>
			다운로드
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
      <label for="current-mode">
        <input
          type="radio"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
          value="01" 
          name="analysisView_srch1"
          onclick="fn_searchWithCallbackAnalysis()"
          checked="checked"
        >
        <span>수출입 현황</span>
      </label>
      <label for="cost-mode">
        <input
          type="radio"
          value="02"
          name="analysisView_srch1"
          onclick="fn_searchWithCallbackAnalysis()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>단가분석</span>
      </label>
      <label for="analysis-mode">
        <input
          type="radio"
          value="03"
          name="analysisView_srch1"
          onclick="fn_searchWithCallbackAnalysis()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>수출입 데이터 분석</span>
      </label>
    </div>
    <!-- 검색기간 -->
    <label
      class="col-start-1 row-start-2 col-span-2 row-span-1 flex items-center font-medium text-gray-900 pr-2"
    >
		등록일자
    </label>
    <!-- Calendar -->
    <div
      date-rangepicker31
      class="col-start-2 row-start-2 col-span-4 flex flex-wrap md:flex-nowrap items-center gap-1
    ">
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                fill="currentColor" viewBox="0 0 20 20">
            <path
                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input name="analysisView1_date" 
        		id="analysisView_srch3"
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
        name="analysisView2_date"
        type="text"
        id="analysisView_srch4"
        class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
        placeholder="종료일자">
      </div>
    </div>
    <!-- Range Button -->
    <div class="col-start-6 row-start-2 col-span-4 flex items-center gap-1">
      <button
          type="button"
          onclick="fn_analysisChgDate1()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		6개월
      </button>
      <button
          type="button"
          onclick="fn_analysisChgDate2()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		1년
      </button>
      <button
          type="button"
          onclick="fn_analysisChgDate3()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
		3년
      </button>
      <button
          type="button"
          onclick="fn_analysisChgDate4()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        5년
      </button>
    </div>
	<!-- 단가차이 이하-->
    <label
      for="n2"
      class="row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2"
    >
		단가비율
    </label>
    <input
      type="text"
      onkeyup="analysisEnterkey()"
      id="analysisView_srch5"
      class="row-start-3 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900 text-algin:right rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      style="text-align:right;"
      placeholder=""
      value="20"
      oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
    >
	<label
      for="n3"
      class="row-start-3 col-start-3 flex items-center font-medium text-gray-900 pr-2"
    >%</label>
    <!-- 범위 선택 스크립트 로딩 -->
    <!-- / 범위 선택 스크립트 로딩 -->
    <!-- 신고번호 -->
  </form>
	<section class="analytics-status-container w-full">
		<!-- 수입실적 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkAnalysisExcel" value="1" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">5년치 수입실적</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	      	<div class="w-full h-[215px] overflow-auto">
		    	<div class="analysis1Chart" style="position: relative;margin: 10 10 10 10;height: 33vh;width: 100%">
		        	<canvas id="analysis1Chart" style="border: 1px dotted gray;"></canvas>
		         </div>
		    </div>
	        <div id="analysis1Table"></div>
	      </div>
	    </article>
		<!-- 수출실적 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkAnalysisExcel" value="2" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">5년치 수출실적</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	      	<div class="w-full h-[215px] overflow-auto">
		    	<div class="analysis2Chart" style="position: relative;margin: 10 10 10 10;height: 33vh;width: 100%">
		        	<canvas id="analysis2Chart" style="border: 1px dotted gray;"></canvas>
		         </div>
		    </div>
	        <div id="analysis2Table"></div>
	      </div>
	    </article>
	    <!-- 해외거래처별 수입실적 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox"  name="checkAnalysisExcel" value="3" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">해외거래처별 수입실적</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	      	<div style="text-align: center;">
		    	<div class="analysis3_1Chart" style="display: inline-block;margin: 10 10 10 10;height: 40vh;width: 49%">
		        	<canvas id="analysis3_1Chart" style="border: 1px dotted gray;"></canvas>
		        </div>
		        <div class="analysis3_2Chart" style="display: inline-block;margin: 10 10 10 10;height: 40vh;width: 49%">
		        	<canvas id="analysis3_2Chart" style="border: 1px dotted gray;"></canvas>
		        </div>
		    </div>
	        <div id="analysis3Table"></div>
	      </div>
	    </article>
	    <!-- 해외거래처별 수출실적 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox"  name="checkAnalysisExcel" value="4" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">해외거래처별 수출실적</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	      	<div style="text-align: center;">
		    	<div class="analysis4_1Chart" style="display: inline-block;margin: 10 10 10 10;height: 40vh;width: 49%">
		        	<canvas id="analysis4_1Chart" style="border: 1px dotted gray;"></canvas>
		        </div>
		        <div class="analysis4_2Chart" style="display: inline-block;margin: 10 10 10 10;height: 40vh;width: 49%">
		        	<canvas id="analysis4_2Chart" style="border: 1px dotted gray;"></canvas>
		        </div>
		    </div>
	        <div id="analysis4Table"></div>
	      </div>
	    </article>
	    <!-- 운임 비교 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox"  name="checkAnalysisExcel" value="5" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">운임 비교</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysis5Table"></div>
	      </div>
	    </article>
	    <!-- 보험료 비교 -->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkAnalysisExcel" value="6" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">보험료 비교</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysis6Table"></div>
	      </div>
	    </article>
	    <!-- 외환신고대상 수출-->
	  	<article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox"  name="checkAnalysisExcel" value="7" checked  class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">외환신고대상 수출</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysis7Table"></div>
	      </div>
	    </article>		    		    		    	    
	    <!-- 수입물품 단가비교 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-import-result" type="checkbox" name="checkCostExcel" value="1" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">수입물품 단가비교</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
		    <div class="w-full h-[200px]">
		           <div class="analysisCost1Chart" style="height: 40vh; width: 100%">
		          	<canvas id="analysisCost1Chart" style="border: 1px dotted gray; width:100%; hight: 100%"></canvas>
		          </div>
            </div>	 	      
			<div class="flex items-center justify-between w-full shrink-0 p-1">
			    <div class="flex items-center gap-4">
			      <h2 class="shrink-0 flex items-center gap-1">
			      	<i class="fa-duotone fa-feather text-primary-900"></i>
			      </h2>
			      <!-- <p class="text-gray-500 text-base">결과:<span id="exportViewCnt">0</span> -->
			    </div>
			    <div class="flex items-center gap-2">
			      <select class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
			      		  id="analysisCost1Option">
			      	<option value="max">최고단가비교</option>
			        <option value="min">최저단가비교</option>
			        <option value="avg">평균단가비교</option>
			      </select>
			    </div>
		    </div>
	        <div id="analysisCost1Table"></div>
	      </div>
	    </article>
	    <!-- 유무상 수입건 과세가격 비교 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkCostExcel" value="2" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">유무상 수입건 과세가격 비교</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
		    <div class="w-full h-[215px] overflow-auto">
		    	<div class="analysisCost2Chart" style="position: relative;margin: 10 10 10 10;height: 33vh;width: 100%">
		       		<canvas id="analysisCost2Chart" style="border: 1px dotted gray;"></canvas>
		        </div>
		    </div>	 	      	
	        <div id="analysisCost2Table"></div>
	      </div>
	    </article>
	    <!-- 동일거래, 결제통화 변경점검 (유사거래건없음) -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkCostExcel" value="3" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">동일거래, 결제통화 변경점검</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysisCost3Table"></div>
	      </div>
	    </article>
	    <!-- 동일자재코드 품목분류 상이점검 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkEtcExcel" value="1" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">동일자재코드 품목분류 상이점검</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysisEtc1Table"></div>
	      </div>
	    </article>
	    <!-- 동일자재코드 관세구분 상이점검 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkEtcExcel" value="2" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">동일자재코드 관세구분 상이점검</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysisEtc2Table"></div>
	      </div>
	    </article>
	    <!-- 감면 적용 일관성 검토 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white ">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkEtcExcel" value="3" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">감면 적용 일관성 검토</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysisEtc3Table"></div>
	      </div>
	    </article>
	    <!-- FTA 직접운송원칙 -->
	    <article class="table-block w-full my-1.5 rounded overflow-hidden bg-white " style="display:none">
	      <div class="pl-4 text-xl bg-primary-800 text-white flex items-center ">
	        <input id="analytics-export-result" type="checkbox" name="checkEtcExcel" value="4" checked class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	        <button class="flex items-center w-full justify-between py-2.5 pr-4">
	          <span class="ms-2 block w-full text-left">FTA 직접운송원칙</span>
	          <i class="fa-solid fa-chevron-down text-2xl shrink-0 duration-200"></i>
	        </button>
	      </div>
	      <div class="table-container">
	        <div id="analysisEtc4Table"></div>
	      </div>
    </article>
    <form id="analysisExcelForm" action="" method="POST">
  	</form>
    </section>
  

</main>

</body>
</html>
