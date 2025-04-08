let gubun = '';
gubun = 'searchId'
$(document).ready(function() {
	
    setTimeout(searchIdAndPwAlertList, 100);
    gubun = 'searchId'
    console.log("gubun"+gubun);
});


/*cardTabButtons.forEach((button, idx) => {
	  button.addEventListener('click', () => {
	    cardTabButtons.forEach(button => button.classList.remove('active'));
	    button.classList.add('active');
	    formContainer.forEach(form => form.classList.remove('active'));
	    formContainer[idx].classList.add('active');

	    // 클릭된 버튼의 ID를 기반으로 gubun 변수에 값을 할당합니다.
	    if (button.id === 'searchId') {
	      gubun = 'searchId';
	      console.log("gubun"+gubun);
	    } else if (button.id === 'searchPw') {
	      gubun = 'searchPw';
	      console.log("gubun"+gubun);
	    }
	  });
	});
*/



/* 언어별 alert array get - jangbora 
function searchIdAndPwAlertList() {
    let url = window.location.href;
    param = {CODE_GROUP_ID: "searchIdAndPw-alert", LANG: url.split("=")[1]};
    jsonAjaxAsyncNotBlock("searchIdAndPw-alert", "/code/commonCodeList", param, "POST", searchIdAndPwAlertSet);
}

 언어별 alert array set - jangbora 
function searchIdAndPwAlertSet(reData) {
    for (let data of reData) {
        for (let code of searchIdAndPwAlertArray) {
            if (code["CODE_COMMON_ID"] == data["CODE_COMMON_ID"]) {
                code["CODE_NAME"] = data["CODE_NAME"];
            }
        }
    }
}*/

/* 탭메뉴 */
// 아이디 찾기
function fn_searchIdBtn(){
	const btnButton = document.querySelector('#searchIdBtn');
	const btnButton2 = document.querySelector('#searchPwBtn');
	const formContainer = document.querySelector('#searchIdAndPwFrm');
	const formContainer2 = document.querySelector('#searchPwFrm');
	btnButton.classList.add('active');
	btnButton2.classList.remove('active');
	formContainer2.classList.remove('active');
	formContainer.classList.add('active');	
	gubun = 'searchId';
	console.log("gubun1"+gubun);
}

//비밀번호 찾기
function fn_searchPwBtn(){
	const btnButton = document.querySelector('#searchIdBtn');
	const btnButton2 = document.querySelector('#searchPwBtn');
	const formContainer = document.querySelector('#searchIdAndPwFrm');
	const formContainer2 = document.querySelector('#searchPwFrm');
	btnButton.classList.remove('active');
	btnButton2.classList.add('active');
	formContainer.classList.remove('active');
	formContainer2.classList.add('active');
	gubun = 'searchPw';
	console.log("gubun2"+gubun);
}

function fn_clearIdAndPwd() {
	$("#input_register_number").val("");
	$("#input_email").val("");
	$("#input_register_number2").val("");
	$("#input_email2").val("");
}


/* 데이터 유효성 검사 */
function searchIdAndPwSubmit() {
    let result = true;
    let frm;
    let regNoVal;
    let emailVal;
    
    if (gubun === 'searchId'){
    	console.log("아이디찾기");
    	 frm = document.querySelector('#searchIdAndPwFrm');
         regNoVal = frm.querySelector('input[name="COMP_REG_NO"]').value;
         emailVal = frm.querySelector('input[name="MEMBER_EMAIL"]').value;
    }else{
    	console.log("비밀번호찾기");
    	 frm = document.querySelector('#searchPwFrm');
         regNoVal = frm.querySelector('input[name="COMP_REG_NO"]').value;
         emailVal = frm.querySelector('input[name="MEMBER_EMAIL"]').value;
    }
    
    if (!regNoVal) {
        alert('사업자 번호를 입력해 주세요.');
        //$.unblockUI();
        return false;
    }

    if (!emailVal) {
        alert('이메일 주소를 입력해 주세요.');
        //$.unblockUI();
        return false;
    }

    // 이메일 정규식 확인
    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if (!regex.test(emailVal)) {
        alert('이메일을 확인해 주세요.');
        //$.unblockUI();
        return false;
    }
     
    let param = {
        MEMBER_EMAIL: emailVal,
        COMP_REG_NO: regNoVal
    	}
    console.log('param', param);
    $.ajax({
        type: "post",
        url: "/member/memberCheck.do",
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        success: function(data) {
            console.log("data   :  " + data);
            if (data == 0) {
                alert('회원이 아닙니다. 회원가입을 해주세요.');
            }
        },
        error: function(e, textStatus, errorThrown) {
            if (e.status == 400) {
                alert("Your request is up. Please log back in if you wish to continue");
                // location.href = document.referrer;
            } else {
                console.log(errorThrown);
                alert("An error occurred while checking the ID.");
            }
        }
    });

        if (gubun === 'searchId') {
           console.log('searchId');
           $.ajax({
               type: "post",
               url: "/member/idSendEmail.do",
               data: JSON.stringify(param),
               contentType: "application/json; charset=utf-8",
               success: function(data) {
                   console.log("data   :  " + data);
                   idSendEmailResult(data);
               },
               error: function(e, textStatus, errorThrown) {
                   if (e.status == 400) {
                       alert("Your request is up. Please log back in if you wish to continue");
                       // location.href = document.referrer;
                   } else {
                       console.log(errorThrown);
                       alert("An error occurred while checking the ID.");
                   }
               }
           });
        
        } else if (gubun === 'searchPw') {
        	 console.log('searchPw');
        	 $.ajax({
                 type: "post",
                 url: "/member/pwSendEmail.do",
                 data: JSON.stringify(param),
                 contentType: "application/json; charset=utf-8",
                 success: function(data) {
                     console.log("data   :  " + data);
                     pwSendEmailResult(data);
                 },
                 error: function(e, textStatus, errorThrown) {
                     if (e.status == 400) {
                         alert("Your request is up. Please log back in if you wish to continue");
                         // location.href = document.referrer;
                     } else {
                         console.log(errorThrown);
                         alert("An error occurred while checking the ID.");
                     }
                 }
             });
        }
    }

    // id 이메일 전송 결과
    function idSendEmailResult(data) {
        console.log("222");
    	if (data == "success") {
        	alert('이메일 주소로 아이디를 발송하였습니다. 메일을 확인해 주세요.');
        } else {
        	alert('존재하지 않는 사용자입니다.');
            //$.unblockUI();
            return false;
        }
        //$.unblockUI();
    }

    // pwd 이메일 전송 결과
    function pwSendEmailResult(data) {
        if (data == "success") {
        	 alert('이메일 주소로 새 비밀번호를 발송하였습니다. 메일을 확인해주세요.');
        } else {
        	alert('아이디 발송에 실패하였습니다. 관리자에게 문의 바랍니다.');
            //$.unblockUI();
            return false;
        }
        //$.unblockUI();
    }


