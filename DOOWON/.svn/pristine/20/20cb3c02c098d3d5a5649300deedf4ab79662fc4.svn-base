
var buyerAppHot;
var buyrAppIndex = 9999;

$( document ).ready(function() {
	
	
	//var fristPostData = $("#buyerApp_searchForm").serialize();
	 // var listUrl = '/prtl/buyerAppJson.do';
	
	  var buyerAppHotElement = document.querySelector('#buyerAppGrid');
	  var buyrAppElementContainer = buyerAppHotElement.parentNode;
	  buyerAppHot = new Handsontable(buyerAppHotElement, fn_buyrAppHandsonTable());

	  buyerAppHot.loadData([]);
	  fn_searchBuyerApp();
});

//테이블 컬럼
function fn_buyrAppHandsonTable(){
	    
	var stsCd = function(instance, td, row, col, prop, value, cellProperties){
	if(value == '20'){
		$(td).empty().attr("style", "text-align:center").append(colConfmReject);
	} else if(value == '10'){
		$(td).empty().attr("style", "text-align:center").append(colConfmRequst);
	} else {
		$(td).empty().attr("style", "text-align:center").append(colConfm);
	}
		
}
	
	var buyrAppSettings = {
		  columns : [
			  {data:'cnt',type:'text',width : 50},
		      {data:'taxNb',type:'text', width : 100},
		      {data:'cmpnyCd', type:'text', width : 100},
		      {data:'pcsStsCd',type:'text', renderer: stsCd, width : 100},   
		      {data:'pcsStsMsg',type:'text', width : 300}, 
    	  ],
    	  //플랜트코드 구매처코드 구매번호 항번 품목코드 물목명 협정명 HS코드 HS버전 PSR 요청일자 원산지 PSR 문서첨부 송신일자 처리현황 승인거절사유
    	  stretchH : 'all',
    	  width : '98%',
    	  autoWrapRow : true,
    	  height : 420,
    	  rowHeights : 10,
    	  rowHeaders : true,
    	  columnHeaderHeight : 10,
    	  colHeaders :[
    		  'No',colBuyerTax,colBuyerCd,colPcsStsNm,colPcsStsCmt 
    		  ],
    
		  manualRowResize : true,
    	  manualColumnResize : true,
    	  manualRowMove : true,
		  manualColumnMove : false,
		  contextMenu : false,
		 // dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		  filters : true,
		  readOnly : true,
		 // columnSorting : {
		//	  indicator : true
         // },
          autoColumnSize : {
        	  samplingRatio : 10
          },
          mergeCells : false,
          allowInsertRow : false
	};

	return buyrAppSettings;
};
	


//초기화
function fn_clearBuyerApp(){
	$("#buyerApp_srch3").val("");
	$("input:radio[name=srch4]")[0].checked = true;
};

function fn_setBuyerAppForm()
{
	var sData = {};
	sData["srch3"] = $("#buyerApp_srch3").val();
	sData["srch4"] = $("#buyerApp_srch4:checked").val();
	return sData;
};


// 판매처 승인내역 조회
function fn_searchBuyerApp(){
	buyerAppIndex = 0;
	console.log(JSON.stringify(fn_setBuyerAppForm()));
	$.ajax({
		type : "POST",
		url : "/prtl/buyerAppJson.do",
		data : fn_setBuyerAppForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	buyerAppHot.loadData([]);
        	buyerAppHot.loadData(data.resultList);
        	$("#buyerAppInfoCnt").text(data.totCnt).number(true); //검색결과 총 갯수	
        	
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else { 
	        	console.log(errorThrown);
	        	//alert(msgSearchError);
        	}
        }
	});
};


// 판매처 승인 요청 저장
function fn_saveBuyerApp(){
	if(!confirm(msgSaveBuyerAppConfirm)){
		return;
	}
	
	var saveBuyerAppData = {/*'corpNo':$("#taxCd").val(),*/ 'cmpnyCd':$("#cmpnyCd").val()};

	$.ajax({
		type : "POST",
		url : "/prtl/saveBuyerApp.do",
		data : JSON.stringify(saveBuyerAppData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		fn_searchBuyerApp();
        		alert(msgSaveBuyerAppSuccess);
        		$('#vndrConfmPop').modal('hide');
        	}
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else { 
	        	console.log(errorThrown);
	        	alert(msgSaveBuyerAppError);
        	}
        }
	});
	
};