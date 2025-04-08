


var judgeHistHot;
var judgeHistIndex = 9999;
var judgeHistScrollTp = true;

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var judgeHistRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		  $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopJudgeDetail()"></i>');
		  $(td).empty().append($button).append("  " + value);
	  };

	  var judgeHistElement = document.querySelector('#judgeHistTable');
	  var judgeHistElementContainer = judgeHistElement.parentNode;
	  var judgeHistSettings = {
			  columns : [
				  {data : 'jdgmntSeq', renderer: judgeHistRenderer, width: 130},
				  {data : 'jdgmntTypeNm', type : 'text', width: 130, className : "htCenter"},
				  {data : 'plntCd', type : 'text', width: 150, className : "htCenter"},
				  {data : 'buyrCd', type : 'text', width: 150, className : "htCenter"},
				  {data : 'buyrNm', type : 'text', width: 250},
				  {data : 'salesNo', type : 'text', width: 150},
				  {data : 'jdgmntOrdr', type : 'text', width: 120, className : "htRight"},
				  {data : 'invoiceNo', type : 'text', width: 170, className : "htRight"},
				  {data : 'itemCd', type : 'text', width: 170, className : "htRight"},
				  {data : 'itemNm', type : 'text', width: 250},
				  {data : 'hsVer', type : 'text', width: 120, className : "htCenter"},
				  {data : 'hsCd', type : 'text', width: 150, className : "htCenter"},
				  {data : 'salesFobPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
				  {data : 'rawmtrlPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
				  {data : 'localPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
				  {data : 'ofshrPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
				  {data : 'jdgmntDt', type : 'text', width: 170, className : "htCenter"},
				  {data : 'jdgmntResultNm', type : 'text', width: 150, className : "htCenter"},
				  {data : 'jdgmntResultYn', type : 'text', width: 100, className : "htCenter"},
				  {data : 'psrInfo', type : 'text'}
	    	  ],
	    	  stretchH : 'all',
	    	  width : '98%',
	    	  autoWrapRow : true,
	    	  height : 487,
	    	  manualRowResize : true,
	    	  manualColumnResize : true,
	    	  rowHeights : 25,
	    	  rowHeaders : true,
	    	  columnHeaderHeight : 25,
	    	  colHeaders : [
	    		  coljudgeSeq,
	    		  coljudgeType,
	    		  colplntCd,
	    		  colbuyrCd,
	    		  colbuyrNm,
	    		  colbuyrNo,
	    		  colsaleOrdr,
	    		  colinvoiceNo,
	    		  colitemCd,
	    		  colitemNm,
	    		  colhsVer,
	    		  colhsCd,
	    		  colsalesFnlPrice,
	    		  colrawmtrPrice,
	    		  collocalPrice,
	    		  colofshrPrice,
	    		  coljdgmntDt,
	    		  coljudgeDetailResult,
	    		  coljudgeResult,
	    		  colpsrOrgInfo
			  ],
			  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			 // dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
			  filters : true,
			  readOnly : true,
			  allowRemoveRow : false,
			//  columnSorting : {
			//	  indicator : true
	         // },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	  judgeHistHot = new Handsontable(judgeHistElement, judgeHistSettings);

	  //정렬항목
	  $("select[name=alignJudgeHist]").change(function(){
		  fn_searchJudgeHist();
	  });

	  //row 수
	  $("select[name=judgeHistPageCnt]").change(function(){
		  fn_searchJudgeHist();
	  });

	  $("#judgeHistTable .wtHolder").scroll(function(){
		  console.log("scroller")
		  var scrollTop = $("#judgeHistTable .wtHolder").scrollTop();
		  var countPerPage = $("#judgeHistPageCnt option:selected").val();
		  var rowHeight = judgeHistHot.getRowHeight();
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

		  if(judgeHistScrollTp && judgeHistIndex != 9999 && scrollTop >= (countPerPage * judgeHistIndex * rowHeight) + addCnt){
			  fn_judgeHistScroll();
		  }
	  });

	  fn_searchJudgeHist();

});

//스크롤
function fn_judgeHistScroll(){
	judgeHistScrollTp = false;
	judgeHistIndex++;

	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeHistList.do",
		data : fn_setJudgeHistForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = judgeHistHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	judgeHistHot.loadData(meargeJson);

        	judgeHistScrollTp = true;
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
		fn_searchJudgeHist();
    }
}

//검색
function fn_searchJudgeHist(){
	judgeHistIndex = 0;

	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeHistList.do",
		data : fn_setJudgeHistForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	judgeHistHot.loadData([]);
        	judgeHistHot.loadData(data.resultList);
        	$("#judgeHistCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setJudgeHistForm(){
	var sData = {};
	sData["srch1"] = $("#judgeHist_srch1").val();
	sData["srch2"] = $("#judgeHist_srch2").val();
	sData["srch3"] = $("#judgeHist_srch3").val();
	sData["srch4"] = $("#judgeHist_srch4").val();
	sData["srch5"] = $("#judgeHist_srch5").val();
	sData["srch6"] = $("#judgeHist_srch6").val();
	sData["srch7"] = $("#judgeHist_srch7").val();
	sData["srch8"] = $("#judgeHist_srch8").val();
	sData["srch9"] = $("#judgeHist_srch9").val();
	sData["srch10"] = $("#judgeHist_srch10").val();
	sData["srch11"] = $("#judgeHist_srch11").val();
	sData["srch12"] = $("#judgeHist_srch12").val();
	sData["srch13"] = $("input:radio[name=judgeHist_srch13]:checked").val();
	sData["srch14"] = $("#judgeHist_srch14").val();

	sData["alignItem"] = $("#alignJudgeHist option:selected").val();
	sData["recordCountPerPage"] = $("#judgeHistPageCnt option:selected").val();
	sData["pageIndex"] = judgeHistIndex;
	return sData;
};

//검색조건 초기화
function fn_clearJudgeHist(){
	$("#judgeHist_srch1").val("");
	$("#judgeHist_srch2").val("");
	$("#judgeHist_srch3").val("");
	$("#judgeHist_srch4").val("");
	$("#judgeHist_srch5").val("");
	$("#judgeHist_srch6").val("");
	$("#judgeHist_srch7").val("");
	$("#judgeHist_srch8").val("");
	$("#judgeHist_srch9").val("");
	$("#judgeHist_srch10").val("");
	$("#judgeHist_srch11").val("");
	$("#judgeHist_srch12").val("");
	$("input:radio[name=judgeHist_srch13]")[0].checked = true;
	$("#judgeHist_srch14").val("");
};

//테이블팝업 호출
function fn_callPopJudgeHist(target){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	//아이템
	if(target == "itemCd"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colitemCd);
	//판매처
	}else{
		strSearch = (colLang == "en") ? "BUYR_ID AS CD, BUYR_NM_EN AS CD_NM" : "BUYR_ID AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colbuyrCd);
	}
	type = target;

	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "itemCd"){
			$("#judgeHist_srch10").val(data.cd);
		}else if(data.type == "buyrCd"){
			$("#judgeHist_srch7").val(data.cd);
		}
	});

};

//판정상세팝업
function fn_callPopJudgeDetail(){

	$("#judgeHistPop").modal("show");
	setTimeout(function(){popPsrHot.render()}, 200);
	setTimeout(function(){popRawMtrlHot.render()}, 200);

};

//증명서발급
function fn_printPdf(type, row){

	//출력타입 (1:원산지증명서, 2:원산지확인서)
	var printType = type;
	//판정일련번호
	var jdgmntSeq = judgeHistHot.getDataAtCell(row, 0);
	//협정코드
	var ftaCd = judgeHistHot.getDataAtCell(row, 13);

	if(type == "2"){
		$("#txtHistPop2").text(colOriginCnfrmn);
	}

	if (type =="1") $("#printPopup").modal("show");
	else $("#printPopup2").modal("show");

};

//증명서 출력 (원산지증명서 TYPE : 1)
function fn_printHistPop(){

	if($("input:checkbox[name=crtf]").is(":checked") == false){
		alert("출력할 항목을 선택하십시오.");
		return;
	}

	var url = "/pdf/BOM.pdf";
	var iframe = document.createElement('iframe');
    // iframe.id = 'pdfIframe'
    iframe.className='pdfIframe'
    document.body.appendChild(iframe);
    iframe.style.display = 'none';
    iframe.onload = function () {
        setTimeout(function () {
            iframe.focus();
            iframe.contentWindow.print();
            URL.revokeObjectURL(url)
            // document.body.removeChild(iframe)
        }, 1);
    };
    iframe.src = url;

};


//증명서 출력 (원산지확인서 TYPE : 2)
function fn_printHistPop2(){

	if($("input:checkbox[name=cnfrmn]").is(":checked") == false){
		alert("출력할 항목을 선택하십시오.");
		return;
	}

	var url = "/pdf/Blank_A4.pdf";
	var iframe = document.createElement('iframe');
    // iframe.id = 'pdfIframe'
    iframe.className='pdfIframe'
    document.body.appendChild(iframe);
    iframe.style.display = 'none';
    iframe.onload = function () {
        setTimeout(function () {
            iframe.focus();
            iframe.contentWindow.print();
            URL.revokeObjectURL(url)
            // document.body.removeChild(iframe)
        }, 1);
    };
    iframe.src = url;

};

$(document).mousedown(function(e){	
	if(e.target.name == "jdgmn1_date" || e.target.name == "jdgmn2_date"){
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

