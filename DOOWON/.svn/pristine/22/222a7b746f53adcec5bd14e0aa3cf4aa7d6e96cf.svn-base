var pfauthorHot;
var pfauthorSettings;
var pfauthorIndex = 9999;
var pfauthorScrollTp = true;
var authRenderer;
var dropdown1 = [];
var dropdown2 = [];
var dropdown3 = [];

$( document ).ready(function() {

	  var pfauthorElement = document.querySelector('#pfauthorTable');
	  var pfauthorElementContainer = pfauthorElement.parentNode;

	  pfauthorHot = new Handsontable(pfauthorElement, pfauthorSettings);

	  fn_authorGridOption(false);

	  $("#btnpfuthorSave").hide();
	  fn_pfauthorChangeTable('read');
	  fn_searchpfauthor();

	//스크롤 이벤트
	  $("#pfauthorTable .wtHolder").scroll(function(){
	  	  var scrollTop = $("#pfauthorTable .wtHolder").scrollTop();
	  	  var countPerPage = $("#pfauthorPageCnt option:selected").val();
	  	  var rowHeight = pfauthorHot.getRowHeight();
	  	  var addCnt = 695;
	  	  if(countPerPage == "50"){
	  		  addCnt = 695;
	  	  }else if(countPerPage == "100"){
	  		  addCnt = 1945;
	  	  }else if(countPerPage == "200"){
	  		  addCnt = 4445;
	  	  }else if(countPerPage == "200"){
	  		  addCnt = 4540;
	  	  }

	  	  if(pfauthorScrollTp && pfauthorIndex != 9999 && scrollTop >= (countPerPage * pfauthorIndex * rowHeight) + addCnt){
	  		  fn_pfauthorScroll();
	  	  }
	  });
});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-ftaauthor").hasClass("active")) {
//			fn_searchpfauthor();
//		} 
//	}
//})

//검색구분 변경
$("input[name=pfauthor_srch1]").change(function(){
	$('input:radio[name=pfauthorType]:radio[value="read"]').prop('checked', true);
	 fn_pfauthorChangeTable($("#pfauthorType").val())
	  fn_changeFtaauthor($(this).val());
});

//테이블 타입 변경
$("input[name=pfauthorType]").change(function(){
	  fn_pfauthorChangeTable($(this).val())
});

//정렬항목
$("select[name=alignPfauthor]").change(function(){
	  fn_searchpfauthor();
});

//row 수
$("select[name=pfauthorPageCnt]").change(function(){
	  fn_searchpfauthor();
});


/** 이벤트 End **/

//스크롤
function fn_pfauthorScroll(){
	if($("input[name=pfauthorType]:checked").val() == "enrol")
		return;
	pfauthorScrollTp = false;
	pfauthorIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectAuthorList.do",
		data : fn_setFtaauthorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = pfauthorHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	pfauthorHot.loadData(meargeJson);

        	pfauthorScrollTp = true;
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
		fn_searchpfauthor();
    }
}

//검색
function fn_searchpfauthor(){
	pfauthorIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectAuthorList.do",
		data : fn_setFtaauthorForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if( $("input[name=pfauthorType]:checked").val() == "enrol"){
        		pfauthorHot.loadData([]);
        		pfauthorHot.alter('insert_row_below', 1, 1);
        	} else {
        		pfauthorHot.loadData([]);
            	pfauthorHot.loadData(data.resultList);
            	$("#pfauthorCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
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
function fn_setFtaauthorForm(){
	var sData = {};
	sData["srch1"] = $("input:radio[name=pfauthor_srch1]:checked").val();
	sData["srch2"] = $("#pfauthor_srch6 option:selected").val();
	sData["srch3"] = $("#pfauthor_srch3").val();
	sData["srch4"] = $("input:radio[name=pfauthor_srch4]:checked").val();
	sData["srch5"] = $("#pfauthor_srch5").val();
	sData["alignItem"] = $("#alignPfauthor option:selected").val();
	sData["recordCountPerPage"] = $("#pfauthorPageCnt option:selected").val();
	sData["pageIndex"] = pfauthorIndex;
	return sData;
};

//검색조건 초기화
function fn_clearFtaauthor(){
	$("#pfauthor_srch2").val("");
	$("#pfauthor_srch3").val("");
	$("input:radio[name=pfauthor_srch4]")[0].checked = true;
	$("#pfauthor_srch5").val("");
	$("#pfauthor_srch6 option:eq(0)").prop("selected", true);
	$("#pfauthor_div1").hide();
	$("#pfauthor_div2").show();
	$("#pfauthor_div3").hide();
	$("#pfauthor_div4").hide();

	fn_changeFtaauthor($("input:radio[name=pfauthor_srch1]:checked").val());
};

//저장버튼 클릭
function fn_savePfauthorCheck(){
	if(pfauthorHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validatePfauthor();
};

//정합성 체크
function fn_validatePfauthor(){
	pfauthorHot.validateCells(function(result) {
		if(result){
			fn_savePfauthorData();
		}else{
			pfauthorHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_savePfauthorData(){
	if(!confirm("저장하시겠습니까?")){
		return;
	}

	var saveFtaauthorData = pfauthorHot.getSourceData();
	var srchType = $("input:radio[name=pfauthor_srch1]:checked").val();
	console.log(srchType);
	for(var i=0; i<saveFtaauthorData.length; i++){
		saveFtaauthorData[i]["targetType"] = srchType;
	}

	$.ajax({
		type : "POST",
		url : "/cmmn/saveAuthorInfo.do",
		data : JSON.stringify(saveFtaauthorData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert("저장되었습니다.");
        		$('input[name="pfauthorType"]:radio[value="read"]').prop('checked',true);
        		fn_pfauthorChangeTable($('input[name="pfauthorType"]').val());
        		fn_searchpfauthor();
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
function fn_authorTableCol(){
	var tableType = $("input:radio[name=pfauthorType]:checked").val();
	var editRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callAuthTab('+row+','+col+')"></i>');
		var rowData = pfauthorHot.getSourceDataAtRow(row);
		if(rowData.adminYn == "Y"){
			$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
		}else{
			$(td).empty().append($button).css("background-color", "#E6E6E6").css("text-align","center").append("  " + value);
		}
	};

	var authorPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var authRenderer = function (instance, td, row, col, prop, value, cellProperties) {
			  var $button = $('<i class="fas fa-search search-icon" style="cursor:pointer;" onclick="fn_callAuthTab('+row+','+col+')"></i>');
			  var rowData = pfauthorHot.getSourceDataAtRow(row);
			  if(rowData.adminYn == "Y"){
				  $(td).empty().append(value).css("text-align", "center");
			  }else{
				  $(td).empty().append($button).append("  " + value).css("text-align", "center");
			  }
		  };

	this.authorGrpCol = (tableType == "edit") ? [
		{data : 'grpCd', type : 'text', width: 50, renderer:editRenderer, readOnly:true},
		{data : 'grpNm', type : 'text'},
		{data : 'adminYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30, validator: function(value, callback){callback(selectboxCheck(value, this.selectOptions))}}
	] : (tableType == "read") ? [
		{data : 'grpCd', renderer : authRenderer, width: 50, validator : function(value, callback){callback(notEmpty(value, 10))}},
		{data : 'grpNm', type : 'text'},
		{data : 'adminYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30}
	] : [
		{data : 'grpCd', width: 50, validator : function(value, callback){callback(notEmpty(value, 10))}},
		{data : 'grpNm', type : 'text'},
		{data : 'adminYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30}
	];

	this.authorMenucol = [
		(tableType == "edit") ? {data : 'grpCd',  editor : 'select', selectOptions : dropdown1, type : 'autocomplete',  className: 'htCenter', renderer:authorPkNoneEdit, readOnly : true} : 
								{data : 'grpCd',  editor : 'select', selectOptions : dropdown1, type : 'autocomplete',  className: 'htCenter'},
		(tableType == "edit") ? {data : 'menuType',  editor : 'select', selectOptions : ['대메뉴', '소메뉴'],  type : 'autocomplete',  className : "htCenter", width: 40, readOnly:true, renderer:authorPkNoneEdit} :
		  						{data : 'menuType',  editor : 'select', selectOptions : ['대메뉴', '소메뉴'],  type : 'autocomplete',  className : "htCenter", width: 40, validator : function(value, callback){callback(notEmpty(value, 10))}},
		(tableType == "edit") ? {data : 'menuNmKr',  editor : 'select', selectOptions : dropdown2, type : 'autocomplete',  renderer:authorPkNoneEdit, readOnly : true} : 
								{data : 'menuNmKr',  editor : 'select', selectOptions : dropdown2, type : 'autocomplete' },
		(tableType == "edit") ? {data : 'menuId',  editor : 'select', selectOptions : dropdown3, type : 'autocomplete',  readOnly:true, renderer:authorPkNoneEdit} :
								{data : 'menuId',  editor : 'select', selectOptions : dropdown3, type : 'autocomplete',  validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'rYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30,
								validator: function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'wYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 30,
								validator: function(value, callback){callback(selectboxCheck(value, this.selectOptions))}}
	];
}

//테이블 헤더
function fn_authorTableHeader(){

	this.authorGrpHeader = [
		'그룹코드','그룹명','관리자여부','삭제여부'
	];

	this.authorMenuHeader = [
		'그룹코드','메뉴타입','메뉴명','menuId','조회권한','작성권한'
	];
}

//테이블 히든컬럼
function fn_authorTableHidden(){
	var tableType = $("input:radio[name=pfauthorType]:checked").val();

	this.authorGrpHidden = (tableType == "read") ? [3] : [];

	this.authorMenuHidden = [];
}

//Table
function fn_handsonGridAuthorOption(col, header, hidden){
	var tableType = $("input:radio[name=pfauthorType]:checked").val();

	pfauthorSettings = {
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
		//dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		//columnSorting : {
		//  indicator : true
	    //},
	    autoColumnSize : {
	      samplingRatio : 23
	    },
	};
	return pfauthorSettings;
}

//검색 그리드
function fn_authorGridOption(type){
	if(type){
		$("#pfauthor_div1").show();
	}else{
		$("#pfauthor_div1").hide();
	}
}

//테이블 타입 변경
function fn_pfauthorChangeTable(type){
	if(type == "edit"){
		$("#btnpfuthorSave").show();
	}else if(type == "enrol"){
		$("#btnpfuthorSave").show();
	}else{
		$("#btnpfuthorSave").hide();
	}
	fn_changeFtaauthor($("input:radio[name=pfauthor_srch1]:checked").val());
}

//검색구분, 테이블 타입 변경
function fn_changeFtaauthor(type){
	
	let authorCol = new fn_authorTableCol();
	let authorHeader = new fn_authorTableHeader();
	let authorHidden = new fn_authorTableHidden();
	var col, header, hidden;

	//$("#alignPfauthor option:eq(0)").prop('selected', true);

	if(type == "01"){
		fn_authorGridOption(false);
		col = authorCol.authorGrpCol;
		header = authorHeader.authorGrpHeader;
		hidden = authorHidden.authorGrpHidden;
		$(".menuName").hide();
		pfauthorHot.updateSettings(fn_handsonGridAuthorOption(col, header, hidden));
	}else{
		fn_authorGridOption(true);
		col = authorCol.authorMenucol;
		header = authorHeader.authorMenuHeader;
		hidden = authorHidden.authorMenuHidden;
		$(".menuName").show();
		pfauthorHot.updateSettings(fn_handsonGridAuthorOption(col, header, hidden));
		fn_searchGrpCdDropdown();//그룹코드 Dropdown
		fn_searchMenuNameDropdown();//메뉴명 Dropdown
		fn_searchMenuIdDropdown();//메뉴명 Dropdown
	}
	fn_searchpfauthor();
};

//그룹코드 Dropdown
function fn_searchGrpCdDropdown(){
	$.ajax({
		type : "POST",
		url : "/cmmn/selectGroupCodeDropdown.do",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	for(var i=0; i<data.resultList.length; i++){
        		dropdown1.push(data.resultList[i].grpCd);
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

//메뉴명 Dropdown
function fn_searchMenuNameDropdown(){
	$.ajax({
		type : "POST",
		url : "/cmmn/selectMenuNameDropdown.do",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
			for(var i=0; i<data.resultList.length; i++){
				dropdown2.push(data.resultList[i].menuNmKr);
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

//메뉴id Dropdown
function fn_searchMenuIdDropdown(){
	$.ajax({
		type : "POST",
		url : "/cmmn/selectMenuIdDropdown.do",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
		success : function(data) {
			for(var i=0; i<data.resultList.length; i++){
				dropdown3.push(data.resultList[i].menuId);
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



//그룹코드 클릭
function fn_callAuthTab(row, col){

	var value = pfauthorHot.getDataAtCell(row, col);
	$("input:radio[name=pfauthor_srch1]")[1].checked = true;
	$("#pfauthor_srch2").val(value);
	$('#pfauthor_srch6 option[value="'+value+'"]').attr('selected','selected');
	fn_changeFtaauthor();
};