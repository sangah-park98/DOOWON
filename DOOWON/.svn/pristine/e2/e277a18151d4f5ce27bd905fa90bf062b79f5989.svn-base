<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>사업자 관리</title>
<script src="/pf/js/function.js"></script>
<script src="/pf/js/cmmn/pfcompany.js" charset="UTF-8"></script>
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
      <button type="button"
      onclick="fn_searchPfCmpny()"
        class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700
        focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none
        duration-300 row-start-1
      ">
        <i class="fa-regular fa-search mr-1"></i>
        검색
      </button>
      <button type="button"
        onclick="fn_clearPfCmpny()"
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
          name="pfcompny_srch1" 
          value="01"
          type="radio"
          checked
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>사업자관리</span>
      </label>
      <!-- <label for="default-radio-2">
        <input
          id="default-radio-2"
          type="radio"
          name="pfcompny_srch1" 
          value="02"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500
          dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600
        ">
        <span>사업자 - 지사</span>
      </label> -->
    </div>
    <!-- 검색기간 -->

   
    <!-- 회사 -->
    
    <label
      for="pfCompny_srch2"
      class="cmpnyName row-start-2 col-start-1 flex items-center font-medium text-gray-900 pr-2"
    >
      회사명
    </label>
    <input
      type ="text"
      id = "pfCompny_srch2"
      onkeyup="enterkey()"
      class="cmpnyName row-start-2 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
      placeholder="회사명을 입력해주세요.
    ">
    <!-- 사업자번호 -->
    <label for="pfUser_srch3" class="cmpnyNum1 userName row-start-2 col-start-7 flex items-center font-medium text-gray-900 px-2">사업자번호</label>
    <input type="text"  id="pfCompny_srch3" onkeyup="enterkey()"
            class="cmpnyNum1 userName row-start-2 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="사업자번호를 입력해주세요.">
    <!-- 지사코드 -->
    <label for="pfCmpny_srch6" class="jisaCode compnyInfo row-start-2 col-start-7 flex items-center font-medium text-gray-900 px-2">지사코드</label>
    <input type="text"  id="pfCmpny_srch6" onkeyup="enterkey()"
            class="jisaCode compnyInfo row-start-2 col-start-8 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="지사코드를 입력해주세요.">
            
     <!-- 지사 사업자번호 -->
    <label for="pfCmpny_srch5" class="cmpnyNum2 row-start-3 col-start-1 flex items-center font-medium text-gray-900 pr-2">사업자번호</label>
    <input type="text"  id="pfCmpny_srch5" onkeyup="enterkey()"
            class="cmpnyNum2 row-start-3 col-start-2 col-span-5 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg
      focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5"
            placeholder="사업자번호를 입력해주세요.">       
    <!-- 승인여부 -->
    <!-- <label class="approveUser col-start-1 row-start-3 col-span-2 row-span-2
       flex items-center font-medium text-gray-900 pr-2">
      승인여부
    </label>
    <div 
      class="approveUser flex flex-row flex-wrap gap-4 col-start-2 col-span-2 row-start-3
      items-center *:flex *:flex-row *:items-center *:gap-2 font-medium text-gray-900
    ">
      <label for="default-radio-1">
        <input
          id="default-radio-1"
          name="pfCmpny_srch4" 
          value="ALL"
          type="radio"
          checked
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
        >
        <span>ALL</span>
      </label>
      <label for="default-radio-2">
        <input
          id="default-radio-2"
          type="radio"
          name="pfCmpny_srch4" 
          value="Y"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500
          dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600
        ">
        <span>Y</span>
      </label>
        <label for="default-radio-3">
        <input
          id="default-radio-3"
          type="radio"
          name="pfCmpny_srch4" 
          value="N"
          class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500
          dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600
        ">
        <span>N</span>
      </label>
    </div> -->
            
    
  </form>

	<div class="flex items-center justify-between w-full shrink-0">
	    <div class="flex items-center gap-4" id="importUp_div6">
	        <h2 id="cmpnyView" class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-chart-network text-primary-900"></i>사업자 관리</h2>
	        <p class="shrink-0 flex items-center gap-1">결과: <span id="pfCmpnyCnt">0</span></p>
	        <label for="default-radio-7">
	            <input id="default-radio-7" type="radio" value="read" name="pfCmpnyType" checked
	                   class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	            <span>읽기</span>
	        </label> 
	        <label for="pfUserType">
	            <input id="pfUserType" type="radio" value="enrol" name="pfCmpnyType"
	                   class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	            <span>등록</span>
	        </label>
	        <label for="default-radio-9">
	            <input id="default-radio-9" type="radio" value="edit" name="pfCmpnyType"
	                   class="w-4 h-4 text-primary-600 bg-gray-100 border-gray-300 focus:ring-primary-500 dark:focus:ring-primary-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
	            <span>편집</span>
           
	        </label>
	    </div>
	    <div class="flex items-center gap-4">
	         <button
		        type="button"
		        id="btnPfCmpnySave" onclick="fn_savePfCmpnyCheck()"
		        class="upload-button h-9 text-white bg-secondary-700 hover:bg-primary-800 font-medium rounded px-2.5 py-2 text-base border border-secondary-700 hover:border-primary-400"
		      >
		        <i class="fa-regular fa-floppy-disk"></i>
		              저장
	      </button>
	        <select 
	            id="alignPfCmpny"
	            name="alignPfCmpny"
	            class="w-36 h-9 text-gray bg-primary-100 hover:bg-primary-200 focus:ring-2 focus:outline-none focus:ring-primary-300 font-medium rounded text-base px-2.5 py-1.5 text-center inline-flex items-center border-primary-500 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
	            <option value="" selected>정렬기준</option>
				<option value="CMPNY_NM">회사명 &uarr; </option>
				<option value="CMPNY_NM_DESC">회사명 &darr; </option>
				<option value="TAX_NO">사업자번호 &uarr; </option>
				<option value="TAX_NO_DESC">사업자번호 &darr; </option>
	        </select>
	        <select 
	            id="pfCmpnyPageCnt"
	            name="pfCmpnyPageCnt"
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
  <div
    id="pfCmpnyTable"
    class="grow bg-white shadow-sm min-h-[32rem] rounded-lg border border-slate-200 z-0">
  </div>
</main>
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
