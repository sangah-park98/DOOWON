var dashboardYy;

$(document).ready(function() {
	dashboardYy = new Date().getFullYear();

	// 대시보드 정보검색
	//fn_selectDashboadInfo();
	//fn_moreNotice($("#moreNoticeList"));
	$("#chartTarget a").click(function() {
		$('.subOutter ol li #' + $(this).attr('id')).click();
		$('.subOutter, .bg').hide();

	})

	
	fn_dashInfo1("01");
	
});


function fn_rptType(type){
	if (type=="01"){
		const tabType1 = document.querySelector('.status-tab-exp');
		const tabType2 = document.querySelector('.status-tab-imp');
		tabType1.classList.add("active");
	    tabType2.classList.remove("active");
	} else {
		const tabType1 = document.querySelector('.status-tab-exp');
		const tabType2 = document.querySelector('.status-tab-imp');
	    tabType1.classList.remove("active");
	    tabType2.classList.add("active");
	}
	fn_dashInfo1(type);
}

function fn_dashInfo1(type){
	
	document.querySelector('#myChart').remove();
    document.querySelector('.myChartClass').innerHTML = '<canvas id="myChart" height="255"></canvas>'
	
	
	fn_loading(true);
	var sData = {};
	sData["srch1"] = type;
	
	$.ajax({
		type : "POST",
		url : "/dash/selectDashboardInfo1.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			$("#dashInfo1").html('');
			var newRow = "";
			var labelDate = [];  		// x축 값
			var expCnt = [];  		// 건수 값
			var expKrw = []; 
			// 금액 값
			var impCnt = [];  		// 건수 값
			var impKrw = []; 		// 금액 값
			var impTax = []; 		// 금액 값
				
				for (var i = 0; i < data.resultList.length; i++) {
					newRow = "<tr>" +
								 "<td id='sumDate'>"+data.resultList[i].sumDate + "</td>" +
								 "<td>"+data.resultList2[i].cnt + "</td>" +
								 "<td>"+data.resultList2[i].sumTax + "</td>" +
								 "<td>"+data.resultList2[i].sumKrw + "</td>" +
								 "<td>"+data.resultList[i].cnt + "</td>" +
								 "<td>"+data.resultList[i].sumKrw + "</td>" +
								 "</tr>"
					$("#dashInfo1").append(newRow);
				}
				
				for (var i = data.resultList.length - 1; i >= 0; i--) {
					labelDate.push(data.resultList[i].sumDate);
					expCnt.push(data.resultList[i].cnt);
					
					impCnt.push(data.resultList2[i].cnt);
					
					var strNumber = data.resultList[i].sumKrw;
					var number = parseInt(strNumber.replace(/,/g, ""), 10);
					
					var strNumber2 = data.resultList2[i].sumKrw;
					var number2 = parseInt(strNumber2.replace(/,/g, ""), 10);
					
					var strNumber3 = data.resultList2[i].sumTax;
					var number3 = parseInt(strNumber3.replace(/,/g, ""), 10);
					expKrw.push(number);
					impKrw.push(number2);
					impTax.push(number3);
				}
			// 차트 생성
		if (type == "01"){
		  	var ctx = document.getElementById('myChart').getContext('2d');
		  	var myChart = new Chart(ctx, {
		    	type: 'bar',
		    	data: {
		      		labels: labelDate,
		      		datasets: [
		        		{
		          			type: 'bar',
		          			label: '수출가격(KRW)',
		          			data: expKrw,
		          			backgroundColor: 'rgba(255, 99, 132, 0.2)',
		          			borderColor: 'rgba(255, 99, 132, 1)',
		          			borderWidth: 1,
		          			yAxisID: 'bar-y-axis'
		        		},
		        		{
		          			type: 'line',
		          			label: '건수',
		          			data: expCnt,
		          			backgroundColor: 'rgba(54, 162, 235, 0.2)',
		          			borderColor: 'rgba(54, 162, 235, 1)',
		          			borderWidth: 1,
		          			fill: false,
		          			yAxisID: 'line-y-axis'
		        		}
		      		]
		    	},
		    options: {
		      		scales: {
		      			'bar-y-axis': {
		  					id: 'bar-y-axis',
		  					type: 'linear',
		  					position: 'left',
		  					beginAtZero: true
						},
		        		'line-y-axis': {
		  					id: 'line-y-axis',
		  					type: 'linear',
		  					position: 'right',
		 	 				beginAtZero: true
		        		}
		    		}
		    	}
			});
				} else {
					var ctx = document.getElementById('myChart').getContext('2d');
				  	var myChart = new Chart(ctx, {
				    	type: 'bar',
				    	data: {
				      		labels: labelDate,
				      		datasets: [
				        		{
				          			type: 'bar',
				          			label: '수입가격(KRW)',
				          			data: impKrw,
				          			backgroundColor: 'rgba(255, 99, 132, 0.2)',
				          			borderColor: 'rgba(255, 99, 132, 1)',
				          			borderWidth: 1,
				          			yAxisID: 'bar-y-axis'
				        		},
				        		{
				          			type: 'bar',
				          			label: '납부세액(KRW)',
				          			data: impTax,
				          			backgroundColor: 'rgba(155, 200, 50, 0.2)',
				          			borderColor: 'rgba(155, 200, 50, 1)',
				          			borderWidth: 1,
				          			yAxisID: 'bar-y-axis'
				        		},
				        		{
				          			type: 'line',
				          			label: '건수',
				          			data: impCnt,
				          			backgroundColor: 'rgba(54, 162, 235, 0.2)',
				          			borderColor: 'rgba(54, 162, 235, 1)',
				          			borderWidth: 1,
				          			fill: false,
				          			yAxisID: 'line-y-axis'
				        		}
				      		]
				    	},
				    options: {
				      		scales: {
				      			'bar-y-axis': {
				  					id: 'bar-y-axis',
				  					type: 'linear',
				  					position: 'left',
				  					beginAtZero: true
								},
								
				        		'line-y-axis': {
				  					id: 'line-y-axis',
				  					type: 'linear',
				  					position: 'right',
				 	 				beginAtZero: true
				        		}
				    		}
				    	}
					});
				}
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



// 공지사항 클릭
function fn_callNoticePop(noticeSeq) {
	$("#dashNoticePop").find("input").val(null);
	$("#dashNoticePop").find("textarea").val(null);
	$("#dashNoticePop").modal("show");
	$("#notiIcon" + noticeSeq + " #newicon").hide();

	var uData = {};
	uData["srch1"] = noticeSeq;
	$.ajax({
		type : "POST",
		url : "/base/updateReadNotice.do",
		data : JSON.stringify(uData),
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			if (data == "success") {
				fn_searchDashNotice(noticeSeq);
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

// 공지사항 팝업검색
function fn_searchDashNotice(noticeSeq) {
	var sData = {};
	sData["srch1"] = noticeSeq;

	$.ajax({
		type : "POST",
		url : "/dash/selectDashNoticeInfo.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			if (data.result.dashFileNm == undefined
					|| data.result.dashFileNm == "") {
				$("#dashNoticeAttach").hide();
			} else {
				$("#dashNoticeAttach").show();
			}

			$.each(data.result, function(key, value) {
				$("#dashNoticePop").find("input[name='" + key + "']")
						.val(value);
				$("#dashNoticePop").find("textarea[name='" + key + "']").val(
						value);
			});
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

// 읽음체크
function fn_noticeReadCheck() {
	for (i = 0; i < colReadList.length; i++) {
		$("#notiIcon" + colReadList[i] + " #newicon").hide();
	}
}

// 공지사항 조회
function fn_moreNotice(elemVal) {
	elemVal.val(Number(elemVal.val()) + 10);
	var nData = {};
	nData["startPoint"] = Number(elemVal.val());
	$.ajax({
		type : "POST",
		url : "/base/selectMoreNoticeList.do",
		data : nData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : "json",
		success : function(data) {
			colNoticecnt = data.totCnt;
			setTimeout(function() {
				fn_noticeList(data)
			}, 0.0001);
		},
		error : function(e, textStatus, errorThrown) {
			if(e.status == 400){
        		alert("Your request is up. Please log back in if you wish continue");
        		location.href = document.referrer;
        	} else {
				console.log(errorThrown);
				// alert(msgSearchError);
        	}
		}
	});

}

// 리스트 그려주는 부분
function fn_noticeList(data) {
	if (data.totCnt > Number($("#moreNoticeList").val()) - 10
			|| $("#moreNoticeList").val() == "0") {
		$("#noticeTbl tbody").children().remove();
		var rowData;
		for (var i = 0; i < data.noticeList.length; i++) {
			rowData = data.noticeList[i];
			var rowText = "<tr>";
			rowText = rowText + "<tr onclick='fn_callNoticePop("
					+ rowData.noticeSeq + ")' style='cursor:pointer;'>";
			rowText = rowText + "<td>" + rowData.noticeSn + "</td>";
			rowText = rowText + "<td align='left' id='notiTit"
					+ rowData.noticeSeq + "'>" + rowData.title + "</td>";
			rowText = rowText
					+ "<td id='notiIcon"
					+ rowData.noticeSeq
					+ "'><span class='badge badge-info' style='margin-right:5px' id='newicon'>NEW</span></td>"
			rowText = rowText + "<td >" + rowData.regDt + "</td> ";
			rowText = rowText + "</tr>";
			$("#noticeTbl tbody").append(rowText);
			$("#noticeTbl").css("border-collapse", "collapse")
			$("#noticeTbl tbody").css("overflow-y", "hidden ")
			// $("#noticeTbl tbody").css("height","300px")
		}
		fn_noticeReadCheck();
	} else {
		alert(msgNotice);
	}
};

// 공지사항 파일다운로드
function fn_downDashNotice() {
	document.dashNoticeFileForm.action = "/dash/downDashNoticeFile.do";
	document.dashNoticeFileForm.submit();
};

// notice modal popup
$('ul.bg-white li').on('click', function(){
	var dashNoticeSeq = $(this).find('p.text-sm:hidden').text();
	console.log(dashNoticeSeq);
    $('#dashNoticePop').show();
    fn_dashNoticeModalContentPopUp(dashNoticeSeq);
});


function fn_dashNoticeModalContentPopUp(dashNoticeSeq){
	var sData = {};
	sData["srch3"] = dashNoticeSeq;
	$.ajax({
		type : "POST",
		url : "/base/selectDashNoticeViewList.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	fillDashNoticeModalContent(data.resultList);
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

function fillDashNoticeModalContent(resultList) {
    var notice = resultList[0];
    var noticeDt = notice.noticeDt;
    var year = noticeDt.substring(0, 4);
    var month = noticeDt.substring(4, 6);
    var day = noticeDt.substring(6, 8);
    var formattedNoticeDt = year + "." + month + "." + day;
    
    var edtDt = notice.edtDt;

    document.querySelector('.dashNotice-modal h3').textContent = notice.titleKr;
    document.querySelector('.dashNotice-modal span').textContent = notice.date;
    // document.querySelector('.dashNotice-modal span').textContent = notice.edtDt;
    document.querySelector('.dashNotice-modal textarea').textContent = notice.cnKr;
    
    var strHtml = "";
    if (notice.fileOrgNm) {
        strHtml = '<a href="#" id="dashDownload" style="color:#030303"><i class="fa-regular fa-floppy-disk"></i> 첨부파일 : ' + notice.fileOrgNm + '</a>';
    }
    
    var dateInfo = document.querySelector('.dashNotice-modal .text-sm');
    if(edtDt == '' || edtDt == null) {
    	dateInfo.textContent = '등록일: ' + formattedNoticeDt;
    } else {
    	/*var edtyear = edtDt.substring(0, 4);
        var edtmonth = edtDt.substring(4, 6);
        var edtday = edtDt.substring(6, 8);
        var formattedEdtDt = edtyear + "." + edtmonth + "." + edtday;
    	dateInfo.textContent = '등록일: ' + formattedNoticeDt + ' , 수정일: ' + formattedEdtDt;*/
    }
    dateInfo.style.fontSize = '13px';
    
    document.querySelector('.dashNotice-modal .text-base').innerHTML = strHtml;
    
    var dashDownloadLink = document.getElementById('dashDownload');
    if (notice.fileOrgNm) {
	    dashDownloadLink.addEventListener('mouseenter', function() {
	    dashDownloadLink.style.color = 'rgb(45 126 98)';
	    dashDownloadLink.style.fontWeight = 'bold';
	    });
	
		dashDownloadLink.addEventListener('mouseleave', function() {
			 dashDownloadLink.style.color = '#030303';
			 dashDownloadLink.style.fontWeight = '';
		});
    }
}


$(document).on('click', '#dashDownload', function(){
	const htmlContent = event.target.innerHTML.trim();
	const fileOrgNm = htmlContent.split(' 첨부파일 : ')[1];
    $("#dashFileDown").val(fileOrgNm);
    document.dashFileDownForm.action = "/cmmn/dashFileDown.do";
    document.dashFileDownForm.submit();
})

// news modal popUp 
function dashNoticeClose(){
	$("#dashNoticePop").hide();
}

$('div.bg-blue li').on('click', function(){
	var dashNewsSeq = $(this).find('p.text-sm:hidden').text();
    $('#dashNewsPop').show();
    fn_dashNewsModalContentPopUp(dashNewsSeq);
});


function fn_dashNewsModalContentPopUp(dashNewsSeq){
	var sData = {};
	sData["srch3"] = dashNewsSeq;
	$.ajax({
		type : "POST",
		url : "/cmmn/selectNewsModalViewList.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType: "json",
        success : function(data) {
        	console.log(data);
        	filldashNewsModalContent(data.resultList);
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


function filldashNewsModalContent(resultList) {
    var news = resultList[0];
    var regDt = news.regDt;
    var year = regDt.substring(0, 4);
    var month = regDt.substring(4, 6);
    var day = regDt.substring(6, 8);
    var formattedNewsDt = year + "." + month + "." + day;
    
    var edtDt = news.edtDt;
    
    document.querySelector('.dashNews-modal h3').textContent = news.titleKr;
    document.querySelector('.dashNews-modal span').textContent = news.regDt;
    // document.querySelector('.dashNews-modal span').textContent = news.edtDt;
    //document.querySelector('.dashNews-modal textarea').textContent = news.cnKr;
    $("#dashNewsContent").html(news.cnKr);
    
    var dateInfo = document.querySelector('.dashNews-modal .text-sm');
    if(edtDt == '' || edtDt == null ) {
    	dateInfo.textContent = '등록일: ' + formattedNewsDt;
    } else {
        /*var edtyear = edtDt.substring(0, 4);
        var edtmonth = edtDt.substring(4, 6);
        var edtday = edtDt.substring(6, 8);
        var formattedEdtDt = edtyear + "." + edtmonth + "." + edtday;
        
    	dateInfo.textContent = '등록일: ' + formattedNewsDt + ' , 수정일: ' + formattedEdtDt;*/
    }
    dateInfo.style.fontSize = '13px';
    
    // document.getElementById('newsTitlePopUp').style.display = 'block';
    
}

function dashNewsClose(){
	$("#dashNewsPop").hide();
}
