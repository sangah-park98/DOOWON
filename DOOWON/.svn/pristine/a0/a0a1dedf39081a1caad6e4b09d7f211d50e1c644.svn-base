var simlatnHistHot;
var simlatnHistIndex = 9999;
var simlatnHistScrollTp = true;
var simRawMtPopHot;
var simPsrInfoPopHot;
var simJudgeResultHot;

$( document ).ready(function() {

	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var simlatnHistRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		  $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;" onclick="fn_simResultPopCall('+row+')"></i>');
		  $(td).empty().append($button).append("  " + value);
	  };

	  var simlatnHistElement = document.querySelector('#simlatnHistTable');
	  var simlatnHistElementContainer = simlatnHistElement.parentNode;
	  
	  var resultSimPopupElement = document.querySelector('#popSimResultTable');
	  var resultSimPopupElementContainer = resultSimPopupElement.parentNode;
	  resultSimPopupSettings = fn_handsonGridSimResultPopupOption() ;
	  simJudgeResultHot = new Handsontable(resultSimPopupElement, resultSimPopupSettings);

//	  var simPsrInfoPopElement = document.querySelector('#simPsrInfoPopTable');
//	  var simPsrInfoPopElementContainer = simPsrInfoPopElement.parentNode;
//	  simPsrInfoPopHot  = new Handsontable(simPsrInfoPopElement, fn_simPsrInfoPopSettings());
//
//	  var simRawMtPopElement = document.querySelector('#simRawMtPopTable');
//	  var simRawMtPopElementContainer = simlatnHistElement.parentNode;
//	  simRawMtPopHot = new Handsontable(simRawMtPopElement, fn_getSimRawMtPopSettings());

	  var simlatnHistSettings = {
			  columns : [
				  {data : 'simlatnSeq', renderer: simlatnHistRenderer, width: 200},
//				  {data : 'jdgmntTypeNm', type : 'text', width: 130, className : "htCenter"},
				  {data : 'plntCd', type : 'text', width: 150, className : "htCenter"},
				  {data : 'ftaCd', type : 'text',  width: 150, className : "htCenter"},
				  {data : 'jdgmntDt', type : 'text', width: 170, className : "htCenter"},
				  {data : 'jdgmntResultNm', type : 'text', width: 150, className : "htCenter",
					  renderer: function(instance, td, row, col, prop, value, cellProperties) {
							 
						    if (instance.getDataAtCell(row, instance.propToCol('jdgmntResultEe')) === 'E') {
						      $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;"  onclick="fn_simJdgmntResult('+row+')"></i>');
						      $(td).empty().append($button).append("  " + value);
						    } else {
						      Handsontable.renderers.TextRenderer.apply(this, arguments);
						    }
						  }},
				  {data : 'jdgmntResultYn', type : 'text', width: 150, className : "htCenter" },
				  {data : 'itemCd', type : 'text', width: 170, className : "htCenter"},
				  {data : 'itemNm', type : 'text', width: 250},
				  {data : 'hsVer', type : 'text', width: 120, className : "htCenter"},
				  {data : 'hsCd', type : 'text', width: 150, className : "htCenter"},
				  {data : 'salesDt', type : 'text', width: 150, className : "htCenter"},
				  {data : 'salesQty', type : 'text', width: 150, className : "htCenter"},
				  {data : 'salesPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
//				  {data : 'rawmtrlPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
//				  {data : 'localPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},
//				  {data : 'ofshrPrice', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}},


//				  {data : 'psrInfo', type : 'text'}
	    	  ],
	    	  stretchH : 'all',
	    	  width : '98.7%',
	    	  autoWrapRow : true,
	    	  height : 487,
	    	  manualRowResize : true,
	    	  manualColumnResize : true,
	    	  rowHeights : 25,
	    	  rowHeaders : true,
	    	  copyPaste: (colAuthor != "KORD MGR") ? false : true,
	    	  columnHeaderHeight : 25,
	    	  colHeaders : [
	    		  coljudgeSeq,
//	    		  coljudgeType,
	    		  colplntCd,
	    		  colFtaCd,
	    		  coljdgmntDt,
	    		  coljudgeResult,
	    		  coljudgeDetailResult,
	    		  colitemCd,
	    		  colitemNm,
	    		  colhsVer,
	    		  colhsCd,
	    		  colSalesDtOrg,
	    		  colSalesQty,
	    		  colsalesPrice,
//	    		  colrawmtrPrice,
//	    		  colLocalPrice,
//	    		  colOfshrPrice,


//	    		  colpsrOrgInfo
			  ],
			  manualRowMove : true,
			  manualColumnMove : true,
			  contextMenu : false,
		//	  dropdownMenu : ['filter_by_condition', 'filter_operators', 'filter_by_condition2', 'filter_by_value', 'filter_action_bar'],
			  filters : true,
			  readOnly : true,
			  allowRemoveRow : false,
		//	  columnSorting : {
			//	  indicator : true
	      //    },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	  simlatnHistHot = new Handsontable(simlatnHistElement, simlatnHistSettings);

	  //정렬항목
	  $("select[name=alignSimlatnHist]").change(function(){
		  fn_searchSimlatnHist();
	  });

	  //row 수
	  $("select[name=simlatnHistPageCnt]").change(function(){
		  fn_searchSimlatnHist();
	  });

	  $("#simlatnHistTable .wtHolder").scroll(function(){
		  var scrollTop = $("#simlatnHistTable .wtHolder").scrollTop();
		  var countPerPage = $("#simlatnHistPageCnt option:selected").val();
		  var rowHeight = simlatnHistHot.getRowHeight();

		  var addCnt = 790;
		  if(countPerPage == "50"){
			  addCnt = 790;
		  }else if(countPerPage == "100"){
			  addCnt = 2040;
		  }else if(countPerPage == "150"){
			  addCnt = 3290;
		  }else if(countPerPage == "200"){
			  addCnt = 4540;
		  }

		  if(simlatnHistScrollTp && simlatnHistIndex != 9999 && scrollTop >= (countPerPage * simlatnHistIndex * rowHeight) + addCnt){
			  fn_simlatnHistScroll();
		  }
	  });

	  fn_searchSimlatnHist();

});

$("body").on("keydown", function(){
	var focusElement = document.activeElement.localName;
	if(focusElement != "select" && focusElement != "textarea"){
		if (window.event.keyCode == 13 && $("#tabs-simlatnhist").hasClass("active")) {
			fn_searchSimlatnHist();
		}
	}
})

//스크롤
function fn_simlatnHistScroll(){
	if($("input[name=simlatnHistType]:checked").val() == "enrol")
		return;
	simlatnHistScrollTp = false;
	simlatnHistIndex++;

	$.ajax({
		type : "POST",
		url : "/orgn/selectSimlatnHistList.do",
		data : fn_setSimlatnHistForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	var getData = simlatnHistHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);
        	simlatnHistHot.loadData(meargeJson);

        	simlatnHistScrollTp = true;
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
		fn_searchSimlatnHist();
    }
}

//검색
function fn_searchSimlatnHist(){
	simlatnHistIndex = 0;

	var data = fn_setSimlatnHistForm();
	var valid = fn_validateSearchDate(data["srch3"], data["srch4"]);

	if(valid === "fail"){
		data["srch3"] = null;
		data["srch4"] = null;
		$("#simlatnHist_srch3").val("");
		$("#simlatnHist_srch4").val("");
	} else {
		data["srch3"] = $("#simlatnHist_srch3").val();
		data["srch4"] = $("#simlatnHist_srch4").val();
	}


	$.ajax({
		type : "POST",
		url : "/orgn/selectSimlatnHistList.do",
		data : fn_setSimlatnHistForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	simlatnHistHot.loadData([]);
        	simlatnHistHot.loadData(data.resultList);
        	$("#simlatnHistCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_setSimlatnHistForm(){
	var sData = {};
	sData["srch1"] = $("#simlatnHist_srch1").val();
	sData["srch2"] = $("#simlatnHist_srch2").val();
	sData["srch3"] = $("#simlatnHist_srch3").val();
	sData["srch4"] = $("#simlatnHist_srch4").val();
	sData["srch5"] = $("#simlatnHist_srch5").val();
	sData["srch6"] = $("#simlatnHist_srch6").val();
	sData["srch7"] = $("#simlatnHist_srch7").val();
	sData["srch8"] = $("#simlatnHist_srch8").val();
	sData["srch9"] = $("input:radio[name=simlatnHist_srch9]:checked").val();
	sData["srch10"] = $("#simlatnHist_srch10").val();

	sData["alignItem"] = $("#alignSimlatnHist option:selected").val();
	sData["recordCountPerPage"] = $("#simlatnHistPageCnt option:selected").val();
	sData["pageIndex"] = simlatnHistIndex;
	return sData;
};

//검색조건 초기화
function fn_clearSimlatnHist(){
	$("#simlatnHist_srch1").val("");
	$("#simlatnHist_srch2").val("");
	$("#simlatnHist_srch3").val("");
	$("#simlatnHist_srch4").val("");
	$("#simlatnHist_srch5").val("");
	$("#simlatnHist_srch6").val("");
	$("#simlatnHist_srch7").val("");
	$("#simlatnHist_srch8").val("");
	$("input:radio[name=simlatnHist_srch9]")[0].checked = true;
	$("#simlatnHist_srch10").val("");
};

function fn_clearSimlatnHistPop(){
	$("#simlIemCd").val("");
	$("#simlSaleDt").val("");
	$("#simlNatCd").val("");
	$("#simlSaleAmount").val("");
	$("#simlSalePrice").val("");
	$("#simlSalePrice").val("");
	$("select[name=simlPlntCd]").val("");
};

function fn_searchFtaList(nation){
	var data = {};
	data['srch1'] = nation;
	var ftaList = [];

	$.ajax({
		type : "POST",
		url : "/orgn/ftaListSearch.do",
		data : JSON.stringify(data),
		async : false,
		contentType : "application/json; charset=utf-8",
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	if(data.resultList.length != 0 ){
        		for(var i=0; i < data.resultList.length; i++){
            		ftaList.push(data.resultList[i].ftaCd);
            	}
        	} else {
        		ftaList.push('Form B');
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
	return ftaList;
}
function fn_simLoading(type){

	fn_startSimulation(type);
	//fn_loading(false);
}


//---- 판정실행
function fn_startSimulation(type) {//asas 판정시작

	fn_loading(true);
	if( $("#simlIemCd").val() == '' ||  $("#simlIemCd").val() == null ||
		$("#simlNatCd").val() == '' || $("#simlNatCd").val() == null ||
		$("#simlSaleAmount").val() == '' || $("#simlSaleAmount").val() == null ||
		$("#simlSalePrice").val() == '' || $("#simlSalePrice").val() == null ||
		$("select[name=simlPlntCd]").val() == '' || $("select[name=simlPlntCd]").val() == null ||
		$("#simlSaleDt").val().replace(/\//gi, '') == '' || $("#simlSaleDt").val().replace(/\//gi, '') == null ){
		alert(msgNonIsEmpty);
		fn_loading(false);
		return;
	}

	var sData = {};
	sData['itemCd'] = $("#simlIemCd").val();
	sData['salesDtOrg'] = $("#simlSaleDt").val().replace(/\//gi, '');
	sData['exportNation'] = $("#simlNatCd").val();
	sData['salesQty'] =  $("#simlSaleAmount").val();
	sData['salesFobPrice'] = $("#simlSalePrice").val();
	sData['jdgmntType'] = type; //판정 type FTA A  FROMB B
	sData['psrSeq'] = 0;
	sData['salesExwPrice'] = $("#simlSalePrice").val();
	sData['isFirstJdgmnt'] = false;
	sData['plntCd'] = $("select[name=simlPlntCd]").val();
	if(type == 'FA'){
		sData['ftaCd'] = 'FORM B';
		sData['jdgmntType'] = "A";
	} else if(type == 'FB'){
		sData['ftaCd'] = 'FORM B';
		sData['jdgmntType'] = "B";
	}

	judgeIng = false ;
	//var strJudgeData = JSON.stringify(judgeData) ;
	setTimeout(function(){
		$.ajax({
			type : "POST",
			url : "/judge/goSimJudgeInfo.do",
			data : JSON.stringify(sData),
			async: false,
			dataType: "json",
	//		beforeSend : function(xmlHttpRequest){
	//			fn_loading(true);
	//			//xmlHttpRequest.setRequestHeader("AJAX", "true");
	//		},
			contentType : "application/json; charset=utf-8",
	        success : function(data) {
	        	if(data.resultType == "nonPlnt"){
	        		alert(msgSimItemCheck);
	        		return;
	        	}
	//        	$("#judgeProgressbarSts").css("width", "100%");
	//        	$("#judgeProgressbarTxt").text("100");\
	        	console.log('success')
	        	alert(saveSuccess);
	        },
	        error : function(e, textStatus, errorThrown) {
	        	if(e.status == 400){
	        		alert("Your request is up. Please log back in if you wish continue");
	        		location.href = document.referrer;
	        	} else {
		        	console.log(errorThrown);
		        	alert(msgSaveError);
	        	}
	        },
	        complete : function(){
	        	fn_loading(false);
	        }
		});
	}, 0);

	$("#simlIemCd").val("");
	$("#simlSaleDt").val("");
	$("#simlNatCd").val("");
	$("#simlSaleAmount").val("");
	$("#simlSalePrice").val("");
	$("#simlSalePrice").val("");
	$("select[name=simlPlntCd]").val("");
	$(".close").trigger("click");
	fn_searchSimlatnHist();
}



//테이블팝업 호출
function fn_callPopSimlatnHist(target){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
	strFrom = "ITEM_INFO";
	strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
	strOrderby = "ITEM_CD";
	strIf1 = "ITEM_CD";
	strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	type = target;
	$("#exampleModalCenterTitleCmmn").text(colitemCd);
	var condition = {type :"tableCd",
			         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
			  	     type : type};

	fn_showCmmnPopup(condition, function(data){
		$("#simlatnHist_srch7").val(data.cd);
	});

};

//판정상세팝업
function fn_callPopJudgeDetail(){

	$("#simlatnHistPop").modal("show");
	setTimeout(function(){popPsrHot.render()}, 200);
	setTimeout(function(){popRawMtrlHot.render()}, 200);

};

//시뮬레이션판정
function fn_simulJudge(){
	$("#simulPop").modal("show");
};

//시뮬레이션 판정 팝업 아이템 팝업 창
function fn_callPopItem(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	//아이템 조회
	if(target == "simlIemCd" || target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
	}

	type = target;

	var condition = {type :"tableCd",
	         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
	  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "simlIemCd"){
			$("#simlIemCd").val(data.cd);
		}
	});
	$("#exampleModalCenterTitleCmmn").text(colitemCd);
};

//시뮬레이션 판정 팝업 아이템 팝업 창
function fn_callPopNat(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	strSearch = (colLang == "en") ? "DISTINCT(CMMN_CD) AS CD, CMMN_NM_EN AS CD_NM" : (colLang == "vt") ? "DISTINCT(CMMN_CD) AS CD, CMMN_NM_VN AS CD_NM" : "DISTINCT(CMMN_CD) AS CD, CMMN_NM_KR AS CD_NM";
	strFrom = "CMMN_CD";
	strWhere = "GRP_CD ='NATION' AND DEL_YN = 'N'";
	strOrderby = "CMMN_CD";
	strIf1 = "CMMN_CD";
	strIf2 = (colLang == "en") ? "CMMN_NM_EN" : (colLang == "vt") ? "CMMN_NM_VN": "CMMN_NM_KR";

	type = target;

	var condition = {type :"tableCd",
	         search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2,
	  	     type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		if(data.type == "simlNatCd"){
			$("#simlNatCd").val(data.cd);
		}
	});
};

$(document).mousedown(function(e){
	if(e.target.name == "siml1_date" || e.target.name == "siml2_date"){
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



//팝업 정보 조회
function fn_simResultPopCall(row){

	if(simlatnHistHot.getDataAtCell(row, 1) == colMerchJudge){
		$("#psrDtl").hide();
	} else {
		$("#psrDtl").show();
	}

	var jData = {};

	jData['srch2'] = simlatnHistHot.getDataAtCell(row, 0);
	jData['srch1'] = simlatnHistHot.getDataAtCell(row, 2);
	$("#sim_detail_ftaCd").text(simlatnHistHot.getDataAtCell(row, 2));
	$("form[name=judge_resultDetail]").find("input[name=itemNm]").val(simlatnHistHot.getDataAtCell(row, 7))
	$("form[name=judge_resultDetail]").find("input[name=itemCd]").val(simlatnHistHot.getDataAtCell(row, 6))
	$("form[name=judge_resultDetail]").find("input[name=hsCd]").val(simlatnHistHot.getDataAtCell(row, 9))
	$("form[name=judge_resultDetail]").find("input[name=salesDt]").val(simlatnHistHot.getDataAtCell(row, 10))
	$("form[name=judge_resultDetail]").find("input[name=salesQty]").val(simlatnHistHot.getDataAtCell(row, 11))
	$("form[name=judge_resultDetail]").find("input[name=judgeDt]").val(simlatnHistHot.getDataAtCell(row, 3))
	$("form[name=judge_resultDetail]").find("input[name=salesPriceFob]").val(simlatnHistHot.getDataAtCell(row, 12))

	$.ajax({
		type:"POST",
		url: "/orgn/selectSimlatnHistDetail.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			console.log(data);
			$("#simResultPop").modal();
//			$("#psrChange").attr("data-seq", data.jdgBaseInfo["simlatnSeq"]);
//			$("#psrChange").attr("data-psr", data.jdgBaseInfo["psrSeq"]);
			//currentJdgmntSeq = 0 ;
			//dokadoka
			//fn_simBaseData(data.jdgBaseInfo);
			// psr 그리드
			fn_simPsrPop(data.psrDetail) ;
			//원재료 그리드
			fn_simRawMtPop(data.rawItemDetail) ;
			var yn = "";
			for(var i=0;i<data.psrDetail.length;i++){
				if(data.psrDetail[i].jdgmntResult == "Y"){
					yn = "Y";
					break;
				} else if(data.psrDetail[i].jdgmntResult == "N"){
					yn = "N";
				}
			}
			if(simlatnHistHot.getDataAtCell(row, 5) == colOrigin){
				$("#sim_detail_jdgmntResultYn").html("<span class='badge badge-success m-2'>"+colOrigin+"("+colSuccessJdg+")</span>")
			} else if(simlatnHistHot.getDataAtCell(row, 5) == colNrigin){
				$("#sim_detail_jdgmntResultYn").html("<span class='badge badge-danger m-2'>"+colNrigin+"("+colSuccessJdg+")</span>")
			} else {
				$("#sim_detail_jdgmntResultYn").html("<span class='badge badge-danger m-2'>"+colDiabledCnt+"("+simlatnHistHot.getDataAtCell(row, 4)+")</span>")
			}


		},
		error:function(e, textStatus, errorThrown){
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
        		console.log(errorThrown);
        	}
		}
	}) ;
}



function fn_getSimRawMtPopSettings(){


	function fn_checkRenderer(instance, td, row, col, prop, value, cellProperties) {
		    Handsontable.renderers.TextRenderer.apply(this, arguments);
		    //선택여부
			var checkedVal = "";
			var orignYn  = "N";
		    var  cnt =  simRawMtPopHot.countSourceRows() ;

			if (row >=0 && simRawMtPopHot.getDataAtCell(row,0) == "1" ) {checkedVal = " checked ";}

			if (row >=0 && simRawMtPopHot.getDataAtCell(row,7) == "Y" ) {orignYn = "Y";}

		    //if (!isNaN(cnt)  ) return ;   //마지막행에는 체크박스 없앰
		    if (isNaN(cnt)) return ;

		    cnt = cnt -1 ;
		    if (cnt != row) {
		    	if (orignYn =="N")
		    	   td.innerHTML = "<input type=checkbox  readonly name=judgeRawMt onclick=fn_simRawMtrlSelectOne("+row+") "+ checkedVal + " value='"+value+"'>" ;
		    	else
		    		td.innerHTML = "" ;
		    } else                 td.innerHTML =  "total " ;
	}

	var simRawMtPopSettings = {
			  columns : [
				  {data : 'checkSts', type : 'text', className : "htCenter", renderer: fn_checkRenderer,  editor: false},  //0
				  {data : 'itemCd', className : "htCenter", width: 100,  editor: false},//1
				  {data : 'vndrCd', className : "htCenter", width: 100,  editor: false}, //2
				  {data : 'purchaseNo', className : "htCenter", width: 100,  editor: false},  //3
				  {data : 'hsVer', className : "htCenter", width: 100,  editor: false},//4
				  {data : 'hsCd', className : "htCenter", width: 100,  editor: false},//5
				  {data : 'purchaseDt', className : "htCenter", width: 100,  editor: false},//6
				  {data : 'orignYn', className : "htCenter", width: 100,  editor: false},//8
				  {data : 'hsChangeYn', className : "htCenter", width: 100,  editor: false},//9
				  {data : 'inptAllQy',  type: "numeric", numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//7
				  {data : 'localPrice', type: "numeric",  numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//10
				  {data : 'ofshrPrice', type: "numeric", numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//11
	    	  ],

	    	  colHeaders :[
	    		  		"<a href=#  onclick='fn_judgeRawAllClick(\"ch\");' >"+colChoice+"</a>",
	    	            colRowMate,
	    	            colVndrCd,
	    	            colPurchaseNo,
	    	            colHsVer,
	    	            colHsCd,
	    	            colPurchaseDt,
	    	            colOriginYn,
						colHsChangedYn,
						colRealQty ,
						colLocalPrice,
						colOfshrPrice,
						'',
						''
	    	      ],

				  allowInsertRow : false,
				  allowInsertColumn : false,
	    	      rowHeaders: true,
		    	  //autoWrapRow : true,
		    	  width : '98%',
		    	  height : 300,
		          hiddenColumns : {copyPasteEnabled : false,indicators : false,columns : [13,14]}
		  };
	return simRawMtPopSettings ;
}


function fn_simPsrInfoPopSettings() {
	var currentSeq = "" ;



	function fn_psrRenderer(instance, td, row, col, prop, value, cellProperties) {
	    Handsontable.renderers.TextRenderer.apply(this, arguments);
	    td.style.color = '';

	    var cellData = instance.getDataAtCell(row,col) ;
	    var cellData2 = instance.getDataAtCell(row,8) ;
	    console.log(cellData2) ;

	    if (cellData == null || cellData == undefined ) return ;
		//td.innerHTML = '<div title="' + cellData2 + '">' + td.innerHTML.slice(0, 64) + '</div>';
		td.innerHTML = '<div title="' + cellData2 + '">' +cellData + '</div>';

       $(td).children().css("text-overflow", "ellipsis").css("overflow", "hidden").css("white-space", "nowrap")


	  }

	function fn_ctcDtsRenderer(instance, td, row, col, prop, value, cellProperties) {
	    var toolTipData = instance.getDataAtCell(row,9) ;

		fn_tooltipRenderer(instance, td, row, col, prop, value, cellProperties, this,arguments,toolTipData) ;
	  }

	function fn_vatDtsRenderer(instance, td, row, col, prop, value, cellProperties) {
	    var toolTipData = instance.getDataAtCell(row,10) ;

		fn_tooltipRenderer(instance, td, row, col, prop, value, cellProperties, this,arguments,toolTipData) ;
	  }

	function fn_addDtsRenderer(instance, td, row, col, prop, value, cellProperties) {
	    var toolTipData = instance.getDataAtCell(row,13) ;

		fn_tooltipRenderer(instance, td, row, col, prop, value, cellProperties, this,arguments,toolTipData) ;
	  }

	function fn_tooltipRenderer(instance, td, row, col, prop, value, cellProperties, obj, arguments, toolTipData){
	    Handsontable.renderers.TextRenderer.apply(obj, arguments);
	    td.style.color = '';

	    var cellData = instance.getDataAtCell(row, col) ;

	    if (cellData == null || cellData == undefined ) return ;
	    if (toolTipData == null || toolTipData == undefined ) return ;

	    //var toolTipText = toolTipData.replace(/\=/g,'\n=');

	    var toolTipText = toolTipData ;

	    console.log(toolTipText) ;

	      td.innerHTML = '<div title="' + toolTipText   + '">' + cellData + '</div>';

	}

	function fn_radioRenderer(instance, td, row, col, prop, value, cellProperties) {
	    Handsontable.renderers.TextRenderer.apply(this, arguments);

	    var checeked = "" ;
	    if (currentSeq == value ) {
	    	checeked = "checked" ;
	    }
	    //선택여부
        td.innerHTML = "<input type=radio readonly name=preSeq id='psrRdo"+row+"' onclick=\"fn_psrChange("+row+","+value+")\"  value="+value+"    "+checeked+">" ;
	  }

	function fn_ctcToolRenderer(instance, td, row, col, prop, value, cellProperties){

		var toolText =  simPsrInfoPopHot.getDataAtCell(row, 7);

		if(toolText == null || toolText == "" || toolText == undefined){
			toolText = "";
		}

		if(value != null && value != ""){
			$(td).empty().append("<p title='"+toolText+"' style='text-align:center; width:100%; margin-bottom:0'>"+value+"</p>")
		} else {
			$(td).empty()
		}
	}

	function fn_vatToolRenderer(instance, td, row, col, prop, value, cellProperties){

		var toolText =  simPsrInfoPopHot.getDataAtCell(row, 8);

		if(toolText == null || toolText == "" || toolText == undefined){
			toolText = "";
		}

		if(value != null && value != ""){
			$(td).empty().append("<p title='"+toolText+"' style='text-align:center; width:100%; margin-bottom:0'>"+value+"</p>")
		} else {
			$(td).empty()
		}
	}

	function fn_dtsToolRenderer(instance, td, row, col, prop, value, cellProperties){

		var toolText =  simPsrInfoPopHot.getDataAtCell(row, 9);

		if(toolText == null || toolText == "" || toolText == undefined){
			toolText = "";
		}

		if(value != null && value != ""){
			$(td).empty().append("<p title='"+toolText+"' style='text-align:center; width:100%; margin-bottom:0'>"+value+"</p>")
		} else {
			$(td).empty()
		}
	}

	var simPsrInfoPopSettings = {
			  columns : [
				  {data : 'psrSumry2', className : "htCenter", width: 130, renderer: fn_dtsToolRenderer},   //1
				  {data : 'jdgmntResult', className : "htCenter", width: 80},//2
				  {data : 'ctcYn', className : "htCenter", width: 200, renderer: fn_ctcToolRenderer},   //3
				  {data : 'vatYn', className : "htCenter", width: 200, renderer: fn_vatToolRenderer}, //4
				  {data : 'pdtYn', className : "htCenter", width: 100},  //5
				  {data : 'woYn', className : "htCenter", width: 100},  //6
				  {data : 'addYn', className : "htCenter", width: 120, renderer: fn_addDtsRenderer},  //7
				  {data : 'ctcDts', className : "htCenter", width: 120, renderer: fn_addDtsRenderer},  //7
				  {data : 'vatDts', className : "htCenter", width: 120, renderer: fn_addDtsRenderer},  //7
				  {data : 'psrDetail', className : "htCenter", width: 120, renderer: fn_addDtsRenderer},  //7

	    	  ],
                                   //0                      , 1                    ,2                   ,3               ,4             ,5             ,6                   7            8
 	    	  colHeaders : [colPrsrSumry, colJdgmntResult,   colCtcDts,colVatDts,colPdtDts,colWoDts,colAddDts, "", "", ""],
		        readOnly: true,
		        width : '99%',
		        height : 100,
		        columnHeaderHeight : 10,
		        rowHeights : 12,
		        manualRowResize : true,
		        manualColumnResize : true,
		        manualRowMove : true,
		        manualColumnMove : false,

	    	    rowHeaders: true,
		        mergeCells : false,
		        allowRemoveRow : false,

		          hiddenColumns : {
		        	  copyPasteEnabled : false,
		        	  indicators : false,
		        	  columns : [7,8,9]
		          }
	  };
	return simPsrInfoPopSettings ;
}

function fn_simPsrPop(data) {
	 $("#simPsrInfoPopTable").empty();   //이전 내용삭제
	  var simPsrInfoPopElement = document.querySelector('#simPsrInfoPopTable');
	  var simPsrInfoPopElementContainer = simPsrInfoPopElement.parentNode;
	  simPsrInfoPopHot  = new Handsontable(simPsrInfoPopElement, fn_simPsrInfoPopSettings());

	   simPsrInfoPopHot.loadData([]);
//	   for(var i=0;i< data.length; i++){
//		   data[i].psrDetail = data[i].psrDetail.replace(/##/gi, " ");
//	   }
	   if(data.length != 0){
		   simPsrInfoPopHot.loadData(data);
	   }

	  setTimeout(function(){simPsrInfoPopHot.render()}, 200);
}

function fn_simRawMtPop(data) {
	// raw 팝업
	 $("#simRawMtPopTable").html("");   //이전 내용삭제
   var simRawMtPopElement = document.querySelector('#simRawMtPopTable');
   var simRawMtPopElementContainer = simRawMtPopElement.parentNode;

   simRawMtPopHot = new Handsontable(simRawMtPopElement, fn_getSimRawMtPopSettings());

   if (data.length >0 ) {
       data =  fn_simSumJdgRawMtPopHot(data) ;  //합계처리
   }

   simRawMtPopHot.loadData([]);
   if(data.length != 0){
	   simRawMtPopHot.loadData(data);
   }


	var lastRow = simRawMtPopHot.countSourceRows() ;

   if (data.length >0 ) {
		var lastRow = simRawMtPopHot.countSourceRows()-1 ;
		simRawMtPopHot.updateSettings({
		      mergeCells: [{row:lastRow , col: 0, rowspan: 1, colspan: 8}]
			});
   }

	setTimeout(function(){simRawMtPopHot.render()}, 200);
}

function fn_simSumJdgRawMtPopHot(data) {
	var sumData  =	{
	   	  rawItemCd:" total :  "
		, inptAllQy: 0
		, localPrice: 0
		, localQty: 0
		, localWght: 0
		, ofshrPrice: 0
		, ofshrQty: 0
		, inputAllQy: 0
		, ofshrWght: 0
	};

	for (var i=0; i<data.length; i++) {
		sumData["inptAllQy"] +=  data[i]["inptAllQy"] ;
		sumData["localPrice"] += data[i]["localPrice"] ;
		sumData["localQty"] += data[i]["localQty"] ;
		sumData["localWght"] += data[i]["localWght"] ;
		sumData["ofshrPrice"] += data[i]["ofshrPrice"] ;
		sumData["ofshrQty"]  += data[i]["ofshrQty"] ;
		sumData["ofshrWght"] +=  data[i]["ofshrWght"] ;
	}
	data.push(sumData);

	return data ;
}

function fn_simBaseData(data){

	$("#sim_detail_ftaCd").html(data.ftaCd);

	$("input[name=itemNm]", document.judge_resultDetail).val(data.itemNm);   //itemcd
	$("input[name=itemCd]", document.judge_resultDetail).val(data.itemCd);   //itemcd
	$("input[name=hsCd]", document.judge_resultDetail).val("["+data.hsVer+"] " + data.hsCd );
	$("input[name=salesDt]", document.judge_resultDetail).val(data.salesDt);
	$("input[name=buyrNm]", document.judge_resultDetail).val(data.buyrNm);
	$("input[name=salesQty]", document.judge_resultDetail).val(data.salesQty);
	$("input[name=judgeDt]", document.judge_resultDetail).val(data.jdgmntDt);
	$("input[name=salesPriceFob]", document.judge_resultDetail).val(data.salesFobPrice);
	$("input[name=psr]", document.judge_resultDetail).val(data.psrInfo2);


	if (data.jdgmntResultYn =="Y") {
		$("#sim_detail_jdgmntResultYn").html("<span class='badge badge-success m-2'>"+msgOrigin+"("+data.jdgmntResultCd+")</span>")
	} else {
		$("#sim_detail_jdgmntResultYn").html("<span class='badge badge-danger m-2'>"+msgNrigin+"("+data.jdgmntResultCd+")</span>")
	}
	//
}


function fn_simRawMtrlSelectOne(row){
	var data = simRawMtPopHot.getSourceData() ;
	if (data[row].checkSts == "0") data[row].checkSts = "1" ;
	else                                           data[row].checkSts = "0" ;

	setTimeout(function(){simRawMtPopHot.render()}, 100);

}

function fn_saveSimRawMtrlData() {

	var sourceData = simRawMtPopHot.getSourceData();
	var targetData = [] ;
	var cnt  = 0 ;
	for (var i = 0; i < sourceData.length-1; i++) {
		var one= sourceData[i] ;
		if (one["checkSts"]=="1") 	{
			targetData.push(sourceData[i]);
			cnt++ ;
		}
	}
	for(var i=0;i< targetData.length; i++){
		targetData[i]['simType'] = 'org';
		targetData[i]['ftaCd'] = $("#sim_detail_ftaCd").text();
	}
	if (cnt==0) {
		alert(msgSelectData);
		return ;
	}

	if(!confirm(msgSaveConfirm)) return;

	$.ajax({
		type : "POST",
		url : "/orgn/saveJudgeRawMtrlReg.do",
		data : JSON.stringify(targetData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				alert(msgSaveSuccess);
				fn_simRawAllClick('reset');
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

function fn_simRawAllClick(mode){

	var data = jdgRawMtPopHot.getSourceData() ;
	for(var i=0; i < data.length; i++){
		if (mode =="reset") data[i].checkSts = "0" ;
		else {
			if (data[i].checkSts =="0") data[i].checkSts = "1" ;
			else data[i].checkSts = "0" ;
		}
	}

	setTimeout(function(){jdgRawMtPopHot.render()}, 200);

	return false ;
}



function fn_simJdgmntResult(row){
	var data = simlatnHistHot.getSourceData();
	var rowData = data[row];
	
	var plntCd = data[row]['plntCd'];
	var simlatnSeq = data[row]['simlatnSeq'];
	var itemCd = data[row]['itemCd'];
	var salesDt = data[row]['salesDt']
	var usedQty = 0;
	
	fn_paramsForSimPopup(data[row]);
	fn_searchSimResultPopup(data[row]) ;	

	document.getElementById('plntCd').value = plntCd;
	document.getElementById('simlatnSeq').value = simlatnSeq;
	document.getElementById('itemCd').value = itemCd;
	document.getElementById('salesDt').value = salesDt;
	
	$("#jdgmntSimResult").modal("show");

}

function fn_paramsForSimPopup(selectedRow){
	var sData = {};

	sData["srch20"] = selectedRow["plntCd"] ;
	sData["srch21"] = selectedRow["simlatnSeq"] ;
	sData["srch22"] = selectedRow["itemCd"] ;
	sData["srch23"] = selectedRow["salesDt"].replace(/\//g, ''); ;
	fn_setJudgeExcelSrch(sData); 
	return sData;
}
function fn_setJudgeExcelSrch(sData){
    $("#judgeSrch1").val(sData["srch20"]); // Set srch20 value to judgeSrch1
    $("#judgeSrch2").val(sData["srch21"]); // Set srch21 value to judgeSrch2
    $("#judgeSrch3").val(sData["srch22"]); // Set srch22 value to judgeSrch3
    $("#judgeSrch4").val(sData["srch23"]); // Set srch23 value to judgeSrch4
}

function fn_searchSimResultPopup(selectedRow){
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectSimJudgeResultList.do",
		data : fn_paramsForSimPopup(selectedRow),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	simJudgeResultHot.loadData([]);
        	simJudgeResultHot.loadData(data.resultList);
			setTimeout(function() {simJudgeResultHot.render()}, 200);
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

function fn_handsonGridSimResultPopupOption(){
	  var resultSimPopupElement = document.querySelector('#popSimResultTable');
	  var resultSimPopupElementContainer = resultSimPopupElement.parentNode;
	  
	  resultPopupSettings = {
	    columns : [
	      {data : 'rawItemCd', type : 'text', className : "htCenter"},
	      {data : 'purchaseNo', type : 'text', className : "htCenter"},
	      {data : 'hsCd', type : 'text', className : "htCenter",
	       renderer: function(instance, td, row, col, prop, value, cellProperties) {
	         if (value && (value.length === 8 || value.length === 6)) {
	        	 if(value.length === 8){
		        	   value = value.slice(0,6) + "-" + value.slice(6);
		           }	        
	           // Insert "-" at the 6th position
	           value = value.slice(0, 4) + "." + value.slice(4);
	          
	         }
	         Handsontable.renderers.TextRenderer.apply(this, arguments);
	       }
	      },    
	      {data : 'useQty', type : 'text', className : "htCenter"},    
	    ],
	    stretchH : 'all',
	    width : '98.7%',
	    autoWrapRow : true,
	    height : 250,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      colRawItemNm,
	      colPurchaseNo,
	      colHsCd,
	      requiredQty     
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : {
	      samplingRatio : 23
	    },
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
