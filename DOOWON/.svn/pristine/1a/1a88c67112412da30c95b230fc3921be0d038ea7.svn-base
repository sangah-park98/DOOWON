var ccpyacntHot;
var ccpyacntSettings;
var ccpyacntIndex = 9999;
var ccpyacntScrollTp = true;

$( document ).ready(function() {
	  var ccpyacntElement = document.querySelector('#ccpyacntTable');
	  var ccpyacntElementContainer = ccpyacntElement.parentNode;

	  ccpyacntHot = new Handsontable(ccpyacntElement, ccpyacntSettings);

	  $("#btnCcpyacntSave").hide();
	  fn_changeCcpyacnt('read')
	  fn_searchCcpyacnt();

	  fn_scroll(); //스크롤 함수
});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-ccpyacnt").hasClass("active")) {
//			fn_searchCcpyacnt();
//		} 
//	}
//})


//테이블 타입 변경
$("input[name=ccpyacntType]").change(function(){
	  fn_changeCcpyacnt($(this).val());
});

//정렬항목
$("select[name=alignCcpyacnt]").change(function(){
	  fn_searchCcpyacnt();
});

//row 수
$("select[name=ccpyacntPageCnt]").change(function(){
	  fn_searchCcpyacnt();
});

function fn_scroll(){
	$("#ccpyacntTable .wtHolder").scroll(function(){
		  var scrollTop = $("#ccpyacntTable .wtHolder").scrollTop();
		  var countPerPage = $("#ccpyacntPageCnt option:selected").val();
		  var rowHeight = ccpyacntHot.getRowHeight();

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

		  if(ccpyacntScrollTp && ccpyacntIndex != 9999 && scrollTop >= (countPerPage * ccpyacntIndex * rowHeight) + addCnt){
			  fn_ccpyacntScroll();
		  }
	});
}


/** 이벤트 End **/

//스크롤
function fn_ccpyacntScroll(){
	if($("input[name=ccpyacntType]:checked").val() == "enrol")
		return;
	ccpyacntScrollTp = false;
	ccpyacntIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectCcpyacntList.do",
		data : fn_setCcpyacntForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = ccpyacntHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	ccpyacntHot.loadData(meargeJson);

        	ccpyacntScrollTp = true;
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

function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchCcpyacnt();
    }
}


//검색
function fn_searchCcpyacnt(){
	ccpyacntIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectCcpyacntList.do",
		data : fn_setCcpyacntForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=ccpyacntType]:checked").val() == "enrol"){
        		ccpyacntHot.loadData([]);
        		ccpyacntHot.alter('insert_row', 1, 1);
        	}else{
        		ccpyacntHot.loadData([]);
            	ccpyacntHot.loadData(data.resultList);
            	$("#ccpyacntCnt").text(data.totCnt).number(true); //검색결과 총 갯수
        	}
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
function fn_setCcpyacntForm(){
	var sData = {};
	sData["srch1"] = $("#ccpyacnt_srch1").val();
	sData["srch2"] = $("#ccpyacnt_srch2").val();
	sData["srch3"] = $("#ccpyacnt_srch3").val();
	sData["srch4"] = $("input:radio[name=ccpyacnt_srch4]:checked").val();
	sData["alignItem"] = $("#alignCcpyacnt option:selected").val();
	sData["recordCountPerPage"] = $("#ccpyacntPageCnt option:selected").val();
	sData["pageIndex"] = ccpyacntIndex;
	return sData;
};

//검색조건 초기화
function fn_clearCcpyacnt(){
	$("#ccpyacnt_srch1").val("");
	$("#ccpyacnt_srch2").val("");
	$("#ccpyacnt_srch3").val("");
	$("input:radio[name=ccpyacnt_srch4]")[0].checked = true;
};

//저장버튼 클릭
function fn_saveCcpyacntCheck(){
	if(ccpyacntHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validateCcpyacnt();
};

//정합성 체크
function fn_validateCcpyacnt(){
	ccpyacntHot.validateCells(function(result) {
		if(result){
			fn_saveCcpyacntData();
		}else{
			ccpyacntHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveCcpyacntData(){

	if(!confirm(msgSaveConfirm)){ return }

	var saveCcpyacntData = ccpyacntHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/cmmn/saveCcpyacntInfo.do",
		data : JSON.stringify(saveCcpyacntData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$('input[name="ccpyacntType"]:radio[value="read"]').prop('checked',true);
        		fn_changeCcpyacnt($('input[name="ccpyacntType"]').val());
        		fn_searchCcpyacnt();
        	}
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
function fn_ccpTableCol(){
	var tableType = $("input:radio[name=ccpyacntType]:checked").val();
	var ccpPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").append(value);
	};
	
	var manualYnChange = function (instance, td, row, col, prop, value, cellProperties) {
		(value == "Y") ? value = colAutoApp : value = colManualApp;
		$(td).empty().append(value).css("text-align", "center");
	}

	var manualYnReturn = function(instance, td, row, col, prop, value, cellProperties) {
		var inputData = '';
		if(value == colAutoApp){
			ccpyacntHot.setDataAtCell(row, col, value);
			inputData = colAutoApp;
		}else if(value == colManualApp){
			ccpyacntHot.setDataAtCell(row, col, value);
			inputData = colManualApp;
		}
		$(td).empty().append(inputData).css("text-align", "center");
	}
	
	(tableType == "read") ?
		this.ccpCol = [
			
			{data : 'corpNm', type : 'text'},
			(tableType == "edit") ? {data : 'usrId', type : 'text', width: 150, renderer:ccpPkNoneEdit, readOnly : true,
				  							validator : /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i} :
				  					{data : 'usrId', type : 'text', width: 150,
				  							validator : /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i},
			{data : 'corpNo', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
			{data : 'usrNm', type : 'text'},
			{data : 'usrPw', type : 'password', width: 150, validator : function(value, callback){callback(notEmpty(value, 100))}},
			{data : 'usrTelNo', type : 'text', className : "htCenter", width: 100},
			{data : 'usrEmail', type : 'text'}
			/*,(tableType == "enrol") ? {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoApp, colManualApp], type : 'autocomplete', className : "htCenter", width: 120} :
			(tableType == "edit")  ? {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoApp, colManualApp], type : 'autocomplete', className : "htCenter", width: 120} :
									 {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoApp, colManualApp], type : 'autocomplete', className : "htCenter", width: 120}*/
		]
		:
		this.ccpCol = [
			
			{data : 'corpNm', type : 'text'},
			(tableType == "edit") ? {data : 'usrId', type : 'text', width: 150, renderer:ccpPkNoneEdit, readOnly : true,
				  							validator : /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i} :
				  					{data : 'usrId', type : 'text', width: 150,
				  							validator : /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i},
			{data : 'corpNo', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
			{data : 'usrNm', type : 'text'},
			{data : 'usrPw', type : 'password', width: 150, validator : function(value, callback){callback(notEmpty(value, 100))}},
			{data : 'usrTelNo', type : 'text', className : "htCenter", width: 100},
			{data : 'usrEmail', type : 'text'},
			/*(tableType == "enrol") ? {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoAppUse, colManualAppYn], type : 'autocomplete', className : "htCenter", width: 120} :
			(tableType == "edit")  ? {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoAppUse, colManualAppYn], type : 'autocomplete', className : "htCenter", width: 120} :
									 {data : 'originAutoYn', editor : 'select', selectOptions : [colAutoAppUse, colManualAppYn], type : 'autocomplete', className : "htCenter", width: 120},*/
			{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], className : "htCenter"}
		];
}

//테이블 헤더
function fn_ccpTableHeader(){
	this.ccpHeader = [
		colCorpNm,colVendorId,colTaxNb+"*",colUserNm,colPassword+"*",colTelNo,colEmail
		/*,colOriginYn*/
		,colDelYn
	];
}

//테이블 히든컬럼
function fn_ccpTableHidden(){
	this.ccpHidden = [];
}

//Table
function fn_handsonGridCcpOption(col, header, hidden){
	var tableType = $("input:radio[name=ccpyacntType]:checked").val();

	ccpyacntSettings = {
		  columns : col,
		  colHeaders : header,
		  hiddenColumns : {
				copyPasteEnabled : false,
				indicators : false,
				columns : hidden
		  },
		  stretchH : 'all',
		  width : '98.7%',
		  height : 487,
		  columnHeaderHeight : 25,
		  rowHeights : 25,
		  rowHeaders : true,
		  manualRowResize : true,
		  manualColumnResize : true,
		  autoWrapRow : true,
		  manualRowMove : true,
		  manualColumnMove : false,
		  filters : true,
		  mergeCells : false,
		  allowRemoveRow : true,
		  readOnly : (tableType == "read") ? true : false,
		  
		  readOnly : (tableType == "read") ? true : false,
		  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo'] : false,
			//	  dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		  //columnSorting : {indicator : true},
	      autoColumnSize : {samplingRatio : 23},
	  };
	return ccpyacntSettings;
}

//테이블 타입 변경
function fn_changeCcpyacnt(type){
	console.log(0)
	let ccpCol = new fn_ccpTableCol();
	let ccpHeader = new fn_ccpTableHeader();
	let ccpHidden = new fn_ccpTableHidden();
	var col, header, hidden;
	col = ccpCol.ccpCol;
	header = ccpHeader.ccpHeader;
	hidden = ccpHidden.ccpHidden;
	ccpyacntHot.updateSettings(fn_handsonGridCcpOption(col, header, hidden));

	if(type == "edit"){
		$("#btnCcpyacntSave").show();
		$("#ccpyExcel").hide();
	}else if(type == "enrol"){
		$("#btnCcpyacntSave").show();
		$("#ccpyExcel").hide();
	}else{
		$("#btnCcpyacntSave").hide();
		$("#ccpyExcel").show();
	}
	fn_searchCcpyacnt();
};

