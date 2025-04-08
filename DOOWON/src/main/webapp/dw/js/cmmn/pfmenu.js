var menuHot;
var menuSettings;
var menuIndex = 9999;
var menuScrollTp = true;
var dropdown = [];

$( document ).ready(function() {



	  var menuElement = document.querySelector('#pfMenuTable');
	  var menuElementContainer = menuElement.parentNode;

	  menuHot = new Handsontable(menuElement, menuSettings);

	  $("#pfMenuTable .wtHolder").scroll(function(){
		  var scrollTop = $("#pfMenuTable .wtHolder").scrollTop();
		  var countPerPage = $("#menuPageCnt option:selected").val();
		  var rowHeight = menuHot.getRowHeight();

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

		  if(menuScrollTp && menuIndex != 9999 && scrollTop >= (countPerPage * menuIndex * rowHeight) + addCnt){
			  fn_menuScroll();
		  }
	  });

	  $("#menu_div1").hide();
	  $("#btnMenuSave").hide();
	  fn_changeMenu('read');
	  fn_searchMenu();
});


//테이블 타입 변경
$("input[name=menuType]").change(function(){
	  fn_changeMenu($(this).val());
});

//정렬항목
$("select[name=alignPfMenu]").change(function(){
	  fn_searchMenu();
});

//row 수
$("select[name=menuPageCnt]").change(function(){
	  fn_searchMenu();
});
//메뉴타입 변경
$("input[name=menu_srch4]").change(function(){
	$('input:radio[name=menuType]:radio[value="read"]').prop('checked', true);
	fn_changeMenu($("#menuType").val());
	fn_changeMenuType($(this).val());
});
/** 이벤트 End **/

//스크롤
function fn_menuScroll(){
	if($("input[name=menuType]:checked").val() == "enrol")
		return;
	menuScrollTp = false;
	menuIndex++;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfMenuList.do",
		data : fn_setMenuForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	/*마우스 스크롤 시 timeout 문제 해결*/
        	/*for(var i=0; i<data.resultList.length; i++){
        		menuHot.getSourceData().push(data.resultList[i]);
        	}
        	menuHot.render();*/

        	var getData = menuHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	menuHot.loadData(meargeJson);

        	menuScrollTp = true;
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
		fn_searchMenu();
    }
}

//검색
function fn_searchMenu(){
	menuIndex = 0;

	$.ajax({
		type : "POST",
		url : "/cmmn/selectPfMenuList.do",
		data : fn_setMenuForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=menuType]:checked").val()=="enrol"){
        		menuHot.loadData([]);
        		menuHot.alter('insert_row_below', 1, 1);
        	}else{
        		menuHot.loadData([]);
            	menuHot.loadData(data.resultList);
            	$("#menuCnt").text(data.totCnt.toLocaleString()); //검색결과 총 갯수
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
function fn_setMenuForm(){
	var sData = {};
	
	sData["srch1"] = $("#menu_srch1").val();  // 메뉴명
	sData["srch2"] = $("#menu_srch2").val();  // 메뉴명(EN)
	sData["srch4"] = $("input:radio[name=menu_srch4]:checked").val();  // 대메뉴  소메뉴 
	sData["srch5"] = $("input:radio[name=menu_srch5]:checked").val();
	sData["srch6"] = $("#menu_srch6").val();  // 대메뉴ID
	sData["alignItem"] = $("#alignPfMenu option:selected").val();
	sData["recordCountPerPage"] = $("#menuPageCnt option:selected").val();
	sData["pageIndex"] = menuIndex;
	
	console.log("srch1"+sData["srch1"]);
	
	return sData;
};

//검색조건 초기화
function fn_clearMenu(){
	$("#menu_srch1").val("");
	$("#menu_srch2").val("");
	$("#menu_srch3").val("");
	$("input:radio[name=menu_srch4]")[0].checked = true;
	$("input:radio[name=menu_srch5]")[0].checked = true;
	$("#menu_srch6").val("");

	fn_changeMenuType("01");
};

//저장버튼 클릭
function fn_saveMenuCheck(){
	if(menuHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validateMenu();
};

//정합성 체크
function fn_validateMenu(){
	menuHot.validateCells(function(result) {
		if(result){
			fn_saveMenuData();
		}else{
			menuHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveMenuData(){
	if(!confirm("저장하시겠습니까?")){ return }
	
	var menuType = $("input:radio[name=menu_srch4]:checked").val();
	var saveMenuData = menuHot.getSourceData();
	
	saveMenuData.forEach(function(row) {
	    row.menuType = menuType;
	});
	
	console.log("saveMenuData: " + JSON.stringify(saveMenuData));
	
	$.ajax({
		type : "POST",
		url : "/cmmn/savePfMenuInfo.do",
		data : JSON.stringify(saveMenuData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert("저장되었습니다.");
        		$('input[name="menuType"]:radio[value="read"]').prop('checked',true);
    			fn_changeMenu($('input[name="menuType"]').val());
        		fn_searchMenu();
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
function fn_ftamenuTableCol(){
	var tableType = $("input[name=menuType]:checked").val();
	console.log("tableType"+tableType);
	var menuPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var upperRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		var $menuButton;
		 if (value === null) {
		        // Replace NULL with an empty string
		        value = "";
		    }
        	$menuButton = $('<i class="fas fa-search search-icon" style="cursor:pointer;" onclick="fn_callMenuTab('+row+','+col+')"></i>');
        $(td).empty().append($menuButton).append("  " + value);
	};
	

	this.mainMenuCol = [
		(tableType == "edit") ? {data : 'menuId', className : "htCenter", width: 50, readOnly:true, renderer:menuPkNoneEdit} :
			 					{data : 'menuId', renderer: upperRenderer, className : "htCenter", width: 50},
		(tableType == "edit") ? {data : 'menuType', type : 'text', readOnly:true, renderer:menuPkNoneEdit} :
								{data : 'menuType', type : 'text'},
		{data : 'upprMenuId', type : 'text', readOnly:true},
		{data : 'menuNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'menuNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'ordrSn', type : 'numeric', width: 50, validator : function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'dispYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 50,
			validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	];

	this.subMenuCol = (tableType == "enrol") ? [
	   	  {data : 'menuId', type : 'text'},
		  {data : 'menuType', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		  {data : 'upprMenuId', editor : 'select', selectOptions : dropdown, type : 'autocomplete', className : "htCenter", width: 50, validator : function(value, callback){callback(notEmpty(value, 100))}},
		  {data : 'menuNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		  {data : 'menuNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		  {data : 'ordrSn', type : 'numeric', width: 50, validator : function(value, callback){callback(notEmpty(value, 100))}},
		  {data : 'dispYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 50,
			  validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : [
		  (tableType == "edit") ? {data : 'menuId', className : "htCenter", width: 50, readOnly:true, renderer:menuPkNoneEdit} :
					  {data : 'menuId', className : "htCenter", width: 50},
	      (tableType == "edit") ? {data : 'menuType', type : 'text', readOnly:true, renderer:menuPkNoneEdit} :
					  {data : 'menuType', className : "htCenter", type : 'text'},
		  {data : 'upprMenuId', editor : 'select', selectOptions : dropdown, type : 'autocomplete', className : "htCenter", width: 50, validator : function(value, callback){callback(notEmpty(value, 100))}},
		  {data : 'menuNmKr', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		  {data : 'menuNmEn', type : 'text', validator : function(value, callback){callback(notEmpty(value, 200))}},
		  {data : 'ordrSn', type : 'numeric', width: 50, validator : function(value, callback){callback(notEmpty(value, 100))}},
		  {data : 'dispYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 50, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
		];
}

//테이블 헤더
function fn_ftamenuTableHeader(){
	var tableType = $("input[name=menuType]:checked").val();

	this.mainMenuHeader = [
		"메뉴ID","메뉴타입","UPPR_MENU_ID","메뉴명","메뉴명(영문)","정렬순서","화면표시"
	];

	this.subMenuHeader = [		
		"메뉴ID","메뉴타입","대메뉴ID","메뉴명","메뉴명(영문)","정렬순서","화면표시"
	];
}

//테이블 히든컬럼
function fn_ftamenuTableHidden(){
	var tableType = $("input[name=menuType]:checked").val();

	this.mainMenuHidden = [1,2];
	//this.mainMenuHidden = [];

	this.subMenuHidden = [];

}

//Table
function fn_handsonGridftamenuOption(col, header, hidden){
	var tableType = $("input[name=menuType]:checked").val();

	menuSettings = {
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

	 // dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
	  filters : true,
	  readOnly : (tableType == "read") ? true : false,
	  allowRemoveRow : false,
	 // columnSorting : {indicator : true},
      autoColumnSize : {samplingRatio : 23},
      mergeCells : false,
      allowInsertRow : false,
	};
	return menuSettings;
}

//테이블 타입 변경
function fn_changeMenu(type){
	if(type == "edit"){
		menuHot.updateSettings({readOnly:false});
		$("#btnMenuSave").show();

	}else if(type == "enrol"){
		menuHot.updateSettings({readOnly:false});
		$("#btnMenuSave").show();
	}else{
		menuHot.updateSettings({readOnly:true});
		$("#btnMenuSave").hide();
	}
	var sendType = $("input:radio[name=menu_srch4]:checked").val();
	fn_changeMenuType(sendType);
};

//메뉴타입 변경
function fn_changeMenuType(type){
	let ftamenuCol = new fn_ftamenuTableCol();
	let ftamenuHeader = new fn_ftamenuTableHeader();
	let ftamenuHidden = new fn_ftamenuTableHidden();
	var col, header, hidden;

	$('#alignPfMenu option:eq(0)').prop('selected', true);

	//대메뉴
	if(type == "01"){
		col = ftamenuCol.mainMenuCol;
		header = ftamenuHeader.mainMenuHeader;
		hidden = ftamenuHidden.mainMenuHidden;
		menuHot.updateSettings(fn_handsonGridftamenuOption(col, header, hidden));
		$(".menuID").hide();
		$("#menu_srch6").val("");
		fn_searchMenu();
	//소메뉴
	}else{
		col = ftamenuCol.subMenuCol;
		header = ftamenuHeader.subMenuHeader;
		hidden = ftamenuHidden.subMenuHidden;
		menuHot.updateSettings(fn_handsonGridftamenuOption(col, header, hidden));
		$(".menuID").show();
		fn_searchUpprMenuDropdown();
	}
	fn_searchMenu();
};

//상위메뉴 Dropdown
function fn_searchUpprMenuDropdown(){
	$.ajax({
		type : "POST",
		url : "/cmmn/selectUpprMenuDropdown.do",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	for(var i=0; i<data.resultList.length; i++){
        		dropdown.push(data.resultList[i].menuId);
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

//메뉴ID 클릭
function fn_callMenuTab(row, col){
	var value = menuHot.getDataAtCell(row, col);
	$("input:radio[name=menu_srch4]")[1].checked = true;
	$("#menu_srch6").val(value);
	fn_changeMenuType("02");
};
