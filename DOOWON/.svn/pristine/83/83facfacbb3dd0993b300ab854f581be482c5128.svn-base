var exportCoViewHot;
var exportCoViewSettings;
/*var documentViewPopupSettings;*/
var eportCoViewIndex = 9999;
var eportCoViewScrollTp = true;
var eportCoViewData = {};
var natSelect = [];
var incotermsSelect = [];
var thisNatCd = '';
var thisTaxbilNo = '';
var thisCustomExpNo = '';
var checkBoxRptNo;
var eportCoViewDownloadHot;
var checkData = [];
var rptNoListHot;
var uploaderButtonDocu;
var modalCloseDocu;
var docuDropzone; 
var docuLoadedFiles = [];
var docuCheckAll;
var isAllChecked = false;
var fileDownChecked = false;
var modalFileType;
var modalRptNo;
var modalInvoiceNo;
var modalCoDate;
var modalCoName;

$( document ).ready(function() {
	
      $('.band-calendar').each(function(){ regCal(this) ;})
      $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var date = new Date();
	  var month = date.getMonth();
	  var today = new Date().toISOString().substring(0,10);
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10);
	  
	  $("#exportCoView_srch2").val(mtoday);
	  $("#exportCoView_srch3").val(today);
	  
	  var documentViewElement = document.querySelector('#exportCoViewTable');
	  var documentViewElementContainer = documentViewElement.parentNode;
	  exportCoViewHot = new Handsontable(documentViewElement, exportCoViewSettings);

	  $("#exportCoView_div1").show();
	  $("#btnExportCoSave").hide();
	  fn_changeDocumentView('read');
	  
	  
	  $("#docuTextView").text("전체");
      $("#docuTextView").prepend('<i class="fa-duotone fa-feather text-primary-900"></i>'); 
	 
	  //scroll 이벤트
	  fn_documentViewasEventReg();
	  documentViewUseEventReg();
	  
		
	  var docuListPopupElement = document.querySelector('#docuListPopupTable');
	  var docuListPopupElementContainer = docuListPopupElement.parentNode;
	  docuListPopupSettings = fn_handsonGridDocuListPopupOption();
	  docuListHot = new Handsontable(docuListPopupElement, docuListPopupSettings);
	  
	  /*if(corpNos != 1){
		 $("#uploadDocuDiv").hide();
		 $("#uploadDocuSaveBtn").hide();
	  }*/
	  
});
/** 이벤트 Start **/

/*$("input:radio[name=exportCoView_srch20]").change(function(){
	$("input[name=itemViewType][value=read]").prop("checked", true);
	fn_changeDocumentView("read");
})*/

//검색구분 변경
$("input[name=exportCoView_srch1]").change(function(){

	  fn_changeDocumentView($("#exportCoViewType").val());
	  
	  var radioValue = document.querySelector('input[name="exportCoView_srch1"]:checked').value;
	  if (radioValue === '03') {
		  document.getElementById('blNoLabel').innerText = 'Invoice 번호';
		  document.getElementById('exportCoView_srch7').placeholder = 'Invoice 번호를 입력해주세요.';
		  document.getElementById('poNoLabel').innerText = 'SO 번호';
		  document.getElementById('exportCoView_srch9').placeholder = 'SO 번호를 입력해주세요.';
		  $("#docuTextView").text("수출");
	      $("#docuTextView").prepend('<i class="fa-duotone fa-feather text-primary-900"></i>'); 
        
	  } else {
		  document.getElementById('blNoLabel').innerText = 'B/L 번호';
		  document.getElementById('exportCoView_srch7').placeholder = 'B/L 번호를 입력해주세요.';
		  document.getElementById('poNoLabel').innerText = 'PO 번호';
		  document.getElementById('exportCoView_srch9').placeholder = 'PO 번호를 입력해주세요.';
		  $("#docuTextView").text("수입");
	      $("#docuTextView").prepend('<i class="fa-duotone fa-feather text-primary-900"></i>'); 
	  }
	  fn_changeItemtView($("#itemViewType").val());
});

$(document).mousedown(function(e){	
	if(e.target.name == "exportCoView1_date" || e.target.name == "exportCoView2_date"){
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
$("input[name=exportCoViewType]").change(function(){
	  fn_changeDocumentView($(this).val());
});

function fn_chgDate1() {
	 var date = new Date();
	  var month = date.getMonth();
	  var dayday = date.getDate();
	  var day = date.getDay();
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'-');
	  
	  $("#exportCoView_srch2").val(today);
	  $("#exportCoView_srch3").val(today);
}
function fn_chgDate2() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - day)).toISOString().substring(0,10).replace(/-/g,'-');
 
     $("#exportCoView_srch2").val(mtoday);
     $("#exportCoView_srch3").val(today);
}
function fn_chgDate3() {
	var date = new Date();
	var month = date.getMonth();
	var dayday = date.getDate();
	var day = date.getDay();
	var today = new Date().toISOString().substring(0,10).replace(/-/g,'-');
	var mtoday = new Date(new Date().setDate(dayday - dayday + 1)).toISOString().substring(0,10).replace(/-/g,'-');

    $("#exportCoView_srch2").val(mtoday);
    $("#exportCoView_srch3").val(today);
}
function fn_chgDate4() {
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

    $("#exportCoView_srch2").val(mtoday);
    $("#exportCoView_srch3").val(today);
}

//정렬항목
/*$("select[name=alignImportView]").change(function(){
	  fn_searchImportView();
});
*/

function fn_setDocumentView(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=exportCoView_srch1]:checked").val(); //srch1: 검색구분
	sData["srch2"] = $("#exportCoView_srch7").val(); // invoice번호 
	sData["srch3"] = $("#exportCoView_srch6").val(); //신고번호
	sData["srch4"] = $("input[name=exportCoView1_date]").val(); // 시작일자
	sData["srch5"] = $("input[name=exportCoView2_date]").val(); // 종료일자
	sData["srch7"] = $("select[name=exportCoView_day]").val(); // 검색기간
	sData["recordCountPerPage"] = $("#documentViewPageCnt option:selected").val();
	sData["pageIndex"] = eportCoViewIndex;
	
	console.log("sData"+sData);
	console.log("sData",sData);
	return sData;
};

//검색 버튼 클릭 시 호출되는 함수
function fn_searchCoDocuView(){
	fn_loading(true);
	eportCoViewIndex = 0;
	var sData = fn_setDocumentView();
	console.log("sData2"+sData);
	console.log("sData2",sData);
	
	$.ajax({
		type : "POST",
		url : "/export/selectCoList.do",
		data : JSON.stringify(sData),
		contentType: "application/json; charset=utf-8",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	exportCoViewHot.loadData([]);
        	exportCoViewHot.loadData(data.resultList);
        	if (sData["srch1"] === "02") {
                var imptotCnt = (data.resultList.length > 0) ? data.resultList[0].cnt : 0;
            	$("#documentViewCnt").text(imptotCnt);
            } else if (sData["srch1"] === "03") {
            	var exptotCnt = (data.resultList.length > 0) ? data.resultList[0].cnt : 0;
            	$("#documentViewCnt").text(exptotCnt);
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
        	fn_loading(false);
        }
	});
};


//row 수
$("select[name=documentViewPageCnt]").change(function(){
	fn_searchCoDocuView();
});


// 스크롤할 때 행이 자동으로 추가 로드될 수 있게 하는 함수
function fn_documentViewasEventReg(){
   $("#exportCoViewTable .wtHolder").scroll(function(){
  	  var scrollTop = $("#exportCoViewTable .wtHolder").scrollTop();
  	  var countPerPage = $("#documentViewPageCnt option:selected").val();
  	  var rowHeight = exportCoViewHot.getRowHeight();
  	  var addCnt = 750;
  	  if(countPerPage == "50"){
  		  addCnt = 750;
  	  }else if(countPerPage == "100"){
  		  addCnt = 1990;
  	  }else if(countPerPage == "200"){
  		  addCnt = 4490;
  	  }else if(countPerPage == "500"){
  		  addCnt = 11990;
  	  }
  	  if(eportCoViewScrollTp && eportCoViewIndex != 9999 && scrollTop >= (countPerPage * eportCoViewIndex * rowHeight) + addCnt){
  		  fn_documentViewScroll();
  	  }
   });
}


//스크롤
function fn_documentViewScroll(){
	fn_loading(true);
	eportCoViewScrollTp = false;
	eportCoViewIndex++;
	
	
	var sData = fn_setDocumentView();
	
	
	$.ajax({
		type : "POST",
		url : "/export/selectCoList.do",
		data : JSON.stringify(sData),
		contentType: "application/json; charset=utf-8",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	
        	var getData = exportCoViewHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	exportCoViewHot.loadData(meargeJson);
        	eportCoViewScrollTp = true;
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
function documentViewUseEventReg(){
	$("#popUsedTable .wtHolder").scroll(function(){
	  fn_popUsedStories(row, col)
	  var data = exportViewHot.getSourceData();
	  var scrollTop = $("#popUsedTable .wtHolder").scrollTop();
	  var countPerPage = 50;
	  var rowHeight = jdgmntUsageHot.getRowHeight();
	  var addCnt = 790;

	  if(documentViewPopScrollTp && eportCoViewIndex != 9999 && scrollTop >= (countPerPage * eportCoViewIndex * rowHeight) + addCnt){
		  fn_documentViewPopScroll(data[row]);
	  }
   });
}


function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchCoDocuView();
    }
}


//검색조건 초기화
function fn_clearDocuView(){
	$("#exportCoView_srch2").val("");
	$("#exportCoView_srch3").val("");
	$("#documentView_srch4").val("");
	$("#documentView_srch5").val("");
	$("#exportCoView_srch6").val("");
	$("#exportCoView_srch7").val("");
	/*$("#exportCoView_srch9").val("");*/
};


//테이블 컬럼
function fn_exportCoViewTableCol(){
	var searchType = $("input:radio[name=exportCoView_srch1]:checked").val();
	var tableType = $("input:radio[name=exportCoViewType]:checked").val();
	var docuFileLoadRenderer = function(instance, td, row, col, prop, value, cellProperties) {
        var $fileButton;
        
        var fileType = (prop === 'coFile') ? 'coFile' : 'summitFile'
        /*if (value != '' && value != null) {*/
            $fileButton = $('<i class="fa-solid fa-magnifying-glass" style="cursor:pointer;" onclick="fn_docuGlassesBtn(\'' + fileType + '\', ' + row + ', ' + col + ')"></i>');
       /* }*/
        $(td).empty().append($fileButton).append("  " + value);
	};
	var pkNoneEdit = function(instance, td, row, col, prop, value, cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	

		this.exportCoViewCol = (tableType == "read") ? [
			{data : 'checkBox', type : 'text', className : "htCenter", width: 60, type: 'checkbox', checkedTemplate: 'yes', uncheckedTemplate: 'no', readOnly:false},
			{data : 'state', className : "htCenter", width: 160, readOnly:true},
			{data : 'subNum', className : "htCenter", width: 150, readOnly:true},
			{data : 'coDate', className : "htCenter",width: 150, wordWrap: false, readOnly:true},
			{data : 'formatDate', className : "htCenter",width: 150, wordWrap: false, readOnly:true},
			{data : 'coName', className : "htCenter", width: 150, readOnly:true},
			{data : 'invoiceNo', className : "htCenter", width: 150, readOnly:true},
			{data : 'rptNo', className : "htCenter", width: 150, readOnly:true},
			{data : 'lisDay', className : "htCenter", width: 150, readOnly:true},
			{data : 'producer', className : "htCenter", width: 150, readOnly:true},
			{data : 'importCountry', className : "htCenter", width: 150, readOnly:true},
			{data : 'importer', className : "htCenter", width: 150, readOnly:true},
			{data : 'impgname', className : "htCenter", width: 150, readOnly:true},
			{data : 'qty', className : "htCenter", width: 150, readOnly:true},
			{data : 'ut', className : "htCenter", width: 150,  readOnly:true},
			{data : 'amt', className : "htCenter", width: 150,  readOnly:true},
			{data : 'concod', className : "htCenter", width: 150,  readOnly:true},
			{data : 'hscode', className : "htCenter", width: 150,  readOnly:true},
			{data : 'deterOrigin', className : "htCenter", width: 150,  readOnly:true},
			{data : 'freeName', className : "htCenter", width: 150,  readOnly:true},
			{data : 'issueNo', className : "htCenter", width: 150,  readOnly:true},
			{data : 'issueDate', className : "htCenter", width: 150,  readOnly:true},
			{data : 'coFile', className : "htCenter", width: 100,  readOnly:true , renderer : docuFileLoadRenderer},
			{data : 'summitFile', className : "htCenter", width: 100, readOnly:true , renderer : docuFileLoadRenderer},
			{data : 'issuanceCost', className : "htCenter", width: 150, readOnly:true},
			{data : 'judgmentCost', className : "htCenter", width: 150,  readOnly:true}
		] : [
			{data : 'checkBox', type : 'text', className : "htCenter", width: 60, type: 'checkbox', checkedTemplate: 'yes', uncheckedTemplate: 'no', readOnly:false},
			{data : 'state', type: 'dropdown', source: ['의뢰', '판정', '접수','정정','승인','발송','재발급'], className : "htCenter", width: 160},
			{data : 'subNum', className : "htCenter", width: 150},
			{data : 'coDate', className : "htCenter",width: 150, wordWrap: false, readOnly:true, renderer : pkNoneEdit},
			{data : 'formatDate', className : "htCenter",width: 150, wordWrap: false, readOnly:true, renderer : pkNoneEdit},
			{data : 'coName', className : "htCenter", width: 150,  readOnly:true, renderer : pkNoneEdit},
			{data : 'invoiceNo', className : "htCenter", width: 150},
			{data : 'rptNo', className : "htCenter", width: 150},
			{data : 'lisDay',type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 150},
			{data : 'producer', className : "htCenter", width: 150, },
			{data : 'importCountry', className : "htCenter", width: 150},
			{data : 'importer', className : "htCenter", width: 150},
			{data : 'impgname', className : "htCenter", width: 150},
			{data : 'qty', className : "htCenter", width: 150},
			{data : 'ut', className : "htCenter", width: 150},
			{data : 'amt', className : "htRight", width: 150},
			{data : 'concod', className : "htCenter", width: 150},
			{data : 'hscode', className : "htCenter", width: 150},
			{data : 'deterOrigin', className : "htCenter", width: 150},
			{data : 'freeName', className : "htCenter", width: 150},
			{data : 'issueNo', className : "htCenter", width: 150},
			{data : 'issueDate', type : 'date', dateFormat: gridCalFormat,className : "htCenter", width: 150},
			{data : 'coFile', className : "htCenter", width: 100, readOnly:true , renderer : docuFileLoadRenderer},
			{data : 'summitFile', className : "htCenter", width: 100,  readOnly:true , renderer : docuFileLoadRenderer},
			{data : 'issuanceCost', className : "htRight", width: 150},
			{data : 'judgmentCost', className : "htRight", width: 150}
		];
	}



function chipRenderer(hotInstance, td, row, column, prop, value, cellProperties) {
	Handsontable.renderers.BaseRenderer.apply(this, arguments);
	td.classList.add('chip-cell');
	td.classList.add('text-center');
	switch (value) {
	   case "수출":
		 td.innerHTML = `<span class="chip chip-blue">${value}</span>`
	     break
	   case "수입":
	     td.innerHTML = `<span class="chip chip-yellow">${value}</span>`
	     break
	   default:
	     td.innerHTML = ``
	     break
	}
}


//테이블 헤더
function fn_exportCoViewTableHeader(){
	var tableType = $("input:radio[name=documentViewType]:checked").val(); 
	//var searchType = $("input:radio[name=exportCoView_srch1]:checked").val(); 
	// 사용여부
	//var exportCoView_srch20 = $("input:radio[name=exportCoView_srch20]:checked").val(); 
	
	
	this.exportCoViewHeader = [
		"", "상태",
		"제출번호","", "CO요청일자", "요청자", "Invoice번호", "수출신고번호", "수리일자", "생산자", "수입국", "수입자", "품명", "수량", "단위", "금액", "인코텀즈", "HSCODE", "원산지결정기준"
		,"자유무역협정명칭","발급번호","발급일자","원산지증명서","제출서류","판정비용","발행비용"
		]; 
	
}


//테이블 히든컬럼
function fn_exportCoViewTableHidden(){
	var tableType = $("input:radio[name=documentViewType]:checked").val();
	this.exportCoViewHidden = [3];
}


//table
function fn_handsonGridViewOption(col, header, hidden){
	var tableType = $("input:radio[name=documentViewType]:checked").val();
	var tableType2 = $("input:radio[name=exportCoView_srch1]:checked").val();

	exportCoViewSettings = {
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
	  rowHeights : 25,
	  rowHeaders : true,
	  columnHeaderHeight : 25,
	  manualRowResize : true,
	  manualColumnResize : true,
	  manualRowMove : true,
	  manualColumnMove : false,
	  fixedColumnsLeft: 1,
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
      afterGetColHeader: function(col, TH){
        	if(col == 0){
          	TH.innerHTML = "<input type='checkbox'  class='checker' id='id_checkDocuAll' onclick='fn_docuAllClick();'>";
          }
        }
	};

	return exportCoViewSettings;
}




//테이블 타입 변경
function fn_changeDocumentView(type){

	var searchTp = $("input:radio[name=exportCoView_srch1]:checked").val();

	if(type == "edit"){
			$("#btnDocumentViewSave").show();
			$("#btnExportCoExcel").hide();
			$("#btnExportCoSave").show();
			fn_changeDocumentViewType(searchTp);
	}else{
		exportCoViewHot.updateSettings({readOnly:true, contextMenu : false});
		$("#btnExportCoExcel").show();
		$("#btnExportCoSave").hide();
		fn_changeDocumentViewType(searchTp);
	}
	
	exportCoViewHot.render();

};

//검색구분 변경
function fn_changeDocumentViewType(type){
	var tableType = $("input:radio[name=exportCoViewType]:checked").val();
	let exportCoViewCol = new fn_exportCoViewTableCol();
	let exportCoViewHeader = new fn_exportCoViewTableHeader();
	//let documentSearchHeader = new fn_documentSearchTableHeader();
	let exportCoViewHidden = new fn_exportCoViewTableHidden();
	
	var col, header, hidden, col2, header2, hidden2, col3, header3, hidden3 ;

	//$('#alignImportView option:eq(0)').prop('selected', true);

	
	//fn_searchGridPurchOption(true);
	col = exportCoViewCol.exportCoViewCol;
	header = exportCoViewHeader.exportCoViewHeader;
	hidden = exportCoViewHidden.exportCoViewHidden;
	//searchHeader = documentSearchHeader.documentSearchHeader;
	
	exportCoViewHot.updateSettings(fn_handsonGridViewOption(col, header, hidden));

	exportCoViewHot.render();
	fn_searchCoDocuView();
};

modalCloseDocu = document.querySelectorAll('.modal-close');

modalCloseDocu.forEach((el) => {
	 el.addEventListener('click', () => {
	 const modalDocu = document.querySelector('.modal-popup-docu')
	 //const contactModal = document.querySelector('.contact-modal')
	 const uploaderModalDocu = document.querySelector('.uploader-modal-docu')
	 modalDocu.classList.remove('flex')
	 modalDocu.classList.add('hidden')
	 uploaderModalDocu.classList.remove('block')
	 uploaderModalDocu.classList.add('hidden')
	 popupState = false
	 })
})

// 드롭다운 
dropzoneDocu = document.getElementById('dropzone-file-docu');

// 파일이 추가되었을 때 이벤트 처리
dropzoneDocu.addEventListener('change', (event) => {
	event.preventDefault(); 
	const files = event.target.files; // 선택된 파일 객체들
	Array.from(files).forEach((file) => {
    	docuLoadedFiles.push(file);
    });
	
    uploadFilesDocu(files);
});

dropzoneDocu.addEventListener('dragover', (event) => {
	 event.preventDefault(); 
});
  
dropzoneDocu.addEventListener('drop', (event) => {
     event.preventDefault(); 
     const fileList = event.dataTransfer.files; // Get dropped files
     const files = Array.from(fileList); // Convert FileList to array
  
     Array.from(files).forEach((file) => {
    	docuLoadedFiles.push(file);
     });
     uploadFilesDocu(files);
     
     const fileInput = document.getElementById('dropzone-file-docu');
     fileInput.files = fileList;
});

 

function uploadFilesDocu(files) {
	
	const fileInput = document.getElementById('dropzone-file-docu');
	const filess = fileInput.files;
	const fileListElement = document.querySelector('.file-list-docu');
	const dropzoneFileInput = document.getElementById('dropzone-file-docu');
    // 기존 파일 목록을 가져옴
    const existingFiles = Array.from(fileListElement.querySelectorAll('li'));
    // 현재 날짜를 가져와서 포맷팅
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
       <select class="min-w-40 text-primary-700 bg-primary-50 border border-primary-500 hover:bg-primary-200 focus:ring-4 focus:outline-none focus:ring-primary-400 font-medium rounded-lg text-sm px-3 py-1.5 text-center inline-flex items-center justify-between dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800" >
	      <option value="dc">신고필증</option>
    	  <option value="cb">통합</option>
    	  <option value="cb">정정 통합</option>
	      <option value="ci">INVOICE</option>
	      <option value="pl">PACKING LIST</option>
	      <option value="bl">BL</option>
	      <option value="co">원산지증명서</option>
	      <option value="rq">요건 서류</option>
	      <option value="ot">기타</option>
	      <option value="ac">정산서</option>
       </select>
      `;
      fileListElement.appendChild(li);
    });
}


function deleteFile(event) {
    const fileElement = event.target.closest('li');
    if (fileElement) {
	   const ulElement = fileElement.parentNode;
	   const liElements = Array.from(ulElement.children);
	   const index = liElements.indexOf(fileElement);
	   docuLoadedFiles.splice(index, 1);
	   fileElement.remove();
    }
}

//파일 업로드
function fn_fileDocuSave(){
    const fileInput = document.getElementById('dropzone-file-docuUpload');
    const files = fileInput.files; // 파일 리스트 가져오기
    const formData = new FormData();
    const rowData = docuListHot.getSourceData(); // 테이블 데이터 가져오기
   
    // 필요한 데이터 추가
    formData.append('fileType', modalFileType);
    formData.append('coDate', modalCoDate);
    formData.append('coName', modalCoName);
    formData.append('rptNo', modalRptNo || ''); // rptNo가 undefined인 경우 공백 추가
    formData.append('invoiceNo', modalInvoiceNo || ''); // invoiceNo가 undefined인 경우 공백 추가

    // 업로드된 파일 추가
    for (let i = 0; i < files.length; i++) {
        formData.append('files', files[i]); // 'files'는 서버에서 받을 필드 이름
    }
    
    // 테이블에서 guide가 '2'인 파일만 추가
    const filteredFiles = rowData.filter(row => row.guide === '2');
    if (filteredFiles.length === 0) {
        alert('새로 저장할 파일이 없습니다.');
        return;
    }
    
    
    filteredFiles.forEach((row, index) => {
        if (row.docuFile) {
            formData.append(`files[${index}].docuFile`, row.docuFile); // 파일 이름
        }
    });
    
    
    
    // liFileData 추가 (JSON 형식으로 전달)
    for (let [key, value] of formData.entries()) {
        console.log(`${key}:`, value);
    }
    
    
    
	$.ajax({
		type: 'POST',
		url: "/export/insertDocuFilesInfo.do",
		data: formData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data) {
			
			const modalDocu = document.querySelector('.modal-popup-docu')
			const uploaderModalDocu = document.querySelector('.uploader-modal-docu')
			modalDocu.classList.remove('flex')
			modalDocu.classList.add('hidden')
			uploaderModalDocu.classList.remove('block')
			uploaderModalDocu.classList.add('hidden')
			popupState = false
			alert('파일이 저장되었습니다.');
			filecoDocuListClose();
			fn_searchCoDocuView();
		},
		error: function (e, textStatus, jqXHR) {}
	});
};





function fn_docuAllClick(){
	var check = "" ;
	var changeArr = [];
	if ( $("#id_checkDocuAll").prop("checked") == false) {
		check = "yes" ;
	} else {
		check = "no" ;
	}

	var data = exportCoViewHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,0,check])
	}
	exportCoViewHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_checkDocuAll").prop("checked", true);
	} else {
		$("#id_checkDocuAll").prop("checked", false);
	}
}

// 돋보기
function fn_docuGlassesBtn(fileType,row, col){
	isAllChecked = false;
	modalInvoice = "";
	modalRptNo = "";
	console.log("fileType"+fileType);
	var data = exportCoViewHot.getSourceDataAtRow(row);
    modalInvoice = data.invoiceNo;
    modalRptNo = data.rptNo;
    modalCoDate = data.coDate;
    modalCoName = data.coName;
    modalFileType = fileType;
    docuLoadedFiles = [];
	$("#docuFileListPopUp").modal("show");

    var sData = fn_docuForPopup(data,fileType);
    
    var text = "";
   
    if (modalInvoice && modalRptNo) {
        // 둘 다 있을 때
        text = "Invoice 번호: " + modalInvoice + " / 신고번호: " + modalRptNo.replace(/-/g, '');
    } else if (modalInvoice) {
        // Invoice 번호만 있을 때
        text = "Invoice 번호: " + modalInvoice;
    } else if (modalRptNo) {
        // 신고번호만 있을 때
        text = "신고번호: " + modalRptNo.replace(/-/g, '');
    } else {
        // 둘 다 없을 때
        text = "";
    }
    
    var uploadDocuImpFileListTitle = document.querySelector('.modal-content .docuModal-title span');
	uploadDocuImpFileListTitle.textContent = text;
    
    
    let docuListPopupCol = new fn_docuListPopupCol();
	let docuListPopupHeader = new fn_docuListPopupHeader();
	
	var col, header;
	
	col = docuListPopupCol.docuListPopupCol;
	header = docuListPopupHeader.docuListPopupHeader;
    
    docuListHot.updateSettings(fn_handsonGridDocuListPopupOption(col, header));
    
    fn_searchCoListFilesPopup(sData);
};


function fn_docuForPopup(selectedRow,fileType){
	
	var sData = {};
	
	sData["srch1"] = selectedRow["rptNo"] || '';
	sData["srch2"] = selectedRow["invoiceNo"] || '';
	sData["srch3"] = selectedRow["orgFileName"];
	sData["srch4"] = fileType;
	sData["srch5"] = selectedRow["coDate"];
	sData["srch6"] = selectedRow["coName"];
	return sData;
}

function filecoDocuListClose(){
	$("#docuFileListPopUp").modal("hide");
}

// 팝업리스트
function fn_searchCoListFilesPopup(sData){
	var searchTp = $("input:radio[name=exportCoView_srch1]:checked").val();
	
	console.log("sData2",sData);
	
	
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/export/selectFileModalUpdateList.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	docuListHot.loadData([]);
        	docuListHot.loadData(data.resultList);
			setTimeout(function() {docuListHot.render()}, 200);
			fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        		location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});
}

function fn_docuListPopupCol(){
		this.docuListPopupCol =  [
			{ data : 'checkBox', type : 'text', width:30, className : "htCenter",type: 'checkbox', checkedTemplate: 'yes', uncheckedTemplate: 'no', readOnly:false},
			{ data: 'guide', type: 'text', className: "htCenter", readOnly: true },
			{ data: 'docuFile', type: 'text', className: "htCenter", readOnly: true },
            { data: 'docuOrgFile', type: 'text', width:250 , className: "htCenter", readOnly: true },
            { data: 'uploadDt', type: 'text', width:80, className: "htCenter", readOnly: true },
           // { data: 'docuPath', type: 'text', className: "htCenter", readOnly: true },
		];
}

function fn_docuListPopupHeader(){
	
	this.docuListPopupHeader =
	 ["",'가이드','파일명2','파일명','업로드 일자'/*,'path'*/];
};


function fn_handsonGridDocuListPopupOption(col, header) {
	docuListPopupSettings = {
        columns: col,
        stretchH: 'all',
        width: '100%',
        autoWrapRow: true,
        height: 250,
        rowHeights: 25,
        rowHeaders: true,
        columnHeaderHeight: 25,
        colHeaders: header,
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
        hiddenColumns: { copyPasteEnabled: false, indicators: false, columns: [/*1*/,2/*,5*/]},
        afterGetColHeader: function(col, TH){
        	if(col == 0){
          	TH.innerHTML = "<input type='checkbox' class='checker' id='id_checkAllDocuListPopup' onclick='fn_checkAllDocuListPopup();'>";
          }
        }
    };

    return docuListPopupSettings;
}

// --------------------- 신고번호 돋보기 모달 내 파일 업로드 팝업창 ---------------------
dropzoneDocuImpUpload = document.getElementById('dropzone-file-docuUpload');

dropzoneDocuImpUpload.addEventListener('change', (event) => {
	 event.preventDefault(); 
	 const files = event.target.files; // 선택된 파일 객체들
	 Array.from(files).forEach((file) => {
		 docuLoadedFiles.push(file);
	 });
	 
	 uploadFilesDocuImp(files); // 파일 업로드 함수 호출
});

 
dropzoneDocuImpUpload.addEventListener('dragover', (event) => {
	 event.preventDefault(); 
});
 
dropzoneDocuImpUpload.addEventListener('drop', (event) => {
	 event.preventDefault(); 
	 const fileList = event.dataTransfer.files; 
	 const files = Array.from(fileList);
	 Array.from(files).forEach((file) => {
		 docuLoadedFiles.push(file);
	 });
	 
	 uploadFilesDocuImp(files);
	 
	 const fileInput = document.getElementById('dropzone-file-impUpload');
	 fileInput.files = fileList;
});

function uploadFilesDocuImp(files) {
    const currentDate = new Date();
    const formattedDate = `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1)
        .toString().padStart(2, '0')}-${currentDate.getDate().toString().padStart(2, '0')}`;
    
    files.forEach(file => {
        console.log("Adding File:", file.name); // 파일 이름 확인
        
        const newRowIdx = docuListHot.countRows();
        docuListHot.alter('insert_row_below', newRowIdx); // 새로운 행 추가
        
        docuListHot.setDataAtCell(newRowIdx, 3, file.name); // 파일 이름
        docuListHot.setDataAtCell(newRowIdx, 1, '2'); // 가이드 번호
        docuListHot.setDataAtCell(newRowIdx, 4, formattedDate); // 업로드 날짜
    });

    docuListHot.render(); // 테이블 강제 렌더링
}


/*function fn_fileDocuModalSave() {
	
	if(docuLoadedFiles.length == 0){
		alert("저장할 파일이 없습니다.")
		return;
	}
	
 	var rptNo = "";
 	var invoiceNo = "";
 	var fileType = "";
 	var coDate = "";
 	var coName = "";
 	
	var insertDocuFile = docuListHot.getSourceData();
	
	rptNo = modalRptNo;
	invoiceNo = modalInvoiceNo;
	fileType = modalFileType;
	coDate = modalCoDate;
	coName = modalCoName;
	
	
	$.ajax({
 		type: 'POST',
 		url: "/export/insertDocuFilesInfo.do",
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
 			vData["srch1"] = rptNo;
 			vData["srch2"] = blNo;
 			vData["srch4"] = invoiceNo;
 			fn_searchCoListFilesPopup(vData);
 			fn_searchCoDocuView();
 			docuLoadedFiles = [];
 		},
 		error: function (e, textStatus, jqXHR) {}
 	});
};
 */

function fn_checkAllDocuListPopup(){
	var check = "" ;
	var changeArr = [];
	if ( $("#id_checkAllDocuListPopup").prop("checked") == false) {
		check = "yes" ;
		isAllChecked = true;
	} else {
		check = "no" ;
		isAllChecked = false;
	}

	var data = docuListHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,0,check])
	}
	docuListHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_checkAllDocuListPopup").prop("checked", true);
	} else {
		$("#id_checkAllDocuListPopup").prop("checked", false);
	}
}

// 파일 다운로드
function fn_coDocuPopupDownload() {
	var searchTp = $("input:radio[name=exportCoView_srch1]:checked").val();
    var rowData = docuListHot.getSourceData();
    var cnt = 0;
    var docuFiles = [];
    // 현재 날짜 가져오기
    const now = new Date();

    // yymmdd 형식으로 변환
    const year = now.getFullYear().toString().slice(-2); // 뒤의 2자리
    const month = (now.getMonth() + 1).toString().padStart(2, '0'); // 월 (2자리)
    const day = now.getDate().toString().padStart(2, '0'); // 일 (2자리)
    const formattedDate = `${year}${month}${day}`;
    
    for (let i = 0; i < rowData.length; i++) {
        if (rowData[i].checkBox === "yes") {
            cnt++;
            //rowData[i].docuType = modalFileType;
            docuFiles.push(rowData[i]);
        }
    }
    
    if (cnt == 0) {
        alert("다운로드할 파일을 선택해 주세요.");
        return;
    }
    
    if (cnt == 1) { // 단일 파일 다운로드
    	console.log("docuFiles",docuFiles);
    	
    	$("#docuPath").val('/home/files');
        $("#docuFile").val(docuFiles[0].docuFile);
        $("#docuOrgFile").val(docuFiles[0].docuOrgFile);
        document.downloadFileOne.action = "/base/downloadFile.do";
        document.downloadFileOne.submit();
    } else {
    	var zipName = "";
        $.ajax({
            type: "POST",
            url: "/export/downloadCoFileZip.do",
            data: JSON.stringify(docuFiles),
            contentType: 'application/json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("AJAX", "true");
            },
            success: function(response) {
                if (response === "fail") {
                    alert("다운로드할 파일을 확인해 주세요.");
                    return;
                }
                const delay = 1000;
                if(modalFileType == 'coFile'){
                	 zipName = "FTA document" + "_" +formattedDate ;
                }else{
                	 zipName = "FTA document" + "_" + formattedDate;
                }
                $("#zipDownloadName").val(zipName);
                document.zipDownloadForm.action = "/export/downloadCoDocuFile.do";
                document.zipDownloadForm.submit();
            },
            error: function(xhr, status, error) {
                console.error("다운로드 실패:", error);
            }
        });
    }
}

function fn_coDocuPopupDelete() {
	var rowData = docuListHot.getSourceData();
	
	let itemsToDelete = [];
	let itemsToDeleteDB = []; // guide가 1인 경우 (DB에 저장된 항목들)
    let itemsToDeleteClient = []; // guide가 2인 경우 (클라이언트에서만 삭제할 항목들)
    var cnt = 0;

    // 삭제할 항목 분류
    for (let i = 0; i < rowData.length; i++) {
        if (rowData[i].checkBox === "yes") {
            cnt++;
            if (rowData[i].guide === "1") {
            	 rowData[i].docuType  = modalFileType;
                 itemsToDeleteDB.push(rowData[i]); // guide가 1인 항목
            } else if (rowData[i].guide === "2") {
                itemsToDeleteClient.push(i); // guide가 2인 항목의 인덱스
            }
        }
    }
    
    
    
    if (cnt == 0){
    	alert("선택된 파일이 없습니다.");
    	return;
    }
    console.log("modal"+modalFileType);
    console.log("JSON.stringify(itemsToDeleteDB)"+JSON.stringify(itemsToDeleteDB));
    if (confirm("파일을 삭제하시겠습니까?")) {
        // 1.서버에 저장된 파일 삭제 요청(guide가 1일때)
    	if(itemsToDeleteDB.length > 0){
    		$.ajax({
                type: "POST",
                url: "/export/deleteCoDocuFile.do",
                data: JSON.stringify(itemsToDeleteDB),
                contentType: 'application/json',
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("AJAX", "true");
                },
                success: function(data) {
                    // 삭제 성공 시 해당 항목 삭제
                   
                	for (let i = itemsToDeleteDB.length - 1; i >= 0; i--) {
                        const rowIndex = rowData.findIndex(row => row === itemsToDeleteDB[i]);
                        if (rowIndex > -1) {
                            docuListHot.alter('remove_row', rowIndex);
                        }
                    }
                    alert("파일이 삭제되었습니다.");
                    filecoDocuListClose();
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
    	
    	 // 2. 클라이언트에서만 삭제 (guide가 2인 항목)
        if (itemsToDeleteClient.length > 0) {
            for (let i = itemsToDeleteClient.length - 1; i >= 0; i--) {
                docuListHot.alter('remove_row', itemsToDeleteClient[i]); // 클라이언트 행 삭제
            }
            console.log('클라이언트에서 업로드된 파일이 삭제되었습니다.');
        }
    } 
}

