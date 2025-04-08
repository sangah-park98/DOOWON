var vendorHot;
var vendorSettings;
var vendorIndex = 9999;
var vendorScrollTp = true;

$( document ).ready(function() {
	  var vendorElement = document.querySelector('#vendorTable');
	  var vendorElementContainer = vendorElement.parentNode;

	  vendorHot = new Handsontable(vendorElement, vendorSettings);

	  $("#btnVendorSave").hide();
	  fn_changeVendor('read');

	//scroll 이벤트
	  $("#vendorTable .wtHolder").scroll(function(){
	  	  var scrollTop = $("#vendorTable .wtHolder").scrollTop();
	  	  var countPerPage = $("#vendorPageCnt option:selected").val();
	  	  var rowHeight = vendorHot.getRowHeight();

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

	  	  if(vendorScrollTp && vendorIndex != 9999 && scrollTop >= (countPerPage * vendorIndex * rowHeight) + addCnt){
	  		  fn_vendorScroll();
	  	  }
	  });
});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-buyer").hasClass("active")) {
//			fn_searchVendor();
//		} 
//	}
//})

//테이블 타입 변경
$("input[name=vendorType]").change(function(){
	  fn_changeVendor($(this).val());
});

//정렬항목
$("select[name=alignVendor]").change(function(){
	  fn_searchVendor();
});

//row 수
$("select[name=vendorPageCnt]").change(function(){
	  fn_searchVendor();
});

/** 이벤트 End **/

//스크롤
function fn_vendorScroll(){
	if ($("input[name=vendorType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	vendorScrollTp = false;
	vendorIndex++;

	$.ajax({
		type : "POST",
		url : "/base/selectVendorList.do",
		data : fn_setVendorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = vendorHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	vendorHot.loadData(meargeJson);
        	vendorScrollTp = true;
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
		fn_searchVendor();
    }
}


//검색
function fn_searchVendor(){
	vendorIndex = 0;

	$("#vndrSrch1").val($("#vendor_srch1").val());
	$("#vndrSrch2").val($("#vendor_srch2").val());
	$("#vndrSrch3").val($("#vendor_srch3").val());
	$("#vndrSrch4").val($("#vendor_srch4").val());
	$("#vndrSrch5").val($("input:radio[name=vendor_srch5]:checked").val());
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectVendorList.do",
		data : fn_setVendorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=vendorType]:checked").val() == "enrol"){
        		vendorHot.loadData([]);
        		vendorHot.alter('insert_row', 1, 1);
        	}else{
        		vendorHot.loadData([]);
            	vendorHot.loadData(data.resultList);
            	$("#vendorCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setVendorForm(){
	var sData = {};
	sData["srch1"] = $("#vendor_srch1").val();
	sData["srch2"] = $("#vendor_srch2").val();
	sData["srch3"] = $("#vendor_srch3").val();
	sData["srch4"] = $("#vendor_srch4").val();
	sData["srch5"] = $("input:radio[name=vendor_srch5]:checked").val();
	sData["alignItem"] = $("#alignVendor option:selected").val();
	sData["recordCountPerPage"] = $("#vendorPageCnt option:selected").val();
	sData["pageIndex"] = vendorIndex;
	fn_setVndrExcelSrch();
	return sData;
};

function fn_setVndrExcelSrch(){
	$("#vndrSrch1").val($("#vendor_srch1").val());
	$("#vndrSrch2").val($("#vendor_srch2").val());
	$("#vndrSrch3").val($("#vendor_srch3").val());
	$("#vndrSrch4").val($("#vendor_srch4").val());
}

//검색조건 초기화
function fn_clearVendor(){
	$("#vendor_srch1").val("");
	$("#vendor_srch2").val("");
	$("#vendor_srch3").val("");
	$("#vendor_srch4").val("");
	$("input:radio[name = 'vendor_srch5']:radio[value = '']").prop("checked", true);
};

//저장버튼 클릭
function fn_saveVendorCheck(){
	if(vendorHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validateVendor();
};

//정합성 체크
function fn_validateVendor(){
	vendorHot.validateCells(function(result) {
		if(result){
			fn_saveVendorData();
		}else{
			vendorHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveVendorData(){
	if(!confirm(msgSaveConfirm)){return}
	fn_loading(true);
	
	var tableType = $("input:radio[name=vendorType]:checked").val();
	var checkedData = vendorHot.getSourceData();
	var popData = [];
	for(var i=0; i<checkedData.length; i++){
		
		if( tableType == "edit" ){
		if(checkedData[i]["saveCheck"] == true){
			popData.push(checkedData[i]);
			}
		} else {
			popData.push(checkedData[i]);
		}
	}
	$.ajax({
		type : "POST",
		url : "/base/saveVendorInfo.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=vendorType]:checked").val() == "enrol"){
        			$("input[name=vendorType]")[0].checked = true;
        			fn_changeVendor($("input[name=vendorType]:checked").val());
        		}
        		$("input:radio[name=vendorType]:input[value='read']").trigger("click");
        		fn_searchVendor();
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
function fn_vendorTableCol(){
	var tableType = $("input:radio[name=vendorType]:checked").val();
	var unitPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	
	this.vendorEidtCol = [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'vndrId', type : 'text', className : "htCenter", width: 150, readOnly : true, renderer: unitPkNoneEdit},
		{data : 'vndrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'vndrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'corpNo', type : 'text', className : "htCenter", validator : /(^[\s\S]{0,20}$)/},
		{data : 'postNo', type : 'text', className : "htCenter", width: 100, validator : /(^[\s\S]{0,10}$)/},
		{data : 'addr1', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		{data : 'addr1En', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		/*{data : 'ceoVnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'ceoEnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},*/
		{data : 'telNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'faxNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'email', type : 'text', width: 200, validator : function(value, callback){
			var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			(email_pattern.test(value)) ? callback(true) :
			(value == null || value == "") ? callback(true) : callback(false);
		}},
		{data : 'empNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empGrd', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,20}$)/},
		{data : 'etc', type : 'text', width: 150},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 100,
									validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}

	];
	this.vendorCol = [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'vndrId', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'vndrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'vndrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'corpNo', type : 'text', className : "htCenter", validator : /(^[\s\S]{0,20}$)/},
		{data : 'postNo', type : 'text', className : "htCenter", width: 100, validator : /(^[\s\S]{0,50}$)/},
		{data : 'addr1', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		{data : 'addr1En', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		/*{data : 'ceoVnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'ceoEnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},*/
		{data : 'telNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'faxNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'email', type : 'text', width: 200, validator : function(value, callback){
			var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			(email_pattern.test(value)) ? callback(true) :
			(value == null || value == "") ? callback(true) : callback(false);
		}},
		{data : 'empNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empGrd', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,20}$)/},
		{data : 'etc', type : 'text', width: 150},
		{data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
		{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	];
	this.vendorEnrolCol = [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'vndrId', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'vndrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'vndrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200,  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'corpNo', type : 'text', className : "htCenter", width: 150, validator : /(^[\s\S]{0,20}$)/},
		{data : 'postNo', type : 'text', className : "htCenter", width: 100, validator : /(^[\s\S]{0,50}$)/},
		{data : 'addr1', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		{data : 'addr1En', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 300},
		/*{data : 'ceoVnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'ceoEnNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},*/
		{data : 'telNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'faxNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/},
		{data : 'email', type : 'text', width: 200, validator : function(value, callback){
			var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			(email_pattern.test(value)) ? callback(true) :
			(value == null || value == "") ? callback(true) : callback(false);
		}},
		{data : 'empNm', type : 'text', className : "htLeft", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empGrd', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,20}$)/},
		{data : 'etc', type : 'text', width: 150},
	]
}

//테이블 헤더
function fn_vendorTableHeader(){

	this.vendorHeader = [
		"saveCheck",
		colVndrCd+"*",colVndrNm+"*",colVndrNmEn+"*",colCorpNo,colZipNb,colAddr1,colAddr1En
		/*,colCeoNm,colCeoNmEn*/
		,colTelNo,colFaxNo,colEmail,colEmpNm,colEmpGrd,colEmpTelNo,colEtc,colRegDt,colEdtDt
	];
	this.vendorHeaderEnrol = [
		"saveCheck",
		colVndrCd+"*",colVndrNm+"*",colVndrNmEn+"*",colCorpNo,colZipNb,colAddr1,colAddr1En
		/*,colCeoNm,colCeoNmEn*/
		,colTelNo,colFaxNo,colEmail,colEmpNm,colEmpGrd,colEmpTelNo,colEtc
		];
	this.vendorHeaderEdit = [
		"saveCheck",
		colVndrCd+"*",colVndrNm+"*",colVndrNmEn+"*",colCorpNo,colZipNb,colAddr1,colAddr1En
		/*,colCeoNm,colCeoNmEn*/
		,colTelNo,colFaxNo,colEmail,colEmpNm,colEmpGrd,colEmpTelNo,colEtc,colDelYn+'*'
		];
}

//테이블 히든컬럼
function fn_vendorTableHidden(){
	var tableType = $("input:radio[name=vendorType]:checked").val();

	this.vendorHidden =  [0];
}

//handsontable Grid 이벤트
function fn_handsonGridVndrOption(col, header, hidden){
	var tableType = $("input:radio[name=vendorType]:checked").val();

	vendorSettings = {
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
	  manualRowResize : true,
	  manualColumnResize : true,
	  rowHeights : 25,
	  colWidths: 100,
	  rowHeaders : true,
	  columnHeaderHeight : 25,
	  //dropdownMenu : true,
	  
	  contextMenu : (tableType == "enrol") ?  ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
	  filters : true,
	  readOnly : (tableType == "read") ?  true : false,
	  allowRemoveRow : true,
	  manualColumnMove : false,
	  manualRowMove : true,
	 // columnSorting : {indicator : true},
      autoColumnSize : {samplingRatio : 23},
      mergeCells : false,
      allowInsertRow : true,
      wordWrap : true,
      afterChange: function(changes, source){
      	if (changes && changes[0][2] !== changes[0][3]){ 
      		/*alert("ROW:"+changes[0][0]+", COLUMN:"+changes[0][1]+", FROM:"+changes[0][2]+", TO:"+changes[0][3]);*/
      		this.setDataAtCell(changes[0][0],0,true); 
      		}
      }
	};

	return vendorSettings;
}

//테이블 타입 변경
function fn_changeVendor(type){
	let vendorCol = new fn_vendorTableCol();
	let vendorHeader = new fn_vendorTableHeader();
	let vendorHidden = new fn_vendorTableHidden();
	var col, header, hidden;


	/*header = vendorHeader.vendorHeader;*/
	hidden = vendorHidden.vendorHidden;


	if(type == "edit"){
		col = vendorCol.vendorEidtCol;
		header = vendorHeader.vendorHeaderEdit;
		$("#btnVendorSave").show();
		$("#btnSave_XmlVendor").hide();
		$("#vendorExcel").hide();
	}else if(type == "enrol"){
		col = vendorCol.vendorEnrolCol;
		header = vendorHeader.vendorHeaderEnrol;
		$("#btnVendorSave").show();
		$("#btnSave_XmlVendor").show();
		$("#vendorExcel").hide();
	}else{
		col = vendorCol.vendorCol;
		header = vendorHeader.vendorHeader;
		$("#btnVendorSave").hide();
		$("#btnSave_XmlVendor").hide();
		$("#vendorExcel").show();
	}
	vendorHot.updateSettings(fn_handsonGridVndrOption(col, header, hidden));
	fn_searchVendor();
};


//테이블팝업 호출
function fn_callPopVendor(target, row, col) {
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	// 아이템 조회
	strSearch = (colLang == "en") ? "DISTINCT(VNDR_ID) AS CD, VNDR_NM_EN AS CD_NM"
			: "DISTINCT(VNDR_ID) AS CD, VNDR_NM AS CD_NM";
	strFrom = "PARTN_VNDR_INFO";
	strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
	strOrderby = "VNDR_ID";
	strIf1 = "VNDR_ID";
	strIf2 = (colLang == "en") ? "VNDR_NM_EN" : "VNDR_NM";
	$("#exampleModalCenterTitleCmmn").text(colVndrCd);

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
		$("#vendor_srch1").val(data.cd);
	});
};


function fn_showPurchaseFilePop(){
	if($("#fileVendorPopupPc").length>1){
		$("#fileVendorPopupPc").eq(1).model("show");
		$("#fileVendorPopupPc").eq(0).model("show");
	} 
	$("#fileVendorPopupPc").modal("show");
}

function fn_saveFileVendor(){
	var file = $("#infoFilesVendor").prop("files")[0];

	/*if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}*/
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoFormVendor'));
	
	$.ajax({
		type: 'POST',
		url: "/base/saveVendorFiles.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success : function(data) {
			vendorHot.loadData([]);
			vendorHot.loadData(data.resultList);
			
			$("#fileVendorPopupPc").modal("hide");
		},
		error: function (jqXHR) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		//alert(msgSaveError);
        	}
		}
	});
};