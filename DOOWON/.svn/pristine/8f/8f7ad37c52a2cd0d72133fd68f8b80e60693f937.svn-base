var bomHot;
var bomSettings;
var bomIndex = 9999;
var bomScrollTp = true;
var plntCdSelect = [];
var unitSelect = [];

$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	$('.band-calendar').each(function(){ regCal(this) ;})
	//캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);


      plntCdList = plntCdList.replace('[','').replace(']','');
	  plntCdSelect = plntCdList.split(', ');

	  baseList = baseList.replace('[','').replace(']','');
	  unitSelect = baseList.split(', ');

	  var bomElement = document.querySelector('#bomTable');
	  var bomElementContainer = bomElement.parentNode;

	  bomHot = new Handsontable(bomElement, bomSettings);

	  $("button#btnBomSave").hide();
	  fn_changeBom('read');
	  
	  fn_bomExcelSrch("01");

	  //스크롤 이벤트 함수
	  fn_scroll();
});
/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-bom").hasClass("active")) {
//			fn_bomSrchCheck();
//		}
//	}
//})

$(document).mousedown(function(e){
	if(e.target.name == "bom_date"){
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
$("select[name=alignBom]").change(function(){
	  fn_searchBom();
});

//row 수
$("select[name=bomPageCnt]").change(function(){
	  fn_searchBom();
});

//테이블타입
$("input[name=bomType]").change(function(){
	  fn_changeBom($(this).val());
});


function fn_scroll(){
	$("#bomTable .wtHolder").scroll(function(){
		  var scrollTop = $("#bomTable .wtHolder").scrollTop();
		  var countPerPage = $("#bomPageCnt option:selected").val();
		  var rowHeight = bomHot.getRowHeight();

		  var addCnt = 790;
		  if(countPerPage == "50"){
			  addCnt = 790;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "200"){
			  addCnt = 3290;
		  }else if(countPerPage == "500"){
			  addCnt = 4540
		  }

		  if(bomScrollTp && bomIndex != 9999 && scrollTop >= (countPerPage * bomIndex * rowHeight) + addCnt){
			  fn_bomScroll();
		  }
	});
}

/** 이벤트 End **/

//스크롤
function fn_bomScroll(){
	if($("input[name=bomType]:checked").val() == "enrol")
		return;


	bomScrollTp = false;
	bomIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectBomList.do",
		data : fn_setBomForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = bomHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	bomHot.loadData(meargeJson);
        	bomScrollTp = true;
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

function fn_bomSrchCheck(){
	if(($("#bom_srch2").val() == "" || $("#bom_srch2").val() == null) && $("input:radio[name=bomType]:checked").val() == "read"){
		alert(msgInputItemCd);
		$("#bom_srch2").focus();
		return;
	}
	fn_searchBom();
}

function fn_bomSrchAll(){
	$("#bom_srch1").val("");
	$("#bom_srch2").val("");
	$('input:checkbox[id="midItemYn"]').attr("checked", false);
	$("#bom_srch4").val("");
	$("input:radio[name = 'bom_srch14']:radio[value = '']").prop("checked", true);
	
	fn_searchBom();
}

function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchBom();
    }
}


//검색
function fn_searchBom(){
	bomIndex = 0;

	$("#bomSrch1").val($("#bom_srch1").val());
	$("#bomSrch2").val($("#bom_srch2").val());
	$("#bomSrch3").val(($('input[name="midItemYn"]').is(":checked") )? "":"N");
	$("#bomSrch4").val($("#bom_srch4").val());
	$("#bomSrch5").val($("input:radio[name=bomType]:checked").val());
	$("#bomSrch6").val($("input:radio[name=bom_srch14]:checked").val());
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/tran/selectBomList.do",
		data : fn_setBomForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if($("input[name=bomType]:checked").val() == "enrol"){
        		bomHot.loadData([]);
        		bomHot.alter('insert_row', 1, 1);
        	}else{
        		bomHot.loadData([]);
            	bomHot.loadData(data.resultList);
            	$("#bomCnt").text(data.totCnt).number(true); //검색결과 총 갯수
        	}
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
};

//검색조건 생성
function fn_setBomForm(){
	var sData = {};
	sData["srch1"] = $("#bom_srch1").val();
	sData["srch2"] = $("#bom_srch2").val();
	sData["srch3"] = ($('input[name="midItemYn"]').is(":checked") )? "":"N";
	sData["srch4"] = $("#bom_srch4").val();
	sData["srch5"] = $("input:radio[name=bomType]:checked").val();
	sData["srch6"] = $("input:radio[name=bom_srch14]:checked").val();
	sData["alignBom"] = $("#alignBom option:selected").val();
	sData["recordCountPerPage"] = $("#bomPageCnt option:selected").val();
	sData["pageIndex"] = bomIndex;
	return sData;
};

//검색조건 초기화
function fn_clearBom(){
	$("#bom_srch1").val("");
	$("#bom_srch2").val("");
	$('input:checkbox[id="midItemYn"]').attr("checked", false);
	$("#bom_srch4").val("");
	$("input:radio[name = 'bom_srch14']:radio[value = '']").prop("checked", true);
	
};

//저장버튼 클릭
function fn_saveBomCheck(){
	if(bomHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	

	for(var i =0; i < bomHot.getData().length; i++ ){
		var temp1 = bomHot.getDataAtCell(i,1);
		var temp2 = bomHot.getDataAtCell(i,2);
		
		if(temp1 == temp2){
			alert(msgBomCheck);
			return;
			} 
	}
	
	fn_validateBom();
};

//정합성 체크
function fn_validateBom(){
	bomHot.validateCells(function(result) {
		if(result){
			fn_saveBomData();
		}else{
			bomHot.render();
			alert(msgSaveCheck);
		}
    });
};

//저장
function fn_saveBomData(){
	if(!confirm(msgSaveConfirm)){ return }
	
	var tableType = $("input:radio[name=bomType]:checked").val();
	
	var checkedData = bomHot.getSourceData();
	var popData = [];
	for(var i=0; i<checkedData.length; i++){
		
		if( tableType == "edit" ){
		if(checkedData[i]["bomCheck"] == true){
			popData.push(checkedData[i]);
			}
		} else {
			popData.push(checkedData[i]);
		}
	}

	var saveBomData = bomHot.getSourceData();
	fn_loading(true);
	
	$.ajax({
		type : "POST",
		url : "/tran/saveBomList.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=bomType]:checked").val() == "enrol"){
        			$("input[name=bomType]")[0].checked = true;
        			fn_changeBom($("input[name=bomType]:checked").val());
        		}
        		$("input:radio[name=bomType]:input[value='read']").trigger("click");
        		fn_searchBom();
        	} else if (data == "fail"){
        		alert(colBomUsed);
        		if($("input[name=bomType]:checked").val() == "enrol"){
        			$("input[name=bomType]")[0].checked = true;
        			fn_changeBom($("input[name=bomType]:checked").val());
        		}
        		$("input:radio[name=bomType]:input[value='read']").trigger("click");
        		fn_searchBom();
        	} else {
        		alert(data +" LINE에 상위코드와 하위코드가 상충합니다. ");
        	}
        	fn_loading(false);
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
function fn_bomTableCol(){
	var tableType = $("input:radio[name=bomType]:checked").val();

	var pkNoneEdit = function(instance, td, row, col, prop, value, cell_properties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var bomItemEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().append('<i class="search-icon text-muted i-Magnifi-Glass1" mouseover="$(this).css(\'curcor\',\'pointer\')" onclick="fn_callPopTableBom(\'1\', '+row+', '+col+',\''+ bomHot.getDataAtCell(row, 1) +'\')"></i>').append(value);
	};

	this.bomCol = (tableType == 'edit') ? [
		{data : 'bomCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', type : 'text', className : "htCenter", width: 100, renderer:pkNoneEdit, readOnly:true},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 130, renderer:pkNoneEdit, readOnly:true},
		{data : 'rawItemCd', type : 'text', className : "htCenter", width: 150, renderer:pkNoneEdit, readOnly:true},
		{data : 'baseQry', type : 'numeric', numericFormat: {pattern: '0,0'}, width: 250, validator:function(value, callback){callback(notEmpty(value, 20))}},
		//{data : 'realBaseQry', type : 'numeric', numericFormat: {pattern: '0,0'}, width: 180, validator:function(value, callback){callback(notEmpty(value, 100))}},
		//{data : 'baseUnt', type : 'text', editor : 'select', selectOptions: unitSelect, className : "htCenter",width: 80},
		{data : 'strtDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180, renderer:pkNoneEdit, readOnly:true, validator:function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'endDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180},
		{data : 'stsCd',editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',width:50,className : "htCenter",option : "N"},
		{data : 'delYn',editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',width:50,className : "htCenter",option : "N"}
	] : (tableType == 'read') ? [
		{data : 'bomCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: 'yes',uncheckedTemplate: 'no', readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntCdSelect, type : 'autocomplete', className : "htCenter", width: 100, validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 130, validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'itemNm', type : 'text', className : "htLeft", width: 150},
		{data : 'rawItemCd', type  : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'rawItemNm', type : 'text', className : "htLeft", width: 180},
		{data : 'path', type : 'text', className : "htLeft", width: 150},
		{data : 'baseQry', type : 'numeric', numericFormat: {pattern: '0,0'},width: 250, validator:function(value, callback){callback(notEmpty(value, 20))}},
		//{data : 'qty', type : 'numeric', numericFormat: {pattern: '0,0'}},
		{data : 'realBaseQry', type : 'numeric', numericFormat: {pattern: '0,0'}, width: 220, validator:function(value, callback){callback(notEmpty(value, 100))}},
		//{data : 'realQty', type : 'numeric', numericFormat: {pattern: '0,0'}},
		//{data : 'baseUnt', type : 'text', editor : 'select', selectOptions: unitSelect, className : "htCenter",width: 80},
		{data : 'strtDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180, validator:function(value, callback){callback(notEmpty(value, 100))}},
		{data : 'endDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180},
		{data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
		{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : [
		{data : 'bomCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true ,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd', editor : 'select', selectOptions : plntCdSelect, type : 'autocomplete', className : "htCenter", width: 100, validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd', type : 'text', className : "htCenter", width: 130, validator : function(value, callback){callback(notEmpty(value, 200))}, renderer: bomItemEdit},
		{data : 'rawItemCd', type : 'text', className : "htCenter", width: 150, validator : function(value, callback){callback(notEmpty(value, 200))}, renderer: bomItemEdit},
		{data : 'baseQry', type : 'numeric', numericFormat: {pattern: '0,0'}, width: 250, validator:function(value, callback){callback(notEmpty(value, 20))}},
		//{data : 'realBaseQry', type : 'numeric', numericFormat: {pattern: '0,0'}, width: 180, validator:function(value, callback){callback(notEmpty(value, 100))}},
		//{data : 'baseUnt', type : 'text', editor : 'select', selectOptions: unitSelect, className : "htCenter",width: 80},
		{data : 'strtDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180, validator:function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'endDt', type : 'date', dateFormat: gridCalFormat, className : "htCenter", width: 180}
		//, validator:function(value, callback){callback(notEmpty(value, 100))}
	];

}

//테이블 헤더
function fn_bomTableHeader(){
	var tableType = $("input:radio[name=bomType]:checked").val();

	this.bomHeader = (tableType == 'edit') ? [
		colPlntCd,colPlntCd+"*",colParentCd+"*",colRawItemCd+"*",colBaseQry+"*"/*,
		colRealBaseQry*/+"*"/*,colBaseUnt*/,colStrtDt+"*",colEndDt,colStsCd,colDelYn
	] : (tableType == 'read') ? [
		colPlntCd,colPlntCd+"*",colParentCd+"*",colItemNm,colRawItemCd+"*",colRawItemNm,colPath,colBaseQry+"*"/*,
		colRealBaseQry*/,colQty/*,colRealQty*//*,colBaseUnt*/,colStrtDt+"*",colEndDt,colRegDt,colEdtDt
	] : [
		colPlntCd,colPlntCd+"*",colParentCd+"*",colRawItemCd+"*",colBaseQry+"*"/*,
		colRealBaseQry*/+"*"/*,colBaseUnt*/,colStrtDt+"*",colEndDt
	];

}

//테이블 히든컬럼
function fn_bomTableHidden(){
	var tableType = $("input:radio[name=bomType]:checked").val();

	this.bomHidden = [0];

}

function fn_handsonGridBomOption(col, header, hidden){
	var tableType = $("input:radio[name=bomType]:checked").val();

	var bomSettings = {
		columns : col,
		colHeaders : header,
		hiddenColumns : {
      	  copyPasteEnabled : false,
      	  indicators : false,
      	  columns: hidden
        },
        readOnly : (tableType == "read") ? true : false,
       // dropdownMenu : true,
        contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
        allowInsertRow:true,
        colWidths: 180,
        stretchH : 'all',
        width : '98%',
        autoWrapRow : true,

        height : 487,
        manualRowResize : true,
        manualColumnResize : true,
        rowHeights : 25,
        rowHeaders : true,
        columnHeaderHeight : 25,
        wordWrap : true,
        beforeChange: function (changes, source) {
      		if(changes != null){
      			for (i = 0; i < changes.length; i++) {
      				var row = changes[i][0]; //0 변경셀의 row
      				var col = changes[i][1]; //1 변경셀의 col
      				var meta = this.getCellMeta(row, col);
      				if(col == "strtDt" || col == "endDt"){
      					var data = changes[i][3].replaceAll("-", "");
      					console.log(data);
            			changes[i][3] = dateFormChange(fn_dateColForm(data));
          			} else if(col == "baseQry"){
          				var data = fn_numericFormat(changes[i][3].replaceAll(",", ""));
      					console.log(data);
      					changes[i][3] = (''+data).replace(/\s+/, '')
      		                                            .replace(/\s+$/g, '')
      		                                            .replace(/\n/g, '')
      		                                            .replace(/\r/g, '')
      		                                            .replace(/(\n|\r\n)/gm, '');
      					data = changes[i][3];
          			} else {
          				return;
          			}
      				
      			}
      		}
      	},
        afterChange: function(changes, source){
        	if (changes && changes[0][2] !== changes[0][3]){ 
        		/*alert("ROW:"+changes[0][0]+", COLUMN:"+changes[0][1]+", FROM:"+changes[0][2]+", TO:"+changes[0][3]);*/
        		this.setDataAtCell(changes[0][0],0,true); 
        		}
        }
	};
	return bomSettings;
}

// 테이블 타입 변경
function fn_changeBom(type) {
	let bomCol = new fn_bomTableCol();
	let bomHeader = new fn_bomTableHeader();
	let bomHidden = new fn_bomTableHidden();
	var col, header, hidden;

	col = bomCol.bomCol;
	header = bomHeader.bomHeader;
	hidden = bomHidden.bomHidden;
	bomHot.updateSettings(fn_handsonGridBomOption(col, header, hidden));

	if (type == "edit") {
		$("#btnBomSave").show();
		$("#bomExcel").hide();
		$("#bomExcelAll").hide();
	} else if(type == "enrol"){
		$("#btnBomSave").show();
		$("#bomExcelAll").hide();
		$("#bomExcel").hide();
		bomHot.loadData([]);
		bomHot.alter('insert_row', 1, 1);
	} else{
		$("#btnBomSave").hide();
		$("#bomExcel").show();
		$("#bomExcelAll").show();
	}
	fn_searchBom();
};


//테이블팝업 호출
function fn_callPopBom(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;
	$("#exampleModalCenterTitle").text(colItemAllCd);
	//아이템 조회
	if(target == "itemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(A.ITEM_CD) AS CD, A.PRDCT_ENM AS CD_NM" : "DISTINCT(A.ITEM_CD) AS CD, A.PRDCT_VNM AS CD_NM";
		strFrom = "bom_info B LEFT JOIN item_info A ON A.ITEM_CD = B.ITEM_CD ";
		strWhere = "A.CMPNY_CD = '"+colCurrCmpnyCd+"' AND A.DEL_YN = 'N' ";
		strOrderby = "A.ITEM_CD";
		strIf1 = "A.ITEM_CD";
		strIf2 = (colLang == "en") ? "A.PRDCT_ENM" : "A.PRDCT_VNM";
	}

	type = target;

	var condition = {type :"tableCd",
	         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
	  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "itemCd"){
			$("#bom_srch2").val(data.cd);
		}else{
			bomHot.setDataAtCell(data.row, data.col, data.cd);
		}
});
	$("#exampleModalCenterTitleCmmn").text(colItemCd);
};


//품목 테이블팝업 호출
function fn_callPopTableBom(target, row, col, plnt){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;
	//아이템 조회
	if(target == "itemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND PLNT_CD = '"+ plnt +"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	}

	type = target;
	var condition = {
			type :"tableCd",
			search :strSearch,
			from : strFrom,
			where : strWhere,
			orderby : strOrderby,
			if1 : strIf1,
			if2 : strIf2,
			type : type,
			row : row,
			col : col
	};

	fn_showCmmnPopup(condition, function(data){
		bomHot.setDataAtCell(data.row, data.col, data.cd);
	});
	$("#exampleModalCenterTitleCmmn").text(colItemCd);
};


function fn_bomExcelSrch(type){
	$("#bomSrch1").val($("input:radio[name=bom_srch1]:checked").val());
	if(type == '01'){
		$("#bomExTit").val(colBomInfo);
		$("#bomExCol").val(String([colPlntCd+"*",colParentCd+"*",colItemNm,colRawItemCd+"*",colRawItemNm,colPath,colBaseQry+"*",colQty,colStrtDt+"*",colEndDt])+",");
		$("#bomExCd").val("plntCd,itemCd,itemNm,rawItemCd,rawItemNm,path,baseQry,qty,strtDt,endDt,");
		$("#bomExType").val("cd,cd,text,cd,text,text,double,double,cd,cd,");
	}

}
