 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="ko">
 <head>
 	<meta charset="UTF-8" />
	<script src="/fta/js/function.js"></script>
	<script src="/fta/js/cmmn/ccpyacnt.js"  charset="UTF-8"></script>
 </head>

 <script type="text/javascript">

 	/* 메시지 */
 	var colCorpNm = "${corpNm}"; //협력사명
 	var colTaxNb = "${taxNb}"; //Tax Number
 	var colUserId = "${userId}"; //사용자ID
 	var colUserNm = "${userNm}"; //사용자명
 	var colPassword = "${password}"; //패스워드
 	var colTelNo = "${telNo}"; //전화번호
 	var colEmail = "${email}"; //이메일
 	var colDelYn = "${delYn}"; //삭제여부
 	var colAutoApp = "${autoApp}" ;
    var colManualApp = "${manualApp}";
    var colOriginYn = "${originAutoYn}";
    var colVendorId = "${vendorId}"; //협력사 ID
    var colManualAppYn = "${manualAppYn}";
    var colAutoAppUse = "${autoAppUse}";


 	var msgSearchError = "${searchError}"; //조회중 에러가 발생하였습니다.
 	var msgSaveEmpty = "${saveEmpty}"; //저장할 데이터가 없습니다.
 	var msgSaveCheck = "${saveCheck}"; //데이터 정합성을 체크해주세요.
 	var msgSaveConfirm = "${saveConfirm}"; //저장하시겠습니까?
 	var msgSaveSuccess = "${saveSuccess}"; //저장 되었습니다.
 	var msgSaveError = "${saveError}"; //저장중 에러가 발생하였습니다.

 </script>

<body class="text-left" id="ccpyacnt">
	<div class="main-content">
		<div class="row">
			<div class="col-md-12">
				<div class="tab-content" id="myTabContent">
					<div class="accordion" id="accordionRightIcon">
						<div class="card">
							<div class="card-header header-elements-inline">
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0"><a class="text-default" data-toggle="collapse" href="#accordion-item-icon-right-1" aria-expanded="true">${search}</a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-1" data-parent="#accordionRightIcon" style="">
								<div class="card-body">

									<div class="form-group col-xl-12 row">
										<!-- 검색구분 -->
										<!-- xl lg md sm xs  -->
										<div class="col-xl-12 col-lg-12 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-1 col-form-label" for="">${searchTp}</label>
					                		<div class="col-xl-11 col-lg-11" style="justify-content:flex-start; display:flex; width:inherit">
					                			<div class="ul-form__radio-inline inline" id="item-radio" >
													<label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="" value="01"  checked="checked" /><span class="ul-form__radio-font">${reqstInfo}</span><span class="checkmark" ></span>
					                				</label>
					                			</div>
					                			<div class="" style="margin-left:auto; display:flex" >
						                			<button class="btn btn-outline-secondary m-1" type="button" onclick="fn_clearCcpyacnt()">${clear}</button>
						            				<button class="btn btn-primary m-1" type="button" onclick="fn_searchCcpyacnt();">${search}</button>
						                		</div>
					                		</div>
						                </div>
									</div>

        							<div class="custom-separator"></div>

									<div class="form-group col-xl-12 row">
										<!-- 협력사명 -->
					                	<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${corpNm}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ccpyacnt_srch1" type="text" onkeyup="enterkey()" placeholder="${corpNmMsg}" />
					                		</div>
					                	</div>

										<!-- 사용자ID -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${userId}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ccpyacnt_srch2" type="text" onkeyup="enterkey()" placeholder="${userIdMsg}" />
					                		</div>
					                	</div>

					                	<!-- 사용자명 -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${userNm}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ccpyacnt_srch3" type="text" onkeyup="enterkey()" placeholder="${userNmMsg}" />
					                		</div>
					                	</div>
					                </div>

					                <div class="custom-separator"></div>

					                <div class="form-group col-xl-12 row">
					                	<!-- 삭제여부 -->
					                	<div class="col-xl-12 col-lg-12 rowflex" id="ftaUser_div4">
					                		<label class="ul-form__label ul-form--margin col-lg-1 col-form-label" for="">${delYn}</label>
					                		<div class="col-lg-11">
					                			<div class="ul-form__radio-inline inline">
					                				<label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="ccpyacnt_srch4" value=""  checked="checked" /><span class="ul-form__radio-font">ALL</span><span class="checkmark" ></span>
					                				</label>
					                				<label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="ccpyacnt_srch4" value="Y"  /><span class="ul-form__radio-font">Y</span><span class="checkmark"></span>
					                				</label>
					                				<label class="ul-radio__position radio radio-primary form-check-inline">
					                					<input type="radio" name="ccpyacnt_srch4" value="N"  /><span class="ul-form__radio-font">N</span><span class="checkmark"></span>
					                				</label>
					                			</div>
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
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0"><a class="text-default" data-toggle="collapse" href="#accordion-item-icon-right-table-1" aria-expanded="true">${partnInfo}</a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-table-1" data-parent="#accordionRightIconTable" style="">
								<div class="card-body">

									<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
										<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
											<p class="card-title inline" style="line-height:35px; height:35px">${result} : <span id="ccpyacntCnt">0</span></p>
											<c:if test="${writable eq 'Y'}">
												<div class="form-group inline">
													<div class="ul-form__radio-inline">
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ccpyacntType" value="read" checked="checked" /><span class="ul-form__radio-font">${readOnly}</span><span class="checkmark"></span>
														</label>
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ccpyacntType" value="edit" /><span class="ul-form__radio-font">${edit}</span><span class="checkmark"></span>
														</label>
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ccpyacntType" value="enrol" /><span class="ul-form__radio-font">${enrollment}</span><span class="checkmark"></span>
														</label>
													</div>
												</div>
											</c:if>
										</div>

										<div class="text-right" style="flex:auto; margin-left:auto; padding-right:10px; margin-top:1.5px">
											<button class="btn btn-primary" style="padding-right:10px" type="button" id="btnCcpyacntSave" onclick="fn_saveCcpyacntCheck()">${save}</button>

										</div>


										<div class="text-right inline-right">
											<select class="form-control" id="alignCcpyacnt" name="alignCcpyacnt" style="text-align:center">
												<option value="" selected>${orderby} </option>
												<option value="USR_ID">${userId} &uarr; </option>
												<option value="USR_ID_DESC">${userId} &darr; </option>
												<option value="USR_NM">${userNm} &uarr; </option>
												<option value="USR_NM_DESC">${userNm} &darr; </option>
											</select>
										</div>

										<div class="text-right inline-right-last">
											<select class="form-control" id="ccpyacntPageCnt" name="ccpyacntPageCnt" style="text-align:right">
												<option value="50" selected>Rows [50]</option>
												<option value="100">Rows [100]</option>
												<option value="200">Rows [200]</option>
												<option value="500">Rows [500]</option>
											</select>
										</div>
									</div>

									<!-- handson table -->
									<div id="ccpyacntTable" style="margin:10px;"></div>


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