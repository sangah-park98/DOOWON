var orgnCsHot;
var orgnCsIndex = 9999;
var orgnCsScrollTp = true;
var orgnCsResultHot;



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

	const radioButtons = document.querySelectorAll('input[name="check_srch1"]');
	const rptDate1Input = document.querySelector('input[name="rptDate1"]');
	const rptDate2Input = document.querySelector('input[name="rptDate2"]');

	function updateMtoday(event) {
	  var selectedValue = event.target.value;
	  var monthsToSubtract = parseInt(selectedValue);
	  var selectedDate = new Date(rptDate2Input.value);
	  var updatedDate = new Date(selectedDate.setMonth(selectedDate.getMonth() - monthsToSubtract));
	  // +2일 추가 
	  updatedDate.setDate(updatedDate.getDate() + day)
	 
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

	$("input[name=rptDate2]").val(today);

	$("select#alignorgnCsResult option").remove();

	 fn_searchResultOption1(true);
	 fn_searchResultOption2(false);
	 fn_searchResultOption3(false);
	 fn_searchResultOption4(false);
	 fn_searchResultOption5(false);
	 fn_searchResultOption6(false);
	 fn_searchResultOption7(false);
	 
	 fn_checkExcelSrch("01");
		$("#check_input2").show();
		$("#check_input3").show();
		$("#check_input4").hide();
		$("#ftaCheck").hide();
		$("#vndrCheck").hide();
		$("#rvcRate").hide();


	 fn_searchorgnCsResult();


	 
	 
	 var resultElement = document.querySelector('#orgnCsResultTable');
	 var resultElementContainer = resultElement.parentNode;
	 resultSettings = fn_orgnCsResult1() ;
	 orgnCsResultHot = new Handsontable(resultElement, resultSettings);
	 
	 fn_regScrollCheck(); //이벤트 등록

});

function fn_regScrollCheck(){
	 $("#orgnCsResultTable .wtHolder").scroll(function(){
		  var scrollTop = $("#orgnCsResultTable .wtHolder").scrollTop();
		  var countPerPage = $("#orgnCsPageCnt option:selected").val();
		  var rowHeight = orgnCsResultHot.getRowHeight();

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

		  if(orgnCsScrollTp && orgnCsIndex != 9999 && scrollTop >= (countPerPage * orgnCsIndex * rowHeight) + addCnt){
			  fn_orgnCsScroll();
		  }
	});
}
function fn_orgnCsScroll() {

	fn_loading(true);
	orgnCsScrollTp = false;
	orgnCsIndex++;

	$.ajax({
		type : "POST",
		url : "/rpt/selectorgncheck.do",
		data : fn_setSearchFormResult1(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			var getData = orgnCsResultHot.getSourceData();
			var meargeJson = getData.concat(data.resultList);
			orgnCsResultHot.loadData(meargeJson);
			orgnCsScrollTp = true;
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
//이벤트등록

//$("body").on("keydown", function(){
//	if (window.event.keyCode == 13 && $("#tabs-originjdgmnt").hasClass("active")) {
//		fn_searchJudge();
//	}
//})

//검색구분
$("select[name=orgnCsResultType]").change(function(){

	console.log($(this).val());
	 fn_changeorgnCsResultType($(this).val());
	  fn_checkExcelSrch($(this).val());
		fn_clearCheck();
});

$("input[name=preSeq]").change(function(){
	  alert($(this).val());
});
function fn_callPopCheck(target, row, col) {
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
			$("#check_srch3").val(data.cd);
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
function fn_clearCheck() {
	//기간
	var Radiobutton = document.querySelectorAll('input[name="check_srch1"]');
	for(var i = 0;i <Radiobutton.length; i++){
		Radiobutton[i].checked = (Radiobutton[i].value==="03");
	}
	
	//현재날짜
	var rptDate2 = document.querySelector('input[name="rptDate2"]');
	var today = new Date().toISOString().substring(0, 10).replace(/-/g, '/');
	rptDate2.value=today;
	// 현재날자 -3개월+1일
	var rptDate1 = document.querySelector('input[name="rptDate1"]');
	var currentDate = new Date();
	currentDate.setMonth(currentDate.getMonth() - 3);
    currentDate.setDate(currentDate.getDate() + 1);
    var formattedDate = currentDate.toISOString().substring(0, 10).replace(/-/g, '/');
    rptDate1.value = formattedDate;
	
	$("input[name=itemCd]", document.orgnCsResultHot).val("");
	$("input[name=salesNo]", document.orgnCsResultHot).val("");
	$("input[name=itemNm]",document.orgnCsResultHot).val("");
	$("#check_srch5", document.orgnCsResultHot).val("");
};


//정렬항목
//$("select[name=alignorgnCsResult]").change(function(){ fn_searchorgnCsResult();});
//row 수
$("select[name=orgnCsPageCnt]").change(function(){fn_searchorgnCsResult();});

function enterkey() {
	if (window.event.keyCode == 13) {
		fn_setSearchFormResult();
    }
}





function fn_changeorgnCsResultType(type){
	/*$("select#alignorgnCsResult option").remove();*/

	if(type == "01"){
		$("#check_input2").show();
		$("#check_input3").show();
		$("#check_input4").hide();
		$("#ftaCheck").hide();
		  $("#check01").show();
		  $("#checkbtn").show();
			$("#vndrCheck").hide();
			$("#rvcRate").hide();
		fn_searchResultOption1(true);
		fn_searchResultOption2(false);
		fn_searchResultOption3(false);
		fn_searchResultOption4(false);
		fn_searchResultOption5(false);
		fn_searchResultOption6(false);
		fn_searchResultOption7(false);
		orgnCsResultHot.updateSettings(fn_orgnCsResult1());
	}else if(type == "02"){
		$("#check_input2").show();
		$("#check_input3").show();
		$("#check_input4").hide();
		$("#ftaCheck").hide();
		  $("#check01").show();
		  $("#checkbtn").show();
			$("#vndrCheck").hide();
			$("#rvcRate").hide();
		fn_searchResultOption1(false);
		fn_searchResultOption2(true);
		fn_searchResultOption3(false);
		fn_searchResultOption4(false);
		fn_searchResultOption5(false);
		fn_searchResultOption6(false);
		fn_searchResultOption7(false);
		orgnCsResultHot.updateSettings(fn_orgnCsResult2());
	}
  else if(type == "03"){
		$("#check_input2").show();
		$("#check_input3").hide();
		$("#check_input4").show();
		$("#ftaCheck").hide();
	  $("#check01").show();
	  $("#checkbtn").show();
		$("#vndrCheck").hide();
		$("#rvcRate").show();
		fn_searchResultOption1(false);
		fn_searchResultOption2(false);
		fn_searchResultOption3(true);
		fn_searchResultOption4(false);
		fn_searchResultOption5(false);
		fn_searchResultOption6(false);
		fn_searchResultOption7(false);
		orgnCsResultHot.updateSettings(fn_orgnCsResult3());
}
else if(type == "04"){
	$("#check_input2").show();
	$("#check_input3").hide();
	$("#check_input4").show();
	$("#ftaCheck").show();
	  $("#check01").show();
	  $("#checkbtn").show();
		$("#vndrCheck").hide();
		$("#rvcRate").hide();
	fn_searchResultOption1(false);
	fn_searchResultOption2(false);
	fn_searchResultOption3(false);
	fn_searchResultOption4(true);
	fn_searchResultOption5(false);
	fn_searchResultOption6(false);
	fn_searchResultOption7(false);
	orgnCsResultHot.updateSettings(fn_orgnCsResult4());
}
else if(type == "05"){
	$("#check_input2").show();
	$("#check_input3").hide();
	$("#check_input4").show();
	$("#ftaCheck").hide();
	  $("#check01").show();
	  $("#checkbtn").show();
		$("#vndrCheck").hide();
		$("#rvcRate").hide();
	fn_searchResultOption1(false);
	fn_searchResultOption2(false);
	fn_searchResultOption3(false);
	fn_searchResultOption4(false);
	fn_searchResultOption5(true);
	fn_searchResultOption6(false);
	fn_searchResultOption7(false);
	orgnCsResultHot.updateSettings(fn_orgnCsResult5());
}
else if(type == "06"){
	$("#check_input2").show();
	$("#check_input3").hide();
	$("#check_input4").hide();
	$("#ftaCheck").hide();
	  $("#check01").show();
	  $("#checkbtn").show();
		$("#vndrCheck").hide();
		$("#rvcRate").hide();
	fn_searchResultOption1(false);
	fn_searchResultOption2(false);
	fn_searchResultOption3(false);
	fn_searchResultOption4(false);
	fn_searchResultOption5(false);
	fn_searchResultOption6(true);
	fn_searchResultOption7(false);
	orgnCsResultHot.updateSettings(fn_orgnCsResult6());
}
else if(type == "07"){
	$("#check_input2").show();
	$("#check_input3").hide();
	$("#check_input4").hide();
	$("#ftaCheck").hide();
	  $("#check01").show();
	  $("#checkbtn").show();
		$("#vndrCheck").show();
		$("#rvcRate").hide();
	fn_searchResultOption1(false);
	fn_searchResultOption2(false);
	fn_searchResultOption3(false);
	fn_searchResultOption4(false);
	fn_searchResultOption5(false);
	fn_searchResultOption6(false);
	fn_searchResultOption7(true);
	orgnCsResultHot.updateSettings(fn_orgnCsResult7());
}
	

	fn_searchorgnCsResult();
}
function fn_setSearchFormResult1(){
	var sData = {};
	var gridType = $("select[name=orgnCsResultType]").val();
	if (gridType=="01") {
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch3"] =$("input[name=itemNm]", document.orgnCsResultHot).val();

	} else if (gridType=="02"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch3"] =$("input[name=itemNm]", document.orgnCsResultHot).val();
	}
	else if (gridType=="03"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch3"] =$("input[name=salesNo]", document.orgnCsResultHot).val();
		sData["srch7"] =$("#check_srch7", document.orgnCsResultHot).val();
		console.log(sData["srch7"]);
	}
	else if (gridType=="04"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch3"] =$("input[name=salesNo]", document.orgnCsResultHot).val();
		sData["srch5"] =$("#check_srch5", document.orgnCsResultHot).val();
	}
	else if (gridType=="05"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch3"] =$("input[name=salesNo]", document.orgnCsResultHot).val();
	}
	else if (gridType=="06"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
	}
	else if (gridType=="07"){
		sData["srch2"] =$("input[name=itemCd]", document.orgnCsResultHot).val();
		sData["srch6"] =$("input:radio[name=check_srch6]:checked", document.orgnCsResultHot).val();

	}
	sData["srch10"] = $("select[name=orgnCsResultType]").val();
	sData["alignItem"] = $("#alignorgnCsResult option:selected").val();
	sData["srch1"] =$("input[name=rptDate1]").val();
	sData["srch4"] =$("input[name=rptDate2]").val();
	sData["srch7"] =$("#check_srch7").val();
	sData["recordCountPerPage"] = $("#orgnCsPageCnt option:selected").val();
	sData["pageIndex"] = orgnCsIndex;
	return sData;
};
function fn_checkExcelSrch(type){
	console.log("111 : " + type);
	$("#searchType").val($("select[name=orgnCsResultType]").val());
	if(type == '01'){
		$("#checkExTit").val('BOM Update Check');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNmVn,strtDate,dateDiff+","]));						
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,strtDt,dateDiff,");
		$("#checkExType").val("text,text,text,text,int,");
	}else if(type == '02'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,maxCnt,maxSalesDt,maxJdgmntDt,minCnt,minSalesDt,minJdgmntDt+","]));
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,minCnt,minSalesDt,minJdgmntDt,maxCnt,maxSalesDt,maxJdgmntDt,");
		$("#checkExType").val("text,text,text,floatString,floatString,floatString,floatString,floatString,floatString,");
	}else if(type == '03'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,colFtaCd,jdgmntDt,salesNo,psrSumryR,psrInfoR,actualRatio+","]));
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,ftaCd,jdgmntDt,salesNo,psrSumry2,psrInfo2,actualRatio,");
		$("#checkExType").val("text,text,text,text,text,text,text,floatString,floatString,");
	}else if(type == '04'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,colFtaCd,jdgmntDt,salesNo,psrSumryR,psrInfoR,jdgmntResultYn+","]));
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,ftaCd,jdgmntDt,salesNo,psrSumry2,psrInfo2,jdgmntResultYn,");
		$("#checkExType").val("text,text,text,text,text,text,text,floatString,floatString,");
	}else if(type == '05'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,colFtaCd,jdgmntDt,salesNo,psrSumryR,psrInfoR+","]));
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,ftaCd,jdgmntDt,salesNo,psrSumry2,psrInfo2,");
		$("#checkExType").val("text,text,text,text,text,text,text,text,");
	}else if(type == '06'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,minPurchaseDt,minPrice,maxPurchaseDt,maxPrice,diff,diffRate+","]));
		$("#checkExCd").val("plntCd,itemCd,prdctVnm,minPurchaseDt,minPrice,maxPurchaseDt,maxPrice,diff,diffRate,");
		$("#checkExType").val("text,text,text,text,floatString,text,floatString,floatString,floatString,");
	}else if(type == '07'){
		$("#checkExTit").val('reportcheck');
		$("#checkExCol").val(String([plntCd,colItemCd,itemNm,localPrice,localVndr,ofshrPrice,ofshrVndr,rate+","]));
		$("#checkExCd").val("plntCd,rawItemCd,prdctVnm,localPrice,localVndr,ofshrPrice,ofshrVndr,rate,");
		$("#checkExType").val("text,text,text,floatString,floatString,floatString,floatString,floatString,");
}
}
function fn_searchResultOption1(mode){
	if (mode) {

		$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
				 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
				  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
				  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
				  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
				  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
				  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


	 $('select#alignorgnCsResult').on('change', function() {
	        
	        var selectedOption = $(this).val(); 
	        fn_searchorgnCsResult(selectedOption); 
	    });
	}
	}
function fn_searchResultOption2(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
    });
}
}
function fn_searchResultOption3(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+"rate"+"</option>"+
			 "<option value='3' >"+"~3%"+" </option>"+
			  "<option value='4' >"+"~4%"+" </option>"+
			  "<option value='5' >"+"~5%"+" </option>"+
			  "<option value='6' >"+"~6%"+" </option>"+
			  "<option value='7' >"+"~7%"+" </option>"+
			  "<option value='8' >"+"~8%"+" </option>"+
			  "<option value='9' >"+"~9%"+" </option>"+
			  "<option value='10' >"+"~10%"+" </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
        console.log($(this).val());
    });
}
}
function fn_searchResultOption4(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
    });
}
}
function fn_searchResultOption5(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
    });
}
}
function fn_searchResultOption6(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
    });
}
}
function fn_searchResultOption7(mode){
	if (mode) {
	

	$("select#alignorgnCsResult").append("<option value='' selected >"+colOrderby+"</option>"+
			 "<option value='JDGMNT_SEQ' >"+colJdgnmtSeq+"  &uarr; </option>"+
			  "<option value='JDGMNT_SEQ_DESC' >"+colJdgnmtSeq+"  &darr; </option>"+
			  "<option value='ITEM_CD' >"+colItemCd+" &uarr; </option>"+
			  "<option value='ITEM_CD_DESC' >"+colItemCd+"  &darr; </option>"+
			  "<option value='FTA_CD' >"+colFtaCd+" &uarr; </option>"+
			  "<option value='FTA_CD_DESC' >"+colFtaCd+"  &darr; </option>"+
			  "<option value='HS_CD' >"+colHsCd+" &uarr; </option>"+
			  "<option value='HS_DESC' >"+colHsCd+"  &darr; </option>");


 $('select#alignorgnCsResult').on('change', function() {
        
        var selectedOption = $(this).val(); 
        fn_searchorgnCsResult(selectedOption); 
    });
}
}
//이벤트 등록끝

function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_searchorgnCsResult(selectedOption){
	$("#checkSrch10").val($("select[name=orgnCsResultType]").val());
	$("#checkSrch1").val($("input:radio[name=check_srch1]:checked").val());
	console.log($("input:radio[name=check_srch1]:checked").val());
	console.log($("select[name=orgnCsResultType]").val());
	orgnCsIndex = 0;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/rpt/selectorgncheck.do",
		data : fn_setSearchFormResult1(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	orgnCsResultHot.loadData([]);
        	orgnCsResultHot.loadData(data.resultList);  //핸드슨
        	$("#orgnCsResultCnt").text(data.totCnt).number(true); //검색결과 총 갯수
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
function fn_orgnCsResult1(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	    	{data : 'plntCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'prdctVnm', type : 'text', className : "htCenter",width:250,readOnly: true},   
	      {data : 'strtDt',  type : 'text',  className : "htCenter",width:60,readOnly: true},   
	      {data : 'dateDiff', type : 'text', className : "htCenter",width:60,readOnly: true},      
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
	    	colItemCd,
	    	itemNmVn,
	    	strtDate,
	    	dateDiff,
	    
	        
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}

function fn_orgnCsResultScroll(){

	
	orgnCsScrollTp = false;
	orgnCsIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/rpt/selectorgncheck.do",
		data : fn_setSearchFormResult1(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var getData = orgnCsResultHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);

        	orgnCsResultHot.loadData(meargeJson);   //핸드슨 정보
        	
        	orgnCsScrollTp = true;
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
	console.log("getData"+getData);
}
function fn_orgnCsResult2(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	      {data : 'plntCd', type : 'text', className : "htCenter",readOnly: true,width:100},
	      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true,width:50},
	      {data : 'prdctVnm', type : 'text', className : "htCenter",readOnly: true,width:150},
	      {data : 'maxCnt', type : 'text', className : "htCenter",width:100,readOnly: true,width:120},  
	      {data : 'maxSalesDt', type : 'text', className : "htCenter",readOnly: true,width:150},
	      {data : 'maxJdgmntDt', type : 'text', className : "htCenter",readOnly: true,width:200},
	      {data : 'minCnt', type : 'text', className : "htCenter",width:100,readOnly: true,width:120}, 
	      {data : 'minSalesDt', type : 'text', className : "htCenter",readOnly: true,width:150}, 
	      {data : 'minJdgmntDt', type : 'text', className : "htCenter",readOnly: true,width:200}, 
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
	    colItemCd,
	    itemNm,
	    maxCnt,
	    maxSalesDt,
	    maxJdgmntDt,
	    minCnt,
	    minSalesDt,
	    minJdgmntDt,
	         
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
function fn_orgnCsResult3(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:70,readOnly: true},
		      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
		      {data : 'prdctVnm', type : 'text', className : "htCenter",width:200,readOnly: true},
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},
	      {data : 'jdgmntDt', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'salesNo', type : 'text', className : "htCenter",readOnly: true}, 
	      {data : 'psrSumry2', type : 'text', className : "htCenter",readOnly: true},    
	      {data : 'psrInfo2', type : 'text', className : "htCenter",readOnly: true},    
	      {data : 'actualRatio', type : 'text', className : "htCenter",readOnly: true},   
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
	 	    colItemCd,
	 	    itemNm,
	     colFtaCd,
	     jdgmntDt,
	     salesNo,
	     psrSumryR,
	     psrInfoR,
	     actualRatio,
	        
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
function fn_orgnCsResult4(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:70,readOnly: true},
		      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
		      {data : 'prdctVnm', type : 'text', className : "htCenter",width:200,readOnly: true},
	      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'jdgmntDt', type : 'text', className : "htCenter",readOnly: true},   
	      {data : 'salesNo',type: 'text', className : "center",readOnly: true}, 
	      {data : 'psrSumry2', type : 'text', className : "htCenter",readOnly: true},  
	      {data : 'psrInfo2',type: 'text', className : "center",readOnly: true},
	      {data : 'jdgmntResultYn', type : 'text', className : "htCenter",readOnly: true},
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
	 	    colItemCd,
	 	    itemNm,
	     colFtaCd,
	     jdgmntDt,
	     salesNo,
	     psrSumryR,
	     psrInfoR,
	     jdgmntResultYn,
	        
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
function fn_orgnCsResult5(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:70,readOnly: true},
		      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true},
		      {data : 'prdctVnm', type : 'text', className : "htCenter",width:200,readOnly: true},
		      {data : 'ftaCd', type : 'text', className : "htCenter",readOnly: true},   
		      {data : 'jdgmntDt', type : 'text', className : "htCenter",readOnly: true},   
		      {data : 'salesNo',type: 'text', className : "center",readOnly: true}, 
		      {data : 'psrSumry2',type: 'text', className : "center",readOnly: true}, 
		      {data : 'psrInfo2',type: 'text', className : "center",readOnly: true}, 
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
	 	    colItemCd,
	 	    itemNm,
		     colFtaCd,
		     jdgmntDt,
		     salesNo,
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
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
function fn_orgnCsResult6(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:70,readOnly: true},
		      {data : 'itemCd', type : 'text', className : "htCenter",readOnly: true,width:80},
		      {data : 'prdctVnm', type : 'text', className : "htCenter",width:100,readOnly: true},
	      {data : 'minPurchaseDt', type : 'text', className : "htCenter",readOnly: true,width:150},
	      {
	    	  data: 'minPrice',
	    	  type: 'numeric',
	    	  className: "htRight",readOnly: true,
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
	      {data : 'maxPurchaseDt', type : 'text', className : "htCenter",readOnly: true,width:150},   
	      {
	    	  data: 'maxPrice',
	    	  type: 'numeric',
	    	  className: "htRight",readOnly: true,
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
	    	{
		    	  data: 'diff',
		    	  type: 'numeric',
		    	  className: "htRight",readOnly: true,
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
	      {data : 'diffRate', type : 'text', className : "htCenter",readOnly: true},  
 
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
	 	    colItemCd,
	 	    itemNm,
	     minPurchaseDt,
	     minPrice+'(VND)',
	     maxPurchaseDt,
	     maxPrice+'(VND)',
	     diff+'(VND)',
	     diffRate
	        
	    ],
	    manualRowResize : true,
	    manualColumnResize : true,
	    manualRowMove : true,
	    manualColumnMove : false,
	    contextMenu : true,
	    //dropdownMenu : true,
	    filters : true,
	    readOnly : false,
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: 100 
	  };

	  return resultPopupSettings;
	}
function fn_orgnCsResult7(){
	  var resultPopupElement = document.querySelector('#orgnCsResultTable');

	  
	  resultPopupSettings = {
	    columns : [
	     
	    	{data : 'plntCd', type : 'text', className : "htCenter",width:30,readOnly: true},
		      {data : 'rawItemCd', type : 'text', className : "htCenter",readOnly: true},
		      {data : 'prdctVnm', type : 'text', className : "htCenter",width:100,readOnly: true},
	    	{
	    	  data: 'localPrice',
	    	  type: 'numeric',
	    	  className: "htRight",readOnly: true,
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
	    	{data: 'localVndr', type: 'text', className: "htCenter",readOnly: true},
	    	{
	    	  data: 'ofshrPrice',
	    	  type: 'numeric',
	    	  className: "htRight",readOnly: true,
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
	    	{data: 'ofshrVndr', type: 'text', className: "htCenter",readOnly: true},
	    	{data: 'rate', type: 'text', className: "htCenter",readOnly: true},
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
	 	    colItemCd,
	 	    itemNm,
	     localPrice+'(VND)',
	     localVndr,
	     ofshrPrice+'(VND)',
	     ofshrVndr,
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
	    autoColumnSize : true,
	    mergeCells : true,
	    allowInsertRow : false,
	    copyPaste: true,
	    colWidths: function(index) {
	    	  if (index === 0) {
	    	    return 100;
	    	  }
	    	  return null; 
	    	}
	  };

	  return resultPopupSettings;
	}


document.getElementById("reportDownBtn3").addEventListener("click", function(event) {
    event.preventDefault(); // 기본 동작 방지

    // FTA기준일
    var url = "/rpt/pdfDownload3.do"; // 서버 측 매핑과 일치하는 URL로 설정

    // 데이터 구성
    var sData = {};
    sData["srch1"] = $("input[name=rptDate1]", document.orgnCsResultHot).val();
    sData["srch4"] = $("input[name=rptDate2]", document.orgnCsResultHot).val();
    sData["srch7"] =$("#check_srch7", document.orgnCsResultHot).val();
    

    // URL에 데이터 매개변수 추가
    url += "?srch1=" + encodeURIComponent(sData["srch1"]) + "&srch4=" + encodeURIComponent(sData["srch4"])+ "&srch7=" + encodeURIComponent(sData["srch7"]);
    		

    // 새 탭이나 창에서 URL 열기
    window.open(url, "_blank");
	/* var newWindow = window.open(url, "_blank");
	    
	    setTimeout(function() {
	        newWindow.close();
	    }, 3000); // 1초 후 닫음
*/});
