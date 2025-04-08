var jtsPie;
var basicPieElem;
$( document ).ready(function() {
	//달력 사용시 반드시 넣어주세요.
	//datepicker -> band-calendar 클래스 교체 해주세요
	$('.band-calendar').each(function(){ regCal(this) ;})
	  //캘린더 포맷
      $('.datepicker').datepicker("option","dateFormat",calFormat);

      $("#judgtrgetsts_srch1").val(fn_gFmtDate(1,"/"));
      $("#judgtrgetsts_srch2").val(fn_gFmtDate(0,"/"));

	  var judgtrgetstsElement = document.querySelector('#judgtrgetstsTable');
	  var judgtrgetstsElementContainer = judgtrgetstsElement.parentNode;
	  var judgtrgetstsSettings = {
			  columns : [
				  {data : 'dt', type : 'text', className : "htCenter"},
				  {data : 'yCnt', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'pCnt', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'nCnt', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"},
				  {data : 'ntCnt', type : 'numeric', numericFormat : {pattern : '0,0'}, className : "htCenter"}
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
	    		  colyes,
	    		  colno,
	    		  colnissu,
	    		  colntrgt
			  ],
	    	  manualRowMove : true,
			  manualColumnMove : false,
			  contextMenu : false,
			 // dropdownMenu : false,
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

	  judgtrgetstsHot = new Handsontable(judgtrgetstsElement, judgtrgetstsSettings);


	  //챠트
//	  var jtsPieElem = document.getElementById('judgtrgetstsPie');
//	  if (jtsPieElem) {
//		  jtsPie = echarts.init(jtsPieElem);
//		  jtsPie.setOption({
//			  color: ['#0080ff', '#5fb404', '#f36d12', '#fa5858'],
//			  grid: {
//				  left: '3%',
//				  right: '4%',
//				  bottom: '3%',
//				  containLabel: true
//			  },
//			  xAxis: [{
//				  axisLine: {show: false},
//				  splitLine: {show: false}
//			  }],
//			  yAxis: [{
//				  axisLine: {show: false},
//				  splitLine: {show: false}
//			  }],
//			  series: [{
//				  name: null,
//				  type: 'pie',
//				  radius: '75%',
//				  center: ['50%', '50%'],
//				  data: [
//					  {value: 0, name: colyes + " (" + 0 + "%)"},
//	    			  {value: 0, name: colno + " (" + 0 + "%)"},
//	    			  {value: 0, name: colnissu + " (" + 0 + "%)"},
//	    			  {value: 0, name: colntrgt + " (" + 0 + "%)"}
//		    	  ],
//		    	  itemStyle: {
//		    		  emphasis: {
//		    			  shadowBlur: 10,
//		    			  shadowOffsetX: 0,
//		    			  shadowColor: 'rgba(0, 0, 0, 0.5)'
//		    		  }
//  				  }
//  	    	  }]
//  	      });
//
//  	      $(window).on('resize', function () {
//  	    	  setTimeout(function () {
//  	    		jtsPie.resize();
//  	    	  }, 500);
//  	      });
//  	  }

	  //검색구분 변경
	  $("input[name=judgtrgetsts_srch3]").change(function(){
		  fn_searchJudgtrgetsts();
	  });
	//3-1.당월 판정대상 현황 조회
	//파이차트옵션
	var mnPieOption = {
			//모든컬럼이 값이 없는경우(0인경우) 시각적 표현을 위해 조건문생성
		 series: [0,0,0,0],
		chart : {
			type : 'pie',
			height : 350,
			enabled : true,
			toolbar: {
				show: true,
		      }
		},
		//colors: ['#2E2EFE','#04B431','#FF0000','#BDBDBD'],
		colors : ['#3490de','#c1c0b9','#ffd460','#f38181'],
		labels: [colyes, colno, colnissu, colntrgt],
		  responsive: [{
	          breakpoint: 480,
	          options: {
	            chart: {
	              width: 200
	            },
	            legend: {
	              position: 'bottom'
	            }
	          }
	        }]
	};
	basicPieElem = new ApexCharts(document
			.querySelector("#judgtrgetstsPie"), mnPieOption);
	basicPieElem.render();

	fn_searchJudgtrgetsts();

});




//검색
function fn_searchJudgtrgetsts(){
	var starDt = $("#judgtrgetsts_srch1");
	var endDt = $("#judgtrgetsts_srch2");

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
		url : "/stat/selectJudgtrgetstsList.do",
		data : fn_setJudgtrgetstsForm(),
		dataType: "json",
        success : function(data) {
        	judgtrgetstsHot.loadData([]);
        	judgtrgetstsHot.loadData(data.resultList);
        	
        	var title = colmonth;
        	var srchTp = $("input:radio[name=judgtrgetsts_srch3]:checked").val();
        	if(srchTp == "01"){
        		title = coldate;
        	}else if(srchTp == "03"){
        		title = colquarter;
        	}else if(srchTp == "04"){
        		title = colyear;
        	}

        	judgtrgetstsHot.updateSettings({
				  colHeaders : [title, colyes, colno, colnissu, colntrgt]
			});
        	
        	if(data.resultList.length < 1){
        		basicPieElem.updateOptions({
            		series: [25, 25, 25, 25]
            	})

        	}else{
        		var totSum = 0;
        		var ySum = 0;
        		var pSum = 0;
        		var nSum = 0;
        		var ntSum = 0;
        		
        		var yRt = 0;
        		var pRt = 0;
        		var nRt = 0;
        		var ntRt = 0;
        		
        		for(var i=0; i<data.resultList.length; i++){
        			//totSum = totSum + data.resultList[i].totCnt;
        			ySum = ySum + data.resultList[i].yCnt;
        			pSum = pSum + data.resultList[i].pCnt;
        			nSum = nSum + data.resultList[i].nCnt;
        			ntSum = ntSum + data.resultList[i].ntCnt;
        		}
        		
        		totSum = ySum + pSum + nSum + ntSum;
        		yRt = (ySum / totSum * 100);
        		yRt = (yRt == "100" || yRt == "0") ? yRt : Number(yRt.toFixed(2));
        		
        		pRt = (pSum / totSum * 100);
        		pRt = (pRt == "100" || pRt == "0") ? pRt : Number(pRt.toFixed(2));
        		
        		nRt = (nSum / totSum * 100);
        		nRt = (nRt == "100" || nRt == "0") ? nRt : Number(nRt.toFixed(2));
        		
        		ntRt = (ntSum / totSum * 100);
        		ntRt = (ntRt == "100" || ntRt == "0") ? ntRt : Number(ntRt.toFixed(2));
        		
        		if(yRt == "NaN" && pRt == "NaN" && nRt == "NaN" && ntRt == "NaN"){
        			basicPieElem.updateOptions({
        				series: [25, 25, 25, 25]
        			})
        		}else{
        			basicPieElem.updateOptions({
        				series: [yRt, pRt, nRt, ntRt]
        			})
        		}
        	}

//        	 ApexCharts.exec(, "updateOptions", {
//        		    data :
//        		    });

//        	//챠트업데이트
//        	jtsPie.setOption({
//  			  series: [{
//  				  data: [
//  					  {value: yRt, name: colyes + " (" + yRt + "%)"},
//	    			  {value: pRt, name: colno + " (" + pRt + "%)"},
//	    			  {value: nRt, name: colnissu + " (" + nRt + "%)"},
//	    			  {value: ntRt, name: colntrgt + " (" + ntRt + "%)"}
//  		    	  ]
//    	      }]
//    	    });
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
		if (window.event.keyCode == 13 && $("#tabs-mnjudgtrgetsts").hasClass("active")) {
			fn_searchJudgtrgetsts();
		}
	}
})


//검색조건 생성
function fn_setJudgtrgetstsForm(){
	var sData = {};
	sData["srch1"] = $("#judgtrgetsts_srch1").val();
	sData["srch2"] = $("#judgtrgetsts_srch2").val();
	sData["srch3"] = $("input:radio[name=judgtrgetsts_srch3]:checked").val();
	return sData;
};

//검색조건 초기화
function fn_clearJudgtrgetsts(){
	$("#judgtrgetsts_srch1").val(fn_gFmtDate(1,"/"));
    $("#judgtrgetsts_srch2").val(fn_gFmtDate(0,"/"));
	$("input:radio[name=judgtrgetsts_srch3]")[1].checked = true;
};

$(document).mousedown(function(e){	
	if(e.target.name == "statMnjdug1_date" || e.target.name == "statMnjdug2_date"){
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