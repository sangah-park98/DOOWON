var pfUserHot;
var pfUserSettings;
var pfUserIndex = 9999;
var pfUserScrollTp = true;
var stsSelect = [];
var grpSelect = [];

$(document).ready(function () {
    
   /* grpCdList = grpCdList.replace('[', '').replace(']', '');
    grpSelect = grpCdList.split(', ');

    stsCdList = stsCdList.replace('[', '').replace(']', '');
    stsSelect = stsCdList.split(', ');*/
    
    userCol = new fn_userTableCol();
    
    var pfUserElement = document.querySelector('#pfCmpnyTable');
    var pfUserElementContainer = pfUserElement.parentNode;
    // pfUserHot으로 변경
    pfUserHot = new Handsontable(pfUserElement, pfUserSettings);

    // afterOnCellMouseDown 이벤트 핸들러에서도 pfUserHot으로 변경
    pfUserHot.addHook('afterOnCellMouseDown', function (event, coords, TD) {
        var column = coords.col; // 클릭한 열의 인덱스
        var data = pfUserHot.getDataAtRow(coords.row); // 클릭한 행의 데이터
        var selectedRadioValue = $('input[name="pfcompny_srch1"]:checked').val(); 
        
        // 'compZip' 열 클릭 시
        if (userCol.userCol[column].data === 'compZip' && selectedRadioValue === '01') {
            openDaumPostcodePopup(coords);
        }
    });

    fn_changePfUser('read');

    fn_scroll(); // 스크롤 함수
    
});

/** 이벤트 Start **/


//테이블 타입 변경
$("input[name=pfCmpnyType]").change(function(){
	  fn_changePfUser($(this).val());
});

//정렬항목
$("select[name=alignPfCmpny]").change(function(){
		fn_searchPfCmpny();
});

//row 수
$("select[name=pfCmpnyPageCnt]").change(function(){
		fn_searchPfCmpny();
});

//검색구분 변경
$("input[name=pfcompny_srch1]").change(function(){
	$('input[name="pfCmpnyType"]:radio[value="read"]').prop('checked',true);
	var selectedValue = $(this).val();
	fn_changePfUserType($(this).val());
	fn_changePfUser($(this).val());
	if(selectedValue === "01") {
		//사업자관리
		$("#cmpnyView").text("사업자 관리");
		$("#cmpnyView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
	}else{
		$("#cmpnyView").text("사업자 - 지사");
		$("#cmpnyView").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
	}
	
});

function fn_scroll(){
	$("#pfCmpnyTable .wtHolder").scroll(function(){
		  var scrollTop = $("#pfCmpnyTable .wtHolder").scrollTop();
		  var countPerPage = $("#pfCmpnyPageCnt option:selected").val();
		  var rowHeight = pfUserHot.getRowHeight();
		  var addCnt = 692;
		  if(countPerPage == "50"){
			  addCnt = 692;
		  }else if(countPerPage == "100"){
			  addCnt = 1943;
		  }else if(countPerPage == "200"){
			  addCnt = 4443;
		  }else if(countPerPage == "500"){
			  addCnt = 11943;
		  }

		  if(pfUserScrollTp && pfUserIndex != 9999 && scrollTop >= (countPerPage * pfUserIndex * rowHeight) + addCnt){
			  fn_pfUserScroll();
		  }
	});
}
/** 이벤트 End **/

//스크롤
function fn_pfUserScroll(){
	if($("input[name=pfCmpnyType]:checked").val() == "enrol")
		return;
	pfUserScrollTp = false;
	pfUserIndex++;
	$.ajax({
		type : "POST",
		url : "/cmmn/selectCompnyList.do",
		data : fn_setFtaUserForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	console.log('data>>',data)
        	var getData = pfUserHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	pfUserHot.loadData(meargeJson);

        	pfUserScrollTp = true;
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
		fn_searchPfCmpny();
    }
}

//검색
function fn_searchPfCmpny(){
	pfUserIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectCompnyList.do",
		data : fn_setFtaUserForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
        	if($("input[name=pfCmpnyType]:checked").val() == 'enrol'){
        		pfUserHot.loadData([]);
        		pfUserHot.alter('insert_row_below', 1, 1);
        		if($("input:radio[name=pfcompny_srch1]:checked").val() == "02"){
        			var cmpnyCd = data.resultList[0].cmpnyCd;
        			var cmpnyNm = data.resultList[0].cmpnyNm;
        			pfUserHot.setDataAtCell(0, 0, cmpnyCd);
        			pfUserHot.setDataAtCell(0, 1, cmpnyNm);
        		}
        	}else{
        		pfUserHot.loadData([]);
            	pfUserHot.loadData(data.resultList);
            	$("#pfCmpnyCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
        	}

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
function fn_setFtaUserForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=pfcompny_srch1]:checked").val();
	sData["srch2"] = $("#pfCompny_srch2").val();
	sData["srch3"] = $("#pfCompny_srch3").val();
	//sData["srch4"] = $("input:radio[name=pfCmpny_srch4]:checked").val();
	sData["srch5"] = $("#pfCmpny_srch5").val();
	sData["srch6"] = $("#pfCmpny_srch6").val();
	sData["alignItem"] = $("#alignPfCmpny option:selected").val();
	sData["recordCountPerPage"] = $("#pfCmpnyPageCnt option:selected").val();
	sData["pageIndex"] = pfUserIndex;
	return sData;
};

//검색조건 초기화
function fn_clearPfCmpny(){
	$("#pfCompny_srch2").val("");
	$("#pfCmpny_srch6").val("");
	$("#pfCmpny_srch5").val("");
	$("#pfCompny_srch3").val("");
	//$("input:radio[name=pfCmpny_srch4]")[0].checked = true;
	$("#pfCmpny_srch5").val("");
};

//저장버튼 클릭
function fn_savePfCmpnyCheck(){
	if(pfUserHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validatePfCmpny();
};

//정합성 체크
function fn_validatePfCmpny(){
	pfUserHot.validateCells(function(result) {
		if(result){
			fn_savePfCmpnyData();
		}else{
			pfUserHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_savePfCmpnyData(){

	if(!confirm(msgSaveConfirm)){ return }

	var saveFtaUserData = pfUserHot.getSourceData();

	var dataType = $("input:radio[name=pfcompny_srch1]:checked").val();
	var tableType = $("input:radio[name=pfCmpnyType]:checked").val();
	for(var i=0; i<saveFtaUserData.length; i++){
		saveFtaUserData[i]["cdTp"] = dataType;
		saveFtaUserData[i]["mnTp"] = tableType;
	}
	
	$.ajax({
		type : "POST",
		url : "/cmmn/saveCompnyInfo.do",
		data : JSON.stringify(saveFtaUserData),
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		$('input[name="pfCmpnyType"]:radio[value="read"]').prop('checked',true);
    			fn_changePfUser($('input[name="pfCmpnyType"]').val());
    			fn_searchPfCmpny();
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

//테이블 컬럼생성
function fn_userTableCol() {
	var tableType = $("input:radio[name=pfCmpnyType]:checked").val();

	var pfuserPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var pfuserPkNoneEditLeft = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").append(value);
	};

	var manualYnChange = function (instance, td, row, col, prop, value, cellProperties) {
		(value == "Y") ? value = colAutoApp : value = colManualApp;
		$(td).empty().append(value).css("text-align", "center");
	}

	var stsCdChange = function (instance, td, row, col, prop, value, cellProperties)
	{
		if(value == "01")
			value = colUse;
		else if(value == "02")
			value = colUnUsed;

		$(td).empty().append(value).css("text-align", "center");
	}

	var localPrtyChange = function (instance, td, row, col, prop, value, cellProperties)
	{
		if(value == "01")
			value = colRegionalUse;
		else if(value == "02")
			value = colFifoUse;
		$(td).empty().append(value).css("text-align", "center");
	}



	var appYnRender = function(instance, td, row, col, prop, value, cellProperties){
		var text= "";
		if(value == "10" || value == colConfmRequst){
			text = colConfmRequst;
			$(td).empty().append(colConfmRequst).css("text-align", "center");
		}else if(value == "20" || value == colConfm){
			text = colConfm;
			$(td).empty().append(colConfm).css("text-align", "center");
		}else{
			text = colConfmReject;
			$(td).empty().append(colConfmReject).css("text-align", "center");
		}
	}

	var trckngDaysCheck = function(instance, td, row, col, prop, value, cellProperties)
	{
		if(value = null || value == undefined)
		{
			value = 180;
		}
		$(td).empty().append(inputData).css("text-align", "right");
	}


	//사업자 컬럼
	this.userCol = [
		(tableType == "edit") ? {data : 'compRegNo', type : 'text', className : "htCenter", width: 100,wordWrap: false, readOnly: true, renderer:pfuserPkNoneEdit} :
							(tableType == "read") ? {data : 'compRegNo', className : "htCenter", width: 100,wordWrap: false,
															validator : function(value, callback){callback(notEmpty(value, 10))}} :
													{data : 'compRegNo', className : "htCenter", width: 100, wordWrap: false,validator : function(value, callback){callback(notEmpty(value, 10))}},
		{data : 'compName', type: 'text',wordWrap: false, className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 80))}},
		{data : 'compCeo', type: 'text',wordWrap: false , className : "htCenter"},
		{data : 'compZip', editor : 'text',wordWrap: false, className : "htCenter"},
		{data : 'compAddr1', editor : 'text',wordWrap: false, className : "htCenter"},
		{data : 'compAddr2', editor : 'text',wordWrap: false, className : "htCenter"},
		{data : 'mangerEmail', type: 'text',wordWrap: false, className : "htCenter"},
		{data : 'delYn', editor : 'select',wordWrap: false, selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		];
		

	//사업자 - 지사 컬럼
	this.userIdCol = (tableType == "edit") ? [
	    {data: 'compName', type: 'text', className: "htCenter",wordWrap: false, width: 50, readOnly: true, renderer: pfuserPkNoneEdit},
	    {data: 'compRegNo', type: 'text', className: "htCenter",wordWrap: false, width: 50, readOnly: true, renderer: pfuserPkNoneEdit},
	    {data: 'branchCd', type: 'text', className: "htCenter",wordWrap: false, width: 50, readOnly: true, renderer: pfuserPkNoneEdit},
	    {data: 'cusPrgCd', type: 'text', className: "htCenter",wordWrap: false, validator: function(value, callback){callback(notEmpty(value, 11))}},
	    {data: 'delYn', editor: 'select',wordWrap: false, selectOptions: ['Y', 'N'], className: "htCenter", width: 100},
	] : (tableType == "enrol") ? [
	    {data: 'compName', type: 'text',wordWrap: false, className: "htCenter", readOnly: true, renderer: pfuserPkNoneEdit},
	    {data: 'compRegNo', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'branchCd', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'cusPrgCd', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'delYn', editor: 'select',wordWrap: false, selectOptions: ['Y', 'N'], className: "htCenter"},
	] : [
	    {data: 'compName', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'compRegNo', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'branchCd', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'cusPrgCd', type: 'text',wordWrap: false, className: "htCenter"},
	    {data: 'delYn', editor: 'select',wordWrap: false, selectOptions: ['Y', 'N'], className: "htCenter"},
	];

	
}

//테이블 해더생성
function fn_userTableHeader() {
	//사업자 테이블 해더
	this.userHeader = [
		"사업자번호","회사명","대표자","우편번호","대표주소","상세주소","총책임자 EMAIL","삭제여부"
	];

	//사업자 - 지사 해더
	this.userIdHeader = [
		"회사명","사업자번호","지사코드","통관시스템","삭제여부"
	];

}

//히든컬럼 생성
function fn_userTablehiddenCol() {
	var tableType = $("input:radio[name=pfCmpnyType]:checked").val();

	//사용자 히든컬럼
	this.userHidden = (tableType == "read") ? [16] : [];

	//사용자ID 히든컬럼
	this.useridHidden = [];
}


//Table
function fn_handsonGridUserOption(col, header, hidden){
	var tableType = $("input:radio[name=pfCmpnyType]:checked").val();

	pfUserSettings = {
		columns:col,
		colHeaders:header,
		hiddenColumns : {
			copyPasteEnabled : false,
			indicators : false,
			columns : hidden
		},
		stretchH : 'all',
		  width : '100%',
		  height : 585,
		  columnHeaderHeight : 25,
		  rowHeights : 25,
		  rowHeaders : true,
		  manualRowResize : true,
		  manualColumnResize : true,
		  autoWrapRow : true,
		  manualRowMove : true,
		  manualColumnMove : false,
		  filters : true,
		  mergeCells : false,
		  allowRemoveRow : true,
		  readOnly : (tableType == "read") ? true : false,

		  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo'] : false,
	      autoColumnSize : {samplingRatio : 23},
	};
	return pfUserSettings;
}

//테이블 타입 변경
function fn_changePfUser(type){
	if(type == "edit"){
		$("#btnPfCmpnySave").show();

	}else if(type == "enrol"){
		$("#btnPfCmpnySave").show();

	}else{
		$("#btnPfCmpnySave").hide();
	}
	var searchTp = $("input:radio[name=pfcompny_srch1]:checked").val();
	fn_changePfUserType(searchTp);
};

//검색 그리드
function fn_userGridOption(type){
	$("#pfCmpnyEnrol").hide();
	$("#fpCmpny_div2").hide();
	$("#fpCmpny_div3").hide();
	$("#fpCmpny_div7").hide();
	$("#fpCmpny_div8").hide();
	$("#fpCmpny_div9").hide();
	if(type == "01"){
		$("#line1").show();
		$(".cmpnyName").show();
		$(".cmpnyNum1").show();
		$(".jisaCode").hide();
		$(".cmpnyNum2").hide();
		//$("#CmpnyInfo_GridTitle").text(colUserInfo);
	}else if(type == "02"){
		// 권한이 KORD MGR 인 경우만 신규등록 가능
		/*if(colAuthor == "KORD MGR"){
			$("#pfCmpnyEnrol").show();
		} else {
			$("#pfCmpnyEnrol").hide();
		}*/
		$(".cmpnyName").show();
		$(".cmpnyNum1").hide();
		$(".jisaCode").show();
		$(".cmpnyNum2").show();
		//$("#CmpnyInfo_GridTitle").text(colUserPerld);
	}else{
		/*if(colAuthor == "Client MGR" || colAuthor == "Client" ){
			$("#pfCmpnyEnrol").hide();
		} else{
			$("#pfCmpnyEnrol").show();
		}*/
		$("#line1").hide();
		$("#fpCmpny_div9").hide();
		$("#fpCmpny_div7").hide();
		//$("#CmpnyInfo_GridTitle").text(colPlntInfo);
	}
}

//검색구분 변경
function fn_changePfUserType(type){
	let userCol = new fn_userTableCol();
	let userHeader = new fn_userTableHeader();
	let userHidden = new fn_userTablehiddenCol();
	var col, header, hidden;
	$('#alignPfCmpny option:eq(0)').prop('selected', true);

	//사업자
	if(type == "01"){
		col = userCol.userCol;
		header = userHeader.userHeader;
		hidden = userHidden.userHidden;
		pfUserHot.updateSettings(fn_handsonGridUserOption(col, header, hidden));
		fn_clearPfCmpny();

	//사업자 - 지사
	}else if(type == "02"){
		col = userCol.userIdCol;
		header = userHeader.userIdHeader;
		hidden = userHidden.userIdHidden;
		pfUserHot.updateSettings(fn_handsonGridUserOption(col, header, hidden));
		fn_clearPfCmpny();
	}
	fn_userGridOption(type);
	fn_searchPfCmpny();
	};


function fn_callUserTab(row){
	var rowData = pfUserHot.getSourceDataAtRow(row);
	$("input:radio[name=pfcompny_srch1]")[1].checked = true;
	$("#pfCompny_srch2").val(rowData.cmpnyNm);
	$("#pfCompny_srch3").val(rowData.cmpnyNmEn);
	fn_changePfUserType("02");
}




// 카카오 우편번호 api
function openDaumPostcodePopup(coords) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            var rowData = pfUserHot.getSourceDataAtRow(coords.row);
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                rowData.compAddr2 = extraAddr;
                pfUserHot.setDataAtRowProp(coords.row, 'compAddr2', extraAddr);
            
            } else {
                rowData.compAddr2 = extraAddr;
                pfUserHot.setDataAtRowProp(coords.row, 'compAddr2', '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            // 핸즈온테이블에 값을 넣는다.
            rowData.compZip = data.zonecode;
            rowData.compAddr1 = addr;
            pfUserHot.setDataAtRowProp(coords.row, 'compZip', data.zonecode);
            pfUserHot.setDataAtRowProp(coords.row, 'compAddr1', addr);

          /*  // 현재 포커스를 설정하고자 하는 셀의 열 인덱스를 가져옴
            var focusColumn = pfUserHot.propToCol('compAddr2');

	         // 해당 열이 DOM에 있는지 확인하고 포커스를 줌
	         var colHeader = pfUserHot.getColHeader(focusColumn);
	         if (colHeader && colHeader.parentElement) {
	             pfUserHot.selectCell(coords.row, focusColumn);
	             pfUserHot.getActiveEditor().focus();
	         }*/
            
        }
    }).open();
}