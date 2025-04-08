var delngCostHot;
var delngCostPageIndex = 9999;
var delngCostScrollTp = true;


$( document ).ready(function() {

	var plntSelect = [];
	  plntList = plntList.replace('[','').replace(']','');
	  plntSelect = plntList.split(', ');


	  var delngCostHotElement = document.querySelector('#hanDelng');
	  var delngCosthotElementContainer = delngCostHotElement.parentNode;
	  var delngCost_hotSettings = {
			  columns: [
				  { data: 'manageNo', type: 'numeric', width: 70 },
				  { data: 'plntCd', editor : 'select', selectOptions : plntSelect, className : "htCenter", width: 70, validator: notEmptyLeng20 },
				  { data: 'plntNm', type: 'text', className : "htCenter",  width: 70 },
				  { data: 'itemCd', renderer: 'text', width: 70, validator: notEmptyLeng20, className : "htCenter" },
				  { data: 'itemNm', type: 'text', width: 140 },
				  { data: 'salesYn', editor : 'select', className : "htCenter", selectOptions : ['Sale', 'Buy'],
					  validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
				  { data: 'blYn', editor : 'select',  className : "htCenter",  selectOptions : ['BI', 'INV'],
					  validator : function(value, callback){callback(selectboxCheck(value, this.selectOptions))}},
				  { data: 'localLoadCost', type: 'numeric', numericFormat : {pattern : '0,0.00'} },
				  { data: 'shippingCost', type: 'numeric', numericFormat : {pattern : '0,0.00'} },
				  { data: 'shippingInsu', type: 'numeric', numericFormat : {pattern : '0,0.00'} },
				  { data: 'frTransCost', type: 'numeric', numericFormat : {pattern : '0,0.00'} },
				  { data: 'tax', type: 'numeric', numericFormat : {pattern : '0,0.00'} },
				  { data: 'delYn', editor : 'select', className : "htCenter", selectOptions : ['Y', 'N'], validator : delYnVali},
				  { data:'orgCmpnyCd', type: 'text'},
				  { data:'orgManageNo', type: 'text'},
				  { data:'orgPlntCd', type: 'text'},
				  { data:'orgItemCd', type: 'text'},
				  { data: 'CmpnyCd', type: 'text' }
	    ],
	    stretchH: 'all',
	    width: '98%',
	    autoWrapRow: true,
	    height: 487,
	    manualRowResize: true,
	    manualColumnResize: true,
	  	rowHeights : 25,
	    rowHeaders: true,
	    readOnly : true,
	    columnHeaderHeight : 25,
	    colHeaders: [
	      colManageNo + "*",
	      colPlntCd + "*",
	      colPlntCd + "*",
	      colItemCd + "*",
	      colItemNm + "*",
	      colSalesYn,
	      colBlYn,
	      colLocalLoadCost,
	      colShippingCost,
	      colShippingInsu,
	      colFrTransCost,
	      colTax,
	      colDelYn,
	      'pk1',
	      'pk2',
	      'pk3',
	      'pk4',
	      colCmpnyCd + "*",
	    ],
	    manualRowMove : true,
		manualColumnMove : false,
	    contextMenu: false,
	    filters: true,
	    dropdownMenu: true,
	    allowRemoveRow : true,
		//dropdownMenu : true,
	   // columnSorting: {
	   //   indicator: true
	   // },
	    autoColumnSize: {
	      samplingRatio: 23
	    },
	    mergeCells: false,
	    hiddenColumns : {
	      copyPasteEnabled : false,
	      indicators : false,
	      columns : [1,3,12,13,14,15,16,17]
	    },
	    wordWrap : true,
        afterOnCellMouseDown: function(event, coords, td) {
		  	  var now = new Date().getTime();
		  	  if(!(td.lastClick && now - td.lastClick < 200) || coords.row < 0 ||  coords.col != 8 || itemType != "edit") {
		  		  td.lastClick = now;
		  	    return;
		  	  }

		  	  var condition = {};
		   if(coords.col == 8){ //품목코드 부분

			   /*테이블 팝업 param
	  		    type : tableCd
	  		    search : select절에 들어갈 컬럼 ※반드시 alias 명을 CD, CD_NM으로 주어야 함
	  		    from : 테이블명
	  		    where : 조건절
	  		    orderby : 정렬할 컬럼
	  		    if1 : 코드 조건 대상 컬럼
	  		    if2 : 코드명 조건 대상 컬럼
	  		    row : 테이블 row no
	  		    column : 테이블 column no*/
			   condition = {type :"tableCd",
  				  	   search :"ITEM_CD AS CD, PRDCT_VNM AS CD_NM",
  				  	   from : "ITEM_INFO",
  				  	   where : "CMPNY_CD = '"+colCurrCmpnyCd+"'",
  				  	   orderby : "PLNT_CD",
  				  	   if1 : "ITEM_CD",
  				  	   if2 : "PRDCT_VNM",
  				  	   row : coords.row,
  				  	   column : coords.col
  				  	   };
		  	  }

		  	  fn_showCmmnPopup(condition, function(data){
		  		delngCostHot.setDataAtCell(data.row, data.column, data.cd);
		  	  });
        }
	  };

	  delngCostHot = new Handsontable(delngCostHotElement, delngCost_hotSettings);

      var exportPlugin = delngCostHot.getPlugin('exportFile');

      $("#btnDownload").click(function(){
    	  exportPlugin.downloadFile('csv', {
    		  bom:true,
    		  columnDelimiter: ',',
    	      columnHeaders: true,
    	      exportHiddenColumns: false,
    	      exportHiddenRows: false,
    	      fileExtension: 'csv',
    	      filename: 'TEST-CSV-file_[YYYY]-[MM]-[DD]',
    	      mimeType: 'text/csv',
    	      rowDelimiter: '\r\n',
    	      rowHeaders: false
    	  });
      });

	//테이블 타입 변경
	  $("input[name=delngCostType]").change(function(){
	  fn_changeDelngCostTable($(this).val());
	  });

	  //정렬항목
	  $("select[name=alignDelngCost]").change(function(){
		  fn_searchDelngCost();
	  });

	  //row 수
	  $("select[name=delngCostCnt]").change(function(){
		  fn_searchDelngCost();
	  });

	  $("#hanDelng .wtHolder").scroll(function(){
		  var scrollTop = $("#hanDelng .wtHolder").scrollTop();
		  var countPerPage = $("#delngCostPageCnt option:selected").val();
		  var rowHeight = delngCostHot.getRowHeight();

		  var addDelngCostCnt = 790;
		  if(countPerPage == "50"){
			  addDelngCostCnt = 790;
		  }else if(countPerPage == "100"){
			  addDelngCostCnt = 2040;
		  }else if(countPerPage == "200"){
			  addDelngCostCnt = 3290;
 		  }else if(countPerPage == "500"){
 			  addDelngCostCnt = 4540;
		  }

		  if(delngCostScrollTp && delngCostPageIndex != 9999 && scrollTop >= (countPerPage * delngCostPageIndex * rowHeight) + addDelngCostCnt){
			  fn_searchDelngCostScroll();
		  }
	  });
	  $("#delngCostSave").hide(); //저장버튼 숨김
	  //조회 Function
	  fn_searchDelngCost();
});

//스크롤
function fn_searchDelngCostScroll(){
	delngCostScrollTp = false;
	delngCostPageIndex++;

	$.ajax({
		type : "POST",
		url : "/tran/selectDelngCostList.do",
		data :{},
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	/*for(var i=0; i<data.resultList.length; i++){
        		ftaTreatyHot.getSourceData().push(data.resultList[i]);
        	}*/
        	var getData = delngCostHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	delngCostHot.loadData(meargeJson);

        	delngCosScrollTp = true;
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

//검색
function fn_searchDelngCost(){
	delngCostPageIndex = 0;
	$.ajax({
		type : "POST",
		url : "/tran/selectDelngCostList.do",
		data : fn_searchDelngCostFrom(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        		delngCostHot.loadData([]);
            	delngCostHot.loadData(data.resultList);
            	$("#delngCostCnt").text(data.totCnt).number(true);
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

//검색조건
function fn_searchDelngCostFrom(){
	var sData = {};
	sData["srch1"] = $('#delngCost_srch1').val();
	sData["srch2"] = $('#delngCost_srch2').val();//기준번호
	sData["srch3"] = $('#delngCost_srch3').val(); //아이템코드
	sData["srch4"] = $('#delngCost_srch4').val();//아이템이름 테스트 필요
	sData["srch6"] = $("input:radio[name=delngCost_srch5]:checked").val(); // 배분기준
	sData["srch7"] = $("input:radio[name=delngCost_srch6]:checked").val(); //판매구매
	sData["srch8"] = $("input:radio[name=delngCost_srch7]:checked").val(); //삭제여부
	sData["alignItem"] = $("#alignDelngCost option:selected").val();
	sData["recordCountPerPage"] = $("#delngCostCnt option:selected").val();
	sData["pageIndex"] = delngCostPageIndex;
	return sData;
}



//검색조건 초기화
function fn_clearDelngCost(){
	$("#delngCost_srch1").val("");
	$("#delngCost_srch2").val("");
	$("#delngCost_srch3").val("");
	$("#delngCost_srch4").val("");
	$('input:radio[name="delngCost_srch6"]:radio[value=""]').prop('checked', true);
	$('input:radio[name="delngCost_srch7"]:radio[value=""]').prop('checked', true);
	$('input:radio[name="delngCost_srch8"]:radio[value=""]').prop('checked', true);
};

//save 클릭 이벤트
function fn_saveCheck(){
	if(delngCostHot.getData().length < 1){
		alert(msgSaveEmpty);
		return;
	}
	fn_validate();
};


//정합성 체크
function fn_validate(){

	delngCostHot.validateCells(function(result) {
		if(result){
			fn_saveData();
		}else{
			delngCostHot.render();
			alert(msgSaveCheck);

		}
    });
};

//저장
function fn_saveData(){

	if(!confirm(msgSaveConfirm)){
		return;
	}

	var saveData = delngCostHot.getSourceData();
	$.ajax({
		type : "POST",
		url : "/tran/seveDelngCostList.do",
		data : JSON.stringify(saveData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
        	if(data == "success"){
        		alert(msgSaveSuccess);
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





//테이블 타입 변경
function fn_changeDelngCostTable(type){
	var hiddenPlugin = delngCostHot.getPlugin('hiddenColumns');
	if(type == "edit"){
		delngCostHot.updateSettings({readOnly:false, contextMenu : ['row_above', 'row_below', '---------', 'undo', 'redo']});
		hiddenPlugin.hideColumn(2,4);
		hiddenPlugin.showColumn(1,3,12);
		$("#delngCostSave").show();
		$("#delngCostExcel").hide();


	}else{
		delngCostHot.updateSettings({readOnly:true, contextMenu : false, wordWrap : true});
		hiddenPlugin.hideColumn(1,3,12);
		hiddenPlugin.showColumn(2,4);
		$("#delngCostSave").hide();
		$("#delngCostExcel").show();


	}
	if(type != "single"){
		fn_searchDelngCost();
	}

}

//팝업
function fn_callDelngCostTablePop(param){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;
	//플랜트
	strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
	strFrom = "ITEM_INFO";
	strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
	strOrderby = "ITEM_CD";
	strIf1 = "ITEM_CD";
	strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	type = param;

	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type};

	fn_showCmmnPopup(condition, function(data){
			$("#delngCost_srch4").val(data.cd);
	});

};



