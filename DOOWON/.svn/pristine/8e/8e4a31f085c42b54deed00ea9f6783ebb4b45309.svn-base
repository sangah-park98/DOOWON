var msgHot;
var msgSettings;
var msgIndex = 9999;
var msgScrollTp = true;

$( document ).ready(function() {

	  var msgElement = document.querySelector('#msgTable');
	  var msgElementContainer = msgElement.parentNode;

	  msgHot = new Handsontable(msgElement, msgSettings);

	  fn_changeMsg('edit');
	  fn_searchMsg();

	  $("#msgTable .wtHolder").scroll(function(){
		  var scrollTop = $("#msgTable .wtHolder").scrollTop();
		  var countPerPage = $("#msgPageCnt option:selected").val();
		  var rowHeight = msgHot.getRowHeight();

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

		  if(msgScrollTp && msgIndex != 9999 && scrollTop >= (countPerPage * msgIndex * rowHeight) + addCnt){
			  fn_msgScroll();
		  }
	});
	  fn_changeMsg('read');
	  fn_changeMsg();
});
/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-ftamsg").hasClass("active")) {
//			fn_searchMsg();
//		} 
//	}
//})

//메시지타입 변경
$("input[name=msg_srch4]").change(function(){
	$('#alignMsg option:eq(0)').prop('selected', true);
	$('input:radio[name=msgType]:radio[value = "edit"]').prop('checked', true);
	fn_changeMsg($("#msgType").val());
	  fn_searchMsg();
});
//테이블 타입 변경
$("input[name=msgType]").change(function(){
	  fn_changeMsg($(this).val());
});

//정렬항목
$("select[name=alignMsg]").change(function(){
	  fn_searchMsg();
});

//row 수
$("select[name=msgPageCnt]").change(function(){
	  fn_searchMsg();
});


/** 이벤트 End **/

//스크롤
function fn_msgScroll(){
	if($("input[name=msgType]:checked").val() == "enrol")
		return;
	msgScrollTp = false;
	msgIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfMsgList.do",
		data : fn_setMsgForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = msgHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	msgHot.loadData(meargeJson);

        	msgScrollTp = true;
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
		fn_searchMsg();
    }
}

//검색
function fn_searchMsg(){
	msgIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfMsgList.do",
		data : fn_setMsgForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=msgType]:checked").val() != "enrol"){
        		msgHot.loadData([]);
        		msgHot.loadData(data.resultList);
            	$("#msgCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
        	} else{
        		msgHot.loadData([]);
        		msgHot.alter('insert_row_below', 1, 1);
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
function fn_setMsgForm(){
	var sData = {};
	sData["srch2"] = $("#msg_srch2").val(); //메세지명(영문)
	sData["srch3"] = $("#msg_srch3").val(); //메세지명
	sData["srch4"] = $("input:radio[name=msg_srch4]:checked").val();
	sData["alignItem"] = $("#alignMsg option:selected").val();
	sData["recordCountPerPage"] = $("#msgPageCnt option:selected").val();
	sData["pageIndex"] = msgIndex;
	return sData;
};

//검색조건 초기화
function fn_clearMsg(){
	$("#msg_srch2").val("");
	$("#msg_srch3").val("");
	$("input:radio[name=msg_srch4]")[0].checked = true;
};

//저장버튼 클릭
function fn_saveMsgCheck(){
	if(msgHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}

	fn_validateMsg();
};

//정합성 체크
function fn_validateMsg(){
	msgHot.validateCells(function(result) {
		if(result){
			fn_saveMsgData();
		}else{
			msgHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveMsgData(){

	if(!confirm("저장하시겠습니까?")){ return }

	var saveMsgData = msgHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/cmmn/savePfMsgInfo.do",
		data : JSON.stringify(saveMsgData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert("저장되었습니다.");
        		/*if($("input[name=msgType]:checked").val() == "enrol"){
        			$("input[name=msgType]").checked = true;
        			fn_changeMsg($("input[name=msgType]:checked").val());
        		}*/
        		$('input[name="msgType"]:radio[value="read"]').prop('checked',true);
        		fn_changeMsg($("input[name=msgType]:checked").val());
        		fn_searchMsg();
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
function fn_msgTableCol(){
	var tableType = $("input[name=msgType]:checked").val();
	var msgPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").append(value).css('text-align', 'center');
	};

	this.msgCol = [
		((tableType == "edit") ||(tableType == "read") ) ? {data : 'msgId', type : 'text', className : 'htCenter', renderer : msgPkNoneEdit, width:100, readOnly:true} :
		  						{data : 'msgId', type : 'text', className : 'htCenter', width:100, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'msgNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 300))}, width:100},
		{data : 'msgNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 300))}, width:100},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 100,
		validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	];

}

//테이블 헤더
function fn_msgTableHeader(){
	this.msgHeader = [
		"메세지코드","메세지명","메세지명(영문)","삭제여부"
	];
}

//테이블 히든컬럼
function fn_msgTableHidden() {
	this.msgHidden = [];
}

function fn_handsonGridMsgOption(col, header, hidden){
	var tableType = $("input[name=msgType]:checked").val();

	var msgSettings = {
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
    	  readOnly : (tableType == "read") ? true : false,
		  manualRowMove : true,
		  manualColumnMove : false,
		  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		//  dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		  filters : true,
		  readOnly : false,
		  allowRemoveRow : false,
		 // columnSorting : {indicator : true},
          autoColumnSize : {samplingRatio : 23},
          mergeCells : false,
          allowInsertRow : false
	  };

	return msgSettings;
}


//테이블 타입 변경
function fn_changeMsg(type){
	let msgCol = new fn_msgTableCol();
	let msgHeader = new fn_msgTableHeader();
	let msgHidden = new fn_msgTableHidden();
	var col, header, hidden;

	col = msgCol.msgCol;
	header = msgHeader.msgHeader;
	hidden = msgHidden.msgHidden;
	msgHot.updateSettings(fn_handsonGridMsgOption(col, header, hidden));

	if(type == "edit"){
		msgHot.updateSettings({readOnly:false});
		$("#btnMsgSave").show();

	}else if(type == "enrol"){
		msgHot.updateSettings({readOnly:false});
		$("#btnMsgSave").show();
	}else{
		msgHot.updateSettings({readOnly:true});
		$("#btnMsgSave").hide();
	}

	fn_searchMsg();
};
