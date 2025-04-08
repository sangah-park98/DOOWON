var judgeHot;
var judgeIndex = 9999;
var judgeScrollTp = true;
var judgeResultHot;

var judgeHistRenderer ;
var originJdgAllSelect = false ;
var originJdgDataIsChecked = false ;
var judgeSts = false ; // fasle  판정미실행  true 판정실행
var judgeDataChkCnt = 0 ;
var judgeFtaCdChkCnt = 0 ;
var resultA = 0 ;
var resultB = 0 ;
var resultC = 0 ;
var judgeCnt = 0 ;
var judgeMngNo = "" ;
var jdgRawMtPopHot;
var judgeIng = true ;
var JdgRawMtDataLength = 1 ;
var currentJdgmntSeq = 0 ;
var goJudgeMode = "all";
var reGoKudgList = null;//재판정 리스트
var jdgType = "";


$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
    $('.datepicker').datepicker("option","dateFormat",calFormat);

	  var judgeElement = document.querySelector('#judgeTable');
	  var judgeElementContainer = judgeElement.parentNode;
	 judgeHot = new Handsontable(judgeElement, fn_originGridOption1());   //첫번째 그리드 그리기
	 
	 //salesDate1 2
	 
	  var date = new Date();
	  var month = date.getMonth();
	  
	  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
	  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'/');
	  
	  $("input[name=salesDate1]").val(mtoday);
	  $("input[name=salesDate2]").val(today);

	 $("select#alignJudge option").remove();

	 fn_searchOption1(true);
	 fn_searchOption2(false);

	 fn_searchJudge();  //검색
	 fn_judge_regScrollEvent(); //이벤트 등록
	 
	 
	 var resultPopupElement = document.querySelector('#popResultTable');
	 var resultPopupElementContainer = resultPopupElement.parentNode;
	 resultPopupSettings = fn_handsonGridResultPopupOption() ;
	 judgeResultHot = new Handsontable(resultPopupElement, resultPopupSettings);
	 
	  

});

function fn_judge_regScrollEvent(){
	 $("#judgeTable .wtHolder").scroll(function(){
		  var scrollTop = $("#judgeTable .wtHolder").scrollTop();
		  var countPerPage = $("#judgePageCnt option:selected").val();
		  var rowHeight = judgeHot.getRowHeight();

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

		  if(judgeScrollTp && judgeIndex != 9999 && scrollTop >= (countPerPage * judgeIndex * rowHeight) + addCnt){
			  fn_judgeScroll();
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
$("input[name=judgeTpType]").change(function(){
	  fn_clearJudge();
	  fn_changeOrgJdgType($(this).val());
});

$("input[name=preSeq]").change(function(){
	  alert($(this).val());
});

$("#btnGoJudgeStart > div > #goJudgeStart").click(function(){//asas판정 시작 버튼
	jdgType = $(this).val();
	if(reGoKudgList === null){
		fn_goJudgeStart("", $(this).val());
	} else if(reGoKudgList !== null){
		fn_goJudgeStart(reGoKudgList, $(this).val());
	}
})

$("body").on("click", "p, h5", function(){
	fn_clearJudge();
	if($(this).attr("id") == "jdgCnt"){
		$("input:radio[name=judgeTpType]:input[value='01']").prop("checked", true);
	} else if($(this).attr("id") == "unCnt"){
		$("input:radio[name=judgeTpType]:input[value='01']").prop("checked", true);
		$("input:radio[name=judgeYn]:input[value='N']").prop("checked", true);
	} else if($(this).attr("id") == "okCnt"){
		$("input:radio[name=judgeTpType]:input[value='02']").prop("checked", true);
		$("input:radio[name=judgeResult]:input[value='Y']").prop("checked", true);
		$("input:radio[name=stsCd]:input[value='20']").prop("checked", true);
	} else if($(this).attr("id") == "noCnt"){
		$("input:radio[name=judgeTpType]:input[value='02']").prop("checked", true);
		$("input:radio[name=judgeResult]:input[value='N']").prop("checked", true);
		$("input:radio[name=stsCd]:input[value='10']").prop("checked", true);
	} else if($(this).attr("id") == "errCnt"){
		$("input:radio[name=judgeTpType]:input[value='02']").prop("checked", true);
		$("input:radio[name=judgeResult]:input[value='E']").prop("checked", true);
		$("input:radio[name=stsCd]:input[value='10']").prop("checked", true);
	} else if($(this).attr("id") == "salesCnt"){
		$("a#sale").trigger("click");
		return;
	}
	fn_changeOrgJdgType($("input:radio[name=judgeTpType]:checked").val());
	 
	fn_searchJudge();
})

//정렬항목
$("select[name=alignJudge]").change(function(){ fn_searchjudge();});
//row 수
$("select[name=judgePageCnt]").change(function(){fn_searchJudge();});


$("#fn_starJudgeFormB").click(function(){
	  var cnt1 = 0 ;
	  var cnt2 =0 ;
	  var data = judgeHot.getData();
	  goJudgeMode = "formb" ;

	  for(var i=0; i<data.length; i++){
		  if ( judgeHot.getDataAtCell(i,0) =="yes"  ) {
			  cnt1++;
			  cnt2++ ;
		  }
	  }

	  if (cnt2==0) {alert(msgSelectJudgeData) ;return ;}

	   judgeFirstDisp(cnt1,cnt2, 'formb');
	   $("#judgePopup").modal({backdrop: 'static', keyboard: false});

});

$("#fn_starJudge").click(function(){

	  var cnt1 = 0 ;
	  var cnt2 =0 ;
	  var returnMsg= "";

	  var data = judgeHot.getData();
	  goJudgeMode = "all" ;
	  var checkData = [];

	  for(var i=0; i<data.length; i++){
		  if ( judgeHot.getDataAtCell(i,0) =="yes"){
			  if( ( judgeHot.getDataAtCell(i,17) ==null ||  judgeHot.getDataAtCell(i,17) == "N")  ) {alert(msgOutsideJdgMsg) ;return ;}
			  cnt1++;
			  cnt2 += judgeHot.getDataAtCell(i,16);
			  
				if((judgeHot.getDataAtCell(i,10) == null||judgeHot.getDataAtCell(i,11)==null)){
					
					if(judgeHot.getDataAtCell(i,10)==null && judgeHot.getDataAtCell(i,11)==null){
						 if(lang =='kr'){
							 returnMsg += msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 의 ITEM, 판매처 "+ msgnoinfo+"\n" ;
						 } else if (lang == 'en'){
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's ITEM, Buyer "+ "\n" ;
						 } else {
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's ITEM, Buyer "+ "\n" ;
						 }
					} else if(judgeHot.getDataAtCell(i,10)==null) {
						 if(lang =='kr'){
							 returnMsg += msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 의 ITEM "+ msgnoinfo+"\n" ;
						 } else if (lang == 'en'){
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's ITEM "+ "\n" ;
						 } else {
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's ITEM "+ "\n" ;
						 }
					} else if(judgeHot.getDataAtCell(i,11)==null) {
						 if(lang =='kr'){
							 returnMsg += msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 의  판매처 "+ msgnoinfo+"\n" ;
						 } else if (lang == 'en'){
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's Buyer "+ "\n" ;
						 } else {
							 returnMsg += msgnoinfo+" of "+msgselected +" "+judgeHot.getDataAtCell(i,7)+" "+ judgeHot.getDataAtCell(i,8) +" 's Buyer "+ "\n" ;
						 }
					}
					//alert(returnMsg);
					
	/*				if(judgeHot.getDataAtCell(i,10)==null)
						returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM "+ msgnoinfo+"\n" ;
					if(judgeHot.getDataAtCell(i,11)==null)
						returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"판매처 "+ msgnoinfo+"\n" ;
					if(judgeHot.getDataAtCell(i,10)==null && judgeHot.getDataAtCell(i,11)==null)
						returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM, 판매처"+ msgnoinfo+"\n" ;
					alert(returnMsg);
					return;
	*/				}
			  
			  
			  
		  }
	//		  if ( judgeHot.getDataAtCell(i,0) =="yes"){
			
		    
/*			if((judgeHot.getDataAtCell(i,10) == null||judgeHot.getDataAtCell(i,11)==null)){
				
				if(judgeHot.getDataAtCell(i,10)==null && judgeHot.getDataAtCell(i,11)==null){
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM, 판매처"+ msgnoinfo+"\n" ;
				} else if(judgeHot.getDataAtCell(i,10)==null) {
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM "+ msgnoinfo+"\n" ;
				} else if(judgeHot.getDataAtCell(i,11)==null) {
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"판매처 "+ msgnoinfo+"\n" ;
				}
				alert(returnMsg);
				return;
				if(judgeHot.getDataAtCell(i,10)==null)
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM "+ msgnoinfo+"\n" ;
				if(judgeHot.getDataAtCell(i,11)==null)
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"판매처 "+ msgnoinfo+"\n" ;
				if(judgeHot.getDataAtCell(i,10)==null && judgeHot.getDataAtCell(i,11)==null)
					returnMsg += msgselected + judgeHot.getDataAtCell(i,8) +"ITEM, 판매처"+ msgnoinfo+"\n" ;
				alert(returnMsg);
				return;
				}*/
			
			  
		//	  }
	  }

	  if (cnt1==0) {alert(msgSelectJudgeData) ;return ;}
	  if (returnMsg != "") {alert(returnMsg) ; return ;}
	  //if (cnt2==0) {alert(msgOutsideNatJdgMsg) ;return ;}

	   judgeFirstDisp(cnt1,cnt2, '');
	   $("#judgePopup").modal({backdrop: 'static', keyboard: false});

});


$("#fn_simulJudge").click(function(){
	  var cnt = 0 ;
	  $("input:checkbox[name=ftaInfo]:checked").each(function(){  cnt++   }  );
});


$("#judgeCheckAll").click(function(){
	 this.checked = !this.checked ;
	  var data = judgeHot.getData();
	  for(var i=0; i< data.length; i++){
		   judgeHot.setDataAtCell(i,0, "yes") ;
	  }
});

//이벤트 등록끝

function fn_originGridOption1(){
	  var  judgeSettings = {
				  columns : [
					  {data : 'judgeCheck', type : 'text', className : "htCenter", width: 60,type: 'checkbox',checkedTemplate: 'yes',uncheckedTemplate: 'no', readOnly:false},  //0
					  {data : 'plntCd', type : 'text', className : "htCenter", width: 100}, //17
					  {data : 'judgeYn', type : 'text', className : "htCenter", width: 150},//1
					  /*{data : 'jdgmntSeq', type : 'text', className : 'htCenter', width: 120},*/
					  {data : 'salesNo', type : 'text', className : "htCenter", width: 100}, //2
					  {data : 'salesOrdr', type : 'text', className : "htCenter", width: 120},//3
					  {data : 'stndrdNo', type : 'text', className : "htCenter", width: 100},//3
					  {data : 'invoiceNo', type : 'text', className : "htLeft", width: 100}, //19
					  {data : 'salesDt', type : 'text', className : "htCenter", width: 120}, //10
					  {data : 'itemCd', type : 'text', className : "htLeft", width: 120},//4
					  {data : 'prdctVnm', type : 'text', className : "htLeft", width: 300},//5
					  {data : 'prdctEnm', type : 'text', className : "htleft", width: 300}, //6
//					  {data : 'buyrId', type : 'text', className : "htLeft", width: 120}, //7
					  {data : 'buyrNm', type : 'text', className : "htLeft", width: 120}, //8
					  {data : 'salesDtOrg', type : 'text', className : "htCenter", width: 120}, //9
//					  {data : 'lcNo', type : 'text', className : "htCenter", width: 120}, //11
//					  {data : 'customExpNo', type : 'text', className : "htCenter", width: 120}, //12
//					  {data : 'sheetNo', type : 'text', className : "htCenter", width: 120}, //13
					  {data : 'exportNation', type : 'text', className : "htCenter", width: 120}, //14
					  {data : 'salesQty', type : 'numeric', width: 120,numericFormat : {pattern : '0,0'}}, //15
					  {data : 'salesPriceFr', type : 'numeric', width: 150, numericFormat : {pattern : '0,0.00'}}, //16
//					  {data : 'salesPrice', type : 'numeric', width: 120, numericFormat : {pattern : '0,0.00'}}, //16
					  {data : 'judgeCnt', type : 'text', className : "htCenter", width: 250}, //18
					  {data : 'ftaCdList', type : 'text', className : "htLeft", width: 150}, //19
					  /*{data : 'judgeYnOrg', type : 'text', className : "htCenter", width: 100}, //20
					  {data : 'spcYn', type : 'text', className : "htCenter", width: 100},
					  {data : 'spcNm', type : 'text', className : "htCenter", width: 100},
					  {data : 'spcAdmitYn', type : 'text', className : "htCenter", width: 100},
					  {data : 'preRequest', type : 'text', className : "htCenter", width: 100}*/
					  
		    	  ],
		    	  stretchH : 'all',
		    	  width : '98%',
		    	  autoWrapRow : true,
		    	  height : 487,
		    	  manualRowResize : true,
		    	  manualColumnResize : true,
		    	  rowHeights : 25,
		    	  rowHeaders : true,
		    	  columnHeaderHeight : 25,
		    	  colHeaders :[
		    	             "<input type='checkbox'  class='checker' id='id_checkJudgeAll' onclick='fn_judgeAllClick(this);' >",
		    	            colPlntCd,
			   	            colJudgeYn,
			   	            /*colJudgeSeq,*/
		    	            colSalesNo,
		    	            colSalesOrdr,
		    	            colStndrdNo,
		    	            colInvoiceNo,
		    	            colSalesDt,
		    	            colItemCd,
		    	            colPrdctVnm,
		    	            colPrdctEnm,
		    	            colBuyrId,
//		    	            colBuyrNm,
		    	            colSalesDtOrg,
//		    	            colLcNo,
//		    	            //colCustomExpNo,
//		    	            colSheetNo,
		    	            colExportNation,
		    	            colSalesQty,
		    	            colSalesPrice+"(VND)",
//		    	            colSalesPrice,
		    	            colJudgCnt,
		    	            colFtaCd,
		    	           /* colJudgYn,
		    	            '가공공정여부',
		    	            '가공공정',
		    	            '불인정공정',
		    	            colPreRequest	*/
		    	        ],

				  manualRowMove : true,
				  manualColumnMove : false,
				  contextMenu : false,
				  //copyPaste: (colAuthor != "KORD MGR") ? false : true,
				  readOnly : true,
				  allowRemoveRow : false,
				//  columnSorting : {
				//	  indicator : true
		        //  },
		          autoColumnSize : {
		        	  samplingRatio : 23
		          },
		          mergeCells : false,
		          allowInsertRow : false,
		          hiddenColumns : {
		        	  copyPasteEnabled : false
		        	  , indicators : false
		        	 , columns : [12/*9,17,21,22,23,24,25*/]
			       	 //, columns : [9]
		          }
		  };
	  return  judgeSettings ;
}

function fn_originGridOption2() {
	   //판정결과그리드 옵션
	  var  judgeResultSettings =	{
			  
				  columns : [
					  {data : 'jdgmntSeq', type : 'numeric',
						  renderer:function (instance, td, row, col, prop, value, cellProperties) {
							  $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;"  onclick="fn_jdgmntResultPopCall('+row+')"></i>');

							  $(td).empty().append($button).append("  " + value);
						  }},
					  {data : 'jdgmntType', className:'htCenter'},
					  {data : 'ftaCd', className:'htCenter'},
					  {data : 'jdgmntDt', type : 'date', className:'htCenter'},
					  {data : 'jdgmntResultYn', className:'htCenter'},					  
					  {data : 'jdgmntResultCd', className:'htCenter' , 
						  renderer: function(instance, td, row, col, prop, value, cellProperties) {
							 
							    if (instance.getDataAtCell(row, instance.propToCol('jdgmntResultEe')) === 'E') {
							      $button = $('<i class="search-icon text-muted i-Magnifi-Glass1" style="cursor:pointer;"  onclick="fn_jdgmntResult('+row+')"></i>');
							      $(td).empty().append($button).append("  " + value);
							    } else {
							      Handsontable.renderers.TextRenderer.apply(this, arguments);
							    }
							  }
					  
							},
					  {data : 'itemCd', className:'htCenter'},
					  {data : 'itemNm', className:'htCenter'},
					  {data : 'invoiceNo', className:'htCenter'},
					  {data : 'salesNo', className:'htCenter'},
					  {data : 'salesOrdr', className:'htCenter'},
					  {data : 'stndrdNo', className:'htCenter'},
					  {data : 'salesDt', className:'htCenter'},
					  {data : 'buyrNm', className:'htCenter'},
					  {data : 'salesQty', className:'htRight'},
					  {data : 'salesFobPrice', className:'htRight'},
					  {data : 'judgeMngNo', clalssName:'htCenter' },
					  {data : 'stsCd', className:'htCenter'},
					  {data : 'jdgmntResultEe', className:'htCenter'},
			
		    	  ],
		    	  colHeaders : [
		    		  colJudgeNo,
		    		  colJudgeType,
		    		  colFtaCd,
		    		  colJudgeDt,
		    		  colJdgmntResult,
		    		  colJdgmntRstStatCd,
		    		  colItemCd,
		    		  colItemNm,
		    		  colInvoiceNo,
		    		  colBuyrNo,
		    		  colBuyrNoOrdr,
		    		  colStndrdNo,
		    		  colSalesDt,
		    		  colBuyrNm,
		    		  colSalesQty,
		    		  colSalesPrice,
		    		  'judgeMngNo',
		    		  colJudgeProcStatus,
		    		  colJdgmntResultEE,

				  ],

		    	  width : '98%',
		    	  autoWrapRow : true,
		    	  height : 487,

				  allowInsertRow : false,
				  allowInsertColumn : false,
				//  columnSorting : {
				//	  indicator : true,
					//  sortEmptyCells: true
				//	},
				  //copyPaste: (colAuthor != "KORD MGR") ? false : true,
		          hiddenColumns : {
		        	  copyPasteEnabled : false,
		        	  indicators : false,
		        	  columns : [16,18]
		          }
			} ;

	  return  judgeResultSettings ;
}

function fn_getJdgRawMtPopSettings(){

	function fn_jdgCheckRenderer(instance, td, row, col, prop, value, cellProperties) {
	    //Handsontable.renderers.TextRenderer.apply(this, arguments);
	    //선택여부
		var checkedVal = "";
//		var orignYn  = "N";
//
//		if (row >=0 && value == "1" ) {checkedVal = " checked ";}
//
//		if (row >=0 && value == "Y" ) {orignYn = "Y";}

	    //if (!isNaN(cnt)  ) return ;   //마지막행에는 체크박스 없앰
	   // if (isNaN(cnt)) return ;

	    	if (value =="N")
	    	   td.innerHTML = "<input type=checkbox style='margin-left: 13px;'  readonly id=rawJdg"+row+" name=judgeRawMt onclick=fn_judgeRawMtrlSelectOne("+row+") "+ checkedVal + " value='"+value+"'>" ;
	    	else
	    		td.innerHTML = "" ;
	       if(value == null || value == undefined)               td.innerHTML =  "<p style='text-align: center;margin: 0;'>total</p>" ;
}

	var jdgRawMtPopSettings = {
			  columns : [
				  {data : 'orignYn', type : 'text', className : "htCenter", renderer: fn_jdgCheckRenderer,  editor: false},  //0
				  {data : 'itemCd', className : "htCenter", width: 100,  editor: false},//1
				  {data : 'vndrCd', className : "htCenter", width: 100,  editor: false}, //2
				  {data : 'purchaseNo', className : "htCenter", width: 100,  editor: false},  //3
				  {data : 'hsVer', className : "htCenter", width: 100,  editor: false},//4
				  {data : 'hsCd', className : "htCenter", width: 100,  editor: false},//5
				  {data : 'purchaseDtOrg', className : "htCenter", width: 100,  editor: false},//6
				  {data : 'inptAllQy',  type: "numeric", numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//7
				  //{data : 'orignYn', className : "htCenter", width: 100,  editor: false},//8
				  {data : 'hsChangeYn', className : "htCenter", width: 100,  editor: false},//9
				  {data : 'localPrice', type: "numeric",  numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//10
				  {data : 'ofshrPrice', type: "numeric", numericFormat: {   pattern: {thousandSeparated: true,mantissa: 2}}, width: 100,  editor: false},//11
				  {data : 'purchaseDt', type: 'text'}, //12
				  {data : 'ftaCd', type: 'text'}, //13
				  {data : 'taxbilNo', type: 'text'}, //14
				  {data : 'customImpNo', type: 'text'} //15
	    	  ],

	    	  colHeaders :[
   	                  "<a href=#  onclick='fn_judgeRawAllClick(\"ch\");' >"+colChoice+"</a>",
	    	            colRowMate,
	    	            colVndrCd,
	    	            colPurchaseNo,
	    	            colHsVer,
	    	            colHsCd,
	    	            colPurchaseDt,
						colRealQty ,
	    	           // colOriginYn,
						colHsChangedYn,
						colLocalPrice,
						colOfshrPrice,
						'',
						'',
						'',
						''
	    	      ],

				  allowInsertRow : false,
				  allowInsertColumn : false,
	    	      rowHeaders: true,
		    	  //autoWrapRow : true,
		    	  width : '100%',
		    	  height : 300,
		          hiddenColumns : {copyPasteEnabled : false,indicators : false,columns : [11,12,13,14]}
		  };
	return jdgRawMtPopSettings ;
}

// checkSts

function fn_judgeRawAllClick(mode){
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

function fn_savejudgeRawMtrlData() {
	var sourceData = jdgRawMtPopHot.getSourceData();
	var targetData = [] ;
	var cnt  = 0 ;
	for (var i = 0; i < sourceData.length-1; i++) {
		var one= sourceData[i] ;
		if ($("#rawJdg"+i).prop("checked")) 	{
			targetData.push(sourceData[i]);
			cnt++ ;
		}
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
				fn_judgeRawAllClick('reset');
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


function fn_judgeRawMtrlSelectOne(row){
//	var data = jdgRawMtPopHot.getSourceData() ;
//	if (data[row].checkSts == "0") data[row].checkSts = "1" ;
//	else                                           data[row].checkSts = "0" ;
//
//	setTimeout(function(){jdgRawMtPopHot.render()}, 100);


}

function fn_psrChange(row,value){
	$("input:radio[name=preSeq]").eq(row).prop("checked", "true")
	$("#psrChange").attr("data-psr", value);
	fn_jdgmntResultPopCall2(currentJdgmntSeq , value);
}

function fn_jdgPsrInfoPopSettings(psrSeq) {
	var currentSeq = psrSeq ;



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

	var jdgPsrInfoPopSettings = {
			  columns : [
				  {data : 'psrSeq', className : "htCenter", width: 40, renderer: fn_radioRenderer},   //0
				  {data : 'psrSumry2', className : "htCenter", width: 130, renderer: fn_psrRenderer},   //1
				  {data : 'jdgmntResult', className : "htCenter", width: 80},//2
				  {data : 'ctcYn', className : "htCenter", width: 200, renderer: fn_ctcDtsRenderer},   //3
				  {data : 'vatYn', className : "htCenter", width: 200, renderer: fn_vatDtsRenderer}, //4
				  {data : 'pdtYn', className : "htCenter", width: 100},  //5
				  {data : 'woYn', className : "htCenter", width: 150},  //6
				  {data : 'addYn', className : "htCenter", width: 150, renderer: fn_addDtsRenderer},  //7
				  {data : 'psrDetail', className : "htCenter", width:1 },  //8
				  {data : 'ctcDts', className : "htCenter", width:1 },  //9
				  {data : 'vatDts', className : "htCenter", width:1 },  //10
				  {data : 'pdtDts', className : "htCenter", width:1 },  //11
				  {data : 'woDts', className : "htCenter", width:1 },  //12
				  {data : 'addDts', className : "htCenter", width:1 }  //13

	    	  ],
                                   //0                      , 1                    ,2                   ,3               ,4             ,5             ,6                   7            8
 	    	  colHeaders : [colChoice,colPrsrSumry, colJdgmntResult,   colCtcDts,colVatDts,colPdtDts,colWoDts,colAddDts,'8','9','10','11','12','13'],
		        readOnly: true,
		        width : '100%',
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
		        	  columns : [8,9,10,11,12,13]
		          }
	  };
	return jdgPsrInfoPopSettings ;
}


function fn_originJdgSelect() {
// originJdgAllSelect = !originJdgAllSelect;
//  $("input:checkbox[name=ftaInfo]").each(function(){  this.checked = originJdgAllSelect ;    }  );

}

//판정대상 리스트 스크롤
function fn_judgeScroll(){
	if($("input[name=judgeType]:checked").val() == "enrol")
		return;

	judgeScrollTp = false;
	judgeIndex++;
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeList.do",
		data : fn_setSearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var getData = judgeHot.getSourceData();
        	var meargeJson = getData.concat(data.resultList);

        	judgeHot.loadData(meargeJson);   //핸드슨 정보

        	judgeScrollTp = true;
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

//판정대상 리스트 검색
function fn_searchJudge(selectedOption){
	judgeIndex = 0;
	if($("input:radio[name=judgeTpType]:checked").val() == "01"){
		var valid = fn_validateSearchDate($("#judge_input1").find("input[name=salesDate1]").val(), $("#judge_input1").find("input[name=salesDate2]").val());
		if(valid === "false"){
			$("input[name=salesDate1]").val("")
			$("input[name=salesDate2]").val("")
			return;
		}
	} else {
		var valid1 = fn_validateSearchDate($("#judge_Date").find("input[name=salesDate1]").val(), $("#judge_Date").find("input[name=salesDate2]").val());
		var valid2 = fn_validateSearchDate($("input[name=judgeDate1]").val(), $("input[name=judgeDate2]").val())
		if(valid1 === "false"){
			$("#judge_Date").find("input[name=salesDate1]").val("")
			$("#judge_Date").find("input[name=salesDate2]").val("")
			return;
		}
		if(valid2 === "false"){
			$("input[name=judgeDate1]").val("")
			$("input[name=judgeDate2]").val("")
			return;
		}
	}
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeList.do",
		data : fn_setSearchForm(),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	judgeHot.loadData([]);
        	judgeHot.loadData(data.resultList);  //핸드슨

        	fn_judgeSummary(data.summaryList);   //판정요약정보
        	$("#judgeCnt").text(data.totCnt).number(true); //검색결과 총 갯수
        	$("input[name=resultJudgList]").val("");
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



//판정 대상 리스트검색조건 생성
function fn_setSearchForm(){
	var sData = {};
	var gridType = $("input:radio[name=judgeTpType]:checked").val()  ;

	if (gridType=="01") {
		sData["srch1"] =$("input[name=salesNo]", document.formJudge).val();    //판매번호
		sData["srch2"] =$("input[name=salesDate1]", document.formJudge).val();    //판매일시1
		sData["srch3"] =$("input[name=salesDate2]", document.formJudge).val();    //판매일시2
		sData["srch4"] = $("input[name=invoiceNo]", document.formJudge).val();    //인보이스번호
		sData["srch5"] =$("input[name=itemCd]", document.formJudge).val();    //품목명
		sData["srch6"] =$("input[name=itemNm]", document.formJudge).val();    //품목코드
		sData["srch7"] =$("input[name=buyrCd]", document.formJudge).val();    //판매처코드
		sData["srch9"] = $("input:radio[name=judgeYn]:checked", document.formJudge).val();   //판정여부
		sData["srch10"] = $("input:radio[name=tranKnd]:checked", document.formJudge).val();   //거래구분
		sData["srch13"] =$("[name=plntCd]", document.formJudge).val();    //플랜트 코드

	} else {
		sData["srch1"] = $("input[name=jdgmntSeq]", document.formJudgeHistory).val();   //판정번호
		sData["srch2"] =$("input[name=itemCd]", document.formJudgeHistory).val();    //품목코드
		sData["srch3"] =$("select[name=plntCd]", document.formJudgeHistory).val();    //판매처코드
		sData["srch4"] =$("input[name=salesNo]", document.formJudgeHistory).val();    //판매번호
		sData["srch5"] =$("input[name=salesDate1]", document.formJudgeHistory).val();    //판매일시1
		sData["srch6"] =$("input[name=salesDate2]", document.formJudgeHistory).val();    //판매일시2
		sData["srch7"] =$("input[name=judgeDate1]", document.formJudgeHistory).val();    //판정일시1
		sData["srch8"] =$("input[name=judgeDate2]", document.formJudgeHistory).val();    //판정일시2
		sData["srch9"] =$("select[name=ftaCd]", document.formJudgeHistory).val();    //협정코드
		sData["srch10"] =$("input:radio[name=judgeResult]:checked", document.formJudgeHistory).val();    //판정결과
		sData["srch16"] = $("input[name=invoiceNo]", document.formJudgeHistory).val();
		sData["srch20"] =$("input[name=resultJudgList]").val()//저장 결과 보기 변수
		sData["srch21"] =$("input:radio[name=stsCd]:checked", document.formJudgeHistory).val();    //판정확정 미확정
	}


	sData["searchType"] = $("input:radio[name=judgeTpType]:checked").val();
	sData["alignItem"] = $("#alignJudge option:selected").val();
	sData["recordCountPerPage"] = $("#judgePageCnt option:selected").val();
	sData["pageIndex"] = judgeIndex;

	return sData;
};

//검색조건 초기화
function fn_clearJudge(){
	document.formJudge.reset();
	document.formJudgeHistory.reset();
};

//테이블 타입 변경
function fn_changeJudge(type){
	var judgeHiddenPlugin = judgeHot.getPlugin('hiddenColumns');
	if(type == "edit"){
		judgeHot.updateSettings({readOnly:false, contextMenu : ['row_above', 'row_below', '---------', 'undo', 'redo']});
		judgeHiddenPlugin.showColumn(22);
		$("#btnJudgeSave").show();

	}else{
		judgeHot.updateSettings({readOnly:true, contextMenu : false});
		judgeHiddenPlugin.hideColumn(22);
		$("#btnJudgeSave").hide();
	}

	if(type != 'single'){
		fn_searchJudge();
	}
};

function fn_goJudgeHist(){
	//$("#jdgmnthist").click();
}


function fn_runJudgeOne(totJudge, ordr, reJdgListreJdgList, type){ //asas 판정데이터 셋팅
	console.log('셋팅')

	var sourceData = judgeHot.getSourceData();
     var runOrdr = 0 ;
	  var data = judgeHot.getData();
	  if(reJdgListreJdgList == ""){
		  for(var i= data.length - 1; i >= 0; i--){
			  
			  if (judgeHot.getDataAtCell(i,0) =="yes") {
				     var strFta = judgeHot.getDataAtCell(i,17) ;


				      if (goJudgeMode =="formb" ) {
				    	  runOrdr++ ;
				    	  if (runOrdr == ordr ) {
					    	 var saveJudgeData = [] ;
							 saveJudgeData.push(sourceData[i]) ;
					    	 saveJudgeData[0]["selectFtaInfo"] = "Form B"
					    	 saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
					    	 saveJudgeData[0]["jdgmntType"] = type;
					    	 goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
					    	 break ;
				      	}

				      } else {
				    	  var ftaInfos = strFta.split(',');
					      for ( var ftaCd in ftaInfos ) {
					    	     runOrdr++ ;

					    	     if (runOrdr == ordr ) {
							    	 var saveJudgeData = [] ;

									 saveJudgeData.push(sourceData[i]) ;
							    	 saveJudgeData[0]["selectFtaInfo"] = ftaInfos[ftaCd] ;
							    	 saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
							    	 saveJudgeData[0]["jdgmntType"] = type;
							    	 goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
							    	 break ;
					    	     }
					    	}
				       }

			    	     if (runOrdr == ordr ) break ;
			    	     if (runOrdr>totJudge) break ;
			   }
		  }
/*		  for(var i=0; i< data.length; i++){
			  if (judgeHot.getDataAtCell(i,0) =="yes") {
				  var strFta = judgeHot.getDataAtCell(i,17) ;
				  
				  
				  if (goJudgeMode =="formb" ) {
					  runOrdr++ ;
					  if (runOrdr == ordr ) {
						  var saveJudgeData = [] ;
						  saveJudgeData.push(sourceData[i]) ;
						  saveJudgeData[0]["selectFtaInfo"] = "Form B"
							  saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
						  saveJudgeData[0]["jdgmntType"] = type;
						  goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
						  break ;
					  }
					  
				  } else {
					  var ftaInfos = strFta.split(',');
					  for ( var ftaCd in ftaInfos ) {
						  runOrdr++ ;
						  
						  if (runOrdr == ordr ) {
							  var saveJudgeData = [] ;
							  
							  saveJudgeData.push(sourceData[i]) ;
							  saveJudgeData[0]["selectFtaInfo"] = ftaInfos[ftaCd] ;
							  saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
							  saveJudgeData[0]["jdgmntType"] = type;
							  goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
							  break ;
						  }
					  }
				  }
				  
				  if (runOrdr == ordr ) break ;
				  if (runOrdr>totJudge) break ;
			  }
		  }
*/	  } else {

		  for(var i=0; i< reJdgListreJdgList.length; i++){
			     var strFta = reJdgListreJdgList[i].ftaCdList ;
			      var ftaInfos = strFta.split(',');

			      if (goJudgeMode =="formb" ) {
			    		console.log("456");
				    	 var saveJudgeData = [] ;
						 saveJudgeData.push(reJdgListreJdgList[i]) ;
				    	 saveJudgeData[0]["selectFtaInfo"] = "Form B"
				    	 saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
				    	 goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
				    	 break ;


			      } else {

				      for ( var ftaCd in ftaInfos ) {
				    	     runOrdr++ ;

				    	     if (runOrdr == ordr ) {
						    	 var saveJudgeData = [] ;

								 saveJudgeData.push(reJdgListreJdgList[i]) ;
						    	 saveJudgeData[0]["selectFtaInfo"] = ftaInfos[ftaCd] ;
						    	 saveJudgeData[0]["judgeMngNo"] = judgeMngNo ;
						    	 goJudgeByOne(saveJudgeData ,totJudge, ordr) ;
						    	 break ;
				    	     }
				    	}
			       }

		    	     if (runOrdr == ordr ) break ;
		    	     if (runOrdr>totJudge) break ;

		  }
	  }


}


function fn_goJudgeStart(reJdgListreJdgList, type){ //asas 판정 최초 진입
	console.log('진입')
	//JudgeSts
	var totJudge  = 0 ;
	judgeSts = !judgeSts ; //버튼 번경
	judgeSts?$("#goJudgeSts").html(msgStopJudge):$("#goJudgeSts").html(msgGoJudge);
	$("#btnGoJudgeStart").hide();   //중지버튼을 임시로 막아둔다.
	$("#JudgeRunResult").show();

	 $("#judgeA").html("0") ;
	 $("#judgeB").html("0") ;
	 $("#judgeC").html("0") ;

	if(reJdgListreJdgList == ""){ //신규 판정인지 재판정인지
		var sourceData = judgeHot.getSourceData();
		 judgeMngNo = fn_judgeMngNo();   //판정결과를 제어할 변수
		  var data = judgeHot.getData();


		  for(var i=0; i< data.length; i++){
			  if ( judgeHot.getDataAtCell(i,0) =="yes" ) {
				  if(judgeHot.getDataAtCell(i,2) == judgeGoYn.replace(/[\[\]]/gi, "")){ //실행여부 체크 실행-> 재판정 미실행-> 판정
					  alert(msgJdgmntReturn);
					  $("#btnJudgeClose").trigger("click");
					  return;
				  }
				  if (goJudgeMode =="formb") {//판정타입
					  totJudge = totJudge + 1 ;
				  } else {
					  console.log(judgeHot.getDataAtCell(i,16));
					  totJudge = totJudge + judgeHot.getDataAtCell(i,16) ;
				  }
			  }
		  }

		  fn_runJudgeOne(totJudge,1, "", type)
	} else {
		fn_runJudgeOne(reJdgListreJdgList.length,1, reJdgListreJdgList, type)
	}
}

// ---- 판정실행
function goJudgeByOne(judgeData, tot, cur) {//asas 판정시작
	console.log('판정')
	judgeIng = false ;
	var strJudgeData = JSON.stringify(judgeData) ;

	$.ajax({
		type : "POST",
		url : "/judge/goJudgeInfo.do",
		data : strJudgeData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType: "application/json; charset=utf-8",
        success : function(data) {
	    	 fn_JudgeProgressDisp(data, cur , tot) ;
	    	 console.log(cur);
	    	 console.log(tot);
	    	 cur++
	    	 if ( cur <= tot)  {
	    		 fn_runJudgeOne(tot, cur, "", jdgType);
	    	 } else {
	    		 jdgType = "";
	    		 reGoKudgList = null ;
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

}


function judgeFirstDisp(cnt1, cnt2, mode){
	 $("#txtFtaInfoCnt").html(cnt1);
	 $("#txtSalesCnt").html(cnt2);
 	 $("#btnJudgeClose").show();

	 judgeDataChkCnt = cnt1 ;
	 judgeFtaCdChkCnt = cnt2 ;

	 judgeSts = false ;
	 judgeCnt = 0 ;
	 var percent = 0 ;
	 $("#judgeProgressbarTxt").html(percent);
	 $("#judgeProgressbarSts").attr("aria-valuenow",percent) ;
	$("#judgeProgressbarSts").width(percent +"%") ;
	resultA = 0 ;
	resultB = 0 ;
	resultC = 0 ;

	$("#JudgeRunResult").hide();
	$("#goJudgeSts").html(msgGoJudge);

	 $("#btnGoJudgeStart").show();
	 $("#btnGoSaveJudge").hide();
}

function fn_judgeAllClick(obj){
	 var check = "" ;
	 var changeArr = [];
	if ( $("#id_checkJudgeAll").prop("checked") == false) {
		check = "yes" ;
	} else {
		check = "no" ;
	}

	var data = judgeHot.getData();

	for(var i=0; i< data.length; i++){
		changeArr.push([i,0,check])
	}
	judgeHot.setDataAtCell(changeArr);
	if(check == "yes"){
		$("#id_checkJudgeAll").prop("checked", true);
	} else {
		$("#id_checkJudgeAll").prop("checked", false);
	}
}

function judgeLastDisp(){
  	 $("#btnGoSaveJudge").show();
  	 $("#btnJudgeClose").hide();
}

function fn_JudgeProgressDisp(data, judgeCnt , tot) {
	 var percent = Math.round(judgeCnt / tot * 100,2);
   	 $("#judgeProgressbarTxt").html(percent + "%");
	 $("#judgeProgressbarSts").attr("aria-valuenow",percent) ;
	 $("#judgeProgressbarSts").width(percent +"%") ;
     if(data == "Y") {
    	 resultA = resultA + 1 ;
    	 $("#judgeA").html(resultA);
     } else if(data == "N")  {
    	 resultB = resultB + 1 ;
    	 $("#judgeB").html(resultB);
     } else if(data == "E")   {
    	 resultC = resultC + 1 ;
    	 $("#judgeC").html(resultC);
     } else   {
    	 resultC = resultC + 1 ;
	     $("#judgeC").html(resultC);
     }
     if (percent ==100)  judgeLastDisp();
}


function fn_goSaveJudge() {
	var jData = {};
	jData["srch1"] = judgeMngNo ;

	$.ajax({
		type:"POST",
		url: "/orgn/updateJudgeList.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			alert(msgSaveSuccess);
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

	$("#btnJudgeClose").click();
	fn_searchJudge();
}

function fn_goSaveJudgeHist() {
	var jData = {};
	jData["srch1"] = judgeMngNo ;

	$.ajax({
		type:"POST",
		url: "/orgn/updateJudgeList.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			alert(msgSaveSuccess);
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

	$("#btnJudgeClose").click();
	$("#jdgmnthist").click();
	$("input[name=resultJudgList]").val(judgeMngNo);
	$("input:radio[name=judgeTpType]").prop("checked",true);
	fn_changeOrgJdgType("02");
	fn_searchJudge();
}

//판정취소
function fn_goJudgeCancel(prm) {
	if (confirm(msgJdgCancelMsg) == false) return;

	var jData = {};
	if($('#cancelJudge').attr("data-row") != '' && $('#cancelJudge').attr("data-row") != null){
		judgeMngNo = judgeHot.getSourceData()[$('#cancelJudge').attr("data-row")].judgeMngNo
	}

	if(prm == "jdgC"){
		jData["srch1"] = judgeMngNo ;
	} else {
		jData["srch1"] = judgeMngNo ;
		jData["srch2"] = judgeHot.getDataAtCell($("#cancelJudge").attr('data-row'),9);
		jData["srch3"] = judgeHot.getDataAtCell($("#cancelJudge").attr('data-row'),10);
		jData["srch4"] = judgeHot.getDataAtCell($("#cancelJudge").attr('data-row'),6);
		jData["srch5"] = judgeHot.getDataAtCell($("#cancelJudge").attr('data-row'),11);
	}
	$('#cancelJudge').attr("data-row", '');
	$("#detailJdgResult").trigger("click");

	$.ajax({
		type:"POST",
		url: "/orgn/cancelJudgeList.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			if(data.status == "success"){
				alert(msgCencleMsg);
				$("#detailJdgResult").trigger("click");
				fn_searchJudge();
			} else {
				alert(msgDisableJdgCancel);
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

	$("#btnJudgeClose").click();
	fn_searchJudge();
}

function fn_goJudgeCancelInvocie() {
	if (confirm(judgeCancelAll) == false) return;
	
	var list = judgeHot.getSourceData()[$('#cancelJudge').attr('data-row')];
	var jData = {};
	
	jData["srch1"] = list.plntCd;
	jData["srch2"] = list.invoiceNo;
	
	console.log(jData);
	
	
	$.ajax({
		type:"POST",
		url: "/orgn/cancelJudgeInvoiceList.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			console.log(data);
			console.log(data.status);
			if(data.status == "success"){
				alert(msgCencleMsg);
				$("#detailJdgResult").trigger("click");
				fn_searchJudge();
			} else {
				alert(confmAllChkMsg);
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

	$("#btnJudgeClose").click();
	fn_searchJudge();
	
}


function fn_judgeSummary(summaryData) {

	if ( summaryData == undefined ) {
		/*
		$("#judgeStsCnt0").html("0");
		$("#judgeStsCnt1").html("0");
		$("#judgeStsCnt2").html("0");
		$("#judgeStsCnt3").html("0");
		$("#judgeStsCnt4").html("0");
		$("#judgeStsCnt5").html("0");
		*/
	}	else {
//			$("#judgeStsCnt0").html(summaryData[0]["cnt1"]) ;
//			$("#judgeStsCnt1").html(summaryData[0]["cnt2"]) ;
//			$("#judgeStsCnt2").html(summaryData[0]["cnt3"]) ;
//			$("#judgeStsCnt3").html(summaryData[0]["cnt4"]) ;
//			$("#judgeStsCnt4").html(summaryData[0]["cnt5"]) ;
//			$("#judgeStsCnt5").html(summaryData[0]["cnt6"]) ;
	}
}


function fn_judgeMngNo(){
		// TODO Auto-generated method stub
		var  keyTable = "abcdefgjijklmnopqrstuvwxyzABCDEFGJIJKLMNOPQRSTUVWXYZ01234567890" ;
		var str = "" ;
		for(var  i=0; i< 8; i++) {
		    var pos = Math.random() * (keyTable.length - 0) + 0;
		    str  = str + keyTable.substring(pos, pos+1);
		}
		return str;
}

function fn_searchOption1(mode){
	if (mode) {
		
		document.formJudge.reset();
		$("#judge_result_srch1").show();
		$("#fn_starJudgeBtn").show();
		
		  var date = new Date();
		  var month = date.getMonth();
		  
		  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
		  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'/');
		  
		 $("input[name=salesDate1]").val(mtoday);
		 $("input[name=salesDate2]").val(today);
		  

		$("select#alignJudge").append("<option value='' selected >"+colOrderby+"</option>"+
				  "<option value='SALES_NO' >"+colSalesNo+" &uarr; </option>"+
				  "<option value='SALES_NO_DESC' >"+colSalesNo+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemAllCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemAllCd+"  &darr; </option>"+
				  "<option value='BUYR_CD' >"+colBuyrCd+" &uarr; </option>"+
				  "<option value='BUYR_CD_DESC' >"+colBuyrCd+"  &darr; </option>"+
				  "<option value='BUYR_NM' >"+colBuyrNm+" &uarr; </option>"+
				  "<option value='BUYR_NM_DESC' >"+colBuyrNm+"  &darr; </option>");
	} else {
		$("#judge_result_srch1").hide();
		$("#fn_starJudgeBtn").hide();
	}

	 $('select#alignJudge').on('change', function() {
	        
	        var selectedOption = $(this).val(); 
	        fn_searchJudge(selectedOption); 
	    });
	}

function fn_searchOption2(mode){
	if (mode) {
		$("#judge_result_srch2").show();
		 $("input[name=salesDate1]").val("");
		 $("input[name=salesDate2]").val("");
		
		  var date = new Date();
		  var month = date.getMonth();
		  
		  var today = new Date().toISOString().substring(0,10).replace(/-/g,'/');
		  var mtoday = new Date(new Date().setMonth(month - 1)).toISOString().substring(0,10).replace(/-/g,'/');
		  
		 
		  
		  $("input[name=judgeDate1]").val(mtoday);
		  $("input[name=judgeDate2]").val(today);

		
		$("select#alignJudge").append("<option value='' selected >"+colOrderby+"</option>"+
				 "<option value='SALES_NO' >"+colSalesNo+" &uarr; </option>"+
				  "<option value='SALES_NO_DESC' >"+colSalesNo+"  &darr; </option>"+
				  "<option value='ITEM_CD' >"+colItemAllCd+" &uarr; </option>"+
				  "<option value='ITEM_CD_DESC' >"+colItemAllCd+"  &darr; </option>"+
				  "<option value='BUYR_CD' >"+colBuyrCd+" &uarr; </option>"+
				  "<option value='BUYR_CD_DESC' >"+colBuyrCd+"  &darr; </option>"+
				  "<option value='BUYR_NM' >"+colBuyrNm+" &uarr; </option>"+
				  "<option value='BUYR_NM_DESC' >"+colBuyrNm+"  &darr; </option>");

	} else {
		$("#judge_result_srch2").hide();
	}
	
	 $('select#alignJudge').on('change', function() {
	       
	        var selectedOption = $(this).val();
	        fn_searchJudge(selectedOption); 
	    }); 
	}

//테이블 검색구분
function fn_changeOrgJdgType(type){
	$("select#alignJudge option").remove();

	if(type == "01"){
		fn_searchOption1(true);
		fn_searchOption2(false);
		judgeHot.updateSettings(fn_originGridOption1());
	}else if(type == "02"){
		fn_searchOption1(false);
		fn_searchOption2(true);
		judgeHot.updateSettings(fn_originGridOption2());
	}
	

	fn_searchJudge();
}

//판정세부정보(target)
function fn_callPopJdgInfo(row){
	var data = judgeHot.getDataAtCell(row, 2);
	$("#judge_srch1").val(data);
	$("input:radio[name=judgeTpType]").prop("checked",true);
	fn_changeOrgJdgType("02");

}

//팝업
function fn_callPopOrgJdg(target, row, col){
	var strSearch, strFrom, strWhere, strOrderby, strIf1, strIf2, type;

	//아이템 조회
	if(target == "judge_itemCd1" ||  target == "judge_ItemCd2" ||  target == "1"){
		strSearch = (colLang == "en") ? "DISTINCT(ITEM_CD) AS CD, PRDCT_ENM AS CD_NM" : "DISTINCT(ITEM_CD) AS CD, PRDCT_VNM AS CD_NM";
		strFrom = "ITEM_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "ITEM_CD";
		strIf1 = "ITEM_CD";
		strIf2 = (colLang == "en") ? "PRDCT_ENM" : "PRDCT_VNM";
		$("#exampleModalCenterTitleCmmn").text(colItemCd);
		type = "itemCd" ;
	} else {
		strSearch = (colLang == "en") ? "DISTINCT(BUYR_ID) AS CD, BUYR_NM_EN_ENM AS CD_NM" : "DISTINCT(BUYR_ID) AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '"+colCurrCmpnyCd+"' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN_ENM" : "BUYR_NM";

		$("#exampleModalCenterTitleCmmn").text(colBuyrCd);

		type = "buyrId" ;
	}


	var condition = {type :"tableCd", search :strSearch, from : strFrom, where : strWhere, orderby : strOrderby, if1 : strIf1, if2 : strIf2, type : type, row : row, col : col};

	fn_showCmmnPopup(condition, function(data){
		$("#"+target).val(data.cd);
  });
};


//테이블팝업 호출
function fn_callPopOrgn(target, row, col) {
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
	} else if(target == "partnCd"){
		strSearch = (colLang == "en") ? "DISTINCT(BUYR_ID) AS CD, BUYR_NM_EN AS CD_NM"
				: "DISTINCT(BUYR_ID) AS CD, BUYR_NM AS CD_NM";
		strFrom = "PARTN_BUYR_INFO";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND DEL_YN = 'N'";
		strOrderby = "BUYR_ID";
		strIf1 = "BUYR_ID";
		strIf2 = (colLang == "en") ? "BUYR_NM_EN" : "BUYR_NM";
		$("#exampleModalCenterTitleCmmn").text(colBuyrCd);
	} else if(target == "nation"){
		strSearch = (colLang == "vt") ? "DISTINCT EXPORT_NATION AS CD, B.CMMN_NM_VN AS CD_NM" : (colLang == "en") ?  "DISTINCT EXPORT_NATION AS CD, B.CMMN_NM_EN AS CD_NM" : "DISTINCT EXPORT_NATION AS CD, B.CMMN_NM_KR AS CD_NM";
		strFrom = "SALES_LIST A LEFT JOIN cmmn_cd B ON A.EXPORT_NATION = B.CMMN_CD ";
		strWhere = "CMPNY_CD = '" + colCurrCmpnyCd + "' AND A.DEL_YN = 'N' AND B.GRP_CD = 'NATION'";
		strOrderby = "B.ORDR_SN";
		strIf1 = "EXPORT_NATION";
		strIf2 = (colLang == "en") ? "B.CMMN_NM_EN" : (colLang == "vt") ? "B.CMMN_NM_VN": "B.CMMN_NM_KR";
		$("#exampleModalCenterTitleCmmn").text(colExportNation);
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
			console.log(data.type)
			if($("input:radio[name=judgeTpType]:checked").val() == "01"){
				$("form[name=formJudge]").find("input[name=itemCd]").val(data.cd);
			} else {
				$("form[name=formJudgeHistory]").find("input[name=itemCd]").val(data.cd);
			}
		} else if(data.type == "partnCd"){
			$("#judge_BuyrCd1").val(data.cd);
		}  else {
			$("#NATCD").val(data.cd);
		}
	});
};





function fn_popupSearch(row){

}

//팝업 정보 조회
function fn_jdgmntResultPopCall(row){

	if(colProductJudge == judgeHot.getDataAtCell(row, 1)){
		$("#psrDtl").show();
	} else {
		$("#psrDtl").hide();
	}
	if(judgeHot.getDataAtCell(row, 2) == "GSP(EU)"){
		
	}
	if(judgeHot.getDataAtCell(row,17).replace(/[\[\]]/gi,"") != judgeResultYn.replace(/[\[\]]/gi,"")){
		$("#cancelJudge").hide();
		$("#cancelJudgeInvoice").hide();
		$("#cnfrmDiv").hide();
		$("#reJudge").hide();
		$("#confmJudge").hide();
		$("#confmJudgeInvoice").hide();
		$("#psrChange").hide();
		$("#doredit").hide();
	} else {
		$("#cancelJudge").show();
		$("#cancelJudgeInvoice").show();
		$("#cnfrmDiv").show();
		$("#reJudge").show();
		$("#confmJudge").show();
		$("#confmJudgeInvoice").show();
		$("#psrChange").show();
		$("#doredit").show();
	}

	currentJdgmntSeq = judgeHot.getDataAtCell(row,0);
	$("#reJudge").attr("data-row", row);
	$('#cancelJudge').attr('data-row', row);
	$("#psrChange").attr("data-row", row);
	var jData = {};
	jData["srch1"] = currentJdgmntSeq ;
	//jData["srch2"] = judgeHot.getDataAtCell(row,0);

	$.ajax({
		type:"POST",
		url: "/orgn/selectJudgePopupList.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		async: false,
		dataType:"json",
		success:function(data){
			console.log(data);
			$("#jdgmntResultPop").modal();
			$("#psrChange").attr("data-seq", data.jdgBaseInfo["jdgmntSeq"]);
			$("#psrChange").attr("data-psr", data.jdgBaseInfo["psrSeq"]);
			//currentJdgmntSeq = 0 ;
			//dokadoka
			fn_jdgmntBaseData(data.jdgBaseInfo);
			// psr 그리드
			fn_jdgmntPsrPop(data.jdgPsrInfoList,  data.jdgBaseInfo["psrSeq"]) ;
			//원재료 그리드
 			fn_jdgmntResultPopCall2(currentJdgmntSeq, data.jdgBaseInfo["psrSeq"]) ;

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

//팝업 정보 조회(원재료 데이터)
function fn_jdgmntResultPopCall2(judgeSeq, psrSeq){
	var jData = {};
	jData["srch1"] = judgeSeq ;
	jData["srch2"] = psrSeq ;

	$.ajax({
		type:"POST",
		url: "/orgn/selectJudgePopupList2.do",
		data: jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType:"json",
		success:function(data){
			console.log(data);
			// 원재료 그리드
			fn_jdgmntRawMtPop(data.jdgRawList) ;

//			jdgRawMtPopHot.updateSettings({
//				 hiddenColumns : {columns : [12,13]}
//			});

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


// psr 팝업
function fn_jdgmntPsrPop(data, psrSeq) {
	 $("#jdgPsrInfoPopTable").html("");   //이전 내용삭제
	  var jdgPsrInfoPopElement = document.querySelector('#jdgPsrInfoPopTable');
	  var jdgPsrInfoPopElementContainer = jdgPsrInfoPopElement.parentNode;
	  jdgPsrInfoPopHot  = new Handsontable(jdgPsrInfoPopElement, fn_jdgPsrInfoPopSettings(psrSeq));

	   jdgPsrInfoPopHot.loadData([]);
	   for(var i=0;i< data.length; i++){
		   data[i].psrDetail = data[i].psrDetail.replace(/##/gi, " ");
	   }
	   jdgPsrInfoPopHot.loadData(data);
	  setTimeout(function(){jdgPsrInfoPopHot.render()}, 200);
}


function fn_jdgmntRawMtPop(data) {
	// raw 팝업
	 $("#jdgRawMtPopTable").html("");   //이전 내용삭제
   var jdgRawMtPopElement = document.querySelector('#jdgRawMtPopTable');
   var jdgRawMtPopElementContainer = jdgRawMtPopElement.parentNode;
   jdgRawMtPopHot = new Handsontable(jdgRawMtPopElement, fn_getJdgRawMtPopSettings());


   if (data.length >0 ) {
       data =  fn_sumJdgRawMtPopHot(data) ;  //합계처리
   }

   jdgRawMtPopHot.loadData([]);
   jdgRawMtPopHot.loadData(data);

	var lastRow = jdgRawMtPopHot.countSourceRows() ;

   if (data.length >0 ) {
		var lastRow = jdgRawMtPopHot.countSourceRows()-1 ;
		jdgRawMtPopHot.updateSettings({
		      mergeCells: [{row:lastRow , col: 0, rowspan: 1, colspan: 7}]
			});
   }

	setTimeout(function(){jdgRawMtPopHot.render()}, 200);
}

function fn_sumJdgRawMtPopHot(data) {
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

function fn_jdgmntBaseData(data){


	$("#judge_detail_ftaCd").html(data.ftaCd);

	$("input[name=itemNm]", document.judge_resultDetail).val(data.itemNm);   //itemcd
	$("input[name=itemCd]", document.judge_resultDetail).val(data.itemCd);   //itemcd
	$("input[name=hsCd]", document.judge_resultDetail).val("["+data.hsVer+"] " + data.hsCd );
	$("input[name=salesDt]", document.judge_resultDetail).val(data.salesDt);
	$("input[name=buyrNm]", document.judge_resultDetail).val(data.buyrNm);
	$("input[name=salesQty]", document.judge_resultDetail).val(data.salesQty);
	$("input[name=judgeDt]", document.judge_resultDetail).val(data.jdgmntDt);
	$("input[name=salesPriceFob]", document.judge_resultDetail).val(data.salesFobPrice);
	$("input[name=psr]", document.judge_resultDetail).val((data.psrInfo2 == "MERCH") ? colMerchJudgeTarget : data.psrInfo2);

	console.log(data.ftaCd);
	if(data.ftaCd == "GSP(EU)" || data.ftaCd == "GSP(UK)" || data.ftaCd == "EVFTA" || data.ftaCd == "EAVFTA" || data.ftaCd == "UKVFTA"){
		$("#fobExw").html(colSalesPriceExw);
	} else {
		$("#fobExw").html(colSalesPriceFob);
	}

	if (data.jdgmntResultYn =="Y") {
		$("#judge_detail_jdgmntResultYn").html("<span class='badge badge-success m-2'>"+msgOrigin+"("+data.jdgmntResultCd+")</span>")
	} else {
		$("#judge_detail_jdgmntResultYn").html("<span class='badge badge-danger m-2'>"+msgNrigin+"("+data.jdgmntResultCd+")</span>")
	}
	//
}

//Tabel 생성

//재판정
function fn_goJudgeReStart(){
	var list = judgeHot.getSourceData()[$("#reJudge").attr("data-row")];
	var jData = {};
	jData['srch1'] = list.salesNo;
	jData['srch11'] = list.plntCd;
	jData['srch12'] = list.salesOrdr;
	jData['searchType'] = "01";

	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeList.do",
		data : jData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        async: false,
        success : function(data) {
        	var cnt2 =0;
        	for(var i=0; i < data.resultList.length; i++){
        		cnt2 += data.resultList[i].ftaCdList.split(",").length;
        	}
        	$("#detailJdgResult").trigger("click");
        	reGoKudgList = data.resultList;
        	judgeFirstDisp(data.resultList.length,1, '');
        	$("#judgePopup").modal()
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

//판정 확정
function fn_confJudge(){
	if(jdgPsrInfoPopHot.getSourceData().length == 0 || jdgPsrInfoPopHot.getDataAtCell($("input:radio[name=preSeq]:checked").attr("id").replace("psrRdo", ""), 2) != 'Y'){
		alert(msgJdgConfmFalesMsg);
		return;
	}
	if(!confirm(msgJdgConfmMsg)) return;
	$("#detailJdgResult").trigger("click");
	var cData = {};
	var list = judgeHot.getSourceData()[$('#cancelJudge').attr('data-row')];
	cData['srch1'] = list.salesNo;
	cData['srch4'] = $("input:radio[name=cnfrmType]:checked").val(); 
	cData['srch11'] = list.plntCd;
	cData['srch12'] = list.salesOrdr;
	cData['srch13'] = list.ftaCd;
	cData['srch14'] = list.itemCd;
	cData['srch15'] = list.stndrdNo;
	cData['searchType'] = "01";

	
	console.log(cData);
	$.ajax({
		type : "POST",
		url : "/orgn/updateCnfJudge.do",
		data : JSON.stringify(cData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        async: false,
        contentType : "application/json; charset=utf-8",
        success : function(data) {
        	alert(msgJdgConfm);
        	fn_searchJudge();
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


function fn_confJudgeInvoice(){
	if(!confirm(confmAllMsg)) return;
	
	var list = judgeHot.getSourceData()[$('#cancelJudge').attr('data-row')];
	
	console.log(list);
	
	var cData = {};
	
	cData['srch1'] = list.plntCd;
	cData['srch2'] = list.invoiceNo;
	cData['srch3'] = list.ftaCd;
	cData['srch4'] = $("input:radio[name=cnfrmType]:checked").val(); 
	
	if(list.invoiceNo == null || list.invoiceNo == ""){
		alert("No Information of Invoice No.")
		return;
	}
	
	console.log(cData);
	
	
	$.ajax({
		type : "POST",
		url : "/orgn/updateCnfJudgeInvoice.do",
		data : JSON.stringify(cData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        async: false,
        dataType : "json",
        contentType : "application/json; charset=utf-8",
        success : function(data) {
        	console.log(data.status);
        	if(data.status == "cnf"){
        		alert(confmAllChkMsg3)
        	} else if (data.status == "jdg"){
        		alert(confmAllChkMsg2)
        	} else {
        		alert(msgJdgConfm);
        		$("#detailJdgResult").trigger("click");
        		fn_searchJudge();
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
}

	
//psr 변경
function fn_ChangePsr(){

	var pData = {};
	pData["srch1"] = $("#psrChange").attr("data-psr");
	pData["srch2"] = $("#psrChange").attr("data-seq");

	$.ajax({
		type : "POST",
		url : "/orgn/changePsr.do",
		data : JSON.stringify(pData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
        async: false,
        contentType : "application/json; charset=utf-8",
        success : function(data) {
        	alert(msgPsrChange);
        	fn_jdgmntResultPopCall($("#psrChange").attr("data-row"));
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
function addComma(num){
	var parts = num.toString().split(".");
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_jdgmntResult(row){
	var data = judgeHot.getSourceData();
	var rowData = data[row];
	
	var plntCd = data[row]['plntCd'];
	var jdgmntSeq = data[row]['jdgmntSeq'];
	var itemCd = data[row]['itemCd'];
	var salesDt = data[row]['salesDt']
	var usedQty = 0;
	
	fn_paramsForPopup(data[row]);
	fn_searchResultPopup(data[row]) ;	

	document.getElementById('plntCd').value = plntCd;
	document.getElementById('jdgmntSeq').value = jdgmntSeq;
	document.getElementById('itemCd').value = itemCd;
	document.getElementById('salesDt').value = salesDt;
	
	$("#jdgmntResult").modal("show");

}

function fn_paramsForPopup(selectedRow){
	var sData = {};

	sData["srch20"] = selectedRow["plntCd"] ;
	sData["srch21"] = selectedRow["jdgmntSeq"] ;
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
function fn_searchResultPopup(selectedRow){
	fn_loading(true);
	$.ajax({
		type : "POST",
		url : "/orgn/selectJudgeResultList.do",
		data : fn_paramsForPopup(selectedRow),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	judgeResultHot.loadData([]);
        	judgeResultHot.loadData(data.resultList);
			setTimeout(function() {judgeResultHot.render()}, 200);
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


function fn_handsonGridResultPopupOption(){
	  var resultPopupElement = document.querySelector('#popResultTable');
	  var resultPopupElementContainer = resultPopupElement.parentNode;
	  
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