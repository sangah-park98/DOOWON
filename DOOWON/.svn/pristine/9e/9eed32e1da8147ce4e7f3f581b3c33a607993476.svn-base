var originIndex = 9999;
var originScrollTp = true;
var originRowCnt = 0;
var cnt = 0;
var originHot;
var gridCalFormat;

function regCal(obj) {
	var calendar = new CalendarPopup(obj, {
		timepicker : false,
		format : gridCalFormat,
		choseOnClick : true,
		closeButton : false,
		choseButton : false,
		validateOnBlur : false,
		mask : false
	});
}


$( document ).ready(function() {
	
	  //date form
	  	calFormat = "yy/mm/dd"; //Vietnam
		gridCalFormat = "YYYY/MM/DD";
		if(colLang == "kr"){
			calFormat = "yy/mm/dd";
			gridCalFormat = "YYYY/MM/DD";
		}else if(colLang == "en"){
			calFormat = "yy/mm/dd";
			gridCalFormat = "YYYY/MM/DD";
		}
	
		//$('.band-calendar').each(function(){ regCal(this) ;});

	  var originHotElement = document.querySelector('#inputTable');
	 // var originHotElementContainer = originHotElement.parentNode;

	  //Yn check function
	  var delYnVali = function(value, callback){
	  	if(!value || String(value).length == 0){
	  		  callback(false);
	  	  }else if(value == 'Y' || value == 'N'){
	  		  callback(true);
	  	  }
	  }

	//validation check function length 10
	  var notEmptyLeng10 = function (value, callback) {
	      if (!value || ((String(value)).trim()) == 0 || value.length > 10) {
	          callback(false);
	      } else {
	          callback(true);
	      }
	  };

	//validation check function length 20
	  var notEmptyLeng20 = function (value, callback) {
	      if (!value || ((String(value)).trim()) == 0 || value.length > 20) {
	          callback(false);
	      } else {
	          callback(true);
	      }
	  };


	//date form change function VN, EN, KR
	  function dateFormChange(value) {
	  	var yy;
	  	var mm;
	  	var dd;
	  	var date;
	  	if(colLang == 'vt') {
	  		yy = value.substr(4,4);
	  		mm = value.substr(2,2);
	  		dd = value.substr(0,2);
	  		date = yy+mm+dd;
	  	} else if(colLang == 'en'){
	  		yy = value.substr(4,4);
	  		mm = value.substr(0,2);
	  		dd = value.substr(2,2);
	  		date = yy+mm+dd;
	  	} else{
	  		date = value;
	  	}
	  	return date;
	  }


	  //date validation check function
	  var dateChcek = function(value, callback){
	  	var dateForm = dateFormChange(value.replaceAll("/", ""))
	  	var re = /[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])/;
	  	if(!re.test(dateForm) || !value || String(dateForm.trim()).length == 0 || String(dateForm.trim()).length != 8){
	  		callback(false);
	  	}else{
	  		callback(true);
	  	}
	  }



		//replaceAll change
		String.prototype.replaceAll = function(org, dest) {
		    return this.split(org).join(dest);
		}


	$('#my_file_input').change(function(evt) {
	    fileList = $(this)[0].files;  //파일 대상이 리스트 형태로 넘어온다.
	    for(var i=0;i < fileList.length;i++){
	        var file = fileList[i];
	        const formData = new FormData();
	        formData.append('file'+i+'', file);  //파일을 더해준다.
	        //만약 여기서 유니크한이이디를 사용하여 테그(노드)를 만든다면
	        //각각 파일에 대해 프로그래싱이 가능하다.
	        //$('프로그래스 상태를 나타낼 테그').append('ex'+i+'');
	    }
	});


	//파일명 input change
	$("#filePc").change(function(){
		$("#fileUploadView").val(fn_getCmaFileInfo($("#filePc").val()));
		$("#docuFile").val(fn_getCmaFileInfo($("#filePc").val()));

	});
	//정렬항목
	$("select[name=alignOriginInfo]").change(function(){
		//fn_searchOriginInfo();
		$('#alignItem').val($(this).val());
		fn_pageNation(1);
		
	});

	//row 수
	$("select[name=originInfoPageCnt]").change(function(){
		fn_searchOriginInfo();
	});

	$("#itemPopup").hide();
	$("#next").val(next);
	$("#prev").val(prev);

	if($("#originInfoTbl1 tr td").text() == ""){
		$("#originInfoTbl1 tr td").children().css("display", "none");
	}


	/*드래그 앤 드롭 */

	var $drop = $("#drop");

	$drop.on("dragenter", function(e) {  //드래그 요소가 들어왔을떄
	  $(this).css("background-color", "#99FFFF");
	  $(this).addClass('drag-over');

	}).on("dragleave", function(e) {  //드래그 요소가 나갔을때
	  $(this).css("background-color", "#CCFFFF");
	  $(this).removeClass('drag-over');

	}).on("dragover", function(e) {

	  e.stopPropagation();

	  e.preventDefault();

	}).on('drop', function(e) {  //드래그한 항목을 떨어뜨렸을때
	  e.preventDefault();
	  $(this).css("background-color", " #CCFFFF");
	  var file = e.originalEvent.dataTransfer.files;
	  fn_excelUp(file);
	  $(this).removeClass('drag-over');
	});

	$("#pageSpace"+ pageIndex +"").parent().attr('class', 'page-item active');
	
});



//액셀 업로드
function fn_excelUp(files){
	var data = new FormData();
	for(var i =0;i < files.length; i++){
		data.append('file', files[i]);
	}
	$.ajax({
		type: "POST",
		url: "/prtl/excelToTable.do",
		enctype: 'multipart/form-data',
		data: data,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		contentType : false,
	    processData: false,
		success : function(data) {
			originHot.loadData(data.resultList);
        	$("#unitCnt").text(data.totCnt).number(true);
		},
		error : function(e, textStatus, errorTrown){
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else { 
				alert(errorTrown);
				console.log(errorTrown);
        	}
		}
	})
}

//엑셀 업로드 정보 초기화
function fn_initExcel(){
	//originHot.loadData([]);
}

//excel save 클릭 이벤트
function fn_originSaveCheck(){
	if(originHot.getData().length < 1){
		//alert(msgSaveEmpty);
		return;
	}
	//fn_dateOriginVali();
	fn_originSaveData();
};

//패이징
function fn_pageNation(elemt){
	var data = [];
	$.each($('#searchForm').serializeArray(), function(key, val){
		data.push(val['value']);
	})
	//searchForm.subnit();
	if(elemt == '1'){
		$("#prev").val(1);
		$("#next").val(10)
	}
	var sh8 = 	$("input:radio[name='srch8']:checked").val();
	
	var starDt = $("#prtlStat_srch1").val();
	var endDt = $("#prtlStat_srch2").val();
	
	
	if(starDt != ""){
	    var startDateCompare = new Date(moment(starDt));
	    var endDateCompare = new Date(moment(resetToday));
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	         alert(checkSearchDate);
	         return;
	    }
	    
	}
	
	if(starDt != "" && endDt != ""){
	    var startDateCompare = new Date(moment(starDt));
	    var endDateCompare = new Date(moment(endDt));
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	         alert(checkSearchDate);
	         return;
	    }
	}
	
	var newForm = $('<form></form>');
	newForm.attr("name", "pageForm");
	newForm.attr("id", "pageForm");
	newForm.attr("method", "POST");
	newForm.attr("action", "/prtl/originInfo.do");
	var newInput = '<input type="hidden" id="srch1" name="srch1" value="'+data[0]+'"/>'; //plntCd
	newInput = newInput + '<input type="hidden" id="srch2" name="srch2" value="'+data[1]+'"/>'; //vndrCd
	newInput = newInput + '<input type="hidden" id="srch3" name="srch3" value="'+data[2]+'"/>'; //vndrNm
	newInput = newInput + '<input type="hidden" id="srch4" name="srch4" value="'+data[3]+'"/>'; //purchaseNo
	newInput = newInput + '<input type="hidden" id="srch5" name="srch5" value="'+data[4]+'"/>'; //strtdate
	newInput = newInput + '<input type="hidden" id="srch6" name="srch6" value="'+data[5]+'"/>'; //enddate
	newInput = newInput + '<input type="hidden" id="srch7" name="srch7" value="'+data[6]+'"/>'; //ftaCd
	newInput = newInput + '<input type="hidden" id="srch8" name="srch8" value="'+sh8+'"/>'; //originYn
	newInput = newInput + '<input type="hidden" id="srch9" name="srch9" value="'+data[8]+'"/>'; //itemCd
	newInput = newInput + '<input type="hidden" id="pagePoint" name="pagePoint" value="'+elemt+'"/>';
	newInput = newInput + '<input type="hidden" id="srch20" name="srch21" value="page"/>'
	newInput = newInput + '<input type="hidden" id="startPoint" name="startPoint" value="'+$('#prev').val()+'"/>';
	newInput = newInput + '<input type="hidden" id="endPoint" name="endPoint" value="'+$('#next').val()+'"/>';
	newInput = newInput + '<input type="hidden" id="srch40" name="srch40" value="'+((elemt%10 == 0) ? 10 : elemt%10)+'"/>';
	newInput = newInput + '<input type="hidden" id="alignItem" name="alignItem" value="'+$('#alignItem').val()+'"/>'
	newForm.append($(newInput));
	newForm.appendTo('body');
	pageForm.submit();
}



//paging 뒤로
function fn_pagePrev(val){
	if(val.val() == 1){
		return;
	}else{
		if($("#next").val()/10 != 0){
			val.val(Number(val.val())-10);
			$("#next").val(Number(val.val())+9);
		}else{
			val.val(Number(val.val())-10);
			$("#next").val(Number($("#next").val())-10);
		}
	}
	fn_pageNation($("#prev").val());
}
//paging 앞으로
function fn_pageNext(val){
	if(val.val()*20 > totCnt){
		return;
	}else{
		if(totCnt < next*20){
			val.val(Number((totCnt%200)/20)+1);
			$("#prev").val((totCnt%200)/20+1);
		}else{
			val.val(Number(val.val())+10);
			$("#prev").val(Number($("#prev").val())+10);
		}
	}
	fn_pageNation($("#prev").val());
}

//정합성
function fn_emptyVal(value){
	return (value == undefined)?"":value;
};

//검색조건 생성
function fn_setOriginInfoForm(){
	var sData = {};
	sData["srch1"] = $("#prtlStat_srch1").val();
	sData["srch2"] = $("#prtlStat_srch2").val();

	//sData["alignItem"] = $("#alignOriginInfo option:selected").val();
	sData["recordCountPerPage"] = $("#originInfoPageCnt option:selected").val();
	sData["pageIndex"] = originInfoIndex;
	return sData;
	

};

window.onload=(function(){
	fn_saveSrch();
})


function fn_saveSrch(){
	$("#prtlStat_srch5").val(stDtForm); //요청시작일
	$("#prtlStat_srch6").val(enDtForm); //요청종료일
}

//초기화
function fn_clearPortalStat(){
	$("#prtlStat_srch5").val(resetStartday);
	$("#prtlStat_srch6").val(resetToday);
	
}

function fn_searchPortalStat(){
	var starDt = $("#prtlStat_srch5").val();
	var endDt = $("#prtlStat_srch6").val();
	
	console.log(endDt);
	if(starDt != ""){
	    var startDateCompare = new Date(moment(starDt));
	    var endDateCompare = new Date(moment(resetToday));
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	         alert(checkSearchDate);
	         return;
	    }
	    
	}
	
	if(starDt != "" && endDt != ""){
	    var startDateCompare = new Date(moment(starDt));
	    var endDateCompare = new Date(moment(endDt));
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	         alert(checkSearchDate);
	         return;
	    }
	}

	$("#prtlStat_srch5").val(starDt);
	$("#prtlStat_srch6").val(endDt);
	document.prtlStat_searchForm.action = "/prtl/portalStat.do";
	document.prtlStat_searchForm.submit();
}
