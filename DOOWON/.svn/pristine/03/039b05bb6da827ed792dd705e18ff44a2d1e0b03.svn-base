<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>수출 packing List 생성</title>
  <script src="/pf/js/function.js"></script>
  <script src="/pf/js/export/exportMakePlCalendar.js" charset="UTF-8"></script>
  <script src="/pf/js/export/exportMakePlCalendar2.js" charset="UTF-8"></script>
  <script src="/pf/js/export/exportMakePk.js" charset="UTF-8"></script>
  <script type="module" crossorigin src="/pf/assets/dropdown-init.js"></script>
</head>
<body class="flex flex-col max-h-fit">
  <main class="p-2 grow flex flex-col gap-2">
    <h2 class="shrink-0 flex items-center gap-1"><i class="fa-duotone fa-box-open-full text-primary-900"></i>PACKING LIST 생성</h2>
    <form onkeydown="return preventFormSubmit2(event)"
      class="w-full shrink-0 grid grid-rows-6 grid-cols-11 auto-rows-auto
      dark:bg-slate-800 shadow-sm rounded-lg border border-slate-200 dark:border-slate-700
      px-4 py-3 gap-1 z-1 text-base *:text-base items-start">
      <!-- SHIPPER / EXPORTER -->
      <div class="group row-span-4 col-span-7 flex flex-col items-start justify-start gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
        <label for="shipper" class="uppercase text-lg font-semibold text-gray-900">
          * shipper / exporter
        </label>
        <input type="text" id="plShipper"
          class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900
          rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
          placeholder="SHIPPER / EXPORTER" pattern="[a-zA-Z0-9]" oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')">
      </div>
      
      <!-- Invoice NO -->
      <div class="row-span-4 col-start-8 col-span-4 flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
        <label for="invoice-no" class="uppercase text-lg font-semibold text-gray-900">
          * invoice no.
        </label>
        <input type="text" id="plInvoice-no" oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')"
          class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900
          rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
          placeholder="INVOICE NO.">
      </div>
      <div
	      date-rangepicker314
	      class="h-full row-span-2 col-start-8 col-span-4 flex items-end">
	      <div class="w-full flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
       <label for="departureDate" class="uppercase text-lg font-semibold text-gray-900">
            * invoice date
       </label>
      <div class="relative">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input id="plInvoiceDate" name="plInvoiceDate" type="text"
        	   placeholder="INVOICE DATE"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))"
               class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 ">
      </div>
      </div>
      <div class="relative grow" style="display: none">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input id="exportUpdate_srch3" name="exportUpdate2_date" type="text"
               class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
               placeholder="yyyy-mm-dd"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" 
			   onkeyUp="fn_dateInputForm($(this))"
			   autocomplete="off" readonly>
      	</div>
      </div>
      <!-- Address -->
      <div class="group row-start-5 row-span-2 col-start-1 col-span-7 flex flex-col items-start justify-start gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
        <label for="address" class="uppercase text-lg font-semibold text-gray-900">
          * address
        </label>
        <textarea type="text" id="plAddress" style="resize: none"
          class="w-full h-32 bg-gray-50 border border-gray-300 text-gray-900
          rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
          placeholder="ADDRESS"
          oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')"></textarea>
      </div>
      <!-- Consignee -->
      <div class="group row-span-6 col-span-7 flex flex-col items-start justify-start gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
        <label for="consignee" class="uppercase text-lg font-semibold text-gray-900">
          * consignee
        </label>
        <input type="text" id="plConsignee"
          class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900
          rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
          placeholder="CONSIGNEE" pattern="[a-zA-Z0-9]" oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')">
      </div>
      <!-- Manufacturer -->
      <div class="row-span-2 col-start-8 col-span-4 flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
	      <label for="manufacturer" class="uppercase text-lg font-semibold text-gray-900">
	        manufacturer
	      </label>
	      <input type="text" id="manufacturer"
	        class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900
	        rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
	        placeholder="MANUFACTURER">
      </div>
      <div class="group row-start-7 row-span-2 col-span-7 flex flex-col items-start justify-start gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
		  <label for="address" class="uppercase text-lg font-semibold text-gray-900">
		    * consignee address 
		  </label>
		  <textarea type="text" id="plConsigneeAddress" style="resize: none"
		    class="w-full h-32 bg-gray-50 border border-gray-300 text-gray-900
		    rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
		    placeholder="CONSIGNEE ADDRESS"
		    oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')"></textarea>
	  </div>
    
      <!-- line -->
      <div class="col-span-11 pt-1 mx-2 mb-1 border-b"></div>
      <!-- Loading Port -->
        <div class="h-full row-span-2 col-start-1 col-span-4 flex items-end">
        <div class="w-full flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
          <label for="loading-port" class="uppercase text-lg font-semibold text-gray-900">
             * loading port
          </label>
          <div class="relative w-full col-span-2">
            <button
              id="plLoadingPortButton"
              onclick="fn_plLoadPort()"
              data-dropdown-toggle="plLoadingPortSearch"
              data-dropdown-placement="bottom"
              class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              type="button"
            >
              Loading Port
              <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
              </svg>
            </button>
            <div id="plLoadingPortSearch" class="z-10 hidden bg-white border rounded-lg shadow-xl w-full dark:bg-gray-700 overflow-auto">
                <div class="p-3">
                  <label for="final-group-search" class="sr-only">Search</label>
                  <div class="relative">
                    <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
                      <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                      </svg>
                    </div>
                    <input type="text" id="plloadPortsrch1" onkeyup="enterkeyPlLoadPort()" class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
                  </div>
                </div>
                <ul class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="finalSearch"></ul>
            </div>
          </div>
        </div>
      </div>
      <!-- Vessel / Flight -->
      <div class="h-full row-span-2 col-start-5 col-span-3 flex items-end">
        <div class="w-full flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
          <label for="vessel" class="uppercase text-lg font-semibold text-gray-900">
            * vessel / flight
          </label>
          <input type="text" id="plVessel"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900
            rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Vessel / Flight"
          >
        </div>
      </div>
      <!-- Final Destination -->
      <div class="h-full row-span-2 col-start-1 col-span-4 flex items-end">
        <div class="w-full flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
          <label for="final-destination" class="uppercase text-lg font-semibold text-gray-900">
            * final destination
          </label>
          <div class="relative w-full col-span-2">
            <button
              id="plFinalButton"
              onclick="fn_plFinalPopup()"
              class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              type="button">
              Final Destination
              <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
              </svg>
            </button>
           <div id="popup" class="hidden absolute top-0 left-0 right-0 bottom-0 bg-white border rounded-lg shadow-xl dark:bg-gray-700 overflow-auto">
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
	        	<ul class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="termsOfTradeButton"></ul>
          </div>
        </div>
      </div>
     </div>
      <!-- Departure Date -->
      <div
	      date-rangepicker313
	      class="h-full row-span-2 col-start-5 col-span-3 flex items-end">
	      <div class="w-full flex flex-col gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
       <label for="departureDate" class="uppercase text-lg font-semibold text-gray-900">
            * departure date
       </label>
      <div class="relative">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input id="plDepDate" name="exportMakepl_date" type="text"
        	   placeholder="DEPARTURE DATE"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))"
               class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 ">
      </div>
      </div>
      <div class="relative grow" style="display: none">
        <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
          <svg class="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
            <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
          </svg>
        </div>
        <input id="exportUpdate_srch3" name="exportUpdate2_date" type="text"
               class="text-base bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full ps-10 py-1 px-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 "
               placeholder="yyyy-mm-dd"
			   onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" 
			   onkeyUp="fn_dateInputForm($(this))"
			   autocomplete="off" readonly>
      	</div>
    </div>
      <!-- line -->
      <div class="col-span-11 pt-1 mx-2 mb-1 border-b"></div>
      <!-- Table Input Form -->
      <div id="addPLRow" class="col-span-11 grid grid-cols-[3fr_1fr_1fr_3.5fr_1fr_4fr_1fr_1.6fr_1.6fr_1.6fr_0.4fr] auto-rows-auto gap-1 pb-2">
        <!-- Labels -->
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* CT No.</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* HS Code</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* 일반품목명</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* Goods Description</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* 원산지</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* Quantity</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* UOM</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* Net Weight</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">* Gross Weight</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1">KG</h2>
        <h2 class="uppercase text-lg font-semibold text-gray-900 p-1"></h2>
        <!-- Table Inputs -->
        <div class="px-1">
          <input
            type="text"
            id="ctno0"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="CT No."
            pattern="[0-9]" oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')"
          >
        </div>
        <div class="px-1">
          <input
            type="text"
            id="plHscode0"
            oninput="formatPhoneNumber2(this)"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="HS Code"
          >
        </div>
        <div class="px-1">
          <input
            type="text"
            id="plItemName0"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="일반품목명"
          >
        </div>
        <div class="px-1">
          <input
            type="text"
            id="plGoodDes0"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Goods Description"
          >
        </div>
         <div class="px-1">
          <div class="relative col-span-2">
            <button
              id="plOriginButton0"
              data-dropdown-toggle="plOriginSearch0"
              data-dropdown-placement="bottom"
              onclick="fn_plNation(0)"
              class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              type="button">
              Origin
              <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
              </svg>
            </button>
            <div id="plOriginSearch0" class="z-10 hidden bg-white border rounded-lg shadow-xl dark:bg-gray-700 overflow-auto">
                <div class="p-3">
                  <label for="origin-group-search" class="sr-only">Search</label>
                  <div class="relative">
                    <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
                      <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                      </svg>
                    </div>
                    <input type="text" id="plOriginSrch0" onkeyup="enterkeyPlOrigin(0)" class="block p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
                  </div>
                </div>
                <ul class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="termsOfTradeButton">
          		  <li>
            	    <button 
              		   class="block ps-2 hover:bg-gray-100 dark:hover:bg-gray-600 py-2 text-sm font-medium text-gray-900 rounded dark:text-gray-300 text-left">
            	    </button>
          		  </li>
      			</ul>
            </div>
          </div>
        </div>
        <div class="px-1">
          <input
            type="text"
            id="plQuantity0"
            onkeyup="plQuantityTotal()"
            oninput="this.value = this.value.replace(/[^0-9]/g, '')"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1 input-required"
            placeholder="Quantity">
        </div>
         <div class="px-1">
          <div class="relative col-span-2">
            <button
              id="plUomButton0"
              onclick="fn_plUomQuantity(0)"
              data-dropdown-toggle="plUomSearch0"
              data-dropdown-placement="bottom"
              class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              type="button">
              UOM
              <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
              </svg>
            </button>
            <div id="plUomSearch0" class="z-10 hidden bg-white border rounded-lg shadow-xl dark:bg-gray-700 overflow-auto">
                <div class="p-3">
                  <label for="uom-group-search" class="sr-only">Search</label>
                  <div class="relative">
                    <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
                      <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                      </svg>
                    </div>
                    <input type="text" id="plUomSrch0" onkeyup="enterkeyUom(0)" class="block p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
                  </div>
                </div>
                <ul class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="termsOfTradeButton">
          			<li>
            		  <button 
              			class="block ps-2 hover:bg-gray-100 dark:hover:bg-gray-600 py-2 text-sm font-medium text-gray-900 rounded dark:text-gray-300 text-left">
            		  </button>
                    </li>
      			</ul>
            </div>
          </div>
        </div>
        <div class="px-1">
          <input
            type="text"
            id="net-weight0"
            onkeyup="netTotal()"
            oninput="this.value = this.value.replace(/[^0-9]/g, '')"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1 input-required"
            placeholder="Net Weight"
          >
        </div>
        <div class="px-1">
          <input
            type="text"
            id="gross-weight0"
            onkeyup="grossTotal()"
            oninput="this.value = this.value.replace(/[^0-9]/g, '')"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1 input-required"
            placeholder="Gross Weight"
          >
        </div>
        <div class="px-1">
          <input
            type="text"
            id="kg0"
            onkeyup="kgTotal()"
            readonly
            oninput="this.value = this.value.replace(/[^0-9]/g, '')"
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1 input-required"
            placeholder="KG"
          >
        </div>
        <div class="flex items-center justify-center">
          <button type="button"
                  onclick="addPLRow()"
          		  class="p-1.5 text-white flex items-center justify-center bg-indigo-600 rounded-lg hover:opacity-50 duration-200"><i class="fa-solid fa-plus"></i>
          </button>
        </div>
      </div>
      <div class="col-span-11 grid grid-cols-[3fr_1fr_1fr_3.5fr_1fr_4fr_1fr_1.6fr_1.6fr_1.6fr_0.4fr] auto-rows-auto bg-primary-50 rounded py-2 gap-1">
        <label
          for="total"
          class="uppercase text-lg font-semibold text-gray-900 col-span-3 flex items-center justify-center"
        >
          	총 포장 수 (필수 기재)
        </label>
        <div class="px-1 col-span-2">
          <div class="relative w-full">
            <button
              id="totCntButton"
              onclick="fn_totCnt()"
              data-dropdown-toggle="totCntSearch"
              data-dropdown-placement="bottom"
              class="h-10 w-full text-primary-900 border border-primary-700 hover:text-white bg-primary-100 hover:bg-primary-500 focus:ring focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              type="button"
            >
              	총 포장 수
              <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
              </svg>
            </button>
            <div id="totCntSearch" class="z-10 hidden bg-white border rounded-lg shadow-xl w-full dark:bg-gray-700 overflow-auto">
                <div class="p-3">
                  <label for="pl-group-search" class="sr-only">Search</label>
                  <div class="relative">
                    <div class="absolute inset-y-0 rtl:inset-r-0 start-0 flex items-center ps-3 pointer-events-none">
                      <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                      </svg>
                    </div>
                    <input type="text" id="totCntSrch1" onkeyUp="enterkeytotCnt()" class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
                  </div>
                  	<ul class="h-48 px-3 pb-3 overflow-y-auto text-sm text-gray-700 dark:text-gray-200 max-h-40 overflow-auto" aria-labelledby="finalSearch">
          			</ul>
                   </div>
	            </div>
	          </div>
	        </div>
        <div class="px-1 col-start-6">
          <input
            type="text"
            id="total-quantity"
            readonly
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Total"
          >
        </div>
        <div class="px-1 col-start-8">
          <input
            type="text"
            id="total-net-weight"
            readonly
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Total"
          >
        </div>
        <div class="px-1 col-start-9">
          <input
            type="text"
            id="total-gross-weight"
            readonly
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="Total"
          >
        </div>
        <div class="px-1 col-start-10">
          <input
            type="text"
            id="total-kg"
            readonly
            class="w-full h-10 bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
            placeholder="KG"
          >
        </div>
      </div>
      <div class="flex gap-2 items-end justify-between col-span-11 pt-3 border-t mt-3">
	      <div class="flex flex-col items-start justify-start gap-1 p-1 focus-within:ring-2 focus-within:ring-primary-500 focus-within:bg-primary-50 rounded">
			  <label for="plComments" class="uppercase text-lg font-semibold text-gray-900">
			    &nbsp;&nbsp;&nbsp;&nbsp;comments 
			  </label>
			  <textarea type="text" id="plComments" style="resize: none; width:1200px; height:100px;" 
			    class="w-full h-32 bg-gray-50 border border-gray-300 text-gray-900
			    rounded-lg focus:ring-primary-500 focus:border-primary-500 block px-2.5 py-1"
			    placeholder="COMMENTS"
			    oninput="this.value = this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g, '')"></textarea>
			</div> 
			<div class="flex">
		        <button type="button"
		          onclick="fn_saveTempExpMakePl()"
		          class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
		          focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300">
		          <i class="fa-regular fa-times mr-1"></i>
		          	임시저장
		        </button>&nbsp;&nbsp;
		        <button type="button"
		          onclick="fn_clearExpMakePk()"
		          class="text-primary-600 bg-primary-100 border border-primary-500 hover:bg-secondary-100
		          focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300">
		          <i class="fa-regular fa-times mr-1"></i>
		          	초기화
		        </button>&nbsp;&nbsp;
		        <a id="exportMakePk" onclick="event.preventDefault(); fn_exportMakePL();"
				   class="text-white bg-primary-700 hover:bg-secondary-800 border border-primary-700 focus:ring-4 focus:ring-secondary-300 font-medium rounded px-5 py-2 focus:outline-none duration-300 row-start-1">
				    <i class="fa-solid fa-arrow-turn-down-left fa-flip-horizontal"></i>
				    <span class="/export/exportIn.do">등록</span>
				</a>
			</div>
		</div>
    </form>
    <form name="fileDownForm" method="post"
		action="/base/downloadFile.do">
		<input type="hidden" name="jdgSeq" id="jdgSeq" />
	</form>
  </main>
  
  
   <div class="modal fade fixed top-0 left-0 h-full w-full z-[200] bg-black/50 items-center justify-center duration-300" id="plFinalDestinationPopUp"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true" style="display: none; ">
		<div class="modal-close absolute top-0 left-0 w-full h-full"></div>
			<div class="modal-dialog modal-xl" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); width:800px;" >
				<div class="modal-content bg-white shadow-lg relative rounded min-w-80 overflow-hidden">
					<div class="pl-7 pr-5 py-2 text-white bg-primary-900 flex items-center justify-between">
						<h4 class="modal-title">
							<span>Final Destination</span>
						</h4>
						<button type="button" onclick="plFinalPopupClose()" class="modal-close text-2xl px-1.5 py-1 rounded-lg hover:bg-rose-500/70 border-2 border-transparent hover:border-white duration-300 flex items-center justify-center"><i class="far fa-xmark"></i></button>
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
		                  <input type="text" id="plFinalSrch1" onkeyup="enterkeyPlFinal()" class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="search">
		                </div>
              		</div>
					</div>
					 <div class="modal-body">
						 <div id="plArrListPopupTable" class="grow bg-white shadow-sm h-full max-h-[100rem] rounded-lg border border-slate-200 z-0">
					</div>
				</div> 
			</div>
		</div>
  </div>
	
	
  
</body>
<footer class="w-full mx-auto flex justify-between justify-self-end items-center shrink-0 bg-primary-900 text-gray-200 px-6 py-2 gap-4">
    <span>KORD Systems Inc.</span>
    <span class="mr-auto">Copyright KORD Systems Inc. All rights reserved.</span>
    <a href="mailto:kord@kordsystems.com">
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
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 0 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
              <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
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
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 1 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
              <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
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
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 2 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
              <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
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
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 3 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
              <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
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
            <svg class="shrink-0 mr-2 fill-current text-primary-400" :class="selected !== 4 && 'invisible'" width="12" height="9" viewBox="0 0 12 9">
              <path d="M10.28.28L3.989 6.575 1.695 4.28A1 1 0 00.28 5.695l3 3a1 1 0 001.414 0l7-7A1 1 0 0010.28.28z"/>
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

<script src="//unpkg.com/alpinejs" defer></script>
<script>initDropdowns();</script>
 <script>
    $(".portal-renderer").slideUp(0)
    $("#portal-rendering-button").on("click", function () {
      $(".portal-renderer").slideToggle(200)
      $(this).children(".fa-chevron-down").toggleClass("rotate-180")
    });
    
    function formatPhoneNumber2(input) {
        // 입력값에서 숫자만 추출
        let phoneNumber = input.value.replace(/[^0-9]/g, '');
        
        // 최소 6자리 최대 10자리로 제한
        phoneNumber = phoneNumber.slice(0, 10);

        // 형식 변경
        let formattedNumber = '';
        for (let i = 0; i < phoneNumber.length; i++) {
            if (i === 4) {
                formattedNumber += '.'; // 4번째와 6번째 자리에는 '.'
            } else if (i === 6) {
                formattedNumber += '-'; // 9번째 자리에는 '-'
            }
            formattedNumber += phoneNumber[i];
        }
        
        // 입력 필드에 변경된 값 설정
        input.value = formattedNumber;
    }
</script>
</html>
