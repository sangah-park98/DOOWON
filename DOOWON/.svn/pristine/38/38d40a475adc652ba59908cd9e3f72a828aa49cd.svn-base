var cmmnCdHot;
var cmmnCdSettings;
var cmmnCdIndex = 9999;
var cmmnCdScrollTp = true;
var cmmnCdDropdown = [];
$( document ).ready(function() {

	  var cmmnCdElement = document.querySelector('#cmmnCdTable');
	  var cmmnCdElementContainer = cmmnCdElement.parentNode;


	  cmmnCdHot = new Handsontable(cmmnCdElement, cmmnCdSettings);



	  $("#cmmnCdTable .wtHolder").scroll(function(){

		  var scrollTop = $("#cmmnCdTable .wtHolder").scrollTop();
		  var countPerPage = $("#cmmnCdPageCnt option:selected").val();
		  var rowHeight = cmmnCdHot.getRowHeight();
		  console.log("scrollTop"+scrollTop);
		  console.log("countPerPage"+countPerPage);
		  console.log("rowHeight"+rowHeight);
		  var addCnt = 670;
		  if(countPerPage == "50"){
			  addCnt = 670;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "150"){
			  addCnt = 3290;
		  }else if(countPerPage == "200"){
			  addCnt = 4540;
		  }

		 // if(cmmnCdScrollTp && cmmnCdIndex != 9999 && scrollTop >= (countPerPage * cmmnCdIndex * rowHeight) + addCnt){
			// console.log("스크롤")
			  fn_cmmnCdScroll();
		  //}
	  });


	  $("#btnCmmnCdSave").hide();
	  fn_changeCmmnCd('read');
	  fn_searchCmmnCd();

});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-ftacmmncd").hasClass("active")) {
//			fn_searchCmmnCd();
//		} 
//	}
//})

//테이블 타입 변경
$("input[name=cmmnCdType]").change(function(){
	  fn_changeCmmnCd($(this).val());
});

//정렬항목
$("select[name=alignCmmnCd]").change(function(){
	  fn_searchCmmnCd();
});

//row 수
$("select[name=cmmnCdPageCnt]").change(function(){
	  fn_searchCmmnCd();
});
//코드타입 변경
$("input[name=cmmnCd_srch6]").change(function(){
	$('input:radio[name=cmmnCdType]:radio[value="read"]').prop('checked', true);
	fn_changeCmmnCd($("#cmmnCdType").val());
	  fn_changeCmmnCdType($(this).val());
});
/** 이벤트 End **/

//스크롤
function fn_cmmnCdScroll(){
	console.log("11111");
	if($("input[name=cmmnCdType]:checked").val() == "enrol")
		return;
	cmmnCdScrollTp = false;
	cmmnCdIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfCmmnCdList.do",
		data : fn_setCmmnCdForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = cmmnCdHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	cmmnCdHot.loadData(meargeJson);

        	cmmnCdScrollTp = true;
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
		fn_searchCmmnCd();
    }
}

//검색
function fn_searchCmmnCd(){
	cmmnCdIndex = 0;
	console.log("222");
	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfCmmnCdList.do",
		data : fn_setCmmnCdForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=cmmnCdType]:checked").val() == "enrol"){
        		cmmnCdHot.loadData([]);
        		cmmnCdHot.alter('insert_row_below', 1, 1);
        	}else{
        		cmmnCdHot.loadData([]);
            	cmmnCdHot.loadData(data.resultList);
            	$("#cmmnCdCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
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
function fn_setCmmnCdForm(){
	var sData = {};
	sData["srch2"] = $("#cmmnCd_srch2").val(); // 코드영문명
	sData["srch3"] = $("#cmmnCd_srch3").val(); // 코드명
	sData["srch4"] = $("#cmmnCd_srch4").val(); // 그룹코드
	sData["srch5"] = $("input:radio[name=cmmnCd_srch5]:checked").val(); // 화면표시
	//sData["srch6"] = $("input:radio[name=cmmnCd_srch6]:checked").val();

	sData["alignItem"] = $("#alignCmmnCd option:selected").val();
	sData["recordCountPerPage"] = $("#cmmnCdPageCnt option:selected").val();
	sData["pageIndex"] = cmmnCdIndex;
	return sData;
};

//검색조건 초기화
function fn_clearCmmnCd(){
	$("#cmmnCd_srch1").val("");
	$("#cmmnCd_srch2").val("");
	$("#cmmnCd_srch3").val("");
	$("#cmmnCd_srch4").val("");

	$("input:radio[name=cmmnCd_srch5]")[0].checked = true;

};

//저장버튼 클릭
function fn_saveCmmnCdCheck(){
	if(cmmnCdHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validateCmmnCd();
};

//정합성 체크
function fn_validateCmmnCd(){
	cmmnCdHot.validateCells(function(result) {
		if(result){
			fn_saveCmmnCdData();
		}else{
			cmmnCdHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveCmmnCdData(){

	if(!confirm("저장하시겠습니까?")){
		return;
	}

	var saveCmmnCdData = cmmnCdHot.getSourceData();
	var cdTp = $("input:radio[name=cmmnCd_srch6]:checked").val();
	for(var i=0; i<saveCmmnCdData.length; i++){
		saveCmmnCdData[i]["cdTp"] = cdTp;
	}

	$.ajax({
		type : "POST",
		url : "/cmmn/savePfCmmnCdInfo.do",
		data : JSON.stringify(saveCmmnCdData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {

        	if(data == "success"){
        		alert("저장되었습니다.");
        		$('input[name="cmmnCdType"]:radio[value="read"]').prop('checked',true);
        		fn_changeCmmnCd($('#cmmnCdType').val());
        		fn_searchCmmnCd();
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

//테이블 컬럼
function fn_ftacmmncdTableCol(){
	var tableType = $("input:radio[name=cmmnCdType]:checked").val();
	var cmmnCdPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var grpCdRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		  var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callCmmnCdTab('+row+')"></i>');
		  $(td).empty().append($button).append("  " + value).css('text-align', 'center');
	  };

	this.grpCol = [
		(tableType == "edit") ? {data : 'grpCd', type : 'text', className : "htCenter", width: 50, renderer:cmmnCdPkNoneEdit, readOnly:true} :
							    (tableType == "enrol") ? {data : 'grpCd', className : "htCenter", width: 50, validator : function(value, callback){callback(notEmpty(value, 10))}} :
								 						 {data : 'grpCd', renderer : grpCdRenderer, className : "htCenter", width: 50},
		{data : 'grpNmVn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'grpNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'grpNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'dispYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 50,
			validator: function(value, callback){callback(selectboxCheck(value, this.selectOptions))}}
	];

	this.cmmnCol = [
		  (tableType == "edit") ? {data : 'grpCd', editor : 'select', selectOptions : cmmnCdDropdown, type : 'autocomplete', className : "htCenter", width: 70, readOnly:true, renderer:cmmnCdPkNoneEdit} :
								  {data : 'grpCd', editor : 'select', selectOptions : cmmnCdDropdown, type : 'autocomplete', className : "htCenter", width: 70, validator:
									  function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		  (tableType == "edit") ? {data : 'cmmnCd', type : 'text', className : "htCenter", width: 70, readOnly:true, renderer:cmmnCdPkNoneEdit} :
								  {data : 'cmmnCd', type : 'text', className : "htCenter", width: 70, validator : function(value, callback){callback(notEmpty(value, 10))}},
		  {data : 'cmmnNmEn', type : 'text', validator : function(value, callback){
			  if(!value || String(value.trim()).length == 0){
				  callback(false);
			  }else{
				  callback(notEmpty(value, 100))
			  }
		  }},
		  {data : 'cmmnNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 100))}},
		  {data : 'ordrSn', type : 'numeric', width: 50, validator : function(value, callback){callback(notEmpty(String(value), 100))}},
		  {data : 'distCd', type : 'text', className : 'htCenter', width : 70},
		  {data : 'dispYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 50,
			  validator: function(value, callback){callback(selectboxCheck(value, this.selectOptions))}}
	];

}

//테이블 헤더
function fn_ftacmmncdTableHeader(){

	this.grpHeader = [
		'그룹코드','공통코드','코드명','코드명(영문)','정렬순서','구분코드','화면표시'
	];

	this.cmmnHeader = [
		'그룹코드','공통코드','코드명','코드명(영문)','정렬순서','구분코드','화면표시'
	];
}

//테이블 히든컬럼
function fn_ftacmmncdTableHidden(){
	var tableType = $("input:radio[name=cmmnCdType]:checked").val();

	this.grpHidden = [];

	this.cmmnHidden = [];
}

//Table
function fn_handsonGridftacmmncdOption(col, header, hidden){
	var tableType = $("input:radio[name=cmmnCdType]:checked").val();

	cmmnCdSettings = {
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
			
			contextMenu : (tableType == 'enrol') ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
			//dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
			filters : true,
			readOnly : (tableType == 'read') ? true : false,
			allowRemoveRow : false,
			//columnSorting : {indicator : true},
			autoColumnSize : {samplingRatio : 23},
			mergeCells : false,
	};
	return cmmnCdSettings;
}

//테이블 타입 변경
function fn_changeCmmnCd(type){
	if(type == "edit"){
		$("#btnCmmnCdSave").show();
	}else if(type == "enrol"){
		$("#btnCmmnCdSave").show();
	}else{
		$("#btnCmmnCdSave").hide();
	}

	var searchTp = $("input:radio[name=cmmnCd_srch6]:checked").val();
	fn_changeCmmnCdType(searchTp);

};

//코드타입 변경
function fn_changeCmmnCdType(type){
	let ftacmmncdCol = new fn_ftacmmncdTableCol();
	let ftacmmncdHeader = new fn_ftacmmncdTableHeader();
	let ftacmmncdHidden = new fn_ftacmmncdTableHidden();
	var col, header, hidden;

	$('#alignCmmnCd option:eq(0)').prop('selected', true);

	//그룹코드
	if(type == "01"){
		col = ftacmmncdCol.grpCol;
		header = ftacmmncdHeader.grpHeader;
		hidden = ftacmmncdHidden.grpHidden;
		cmmnCdHot.updateSettings(fn_handsonGridftacmmncdOption(col, header, hidden));
		$("#cmmnCd_srch4").val("");

	//공통코드
	}else{
		col = ftacmmncdCol.cmmnCol;
		header = ftacmmncdHeader.cmmnHeader;
		hidden = ftacmmncdHidden.cmmnHidden;
		fn_searchGrpCdDropdown();
		cmmnCdHot.updateSettings(fn_handsonGridftacmmncdOption(col, header, hidden));

	}
	fn_searchCmmnCd();
};

//공통그룹코드 dropdown
function fn_searchGrpCdDropdown(){
	$.ajax({
		type : "POST",
		url : "/cmmn/selectCmmnGrpDropdown.do",
		dataType: "json",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        success : function(data) {
        	console.log("data"+data);
        	for(var i=0; i<data.resultList.length; i++){
        		cmmnCdDropdown.push(data.resultList[i].grpCd);
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

function fn_callCmmnCdTab(row){
	var rowData = cmmnCdHot.getSourceDataAtRow(row);
	$("input:radio[name=cmmnCd_srch6]")[1].checked = true;
	$("#cmmnCd_srch4").val(rowData.grpCd);
	fn_changeCmmnCdType("02");
};
