$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요. 
	//datepicker -> band-calendar 클래스 교체 해주세요 
	$('.band-calendar').each(function(){ regCal(this) ;})

	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      $("#mndocprtsts_srch1").val(fn_gFmtDate(1,"/"));
      $("#mndocprtsts_srch2").val(fn_gFmtDate(0,"/"));

	  var mndocprtstsElement = document.querySelector('#mndocprtstsTable');
	  var mndocprtstsElementContainer = mndocprtstsElement.parentNode;
	  var mndocprtstsSettings = {
			  columns : [
				  {data : 'dt', type : 'text', className : "htCenter"},
				  {data : 'cnt', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"}
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
	    	  colHeaders : [
	    		  colmonth,
	    		  colyesCnt
			  ],
	    	  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			//  dropdownMenu : false,
			  filters : true,
			  readOnly : true,
			  allowRemoveRow : false,
			//  columnSorting : {
			//	  indicator : true
	         // },
	          autoColumnSize : {
	        	  samplingRatio : 23
	          },
	          mergeCells : false,
	          allowInsertRow : false
	  };

	  mndocprtstsHot = new Handsontable(mndocprtstsElement, mndocprtstsSettings);

	  //챠트
	  var mndocprtstsChartOptions = {
			  chart: {
				  height: 500,
				  type: 'bar',
				  enabled: true
			  },
			  plotOptions: {
				  bar: {
					  horizontal: false,
					  //endingShape: 'rounded',
					  columnWidth: '10%'
				  }
	    	  },
	    	  dataLabels: {
	    		  enabled: true
	    	  },
	    	  series: [
	    		  {
	    			  name: colyes,
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
			  fill: {
				  colors : '#0080ff',
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

	  mndocprtstsChart = new ApexCharts(document.querySelector("#mndocprtstsChart"), mndocprtstsChartOptions);
	  mndocprtstsChart.render();

	  //검색구분 변경
	  $("input[name=mndocprtsts_srch3]").change(function(){
		  fn_searchMndocprtsts();
	  });

	  fn_searchMndocprtsts();

});

//검색
function fn_searchMndocprtsts(){
	var starDt = $("#mndocprtsts_srch1");
	var endDt = $("#mndocprtsts_srch2");

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
		url : "/stat/selectDocprtstsList.do",
		data : fn_setMndocprtstsForm(),
		dataType: "json",
        success : function(data) {
        	mndocprtstsHot.loadData([]);
        	mndocprtstsHot.loadData(data.resultList);

        	var title = colmonth;
        	var srchTp = $("input:radio[name=mndocprtsts_srch3]:checked").val();
        	if(srchTp == "01"){
        		title = coldate;
        	}else if(srchTp == "03"){
        		title = colquarter;
        	}else if(srchTp == "04"){
        		title = colyear;
        	}

        	mndocprtstsHot.updateSettings({
				  colHeaders : [title, colyesCnt]
			});
        	
        	var resultOption = {
    				series: [{data: []}],
    				xaxis: {categories: ['','']}
    		};
        	
        	if(data.resultList.length > 0){
        		//챠트업데이트
        		var rData = [];
        		var rCtgrs = [];
        		for(var i=0; i<data.resultList.length; i++){
        			rData.push(data.resultList[i].cnt);
        			rCtgrs.push("[ " + data.resultList[i].dt + " ]");
        		}
        		
        		resultOption = {
        				series: [{data: rData}],
        				xaxis: {categories: rCtgrs}
        		};
        	}

        	mndocprtstsChart.updateOptions(resultOption);

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
		if (window.event.keyCode == 13 && $("#tabs-mndocprtsts").hasClass("active")) {
			fn_searchMndocprtsts();
		}
	}
})

//검색조건 생성
function fn_setMndocprtstsForm(){
	var sData = {};
	sData["srch1"] = $("#mndocprtsts_srch1").val();
	sData["srch2"] = $("#mndocprtsts_srch2").val();
	sData["srch3"] = $("input:radio[name=mndocprtsts_srch3]:checked").val();
	return sData;
};

//검색조건 초기화
function fn_clearMndocprtsts(){
	$("#mndocprtsts_srch1").val(fn_gFmtDate(1,"/"));
    $("#mndocprtsts_srch2").val(fn_gFmtDate(0,"/"));
	$("input:radio[name=mndocprtsts_srch3]")[1].checked = true;
};

$(document).mousedown(function(e){	
	if(e.target.name == "statMndoc1_date" || e.target.name == "statMndoc2_date"){
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