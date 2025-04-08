var buyerHot;
var buyerSettings;
var buyerIndex = 9999;
var buyerScrollTp = true;

$( document ).ready(function() {
	  var buyerElement = document.querySelector('#buyerTable');
	  var buyerElementContainer = buyerElement.parentNode;

	  buyerHot = new Handsontable(buyerElement, buyerSettings);

	  $("#btnBuyerSave").hide();
	  fn_changeBuyer('read');
	  fn_searchBuyer();

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
//		if (window.event.keyCode == 13 && $("#tabs-vendor").hasClass("active")) {
//			fn_searchBuyer();
//		} 
//	}
//})

//테이블 타입 변경
$("input[name=buyerType]").change(function(){
	  fn_changeBuyer($(this).val());
});

//정렬항목
$("select[name=alignBuyer]").change(function(){
	  fn_searchBuyer();
});

//row 수
$("select[name=buyerPageCnt]").change(function(){
	  fn_searchBuyer();
});


/** 이벤트 End **/

//스크롤
function fn_buyerScroll(){
	buyerScrollTp = false;
	buyerIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectBuyerList.do",
		data : fn_setBuyerForm(),
		dataType: "json",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        success : function(data) {
        	var getData = buyerHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	buyerHot.loadData(meargeJson);
        	buyerScrollTp = true;
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
		fn_searchBuyer();
    }
}


//검색
function fn_searchBuyer(){
	buyerIndex = 0;

	$("#buyrSrch1").val($("buyer_srch1").val());
	$("#buyrSrch2").val($("buyer_srch2").val());
	$("#buyrSrch3").val($("buyer_srch3").val());
	$("#buyrSrch4").val($("buyer_srch4").val());
	$("#buyrSrch5").val($("input:radio[name=buyer_srch5]:checked").val());
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectBuyerList.do",
		data : fn_setBuyerForm(),
		dataType: "json",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        success : function(data) {
        	 if($("input[name=buyerType]:checked").val() == "enrol"){
        		 buyerHot.loadData([]);
        		 buyerHot.alter('insert_row', 1, 1);
        	 }else{
        		buyerHot.loadData([]);
             	buyerHot.loadData(data.resultList);
             	$("#buyerCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setBuyerForm(){
	var sData = {};
	sData["srch1"] = $("#buyer_srch1").val();
	sData["srch2"] = $("#buyer_srch2").val();
	sData["srch3"] = $("#buyer_srch3").val();
	sData["srch4"] = $("#buyer_srch4").val();
	sData["srch5"] = $("input:radio[name=buyer_srch5]:checked").val();
	sData["alignItem"] = $("#alignBuyer option:selected").val();
	sData["recordCountPerPage"] = $("#buyerPageCnt option:selected").val();
	sData["pageIndex"] = buyerIndex;
	return sData;
};

//검색조건 초기화
function fn_clearBuyer(){
	$("#buyer_srch1").val("");
	$("#buyer_srch2").val("");
	$("#buyer_srch3").val("");
	$("#buyer_srch4").val("");
	$("input:radio[name = 'buyer_srch5']:radio[value = '']").prop("checked", true);
};

//저장버튼 클릭
function fn_saveBuyerCheck(){
	if(buyerHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validateBuyer();
};

//정합성 체크
function fn_validateBuyer(){
	buyerHot.validateCells(function(result) {
		if(result){
			fn_saveBuyerData();
		}else{
			buyerHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveBuyerData(){
	if(!confirm(msgSaveConfirm)){return;}
	fn_loading(true);
	
	var tableType = $("input:radio[name=buyerType]:checked").val();
	var checkedData = buyerHot.getSourceData();
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
	var saveBuyerData = buyerHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/base/saveBuyerInfo.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=buyerType]:checked").val() == "enrol"){
        			$("input[name=buyerType]")[0].checked == true;
        			fn_changeBuyer($("input[name=buyerType]:checked").val());
        		}
        		$("input:radio[name=buyerType]:input[value='read']").trigger("click");
        		fn_searchBuyer();
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
function fn_buyerTableCol(){
	var tableType = $("input:radio[name=buyerType]:checked").val();
	var unitPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	this.buyerCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'buyrId', type : 'text', className : "htLeft", width: 130, className:"htCenter", renderer:unitPkNoneEdit, readOnly:true},
		{data : 'buyrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'buyrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
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
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,20}$)/, className:"htCenter"},
		{data : 'etc', type : 'text'},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 100,
									validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
	] : (tableType == "read") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'buyrId', type : 'text', className : "htLeft", width: 130, validator : function(value, callback){callback(notEmpty(value, 200))}, className:"htCenter"},
		{data : 'buyrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'buyrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'corpNo', type : 'text', className : "htCenter", width: 150, validator : /(^[\s\S]{0,20}$)/},
		{data : 'postNo', type : 'text', className : "htCenter", width: 100, validator : /(^[\s\S]{0,10}$)/},
		{data : 'addr1', type : 'text', validator : /(^[\s\S]{0,100}$)/, width: 300},
		{data : 'addr1En', type : 'text', validator : /(^[\s\S]{0,100}$)/, width: 300},
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
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 200, validator : /(^[\s\S]{0,20}$)/, className:"htCenter"},
		{data : 'etc', type : 'text'},
		{data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
		{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'buyrId', type : 'text', className : "htLeft", width: 100, validator : function(value, callback){callback(notEmpty(value, 200))}, className:"htCenter"},
		{data : 'buyrNm', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'buyrNmEn', type : 'text', validator : /(^[\s\S]{0,500}$)/, width: 200, className:"htCenter",  validator : function(value, callback){callback(notEmpty(value, 500))}},
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
		{data : 'empTelNo', type : 'text', className : "htCenter", width: 130, validator : /(^[\s\S]{0,20}$)/, className:"htCenter"},
		{data : 'etc', type : 'text'}
	];
}

//테이블 헤더
function fn_buyerTableHeader(){
	var tableType = $("input:radio[name=buyerType]:checked").val();
	
	this.buyerHeader = (tableType == "edit") ? [
		"saveCheck",
		colBuyrCd+'*',colBuyrNm+"*",colBuyrNmEn+"*",colCorpNo,colZipNb,colAddr1,colAddr1En
		/*,colCeoNm,colCeoNmEn*/
		,colTelNo,colFaxNo,colEmail,colEmpNm,colEmpGrd,colEmpTelNo,colEtc,colDelYn
	] : [
		"saveCheck",
		colBuyrCd+'*',colBuyrNm+"*",colBuyrNmEn+"*",colCorpNo,colZipNb,colAddr1,colAddr1En
		/*,colCeoNm,colCeoNmEn*/
		,colTelNo,colFaxNo,colEmail,colEmpNm,colEmpGrd,colEmpTelNo,colEtc,colRegDt,colEdtDt
	];
}

//테이블 히든커럶
function fn_buyerTableHidden(){
	var tableType = $("input:radio[name=buyerType]:checked").val();

	this.buyerHidden = [0];
}


function fn_handsonGridBuyrOption(col, header, hidden){
	var tableType = $("input:radio[name=buyerType]:checked").val();

	var buyerSettings = {
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
            afterChange: function(changes, source){
            	if (changes && changes[0][2] !== changes[0][3]){ 
            		/*alert("ROW:"+changes[0][0]+", COLUMN:"+changes[0][1]+", FROM:"+changes[0][2]+", TO:"+changes[0][3]);*/
            		this.setDataAtCell(changes[0][0],0,true); 
            		}
            }
	 };
	return buyerSettings;
}

/*manualRowMove: false,    //처음과 끝으로
manualColumnMove: false, //처음과 끝으로
*/
//테이블 타입 변경
function fn_changeBuyer(type){
	let buyerCol = new fn_buyerTableCol();
	let buyerHeader = new fn_buyerTableHeader();
	let buyerHidden = new fn_buyerTableHidden();
	var col, header, hidden;

	col = buyerCol.buyerCol;
	header = buyerHeader.buyerHeader;
	hidden = buyerHidden.buyerHidden;
	buyerHot.updateSettings(fn_handsonGridBuyrOption(col, header, hidden));

	if(type == "edit"){
		$("#btnSave_XmlBuyer").hide();
		$("#btnBuyerSave").show();
		$("#buyerExcel").hide();
	}else if(type == "enrol"){
		$("#btnSave_XmlBuyer").show();
		$("#btnBuyerSave").show();
		$("#buyerExcel").hide();
	}else{
		$("#btnSave_XmlBuyer").hide();
		$("#btnBuyerSave").hide();
		$("#buyerExcel").show();
		
	}
	fn_searchBuyer();
};

//테이블팝업 호출
function fn_callPopBuyer(target, row, col) {
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	// 아이템 조회
	strSearch = (colLang == "en") ? "DISTINCT(BUYR_ID) AS CD, BUYR_NM_EN AS CD_NM"
			: "DISTINCT(BUYR_ID) AS CD, BUYR_NM AS CD_NM";
	strFrom = "PARTN_BUYR_INFO";
	strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
	strOrderby = "BUYR_ID";
	strIf1 = "BUYR_ID";
	strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
	$("#exampleModalCenterTitleCmmn").text(colBuyrCd);

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
		$("#buyer_srch1").val(data.cd);
	});
};


function fn_showPurchaseFilePop(){
	if($("#fileBuyerPopupPc").length>1){
		$("#fileBuyerPopupPc").eq(1).model("show");
		$("#fileBuyerPopupPc").eq(0).model("show");
	} 
	$("#fileBuyerPopupPc").modal("show");
}

function fn_saveFileBuyer(){
	var file = $("#infoFilesBuyer").prop("files")[0];

	/*if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}*/
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoFormBuyer'));
	
	$.ajax({
		type: 'POST',
		url: "/base/saveBuyerFiles.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success : function(data) {
			buyerHot.loadData([]);
			buyerHot.loadData(data.resultList);
			
			$("#fileBuyerPopupPc").modal("hide");
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