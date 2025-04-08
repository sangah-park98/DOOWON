var rpmsnHot;
var rpmsnSettings;
var rpmsnIndex = 9999;
var rpmsnScrollTp = true;
var plntSelect = [];
var tranSelect = [];
var incoSelect = [];
var natSelect = [];
var rCrncyList = [];

$( document ).ready(function() {

	  //달력 사용시 반드시 넣어주세요.
	  //datepicker -> band-calendar 클래스 교체 해주세요
	  $('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      plntCdList = plntCdList.replace('[','').replace(']','');
	  plntSelect = plntCdList.split(', ');

	  tranCdList = tranCdList.replace('[','').replace(']','');
	  tranSelect = tranCdList.split(', ');

	  incoCdList = incoCdList.replace('[','').replace(']','');
	  incoSelect = incoCdList.split(', ');

	  natCdList = natCdList.replace('[','').replace(']','');
	  natSelect = natCdList.split(', ');

	  rCrncyList = rpmCrncyList.replace('[','').replace(']','');
	  rCrncySelect = rCrncyList.split(', ');

	  var rpmsnElement = document.querySelector('#rpmsnTable');
	  var rpmsnElementContainer = rpmsnElement.parentNode;


	  rpmsnHot = new Handsontable(rpmsnElement, rpmsnSettings);


	  fn_rpmsnExcelSrch("02");

	  $("#rpmsn_div2").hide();
	  $("#rpmsn_div4").hide();
	  $("#btnRpmsnSave").hide();
	  fn_changeRpmsn('read');
//	  fn_searchRpmsn();

});

/** 이밴트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-rpmsn").hasClass("active")) {
//			fn_searchRpmsn();
//		}
//	}
//})

$(document).mousedown(function(e){
	if(e.target.name == "rpmsn1_data" || e.target.name == "rpmsn2_data"){
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
$("input[name=rpmsnType]").change(function(){
	  fn_changeRpmsn($(this).val());
});

//정렬항목
$("select[name=alignRpmsn]").change(function(){
	  fn_searchRpmsn();
});

//row 수
$("select[name=rpmsnPageCnt]").change(function(){
	  fn_searchRpmsn();
});

$("#rpmsnTable .wtHolder").scroll(function(){
	  var scrollTop = $("#rpmsnTable .wtHolder").scrollTop();
	  var countPerPage = $("#rpmsnPageCnt option:selected").val();
	  var rowHeight = rpmsnHot.getRowHeight();

	  var addCnt = 790;
	  if(countPerPage == "50"){
		  addCnt = 790;
	  }else if(countPerPage == "100"){
		  addCnt = 2040;
	  }else if(countPerPage == "150"){
		  addCnt = 3290;
	  }else if(countPerPage == "200"){
		  addCnt = 4540;
	  }

	  if(rpmsnScrollTp && rpmsnIndex != 9999 && scrollTop >= (countPerPage * rpmsnIndex * rowHeight) + addCnt){
		  fn_rpmsnScroll();
	  }
});

//검색구분 변경
$("input[name=rpmsn_searchType]").change(function(){
	$('input:radio[name=rpmsnType]:radio[value="read"]').prop('checked', true);
	fn_rpmsnExcelSrch($(this).val())
	fn_changeRpmsn($("#rpmsnType").val());
	fn_changeRpmsnType($(this).val());
});
/** 이밴트 End **/


//스크롤
function fn_rpmsnScroll(){
	if( $("input[name=rpmsnType]:checked").val() == "enrol")
		return;

	rpmsnScrollTp = false;
	rpmsnIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectCustomList.do",
		data : fn_setRpmsnForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = rpmsnHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	rpmsnHot.loadData(meargeJson);

        	rpmsnScrollTp = true;
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

function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchRpmsn();
    }
}

//검색
function fn_searchRpmsn(){
	rpmsnIndex = 0;
	$("#rpmsnSrch1").val($("#rpmsn_srch1").val());
	$("#rpmsnSrch2").val($("#rpmsn_srch2").val());
	$("#rpmsnSrch3").val($("#rpmsn_srch3").val());
	$("#rpmsnSrch4").val($("#rpmsn_srch4").val());
	$("#rpmsnSrch5").val($("#rpmsn_srch5").val());
	$("#rpmsnSrch6").val($("#rpmsn_srch6").val());
	$("#rpmsnSrch7").val($("#rpmsn_srch7").val());
	$("#rpmsnSrch8").val($("#rpmsn_srch8").val());
	$("#rpmsnSrch9").val($("input:radio[name=rpmsn_srch9]:checked").val());
	$("#SearchType").val($("input:radio[name=rpmsn_searchType]:checked").val());

	var data = fn_setRpmsnForm();
	var valid = fn_validateSearchDate(data["srch5"], data["srch6"]);

	if(valid === "false"){
		data["srch5"] = null;
		data["srch6"] = null;
		$("#rpmsn_srch5").val("");
		$("#rpmsn_srch6").val("");
		return;
	} else {
		data["srch5"] = $("#rpmsn_srch5").val();
		data["srch6"] = $("#rpmsn_srch6").val();
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectCustomList.do",
		data : fn_setRpmsnForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=rpmsnType]:checked").val() == "enrol"){
        		rpmsnHot.loadData([]);
        		rpmsnHot.alter('insert_row', 1, 1);
        	} else{
        		rpmsnHot.loadData([]);
            	rpmsnHot.loadData(data.resultList);
            	$("#rpmsnCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setRpmsnForm(){
	var sData = {};
	sData["searchType"] = $("input:radio[name=rpmsn_searchType]:checked").val();
	sData["srch1"] = $("#rpmsn_srch1").val();
	sData["srch2"] = $("#rpmsn_srch2").val();
	sData["srch3"] = $("#rpmsn_srch3").val();
	sData["srch4"] = $("#rpmsn_srch4").val();
	sData["srch5"] = $("#rpmsn_srch5").val();
	sData["srch6"] = $("#rpmsn_srch6").val();
	sData["srch7"] = $("#rpmsn_srch7").val();
	sData["srch8"] = $("#rpmsn_srch8").val();
	sData["srch9"] = $("input:radio[name=rpmsn_srch9]:checked").val();
	sData["alignItem"] = $("#alignRpmsn option:selected").val();
	sData["recordCountPerPage"] = $("#rpmsnPageCnt option:selected").val();
	sData["pageIndex"] = rpmsnIndex;
	return sData;
};

//검색조건 초기화
function fn_clearRpmsn(){
	//$("input:radio[name=rpmsn_searchType]")[0].checked = true;
	$("#rpmsn_srch1").val("");
	$("#rpmsn_srch2").val("");
	$("#rpmsn_srch3").val("");
	$("#rpmsn_srch4").val("");
	$("#rpmsn_srch5").val("");
	$("#rpmsn_srch6").val("");
	$("#rpmsn_srch7").val("");
	$("#rpmsn_srch8").val("");
	$("input:radio[name=rpmsn_srch9]")[0].checked = true;
	//$("#rpmsn_div1").show();
	//$("#rpmsn_div3").show();
	//$("#rpmsn_div2").hide();
	//$("#rpmsn_div4").hide();
	//fn_changeRpmsnType("01");
};

//저장버튼 클릭
function fn_saveRpmsnCheck(){
	if(rpmsnHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validateRpmsn();
};

//정합성 체크
function fn_validateRpmsn(){
	rpmsnHot.validateCells(function(result) {
		if(result){
			fn_saveRpmsnData();
		}else{
			rpmsnHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveRpmsnData(){

	if(!confirm(msgSaveConfirm)){ return }

	var saveRpmsnData = rpmsnHot.getSourceData();
	var dataType = $("input:radio[name=rpmsn_searchType]:checked").val();
	for(var i=0; i<saveRpmsnData.length; i++){
		saveRpmsnData[i]["srchTp"] = dataType;
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/saveCustomInfo.do",
		data : JSON.stringify(saveRpmsnData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=rpmsnType]:checked").val() == "enrol"){
        			$("input[name=rpmsnType]")[0].checked = true;
        			fn_changeRpmsn($("input[name=rpmsnType]:checked").val());
        		}
        		$("input:radio[name=rpmsnType]:input[value='read']").trigger("click");
        		fn_searchRpmsn();
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
function fn_rpmsnTableCol(){
	var tableType = $("input:radio[name=rpmsnType]:checked").val();

	var rpmsnPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	var rightRpmsnPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","right").append(value);
	};

	var popSearchRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopRpmsn(\''+prop+'\','+row+','+col+')"></i>');
		var str = (value == null) ? "" : value;
		$(td).empty().append($button).append("  " + str)
	};

	this.rpmsnExpCol = (tableType == "edit") ? [
		{data : 'plntCd', type: 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'customExpNo', type : 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'buyrCd', type : 'text', className : "htCenter", width: 150, renderer:popSearchRenderer },
		{data : 'salesDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
		{data : 'tranKnd', editor : 'select', selectOptions : tranSelect, type : 'autocomplete', className : "htCenter", width: 150, width: 150, validator : function(value, callback){callback(emptySelectboxCheck(value, this.selectOptions))}},
		{data : 'stndrdNo', type : 'numeric', width: 150},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'salesNo', type : 'numeric', width: 150},
		{data : 'salesOrdr', type : 'text', className : "htRight", width: 150},
		{data : 'expNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(String(value), 3))}},
		{data : 'itemPrice', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 250, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'foreUnit',  editor : 'select', selectOptions : rCrncySelect, type : 'autocomplete', width : 150, className:"htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'exchngRt', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},
		{data : 'itemQty', type : 'text', className : 'htRight',  width: 150, validator : function(value, callback){fn_positive(value, callback)}},

		{data: 'delYn', editor: 'select', className : "htCenter", selectOptions : ['Y', 'N'], width: 80, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
	] : (tableType == "read") ? [
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, className : "htCenter" ,type : 'autocomplete', validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'customExpNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'buyrCd', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'salesDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
		{data : 'tranKnd', type : 'text', className : "htCenter", width: 150},
		{data : 'stndrdNo', type : 'numeric', width: 150},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150},
		{data : 'salesNo', type : 'numeric', width: 150},
		{data : 'salesOrdr', type : 'text', className : "htRight", width: 150},
		{data : 'expNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(String(value), 3))}},
		{data : 'itemPrice', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 250, validator : function(value, callback){callback(notEmpty(String(value), 100))}},
		{data : 'foreUnit', type : 'text', width : 150, className:"htCenter"},
		{data : 'exchngRt', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},
		{data : 'itemQty', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'fobPrice', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 180},
		{data : 'fobPriceUnit', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},
	] : [
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, className : "htCenter" ,type : 'autocomplete', validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}, renderer:popSearchRenderer},
		{data : 'customExpNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'buyrCd', type : 'text', className : "htCenter", width: 150, renderer:popSearchRenderer},
		{data : 'salesDt', type: 'date', className : "htCenter", dateFormat: gridCalFormat, validator : notEmptyDataCheck},
		{data : 'tranKnd', editor : 'select', selectOptions : tranSelect, type : 'autocomplete', className : "htCenter", width: 150, width: 150,  validator : function(value, callback){callback(emptySelectboxCheck(value, this.selectOptions))}},
		{data : 'stndrdNo', type : 'numeric', width: 150},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'salesNo', type : 'numeric', width: 150, validator : function(value, callback){callback(notEmpty(String(value), 20))}},
		{data : 'salesOrdr', type : 'text', className : "htRight", width: 150},
		{data : 'expNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(String(value), 3))}},
		{data : 'itemPrice', type : 'text', className : 'htRight', width: 250, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'foreUnit',  editor : 'select', selectOptions : rCrncySelect, type : 'autocomplete', width : 150, className:"htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'exchngRt', type : 'text', type : 'text', className : 'htRight', width: 150},
		{data : 'itemQty', type : 'text',className : 'htRight', width: 150, validator : function(value, callback){fn_positive(value, callback)}},
	];

	this.rpmsnImpCol = (tableType == "edit") ? [
		{data : 'plntCd', type: 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'customImpNo', type : 'text', className : "htCenter", width: 150, readOnly:true, renderer:rpmsnPkNoneEdit},
		{data : 'vndrId', renderer: popSearchRenderer, width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(String(value), 20))}},
		{data : 'salesDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator : notEmptyDataCheck},
		{data : 'tranKnd', editor : 'select', selectOptions : tranSelect, type : 'autocomplete', className : "htCenter", width: 150, width: 150, validator : function(value, callback){callback(emptySelectboxCheck(value, this.selectOptions))}},
		{data : 'stndrdNo', type : 'text', className : "htLeft", width: 150, validator : /(^[\s\S]{0,20}$)/},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'purchaseNo', type : 'text', className : "htCenter", width: 150},
		{data : 'purchaseOrdr', type : 'text', className : "htRight", width: 150, validator : /(^[\s\S]{0,20}$)/},
		{data : 'impNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 3))}},
		{data : 'itemPrice', type : 'text', className : 'htRight', width: 250, validator : function(value, callback){callback(notEmpty(String(value), 200))}},
		{data : 'foreUnit',  editor : 'select', selectOptions : rCrncySelect, type : 'autocomplete', width : 150, className:"htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'exchngRt', type : 'text', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},
		{data : 'itemQty', type : 'text', className : 'htRight',  width: 150, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 120, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : (tableType == "read") ? [
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150},
		{data : 'itemCd', type : 'text', className : "htCenter"},
		{data : 'customImpNo', type : 'text', className : "htCenter", width: 150},
		{data : 'vndrId', width: 150, className : "htCenter"},
		{data : 'salesDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"},
		{data : 'tranKnd', type : 'text', className : "htCenter", width: 150, width: 150},
		{data : 'stndrdNo', type : 'text', className : "htLeft", width: 150},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150},
		{data : 'purchaseNo', type : 'text', className : "htCenter", width: 150},
		{data : 'purchaseOrdr', type : 'text', className : "htRight", width: 150},
		{data : 'impNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180},//국가코드
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150},//인코텀즈 --
		{data : 'itemPrice', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 250},//단가(거래통화) 필수입력값
		{data : 'foreUnit', type : 'text', width : 150, className:"htCenter"},//통화단위
		{data : 'exchngRt', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},//환율
		{data : 'itemQty', type : 'text', className : 'htRight',  width: 150, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'cifPriceUnit', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 180},//CIF 거래통화 //환율 * 거래금액
		{data : 'cifPrice', type : 'numeric', numericFormat : {pattern : '0,0.00'}, width: 150},//CIF금액
	] : [
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150,validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd', type : 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, width: 150, renderer : popSearchRenderer},
		{data : 'customImpNo', type : 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, width: 150},
		{data : 'vndrId', renderer: popSearchRenderer, width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(String(value), 20))}},
		{data : 'salesDt', type :  'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator : notEmptyDataCheck},
		{data : 'tranKnd', editor : 'select', selectOptions : tranSelect, type : 'autocomplete', className : "htCenter", width: 150, width: 150, validator : function(value, callback){callback(emptySelectboxCheck(value, this.selectOptions))}},
		{data : 'stndrdNo', type : 'text', className : "htLeft", width: 150, validator : /(^[\s\S]{0,20}$)/},
		{data : 'invoiceNo', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'purchaseNo', type : 'text', className : "htCenter", width: 150},
		{data : 'purchaseOrdr', type : 'text', className : "htRight", width: 150},
		{data : 'impNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 180, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incoSelect, type : 'autocomplete', className : "htCenter", width: 150, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'itemPrice', type : 'text', className : 'htRight', width: 250, validator : function(value, callback){fn_positive(value, callback)}},
		{data : 'foreUnit',  editor : 'select', selectOptions : rCrncySelect, type : 'autocomplete', width : 150, className:"htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'exchngRt', type : 'text', width : 150, className : 'htRight'},
		{data : 'itemQty', type : 'text', className : 'htRight',  width: 150, validator : function(value, callback){fn_positive(value, callback)}},
	];
}

//테이블 헤더
function fn_rpmsnTableHeader(){
	var tableType = $("input:radio[name=rpmsnType]:checked").val();

	this.rpmsnExpHeader = (tableType == "edit") ? [
		colplntCd + '*',colitemCd + '*',colcustomExpNo + '*',colbuyrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
		colinvoiceNo+"*",colsalesNo,colsaleOrdr,colexpNatCd+"*",colinctrm+"*",colunitCost+"*",colForeUnit+"*",colExchngRt,
		colunitQty+"*",coldelYn
	] : (tableType == "read") ? [
		colplntCd + '*',colitemCd + '*',colcustomExpNo + '*',colbuyrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
		colinvoiceNo+"*",colsalesNo,colsaleOrdr,colexpNatCd+"*",colinctrm+"*",colunitCost+"*", colForeUnit+"*",
		colExchngRt,colunitQty+"*",colCifPriceUnit,colforPrice+"(VND)",
	] : [
		colplntCd + '*',colitemCd + '*',colcustomExpNo + '*',colbuyrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
		colinvoiceNo+"*",colsalesNo,colsaleOrdr,colexpNatCd+"*",colinctrm+"*", colunitCost+"*",colForeUnit+"*",colExchngRt,colunitQty+"*",colunitCost+"*"
	];

	this.rpmsnImpHeader = (tableType == "edit") ? [
		colplntCd + '*',colitemCd + '*',colcustomImpNo + '*',colvndrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
		colinvoiceNo+"*",colpurchsNo,colsaleOrdr,colimpNatCd+"*",colinctrm+"*",colunitCost+"*",colForeUnit+"*",
		colExchngRt,colunitQty+"*",coldelYn
	] : (tableType == "read") ? [
		colplntCd + '*',colitemCd + '*',colcustomImpNo + '*',colvndrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,colinvoiceNo+"*",colpurchsNo,
		colsaleOrdr,colimpNatCd+"*",colinctrm+"*",colunitCost+"*",colForeUnit+"*",colExchngRt,colunitQty+"*",colCifPriceUnit,colcifPrice+"(VND)"
		/**//*colunitQty+"*",colunitWght,*//*,colCoNo*/
		//colCost

	] : [
		colplntCd + '*',colitemCd + '*',colcustomImpNo + '*',colvndrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
		colinvoiceNo+"*",colpurchsNo,colsaleOrdr,colimpNatCd+"*",colinctrm+"*",colunitCost+"*",colForeUnit+"*",
		colExchngRt,colunitQty+"*",
	];

}

//테이블 히든컬럼
function fn_rpmsnTableHidden(){
	var tableType = $("input:radio[name=rpmsnType]:checked").val();

	this.rpmsnExpHidden = [];

	this.rpmsnImpHidden = [];

}

//table
function fn_handsonGridRpmsnOprion(col, header, hidden){
	var tableType = $("input:radio[name=rpmsnType]:checked").val();

	rpmsnSettings = {
		  columns : col,
		  colHeaders : header,
		  hiddenColumns : {
        	  copyPasteEnabled : false,
        	  indicators : false,
        	  columns : hidden
          },
    	  stretchH : 'all',
    	  width : '98.7%',
    	  autoWrapRow : true,
    	  height : 487,
    	  manualRowResize : true,
    	  manualColumnResize : true,
    	  rowHeights : 25,
    	  rowHeaders : true,
    	  columnHeaderHeight : 25,
		  manualRowMove : true,
		  manualColumnMove : false,
		 // dropdownMenu : true,

		  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		  filters : true,
		  readOnly : (tableType == "read") ? true : false,
		  allowInsertRow : true,
		  allowRemoveRow : true,
		 // columnSorting : {indicator : true},
          autoColumnSize : {samplingRatio : 23},
          mergeCells : false,
          beforeChange: function (changes, source) {
      		if(changes != null){
      			//maxlength
      			for (i = 0; i < changes.length; i++) {
      				var row = changes[i][0]; //0 변경셀의 row
      				var col = changes[i][1]; //1 변경셀의 col
      				var meta = this.getCellMeta(row, col);
      				if(col == "itemQty" || col == "exchngRt" || col == "purchasePriceFr" || col == "itemPrice"){
      					var data = fn_numericFormat(changes[i][3].replaceAll(/,/gi, "")); //3 변경 데이터
      					//replace \n
      					changes[i][3] = (''+data).replace(/\s+/, '')
      		                                            .replace(/\s+$/g, '')
      		                                            .replace(/\n/g, '')
      		                                            .replace(/\r/g, '')
      		                                            .replace(/(\n|\r\n)/gm, '');
      					data = changes[i][3];
  						if(data == null || data == ""){
  							return;
  						}
  						if(data.indexOf(".") == -1){
  							data = data+".00";
  						} else if(data.indexOf(".") != -1){
  							var row = data.split(".");
  							if(row[1].length > 2){
  								data = row[0] +"."+ row[1].substring(0,2);
  							} else if(row[1].length < 2){
  								data+"0";
  							}
  						}
  						changes[i][3] = data;

      					//maxlength
      	                if(col != null && col =="numberColumn"  ){
      						changes[i][3] = (''+data).replace(/,/g, '');
      						data = changes[i][3];

      						if((''+data).length>10){
      							changes[i][3] = (''+data).substring(0, 10);
      						}
      					}
      				} else if(col != null && col =="salesDt"  ){
      					var data = changes[i][3].replaceAll("/", "");
      					changes[i][3] = dateFormChange(fn_dateColForm(data));
      				} else {
      					return;
      				}
      			}
      		}
         }
	  };
	return rpmsnSettings;
}

//테이블 타입 변경
function fn_changeRpmsn(type){
	if(type == "edit"){
		$("#btnRpmsnMdat").hide();
		$("#btnRpmsnSave").show();
	}else if(type == "enrol"){
		$("#btnRpmsnMdat").hide();
		$("#btnRpmsnSave").show();
	}else{
		$("#btnRpmsnMdat").show();
		$("#btnRpmsnSave").hide();
	}

	var searchTp = $("input:radio[name=rpmsn_searchType]:checked").val();
	fn_changeRpmsnType(searchTp);
};

//검색구분 변경
function fn_changeRpmsnType(type){
	let rpmsnCol = new fn_rpmsnTableCol();
	let rpmsnHeader = new fn_rpmsnTableHeader();
	let rpmsnHidden = new fn_rpmsnTableHidden();
	var col, header, hidden;

	$("#alignRpmsn option:eq(0)").prop('selected', true);

	//수출면장
	if(type == "01"){
		$("#rpmsn_div1").show();
		$("#rpmsn_div3").show();
		$("#rpmsn_div2").hide();
		$("#rpmsn_div4").hide();
		col = rpmsnCol.rpmsnExpCol;
		header = rpmsnHeader.rpmsnExpHeader;
		hidden = rpmsnHidden.rpmsnExpHidden;
		rpmsnHot.updateSettings(fn_handsonGridRpmsnOprion(col, header, hidden));
	//수입면장
	}else{
		$("#rpmsn_div1").hide();
		$("#rpmsn_div3").hide();
		$("#rpmsn_div2").show();
		$("#rpmsn_div4").show();
		col = rpmsnCol.rpmsnImpCol;
		header = rpmsnHeader.rpmsnImpHeader;
		hidden = rpmsnHidden.rpmsnImpHidden;
		rpmsnHot.updateSettings(fn_handsonGridRpmsnOprion(col, header, hidden));
	}
	fn_searchRpmsn();
};

//팝업호출
function fn_callPopRpmsn(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2;
	//품목코드 팝업
	if(target == "itemCd"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colitemCd);
	//판매처코드 팝업
	}else if(target == "buyrCd" || target == "1"){
		strSearch = (colLang == "en") ? "BUYR_ID AS CD, BUYR_NM_EN AS CD_NM" : "BUYR_ID AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colbuyrCd);
	//구매처코드 팝업
	}else if(target == "vndrId" || target == "2"){
		strSearch = (colLang == "en") ? "VNDR_ID AS CD, VNDR_NM_EN AS CD_NM" : "VNDR_ID AS CD, VNDR_NM AS CD_NM";
		strFrom = "PARTN_VNDR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "VNDR_ID";
		strIf1 = "VNDR_ID";
		strIf2 = (colLang == "en") ? "VNDR_NM_EN" : "VNDR_NM";
		$("#exampleModalCenterTitleCmmn").text(colvndrCd);
	}

	var condition = {type :"tableCd", search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2, type : target, row : row, col : col};
	fn_showCmmnPopup(condition, function(data){
		if(data.row == null || data.col == null || data.row == undefined || data.col == undefined){
			if(data.type == "itemCd"){
				$("#rpmsn_srch2").val(data.cd);
			}else if(data.type == "buyrCd"){
				$("#rpmsn_srch3").val(data.cd);
			}else if(data.type == "vndrCd"){
				$("#rpmsn_srch4").val(data.cd);
			}
		}else{
			rpmsnHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
};

//가격조정
function fn_priceMdat(){
	var searchType = $("input:radio[name=rpmsn_searchType]:checked").val();
	var confirmMsg = (searchType == "01") ? msgSalesPriceMsg : msgPurchPriceMsg;
	if(!confirm(confirmMsg)){ return }
	var saveRpmsnData = rpmsnHot.getSourceData()
	var mdatData = {};
	for(var i=0; i<saveRpmsnData.length; i++){
		saveRpmsnData[i]["srchTp"] = searchType;
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/savePriceMdat.do",
		data : JSON.stringify(saveRpmsnData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
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


function fn_rpmsnExcelSrch(type){
	$("#rpmsnSrch1").val($("input:radio[name=purchase_srch1]:checked").val());
	if(type == '02'){
		$("#rpmsnExTit").val(colCustomImp);
		$("#rpmsnExCol").val(String([colplntCd+"*",colitemCd+"*",colcustomImpNo+"*",colvndrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,colinvoiceNo+"*",colpurchsNo,
			colsaleOrdr,colimpNatCd+"*",colinctrm+"*",colunitCost+"*",colForeUnit+"*",colExchngRt,colunitQty+"*",colCifPriceUnit,colcifPrice])+",");
		$("#rpmsnExCd").val("plntCd,itemCd,customImpNo,vndrId,salesDt,tranKnd,stndrdNo,invoiceNo,purchaseNo,purchaseOrdr,impNatCd,incoterms,itemPrice,foreUnit,exchngRt,itemQty,cifPriceUnit,cifPrice,");
		$("#rpmsnExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,floatString,cd,floatString,floatString,floatString,floatString,");
	}else{
		$("#rpmsnExTit").val(colCustomExp);
		$("#rpmsnExCol").val(String([colplntCd+"*",colitemCd+"*",colcustomExpNo+"*",colbuyrCd+"*",colFixDt+"*",coltranKnd,colstndrdNo,
			colinvoiceNo+"*",colsalesNo,colsaleOrdr,colexpNatCd+"*",colinctrm+"*",colunitCost+"*", colForeUnit+"*",
			colExchngRt,colunitQty+"*",colCifPriceUnit,colforPrice+","]));
		$("#rpmsnExCd").val("plntCd,itemCd,customExpNo,buyrCd,salesDt,tranKnd,stndrdNo,invoiceNo,salesNo,salesOrdr,expNatCd,incoterms,itemPrice,foreUnit,exchngRt,itemQty,fobPrice,fobPriceUnit,");
		$("#rpmsnExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,floatString,cd,floatString,floatString,floatString,floatString,");
	}

}


