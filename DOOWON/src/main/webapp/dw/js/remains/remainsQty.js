var remainsViewHot;
var remainsViewSettings;
var remainsViewPopupSettings;
var remainsViewIndex = 9999;
var remainsViewScrollTp = true;

var remainsInputHot;
var remainsInputSettings;
var remainsInputIndex = 9999;
var remainsInputScrollTp = true;
var selectedRptNo = null;

$( document ).ready(function() {
	
	$('.band-calendar').each(function(){ regCal(this) ;})
    $('.datepicker').datepicker("option","dateFormat",calFormat);

    var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
	var yesterDay = new Date(new Date().setDate(dayday - 1)).toISOString().substring(0,10);
	$("#remainsView_srch2").val(mtoday);
	$("#remainsView_srch3").val(today);
	
	var remainsViewElement = document.querySelector('#remainsViewTable');
	var remainsViewElementContainer = remainsViewElement.parentNode;
	remainsViewHot = new Handsontable(remainsViewElement, remainsViewSettings);
	
	var remainsInputElement = document.querySelector('#remainsInputTable');
	var remainsInputElementContainer = remainsInputElement.parentNode;
	remainsInputHot = new Handsontable(remainsInputElement, remainsInputSettings);
	
	fn_changeRemainsView('read');
	$("#remainsInputDel").show();
	$("#remainsInputSave").hide();
	fn_remainsViewEventReg();
	
	
	$("#remainsSrchType2").change(function() {
	    var selectVal = $(this).val();
	    var $inputField = $("#remainsSrchType3");
	    $inputField.empty().append('<option value="" selected>선택하세요.</option>');

	    if (selectVal === "importer") {
	        $.ajax({
	            type: "POST",
	            url: "/remains/getImporterList.do",
	            data: { searchType: selectVal },
	            dataType: "json",
	            success: function(data) {
	                if (data.resultList && data.resultList.length > 0) {
	                    $.each(data.resultList, function(index, item) {
	                        $("<option>").val(item.buyFirm).text(item.buyFirm).appendTo($inputField);
	                    });
	                }
	            },
	        });
	    }
	});
});

$(document).mousedown(function(e){
	if(e.target.name == "remainsView1_date" || e.target.name == "remainsView2_date"){
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


function fn_todayBtn() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'-');
	  
	$("#remainsView_srch2").val(today);
	$("#remainsView_srch3").val(today);
}
function fn_weekBtn() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - day)).toISOString().substring(0,10).replace(/-/g,'-');
	
	$("#remainsView_srch2").val(mtoday);
	$("#remainsView_srch3").val(today);
}
function fn_monthBtn() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - dayday + 1)).toISOString().substring(0,10).replace(/-/g,'-');
	
	$("#remainsView_srch2").val(mtoday);
	$("#remainsView_srch3").val(today);
}
function fn_lastMonthBtn() {
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
	
	$("#remainsView_srch2").val(today);
	$("#remainsView_srch3").val(mtoday);
}


$("select[name=remainsViewPageRow]").change(function(){
	fn_searchRemainsView();
});


function fn_remainsViewEventReg(){
	$("#remainsViewTable .wtHolder").scroll(function(){
		var scrollTop = $("#remainsViewTable .wtHolder").scrollTop();
  	  	var countPerPage = $("#remainsViewPageRow option:selected").val();
  	  	var rowHeight = remainsViewHot.getRowHeight();

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
  	if(remainsViewScrollTp && remainsViewIndex != 9999 && scrollTop >= (countPerPage * remainsViewIndex * rowHeight) + addCnt){
  		fn_remainsViewScroll();
  	  }
   });
}


function fn_remainsViewScroll(){
	fn_loading(true);
	remainsViewScrollTp = false;
	remainsViewIndex++;
	var data = fn_setRemainsViewForm();
	
	$.ajax({
		type : "POST",
		url : "/remains/selectRemainsViewList.do",
		data : JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = remainsViewHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	remainsViewHot.loadData(meargeJson);
        	remainsViewScrollTp = true;
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


function fn_searchRemainsView(){
    remainsViewIndex = 0;
	var data = fn_setRemainsViewForm();
	var valid = fn_validateSearchDate(data["srch2"], data["srch3"]);

	if(valid === "false"){
		data["srch2"] = null;
		data["srch3"] = null;
		$("#remainsView_srch2").val("");
		$("#remainsView_srch3").val("");
		return;
	} else {
		data["srch2"] = $("#remainsView_srch2").val();
		data["srch3"] = $("#remainsView_srch3").val();
	}
	
	if(data["srch2"] == null || data["srch2"] == "" || data["srch3"] == "" || data["srch3"] == null){
		alert("날짜를 입력해 주세요.");
		return;
	}
	
	fn_loading(true);
	
	$.ajax({
		type : "POST",
		url : "/remains/selectRemainsViewList.do",
		data : JSON.stringify(data),
		contentType: "application/json; charset=utf-8", 
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	remainsViewHot.loadData([]);
        	remainsViewHot.loadData(data.resultList);
        	var totCnt = (data.resultList.length > 0) ? data.resultList[0].cnt : 0;
        	$("#remainsViewCnt").text(totCnt); 
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
		fn_searchRemainsView();
    }
}

function fn_setRemainsViewForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=remainsView_srch1]:checked").val();
	sData["srch2"] = $("#remainsView_srch2").val();
	sData["srch3"] = $("#remainsView_srch3").val();
	sData["srch4"] = $("#remainsView_srch4").val();
	sData["srch5"] = $("#remainsView_srch5").val();
	
	sData["srch8"] = $("#remainsDtType option:selected").val();
	sData["recordCountPerPage"] = $("#remainsViewPageRow option:selected").val();
	sData["pageIndex"] = remainsViewIndex;
	
	sData["srchType1"] = $("#remainsSrchType1 option:selected").val();
	sData["srchText1"] = $("#remainsSrchText1").val();
	
	sData["srchType2"] = $("#remainsSrchType2 option:selected").val();
	sData["srchText2"] = $("#remainsSrchText2").val();
	return sData;
};

function fn_remainsQtyClear(){
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
  
	$("input:radio[name=remainsView_srch1][value=01]").prop('checked', true);
	$("#remainsView_srch2").val(mtoday);
	$("#remainsView_srch3").val(today);
	$("#remainsView_srch4").val("");
	$("#remainsView_srch5").val("");
	$("#remainsDtType").val("01");
	
	$("#remainsSrchType1").val("");
	$("#remainsSrchType2").val("");
	
	$("#remainsSrchText1").val("");
	$("#remainsSrchText2").val("");
};


function fn_remainsViewTableHeader(){
	this.remainsViewHeader = [
		 "수출신고번호", "수출화주", "해외거래처", "목적국", "란번호", "규격번호",
		 "HS CODE", "용기 Type", "규격1", "수출수량", "수입자", "소진수량", "잔량"
	] ;
}

function fn_remainsViewTableCol(){
    var remainsView_srch20 = $("input:radio[name=remainsView_srch20]:checked").val(); 

    var rptNoDownRenderer = function(instance, td, row, col, prop, value, cellProperties) {
        $(td).empty();

        if (value != '' && value != null) {
            var $textSpan = $('<span style="cursor:pointer;">')
                .html('&nbsp;' + value + '&nbsp;')
                .attr('onclick', 'fn_remainsRptNoDown(' + row + ',' + col + ')');

            var $downBtn = $('<i class="fa-regular fa-download" style="cursor:pointer; margin-left:5px;"></i>')
                .attr('onclick', 'fn_remainsRptNoDown(' + row + ',' + col + ')');

            $(td).append($textSpan).append($downBtn);
        } else {
            $(td).text(value || '');
        }
    };

	this.remainsViewCol = [
		{data : 'rptNo', className : "htCenter", width: 150, wordWrap: false, className : "htCenter", readOnly:true, renderer: rptNoDownRenderer},
		{data : 'expFirm', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'buyFirm', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'taStIso', className : "htCenter", width: 60, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'ranNo', className : "htCenter", width: 60, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'sil', className : "htCenter", width: 60, wordWrap: false, className : "htCenter", readOnly:true},
		
		{data : 'hs', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'caseType', className : "htCenter", width: 160, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'gnm1', className : "htCenter", width: 230, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'qty', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'importer', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'usedQty', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'remainsQty', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
	] ;
}

	
function fn_remainsViewTableHidden(){
	this.remainsViewHidden = [];
}

function fn_handsonGridViewOption(col, header, hidden){
	remainsViewSettings = {
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
		height : 400,
		rowHeights : 27,
		rowHeaders : true,
		columnHeaderHeight : 25,
		manualRowResize : true,
		manualColumnResize : true,
		manualRowMove : true,
		manualColumnResize : true,
		manualColumnMove : false,
		licenseKey: 'non-commercial-and-evaluation',
		contextMenu : true,
		readOnly : true,
		allowInsertRow : true,
		allowRemoveRow : true,
		autoColumnSize : {samplingRatio : 30},
		mergeCells : false,
		wordWrap : true,
		afterOnCellMouseDown : function(event, coords){
			var dataList = "";
			var rptNo = "";
			var dataList = remainsViewHot.getSourceData(coords.row, 35);
			var rptNo = dataList[dataList.length-1].rptNo.replace(/-/g, '');
			var expFirm = dataList[dataList.length-1].expFirm;
			var ranNo = dataList[dataList.length-1].ranNo;
			var sil = dataList[dataList.length-1].sil;
			$("#rptNo").val(rptNo);
			$("#expFirm").val(expFirm);
            $("#lanNo").val(ranNo);
            $("#sil").val(sil);
			fn_searchRemainsInput();
			selectedRptNo = rptNo;
		}
	};

	return remainsViewSettings;
}


// 테이블 타입 변경
function fn_changeRemainsView(){
	var searchTp = $("input:radio[name=remainsInputType]:checked").val();
	remainsViewHot.updateSettings({readOnly:true, contextMenu : false});
	fn_changeRemainsViewType(searchTp);
};

// 검색구분 변경
function fn_changeRemainsViewType(){
	let remainsViewCol = new fn_remainsViewTableCol();
	let remainsViewHeader = new fn_remainsViewTableHeader();
	let remainsViewHidden = new fn_remainsViewTableHidden();
	
	let remainsInputCol = new fn_remainsInputTableCol();
	let remainsInputHeader = new fn_remainsInputTableHeader();
	let remainsInputHidden = new fn_remainsInputTableHidden();
	
	var col, header, hidden, col2, header2, hidden2;

	col = remainsViewCol.remainsViewCol;
	header = remainsViewHeader.remainsViewHeader;
	hidden = remainsViewHidden.remainsViewHidden;
	
	col2 = remainsInputCol.remainsInputCol;
	header2 = remainsInputHeader.remainsInputHeader;
	hidden2 = remainsInputHidden.remainsInputHidden;
	
	remainsViewHot.updateSettings(fn_handsonGridViewOption(col, header, hidden));
	remainsInputHot.updateSettings(fn_handsonRemainsInputOption(col2, header2, hidden2));
	
	fn_searchRemainsView();
};


function fn_remainsRptNoDown(row, col) {
	var data = remainsViewHot.getSourceDataAtRow(row);
	var sData = {};
	sData["srch1"] = data.rptNo.replace(/-/g, '');
	
	$.ajax({
		type : "POST",
		url : "/remains/selectRemainsRptNoList.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	$("#docuPath").val(data.resultList[0].docuPath);
    	    $("#docuFile").val(data.resultList[0].docuFile);
    	    $("#docuOrgFile").val(data.resultList[0].docuOrgFile);

    	    document.remainsRptNoZipDownForm.action = "/remains/downloadFile.do";
    	    document.remainsRptNoZipDownForm.submit();
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert(msgSearchError);
        		location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});
}


$("#remainsViewTable .wtHolder").scroll(function(){
    var scrollTop = $("#remainsRptNoPopUpTable .wtHolder").scrollTop();
    var countPerPage = 50;
    var rowHeight = overHot.getRowHeight();
    var addCnt = 790;
});


$("#popOverTable .wtHolder").scroll(function(){
	fn_remainsRptNoList(row, col)
	var data = remainsViewHot.getSourceData();
	var scrollTop = $("#remainsViewTable .wtHolder").scrollTop();
	var countPerPage = 50;
	var rowHeight = filesHot.getRowHeight();
	var addCnt = 790;
	
});


function fn_remainsInputTableHeader(){
	var tableType = $("input[name=remainsInputType]:checked").val();
	this.remainsInputHeader = (tableType == "read") ? [
		"", "수출신고번호", "수출화주", "수입자", "기존수량", "소진수량", "잔량", "사용근거 (INVOICE 번호)", "사용일자", "사용자 ID", "A"
	] : [
		"수출신고번호", "수출화주", "수입자", "소진수량", "사용근거 (INVOICE 번호)"
	] ;
}


function fn_remainsInputTableCol(){
	var tableType = $("input[name=remainsInputType]:checked").val();

	this.remainsInputCol =  (tableType == "read") ? [
		{data : 'checkBox', width:30, className : "htCenter",type: 'checkbox', checkedTemplate: 'yes', uncheckedTemplate: 'no', readOnly:false},
		{data : 'rptNo', className : "htCenter", width: 160, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'expFirm', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'importer', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'qty', className : "htCenter", width: 80, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'usedQty', className : "htCenter", width: 80, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'remainsQty', className : "htCenter", width: 80, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'usedRsn', className : "htCenter", width: 160, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'usedDt', className : "htCenter", width: 120, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'regId', className : "htCenter", width: 100, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'usedDt2', className : "htCenter", width: 100, wordWrap: false, className : "htCenter", readOnly:true},
	]:[		
		{data : 'rptNo', className : "htCenter", width: 160, wordWrap: false, className : "htCenter", readOnly:true},
		{data : 'expFirm', className : "htCenter", width: 200, wordWrap: false, className : "htCenter", readOnly:true},
		{data: 'importer', className: "htCenter", width: 200, wordWrap: false, type: 'autocomplete', 
			source: function(query, process) {
                fn_getImporterList(process);
            },
            strict: false
        },
		{data : 'usedQty', className : "htCenter", width: 60, wordWrap: false, className : "htCenter"},
		{data : 'usedRsn', className : "htCenter", width: 100, wordWrap: false, className : "htCenter"},
	];
}

function fn_remainsInputTableHidden(){
	var tableType = $("input:radio[name=remainsInputType]:checked").val();
	this.remainsInputHidden = [10];
}


function fn_handsonRemainsInputOption(col, header, hidden){
	var tableType = $("input:radio[name=remainsInputType]:checked").val();
	 if (remainsInputHot) {
		 remainsInputHot.loadData([]);
	 }
	remainsInputSettings = {
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
		height : 180,
		rowHeights : 27,
		rowHeaders : true,
		columnHeaderHeight : 25,
		manualRowResize : true,
		manualColumnResize : true,
		manualRowMove : true,
		manualColumnResize : true,
		manualColumnMove : false,
		licenseKey: 'non-commercial-and-evaluation',
		contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		filters : true,
		readOnly : (tableType == "read") ? true : false,
		allowInsertRow : true,
		allowRemoveRow : true,
		autoColumnSize : {samplingRatio : 30},
		mergeCells : false,
		wordWrap : true,
		afterGetColHeader: function(col, TH){
        	if(col == 0){
        		TH.innerHTML = "<input type='checkbox' class='checker' id='id_inputDelAllChk' onclick='fn_inputDelAllChk();'>";
        	}
        }
	};
	return remainsInputSettings;
}


$("input[name=remainsInputType]").change(function(){
	var type = $("input:radio[name=remainsInputType]:checked").val();
	fn_changeInputType(type);
});


function fn_changeInputType(type){
	if (type == "read"){
		$("#remainsInputSave").hide();
		$("#remainsInputDel").show();
	} else {
		$("#remainsInputSave").show();
		$("#remainsInputDel").hide();
	}
	fn_changeInputTypeView();
};


function fn_changeInputTypeView(type){
	
	let remainsInputCol = new fn_remainsInputTableCol();
	let remainsInputHeader = new fn_remainsInputTableHeader();
	let remainsInputHidden = new fn_remainsInputTableHidden();
	
	var col2, header2, hidden2;	

	col2 = remainsInputCol.remainsInputCol;
	header2 = remainsInputHeader.remainsInputHeader;
	hidden2 = remainsInputHidden.remainsInputHidden;
	
	remainsInputHot.updateSettings(fn_handsonRemainsInputOption(col2, header2, hidden2));
	
	if($("input[name=remainsInputType]:checked").val() == "read"){
		fn_searchRemainsInput(selectedRptNo);
	} else {
		var rptNo = document.getElementById("rptNo").value.replace(/^(\d{5})(\d{2})(\d{6}X?)$/, "$1-$2-$3");
		var expFirm = document.getElementById("expFirm").value;
		remainsInputHot.loadData([]);
		remainsInputHot.alter('insert_row_below', 1, 1);
		remainsInputHot.setDataAtCell(0, 0, rptNo);
	    remainsInputHot.setDataAtCell(0, 1, expFirm);
	}
};


function fn_inputDelAllChk(){
	var check = "" ;
	var changeArr = [];
	if ( $("#id_inputDelAllChk").prop("checked") == false) {
		check = "yes" ;
		isAllChecked = true;
	} else {
		check = "no" ;
		isAllChecked = false;
	}

	var data = remainsInputHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,0,check])
	}
	remainsInputHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_inputDelAllChk").prop("checked", true);
	} else {
		$("#id_inputDelAllChk").prop("checked", false);
	}
}


function fn_remainsInputDel() {
	var rowData = remainsInputHot.getSourceData();
	let list = [];
    var cnt = 0;
    for (let i = 0; i < rowData.length; i++) {
        if (rowData[i].checkBox === "yes") {
        	rowData[i].usedDt = rowData[i].usedDt2;
        	let item = {};
            for (let key in rowData[i]) {
                item[key] = rowData[i][key];
            }
            item.lanNo = item.ranNo;
            delete item.ranNo;
            list.push(item);
            cnt++;
        }
    }
    if (cnt == 0){
    	alert("삭제할 내역을 선택해주세요.");
    	return;
    }
    if (confirm("삭제하시겠습니까?")) {
        $.ajax({
        	type: "POST",
        	url: "/remains/deleteRemainsInputList.do",
            data: JSON.stringify(list), 
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("AJAX", "true");
            },
            success: function(data) {
            	if (data.status === "success") {
            		alert("삭제되었습니다.");
	                for (let i = list.length - 1; i >= 0; i--) {
	                	remainsInputHot.alter('remove_row', list[i]);
	                }
	                fn_searchRemainsInput();
            	}
            },
            error: function(xhr, textStatus, errorThrown) {
                if (xhr.status == 400) {
                    alert("에러 발생");
                    location.href = document.referrer;
                } else {
                    console.log(errorThrown);
                    alert("오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
                }
            }
        });
    }
}

function fn_searchRemainsInput(){
	remainsInputIndex = 0;
	
	var sData = {};
	sData["srch1"] = rptNo.value;
	sData["srch2"] = lanNo.value;
	sData["srch3"] = sil.value;
	
	fn_loading(true);
	
	$.ajax({
		type : "POST",
		url : "/remains/selectRemainsInputList.do",
		data : JSON.stringify(sData),
		contentType: "application/json; charset=utf-8", 
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
			remainsInputHot.loadData([]);
			remainsInputHot.loadData(data.resultList);
			var totCnt = (data.resultList.length > 0) ? data.resultList[0].cnt : 0;
			fn_loading(false);
			$("#remainsInputDel").show();
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


function fn_getImporterList(callback) {
    $.ajax({
        type: "POST",
        url: "/remains/getImporterList.do",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            var importerList = data.resultList.map(item => item.buyFirm);
            callback(importerList);
        },
        error: function(e) {
            callback([]);
        }
    });
}


function fn_remainsInputSave(){
	if(!confirm("저장하시겠습니까?")){return;}
	
	let sData = [];
	var rowData = remainsInputHot.getSourceData();
	var lanNo = document.getElementById("lanNo").value;
	var sil = document.getElementById("sil").value;
	
	for(let i=0; i<rowData.length; i++){
		rowData[i].lanNo = lanNo;
	    rowData[i].sil = sil;
	    sData.push(rowData[i]);
	}
	$.ajax({
		type : "POST",
		url : "/remains/insertRemainsInputList.do",
		data : JSON.stringify(sData),
		async : false,
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			alert("저장되었습니다.");
			$("input[name=remainsInputType]").filter("[value='read']").prop("checked", true);
			$("#remainsInputSave").hide();
			fn_searchRemainsView();
			
			let remainsInputCol = new fn_remainsInputTableCol();
			let remainsInputHeader = new fn_remainsInputTableHeader();
			let remainsInputHidden = new fn_remainsInputTableHidden();
			
			var col2, header2, hidden2;	

			col2 = remainsInputCol.remainsInputCol;
			header2 = remainsInputHeader.remainsInputHeader;
			hidden2 = remainsInputHidden.remainsInputHidden;
			
			remainsInputHot.updateSettings(fn_handsonRemainsInputOption(col2, header2, hidden2));
			
			setTimeout(function() {
				fn_searchRemainsInput(rptNo);
	        }, 500);
			
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



function fn_remainsViewExcelDown(){
	// var type = $("input:radio[name=remainsView_srch1]:checked").val();
	const hiddenIndices = [0];
	fn_loading(true);

	var exTitArr = [];
	var exTit = "";
	var exColArr = [];
	var exCol = "";
    var exTitDivArr = [];
    var exTitDiv = "";
	
	let expViewCol = new fn_expViewTableCol();
	let expViewHeader = new fn_expViewTableHeader();
    
    exColArr.push(fn_getExcelCol(expViewCol.expViewCol.filter((item, index) => !hiddenIndices.includes(index))));
	exTitArr.push(fn_getExcelHead(expViewHeader.expViewHeader.filter((item, index) => !hiddenIndices.includes(index))));
	
 	exCol = exColArr.join("|||");
	exTit = exTitArr.join("||||");
	exTitDiv = "1|수츨신고현황";
		
	var parameters = {exCol : "", exTit: "", exTitDiv: "", exType: "", srch40: ""};
	
    // 검색옵션
	$.each(fn_setExportViewForm(), function(attrName, attrValue){
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