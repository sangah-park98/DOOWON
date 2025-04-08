var judgeHot;
var judgeIndex = 9999;
var judgeScrollTp = true;
var judgeResultHot;

var judgeHistRenderer ;
var originJdgAllSelect = false ;
var originJdgDataIsChecked = false ;
var judgeSts = false ; // fasle  판정미실행  true 판정실행
var judgeDataChkCnt = 0 ;
var judgeFtaCdChkCnt = 0 ;
var resultA = 0 ;
var resultB = 0 ;
var resultC = 0 ;
var judgeCnt = 0 ;
var judgeMngNo = "" ;
var jdgRawMtPopHot;
var judgeIng = true ;
var JdgRawMtDataLength = 1 ;
var currentJdgmntSeq = 0 ;
var goJudgeMode = "all";
var reGoKudgList = null;//재판정 리스트
var jdgType = "";


$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);
  //첫번째 그리드 그리기
	
	  var date = new Date();
	  var month = date.getMonth();
	  
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
	  
	  $("input[name=judgeResultDate]").val(today);
	 


	$("select#alignJudgeResult option").remove();

	 fn_searchResultOption1(true);
	 fn_searchResultOption2(false);



	 fn_searchJudgeResult();

	 fn_judgeResult_regScrollEvent(); //이벤트 등록
	 
	 
	 var resultElement = document.querySelector('#judgeResultTable');
	 var resultElementContainer = resultElement.parentNode;
	 resultSettings = fn_judgeResult1() ;
	 judgeResultHot = new Handsontable(resultElement, resultSettings);
	 
	  

});

function fn_judgeResult_regScrollEvent(){
	 $("#judgeTable .wtHolder").scroll(function(){
		  var scrollTop = $("#judgeTable .wtHolder").scrollTop();
		  var countPerPage = $("#judgePageCnt option:selected").val();
		  var rowHeight = judgeResultHot.getRowHeight();

		  var addCnt = 790;
		  if(countPerPage == "50"){
			  addCnt = 790;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "200"){
			  addCnt = 3290;
		  }else if(countPerPage == "500"){
			  addCnt = 4540;
		  }

		  if(judgeScrollTp && judgeIndex != 9999 && scrollTop >= (countPerPage * judgeIndex * rowHeight) + addCnt){
			  fn_judgeScroll();
		  }
	});
}

//이벤트등록

//$("body").on("keydown", function(){
//	if (window.event.keyCode == 13 && $("#tabs-originjdgmnt").hasClass("active")) {
//		fn_searchJudge();
//	}
//})

//검색구분
$("input[name=judgeResultType]").change(function(){

	  fn_changeJdgResultType($(this).val());
});

$("input[name=preSeq]").change(function(){
	  alert($(this).val());
});




//정렬항목
$("select[name=alignJudgeResult]").change(function(){ fn_searchJudgeResult();});
//row 수
$("select[name=judgePageCnt]").change(function(){fn_searchJudgeResult();});







function fn_changeJdgResultType(type){
	$("select#alignJudgeResult option").remove();

	if(type == "01"){
		fn_searchResultOption1(true);
		fn_searchResultOption2(false);
		judgeResultHot.updateSettings(fn_judgeResult1());
	}else if(type == "02"){
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		judgeResultHot.updateSettings(fn_judgeResult2());
	}else if(type == "03"){
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		judgeResultHot.updateSettings(fn_judgeResult3());
	} else if(type == "04"){
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		judgeResultHot.updateSettings(fn_judgeResult4());
	} else if(type == "05"){
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		judgeResultHot.updateSettings(fn_judgeResult5());
	} 
	

	fn_searchJudgeResult();
}
function fn_setSearchFormResult(){
	var sData = {};
	
	sData["srch1"] = $("input[name=judgeResultDate]").val();
	sData["srch2"] = $("input[name=judgeResult_itemCd1]").val();
	sData["searchType"] = $("input:radio[name=judgeResultType]:checked").val();
	sData["alignItem"] = $("#alignJudgeResult option:selected").val();

	return sData;
};
function fn_searchResultOption1(mode){
	if (mode) {

		$("select#alignJudgeResult").append("<option value='' selected >"+colOrderby+"</option>"+
				"<option value='SALES_NO' >"+colSalesNo+"  &uarr; </option>"+
				  "<option value='SALES_NO_DESC' >"+colSalesNo+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemAllCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemAllCd+"  &darr; </option>"+
				  "<option value='BUYR_CD' >"+colBuyrCd+" &uarr; </option>"+
				  "<option value='BUYR_CD_DESC' >"+colBuyrCd+"  &darr; </option>" );


	 $('select#alignJudgeResult').on('change', function() {
	        
	        var selectedOption = $(this).val(); 
	        fn_searchJudgeResult(selectedOption); 
	    });
	}
	}
function fn_searchResultOption2(mode){
	if (mode) {

	$("select#alignJudgeResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='SALES_NO' >"+colSalesNo+"  &uarr; </option>"+
			  "<option value='SALES_NO_DESC' >"+colSalesNo+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemAllCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemAllCd+"  &darr; </option>"+
			  "<option value='BUYR_CD' >"+colBuyrCd+" &uarr; </option>"+
			  "<option value='BUYR_CD_DESC' >"+colBuyrCd+"  &darr; </option>");


 $('select#alignJudgeResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchJudgeResult(selectedOption); 
    });
}
}
//이벤트 등록끝

function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_searchJudgeResult(selectedOption){
	judgeIndex = 0;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeResult.do",
		data : fn_setSearchFormResult(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	judgeResultHot.loadData([]);
        	judgeResultHot.loadData(data.resultList);  //핸드슨


        	$("#judgeResultCnt").text(data.totCnt).number(true); //검색결과 총 갯수
        	fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});
};
function fn_judgeResult1(){
	  var resultPopupElement = document.querySelector('#judgeResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	      {data : 'salesQty', type : 'text', className : "htCenter"},
	      {data : 'salesDt', type : 'text', className : "htCenter"},
	      {data : 'itemCd', type : 'text', className : "htCenter"},    
	      {data : 'rawItemCd', type : 'text', className : "htCenter"},    
	      {data : 'useQty', type : 'text', className : "htCenter"},
	    ],
	    stretchH : 'all',
	    width : '98.7%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      	
	      colSalesQty,
	      colSalesDt,
	      colItemCd,
	      colRowMate,
	      colRequiredQty,
	        
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : {
	      samplingRatio : 23
	    },
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}

function fn_judgeResult2(){
	var resultPopupElement = document.querySelector('#judgeResultTable');
	
	
	resultPopupSettings = {
			columns : [
				
				{data : 'itemCd', type : 'text', className : "htCenter"},    
				{data : 'rawItemCd', type : 'text', className : "htCenter"},    
				{data : 'noHscd', type : 'text', className : "htCenter"},
				],
				stretchH : 'all',
				width : '98.7%',
				autoWrapRow : true,
				height : 500,
				rowHeights : 25,
				rowHeaders : true,
				columnHeaderHeight : 25,
				colHeaders : [
					
					colItemCd,
					colRowMate,
					"HS CD",
					
					],
					manualRowResize : true,
					manualColumnResize : true,
					manualRowMove : true,
					manualColumnMove : false,
					contextMenu : true,
					//dropdownMenu : true,
					filters : true,
					readOnly : false,
					autoColumnSize : {
						samplingRatio : 23
					},
					mergeCells : true,
					allowInsertRow : false,
					copyPaste: true,
					colWidths: 100 
	};
	
	return resultPopupSettings;
}

function fn_judgeResult3(){
	var resultPopupElement = document.querySelector('#judgeResultTable');
	
	
	resultPopupSettings = {
			columns : [
				
				{data : 'itemCd', type : 'text', className : "htCenter"},    
				{data : 'prdctVnm', type : 'text', className : "htCenter"},    
				{data : 'prdctEnm', type : 'text', className : "htCenter"},    
				{data : 'noHscd', type : 'text', className : "htCenter"},
				],
				stretchH : 'all',
				width : '98.7%',
				autoWrapRow : true,
				height : 500,
				rowHeights : 25,
				rowHeaders : true,
				columnHeaderHeight : 25,
				colHeaders : [
					
					colItemCd,
					colPrdctVnm,
					colPrdctEnm,
					"HS CD",
					
					],
					manualRowResize : true,
					manualColumnResize : true,
					manualRowMove : true,
					manualColumnMove : false,
					contextMenu : true,
					//dropdownMenu : true,
					filters : true,
					readOnly : false,
					autoColumnSize : {
						samplingRatio : 23
					},
					mergeCells : true,
					allowInsertRow : false,
					copyPaste: true,
					colWidths: 100 
	};
	
	return resultPopupSettings;
}

function fn_judgeResult4(){
	var resultPopupElement = document.querySelector('#judgeResultTable');
	
	
	resultPopupSettings = {
			columns : [
				
				{data : 'itemCd', type : 'text', className : "htCenter"},    
				{data : 'prdctVnm', type : 'text', className : "htCenter"},    
				{data : 'prdctEnm', type : 'text', className : "htCenter"},    
				{data : 'noPsr', type : 'text', className : "htCenter"},
				],
				stretchH : 'all',
				width : '98.7%',
				autoWrapRow : true,
				height : 500,
				rowHeights : 25,
				rowHeaders : true,
				columnHeaderHeight : 25,
				colHeaders : [
					
					colItemCd,
					colPrdctVnm,
					colPrdctEnm,
					"PSR",
					
					],
					manualRowResize : true,
					manualColumnResize : true,
					manualRowMove : true,
					manualColumnMove : false,
					contextMenu : true,
					//dropdownMenu : true,
					filters : true,
					readOnly : false,
					autoColumnSize : {
						samplingRatio : 23
					},
					mergeCells : true,
					allowInsertRow : false,
					copyPaste: true,
					colWidths: 100 
	};
	
	return resultPopupSettings;
}

function fn_judgeResult5(){
	var resultPopupElement = document.querySelector('#judgeResultTable');
	
	
	resultPopupSettings = {
			columns : [
				
				{data : 'itemCd', type : 'text', className : "htCenter"},    
				{data : 'prdctVnm', type : 'text', className : "htCenter"},    
				{data : 'prdctEnm', type : 'text', className : "htCenter"},    
				{data : 'noBom', type : 'text', className : "htCenter"},
				],
				stretchH : 'all',
				width : '98.7%',
				autoWrapRow : true,
				height : 500,
				rowHeights : 25,
				rowHeaders : true,
				columnHeaderHeight : 25,
				colHeaders : [
					
					colItemCd,
					colPrdctVnm,
					colPrdctEnm,
					"BOM",
					
					],
					manualRowResize : true,
					manualColumnResize : true,
					manualRowMove : true,
					manualColumnMove : false,
					contextMenu : true,
					//dropdownMenu : true,
					filters : true,
					readOnly : false,
					autoColumnSize : {
						samplingRatio : 23
					},
					mergeCells : true,
					allowInsertRow : false,
					copyPaste: true,
					colWidths: 100 
	};
	
	return resultPopupSettings;
}

function fn_judgeResultScroll(){


	judgeScrollTp = false;
	judgeIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeResult.do",
		data : fn_setSearchFormResult(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var getData = judgeResultHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);

        	judgeResultHot.loadData(meargeJson);   //핸드슨 정보

        	judgeScrollTp = true;
        	fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});

}




