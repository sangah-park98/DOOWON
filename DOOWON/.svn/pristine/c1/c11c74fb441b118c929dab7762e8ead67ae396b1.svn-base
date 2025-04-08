var originIndex = 9999;
var originScrollTp = true;
var originRowCnt = 0;
var originHot;
var cnt = 0;
var gridCalFormat;
var originData = {};
var updateUploaderData;
var statclick = null;

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

$(document).mousedown(function(e){
	if(e.target.name == "srch2" || e.target.name == "srch3" || e.target.name == "srch3" || e.target.name == "srch4"){
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

$( document ).ready(function() {

	$('.band-calendar').each(function(){ regCal(this) ;})
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

		$(document).mousedown(function(e){
			if($(".calendar-popup-container").hasClass("calendar-popup-container_active")){
				$(".calendar-popup-container").attr("class", "calendar-popup-container");
			}
		});


		//파일명 input change
		$("#filePc").change(function(){
			$("#fileUploadView").val(fn_getCmaFileInfo($("#filePc").val()));
			$("#docuFile").val(fn_getCmaFileInfo($("#filePc").val()));

		});
		//정렬항목
		$("select[name=alignOriginInfo]").change(function(){
			fn_searchOriginInfo();
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

	  var originHotElement = document.querySelector('#divOriginInfo');
	  var originElementContainer = originHotElement.parentNode;
	  originHot = new Handsontable(originHotElement, fn_originHandsonTable());

	  originHot.loadData([]);
	  fn_scroll();
});


/** 이벤트 Start **/
function fn_scroll(){
	$("#divOriginInfo .wtHolder").scroll(function(){
		  var scrollTop = $("#divOriginInfo .wtHolder").scrollTop();
		  var countPerPage = 50;
		  var rowHeight = originHot.getRowHeight();

		  var addUnitCnt = 790;
		  if(countPerPage == "50"){
			  addUnitCnt = 790;
		  }else if(countPerPage == "100"){
			  addUnitCnt = 2040;
		  }else if(countPerPage == "200"){
			  addUnitCnt = 3290;
		  }else if(countPerPage == "500"){
			  addUnitCnt = 4540;
		  }
		  if(originScrollTp && originIndex != 9999 && scrollTop >= (countPerPage * originIndex * rowHeight) + addUnitCnt){
			  fn_searchOriginInfoScroll();
		  }
	});
}

/** 이벤트 End **/


//스크롤
function fn_searchOriginInfoScroll(){
	if ($("input[name=unitType]:checked").val() == "enrol")
		return;



	fn_loading(true);
	originScrollTp = false;
	originIndex++;
	$.ajax({
		type : "POST",
		url : "/prtl/originInfoJson.do",
		data : fn_setOriginInfoForm(),
		dataType: "json",
        success : function(data) {
        	var getData = originHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	originHot.loadData(meargeJson);
        	originScrollTp = true;
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

function fn_searchOriginInfo()
{
	originIndex = 0;

	if($("#originInfo_srch1").val() != "")
	{
		$("#originSrch1").val($("#originInfo_srch1").val());
		$("#originSrch2").val($("#originInfo_srch2").val());
		$("#originSrch3").val($("#originInfo_srch3").val());
		$("#originSrch4").val($("#originInfo_srch4").val());
		$("#originSrch5").val($("#originInfo_srch5").val());
		$("#originSrch6").val($("#originInfo_srch6:checked").val());
		$("#originSrch7").val($("#originInfo_srch7").val());
		$("#originSrch8").val(vndrId);

		$.ajax({
			type : "POST",
			url : "/prtl/originInfoJson.do",
			data : fn_setOriginInfoForm(),
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			dataType: "json",
	        success : function(data) {
	        	originHot.loadData([]);
	        	originHot.loadData(data.resultList);
	        	$("#originInfoCnt").text(data.totCnt).number(true); //검색결과 총 갯수

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
	}else
	{
		return;
	}

}




window.onload=(function(){
	//fn_srchSave();
})

//파일 업로드 다운로드
function fn_fileDown(row, col){
	var rowData = originHot.getSourceDataAtRow(row);

	fn_pcfileDownload(row);
};


//파일 업로드 다운로드
function fn_fileUp(row, col){
	if(originHot.getDataAtCell(row,col+4) == colConfm){
		alert(confmDIsableMsg);
		return;
	}
	var rowData = originHot.getSourceDataAtRow(row);
	updateUploaderData = originHot.getSourceDataAtRow(row);
	fn_showPurchaseFilePop(rowData, row, col);
};


//파일 다운로드
function fn_pcfileDownload(row){

	var data = originHot.getSourceDataAtRow(row);
	if(data.docuFile == undefined){
		alert(msgFileEmptyMsg);
		return;
	}

	$("#docuOrgFilePc").val(data.docuOrgFile);
	$("#docuFilePc").val(data.docuFile);
	document.fileDownForm.action = "/prtl/downloadFile.do";
	document.fileDownForm.submit();
};

//파일 업로드
function fn_showPurchaseFilePop(data, row, col){
	originData = {row:row, col:col};
	$("#cmpnyCdPc").val(data.cmpnyCd);
	$("#plntCdPc").val(data.plntCd);
	$("#vndrCdPc").val(data.vndrCd);
	$("#purchaseNoPc").val(data.purchaseNo);
	$("#purchaseOrdrPc").val(data.purchaseOrdr);
	$("#itemCdPc").val(data.itemCd);
	$("#ftaCdPc").val(data.ftaCd);
	$("#filePc").val("");
	$("#filePopupPc3").modal("show");
};


//업로드파일 저장
function fn_saveOriginInfoFile(){
	$("input[name=psrSumry]").val($("input[name=psrText]").val());
	$("input[name=originYn]").val($("select[name=orgnYn]").val());
	var file = $("#filePc").prop("files")[0];

	if(file == undefined || file == null || file == ""){
		alert(selectFileMsg);
		return;
	}

	if($("input[name=psrText]").val() == null || $("input[name=psrText]").val() == "" ){
		alert(notEmptyPsrMsg);
		return;
	}

	var form = new FormData(document.getElementById('fileFormPc'));
	$.ajax({
		type: 'POST',
		url: "/prtl/saveFileInfo.do",
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
				$("#filePopupPc3").modal("hide");
				originHot.setDataAtRowProp(originData.row, "docuOrgFile", data.docuOrgFile);
				fn_saveUploderEvent();
				//originHot.setDataAtRowProp(originData.row, "docuFile", data.docuFile);
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



//테이블 컬럼
function fn_originHandsonTable(){

	//문서 다운로드 업로드
	var docuFileLoadRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		//var $fileButton = $('<button class="" style="cursor:pointer;" onclick="fn_fileDown('+row+','+col+')">[D]</button>');
		var $fileButton = $('<button class="searchCon_Btn_f" style="cursor:pointer; padding: 0.15rem 0.25rem;" onclick="fn_fileUp('+row+','+col+')">'+ colSubmit +'</button>');
		$(td).empty().append($fileButton).append("  " + value);
	};

	var orgnRender = function (instance, td, row, col, prop, value, cellProperties) {
		if(value == 'Y'){
			$(td).empty().append('Origin');
		} else if(value == 'N'){
			$(td).empty().append('non-Origin');
		} else {
			$(td).empty().append('');
		}
	}
	var originSettings = {
		  columns : [
			  {data: 'plntCd', type : 'text', width: 110, className : "htCenter"},
			  {data: 'cmpnyCd', type: 'text', width: 120, className: 'htCenter'},
			  {data: 'purchaseNo', width: 100, type: 'text'},
			  {data: 'purchaseOrdr', type: 'text', width: 100, className: 'htCenter'},
			  {data: 'itemCd', type: 'text', width: 100, className: 'htCenter'},
			  {data: 'itemNm', type: 'text', width: 200},
			  {data: 'ftaCd', type: 'text', width: 150, className: 'htCenter'},
			  {data: 'hsCd', type: 'text', width: 100},
			  {data: 'hsVer', type: 'text', width: 100},
//			  {data: 'psrSumry', type: 'text'},
			  {data: 'reqDtm', type: 'text', className: 'htCenter', width: 130},
			  {data: 'docuOrgFile', type: 'text', renderer:docuFileLoadRenderer, readOnly:true, width: 200},
			  {data: 'originYn', type: 'text', className: 'htCenter', renderer : orgnRender, width: 100},
			  {data: 'psrSumry', type: 'text', width: 100},
			  {data: 'recvDtm', type: 'text', className: 'htCenter', width: 150},
			  {data: 'approvedState', type: 'text', className: 'htCenter', width: 180},
			  {data: 'stateMsg', type: 'text', className: 'htCenter', width: 210}
    	  ],
    	  //플랜트코드 구매처코드 구매번호 항번 품목코드 물목명 협정명 HS코드 HS버전 PSR 요청일자 원산지 PSR 문서첨부 송신일자 처리현황 승인거절사유
    	  stretchH : 'all',
    	  width : '100%',
    	  autoWrapRow : true,
    	  height : 487,
    	  rowHeights : 25,
    	  rowHeaders : true,
    	  columnHeaderHeight : 25,
    	  colHeaders : true,
    	  nestedHeaders : [

    		  [
  				{label:colBuyrStdrdInfo, colspan:10},
  				{label:"", colspan:7},
  		    ],[
  		    	colPlntCd, colVndrCd, colPurchsNo, colPurchaseOrdr, colItemCd, colItemNm, colFtaCd, colHsCd, colHsVer
  		    	/*colPsr*/, colReqDtm,  /*colAttachFile*/colSubmitDo,colOrigin, colPsr, colSendDt , colPcsStsNm, colPcsStsMsg
  			  ]
    	  ],
		  manualRowResize : true,
    	  manualColumnResize : true,
    	  manualRowMove : true,
		  manualColumnMove : false,
		  contextMenu : false,
		//  dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		  filters : true,
		  readOnly : true,
		 // columnSorting : {
		//	  indicator : true
        //  },
          autoColumnSize : {
        	  samplingRatio : 23
          },
          mergeCells : false,
          allowInsertRow : false,
          wordWrap : true,
          dataSchema: {deminRt:0, bdRt:0, buRt:0, mcRt:0, indrtRt:0, cnctrRt:0, originRt:0 ,nriginRt:0 ,partsRt:0}
	};

	return originSettings;
}

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
	originHot.loadData([]);
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

////정합성 체크
function fn_dateOriginVali(){
	originHot.validateCells(function(valid) {
		console.log(valid)
		if(valid){
			fn_originSaveData();
		}else{
			originHot.render();
			alert("정합성 체크가 필요합니다.");

		}
    });
};




//저장
function fn_saveUploderEvent(){

	$.ajax({
		type : "POST",
		url : "/prtl/updateUploadeUser.do",
		data : JSON.stringify(updateUploaderData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
        success : function(data) {
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

	fn_searchOriginInfo();
};






/*
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
*/


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
	if(val.val()*50 > totCnt){
		return;
	}else{
		if(totCnt < next*50){
			val.val(Number((totCnt%200)/50)+1);
			$("#prev").val((totCnt%200)/50+1);
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
	sData["srch1"] = $("#originInfo_srch1").val();
	sData["srch2"] = $("#originInfo_srch2").val();
	sData["srch3"] = $("#originInfo_srch3").val();
	sData["srch4"] = $("#originInfo_srch4").val();
	sData["srch5"] = $("#originInfo_srch5").val();
	if(statclick == 'Y'){
		sData["srch6"] = 'Y';
	} else if(statclick == 'N') {
		sData["srch6"] = 'N';
	} else {
		sData["srch6"] = $("input:radio[name='srch6']:checked").val();
	}
	sData["srch7"] = $("#originInfo_srch7").val();
	sData["vndrId"] = vndrId;
	//sData["alignItem"] = $("#alignOriginInfo option:selected").val();
	sData["recordCountPerPage"] = 50;
	sData["pageIndex"] = originIndex;
	return sData;


};

//초기화
function fn_clearOriginInfo(){
	$("#originInfo_srch1").val("");
	$("#originInfo_srch2").val("");
	$("#originInfo_srch3").val("");
	$("#originInfo_srch4").val("");
	$("#originInfo_srch5").val("");
	$('input:radio[name="srch6"]:input[value = ""]').prop("checked", true);
	$("#originInfo_srch7").val("All");
	originHot.loadData([]);

};

//edit page
function fn_rowSubmitForm(td){
	var form = document.createElement('form');
    var tdArr = new Array();   // 배열 선언
    var fData = {};
    var tr = $(this);
    td.each(function(i){
        tdArr.push(td.eq(i).text());
    });

	var newForm = $('<form></form>');
	newForm.attr("name", "orgInfoEditForm");
	newForm.attr("id", "orgInfoEditForm");
	newForm.attr("method", "POST");
	newForm.attr("action", "/prtl/originInfoEdit.do");


	for(var i=1; i < 8; i++){
		var newInput = '<input type="hidden" id="srch2'+i+'" name="srch2'+i+'" value="'+tdArr[i]+'"/>';
		newForm.append($(newInput));
	}
	newForm.appendTo('body');
	newForm.submit();
	$("#orgInfoEditForm").remove();

}

//파일업로드
function fn_fileUplad(){
	$('#filePc').click();
}

//파일명만 추출
function fn_getCmaFileInfo(obj) {
    var fileObj, pathHeader , pathMiddle, pathEnd, allFilename, fileName, extName;
    if (fileObj != "") {
            pathHeader = obj.lastIndexOf("\\");
            pathMiddle = obj.lastIndexOf(".");
            pathEnd = obj.length;
            fileName = obj.substring(pathHeader+1, pathMiddle);
            extName = obj.substring(pathMiddle+1, pathEnd);
            allFilename = fileName+"."+extName;
            return allFilename; // 확장자 포함 파일명
    } else {
            alert(originInfo_selectFileMsg);
            return false;
    }
 }

//submit(Edit)
function fn_updateOrgInfo(){
	document.editUpdateForm.submit();
	document.fileUpdateForm.submit();
	alert(originInfo_saveSuccess);
	location.href = document.referrer;;
}

/*//파일 다운로드 submit
function fn_fileDown(td){
	if((td.parent().text()).replace( /(\s*)/g, "") == ''){
		alert(originInfo_saveEmpty);
		return;
	}
	var tdArr = [];
	var list = td.parents().parents().children();
        tdArr.push(list.eq(15).text().replace(td.text(),""));
        tdArr.push(list.eq(16).text());
	var dData = {};

	var newForm = $('<form></form>');
	newForm.attr("name", "downFile");
	newForm.attr("id", "downFile");
	newForm.attr("method", "POST");
	newForm.attr("target", "info");
	newForm.attr("action", "/prtl/downloadFile.do");

	var newInput = '<input type="hidden" id="docuOrgFile" name="docuOrgFile" value="'+tdArr[0]+'"/>';
	newForm.append($(newInput));
	var newInput = '<input type="hidden" id="docuFile" name="docuFile" value="'+tdArr[1]+'"/>';
	newForm.append($(newInput));
	newForm.appendTo('body');

	downFile.submit();
	$("#downFile").remove();

}*/

//popup Code input
function fn_popCdInput(val){
	$("#originInfo_srch9").val(val.eq(1).text());
	$('#myModal').css('display', 'none');
}

//item popup
function fn_itemPopup(){
	fn_itemPopupSrch();
	$("#myModal").css("display", "block");
}

//excel
function fn_filePopup(){
	fn_initExcel();
	$(".fileModal").css("display", "block");
}

//excel
/*function fn_filePopup2(){
	fn_initExcel();
	$("#fileModal2").css("display", "block");
}*/

//popup item 검색(ajax로 처리했습니다)
function fn_itemPopupSrch(){
	sData = {};
	sData["itemCd"] = $("#itemPop_srch1").val();
	sData["itemNm"] = $("#ItemPop_srch2").val();

	$.ajax({
		type: "POST",
		url: "/prtl/originInfoitemPop.do",
		data: sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
			itemPopTable(data);
		},
		error : function(e, textStatus, errorTrown){

		}
	})
}

//팝업 테이블을 그려주는 부분
function itemPopTable(data){
	$("#originPopTbl tbody").children().remove();
	var rowData;
	originRowCnt = 0;
	for(var i=0; i<data.itemList.length; i++){
		originRowCnt++;
		rowData = data.itemList[i];
		var rowText = "<tr style='cursor:pointer' id='itemList"+originRowCnt+"' onclick='fn_popCdInput($(this).children())'>";
		rowText = rowText + "<td id=;colCn' class='td-bg' >"+originRowCnt+"</td>";
		rowText = rowText + "<td style='width:10%'>"+rowData.cd+"</td>";
		rowText = rowText + "<td>"+rowData.cdNm+"</td>";
		rowText = rowText + "</tr>";
		$("#originPopTbl tbody").append(rowText);
	}
}


function fn_orgBoxEvt(data){
	if(data == 1){
		$("input:radio[name='srch6']:radio[value='']").prop('checked', true);
	}else if(data == 2){
		$("input:radio[name='srch6']:radio[value='40']").prop('checked', true);
	}else if(data == 'Y'){
		$("input:radio[name='srch6']:radio[value='20']").prop('checked', true);
		statclick = 'Y'
	} else {
		$("input:radio[name='srch6']:radio[value='20']").prop('checked', true);
		statclick = 'N'
	}
	fn_searchOriginInfo();
	statclick = null;
}





