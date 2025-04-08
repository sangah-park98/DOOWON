var psrHot;
var psrSettings;
var psrIndex = 9999;
var psrScrollTp = true;
var psrSeqCol;
var psrSelect;
var topDropBar;
var downDropBar;
var natSelect = [];

$( document ).ready(function() {

	  psrList = psrList.replace('[','').replace(']','');
	  psrSelect = psrList.split(', ');
	  
	  natCdList = natCdList.replace('[','').replace(']','');
	  natSelect = natCdList.split(', ');
	  
	  var psrElement = document.querySelector('#psrTable');
	  var psrElementContainer = psrElement.parentNode;

	  psrHot = new Handsontable(psrElement, psrSettings);

	  $("#psrTable .wtHolder").scroll(function(){
		  var scrollTop = $("#psrTable .wtHolder").scrollTop();
		  var countPerPage = $("#psrPageCnt option:selected").val();
		  var rowHeight = psrHot.getRowHeight();

		  var addCnt = 790;
		  if(countPerPage == "50"){
			  addCnt = 790;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "200"){
			  addCnt = 3290;
		  }else if(countPerPage == "500"){
			  addCnt = 4540;
		  }
		  if(psrScrollTp && psrIndex != 9999 && scrollTop >= (countPerPage * psrIndex * rowHeight) + addCnt){
			  fn_psrScroll();
		  }
	  });
	  $(document).on('keyup', '#psr_srch2', function(){
			  $(this).val(fn_hsCdForm($(this).val()));
	  })
	  $("#btnPsrSave").hide();
	  fn_changePsr('read');
	  fn_searchPsr();

});

/** 이벤트 Start **/

//$("body").on("keydown", function(){
//	var focusElement = document.activeElement.localName;
//	if(focusElement != "select" && focusElement != "textarea"){
//		if (window.event.keyCode == 13 && $("#tabs-originbase").hasClass("active")) {
//			fn_searchPsr();
//		}
//	}
//})

//테이블 타입 변경
$("input[name=psrType]").change(function(){
	  fn_changePsr($(this).val());
	  fn_searchPsr();
});

//정렬항목
$("select[name=alignPsr]").change(function(){
	  fn_searchPsr();
});

//row 수
$("select[name=psrPageCnt]").change(function(){
	  fn_searchPsr();
});


/** 이벤트 End **/
//스크롤
function fn_psrScroll(){
	psrScrollTp = false;
	psrIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectPsrList.do",
		data : fn_setPsrForm(),
		acync: false,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = psrHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	psrHot.loadData(meargeJson);

        	psrScrollTp = true;
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
		fn_searchPsr();
    }
}


//검색
function fn_searchPsr(){
	psrIndex = 0;
	fn_loading(true);
	if($("#psr_srch2").val().length == 0 || $("#psr_srch2").val().length == 7)
	{
		$("#psrSrch1").val($("#psr_srch1").val());
		$("#psrSrch2").val($("#psr_srch2").val().replace('.',''));
		$.ajax({
			type : "POST",
			url : "/base/selectPsrList.do",
			data : fn_setPsrForm(),
			acync: false,
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			dataType: "json",
	        success : function(data) {
	        	if( $("input[name=psrType]:checked").val() == "enrol"){
	        		psrHot.loadData([]);
	        		psrHot.alter('insert_row', 1, 1);
	        	}else{
	        		psrHot.loadData([]);
	            	psrHot.loadData(data.resultList);
	            	$("#psrCnt").text(data.totCnt).number(true); //검색결과 총 갯수
	            	$("#psrtExcelBuffer").val(data.totCnt).number(true);
	        	}
	        	fn_loading(false);
	        },
	        error : function(e, textStatus, errorThrown) {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
	        }
		});
	}
	else
	{
		alert(msgHSSearch);
		$("#psr_srch2").val("");
		fn_searchPsr();
	}
};



//검색조건 생성
function fn_setPsrForm(){
	var sData = {};
	var srch2 = $("#psr_srch2").val();
	
	sData["srch1"] = $("#psr_srch1").val();
	sData["srch2"] = srch2.replace(/\./g,'')
	sData["alignItem"] = $("#alignPsr option:selected").val();
	sData["recordCountPerPage"] = $("#psrPageCnt option:selected").val();
	sData["pageIndex"] = psrIndex;
	return sData;
};

//검색조건 초기화
function fn_clearPsr(){
	$("#psr_srch1").val("");
	$("#psr_srch2").val("");
};

//저장버튼 클릭
function fn_savePsrCheck(){
	if(psrHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validatePsr();
};

//정합성 체크
function fn_validatePsr(){

	var savePsrData = psrHot.getSourceData();
	var data;
	for(var i=0; i<savePsrData.length; i++){
		if(savePsrData[i].stdrHs !=null ){
			savePsrData[i].stdrHs = savePsrData[i].stdrHs.trim();
			if(savePsrData[i].endHs !=null){
				savePsrData[i].endHs = savePsrData[i].endHs.trim();
			} /*else{
				savePsrData[i].endHs = savePsrData[i].stdrHs;
			}*/
		} else{
			alert(msgStrtHs);
			return;
		}

		data = (savePsrData[i].deminRt+"").trim();
		savePsrData[i].deminRt = (data == "") ? "0" : data;

		data = (savePsrData[i].bdRt+"").trim();
		savePsrData[i].bdRt = (data == "") ? "0" : data;

		data = (savePsrData[i].buRt+"").trim();
		savePsrData[i].buRt = (data == "") ? "0" : data;

		data = (savePsrData[i].ncRt+"").trim();
		savePsrData[i].ncRt = (data == "") ? "0" : data;

		data = (savePsrData[i].mcRt+"").trim();
		savePsrData[i].mcRt = (data == "") ? "0" : data;

		data = (savePsrData[i].indrtRt+"").trim();
		savePsrData[i].indrtRt = (data == "") ? "0" : data;
	
		data = (savePsrData[i].cnctrRt+"").trim();
		savePsrData[i].cnctrRt = (data == "") ? "0" : data;
		
		
		data = (savePsrData[i].addBdRt+"").trim();
		savePsrData[i].addBdRt = (data == "") ? "0" : data;


		data = (savePsrData[i].originRt+"").trim();
		savePsrData[i].originRt = (data == "") ? "0" : data;

		data = (savePsrData[i].nriginRt+"").trim();
		savePsrData[i].nriginRt = (data == "") ? "0" : data;

		data = (savePsrData[i].partsRt+"").trim();
		savePsrData[i].partsRt = (data == "") ? "0" : data;
	}
	psrHot.validateCells(function(result) {
		if(result){
			fn_savePsrData();
		}else{
			psrHot.render();
			alert(msgSaveCheck);
		}
    });
	fn_nonEmptyValidatePsr();
};

//function fn_nonEmptyValidatePsr(){
//
//}

//저장
function fn_savePsrData(){

	if(!confirm(msgSaveConfirm)){
		return;
	}
	fn_loading(true);
	var savePsrData = psrHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/base/savePsrInfo.do",
		data : JSON.stringify(savePsrData),
		acync: false,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
        		if($("input[name=psrType]:checked").val() == "enrol" ){
        			$("input[name=psrType]")[0].checked = true;
        			fn_changePsr($("input[name=psrType]:checked").val());
        		}
        		$("input:radio[name=psrType]:input[value='read']").trigger("click");
				fn_searchPsr();
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
function fn_psrTableCol(){
	 var tableType = $("input:radio[name=psrType]:checked").val();

	 var psrPkNoneEdit = function(instance, td, row, col, prop, value,cellProperties) {
	 	  $(td).empty().css("background-color", "#E6E6E6").css("text-align","center").append(value);
	 };

	 var psrInfoRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		  var param = psrHot.getDataAtCell(row,4);

		  $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_callPopPsrInfo('+param+')"></i>');
		  if(value == null || value == undefined){
			 value = "";
		  }
		  $(td).empty().append($button).append("  " + value);
	  };


	this.psrCol = (tableType == "read") ? [
		{data : 'ftaCd', editor : 'select', selectOptions : psrSelect, className:"htCenter",type : 'autocomplete', width: 200, validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'stdrHs', type : 'text',  width: 120, validator : /(^[\s\S]{0,10}$)/, className:"htCenter"},
		{data : 'endHs', type : 'text' ,  width: 120, className:"htCenter"},
		{data : 'hsVer', type : 'text', className : "htCenter", width: 120, validator : /(^[\s\S]{0,10}$)/, className:"htCenter"},
		{data : 'psrSeq', type : 'numeric'},
		{data : 'seq', type : 'numeric', className:"htCenter", width: 120, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'psrSumry2',  width: 150, type : 'text', validator : /(^[\s\S]{0,100}$)/,  className:"htCenter"},
		{data : 'psrDetail', type : 'text', width: 400, className:"htCenter", renderer: psrInfoRenderer},
		{data : 'preRequest', width: 300,  type : 'text',  className:"htCenter"},
	] : (tableType == "edit") ? [
		{data : 'ftaCd', editor : 'select', selectOptions : psrSelect, className:"htCenter",type : 'autocomplete', width: 200, renderer: psrPkNoneEdit},
		{data : 'stdrHs', type : 'text',  width: 120, validator : /(^[\s\S]{0,10}$)/, className:"htCenter"},
		{data : 'endHs', type : 'text' ,  width: 120, className:"htCenter"},
		{data : 'hsVer', type : 'text', className : "htCenter", width: 120, validator : fn_hsVerCheck, className:"htCenter"},
		{data : 'psrSeq', type : 'numeric'},
		{data : 'perfectPrdct', type : 'text',  width: 150,  className:"htCenter"},
		{data : 'hsChangeStdr', type : 'text',  width: 150, validator : /(^[\s\S]{0,10}$)/,  className:"htCenter"},
		{data : 'changeExclHs', type : 'text',  width: 150, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
		{data : 'deminStdr', type : 'text', width: 150, validator : /(^[\s\S]{0,10}$)/,  className:"htCenter"},
		{data : 'deminRt', width: 150, type : 'numeric'},
		{data : 'bdRt', width: 150, type : 'numeric'},
		{data : 'buRt', width: 150, type : 'numeric'},
		{data : 'mcRt', width: 150, type : 'numeric'},
		{data : 'indrtRt', width: 200, type : 'numeric'},
		{data : 'cnctrRt', width: 170, type : 'numeric'},
		{data : 'processYn', editor : 'select', selectOptions : ['SP', 'NULL'], className : "htCenter", width: 150},
		{data : 'processDtsYn', editor : 'select', selectOptions : ['Y', 'N'], className : "htCenter", width: 180},
		{data : 'spcifyHs', type : 'text', width: 200, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
		{data : 'trgetStdrHs', type : 'text', width: 200, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
		{data : 'rtStdr', type : 'text', width: 200, validator : /(^[\s\S]{0,50}$)/},
		{data : 'addBdRt', width: 150, type : 'numeric'},
		{data : 'addNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter",width: 150,
			className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
		{data : 'originRt', width: 150, type : 'numeric'},
		{data : 'nriginRt', width: 150, type : 'numeric'},
		{data : 'partsRt', width: 180, type : 'numeric'},
		{data : 'seq', type : 'numeric', className:"htCenter", width: 120, validator : function(value, callback){callback(notEmpty(value, 20))}},
		{data : 'psrSumry2',  width: 150, type : 'text', validator : /(^[\s\S]{0,100}$)/,  className:"htCenter"},
		{data : 'psrDetail', type : 'text', width: 400, className:"htCenter", renderer: psrInfoRenderer},
		{data : 'preRequest', width: 300,  type : 'text',  className:"htCenter"},
		{data : 'delYn', editor : 'select', selectOptions : ['Y', 'N'], type : 'autocomplete', className : "htCenter", width: 120, validator : function(value, callback) {callback(selectboxCheck(value,this.selectOptions))}},
	] : [
	    {data : 'ftaCd', editor : 'select', selectOptions : psrSelect, className:"htCenter",type : 'autocomplete', width: 200, validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
	    {data : 'stdrHs', type : 'text',  width: 120, validator : /(^[\s\S]{0,10}$)/, className:"htCenter"},
	    {data : 'endHs', type : 'text' ,  width: 120, className:"htCenter"},
	    {data : 'hsVer', type : 'text', className : "htCenter", width: 120, validator : fn_hsVerCheck, className:"htCenter"},
	    {data : 'psrSeq', type : 'numeric'},
	    {data : 'perfectPrdct', type : 'text',  width: 150,  className:"htCenter"},
	    {data : 'hsChangeStdr', type : 'text',  width: 150, validator : /(^[\s\S]{0,10}$)/,  className:"htCenter"},
	    {data : 'changeExclHs', type : 'text',  width: 150, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
	    {data : 'deminStdr', type : 'text', width: 150, validator : /(^[\s\S]{0,10}$)/,  className:"htCenter"},
	    {data : 'deminRt', width: 150, type : 'numeric'},
	    {data : 'bdRt', width: 150, type : 'numeric'},
	    {data : 'buRt', width: 150, type : 'numeric'},
	    {data : 'mcRt', width: 150, type : 'numeric'},
	    {data : 'indrtRt', width: 200, type : 'numeric'},
	    {data : 'cnctrRt', width: 170, type : 'numeric'},
	    {data : 'processYn', editor : 'select', selectOptions : ['SP', 'NULL'], className : "htCenter", width: 150},
	    {data : 'processDtsYn', editor : 'select', selectOptions : ['Y', 'N'], className : "htCenter", width: 180},
	    {data : 'spcifyHs', type : 'text', width: 200, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
	    {data : 'trgetStdrHs', type : 'text', width: 200, validator : /(^[\s\S]{0,300}$)/,  className:"htCenter"},
	    {data : 'rtStdr', type : 'text', width: 200, validator : /(^[\s\S]{0,50}$)/},
	    {data : 'addBdRt', width: 150, type : 'numeric'},
		{data : 'addNatCd', editor : 'select', selectOptions : natSelect, type : 'autocomplete', className : "htCenter",width: 150,
			className : "htCenter",validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
	    {data : 'originRt', width: 150, type : 'numeric'},
	    {data : 'nriginRt', width: 150, type : 'numeric'},
	    {data : 'partsRt', width: 180, type : 'numeric'},
	    {data : 'seq', type : 'numeric', className:"htCenter", width: 120, validator : function(value, callback){callback(notEmpty(value, 20))}},
	    {data : 'psrSumry2',  width: 150, type : 'text', validator : /(^[\s\S]{0,100}$)/,  className:"htCenter"},
	    {data : 'psrDetail', type : 'text', width: 400, className:"htCenter"},
	    {data : 'preRequest', width: 300,  type : 'text',  className:"htCenter"}
	];
}

//테이블 헤더
function fn_psrTableHeader(){
	 var tableType = $("input:radio[name=psrType]:checked").val();

	this.psrHeader = (tableType == "read") ? [
			[
				colFtaHead,
				{label:colHsHead, colspan:4},
				{label:colPsr, colspan:4}
		    ],[
		    	colFtaNm+'*',colStdrHs,colEndHs,colHsVer+"*",'psrSeq',colSalesOrdr+"*",colPsrSumry,colPsrDetail,colPreRequest
		      ]
		] : (tableType == "edit") ? [
			[
				colFtaHead,
				{label:colHsHead, colspan:4},
				colPerfectPrdct,
				{label:colSpcifyHsHead, colspan:4},
				{label:colValueAdded, colspan:5},
				{label:colProcessHead, colspan:2},
				{label:colAddStnd, colspan:8},
				{label:colPsr, colspan:4},
				'','','','','','','','',''
		    ],[
		    	colFtaNm+'*',colStdrHs,colEndHs,colHsVer+"*",'psrSeq',colPerfectPrdct,colHsChangeStdr,colChangeExclHs,
		    	colDeminStdr,colDeminRt,colBdRt,colBuRt,colMcRt,colIndrtRt,colCnctrRt,colProcessYn,colProcessDtsYn,
		    	colSpcifyHs,colTargetStdrHs,colRtStdr,colAddBdRt,colAddNatCd,colOriginRt,colNriginRt,colPartsRt,colSalesOrdr+"*",colPsrSumry,colPsrDetail,colPreRequest,colDelYn
			  ]
		] : [
			[	  colFtaHead,
		      {label:colHsHead, colspan:4},
		      colPerfectPrdct,
		      {label:colSpcifyHsHead, colspan:4},
		      {label:colValueAdded, colspan:5},
		      {label:colProcessHead, colspan:2},
		      {label:colAddStnd, colspan:8},
		      {label:colPsr, colspan:4},
		      '','','','','','','',''
		    ],[
			   colFtaNm+'*',colStdrHs,colEndHs,colHsVer+"*",'psrSeq',colPerfectPrdct,colHsChangeStdr,colChangeExclHs,
			   colDeminStdr,colDeminRt,colBdRt,colBuRt,colMcRt,colIndrtRt,colCnctrRt,colProcessYn,colProcessDtsYn,
			   colSpcifyHs,colTargetStdrHs,colRtStdr,colAddBdRt,colAddNatCd,colOriginRt,colNriginRt,colPartsRt,colSalesOrdr+"*",colPsrSumry,colPsrDetail,colPreRequest
			   ]
		];
}

//테이블 히든컬럼
function fn_psrTableHidden(){
	var tableType = $("input:radio[name=psrType]:checked").val();

	this.psrHidden = [4];
}

//Table
function fn_handsonGridPsrOprion(col, header, hidden){

	  var tableType = $("input:radio[name=psrType]:checked").val();

	  psrSettings = {
		  columns : col,
		  nestedHeaders: header,
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
    	  colHeaders: true,
    	  manualRowMove : true,
		  manualColumnMove : false,
		  //dropdownMenu : true,
		  contextMenu : (tableType == "enrol") ? ['row_above', 'row_below', '---------', 'undo', 'redo', 'remove_row'] : false,
		  //dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
		  filters : true,
		  readOnly : (tableType == 'read') ? true : false,
		  allowRemoveRow : true,
		 // columnSorting : {indicator : true},
          autoColumnSize : {samplingRatio : 23},
          copyPaste: ( colAuthor == "KORD MGR" || tableType == 'edit') ? true : false,
          mergeCells : false,
          wordWrap : true,
          dataSchema: {deminRt:0, bdRt:0, buRt:0, mcRt:0, indrtRt:0, cnctrRt:0,addBdRt:0, originRt:0 ,nriginRt:0 ,partsRt:0 }
	  };

	return psrSettings;
}

//테이블 타입 변경
function fn_changePsr(type){
	let psrCol = new fn_psrTableCol();
	let psrHeader = new fn_psrTableHeader();
	let psrHidden = new fn_psrTableHidden();
	var col, header, hidden;

	col = psrCol.psrCol;
	header = psrHeader.psrHeader;
	hidden = psrHidden.psrHidden;
	psrHot.updateSettings(fn_handsonGridPsrOprion(col, header, hidden));
	if(type == "edit"){
		$("#psrExcel").hide();
		$("#btnPsrSave").show();
	}else if(type == "enrol"){
		$("#psrExcel").hide();
		$("#btnPsrSave").show();
		}else{
		$("#psrExcel").show();
		$("#btnPsrSave").hide();
	}
	fn_searchPsr();
};

function capturekey() {
	   var pressedKey = String.fromCharCode(event.keyCode).toLowerCase();
	   if (event.ctrlKey) {
	       event.returnValue = false;
	   }
}

//PSR 상세정보
function fn_callPopPsrInfo(val){
	$("#psrInfoPop").modal("show");
	$("#psr_Info").css("word-break", "break-all");

	var pData = {};
	pData["srch10"] = val;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/base/selectPsrDetail.do",
		data : pData,
		acync: false,
		dataType: "json",
        success : function(data) {
        	$("#psr_Info").empty();
        	$("#psr_Info").append(data.resultList[0].psr);
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
