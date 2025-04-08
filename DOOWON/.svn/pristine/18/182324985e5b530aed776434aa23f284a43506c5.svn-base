
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>ITEM 정보</title>

<script type="module" src="/pf/assets/dropdown-init.js"></script>
<script src="/pf/js/function.js"></script>
<script src="/pf/js/item/itemView.js" charset="UTF-8"></script>
<script src="/pf/js/item/itemViewCalendar.js" charset="UTF-8"></script>
</head>
<body class="flex flex-col max-h-fit">
<main class="p-2 grow flex flex-col gap-2">
  <form
    class="w-full shrink-0 grid grid-rows-3 grid-cols-[auto_repeat(2,1fr)_auto_repeat(2,1fr)auto_repeat(2,1fr)auto_repeat(2,1fr)] row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base items-center"
  >
   <input type="hidden" id="grpCd" value="${grpCd}">
   
    <div
      class="row-start-1 col-span-6 col-end-13 flex flex-row gap-2 items-end justify-end"
    >
      <button type="button"
      onclick="fn_searchItemView();"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
      
        <i class="fa-regular fa-search mr-1"></i>
               검색
      </button>
      <button type="button"
      onclick="fn_clearItemView()"
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
      <label for="default-radio-1">
        <input 
        	id="default-radio-1" 
        	type="radio" 
        	value="01" 
        	name="itemView_srch1" 
        	checked="checked"
        	onclick="handleSearchTypeChange()"
            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <span>전체</span>
      </label>
      <label for="default-radio-2">
        <input
          id="default-radio-2"
          type="radio"
          value="02"
          name="itemView_srch1"
          onclick="handleSearchTypeChange()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500
          dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600
        ">
        <span>수입</span>
      </label>
      <label for="default-radio-5">
        <input
          id="default-radio-5"
          type="radio"
          value="03"
          name="itemView_srch1"
          onclick="handleSearchTypeChange()"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500
          dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600
        ">
        <span>수출</span>
      </label>
    </div>
    <!-- 검색기간 -->
    <label
      class="col-start-1 row-start-2 col-span-1 row-span-1
      flex items-center font-medium text-gray-900 pr-2
    ">
      검색기간
    </label>
    <select
      id="itemView_srch10"
      class="row-start-2 col-start-2 col-span-1 bg-gray-50 border border-gray-300 text-gray-900
      rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5
    ">
      <option selected value="last_LisDay ">최종 수리일자</option>
      <option value="first_LisDay">최초 수리일자</option>
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
        <input name="itemView1_date" 
        		id="itemView_srch2"
        		type="text"
                class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
                placeholder="시작일자">
      </div>
      <div class="relative grow">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg
            class="w-4 h-4 text-gray-500"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 20 20"
          >
            <path
              d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"
            />
          </svg>
        </div>
        <input
          name="itemView2_date"
          type="text"
          id="itemView_srch3"
          class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
          placeholder="종료일자"
        >
      </div>
      <!-- /Calendar -->

    </div>
    <!-- Range Button -->
    <div class="flex items-center gap-1 col-start-7 row-start-2 col-span-4">
      <button
          type="button"
          onclick="fn_chgDate1()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        6개월
      </button>
      <button
          type="button"
          onclick="fn_chgDate2()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        1년
      </button>
      <button
          type="button"
          onclick="fn_chgDate3()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        3년
      </button>
      <button
          type="button"
          onclick="fn_chgDate4()"
          class="py-2 px-5 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border text-nowrap
          border-primary-200 hover:text-white hover:bg-primary-700 focus:z-10 focus:ring-4 focus:ring-gray-100
          dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white
          dark:hover:bg-gray-700
        ">
        5년
      </button>
    </div>
    <!-- / Range Button -->


    <!-- /검색기간 -->
    <!-- 신고번호 -->
    <!-- 자재코드 -->
    <label
      for="n0"
      class="row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2"
    >
      자재코드
    </label>
    <input
      type="text"
      id="itemView_srch4"
      onkeyup="enterkey()"
      class="row-start-3 col-start-2 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="자재코드를 입력해주세요.
    ">
    <!-- Description -->
    <label for="n2" class="row-start-3 col-start-4 flex items-center font-medium text-gray-900 px-2">Description</label>
    <input type="text"  
    id="itemView_srch5"
    onkeyup="enterkey()"
            class="row-start-3 col-start-5 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Description을 입력해주세요.">

    <!-- 중복허용 -->
    <div class="row-start-3 col-span-2 col-start-8 px-4 flex items-center gap-2">
      <input onclick="fn_checkboxClick()" 
      name="itemView_srch13" id="default-checkbox" type="checkbox" value="01" class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 rounded focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      <label for="default-checkbox">중복허용</label>
    </div>
  </form>

  <div class="flex items-center justify-between w-full shrink-0">
    <div class="flex items-center gap-4">
      <h2 class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-chart-network text-primary-900"></i>ITEM 정보</h2>
      <p class="card-title inline" style="line-height: 39px">결과:<span id="itemViewCnt">0</span>
      </p>
    </div>
    <div class="flex items-center gap-2">
     <c:if test="${!grpCd.equals('Client Basic') && !grpCd.equals('Client Advanced')}">
        <button
	      type="button"
	      onclick="fn_itemViewExcelDownload()"
	      class="text-white bg-primary-700 hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-2.5 py-1.5 focus:outline-noneduration-300 row-start-1 text-base">
         <i class="fa-regular fa-download"></i>
        	Excel 다운로드
      	</button>	
      </c:if>
      <select 
      id="itemViewPageCnt"
	  name="itemViewPageCnt"
      class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
        <option value="50" selected>Rows [50]</option>
		<option value="100">Rows [100]</option>
		<option value="200">Rows [200]</option>
		<option value="500">Rows [500]</option>
      </select>
    </div>
    </div>
  </div>
  <!-- MainTable -->
  <div class="grow bg-white shadow-sm rounded-lg border border-slate-200 z-0 overflow-auto">
    <div id="itemViewTable"></div>
  </div>
  <!-- /MainTable -->
  <!-- Second Search Form -->
  <form
    class="w-full shrink-0 grid grid-rows-2 grid-cols-[auto_repeat(2,1fr)_auto_repeat(2,1fr)auto_repeat(2,1fr)auto_repeat(2,1fr)] row-start-1 col-start-1 col-span-2 bg-white dark:bg-slate-800 shadow-sm rounded-lg border border-slate-200 dark:border-slate-700 px-4 py-3 gap-1 z-1 text-base *:text-base items-center"
  >
    
    <!-- 신고번호 -->
    <label
      for="s0"
      class="row-start-1 flex items-center font-medium text-gray-900 px-2"
    >
      신고번호
    </label>
    <input
      type="text"
      id="itemView_srch6"
      onkeyup="enterkey2()"
  	 
      class="row-start-1 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="신고 번호를 입력해주세요.
    ">
    <!-- B/L번호 -->
    <label
      for="itemView_srch7"
      class="importtext row-start-1 flex items-center font-medium text-gray-900 px-2"
    >
      B/L번호
    </label>
    <input
      type="text"
      id="itemView_srch7"
      onkeyup="enterkey2()"
      class="row-start-1 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="B/L 번호를 입력해주세요.
    ">
    
      <!-- Invoice 번호 -->
    <label
      for="itemView_srch12"
      class="exporttext row-start-1 flex items-center font-medium text-gray-900 px-2"
    >
      Invoice 번호
    </label>
    <input
      type="text"
      id="itemView_srch12"
      onkeyup="enterkey2()"
      class="row-start-1 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="Invoice 번호를 입력해주세요."
      >
     <!-- 공장코드 -->
  <!--   <label for="itemView_srch8" class="row-start-2 flex items-center font-medium text-gray-900 px-2">공장코드 </label>
    <select
     type="text"
      id="itemView_srch8"
      onkeyup="enterkey2()"
      class="row-start-2 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
    >
      <option value="">공장코드를 선택해주세요.</option>
      <option value="1">공장코드1</option>
      <option value="2">공장코드2</option>
      <option value="3">공장코드3</option>
    </select> -->
    
    
    <div
      class="row-start-1 col-start-10 col-span-3 flex flex-row gap-2 items-end justify-end"
    >
      <button
        type="button" 
        id="btnSearch"
	    onclick="fn_searchItemViewLan2();"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
        <i class="fa-regular fa-search mr-1"></i>
        	검색
      </button>
      <button
      	type="button"
       	onclick="fn_clearItemView()"
        class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300
      ">
        <i class="fa-regular fa-times mr-1"></i>
       	   	 초기화
      </button>
    </div> 
    
    <!-- PO번호 -->
    <label
      for="itemView_srch9"
      class="importtext row-start-2 flex items-center font-medium text-gray-900 px-2"
    >
      PO번호
    </label>
    <input
      type="text"
      id="itemView_srch9"
      onkeyup="enterkey2()"
      class="row-start-2 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="PO번호를 입력해주세요."
      >
    <!-- SO번호 -->
    <label
      for="itemView_srch11"
      class="exporttext row-start-2 flex items-center font-medium text-gray-900 px-2"
    >
      SO번호
    </label>
    <input
      type="text"
      id="itemView_srch11"
      onkeyup="enterkey2()"
      class="row-start-2 col-span-2 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="SO번호를 입력해주세요."
      >
  <label
      for="itemView_srch8"
      class="row-start-2 flex items-center font-medium text-gray-900 px-2"
    >
      공장코드
    </label>
    <input
      type="text"
      id="itemView_srch8"
      onkeyup="enterkey2()"
      class="row-start-2 col-span-3 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="공장코드를 입력하세요
    ">
    
  </form>
  <div class="flex items-center justify-between w-full shrink-0">
    <div class="flex items-center gap-4">
      <h2 class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-chart-network text-primary-900"></i>통관 정보</h2>
      <p class="card-title inline" style="line-height: 39px">결과:<span id="itemlanViewCnt">0</span>
    </div>
    <div class="flex items-center gap-2">
    </div>
    </div>
  <!-- Second Table -->
  <div class="grow bg-white shadow-sm rounded-lg border border-slate-200 z-0 overflow-auto">
    <div id="itemViewLanTable"></div>
  </div>
  <!-- /Second Table -->
  <div class="grow grid grid-cols-[6fr_4fr]">
  <div class="flex items-center gap-4">
      <h2 class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-chart-network text-primary-900"></i>요건 정보</h2>
    </div>
    <div class="flex items-center gap-4">
      <h2 class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-chart-network text-primary-900"></i>메모</h2>
     <label for="default-radio-7">
      <input id="default-radio-7" type="radio" name="itemViewType" value="read" checked
            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      <span>읽기</span>
    </label>
    <label for="default-radio-8">
      <input id="default-radio-8" type="radio" name="itemViewType" value="enrol"
            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      <span>등록</span>
    </label>
    <label for="default-radio-9">
      <input id="default-radio-9" type="radio" name="itemViewType" value="edit"
            class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
      <span>편집</span>
    </label>
     </div>
  </div>
  <!-- Sub Table -->
  <div class="grow grid grid-cols-[6fr_4fr] auto-rows-auto max-h-[13rem] grid-rows-[1fr] gap-1">
    <div class="flex justify-end">
      <!-- <button
        type="button"
        id="btnItemViewSave2" onclick="fn_saveItemViewSpecCheck()"
        class="upload-button h-9 text-white bg-secondary-700 hover:bg-primary-800 font-medium rounded px-2.5 py-2 text-base border border-secondary-700 hover:border-primary-400"
      >
        <i class="fa-regular fa-floppy-disk"></i>
              저장
      </button> -->
    </div>
    <div class="row-start-2 bg-white shadow-sm rounded-lg border border-slate-200 overflow-auto h-full">
      <div id="itemViewSpecTable"></div>
    </div>
    
    <div class="flex justify-end">
      
      <button
        type="button"
        id="btnItemViewSave3" onclick="fn_saveItemViewMemoCheck()"
        class="upload-button h-9 text-white bg-secondary-700 hover:bg-primary-800 font-medium rounded px-2.5 py-2 text-base border border-secondary-700 hover:border-primary-400"
      >
        <i class="fa-regular fa-floppy-disk"></i>
        저장
      </button>
    </div>
    <div class="row-start-2 bg-white shadow-sm rounded-lg border border-slate-200 overflow-auto h-full">
      <div id="itemViewMemoTable"></div>
    </div>
  </div>
  <!-- / Sub Table -->
</main>
    <form id="itemViewExcelForm" action="" method="POST">
  	</form>
	<footer class="w-full
    mx-auto flex justify-between justify-self-end items-center
    shrink-0 bg-primary-900 text-gray-200 px-6 py-2 gap-4">

    <span>KORD Systems Inc.</span>
    <span class="mr-auto">Copyright KORD Systems Inc. All rights reserved.</span>

    <a href="mailto:ioom@kordsystems.com">
      <i class="fa-regular fa-envelopes"></i>
     ioom@kordsystems.com
    </a>
    <p>
      <i class="fa-regular fa-phone-volume"></i>
      +82-2-2038-8299
    </p>

    <a href="#" class="hover:underline">시스템소개</a>
    <a href="#" class="hover:underline">사용자매뉴얼</a>
    <!-- Start -->
    <div class="relative inline-flex" x-data="{ open: false, selected: 0 }">
      <button
          class="btn justify-between min-w-40 bg-white/30 dark:bg-slate-800 border-slate-200 hover:border-slate-300 text-white hover:text-slate-200 py-1"
          aria-label="Select date range"
          aria-haspopup="true"
          @click.prevent="open = !open"
          :aria-expanded="open"
      >
                  <span class="flex items-center">
                      <span x-text="$refs.options.children[selected].children[1].innerHTML"></span>
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
          x-cloak
      >
        <div class="font-medium text-sm text-slate-600 dark:text-slate-300" x-ref="options">

          <button
              tabindex="0"
              class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
              :class="selected === 0 && 'text-primary-900'"
              @click="selected = 0;open = false"
              @focus="open = true"
              @focusout="open = false"
          >
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 0 && 'invisible'"
                 width="12" height="9" viewBox="0 0 12 9">
              <path
                  d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
            </svg>
            <span>참고사이트</span>
          </button>
          <button
              tabindex="0"
              class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
              :class="selected === 1 && 'text-primary-900'"
              @click="selected = 1;open = false"
              @focus="open = true"
              @focusout="open = false"
          >
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 1 && 'invisible'"
                 width="12" height="9" viewBox="0 0 12 9">
              <path
                  d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
            </svg>
            <span>유니패스</span>
          </button>
          <button
              tabindex="0"
              class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
              :class="selected === 2 && 'text-primary-900'"
              @click="selected = 2;open = false"
              @focus="open = true"
              @focusout="open = false"
          >
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 2 && 'invisible'"
                 width="12" height="9" viewBox="0 0 12 9">
              <path
                  d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
            </svg>
            <span>관세법령정보포털</span>
          </button>
          <button
              tabindex="0"
              class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
              :class="selected === 3 && 'text-primary-900'"
              @click="selected = 3;open = false"
              @focus="open = true"
              @focusout="open = false"
          >
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 3 && 'invisible'"
                 width="12" height="9" viewBox="0 0 12 9">
              <path
                  d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
            </svg>
            <span>FTA 포털</span>
          </button>
          <button
              tabindex="0"
              class="flex items-center w-full hover:bg-slate-50 hover:dark:bg-slate-700/20 py-1 px-3 cursor-pointer"
              :class="selected === 4 && 'text-primary-900'"
              @click="selected = 4;open = false"
              @focus="open = true"
              @focusout="open = false"
          >
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 4 && 'invisible'"
                 width="12" height="9" viewBox="0 0 12 9">
              <path
                  d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
            </svg>
            <span>트레이드테비</span>
          </button>
        </div>
      </div>
    </div>
    <!-- End -->
	<script>
    $(".portal-renderer").slideUp(0)
    $("#portal-rendering-button").on("click", function () {
      $(".portal-renderer").slideToggle(200)
      $(this).children(".fa-chevron-down").toggleClass("rotate-180")
    });
  </script>
  </footer>
</body>
</html>
