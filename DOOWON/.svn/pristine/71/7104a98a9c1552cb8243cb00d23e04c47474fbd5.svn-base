var filesHot;
var filesSettings;
var vendorIndex = 9999;
var vendorScrollTp = true;
var thisDocuOrgFile ="";

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
    $('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);
    
      var date = new Date();
	  var month = date.getMonth();
	  
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'/');
	  
	  $("#files_srch3").val(mtoday);
	  $("#files_srch4").val(today);
	
	
	  var filesElement = document.querySelector('#filesTable');
	  var filesElementContainer = filesElement.parentNode;
	  
	  plntCdList = plntCdList.replace('[','').replace(']','');
	  plntSelect = plntCdList.split(', ');

	  filesHot = new Handsontable(filesElement, filesSettings);

	  $("#btnFilesSave").hide();
	  fn_changeFiles('read');

	//scroll 이벤트
	  $("#filesTable .wtHolder").scroll(function(){
	  	  var scrollTop = $("#filesTable .wtHolder").scrollTop();
	  	  var countPerPage = $("#vendorPageCnt option:selected").val();
	  	  var rowHeight = filesHot.getRowHeight();

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

$(document).mousedown(function(e){
	if(e.target.name == "files1_date" || e.target.name == "files2_date"){
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
$("input[name=vendorType]").change(function(){
	  fn_changeFiles($(this).val());
});

//정렬항목
$("select[name=alignVendor]").change(function(){
	  fn_searchFiles();
});

//row 수
$("select[name=vendorPageCnt]").change(function(){
	  fn_searchFiles();
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
		url : "/tran/selectFilesList.do",
		data : fn_setVendorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = filesHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	filesHot.loadData(meargeJson);
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
		fn_searchFiles();
    }
}

//검색
function fn_searchFiles(){
	vendorIndex = 0;

	$("#fileSrch1").val($("#files_srch1").val());
	$("#fileSrch2").val($("#files_srch2").val());
	$("#fileSrch3").val($("#files_srch3").val());
	$("#fileSrch4").val($("#files_srch4").val());
	$("#fileSrch5").val($("input:radio[name=files_srch5]:checked").val());
	$("#fileSrch6").val($("input:radio[name=files_srch6]:checked").val());
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectFilesList.do",
		data : fn_setVendorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=vendorType]:checked").val() == "enrol"){
        		filesHot.loadData([]);
        		filesHot.alter('insert_row', 1, 1);
        	}else{
        		filesHot.loadData([]);
            	filesHot.loadData(data.resultList);
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
	sData["srch1"] = $("#files_srch1").val();
	sData["srch2"] = $("#files_srch2").val();
	sData["srch3"] = $("#files_srch3").val();
	sData["srch4"] = $("#files_srch4").val();
	sData["srch5"] = $("input:radio[name=files_srch5]:checked").val();
	sData["srch6"] = $("input:radio[name=files_srch6]:checked").val();
	sData["recordCountPerPage"] = $("#vendorPageCnt option:selected").val();
	sData["pageIndex"] = vendorIndex;
	return sData;
};


//검색조건 초기화
function fn_clearVendor(){
	$("#files_srch1").val("");
	$("#files_srch2").val("");
	$("#files_srch3").val("");
	$("#files_srch4").val("");
	$("input:radio[name = 'files_srch5']:radio[value = '']").prop("checked", true);
	$("input:radio[name = 'files_srch6']:radio[value = '']").prop("checked", true);
};

//저장버튼 클릭
function fn_saveFilesCheck(){
	if(filesHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validateFiles();
};

//정합성 체크
function fn_validateFiles(){
	filesHot.validateCells(function(result) {
		if(result){
			fn_saveFilesData();
		}else{
			filesHot.render();
			alert(msgSaveCheck);
		}
    });
};

function fn_showPurchaseFilePop2(){
	if($("#filePopupPc2").length>1){
		$("#filePopupPc2").eq(1).model("show");
		$("#filePopupPc2").eq(0).model("show");
	} 
	$("#filePopupPc2").modal("show");
}


//저장
function fn_saveFilesData(){
	if(!confirm(msgSaveConfirm)){return}
	fn_loading(true);
	var saveVendorData = filesHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/tran/saveFilesInfo.do",
		data : JSON.stringify(saveVendorData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=vendorType]:checked").val() == "enrol"){
        			$("input[name=vendorType]")[0].checked = true;
        			fn_changeFiles($("input[name=vendorType]:checked").val());
        		}
        		$("input:radio[name=vendorType]:input[value='read']").trigger("click");
        		fn_searchFiles();
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
function fn_filesTableCol(){
	var tableType = $("input:radio[name=vendorType]:checked").val();
	
	var docuFileLoadRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		$fileButton = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_fileUpDown('+row+','+col+')"></i>');
		if(value != null || value !=""){
			$(td).empty().append($fileButton).append("  " +value).css("text-align", "center");
		}
	};

	
	var unitPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};
	
	this.filesEditCol = [
		{data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 100, className : "htCenter", validator: notEmptyDataCheck}, 
		{data : 'purchaseNo', type: 'text', className : "htCenter", readOnly:true},
		{data : 'docuOrgFile', type: 'text', className : "htCenter", readOnly:true},
		{data : 'docuFile', readOnly:true},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 20,
									validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}

	];
	this.filesCol = [
		{data : 'purchaseDt', type : 'date', dateFormat: gridCalFormat, width: 100, className : "htCenter", validator: notEmptyDataCheck}, 
		{data : 'purchaseNo', type: 'text', className : "htCenter", readOnly:true},
		{data : 'docuOrgFile', type: 'text', className : "htCenter", renderer:docuFileLoadRenderer, readOnly : true},
		{data : 'docuFile', readOnly : true},
	]
	
}

//테이블 헤더
function fn_filesTableHeader(){

	this.filesHeader = [
		colPurchaseDt,colCustomImpNo+" / "+colTaxbilNo,colFileNm,colFileNm
/*		colVndrCd+"*",colVndrNm+"*",colVndrNmEn+"*",colCorpNo+"*",colZipNb,colAddr1,colAddr1En
*/	];
	this.filesHeaderEdit = [
		colPurchaseDt,colCustomImpNo+" / "+colTaxbilNo,colFileNm,colFileNm,colDelYn+'*'
/*		colVndrCd+"*",colVndrNm+"*",colVndrNmEn+"*",colCorpNo+"*",colZipNb,colAddr1,colAddr1En,colDelYn+'*'
*/		];
}



function fn_fileUpDown(row, col){
	var rowData = filesHot.getSourceDataAtRow(row);
	//파일 업로드
		fn_pcfileDownload2(row);
};

function fn_pcfileDownload2(row){
	var data = filesHot.getSourceDataAtRow(row);
	if(data.docuFile == null || data.docuFile == ""){
		alert(msgFileEmptyMsg);
		return;
	}

	$("#docuOrgFilePc").val(data.docuOrgFile);
	$("#docuFilePc").val(data.docuFile);
	document.fileDownForm.action = "/base/downloadFile.do";
	document.fileDownForm.submit();
};


//테이블 히든컬럼
function fn_filesTableHidden(){
	var tableType = $("input:radio[name=vendorType]:checked").val();

	this.filesHidden =  [3];
}

//handsontable Grid 이벤트
function fn_handsonGridVndrOption(col, header, hidden){
	var tableType = $("input:radio[name=vendorType]:checked").val();

	filesSettings = {
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
	  colWidths: 100,
	 // dropdownMenu : true,
	  
	  contextMenu : (tableType == "enrol") ?  ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
	  filters : true,
	  readOnly : (tableType == "read") ?  true : false,
	  //columnSorting : {indicator : true},
      autoColumnSize : {samplingRatio : 23},
      mergeCells : false,
      wordWrap : true
	};

	return filesSettings;
}

//테이블 타입 변경
function fn_changeFiles(type){
	let filesCol = new fn_filesTableCol();
	let filesHeader = new fn_filesTableHeader();
	let filesHidden = new fn_filesTableHidden();
	var col, header, hidden;


	/*header = filesHeader.filesHeader;*/
	hidden = filesHidden.filesHidden;


	if(type == "edit"){
		col = filesCol.filesEditCol;
		header = filesHeader.filesHeaderEdit;
		$("#btnFilesSave").show();
		$("#vendorExcel").hide();
	}else if(type == "enrol"){
		col = filesCol.filesCol;
		header = filesHeader.filesHeaderEdit;
		$("#btnFilesSave").show();
		$("#vendorExcel").hide();
	}else{
		col = filesCol.filesCol;
		header = filesHeader.filesHeader;
		$("#btnFilesSave").hide();
		$("#vendorExcel").show();
	}
	filesHot.updateSettings(fn_handsonGridVndrOption(col, header, hidden));
	fn_searchFiles();
};

function fn_saveFile(){
	$("input[name=plntCd]").val( $("#files_var1").val() );
	$("input[name=purchaseNo]").val($("input[name=files_var2]").val());
	var file = $("#infoFiles").prop("files")[0];

	if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoForm'));
	
	$.ajax({
		type: 'POST',
		url: "/tran/saveFiles.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data) {
			if(data.result == "success"){
				alert(msgSaveSuccess);
				if($("#filePopupPc2").length>1){
					$("#filePopupPc2").eq(1).model("hide");
					$("#filePopupPc2").eq(0).model("hide");
				}
				$("#filePopupPc2").modal("hide");
			}else{
				alert(msgSaveError);
			}
		},
		error: function (jqXHR) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		alert(msgSaveError);
        	}
		}
	});
};





