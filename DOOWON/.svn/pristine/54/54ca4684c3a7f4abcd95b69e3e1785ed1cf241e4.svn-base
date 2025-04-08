 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="ko">
 <head>
 	<meta charset="UTF-8" />
	<script src="/pf/js/function.js"></script>
	<script src="/pf/js/cmmn/ftatreaty.js"  charset="UTF-8"></script>
 </head>

 <script type="text/javascript">

 	/* 메시지 */
	var colFtaCd = "${ftaCd}"; //FTA 코드
	var colFtaNm = "${ftaNm}"; //FTA명
	var colFtaCmmnts = "${ftaCmmnts}"; //FTA 설명
	var colNatCd = "${natCd}"; //국가코드
	var colNatNm = "${natNm}"; //국가명
	var colDelYn = "${delYn}"; //삭제여부
	var colCmmnCd = "${cmmnCd}"; //공통 코드
 	var colGrpCd = "${grpCd}"; //그룹코드
 	var colRsnCntn = "${rsnCntn}" //근거
	var colFtaInfo = "${ftaInfo}"; //FTA정보
	var colNatByFtaInfo = "${natByFtaInfo}"; //FTA국가정보
	var colPsrKnd = "${psrKnd}"; //PSR종류
	var colDocuCd = "${docuCd}"; //문서코드
	var colDocuFileNm = "${docuFileNm}"; // 문서파일명
	var colPrintSheetNo = "${printSheetNo}"; //프린트수
	var colSeq = "${seq}"; //순번
	var colHsVer = "${hsVer}"; //HS버젼
	var colOrderSn = "${orderSn}";//ordr정렬순서

	var colLang = "${lang}";
	var tableList = "${tableList}";
	var ftaNatList = "${natCdList}";

 	var msgSearchError = "${searchError}"; //조회중 에러가 발생하였습니다.
 	var msgSaveEmpty = "${saveEmpty}"; //저장할 데이터가 없습니다.
 	var msgSaveCheck = "${saveCheck}"; //데이터 정합성을 체크해주세요.
 	var msgSaveConfirm = "${saveConfirm}"; //저장하시겠습니까?
 	var msgSaveSuccess = "${saveSuccess}"; //저장 되었습니다.
 	var msgSaveError = "${saveError}"; //저장중 에러가 발생하였습니다.
 	var msgEnterFtaCd = "${msgEnterFtaCd}" //협정코드를 입력하세요.

 </script>
<body class="text-left" id="cmmncd">
	<!-- ============ Body content START ============= -->
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
									<div class="col-xl-12 col-lg-12 row" style="padding-right:0">
				                		<label class="ul-form__label ul-form--margin col-lg-1 col-form-label" for="">${searchTp}</label>
				                		<div class="col-xl-11 col-lg-11" style="justify-content:flex-start; display:flex; width:inherit; padding-right:0">
				                			<div class="ul-form__radio-inline inline" id="item-radio" >
												<label class="ul-radio__position radio radio-primary form-check-inline">
				                					<input type="radio" name="ftaTreaty_srch4" value="01"  checked="checked" /><span class="ul-form__radio-font">${ftaAllInfo}</span><span class="checkmark" ></span>
				                				</label>
				                				<label class="ul-radio__position radio radio-primary form-check-inline">
				                					<input type="radio" name="ftaTreaty_srch4" value="02"  /><span class="ul-form__radio-font">${natByFtaInfo}</span><span class="checkmark"></span>
				                				</label>
				              					<label class="ul-radio__position radio radio-primary form-check-inline">
				                					<input type="radio" name="ftaTreaty_srch4" value="03"  /><span class="ul-form__radio-font">${docuInfo}</span><span class="checkmark"></span>
				                				</label>
				                			</div>
				                			<div class="" style="margin-left:auto; display:flex" >
					                			<button class="btn btn-outline-secondary m-1" type="button" onclick="fn_clearTreaty()">${clear}</button>
					            				<button class="btn btn-primary m-1" type="button" onclick="fn_searchftaTreaty();">${search}</button>
					                		</div>
				                		</div>
					                </div>
                                   </div>

					                <div class="custom-separator"></div>

					                <div class="form-group col-xl-12 row">
					            		<!-- 코드명(VN) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${ftaNm}  </label>
					                		<div class="col-lg-9">
						                		<select class="selectboxCustom" id="ftaTreaty_srch1">
				           							<option selected value="">${all}</option>
				           							<c:forEach var="fta" items="${ftaList}" varStatus="status">
				           								<option value="${fta.cmmnCd}">${fta.cmmnCd} (${fta.cmmnNm})</option>
				           							</c:forEach>
				           						</select>
			           						</div>
					                	</div>

					                <%-- 	<!-- 코드명(EN) -->
										<div class="col-xl-4 col-lg-4 row" id="ftaTreaty1">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${ftaNm}  </label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ftaTreaty_srch2" type="text" placeholder="${cdNmEnMsg}" />
					                		</div>
					                	</div> --%>
					                	<!-- 국가코드(EN) -->
										<div class="col-xl-4 col-lg-6 row" id="ftaNatInfo1">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${natCd}  </label>
					                		<div class="col-lg-9">
						                		<select class="selectboxCustom" id="ftaTreaty_srch12">
				           							<option selected value="">${all}</option>
				           							<c:forEach var="nat" items="${natList}" varStatus="status">
				           								<option value="${nat.cmmnCd}">${nat.cmmnCd} (${nat.cmmnNm})</option>
				           							</c:forEach>
				           						</select>
			           						</div>
					                	</div>
					                	<!-- PSR(EN) -->
										<div class="col-xl-4 col-lg-6 row" id="ftaDocuInfo1">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${psrKnd}  </label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ftaTreaty_srch22" type="text" placeholder="${cdNmEnMsg}" />
					                		</div>
					                	</div>
					                	<%-- <!-- 국가명(KR) -->
					                	<div class="col-xl-4 col-lg-6 row" id="ftaNatInfo2">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${natNm}  </label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ftaTreaty_srch13" type="text" placeholder="${cdNmKrMsg}" />
					                		</div>
					                	</div> --%>
					                	<!-- 문서코드(KR) -->
					                	<div class="col-xl-4 col-lg-6 row" id="ftaDocuInfo2">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${docuCd}  </label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="ftaTreaty_srch23" type="text" placeholder="${cdNmKrMsg}" />
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
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0"><a class="text-default" id="colFtaInfo-title" data-toggle="collapse" href="#accordion-item-icon-right-table-1" aria-expanded="true">${ftaInfo}</a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-table-1" data-parent="#accordionRightIconTable" style="">
								<div class="card-body">
									<!-- 삭제 : <div class="card-header bg-transparent"> -->

									<div class="card-header bg-transparent form-row" style="padding:0 1.25rem; margin-right:15px">
										<!-- 추가: <p class="card-title inline">검색결과 : <span id="atreatyCnt">0</span> 건</p> -->
										<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
											<p class="card-title inline" style="line-height:35px; height:35px">${result} : <span id="atreatyCnt">0</span></p>
											<c:if test="${writable eq 'Y'}">
											    <!-- 클래스 변경 inline -->
												<div class="form-group inline">
													<div class="ul-form__radio-inline">
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ftaTreatyType" value="read" checked="checked" /><span class="ul-form__radio-font">${readOnly}</span><span class="checkmark"></span>
														</label>
														<c:if test='${userAuther eq "KORD MGR"}'>
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ftaTreatyType" value="edit" /><span class="ul-form__radio-font">${edit}</span><span class="checkmark"></span>
														</label>
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ftaTreatyType" value="enrol" /><span class="ul-form__radio-font">${enrollment}</span><span class="checkmark"></span>
														</label>
														</c:if>
													</div>
												</div>
											</c:if>
											<c:if test="${writable eq 'N'}">
												<div class="form-group inline">
													<div class="ul-form__radio-inline">
														<label class="ul-radio__position radio radio-primary form-check-inline">
															<input type="radio" name="ftaTreatyType" value="read" checked="checked" /><span class="ul-form__radio-font">${readOnly}</span><span class="checkmark"></span>
														</label>
													</div>
												</div>
											</c:if>
										</div>

										<div class="text-right" style="flex:auto; margin-left:auto; padding-right:10px; margin-top:1.5px">
											<button class="btn btn-primary" style="padding-right:10px" type="button" id="btnftaTreatySave" onclick="fn_saveFtaTreatyCheck()">${save}</button>
										</div>

										<!-- col-lg-8 삭제 -->
										<!-- 클래스 변경 inline-right -->
										<div class="text-right inline-right">
											<div class="rowWrap">
												<select class="form-control" id="alignTreaty" name="alignTreaty" style="text-align:center">
													<option value="" selected>${orderby} </option>
													<option value="FTA_CD">${ftaCd} &uarr; </option>
													<option value="FTA_CD_DESC">${ftaCd} &darr; </option>
													<option id="aliFta1"value="FTA_NM">${ftaNm} &uarr; </option>
													<option id="aliFta1"value="FTA_NM_DESC">${ftaNm} &darr; </option>
													<option id="aliNat1" value="NAT_CD">${natCd} &uarr; </option>
													<option id="aliNat1" value="NAT_CD_DESC">${natCd} &darr; </option>
													<option id="aliNat2" value="NAT_NM">${natNm} &uarr; </option>
													<option id="aliNat2" value="NAT_NM_DESC">${natNm} &darr; </option>
													<option id="aliDoc1" value="SEQ">${seq} &uarr; </option>
													<option id="aliDoc1" value="SEQ_DESC">${seq} &darr; </option>
													<option id="aliDoc2" value="DOCU_CD">${docuCd} &uarr; </option>
													<option id="aliDoc2" value="DOCU_CD_DESC">${docuCd} &darr; </option>
												</select>
												<div class="select-arrow"></div>
											</div>
										</div>

										<!-- 클래스 변경 inline-right-last -->
										<div class="text-right inline-right-last">
											<div class="rowWrap">
												<select class="form-control" id="treatyPageCnt" name="treatyPageCnt" style="text-align:right">
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
									<div id="hanTreaty" style="margin:10px; margin-right:15px"></div>

<!--
									<div class="card-header bg-transparent">
										<div class="mc-footer">
											<div class="row text-right">
												<div class="col-lg-12">
													<button class="btn btn-primary m-1" type="button" id="btnftaTreatySave" onclick="fn_saveFtaTreatyCheck()">${save}</button>
												</div>
											</div>
										</div>
									</div>
									-->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ============ Body content END ============= -->
</body>
</html>