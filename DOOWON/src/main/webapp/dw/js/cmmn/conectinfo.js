var conectInfoHot;
var conectInfoSettings;
var conectInfoIndex = 9999;
var conectInfoScrollTp = true;

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	$('.band-calendar').each(function(){ regCal(this) ;})
    //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

	var conectInfoElement = document.querySelector('#conectInfoTable');
	var conectInfoElementContainer = conectInfoElement.parentNode;

	conectInfoHot = new Handsontable(conectInfoElement, conectInfoSettings);

	$("#conectInfo_div4").hide();
	$("#conectInfo_div5").hide();
	$("#conectInfo_div6").hide();

	fn_changeConectInfoType('01');
	fn_searchConectInfo();

	//스크롤이벤트
	$("#conectInfoTable .wtHolder").scroll(function(){
		  var scrollTop = $("#conectInfoTable .wtHolder").scrollTop();
		  var countPerPage = $("#conectInfoPageCnt option:selected").val();
		  var rowHeight = conectInfoHot.getRowHeight();
		  console.log("scrollTop"+scrollTop);
		  var addCnt = 691;
		  if(countPerPage == "50"){
			  addCnt = 691;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "150"){
			  addCnt = 3290;
		  }else if(countPerPage == "200"){
			  addCnt = 4540;
		  }

		  if(conectInfoScrollTp && conectInfoIndex != 9999 && scrollTop >= (countPerPage * conectInfoIndex * rowHeight) + addCnt){
			  fn_conectInfoScroll();
		  }
	});
});
/** 이벤트 Start **/


//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-conectinfo").hasClass("active")) {
//			fn_searchConectInfo();
//		} 
//	}
//})

//검색구분 변경
$("input[name=conectInfo_srch1]").change(function(){
	  fn_changeConectInfoType($(this).val());
});


//달력 창 닫기

$(document).mousedown(function(e){	
	if(e.target.name == "cone1_date" || e.target.name == "cone2_date"){
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
$("select[name=alignConectInfo]").change(function(){
	  fn_searchConectInfo();
});

//row 수
$("select[name=conectInfoPageCnt]").change(function(){
	  fn_searchConectInfo();
});
/** 이벤트 End **/

//스크롤
function fn_conectInfoScroll(){
	if($("input[name=conectInfoType]:checked").val() == "enrol")
		return;
	conectInfoScrollTp = false;
	conectInfoIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectConectList.do",
		data : fn_setConectInfoForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = conectInfoHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	conectInfoHot.loadData(meargeJson);

        	conectInfoScrollTp = true;
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
		fn_searchConectInfo();
    }
}

//검색
function fn_searchConectInfo(){
	conectInfoIndex = 0;
	
	var valid = fn_validateSearchDate($("input[name=cone1_date]").val(),$("input[name=cone2_date]").val());
	if(valid === "false"){
		$("input[name=cone1_date]").val("")
		$("input[name=cone2_date]").val("")
		return;
	}
	
	$.ajax({
		type : "POST",
		url : "/cmmn/selectConectList.do",
		data : fn_setConectInfoForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	conectInfoHot.loadData([]);
        	conectInfoHot.loadData(data.resultList);
        	$("#conectInfoCnt").text(data.totCnt.toLocaleString());//검색결과 총 갯수
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
function fn_setConectInfoForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=conectInfo_srch1]:checked").val();
	sData["srch2"] = $("#conectInfo_srch2").val(); //사용자명
	sData["srch3"] = $("#conectInfo_srch3").val(); //접속회사명 
	sData["srch4"] = $("#conectInfo_srch4").val(); //시작일자
	sData["srch5"] = $("#conectInfo_srch5").val(); //종료일자
	sData["alignItem"] = $("#alignConectInfo option:selected").val();
	sData["recordCountPerPage"] = $("#conectInfoPageCnt option:selected").val();
	sData["pageIndex"] = conectInfoIndex;
	return sData;
};

//검색조건 초기화
function fn_clearConectInfo(){
	$("#conectInfo_srch2").val("");
	$("#conectInfo_srch3").val("");
	$("#conectInfo_srch4").val("");
	$("#conectInfo_srch5").val("");
	$("#conectInfo_srch6").val("");
	$("#conectInfo_srch7").val("");
	$("#conectInfo_srch8").val("");
	$("#conectInfo_srch9").val("");
	$("#conectInfo_div1").show();
	$("#conectInfo_div2").show();
	$("#conectInfo_div3").show();
	$("#conectInfo_div4").hide();
	$("#conectInfo_div5").hide();
	$("#conectInfo_div6").hide();
};

//접속정보 컬럼 (헤더)
function fn_coneTableCol(){
	this.coneCol = [
		{data : 'usrId', type : 'text', width: 70},
		{data : 'usrNm', type : 'text'},
		{data : 'cmpnyNm', type : 'text'},
		{data : 'conectDt', type : 'text', className : "htCenter", width: 50},
		{data : 'regIp', type : 'text', className : "htCenter", width: 50}
	];

}

//접속정보 헤더(여기에서 바꾸기)
function fn_coneTableHeader(){

	this.coneHeader = [
		'사용자ID','사용자명','접속회사명','접속일','접속IP'
	];

}

//접속정보 히든컬럼
function fn_coneTableHidden(){

	this.coneHidden = [];

	this.coneChangeHidden = [];
}



function fn_handsonGridConeOption(col, header, hidden){
	conectInfoSettings = {
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
	    	  height : 585,
	    	  manualRowResize : true,
	    	  manualColumnResize : true,
	    	  rowHeights : 25,
	    	  rowHeaders : true,
	    	  columnHeaderHeight : 25,
	    	  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			  filters : true,
			  readOnly : true,
			  //dropdownMenu : true,
			  allowRemoveRow : false,
			  //columnSorting : {indicator : true},
	          autoColumnSize : {samplingRatio : 23},
	          mergeCells : false,
	          allowInsertRow : false
	  };
	return conectInfoSettings;
}

//검색그리드
function fn_gridConeOption(type){
	if(type){
		$("#conectInfo_div1").show();
		$("#conectInfo_div2").show();
		$("#conectInfo_div3").show();
		$("#conectInfo_div4").hide();
		$("#conectInfo_div5").hide();
		$("#conectInfo_div6").hide();
	}else{
		$("#conectInfo_div1").hide();
		$("#conectInfo_div2").hide();
		$("#conectInfo_div3").hide();
		$("#conectInfo_div4").show();
		$("#conectInfo_div5").show();
		$("#conectInfo_div6").show();
	}
}

//검색구분 변경
function fn_changeConectInfoType(type){
	let coneCol = new fn_coneTableCol();
	let coneHeader = new fn_coneTableHeader();
	let coneHidden = new fn_coneTableHidden();
	var col, header, hidden;

	$('#alignConectInfo option:eq(0)').prop('selected', true);

	//접속정보
	if(type == "01"){
		fn_gridConeOption(true);
		col = coneCol.coneCol;
		header = coneHeader.coneHeader;
		hidden = coneHidden.coneHidden;
		conectInfoHot.updateSettings(fn_handsonGridConeOption(col, header, hidden));
		//$("#conectInfoTitme").text(colConectInfo)
	//변경이력
	}/*else{
		fn_gridConeOption(false);
		col = coneCol.coneChangeCol;
		header = coneHeader.coneChangeHeader;
		hidden = coneHidden.coneChangeHidden;
		conectInfoHot.updateSettings(fn_handsonGridConeOption(col, header, hidden));
		$("#conectInfoTitme").text(colChangeInfo)
	}*/

	fn_clearConectInfo();
	fn_searchConectInfo();
};
