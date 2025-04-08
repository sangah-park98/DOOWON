$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      $("#hsjudgests_srch1").val(fn_gFmtDate(1,"/"));
      $("#hsjudgests_srch2").val(fn_gFmtDate(0,"/"));

	  var hsjudgestsElement = document.querySelector('#hsjudgestsTable');
	  var hsjudgestsElementContainer = hsjudgestsElement.parentNode;
	  var hsjudgestsSettings = {
			  columns : [
				  {data : 'dt', type : 'text', className : "htCenter"},
				  {data : 'oCd1', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd1', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd2', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd2', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd3', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd3', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd4', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd4', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd5', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd5', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd6', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd6', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd7', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd7', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd8', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd8', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd9', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd9', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCd10', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCd10', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oEtc', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nEtc', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"}
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
	    	  colHeaders: true,
	    	  nestedHeaders: [
	    	    [ colmonth,
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:colhsCd, colspan:2},
	    	      {label:coletcOrg, colspan:2}
	    	    ],
	    	    [
    	    	  '',
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin,
    	    	  colorigin,
    	    	  colnrigin
	    		]
	    	  ],
	    	  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			 // dropdownMenu : false,
			  filters : true,
			  readOnly : true,
			  allowRemoveRow : false,
			//  columnSorting : {
			//	  indicator : true
	        //  },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	  hsjudgestsHot = new Handsontable(hsjudgestsElement, hsjudgestsSettings);

	  //챠트
	  var hsjudgestsChartOptions = {
	    		chart: {
	    			height: 450,
	    			type: 'bar', // sparkline: {
	    			enabled: true
	    			// },

	    		},
	    		plotOptions: {
	    			bar: {
	    				horizontal: false,
	    				//endingShape: 'rounded',
	    				columnWidth: '40%'
	    			}
	    		},
	    		dataLabels: {
	    			enabled: true
	    		},
			    series: [
			    	{
			    		name: colorigin,
			    		data: []
			    	},
			    	{
			    		name: colnrigin,
			    		data: []
			    	}
			    ],
			    xaxis: {
			    	categories: []
			    },
			    yaxis: {
			    	title: {
			    		text: ''
			    	}
			    },
			    legend : {
  				show : false
  			},
  			colors : ['#0080ff', '#f36d12'],
		    fill: {
		    	colors : ['#0080ff', '#f36d12'],
		    	opacity: 1
		    },
		    tooltip: {
		    	y: {
		    		formatter: function formatter(val) {
		    			return val;
		    		}
		    	}
		    }
	  };

	  hsjudgestsChart = new ApexCharts(document.querySelector("#hsjudgestsChart"), hsjudgestsChartOptions);
	  hsjudgestsChart.render();

	  //검색구분 변경
	  $("input[name=hsjudgests_srch3]").change(function(){
		  fn_searchHsjudgests();
	  });

	  fn_searchHsjudgests();

});

//검색
function fn_searchHsjudgests(){
	var starDt = $("#hsjudgests_srch1");
	var endDt = $("#hsjudgests_srch2");

	if(starDt.val() == ""){
		alert(msgSearchPdMsg);
		starDt.focus();
		return;
	}

	if(endDt.val() == ""){
		alert(msgSearchPdMsg);
		endDt.focus();
		return;
	}

	$.ajax({
		type : "POST",
		url : "/stat/selectHsjudgestsList.do",
		data : fn_setHsjudgestsForm(),
		dataType: "json",
        success : function(data) {
        	var title = colmonth;
        	var srchTp = $("input:radio[name=hsjudgests_srch3]:checked").val();
        	if(srchTp == "01"){
        		title = coldate;
        	}else if(srchTp == "03"){
        		title = colquarter;
        	}else if(srchTp == "04"){
        		title = colyear;
        	}

        	var result = data.resultList[0];
        	var hsColumns = [];
        	var hsHeader = [];
        	var hsSub1 = [];
        	var hsSub2 = [];
        	hsColumns.push({data : 'dt', type : 'text', className : "htCenter"});
        	hsSub1.push(title);
        	hsSub2.push("");

        	var hsText = [];
        	var hsOcnt = [];
        	var hsNcnt = [];

        	var oCd1Sum = 0, nCd1Sum = 0, oCd2Sum = 0, nCd2Sum = 0, oCd3Sum = 0, nCd3Sum = 0, oCd4Sum = 0, nCd4Sum = 0,
        	    oCd5Sum = 0, nCd5Sum = 0, oCd6Sum = 0, nCd6Sum = 0, oCd7Sum = 0, nCd7Sum = 0, oCd8Sum = 0, nCd8Sum = 0,
        	    oCd9Sum = 0, nCd9Sum = 0, oCd10Sum = 0, nCd10Sum = 0, oEtcSum = 0, nEtcSum = 0;

        	for(var i=0; i<data.resultList.length; i++){
        		if(result.cd1 != 'NULL'){
        			oCd1Sum = oCd1Sum + data.resultList[i].oCd1;
        			nCd1Sum = nCd1Sum + data.resultList[i].nCd1;
        		}
        		if(result.cd2 != 'NULL'){
        			oCd2Sum = oCd2Sum + data.resultList[i].oCd2;
        			nCd2Sum = nCd2Sum + data.resultList[i].nCd2;
        		}
        		if(result.cd3 != 'NULL'){
        			oCd3Sum = oCd3Sum + data.resultList[i].oCd3;
        			nCd3Sum = nCd3Sum + data.resultList[i].nCd3;
        		}
        		if(result.cd4 != 'NULL'){
        			oCd4Sum = oCd4Sum + data.resultList[i].oCd4;
        			nCd4Sum = nCd4Sum + data.resultList[i].nCd4;
        		}
        		if(result.cd5 != 'NULL'){
        			oCd5Sum = oCd5Sum + data.resultList[i].oCd5;
        			nCd5Sum = nCd5Sum + data.resultList[i].nCd5;
        		}
        		if(result.cd6 != 'NULL'){
        			oCd6Sum = oCd6Sum + data.resultList[i].oCd6;
        			nCd6Sum = nCd6Sum + data.resultList[i].nCd6;
        		}
        		if(result.cd7 != 'NULL'){
        			oCd7Sum = oCd7Sum + data.resultList[i].oCd7;
        			nCd7Sum = nCd7Sum + data.resultList[i].nCd7;
        		}
        		if(result.cd8 != 'NULL'){
        			oCd8Sum = oCd8Sum + data.resultList[i].oCd8;
        			nCd8Sum = nCd8Sum + data.resultList[i].nCd8;
        		}
        		if(result.cd9 != 'NULL'){
        			oCd9Sum = oCd9Sum + data.resultList[i].oCd9;
        			nCd9Sum = nCd9Sum + data.resultList[i].nCd9;
        		}
        		if(result.cd10 != 'NULL'){
        			oCd10Sum = oCd10Sum + data.resultList[i].oCd10;
        			nCd10Sum = nCd10Sum + data.resultList[i].nCd10;
        		}
        		if(result.oEtc > 0 && result.nEtc > 0){
        			oEtcSum = oEtcSum + data.resultList[i].oEtc;
        			nEtcSum = nEtcSum + data.resultList[i].nEtc;
        		}
        	}

        	if(result != undefined && result.cd1 != 'NULL'){
        		hsColumns.push({data : 'oCd1', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd1', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd1, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd1 + " ]");
        		hsOcnt.push(oCd1Sum);
        		hsNcnt.push(nCd1Sum);
        	}

        	if(result != undefined && result.cd2 != 'NULL'){
        		hsColumns.push({data : 'oCd2', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd2', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd2, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd2 + " ]");
        		hsOcnt.push(oCd2Sum);
        		hsNcnt.push(nCd2Sum);
        	}

        	if(result != undefined && result.cd3 != 'NULL'){
        		hsColumns.push({data : 'oCd3', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd3', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd3, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd3 + " ]");
        		hsOcnt.push(oCd3Sum);
        		hsNcnt.push(nCd3Sum);
        	}

        	if(result != undefined && result.cd4 != 'NULL'){
        		hsColumns.push({data : 'oCd4', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd4', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd4, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd4 + " ]");
        		hsOcnt.push(oCd4Sum);
        		hsNcnt.push(nCd4Sum);
        	}

        	if(result != undefined && result.cd5 != 'NULL'){
        		hsColumns.push({data : 'oCd5', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd5', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd5, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd5 + " ]");
        		hsOcnt.push(oCd5Sum);
        		hsNcnt.push(nCd5Sum);
        	}

        	if(result != undefined && result.cd6 != 'NULL'){
        		hsColumns.push({data : 'oCd6', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd6', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd6, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd6 + " ]");
        		hsOcnt.push(oCd6Sum);
        		hsNcnt.push(nCd6Sum);
        	}

        	if(result != undefined && result.cd7 != 'NULL'){
        		hsColumns.push({data : 'oCd7', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd7', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd7, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd7 + " ]");
        		hsOcnt.push(oCd7Sum);
        		hsNcnt.push(nCd7Sum);
        	}

        	if(result != undefined && result.cd8 != 'NULL'){
        		hsColumns.push({data : 'oCd8', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd8', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd8, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd8 + " ]");
        		hsOcnt.push(oCd8Sum);
        		hsNcnt.push(nCd8Sum);
        	}

        	if(result != undefined && result.cd9 != 'NULL'){
        		hsColumns.push({data : 'oCd9', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd9', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd9, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd9 + " ]");
        		hsOcnt.push(oCd9Sum);
        		hsNcnt.push(nCd9Sum);
        	}

        	if(result != undefined && result.cd10 != 'NULL'){
        		hsColumns.push({data : 'oCd10', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nCd10', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cd10, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cd10 + " ]");
        		hsOcnt.push(oCd10Sum);
        		hsNcnt.push(nCd10Sum);
        	}

        	if(result != undefined && result.oEtc > 0 && result.nEtc > 0){
        		hsColumns.push({data : 'oEtc', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsColumns.push({data : 'nEtc', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"});
        		hsSub1.push({label:result.cdEtc, colspan:2});
        		hsSub2.push(colorigin);
        		hsSub2.push(colnrigin);
        		hsText.push("[ " + result.cdEtc + " ]");
        		hsOcnt.push(oEtcSum);
        		hsNcnt.push(nEtcSum);
        	}

        	hsHeader.push(hsSub1);
        	hsHeader.push(hsSub2);

        	hsjudgestsHot.updateSettings({
        		columns : hsColumns,
        		nestedHeaders: hsHeader
			});

        	hsjudgestsHot.loadData([]);
        	hsjudgestsHot.loadData(data.resultList);
        	
        	if(hsText.length < 1){
        		hsText = ['',''];
        	}

        	//챠트업데이트
        	var resultOption = {
        			series: [
    			    	{
    			    		name: colorigin,
    			    		data: hsOcnt
    			    	},
    			    	{
    			    		name: colnrigin,
    			    		data: hsNcnt
    			    	}
    			    ],
    			    xaxis: {
    			    	categories: hsText
    			    }
      	    };
        	hsjudgestsChart.updateOptions(resultOption);

        },
        error : function(e, textStatus, errorThrown) {
        	console.log(errorThrown);
        	alert(msgSearchError);
        }
	});
};

$("body").on("keydown", function(){
	var focusElement = document.activeElement.localName;
	if(focusElement != "select" && focusElement != "textarea"){
		if (window.event.keyCode == 13 && $("#tabs-hsjudgests").hasClass("active")) {
			fn_searchHsjudgests();
		}
	}
})

//검색조건 생성
function fn_setHsjudgestsForm(){
	var sData = {};
	sData["srch1"] = $("#hsjudgests_srch1").val();
	sData["srch2"] = $("#hsjudgests_srch2").val();
	sData["srch3"] = $("input:radio[name=hsjudgests_srch3]:checked").val();
	return sData;
};

//검색조건 초기화
function fn_clearHsjudgests(){
	$("#hsjudgests_srch1").val(fn_gFmtDate(1,"/"));
    $("#hsjudgests_srch2").val(fn_gFmtDate(0,"/"));
	$("input:radio[name=hsjudgests_srch3]")[1].checked = true;
};

$(document).mousedown(function(e){	
	if(e.target.name == "statHsjudg1_date" || e.target.name == "statHsjudg2_date"){
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