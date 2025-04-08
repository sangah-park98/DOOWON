var purchaseHot;
var purchaseSettings;
var purchasePopupSettings;
var purchaseIndex = 9999;
var purchaseScrollTp = true;
var purchaseData = {};
var natSelect = [];
var incotermsSelect = [];
var thisNatCd = '';
var thisTaxbilNo = '';
var thisCustomImpNo = '';

var numberValidator = function (value, callback) {
	var tmpStr='';
	var valueStr = (''+value).replace(/\s/g, '');
	for(var i = 0 ; i<valueStr.length; i++){
		tmpStr =valueStr.substring(i, i+1);
		if(    tmpStr == '0' || tmpStr == '1' || tmpStr == '2'
                        || tmpStr == '3' || tmpStr == '4' || tmpStr == '5'
                        || tmpStr == '6' || tmpStr == '7' || tmpStr == '8'
                        || tmpStr == '9' || tmpStr == ',' || tmpStr == '.'){

		}else{
			callback(false);
			break;
		}
		callback(true);
	}

};

$( document ).ready(function() {
	  //달력 사용시 반드시 넣어주세요.
      $('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);
	  plntCdList = plntCdList.replace('[','').replace(']','');
	  plntSelect = plntCdList.split(', ');

	  ftaCdList = ftaCdList.replace('[','').replace(']','');
	  ftaSelect = ftaCdList.split(', ');

	  natCdList = natCdList.replace('[','').replace(']','');
	  natSelect = natCdList.split(', ');


	  crncyList = crncyList.replace('[','').replace(']','');
	  crncySelect = crncyList.split(', ');

	  incotermsList = incotermsList = incotermsList.replace('[','').replace(']','');
	  incotermsSelect =  incotermsList = incotermsList.split(', ');

	  var date = new Date();
	  var month = date.getMonth();
	  
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'/');
	  
	  $("#purchase_srch7").val(mtoday);
	  $("#purchase_srch8").val(today);
	  
	  var purchaseElement = document.querySelector('#purchaseTable');
	  var purchaseElementContainer = purchaseElement.parentNode;


	  purchaseHot = new Handsontable(purchaseElement, purchaseSettings);

	  $("#purchase_div1").show();
	  $("#purchase_div2").show();
	  $("#purchase_div3").hide();
	  $("#purchase_div4").hide();
	  $("#btnPurchaseSave").hide();
	  $("#purchInfo1").hide();
	  $("#purchInfo2").hide();
	  fn_changePurchase('read');

	  //팝업모달
	  var purchasePopupElement = document.querySelector('#popUsedTable');
	  var purchasePopupElementContainer = purchasePopupElement.parentNode;
	  purchasePopupSettings = fn_handsonGridPurchPopupOption() ;
	  jdgmntUsageHot = new Handsontable(purchasePopupElement, purchasePopupSettings);
	 
	  
	  //scroll 이벤트
	  fn_purchasEventReg();
	  purchaseUseEventReg();
	  
	
		$("#docBtn").append('<button class="btn btn-primary" style="display: inline-block; padding-right: 10px;	type="button" onclick="fn_DOFtaSelectPopup();">'+colDOEnrol+'</button>');
	  fn_purchExcelSrch("01");
	  
	  
		$("#purchUseExTit").val(colJdgmntUse);
		$("#purchUseExCol").val(String([colItemAllCd,colItemNm,colBuyrNm,colBuyrNo,colJdgmntDt,colUsedQty])+",");
		$("#purchUseExCd").val("itemCd,itemNm,buyrNm,salesNo,jdgmntDt,purchaseQty,");
		$("#purchUseExType").val("cd,cd,cd,cd,cd,floatString,");
	


	  $(document).on("click", '.itemCdClass', function(){
		  alert($(this).index());
	  });
});
/** 이벤트 Start **/

$(document).mousedown(function(e){
	if(e.target.name == "purchase1_date" || e.target.name == "purchase2_date"){
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

$("input:radio[name=purchase_srch20]").change(function(){
	$("input[name=purchaseType][value=read]").prop("checked", true);
	fn_changePurchase("read");
})

//검색구분 변경
$("input[name=purchase_srch1]").change(function(){

	  //fn_changePurchaseType($(this).val());
	  fn_purchExcelSrch($(this).val())
	  fn_typeHook($(this).val());
	  fn_changePurchase($("#purchaseType").val());
});

//테이블 타입 변경
$("input[name=purchaseType]").change(function(){
	  fn_changePurchase($(this).val());
});

//정렬항목
$("select[name=alignPurchase]").change(function(){
	  fn_searchPurchase();
});

//row 수
$("select[name=purchasePageCnt]").change(function(){
	  fn_searchPurchase();
});

$("input[name=ftaCdAll]").change(function(){
	 if ($(this).prop("checked") == true) {
		 for(var i=1; i < ftaCdList.match(/,/g).length+2; i++){
			 $("input[name=ftaCd"+i+"]").prop("checked", true);
		 }
	 } else {
		 for(var i=1; i < ftaCdList.match(/,/g).length+2; i++){
			 $("input[name=ftaCd"+i+"]").prop("checked", false);
		 }
	 }
});

$("#leftQty").mouseover(function(){

})

$("body").on("click", "input:checkbox",function(){

})

function fn_purchasEventReg(){
	
 $("#purchaseTable .wtHolder").scroll(function(){
	  	  var scrollTop = $("#purchaseTable .wtHolder").scrollTop();
	  	  var countPerPage = $("#purchasePageCnt option:selected").val();
	  	  var rowHeight = purchaseHot.getRowHeight();

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

	  	  if(purchaseScrollTp && purchaseIndex != 9999 && scrollTop >= (countPerPage * purchaseIndex * rowHeight) + addCnt){
	  		  fn_purchaseScroll();
	  	  }
	  });

}
//popUp table scroll 이벤트

function purchaseUseEventReg(){
	

$("#popUsedTable .wtHolder").scroll(function(){
	  fn_popUsedStories(row, col)
	  var data = purchaseHot.getSourceData();
	  var scrollTop = $("#popUsedTable .wtHolder").scrollTop();
	  var countPerPage = 50;
	  var rowHeight = jdgmntUsageHot.getRowHeight();
	  var addCnt = 790;

//	  var addCnt = 790;
//	  if(countPerPage == "50"){
//		  addCnt = 790;
//	  }else if(countPerPage == "100"){
//		  addCnt = 2040;
//	  }else if(countPerPage == "200"){
//		  addCnt = 3290;
//	  }else if(countPerPage == "500"){
//		  addCnt = 4540;
//	  }

	  if(purchasePopScrollTp && purchaseIndex != 9999 && scrollTop >= (countPerPage * purchaseIndex * rowHeight) + addCnt){
		  fn_purchasePopScroll(data[row]);
	  }
});

}
/** 이벤트 End **/
//스크롤
function fn_purchaseScroll(){
	if( $("input[name=purchaseType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	purchaseScrollTp = false;
	purchaseIndex++;

	$.ajax({
		type : "POST",
		url : "/base/selectPurchaseList.do",
		data : fn_setPurchaseForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = purchaseHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	purchaseHot.loadData(meargeJson);
        	purchaseScrollTp = true;
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

//Popup 테이블 스크롤
function fn_purchasePopScroll(row){
	purchaseScrollTp = false;
	purchaseIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectUsedForJdgmnt.do",
		data : fn_searchPurchasePop(row),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = jdgmntUsageHot.getSourceData();
        	var meargeJson = getData.concat(data.usedList);
        	jdgmntUsageHot.loadData(meargeJson);

        	purchaseScrollTp = true;
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


//검색
function fn_searchPurchase(){
	purchaseIndex = 0;
	$("#purchSrch2").val($("#purchase_srch2").val());
	$("#purchSrch3").val($("#purchase_srch3").val());
	$("#purchSrch4").val($("#purchase_srch4").val());
	$("#purchSrch5").val($("#purchase_srch5").val());
	$("#purchSrch6").val($("#purchase_srch6").val());
	$("#purchSrch7").val($("#purchase_srch7").val());
	$("#purchSrch8").val($("#purchase_srch8").val());
	$("#purchSrch9").val($("#purchase_srch9").val());
	$("#purchSrch10").val($("#purchase_srch10").val());
	$("#purchSrch12").val($("#purchase_srch12").val());
	$("#purchSrch13").val($("#purchase_srch13").val());
	$("#purchSrch11").val($("input:radio[name=purchase_srch11]:checked").val());
	$("#purchSrch21").val($("input:radio[name=purchase_srch21]:checked").val());

	var data = fn_setPurchaseForm();
	var valid = fn_validateSearchDate(data["srch7"], data["srch8"]);
	
	console.log(data);

	if(valid === "false"){
		data["srch7"] = null;
		data["srch8"] = null;
		$("#purchase_srch7").val("");
		$("#purchase_srch8").val("");
		return;
	} else {
		data["srch7"] = $("#purchase_srch7").val();
		data["srch8"] = $("#purchase_srch8").val();
	}
	fn_loading(true);

	$.ajax({
		type : "POST",
		url : "/base/selectPurchaseList.do",
		data : fn_setPurchaseForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=purchaseType]:checked").val() == "enrol"){
        		purchaseHot.loadData([]);
        		purchaseHot.alter('insert_row', 1, 1);
        	}else{
        		purchaseHot.loadData([]);
            	purchaseHot.loadData(data.resultList);
            	$("#purchaseCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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


function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchPurchase();
    }
}

//판정 사용 내역 조회


//검색조건 생성
function fn_setPurchaseForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=purchase_srch1]:checked").val();
	sData["srch2"] = $("#purchase_srch2").val();
	sData["srch3"] = $("#purchase_srch3").val();
	sData["srch4"] = $("#purchase_srch4").val();
	sData["srch5"] = $("#purchase_srch5").val();
	sData["srch6"] = $("#purchase_srch6").val();
	sData["srch7"] = $("#purchase_srch7").val();
	sData["srch8"] = $("#purchase_srch8").val();
	sData["srch9"] = $("#purchase_srch9").val();
	sData["srch10"] = $("#purchase_srch10").val();
	sData["srch12"] = $("#purchase_srch12").val();
	sData["srch13"] = $("#purchase_srch13").val();
	sData["srch11"] = $("input:radio[name=purchase_srch11]:checked").val();
	sData["srch20"] = $("input:radio[name=purchase_srch20]:checked").val();
	sData["srch21"] = $("input:radio[name=purchase_srch21]:checked").val();
	sData["alignItem"] = $("#alignPurchase option:selected").val();
	sData["recordCountPerPage"] = $("#purchasePageCnt option:selected").val();
	sData["pageIndex"] = purchaseIndex;
	return sData;
};

//검색조건 초기화
function fn_clearPurchase(){
	$("#purchase_srch2").val("");
	$("#purchase_srch3").val("");
	$("#purchase_srch4").val("");
	$("#purchase_srch5").val("");
	$("#purchase_srch6").val("");
	$("#purchase_srch7").val("");
	$("#purchase_srch8").val("");
	$("#purchase_srch9").val("");
	$("#purchase_srch10").val("");
	$("#purchase_srch12").val("");
	$("#purchase_srch13").val("");
	$("input:radio[name = 'purchase_srch21']:radio[value = '']").prop("checked", true);
//
//	$("#purchase_div1").show();
//	$("#purchase_div2").show();
//	$("#purchase_div3").hide();
//	$("#purchase_div4").hide();
//	$("#purchase_span1").text(colPurchLedgrInfo);
};

//저장버튼 클릭
function fn_savePurchaseCheck(){
	if(purchaseHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	console.log(purchaseHot.getData());
	fn_validatePurchase();
};

//정합성 체크
function fn_validatePurchase(){
	purchaseHot.validateCells(function(result) {
		if(result){
			fn_savePurchaseData();
		}else{
			alert(msgSaveCheck);
			if($("input:radio[name=purchase_srch1]:checked").val()=="01"){
				if($("input:radio[name=purchaseType]:checked").val()=="enrol"){
					if(purchaseHot.getDataAtCell(0,1)==null){
						purchaseHot.setDataAtCell(0, 1, '');
					}
					if(purchaseHot.getDataAtCell(0,4)==null){
						purchaseHot.setDataAtCell(0, 4, '');
					}
				}
			}

			purchaseHot.render();
		}
    });
};

/*//저장
function fn_savePurchaseData(){
	if(!confirm(msgSaveConfirm)){
		return;
	}

	var savePurchaseData = purchaseHot.getSourceData();
	var srchType = $("input:radio[name=purchase_srch1]:checked").val();
	for(var i=0; i<savePurchaseData.length; i++){
		savePurchaseData[i]["srchTp"] = srchType;
	}

	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/savePurchaseInfo.do",
		data : JSON.stringify(savePurchaseData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if( $("input:radio[name=purchaseType]:checked").val() == 'enrol'){
            		$("input:radio[name=purchaseType]")[0].checked = true;
    				fn_changeFtaTreatyTable($("input[name=purchaseType]:checked").val());
        		}
        		$("input:radio[name=purchaseType]:input[value='read']").trigger("click");
        		fn_searchPurchase();
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
};*/

//테이블 컬럼
function fn_purchTableCol(){
	var tableType = $("input:radio[name=purchaseType]:checked").val();
	// 사용여부
	var purchase_srch20 = $("input:radio[name=purchase_srch20]:checked").val(); 
	

	var purchPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var rightPurchPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","right").append(value);
	};

	//item 팝업
	var purchaseItemCdRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var targetTp = (prop == "itemCd") ? 1 : 2;
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopPurchase('+targetTp+','+row+','+col+')"></i>');
		$(td).empty().append($button).append("  " +  (value != null) ? value : "");
		if(value == ""){
			$(td).addClass("htInvalid");
		}
	};

	//
	var purchaseDocuRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var targetTp = (prop == "itemCd") ? 1 : 2;
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_docuViewCall('+targetTp+','+row+','+col+')"></i>');
		$(td).empty().append($button).append("  " + value);
	};

	//문서 다운로드 업로드
	var docuFileLoadRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		if(tableType == "read"){
			$fileButton = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_fileUpDown('+row+','+col+')"></i>');
			if(value != '' || value != null){
				$(td).empty().append($fileButton).append("  " +value);
			}
		}else{
			var $fileButton = $('<i class="search-icon text-muted i-Add-File" style="cursor:pointer;" onclick="fn_fileUpDown('+row+','+col+')"></i>');
			$(td).empty().append($fileButton).append("  " + value);
		}
	};

    var usedQtyRenderer = function (instance, td, row, col, prop, value, cellProperties) {
    	if (value ==null || Number(value)==0 ) {
    		$(td).empty().append($button).append("");
    	} else {
    		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" id="buttonPop" style="cursor:pointer;" onclick="fn_popUsedStories('+row+','+col+')"></i>');
    		$(td).empty().append(value+"	").append($button).css("text-align", "right");
    	}
	};


	this.purchCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		//{data : 'purchaseCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: 'yes',uncheckedTemplate: 'no', readOnly:false},   //0
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", renderer:purchPkNoneEdit, readOnly: true}, //1
		{data : 'vndrCd', type : 'text', width: 150, className:"htCenter",renderer:purchPkNoneEdit, readOnly: true}, //2
	    {data : 'purchaseNo', type : 'text', width: 150, className : "htCenter", renderer:purchPkNoneEdit, readOnly: true}, //3
	    {data : 'purchaseOrdr', type : 'text', width: 150, className : "htCenter", renderer:purchPkNoneEdit, readOnly: true}, //4
	    {data : 'itemCd', type : 'text', width: 150, className : "htCenter", renderer:purchPkNoneEdit, readOnly: true}, //5
//	    {data : 'hsCd', type : 'text', width : 150, className: 'htCenter', validator : fn_hsCdCheck},
/*	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback) { thisTaxbilNo = value; thisNatCd.substring(0, 2)=='VN' && thisCustomImpNo==null?callback(notEmpty(value, 20)):callback(true); } }, //13
*/	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter" }, //13
	    {data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator: notEmptyDataCheck}, //14
	    {data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,200}$)/},  //21
	   /* {data : 'blNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,30}$)/}, //15*/
/*	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback) { thisCustomImpNo = value; if (thisNatCd != null){	if (thisNatCd.substring(0, 2)=='VN') { if (thisTaxbilNo==null) { callback(notEmpty(value, 20)); } else { callback(true); } } else { callback(notEmpty(value, 20)); } } else { callback(true); }} }, //16
*/	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter"}, //16
	    {data : 'stndrdNo', type : 'text', width: 150, validator : /(^[\s\S]{0,100}$)/}, //18
	    {data : 'natCd', editor : 'select',selectOptions : natTyList, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 2))}}, //19
	    //{data : 'natCd', editor : 'select',selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter",validator : function(value, callback) { thisNatCd=value; callback(selectboxCheck(value,this.selectOptions)); }}, //19
	    {data : 'purchaseQty', width: 140, type : 'text', className : "htRight", /*numericFormat : {pattern : '0,0'},*/ validator : function(value, callback){callback(notEmpty(value, 20))}}, //22 asas
	    //{data : 'qtyUnt', type : 'text', className:"htCenter"}, //25
	    {data : 'incoterms', editor : 'select', selectOptions : incotermsSelect, type : 'autocomplete', className : "htCenter", width: 150,validator : function(value, callback) {callback(emptySelectboxCheck(value,this.selectOptions))}}, //31
	    {data : 'purchasePriceVn', width: 250, type : 'text', className: "htRight"}, //26
	    {data : 'crrncyUnt', editor : 'select',selectOptions : crncyTyList, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter"}, //29
	    {data : 'exchngRt', width: 120, type : 'text', className : "htRight"}, //30 asas
	    {data : 'purchasePriceFr', width: 160, type : 'text', className: "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}}, //27
	    {data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 100,validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
	] : (tableType == "read" && purchase_srch20 == "N") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'purchaseCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: 'yes',uncheckedTemplate: 'no', readOnly:false},   //0
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}, renderer:purchaseDocuRenderer},
		{data : 'vndrCd', type : 'text', width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}, className:"htCenter", readOnly:true},
	    {data : 'purchaseNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
	    {data : 'purchaseOrdr', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
	    {data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly:true}, //
	    {data : 'itemNm', type : 'text', width: 150, className : "htleft", readOnly:true}, //
//	    {data : 'hsCd', type : 'text', width : 150, className: 'htCenter'}, //12
	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter"}, //13
	    {data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator: notEmptyDataCheck}, //14
	    {data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/},  //21
	   /* {data : 'blNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,30}$)/}, //15
*/	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/}, //16
	    {data : 'stndrdNo', type : 'text', width: 150, validator : /(^[\s\S]{0,20}$)/}, //18
	    {data : 'natCd', editor : 'select',selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter",validator : function(value, callback) { thisNatCd=value; callback(selectboxCheck(value,this.selectOptions)); }}, //19
	    {data : 'purchaseQty', width: 140, type : 'text', className : "htRight", /*numericFormat : {pattern : '0,0'},*/ validator : function(value, callback){callback(notEmpty(value, 20))}}, //22 asas
	    {data : 'usedQty', width: 150, type : 'numeric', className: 'htRight', numericFormat : {pattern : '0,0.00'}, renderer:usedQtyRenderer} , //23
	    {data : 'leftQty', width: 120, type : 'numeric', numericFormat : {pattern : '0,0.00'}, className:'htRight'}, //24
	    //{data : 'qtyUnt', type : 'text', className:"htCenter"}, //25
	    {data : 'incoterms', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(lengthcheck(value, 3))}}, //31
	    {data : 'purchasePriceVn', width: 250, type : 'text', className: "htRight"}, //26
	    {data : 'crrncyUnt', editor : 'select',selectOptions : crncySelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter"}, //29
	    {data : 'exchngRt', width: 120, type : 'text', className : "htRight"}, //30 asas
	    {data : 'purchasePriceFr', width: 160, type : 'text', className: "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}}, //27
	    {data : 'purchaseCifPrice', width: 160, type : 'text', /*numericFormat: {pattern : '0,0.00'},*/ className: "htRight"}, //28 asas
	    {data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	//	{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : (tableType == "read" && purchase_srch20 == "Y" ) ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		/*{data : 'purchaseCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: 'yes',uncheckedTemplate: 'no', readOnly:false},   //0
*/		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}, renderer:purchaseDocuRenderer},
		{data : 'vndrCd', type : 'text', width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}, className:"htCenter", readOnly:true},
	    {data : 'purchaseNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
	    {data : 'purchaseOrdr', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
	    {data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly:true}, //
	    {data : 'itemNm', type : 'text', width: 150, className : "htleft", readOnly:true}, //
//	    {data : 'hsCd', type : 'text', width : 150, className: 'htCenter'}, //12
	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter"}, //13
	    {data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator: notEmptyDataCheck}, //14
	    {data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/},  //21
	   /* {data : 'blNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,30}$)/}, //15
*/	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/}, //16
	    {data : 'stndrdNo', type : 'text', width: 150, validator : /(^[\s\S]{0,20}$)/}, //18
	    {data : 'natCd', editor : 'select',selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter",validator : function(value, callback) { thisNatCd=value; callback(selectboxCheck(value,this.selectOptions)); }}, //19
	    {data : 'purchaseQty', width: 140, type : 'text', className : "htRight", /*numericFormat : {pattern : '0,0'},*/ validator : function(value, callback){callback(notEmpty(value, 20))}}, //22 asas
	    {data : 'usedQty', width: 150, type : 'numeric', className: 'htRight', numericFormat : {pattern : '0,0.00'}, renderer:usedQtyRenderer} , //23
	    {data : 'leftQty', width: 120, type : 'numeric', numericFormat : {pattern : '0,0.00'}, className:'htRight'}, //24
	    //{data : 'qtyUnt', type : 'text', className:"htCenter"}, //25
	    {data : 'incoterms', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(lengthcheck(value, 3))}}, //31
	    {data : 'purchasePriceVn', width: 250, type : 'text', className: "htRight"}, //26
	    {data : 'crrncyUnt', editor : 'select',selectOptions : crncySelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter"}, //29
	    {data : 'exchngRt', width: 120, type : 'text', className : "htRight"}, //30 asas
	    {data : 'purchasePriceFr', width: 160, type : 'text', className: "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}}, //27
	    {data : 'purchaseCifPrice', width: 160, type : 'text', /*numericFormat: {pattern : '0,0.00'},*/ className: "htRight"}, //28 asas
	    {data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	//	{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'vndrCd', type : 'text', width: 150, validator : function(value, callback){callback(notEmpty(value, 100))}, className:"htCenter", renderer : purchaseItemCdRenderer},
	    {data : 'purchaseNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
	    {data : 'purchaseOrdr', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
	    {data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, renderer:purchaseItemCdRenderer}, //
/*	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback) { thisTaxbilNo = value; thisNatCd.substring(0, 2)=='VN' && thisCustomImpNo==null?callback(notEmpty(value, 20)):callback(true); } }, //13
*/	    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter" }, //13
	    {data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator: notEmptyDataCheck}, //14
	    {data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,200}$)/},  //21
//    	{data : 'blNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,30}$)/}, //15
/*	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback) { thisCustomImpNo = value; if (thisNatCd != null){	if (thisNatCd.substring(0, 2)=='VN') { if (thisTaxbilNo==null) { callback(notEmpty(value, 20)); } else { callback(true); } } else { callback(notEmpty(value, 20)); } } else { callback(true); }} }, //16
*/	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter"}, //16
	    {data : 'stndrdNo', type : 'text', width: 150, validator : /(^[\s\S]{0,100}$)/}, //18
	    {data : 'natCd', editor : 'select',selectOptions : natTyList, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 2))}}, //19
	    //{data : 'natCd', editor : 'select',selectOptions : natSelect, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter",validator : function(value, callback) {console.log(value); thisNatCd=value; callback(selectboxCheck(value,this.selectOptions)); console.log(this.selectOptions) ; }}, //19
	    {data : 'purchaseQty', width: 140, type : 'text', className : "htRight", /*numericFormat : {pattern : '0,0'},*/ validator : function(value, callback){callback(notEmpty(value, 20))}}, //22 asas
	    //{data : 'qtyUnt', type : 'text', className:"htCenter"}, //25
	    {data : 'incoterms', editor : 'select', selectOptions : incotermsSelect, type : 'autocomplete', className : "htCenter", width: 150,validator : function(value, callback) {callback(emptySelectboxCheck(value,this.selectOptions))}}, //31
	    {data : 'purchasePriceVn', width: 250, type : 'text', className: "htRight"}, //26
	    {data : 'crrncyUnt', editor : 'select',selectOptions : crncyTyList, type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter"}, //29
	    {data : 'exchngRt', width: 120, type : 'text', className : "htRight"}, //30 asas
	    {data : 'purchasePriceFr', width: 160, type : 'text', className: "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}}, //27
	];

	this.purchOrgCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter",type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 150, renderer:purchPkNoneEdit, readOnly:true},
		{data : 'vndrCd', type: 'text', renderer:purchPkNoneEdit, readOnly:true},
		{data : 'purchaseNo', type: 'text', className: 'htCenter', renderer:purchPkNoneEdit, readOnly:true},
		{data : 'purchaseOrdr', type: 'numeric', renderer:purchPkNoneEdit, readOnly:true},
		{data : 'itemCd', type: 'text', renderer:purchPkNoneEdit, readOnly:true},
		{data : 'purchaseDt', type : 'date', className : "htCenter", dateFormat: gridCalFormat, renderer:purchPkNoneEdit , readOnly:true},
		{data : 'taxbilNo', type : 'text', className : "htCenter", renderer:purchPkNoneEdit , readOnly:true }, 
		{data : 'customImpNo', type : 'text', className : "htCenter", renderer:purchPkNoneEdit , readOnly:true},
		{data : 'ftaCd', editor: 'select', selectOptions: ftaSelect, type : 'autocomplete', renderer:purchPkNoneEdit, readOnly:true},
		{data : 'hsVer', type: 'text', className:'htCenter', renderer: purchPkNoneEdit, readOnly: true},
		{data : 'hsCd', type : 'text', className : 'htCenter', renderer: purchPkNoneEdit, readOnly: true},
		{data : 'psrSumry', type: 'text', className:"htCenter", validator : function(value, callback){
			console.log("col : "+this.col+" row : "+this.row )
			console.log(purchaseHot.getDataAtCell(this.row, this.col+5))
			if(purchaseHot.getDataAtCell(this.row, this.col+5) == colConfm){
				if(value == null || value == ""){
					return callback(false);
				}
				if(((String(value)).trim()).length > 0 && ((String(value)).trim()).length <= 10){
					return callback(true);
				} else {
					return callback(false);
				}
			} else {
				return callback(true);
			}
		}},
		{data : 'reqDtm', className: 'htCenter', renderer: purchPkNoneEdit, readOnly: true},
		{data : 'docuName',type: 'text'},
		{data : 'docuOrgFile', type: 'text', renderer:docuFileLoadRenderer, readOnly:true},
		{data : 'originYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter"},
		/*{data : 'judgmntCmmnts', type:'text'},*/
		{data : 'approvedState', editor : 'select', selectOptions : [colPendency, colConfmRequst, colConfm, colConfmReject], type : 'autocomplete', className : "htCenter"},
		{data : 'recvDtm', type: 'date', className: 'htCenter', dateFormat: gridCalFormat},
		{data : 'stateMsg',type: 'text'},
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter",type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', type : 'text', className : 'htCenter'},
		{data : 'vndrCd', type: 'text', className : 'htCenter'},
		{data : 'purchaseNo', type: 'text', className: 'htCenter'},
		{data : 'purchaseOrdr', type: 'numeric', className: 'htCenter'},
		{data : 'itemCd', type : 'text', className : 'htCenter'},
		{data : 'itemNm', type: 'text'},
		{data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter"},
		{data : 'taxbilNo', type : 'text', className : "htCenter" }, 
		{data : 'customImpNo', type : 'text', className : "htCenter" }, 
		{data : 'ftaCd', type : 'text', className : 'htCenter'},
		{data : 'hsVer', type: 'text', className:'htCenter'},
		{data : 'hsCd', type : 'text', className : 'htCenter'},
		{data : 'psrSumry', type: 'text', className:"htCenter"},
		{data : 'reqDtm', className: 'htCenter', readOnly: true},
		{data : 'docuName',type: 'text'},
		{data : 'docuOrgFile', type: 'text', renderer:docuFileLoadRenderer, readOnly:true},
		{data : 'originYn', type : 'text', className : 'htCenter'},
		/*{data : 'judgmntCmmnts', type:'text'},*/
		{data : 'approvedState', editor : 'select', selectOptions : [colPendency, colConfmRequst, colConfm, colConfmReject], type : 'autocomplete', className : "htCenter"},
		{data : 'recvDtm', type: 'date', className: 'htCenter', dateFormat: gridCalFormat},
		{data : 'stateMsg',type: 'text'},
	] ;
		
		this.purchUseCol =  [
			{data : 'plntCd', editor : 'select', type : 'autocomplete', className : "htCenter", width: 150, className : "htCenter"},
			{data : 'vndrCd', type : 'text', width: 150, validator : function(value, callback){callback(notEmpty(value, 20))}, className:"htCenter", readOnly:true},
		    {data : 'purchaseNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		    {data : 'purchaseOrdr', type : 'text', width: 120, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		    {data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, readOnly:true}, //
//		    {data : 'hsCd', type : 'text', width : 150, className: 'htCenter'}, //12
		    {data : 'taxbilNo', type : 'text', width: 150, className : "htCenter"}, //13
		  
		    {data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator: notEmptyDataCheck}, //14
		    {data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/},  //21
		   /* {data : 'blNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,30}$)/}, //15
	*/	    {data : 'customImpNo', type : 'text', width: 150, className : "htCenter", validator : /(^[\s\S]{0,20}$)/}, //16
			{data : 'salesNo', type : 'text', width: 150, className : "htCenter"}, //13
		    {data : 'purchaseQty', width: 120, type : 'text', className : "htRight", /*numericFormat : {pattern : '0,0'},*/ validator : function(value, callback){callback(notEmpty(value, 20))}}, //22 asas
		   /* {data : 'usedQty', width: 150, type : 'numeric', className: 'htRight', numericFormat : {pattern : '0,0.00'}, renderer:usedQtyRenderer} , //23
		    {data : 'leftQty', width: 90, type : 'numeric', numericFormat : {pattern : '0,0.00'}, className:'htRight'}, //24
*/		    //{data : 'qtyUnt', type : 'text', className:"htCenter"}, //25
		]   ;

	//판정 사용 내역 컬럼
}
//테이블 헤더
function fn_purchTableHeader(){
	var tableType = $("input:radio[name=purchaseType]:checked").val(); //20201221 박은식 테이블 모드 값(plnt 코드, 명 조건문 처리를 위함)
	// 사용여부
	var purchase_srch20 = $("input:radio[name=purchase_srch20]:checked").val(); 
	

	this.purchHeader = (tableType == "edit") ? [
		"saveCheck",
		/*"<input type='checkbox'  class='checker' id='id_checkPurchaseAll' onclick='fn_purchaseAllClick();' >",*/
		colPlntCd+"*" ,colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*"/*,colHsCd*/,colTaxbilNo,colPurchaseDt+"*",colInvoiceNo, /*20201221 박은식 일기모드일 때 plntNm*/
        colCustomImpNo/*,colSheetNo*/,colStndrdNo,colNatCd+"*"/*,colCoNo*/,colPurchaseQty+"*"/*,colQtyUnt*/,//colPurchPriceCif+"(VND)",
        colInctrm,colPuchaseAmt,colCurrentUnt,colExchngRt,colPurchaseAmtVn+"*",colDelYn
	] : (tableType == "read" && purchase_srch20 == "Y") ? [
		"saveCheck",
		/*"<input type='checkbox'  class='checker' id='id_checkPurchaseAll' onclick='fn_purchaseAllClick();' >",*/
		  colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*"/*,colHsCd*/,colItemNm,colTaxbilNo,colPurchaseDt+"*",colInvoiceNo, /*20201221 박은식 일기모드일 때 plntNm*/
	      colCustomImpNo/*,colSheetNo*/,colStndrdNo,colNatCd+"*"/*,colCoNo*/,colPurchaseQty+"*",colUsedQty,colLeftQty/*,colQtyUnt*/,
	      colInctrm/*면장정보 있으면 필수*/,colPuchaseAmt,  colCurrentUnt,colExchngRt,colPurchaseAmtVn+"*",    colPurchPriceCif+"(VND)",colRegDt/*,colEdtDt*/
	 ] : (tableType == "read" && purchase_srch20 == "N") ? [
		"saveCheck",
		"<input type='checkbox'  class='checker' id='id_checkPurchaseAll' onclick='fn_purchaseAllClick();' >",
		  colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*"/*,colHsCd*/,colItemNm,colTaxbilNo,colPurchaseDt+"*",colInvoiceNo, /*20201221 박은식 일기모드일 때 plntNm*/
	      colCustomImpNo/*,colSheetNo*/,colStndrdNo,colNatCd+"*"/*,colCoNo*/,colPurchaseQty+"*",colUsedQty,colLeftQty/*,colQtyUnt*/,
	      colInctrm/*면장정보 있으면 필수*/,colPuchaseAmt,  colCurrentUnt,colExchngRt,colPurchaseAmtVn+"*",    colPurchPriceCif+"(VND)",colRegDt/*,colEdtDt*/
	] : [
		"saveCheck",
		colPlntCd+"*" ,colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colTaxbilNo,colPurchaseDt+"*",colInvoiceNo, /*20201221 박은식 일기모드일 때 plntNm*/
        colCustomImpNo/*,colSheetNo*/,colStndrdNo,colNatCd+"*"/*,colCoNo*/,colPurchaseQty+"*"/*,colQtyUnt*//*,colPurchPriceCif+"(VND)"*/
        ,colInctrm,colPuchaseAmt,colCurrentUnt,colExchngRt,colPurchaseAmtVn+"*",
	];

	this.purchOrgHeader = (tableType == "edit") ? [
		"saveCheck",
		colPlntCd+"*",colVndrCd+"*",colPurchaseNo+"*",colPurchaseOrdr+"*",colItemAllCd+"*",colPurchaseDt,colTaxbilNo,colCustomImpNo,colFtaCd+"*",colHsVer,colHsCd,
		colPsr+"*",colReqDtm,colFileNm,colDocuFile,colOriginYn,colConfmSttus,colRecvDt,colStateMsg,colDelYn
	] : [
		"saveCheck",
		colPlntCd+"*",colVndrCd+"*",colPurchaseNo+"*",colPurchaseOrdr+"*",colItemAllCd+"*",colItemNm,colPurchaseDt,colTaxbilNo,colCustomImpNo,colFtaCd+"*",colHsVer,colHsCd,
		colPsr+"*",colReqDtm,colFileNm,colDocuFile,colOriginYn,colConfmSttus,colRecvDt,colStateMsg
	]  ;
		
		
	this.purchUseHeader =  [
		  colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*"/*,colHsCd*/,colTaxbilNo,colPurchaseDt+"*",colInvoiceNo, /*20201221 박은식 일기모드일 때 plntNm*/
	      colCustomImpNo,colSalesNo/*,colCoNo*/,colUsedQty+"*"/*,colUsedQty,colLeftQty*//*,colQtyUnt*/
	      ]  ;
	//판정 사용 내역 헤더
}

//테이블 히든컬럼
function fn_purchTableHidden(){
	var tableType = $("input:radio[name=purchaseType]:checked").val();
	this.purchHidden = [0];

	this.purchOrgHidden = [0];
}

//table
function fn_handsonGridPurchOption(col, header, hidden){
	var tableType = $("input:radio[name=purchaseType]:checked").val();

	purchaseSettings = {
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
	  rowHeights : 25,
	  rowHeaders : true,
	  columnHeaderHeight : 25,
	  manualRowResize : true,
	  manualColumnResize : true,
	  manualRowMove : true,
	  manualColumnMove : false,
	  //dropdownMenu : true,

	  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
	  filters : true,
	  readOnly : (tableType == "read") ? true : false,
	  allowInsertRow : true,
	  allowRemoveRow : true,
	 // columnSorting : {indicator : true},
      autoColumnSize : {samplingRatio : 23},
      mergeCells : false,
      wordWrap : true,
      //numeric은 엑셀 copy & paste 에러가 있어 직접 처리해줘야함 아래의 로직이 해당 처리 로직 START
      beforeChange: function (changes, source) {
		if(changes != null){
			//maxlength
			for (i = 0; i < changes.length; i++) {
				
				var savePurchaseData = purchaseHot.getSourceData();
				
				var row = changes[i][0]; //0 변경셀의 row
				var col = changes[i][1]; //1 변경셀의 col
				var meta = this.getCellMeta(row, col);
				if(col == "purchaseQty" || col == "purchasePriceVn" || col == "purchasePriceFr" || col == "exchngRt" || col == "purchaseQty"){
					var data = fn_numericFormat(changes[i][3].replace(/,/gi, "")); //3 변경 데이터
					//height change
//					if(row>8 && _height1<310 && data != null && data != ''){
//						_height1=500;
//						tRefriSaleIncome_Handsontable.updateSettings({
//							height:  _height1
//						});
//					}

					//replace \n
					changes[i][3] = (''+data).replace(/\s+/, '')
		                                            .replace(/\s+$/g, '')
		                                            .replace(/\n/g, '')
		                                            .replace(/\r/g, '')
		                                            .replace(/(\n|\r\n)/gm, '');
					data = changes[i][3];
					if(col == "exchngRt"){
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
					}

					//maxlength
	                if(col != null && col =="numberColumn"  ){
						changes[i][3] = (''+data).replace(/,/g, '');
						data = changes[i][3];

						if((''+data).length>10){
							changes[i][3] = (''+data).substring(0, 10);
						}
					}
				} else if(col == "purchaseDt"){
  					var data = changes[i][3].replaceAll("-", "");
  					changes[i][3] = dateFormChange(fn_dateColForm(data));
  				} else {
					return;
				}
			}
		}
      },
      //numeric은 엑셀 copy & paste 에러가 있어 직접 처리해줘야함 해당 처리 로직 END
      afterChange: function(changes, source){
      	if (changes && changes[0][2] !== changes[0][3]){ 
      		/*alert("ROW:"+changes[0][0]+", COLUMN:"+changes[0][1]+", FROM:"+changes[0][2]+", TO:"+changes[0][3]);*/
      		console.log(changes.length);
      		this.setDataAtCell(changes[0][0],0,true); 
      		}
      }
	};

	return purchaseSettings;
}

//Purchase Pop Up
function fn_handsonGridPurchPopupOption(){
	  var jdgmntUsageElement = document.querySelector('#popUsedTable');
	  var jdgmntUsageElementContainer = jdgmntUsageElement.parentNode;

	  purchasePopupSettings = {
			  columns : [
				  {data : 'itemCd', type : 'text', className : "htCenter",   readOnly:true},
				  {data : 'itemNm', type : 'text', className : "htCenter",   readOnly:true},
				  {data : 'buyrNm', type : 'text',  className : "htCenter",   readOnly:true},
				  {data : 'salesNo', type : 'text', className : "htCenter", 	  readOnly : true},
				  {data : 'jdgmntDt', type : 'text', className : "htCenter", readOnly : true},
				  {data : 'purchaseQty', type : 'numeric',  className : "htRight", numericFormat : {pattern : '0,0'}, readOnly : true}
	    	  ],
	    	  stretchH : 'all',
	    	  width : '98.7%',
	    	  autoWrapRow : true,
	    	  height : 250,
	    	  rowHeights : 25,
	    	  rowHeaders : true,
	    	  columnHeaderHeight : 25,
	    	  colHeaders : [
	    		  colItemAllCd,
	    		  colItemNm,
	    		  colBuyrNm,
	    		  colBuyrNo,
	    		  colJdgmntDt,
	    		  colUsedQty
	    	  ],
			  manualRowResize : true,
	    	  manualColumnResize : true,
	    	  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			  dropdownMenu : false,
			  filters : true,
			  readOnly : false,
			  columnSorting : {
				  indicator : true
	          },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	return purchasePopupSettings;
}


//검색 그리드
function fn_searchGridPurchOption(type){
	if(type){
		$("#purchEnrol").show();
		$("#purchase_div1").show();
		$("#purchase_div2").show();
		$("#purchase_div3").hide();
		$("#purchase_div4").hide();
		$("#purchase_div12").hide();
		$("#purchase_div5").show();
		$("#purchase_div6").show();
		$("#purchase_div7").show();
		$("#purchase_div8").show();
		$("#purchInfo1").hide();
		$("#purchInfo2").hide();
		$("#docBtn").show();
		$("#purchase_span1").text(colPurchLedgrInfo);
	}else{
		$("#purchEnrol").hide();
		$("#purchase_div1").show();
		$("#purchase_div2").hide();
		$("#purchase_div3").show();
		$("#purchase_div4").show();
		$("#purchase_div5").hide();
		$("#purchase_div12").hide();
		$("#purchase_div6").show();
		$("#purchase_div7").hide();
		$("#purchase_div8").show();
		$("#purchInfo1").show();
		$("#purchInfo2").show();
		$("#docBtn").hide();
		$("#purchase_span1").text(colOriginCnftmnInfo);
	}
}

function fn_searchGridPurchOption2(){
	
		$("#purchEnrol").show();
		$("#purchase_div1").show();
		$("#purchase_div12").show();
		$("#purchase_div2").hide();
		$("#purchase_div3").hide();
		$("#purchase_div4").hide();
		$("#purchase_div5").hide();
		$("#purchase_div6").hide();
		$("#purchase_div7").hide();
		$("#purchase_div8").hide();
		$("#purchInfo1").hide();
		$("#purchInfo2").hide();
		$("#docBtn").hide();		
		$("#purchase_span1").text(colPurchLedgrInfo);
}

//테이블 타입 변경
function fn_changePurchase(type){

	var searchTp = $("input:radio[name=purchase_srch1]:checked").val();

	if(type == "edit"){
			if(type == "edit" && $('input:radio[name=purchase_srch20]:checked').val() == "Y" && searchTp == "01"){
				alert(msgUsePurchNonEditMsg);
				$("input:radio[name=purchaseType][value=read]").prop("checked", true);
				return;
			}
			$("#btnPurchaseSave").show();
			$("#purExcel").hide();
			$("#btnSave_XmlIm").hide();
			$("#docBtn").children().hide();
			fn_changePurchaseType(searchTp);
	}else if(type == "enrol"){
		if(type == "enrol" && $('input:radio[name=purchase_srch20]:checked').val() == "Y" && searchTp == "01"){
			alert(msgUsePurchNonEnrolMsg);
			$("input:radio[name=purchaseType][value=read]").prop("checked", true);
			return;
		}
			$("#btnPurchaseSave").show();
			$("#purExcel").hide();
			$("#btnSave_XmlIm").show();
			$("#docBtn").children().hide();
			fn_changePurchaseType(searchTp);
	}else{
			purchaseHot.updateSettings({readOnly:true, contextMenu : false});
			$("#btnPurchaseSave").hide();
			$("#purExcel").show();
			$("#btnSave_XmlIm").hide();
			$("#docBtn").children().show();
			fn_changePurchaseType(searchTp);
	}
};

//검색구분 변경
function fn_changePurchaseType(type){
	let purchCol = new fn_purchTableCol();
	let purchHeader = new fn_purchTableHeader();
	let purchHidden = new fn_purchTableHidden();
	var col, header, hidden;

	$('#alignPurchase option:eq(0)').prop('selected', true);

	//구매원장
	if(type == "01"){
		fn_searchGridPurchOption(true);
		col = purchCol.purchCol;
		header = purchHeader.purchHeader;
		hidden = purchHidden.purchHidden;
		purchaseHot.updateSettings(fn_handsonGridPurchOption(col, header, hidden));
	//원산지확인서
	}else if (type == "02"){
		fn_searchGridPurchOption(false);
		col = purchCol.purchOrgCol;
		header = purchHeader.purchOrgHeader;
		hidden = purchHidden.purchOrgHidden;
		purchaseHot.updateSettings(fn_handsonGridPurchOption(col, header, hidden));
	}else if (type == "03"){
		fn_searchGridPurchOption2();
		col = purchCol.purchUseCol;
		header = purchHeader.purchUseHeader;
		hidden = purchHidden.purchUseHidden;
		purchaseHot.updateSettings(fn_handsonGridPurchOption(col, header, hidden));
	}
	fn_searchPurchase();
};

//테이블팝업 호출
function fn_callPopPurchase(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;
	//아이템
	if(target == "itemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	//벤더
	}else{
		strSearch = (colLang == "en") ? "VNDR_ID AS CD, VNDR_NM_EN AS CD_NM" : "VNDR_ID AS CD, VNDR_NM AS CD_NM";
		strFrom = "PARTN_VNDR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "VNDR_ID";
		strIf1 = "VNDR_ID";
		strIf2 = (colLang == "en") ? "VNDR_NM_EN" : "VNDR_NM";
	}
	type = target;

	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "itemCd"){
			$("#purchase_srch6").val(data.cd);
		}else if(data.type == "vndrCd"){
			$("#purchase_srch3").val(data.cd);
		}else if(data.type == "vndrNm"){
			$("#purchase_srch4").val(data.cdNm);
		}else{
			purchaseHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
	if(target == "itemCd" || target == "1"){
		$("#exampleModalCenterTitleCmmn").text(colItemAllCd);
	}else{
		$("#exampleModalCenterTitleCmmn").text(colVndrCd);
	}

};

function fn_purchaseAllClick(){
	id_checkPurchaseAll
	var check = "" ;
	var changeArr = [];
	if ( $("#id_checkPurchaseAll").prop("checked") == false) {
		check = "yes" ;
	} else {
		check = "no" ;
	}

	var data = purchaseHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,1,check])
	}
	purchaseHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_checkPurchaseAll").prop("checked", true);
	} else {
		$("#id_checkPurchaseAll").prop("checked", false);
	}
}




//저장
function fn_savePurchaseData(){
	if(!confirm(msgSaveConfirm)){ return }
	fn_loading(true);
	
	var tableType = $("input:radio[name=purchaseType]:checked").val();
	var srchType = $("input:radio[name=purchase_srch1]:checked").val();
	var checkedData = purchaseHot.getSourceData();
	var popData = [];
	for(var i=0; i<checkedData.length; i++){
		
		//if( tableType == "edit" && srchType == "01" ){
		//if(checkedData[i]["saveCheck"] == true){
	//		checkedData[i]["srchTp"] = srchType;
	//		popData.push(checkedData[i]);
	//		}
	//	} else {
			checkedData[i]["srchTp"] = srchType;
			popData.push(checkedData[i]);
	//	}
	}
	
/*	for(var i=0; i<savePurchaseData.length; i++){
		savePurchaseData[i]["srchTp"] = srchType;
	}
*/	console.log(popData);
	$.ajax({
		type : "POST",
		url : "/base/savePurchaseInfo.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$("input:radio[name=purchaseType]:input[value='read']").trigger("click");
        		fn_searchPurchase();
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

//인증서요청
function fn_docCall(impYn) {

	if(impYn == "Y"){

	} else {

	}
	  var cnt1 = 0;
	  var cnt2 = 0;
	  var data = purchaseHot.getSourceData(); //선택데이터 가져오기위함
	  var savePurchaseData = [];
	  var ftaCd = {};

	  for(var i=1; i < ftaCdList.match(/,/g).length+2; i++){
		  if($("input[name=ftaCd"+i+"]:checkbox").prop("checked") == true){
			  cnt2++;
		  }
	  }
	  for(var i=0; i<data.length; i++){
		  if ( purchaseHot.getDataAtCell(i,1) =="yes") {
			  cnt1 ++;
			  savePurchaseData.push(data[i]);
		  }
	  }
	  if(cnt2 == 0){
		  alert(msgNonSelectFta);
		  return;
	  }
	  var ftaArr = [];
	  for(var i=1; i < ftaCdList.match(/,/g).length+2; i++){
		  if($("input[name=ftaCd"+i+"]:checkbox").prop("checked") == true){
			  ftaArr.push($("input[name=ftaCd"+i+"]:checkbox").val());
		  }
	  }
	  ftaCd["ftaCdList"] = ftaArr;
	  savePurchaseData.push(ftaCd);

	  var inBlCnt = 0;
	  for(var i = 0; i < savePurchaseData.length-1; i++){
		  if(!savePurchaseData[i].blNo){
			  inBlCnt++;
		  }
	  }
	  //협정 선택 개수 ftaArr.length
	  //문서 총 개수 savePurchaseData.length-1
	  //협정선택 문서 inBlCnt
	  //협정미선택 문서 (savePurchaseData.length-1) - inBlCnt
	  var ftaSelDocu = ftaArr.length;
	  var ftaUnselDocu = (savePurchaseData.length-1);
	  fn_loading(true);
	  $.ajax({
			type : "POST",
			url : "/base/savePurchaseDocInfo.do",
			data : JSON.stringify(savePurchaseData),
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			contentType: "application/json; charset=utf-8",
	        success : function(data) {
	        	if(data == "success"){
	        		alert(msgDOEnrolMsg);
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

	  //언어별 메시지
	  if(lang == 'vt'){
		  alert("toàn bộ "+(ftaSelDocu*ftaUnselDocu)+"mã FTA đã được chọn.");
	  } else if(lang == 'en'){
		  alert((ftaSelDocu*ftaUnselDocu)+" FTA code(s) selected.");
	  } else {
		  alert((ftaSelDocu*ftaUnselDocu)+"개의 협정 정보가 선택됐습니다.");
	  }

	  for(var i = 1; i < ftaCdList.match(/,/g).length+2; i++){
		  $("input[name=ftaCd"+i+"").prop("checked", false);
	  }
	  $("#DOFtaSelectPopup").modal("hide");
}

function fn_docuViewCall(target, row, col){
	$("input:radio[name=purchase_srch1]")[1].checked = true;
	$("#purchase_srch3").val(purchaseHot.getDataAtCell(row, 3));
	$("#purchase_srch5").val(purchaseHot.getDataAtCell(row, 4));
	$("#purchase_srch6").val(purchaseHot.getDataAtCell(row, 6));
	fn_changePurchaseType("02")
}

//파일 업로드 다운로드
function fn_fileUpDown(row, col){
	var type = $("input:radio[name=purchaseType]:checked").val();
	var rowData = purchaseHot.getSourceDataAtRow(row);
	//파일 업로드
	if(type == "read"){
		fn_pcfileDownload(row);
	}else{
		fn_showPurchaseFilePop(rowData, row, col);
	}
};

//파일 업로드
function fn_showPurchaseFilePop(data, row, col){
	purchaseData = {row:row, col:col};
	$("#cmpnyCdPc").val(data.cmpnyCd);
	$("#plntCdPc").val(data.plntCd);
	$("#vndrCdPc").val(data.vndrCd);
	$("#purchaseNoPc").val(data.purchaseNo);
	$("#purchaseOrdrPc").val(data.purchaseOrdr);
	$("#itemCdPc").val(data.itemCd);
	$("#ftaCdPc").val(data.ftaCd);
	$("#filePc").val("");
	$("#filePopupPc").modal("show");
};

//업로드파일 저장
function fn_savePurchaseFile(){
	var file = $("#filePc").prop("files")[0];
	if(file == undefined){
		alert(msgSelectFile);
		return;
	}
	fn_loading(true);
	var form = new FormData(document.getElementById('fileFormPc'));
	console.log(form);
	$.ajax({
		type: 'POST',
		url: "/base/saveFileInfo.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data) {
			if(data.result == "success"){
				purchaseHot.setDataAtRowProp(purchaseData.row, "docuOrgFile", data.docuOrgFile);
				purchaseHot.setDataAtRowProp(purchaseData.row, "docuFile", data.docuFile);

				alert(msgSaveSuccess);
				$("#filePopupPc").modal("hide");
			}else{
				alert(msgSaveError);
			}
			fn_loading(false);
		},
		error: function (e, textStatus, jqXHR) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		alert(msgSaveError);
        	}
		}
	});
};

//파일 다운로드
function fn_pcfileDownload(row){
	var data = purchaseHot.getSourceDataAtRow(row);
	if(data.docuFile == undefined || data.docuFile == ''){
		alert(msgFileEmptyMsg);
		return;
	}

	$("#docuOrgFilePc").val(data.docuOrgFile);
	$("#docuFilePc").val(data.docuFile);
	document.fileDownForm.action = "/base/downloadFile.do";
	document.fileDownForm.submit();
};

//수취대상 등록 팝업창
function fn_DOFtaSelectPopup(){
	$("input:checkbox[name=ftaCdAll]").prop("checked", false);
	var inputDom = $("input:checkbox[name=ftaCd1]"). parent().parent().parent().find("input");
	for(var i=0; i < inputDom.length; i++){
		inputDom.eq(i).prop("checked", false);
	}

	var cnt1 = 0;
	var impCnt = 0;
	var data = purchaseHot.getSourceData();
	var check = [];
	$("input:checkbox[name=ftaCdAll]").attr("disabled", false);
	for(var i=0; i < $("#ftaList").find("input").length; i++){
		inputDom.eq(i).attr("disabled", false);
	}

	for(var i=0; i<data.length; i++){//컬럼이동시 무조건 수정 해야됨
	  if ( purchaseHot.getDataAtCell(i,1) =="yes") {
		  cnt1 ++;
		  check.push(data[i]);
		  console.log(purchaseHot.getDataAtCell(i,12));
		  if(purchaseHot.getDataAtCell(i,13).split('(')[0].trim() != "" && purchaseHot.getDataAtCell(i,13).split('(')[0].trim() != null){
			  impCnt ++;
		  }
	  }
	}
	var selectCnt = 0;
	if(cnt1==0) {
		alert(msgAnnexRequest);  //annexRequest
		return;
	}else if(data.length > 1 && impCnt > 0 && cnt1 > impCnt){
		alert(msgAnnexImport);  //annexImport
		return;
	}
	//수입건일경우 START
	if(impCnt == 1){
		var nData = {};

		nData["srch1"] = check[0].natCd.split('(')[0].trim()

		$.ajax({
			type : "POST",
			url : "/base/selectFtaAbleList.do",
			data : nData,
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			dataType : 'json',
	        success : function(data) {
	        	$("input:checkbox[name=ftaCdAll]").attr("disabled", true);
	        	for(var i=0; i < $("#ftaList").find("input").length; i++){
	        		for(var j=0;j < data.resultList.length;j++){
	        			var val = inputDom.eq(i).val()
	        			if(val.indexOf(data.resultList[j].ftaCd) != -1){
	        				inputDom.eq(i).attr("disabled", false);
	        				inputDom.eq(i).prop("checked", true);
	        				break;
	        			}else  if(val.indexOf("Form") != -1){
	        				inputDom.eq(i).attr("disabled", false);
	        			} else {
	        				inputDom.eq(i).attr("disabled", true);
	        			}
	        		}
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
	}
	//수입건일경우 END

	for(var i = 0; i < check.length; i++){
		selectCnt++;
	}
	if(selectCnt > 0){
		$("#DOFtaSelectPopup").modal("show");
	}else{

		fn_docCall();
	}
}

function fn_unCheck(){$("input[name=ftaCdAll]").prop("checked", false)}

function fn_typeHook(type){$("#srch1").val(type)}

function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_popUsedStories(row, col){
	var data = purchaseHot.getSourceData();

	if(data[row]['usedQty'] == "0"){
		document.getElementById("buttonPop").disabled = true;
		return false;
	}
	var itemCd = data[row]['itemCd'];
	var itemNm = data[row]['itemNm'];
	var purchDt = data[row]['purchaseDt'];
	var purchQty = data[row]['purchaseQty'];
	var remainQty = data[row]['leftQty'];
	var usedQty = 0;
	$("#jdgmntUsedStory").modal("show");
	fn_paramsForPopup(data[row]);
	fn_searchPurchasePopup(data[row]) ;
	var remainQty5 = addComma(remainQty)/*.toFixed(5)*/
	purchQty = addComma(purchQty);
	//remainQty5 = addComma(remainQty5);


	for(var i=0; i < jdgmntUsageHot.getSourceData().length; i++ ){
		usedQty += jdgmntUsageHot.getSourceData()[i]['purchaseQty'];
	}
	usedQty = addComma(usedQty.toFixed(3));
	document.getElementById('itemCd').value = itemCd
	document.getElementById('itemNm').value = itemNm
	document.getElementById('purchaseDt').value = purchDt
	document.getElementById('purchaseQty').value = purchQty
	document.getElementById('leftQty').value = remainQty5
	$("#leftQty").attr("title", addComma(remainQty));
	document.getElementById("usedQty").value = usedQty;
}

function fn_paramsForPopup(selectedRow){
	var sData = {};

	sData["srch20"] = selectedRow["plntCd"] ;
	sData["srch21"] = selectedRow["vndrCd"] ;
	sData["srch22"] = selectedRow["purchaseNo"] ;
	sData["srch23"] = selectedRow["purchaseOrdr"] ;
	sData["srch24"] = selectedRow["itemCd"] ;

	return sData;
}

function fn_searchPurchasePopup(selectedRow){
	fn_loading(true);
	
	$("#purchUseSrch1").val(selectedRow["plntCd"]);
	$("#purchUseSrch2").val(selectedRow["vndrCd"]);
	$("#purchUseSrch3").val(selectedRow["purchaseNo"]);
	$("#purchUseSrch4").val(selectedRow["purchaseOrdr"]);
	$("#purchUseSrch5").val(selectedRow["itemCd"]);
	
	$.ajax({
		type : "POST",
		url : "/base/selectUsedForJdgmnt.do",
		data : fn_paramsForPopup(selectedRow),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	jdgmntUsageHot.loadData([]);
        	jdgmntUsageHot.loadData(data.usedList);
			setTimeout(function() {jdgmntUsageHot.render()}, 200);
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


function fn_purchExcelSrch(type){
	$("#purchSrch1").val($("input:radio[name=purchase_srch1]:checked").val());
	if(type == '01'){
		$("#purchExTit").val(colPurchLedgrInfo);
		$("#purchExCol").val(String([colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colItemNm,colTaxbilNo,colPurchaseDt+"*",colInvoiceNo,
		     colCustomImpNo,colStndrdNo,colNatCd+"*",colPurchaseQty+"*",colUsedQty,colLeftQty,
		      colInctrm,colPuchaseAmt,colCurrentUnt,colExchngRt,colPurchaseAmtVn+"*",colPurchPriceCif])+",");
		$("#purchExCd").val("plntCd,vndrCd,purchaseNo,purchaseOrdr,itemCd,itemNm,taxbilNo,purchaseDt,invoiceNo,customImpNo,stndrdNo,natCd,purchaseQty,usedQty,leftQty,incoterms,purchasePriceVn,crrncyUnt,exchngRt,purchasePriceFr,purchaseCifPrice,");
		$("#purchExType").val("cd,cd,cd,cd,cd,text,cd,cd,cd,cd,cd,cd,floatString,floatString,floatString,cd,floatString,cd,floatString,floatString,floatString,");
	}else if(type == '02'){
		$("#purchExTit").val(colOriginCnftmnInfo);
		$("#purchExCol").val(String([colPlntCd+"*",colVndrCd+"*",colPurchaseNo+"*",colPurchaseOrdr+"*",colItemAllCd+"*",colFtaCd+"*",colHsVer,colHsCd,
			colPsr+"*",colReqDtm,colDocuFile,colOriginYn,colConfmSttus,colRecvDt,colStateMsg+","]));
		$("#purchExCd").val("plntCd,vndrCd,purchaseNo,purchaseOrdr,itemCd,ftaCd,hsVer,hsCd,psrSumry,reqDtm,docuOrgFile,originYn,approvedState,recvDtm,stateMsg,");
		$("#purchExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,");
	} else{
		$("#purchExTit").val(colPurchaseUsed);
		$("#purchExCol").val(String([colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colTaxbilNo,colPurchaseDt+"*",colInvoiceNo,
		     colCustomImpNo,colSalesNo,colUsedQty])+",");
		$("#purchExCd").val("plntCd,vndrCd,purchaseNo,purchaseOrdr,itemCd,taxbilNo,purchaseDt,invoiceNo,customImpNo,salesNo,purchaseQty,");
		$("#purchExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,floatString,");
	}

}

function fn_showXmlFilePop(){
	if($("#filePopupXml").length>1){
		$("#filePopupXml").eq(1).model("show");
		$("#filePopupXml").eq(0).model("show");
	} 
	$("#filePopupXml").modal("show");
}

function fn_saveFile(){
	var file = $("#infoFilesXml").prop("files")[0];

	/*if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}*/
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoFormXml'));
	
	$.ajax({
		type: 'POST',
		url: "/tran/saveFilesPurchase.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success : function(data) {
			if(data.resultList[0].tradeKnd == "N"){
				purchaseHot.loadData([]);
				purchaseHot.loadData(data.resultList);
				$("#filePopupXml").modal("hide");
			}else{
				alert(xmlPurchase)
			}
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

