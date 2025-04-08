var noticeHot;
var noticeSettings;
var noticeIndex = 9999;
var noticeScrollTp = true;

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	$('.band-calendar').each(function(){ regCal(this) ;})

	//캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat, {
    	defaultDate: moment()
    });

	var noticeElement = document.querySelector('#noticeTable');
	var noticeElementContainer = noticeElement.parentNode;

	noticeHot = new Handsontable(noticeElement, noticeSettings);
	fn_changeNoticeType('');
	fn_searchNotice();

	//스크롤 이벤트
	$("#noticeTable .wtHolder").scroll(function(){
		  var scrollTop = $("#noticeTable .wtHolder").scrollTop();
		  var countPerPage = $("#noticePageCnt option:selected").val();
		  var rowHeight = noticeHot.getRowHeight();

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

		  if(noticeScrollTp && noticeIndex != 9999 && scrollTop >= (countPerPage * noticeIndex * rowHeight) + addCnt){
			  fn_noticeScroll();
		  }
	});
});
/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-notice").hasClass("active")) {
//			fn_searchNotice();
//		}
//	}
//})

//달력 창 닫기

$(document).mousedown(function(e){
	if(e.target.name == "notice1_date" || e.target.name == "notice2_date"){
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


//정렬항목
$("select[name=alignNotice]").change(function(){
	  fn_searchNotice();
});

//row 수
$("select[name=noticePageCnt]").change(function(){
	  fn_searchNotice();
});


/** 이벤트 End **/

//스크롤
function fn_noticeScroll(){
	if($("input[name=noticeType]:checked").val() == "enrol")
		return;
	noticeScrollTp = false;
	noticeIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectNoticeList.do",
		data : fn_setNoticeForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = noticeHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	noticeHot.loadData(meargeJson);

        	noticeScrollTp = true;
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
		fn_searchNotice();
    }
}

//검색
function fn_searchNotice(){
	noticeIndex = 0;

	var valid = fn_validateSearchDate($("input[name=notice1_date]").val(),$("input[name=notice2_date]").val());
	if(valid === "false"){
		$("input[name=notice1_date]").val("")
		$("input[name=notice2_date]").val("")
		return;
	}

	$.ajax({
		type : "POST",
		url : "/cmmn/selectNoticeList.do",
		data : fn_setNoticeForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	noticeHot.loadData([]);
        	noticeHot.loadData(data.resultList);
        	$("#noticeCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setNoticeForm(){
	var sData = {};
	sData["srch1"] = $("#notice_srch1").val();
	sData["srch2"] = $("#notice_srch2").val();
	sData["srch3"] = $("#notice_srch3").val();
	sData["srch4"] = $("#notice_srch4").val();
	sData["srch5"] = $("#notice_srch5").val();
	sData["srch6"] = $("#notice_srch6").val();
	sData["srch7"] = $("#notice_srch7").val();
	sData["srch8"] = $("#notice_srch8").val();
	sData["alignItem"] = $("#alignNotice option:selected").val();
	sData["recordCountPerPage"] = $("#noticePageCnt option:selected").val();
	sData["pageIndex"] = noticeIndex;
	return sData;
};

//검색조건 초기화
function fn_clearNotice(){
	$("#notice_srch1").val("");
	$("#notice_srch2").val("");
	$("#notice_srch3").val("");
	$("#notice_srch4").val("");
	$("#notice_srch5").val("");
	$("#notice_srch6").val("");
	$("#notice_srch7").val("");
	$("#notice_srch8").val("");
};

//등록팝업 호출
function fn_newRegist(row){
	if(row == undefined){
		$("#noticeFileForm").show();
		$("#noticeFileDownForm").hide();
		$("#attach3").hide();
		$("#attach4").hide();
	}else{
		var rowData = noticeHot.getSourceDataAtRow(row);
		fn_searchPopNotice(rowData.noticeSeq);
	}
	$("#noticePop").find("input").val(null);
	$("#noticePop").find("textarea").val(null);
	$("#noticePop").find("select").val("N");
	$("#noticePop").modal("show");

};

//팝업검색
function fn_searchPopNotice(noticeSeq){
	var sData = {};
	sData["srch9"] = noticeSeq;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectNoticeInfo.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if(data.result.fileOrgNm == undefined || data.result.fileOrgNm == ""){
        		$("#noticeFileForm").show();
        		$("#noticeFileDownForm").hide();
        		$("#attach3").hide();
        		$("#attach4").hide();
        	}else{
        		$("#noticeFileForm").hide();
        		$("#noticeFileDownForm").show();
        		$("#attach3").show();
        		$("#attach4").show();
        	}

        	$.each(data.result, function(key, value){
        		$("#noticePop").find("input[name='" + key + "']").val(value);
        		$("#noticePop").find("textarea[name='" + key + "']").val(value);
        		if(key == "delYn"){
        			$("#noticePop").find("select[name='delYn']").val(value);
        		}else if(key == "noticeType"){
        			$("#noticePop").find("select[name='noticeType']").val(value);
        		}
        	});
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

//등록팝업 저장버튼 클릭
function fn_saveNotice(){
	var file = $("#noticeFile").prop("files")[0];
	if(file == undefined){
		fn_saveNoticePop();
	}else{
		fn_saveNoticeFile();
	}
};

//첨부파일 저장
function fn_saveNoticeFile(){
	var form = new FormData(document.getElementById('noticeFileForm'));
	$.ajax({
		type: 'POST',
		url: "/cmmn/uploadNoticeFile.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success: function (data) {
			if(data.result == "success"){
				$("input[name='fileOrgNm']").val(data.fileOrgNm);
				$("input[name='fileNm']").val(data.fileNm);
				fn_saveNoticePop();
			}else if(data.result == "format"){
				alert(msgSelectFileFormat);
			}else{
				alert(msgSaveError);
			}
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

//등록팝업 정보 저장
function fn_saveNoticePop(){
	if(!confirm(msgSaveConfirm)){ return }

	var sData = {};
	sData["noticeSeq"] = $("input[name='noticeSeq']").val();
	sData["titleVn"] = $("input[name='titleVn']").val();
	sData["titleEn"] = $("input[name='titleEn']").val();
	sData["titleKr"] = $("input[name='titleKr']").val();
	sData["cnVn"] = $("textarea[name='cnVn']").val();
	sData["cnEn"] = $("textarea[name='cnEn']").val();
	sData["cnKr"] = $("textarea[name='cnKr']").val();
	sData["fileOrgNm"] = $("input[name='fileOrgNm']").val();
	sData["fileNm"] = $("input[name='fileNm']").val();
	sData["noticeType"] = $("select[name='noticeType']").val();
	sData["delYn"] = $("select[name='delYn']").val();
	if(sData["titleVn"] == "" || sData["titleVn"] == null ||
	   sData["titleEn"] == "" || sData["titleEn"] == null ||
	   sData["titleKr"] == "" || sData["titleKr"] == null){
		alert(titleVnMsg);
		return;
	}
	if(sData["cnVn"] == "" || sData["cnVn"] == null ||
	   sData["cnEn"] == "" || sData["cnEn"] == null ||
	   sData["cnKr"] == "" || sData["cnKr"] == null){
		alert(cnVnMsg);
		return;
	}

	$.ajax({
		type : "POST",
		url : "/cmmn/saveNoticeInfo.do",
		data : JSON.stringify(sData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$("#noticePop").modal("hide");
        		fn_searchNotice();
        	}
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

//첨부파일 삭제
function fn_deleteNoticeFile(){
	if(!confirm(msgFileDeleteConfirm)){	return }

	var sData = {};
	sData["noticeSeq"] = $("input[name='noticeSeq']").val();
	$.ajax({
		type : "POST",
		url : "/cmmn/deleteFileNm.do",
		data : JSON.stringify(sData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	$("#noticeFileForm").show();
        	$("#noticeFileDownForm").hide();
        	$("#attach3").hide();
        	$("#attach4").hide();
        	$("input[name='fileNm']").val("");
        	$("input[name='fileOrgNm']").val("");
        	$("#noticeFile").val("");
        	alert(msgFileDeleteMsg);
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
function fn_noticeTableCol(){
	var noticeRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		  $fileButton = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_newRegist('+row+')"></i>');
		  $(td).empty().append($fileButton).append("  " + value);
	 };

	this.noticeCol = [
		{data : 'titleVn', type : 'text', renderer:noticeRenderer, width: 350},
		{data : 'noticeSeq', type : 'numeric'},
		{data : 'titleEn', type : 'text', width: 350},
		{data : 'titleKr', type : 'text', width: 350},
		{data : 'regDt', type : 'text', className : "htCenter", width: 130},
		{data : 'noticeType', editor : 'select', selectOptions : [ 'Y', 'N' ], type : 'autocomplete', className : "htCenter",
			validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	];
}

//테이블 헤더
function fn_noticeTableHeader(){
	this.noticeHeader = [
		coltitleVn,'noticeSeq',coltitleEn,coltitleKr,colregDt,colNoticeType
	];
}

//테이블 히든컬럼
function fn_noticeTableHidden(){
	this.noticeHiddon = [1];
}

//Table
function fn_handsonGridNoticeOption(col, header, hidden){

	 noticeSettings = {
		  columns : col,
		  colHeaders : header,
		  hiddenColumns : {
	       	  copyPasteEnabled : false,
	       	  indicators : false,
	       	  columns : hidden
	      },
	      //dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
	      contextMenu : false,
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
		  filters : true,
		  readOnly : true,
		  allowRemoveRow : false,
		 // columnSorting : {indicator : true},
		 autoColumnSize : {samplingRatio : 23},
		 mergeCells : false,
		 allowInsertRow : false,
	 };
	 return noticeSettings;
}

//검색구분 (매뉴가 추가될 시 조건문 이용하여 처리)
function fn_changeNoticeType(type){
	let noticeCol = new fn_noticeTableCol();
	let noticeHeader = new fn_noticeTableHeader();
	let noticeHidden = new fn_noticeTableHidden();
	var col, header, hidden;

	col = noticeCol.noticeCol;
	header = noticeHeader.noticeHeader;
	hidden = noticeHidden.noticeHiddon;
	noticeHot.updateSettings(fn_handsonGridNoticeOption(col, header, hidden));
}

//첨부파일 다운로드
function fn_downNoticeFile(){
	document.noticeFileDownForm.action = "/cmmn/downloadNoticeFile.do";
	document.noticeFileDownForm.submit();
};
