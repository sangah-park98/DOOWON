var geneHot;
var geneIndex = 9999;
var geneScrollTp = true;
var geneResultHot;



$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

	 
	var day = 2; 
	var date = new Date();
	var month = date.getMonth();

	var today = new Date().toISOString().substring(0, 10).replace(/-/g, '/');
	var mtoday;

	var currentDate = new Date();
	currentDate.setMonth(currentDate.getMonth() - 3);
	currentDate.setDate(currentDate.getDate() + 1);
	mtoday = currentDate.toISOString().substring(0, 10).replace(/-/g, '/');

	const radioButtons = document.querySelectorAll('input[name="gene_srch1"]');
	const rptDate1Input = document.querySelector('input[name="generptDate1"]');
	const rptDate2Input = document.querySelector('input[name="generptDate2"]');

	function updateMtoday(event) {
	  var selectedValue = event.target.value;
	  var monthsToSubtract = parseInt(selectedValue);
	  var selectedDate = new Date(rptDate2Input.value);
	  
	  var updatedDate = new Date(selectedDate.setMonth(selectedDate.getMonth() - monthsToSubtract));
	  // +2일 추가
	  updatedDate.setDate(updatedDate.getDate() + day);
	  
	  var formattedDate = updatedDate.toISOString().substring(0, 10).replace(/-/g, '/');
	  mtoday = formattedDate;
	  rptDate1Input.value = mtoday; 
	  console.log('Updated mtoday:', mtoday);
	}

	radioButtons.forEach((radioButton) => {
	  radioButton.addEventListener('change', updateMtoday);
	});

	radioButtons.forEach((radioButton) => {
	  if (radioButton.value === '03') {
	    radioButton.checked = true;
	    rptDate1Input.value = mtoday; 
	  }
	});

	rptDate2Input.addEventListener('change', updateMtoday); 

	$("input[name=generptDate2]").val(today);
	
	  fn_geneExcelSrch("01");
	$("select#aligngeneResult option").remove();

	 fn_searchResultOption1(true);
	 fn_searchResultOption2(false);
	 fn_searchResultOption3(false);
	 fn_searchResultOption4(false);
	
		$("#gene_input8").hide();
		$("#gene_input9").hide();
		$("#gene_input10").hide();
		$("#gene_input11").hide();

	 fn_searchgeneResult();

	 
	 
	 var resultElement = document.querySelector('#geneResultTable');
	 var resultElementContainer = resultElement.parentNode;
	 resultSettings = fn_geneResult1() ;
	 geneResultHot = new Handsontable(resultElement, resultSettings);
	 
	  
	 fn_regScroll(); //이벤트 등록
	


});

function fn_regScroll(){
	 $("#geneResultTable .wtHolder").scroll(function(){
		  var scrollTop = $("#geneResultTable .wtHolder").scrollTop();
		  var countPerPage = $("#genePageCnt option:selected").val();
		  var rowHeight = geneResultHot.getRowHeight();
		 
		  
		  var addCnt = 770;
		  if(countPerPage == "50"){
			  addCnt = 770;
		  }else if(countPerPage == "100"){
			  addCnt = 2020;
		  }else if(countPerPage == "200"){
			  addCnt = 3270;
		  }else if(countPerPage == "500"){
			  addCnt = 4520;
		  }

		  console.log("123123  / " + countPerPage+" / " + addCnt + " / " + geneScrollTp + " / " + geneIndex + " / " + scrollTop);
		  if(geneScrollTp && geneIndex != 9999 && scrollTop >= (countPerPage * geneIndex * rowHeight) + addCnt){
			  fn_geneScroll();
		  }
	});
}
function fn_geneScroll() {
	console.log("123");
	fn_loading(true);
	geneScrollTp = false;
	geneIndex++;

	$.ajax({
		type : "POST",
		url : "/rpt/selectgeneresult.do",
		data : fn_setSearchFormResult(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			var getData = geneResultHot.getSourceData();
			var meargeJson = getData.concat(data.resultList);
			geneResultHot.loadData(meargeJson);
			geneScrollTp = true;
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
		fn_setSearchFormResult();
    }
}
function fn_clearGene() {

};
//이벤트등록

//$("body").on("keydown", function(){
//	if (window.event.keyCode == 13 && $("#tabs-originjdgmnt").hasClass("active")) {
//		fn_searchJudge();
//	}
//})

//검색구분
$("select[name=geneResultType]").change(function(){
	  console.log($(this).val());
	  fn_changegeneResultType($(this).val());
	  fn_geneExcelSrch($(this).val());
	  fn_clearGene();
});

$("input[name=preSeq]").change(function(){
	  alert($(this).val());
});




//정렬항목
$("select[name=aligngeneResult]").change(function(){ fn_searchgeneResult();});
//row 수
$("select[name=genePageCnt]").change(function(){fn_searchgeneResult();});

function fn_callPopGene(target, row, col) {
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
			$("#gene_srch2").val(data.cd);
		} else if(data.type == "partnCd"){
			$("#gene_srch10").val(data.cd);
		} else if(data.type == "partnItemCd"){
			$("#item_srch12").val(data.cd);
		} else if(data.type == "partnCd1"){
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		} else {
			itemHot.setDataAtCell(data.row, data.col, data.cd);
		}
	});
};
function fn_clearGene() {

	//기간
	var Radiobutton = document.querySelectorAll('input[name="gene_srch1"]');
	for(var i = 0;i <Radiobutton.length; i++){
		Radiobutton[i].checked = (Radiobutton[i].value==="03");
	}
	
	//현재날짜
	var generptDate2 = document.querySelector('input[name="generptDate2"]');
	var today = new Date().toISOString().substring(0, 10).replace(/-/g, '/');
	generptDate2.value = today;
	// 현재날자 -3개월+1일
	var generptDate1 = document.querySelector('input[name="generptDate1"]');
	var currentDate = new Date();
	currentDate.setMonth(currentDate.getMonth() - 3);
    currentDate.setDate(currentDate.getDate() + 1);
    var formattedDate = currentDate.toISOString().substring(0, 10).replace(/-/g, '/');
    generptDate1.value = formattedDate;

	
	//psr(판정)
	var gene_srch13 = document.querySelector('#gene_srch13');
	if(gene_srch13){
		gene_srch13.value = "";
	}
	
	//협정명
	var gene_srch5 = document.querySelector('#gene_srch5')
	if(gene_srch5){
		gene_srch5.value = "";
	}
	
	$("input[name=itemCd]", document.geneResultHot).val("");
	$("input[name=invoiceNo]", document.geneResultHot).val("");
	$("input[name=hsCd]", document.geneResultHot).val("");
	$("input[name=salesNo]", document.geneResultHot).val("");
	$("#gene_srch5", document.geneResultHot).val("");
	$("input[name=jdgPsr]",document.geneResultHot).val("");
	$("input[name=docuFileNmR]", document.geneResultHot).val("");
	$("input[name=vndrCd]", document.geneResultHot).val("");
	
};

function fn_geneExcelSrch(type){
	console.log("111 : " + type);
	var today = new Date();
	var year = today.getFullYear();
	var month = (today.getMonth() + 1).toString().padStart(2, '0');
	var day = today.getDate().toString().padStart(2, '0');
	var formattedDate = year + '-' + month + '-' + day;
	
	$("#searchType").val($("select[name=geneResultType]").val());
	if(type == '01'){
		$("#geneExTit").val("report");
		$("#geneExCol").val(String([plntCd, jdgmntDt,buyrNo,docuInvoiceNo,colItemCd,itemNm, colHsCd, colFtaCd, psrSumryR, psrInfoR+","]));						
		$("#geneExCd").val("plntCd,issuDt,salesNo,invoiceNo,itemCd,prdctVnm,hsCd,ftaCd,psrSumry2,psrInfo2,");
		$("#geneExType").val("text,text,text,text,text,text,text,text,text,text,");
	}else if(type == '02'){
		$("#geneExTit").val("report");
		$("#geneExCol").val(String([plntCd,docuFileNmR,issueDt,colFtaCd,buyrNm,psrInfoR,invoiceNo,salesNo,salesDt,customExpNo,colItemCd,prdctNm,colHsCd,salesQty,salesUnt,salesPrice,crrncyUnt+","]));
		$("#geneExCd").val("plntCd,docuFileNm,issuDt,ftaCd,buyrNm,psrInfo2,invoiceNo,salesNo,salesDt,customExpNo,itemCd,prdctVnm,hsCd,salesQty,baseUnt,salesPrice,crrncyUnt,");
		$("#geneExType").val("text,text,text,text,text,text,text,text,text,text,text,text,text,double,text,double,text,");
	}else if(type == '03'){
		$("#geneExTit").val("report");
		$("#geneExCol").val(String([plntCd,colbuyrNm,colFtaCd,issue,items,ftaPrice+","]));
		$("#geneExCd").val("buyrNm,ftaCd,issue,item,totPrice,");
		$("#geneExType").val("text,text,floatString,floatString,floatString,");
	}else if(type == '04'){
		$("#geneExTit").val("report");
		$("#geneExCol").val(String([plntCd,colvndrCd,colItemCd,itemNm,colFtaCd,reqNumber,recNumber,uncollectNumber,recRate,rate+","]));
		$("#geneExCd").val("plntCd,vndrCd,itemCd,prdctVnm,ftaCd,cnt1,cnt2,cnt3,cnt4,orgnRate,");
		$("#geneExType").val("text,text,text,text,text,floatString,floatString,floatString,floatString,floatString,");
	}
	
}


function fn_changegeneResultType(type){
	$("select#aligngeneResult option").remove();

	if(type == "01"){
		$("#gene_input2").show();
		$("#gene_input3").show();
		$("#gene_input4").show();
		$("#gene_input5").show();
		$("#fta").show();
		$("#psrInfoR").show();
		$("#gene_input6").show();
		$("#gene_input7").show();
		$("#gene_input8").hide();
		$("#gene_input9").hide();
		$("#gene_input10").hide();
		$("#separator1").show();
		$("#separator2").show();
		$("#gene_input11").hide();
		$("#gene_input12").show();
		fn_searchResultOption1(true);
		fn_searchResultOption2(false);
		fn_searchResultOption3(false);
		fn_searchResultOption4(false);
		geneResultHot.updateSettings(fn_geneResult1());
	}else if(type == "02"){
		$("#gene_input2").show();
		$("#gene_input3").show();
		$("#gene_input4").show();
		$("#gene_input5").show();
		$("#fta").show();
		$("#psrInfoR").hide();
		$("#gene_input6").hide();
		$("#gene_input7").hide();
		$("#gene_input8").show();
		$("#gene_input9").hide();
		$("#gene_input10").hide();
		$("#separator1").show();
		$("#separator2").show();
		$("#gene_input11").show();
		$("#gene_input12").hide();
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		fn_searchResultOption3(false);
		fn_searchResultOption4(false);
		geneResultHot.updateSettings(fn_geneResult2());
	}
  else if(type == "03"){
		$("#gene_input2").hide();
		$("#gene_input3").hide();
		$("#gene_input4").hide();
		$("#gene_input5").hide();
		$("#fta").hide();
		$("#psrInfoR").hide();
		$("#gene_input6").show();
		$("#gene_input7").hide();
		$("#gene_input8").hide();
		$("#gene_input9").show();
		$("#gene_input10").hide();
		$("#separator1").show();
		$("#separator2").hide();
		$("#gene_input11").hide();
		fn_searchResultOption1(false);
		fn_searchResultOption2(false);
		fn_searchResultOption3(true);
		fn_searchResultOption4(false);
		geneResultHot.updateSettings(fn_geneResult3());
}
else {
	$("#gene_input2").hide();
	$("#gene_input3").show();
	$("#gene_input4").hide();
	$("#gene_input5").hide();
	$("#fta").show();
	$("#psrInfoR").hide();
	$("#gene_input6").hide();
	$("#gene_input7").hide();
	$("#gene_input8").hide();
	$("#gene_input9").hide();
	$("#gene_input10").show();
	$("#separator1").show();
	$("#separator2").hide();
	$("#gene_input11").hide();
	$("#gene_input12").hide();
	fn_searchResultOption1(false);
	fn_searchResultOption2(false);
	fn_searchResultOption3(false);
	fn_searchResultOption4(true);
	geneResultHot.updateSettings(fn_geneResult4());
}
	

	fn_searchgeneResult();
}
function fn_setSearchFormResult(){
	var sData = {};
	
	var gridType = $("select[name=geneResultType]").val() ;
	if (gridType=="01") {
		sData["srch1"] =$("input[name=invoiceNo]", document.geneResultHot).val();
		sData["srch2"] =$("input[name=itemCd]", document.geneResultHot).val();
		sData["srch3"] =$("input[name=hsCd]", document.geneResultHot).val();
		sData["srch3"] = sData["srch3"].replace(/[^0-9]/g, "");
		sData["srch4"] =$("input[name=salesNo]", document.geneResultHot).val();
		sData["srch5"] =$("#gene_srch5", document.geneResultHot).val();
		sData["srch6"] =$("input[name=geneDate1]", document.geneResultHot).val();
		sData["srch7"] =$("input[name=geneDate2]", document.geneResultHot).val();
		sData["srch12"] =$("input[name=jdgPsr]",document.geneResultHot).val();
		sData["srch13"] =$("#gene_srch13",document.geneResultHot).val();
	} else if (gridType=="02") {
		sData["srch1"] =$("input[name=itemCd]", document.geneResultHot).val();
		sData["srch2"] =$("input[name=hsCd]", document.geneResultHot).val();
		sData["srch2"] = sData["srch2"].replace(/[^0-9]/g, "");
		sData["srch11"] =$("input[name=docuFileNmR]", document.geneResultHot).val();
		sData["srch3"] =$("input[name=invoiceNo]", document.geneResultHot).val();
		sData["srch4"] =$("#gene_srch5", document.geneResultHot).val();
		sData["srch5"] =$("input[name=salesNo]", document.geneResultHot).val();
	}
	 else if (gridType=="03") {
			sData["srch1"] =$("input[name=ftaCd]", document.geneResultHot).val();
			sData["srch2"] =$("input[name=buyrNm]", document.geneResultHot).val();

		}
	 else if (gridType=="04") {
			sData["srch1"] =$("input[name=itemCd]", document.geneResultHot).val();
			sData["srch2"] =$("input[name=vndrCd]", document.geneResultHot).val();
			sData["srch5"] =$("#gene_srch5", document.geneResultHot).val();

		}
	sData["srch10"] = $("select[name=geneResultType]").val();
	sData["alignItem"] = $("#aligngeneResult option:selected").val();
	sData["srch8"] =$("input[name=generptDate1]", document.geneResultHot).val();
	sData["srch9"] =$("input[name=generptDate2]", document.geneResultHot).val();
	sData["recordCountPerPage"] = $("#genePageCnt option:selected").val();
	sData["pageIndex"] = geneIndex;
	return sData;
};
function fn_searchResultOption1(mode){
	if (mode) {

		$("select#aligngeneResult").append("<option value='' selected >"+colOrderby+"</option>"+
				 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
				  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
				  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
				  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
				  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
				  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


	 $('select#aligngeneResult').on('change', function() {
	        
	        var selectedOption = $(this).val(); 
	        fn_searchgeneResult(selectedOption); 
	    });
	}
	}
function fn_searchResultOption2(mode){
	if (mode) {
		


	$("select#aligngeneResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#aligngeneResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchgeneResult(selectedOption); 
    });
}
}
function fn_searchResultOption3(mode){
	if (mode) {


	$("select#aligngeneResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#aligngeneResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchgeneResult(selectedOption); 
    });
}
}
function fn_searchResultOption4(mode){
	if (mode) {


	$("select#aligngeneResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#aligngeneResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchgeneResult(selectedOption); 
    });
}
}
//이벤트 등록끝

function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_searchgeneResult(selectedOption){
	$("#geneSrch10").val($("select[name=geneResultType]").val());
	var rptDate1Input = document.querySelector('input[name="generptDate1"]');
	var rptDate2Input = document.querySelector('input[name="generptDate2"]');
	
	        if (rptDate1Input > rptDate2Input) {
	            alert("종료일이 시작일보다 빠를 수 없습니다."); 
	        
	    }
	geneIndex = 0;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/rpt/selectgeneresult.do",
		data : fn_setSearchFormResult(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	geneResultHot.loadData([]);
        	geneResultHot.loadData(data.resultList);  //핸드슨


        	$("#geneResultCnt").text(data.totCnt); //검색결과 총 갯수*/        	
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
function fn_geneResult1(){
	  var resultPopupElement = document.querySelector('#geneResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:100,readOnly: true},
	      {data : 'issuDt', type : 'text', className : "htCenter",readOnly: true,width:150},
	      {data : 'salesNo', type : 'text', className : "htCenter",width:150,readOnly: true},
	      {data : 'invoiceNo', type : 'text', className : "htCenter",width:150,readOnly: true},
	      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'prdctVnm', type : 'text', className : "htCenter",width:250,readOnly: true},
	      {data : 'hsCd', type : 'text', className : "htCenter",readOnly: true,renderer:function(instance, td, row, col, prop, value, cellProperties) {
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
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'psrSumry2', type : 'text', className : "htCenter",width:350,readOnly: true},   
	      {data : 'psrInfo2', type : 'text', className : "htCenter",width:150,readOnly: true},   
	    ],
	    stretchH : 'all',
	    width : '98%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      
	    plntCd,	
	     jdgmntDt,
	     buyrNo,
	     docuInvoiceNo,
	     colItemCd,
	     itemNm,
	     colHsCd,
	     colFtaCd,
	     psrSumryR,
	     psrInfoR,
	    
	        
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

function fn_geneResultScroll(){


	geneScrollTp = false;
	geneIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/rpt/selectgeneResult.do",
		data : fn_setSearchFormResult(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var getData = geneResultHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);

        	geneResultHot.loadData(meargeJson);   //핸드슨 정보

        	geneScrollTp = true;
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
function fn_geneResult2(){
	  var resultPopupElement = document.querySelector('#geneResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	    	{data : 'plntCd', type : 'text', className : "htCenter",readOnly: true}, 
		      {data : 'docuFileNm', type : 'text', className : "htCenter",readOnly: true,width:170}, 
	      {data : 'issuDt', type : 'text', className : "htCenter",readOnly: true,width:150},
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'buyrNm', type : 'text', className : "htCenter",width:200,readOnly: true},   
	      {data : 'psrInfo2', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'invoiceNo', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'salesNo', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'salesDt', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'customExpNo', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},  
	      {data : 'prdctVnm', type : 'text', className : "htCenter",width:350,readOnly: true},  
	      {data : 'hsCd', type : 'text', className : "htCenter",readOnly: true,renderer:function(instance, td, row, col, prop, value, cellProperties) {
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
	      {data : 'salesQty', type : 'text', className : "htCenter",width:100,readOnly: true},  
	      {data : 'baseUnt', type : 'text', className : "htCenter",width:60,readOnly: true},  
	      {
	    	  data: 'salesPrice',
	    	  type: 'numeric',
	    	  className: "htRight",readOnly: true,width:150,
	    	  renderer: function (instance, td, row, col, prop, value, cellProperties) {
	    	    if (value !== null) {
	    	      const formattedValue = parseFloat(value).toLocaleString(undefined, {
	    	        minimumFractionDigits: 2,
	    	        maximumFractionDigits: 2,
	    	      });
	    	      Handsontable.renderers.TextRenderer.apply(this, [instance, td, row, col, prop, formattedValue, cellProperties]);
	    	    }
	    	  },
	    	},  
	      {data : 'crrncyUnt', type : 'text', className : "htCenter",width:60,readOnly: true},

	    ],
	    stretchH : 'all',
	    width : '98%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	    	
	    plntCd,	
	    docuFileNmR,
        issueDt,
        colFtaCd,
        buyrNm,
        psrInfoR,
        invoiceNo,
        salesNo,
        salesDt,
        customExpNo,
        colItemCd,
        itemNm,
        colHsCd,
        salesQty,
        salesUnt,
        salesPrice+'(VND)',
        crrncyUnt,

	    
	        
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
function fn_geneResult3(){
	  var resultPopupElement = document.querySelector('#geneResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	      {data : 'buyrNm', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'issue', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'item', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'totPrice', type : 'numeric', className: 'htRight',readOnly: true, numericFormat : {pattern : '0,0'}, },  
	    ],
	    stretchH : 'all',
	    width : '98.7%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      	
	     colbuyrNm,
	     colFtaCd,
	     issue,
	     items,
	     ftaPrice,
	        
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
function fn_geneResult4(){
	  var resultPopupElement = document.querySelector('#geneResultTable');

	  var percentRenderer = function (instance, td, row, col, prop, value, cellProperties) {
		    $(td).empty().css("text-align", "center");
		    
		    if (value !== "") {
		        $(td).append(value + "%");
		    } else {
		        $(td).append(value);
		    }
		};
	  resultPopupSettings = {
	    columns : [
	    	 {data : 'plntCd', type : 'text', className : "htCenter",width:70,readOnly: true},
	      {data : 'vndrCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'prdctVnm', type : 'text', className : "htCenter",width:200,readOnly: true},
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'cnt1', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'cnt2', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'cnt3', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'cnt4',type: 'text', className : "htCenter",readOnly: true}, 
	      {data : 'orgnRate',type: 'text', className : "htCenter",readOnly: true, renderer: percentRenderer},
	    ],
	    stretchH : 'all',
	    width : '98%',
	    autoWrapRow : true,
	    height : 500,
	    rowHeights : 25,
	    rowHeaders : true,
	    columnHeaderHeight : 25,
	    colHeaders : [
	      	
	    plntCd,	
	     colvndrCd,
	     colItemCd,
	     itemNm,
	     colFtaCd,
	     reqNumber,
	     recNumber,
	     uncollectNumber,
	     recRate,
	     rate
	        
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
	/*document.getElementById('generatePdfBtn').addEventListener('click', function(event) {
    event.preventDefault(); 

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '');
    xhr.responseType = 'blob';

    var searchData = fn_setSearchFormResult(); 

    xhr.onload = function() {
        if (xhr.status === 200) {
            var blob = new Blob([xhr.response], { type: 'application/pdf' });
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = 'reportPDF.pdf';
            link.click();
        } else {
            console.error('Error:', xhr.status);
        }
    };
    var sData = {};
	sData["srch8"] =$("input[name=generptDate1]", document.geneResultHot).val();
	sData["srch9"] =$("input[name=generptDate2]", document.geneResultHot).val();
    var formData = new FormData();
    formData.append("lang", searchData.lang);
    formData.append("cmpnyCd", searchData.cmpnyCd);
    formData.append("srch8", sData["srch8"]);
    formData.append("srch9", sData["srch9"]);
    console.log(sData["srch8"]);
    xhr.send(formData);
});*/

document.getElementById("reportDownBtn").addEventListener("click", function(event) {
    event.preventDefault(); // 기본 동작 방지

    // FTA기준일
    var url = "/rpt/pdfDownload.do"; // 서버 측 매핑과 일치하는 URL로 설정
    // 데이터 구성
    var sData = {};
    sData["srch8"] = $("input[name=generptDate1]", document.geneResultHot).val();
    sData["srch9"] = $("input[name=generptDate2]", document.geneResultHot).val();
    
   
    // URL에 데이터 매개변수 추가
    url += "?srch8=" + encodeURIComponent(sData["srch8"]) + "&srch9=" + encodeURIComponent(sData["srch9"]);
    window.open(url, "_blank");
   /* var newWindow = window.open(url, "_blank");
    
    setTimeout(function() {
        newWindow.close();
    }, 1000); // 1초 후 닫음
*/
});




