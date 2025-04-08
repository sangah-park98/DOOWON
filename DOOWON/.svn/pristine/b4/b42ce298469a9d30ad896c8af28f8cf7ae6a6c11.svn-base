 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="ko">
 <head>
 	<meta charset="UTF-8" />
	<script src="/fta/js/function.js"></script>
	<script src="/fta/js/cmmn/notice.js"  charset="UTF-8"></script>
 </head>

 <script type="text/javascript">

 	/* 메시지 */
 	var coltitleVn = "${titleVn}"; //제목(VN)
 	var coltitleEn = "${titleEn}"; //제목(EN)
 	var coltitleKr = "${titleKr}"; //제목(KR)
 	var colcnVn = "${cnVn}"; //내용(VN)
 	var colcnEn = "${cnEn}"; //내용(EN)
 	var colcnKr = "${cnKr}"; //내용(KR)
 	var colattachFile = "${attachFile}"; //첨부파일
 	var colregDt = "${regDt}"; //등록일
 	var coldelYn = "${delYn}"; //삭제여부
 	var colNoticeType = "${noticeType}";

 	var cnVnMsg = "${cnVnMsg}"; //내용을 입력해주세요.
 	var titleVnMsg = "${titleVnMsg}"; //제목을 입력해주세요.
 	var msgSearchError = "${searchError}"; //조회중 에러가 발생하였습니다.
 	var msgSaveEmpty = "${saveEmpty}"; //저장할 데이터가 없습니다.
 	var msgSaveCheck = "${saveCheck}"; //데이터 정합성을 체크해주세요.
 	var msgSaveConfirm = "${saveConfirm}"; //저장하시겠습니까?
 	var msgSaveSuccess = "${saveSuccess}"; //저장 되었습니다.
 	var msgSaveError = "${saveError}"; //저장중 에러가 발생하였습니다.
 	var msgFileDeleteMsg = "${fileDeleteMsg}"; //파일이 삭제되었습니다
 	var msgFileDeleteConfirm = "${fileDeleteConfirm}"; //파일을 삭제하시겠습니까?
 	var msgSelectFileFormat = "${selectFileFormat}";

 </script>

<body class="text-left" id="notice">
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
				                					<input type="radio" name="" value="01"  checked="checked" /><span class="ul-form__radio-font">${notice}</span><span class="checkmark" ></span>
				                				</label>
				                			</div>
				                			<div class="" style="margin-left:auto; display:flex" >
					                			<button class="btn btn-outline-secondary m-1" type="button" onclick="fn_clearNotice()">${clear}</button>
					            				<button class="btn btn-primary m-1" type="button" onclick="fn_searchNotice();">${search}</button>
					                		</div>
				                		</div>
					                </div>
								</div>

        						<div class="custom-separator"></div>





								<div class="form-group col-xl-12 row">
									<!-- 등록일 -->
									<div class="col-xl-4 col-lg-4 rowflex">
					               		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${regDt}</label>
					               		<div class="col-lg-4 cal">
					               			<input type="text" class="form-control band-calendar" id="notice_srch7" name="notice1_date" onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" placeholder="${inputPickDateMsg}" autocomplete="off" readonly>
					               		</div>
					               		<div class="col-lg-5 cal">
					               			<input type="text" class="form-control band-calendar" id="notice_srch8" name="notice2_date" onKeypress="javascript:if(event.keyCode==13) {$('.calendar-popup-container').removeClass('calendar-popup-container_active'); $(this).blur()}" onkeyUp="fn_dateInputForm($(this))" placeholder="${inputPickDateMsg}" autocomplete="off" readonly>
					              		</div>
					               	</div>

										<!-- 제목(VN) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${titleVn}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch1" type="text" onkeyup="enterkey()" placeholder="${titleVnMsg}" />
					                		</div>
					                	</div>

										<!-- 제목(EN) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${titleEn}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch2" type="text" onkeyup="enterkey()" placeholder="${titleEnMsg}" />
					                		</div>
					                	</div>
					                </div>

					                <div class="custom-separator"></div>

					                <div class="form-group col-xl-12 row">
					                	<!-- 제목(KR) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${titleKr}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch3" type="text" onkeyup="enterkey()" placeholder="${titleKrMsg}" />
					                		</div>
					                	</div>

					                	<!-- 내용(VN) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${cnVn}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch4" type="text" onkeyup="enterkey()" placeholder="${cnVnMsg}" />
					                		</div>
					                	</div>

					                	<!-- 내용(EN) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${cnEn}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch5" type="text" onkeyup="enterkey()" placeholder="${cnEnMsg}" />
					                		</div>
					                	</div>
					                </div>

					                <div class="custom-separator"></div>

					                <div class="form-group col-xl-12 row">
					                	<!-- 내용(KR) -->
										<div class="col-xl-4 col-lg-4 rowflex">
					                		<label class="ul-form__label ul-form--margin col-lg-3 col-form-label" for="">${cnKr}</label>
					                		<div class="col-lg-9">
					                			<input class="form-control" id="notice_srch6" type="text" onkeyup="enterkey()" placeholder="${cnKrMsg}" />
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
								<h6 class="card-title ul-collapse__icon--size ul-collapse__right-icon mb-0"><a class="text-default" data-toggle="collapse" href="#accordion-item-icon-right-table-1" aria-expanded="true">${notice}</a></h6>
							</div>
							<div class="collapse show" id="accordion-item-icon-right-table-1" data-parent="#accordionRightIconTable" style="">
								<div class="card-body">
									<div class="card-header bg-transparent form-row" style="padding:0 1.25rem">
										<div class="card-header bg-transparent form-row" style="padding:0 1.25rem" >
											<p class="card-title inline" style="line-height:35px; height:35px">${result} : <span id="noticeCnt">0</span></p>
										</div>

										<div class="text-right" style="flex:auto; margin-left:auto; padding-right:10px; margin-top:1.5px">
											<button class="btn btn-primary" style="padding-right:10px" type="button" onclick="fn_newRegist()">${newRegist}</button>
										</div>

										<div class="text-right inline-right">
											<div class="rowWrap">
												<select class="form-control" id="alignNotice" name="alignNotice" style="text-align:center">
													<option value="" selected>${orderby} </option>
													<option value="TITLE_VN">${titleVn} &uarr; </option>
													<option value="TITLE_VN_DESC">${titleVn} &darr; </option>
													<option value="TITLE_EN">${titleEn} &uarr; </option>
													<option value="TITLE_EN_DESC">${titleEn} &darr; </option>
													<option value="TITLE_KR">${titleKr} &uarr; </option>
													<option value="TITLE_KR_DESC">${titleKr} &darr; </option>
												</select>
												<div class="select-arrow"></div>
											</div>
										</div>

										<div class="text-right inline-right-last">
											<div class="rowWrap">
												<select class="form-control" id="noticePageCnt" name="noticePageCnt" style="text-align:right">
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
									<div id="noticeTable" style="margin:10px;"></div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 공지사항 팝업 start -->
	<div class="modal fade bd-example-modal-lg" id="noticePop"
		 tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		 aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg modal-custom" >
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">${notice}</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
              		</button>
              	</div>
              	<div class="modal-body" style="padding:1rem 0">
              		<div class="card-body">
              			<input type="hidden" name="noticeSeq" />
	                    <!-- 제목(VN) -->
	                    <div class="input-group">
	              			<div class="input-group-prepend"><span class="input-group-text">${titleVn}</span></div>
	              			<input class="form-control" type="text" name="titleVn" aria-label="Username" aria-describedby="basic-addon1" maxlength="100" />
	                    </div>

	                    <!-- 제목(EN) -->
	                    <div class="input-group">
	              			<div class="input-group-prepend"><span class="input-group-text">${titleEn}</span></div>
	              			<input class="form-control" type="text" name="titleEn" aria-label="Username" aria-describedby="basic-addon1" maxlength="100" />
	                    </div>

	                    <!-- 제목(KR) -->
	                    <div class="input-group">
	              			<div class="input-group-prepend"><span class="input-group-text">${titleKr}</span></div>
	              			<input class="form-control" type="text" name="titleKr" aria-label="Username" aria-describedby="basic-addon1" maxlength="100" />
	                    </div>

						<!-- 내용(VN) -->
	                    <div class="input-group">
	                    	<div class="input-group-prepend"><span class="input-group-text">${cnVn}</span></div>
	                    	<textarea class="form-control" name="cnVn" aria-label="With textarea" rows="5"></textarea>
	                    </div>

	                    <!-- 내용(EN) -->
	                    <div class="input-group">
	                    	<div class="input-group-prepend"><span class="input-group-text">${cnEn}</span></div>
	                    	<textarea class="form-control" name="cnEn" aria-label="With textarea" rows="5"></textarea>
	                    </div>

	                    <!-- 내용(KR) -->
	                    <div class="input-group">
	                    	<div class="input-group-prepend"><span class="input-group-text">${cnKr}</span></div>
	                    	<textarea class="form-control" name="cnKr" aria-label="With textarea" rows="5"></textarea>
	                    </div>

	                    <!-- 첨부파일 -->
	                    <div class="input-group">
	                    	<div class="input-group-prepend"><span class="input-group-text">${attachFile}</span></div>
	                    	<form id="noticeFileForm" method="post" enctype=”multipart/form-data”>
	                    		<input type="file" class="form-control" name="file" id="noticeFile">
	                    	</form>
	                    	<form id="noticeFileDownForm" name="noticeFileDownForm" method="post">
		                    	<input class="form-control" type="text" name="fileOrgNm" readonly="readonly" />
		                    	<input type="hidden" name="fileNm" />
					        </form>
					        <button class="btn btn-light m-1" type="button" id="attach3" onclick="fn_downNoticeFile()">${fileDownload}</button>
					        <button class="btn btn-light m-1" type="button" id="attach4" onclick="fn_deleteNoticeFile()">${fileDelete}</button>
	                    </div>

	                    <div class="inner-flex-custom">
	                    	<!-- 등록일 -->
	                    	<div class="input-group">
	                    		<div class="input-group-prepend"><span class="input-group-text">${regDt}</span></div>
	                    		<input class="form-control" type="text" name="regDt" aria-describedby="basic-addon1" readonly="readonly" />
                 	   		</div>

                 	   		<!-- 삭제여부 -->
                 	   		<div class="input-group">
                    			<div class="input-group-prepend"><span class="input-group-text">${delYn}</span></div>
                    			<select class="selectboxCustom" name="delYn">
	       							<option value="Y">Y</option>
                    				<option selected value="N">N</option>
	       						</select>
                 	   		</div>
                 	   		<!-- 상단고정여부 -->
                 	   		<div class="input-group">
                    			<div class="input-group-prepend"><span class="input-group-text">${noticeType}</span></div>
                    			<select class="selectboxCustom" name="noticeType">
	       							<option value="Y">Y</option>
                    				<option selected value="N">N</option>
	       						</select>
                 	   		</div>
                    	</div>
              		</div>

              		<div class="modal-footer">
              			<div class="mc-footer">
		            		<div class="row text-center">
		            			<div class="col-lg-12">
		            				<button class="btn btn-primary" type="button" id="btnNoticeSave" onclick="fn_saveNotice()">${save}</button>
		            			</div>
		            		</div>
		            	</div>
		            </div>
				</div>
			</div>
		</div>
	</div>
	<!-- 공지사항 팝업 end -->

</body>
</html>