var cnvrsnrtHot;
var cnvrnsrtHotSettings;
var cnvrsnrtPageIndex = 9999;
var cnvrsnrtScrollTp = true;
var plntCdSelect = [];
var oceanCdSelect = [];

$( document ).ready(function(){
	//달력 사용시 반드시 넣어주세요.
	$('.band-calendar').each(function(){ regCal(this) ;})
	//캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

      plntCdList = plntCdList.replace('[','').replace(']','');
	  plntCdSelect = plntCdList.split(', ');
	  
	  oceanCdList = oceanCdList.replace('[','').replace(']','');
	  oceanCdSelect = oceanCdList.split(', ');
	  var cnvrnsrtHotElement = document.querySelector('#hanCnvrsnrt');
	  var cnvrnsrtHotElementContainer = cnvrnsrtHotElement.parentNode;

	  cnvrsnrtHot = new Handsontable(cnvrnsrtHotElement, cnvrnsrtHotSettings);

	  $("#btnCnvrsnrtSave").hide();
	  fn_changeTable('read');
//	  fn_searchCnvrsnrt();
	  
	  if(colAuthor == "KORD MGR" || colAuthor == "KORD BPO"){
		 $("#cnvrEdit").show();
	  } else {
		  $("#cnvrEdit").hide();
	  }
	  
	  
	  $("#buyerTable .wtHolder").scroll(function(){
		  var scrollTop = $("#buyerTable .wtHolder").scrollTop();
		  var countPerPage = $("#buyerPageCnt option:selected").val();
		  var rowHeight = buyerHot.getRowHeight();

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

		  if(buyerScrollTp && buyerIndex != 9999 && scrollTop >= (countPerPage * buyerIndex * rowHeight) + addCnt){
			  fn_buyerScroll();
		  }
	});
});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-cnvrsnrt").hasClass("active")) {
//			fn_searchCnvrsnrt();
//		} 
//	}
//})

$(document).mousedown(function(e){	
	if(e.target.name == "cnvrsnrt_date"){
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
$("input[name=cnvrsnrtType]").change(function(){
	    fn_changeTable($(this).val());
});

//정렬항목
$("select[name=aligncnvrsnrt]").change(function(){
	  fn_searchCnvrsnrt();
});

//row 수
$("select[name=cnvrsnrtPageCnt]").change(function(){
	  fn_searchCnvrsnrt();
});


/** 이벤트 End **/

//스크롤
function fn_searchCnvrsnrtScroll(){
	if($("input[name=cnvrsnrtType]:checked").val() == "enrol")
		return;
	
	cnvrsnrtScrollTp = false;
	cnvrsnrtPageIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectcnvrsnrtList.do",
		data : fn_setCnvrsnrtSearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {

        	var getData = cnvrsnrtHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	cnvrsnrtHot.loadData(meargeJson);

        	cnvrsnrtScrollTp = true;
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
function fn_searchCnvrsnrt(){
	cnvrsnrtPageIndex = 0;

	$("#cnvrSrch1").val($("#cnvrsnrt_srch1").val());
	$("#cnvrSrch2").val($("#cnvrsnrt_srch2").val());
	$("#cnvrSrch4").val($("#cnvrsnrt_srch4").val());
	$("#cnvrSrch6").val($("input:radio[name=cnvrsnrt_srch6]:checked").val());
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectCnvrsnrtList.do",
		data : fn_setCnvrsnrtSearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=cnvrsnrtType]:checked").val() == "enrol"){
        		cnvrsnrtHot.loadData([]);
        		cnvrsnrtHot.alter('insert_row', 1, 1);
        	}else{
        		cnvrsnrtHot.loadData([]);
            	cnvrsnrtHot.loadData(data.resultList);
            	$("#cnvrsnrtCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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


//검색조건 생성
function fn_setCnvrsnrtSearchForm(){
	var sData = {};
	sData["srch1"] = $("#cnvrsnrt_srch1").val();
	sData["srch2"] = $("#cnvrsnrt_srch2 option:selected").val();
	sData["srch3"] = $("#cnvrsnrt_srch3").val();
	sData["srch4"] = $("#cnvrsnrt_srch4").val();
	sData["srch6"] = $("input:radio[name=cnvrsnrt_srch6]:checked").val();
	sData["alignItem"] = $("#aligncnvrsnrt option:selected").val();
	sData["recordCountPerPage"] =  $("#cnvrsnrtPageCnt option:selected").val();
	sData["pageIndex"] = cnvrsnrtPageIndex;
	return sData;
};

//검색조건 초기화
function fn_clearCnvrsnrt(){
	$("#cnvrsnrt_srch1").val("");
	$("#cnvrsnrt_srch2").val("");
	$("#cnvrsnrt_srch3").val("");
	$("#cnvrsnrt_srch4").val("");
	$('input:radio[name="cnvrsnrt_srch6"]:radio[value=""]').prop('checked', true);
};

//save 클릭 이벤트
function fn_saveCheck(){
	if(cnvrsnrtHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validate();
};

//정합성 체크
function fn_validate(){

	cnvrsnrtHot.validateCells(function(result) {
		if(result){
			fn_saveData();
		}else{
			cnvrsnrtHot.render();
			alert(msgSaveCheck);

		}
    });
};

//저장
function fn_saveData(){

	if(!confirm(msgSaveConfirm)){return}

	var saveData = cnvrsnrtHot.getSourceData();
	for(var i=0;i < saveData.length; i++){
		if(saveData[i].salesYn.length >= 2){
			if(saveData[i].salesYn == colSale){
				saveData[i].salesYn = 'N'
			} else {
				saveData[i].salesYn = 'Y'
			}
		}
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/saveCnvrsnrtList.do",
		data : JSON.stringify(saveData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$("input:radio[name=cnvrsnrtType]:input[value='read']").trigger("click");
        		fn_searchCnvrsnrt();
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
function fn_cnvrTableCol(){
	var tableType = $("input:radio[name=cnvrsnrtType]:checked").val();

	var perTextRenderer = function (instance, td, row, col, prop, value) {
		  $(td).empty().append(value +"%");
	};
	var cnvrsnrtRenderer = function (instance, td, row, col, prop, value, cellProperties) {
	 	if(!value){
	 		value = "";
	 	}
		var targetTp = (prop == "plntCd") ? 1 : 2;
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopCnvrsnrt('+targetTp+','+row+','+col+')"></i>');
		$(td).empty().append($button).append("  " + value);
	};

	var cnvrPkNoneEdit = function (instance, td, row, col, prop, value, cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};


	var salesYnReturn = function (instance, td, row, col, prop, value, cellProperties) {
			var text = "";
			if(value == "N") {
				text = colSale;
			} else if(value == "Y"){
				text = colBuy;
			}
			(tableType == "edit") ? $(td).empty().append(text).css("text-align", "center").css("background-color", "#E6E6E6") :
									$(td).empty().append(text).css("text-align", "center");
	}
	var salesYnChange = function (instance, td, row, col, prop, value, cellProperties) {
		var text = "";
		if(value === "Y" || value ===  "N"){
			$(td).children().css("text-align", "center")
			return;
		}
		if(value === colSale) {
			fn_chageCellData(row, col, "Y");
			text = colSale;
		} else if(value === colBuy){
			fn_chageCellData(row, col, "N");
			text = colBuy;
		}

		$(td).empty().append(text).css("text-align", "center");
}

	this.cnvrCol = (tableType == "edit") ?  [
		//20201221 박은식 필수값 정합성 체크 수정 START
		{ data: 'plntCd', type : 'text', className : "htCenter", width: 90,renderer:cnvrPkNoneEdit, readOnly: true},
		{ data: 'seq', type : 'text'},
		{ data: 'salesYn', editor: 'select' , selectOptions : [colSale, colBuy], className : "htCenter", width: 130,
									validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly: true, renderer:salesYnReturn},
		{ data: 'strtDt', type: 'date',  className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly: true},
		//20201221 박은식 필수값 정합성 체크 수정 END
		{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator: dateChcek},
		{ data: 'oceanCd', editor : 'select', selectOptions : oceanCdSelect, type : 'autocomplete', className : "htCenter",validator : function(value, callback){callback(notEmpty(value, 60))}},//대륙코드
		/*{ data: 'partnCd', type: 'text', className: 'htCenter'},// 업체코드
*/		{ data: 'deliveryToPort', type : 'numeric'}, //로컬운송료 및 선적비용
		{ data: 'carriageChgs', type : 'numeric'}, //해상운임비용
		{ data: 'insurance', type : 'numeric'}, //보험료
		{ data: 'importTaxes', type : 'numeric'},// 수입국세금
		/*{ data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 90}*/
		
		
	] : (tableType == "read") ? [
		//20201221 박은식 필수값 정합성 체크 수정 START
		{ data: 'plntCd' , editor : 'select', selectOptions : plntCdSelect, type : 'autocomplete', className : "htCenter", width: 90,
									validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{ data: 'seq', type : 'text'},
		{ data: 'salesYn', editor: 'select', selectOptions : [colSale, colBuy], className : "htCenter", width: 130,
																validator : function(value, callback){callback(notEmpty(value, 20))}, renderer: salesYnReturn},
		{ data: 'strtDt', type: 'date',  className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){callback(notEmpty(value, 20))}},
		//20201221 박은식 필수값 정합성 체크 수정 END
		{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator: dateChcek},
		{ data: 'oceanCd', editor : 'select', selectOptions : oceanCdSelect, type : 'autocomplete', className : "htCenter"},//대륙코드
	/*	{ data: 'partnCd', type: 'text', className: 'htCenter'},// 업체코드
*/		{ data: 'deliveryToPort', type : 'numeric'}, //로컬운송료 및 선적비용
		{ data: 'carriageChgs', type : 'numeric'}, //해상운임비용
		{ data: 'insurance', type : 'numeric'}, //보험료
		{ data: 'importTaxes', type : 'numeric'},// 수입국세금
		
	] : [
		//20201221 박은식 필수값 정합성 체크 수정 START
		{ data: 'plntCd' , editor : 'select', selectOptions : plntCdSelect, type : 'autocomplete', className : "htCenter", width: 90,
									validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{ data: 'seq', type : 'text'},
		{ data: 'salesYn' , editor : 'select', selectOptions : [colSale, colBuy], type : 'autocomplete', className : "htCenter", width: 130,
																validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{ data: 'strtDt', type: 'date',  className : "htCenter", dateFormat: gridCalFormat, validator : function(value, callback){callback(notEmpty(value, 20))}},
		//20201221 박은식 필수값 정합성 체크 수정 END
		{ data: 'endDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator: dateChcek},
		{ data: 'oceanCd', editor : 'select', selectOptions : oceanCdSelect, type : 'autocomplete', className : "htCenter",validator : function(value, callback){callback(notEmpty(value, 60))}},//대륙코드
		/*{ data: 'partnCd', type: 'text', className: 'htCenter'},// 업체코드
*/		{ data: 'deliveryToPort', type : 'numeric'}, //로컬운송료 및 선적비용
		{ data: 'carriageChgs', type : 'numeric'}, //해상운임비용
		{ data: 'insurance', type : 'numeric'}, //보험료
		{ data: 'importTaxes', type : 'numeric'},// 수입국세금
		
	];
}
//sale 판매  buy 구매
//테이블 헤더
function fn_cnvrTableHeader(){
	var tableType = $("input:radio[name=cnvrsnrtType]:checked").val();
	
	this.cnvrHeader = [
		colPlntCd+"*","seq",colSalesYn+"*",colStrtDt+"*",colEndDt,colOceanCd+"*",colDeliveryToPort+" %",colCarriageChgs+" %",
		colInsurace+" %", colImportTaxes+" %"/*, colDelYn*/
	];
}

//테이블 히든컬럼
function fn_cnvrtableHidden(){
	var tableType = $("input:radio[name=cnvrsnrtType]:checked").val();
	this.cnvrHidden = [1];
}

//table
function fn_handsonGridCnvrOprion(col, header, hidden){
	var tableType = $("input:radio[name=cnvrsnrtType]:checked").val();

	 cnvrnsrtHotSettings = {
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
		//rowHeights : 25, -> 틀어지는 현상 발생 시 삭제
		rowHeaders : true,
		columnHeaderHeight : 25,
		manualRowMove : true,
		manualColumnMove : false,
		//dropdownMenu : true,
		
		contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		//dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		filters : true,
		readOnly : (tableType == "read" || tableType == undefined) ? true : false,
		allowRemoveRow : true,
		mergeCells : false,
		//columnSorting : {indicator : true},
		autoColumnSize : {samplingRatio : 23},
		mergeCells : false,
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
	return cnvrnsrtHotSettings;
}

//테이블 타입 변경
function fn_changeTable(type){
	console.log(2)
	let cnvrCol = new fn_cnvrTableCol();
	let cnvrHeader = new fn_cnvrTableHeader();
	let cnvrHidden = new fn_cnvrtableHidden();
	var col, header, hidden;

	col = cnvrCol.cnvrCol;
	header = cnvrHeader.cnvrHeader;
	hidden = cnvrHidden.cnvrHidden;
	cnvrsnrtHot.updateSettings(fn_handsonGridCnvrOprion(col, header, hidden));

	if(type == "edit"){
		$("#btnCnvrsnrtSave").show();
		$("#cnvrsnrtExcel").hide();
	}else if(type == "enrol"){
		$("#btnCnvrsnrtSave").show();
		$("#cnvrsnrtExcel").hide();
	}else{
		$("#btnCnvrsnrtSave").hide();
		$("#cnvrsnrtExcel").show();
	}
	fn_searchCnvrsnrt();
}

//팝업
function fn_callCnvrsnrtTablePop(){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

		strSearch = (colLang == "en") ? "UP_CMMN_CD AS CD, CMMN_NM_EN AS CD_NM" : "UP_CMMN_CD AS CD, CMMN_NM_VN AS CD_NM";
		strFrom = "CMMN_CD";
		strWhere = "DEL_YN = 'N' AND GRP_CD = 'NATION'";
		strOrderby = "UP_CMMN_CD";
		strIf1 = "UP_CMMN_CD";
		strIf2 = (colLang == "en") ? "CMMN_NM_EN": "CMMN_NM_VN";

	var condition = {type :"tableCd",
			search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
	  	     type : type};

	fn_showCmmnPopup(condition, function(data){
		$("#cnvrsnrt_srch2").val(data.cd);
	});
	$("#exampleModalCenterTitleCmmn").text(colNatCd);
};

//테이블팝업 호출
function fn_callPopCnvrsnrt(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

		if(cnvrsnrtHot.getDataAtCell(row, 3) == 'Y'){// getDataAtCell Method를 이용하여 클릭한 행의 판매구매 상태값을 불러옴.
			strSearch = (colLang == "en") ? "BUYR_ID AS CD, BUYR_NM_EN AS CD_NM" : "BUYR_ID AS CD, BUYR_NM AS CD_NM";
			strFrom = "PARTN_BUYR_INFO";
			strWhere = "DEL_YN = 'N'";
			strOrderby = "BUYR_ID";
			strIf1 = "BUYR_ID";
			strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";

		}else{
			strSearch = (colLang == "en") ? "VNDR_ID AS CD, VNDR_NM_EN AS CD_NM" : "VNDR_ID AS CD, VNDR_NM AS CD_NM";
			strFrom = "PARTN_VNDR_INFO";
			strWhere = "DEL_YN = 'N'";
			strOrderby = "VNDR_ID";
			strIf1 = "VNDR_ID";
			strIf2 = (colLang == "en") ? "VNDR_NM_EN" : "VNDR_NM";
		}

	type = target;

	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		cnvrsnrtHot.setDataAtCell(data.row, data.col, data.cd);
	});

};

//cell data change
function fn_chageCellData(row, col, data){
	cnvrsnrtHot.setDataAtCell(row, col, data);
}
