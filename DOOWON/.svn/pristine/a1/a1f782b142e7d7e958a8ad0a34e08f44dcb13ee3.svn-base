var salesHot;
var salesSettings;
var salesIndex = 9999;
var salesScrollTp = true;
var plntSelect = [];
var natSelect = [];
var incotermsSelect = [];

$( document ).ready(function() {
	  plntCdList = plntCdList.replace('[','').replace(']','');
	  plntSelect = plntCdList.split(', ');
	  
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
	  

	  console.log(mtoday);
	  
	  $("#sales_srch5").val(mtoday);
	  $("#sales_srch6").val(today);
	  
	  //달력 사용시 반드시 넣어주세요.
	  $('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var salesElement = document.querySelector('#salesTable');
	  var salesElementContainer = salesElement.parentNode;

	  salesHot = new Handsontable(salesElement, salesSettings);

	  $("#btnSalesSave").hide();
	  fn_changeSales('read')
	  fn_searchSales();
	  
	  fn_scroll();
});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-sale").hasClass("active")) {
//			fn_searchSales();
//		} 
//	}
//})

function fn_scroll(){
	//스크롤
	  $("#salesTable .wtHolder").scroll(function(){
	  	  var scrollTop = $("#salesTable .wtHolder").scrollTop();
	  	  var countPerPage = $("#salesPageCnt option:selected").val();
	  	  var rowHeight = salesHot.getRowHeight();

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

	  	  if(salesScrollTp && salesIndex != 9999 && scrollTop >= (countPerPage * salesIndex * rowHeight) + addCnt){
	  		  fn_salesScroll();
	  	  }
	  });
}

$(document).mousedown(function(e){	
	if(e.target.name == "sales1_date" || e.target.name == "sales2_date"){
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

$("input:radio[name=sales_srch8]").change(function(){
	$("input[name=salesType][value=read]").prop("checked", true);
	fn_changeSales("read");
})

//테이블 타입 변경
$("input[name=salesType]").change(function(){
	  fn_changeSales($(this).val());
});

//정렬항목
$("select[name=alignSales]").change(function(){
	  fn_searchSales();
});

//row 수
$("select[name=salesPageCnt]").change(function(){
	  fn_searchSales();
});

//검색 조건 값 가져오기
$("select[id=sales_srch1]").change(function(){
	  fn_srch1($(this).val());
});

/** 이벤트 End **/

//스크롤
function fn_salesScroll(){
	if( $("input[name=salesType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	salesScrollTp = false;
	salesIndex++;

	
	
	$.ajax({
		type : "POST",
		url : "/tran/selectSalesList.do",
		data : fn_setSalesForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = salesHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	salesHot.loadData(meargeJson);
        	salesScrollTp = true;
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
		fn_searchSales();
    }
}

//검색
function fn_searchSales(){
	salesIndex = 0;

	$("#salesSrch1").val($("#sales_srch1").val());
	$("#salesSrch2").val($("#sales_srch2").val());
	$("#salesSrch3").val($("#sales_srch3").val());
	$("#salesSrch4").val($("#sales_srch4").val());
	$("#salesSrch5").val($("#sales_srch5").val());
	$("#salesSrch6").val($("#sales_srch6").val());
	$("#salesSrch7").val($("#sales_srch7").val());
	$("#salesSrch9").val($("input:radio[name=sales_srch9]:checked").val());
	$("#salesSrch10").val($("#sales_srch10").val());
	
	var data = fn_setSalesForm();
	var valid = fn_validateSearchDate(data["srch5"], data["srch6"]);
	
	if(valid === "false"){
		data["srch5"] = null;
		data["srch6"] = null;
		$("#sales_srch5").val("");
		$("#sales_srch6").val("");
		return;
	} else {
		data["srch5"] = $("#sales_srch5").val();
		data["srch6"] = $("#sales_srch6").val();
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectSalesList.do",
		data : data,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if( $("input[name=salesType]:checked").val() == "enrol"){
        		salesHot.loadData([]);
        		salesHot.alter('insert_row', 1, 1);
        	}else{
        		salesHot.loadData([]);
            	salesHot.loadData(data.resultList);
            	$("#salesCnt2").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setSalesForm(){
	var sData = {};
	sData["srch1"] = $("#sales_srch1").val();
	sData["srch2"] = $("#sales_srch2").val();
	sData["srch3"] = $("#sales_srch3").val();
	sData["srch4"] = $("#sales_srch4").val();
	sData["srch5"] = $("#sales_srch5").val();
	sData["srch6"] = $("#sales_srch6").val();
	sData["srch7"] = $("#sales_srch7").val();
	sData["srch8"] = $("input:radio[name=sales_srch8]:checked").val();
	sData["srch9"] = $("input:radio[name=sales_srch9]:checked").val();
	sData["srch10"] = $("#sales_srch10").val();
	
	sData["alignItem"] = $("#alignSales option:selected").val();
	sData["recordCountPerPage"] = $("#salesPageCnt option:selected").val();
	sData["pageIndex"] = salesIndex;
	console.log(sData);
	return sData;
};

//검색조건 초기화
function fn_clearSales(){
	$("#sales_srch1").val("");
	$("#sales_srch2").val("");
	$("#sales_srch3").val("");
	$("#sales_srch4").val("");
	$("#sales_srch5").val("");
	$("#sales_srch6").val("");
	$("#sales_srch7").val("");
	$("#sales_srch10").val("");
	$("input:radio[name = 'sales_srch9']:radio[value = '']").prop("checked", true);
};

//저장버튼 클릭
function fn_saveSalesCheck(){
	if(salesHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validateSales();
};

//정합성 체크
function fn_validateSales(){
	salesHot.validateCells(function(result) {
		if(result){
			fn_saveSalesData();
		}else{
			salesHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveSalesData(){

	if(!confirm(msgSaveConfirm)){return}
	
	var tableType = $("input:radio[name=salesType]:checked").val();
	var checkedData = salesHot.getSourceData();
	var popData = [];
	for(var i=0; i<checkedData.length; i++){
		
		//if( tableType == "edit" ){
		//if(checkedData[i]["saveCheck"] == true){
		//	popData.push(checkedData[i]);
		//	}
		//} else {
			popData.push(checkedData[i]);
		//}
	}

	var saveSalesData = salesHot.getSourceData();
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/saveSalesInfo.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {

      	  //테이블 타입 변경
      	  $("input[name=salesType]").change(function(){
      		  fn_changeSales($(this).val());
      	  });

        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=salesType]:checked").val() == "enrol"){
        			$("input[name=salesType]")[0].checked = true;
        			fn_changeSales($("input[name=salesType]:checked").val());
        		}
        		$("input:radio[name=salesType]:input[value='read']").trigger("click");
        		fn_searchSales();
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
function fn_salesTableCol(){
	var tableType = $("input:radio[name=salesType]:checked").val();

	var salesPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	var rightSalesPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","right").append(value);
	};
	
	var salesItemCdRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var targetTp = (prop == "itemCd") ? 1 : 2;
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopSales('+targetTp+','+row+','+col+')"></i>');
		$(td).empty().append($button).append("  " +  (value != null) ? value : "");
	};
	
	var trasRenderer = function (instance, td, row, col, prop, value, cellProperties) {
    	if (value ==null || Number(value)==0 ) {
    		$(td).empty().append($button).append("");
    	} else {
    		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" id="buttonPop" style="cursor:pointer;" onclick="fn_popTransRate('+row+','+col+')"></i>');
    		$(td).empty().append(value+"	").append($button).css("text-align", "right");
    	}
	};
	
	this.salesCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter", width: 120, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'buyrId', type : 'text', width: 150, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'salesNo', type : 'text', width: 150, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'salesOrdr', type : 'text', width: 150, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'itemCd', type : 'text', width: 150, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'stndrdNo', type : 'text', width: 120, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true},
		{data : 'salesDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", renderer:salesPkNoneEdit, readOnly:true }, 
		{data : 'invoiceNo', type : 'text', width: 150, className : "htCenter"},
		{data : 'invoiceDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"}, 
		/*{data : 'lcNo', type : 'text', className : "htCenter" },*/
		{data : 'customExpNo', type : 'text', width: 200, className : "htCenter", validator : /(^[\s\S]{0,20}$)/},
		{data : 'customExpDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"}, 
		{data : 'exportNation',editor : 'select', selectOptions : natTyList, type : 'autocomplete', className : "htCenter",width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 2))}},
		//{data : 'exportNation',editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter",width: 150, className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incotermsSelect, type : 'autocomplete', className : "htCenter", width: 150,validator : function(value, callback) {callback(emptySelectboxCheck(value,this.selectOptions))}},
		{data : 'salesPrice', width: 230, type : 'text',className : "htRight"},
		{data : 'crrncyUnt', editor : 'select', selectOptions : crncyTyList, type : 'autocomplete', className : "htCenter"},
		{data : 'exchngRt', width: 120, type : 'text',className : "htRight"},
		{data : 'salesQty', width: 120, type : 'text',className : "htRight", validator : function(value, callback){callback(notEmpty(value, 1000))}},
		{data : 'salesPriceFr', width: 150, type : 'text',className : "htRight", },
//		{data : 'salesFobPrice', width: 150, type : 'text', renderer:rightSalesPkNoneEdit, readOnly:true,className : "htLeft"},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},

	] : (tableType == "read") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter",width: 120,
				 className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'buyrId', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}, readOnly:true},
		{data : 'salesNo', type : 'text', width: 150, className : "htCenter", renderer:trasRenderer, validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'salesOrdr', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 3))}},
		{data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, readOnly:true},
		{data : 'stndrdNo', type : 'text', width: 120, className : "htCenter"},
		{data : 'salesDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator:notEmptyDataCheck },
		{data : 'invoiceNo', type : 'text', width: 150, className : "htCenter",validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'invoiceDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"},
		/*{data : 'lcNo', type : 'text', className : "htCenter" },*/
		{data : 'customExpNo', type : 'text', width: 200, className : "htCenter", validator : /(^[\s\S]{0,200}$)/},
		{data : 'customExpDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"},
		{data : 'exportNation', editor : 'select', selectOptions : natTyList, type : 'autocomplete', className : "htCenter",width: 150,
				className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'incoterms', type : 'text', width: 150, className : "htCenter"},
		{data : 'salesPrice', width: 230, type : 'text',className : "htRight"},
		{data : 'crrncyUnt', editor : 'select', selectOptions : crncySelect, type : 'autocomplete', className : "htCenter"},
		{data : 'exchngRt', width: 120, type : 'text',className : "htRight"},
		{data : 'salesQty', width: 120, type : 'text',className : "htRight" , validator : function(value, callback){callback(notEmpty(value, 1000))}},
		{data : 'salesDelivIm', width: 200, type : 'text',className : "htRight",},
		{data : 'salesDelivEx', width: 200, type : 'text',className : "htRight",},
		{data : 'salesPriceFr', width: 150, type : 'text',className : "htRight",},
		{data : 'salesFobPrice', width: 180, type : 'text',className : "htRight"},
		{data : 'salesExwPrice', width: 180, type : 'text',className : "htRight"},
		{data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
		//{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntSelect, type : 'autocomplete', className : "htCenter",width: 120,
				 className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'buyrId', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 100))}, renderer: salesItemCdRenderer},
		{data : 'salesNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'salesOrdr', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'itemCd', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, renderer: salesItemCdRenderer},
		{data : 'stndrdNo', type : 'text', width: 120, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 100))} },
		{data : 'salesDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter", validator:notEmptyDataCheck },
		{data : 'invoiceNo', type : 'text', width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'invoiceDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"},
		/*{data : 'lcNo', type : 'text', className : "htCenter" },*/
		{data : 'customExpNo', type : 'text', width: 200, className : "htCenter", validator : /(^[\s\S]{0,200}$)/},
		{data : 'customExpDt', type : 'date', dateFormat: gridCalFormat, width: 150, className : "htCenter"},
		{data : 'exportNation', editor : 'select', selectOptions : natTyList, type : 'autocomplete', className : "htCenter",width: 150, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 2))}},
		//{data : 'exportNation', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter",width: 150, className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'incoterms', editor : 'select', selectOptions : incotermsSelect, type : 'autocomplete', className : "htCenter", width: 100,validator : function(value, callback) {callback(emptySelectboxCheck(value,this.selectOptions))}},
		{data : 'salesPrice', width: 230, type : 'text',className : "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'crrncyUnt', editor : 'select', selectOptions : crncyTyList, type : 'autocomplete', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'exchngRt', width: 120, type : 'text',className : "htRight"},
		{data : 'salesQty', width: 120, type : 'text',className : "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'salesPriceFr', width: 150, type : 'text',className : "htRight", validator : function(value, callback){callback(notEmpty(value, 20))}},
//		{data : 'salesFobPrice', width: 150, type : 'numeric', numericFormat : {pattern : '0,0.00'}},		
		
	];
}

//테이블 헤더
function fn_salesTableHeader(){
	var tableType = $("input:radio[name=salesType]:checked").val();

	this.salesHeader = (tableType=="edit") ? [
		"saveCheck",
		colPlntCd+"*",colBuyrCd+"*",colBuyrNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colStndrdNo+"*",colSalesDtOrg+"*",colInvoiceNo+"*",colInvoiceDt,colCustomExpNo,colCustomExpDt,
	    /*colSheetNo,*/colExpNat+"*",colInctrm,colSalesPriceFr+"*" ,colCurrentUnt+"*",colExchngRt,colSalesQty+"*",colSalesPrice+"(VND) *",/*colSalesPriceFobAuto+"(VND)",*/
	    colDelYn 
	] : (tableType=="read") ? [
		"saveCheck",
		colPlntCd+"*",colBuyrCd+"*",colBuyrNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colStndrdNo+"*",colSalesDtOrg+"*",colInvoiceNo+"*",colInvoiceDt, colCustomExpNo,colCustomExpDt,
	    /*colSheetNo,*/colExpNat+"*",colInctrm,colSalesPriceFr+"*",colCurrentUnt+"*",colExchngRt,colSalesQty+"*",colTransCostIm,colTransCostEx,colSalesPrice+"(VND) *",colSalesPriceFobAuto+"(VND)",colSalesPriceExwAuto+"(VND)",colRegDt/*,colEdtDt*/
	] : [
		"saveCheck",
		colPlntCd+"*",colBuyrCd+"*",colBuyrNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colStndrdNo+"*",colSalesDtOrg+"*",colInvoiceNo+"*",colInvoiceDt,colCustomExpNo,colCustomExpDt,
	    /*colSheetNo,*/colExpNat+"*",colInctrm,colSalesPriceFr+"*",colCurrentUnt+"*",colExchngRt,colSalesQty+"*",colSalesPrice+"(VND) *",//colSalesPriceFobAuto+"(VND)",
	];
}


//테이블 히든컬럼
function fn_salesTableHidden(){
	var tableType = $("input:radio[name=salesType]:checked").val();

	this.salesHidden = [0];
}

function fn_handsonGridSalesOption(col, header, hidden){
	  var tableType = $("input:radio[name=salesType]:checked").val();

	  var salesSettings = {
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
	    	  manualRowMove : true,
			  manualColumnMove : false,
	    	  rowHeights : 25,
	    	  rowHeaders : true,
	    	  columnHeaderHeight : 25,
	    	//  dropdownMenu : true,
	    	  
			  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
			  filters : true,
			  readOnly : (tableType == "read") ? true : false,
			  allowRemoveRow : true,
			//  columnSorting : {indicator : true},
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
	      				if(col == "salesFobPrice" || col == "salesPrice" || col == "salesPriceFr" || col == "exchngRt" || col == "salesQty"){
	      					var data = fn_numericFormat(changes[i][3].replaceAll(",", "")); //3 변경 데이터

	      					//replace \n
	      					changes[i][3] = (''+data).replace(/\s+/, '')
	      		                                            .replace(/\s+$/g, '')
	      		                                            .replace(/\n/g, '')
	      		                                            .replace(/\r/g, '')
	      		                                            .replace(/(\n|\r\n)/gm, '');
	      					data = changes[i][3];
	      					if(col == "salesFobPrice" || col == "salesPrice" || col == "salesPriceFr" || col == "exchngRt" || col == "salesQty"){
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
	      				} else if(col == "salesDt" || col == "customExpDt" || col == "invoiceDt"){
	      					var data = changes[i][3].replaceAll("-", "");
	      					changes[i][3] = dateFormChange(fn_dateColForm(data));
	      				} else {
	      					return;
	      				}
	      			}
	      		}
	            },
	            afterChange: function(changes, source){
	            	if (changes && changes[0][2] !== changes[0][3]){ 
	            		/*alert("ROW:"+changes[0][0]+", COLUMN:"+changes[0][1]+", FROM:"+changes[0][2]+", TO:"+changes[0][3]);*/
	            		this.setDataAtCell(changes[0][0],0,true); 
	            		}
	            }
	  };
	  return salesSettings;
}

//테이블 타입 변경
function fn_changeSales(type){
	if(type == "edit" && $('input:radio[name=sales_srch8]:checked').val() == "Y"){
		alert(msgSalesJudgeReturn);
		$("input:radio[name=salesType][value=read]").prop("checked", true);
		return;
	}
	let salesCol = new fn_salesTableCol();
	let salesHeader = new fn_salesTableHeader();
	let salesHidden = new fn_salesTableHidden();
	var col, header, hidden;

	col = salesCol.salesCol;
	header = salesHeader.salesHeader;
	hidden = salesHidden.salesHidden;
	salesHot.updateSettings(fn_handsonGridSalesOption(col, header, hidden));
	if(type == "edit"){
		$("#btnSalesSave").show();
		$("#salesExcel").hide();
		$("#btnSave_XmlEx").hide();
		$("#btnRpmsnMdat").hide();
	}else if(type == "enrol"){
		$("#btnSalesSave").show();
		$("#salesExcel").hide();
		$("#btnSave_XmlEx").show();
		$("#btnRpmsnMdat").hide();
	}else{
		$("#btnSalesSave").hide();
		$("#salesExcel").show();
		$("#btnSave_XmlEx").hide();
		$("#btnRpmsnMdat").show();
	}

	fn_searchSales();
};


function fn_popTransRate(row, col){
	var data = salesHot.getSourceData();

	var plntCd = data[row]['plntCd'];
	var buyrId = data[row]['buyrId'];
	var invoiceNo = data[row]['invoiceNo'];
	var salesOrdr = data[row]['salesOrdr'];
	$("#transRate").modal("show");
	/*fn_paramsForPopup(data[row]);*/
	/*fn_searchPurchasePopup(data[row]) ;*/
	//remainQty5 = addComma(remainQty5);

	document.getElementById('plntCd').value = plntCd
	document.getElementById('buyrId').value = buyrId
	document.getElementById('invoiceNo').value = invoiceNo
	document.getElementById('salesOrdr').value = salesOrdr
	$("#delivIm").on("input", function() {
	    this.value = this.value.replace(/[^0-9]/g, '');
	});

	$("#delivEx").on("input", function() {
	    this.value = this.value.replace(/[^0-9]/g, '');	
	});
	/*$("#leftQty").attr("title", addComma(remainQty));*/
	closeTransRateModal();
}
document.getElementById("delivIm").addEventListener("input", updateSecondInputIm);
document.getElementById("delivEx").addEventListener("input", updateSecondInputEx);

function updateSecondInputIm() {
	  var firstInputValueIm = document.getElementById("delivIm").value;
	  var formattedValueIm = addCommas(firstInputValueIm);
	  document.getElementById("delivImSub").value = formattedValueIm;
	}


function updateSecondInputEx() {
	  var firstInputValueEx = document.getElementById("delivEx").value;
	  var formattedValueEx = addCommas(firstInputValueEx);
	  document.getElementById("delivExSub").value = formattedValueEx;
}
function addCommas(value) {
	  return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
function closeTransRateModal(){
	
	$("transRate").modal("hide");
	
	document.getElementById('delivIm').value='';
	document.getElementById('delivEx').value='';
	document.getElementById('delivImSub').value='';
	document.getElementById('delivExSub').value='';
}

function fn_transRateSave(){
	
	if(!confirm(msgSaveConfirm)){return}
	
	var sData = {};
	sData['srch1'] = $("#plntCd").val();
	sData['srch2'] = $("#buyrId").val()
	sData['srch10'] = $("#invoiceNo").val();
	sData['srch4'] =  $("#salesOrdr").val();
	sData['srch5'] = $("#delivIm").val()
	sData['srch6'] = $("#delivEx").val()
	if($("#delivIm").val() == ''){
		sData['srch5'] = 0;
	} 
	if($("#delivEx").val() == ''){
		sData['srch6'] = 0;
	} 
	
	console.log(sData);
	
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/saveSalesTrans.do",
		data :  sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "text",
        success : function(data) {
        	console.log(data);
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$("#transRate").modal("hide");
        		$("input:radio[name=salesType]:input[value='read']").trigger("click");
        		fn_searchSales();
        	}
        	fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else { 
	        	console.log(e.status);
	        	console.log(textStatus);
	        	console.log(errorThrown);
	        	alert(msgSaveError);
        	}
        }
	});
}

//테이블팝업 호출
function fn_callPopSales(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	//아이템
	if(target == "itemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colItemAllCd);
	//판매처
	}else{
		strSearch = (colLang == "en") ? "BUYR_ID AS CD, BUYR_NM_EN AS CD_NM" : "BUYR_ID AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colBuyrCd);
	}
	type = target;

	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "itemCd"){
			$("#sales_srch4").val(data.cd);
		}else if(data.type == "buyrCd"){
			$("#sales_srch2").val(data.cd);
		}else{
			salesHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
};

function addComma(num){
	var parts = num.toString().split("."); 
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_showXmlFilePop(){
	if($("#filePopupXml2").length>1){
		$("#filePopupXml2").eq(1).model("show");
		$("#filePopupXml2").eq(0).model("show");
	} 
	$("#filePopupXml2").modal("show");
}

function fn_saveFile2(){
	var file = $("#infoFilesXml2").prop("files")[0];

	/*if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}*/
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoFormXml2'));
	
	$.ajax({
		type: 'POST',
		url: "/tran/saveFilesSales.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success : function(data) {
			if(data.resultList[0].tradeKnd == "X"){
				salesHot.loadData([]);
				salesHot.loadData(data.resultList);
				
				$("#filePopupXml2").modal("hide");
			}else{
				alert(xmlSales)
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
