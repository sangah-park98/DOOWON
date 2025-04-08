 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="ko">
 <head>
 	<meta charset="UTF-8" />
	<script src="/pf/js/function.js"></script>
	<script src="/pf/js/cmmn/conectinfo.js"  charset="UTF-8"></script>
 </head>

 <script type="text/javascript">

 	/* 메시지 */
 	var colUserId = "${userId}"; //사용자ID
 	var colUserNm = "${userNm}"; //사용자명
 	var colConCmpnyNm = "${conCmpnyNm}"; //접속회사명
 	var colConectDt = "${conectDt}"; //접속일
 	var colConectIp = "${conectIp}"; //접속IP
 	var colConectInfo = "${conectInfo}"; //접속정보
	var colChangeInfo = "${changeInfo}"; //변경이력
 	
 	var colChangeItem = "${changeItem}"; //변경항목
 	var colChangeBefore = "${changeBefore}"; //변경전
 	var colChangeAfter = "${changeAfter}"; //변경후
 	var colWorkId = "${workId}"; //작업자ID
 	var colChangeDt = "${changeDt}"; //변경일

 	var msgSearchError = "${searchError}"; //조회중 에러가 발생하였습니다.
 	var msgSaveEmpty = "${saveEmpty}"; //저장할 데이터가 없습니다.
 	var msgSaveCheck = "${saveCheck}"; //데이터 정합성을 체크해주세요.
 	var msgSaveConfirm = "${saveConfirm}"; //저장하시겠습니까?
 	var msgSaveSuccess = "${saveSuccess}"; //저장 되었습니다.
 	var msgSaveError = "${saveError}"; //저장중 에러가 발생하였습니다.

 </script>

<body class="text-left" id="conectInfo">
	<div class="main-content">
		<div class="row">
			<div class="col-md-12">
				<div class="tab-content" id="myTabContent">
					<div class="accordion" id="accordionRightIcon">
						<div class="card">
							<div class="card-header header-elements-inline">
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0"><a class="text-default" data-toggle="collapse" href="#accordion-item-icon-right-1" aria-expanded="true">검색<%-- ${search} --%></a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-1" data-parent="#accordionRightIcon" style="">
								<div class="card-body">
									<div class="form-group col-xl-12 row">
										<!-- 검색구분 -->
										<!-- xl lg md sm xs  -->
										<div class="col-xl-12 col-lg-12 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-1 col-form-label" for=""><%-- ${searchTp} --%>검색구분</label>
					                		<div class="col-xl-11 col-lg-11" style="justify-content:flex-start; display:flex; width:inherit">
					                			<div class="ul-form__radio-inline inline" id="item-radio" >
													<label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="conectInfo_srch1" value="01"  checked="checked" /><span class="ul-form__radio-font">접속정보<%-- ${conectInfo} --%></span><span class="checkmark" ></span>
					                				</label>
					                				<%-- <label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="conectInfo_srch1" value="02"  /><span class="ul-form__radio-font">${changeInfo}</span><span class="checkmark"></span>
					                				</label> --%>
					                			</div>
					                			<div class="" style="margin-left:auto; display:flex" >
						                			<button class="btn btn-outline-secondary m-1" type="button" onclick="fn_clearConectInfo()"><%-- ${clear} --%>초기화</button>
						            				<button class="btn btn-primary m-1" type="button" onclick="fn_searchConectInfo();"><%-- ${search} --%>검색</button>
						                		</div>
					                		</div>
						                </div>
					                </div>

					                <div class="custom-separator"></div>

					                <div class="form-group col-xl-12 row">
					                	<!-- 사용자명 -->
					                	<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div1">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for=""><%-- ${userNm} --%>사용자명</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="conectInfo_srch2" type="text" onkeyup="enterkey()" placeholder="사용자명을 입력해주세요<%-- ${userNmMsg} --%>" />
					                		</div>
					                	</div>

										<!-- 접속회사명 -->
										<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div2">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for=""><%-- ${conCmpnyNm} --%>접속회사명</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="conectInfo_srch3" type="text" onkeyup="enterkey()" placeholder="<%-- ${conCmpnyNmMsg} --%>접속회사명을 입력해주세요." />
					                		</div>
					                	</div>

					                	<!-- 변경항목 -->
					                	<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div4">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${changeItem}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="conectInfo_srch6" type="text" placeholder="${changeItem}" />
					                		</div>
					                	</div>

										<!-- 작업자ID -->
										<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div5">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${workId}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="conectInfo_srch7" type="text" placeholder="${workId}" />
					                		</div>
					                	</div>
					                	<!-- 접속일 -->
										<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div3">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for=""><%-- ${conectDt} --%>접속일</label>
					                		<div class="col-lg-4 cal">
					                			<input type="text" class="form-control band-calendar" id="conectInfo_srch4" name="cone1_date" onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" placeholder="<%-- ${inputPickDateMsg} --%>yyyy/mm/dd" autocomplete="off" readonly>
					                		</div>
					                		<div class="col-lg-5 cal">
					                			<input type="text" class="form-control band-calendar" id="conectInfo_srch5" name="cone2_date" onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" placeholder="<%-- ${inputPickDateMsg} --%>yyyy/mm/dd" autocomplete="off" readonly>
					                		</div>
					                	</div>

					                	<!-- 변경일 -->
										<div class="col-xl-4 col-lg-4 rowflex" id="conectInfo_div6">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${changeDt}</label>
					                		<div class="col-lg-4 cal">
					                			<input type="text" class="form-control datepicker" id="conectInfo_srch8" name="date" placeholder="${inputPickDateMsg}" autocomplete="off">
					                		</div>
					                		<div class="col-lg-5 cal">
					                			<input type="text" class="form-control datepicker" id="conectInfo_srch9" name="date" placeholder="${inputPickDateMsg}" autocomplete="off">
					                		</div>
					                	</div>
					                </div>
						        </div>
						    </div>
						</div>
					</div>

					<div class="accordion" id="accordionRightIconTable" style="margin-top:2em;">
						<div class="card">
							<div class="card-header header-elements-inline">
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0">접속정보<a class="text-default" id="conectInfoTitme" data-toggle="collapse" href="#accordion-item-icon-right-table-1" aria-expanded="true"></a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-table-1" data-parent="#accordionRightIconTable" style="">
								<div class="card-body">

									<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
										<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
											<p class="card-title inline" style="line-height:35px; height:35px">검색결과 : <span id="conectInfoCnt">0</span></p>
										</div>
										<div class="text-right inline-right">
											<div class="rowWrap">
												<select class="form-control" id="alignConectInfo" name="alignConectInfo" style="text-align:center">
													<option value="" selected><%-- ${orderby} --%> 정렬기준</option>
													<option value="REG_DT"><%-- ${changeDt} --%> 변경일&uarr; </option>
													<option value="REG_DT_DESC"><%-- ${changeDt} --%>변경일 &darr; </option>
												</select>
												<div class="select-arrow"></div>
											</div>
										</div>

										<div class="text-right inline-right-last">
											<div class="rowWrap">
												<select class="form-control" id="conectInfoPageCnt" name="conectInfoPageCnt" style="text-align:right">
													<option value="50" selected>Rows [50]</option>
													<option value="100">Rows [100]</option>
													<option value="200">Rows [200]</option>
													<option value="500">Rows [500]</option>
												</select>
												<div class="select-arrow"></div>
											</div>
										</div>
									</div>

									<!-- handson table -->
									<div id="conectInfoTable" style="margin:10px;"></div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>