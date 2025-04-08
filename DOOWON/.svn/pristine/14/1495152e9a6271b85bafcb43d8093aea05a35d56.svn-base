var unitHot;
var unitHotSettings;
var unitPricePageIndex = 9999;
var unitScrollTp = true;
var plntCdSelect = [];
var plntCdCol;
var itemCdCol;
var strtDtCol;

$( document ).ready(function() {
	//캘린더
    $('.band-calendar').each(function(){ regCal(this) ;})
	//캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

	plntCdList = plntCdList.replace('[','').replace(']','');
	plntCdSelect = plntCdList.split(', ');

	var unitHotElement = document.querySelector('#hanUnit');
	var unitHotElementContainer = unitHotElement.parentNode;

	unitHot = new Handsontable(unitHotElement, unitHotSettings);

	$("#btnUnitPriceSave").hide();
	fn_unitPriceChangeTable('read');
	fn_searchUnitPrice();

	fn_scroll() //스크롤 함수

});

/** 이벤트 Start**/
function fn_scroll(){
	$("#hanUnit .wtHolder").scroll(function(){
		  var scrollTop = $("#hanUnit .wtHolder").scrollTop();
		  var countPerPage = $("#unitPageCnt option:selected").val();
		  var rowHeight = unitHot.getRowHeight();

		  var addUnitCnt = 790;
		  if(countPerPage == "50"){
			  addUnitCnt = 790;
		  }else if(countPerPage == "100"){
			  addUnitCnt = 2040;
		  }else if(countPerPage == "200"){
			  addUnitCnt = 3290;
		  }else if(countPerPage == "500"){
			  addUnitCnt = 4540;
		  }

		  if(unitScrollTp && unitPricePageIndex != 9999 && scrollTop >= (countPerPage * unitPricePageIndex * rowHeight) + addUnitCnt){
			  fn_searchUnitPriceScroll();
		  }
	});
}


//달력 창 닫기

$(document).mousedown(function(e){	
	if(e.target.name == "unitPrice_date"){
		if($(".calendar-popup-container").hasClass("calendar-popup-container_active")){
			return;
		}
		$(".calendar-popup-container").remove();
		$('.band-calendar').each(function(){ regCal(this);});
	}else{
		if($(".calendar-popup-container").hasClass("calendar-popup-container_active")){
			$(".calendar-popup-container").attr("class", "calendar-popup-container");
		}	
	}
});


//테이블 타입 변경
$("input[name=unitType]").change(function(){
	    fn_unitPriceChangeTable($(this).val());
});

//정렬항목
$("select[name=alignUnit]").change(function(){
	  fn_searchUnitPrice();
});

//row 수
$("select[name=unitPageCnt]").change(function(){
	  fn_searchUnitPrice();
});

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-unitprice").hasClass("active")) {
//			fn_searchUnitPrice();
//		}
//	}
//})

/** 이벤트 End**/

//스크롤
function fn_searchUnitPriceScroll(){
	if ($("input[name=unitType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	unitScrollTp = false;
	unitPricePageIndex++;

	$.ajax({
		type : "POST",
		url : "/base/selectUnitPriceList.do",
		data : fn_setUnitPriceSearchForm(),
		dataType: "json",
        success : function(data) {
        	var unitHot = unitHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	unitHot.loadData(meargeJson);
        	unitScrollTp = true;
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


//조회
function fn_searchUnitPrice(){
	unitPricePageIndex = 0;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectUnitPriceList.do",
		data : fn_setUnitPriceSearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=unitType]:checked").val() == "enrol"){
        		unitHot.loadData([]);
        		unitHot.alter('insert_row', 1, 1);
        	}else{
        		unitHot.loadData([]);
            	unitHot.loadData(data.resultList);
            	$("#unitCnt").text(data.totCnt).number(true); //검색결과 총 갯수
        	}
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

//조회
function fn_excelUnitPrice(){
	unitPricePageIndex = 0;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/cmmn/excelDownload.do",
		data : fn_setUnitPriceExcelForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        success : function(data) {
        	window.location ="/cmmn/excelDownload.do";
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


//검색조건 생성
function fn_setUnitPriceSearchForm(){
	var sData = {};
	sData["srch2"] = $("#unit_srch2").val();
	sData["srch3"] = $("#unit_srch3").val();
	sData["srch4"] = $("#unit_srch4").val();
	sData["alignItem"] = $("#alignUnit option:selected").val();
	sData["recordCountPerPage"] =  $("#unitPageCnt option:selected").val();
	sData["pageIndex"] = unitPricePageIndex;
	fn_setUnitExcelSearch();
	return sData;
};

//검색 시 엑셀 검색조건 추가
function fn_setUnitExcelSearch(){
	$("#unitSrch2").val($("#unit_srch2").val());
	$("#unitSrch3").val($("#unit_srch3").val());
	$("#unitSrch4").val($("#unit_srch4").val());
}

//검색조건 초기화
function fn_clearUnitPrice(){
	$("#unit_srch2").val("");
	$("#unit_srch3").val("");
	$("#unit_srch4").val("");
};

function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchUnitPrice();
    }
}


//save 클릭 이벤트
function fn_unitPriceSaveCheck(){
	if(unitHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_unitPriceValidate();
};

//정합성 체크
function fn_unitPriceValidate(){
unitHot.validateCells(function(result) {
		if(result){
			fn_unitPriceSaveData();
		}else{
			unitHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_unitPriceSaveData(){

	if(!confirm(msgSaveConfirm)){return;}
	var saveData = unitHot.getSourceData();
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/seveUnitPriceList.do",
		data : JSON.stringify(saveData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=unitType]:checked").val() == "enrol"){
        			$("input[name=unitType]")[0].checked = true;
        			fn_unitPriceChangeTable($("input[name=unitType]:checked").val());
        		}
        		$("input:radio[name=unitType]:input[value='read']").trigger("click");
        		fn_searchUnitPrice();
        	}
        	fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else { 
	        	console.log(errorThrown);
	        	alert(msgSaveError);
        	}
        }
	});
};

//테이블 컬럼
function fn_unitTableCol(){
	var tableType = $("input:radio[name=unitType]:checked").val();
	var unitPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	var unitItemEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().append('<i class="search-icon text-muted i-Magnifi-Glass1" mouseover="$(this).css(\'curcor\',\'pointer\')" onclick="fn_callPopUnit(\'1\', '+row+', '+col+')"></i>').append(value);
	};
	
	this.unitCol = (tableType == "edit") ? [
		{ data: 'plntCd', type: 'text', className : "htCenter", editor : 'select', selectOptions : plntCdSelect, width: 70, validator: function(value, callback){callback(selectboxCheck(value, plntCdSelect));}, readOnly:true, renderer:unitPkNoneEdit},
        { data: 'itemCd', type: 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly:true, renderer:unitPkNoneEdit },
        { data: 'strtDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
      	{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){
							    		stDt = unitHot.getDataAtCell(this.row, this.col-1);
							    		callback(fn_strtEdtDtCheck(stDt, value));}},
		{data: 'stndrdPrice', type: 'numeric', numericFormat: {pattern: '0,0.00', culture:'en-US' }, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 100, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : (tableType == "read") ? [
		{ data: 'plntCd', type: 'text', className : "htCenter", editor : 'select', selectOptions : plntCdSelect, width: 70, validator: function(value, callback){callback(selectboxCheck(value, plntCdSelect));}},
		{ data: 'itemCd', type: 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data: 'strtDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
		{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){
	    		stDt = unitHot.getDataAtCell(this.row, this.col-1);
	    		callback(fn_strtEdtDtCheck(stDt, value));}},
	    {data: 'stndrdPrice', type: 'numeric', numericFormat: {pattern: '0,0.00', culture:'en-US' } }
	] : [
		{ data: 'plntCd', type: 'text', className : "htCenter", editor : 'select', selectOptions : plntCdSelect, width: 70, validator: function(value, callback){callback(selectboxCheck(value, plntCdSelect));}},
		{ data: 'itemCd', type: 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, renderer: unitItemEdit},
		{ data: 'strtDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
		{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){
    		stDt = unitHot.getDataAtCell(this.row, this.col-1);
    		callback(fn_strtEdtDtCheck(stDt, value));}},
    	{data: 'stndrdPrice', type: 'numeric', numericFormat: {pattern: '0,0.00', culture:'en-US' }, validator : function(value, callback){callback(notEmpty(value, 20))}}
    ];
}

//테이블 헤더
function fn_unitTableHeader(){
	var tableType = $("input:radio[name=unitType]:checked").val();
	
	this.unitHeader = (tableType == "edit") ? [
		colPlntCd+'*',colItemCd+'*',colStrtDt+'*',colendDt,colStndrdPrice+" (VND)*",colDelYn
	] : (tableType == "read") ? [
		colPlntCd+'*',colItemCd+'*',colStrtDt+'*',colendDt,colStndrdPrice+" (VND)*"	
	] : [ 
		colPlntCd+'*',colItemCd+'*',colStrtDt+'*',colendDt,colStndrdPrice+" (VND)*"
	];
}

//테이블 히든컬럼
function fn_unitTableHidden(){
	var tableType = $("input:radio[name=unitType]:checked").val();

	this.unitHidden = [];
}

//handsontable grid
function fn_handsonGridUnitOption(col, header, hidden){
	var tableType = $("input:radio[name=unitType]:checked").val();

	unitHotSettings = {
		columns: col,
		colHeaders: header,
		hiddenColumns : {
		      copyPasteEnabled : false,
		  	  indicators : false,
		  	  columns : hidden
		    },
	    stretchH : 'all',
	    width : '98%',
	    autoWrapRow : true,
	    height : 487,
	    manualRowResize : true,
	    manualColumnResize : true,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    
	    contextMenu : (tableType == "enrol") ?  ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		filters : true,
		readOnly : (tableType == "read") ?  true : false,
		allowRemoveRow : true,
		dropdownMenu : true,
		manualColumnMove : false,
		//columnSorting : {indicator : true},
		autoColumnSize : {samplingRatio : 23},
		mergeCells : false,
		allowInsertRow : true,
		wordWrap : true,
		beforeChange: function (changes, source) {
	      		if(changes != null){
	      			//maxlength
	      			for (i = 0; i < changes.length; i++) {
	      				var row = changes[i][0]; //0 변경셀의 row
	      				var col = changes[i][1]; //1 변경셀의 col
	      				var meta = this.getCellMeta(row, col);
	      				if(col == "strtDt" || col == "endDt"){
	      					var data = changes[i][3].replaceAll("/", "");
	      					changes[i][3] = dateFormChange(fn_dateColForm(data));
	      				} else {
	      					return;
	      				}
	      			}
	      		}
	       	}
	  };

	  return unitHotSettings;
}


//테이블 타입 변경
function fn_unitPriceChangeTable(type){
	let unitCol = new fn_unitTableCol();
	let unitHeader = new fn_unitTableHeader();
	let unitHidden = new fn_unitTableHidden();
	var col, header, hidden;

	col = unitCol.unitCol;
	header = unitHeader.unitHeader;
	hidden = unitHidden.unitHidden;
	unitHot.updateSettings(fn_handsonGridUnitOption(col, header, hidden));

	if(type == "edit"){
		$("#btnUnitPriceSave").show();
		$("#unitpriceExcel").hide();
	}else if(type == "enrol"){
		$("#btnUnitPriceSave").show();
		$("#unitpriceExcel").hide();
	}else{
		$("#btnUnitPriceSave").hide();
		$("#unitpriceExcel").show();
	}

	fn_searchUnitPrice();
}



//품목 테이블팝업 호출
function fn_callPopUnit(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;
	//아이템 조회
	if(target == "itemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	}

	type = target;
	var condition = {
			type :"tableCd",
			search :strSearch,
			from : strFrom,
			where : strWhere,
			orderby : strOrderby,
			if1 : strIf1,
			if2 : strIf2,
			type : type,
			row : row,
			col : col
	};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "itemCd"){
			$("#unit_srch3").val(data.cd);
		}else{
			unitHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
	$("#exampleModalCenterTitleCmmn").text(colItemCd);
};
