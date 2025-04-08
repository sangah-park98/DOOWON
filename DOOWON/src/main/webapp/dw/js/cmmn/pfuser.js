var pfUserHot;
var pfUserSettings;
var pfUserIndex = 9999;
var pfUserScrollTp = true;
var stsSelect = [];
var grpSelect = [];
// 변경된 데이터 추적 
var userUpdateArray = [];
var agreeYnChanges = []; // Track changes in agreeYn separately

$( document ).ready(function() {

	/*grpCdList = grpCdList.replace('[','').replace(']','');
	grpSelect = grpCdList.split(', ');

	stsCdList = stsCdList.replace('[','').replace(']','');
	stsSelect = stsCdList.split(', ');
*/
	var pfUserElement = document.querySelector('#pfUserTable');
	var pfUserElementContainer = pfUserElement.parentNode;

	pfUserHot = new Handsontable(pfUserElement, pfUserSettings);
	fn_changePfUser('read');

	fn_scroll(); //스크롤 함수
	
	// 변경된 데이터 추적 
	pfUserHot.addHook('afterChange', function (changes, source) {
	    var tableType = $("input:radio[name=pfUserType]:checked").val();
	    if (tableType === 'edit' && changes) {  // 'changes'가 정의되어 있는지 확인
	        for (var i = 0; i < changes.length; i++) {
	            var change = changes[i];
	            var row = change[0];
	            var col = change[1];
	            var oldValue = change[2];
	            var newValue = change[3];

	            // userUpdateArray 배열 초기화
	            if (!userUpdateArray[row]) {
	                userUpdateArray[row] = {};
	            }

	            userUpdateArray[row][col] = newValue;

	            // 'agreeYn'에서 'N'에서 'Y'로 변경사항 추적
	            if (col === 'apprYn' && oldValue === 'N' && newValue === 'Y') {
	                agreeYnChanges.push({
	                    row: row,
	                    col: col,
	                    oldValue: oldValue,
	                    newValue: newValue
	                });
	            }
	        }
	    }
	});
	
});

/** 이벤트 Start **/


//테이블 타입 변경
$("input[name=pfUserType]").change(function(){
	  fn_changePfUser($(this).val());
});

//정렬항목
$("select[name=alignPfUser]").change(function(){
	  fn_searchPfUser();
});

//row 수
$("select[name=pfUserPageCnt]").change(function(){
	  fn_searchPfUser();
});

//검색구분 변경
$("input[name=pfUser_srch1]").change(function(){
	$('input[name="pfUserType"]:radio[value="read"]').prop('checked',true);
	fn_changePfUserType($(this).val());
	fn_changePfUser($(this).val());
});

function fn_scroll(){
	$("#pfUserTable .wtHolder").scroll(function(){
		  var scrollTop = $("#pfUserTable .wtHolder").scrollTop();
		  var countPerPage = $("#pfUserPageCnt option:selected").val();
		  var rowHeight = pfUserHot.getRowHeight();

		  var addCnt = 695;
		  if(countPerPage == "50"){
			  addCnt = 695;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "150"){
			  addCnt = 3290;
		  }else if(countPerPage == "200"){
			  addCnt = 4540;
		  }

		  if(pfUserScrollTp && pfUserIndex != 9999 && scrollTop >= (countPerPage * pfUserIndex * rowHeight) + addCnt){
			  fn_pfUserScroll();
		  }
	});
}
/** 이벤트 End **/

//스크롤
function fn_pfUserScroll(){
	if($("input[name=pfUserType]:checked").val() == "enrol")
		return;
	pfUserScrollTp = false;
	pfUserIndex++;
	$.ajax({
		type : "POST",
		url : "/cmmn/selectUserInfoList.do",
		data : fn_setPfUserForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	console.log('data>>',data)
        	var getData = pfUserHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	pfUserHot.loadData(meargeJson);

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
		fn_searchPfUser();
    }
}

//검색
function fn_searchPfUser(){
	pfUserIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectUserInfoList.do",
		data : fn_setPfUserForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
        	if($("input[name=pfUserType]:checked").val() == 'enrol'){
        		pfUserHot.loadData([]);
        		pfUserHot.alter('insert_row_below', 1, 1);
        		if($("input:radio[name=pfUser_srch1]:checked").val() == "02"){
        			var cmpnyCd = data.resultList[0].cmpnyCd;
        			var cmpnyNm = data.resultList[0].cmpnyNm;
        			pfUserHot.setDataAtCell(0, 0, cmpnyCd);
        			pfUserHot.setDataAtCell(0, 1, cmpnyNm);
        		}
        	}else{
        		pfUserHot.loadData([]);
            	pfUserHot.loadData(data.resultList);
            	$("#pfUserCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
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
function fn_setPfUserForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=pfUser_srch1]:checked").val();
	sData["srch2"] = $("#pfUser_srch2").val();
	sData["srch3"] = $("#pfUser_srch3").val();
	sData["srch4"] = $("input:radio[name=pfUser_srch4]:checked").val();
	sData["srch5"] = $("#pfUser_srch5").val();
	sData["alignItem"] = $("#alignPfUser option:selected").val();
	sData["recordCountPerPage"] = $("#pfUserPageCnt option:selected").val();
	sData["pageIndex"] = pfUserIndex;
	return sData;
};

//검색조건 초기화
function fn_clearPfUser(){
	$("#pfUser_srch2").val("");
	$("#pfUser_srch3").val("");
	$("input:radio[name=pfUser_srch4]")[0].checked = true;
	$("#pfUser_srch5").val("");
};

//저장버튼 클릭
function fn_savePfUserCheck(){
	if(pfUserHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validatePfUser();
};

//정합성 체크
function fn_validatePfUser(){
	pfUserHot.validateCells(function(result) {
		if(result){
			fn_savePfUserData();
		}else{
			pfUserHot.render();
			alert("정합성 체크해주세요");
		}
    });
};



//저장
function fn_savePfUserData(){

	if(!confirm("저장하시겠습니까?")){ return }

	var saveUserData = pfUserHot.getSourceData();

	console.log("JSON"+JSON.stringify(saveUserData));
	var dataType = $("input:radio[name=pfUser_srch1]:checked").val();
	var tableType = $("input:radio[name=pfUserType]:checked").val();
	for(var i=0; i<saveUserData.length; i++){
		saveUserData[i]["cdTp"] = dataType;
		console.log("dataType"+dataType);
		saveUserData[i]["mnTp"] = tableType;
		console.log("tableType"+tableType);
	}
	
	$.ajax({
		type : "POST",
		url : "/cmmn/saveUserInfo.do",
		data : JSON.stringify(saveUserData),
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert("저장하였습니다.");
        		$('input[name="pfUserType"]:radio[value="read"]').prop('checked',true);
    			fn_changePfUser($('input[name="pfUserType"]').val());
        		fn_searchPfUser();
        		fn_sendApprovalEmail();
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

function fn_sendApprovalEmail() {
    var saveUserData = pfUserHot.getSourceData();

    // Iterate through agreeYn changes and trigger email sending
    for (var i = 0; i < agreeYnChanges.length; i++) {
        var change = agreeYnChanges[i];
        var row = change.row;
        var col = change.col;
        var oldValue = change.oldValue;
        var newValue = change.newValue;

        // 서버에 이메일 전송 요청
        $.ajax({
            type: "POST",
            url: "/cmmn/sendApprovalEmail.do",
            data: JSON.stringify([saveUserData[row]]), // 배열 형태로 변경
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                if (data == "success") {
                    //alert("사용자에게 승인 메일을 보냈습니다.");
                    resultSendApprovalMailSubmit();  
                }
            },
            error: function (e, textStatus, errorThrown) {
                if (e.status == 400) {
                    alert("Your request is up. Please log back in if you wish to continue");
                    location.href = document.referrer;
                } else {
                    console.log(errorThrown);
                    alert(msgSaveError);
                }
            }
        });
    }
}

function resultSendApprovalMailSubmit(data){
	//$.unblockUI();
	if(data !== "success") {
		//alert("오류입니다.");
		return false;
	}
}

//테이블 컬럼생성
function fn_userTableCol() {
	var tableType = $("input:radio[name=pfUserType]:checked").val();

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


	//사용자 컬럼
	this.userCol = [
		(tableType == "edit") ? {data : 'memberId', type : 'text', className : "htCenter", width: 100, readOnly: true, renderer:pfuserPkNoneEdit} :
							(tableType == "read") ? {data : 'memberId', className : "htCenter", width: 100,
															validator : function(value, callback){callback(notEmpty(value, 20))}} :
													{data : 'memberId', className : "htCenter", width: 100, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'memberName', type: 'text', className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 10))}},
		{data : 'memberPwd', type : 'password', validator : function(value, callback){callback(notEmpty(value, 100))}},
		//{data : 'memberPwd', type: 'text', className: 'htCenter', visible: false, readOnly: (tableType === "edit"), renderer: (tableType === "edit") ? pfuserPkNoneEdit : undefined},
		{data : 'memberEmail', type: 'text', className : "htCenter",validator: function(value, callback) { if (/.*@.*/.test(value)) { callback(true); } else {callback(false); }}},
		{data : 'memberTel', type: 'text', validator:/^[^-./]{0,50}$/, width: 100, className : "htCenter"},
		{data : 'alarmEmail', editor : 'select', selectOptions : ['Y', 'N'], className : "htCenter", width: 80},
		{data : 'alarmSMS', editor : 'select', selectOptions : ['Y', 'N'],   className : "htCenter", width: 80},
		{data : 'alarmKakao', editor : 'select', selectOptions : ['Y', 'N'],  className : "htCenter", width: 80},
		{data : 'shinhanManer',type : 'text', className : "htCenter"},
		{data : 'recvYn',editor : 'select',selectOptions : ['Y', 'N'], className : "htCenter"},
		{data : 'grpCd', editor : 'select', selectOptions : ['KORD Mgr','KORD','KORD Cslt','KORD Agnt','Client Advanced','Client Basic','Client Pro'],  className : "htCenter", width: 100},
		//{data : 'compName', type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 30))}},
		//{data : 'compRegNo', type: 'text', width: 100, className: "htCenter", validator: /^[^-./]{0,50}$/, validatorFunction: function(value, callback) {callback(notEmpty(value, 101));}},
		{data : 'apprYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		];
		

	//사용자별 ID 컬럼
	this.userIdCol = (tableType == "edit") ? [
		{data : 'memberId', type : 'text', className : "htCenter", width: 50, readOnly: true, renderer:pfuserPkNoneEdit},
		{data : 'compName', type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'compRegNo', type: 'text', width: 100, className: "htCenter", validator: /^[^-./]{0,50}$/, validatorFunction: function(value, callback) {callback(notEmpty(value, 10));}},
		//{data : 'manger', type: 'text', width: 100, className: "htCenter", validator: /^[^-./]{0,50}$/, validatorFunction: function(value, callback) {callback(notEmpty(value, 50));}},
		{data : 'mangerYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		//{data : 'agreeYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
	] : [
		{data : 'memberId', type : 'text', className : "htCenter", width: 50},
		{data : 'compName', type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'compRegNo', type: 'text', width: 100, className: "htCenter", validator: /^[^-./]{0,50}$/, validatorFunction: function(value, callback) {callback(notEmpty(value, 50));}},
		{data : 'mangerYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		//{data : 'apprYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'],className : "htCenter", width: 100},
	];

	
}

//테이블 해더생성
function fn_userTableHeader() {
	//사용자 테이블 해더
	this.userHeader = [
		  "사용자 ID","사용자명","비밀번호","이메일","전화번호","SMS수신","EMAIL수신","KAKAO수신","신한담당자","리포트 수신여부","그룹 코드","승인여부","삭제여부"
	];

	//사용자별ID 해더
	this.userIdHeader = [
		"사용자 ID","회사명","사업자번호","매니저승인유무","삭제여부"
	];

}

//히든컬럼 생성
function fn_userTablehiddenCol() {
	var tableType = $("input:radio[name=pfUserType]:checked").val();

	//사용자 히든컬럼
	if(tableType == 'edit' || tableType == 'read'){
		this.userHidden = [2];	
	}else{
		this.userHidden = [];	
	}
	

	//사용자ID 히든컬럼
	this.useridHidden = [];
}


//Table
function fn_handsonGridUserOption(col, header, hidden){
	var tableType = $("input:radio[name=pfUserType]:checked").val();

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
		$("#btnPfUserSave").show();

	}else if(type == "enrol"){
		$("#btnPfUserSave").show();

	}else{
		$("#btnPfUserSave").hide();
	}
	var searchTp = $("input:radio[name=pfUser_srch1]:checked").val();
	fn_changePfUserType(searchTp);
};

//검색 그리드
function fn_userGridOption(type){
	console.log('type'+type);
	$("#pfUserEnrol").hide();
	$("#fpUser_div1").hide();
	$("#fpUser_div2").hide();
	$("#fpUser_div7").hide();
	$("#fpUser_div8").hide();
	$("#fpUser_div9").hide();
	if(type == "01"){
		/*$("#line1").show();*/
		$(".userName").show();
		$(".compnyInfo").hide();
		$(".approveUser").show();
		/*$("#fpUser_div9").show();
		$("#pfUserEnrol").show();
		$("#fpUser_div1").show();
		$("#fpUser_div7").show();*/
		//$("#userInfo_GridTitle").text(colUserInfo);
	}else if(type == "02"){
		// 권한이 KORD MGR 인 경우만 신규등록 가능
		/*if(colAuthor == "KORD MGR"){
			$("#pfUserEnrol").show();
		} else {
			$("#pfUserEnrol").hide();
		}*/
		/*$("#pfUserEnrol").show();
		$("#fpUser_div8").show();*/
		$(".userName").hide();
		$(".compnyInfo").show();
		$(".approveUser").hide();
		/*$("#alignPfUser").hide();*/
		//("#userInfo_GridTitle").text(colUserPerld);
	}else{
		/*if(colAuthor == "Client MGR" || colAuthor == "Client" ){
			$("#pfUserEnrol").hide();
		} else{
			$("#pfUserEnrol").show();
		}*/
		$("#line1").hide();
		$("#fpUser_div8").hide();
		$("#fpUser_div9").hide();
		$("#fpUser_div7").hide();
		//$("#userInfo_GridTitle").text(colPlntInfo);
	}
}

//검색구분 변경
function fn_changePfUserType(type){
	let userCol = new fn_userTableCol();
	let userHeader = new fn_userTableHeader();
	let userHidden = new fn_userTablehiddenCol();
	var col, header, hidden;
	$('#alignPfUser option:eq(0)').prop('selected', true);

	//사용자 관리
	if(type == "01"){
		col = userCol.userCol;
		header = userHeader.userHeader;
		hidden = userHidden.userHidden;
		pfUserHot.updateSettings(fn_handsonGridUserOption(col, header, hidden));
		fn_clearPfUser();
		$("#userText").text("사용자 관리");
		$("#userText").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 

	//사용자 - 사업자
	}else if(type == "02"){
		col = userCol.userIdCol;
		header = userHeader.userIdHeader;
		hidden = userHidden.userIdHidden;
		pfUserHot.updateSettings(fn_handsonGridUserOption(col, header, hidden));
		fn_clearPfUser();
		$("#userText").text("사용자 - 사업자");
		$("#userText").prepend('<i class="fa-duotone fa-chart-network text-primary-900"></i>'); 
	}
	fn_userGridOption(type);
	fn_searchPfUser();
	};


function fn_callUserTab(row){
	var rowData = pfUserHot.getSourceDataAtRow(row);
	$("input:radio[name=pfUser_srch1]")[1].checked = true;
	$("#pfUser_srch2").val(rowData.cmpnyNm);
	$("#pfUser_srch3").val(rowData.cmpnyNmEn);
	fn_changePfUserType("02");
}

