var ftaTreatyHot;
var ftaTreaty_hotSettings;
var ftaTreatyPageIndex = 9999;
var ftaTreatyScrollTp = true;
var ftaTreatyNatDropdown = [];
var ftaCdDropdown = [];
var rowDropdown;
var	ftaNatDropdown = [];
var hsVerDropDown = [];
rowDropdown = ftaNatDropdown;
$(document).ready(function() {

	tableList = tableList.replace('[', '').replace(']', '');
	ftaCdDropdown = tableList.split(', ');
	//hsver 셋팅
	var nowYear = (new Date()).getFullYear();
	var hsVertmp = [];
	for(var i=2002; i <= nowYear; i+=5 ){
		hsVertmp.push(String(i));
	}
	hsVerDropDown = hsVertmp.sort(function(a,b){
		return b-a;
	})
	console.log(hsVerDropDown);
	//hsver 셋팅
//	ftaNatList = ftaNatList.replace('[', '').replace(']', '');
//	ftaNatDropdown = ftaNatList.split(', ');

	var ftaTreatyElement = document.querySelector('#hanTreaty');
	var ftaTreatyElementContainer = ftaTreatyElement.parentNode;

	ftaTreatyHot = new Handsontable(ftaTreatyElement,ftaTreaty_hotSettings);

	//FTA협정 검색구분에 따라 검색 요소 변경
	$("#ftaTreaty1").show();
	$("#ftaTreaty2").show();
	$("#ftaNatInfo1").hide();
	$("#ftaDocuInfo1").hide();
	$("#ftaNatInfo2").hide();
	$("#ftaDocuInfo2").hide();
	$("#aliNat1").hide();
	$("#aliNat2").hide();
	$("#aliDoc1").hide();
	$("#aliDoc2").hide();
	$("#ftaTableType").hide();
	$("#btnftaTreatySave").hide(colFtaInfo);

	fn_changeFtaTreatyTable('read');

	$("#hanTreaty .wtHolder").scroll(function() {
				var scrollTop = $("#hanTreaty .wtHolder").scrollTop();
				var countPerPage = $("#treatyPageCnt option:selected")
						.val();
				var rowHeight = ftaTreatyHot.getRowHeight();

				var addftaTreatyCnt = 790;
				if (countPerPage == "50") {
					addftaTreatyCnt = 790;
				} else if (countPerPage == "100") {
					addftaTreatyCnt = 2040;
				} else if (countPerPage == "200") {
					addftaTreatyCnt = 3290;
				} else if (countPerPage == "500") {
					addftaTreatyCnt = 4540;
				}

				if (ftaTreatyScrollTp && ftaTreatyPageIndex != 9999 && scrollTop >= (countPerPage* ftaTreatyPageIndex * rowHeight) + addftaTreatyCnt) {
					fn_searchftaTreatyScroll();
				}
		});

});
/** 이벤트 Start **/
//테이블 타입 변경
$("input[name=ftaTreatyType]").change(function() {
	fn_changeFtaTreatyTable($(this).val());
});

//정렬항목
$("select[name=alignTreaty]").change(function() {
	fn_searchftaTreaty();
});

//row 수
$("select[name=treatyPageCnt]").change(function() {
	fn_searchftaTreaty();
});

//테이블 출력 controller
$("input[name=ftaTreaty_srch4]").change(function() {
	$('input:radio[name=ftaTreatyType]:radio[value="read"]').prop('checked',true);
	fn_clearTreaty();
	fn_changeFtaTreatyTable($("input:radio[name=ftaTreatyType]:checked").val());
});

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-ftatreaty").hasClass("active")) {
//			fn_searchftaTreaty();
//		}
//	}
//})

/** 이벤트 End **/

// 스크롤
function fn_searchftaTreatyScroll() {
	
	if($("input:radio[name=ftaTreatyType]:checked").val() == "enrol")
		return;
	
	ftaTreatyScrollTp = false;
	ftaTreatyPageIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/cmmn/selectftaTreatyList.do",
		data : fn_setFtaTreatySearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			/*
			 * for(var i=0; i<data.resultList.length; i++){
			 * ftaTreatyHot.getSourceData().push(data.resultList[i]); }
			 */
			var getData = ftaTreatyHot.getSourceData();
			var meargeJson = getData.concat(data.resultList);
			ftaTreatyHot.loadData(meargeJson);

			ftaTreatyScrollTp = true;
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

// 검색
function fn_searchftaTreaty() {
	fn_loading(true);
	ftaTreatyPageIndex = 0;
	$.ajax({
		type : "POST",
		url : "/cmmn/selectftaTreatyList.do",
		data : fn_setFtaTreatySearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			if($("input:radio[name=ftaTreatyType]:checked").val() == "enrol"){
				ftaTreatyHot.loadData([]);
				ftaTreatyHot.alter('insert_row', 1, 1);
			}else{
				ftaTreatyHot.loadData([]);
				ftaTreatyHot.loadData(data.resultList);
				$("#atreatyCnt").text(data.totCnt).number(true); // 검색결과 총 갯수
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

function fn_searchftaDorpDown(){
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/cmmn/selectFtaTreatyDropdown.do",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			ftatreatyNatDropdown = [];
			for (var i = 0; i < data.resultList.length; i++) {
				ftaTreatyNatDropdown.push(data.resultList[i].ftaCd);
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
}


// 검색조건 생성
function fn_setFtaTreatySearchForm() {
	var sData = {};
	//fta정보
	sData["srch2"] = $("#ftaTreaty_srch2").val();
	//국가정보
	sData["srch12"] = $("#ftaTreaty_srch12").val();
	sData["srch22"] = $("#ftaTreaty_srch22").val();
	//문서정보
	sData["srch13"] = $("#ftaTreaty_srch13").val();
	sData["srch23"] = $("#ftaTreaty_srch23").val();
	//공통
	sData["srch1"] = $("#ftaTreaty_srch1").val();
	sData["srch10"] = $("input:radio[name=ftaTreaty_srch4]:checked").val();
	sData["alignItem"] = $("#alignTreaty option:selected").val();
	sData["recordCountPerPage"] = $("#treatyPageCnt option:selected").val();
	sData["pageIndex"] = ftaTreatyPageIndex;
	return sData;
};

// 검색조건 초기화
function fn_clearTreaty() {
	$("#ftaTreaty_srch1").val("");
	$("#ftaTreaty_srch2").val("");
	$("#ftaTreaty_srch12").val("");
	$("#ftaTreaty_srch22").val("");
	$("#ftaTreaty_srch13").val("");
	$("#ftaTreaty_srch23").val("");
};

// 저장버튼 클릭
function fn_saveFtaTreatyCheck() {
	if (ftaTreatyHot.getData().length < 1) {
		alert(msgSaveEmpty);
		return;
	}

	fn_validateFtaTreaty();
};

// 정합성 체크
function fn_validateFtaTreaty() {
	ftaTreatyHot.validateCells(function(result) {
		if (result) {
			fn_saveFtaTreatyData();
		} else {
			ftaTreatyHot.render();
			alert(msgSaveCheck);
		}
	});
};

// 저장
function fn_saveFtaTreatyData() {
	if (!confirm(msgSaveConfirm)) {
		return;
	}
	fn_loading(true);
	var saveFtaData = ftaTreatyHot.getSourceData();
	var cdTp = $("input:radio[name=ftaTreaty_srch4]:checked").val();
	for (var i = 0; i < saveFtaData.length; i++) {
		saveFtaData[i]["cdTp"] = cdTp;
	}

	$.ajax({
		type : "POST",
		url : "/cmmn/saveFtaTreatyList.do",
		data : JSON.stringify(saveFtaData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				alert(msgSaveSuccess);
				fn_searchftaTreaty();
				if($("input[name=ftaTreatyType]:checked").val() == "enrol"){
					$("input:radio[name=ftaTreatyType]")[0].checked = true;
					fn_changeFtaTreatyTable($("input[name=ftaTreatyType]:checked").val());
				}
				$("input:radio[name=ftaTreatyType]:input[value='read']").trigger("click");
				fn_searchftaTreaty();
				
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
function fn_ftaTableCol(){
	var tableType = $("input:radio[name=ftaTreatyType]:checked").val();

	var ftaPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	var ftaTreatyNatCdRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var $button = $('<i class="search-icon text-muted i-Magnifiw-Glass1" style="cursor:pointer;" onclick="fn_callPopFtaTreaty(1,'+row+','+col+')"></i>');
		$(td).empty().append($button).append("  " + value).css("text-align", "center");
	};
	
	this.ftaCol = (tableType == "read") ? [
		{ data : 'ftaCd', type : 'text', validator : function(value, callback){callback(notEmpty(value, 20))}, className:"htCenter"},
		{ data : 'ftaNm', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'hsVer', editor : 'select', className : "htCenter", selectOptions : hsVerDropDown, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{ data : 'rsnCntn', type : 'text' },
		{ data : 'rsnCntnEn', type : 'text'}
	] : (tableType == "edit") ? [
		{ data : 'ftaCd', type : 'text', className:"htCenter", renderer : ftaPkNoneEdit, readOnly:true},
		{ data : 'ftaNm', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'hsVer', editor : 'select', className : "htCenter", selectOptions : hsVerDropDown, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{ data : 'rsnCntn', type : 'text' , validator : function(value, callback){callback(notEmpty(value, 500))}},
		{ data : 'rsnCntnEn', type : 'text' , validator : function(value, callback){callback(notEmpty(value, 500))}},
		{ data : 'ordr', type : 'numeric'},
		{ data : 'delYn', editor : 'select', className : "htCenter", selectOptions : [ 'Y', 'N' ]}
	] : [
		{ data : 'ftaCd', type : 'text', validator : function(value, callback){callback(notEmpty(value, 20))}, className:"htCenter"},
		{ data : 'ftaNm', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'ftaNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{ data : 'hsVer', editor : 'select', className : "htCenter", selectOptions : hsVerDropDown, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{ data : 'rsnCntn', type : 'text' , validator : function(value, callback){callback(notEmpty(value, 500))}},
		{ data : 'rsnCntnEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{ data : 'ordr', type : 'numeric'},
	];

	this.ftaNatCol =  (tableType == "read") ? [
		{ data : 'ftaCd', type : 'autocomplete', source : ftaCdDropdown, className:"htCenter",validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data : 'ftaNm', type : 'text'}, //동록 데이터가 아니어서 정합성 삭제
		{ data : 'natCd', type : 'autocomplete', source : ftaNatDropdown, className:"htCenter",validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data : 'natNm', type : 'text'}
	] :  (tableType == "edit") ? [
		{ data : 'ftaCd', type : 'autocomplete', source : ftaCdDropdown, className:"htCenter", readOnly:true, renderer:ftaPkNoneEdit },
		{ data : 'ftaNm', type : 'text', readOnly : true, renderer:ftaPkNoneEdit },
		{ data : 'natCd', type : 'autocomplete', source : ftaNatDropdown, className:"htCenter",validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data : 'natNm', type : 'text', readOnly : true, renderer:ftaPkNoneEdit },//동록 데이터가 아니어서 정합성 삭제
		{ data : 'delYn', editor : 'select', className : "htCenter", selectOptions : [ 'Y', 'N' ], validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : [
		{ data : 'ftaCd', type : 'autocomplete', source : ftaCdDropdown, className:"htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data : 'natCd', type : 'autocomplete', source : ftaNatDropdown, className:"htCenter",validator : function(value, callback){callback(notEmpty(value, 20))}},
	];

	//히든컬럼 issue문제로 header columns을 나누어 설정.
	this.ftaDocuCol = (tableType == "edit") ? [
		{ data : 'ftaCd', type : 'autocomplete', source : ftaCdDropdown, className:"htCenter", width : 50, className:"htCenter", renderer: ftaPkNoneEdit, readOnly:true },
		{ data : 'psrKnd', type : 'text',  className:"htCenter", renderer: ftaPkNoneEdit, readOnly:true, width: 35},
		{ data : 'seq', type : 'numeric', className : "htCenter",  width : 35, renderer: ftaPkNoneEdit, readOnly:true},
		{ data : 'docuCd', type : 'text', className : "htCenter", width : 45},
		{ data : 'printSheetNo', type : 'numeric', className : "htCenter",width:45},
		{ data : 'docuFileNm', type : 'text', width:100},
		{ data : 'delYn', editor : 'select', className : "htCenter", selectOptions : [ 'Y', 'N' ],
			validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}, width : 50}
	] :
	[
		{ data : 'ftaCd', type : 'autocomplete', source : ftaCdDropdown, className:"htCenter", width : 50, className:"htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{ data : 'psrKnd', type : 'text', width: 35,  className:"htCenter", validator : function(value, callback){callback(notEmpty(value, 10))}},
		{ data : 'seq', type : 'numeric', className : "htCenter",  width : 35, validator : function(value, callback){callback(notEmpty(value, 3))}},
		{ data : 'docuCd', type : 'text', className : "htCenter", width : 45},
		{ data : 'printSheetNo', type : 'numeric', className : "htCenter",width:45},
		{ data : 'docuFileNm', type : 'text', width:100},
	];
}

//테이블 헤더
function fn_ftaTableHeader(){
	var tableType = $("input:radio[name=ftaTreatyType]:checked").val();
	
	this.ftaHeader = (tableType == "read") ? [
		colFtaCd + "*", colFtaNm + "*", colFtaNm + "(EN)" + "*", colFtaNm + "(KR)" + "*",
		colHsVer + "*", colRsnCntn + "*", colRsnCntn + "(EN)" + "*"
	] : (tableType == "edit") ? [
		colFtaCd + "*", colFtaNm + "*", colFtaNm + "(EN)" + "*", colFtaNm + "(KR)" + "*",
		colHsVer + "*", colRsnCntn + "*", colRsnCntn + "(EN)" + "*", colOrderSn, colDelYn
	] : [
		colFtaCd + "*", colFtaNm + "*", colFtaNm + "(EN)" + "*", colFtaNm + "(KR)" + "*",
		colHsVer + "*", colRsnCntn + "*", colRsnCntn + "(EN)" + "*", colOrderSn
	];

	this.ftaNatHeader = (tableType == "read") ? [
		colFtaCd+"*",colFtaNm, colNatCd+"*", colNatNm
	] : (tableType == "edit") ? [
		colFtaCd+"*",colFtaNm, colNatCd+"*", colNatNm, colDelYn
	] : [
		colFtaCd+"*", colNatCd+"*"
	];

	//히든컬럼 issue문제로 header columns을 나누어 설정.
	this.ftaDocuHeader = (tableType == "edit") ? [
		colFtaCd+"*", colPsrKnd+"*", colSeq+"*",colDocuCd, colPrintSheetNo, colDocuFileNm,colDelYn
	] :
	[
		colFtaCd+"*", colPsrKnd+"*", colSeq+"*",colDocuCd, colPrintSheetNo, colDocuFileNm
	];

}

//테이블 히든컬럼
function fn_ftaTableHidden(){
	var tableType = $("input:radio[name=ftaTreatyType]:checked").val();

	this.ftaHidden = [];

	this.ftaNatHidden = [];
	
	this.ftaDocuHidden = [];
}

//협정
function fn_handsonGridFtaOption(col, header, hidden){
	var tableType = $("input:radio[name=ftaTreatyType]:checked").val();

	var ftaPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	ftaTreaty_hotSettings = {
		columns : col,
		colHeaders : header,
		hiddenColumns : {
			copyPasteEnabled : false,
			indicators : false,
			columns :hidden
		},
		stretchH : 'all',
		width : '98%',
		autoWrapRow : true,
		height : 487,
		manualRowResize : true,
		manualColumnResize : true,
		rowHeights : 25,
		rowHeaders : true,
		readOnly : true,
		columnHeaderHeight : 25,
		manualRowMove : true,
		manualColumnMove : false,
		//dropdownMenu : true,
		contextMenu: (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		filters : true,
		readOnly : (tableType == 'read') ? true : false,
		allowRemoveRow : false,
		//columnSorting : {indicator : true},
		
		autoColumnSize : {samplingRatio : 23},
		mergeCells : true,
		beforeChange: function (changes, source) {
				if(changes != null){
					//maxlength
					for (i = 0; i < changes.length; i++) {
						var row = changes[i][0]; //0 변경셀의 row
						var col = changes[i][1]; //1 변경셀의 col
						var meta = this.getCellMeta(row, col);
						if(col == "ftaCd"){
							var data = fn_numericFormat(changes[i][3].replaceAll(",", "")); //3 변경 데이터
							var fData = {};
							fData["srch1"] = data;
							//FTA 국가정보 조회하여 해당 데이터를 리스트로 만듦 START
							$.ajax({
								type : "POST",
								url : "/cmmn/selectFtaNationDropdown.do",
								data : fData,
								beforeSend : function(xmlHttpRequest){
									xmlHttpRequest.setRequestHeader("AJAX", "true");
								},
								dataType : "json",
								success : function(data) {
									rowDropdown.length = 0;
									for(var i=0; i < data.resultList.length; i++){
										rowDropdown.push(data.resultList[i].cd+"("+data.resultList[i].nm+")") 
									}
									ftaTreatyHot.render;
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
							//FTA 국가정보 조회하여 해당 데이터를 리스트로 만듦 END
						} else {
							return;
						}
					}
				}
		      },
		  afterOnCellMouseDown : function(changes, source){
				var fData = {};
				fData["srch1"] = ftaTreatyHot.getDataAtCell(source.row, 0);
				//FTA 국가정보 조회하여 해당 데이터를 리스트로 만듦 START
				$.ajax({
					type : "POST",
					url : "/cmmn/selectFtaNationDropdown.do",
					data : fData,
					beforeSend : function(xmlHttpRequest){
						xmlHttpRequest.setRequestHeader("AJAX", "true");
					},
					dataType : "json",
					success : function(data) {
						rowDropdown.length = 0;
						for(var i=0; i < data.resultList.length; i++){
							rowDropdown.push(data.resultList[i].cd+"("+data.resultList[i].nm+")") 
						}
						ftaTreatyHot.render;
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
				//FTA 국가정보 조회하여 해당 데이터를 리스트로 만듦 END
			}
		    //numeric은 엑셀 copy & paste 에러가 있어 직접 처리해줘야함 해당 처리 로직 END
		};
	return ftaTreaty_hotSettings;
}

// 테이블 타입 변경
function fn_changeFtaTreatyTable(type) {
	var hiddenPlugin = ftaTreatyHot.getPlugin('hiddenColumns');
	if (type == "edit") {
		$("#btnftaTreatySave").show();
	}else if(type == "enrol"){
		$("#btnftaTreatySave").show();
	} else {
		$("#btnftaTreatySave").hide();
	}

	var tableType = $("input:radio[name=ftaTreaty_srch4]:checked").val();
	fn_changeFtaTreatyType(tableType);
}

function fn_searchFtaOption(type){
	if(type){
		$("#ftaTreaty1").show();
		$("#ftaTreaty2").show();
		$("#aliFta1").hide();
		$("#ftaTableType").hide();
	}else{
		$("#ftaTreaty1").hide();
		$("#ftaTreaty2").hide();
	}
}
function fn_searchNatOption(type){
	if(type){
		$("#ftaNatInfo1").show();
		$("#ftaNatInfo2").show();
		$("#aliNat1").show();
		$("#aliNat2").show();
		$("#aliFta1").hide();
		$("#ftaTableType").show();
	}else{
		$("#aliNat1").hide();
		$("#aliNat2").hide();
		$("#ftaNatInfo1").hide();
		$("#ftaNatInfo2").hide();

	}
}
function fn_searchDocuOption(type){
	if(type){
		$("#ftaDocuInfo1").show();
		$("#ftaDocuInfo2").show();
		$("#aliDoc1").show();
		$("#aliDoc2").show();
		$("#aliFta1").hide();
		$("#ftaTableType").show();
	}else{
		$("#aliDoc1").hide();
		$("#aliDoc2").hide();
		$("#ftaDocuInfo1").hide();
		$("#ftaDocuInfo2").hide();
	}
}

// 검색구분변경
function fn_changeFtaTreatyType(type) {
	let ftaCol = new fn_ftaTableCol();
	let ftaHeader = new fn_ftaTableHeader();
	let ftaHidden = new fn_ftaTableHidden();
	var col, header, hidden;
	$('#alignTreaty option:eq(0)').prop('selected', true);


	//협정
	if (type == "01") {
		fn_searchFtaOption(true);
		fn_searchNatOption(false);
		fn_searchDocuOption(false);

		col = ftaCol.ftaCol;
		header = ftaHeader.ftaHeader;
		hidden = ftaHidden.ftaHidden;
		ftaTreatyHot.updateSettings(fn_handsonGridFtaOption(col, header, hidden));

	//협정별국가코드
	} else if (type == "02") {
		fn_searchFtaOption(false);
		fn_searchNatOption(true);
		fn_searchDocuOption(false);

		col = ftaCol.ftaNatCol;
		header = ftaHeader.ftaNatHeader;
		hidden = ftaHidden.ftaNatHidden;
		ftaTreatyHot.updateSettings(fn_handsonGridFtaOption(col, header, hidden));

	//서류정보
	} else {
		fn_searchFtaOption(false);
		fn_searchNatOption(false);
		fn_searchDocuOption(true);

		col = ftaCol.ftaDocuCol;
		header = ftaHeader.ftaDocuHeader;
		hidden = ftaHidden.ftaDocuHidden;
		console.log(col)
		console.log(header)

		ftaTreatyHot.updateSettings(fn_handsonGridFtaOption(col, header, hidden));
	}
	fn_searchftaTreaty();
};



//버튼 클릭시 팝업
function fn_callPopFtaTreaty(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	strSearch = (colLang == "en") ? "DISTINCT(CMMN_CD) AS CD, CMMN_NM_EN AS CD_NM" : (colLang == "vt") ? "DISTINCT(CMMN_CD) AS CD, CMMN_NM_VN AS CD_NM" : "DISTINCT(CMMN_CD) AS CD, CMMN_NM_KR AS CD_NM";
	strFrom = "CMMN_CD";
	strWhere = "GRP_CD ='NATION' AND DEL_YN = 'N'";
	strOrderby = "CMMN_CD";
	strIf1 = "CMMN_CD";
	strIf2 = (colLang == "en") ? "CMMN_NM_EN" : (colLang == "vt") ? "CMMN_NM_VN": "CMMN_NM_KR";

	type = target;

	var condition = {type :"tableCd",
	         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
	  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
			ftaTreatyHot.setDataAtCell(data.row, data.col, data.cd);
	});
}
