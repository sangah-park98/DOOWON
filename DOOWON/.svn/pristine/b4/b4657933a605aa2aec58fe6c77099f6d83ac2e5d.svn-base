var cmmnPopHot;
var fnPopupCallback;
var popupData;
var calFormat;
var gridCalFormat;
var cmpnyListHot;
var count =0;  


document.addEventListener('DOMContentLoaded', function() {
    var cmpnyListPopupElement = document.querySelector('#cmpnyPopupTable');
    var cmpnyListPopupElementContainer = cmpnyListPopupElement.parentNode;
    cmpnyListPopupSettings = fn_handsonGridcmpnyListPopupOption();
    cmpnyListHot = new Handsontable(cmpnyListPopupElement, cmpnyListPopupSettings);
    
/*    var advancedRadio = document.getElementById('Client_Advanced');
    var ProRadio = document.getElementById('Client_Pro');
    var basicRadio = document.getElementById('Client_Basic');
    var paymentOptions = document.getElementById('paymentOptions');
    var paymentName = document.getElementById('paymentName');
    
    
    paymentOptions.classList.add('hidden'); 
    paymentName.classList.add('hidden'); 
    
    advancedRadio.addEventListener('change',()=>{
    	console.log("11");
    	if(advancedRadio.checked || ProRadio.checked){
    		 paymentOptions.classList.remove('hidden'); // 변경
    		 paymentName.classList.remove('hidden'); // 변경
    	}
    });

    ProRadio.addEventListener('change',()=>{
    	console.log("22");
    	if(advancedRadio.checked || ProRadio.checked){
    		paymentOptions.classList.remove('hidden'); // 변경
   		 	paymentName.classList.remove('hidden'); // 변경		
    	}
    });
    
    basicRadio.addEventListener('change', () => {
        console.log("33");
        if (basicRadio.checked) {
            paymentOptions.classList.add('hidden');
            paymentName.classList.add('hidden');
        }
    });*/

});



/*$( document ).ready(function() {
	setTimeout(getJoinCodeArray, 200);
});*/

function fn_searchCmpny(){

	$("#searchCmpnyPopUp").modal("show");

    fn_searchCmpnyPopup();
};


function cmpnySearchPopupClose(){
	$("#searchCmpnyPopUp").modal("hide");
}


function enterKeyPopUp() {
	if (window.event.keyCode == 13) {
		fn_searchCmpnyPopup();
    }
}




function fn_searchCmpnyPopup(){
	var sData = {};
	sData["srch1"] = $('#cmpnySrch1').val();
	fn_loading(true);
	
	$.ajax({
		type : "POST",
		url : "/member/selectJoinSearchCmpnyList.do",
		data : sData,
		beforeSend : function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX", "true");
		},
		dataType : 'json',
		async: false,
        success : function(data) {
        	cmpnyListHot.loadData([]);
        	cmpnyListHot.loadData(data.resultList);
			setTimeout(function() {cmpnyListHot.render()}, 200);
        	fn_loading(false);
        },
        error : function(e, textStatus, errorThrown) {
        	if(e.status == 400){
        		alert("에러 발생");
        		//location.href = document.referrer;
        	} else {
	        	console.log(errorThrown);
	        	alert(msgSearchError);
        	}
        }
	});
}


function fn_handsonGridcmpnyListPopupOption() {
    cmpnyListPopupSettings = {
        columns: [
        	{ data: 'taxNo', type: 'text', className: "htCenter", readOnly: true },
        	{ data: 'cmpnyNm', type: 'text', className: "htCenter", readOnly: true },
        ],
        stretchH: 'all',
        width: '100%',
        autoWrapRow: true,
        height: 250,
        rowHeights: 25,
        rowHeaders: true,
        columnHeaderHeight: 25,
        colHeaders: ["사업자 번호", "회사 명"], 
        manualRowResize: true,
        manualColumnResize: true,
        manualRowMove: true,
        manualColumnMove: false,
        contextMenu: false,
        dropdownMenu: false,
        filters: true,
        readOnly: false,
        columnSorting: { indicator: true },
        autoColumnSize: { samplingRatio: 23 },
        mergeCells: false,
        allowInsertRow: false,
        hiddenColumns: { copyPasteEnabled: false, indicators: false, columns: [] },
        
        afterOnCellMouseDown : function(event, coords, td) {
        	console.log("coords: " + JSON.stringify(coords));
        	console.log("event: " + JSON.stringify(event));
        	console.log("td: " + JSON.stringify(td));
			var now = new Date().getTime();
			/*if (!(td.lastClick && now - td.lastClick < 200)
					|| coords.row < 0 || coords.col < 0) {
				td.lastClick = now;
				return;
			}*/

			//fn_selectCmpnyPop(coords);
		}
    };

    return cmpnyListPopupSettings;
}


function fn_selectCmpnyPop(coords) {

	let coordsObj = JSON.parse(coords);
	
	
	
    console.log("count"+count);
 // resultList에서 taxNo와 cmpnyNm 추출
	const taxNo = coordsObj.resultList[0].taxNo;
	const cmpnyNm = coordsObj.resultList[0].cmpnyNm;
	
    console.log("taxNo: " + taxNo);
    console.log("cmpnyNm: " + cmpnyNm);
    
    $("#searchCmpnyPopUp").modal("hide");
    
    $("#usrCmpnyCd").val(cmpnyNm);
    $("#usrtaxNo").val(taxNo);
	//document.mainForm.submit();
	 
	var companyNameInput = document.getElementsByName("COMP_NAME[" + count + "]")[0];
	var companyNumberInput = document.getElementsByName("COMP_REG_NO[" + count + "]")[0];
	    
    companyNameInput.value = cmpnyNm;
    companyNumberInput.value = taxNo;
};


function getJoinCodeArray(){
    let url = window.location.href;
    document.querySelector('#LANG').value = url.split("=")[1];
    param = {CODE_GROUP_ID : "joinCode", LANG : url.split("=")[1]}
    jsonAjaxAsync("joinCode", "/code/commonCodeList", param, "POST", joinCodeArraySet)
}

function joinCodeArraySet(reData){

    for(let data of reData) {
        for(let code of joinCodeArray) {
            if(code["CODE_COMMON_ID"] == data["CODE_COMMON_ID"]) {
                code["CODE_NAME"] = data["CODE_NAME"];
            }
        }
    }
    $.unblockUI();
}

function addRow(event) {
	var newRow = "";
	count++;
    
	newRow =
        '<div class="companySets grid grid-cols-[1fr_2.4fr_1fr] gap-x-2 gap-y-1 items-center">'+
        '<label for="company_name" class="text-primary-700 font-semibold px-2 text-left row-start-2">사업자 명</label>' +
        '<input type="text" readonly id="company_name" name="COMP_NAME[' + count + ']" class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg row-start-2" placeholder="사업자 명을 입력해주세요.">' +
        '<label for="company_number" class="text-primary-700 font-semibold px-2 text-left">사업자 번호</label>' +
        '<input type="text" id="company_number" name="COMP_REG_NO[' + count + ']" oninput="removeHyphen(event)" class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg" placeholder="사업자 번호를 입력해주세요.">'+
        '<input type="hidden" id="REGNO_CHECK_' + count + '" name="REGNO_CHECK[' + count + ']" value="N"/>'+ 
        '<button type="button" class="block w-full py-1 px-2.5 font-semibold text-center text-white border border-secondary-700 bg-secondary-700 rounded-lg hover:bg-secondary-800 focus:ring-4 focus:ring-secondary-300 dark:bg-secondary-600 dark:hover:bg-secondary-700 dark:focus:ring-secondary-800 leading-6" onclick="regNoValidation(' + count + ')">사업자 번호 인증</button>'+
        '<svg xmlns="http://www.w3.org/2000/svg" height="17" width="17" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path fill="#b71f1f" d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM184 232H328c13.3 0 24 10.7 24 24s-10.7 24-24 24H184c-13.3 0-24-10.7-24-24s10.7-24 24-24z" onclick="removeRow(this)"/></svg>' +
        '<div class="col-span-3 my-3 h-[1px] bg-gray-200 mx-10 row-start-3"></div>';
    $('#companySet1').append(newRow);

}

function removeRow(button) {
    // 현재 행을 찾아 삭제.
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

function showDetails(id) {
	   var details = document.getElementById(id);
	   if (details.style.display === "none") {
	     details.style.display = "block";
	   } else {
	     details.style.display = "none";
	   }
	 }
function toggleAllAgree() {
	    var allAgreeCheckbox = document.getElementsByName('allAgree')[0];
	    var shinhnAgreeCheckbox = document.getElementById('SHINHAN_AGREE');
	    var privacyAgreeCheckbox = document.getElementById('PRIVACY_AGREE');
	    
	    // "모든 약관에 동의합니다" 체크박스의 상태에 따라 다른 체크박스들의 상태를 변경
	    shinhnAgreeCheckbox.checked = allAgreeCheckbox.checked;
	    privacyAgreeCheckbox.checked = allAgreeCheckbox.checked;
	}


/*function addRow() {
	  // 새로운 사업자 세트를 생성
	  var newRow = document.createElement('div');
	  newRow.innerHTML = `
	    <label for="company_name" class="text-primary-700 font-semibold px-2 text-left">사업자 명</label>
	    <input
	      type="text"
	      id="company_name"
	      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
	      placeholder="사업자 명을 입력해주세요."
	    >
	    <label for="company_number" class="text-primary-700 font-semibold px-2 text-left">사업자 번호</label>
	    <input
	      type="text"
	      id="company_number"
	      class="bg-gray-50 border border-gray-300 text-gray-900 rounded-lg focus:ring-primary-500 focus:border-primary-500 block py-1 px-2.5 text-lg"
	      placeholder="사업자 번호를 입력해주세요."
	    >
	  `;
	  
	  // 새로운 사업자 세트를 추가
	  document.getElementById('companySets').appendChild(newRow);
	}
*/
// 사업자 + 
function collectData() {
    var compnyRows = document.querySelectorAll('#cmpnyRows tr');
    var formData = { compnyList: [] };

    compnyRows.forEach(function (row, index) {
        var compName = row.querySelector('input[name^="compnyList["][name$="].compName"]').value;
        var compRegNo = row.querySelector('input[name^="compnyList["][name$="].compRegNo"]').value;

        formData.compnyList.push({
            compName: compName,
            compRegNo: compRegNo
        });
    });

    return formData;
}

//입력값이 변경될 때마다 호출되는 함수
function checkInput() {
    var input = document.getElementById("MEMBER_ID").value;
    var message = document.querySelector('.member-id-text');
    var button = document.querySelector('button');

    if (input.match(/[^\x00-\x7F]+/)) { // 한글이 포함되어 있는지 확인
        message.innerHTML = '● 5~20자의 영문,숫자와 특수기호(_),(-)만 사용 가능합니다.';
        message.style.color = 'red';
        button.disabled = true; // 중복체크 버튼 비활성화
    } else {
        message.innerHTML = '● 중복체크를 해주세요.';
        message.style.color = 'red';
        button.disabled = false; // 중복체크 버튼 활성화
    }
}

/* - 없애기 */
function removeHyphen(){
	
	var phoneNumber = document.getElementById('MEMBER_TEL').value;
	var cmpyRegNo = document.getElementById('COMP_REG_NO').value;
	 	
		phoneNumber = phoneNumber.replace(/-/g, '');
	 	cmpyRegNo = cmpyRegNo.replace(/-/g, '');
	 	
	 	document.getElementById('MEMBER_TEL').value = phoneNumber;
	 	document.getElementById('COMP_REG_NO').value = cmpyRegNo;
}

/* 아이디 중복체크 */
function idCheck(){
	if(!document.querySelector('#MEMBER_ID').value){
		alert("아이디를 입력해 주세요.");
		document.querySelector('#MEMBER_ID').focus();
		return false;
	}

    /*if(document.querySelector('#MEMBER_ID').value.length < 8) {
        alert("아이디는 8자 이상 작성해주세요.");
        document.querySelector('#MEMBER_ID').focus();
        return false;
	}*/
	var param = document.querySelector('#MEMBER_ID').value;
	console.log('param'+param);
	$.ajax({
	    type: "POST",
	    url: "/member/idCheck.do",
	    data: {usrId: param}, // 객체를 그대로 전송
	    /*beforeSend: function (xmlHttpRequest) {
	        xmlHttpRequest.setRequestHeader("AJAX", "true");
	    },*/
	    dataType: "text",
	    success: function (data) {
	        console.log("Returned data: " + data);
	        idCheckCallback(data);
	    },
	    error: function (e, textStatus, errorThrown) {
	        if (e.status == 400) {
	            alert("Your request is up. Please log back in if you wish to continue");
	            location.href = document.referrer;
	        } else {
	            console.log(errorThrown);
	            alert("An error occurred while checking the ID.");
	        }
	    }
	});
}

function idCheckCallback(data) {
    var xmlDoc = new DOMParser().parseFromString(data, "text/xml"); // XML 파싱
    var parsedData = parseInt(xmlDoc.querySelector("Integer").textContent); // XML에서 숫자 추출
    console.log('reData>' + parsedData);

    if (parsedData > 0) {
        document.querySelector('#MEMBER_ID_CHK').value = parsedData;
        document.querySelector('.member-id-text').style.color = "red";
        document.querySelector('.member-id-text').innerHTML = '● 중복된 아이디입니다.';
        /*  $.unblockUI();*/  // $.blockUI 이후에 $.unblockUI가 호출되도록 확인
    } else {
        document.querySelector('#MEMBER_ID_CHK').value = 0;
        document.querySelector('.member-id-text').style.color = "#55A5B7";
        document.querySelector('.member-id-text').innerHTML = '● 사용가능한 아이디입니다.';
        /*$.unblockUI(); */ // $.blockUI 이후에 $.unblockUI가 호출되도록 확인
    }
}

/* 비밀번호 체크 */
function memberPassChk(str){
	console.log("str>>"+str);
	let memberPass = document.querySelector('#MEMBER_PASS'); //비밀번호
	let memberPassChk = document.querySelector('#MEMBER_PASS_CHK'); //비밀번호확인
	let passCheck1 = document.querySelector('.passCheck1'); //비밀번호
	let passCheck2 = document.querySelector('.passCheck2'); //비밀번호 확인
	if (str == 'pw') {
        if (memberPass.value != "") {
            let chk_num = memberPass.value.search(/[0-9]/g);
            let chk_small_eng = memberPass.value.search(/[a-z]/);
            let chk_large_eng = memberPass.value.search(/[A-Z]/);
            let chk_spe = memberPass.value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

            if (!/^(?=.*[a-zA-Z0-9])((?=.*\d)|(?=.*\W)).{5,20}$/.test(memberPass.value)) {
                passCheck1.innerHTML = '● 비밀번호(대문자, 소문자, 특수문자, 숫자 포함, 5~20자리)를 입력해주세요';
                passCheck1.style.color = "red";
                return;
            } else if (chk_small_eng < 0) {
                passCheck1.innerHTML = '● 비밀번호에 하나 이상의 영문 소문자가 포함되어야 합니다.';
                passCheck1.style.color = "red";
                return;
            } else if(chk_large_eng < 0){
                passCheck1.innerHTML = '● 비밀번호에 하나 이상의 영문 대문자가 포함되어야 합니다.';
                passCheck1.style.color = "red";
                return;
           } else if (chk_spe < 0) {
                passCheck1.innerHTML = '● 비밀번호에 하나 이상의 특수문자가 포함되어야 합니다.';
                passCheck1.style.color = "red";
                return;
            } else if (chk_num < 0) {
				passCheck1.innerHTML = '● 비밀번호에 하나 이상의 숫자가 포함되어야 합니다.';
                passCheck1.style.color = "red";
                return;
			} else {
                passCheck1.innerHTML = '● 사용가능한 비밀번호입니다.';
                passCheck1.style.color = "#55A5B7";
                return;
            }
        } else {
            passCheck1.innerHTML = '● 비밀번호를 입력해주세요.';
            passCheck1.style.color = "red";
            return;
        }
	} else {
        if (memberPass.value != "" && memberPassChk.value != "") {
            if (memberPassChk.value != memberPass.value) {
                passCheck2.innerHTML = '● 비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요.';
                passCheck2.style.color = "red";
                document.getElementById('passwordIndicator').innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" height="25" width="25" viewBox="0 0 512 512"><path fill="#990f0f" d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM175 175c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z"/></svg>';
                return;
            } else {
                passCheck2.innerHTML = '● 비밀번호가 일치합니다.';
                passCheck2.style.color = "#55A5B7";
                document.getElementById('passwordIndicator').innerHTML = '<i class="fa-duotone fa-check bg-primary-200 rounded-full flex items-center justify-center p-1"></i>';
                return;
            }
        } else {
            passCheck2.innerHTML = '● 비밀번호를 확인해주세요.';
            passCheck2.style.color = "red";
            return;
        }
	}
}

/* 이메일 검증 */
function emailValidation(){
	let url = window.location.href;
	let memberEmail = document.querySelector('#MEMBER_EMAIL').value;
    //이메일 정규식 확인
    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if(!regex.test(memberEmail)) {
        alert(joinCodeArray[16].CODE_NAME);
        return false;
    }else{
    emailSend(memberEmail, url.split("=")[1]);
    }
    //이메일 중복여부 체크
  /*  let url = window.location.href;
    let param={MEMBER_EMAIL : memberEmail, LANG : url.split("=")[1]};
    jsonAjaxAsync('emailCheck', '/member/emailCheck', param, 'POST', function(reData){
        if (reData == 1) {
            alert(joinCodeArray[17].CODE_NAME);
            $.unblockUI();
            return false;
        } else {
            emailSend(memberEmail, url.split("=")[1]);
        }
    });*/
}

/* 이메일 전송 */
function emailSend(email, lang){
	
	
    let param = {email : email, lang : 'kr'}
    console.log('param', param);
    $.ajax({
	    type: "POST",
	    url: "/member/certNumberSend.do",
	    data: JSON.stringify(param),
	    contentType: "application/json; charset=utf-8",
	    success: function (data) {
	        console.log("NumberSend : " + data);
	        emailSendResult(data);
	    },
	    error: function (e, textStatus, errorThrown) {
	        if (e.status == 400) {
	            alert("Your request is up. Please log back in if you wish to continue");
	            //location.href = document.referrer;
	        } else {
	            console.log(errorThrown);
	            alert("An error occurred while checking the ID.");
	        }
	    }
	});
    
}

/* 이메일 전송 결과 */
function emailSendResult(data){
    if(data == "success") {
        alert('인증번호를 발송하였습니다. 인증번호를 입력해 주시기 바랍니다.');
        startTimer();
       // $.unblockUI();
    } else {
        alert('인증번호 발송에 실패하였습니다. 관리자에게 문의 바랍니다.');
       // $.unblockUI();
        return false;
    }
}
/* 인증번호 타이머 */
let minutes = 5;
let seconds = 0;
let timer;
function startTimer(){
    timer = setInterval(updateTimer, 1000);
}

/* 타이머  */
function updateTimer() {
    console.log("11");
    let timerElement = document.querySelector(".timer");
    if (minutes == 0 && seconds == 0) {
        clearInterval(timer);
        timerElement.innerHTML = '● 인증 시간이 초과되었습니다.';
        let param = { MEMBER_EMAIL: document.querySelector('#MEMBER_EMAIL').value };
        $.ajax({
            type: "post",
            url: "/member/certTimeOut.do",
            data: { email: param },
            dataType: "text",
            success: function (data) {
                alert('인증 시간이 초과되었습니다. 다시 인증을 받아주세요.');
                return;
            },
            error: function () {
                console.error('에러가 났습니다.');
            }
        });
        return;
    } 
    if (seconds == 0) {
        minutes--;
        seconds = 59;
    } else {
        seconds--;
    }
    timerElement.innerHTML = ''; 
    let svgElement = document.createElementNS("http://www.w3.org/2000/svg", "svg");
    svgElement.setAttribute("xmlns", "http://www.w3.org/2000/svg");
    svgElement.setAttribute("viewBox", "0 0 512 512");
    svgElement.setAttribute("width", "18"); 
    svgElement.setAttribute("height", "18"); 
    svgElement.innerHTML = '<path fill="#55A5B7" d="M464 256A208 208 0 1 1 48 256a208 208 0 1 1 416 0zM0 256a256 256 0 1 0 512 0A256 256 0 1 0 0 256zM232 120V256c0 8 4 15.5 10.7 20l96 64c11 7.4 25.9 4.4 33.3-6.7s4.4-25.9-6.7-33.3L280 243.2V120c0-13.3-10.7-24-24-24s-24 10.7-24 24z"/>';
    let textNode = document.createTextNode(`${minutes}:${seconds.toString().padStart(2, '0')}`);
    timerElement.appendChild(svgElement);
    timerElement.appendChild(textNode);
}


/* 인증확인 */
function certNumberConfirm(){
	let certNum = document.querySelector('#CERT_NUM');
    let memberEmail = document.querySelector('#MEMBER_EMAIL').value;
    console.log("certNum"+certNum);
    console.log("memberEmail"+memberEmail);
    
    if (!certNum.value) {
        alert('인증번호를 입력해 주세요.');
        return false;
    }

    let param = {
            MEMBER_EMAIL : memberEmail,
            CERT_NUM : Number(certNum.value)
        }
    console.log('param', param);
    $.ajax({
	    type: "POST",
	    url: "/member/certNumberConfirm.do",
	    data: JSON.stringify(param),
	    contentType: "application/json; charset=utf-8",
	    success: function (data) {
	        console.log("NumberSend : " + data);
	        certNumberConfirmResult(data);
	    },
	    error: function (e, textStatus, errorThrown) {
	        if (e.status == 400) {
	            alert("Your request is up. Please log back in if you wish to continue");
	            //location.href = document.referrer;
	        } else {
	            console.log(errorThrown);
	            alert("An error occurred while checking the ID.");
	        }
	    }
	});
}

function regNoValidation(count){
	console.log("count123"+count);
	let compRegNo = document.querySelector('input[name="COMP_REG_NO[' + count + ']"]').value;
	 console.log("compRegNo value: " + compRegNo);
	 /*if (!compRegNo.value) {
	        alert('사업자 번호를 입력해 주세요.');
	        return false;
	    }*/
	 
	 $.ajax({
		    type: "POST",
		    url: "/member/comRegNoConfirm.do",
		    data: {compRegNo: compRegNo},
		    success: function (data) {
		        console.log("NumberSend : " + data);
		        alert('사업자 번호가 확인되었습니다.');
		        document.querySelector('input[name="REGNO_CHECK[' + count + ']"]').value = "Y"; // ID도 count와 함께 변경
		        fn_selectCmpnyPop(data);
		    },
		    error: function (e, textStatus, errorThrown) {
		        if (e.status == 400) {
		            alert("Your request is up. Please log back in if you wish to continue");
		            //location.href = document.referrer;
		        } else {
		            console.log(errorThrown);
		            alert("사업자 번호가 등록되어 있지 않습니다. 관리자에게 문의해 주세요.");
		        }
		    }
		});
}

function certNumberConfirmResult(data){
    if (data == "notFoundData") {
        alert('인증번호를 확인해 주시기 바랍니다.');
        //$.unblockUI();
        return false;
    } else if (data == "Timeout") {
        alert('인증시간이 초과되었습니다.');
        //$.unblockUI();
        return false;
    } else {
        alert('인증되었습니다.');
        clearInterval(timer);
        document.querySelector(".timer").innerHTML = "● 인증되었습니다.";
        document.querySelector(".timer").style.color = "#55A5B7";
        document.querySelector("#CERT_CHECK").value = "Y";
        //$.unblockUI();
        return false;
    }
}
/* 회원가입 데이터 체크 */
function joinDataConfirm(){
	let frm = document.querySelector('#joinFrm');


	if(!frm.querySelector('#MEMBER_ID').value){
		alert("아이디를 입력해 주세요.");
		frm.querySelector('#MEMBER_ID').focus();
		return false;
	}

	if(frm.querySelector('#MEMBER_ID_CHK').value == "none"){
		alert("아이디 중복여부를 확인해 주세요.");
		frm.querySelector('#MEMBER_ID').focus();
		return false;
	} else if (frm.querySelector('#MEMBER_ID_CHK').value == "false"){
		alert("중복된 아이디입니다.");
		frm.querySelector('#MEMBER_ID').focus();
		return false;
	}

	if(!frm.querySelector('#MEMBER_PASS').value) {
	    alert("비밀번호를 입력해 주세요.");
        frm.querySelector('#MEMBER_PASS').focus();
        return false;
	}

	if(!frm.querySelector('#MEMBER_PASS_CHK').value){
	    alert("비밀번호 중복을 확인해 주세요.")
	    frm.querySelector('#MEMBER_PASS_CHK').focus();
        return false;
	}

	if (frm.querySelector('#MEMBER_PASS').value != frm.querySelector('#MEMBER_PASS_CHK').value) {
		alert("비밀번호를 확인해 주세요.");
		frm.querySelector('#MEMBER_PASS_CHK').focus();
		return false;
	}
	
	if (!frm.querySelector('#COMP_REG_NO').value) {
		alert("사업자 번호를 입력해 주세요.");
		frm.querySelector('#COMP_REG_NO').focus();
		return false;
	}
	if (!frm.querySelector('#COMP_NAME').value) {
		alert("사업장 상호를 입력해 주세요.");
		frm.querySelector('#COMP_NAME').focus();
		return false;
	}
	if (!frm.querySelector('#SHINHAN_AGREE').checked) {
	    alert("이용약관에 동의해 주세요.");
	    frm.querySelector('#SHINHAN_AGREE').focus();
	    return false;
	}
	if (!frm.querySelector('#PRIVACY_AGREE').checked) {
	    alert("개인정보 수집에 동의해 주세요.");
	    frm.querySelector('#PRIVACY_AGREE').focus();
	    return false;
	}
	if (!frm.querySelector('#MEMBER_TEL').value) {
		alert("전화번호를 입력해 주세요.");
		frm.querySelector('#MEMBER_TEL').focus();
		return false;
	}
	/*if (!frm.querySelector('#COMP_PERSON').value) {
		alert("신한 담당자를 선택해 주세요");
		frm.querySelector('#COMP_PERSON').focus();
		return false;
	}*/

	if(!frm.querySelector('#MEMBER_NAME').value){
		alert('이름을 입력해 주세요.');
		frm.querySelector('#MEMBER_NAME').focus();
		return false;
	}
		const inputFields = frm.querySelectorAll('input[name^="REGNO_CHECK"]');
	    for (let i = 0; i < inputFields.length; i++) {
	        if (inputFields[i].value !== 'Y') {
	        	alert('사업자번호를 등록해 주세요.');
	            return false;
	        }
	    }
	    
	    
    
/*    let compPersonRadio = document.querySelectorAll('input[name="COMP_PERSON"]:checked');
    if (compPersonRadio.length === 0) {
        alert('신한 담당자를 선택해 주세요.');
        return false;
    }*/
      
     	
    // 비밀번호 조합체크
    let memberPass = frm.querySelector('#MEMBER_PASS').value;
    if(memberPass != ""){
        let chk_num = memberPass.search(/[0-9]/g);
        let chk_small_eng = memberPass.search(/[a-z]/);
        let chk_large_eng = memberPass.search(/[A-Z]/);
        let chk_spe = memberPass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

        if (!/^(?=.*[a-zA-Z0-9])((?=.*\d)|(?=.*\W)).{5,20}$/.test(memberPass)) {
            alert('비밀번호는 숫자와 영문자, 특수문자를 포함한 5~20자리 문자를 입력해야 합니다.');
            return false;
        } else if (chk_small_eng < 0) {
            alert('비밀번호는 한 개 이상의 영문 소문자가 포함되어야 합니다.');
            return false;
        } else if(chk_large_eng < 0){
            alert('비밀번호는 한 개 이상의 영문 대문자가 포함되어야 합니다.');
            return false;
        } else if (chk_spe < 0) {
            alert('비밀번호는 특수문자가 한 개 이상 포함되어야 합니다.');
            return false;
        }
    }
    alert('회원가입이 완료되었습니다. 관리자 승인 후 이용 가능합니다.');
    $("#joinFrm").submit(); 
    
    /*let param = {COMP_REG_NO : frm.querySelector('#COMP_REG_NO').value};
    $.ajax({
	    type: "POST",
	    url: "/member/companyCheck.do",
	    data: JSON.stringify(param),
	    contentType: "application/json; charset=utf-8",
	    success: function (data) {
	        console.log("NumberSend : " + data);
	        resultJoinDataConfirm(data);
	    },
	    error: function (e, textStatus, errorThrown) {
	        if (e.status == 400) {
	            alert("Your request is up. Please log back in if you wish to continue");
	            //location.href = document.referrer;
	        } else {
	            console.log(errorThrown);
	            alert("An error occurred while checking the ID.");
	        }
	    }
	});*/
    
}

/*function resultJoinDataConfirm(data){
    if (data > 0){
       alert('이미 가입된 사업장입니다.');
       return false;
    } else {
    	alert('회원가입이 완료되었습니다 관리자 승인 후 사용가능합니다.');
    	$("#joinFrm").submit();
    }
}
*/


