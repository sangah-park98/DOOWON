var orgnHot;
var orgnIndex = 9999;
var orgnScrollTp = true;
var orgnResultHot;
var resultOrgnPopupSettings;

//모달창
function showPurchaseFilePop(){
	if($("#filePopupPc").length>1){
		$("#filePopupPc").eq(0).modal("show");
	} 
	$("#filePopupPc").modal("show");
}

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

	 
	 
	var date = new Date();
	var month = date.getMonth();

	var today = new Date().toISOString().substring(0, 10).replace(/-/g, '/');
	var mtoday;

	var currentDate = new Date();
	currentDate.setMonth(currentDate.getMonth() - 3);
	mtoday = currentDate.toISOString().substring(0, 10).replace(/-/g, '/');

	const radioButtons = document.querySelectorAll('input[name="rpt_srch1"]');
	const rptDate1Input = document.querySelector('input[name="rptDate3"]');
	const rptDate2Input = document.querySelector('input[name="rptDate4"]');

	function updateMtoday(event) {
	  var selectedValue = event.target.value;
	  var monthsToSubtract = parseInt(selectedValue);
	  var selectedDate = new Date(rptDate2Input.value);
	  var updatedDate = new Date(selectedDate.setMonth(selectedDate.getMonth() - monthsToSubtract));
	  var formattedDate = updatedDate.toISOString().substring(0, 10).replace(/-/g, '/');
	  mtoday = formattedDate;
	  rptDate1Input.value = mtoday; 
	  console.log('Updated mtoday:', mtoday);
	}

	radioButtons.forEach((radioButton) => {
	  radioButton.addEventListener('change', updateMtoday);
	});

	radioButtons.forEach((radioButton) => {
	  if (radioButton.value === '03') {
	    radioButton.checked = true;
	    rptDate1Input.value = mtoday; 
	  }
	});
	$("input[name=rptDate4]").val(today);
	rptDate2Input.addEventListener('change', updateMtoday); 
	$("select#alignorgnResult option").remove();

	var resultElement = document.querySelector('#orgnResultTable');
	var resultElementContainer = resultElement.parentNode;
	
	orgnResultHot = new Handsontable(resultElement, fn_handsonGridOrgnOption('read'));

	
	 fn_searchResultOption11(false);
	 fn_searchResultOption22(true);

	 fn_changeOrgn('read');

	 fn_reportExcelSrch("01");
	 
	 fn_searchorgnResult();

	 fn_orgnResult_regScrollEvent(); //이벤트 등록
	 
	 
	 
	  

});

function fn_orgnResult_regScrollEvent(){
	 $("#orgnTable .wtHolder").scroll(function(){
		  var scrollTop = $("#orgnTable .wtHolder").scrollTop();
		  var countPerPage = $("#orgnPageCnt option:selected").val();
		  var rowHeight = orgnResultHot.getRowHeight();

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

		  if(orgnScrollTp && orgnIndex != 9999 && scrollTop >= (countPerPage * orgnIndex * rowHeight) + addCnt){
			  fn_orgnScroll();
		  }
	});
}

//이벤트등록

//$("body").on("keydown", function(){
//	if (window.event.keyCode == 13 && $("#tabs-originjdgmnt").hasClass("active")) {
//		fn_searchJudge();
//	}
//})
$("input[name=orgnType]").change(function() {
 
	fn_changeOrgn($(this).val());
	fn_reportExcelSrch($(this).val());

});
//검색구분
$("input[name=orgnResultType]").change(function(){
	  fn_changeorgnResultType($(this).val());
	  fn_reportExcelSrch($(this).val());
	  fn_clearRpt();
});

$("input[name=preSeq]").change(function(){
	  alert($(this).val());
});
function enterkey() {
	if (window.event.keyCode == 13) {
		fn_setSearchFormResult2();
    }
}

function fn_clearRpt() {

	$("input[name=itemCd]", document.geneResultHot).val("");
	$("input[name=exportNation]", document.orgnResultHot).val("");
	$("input[name=itemCd]", document.orgnResultHot).val("");
	$("input[name=buyrNm]", document.orgnResultHot).val("");
	$("#rpt_srch6", document.orgnResultHot).val("");
	$("input[name=hsCd]", document.orgnResultHot).val("");
};

//정렬항목
$("select[name=alignorgnResult]").change(function(){ fn_searchorgnResult();});
//row 수
$("select[name=orgnPageCnt]").change(function(){fn_searchorgnResult();});


function fn_changeOrgn(type) {
  
	if(type == "read"){
		$("#orgnExcel").show();
		$("#btnOrgnSave").hide();

		
	}else if (type == "edit") {
		$("#orgnExcel").hide();
		$("#btnOrgnSave").show();

		
	} else {
		$("#orgnExcel").hide();
		$("#btnOrgnSave").show();

	}
	
	
	fn_changeorgnResultType($("input[name=orgnResultType]:checked").val());
};


function fn_callPopReport(target, row, col) {
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	// 아이템 조회
	if (target == "itemCd" || target == "1") {
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM"
				: "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colItemCd);
	} else if(target == "partnCd" || target == "partnCd1"){
		strSearch = (colLang == "en") ? "DISTINCT(BUYR_ID) AS CD, BUYR_NM_EN AS CD_NM"
				: "DISTINCT(BUYR_ID) AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colPartnCd);
	} else if(target == "partnItemCd"){
		strSearch = "DISTINCT(PARTN_ITEM_CD) AS CD, PARTN_ITEM_NM AS CD_NM"
		strFrom = "PARTN_ITEM_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = "PARTN_ITEM_NM";
		$("#exampleModalCenterTitleCmmn").text(colPartnItemCd);
	}

	type = target;

	var condition = {
		type : "tableCd",
		search : strSearch,
		from : strFrom,
		where : strWhere,
		orderby : strOrderby,
		if1 : strIf1,
		if2 : strIf2,
		type : type,
		row : row,
		col : col
	};

	fn_showCmmnPopup(condition, function(data) {
		if (data.type == "itemCd") {
			$("#rpt_srch2").val(data.cd);
		} else if(data.type == "partnCd"){
			$("#gene_srch10").val(data.cd);
		} else if(data.type == "partnItemCd"){
			$("#item_srch12").val(data.cd);
		} else if(data.type == "partnCd1"){
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		} else {
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
};

function fn_changeorgnResultType(type){

	let orgnCol = new fn_orgnTableCol();
	let orgnHeader = new fn_orgnTableHeader();
	let orgnHidden = new fn_orgnTableHidden();

	var col, header, hidden;
	if(type == "01"){

		$("#rpt_input3").hide();
		$("#rpt_input4").hide();
		$("#rpt_input5").hide();
		$("#fta").hide();
		$("#rpt_input7").hide();

		fn_searchResultOption11(true);
		fn_searchResultOption22(false);
		col = orgnCol.orgnCol;
		header = orgnHeader.orgnHeader;
		hidden = orgnHidden.orgnHidden;
		//그리드 옵션조정
		$("#editYn").show();
		orgnResultHot.updateSettings(fn_handsonGridOrgnOption(col, header, hidden));
	}else if(type == "02"){
		$("#rpt_input3").show();
		$("#rpt_input4").show();
		$("#rpt_input5").show();
		$("#fta").show();
		$("#rpt_input7").show();
		fn_searchResultOption11(false);
		fn_searchResultOption22(true);
		$("#editYn").hide();
		$("#orgnExcel").show();
		$("#btnOrgnSave").hide();
		col = orgnCol.orgnCol;
		header = orgnHeader.orgnHeader;
		hidden = orgnHidden.orgnHidden;
		//그리드 옵션조정
		orgnResultHot.updateSettings(fn_orgnResult2());
	}
	

	fn_searchorgnResult();
}
function fn_setSearchFormResult2(){
	var sData = {};
	var gridType = $("input:radio[name=orgnResultType]:checked").val()  ;
	if (gridType=="01") {


	} else {
		sData["srch3"] =$("input[name=exportNation]", document.orgnResultHot).val();
		sData["srch4"] =$("input[name=itemCd]", document.orgnResultHot).val();
		sData["srch5"] =$("input[name=buyrNm]", document.orgnResultHot).val();
		sData["srch6"] =$("#rpt_srch6", document.orgnResultHot).val();
		sData["srch7"] =$("input[name=hsCd]", document.orgnResultHot).val();
	}
	sData["srch10"] = $("input:radio[name=orgnResultType]:checked").val();
	sData["alignItem"] = $("#alignorgnResult option:selected").val();
	sData["srch1"] =$("input[name=rptDate3]", document.orgnResultHot).val();
	sData["srch2"] =$("input[name=rptDate4]", document.orgnResultHot).val();

	return sData;
};
function fn_reportExcelSrch(type){
	console.log("111 : " + type);
	$("#searchType").val($("input:radio[name=orgnResultType]:checked").val());
	if(type == '01'){
		$("#reportExTit").val(orgnreport);
		$("#reportExCol").val(String([exportNation,colFtaCd,colHsCd,mfnPrice,ftaPrice2,applyYear+","]));						
		$("#reportExCd").val("exportNation,ftaCd,hsCd,mfnPrice,ftaPrice,applyYear,");
		$("#reportExType").val("text,text,text,text,floatString,floatString,int,");
	}else if(type == '02'){
		$("#reportExTit").val(orgnreport);
		$("#reportExCol").val(String([exportNation,buyrNm,colFtaCd,colItemCd,colHsCd,mfnPrice,ftaPrice2,applyYear,customPrice+","]));
		$("#reportExCd").val("exportNation,buyrNm,ftaCd,itemCd,hsCd,mfnPrice,ftaPrice,applyYear,calPrice,");
		$("#reportExType").val("text,text,text,text,text,floatString,floatString,texts,floatString,");
	
}
}
function fn_searchResultOption11(mode){
	if (mode) {

		$("select#alignorgnResult").append("<option value='' selected >"+colOrderby+"</option>"+
				 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
				  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
				  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
				  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
				  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
				  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


	 $('select#alignorgnResult').on('change', function() {
	        
	        var selectedOption = $(this).val(); 
	        fn_searchorgnResult(selectedOption); 
	    });
	}
	}
function fn_searchResultOption22(mode){
	if (mode) {
	

	$("select#alignorgnResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnResult(selectedOption); 
    });
}
}

//이벤트 등록끝

function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_searchorgnResult(selectedOption){
	$("#reportSrch10").val($("input:radio[name=orgnResultType]:checked").val());
	orgnIndex = 0;
	fn_loading(true);
	
	$.ajax({
		type : "POST",
		url : "/rpt/selectorgnreport.do",
		data : fn_setSearchFormResult2(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	
        	orgnResultHot.loadData([]);
        	orgnResultHot.loadData(data.resultList);  //핸드슨


        	$("#orgnResultCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_handsonGridOrgnOption(col,header,hidden){

	var tableType = $("input[name=orgnType]:checked").val();
	
	  
	  resultOrgnPopupSettings = {
			  columns : col,
				colHeaders : header,
				hiddenColumns : {
					copyPasteEnabled : false,
					indicators : false,
					columns : hidden
				},
				stretchH : 'all',
				width : '98%',
				autoWrapRow : true,
				height : 487,
				autoRowSize : true,
				manualRowResize : true,
				manualColumnResize : true,
				rowHeights : 25,
				rowHeaders : true,
				columnHeaderHeight : 25,
				manualRowMove : true,
				manualColumnMove : false,
				//dropdownMenu : true,

				contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
				//dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
				filters : true,
				readOnly : (tableType == "read") ? true : false,
				allowRemoveRow : true,
				//columnSorting : {indicator : true},
				autoColumnSize : {samplingRatio : 23},
				wordWrap : true,
				
			};

	  return resultOrgnPopupSettings;
	}

function fn_orgnResultScroll(){


	orgnScrollTp = false;
	orgnIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/rpt/selectorgnResult.do",
		data : fn_setSearchFormResult2(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var getData = orgnResultHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);

        	orgnResultHot.loadData(meargeJson);   //핸드슨 정보

        	orgnScrollTp = true;
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
function fn_orgnTableCol(){
	//var resultPopupElement = document.querySelector('#orgnResultTable');
	var tableType = $("input[name=orgnType]:checked").val();
	var pkNoneEdit = function(instance, td, row, col, prop, value, cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	var percentRenderer = function (instance, td, row, col, prop, value, cellProperties) {
	    $(td).empty().css("text-align", "center");
	    
	    if (value !== "") {
	        $(td).append(value + "%");
	    } else {
	        $(td).append(value);
	    }
	};

	this.orgnCol = (tableType == "edit") ? [
		{data : 'exportNation',type : 'text',className : "htCenter",readOnly : true, renderer : pkNoneEdit},
		{data : 'ftaCd',type : 'text',className : "htCenter",readOnly : true, renderer : pkNoneEdit},
		{data : 'hsCd', type : 'text',className : "htCenter",readOnly : true, renderer : pkNoneEdit ,
			renderer:function(instance, td, row, col, prop, value, cellProperties) {
	         if (value && (value.length === 8 || value.length === 6)) {
	        	 if(value.length === 8){
		        	   value = value.slice(0,6) + "-" + value.slice(6);
		           }	        
	           // Insert "-" at the 6th position
	           value = value.slice(0, 4) + "." + value.slice(4);
	          
	         }
	         Handsontable.renderers.TextRenderer.apply(this, arguments);
	       }
	      },    
		{data : 'mfnPrice', type : 'text',className : "htCenter"},
		{data : 'ftaPrice', type : 'text',className : "htCenter"},
		{data : 'applyYear', type : 'text',className : "htCenter"}
		

	] : [
		{data : 'exportNation',type : 'text',className : "htCenter",readOnly : true},
		{data : 'ftaCd',type : 'text',className : "htCenter",readOnly : true},
		{data : 'hsCd', type : 'text',className : "htCenter",readOnly : true,
			renderer: function(instance, td, row, col, prop, value, cellProperties) {
	         if (value && (value.length === 8 || value.length === 6)) {
	        	 if(value.length === 8){
		        	   value = value.slice(0,6) + "-" + value.slice(6);
		           }	        
	           // Insert "-" at the 6th position
	           value = value.slice(0, 4) + "." + value.slice(4);
	          
	         }
	         Handsontable.renderers.TextRenderer.apply(this, arguments);
	       }
	      },   
		{data : 'mfnPrice', type : 'numeric',format:'0%',className : "htCenter", renderer: percentRenderer},
		{data : 'ftaPrice', type : 'numeric',format:'0%',className : "htCenter", renderer: percentRenderer},
		{data : 'applyYear', type : 'text',className : "htCenter"}
	];
}

//테이블 헤더
function fn_orgnTableHeader(){
	var tableType = $("input[name=orgnType]:checked").val();

	this.orgnHeader = (tableType == "edit") ? [
		exportNation,colFtaCd,colHsCd,mfnPrice,ftaPrice2,applyYear
	] : [
		exportNation,colFtaCd,colHsCd,mfnPrice,ftaPrice2, applyYear
	];

}

//테이블 히든컬럼
function fn_orgnTableHidden(){
	var tableType = $("input[name=orgnType]:checked").val();

	this.orgnHidden =  [];

	this.orgnHsHidden = [];

	this.orgnPartnHidden =  [];
}

function fn_saveData() {
	//if(!confirm(msgSaveConfirm)) return;
	fn_loading(true);
	var checkedData = orgnResultHot.getSourceData();
	var popData = [];
	
	

	for(var i=0; i<checkedData.length; i++){
		
		if(checkedData[i]['mfnPrice'] != '') {
			popData.push(checkedData[i]);
		}
	}


	console.log(popData);
$.ajax({
		type : "POST",
		url : "/rpt/saveCoReportList.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				alert("save");
				if ($("input[name=orgnType]:checked").val() == "edit") {
					$("input:radio[name=orgnType]")[0].checked = true;
					fn_changeOrgn($("input[name=orgnType]:checked").val());
				}
				$("input:radio[name=orgnType]:input[value='read']").trigger("click");
				fn_searchorgnResult();
			} 
			fn_loading(false);
		},
		error : function(e, textStatus, errorThrown) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
				console.log(errorThrown);
				alert("error");
        	}
		}
	});

};
function fn_orgnResult2(){
	  var resultPopupElement = document.querySelector('#orgnResultTable');
		var percentRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		    $(td).empty().css("text-align", "center");
		    
		    if (value !== "") {
		        $(td).append(value + "%");
		    } else {
		        $(td).append(value);
		    }
		};
	  
	  resultOrgnPopupSettings = {
	    columns : [
	     
	      {data : 'exportNation', type : 'text', className : "htCenter",width:60},
	      {data : 'buyrNm', type : 'text', className : "htCenter",width:200},
	      {data : 'ftaCd', type : 'text', className : "htCenter"},   
	      {data : 'itemCd', type : 'text', className : "htCenter"},   
	      {data : 'hsCd', type : 'text', className : "htCenter",renderer:function(instance, td, row, col, prop, value, cellProperties) {
		         if (value && (value.length === 8 || value.length === 6)) {
		        	 if(value.length === 8){
			        	   value = value.slice(0,6) + "-" + value.slice(6);
			           }	        
		           // Insert "-" at the 6th position
		           value = value.slice(0, 4) + "." + value.slice(4);
		          
		         }
		         Handsontable.renderers.TextRenderer.apply(this, arguments);
		       }
		      },   
	      {data : 'mfnPrice', type : 'text', className : "htCenter",renderer: percentRenderer},
	      {data : 'ftaPrice', type : 'text', className : "htCenter",renderer: percentRenderer},
	      {data : 'applyYear', type : 'text', className: "htCenter" },
	      {data : 'calPrice', type : 'text', className:  "htRight" },
	      
	    ],
	    stretchH : 'all',
	    width : '98.7%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      	
	     exportNation,
	     buyrNm,
	     colFtaCd,
	    colItemCd,
	    colHsCd,
	    mfnPrice,
	    ftaPrice2,
	    applyYear,
	    customPrice
	    
	        
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
	    beforeRowFilter: function (row, data) {
	        // totPrice 또는 calPrice가 빈 값이거나 null인 경우 해당 row를 출력하지 않습니다.
	        if (!data.calPrice) {
	          return false; // row를 걸러냅니다.
	        }
	        return true; // row를 유지합니다.
	      },
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultOrgnPopupSettings;
	}

/*document.getElementById("reportDownBtn2").addEventListener("click", function(event) {
    event.preventDefault(); // 기본 동작 방지

    // FTA기준일
    var url = "/rpt/pdfDownload2.do"; // 서버 측 매핑과 일치하는 URL로 설정

    // 데이터 구성
    var sData = {};
    sData["srch1"] = $("input[name=rptDate3]", document.orgnResultHot).val();
    sData["srch2"] = $("input[name=rptDate4]", document.orgnResultHot).val();

    // URL에 데이터 매개변수 추가
    url += "?srch1=" + encodeURIComponent(sData["srch1"]) + "&srch2=" + encodeURIComponent(sData["srch2"]);

    // 새 탭이나 창에서 URL 열기
    window.open(url, "_blank");
});*/

//excel 업로드
function fn_saveFile(){

	var fileInput = document.getElementById('infoFiles');
	var file =  fileInput.files[0];
	var form = new FormData();
	form.append('file',file);
	
	$.ajax({
		type : "POST",
		url : "/rpt/excelUpload.do",
		data: form,
		beforeSend : function(xhr){
			xhr.setRequestHeader("AJAX",true);
		},
		
		dataType:'json',
		processData:false,
		contentType:false,
		success : function(data){
			console.log('업로드 성공 :', data);
			
			// 엑셀 업로드 후 필터링과 열 제외
            var filteredData = data.resultList.map(function (item) {
                // 필요한 데이터만 선택
                return {
                    'mfnPrice' : item.mfnPrice,
                    'ftaPrice' : item.ftaPrice,
                    'applyYear' : item.applyYear,
                };
            });
             // 각 행에 대해 데이터 업데이트 
            for (var i = 0; i < orgnResultHot.countRows(); i++) {
            	                 // 행의 수를 반환
				orgnResultHot.setDataAtCell(i, orgnResultHot.propToCol('mfnPrice'), filteredData[i].mfnPrice);
				//테이블의 특정 행과 열에 할당
				orgnResultHot.setDataAtCell(i, orgnResultHot.propToCol('ftaPrice'), filteredData[i].ftaPrice);
				orgnResultHot.setDataAtCell(i, orgnResultHot.propToCol('applyYear'), filteredData[i].applyYear); 
			}
           
            orgnResultHot.render(); // 핸즈온테이블을 다시 렌더링
        },
		error:function(request, status, error) {
		 	console.log("code: " + request.status)
	        console.log("message: " + request.responseText)
	        console.log("error: " + error);
		}
	});
}


