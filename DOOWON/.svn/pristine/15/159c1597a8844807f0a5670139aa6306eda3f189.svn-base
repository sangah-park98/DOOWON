var exportInHot;
var inListHot;
var exportInSettings;
var inListPopupSettings;
var exportInIndex = 9999;
var exportInScrollTp = true;
var exportInData = {};
var popupState;
var uploaderButton;
var modalClose;
var loadedFilesIn = [];
var allChecked = false;


$( document ).ready(function() {
	
      $('.band-calendar').each(function(){ regCal(this) ;})
      $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var date = new Date();
	  var month = date.getMonth();
	  var dayday = date.getDate();
	  var today = new Date().toISOString().substring(0,10);
	  var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
	  
	  $("#exportIn_srch2").val(mtoday);
	  $("#exportIn_srch3").val(today);
	  
	  var exportInElement = document.querySelector('#exportInTable');
	  var exportInElementContainer = exportInElement.parentNode;
	  exportInHot = new Handsontable(exportInElement, exportInSettings);

	  $("#exportIn_div1").show();
	  $("#exportIn_div2").show();
	  $("#exportIn_div3").hide();
	  $("#exportIn_div4").hide();
	  $("#btnExportInSave").hide();
	  $("#expViewInfo1").hide();
	  $("#expViewInfo2").hide();
	  fn_changeExportIn('read');
	 
	  //scroll 이벤트
	  fn_expViewasEventReg();

	  var inListPopupElement = document.querySelector('#inListPopupTable');
	  var inListPopupElementContainer = inListPopupElement.parentNode;
	  inListPopupSettings = fn_handsonGridinListPopupOption();
	  inListHot = new Handsontable(inListPopupElement, inListPopupSettings);
});


$("input:radio[name=exportIn_srch20]").change(function(){
	$("input[name=exportInType][value=read]").prop("checked", true);
	fn_changeExportIn("read");
})

//테이블 타입 변경
$("input[name=exportInType]").change(function(){
	  fn_changeExportIn($(this).val());
});

function fn_expInchgDate1() {
	  var date = new Date();
	  var month = date.getMonth();
	  var dayday = date.getDate();
	  var day = date.getDay();
	  var today = new Date().toISOString().substring(0,10);
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10);
	  
	  $("#exportIn_srch2").val(today);
	  $("#exportIn_srch3").val(today);
}

function fn_expInchgDate2() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - day)).toISOString().substring(0,10);
	
	$("#exportIn_srch2").val(mtoday);
	$("#exportIn_srch3").val(today);
}
function fn_expInchgDate3() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - dayday + 1)).toISOString().substring(0,10);
	
	$("#exportIn_srch2").val(mtoday);
	$("#exportIn_srch3").val(today);
}
function fn_expInchgDate4() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var startDt = new Date();
	startDt.setMonth(startDt.getMonth() - 1);
	startDt.setDate(1);

	var endDt = new Date();
	endDt.setMonth(endDt.getMonth(), 1);
	endDt.setDate(endDt.getDate() - 1);

	var today = startDt.toISOString().substring(0,10);
	var mtoday = endDt.toISOString().substring(0,10);
	
	$("#exportIn_srch2").val(today);
	$("#exportIn_srch3").val(mtoday);
}


//row 수
$("select[name=exportInPageCnt]").change(function(){
	  fn_searchExportIn();
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

function fn_expViewasEventReg(){
    $("#exportInTable .wtHolder").scroll(function(){
	   
	   var scrollTop = $("#exportInTable .wtHolder").scrollTop();
	   var countPerPage = $("#exportInPageCnt option:selected").val();
	   var rowHeight = exportInHot.getRowHeight();
	   var addCnt = 720;
	   if(countPerPage == "50"){
	  	   addCnt = 720;
	   }else if(countPerPage == "100"){
	  	   addCnt = 1900;
	   }else if(countPerPage == "200"){
		   addCnt = 4400;
	   }else if(countPerPage == "500"){
		   addCnt = 11800;
	   }
	   if(exportInScrollTp && exportInIndex != 9999 && scrollTop >= (countPerPage * exportInIndex * rowHeight) + addCnt){
	  		  fn_exportInScroll();
	  }
   });
}


function exportUpUseEventReg(){
	
   $("#popUsedTable .wtHolder").scroll(function(){
	  
	  fn_popUsedStories(row, col)
	  var data = exportUpHot.getSourceData();
	  var scrollTop = $("#popUsedTable .wtHolder").scrollTop();
	  var countPerPage = 50;
	  var rowHeight = jdgmntUsageHot.getRowHeight();
	  var addCnt = 790;

	  if(exportUpPopScrollTp && exportUpIndex != 9999 && scrollTop >= (countPerPage * exportUpIndex * rowHeight) + addCnt){
			  fn_exportUpPopScroll(data[row]);
	  }
   });
}


// Invoice의 읽기 페이지 PDF Invoice 번호별로 팝업창 띄우는 핸드슨 테이블
function fn_handsonGridinListPopupOption() {
    inListPopupSettings = {
        columns: [
        	{data : 'checkBox', type : 'text', className : "htCenter", width: 60, type: 'checkbox', checkedTemplate: 'yes', uncheckedTemplate: 'no', readOnly:false},
        	{ data: 'invoiceNo', type: 'text', className: "htCenter", readOnly: true },
            {
                data: 'docuType',
                type: 'text',
                className: "htCenter",
                readOnly: true,
                renderer: function (instance, td, row, col, prop, value, cellProperties) {
                    if (value === 'CI') {
                        td.innerHTML = '<div style="text-align: center;">Invoice</div>';
                    } else if (value === 'PL') {
                        td.innerHTML = '<div style="text-align: center;">Packing List</div>';
                    } else if (value === 'OT') {
                        td.innerHTML = '<div style="text-align: center;">Receipt</div>';
                    }else {
                        td.innerHTML = '<div style="text-align: center;">B/L</div>';
                    }
                }
            },
            { data: 'docuOrgFile', type: 'text', className: "htCenter", readOnly: true },
            { data: 'docuFile', type: 'text', className: "htCenter", readOnly: true },
            { data: 'uploadDt', type: 'text', className: "htCenter", readOnly: true },
            {
                data: 'deleteButton', width:50 , readOnly: true,
                renderer: function(instance, td, row, col, prop, value, cellProperties) {
                    td.innerHTML = '<button type="button" class="delete-button hover:opacity-50 text-rose-600" onclick="deleteExpInFile('+row+','+col+')"><i class="fa-regular fa-trash-can"></i></button>';
                    td.classList.add('htCenter');
                }
            }
        ],
        stretchH: 'all',
        width: '100%',
        autoWrapRow: true,
        height: 250,
        rowHeights: 25,
        rowHeaders: true,
        columnHeaderHeight: 25,
        colHeaders: ["", "invoice번호", "파일 타입", "파일명",'', "업로드 일자", "삭제"],
        manualRowResize: true,
        manualColumnResize: true,
        manualRowMove: true,
        manualColumnMove: false,
        contextMenu: false,
        dropdownMenu: false,
        filters: true,
        readOnly: false,
        columnSorting: { indicator: true },
        autoColumnSize: { samplingRatio: 23 },
        mergeCells: false,
        allowInsertRow: false,
        hiddenColumns: { copyPasteEnabled: false, indicators: false, columns: [1,4,6]},
        afterGetColHeader: function(col, TH){
            if(col == 0){
              TH.innerHTML = "<input type='checkbox' class='checker' id='id_checkAllExpListPopup' onclick='fn_checkAllExpListPopup();'>";
          }
        }
    };

    return inListPopupSettings;
}


$("#exportInTable .wtHolder").scroll(function(){
	var scrollTop = $("#inListPopupTable .wtHolder").scrollTop();
	var countPerPage = 50;
	var rowHeight = overHot.getRowHeight();
	var addCnt = 790;
});


$("#popOverTable .wtHolder").scroll(function(){
	fn_inFileList(row, col)
	var data = exportInHot.getSourceData();
	var scrollTop = $("#exportInTable .wtHolder").scrollTop();
	var countPerPage = 50;
	var rowHeight = filesHot.getRowHeight();
	var addCnt = 790;
	
	if(exportInScrollTp && exportInIndex != 9999 && scrollTop >= (countPerPage * exportInIndex * rowHeight) + addCnt){
		fn_selectInFilesList(data[row]);
	}
});


// 스크롤
function fn_exportInScroll(){
	if( $("input[name=exportInType]:checked").val() == "enrol")
		return;
	fn_loading(true);
	exportInScrollTp = false;
	exportInIndex++;

	$.ajax({
		type : "POST",
		url : "/export/selectExportInList.do",
		data : fn_setExportInForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = exportInHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList, data.resultList2);
        	exportInHot.loadData(meargeJson);
        	exportInScrollTp = true;
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
function fn_searchExportIn(){
	exportInIndex = 0;
	$("#expViewSrch2").val($("#exportIn_srch2").val());
	$("#expViewSrch3").val($("#exportIn_srch3").val());
	$("#expViewSrch4").val($("#exportIn_srch4").val());
	$("#expViewSrch5").val($("#exportIn_srch5").val());
	
	var data = fn_setExportInForm();
	var valid = fn_validateSearchDate(data["srch2"], data["srch3"]);

	if(valid === "false"){
		data["srch2"] = null;
		data["srch3"] = null;
		$("#exportIn_srch2").val("");
		$("#exportIn_srch3").val("");
		return;
	} else {
		data["srch2"] = $("#exportIn_srch2").val();
		data["srch3"] = $("#exportIn_srch3").val();
	}
	if(data["srch2"] == null || data["srch2"] == "" || data["srch3"] == "" || data["srch3"] == null){
		alert("날짜를 입력해 주세요.");
		return;
	}
	
	fn_loading(true);

	$.ajax({
		type : "POST",
		url : "/export/selectExportInList.do",
		data : fn_setExportInForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
            exportInHot.loadData([]);
            exportInHot.loadData(data.resultList);
            $("#exportInCnt").text(data.totCnt.toLocaleString());
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
		fn_searchExportIn();
    }
}


// 검색조건 생성
function fn_setExportInForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=exportIn_srch1]:checked").val();
	sData["srch2"] = $("#exportIn_srch2").val();
	sData["srch3"] = $("#exportIn_srch3").val();
	sData["srch4"] = $("#exportIn_srch4").val();
	sData["srch5"] = $("#exportIn_srch5").val();
	sData["srch6"] = $("#exportInDateType option:selected").val();
	sData["recordCountPerPage"] = $("#exportInPageCnt option:selected").val();
	sData["pageIndex"] = exportInIndex;
	return sData;
};

// 검색조건 초기화
function fn_clearExportIn(){
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var today = new Date().toISOString().substring(0,10);
	var mtoday = new Date(new Date().setDate(dayday - 6)).toISOString().substring(0,10);
	  
	$("input:radio[name=exportIn_srch1][value=01]").prop('checked', true);
	$("#exportIn_srch2").val(mtoday);
	$("#exportIn_srch3").val(today);
	$("#exportIn_srch4").val("");
	$("#exportIn_srch5").val("");
	$("#exportInDateType option:selected").val("01");
};


// 테이블 컬럼
function fn_expInTableCol(){
	var tableType = $("input:radio[name=exportInType]:checked").val();
	// 사용여부
	var exportIn_srch20 = $("input:radio[name=exportIn_srch20]:checked").val(); 
	// 문서 다운로드 업로드
	var docuFileLoadRenderer = function(instance, td, row, col, prop, value, cellProperties) {
	    var $fileButton;
	    var data = exportInHot.getData();
		var valueYn = data[row][1];
		var valueYn1 = data[row][2];
		var valueYn2 = data[row][6];
	        
		if(valueYn === '임시저장'){}
		else {
		  if (value != '' && value != null) {
	          $fileButton = $('<i class="fas fa-search search-icon" style="cursor:pointer;" onclick="fn_inFileList('+row+','+col+')"></i>');
	      } else {
	          $fileButton = $('<i class="fas fa-plus search-icon" style="cursor:pointer;" onclick="fn_fileUpDownIn('+row+','+col+')"></i>');
	      }
		}
	    $(td).empty().append($fileButton).append("  " + value);
	};

	//통관의뢰 버튼 업로드
	var expRequestRenderer = function(instance, td, row, col, prop, value, cellProperties) {
	    var data = exportInHot.getData();
	    var valueYn = data[row][1];
	    var valueYn1 = data[row][2];
	    var valueYn2 = data[row][6];
	    var valueYn3 = data[row][7];
	    
	    /*if(valueYn ==='임시저장'){
	    	var $fileButton = $('<button type="button" class="chip chip-green" onclick="fn_callTempInvoice(' + row + ',' + col + ')">불러오기</button>');
	    	$fileButton.css({'float': 'right'});
            $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
	    } else if(valueYn3 === 'Y' && valueYn === '' && valueYn1 === '' && valueYn2 != '') {
	    	var $fileButton = $('<button type="button" class="chip" style="background-color: #1e73be; color: white;">통관 진행 중</button>');
	    	$fileButton.css({'float': 'right'});
	        $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
	    } else {
	    	if (valueYn === '' && valueYn1 === '' && valueYn2 != '') {
	        	var $fileButton = $('<button type="button" class="chip chip-blue" onclick="fn_customsRequestExp(' + row + ',' + col + ')">통관의뢰</button>');
	        	$fileButton.css({'float': 'right'});
	            $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
	        } else {
	            $(td).empty().html('<div>' + value + '</div>');
	        }
	    }
	    */
	    
	    if (valueYn3 === 'N') {
	    	if (valueYn === '' && valueYn1 === '' && valueYn2 != '') {
	        	var $fileButton = $('<button type="button" class="chip chip-blue" onclick="fn_customsRequestExp(' + row + ',' + col + ')">통관의뢰</button>');
	        	$fileButton.css({'float': 'right'});
	            $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
	        } 
    	} else if (valueYn3 === 'Y' && valueYn === '' && valueYn1 === '' && valueYn2 != '')  {
    	    	var $fileButton = $('<button type="button" class="chip" style="background-color: #1e73be; color: white;">통관 진행 중</button>');
    	    	$fileButton.css({'float': 'right'});
    	        $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
    	} else if(valueYn ==='임시저장') {
    		var $fileButton = $('<button type="button" class="chip chip-green" onclick="fn_callTempInvoice(' + row + ',' + col + ')">불러오기</button>');
	    	$fileButton.css({'float': 'right'});
            $(td).empty().html('<div>' + value + "  " + $fileButton[0].outerHTML + '</div>');
    	} else {
            $(td).empty().html('<div>' + value + '</div>');
        }
	};

	var chipRenderer = function (instance, td, row, col, prop, value, cellProperties) {
        Handsontable.renderers.BaseRenderer.apply(this, arguments);
        td.classList.add('chip-cell');
        td.classList.add('text-center');
        switch (value) {
          case "예":
          case "접수":
          case "Y":
            td.innerHTML = `<span class="chip chip-blue">${value}</span>`
            break
          case "수리":
            td.innerHTML = `<span class="chip chip-green">${value}</span>`
            break
          case "N":
          case "서류 미비":
            td.innerHTML = `<span class="chip chip-red">${value}</span>`
            break
          case "자수":
            td.innerHTML = `<span class="chip chip-yellow">${value}</span>`
            break
          case "임시저장":
            td.innerHTML = `<span class="chip chip-yellow">${value}</span>`
            break
          default:
            // td.innerHTML = `<span class="chip chip-primary">${value}</span>`
            break
        }
   };
	
   
   var pkNoneEdit = function(instance, td, row, col, prop, value, cell_properties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	
	this.expViewCol = [
	    {data: 'invoiceNo', className: "htCenter", readOnly: true}, // [ref] width: 150
	    {data: 'rece', className: "htCenter", readOnly: true, renderer: chipRenderer},
	    {data: 'rptNo', className: "htCenter", readOnly: true},
	    {data: 'rptDay', className: "htCenter", readOnly: true},
	    {data: 'expLisDay', className: "htCenter", readOnly: true},
	    {data: 'pdf', className: "htCenter", readOnly: true, renderer: docuFileLoadRenderer},
	    {data: 'type', className: "htCenter", readOnly: true, renderer: expRequestRenderer},
	    {data : 'requestYn', className : "htCenter", wordWrap: false, className : "htCenter", readOnly:true, renderer : expRequestRenderer},
	];
}

// 테이블 헤더
function fn_expInTableHeader(){
	var tableType = $("input:radio[name=exportInType]:checked").val();
	this.expViewHeader = [
		"invoice번호", "상태", "신고번호", "신고일자", "수리일자", "PDF", "구분", ""
	] ;
}

// 테이블 히든컬럼
function fn_expInTableHidden(){
	var tableType = $("input:radio[name=exportInType]:checked").val();
	this.expViewHidden = [];
	this.expViewOrgHidden = [];
}

// table
function fn_handsonGridReadViewOption(col, header, hidden){
	var tableType = $("input:radio[name=exportInType]:checked").val();

	exportInSettings = {
	  columns : col,
	  colHeaders : header,
	  hiddenColumns : {
    	  copyPasteEnabled : false,
    	  indicators : false,
    	  columns : [7]
      },
	  stretchH : 'all',
	  width : '100%',
	  autoWrapRow : true,
	  height : 550,
	  rowHeights : 25,
	  rowHeaders : true,
	  columnHeaderHeight : 25,
	  manualRowResize : true,
	  manualColumnResize : true,
	  manualRowMove : true,
	  manualColumnMove : false,
	  licenseKey: 'non-commercial-and-evaluation',
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
	};

	return exportInSettings;
}


// 검색 그리드
function fn_searchGridPurchOption(type){
	if(type){
		$("#expViewEnrol").show();
		$("#exportIn_div1").show();
		$("#exportIn_div2").show();
		$("#exportIn_div3").hide();
		$("#exportIn_div4").hide();
		$("#exportIn_div12").hide();
		$("#exportIn_div5").show();
		$("#exportIn_div6").show();
		$("#exportIn_div7").show();
		$("#exportIn_div8").show();
		$("#expViewInfo1").hide();
		$("#expViewInfo2").hide();
		$("#docBtn").show();
	}else{
		$("#expViewEnrol").hide();
		$("#exportIn_div1").show();
		$("#exportIn_div2").hide();
		$("#exportIn_div3").show();
		$("#exportIn_div4").show();
		$("#exportIn_div5").hide();
		$("#exportIn_div12").hide();
		$("#exportIn_div6").show();
		$("#exportIn_div7").hide();
		$("#exportIn_div8").show();
		$("#expViewInfo1").show();
		$("#expViewInfo2").show();
		$("#docBtn").hide();
	}
}

function fn_searchGridPurchOption2(){

	$("#expViewEnrol").show();
	$("#exportIn_div1").show();
	$("#exportIn_div12").show();
	$("#exportIn_div2").hide();
	$("#exportIn_div3").hide();
	$("#exportIn_div4").hide();
	$("#exportIn_div5").hide();
	$("#exportIn_div6").hide();
	$("#exportIn_div7").hide();
	$("#exportIn_div8").hide();
	$("#expViewInfo1").hide();
	$("#expViewInfo2").hide();
	$("#docBtn").hide();		
}

//테이블 타입 변경
function fn_changeExportIn(type){

	var searchTp = $("input:radio[name=exportIn_srch1]:checked").val();

	if(type == "edit"){
		$("#btnExportInSave").show();
		$("#expExcel").hide();
		$("#docBtn").children().hide();
		fn_changeExportInType(searchTp);
	}else if(type == "enrol"){
		$("#btnExportInSave").show();
		$("#expExcel").hide();
		$("#docBtn").children().hide();
		fn_changeExportInType(searchTp);
	}else{
		exportInHot.updateSettings({readOnly:true, contextMenu : false});
		$("#btnExportInSave").hide();
		$("#expExcel").show();
		$("#docBtn").children().show();
		fn_changeExportInType(searchTp);
	}
};

//검색구분 변경
function fn_changeExportInType(type){
	let expViewCol = new fn_expInTableCol();
	let expViewHeader = new fn_expInTableHeader();
	let expViewHidden = new fn_expInTableHidden();
	var col, header, hidden;

	fn_searchGridPurchOption(true);
	col = expViewCol.expViewCol;
	header = expViewHeader.expViewHeader;
	hidden = expViewHidden.expViewHidden;
	exportInHot.updateSettings(fn_handsonGridReadViewOption(col, header, hidden));
	
	fn_searchExportIn();
};


function fn_inFileList(row, col){

	var data = exportInHot.getSourceDataAtRow(row);
    // console.log("data.invoiceNo: " + data.invoiceNo); // O
    // console.log("data: " + data.rptNo); 
	 
	$("#inFileListPopUp").modal("show");

    var sData = fn_invoiceForPopup(data);
    // 모달 타이틀: invoice번호로
    var uploadFileListTitle = document.querySelector('.modal-content .modal-title span');
    if (uploadFileListTitle) {
        uploadFileListTitle.textContent = "Invoice 번호: " + data.invoiceNo;
    }
    fn_searchInFilesPopup(sData);
};


function fileListClose(){
	
	$("#inFileListPopUp").modal("hide");
}

// Invoice 넘버에 맞는 파일 타입과 파일명을 불러오기 위해 필요한 칼럼 가져오는 함수
function fn_invoiceForPopup(selectedRow){
	console.log("selectedRow: " + selectedRow); // -> object
	// console.log("selectedRow.칼럼: " + selectedRow.invoiceNo); O
	
	var sData = {};

	sData["srch1"] = selectedRow["invoiceNo"];
	sData["srch2"] = selectedRow["name"];
	sData["srch3"] = selectedRow["orgFileName"];

	console.log("sData: " + sData); // -> object
	console.log("sData.srch1: " + sData["srch1"]); // O
	return sData;
}


// Invoice에 맞는 데이터 띄워주는 함수
function fn_searchInFilesPopup(data){
	
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/export/selectInFilesList.do",
		data : data,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	console.log(data);
        	inListHot.loadData([]);
        	inListHot.loadData(data.expInList);
			setTimeout(function() {inListHot.render()}, 200);
			fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("에러 발생");
        		location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});
}


//파일 업로드 다운로드
function fn_fileUpDownIn(row, col){
	
	$("#invoiceNo").val("");
	$("#rptNo").val("");
	var rowData = exportInHot.getSourceDataAtRow(row);
	var invoiceNo = rowData.invoiceNo;
	var rptNo = rowData.rptNo;
	
	loadedFilesIn = [];
	  const modal = document.querySelector('.modal-popup')
	  const uploaderModal = document.querySelector('.uploader-modal')
	  modal.classList.remove('hidden')
	  modal.classList.add('flex')
	  uploaderModal.classList.remove('hidden')
	  uploaderModal.classList.add('block')

	  const fileList = document.querySelector('.file-list')
	  fileList.innerHTML = '';
	
	  $("#invoiceNo").val(invoiceNo);
	  $("#rptNo").val(rptNo);
	
};


function fn_expViewExcelSrch(type){
	$("#expViewSrch1").val($("input:radio[name=exportIn_srch1]:checked").val());
	if(type == '01'){
		$("#expViewExTit").val(colPurchLedgrInfo);
		$("#expViewExCol").val(String([colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colItemNm,colTaxbilNo,colExportInDt+"*",colInvoiceNo,
		     colCustomExpNo,colStndrdNo,colNatCd+"*",colExportInQty+"*",colUsedQty,colLeftQty,
		      colInctrm,colPuchaseAmt,colCurrentUnt,colExchngRt,colExportInAmtVn+"*",colPurchPriceCif])+",");
		$("#expViewExCd").val("plntCd,vndrCd,exportInNo,exportInOrdr,itemCd,itemNm,taxbilNo,exportInDt,invoiceNo,customExpNo,stndrdNo,natCd,exportInQty,usedQty,leftQty,incoterms,exportInPriceVn,crrncyUnt,exchngRt,exportInPriceFr,exportInCifPrice,");
		$("#expViewExType").val("cd,cd,cd,cd,cd,text,cd,cd,cd,cd,cd,cd,floatString,floatString,floatString,cd,floatString,cd,floatString,floatString,floatString,");
	}else if(type == '02'){
		$("#expViewExTit").val(colOriginCnftmnInfo);
		$("#expViewExCol").val(String([colPlntCd+"*",colVndrCd+"*",colExportInNo+"*",colExportInOrdr+"*",colItemAllCd+"*",colFtaCd+"*",colHsVer,colHsCd,
			colPsr+"*",colReqDtm,colDocuFile,colOriginYn,colConfmSttus,colRecvDt,colStateMsg+","]));
		$("#expViewExCd").val("plntCd,vndrCd,exportInNo,exportInOrdr,itemCd,ftaCd,hsVer,hsCd,psrSumry,reqDtm,docuOrgFile,originYn,approvedState,recvDtm,stateMsg,");
		$("#expViewExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,");
	} else{
		$("#expViewExTit").val(colExportInUsed);
		$("#expViewExCol").val(String([colPlntCd+"*",colVndrCd+"*",colPurchsNo+"*",colSaleOrdr+"*",colItemAllCd+"*",colTaxbilNo,colExportInDt+"*",colInvoiceNo,
		     colCustomExpNo,colSalesNo,colUsedQty])+",");
		$("#expViewExCd").val("plntCd,vndrCd,exportInNo,exportInOrdr,itemCd,taxbilNo,exportInDt,invoiceNo,customExpNo,salesNo,exportInQty,");
		$("#expViewExType").val("cd,cd,cd,cd,cd,cd,cd,cd,cd,cd,floatString,");
	}
}


function chipRenderer(hotInstance, td, row, column, prop, value, cellProperties) {
  Handsontable.renderers.BaseRenderer.apply(this, arguments);
  td.classList.add('chip-cell');
  td.classList.add('text-center');
  switch (value) {
    case "예":
    case "선적 완료":
    case "완료":
      td.innerHTML = `<span class="chip chip-blue">${value}</span>`
      break
    case "진행 중":
      td.innerHTML = `<span class="chip chip-green">${value}</span>`
      break
    case "아니요":
    case "서류 미비":
      td.innerHTML = `<span class="chip chip-red">${value}</span>`
      break
    case "승인 대기":
    case "대기":
    case "예정":
      td.innerHTML = `<span class="chip chip-yellow">${value}</span>`
      break
    default:
      td.innerHTML = ``
      break
  }
}


popupState = false;
function popupRenderer(hotInstance, td, row, column, prop, value, cellProperties) {
  Handsontable.renderers.BaseRenderer.apply(this, arguments);
  if(value === null) return
  td.classList.add('popup-cell');
  td.classList.add('text-center');
  td.innerText = value
  const modal = document.querySelector('.modal')
  const contactModal = document.querySelector('.contact-modal')
  const customerModal = document.querySelector('.customer-modal')
  if (value.includes("신한") && popupState === false) {
    td.addEventListener('click', () => {
      popupState = true
      popupData = value
      const c = cs.map((c, i) => {
        if (c.name === value) {
          return `
            <li class="flex items-center gap-4 py-3">
              <i class="fa-duotone fa-user-tie text-primary-600 text-2xl"></i><p class="font-bold text-xl">${c.name}</p>
            </li>
            <li class="flex items-center gap-4 py-3">
              <i class="fa-duotone fa-phone-office text-primary-600 text-2xl"></i><p class="font-bold text-xl">${c.phone}</p>
            </li>
            <li class="flex items-center gap-4 py-3">
              <i class="fa-duotone fa-envelope text-primary-600 text-2xl"></i><a class="block" href="mailto:${c.email}">${c.email}</a>
            </li>
          `
        }
      })
      modal.classList.remove('hidden')
      modal.classList.add('flex')
      contactModal.classList.remove('hidden')
      contactModal.classList.add('block')
      const csContact = document.querySelector('.cs-contact')
      csContact.innerHTML = c.join('')
    })

  } else if (value.includes("고객사") && popupState === false) {
    // 통관의뢰 action
    const button = document.createElement('button')
    button.type = 'button'
    button.classList.add('apply-button')
    button.innerHTML = '통관의뢰'
    td.innerText = value
    button.addEventListener('click', () => {
      const so = hotInstance.getDataAtCell(row, 3)
      alert(`Invoice번호: ${so} \n 통관 의뢰가 완료되었습니다. `)
    })
    td.appendChild(button)
  } else {
    return
  }
}


function uploaderRenderer(hotInstance, td, row, column, prop, value, cellProperties) {
  Handsontable.renderers.BaseRenderer.apply(this, arguments);
  td.classList.add('uploader-cell');
  td.classList.add('text-center');
  td.innerText = value
  td.addEventListener('click', () => {
    popupState = true
    const modal = document.querySelector('.modal')
    const uploaderModal = document.querySelector('.uploader-modal')
    const fileList = document.querySelector('.file-list')
    modal.classList.remove('hidden')
    modal.classList.add('flex')
    uploaderModal.classList.remove('hidden')
    uploaderModal.classList.add('block')
    fileList.innerHTML = `
      <li class="flex items-center py-1 px-4 rounded justify-between hover:bg-gray-100 duration-150 gap-10">
        <p class="flex items-end gap-2">
          <a
            href="#"
            target="_blank"
            class="font-semibold text-xl underline"
          >
            ${value}
          </a>
          <span class="text-base pl-3 text-gray-400">2023-01-12</span>
          <button type="button" class="delete-button hover:opacity-50 text-rose-600"><i class="fa-regular fa-trash-can"></i></button>
        </p>
        <select
          id="file${row}"
          class="min-w-40 text-primary-700 bg-primary-50 border border-primary-500 hover:bg-primary-200 focus:ring-4 focus:outline-none focus:ring-primary-400 font-medium rounded-lg text-sm px-3 py-1.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
        >
          <option value="">구분</option>
          <option value="bl">BL</option>
          <option value="iv">INVOICE</option>
          <option value="pl">PACKING LIST</option>
          <option value="ot">RECEIPT</option>
        </select>
      </li>
    `
  })
}
Handsontable.renderers.registerRenderer('chip', chipRenderer);
Handsontable.renderers.registerRenderer('popup', popupRenderer);
Handsontable.renderers.registerRenderer('file', uploaderRenderer);

// Modal Action
uploaderButton = document.querySelector('.upload-button')
uploaderButton.addEventListener('click', () => {
	loadedFilesIn = [];
	$("#invoiceNo").val("");
	$("#rptNo").val("");
  const modal = document.querySelector('.modal-popup')
  const uploaderModal = document.querySelector('.uploader-modal')
  modal.classList.remove('hidden')
  modal.classList.add('flex')
  uploaderModal.classList.remove('hidden')
  uploaderModal.classList.add('block')

  const fileList = document.querySelector('.file-list')
  fileList.innerHTML = '';
  
})

modalClose = document.querySelectorAll('.modal-close')
modalClose.forEach((el) => {
  el.addEventListener('click', () => {
    const modal = document.querySelector('.modal-popup')
    const uploaderModal = document.querySelector('.uploader-modal')
    
    modal.classList.remove('flex')
    modal.classList.add('hidden')
    uploaderModal.classList.remove('block')
    uploaderModal.classList.add('hidden')
    popupState = false
  })
}) 

// '업로드' 클릭했을 때
dropzone = document.getElementById('dropzone-file');

dropzone.addEventListener('change', (event) => {
	event.preventDefault(); 
	const files = event.target.files; // 선택된 파일 객체들
	Array.from(files).forEach((file) => {
		 loadedFilesIn.push(file);
	});
    uploadFiles(files); // 파일 업로드 함수 호출
});

dropzone.addEventListener('dragover', (event) => {
	 event.preventDefault(); 
});
  
dropzone.addEventListener('drop', (event) => {
	  event.preventDefault(); 
	  const fileList = event.dataTransfer.files; // Get dropped files
	  const files = Array.from(fileList); // Convert FileList to array
	  Array.from(files).forEach((file) => {
			 loadedFilesIn.push(file);
	  });
	  // Call uploadFiles function to handle file upload
	  uploadFiles(files);
	  
	  const fileInput = document.getElementById('dropzone-file');
      fileInput.files = fileList;
});
// --------------------------------------------------------------------
// 돋보기 클릭한 후 업로드 할 때
dropzoneExpUpload = document.getElementById('dropzone-file-expUpload');
 
dropzoneExpUpload.addEventListener('change', (event) => {
	 event.preventDefault(); 
	 const files = event.target.files; // 선택된 파일 객체들
	 
	 Array.from(files).forEach((file) => {
		 loadedFilesIn.push(file);
	 });
	 
	 uploadFilesExpIn(files); // 파일 업로드 함수 호출
});
 
dropzoneExpUpload.addEventListener('dragover', (event) => {
	 event.preventDefault(); 
});
 
dropzoneExpUpload.addEventListener('drop', (event) => {
	 event.preventDefault(); 
	 const fileList = event.dataTransfer.files; // Get dropped files
	 const files = Array.from(fileList); // Convert FileList to array
	 
	 Array.from(files).forEach((file) => {
		 loadedFilesIn.push(file);
	 });
	 
	 // Call uploadFiles function to handle file upload
	 uploadFilesExpIn(files);
	 
	 const fileInput = document.getElementById('dropzone-file-expUpload');
	 fileInput.files = fileList;
});

function uploadFiles(files) {
 	const fileInput = document.getElementById('dropzone-file');
	const filess = fileInput.files;
	const fileListElement = document.querySelector('.file-list');
	const dropzoneFileInput = document.getElementById('dropzone-file');
    const existingFiles = Array.from(fileListElement.querySelectorAll('li'));
    const currentDate = new Date();
    const formattedDate = `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1).toString().padStart(2, '0')}-${currentDate.getDate().toString().padStart(2, '0')}`;
   
    // 새로운 파일을 기존 목록에 추가
    files.forEach(file => {
      const li = document.createElement('li');
      li.classList.add('flex', 'items-center', 'py-1', 'px-4', 'rounded', 'justify-between', 'hover:bg-gray-100', 'duration-150', 'gap-10');
      li.innerHTML = `
        <p class="flex items-end gap-2">
          <a href="#" target="_blank" class="font-semibold text-xl underline" maxlength='10' style="text-overflow: ellipsis;">${file.name}</a>
          <span class="text-base pl-3 text-gray-400">${formattedDate}</span>
          <button type="button" class="delete-button hover:opacity-50 text-rose-600" onclick="deleteFile(event)"><i class="fa-regular fa-trash-can"></i></button>
        </p>
        <select class="min-w-40 text-primary-700 bg-primary-50 border border-primary-500 hover:bg-primary-200 focus:ring-4 focus:outline-none focus:ring-primary-400 font-medium rounded-lg text-sm px-3 py-1.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
          <option value="bl">BL</option>
          <option value="iv">INVOICE</option>
          <option value="pl">PACKING LIST</option>
          <option value="ot">RECEIPT</option>
        </select>
      `;
      fileListElement.appendChild(li);
    });
}
 
function uploadFilesExpIn(files) {
	 const fileInput = document.getElementById('dropzone-file-expUpload');
	 const filess = fileInput.files;
	 const fileListElement = document.querySelector('.file-list-expUpload');
	 const dropzoneFileInput = document.getElementById('dropzone-file-expUpload');
	 const existingFiles = Array.from(fileListElement.querySelectorAll('li'));
	 const currentDate = new Date();
	 const formattedDate = `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1).toString().padStart(2, '0')}-${currentDate.getDate().toString().padStart(2, '0')}`;
	 files.forEach(file => {
		    var newRowIdx = inListHot.countRows();
		    inListHot.alter('insert_row_below', inListHot.countRows(), 1);
		    const currentDate = new Date();
		    const formattedDate = `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1).toString().padStart(2, '0')}-${currentDate.getDate().toString().padStart(2, '0')}`;
		    var selectHTML = document.createElement('select');
		    selectHTML.className = "min-w-30 text-primary-700 bg-primary-50 border border-primary-500 hover:bg-primary-200 focus:ring-4 focus:outline-none focus:ring-primary-400 font-medium rounded-lg text-sm px-3 py-1.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800";
		    selectHTML.setAttribute('id', 'insertRow' + inListHot.countRows());
		    
		    var option1 = document.createElement('option');
		    option1.value = "bl";
		    option1.text = "BL";
		    var option2 = document.createElement('option');
		    option2.value = "ci";
		    option2.text = "INVOICE";
		    var option3 = document.createElement('option');
		    option3.value = "pl";
		    option3.text = "PACKING LIST";
		    var option4 = document.createElement('option');
		    option4.value = "ot";
		    option4.text = "RECEIPT";
		    selectHTML.appendChild(option1);
		    selectHTML.appendChild(option2);
		    selectHTML.appendChild(option3);
		    selectHTML.appendChild(option4);

		    inListHot.getCellMeta(newRowIdx, 2).renderer = function(instance, td, row, col, prop, value, cellProperties) {
		        Handsontable.renderers.HtmlRenderer.apply(this, arguments);
		        td.appendChild(selectHTML);
		    };
		    
		    inListHot.getCellMeta(newRowIdx, 6).renderer = function(instance, td, row, col, prop, value, cellProperties) {
                td.innerHTML = '<button type="button" class="delete-button hover:opacity-50 text-rose-600" onclick="deleteFileRow('+row+','+col+')"><i class="fa-regular fa-trash-can"></i></button>';
                td.classList.add('htCenter');
            };
		    
		    inListHot.setDataAtCell(newRowIdx, 3, `${file.name}`);
		    inListHot.setDataAtCell(newRowIdx, 4, `${file.name}`);
		    inListHot.setDataAtCell(newRowIdx, 5, formattedDate);
	 });
}

function deleteFile(event) {
	const fileElement = event.target.closest('li');
	if (fileElement) {
	    const ulElement = fileElement.parentNode;
	    const liElements = Array.from(ulElement.children);
	    const index = liElements.indexOf(fileElement);
	    // index 변수에 클릭된 요소의 인덱스가 저장됩니다.
	    loadedFilesIn.splice(index, 1);
	    fileElement.remove();
	}
}
 

function deleteFileRow(row){
  var rowData = inListHot.getSourceDataAtRow(row);
  var fileName = rowData.docuOrgFile;
 
  const index = loadedFilesIn.findIndex(file => file.name === fileName);
  loadedFilesIn.splice(index, 1);
  inListHot.alter('remove_row', row);
}


function fn_fileInSave(){
 	
	const fileList = document.querySelectorAll('.file-list li');
	const fileInput = document.getElementById('dropzone-file');
	const files = fileInput.files;
	const formData = new FormData();
	
	const liFileData = Array.from(fileList).map(fileListItem => {
	    const fileNameElement = fileListItem.querySelector('a');
	    const fileName = fileNameElement.innerText.trim();
	    const fileSelectElement = fileListItem.querySelector('select');
	    const fileType = fileSelectElement.value;
	    return { fileName, fileType };
	});
    
	for (let i = 0; i < loadedFilesIn.length; i++) {
        // 파일명과 파일 유형 추출
        const fileName = loadedFilesIn[i].name;

        // 파일명과 파일 유형이 일치하는 li 요소의 정보를 찾아내기 
        const matchingLiData = liFileData.find(data => data.fileName === fileName);

        if (matchingLiData) {
            if (matchingLiData.fileType === 'iv') {
                formData.append('fileIn[]', loadedFilesIn[i]);
            } else if (matchingLiData.fileType === 'pl') {
                formData.append('filePl[]', loadedFilesIn[i]);
            } else if (matchingLiData.fileType === 'bl') {
                formData.append('fileBl[]', loadedFilesIn[i]);
            } else {
                formData.append('fileOt[]', loadedFilesIn[i]);
            }
        }
    }
	
	formData.append('invoiceNo', $("#invoiceNo").val() );
	formData.append('rptNo', $("#rptNo").val() );
 	
 	
 	const fileInEntries = formData.getAll('fileIn[]');
 	const fileInName = fileInEntries[0].name;
 	if (fileInEntries.length !== 1) {
 	    alert('Invoice 파일은 반드시 한 개가 등록되어야 합니다.');
 	    return;
 	} else {
 		if (!(fileInName.startsWith('CI_') || fileInName.startsWith('ci_')) && $("#invoiceNo").val() == "") {
    	    alert('Invoice의 파일명은 "CI_"로 시작되어야 합니다.');
    	    return;
 	    }
 	}
 	    
   var data = exportInHot.getSourceData();
   for(var i=0; i<data.length; i++){
    	var blno = data[i]["pdf"];
		if(blno == fileInName){
			alert('해당 Invoice 번호로 이미 파일이 등록되어 있습니다.');
			return;
		}
   }  
 	  
   $.ajax({
 		type: 'POST',
 		url: "/export/insertExportFilesInfo.do",
 		data: formData,
 		beforeSend : function(xmlHttpRequest){
 			xmlHttpRequest.setRequestHeader("AJAX", "true");
 		},
 		dataType: 'json',
 		processData: false,
 		contentType: false,
 		success: function (data) {
 			alert('파일이 저장되었습니다.');
 			const modalBl = document.querySelector('.modal-popup')
 			 const uploaderModalBl = document.querySelector('.uploader-modal')
 			 modalBl.classList.remove('flex')
 			 modalBl.classList.add('hidden')
 			 uploaderModalBl.classList.remove('block')
 			 uploaderModalBl.classList.add('hidden')
 			 popupState = false
 			 
 			fn_searchExportIn();
 		},
 		error: function (e, textStatus, jqXHR) {}
 	});
 };

 
 function fn_docuPrint() {
     var downloadFile = inListHot.getSourceData();
     var invoiceNo = downloadFile[0].invoiceNo
     
     $.ajax({
         type: "POST",
         url: "/export/downLoadZipFileInList.do",
         data: JSON.stringify(downloadFile), 
         contentType: 'application/json',
         beforeSend: function(xhr) {
             xhr.setRequestHeader("AJAX", "true");
         },
         success: function() {
            $("#zipInName").val(invoiceNo);
         	document.zipInDownForm.action = "/export/downloadInFile.do";
         	document.zipInDownForm.submit();
         },
         error: function(xhr, status, error) {
             console.error("다운로드 실패:", error);
         }
     });
 }
 
 
function fn_customsRequestExp(row,col){
 	
 	var rowData = exportInHot.getSourceDataAtRow(row);
 	var invoiceNo = rowData.invoiceNo;
 	var cmpnyCd = rowData.type;
 	
 	console.log(invoiceNo);
 	console.log(cmpnyCd);
 	$.ajax({
         type: "POST", 
         url: "/export/exportSendEmail.do",
         data: {
             sendInvoiceNo: invoiceNo,
             sendCmpnyCd: cmpnyCd
         },
         success: function(data) {
             alert("통관 의뢰가 완료되었습니다.");
             fn_searchExportIn();
         },
         error: function(xhr, status, error) {
             console.error("폼 제출 중 오류가 발생했습니다:", error);
         }
     });
}
 
function fn_callTempInvoice(row,col){
	var rowData = exportInHot.getSourceDataAtRow(row);
	var invoiceNo = rowData.invoiceNo;
 
	fn_openInoviceTemp(invoiceNo);
	 
}


function fn_fileExpInSave(){
 	
	var insertExpInFile = inListHot.getSourceData();
	var invoiceNo = insertExpInFile[0].invoiceNo;
	var elements = document.querySelectorAll('[id^="insertRow"]');
	var sData = [];
	
	for (var i = 0; i < insertExpInFile.length; i++) {
		if(insertExpInFile[i].invoiceNo == null){
			sData.push(insertExpInFile[i]);
		}
	}
	
	elements.forEach(function(element, index) {
	    sData[index].docuType = element.value;
	});
	
	console.log(sData);
	const formData = new FormData();
	
	for (let i = 0; i < sData.length; i++) {

        if (sData[i].docuType === 'ci') {
            formData.append('fileIn[]', loadedFilesIn[i]);
        } else if (sData[i].docuType === 'pl') {
            formData.append('filePl[]', loadedFilesIn[i]);
        } else if (sData[i].docuType === 'bl') {
            formData.append('fileBl[]', loadedFilesIn[i]);
        } else {
            formData.append('fileOt[]', loadedFilesIn[i]);
        }
    }
	
	formData.append('invoiceNo', invoiceNo );
	formData.append('rptNo', '' );
	
	$.ajax({
 		type: 'POST',
 		url: "/export/insertExportFilesInfo.do",
 		data: formData,
 		beforeSend : function(xmlHttpRequest){
 			xmlHttpRequest.setRequestHeader("AJAX", "true");
 		},
 		dataType: 'json',
 		processData: false,
 		contentType: false,
 		success: function (data) {
 			alert('파일이 저장되었습니다.');
 			var vData = {};
 			vData["srch1"] = invoiceNo;
 			fn_searchInFilesPopup(vData);
 		
 		},
 		error: function (e, textStatus, jqXHR) {}
 	});

 };
 
 
 
function fn_checkAllExpListPopup(){
	var check = "" ;
	var changeArr = [];
	if ( $("#id_checkAllExpListPopup").prop("checked") == false) {
		check = "yes" ;
		allChecked = true;
	} else {
		check = "no" ;
		allChecked = false;
	}

	var data = inListHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,0,check])
	}
	inListHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_checkAllExpListPopup").prop("checked", true);
	} else {
		$("#id_checkAllExpListPopup").prop("checked", false);
	}
}


function fn_expPopupDelete () {
    var sData = {};
    var rowData = inListHot.getSourceData();
    console.log(rowData);

    if (allChecked == true) {
        if (confirm("등록된 모든 파일을 삭제하시겠습니까?")) {
            for (var i = 0; i < rowData.length; i++) {
                sData["srch1"] = rowData[i].invoiceNo;
            }

            $.ajax({
                type: "POST",
                url: "/export/expPopupDeleteList.do",
                data: sData,
                beforeSend: function(xmlHttpRequest) {
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                },
                dataType: "json",
                success: function(data) {
                	inListHot.alter('remove_row', 0, inListHot.countRows());
                    alert('모든 파일이 삭제되었습니다.');
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
    } else if (allChecked == false) {
        if (confirm("선택한 파일을 삭제하시겠습니까?")) {
            let itemsToDelete = [];
            for (let i = 0; i < rowData.length; i++) {
                if (rowData[i].checkBox === "yes") {
                	sData["srch1"] = rowData[i].invoiceNo;
                    sData["srch2"] = rowData[i].docuFile;
                    sData["srch3"] = rowData[i].uploadDt;
                    itemsToDelete.push(i);
                }
            }

            $.ajax({
                type: "POST",
                url: "/export/deleteExpInFile.do",
                data: sData,
                beforeSend: function(xmlHttpRequest) {
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                },
                dataType: "json",
                success: function(data) {
                    for (let i = itemsToDelete.length - 1; i >= 0; i--) {
                    	inListHot.alter('remove_row', itemsToDelete[i]);
                    }
                    alert('파일이 삭제되었습니다.');
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
}
