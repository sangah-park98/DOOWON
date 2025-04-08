var itemHot;
var ftaPreHot;
var itemSettings;
var colCnt;
var itemIndex = 9999;
var itemScrollTp = true;
var itemDropdown = [];
var plntDropdown = [];
var itemTypeDrop = [];
var popRowData, popRow, popCol;

$(document).ready(function(){
	codeList = codeList.replace('[', '').replace(']', '');
	itemDropdown = codeList.split(', ');

	plntCdList = plntCdList.replace('[', '').replace(']', '');
	plntDropdown = plntCdList.split(', ');



	var itemElement = document.querySelector('#itemTable');
	var itemElementContainer = itemElement.parentNode;

	itemHot = new Handsontable(itemElement, fn_handsonGridItemOption('read'));

	fn_gridItemOption1(true);
	fn_gridItemOption2(false);
	fn_gridItemOption3(false);

	fn_changeItem('read');

	fn_itemExcelSrch("01");

	fn_itemEventReg();  //스크롤이벤트 등록

	//HS코드 입력 폼 적용
	$(document).on('keyup', '#item_srch3', function(){
		  $(this).val(fn_hsCdForm($(this).val()));
	});
	
	

});


$(document).mousedown(function(e){
	if(e.target.name == "item1_date" || e.target.name == "item2_date"){
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


//스크롤 이벤트 등록
function fn_itemEventReg(){

	$("#itemTable .wtHolder").scroll(function() {
		var itemScrollTop = $("#itemTable .wtHolder").scrollTop();
		var itemCountPerPage = $("#itemPageCnt option:selected").val();
		var itemRowHeight = itemHot.getRowHeight();

		var itemAddCnt = 790;
		if (itemCountPerPage == "50") {
			itemAddCnt = 790;
		} else if (itemCountPerPage == "100") {
			itemAddCnt = 2040;
		} else if (itemCountPerPage == "200") {
			itemAddCnt = 3290;
		} else if (itemCountPerPage == "500") {
			itemAddCnt = 4540;
		}

		if (itemScrollTp && itemIndex != 9999&& itemScrollTop >= (itemCountPerPage* itemIndex * itemRowHeight)+ itemAddCnt) {
			fn_itemScroll();
		}
	});

}


/** 이벤트 등록 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-item").hasClass("active")) {
//			fn_searchItem();
//		}
//	}
//})




//테이블 타입 변경
$("input[name=itemType]").change(function() {
	fn_changeItem($(this).val());

});

// 정렬항목
$("select[name=alignItem]").change(function() {
	fn_searchItem();
});

// row 수
$("select[name=itemPageCnt]").change(function() {
	fn_searchItem();
});

// 검색구분 및 테이블 타입변경
$("input[name=item_srch20]").change(function() {
	$('input:radio[name=itemType]:radio[value="read"]').prop('checked',true);
	fn_clearItem();
	fn_changeItemSrchType($(this).val());
	fn_itemExcelSrch($(this).val());
	fn_changeItem($("input:radio[name=itemType]:checked").val());
	console.log('페이지 바뀜'+$("input:radio[name=itemType]:checked").val());
});

// 엑셀 다운로드 검색 조건 값 전달
//$("select[id=item_srch1]").change(function() {
//	fn_srch22($(this).val());
//});

$("body").on("click","#ftaPsrInfo",function(){
	fn_ftaPsrSrch($(this).attr("data-fta"), $(this).attr("data-type"), $(this).attr("data-seq"));
});

$("input:radio[name=additional]").click(function(){
	$("div[name=additionalBody]").hide();
	$("#"+$("input:radio[name=additional]:checked").val()).show();
	
	spcTitle = $("input:radio[name=additional]:checked").val();
	
	if(spcTitle == "rawSpcYn"){// 원자제가공공정여부
		$("#itemSpcTitle").text(colRawSpcYn)
	} else if(spcTitle == "rawWoYn"){//원자제 완전생산여부
		$("#itemSpcTitle").text(colRawWoYn)
	} else if(spcTitle == "woYn"){//완전생산여부
		$("#itemSpcTitle").text(colWoYn)
	} else { //가공공정여부
		$("#itemSpcTitle").text(colSpcYn)
	}
	
	
})
/** 이벤트 등록 End **/

// 스크롤
function fn_itemScroll() {
	
	
	if ($("input[name=itemType]:checked").val() == "enrol")
		return;
	
	fn_loading(true);
	itemScrollTp = false;
	itemIndex++;
	
	var itemType = $("input[name=itemType]:checked").val();
	var dictionary = $("input[name=item_srch6]:checked").val();
	var data = fn_setItemForm();
	data["itemType"] = itemType;
	data["dictionary"] = dictionary;

	console.log("data"+data);
	$.ajax({
		type : "POST",

		url : "/base/selectItemList.do",
		data : data,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			var getData = itemHot.getSourceData();
			var meargeJson = getData.concat(data.resultList);
			itemHot.loadData(meargeJson);
			itemScrollTp = true;
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




function enterkey() {
	if (window.event.keyCode == 13) {
		fn_searchItem();
    }
}



// 검색
function fn_searchItem() {

	itemIndex = 0;

	$("#itemSrch1").val($("#item_srch1").val());
	$("#itemSrch2").val($("#item_srch2").val());
	$("#itemSrch3").val($("#item_srch3").val());
	$("#itemSrch4").val($("#item_srch4 option:selected").val());
	$("#itemSrch5").val($("#item_srch5").val());
	$("#itemSrch6").val($("input:radio[name=item_srch6]:checked").val());
	$("#itemSrch14").val($("input:radio[name=item_srch14]:checked").val());
	$("#itemSrch7").val($("#item_srch7").val());
	$("#itemSrch8").val($("#item_srch8").val());
	$("#itemSrch9").val($("#item_srch9").val());
	$("#itemSrch10").val($("#item_srch10").val());
	$("#itemSrch11").val($("#item_srch11").val());
	$("#itemSrch12").val($("#item_srch12").val());
	$("#itemSrch15").val($("#item_srch15").val());
	$("#itemSrch16").val($("#item_srch16").val());
	$("#itemSrch22").val($("input:radio[name=item_srch22]:checked").val());
	
	
	var data = fn_setItemForm();
	var valid = fn_validateSearchDate(data["srch15"], data["srch16"]);

	if(valid === "false"){
		data["srch15"] = null;
		data["srch16"] = null;
		$("#item_srch15").val("");
		$("#item_srch16").val("");
		return;
	} else {
		data["srch15"] = $("#item_srch15").val();
		data["srch16"] = $("#item_srch16").val();
	}
	
	
	fn_loading(true);
	
	var itemType = $("input[name=itemType]:checked").val();
	var dictionary = $("input[name=item_srch6]:checked").val();
	var data = fn_setItemForm();
	data["itemType"] = itemType;
	data["dictionary"] = dictionary;
		
	$.ajax({
		type : "POST",
		url : "/base/selectItemList.do",
		data : data,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			if ($("input[name=itemType]:checked").val() == "enrol") {
				itemHot.loadData([]);
				itemHot.alter('insert_row', 1, 1);
			} else {
				itemHot.loadData([]);
				itemHot.loadData(data.resultList);
				$("#itemCnt").text(data.totCnt).number(true); // 검색결과 총 갯수
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

// 검색조건 생성
function fn_setItemForm() {
	var sData = {};
	sData["srch1"] = $("#item_srch1").val();
	sData["srch2"] = $("#item_srch2").val();
	sData["srch3"] = $("#item_srch3").val();
	sData["srch4"] = $("#item_srch4 option:selected").val();
	sData["srch5"] = $("#item_srch5").val();
	sData["srch6"] = $("input:radio[name=item_srch6]:checked").val();
	sData["srch14"] = $("input:radio[name=item_srch14]:checked").val();
	sData["srch7"] = $("#item_srch7").val();
	sData["srch8"] = $("#item_srch8").val();
	sData["srch9"] = $("#item_srch9").val();
	sData["srch10"] = $("#item_srch10").val();
	sData["srch11"] = $("#item_srch11").val();
	sData["srch12"] = $("#item_srch12").val();
	sData["srch15"] = $("#item_srch15").val();
	sData["srch16"] = $("#item_srch16").val();
	sData["srch13"] = $("input:radio[name=item_srch13]:checked").val();
	sData["srch20"] = $("input:radio[name=item_srch20]:checked").val();
	sData["alignItem"] = $("#alignItem option:selected").val();
	sData["recordCountPerPage"] = $("#itemPageCnt option:selected").val();
	sData["pageIndex"] = itemIndex;
	sData["srch22"] = $("input:radio[name=item_srch22]:checked").val();
	return sData;
};

// 검색조건 초기화
function fn_clearItem() {
	$("#item_srch1").val("");
	$("#item_srch2").val("");
	$("#item_srch3").val("");
	$("#item_srch4").val("");
	$("#item_srch5").val("");
	$("input:radio[name = 'item_srch6']:radio[value = '']").prop("checked", true);
	$("input:radio[name = 'item_srch14']:radio[value = '']").prop("checked", true);
	$("#item_srch7").val("");
	$("#item_srch8").val("");
	$("#item_srch9").val("");
	$("#item_srch10").val("");
	$("#item_srch11").val("");
	$("#item_srch12").val("");
	$("#item_srch15").val("");
	$("#item_srch16").val("");
	$("input:radio[name = 'itemType']:radio[value = 'read']").prop("checked", true);
	$("input:radio[name = 'item_srch22']:radio[value = '']").prop("checked", true);
	fn_changeItem($("input:radio[name=itemType]:checked").val());
};

function fn_itemExcelSrch(type){
	$("#itemSrch20").val($("input:radio[name=item_srch20]:checked").val());
	if(type == '01'){


		$("#itemExTit").val(itemInfo);
		$("#itemExCol").val(String([colPlntCd+"*", colItemCd+"*", colHsCd, colHsVer+"*", colItemNmVn+"*", colItemNmEn+"*",
								    colPrdctSpc, colBaseUnt+"*"
								  /*  ,colUntWght, colUntDisp*/
								    , colSpcAdmitYn, colpreReq, colApplyPsr, colSpcYn, colSpcNm,colRawSpcYn,colWoYn,colRawWoYn])+",");
		$("#itemExCd").val("plntCd,itemCd,hsCd,hsVer,prdctVnm,prdctEnm,prdctSpc,baseUnt,spcAdmitYn,psrCnt,preRequest,spcYn,spcNm,rawSpcYn,woYn,rawWoYn,");
		$("#itemExType").val("cd,cd,cd,cd,text,text,text,cd,text,text,text,text,text,text,text,text,");
	}else if(type == '02'){
		$("#itemExTit").val(itemHsInfo);
		$("#itemExCol").val(String([colPlntCd,colItemCd,colHsVer,colHsCd,colRm+","]));
		$("#itemExCd").val("plntCd,itemCd,hsVer,hsCd,cmmnts,");
		$("#itemExType").val("cd,cd,cd,cd,text,");
	}else{
		$("#itemExTit").val(partnItemInfo);
		$("#itemExCol").val(String([colPlntCd,colItemCd,colPartnCd,colPartnItemCd,
									colPartnItemNm,colPartnHsCd,colPartnHsVer,colRm+","]));
		$("#itemExCd").val("plntCd,itemCd,partnCd,partnItemCd,partnItemNm,partnHsCd,partnHsVer,remark,");
		$("#itemExType").val("cd,cd,cd,cd,text,cd,cd,text,");
	}
}


// 저장버튼 클릭
function fn_saveItemCheck() {
	if (itemHot.getData().length < 1) {
		alert(msgSaveEmpty);
		return;
	}
	fn_validateItem();
};

// 정합성 체크
function fn_validateItem() {
	itemHot.validateCells(function(result) {
		if (result) {
			fn_saveItemData();
		} else {
			alert(msgSaveCheck);
			if($("input:radio[name=item_srch20]:checked").val() == '03'){
				if($("input:radio[name=itemType]:checked").val() == 'enrol'){
					if(itemHot.getDataAtCell(0,2)==null){
						itemHot.setDataAtCell(0, 2, '');
					}
					if(itemHot.getDataAtCell(0,3)==null){
						itemHot.setDataAtCell(0, 3, '');
					}
				}
			}
			itemHot.render();
		}
	});
};

// 저장
function fn_saveItemData() {
	if(!confirm(msgSaveConfirm)) return;
	fn_loading(true);
	var tableType = $("input:radio[name=itemType]:checked").val();
	var cdTp = $("input:radio[name=item_srch20]:checked").val();
	var checkedData = itemHot.getSourceData();
	var popData = [];
	
	
	if($("input[name=item_srch20]:checked").val() == "01"){
	for(var i=0; i<checkedData.length; i++){
		
		//if( tableType == "edit" ){
		//if(checkedData[i]["saveCheck"] == true){
			checkedData[i]["cdTp"] = cdTp;
			popData.push(checkedData[i]);
	//		}
	//	} else {
	//		checkedData[i]["cdTp"] = cdTp;
	//		popData.push(checkedData[i]);
	//	}
	}

	} else if($("input[name=item_srch20]:checked").val() == "02"){
		for (var i = 0; i < checkedData.length; i++) {
			if(checkedData[i]["hsVer"] == "" || checkedData[i]["hsVer"] == null){
				checkedData[i]["hsVer"] = "2022";
				checkedData[i]["tableType"] = tableType;
			}
			checkedData[i]["cdTp"] = cdTp;
			popData.push(checkedData[i]);
			console.log(popData);
		}
	} else {
		for(var i=0; i<checkedData.length; i++){
		checkedData[i]["cdTp"] = cdTp;
		popData.push(checkedData[i]);
		}
	}
	console.log(popData);
	$.ajax({
		type : "POST",
		url : "/base/saveItemList.do",
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				alert(msgSaveSuccess);
				if ($("input[name=itemType]:checked").val() == "enrol") {
					$("input:radio[name=itemType]")[0].checked = true;
					fn_changeItem($("input[name=itemType]:checked").val());
				}
				$("input:radio[name=itemType]:input[value='read']").trigger("click");
				fn_searchItem();
			} else if(data = "overlap"){
				alert("등록 정보와 중복되는 기존정보가 존재합니다.");
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
function fn_itemTableCol(){
	var tableType = $("input[name=itemType]:checked").val();
	var pkNoneEdit = function(instance, td, row, col, prop, value, cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	};

	var nullHsCode = function(instance, td, row, col, prop, value, cellproperties)
	{
		if((value == '' || value == null || value == undefined) && tableType == "read"){
			value = userInput;
			$(td).empty().append(value).css("text-align", "center").css("background-color", "#f0e69f");
		} else if((value == '' || value == null || value == undefined) && tableType == "edit"){
			value = '';
			$(td).empty().append(value).css("text-align", "center").css("background-color", "#f0e69f");
		} else {
			$(td).empty().append(value).css("text-align", "center");
		}

	};

	var pkNoneEditNoneTxtAgn = function(instance, td, row, col, prop, value, cellProperties) {
		$(td).empty().css("background-color", "#E6E6E6").append(value);
	};
	//button이 있는 컬럼
	var ftaPreRnder = function(instance, td, row, col, prop, value,	cellProperties) {
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1", id="psr'+row+'" style="cursor:pointer;" onclick="fn_callFtaPrePop(\''+prop+'\','+ row + ',' + col + ')"></i>');
		if(value == "" || value == null || value == undefined){
			value == '';
		}
		$(td).empty().append($button).append(value);
	};

	var srchPartnEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().append('<i class="search-icon text-muted i-Magnifi-Glass1" mouseover="$(this).css(\'curcor\',\'pointer\')" onclick="fn_callPopItem(\'partnCd1\', '+row+', '+col+')"></i>').append(value);
		if(value == ""){
			$(td).addClass("htInvalid");
		}
	};


	var srchItemEdit = function(instance, td, row, col, prop, value,cellProperties) {
		$(td).empty().append('<i class="search-icon text-muted i-Magnifi-Glass1" mouseover="$(this).css(\'curcor\',\'pointer\')" onclick="fn_callPopItem(\'1\', '+row+', '+col+')"></i>').append(value);
		if(value == ""){
			$(td).addClass("htInvalid");
		}
	};

	var procFtaRnder = function(instance, td, row, col, prop, value, cellProperties) {
		var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1", id="proc'+row+'" style="cursor:pointer;" onclick="fn_callProcFtaPop('	+ row + ',' + col + ',\'' + prop + '\')"></i>');
		if(value == "" || value == null || value == undefined){
			value == '';
		}
		$(td).empty().append($button).append(value);
	};

	var preReqYnRndr = function(instance, td, row, col, prop, value, cellProperties) {
		if(itemHot.getDataAtCell(row, col) != undefined && itemHot.getDataAtCell(row, col) != '' && itemHot.getDataAtCell(row, col) != null && itemHot.getDataAtCell(row, col) !=  0){
			$(td).empty().append('Y').css('text-align', 'center');
		}else{
			$(td).empty().append('N').css('text-align', 'center');
		}
	};

	var mtrlTypeRndr = function(instance, td, row, col, prop, value, cellProperties){
		var text = "";
		if(value == "A"|| value == colProduct){
			text = colProduct;
		}else if (value == "B" || value == colRowMate) {
			text = colRowMate;
		}else {
			text = colNoType;
		}
		$(td).empty().append(text).css("text-align", "center");
	}

	var itemHsVer = [];
	var thisYear = '2022';
	//var thisYear = new Date().getFullYear();
	for(var i=2002; i <= thisYear; i+=5){
		itemHsVer.push(String(i));
	}

	this.itemCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',type : 'text',className : "htCenter",readOnly : true, renderer : pkNoneEdit},
		{data : 'itemCd',type : 'text',className : "htCenter",readOnly : true,renderer : pkNoneEdit},
		{data : 'hsCd', type : 'text',className : "htCenter", validator : fn_hsCdCheck},
		{data : 'hsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'prdctVnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctEnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctSpc',type : 'text',validator : /(^[\s\S]{0,1000}$)/,width : 250},
		{data : 'baseUnt',editor : 'select',selectOptions : itemDropdown,type : 'autocomplete',className : "htCenter",
			validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		/*{data : 'untWght',type : 'numeric',numericFormat : {pattern : '0,0'},validator : /(^[\s\S]{0,20}$)/},
		{data : 'untDisp',type : 'text',className : "htCenter",validator : /(^[\s\S]{0,20}$)/},*/
		//{data : 'mtrlType',editor : 'select',selectOptions : [colProduct, colRowMate, colNoType], width:100, className : "htCenter",type : 'autocomplete', renderer :mtrlTypeRndr },
		{data : 'spcAdmitYn',editor : 'select',className : "htCenter",selectOptions : [ 'Y', 'N' ],type : 'autocomplete'},
		{data : 'psrCnt', type : 'text', renderer : preReqYnRndr, renderer : ftaPreRnder},
		{data : 'preRequest',type : 'text', renderer : ftaPreRnder, readOnly:true, width:400},
		{data : 'spcYn', type : 'text', width:250, renderer:procFtaRnder},
		{data : 'spcNm',type : 'text',className : "htLeft",validator : function(value, callback) {
			if (itemHot.getDataAtCell(this.row, this.col-1) == "Y") callback(notEmpty(value, 100))
			else callback(true)}},
		{data : 'rawSpcYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'woYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'rawWoYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'delYn',editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
	] : (tableType == "read") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'hsCd', type : 'text',className : "htCenter", validator : fn_hsCdCheck},
		{data : 'hsVer', type : 'numeric', className : "htCenter", validator : fn_hsVerCheck},
		{data : 'prdctVnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctEnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctSpc',type : 'text',validator : /(^[\s\S]{0,1000}$)/,width : 250},
		{data : 'baseUnt',editor : 'select',selectOptions : itemDropdown,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		/*{data : 'untWght',type : 'numeric',numericFormat : {pattern : '0,0'},validator : /(^[\s\S]{0,20}$)/},
		{data : 'untDisp',type : 'text',className : "htCenter",validator : /(^[\s\S]{0,20}$)/},*/
		//{data : 'mtrlType',editor : 'select',selectOptions : [colProduct, colRowMate, colNoType], width:100,className : "htCenter",type : 'autocomplete',renderer : mtrlTypeRndr},
		{data : 'spcAdmitYn',editor : 'select',className : "htCenter",selectOptions : [ 'Y', 'N' ],type : 'autocomplete'},
		{data : 'psrCnt', type : 'text', renderer : preReqYnRndr},
		{data : 'preRequest',type : 'text', width:400},
		{data : 'spcYn', type : 'text', width:250,readOnly : true, renderer:procFtaRnder},
		{data : 'spcNm',type : 'text',className : "htLeft",validator : function(value, callback) {
			if (itemHot.getDataAtCell(this.row, this.col-1) == "Y") callback(notEmpty(value, 100))
			else callback(true)}},
		{data : 'rawSpcYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'woYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'rawWoYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'regDt',type : 'text',className : "htCenter", width:200,readOnly : true},
		//{data : 'edtDt',type : 'text',className : "htCenter", width:200,readOnly : true},
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'hsCd', type : 'text',className : "htCenter", validator : fn_hsCdCheck},
		{data : 'hsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(itemSelectboxCheck(value,this.selectOptions))}},
		{data : 'prdctVnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctEnm',type : 'text', validator : function(value, callback){callback(notEmpty(value, 500))}},
		{data : 'prdctSpc',type : 'text',validator : /(^[\s\S]{0,1000}$)/,width : 250},
		{data : 'baseUnt',editor : 'select',selectOptions : itemDropdown,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		/*{data : 'untWght',type : 'numeric',numericFormat : {pattern : '0,0'},validator : /(^[\s\S]{0,20}$)/},
		{data : 'untDisp',type : 'text',className : "htCenter",validator : /(^[\s\S]{0,20}$)/},*/
		//{data : 'mtrlType',editor : 'select',selectOptions : [colProduct, colRowMate, colNoType], width:100, className : "htCenter",type : 'autocomplete', renderer :mtrlTypeRndr },
		{data : 'spcAdmitYn',editor : 'select',className : "htCenter",selectOptions : [ 'Y', 'N' ],type : 'autocomplete'},
		{data : 'psrCnt',type : 'text', renderer : ftaPreRnder, readOnly:true, width:400},
		{data : 'preRequest',type : 'text', width:400},
		{data : 'spcYn',type : 'text', width:250,readOnly : true, renderer:procFtaRnder},
		{data : 'spcNm',type : 'text',className : "htLeft",validator : function(value, callback) {
			if (itemHot.getDataAtCell(this.row, this.col-1) == "Y") callback(notEmpty(value, 100))
			else callback(true)}},
		{data : 'rawSpcYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'woYn', type :'text', renderer : procFtaRnder,width : 250},
		{data : 'rawWoYn', type :'text', renderer : procFtaRnder,width : 250},
	];

	this.itemHsCol = (tableType == "edit") ? [
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",readOnly : true,renderer : pkNoneEdit, validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter",readOnly : true,renderer : pkNoneEdit, renderer : srchItemEdit, readOnly : true,renderer : pkNoneEdit},
		{data : 'hsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter",readOnly : true,renderer : pkNoneEdit, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'hsCd',type : 'text',className : 'htCenter',validator : fn_hsCdCheck, renderer : nullHsCode},
		{data : 'cmmnts',type : 'text'},
		{data : 'autoYn', editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',className : "htCenter"}
		//{data : 'delYn',editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : (tableType == "read") ? [
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'hsVer',type : 'numeric',className : 'htCenter', validator : function(value, callback){callback(notEmpty(value, 5))}},
		{data : 'hsCd',type : 'text',className : 'htCenter',validator : fn_hsCdCheck, renderer : nullHsCode},
		{data : 'cmmnts',type : 'text'}
	] : [
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, renderer : srchItemEdit, readOnly : true},
		{data : 'hsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'hsCd',type : 'text',className : 'htCenter',validator : fn_hsCdCheck},
		{data : 'cmmnts',type : 'text'}
	];

	this.itemPartnCol = (tableType == "edit") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",readOnly : true,renderer : pkNoneEdit},
		{data : 'itemCd',type : 'text',className : "htCenter",readOnly : true,renderer : pkNoneEdit},
		{data : 'partnCd',type : 'text',className : 'htCenter',readOnly : true,renderer : pkNoneEdit},
		{data : 'partnItemCd',type : 'text',className : 'htCenter',readOnly : true,renderer : pkNoneEdit},
		{data : 'partnItemNm',type : 'text'},
		{data : 'partnHsCd',type : 'text',className : 'htCenter',validator : fn_hsCd6Check},
		{data : 'partnHsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter",readOnly : true,renderer : pkNoneEdit},
		{data : 'remark',type : 'text'},
		{data : 'delYn',editor : 'select',selectOptions : [ 'Y', 'N' ],type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}}
	] : (tableType == "read") ? [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'partnCd',type : 'text',className : 'htCenter', validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'partnItemCd',type : 'text',className : 'htCenter', validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'partnItemNm',type : 'text'},
		{data : 'partnHsCd',type : 'text',className : 'htCenter',validator : fn_hsCd6Check},
		{data : 'partnHsVer',type : 'numeric',className : 'htCenter',validator : fn_hsVerCheck},
		{data : 'remark',type : 'text'}
	] : [
		{data : 'saveCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: true,uncheckedTemplate: false, readOnly:false},
		{data : 'plntCd',editor : 'select',selectOptions : plntDropdown,type : 'autocomplete',className : "htCenter",validator : function(value, callback) {callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'itemCd',type : 'text',className : "htCenter", validator : function(value, callback){callback(notEmpty(value, 200))}, renderer : srchItemEdit},
		{data : 'partnCd',type : 'text',className : 'htCenter', validator : function(value, callback){callback(notEmpty(value, 20))}, renderer : srchPartnEdit},
		{data : 'partnItemCd',type : 'text',className : 'htCenter', validator : function(value, callback){callback(notEmpty(value, 200))}},
		{data : 'partnItemNm',type : 'text'},
		{data : 'partnHsCd',type : 'text',className : 'htCenter',validator : fn_hsCd6Check},
		{data : 'partnHsVer',editor : 'select',selectOptions : itemHsVer,type : 'autocomplete',className : "htCenter", validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
		{data : 'remark',type : 'text'}
	];
}

//테이블 헤더
function fn_itamTableHeader(){
	var tableType = $("input[name=itemType]:checked").val();

	this.itemHeader = (tableType == "edit") ? [
		"saveCheck",
		colPlntCd + '*', colItemCd + '*', colHsCd, colHsVer + '*', colItemNmVn + '*', colItemNmEn + '*',
	    colPrdctSpc, colBaseUnt + '*'/*20201221 박은식 단위 필수값 표시 추가 */
	   /* ,colUntWght, colUntDisp*/
	    , colSpcAdmitYn,
	    /*colMtrlType,*/colpreReq, colApplyPsr, colSpcYn, colSpcNm,colRawSpcYn,colWoYn,colRawWoYn, colDelYn
	] : (tableType == "read") ? [
		"saveCheck",
		colPlntCd + '*', colItemCd + '*', colHsCd, colHsVer + '*', colItemNmVn + '*', colItemNmEn + '*',
	    colPrdctSpc, colBaseUnt + '*'/*20201221 박은식 단위 필수값 표시 추가 */
	   /* ,colUntWght, colUntDisp*/
	    , colSpcAdmitYn,
	    /*colMtrlType,*/colpreReq, colApplyPsr, colSpcYn, colSpcNm,colRawSpcYn,colWoYn,colRawWoYn,colRegDt/*,colEdtDt*/
	] : [
		"saveCheck",
		colPlntCd + '*', colItemCd + '*', colHsCd, colHsVer + '*', colItemNmVn + '*', colItemNmEn + '*',
		colPrdctSpc, colBaseUnt + '*'/*20201221 박은식 단위 필수값 표시 추가 */
		/*,colUntWght, colUntDisp*/
		, colSpcAdmitYn,
		/*colMtrlType,*/colpreReq, colApplyPsr, colSpcYn, colSpcNm,colRawSpcYn,colWoYn,colRawWoYn

	];

	this.itemHsHeader = (tableType == "edit") ? [
		colPlntCd + "*", colItemCd + "*", colHsVer + "*", colHsCd, colRm, colAutoHsChangeYn
	] : [
		colPlntCd + "*", colItemCd + "*", colHsVer + "*", colHsCd, colRm
	];

	this.itemPartnHeader = (tableType == "edit") ? [
		"saveCheck",
		colPlntCd + "*", colItemCd + "*", colPartnCd + "*",	colPartnItemCd + "*", colPartnItemNm, colPartnHsCd+"*",	colPartnHsVer+"*", colRm, colDelYn
	] : [
		"saveCheck",
		colPlntCd + "*", colItemCd + "*", colPartnCd + "*",	colPartnItemCd + "*", colPartnItemNm, colPartnHsCd+"*",	colPartnHsVer+"*", colRm
		];

}

//테이블 히든컬럼
function fn_itemTableHidden(){
	var tableType = $("input[name=itemType]:checked").val();

	this.itemHidden =  [0];

	this.itemHsHidden = [];

	this.itemPartnHidden =  [0];
}

// 테이블 타입 변경
function fn_changeItem(type) {
	var a = itemHot.getDataAtCell(0,3);
	
	if(type == "read"){
		$("#itemExcel").show();
		$("#hsUpdate").show();
		$("#btnItemSave").hide();
		$("#btnSave_XmlItem").hide();
		$("#btnItemEditSave").hide();
		
	}else if (type == "edit") {
		$("#itemExcel").hide();
		$("#btnItemSave").hide();
		$("#btnSave_XmlItem").hide();
		$("#hsUpdate").hide();
		$("#btnItemEditSave").show();
		
	} else {
		$("#itemExcel").hide();
		$("#hsUpdate").hide();
		$("#btnItemSave").show();
		$("#btnSave_XmlItem").show();
		$("#btnItemEditSave").hide();
	}
	fn_changeItemSrchType($("input[name=item_srch20]:checked").val());
};

var jsonList;
//editsave
function fn_EditItemCheck() {
	if (itemHot.getData().length < 1) {
		alert(msgSaveEmpty);
		return;
	}
	fn_validateItemE();
};

// 정합성 체크
function fn_validateItemE() {
	itemHot.validateCells(function(result) {
		if (result) {
			console.log('bbbbbbbbb');
			 fn_EditItemData([]);
		} else {
			alert(msgSaveCheck);
			if($("input:radio[name=item_srch20]:checked").val() == '03'){
				if($("input:radio[name=itemType]:checked").val() == 'enrol'){
					if(itemHot.getDataAtCell(0,2)==null){
						itemHot.setDataAtCell(0, 2, '');
					}
					if(itemHot.getDataAtCell(0,3)==null){
						itemHot.setDataAtCell(0, 3, '');
					}
				}
			}
			itemHot.render();
		}
	});
};
function fn_EditItemData(jsonList) {
	if(!confirm(msgSaveConfirm)) return;
	fn_loading(true);
	var tableType = $("input:radio[name=itemType]:checked").val();
	var cdTp = $("input:radio[name=item_srch20]:checked").val();
	var checkedData = itemHot.getSourceData();
	var popData = [];

	if($("input[name=item_srch20]:checked").val() == "01"){
	for(var i=0; i<checkedData.length; i++){
		
		checkedData[i]["cdTp"] = cdTp;
	     popData.push(checkedData[i]);
		
	     /*if( tableType == "edit" ){
		if(checkedData[i]["saveCheck"] == true){
			checkedData[i]["cdTp"] = cdTp;
			popData.push(checkedData[i]);
			}
		} else {
			checkedData[i]["cdTp"] = cdTp;
			popData.push(checkedData[i]);
		}*/
	}

	} else if($("input[name=item_srch20]:checked").val() == "02"){
		for (var i = 0; i < checkedData.length; i++) {
			if(checkedData[i]["hsVer"] == "" || checkedData[i]["hsVer"] == null){
				checkedData[i]["hsVer"] = "2022";
				checkedData[i]["tableType"] = tableType;
			}
			checkedData[i]["cdTp"] = cdTp;
			popData.push(checkedData[i]);
			console.log(popData);
		}
	} else {
		for(var i=0; i<checkedData.length; i++){
		checkedData[i]["cdTp"] = cdTp;
		popData.push(checkedData[i]);
		}
	}
	$.ajax({
		type : "POST",
		url : "/base/updateItemList.do?cdTp="+cdTp,
		/*url : "/base/updateItemList.do",*/
		data : JSON.stringify(popData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				alert(msgSaveSuccess);
				if ($("input[name=itemType]:checked").val() == "enrol") {
					$("input:radio[name=itemType]")[0].checked = true;
					fn_changeItem($("input[name=itemType]:checked").val());
				}
				$("input:radio[name=itemType]:input[value='read']").trigger("click");
				fn_searchItem();
			} else if(data = "overlap"){
				alert("등록 정보와 중복되는 기존정보가 존재합니다.");
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

//table Settings 아이템정보
function fn_handsonGridItemOption(col, header, hidden) {
	var tableType = $("input[name=itemType]:checked").val();

	itemSettings = {
		columns : col,
		colHeaders : header,
		hiddenColumns : {
			copyPasteEnabled : false,
			indicators : false,
			columns : hidden
		},
		stretchH : 'all',
		width : '98%',
		autoWrapRow : true,
		height : 487,
		autoRowSize : true,
		manualRowResize : true,
		manualColumnResize : true,
		rowHeights : 25,
		rowHeaders : true,
		columnHeaderHeight : 25,
		manualRowMove : true,
		manualColumnMove : false,
		//dropdownMenu : true,

		contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		//dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		filters : true,
		readOnly : (tableType == "read") ? true : false,
		allowRemoveRow : true,
		//columnSorting : {indicator : true},
		autoColumnSize : {samplingRatio : 23},
		wordWrap : true,
		afterChange: function(changes, source) {
			  if (changes && changes[0][2] !== changes[0][3]) {
			    var checkedRows = [];
			    for (var i = 0; i < changes.length; i++) {
			      var row = changes[i][0]; // Get the row of the changed cell
			      var col = changes[i][1]; // Get the col of the changed cell

			      if (col == "hsCd") {
			        var isChecked = this.setDataAtCell(row, 0, true); // Set the value of the cell at row 0 and col 0 to true
			        checkedRows.push(this.getDataAtRow(row)); // Push the entire row data to the checkedRows array
			      }
			    }
			    jsonList = JSON.stringify(checkedRows); // Convert the checkedRows array to JSON and assign it to jsonList
		
			  }
			}
	};
    return  itemSettings ;
}


//아이템정보 검색 그리드
function fn_gridItemOption1(mode) {
	if (mode) {
		$("#itemInfo").show();
		$("#itemInfo1").show();
		$("#itemInfo2").show();
		$("#itemInfo3").show();
		$("#itemInfo4").show();
		$("#itemInfo5").show();
		$("#itemInfo14").show();
		$("#itemInfo15").show();
		$("#hsUpdate").show();
		$("#itemInfo16").show();
	} else {
		$("#itemInfo").hide();
		$("#itemInfo1").hide();
		$("#itemInfo2").hide();
		$("#itemInfo3").hide();
		$("#hsUpdate").hide();
		$("#btnSave_XmlItem").hide();
		$("#itemInfo5").hide();
		$("#itemInfo14").hide();
		$("#itemInfo15").hide();
		$("#itemInfo16").hide();
	}
}

//hs정보 검색 그리드
function fn_gridItemOption2(mode) {
	if (mode) {
		$("#itemhsInfo").show();
		$("#hsCdSrch1").show();
		$("#itemInfo4").show();
		$("#itemInfo6").show();
	} else {
		$("#itemhsInfo").hide();
		$("#hsCdSrch1").hide();
		$("#itemInfo6").hide();
	}
}

//고객사품목 검색 그리드
function fn_gridItemOption3(mode) {
	if (mode) {
		$("#partnItemInfo").show();
		$("#partnInfo1").show();
		$("#partnInfo2").show();
		$("#partnInfo3").show();
		$("#partnInfo4").show();
		$("#partnInfo5").show();
		$("#partnInfo16").show();
		$("#itemInfo4").hide();
	} else {
		$("#partnItemInfo").hide();
		$("#partnInfo1").hide();
		$("#partnInfo2").hide();
		$("#partnInfo3").hide();
		$("#partnInfo4").hide();
		$("#partnInfo5").hide();
		$("#partnInfo16").hide();
	}
}

// 검색구분 변경
function fn_changeItemSrchType(type) {
	let itemCol = new fn_itemTableCol();
	let itemHeader = new fn_itamTableHeader();
	let itemHidden = new fn_itemTableHidden();
	var col, header, hidden;

	$('#alignItem option:eq(0)').prop('selected', true);

	if (type == "01") {
		//화면 라벨 조정
		fn_gridItemOption1(true);
		fn_gridItemOption2(false);
		fn_gridItemOption3(false);
		//생성 컬럼 해더 히든 선택
		col = itemCol.itemCol;
		header = itemHeader.itemHeader;
		hidden = itemHidden.itemHidden;
		//그리드 옵션조정
		itemHot.updateSettings(fn_handsonGridItemOption(col, header, hidden));

	} else if (type == "02") {
		fn_gridItemOption1(false);
		fn_gridItemOption2(true);
		fn_gridItemOption3(false);

		col = itemCol.itemHsCol;
		header = itemHeader.itemHsHeader;
		hidden = itemHidden.itemHsHidden

		itemHot.updateSettings(fn_handsonGridItemOption(col, header, hidden));

	} else {
		fn_gridItemOption1(false);
		fn_gridItemOption2(false);
		fn_gridItemOption3(true);

		col = itemCol.itemPartnCol;
		header = itemHeader.itemPartnHeader;
		hidden = itemHidden.itemPartnHidden

		itemHot.updateSettings(fn_handsonGridItemOption(col, header, hidden));
	}
	//데이터 갱신
	fn_searchItem();

}

// 테이블팝업 호출
function fn_callPopItem(target, row, col) {
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	// 아이템 조회
	if (target == "itemCd" || target == "1") {
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM"
				: "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colItemCd);
	} else if(target == "partnCd" || target == "partnCd1"){
		strSearch = (colLang == "en") ? "DISTINCT(BUYR_ID) AS CD, BUYR_NM_EN AS CD_NM"
				: "DISTINCT(BUYR_ID) AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colPartnCd);
	} else if(target == "partnItemCd"){
		strSearch = "DISTINCT(PARTN_ITEM_CD) AS CD, PARTN_ITEM_NM AS CD_NM"
		strFrom = "PARTN_ITEM_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = "PARTN_ITEM_NM";
		$("#exampleModalCenterTitleCmmn").text(colPartnItemCd);
	}

	type = target;

	var condition = {
		type : "tableCd",
		search : strSearch,
		from : strFrom,
		where : strWhere,
		orderby : strOrderby,
		if1 : strIf1,
		if2 : strIf2,
		type : type,
		row : row,
		col : col
	};

	fn_showCmmnPopup(condition, function(data) {
		if (data.type == "itemCd") {
			$("#item_srch2").val(data.cd);
		} else if(data.type == "partnCd"){
			$("#item_srch10").val(data.cd);
		} else if(data.type == "partnItemCd"){
			$("#item_srch12").val(data.cd);
		} else if(data.type == "partnCd1"){
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		} else {
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
};

// 품목 추가 확인 버튼 클릭
function fn_callFtaPrePop(prop,row, col) {
	popRowData = itemHot.getSourceDataAtRow(row);
	popRow = row;
	popCol = col;
	$("#ftaPrePop").modal("show");
	setTimeout(function() {
		ftaPreHot.render()
	}, 200);
	fn_searchFtaInfo(prop,row, col);
};

function fn_saveProcFtaPop(){
	//각각의 영역별 처리
	fn_loading(true);
	
	var listTmp = "";
	var spcList = $("#spcYn").find("select");
	var rawSpcList = $("#rawSpcYn").find("select");
	var woList = $("#woYn").find("select");
	var rawWoList = $("#rawWoYn").find("select");

	var row = Number($("#ftaProcPop").attr("data-row"))
	var spcCol = 12;
	var rawSpcCol = 14;
	var woCol = 15;
	var rawWoCol = 16;
	//가공공정
	for(var i=0;i<spcList.length; i++){
		if(spcList.length-1 > i){
			listTmp += spcList.eq(i).attr("id")+":"+spcList.eq(i).val()+",";
		}else {
			listTmp += spcList.eq(i).attr("id")+":"+spcList.eq(i).val();
		}
	}
	itemHot.setDataAtCell(row,spcCol, listTmp);
	listTmp = "";

	//원자제 가공공정 procList
	for(var i=0;i<rawSpcList.length; i++){
		if(rawSpcList.length-1 > i){
			listTmp += rawSpcList.eq(i).attr("id")+":"+rawSpcList.eq(i).val()+",";
		}else {
			listTmp += rawSpcList.eq(i).attr("id")+":"+rawSpcList.eq(i).val();
		}
	}
	itemHot.setDataAtCell(row,rawSpcCol, listTmp);
	listTmp = "";

	//완전생산
	for(var i=0;i<woList.length; i++){
		if(woList.length-1 > i){
			listTmp += woList.eq(i).attr("id")+":"+woList.eq(i).val()+",";
		}else {
			listTmp += woList.eq(i).attr("id")+":"+woList.eq(i).val();
		}
	}
	itemHot.setDataAtCell(row,woCol, listTmp);
	listTmp = "";

	//원자제 완전생산
	for(var i=0;i<rawWoList.length; i++){
		if(rawWoList.length-1 > i){
			listTmp += rawWoList.eq(i).attr("id")+":"+rawWoList.eq(i).val()+",";
		}else {
			listTmp += rawWoList.eq(i).attr("id")+":"+rawWoList.eq(i).val();
		}
	}
	itemHot.setDataAtCell(row,rawWoCol, listTmp);

	$("#ftaProcPop").modal("hide");
	fn_loading(false);
}

// 팝업검색
function fn_searchFtaInfo(prop,row, col) {

	// 사전질의 팝업
	var ftaPreElement = document.querySelector('#ftaPreTable');
	var ftaPreElementContainer = ftaPreElement.parentNode;
	var colRadio = "<input type='checkbox' class='checker' value='no' onclick='fn_ftaAllChk($(this));' >";


	function commentsRenderer(instance, td, row, col, prop, value, cellProperties) {
	    Handsontable.renderers.TextRenderer.apply(this, arguments);
	    td.style.color = '';

	    if (value ==null || value == undefined ) return ;

	    if (value.length > 64) {
	      td.innerHTML = '<div title="' + value + '">' + value.slice(0, 64) + '</div>';
	    } else {
		  td.innerHTML = '<div>' + value + '</div>';
	    }

	    $(td).children().css("text-overflow", "ellipsis").css("overflow", "hidden").css("white-space", "nowrap")
	  }

	function psrSelectRadioRenderer(instance, td, row, col, prop, value, cellProperties) {
	    var ftaCd = ftaPreHot.getDataAtCell(row, col+1);
		var html = "<input type='radio' name='"+ftaCd+"' data-col='"+col+"' data-row='"+row+"' style='margin-left:35%'/>"

	    $(td).empty().append(html);
	  }

	var ftaPreSettings = {
		columns : [
					{data : 'psrSeq',type : 'text',className : "htCenter",width : 50},
					{data : 'preChk',type : 'checkbox',checkedTemplate : 'yes',uncheckedTemplate : 'no',className : "htCenter",width : 15, readOnly:false, renderer:psrSelectRadioRenderer},
					{data : 'ftaCd',type : 'text',className : "htCenter",width : 40},
					{data : 'preRequest', type : 'text', width : 200},
					{data : 'psrSumry2',type : 'text',className : "htCenter",width : 40},
				 ],
		stretchH : 'all',
		width : '98.7%',
		height : 390,
		rowHeights : 25,
		columnHeaderHeight : 25,
		colHeaders : [colPsrSeq,colChoice,colftaCd/*,colHsVer,colStdrHs,colEndHs*//*,colSeq*/,colApplyPsrList, "PSR"],
		contextMenu : false,
		//manualColumnResize : true,
		readOnly : true,
		hiddenColumns : {
			copyPasteEnabled : false,
			indicators : false,
			columns : [0]
		}
	};

	ftaPreHot = new Handsontable(ftaPreElement, ftaPreSettings);
	fn_loading(true);
	var fData = {};
	fData['srch30'] = itemHot.getDataAtCell(row,3);
	console.log(fData);
	$.ajax({
		type : "POST",
		url : "/base/selectFtaInfoList.do",
		data : fData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			ftaPreHot.loadData([]);
			ftaPreHot.loadData(data.resultList);
			setTimeout(function() {ftaPreHot.render()}, 200);
			fn_setFtaPre();
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
	var selectInfo = "<h6 style='margin-right:10px; float:left'>"+colItemCd+":"+itemHot.getDataAtCell(row,2)+
					 "</h6><h6 style='margin-right:10px; float:left'>"+colItemNm+":"+itemHot.getDataAtCell(row,5)+
					 "</h6><h6 style='float:left'>"+colHsCd+":"+itemHot.getDataAtCell(row,3)+"["+itemHot.getDataAtCell(row,4)+"]</h6>";

	$("#psrItemInfo").text('').append(selectInfo);

};

// 협정별 사전질의 팝업 셋팅
function fn_setFtaPre() {
	var ftaStr, preStr;
	if (popRowData.preRequest != undefined && popRowData.preRequest != "") {
		ftaStr = popRowData.preRequest.split(",");
		console.log(ftaStr)
		for (var i = 0; i < ftaStr.length; i++) {
			if (ftaStr[i] != "") {
				preStr = ftaStr[i].split(",");
				var saveData = ftaPreHot.getSourceData();
				for (var j = 0; j < saveData.length; j++) {
					if (saveData[j]["psrSeq"] == preStr[0]) {
						saveData[j]["preChk"] = "yes";
					}
				}
			}
		}
	}
};

// 협정별 사전질의 팝업 적용 버튼
function fn_saveFtaPre() {
	var pattern = /[^(0-9,)]/gi;
	var preRequest = [];
	var saveData = ftaPreHot.getSourceData();
	var tmpFta = [];
	var preReqList = "";
	for(var i=0;i<saveData.length;i++){
		if(tmpFta.indexOf(saveData[i].ftaCd) < 0){
			tmpFta.push(saveData[i].ftaCd);
		} else {
			continue;
		}
	}
	for(var i=0;i< tmpFta.length; i++){
		if($("input:radio[name='"+tmpFta[i]+"']:checked").attr('data-row') != undefined){
			preRequest.push($("input:radio[name='"+tmpFta[i]+"']:checked").attr('data-row'));
		}
	}
	for(var i=0; i<preRequest.length;i++){
		preReqList += saveData[preRequest[i]].psrSeq + ",";
	}
	itemHot.setDataAtCell(popRow, popCol, preReqList);



	var $button = $('<i class="search-icon text-muted i-Magnifi-Glass1", id="psr'+popRow+'" style="cursor:pointer;" onclick="fn_callFtaPrePop(\'preRequest\','+ popRow + ',' + popCol + ')"></i>');
	$("#psr"+popRow+"").parent().text('').append($button).append(preReqList);
	$("#ftaPrePop").modal("hide");
};

// 협정별 사전질의 팝업 checkbox all check
function fn_ftaAllChk(obj) {
	var check, chkHeader;
	console.log(obj.val())
	if (obj.val() == 'no') {
		check = "yes";
		obj.val('yes');
		chkHeader = "<input type='checkbox' class='checker' value='yes' onclick='fn_ftaAllChk($(this));' >";
	} else {
		check = "no";
		obj.val('no');
		chkHeader = "<input type='checkbox' class='checker'  value='no' onclick='fn_ftaAllChk($(this));' >";
	}

	var data = ftaPreHot.getData();
	for (var i = 0; i < data.length; i++) {
		ftaPreHot.setDataAtCell(i, 0, check);
	}
};

// hsUpdate
function fn_hsUpdate() {
	//alert("HS CODE UPDATE 개발중");
	if(!confirm(msgHsUpdateMsg)){
		return ;
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/makeItemHsInfo.do",
		dataType : "json",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		success : function(data) {
			alert(msgSaveSuccess);
			fn_loading(false);
		},
		error : function(e, textStatus, errorThrown) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		if(e.status == 400){
            		alert("Your request is up. Please log back in if you wish continue");
            		location.href = document.referrer;
            	} else {
					console.log(errorThrown);
					alert(msgSearchError);
            	}
        	}
		}
	});

}

function fn_ftaPsrSrch(fta, type, seq){
	var fData = {};
	fData["srch1"] = fta;
	fData["srch2"] = itemHot.getDataAtCell($("#procFta").attr("data-row"), 2).replace(".", "").replace("-", "");
	fData["srch4"] = seq;
	$("#ftaPsrInfoText").empty();
	if(seq == undefined || seq == null || seq == ""){
		if(type == "spc"){
			msgText = msgNonSpcYn;
		} else if(type == "rawSpc"){
			msgText = msgNonRawSpcYn;
		} else if(type == "wo"){
			msgText = msgNonWoYn;
		} else {
			msgText = msgNonRawWoYn;
		}
		$("#ftaPsrInfoText").append("<p style='color:#777777; font-size:14px'>"+msgText+"</p>");
		console.log(msgText);
		return;
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/ftaPsrSrch.do",
		data : fData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			var list = data.resultList;
			if(list.length == 0){
			//가공공정여부 TEXT STRAT
				if(type == "spc"){
					msgText = msgNonSpcYn;
				} else if(type == "rawSpc"){
					msgText = msgNonRawSpcYn;
				} else if(type == "wo"){
					msgText = msgNonWoYn;
				} else {
					msgText = msgNonRawWoYn;
				}
				$("#ftaPsrInfoText").append("<p style='color:#777777; font-size:14px'>"+msgText+"</p>")

			} else {
					$("#ftaPsrInfoText").append("<p style='font-size:14px'>"+list[0].psrDetail+"</p>")

			}
			fn_loading(false);
			//가공공정여부 TEXT END
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

//가공공정여부
function fn_callProcFtaPop(row, col, type) {
	fn_loading(true);
	$("#spcYn").find("label").attr("data-seq", "");
	$("#rawSpcYn").find("label").attr("data-seq", "");
	$("#woYn").find("label").attr("data-seq", "");
	$("#rawWoYn").find("label").attr("data-seq", "");

	//추가기준 선택 부분 START
	if(type == "rawSpcYn"){// 원자제가공공정여부
		$("#itemSpcTitle").text(colRawSpcYn)
	} else if(type == "rawWoYn"){//원자제 완전생산여부
		$("#itemSpcTitle").text(colRawWoYn)
	} else if(type == "woYn"){//완전생산여부
		$("#itemSpcTitle").text(colWoYn)
	} else { //가공공정여부
		$("#itemSpcTitle").text(colSpcYn)
	}
	$("input:radio[name=additional][value="+type+"]").prop("checked", true)
	$("[name=additionalBody]").css("display", "none");
	$("#"+type+"").css("display", "block");
	//추가기준 선택 부분 END

	itemHot.getDataAtProp($("input:radio[name=additional]:checked").val())[row] //컬럼명으로 조회
	/**
	 * 적용 로직
	 * 1. itemHot.getDataAtProp("spcYn") 를 이용하여 현재 적용되어있는 정보를 가져옴
	 * 1-1. 적용되어있는 정보가 없으면 패스
	 * 1-2. 적용되어있는 정보가 있으면 해당 정보를 selectbox에 적용
	 * 2. 각각의 추가기준 정보를 선택할 시 적용되는 PSR FTA를 조회
	 * 3. 해당하는 FTA가 있을 경우 각각의 select box 를 활성화
	 * 4. 적용 시 각각의 컬럼에 맞게 적용
	 *
	 *  ** 화면분할 완료
	 *  ** 어떻게 타겟을 잡아서 데이터를 넣어줄지
	 *  ** row값만 알면 가능함
	 *  ** col값은 각각의 버튼에 data-col로 저장하여 가져옴
	 *  ** 한화면에서 모두 선택가능하게
	 *  ** 버튼은 어느것을 눌러도 해당정보를 가져오도록 처리
	 * */
	var tableType = $("input[name=itemType]:checked").val();
	var procSlect = $("#"+type+"").find("select");
	$("#ftaPsrInfoText").empty();
	$("#ftaPsrInfoText").append("<br/>")
	$("#procFta").attr("data-row", row);
	var spcFta = [];
	var woFta = [];
	var rawSpcFta = [];
	var rawWoFta = [];
	var pData = {};
	if(itemHot.getDataAtCell(row, 3) == null || itemHot.getDataAtCell(row, 3) == ""){
		alert(msgHsCdMsg)
		return;
	}
	pData["srch2"] = itemHot.getDataAtCell(row, 3).replace(".", "").replace("-", "");
	pData["searchType"] = type;
	$.ajax({
		type : "POST",
		url : "/base/ftaPsrCheck.do",
		data : pData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async : false,
		dataType : "json",
		success : function(data) {
			console.log(data)
			spcFta = data.spcYn;
			rawSpcFta = data.rawSpcYn;
			woFta = data.woYn;
			rawWoFta = data.rawWoYn;
//			for(var i=0;i < data.spcYn.length; i++){
//				spcFta.push(data.spcYn[i].ftaCd);
//			}
//
//			for(var i=0;i < data.rawSpcYn.length; i++){
//				rawSpcFta.push(data.rawSpcYn[i].ftaCd);
//			}
//			for(var i=0;i < data.woYn.length; i++){
//				woFta.push(data.woYn[i].ftaCd);
//			}
//			for(var i=0;i < data.rawWoYn.length; i++){
//				rawWoFta.push(data.rawWoYn[i].ftaCd);
//			}
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
	var spcList = null;
	var rawSpcList = null;
	var woList = null;
	var rawWoList = null;
	
	spcList = $("#spcYn").find("select");
	rawSpcList = $("#rawSpcYn").find("select");
	woList = $("#woYn").find("select");
	rawWoList = $("#rawWoYn").find("select");

	var spcTmp=itemHot.getDataAtCell(row,12);
	var rawSpcTmp=itemHot.getDataAtCell(row,14);
	var woTmp=itemHot.getDataAtCell(row,15);
	var rawWoTmp=itemHot.getDataAtCell(row,16);
	for(var i=0; i < spcList.length; i++){
		for(var j=0; j< spcFta.length; j++){
			if(spcList.eq(i).attr("id") == spcFta[j].ftaCd){
				spcList.eq(i).parent().find("label").attr("data-seq", spcFta[j].psrSeq);
			}
		}
	}
	for(var i=0; i < rawSpcList.length; i++){
		for(var j=0; j< rawSpcFta.length; j++){
			if(rawSpcList.eq(i).attr("id") == rawSpcFta[j].ftaCd){
				rawSpcList.eq(i).parent().find("label").attr("data-seq", rawSpcFta[j].psrSeq);
			}
		}
	}
	for(var i=0; i < woList.length; i++){
		for(var j=0; j< woFta.length; j++){
			if(woList.eq(i).attr("id") == woFta[j].ftaCd){
				woList.eq(i).parent().find("label").attr("data-seq", woFta[j].psrSeq);
			}
		}
	}
	for(var i=0; i < rawWoList.length; i++){
		for(var j=0; j< rawWoFta.length; j++){
			if(rawWoList.eq(i).attr("id") == rawWoFta[j].ftaCd){
				rawWoList.eq(i).parent().find("label").attr("data-seq", rawWoFta[j].psrSeq);
			}
		}
	}


	if(tableType == 'read'){
		$("#btnFtaProcSave").hide();
		if(spcTmp == null || spcTmp.length == 0){
			for(var i=0;i<spcList.length; i++){
				spcList.eq(i).val("").css("color", "")
									   .prop("selected", true);
			}
		} else {
			var getData = spcTmp.split(",");
			for(var i=0; i < spcList.length; i++){
				for(var j=0; j < getData.length; j++){
					if(spcList.eq(i).attr("id") == getData[j].split(":")[0]){
						spcList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																    .prop("selected", true);
					}
				}

			}
		}

		if(rawSpcTmp == null || rawSpcTmp.length == 0){
			for(var i=0;i<rawSpcList.length; i++){
				rawSpcList.eq(i).val("").css("color", "")
									   .prop("selected", true);
			}
		} else {
			var getData = rawSpcTmp.split(",");
			for(var i=0; i < rawSpcList.length; i++){
				for(var j=0; j < getData.length; j++){
					if(rawSpcList.eq(i).attr("id") == getData[j].split(":")[0]){
						rawSpcList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																    .prop("selected", true);
					}
				}

			}
		}

		if(woTmp == null || woTmp.length == 0){
			for(var i=0;i<woList.length; i++){
				woList.eq(i).val("").css("color", "")
									   .prop("selected", true)
									   .attr("disabled", true);
			}
		} else {
			var getData = woTmp.split(",");
			for(var i=0; i < woList.length; i++){
				for(var j=0; j < getData.length; j++){
					if(woList.eq(i).attr("id") == getData[j].split(":")[0]){
						woList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																    .prop("selected", true);
					}
				}

			}
		}

		if(rawWoTmp == null || rawWoTmp.length == 0){
			for(var i=0;i<rawWoList.length; i++){
				rawWoList.eq(i).val("").css("color", "")
									   .prop("selected", true)
									   .attr("disabled", true);
			}
		} else {
			var getData = rawWoTmp.split(",");
			for(var i=0; i < rawWoList.length; i++){
				for(var j=0; j < getData.length; j++){
					if(rawWoList.eq(i).attr("id") == getData[j].split(":")[0]){
						rawWoList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																    .prop("selected", true)
																    .attr("disabled", true);
					}
				}

			}
		}

		$("#procFta").find("select").prop("disabled", true);
	} else {
		//화면별로 처리
		/*$("#btnFtaProcSave").show();
		spcList.css("color", "#ffffff").attr("disabled", true);
		//가공공정
		if(spcFta.length == 0){
			for(var i=0;i<spcList.length; i++){
				spcList.eq(i).css("color", "#ffffff").attr("disabled", true);
			}
		} else {
			for(var i=0;i<spcList.length; i++){
				for(var j=0;j < spcFta.length; j++){
					if(spcList.eq(i).attr("id") == spcFta[j].ftaCd){
						spcList.eq(i).css("color", "").attr("disabled", false);
					}
				}
			}
			
			if(spcTmp == null || spcTmp.length == 0){
				for(var i=0;i<spcList.length; i++){
					spcList.eq(i).val("").css("color", "")
										   .prop("selected", true);
					spcList.eq(i).css("color", "#ffffff").attr("disabled", true);
				}
			} else {
				var getData = spcTmp.split(",");
				for(var i=0; i < spcList.length; i++){
					for(var k=0; k < getData.length; k++){
						if(spcList.eq(i).attr("id") == getData[k].split(":")[0]){
							spcList.eq(i).val(getData[k].split(":")[1]).css("color", "")
																	    .prop("selected", true);
						}
					}

				}
			}
			
		}

		rawSpcList.css("color", "#ffffff").attr("disabled", true);
		//원자제 가공공정
		if(rawSpcFta.length == 0){
			for(var i=0;i<rawSpcList.length; i++){
				rawSpcList.eq(i).css("color", "#ffffff").attr("disabled", true);
			}
		} else {
			for(var i=0;i<rawSpcList.length; i++){
				for(var j=0;j < rawSpcFta.length; j++){
					if(rawSpcList.eq(i).attr("id") == rawSpcFta[j].ftaCd){
						rawSpcList.eq(i).css("color", "").attr("disabled", false);
					}
				}
			}
			if(rawSpcTmp == null || rawSpcTmp.length == 0){
				for(var i=0;i<rawSpcList.length; i++){
					rawSpcList.eq(i).val("").css("color", "")
										   .prop("selected", true);
				}
			} else {
				var getData = rawSpcTmp.split(",");
				for(var i=0; i < rawSpcList.length; i++){
					for(var j=0; j < getData.length; j++){
						if(rawSpcList.eq(i).attr("id") == getData[j].split(":")[0]){
							rawSpcList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																	    .prop("selected", true);
						}
					}

				}
			}
			
		}

		woList.css("color", "#ffffff").attr("disabled", true);
		//완전생산
		if(woFta.length == 0){
			for(var i=0;i<woList.length; i++){
				woList.eq(i).css("color", "#ffffff").attr("disabled", true);
			}
		} else {
			for(var i=0;i<woList.length; i++){
				for(var j=0;j < woFta.length; j++){
					if(woList.eq(i).attr("id") == woFta[j].ftaCd){
						woList.eq(i).css("color", "").attr("disabled", false);
					}
				}
			}
			
			if(woTmp == null || woTmp.length == 0){
				for(var i=0;i<woList.length; i++){
					woList.eq(i).val("").css("color", "")
										   .prop("selected", true)
										   .attr("disabled", true);
				}
			} else {
				var getData = woTmp.split(",");
				for(var i=0; i < woList.length; i++){
					for(var j=0; j < getData.length; j++){
						if(woList.eq(i).attr("id") == getData[j].split(":")[0]){
							woList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																	    .prop("selected", true);
						}
					}

				}
			}
		}

		rawWoList.css("color", "#ffffff").attr("disabled", true);
		//원자제 완전생산
		if(rawWoFta.length == 0){
			for(var i=0;i<rawWoList.length; i++){
				rawWoList.eq(i).css("color", "#ffffff").attr("disabled", true);
			}
		} else {
			for(var i=0;i<rawWoList.length; i++){
				for(var j=0;j < rawWoFta.length; j++){
					if(rawWoList.eq(i).attr("id") == rawWoFta[j].ftaCd){
						rawWoList.eq(i).css("color", "").attr("disabled", false);
					}
				}
			}
			
			if(rawWoTmp == null || rawWoTmp.length == 0){
				for(var i=0;i<rawWoList.length; i++){
					rawWoList.eq(i).val("").css("color", "")
										   .prop("selected", true)
										   .attr("disabled", true);
				}
			} else {
				var getData = rawWoTmp.split(",");
				for(var i=0; i < rawWoList.length; i++){
					for(var j=0; j < getData.length; j++){
						if(rawWoList.eq(i).attr("id") == getData[j].split(":")[0]){
							rawWoList.eq(i).val(getData[j].split(":")[1]).css("color", "")
																	    .prop("selected", true)
																	    .attr("disabled", true);
						}
					}

				}
			}

		}*/
		
		$("#btnFtaProcSave").show();
		spcList.css("color", "#ffffff").attr("disabled", true);
		//가공공정
		if(spcFta.length == 0){
			for(var i=0;i<spcList.length; i++){
				spcList.eq(i).css("color", "#ffffff").attr("disabled", true);
				spcList.eq(i).val("").prop("selected", true);
			}
		} else {
			for(var i=0;i<spcList.length; i++){
				spcList.eq(i).val("").prop("selected", true);
				for(var j=0;j < spcFta.length; j++){
					if(spcList.eq(i).attr("id") == spcFta[j].ftaCd){
						spcList.eq(i).css("color", "").attr("disabled", false);
					}
				}
				if(spcTmp != null){
					var getData = spcTmp.split(",");
					for(var k=0; k < getData.length; k++){
						if(spcList.eq(i).attr("id") == getData[k].split(":")[0]){
							spcList.eq(i).val(getData[k].split(":")[1]).prop("selected", true);
						}
					}
				}
			}
		}

		rawSpcList.css("color", "#ffffff").attr("disabled", true);
		//원자제 가공공정
		if(rawSpcFta.length == 0){
			for(var i=0;i<rawSpcList.length; i++){
				rawSpcList.eq(i).css("color", "#ffffff").attr("disabled", true);
				rawSpcList.eq(i).val("").prop("selected", true);
			}
		} else {
			for(var i=0;i<rawSpcList.length; i++){
				rawSpcList.eq(i).val("").prop("selected", true);
				for(var j=0;j < rawSpcFta.length; j++){
					if(rawSpcList.eq(i).attr("id") == rawSpcFta[j].ftaCd){
						rawSpcList.eq(i).css("color", "").attr("disabled", false);
					}
				}
				if(rawSpcTmp != null){
					var getData = rawSpcTmp.split(",");
					for(var k=0; k < getData.length; k++){
						if(rawSpcList.eq(i).attr("id") == getData[k].split(":")[0]){
							rawSpcList.eq(i).val(getData[k].split(":")[1]).prop("selected", true);
						}
					}
				}
			}
		}

		woList.css("color", "#ffffff").attr("disabled", true);
		//완전생산
		if(woFta.length == 0){
			for(var i=0;i<woList.length; i++){
				woList.eq(i).css("color", "#ffffff").attr("disabled", true);
				woList.eq(i).eq(i).val("").prop("selected", true);
			}
		} else {
			for(var i=0;i<woList.length; i++){
				woList.eq(i).eq(i).val("").prop("selected", true);
				for(var j=0;j < woFta.length; j++){
					if(woList.eq(i).attr("id") == woFta[j].ftaCd){
						woList.eq(i).css("color", "").attr("disabled", false);
					}
				}
				if(woTmp != null){
					var getData = woTmp.split(",");
					for(var k=0; k < getData.length; k++){
						if(woList.eq(i).attr("id") == getData[k].split(":")[0]){
							woList.eq(i).val(getData[k].split(":")[1]).prop("selected", true);
						}
					}
				}
				
			}
		}

		rawWoList.css("color", "#ffffff").attr("disabled", true);
		//원자제 완전생산
		if(rawWoFta.length == 0){
			for(var i=0;i<rawWoList.length; i++){
				rawWoList.eq(i).css("color", "#ffffff").attr("disabled", true);
				rawWoList.eq(i).val("").prop("selected", true);
			}
		} else {
			for(var i=0;i<rawWoList.length; i++){
				rawWoList.eq(i).val("").prop("selected", true);
				for(var j=0;j < rawWoFta.length; j++){
					if(rawWoList.eq(i).attr("id") == rawWoFta[j].ftaCd){
						rawWoList.eq(i).css("color", "").attr("disabled", false);
					}
				}
				if(rawWoTmp != null ){
					var getData = rawWoTmp.split(",");
					for(var k=0; k < getData.length; k++){
						if(rawWoList.eq(i).attr("id") == getData[k].split(":")[0]){
							rawWoList.eq(i).val(getData[k].split(":")[1]).prop("selected", true);
						}
					}
				}
			}
		}

	}

	$("#ftaProcPop").modal("show");
	$("#ftaProcPop").attr("data-row", row)
	$("#ftaProcPop").attr("data-col", col)
	fn_loading(false);
};


//SelectBox validation check function

function itemSelectboxCheck(value, selOption){
	if (!value || String(value.trim()).length == 0 || value.length > 20 || $.inArray(value, selOption) < 0) {
		value = "2022";
	}
	return true;
}

function fn_showPurchaseFilePop(){
	if($("#fileItemPopupPc").length>1){
		$("#fileItemPopupPc").eq(1).model("show");
		$("#fileItemPopupPc").eq(0).model("show");
	} 
	$("#fileItemPopupPc").modal("show");
}

function fn_saveFile(){
	var file = $("#infoFilesItem").prop("files")[0];

	/*if(file == undefined || file == null || file == ""){
		alert(msgSelectFile);
		return;
	}*/
	
/*	var purchaseNo = $("input[name=files_var2]").val();
	if(	purchaseNo == null || purchaseNo == "" ){
		alert("구매번호를 입력해주세요.");
		return;
	}*/

	var form = new FormData(document.getElementById('filesInfoFormItem'));
	
	$.ajax({
		type: 'POST',
		url: "/base/saveItemFiles.do",
		data: form,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: 'json',
		processData: false,
		contentType: false,
		success : function(data) {
			itemHot.loadData([]);
			itemHot.loadData(data.resultList);
			
			$("#fileItemPopupPc").modal("hide");
		},
		error: function (jqXHR) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		//alert(msgSaveError);
        	}
		}
	});
};
