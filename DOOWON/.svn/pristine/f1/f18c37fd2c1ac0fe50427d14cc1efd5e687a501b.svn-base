var tradeUploadHot;
var tradeUploadSettings;
var tradeUploadPopupSettings;
var tradeUploadIndex = 9999;
var tradeUploadScrollTp = true;

$( document ).ready(function() {
	
      $('.band-calendar').each(function(){ regCal(this) ;})
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      var date = new Date();
	  var month = date.getMonth();
	  var dayday = date.getDate();
	  var today = new Date().toISOString().substring(0,10);
	  var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
	  
	  $("#tradeUpload_srch2").val(mtoday);
	  $("#tradeUpload_srch3").val(today);
	  
	  var tradeUploadElement = document.querySelector('#tradeUploadTable');
	  var tradeUploadElementContainer = tradeUploadElement.parentNode;

	  tradeUploadHot = new Handsontable(tradeUploadElement, tradeUploadSettings);

	  fn_changeTradeUpload('read');
	 
	  //scroll 이벤트
	  fn_tradeUploadasEventReg();
	  $("#tradeUploadTextView").text("전체");
      $("#tradeUploadTextView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
});

$(document).mousedown(function(e){	
	if(e.target.name == "tradeUpload1_date" || e.target.name == "tradeUpload2_date"){
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

$("input:radio[name=tradeUpload_srch20]").change(function(){
	$("input[name=tradeUploadType][value=read]").prop("checked", true);
	fn_changeTradeUpload("read");
})

$("input[name=tradeUpload_srch1]").change(function(){
	
	var selectedValue = $(this).val();
    if(selectedValue === "01") {
        $("#tradeUploadTextView").text("수출실적");
        $("#tradeUploadTextView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
        fn_changeTradeUploadType(selectedValue);
    } else if(selectedValue === "02") {
        $("#tradeUploadTextView").text("수입실적");
        $("#tradeUploadTextView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
        fn_changeTradeUploadType(selectedValue);
    } else if(selectedValue === "03") {
        $("#tradeUploadTextView").text("입고실적");
        $("#tradeUploadTextView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>');
        fn_changeTradeUploadType(selectedValue);
    }
});


function fn_tradeUploadchgDate1() {
	  var date = new Date();
	  var month = date.getMonth();
	  var dayday = date.getDate();
	  var day = date.getDay();
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'-');
	  
	  $("#tradeUpload_srch2").val(today);
	  $("#tradeUpload_srch3").val(today);
}

function fn_tradeUploadchgDate2() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - day)).toISOString().substring(0,10).replace(/-/g,'-');
	
	$("#tradeUpload_srch2").val(mtoday);
	$("#tradeUpload_srch3").val(today);
}
function fn_tradeUploadchgDate3() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - dayday + 1)).toISOString().substring(0,10).replace(/-/g,'-');
	
	$("#tradeUpload_srch2").val(mtoday);
	$("#tradeUpload_srch3").val(today);
}
function fn_tradeUploadchgDate4() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var startDt = new Date();
	startDt.setDate(1);
  	startDt.setMonth(startDt.getMonth() - 1);

  	var endDt = new Date();
  	endDt.setMonth(endDt.getMonth(), 1);
  	endDt.setDate(endDt.getDate() - 1);
	
	var today = startDt.toISOString().substring(0,10).replace(/-/g,'-')
	var mtoday = endDt.toISOString().substring(0,10).replace(/-/g,'-')
	
	$("#tradeUpload_srch2").val(today);
	$("#tradeUpload_srch3").val(mtoday);
}

//row 수
$("select[name=tradeUploadPageCnt]").change(function(){
	  fn_searchTradeUpload();
});


// 스크롤할 때 행이 자동으로 추가 로드될 수 있게 하는 함수
function fn_tradeUploadasEventReg(){
	
   $("#tradeUploadTable .wtHolder").scroll(function(){
	  //fn_tradeUploadFileList(row, col)
  	  var scrollTop = $("#tradeUploadTable .wtHolder").scrollTop();
  	  var countPerPage = $("#tradeUploadPageCnt option:selected").val();
  	  var rowHeight = tradeUploadHot.getRowHeight();

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
  	  if(tradeUploadScrollTp && tradeUploadIndex != 9999 && scrollTop >= (countPerPage * tradeUploadIndex * rowHeight) + addCnt){
  		  fn_tradeUploadScroll();
  	  }
   });
}

// 스크롤
function fn_tradeUploadScroll(){
	if( $("input[name=tradeUploadType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	tradeUploadScrollTp = false;
	tradeUploadIndex++;
	var data = fn_setTradeUploadForm();

	$.ajax({
		type : "POST",
		url : "/trade/selectTradeUploadList.do",
		data : JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = tradeUploadHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	tradeUploadHot.loadData(meargeJson);
        	tradeUploadScrollTp = true;
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
function fn_searchTradeUpload(){
	tradeUploadIndex = 0;
	
	var data = fn_setTradeUploadForm();
	var valid = fn_validateSearchDate(data["srch2"], data["srch3"]);

	if(valid === "false"){
		data["srch2"] = null;
		data["srch3"] = null;
		$("#tradeUpload_srch2").val("");
		$("#tradeUpload_srch3").val("");
		return;
	} else {
		data["srch2"] = $("#tradeUpload_srch2").val();
		data["srch3"] = $("#tradeUpload_srch3").val();
	}
	
	if(data["srch2"] == null || data["srch2"] == "" || data["srch3"] == "" || data["srch3"] == null){
		alert("날짜를 입력해 주세요.");
		return;
	}
	
	fn_loading(true);

	$.ajax({
		type : "POST",
		url : "/trade/selectTradeUploadList.do",
		data : JSON.stringify(data),
		contentType: "application/json; charset=utf-8", 
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	tradeUploadHot.loadData([]);
        	tradeUploadHot.loadData(data.resultList);
        	var totCnt = (data.resultList.length > 0) ? data.resultList[0].cnt : 0;
        	$("#tradeUploadCnt").text(totCnt); 
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
		fn_searchTradeUpload();
    }
}


// 검색조건 생성
function fn_setTradeUploadForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=tradeUpload_srch1]:checked").val();
	sData["srch2"] = $("#tradeUpload_srch2").val();
	sData["srch3"] = $("#tradeUpload_srch3").val();
	sData["srch4"] = $("#tradeUpload_srch4").val();
	sData["srch5"] = $("#tradeUpload_srch5").val();
	var list2 = sData["srch5"].split(/[, ]+/).map(function(item) {
        return item.trim();
    }).filter(function(item) {
        return item.length > 0; 
    });
    sData["list2"] = list2;
	sData["srch8"] = $("#tradeUploadDateType option:selected").val();
	sData["recordCountPerPage"] = $("#tradeUploadPageCnt option:selected").val();
	sData["pageIndex"] = tradeUploadIndex;
	
	sData["srchType1"] = $("#tradeUploadSrchType1 option:selected").val();
	sData["srchText1"] = $("#tradeUploadSrchText1").val();
	
	sData["srchType2"] = $("#tradeUploadSrchType2 option:selected").val();
	sData["srchText2"] = $("#tradeUploadSrchText2").val();
	return sData;
};

//검색조건 초기화
function fn_clearTradeUpload(){
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
  
	$("input:radio[name=tradeUpload_srch1][value=01]").prop('checked', true);
	$("#tradeUpload_srch2").val(mtoday);
	$("#tradeUpload_srch3").val(today);
	$("#tradeUpload_srch4").val("");
	$("#tradeUpload_srch5").val("");
	$("#tradeUploadDateType").val("01");
	
	$("#tradeUploadSrchType1").val("");
	$("#tradeUploadSrchType2").val("");
	
	$("#tradeUploadSrchText1").val("");
	$("#tradeUploadSrchText2").val("");
	
};


// 테이블 컬럼
function fn_tradeUploadTableCol(){
	
		this.tradeUploadCol = [
			{data : 'rptNo', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'expLisDay', className : "htCenter", width: 90, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'excDivi', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'gnm1', className : "htCenter", width: 250, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'itemCode', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'qty', className : "htCenter", width: 90, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'qtyUt', className : "htCenter", width: 90, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'mgCode', className : "htCenter", width: 130, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'buyFirm', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
			{data : 'tradeQty', className : "htCenter", width: 90, wordWrap: false, className : "htCenter", readOnly:true, renderer : qtyRenderer},
			{data : 'tradeRemark', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true, renderer : remarkRenderer},
		] ;

}

// 테이블 헤더
function fn_tradeUploadTableHeader(){

	this.tradeUploadHeader = [
		 "수출신고번호", "수리일자", "거래구분", "거래품명", "규격(ITEM CODE)" , "수량" , "단위" ,"인보이스 번호", "해외거래처",  "수량 보정", "보정 내용 설명"
	 ] ;

}
	
// 테이블 히든컬럼
function fn_tradeUploadTableHidden(){
	this.tradeUploadHidden = [];
}

// table
function fn_handsonGridViewOption(col, header, hidden){
	var tableType = $("input:radio[name=tradeUploadType]:checked").val();
	
	tradeUploadSettings = {
	  columns : col,
	  colHeaders : header,
	  hiddenColumns : {
    	  copyPasteEnabled : false,
    	  indicators : false,
    	  columns : hidden
      },
	  stretchH : 'all',
	  width : '100%',
	  autoWrapRow : true,
	  height : 500,
	  rowHeights : 27,
	  rowHeaders : true,
	  columnHeaderHeight : 25,
	  manualRowResize : true,
	  manualColumnResize : true,
	  manualRowMove : true,
	  manualColumnResize : true,
	  manualColumnMove : false,
	  licenseKey: 'non-commercial-and-evaluation',
	  //dropdownMenu : true,
	  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
	  filters : true,
	  readOnly : (tableType == "read") ? true : false,
	  allowInsertRow : true,
	  allowRemoveRow : true,
	 // columnSorting : {indicator : true},
      autoColumnSize : {samplingRatio : 30},
      mergeCells : false,
      wordWrap : true
	};

	return tradeUploadSettings;
}

//테이블 타입 변경
function fn_changeTradeUpload(type){

	tradeUploadHot.updateSettings({readOnly:true, contextMenu : false});
	$("#btnTradeUploadSave").hide();
	$("#expExcel").show();
	$("#docBtn").children().show();
	fn_changeTradeUploadType();
};

//검색구분 변경
function fn_changeTradeUploadType(type){
	
	let tradeUploadCol = new fn_tradeUploadTableCol();
	let tradeUploadHeader = new fn_tradeUploadTableHeader();
	let tradeUploadHidden = new fn_tradeUploadTableHidden();
	
	
	var col, header, hidden ;	

	//구매원장
	col = tradeUploadCol.tradeUploadCol;
	header = tradeUploadHeader.tradeUploadHeader;
	hidden = tradeUploadHidden.tradeUploadHidden;
	
	tradeUploadHot.updateSettings(fn_handsonGridViewOption(col, header, hidden));
	fn_searchTradeUpload();
};
	

function fn_tradeUploadExcelDownload(){
	 var type = $("input:radio[name=tradeUpload_srch1]:checked").val();
	 fn_loading(true);
		//엑셀옵션
		var exTitArr = [];
		var exTit = "";
		var exColArr = [];
		var exCol = "";
	    var exTitDivArr = [];
	    var exTitDiv = "";
		
		let tradeUploadCol = new fn_tradeUploadTableCol();
		let tradeUploadHeader = new fn_tradeUploadTableHeader();
	    exColArr.push(fn_getExcelCol(tradeUploadCol.tradeUploadCol));
		exTitArr.push(fn_getExcelHead(tradeUploadHeader.tradeUploadHeader));
		
	 	exCol = exColArr.join("|||");
		exTit = exTitArr.join("||||");
		exTitDiv = "1|수츨신고현황||";
			
	   
	   var parameters = {exCol : "", exTit: "", exTitDiv: "", exType: "", srch40: ""};
		
	   // 검색옵션
	   $.each(fn_setTradeUploadForm(), function(attrName, attrValue){
	   	parameters[attrName] = attrValue;
	   });
		
		parameters.exCol = exCol.replace(/ /g,"_");
		parameters.exTit = exTit.replace(/ /g,"_");
		parameters.exTitDiv = exTitDiv.replace(/ /g,"_");
		parameters.exType = type;
		parameters.srch40 = "수출신고현황";
		
		$.ajax({
			 url: "/export/exportDownloadExcel.do",
			 data: parameters,
			 type: 'POST',
			 cache: false,
			 timeout: 200000,
			 xhrFields: {
				 responseType: "blob",
			 },
		    success: function(blob, status, xhr) {
		    	try {
					// check for a filename
					 var fileName = "";
					 var disposition = xhr.getResponseHeader("Content-Disposition");

				       if (disposition && disposition.indexOf("attachment") !== -1) {
				      	 var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
				           var matches = filenameRegex.exec(disposition);

				           if (matches != null && matches[1]) {
				               fileName = decodeURI(matches[1].replace(/['"]/g, ""));
				           }
				       }

				       // for IE
				       if (window.navigator && window.navigator.msSaveOrOpenBlob) {
				           window.navigator.msSaveOrOpenBlob(blob, fileName);
				       } else {
				           var URL = window.URL || window.webkitURL;
				           var downloadUrl = URL.createObjectURL(blob);

				           if (fileName) {
				               var a = document.createElement("a");

				               // for safari
				               if (a.download === undefined) {
				                   window.location.href = downloadUrl;
				               } else {
				                   a.href = downloadUrl;
				                   a.download = fileName;
				                   document.body.appendChild(a);
				                   a.click();
				               }
				           } else {
				               window.location.href = downloadUrl;
				           }
				       }
			       fn_loading(false);
				} catch (e) {
					console.log(e);
					fn_loading(false);
				};
		    },
		    error: function(e, textStatus, errorThrown) {
		    	if(e.status == 400){
		    		alert("Your request is up. Please log back in if you wish continue");
		    		location.href = document.referrer;
		    	} else {
		        	console.log(errorThrown);
		    	}
		    }
		});
}

function fn_getExcelCol(viewCol){
    return viewCol.map(item => item['data'] + '|' + item['className'] + '|' + item['width']).join("||");
}
 
function fn_getExcelHead(viewHead){
    var result = [];
    
    if(viewHead.length > 1 && typeof(viewHead[0][0]) == 'object') {
        for(var i=0; i < viewHead.length; i++) {
            if(i == viewHead.length -1){
                result.push(viewHead[i].join("|null||") + "|null");
            }else {
                result.push(viewHead[i].map(item => (item['label'] ? item['label'] : 'null') + '|' + (item['colspan'] ? item['colspan'] : 'null')).join("||"));
            }
        }
        return result.join("|||");
    }else{
        return viewHead.join("|null||") + "|null";
    };
}


function fn_tradeSave(row, col){
	var tableType = $("input:radio[name=tradeUploadType]:checked").val();
	var rowData = tradeUploadHot.getSourceDataAtRow(row);
	
	var rptNo = rowData.rptNo;
	var itemCode = rowData.itemCode;
	var qty = $("#tradeQty"+row).val();
	var remark = $("#tradeRemark"+row).val();
	
	var tradeType = "";
	if(tableType=="01"){
		tradeType = "EXP"
	} else if (tableType=="02"){
		tradeType = "IMP"
	} else {
		tradeType = "ENTRY"
	}
	
	var sData = {};
	sData["srch1"] = rptNo;
	sData["srch2"] = itemCode;
	sData["srch3"] = qty;
	sData["srch4"] = remark;
	sData["srch5"] = tradeType;
	
	console.log(sData);
	
	if(confirm("저장하시겠습니까?")){
		
		/*$.ajax({
			type : "POST",
			url : "/import/saveImportMemo.do",
			data : sData,
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			dataType: "json",
			success : function(data) {
				alert('저장되었습니다.')
				fn_searchImportView();
				
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
		});*/
	} else {
		return;
	}
}

