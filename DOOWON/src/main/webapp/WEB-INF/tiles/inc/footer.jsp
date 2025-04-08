<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 공통팝업 start -->
<div class="modal fade bd-example-modal-lg" id="cmmnPopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-lg modal-custom">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitleCmmn">
                    <span id="txtCmmnPop1">공통코드</span>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="flexWrapper">
                        <div class="flexContent">
                            <div class="flexInput">
                                <div>
                                    <span id="txtCmmnPop3">코드</span>
                                    <input class="form-control" id="cmmnPop_srch1" type="text" placeholder="코드를 입력해주세요">
                                </div>
                                <div>
                                    <span id="txtCmmnPop4">코드명</span>
                                    <input class="form-control" id="cmmnPop_srch2" type="text" placeholder="코드명을 입력해주세요">
                                </div>
                            </div>
                        </div>
                        <div class="flexContent flexBtn">
                            <button class="btn btn-primary m-1" type="button" id="btnCmmnPop" onclick="fn_searchCmmnPop();">
                                <span id="txtCmmnPop6">검색</span>
                            </button>
                        </div>
                    </div>
                    <!-- handson table -->
                    <div id="cmmnCdPopup" style="margin-top: 3px; height: 300px; overflow: hidden; width: 96%;" class="handsontable htRowHeaders htColumnHeaders ht__manualRowMove" data-initialstyle="margin-top: 3px" data-originalstyle="margin-top: 3px; height: 300px; overflow: hidden; width: 96%;">
                        <div class="ht_master handsontable">
                            <div class="wtHolder" style="position: relative; height: 0px; width: 0px;">
                                <div class="wtHider" style="width: 150px; height: 1px;">
                                    <div class="wtSpreader" style="position: relative;">
                                        <table class="htCore">
                                            <colgroup></colgroup>
                                            <thead>
                                                <tr></tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ht_clone_top handsontable" style="position: absolute; top: 0px; left: 0px; overflow: hidden; width: 0px; height: 0px;">
                            <div class="wtHolder" style="position: relative; width: 0px; height: 17px;">
                                <div class="wtHider" style="width: 150px;">
                                    <div class="wtSpreader" style="position: relative;">
                                        <table class="htCore">
                                            <colgroup></colgroup>
                                            <thead>
                                                <tr></tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ht_clone_bottom handsontable" style="position: absolute; top: 0px; left: 0px; overflow: hidden;">
                            <div class="wtHolder" style="position: relative;">
                                <div class="wtHider">
                                    <div class="wtSpreader" style="position: relative;">
                                        <table class="htCore">
                                            <colgroup></colgroup>
                                            <thead>
                                                <tr></tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ht_clone_left handsontable" style="position: absolute; top: 0px; left: 0px; overflow: hidden; height: 0px; width: 0px;">
                            <div class="wtHolder" style="position: relative; height: 0px; width: 17px;">
                                <div class="wtHider" style="height: 1px;">
                                    <div class="wtSpreader" style="position: relative;">
                                        <table class="htCore">
                                            <colgroup></colgroup>
                                            <thead>
                                                <tr></tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ht_clone_top_left_corner handsontable" style="position: absolute; top: 0px; left: 0px; overflow: hidden;">
                            <div class="wtHolder" style="position: relative;">
                                <div class="wtHider">
                                    <div class="wtSpreader" style="position: relative;">
                                        <table class="htCore">
                                            <colgroup></colgroup>
                                            <thead>
                                                <tr></tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="hot-display-license-info">
                    	<a href="https://handsontable.com/docs/tutorial-license-key.html" target="_blank">Read more</a> 
                    	<a href="mailto:support@handsontable.com">support@handsontable.com</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 공통팝업 end -->