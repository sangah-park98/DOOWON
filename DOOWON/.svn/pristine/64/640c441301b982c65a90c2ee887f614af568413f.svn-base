$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      $("#ftajudgsts_srch1").val(fn_gFmtDate(1,"/"));
      $("#ftajudgsts_srch2").val(fn_gFmtDate(0,"/"));

	  var ftajudgstsElement = document.querySelector('#ftajudgstsTable');
	  var ftajudgstsElementContainer = ftajudgstsElement.parentNode;
	  var ftajudgstsSettings = {
			  columns : [
				  {data : 'dt', type : 'text', className : "htCenter"},
				  {data : 'oAtiga', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAtiga', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAifta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAifta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAcfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAcfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAjcep', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAjcep', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oVcfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nVcfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oVjepa', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nVjepa', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oVkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nVkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAanzfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAanzfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oEavfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nEavfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oAhkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nAhkfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oEvfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nEvfta', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oCptpp', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCptpp', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'oGsp', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nGsp', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"}
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
/*	    	  colHeaders : [
	    		  colmonth,
	    		  'ATIGA',
	    		  'AIFTA',
	    		  'ACFTA',
	    		  'AJCEP',
	    		  'AKFTA',
	    		  'VCFTA',
	    		  'VJEPA',
	    		  'VKFTA',
	    		  'AANZFTA',
	    		  'EAVFTA',
	    		  'AHKFTA',
	    		  'EVFTA',
	    		  'CPTPP',
	    		  'GSP'
			  ],*/
	    	  colHeaders: true,
	    	  nestedHeaders: [
	    	    [ colmonth,
	    	      {label:'ATIGA', colspan:2},
	    	      {label:'AIFTA', colspan:2},
	    	      {label:'ACFTA', colspan:2},
		    	  {label:'AJCEP', colspan:2},
		    	  {label:'AKFTA', colspan:2},
		    	  {label:'VCFTA', colspan:2},
		    	  {label:'VJEPA', colspan:2},
		    	  {label:'VKFTA', colspan:2},
		    	  {label:'AANZFTA', colspan:2},
		    	  {label:'EAVFTA', colspan:2},
		    	  {label:'AHKFTA', colspan:2},
		    	  {label:'EVFTA', colspan:2},
		    	  {label:'CPTPP', colspan:2},
		    	  {label:'GSP', colspan:2}
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
			//  dropdownMenu : false,
			  filters : true,
			  readOnly : true,
			  allowRemoveRow : false,
			 // columnSorting : {
			//	  indicator : true
	         // },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	  ftajudgstsHot = new Handsontable(ftajudgstsElement, ftajudgstsSettings);

	  //챠트
	  var ftajudgstsChartOptions = {
  			chart : {
  				height : 450,
  				type : 'bar',
  				stacked : true,
  				toolbar : {
  					show : false
  				},
  				zoom : {
  					enabled : false
  				}
  			},
  			responsive : [ {
  				breakpoint : 480,
  				options : {
  					legend : {
  						position : 'bottom',
  						offsetX : -10,
  						offsetY : 0
  					}
  				}
  			} ],
  			plotOptions : {
  				bar : {
  					horizontal : false,
  					columnWidth: '50%'
  				}
  			},
  			series : [],
  			xaxis : {
  				categories: [
			  		'ATIGA',
			  		'AIFTA',
			  		'ACFTA',
			  		'AJCEP',
			  		'AKFTA',
			  		'VCFTA',
			  		'VJEPA',
			  		'VKFTA',
			  		'AANZFTA',
			  		'EAVFTA',
			  		'AHKFTA',
			  		'EVFTA',
			  		'CPTPP',
			  		'GSP'
			  	]
  			},
  			legend : {
  				show : false
  			},
  			colors : ['#0080ff', '#f36d12'],
  			fill : {
  				colors : ['#0080ff', '#f36d12'],
  				opacity : 1
  			}
	  };

	  ftajudgstsChart = new ApexCharts(document.querySelector("#ftajudgstsChart"), ftajudgstsChartOptions);
	  ftajudgstsChart.render();

	  //검색구분 변경
	  $("input[name=ftajudgsts_srch3]").change(function(){
		  fn_searchFtajudgsts();
	  });

	  fn_searchFtajudgsts();

});

//검색
function fn_searchFtajudgsts(){
	var starDt = $("#ftajudgsts_srch1");
	var endDt = $("#ftajudgsts_srch2");

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
		url : "/stat/selectFtajudgstsList.do",
		data : fn_setFtajudgstsForm(),
		dataType: "json",
        success : function(data) {
        	ftajudgstsHot.loadData([]);
        	ftajudgstsHot.loadData(data.resultList);

        	var title = colmonth;
        	var srchTp = $("input:radio[name=ftajudgsts_srch3]:checked").val();
        	if(srchTp == "01"){
        		title = coldate;
        	}else if(srchTp == "03"){
        		title = colquarter;
        	}else if(srchTp == "04"){
        		title = colyear;
        	}

        	ftajudgstsHot.updateSettings({
        		nestedHeaders: [
    	    	    [ title,
    	    	      {label:'ATIGA', colspan:2},
    	    	      {label:'AIFTA', colspan:2},
    	    	      {label:'ACFTA', colspan:2},
    		    	  {label:'AJCEP', colspan:2},
    		    	  {label:'AKFTA', colspan:2},
    		    	  {label:'VCFTA', colspan:2},
    		    	  {label:'VJEPA', colspan:2},
    		    	  {label:'VKFTA', colspan:2},
    		    	  {label:'AANZFTA', colspan:2},
    		    	  {label:'EAVFTA', colspan:2},
    		    	  {label:'AHKFTA', colspan:2},
    		    	  {label:'EVFTA', colspan:2},
    		    	  {label:'CPTPP', colspan:2},
    		    	  {label:'GSP', colspan:2}
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
        	    	  colnrigin,
        	    	  colorigin,
        	    	  colnrigin,
        	    	  colorigin,
        	    	  colnrigin,
        	    	  colorigin,
        	    	  colnrigin
    	    		]
    	    	  ]
			});

        	//챠트업데이트
        	var ftaSeries = [];
        	var ftaName = {};
        	ftaName["name"] = colorigin;
        	var nameArray = [];

        	var ftaData = {};
        	ftaData["name"] = colnrigin;
        	var dataArray = [];

        	var oAtigaSum = 0, nAtigaSum = 0, oAiftaSum = 0, nAiftaSum = 0, oAcftaSum = 0, nAcftaSum = 0,
        	    oAjcepSum = 0, nAjcepSum = 0, oAkftaSum = 0, nAkftaSum = 0, oVcftaSum = 0, nVcftaSum = 0,
        	    oVjepaSum = 0, nVjepaSum = 0, oVkftaSum = 0, nVkftaSum = 0, oAanzftaSum = 0, nAanzftaSum = 0,
        	    oEavftaSum = 0, nEavftaSum = 0, oAhkftaSum = 0, nAhkftaSum = 0, oEvftaSum = 0, nEvftaSum = 0,
        	    oCptppSum = 0, nCptppSum = 0, oGspSum = 0, nGspSum = 0;

        	for(var i=0; i<data.resultList.length; i++){
        		oAtigaSum = oAtigaSum + data.resultList[i].oAtiga;
        		nAtigaSum = nAtigaSum + data.resultList[i].nAtiga;

        		oAiftaSum = oAiftaSum + data.resultList[i].oAifta;
        		nAiftaSum = nAiftaSum + data.resultList[i].nAifta;

        		oAcftaSum = oAcftaSum + data.resultList[i].oAcfta;
        		nAcftaSum = nAcftaSum + data.resultList[i].nAcfta;

        		oAjcepSum = oAjcepSum + data.resultList[i].oAjcep;
        		nAjcepSum = nAjcepSum + data.resultList[i].nAjcep;

        		oAkftaSum = oAkftaSum + data.resultList[i].oAkfta;
        		nAkftaSum = nAkftaSum + data.resultList[i].nAkfta;

        		oVcftaSum = oVcftaSum + data.resultList[i].oVcfta;
        		nVcftaSum = nVcftaSum + data.resultList[i].nVcfta;

        		oVjepaSum = oVjepaSum + data.resultList[i].oVjepa;
        		nVjepaSum = nVjepaSum + data.resultList[i].nVjepa;

        		oVkftaSum = oVkftaSum + data.resultList[i].oVkfta;
        		nVkftaSum = nVkftaSum + data.resultList[i].nVkfta;

        		oAanzftaSum = oAanzftaSum + data.resultList[i].oAanzfta;
        		nAanzftaSum = nAanzftaSum + data.resultList[i].nAanzfta;

        		oEavftaSum = oEavftaSum + data.resultList[i].oEavfta;
        		nEavftaSum = nEavftaSum + data.resultList[i].nEavfta;

        		oAhkftaSum = oAhkftaSum + data.resultList[i].oAhkfta;
        		nAhkftaSum = nAhkftaSum + data.resultList[i].nAhkfta;

        		oEvftaSum = oEvftaSum + data.resultList[i].oEvfta;
        		nEvftaSum = nEvftaSum + data.resultList[i].nEvfta;

        		oCptppSum = oCptppSum + data.resultList[i].oCptpp;
        		nCptppSum = nCptppSum + data.resultList[i].nCptpp;

        		oGspSum = oGspSum + data.resultList[i].oGsp;
        		nGspSum = nGspSum + data.resultList[i].nGsp;
        	}

        	nameArray.push(oAtigaSum);
        	dataArray.push(nAtigaSum);

    		nameArray.push(oAiftaSum);
    		dataArray.push(nAiftaSum);

    		nameArray.push(oAcftaSum);
    		dataArray.push(nAcftaSum);

    		nameArray.push(oAjcepSum);
    		dataArray.push(nAjcepSum);

    		nameArray.push(oAkftaSum);
    		dataArray.push(nAkftaSum);

    		nameArray.push(oVcftaSum);
    		dataArray.push(nVcftaSum);

    		nameArray.push(oVjepaSum);
    		dataArray.push(nVjepaSum);

    		nameArray.push(oVkftaSum);
    		dataArray.push(nVkftaSum);

    		nameArray.push(oAanzftaSum);
    		dataArray.push(nAanzftaSum);

    		nameArray.push(oEavftaSum);
    		dataArray.push(nEavftaSum);

    		nameArray.push(oAhkftaSum);
    		dataArray.push(nAhkftaSum);

    		nameArray.push(oEvftaSum);
    		dataArray.push(nEvftaSum);

    		nameArray.push(oCptppSum);
    		dataArray.push(nCptppSum);

    		nameArray.push(oGspSum);
    		dataArray.push(nGspSum);

        	ftaName["data"] = nameArray;
        	ftaData["data"] = dataArray;

        	ftaSeries.push(ftaName);
        	ftaSeries.push(ftaData);

        	var resultOption = {
        			series: ftaSeries
      	    };
        	ftajudgstsChart.updateOptions(resultOption);

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
		if (window.event.keyCode == 13 && $("#tabs-ftajudgsts").hasClass("active")) {
			fn_searchFtajudgsts();
		}
	}
})

//검색조건 생성
function fn_setFtajudgstsForm(){
	var sData = {};
	sData["srch1"] = $("#ftajudgsts_srch1").val();
	sData["srch2"] = $("#ftajudgsts_srch2").val();
	sData["srch3"] = $("input:radio[name=ftajudgsts_srch3]:checked").val();
	return sData;
};

//검색조건 초기화
function fn_clearFtajudgsts(){
	$("#ftajudgsts_srch1").val(fn_gFmtDate(1,"/"));
    $("#ftajudgsts_srch2").val(fn_gFmtDate(0,"/"));
	$("input:radio[name=ftajudgsts_srch3]")[1].checked = true;
};


$(document).mousedown(function(e){	
	if(e.target.name == "statFtaJudg1_date" || e.target.name == "statFtaJudg2_date"){
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