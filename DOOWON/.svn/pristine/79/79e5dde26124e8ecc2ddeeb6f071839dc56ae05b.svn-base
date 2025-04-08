<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv"X-UA-Compatible" content="IE=edge">
  <script type="text/javascript" src="/pf/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="/pf/js/menu.js"></script>
  <title>KORD FTA</title>
  <link type="text/css" rel="stylesheet" href="fta/css/portalStyle.css">
</head>

<script type="text/javascript">

	function pLogin(){
		var email = $("#pEmail");
		var password = $("#pPwd");

		if(email.val() == ""){
			alert("Please enter your email address");
			email.focus();
			return;
		}

		if(password.val() == ""){
			alert("Please enter a password");
			password.focus();
			return;
		}

		var param = {};
		param["id"] = email.val();
		param["pwd"] = password.val();
		param["lang"] = $("#pLang").val();

		$.ajax({
			type : "POST",
			url : "/pLoginCheck.do",
			data : param,
			dataType: "json",
	        success : function(data) {
	        	if(data.result == "SUCCESS"){
	        		document.pLoginForm.submit();
	        	}else{
	        		alert("There is no registered user information");
	        	}
	        },
	        error : function(e, textStatus, errorThrown) {
	        	console.log(errorThrown);
	        }
		});

	}
	
	function fn_vndrMberSbscrb(){
		$("#mberSbscrbLang").val($("#pLang").val());
		document.vndrMberSbscrbForm.submit();
	}
</script>
<style>
        ul.informeson {margin-left:20px;}
        ul.informeson li {font-size:0.9rem; margin-bottom:10px; letter-spacing:-1px;     list-style: square;}
        
#footer {background:#3b3b3c; position:fixed; width:100%; z-index:1; bottom:0; padding:5px 30px; color:#999; text-align:center; font-size:14px} 
/* #footer {background-color: rgba(0,0,0,0.3); position:fixed; width:100%; z-index:1; bottom:0; padding:0px 30px; color:#fff; text-align:center; font-size:14px} */
#footer:before {   content: ""; display: block; position: absolute; top: -1px; left: 0; width: 100%; height: 1px; background-color: #fff; opacity: 0.75;}
#footer .copyright {font-weight:bold; margin-bottom:10px; margin:0}
.footer-content {display:flex; justify-content:flex-start; align-items:center; flex-wrap:nowrap}
.footer-content div {flex:none; margin:0 10px}
.footer-content div a {color:#fff;}
    </style>

<body>
	<form action="/prtl/originInfo.do" name="pLoginForm" id="pLoginForm" method="post"></form>
	
	<form action="/vndrMberSbscrb.do" name="vndrMberSbscrbForm" id="vndrMberSbscrbForm" method="post">
		<input type="hidden" name="mberSbscrbLang" id="mberSbscrbLang">
	</form>

	<div class="containerlogin">
		<div class="container-fluid">
			<div class="row">
				<div class="form-section">
					<div class="card-body">
						<div class="form-group">
							<h1><img src="/pf/images/logo.png" class="logo" alt="" style="width:300px; height:auto"></h1>
							<p>Sign into your account</p>
							<select name="pLang" id="pLang" onchange="changeDesc(this);">
								<option value="kr" selected>한국어</option>
								<option value="en">English</option>
								<option value="vt">tiếng Việt</option>
								<option value="jp">日本語</option>
							</select>
							<div class="form-label-group">
								<input type="email" id="pEmail" name="pEmail" class="form-control" placeholder="Email Address" value="">
							</div>
							<div class="form-label-group">
								<input type="password" id="pPwd" name="pPwd" class="form-control" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							
							<a class="btn" onclick="pLogin()">Login</a>
						</div>
						<a href="javascript:fn_vndrMberSbscrb();" id="popOpenBtn"><span id="memberJoinLabel">회원가입</span></a>
					</div>
				</div>
				<div class="bg-img none">
					<ul class="informeson" id="descKor">
	           	<li>기초자료 관리부터 원산지 증명서 출력까지 All-in-One</li>
	   			<li>All FTA & Form A, Form B 원산지 관리까지</li>
				<li>베트남의 FTA 실무 프로세스를 완벽 반영한 로직 설계</li>
				<li>수출입통관 및 기업 ERP 데이터 자동 인터페이스 지원</li>
				<li>협력사 원산지 정보 송수신 지원</li>
				<li>한국어, 영어, 베트남어 3개 언어 서비스</li>
				<li>원산지 판정ㆍ발급 실적 분석 및 리포팅 서비스</li>
				<li>전기전자, 자동차 부품, 섬유·의류 등 모든 산업군 사용 가능</li>
            </ul>
            
            <ul class="informeson" id="descEn" style="display:none;">
				<li>All-in-One ; from managing basic data to printing C/O</li>
				<li>Origin management of All FTA and even Form A and Form B.</li>
				<li>Logic design completely reflected working processes in Vietnam</li>
				<li>Automatic interface with export-import customs clearance and/or company ERP data</li>
				<li>Sending and receiving function of vendor’s raw material origin information</li>
				<li>Service for three languages ;Korean, English and Vietnamese</li>
				<li>Analysis and reporting service of origin determination and issuance result</li>
				<li>All industrial groups such as electronics, automotive parts, textiles and clothing can be use KORD system.</li>
            </ul>
            
            <ul class="informeson" id="descVet" style="display:none;">
				<li>Trọn gói; từ quản lý dữ liệu đến in giấy chứng nhận xuất xứ</li>
				<li>Không chỉ quản lý xuất xứ hàng hóa cho các FTA mà áp dụng cho cả chứng nhận xuất xứ mẫu A và B.</li>
				<li>Thiết kế hoàn toàn dựa trên quy trình làm việc tại Việt Nam</li>
				<li>Tự động lấy dữ liệu của tờ khai xuất, nhập khẩu và/ hoặc dữ liệu trên hệ thống ERP của công ty</li>
				<li>Tích hợp chức năng truyền và nhận thông tin xuất xứ của nguyên liệu từ nhà cung cấp nội địa.</li>
				<li>3 ngôn ngữ được sử dụng: Hàn, Anh, Việt.</li>
				<li>Phân tích và báo cáo về xuất xứ hàng hóa và phát hành kết quả.</li>
				<li>Áp dụng được với tất cả các ngành công nghiệp như điện tử, linh kiện ô tô, may mặc,...</li>				
            </ul>
            <ul class="informeson" id="descJp" style="display:none;">
				<li>基礎資料管理から原産地証明書の出力までAll-in-One</li>
				<li>All FIFA & Form A、Form B原産地管理まで</li>
				<li>ベトナムのFTA実務プロセスを完璧に反映したロジック設計</li>
				<li>輸出入通関および企業ERPデータ自動インターフェース支援</li>
				<li>協力会社の原産地情報送受信支援</li>
				<li>韓国語、英語、ベトナム語、日本語の4か国語対応</li>
				<li>原産地判定・発行実績分析およびレポーティングサービス</li>
				<li>電気電子、自動車部品、繊維・衣類などあらゆる産業群に使用可能</li>				
            </ul>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
  
  	<div class="footer-content">
  		<div style="margin-left:0"><a href="/">KORD FTA</a></div>  		
  		<div>KORD Systems Inc.</div>
  		<!--  <div><a href="http://www.customsservice.co.kr/" target="_blank">KORD Systems Inc.</a></div>-->
  	</div>
  	
  	<div class="footer-content">
		<div class="copyright">Copyright 2020 KORD Systems Inc. All rights reserved.</div>
		<!--  <div>Tel: [KR] +82-2-3448-1181 [VN] +84-24-7300-8630</div>-->
		<div><a></a>e-mail : <a href="mailto:ioom@kordsystems.com" target="_top">ioom@kordsystems.com</a></div>  		
  	</div>
  	  	
  	
  	<!-- 
FTA Portal for vendors (협력사 포털 링크)

SHINHAN Customs Service Inc. (신한관세법인 홈페이지 링크)

Tel: [KR] +82-2-3448-1181 [VN] +84-24-7300-8630
-->
  	
  </div>
	
	

	<!-- 회원가입 start -->
	<!-- <div id ="popup_mask" ></div>
	<div id="popupDiv">
		<div class="pop-tit">회원가입</div>
       	<div class="popWrap">
       		<table>
       			<colgroup>
       				<col width="30%"/>
       				<col width="70%"/>
       			</colgroup>
       			<tr>
       				<th>사용자ID</th>
       				<td><input type="text" class="pop-control"></td>
       			</tr>
	            <tr>
	            	<th>회사명</th>
	            	<td><input type="text" class="pop-control"></td>
	            </tr>
	            <tr>
	            	<th>회사식별번호</th>
	            	<td><input type="text" class="pop-control"></td>
	            </tr>
	            <tr>
	            	<th>사용자명</th>
	            	<td><input type="text" class="pop-control"></td>
	            </tr>
	            <tr>
	            	<th>비밀번호</th>
	            	<td><input type="password" class="pop-control"></td>
	            </tr>
	            <tr>
	            	<th>비밀번호 확인</th>
	            	<td>
	            		<input type="password" class="pop-control">
	            		<span class="pop-info">*비밀번호가 일치 하지 않습니다.</span>
	            	</td>
	            </tr>
	            <tr>
	            	<th>사용자 연락처</th>
	            	<td><input type="text" class="pop-control"></td>
	            </tr>
	            <tr>
	            	<th>사용자 이메일</th>
	            	<td><input type="text" class="pop-control"></td>
	            </tr>
       		</table>
       	</div>
       	<div class="pop-btnWrap">
       		<button id="popCloseBtn" type="button">저장</button>
       		<button id="popCancleBtn" type="button">취소</button>
       	</div>
       </div> -->

	<!-- 회원가입 end -->
	 <script>
  	function changeDesc(obj){
   		var value = $(obj).val();
   		if(value == "kr") {
   			$(".informeson").hide();
   			$("#descKor").show();
   			$("#memberJoinLabel").html("회원가입");
   		} else if (value == "en"){
   			$(".informeson").hide();
   			$("#descEn").show();
   			$("#memberJoinLabel").html("Membership join");   			
   		} else if (value == "vt"){
   			$(".informeson").hide();
   			$("#descVet").show();
   			$("#memberJoinLabel").html("Đăng ký hội viên");   			
   		} else if (value == "jp"){
   			$(".informeson").hide();
   			$("#descJp").show();
   			$("#memberJoinLabel").html("会員加入");   			
   		}
        console.log(test);
    }
  </script>

</body>
</html>