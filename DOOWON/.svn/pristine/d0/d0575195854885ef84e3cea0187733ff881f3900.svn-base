<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tiles/inc/taglib.jsp"%>

<!-- 회원완료 -->
<c:forEach var="joinSuccess" items="${joinSuccessCode}">
	<c:choose>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text1'}">
			<c:set var="joinSuccess_text1" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text2'}">
			<c:set var="joinSuccess_text2" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text3'}">
			<c:set var="joinSuccess_text3" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text4'}">
			<c:set var="joinSuccess_text4" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text5'}">
			<c:set var="joinSuccess_text5" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text6'}">
			<c:set var="joinSuccess_text6" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text7'}">
			<c:set var="joinSuccess_text7" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text8'}">
			<c:set var="joinSuccess_text8" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
		<c:when test="${joinSuccess.CODE_COMMON_ID eq  'text9'}">
			<c:set var="joinSuccess_text9" value="${joinSuccess.CODE_NAME}"/>
		</c:when>
	</c:choose>
</c:forEach>

<div class="back_full">
    <div class="find_box">
        <div class="title_area">
            <h1>
                ${joinSuccess_text1}
                <p>${joinSuccess_text2}</p>
            </h1>
        </div>
        <fieldset class="form_box">
            <legend class="blind">SIGN UP</legend>

            <div class="inner2">
                <div class="signup_done">
                    <p class="txt01">${joinSuccess_text3}</p>
                    <p class="txt02">${joinSuccess_text4}<br>${joinSuccess_text5}</p>
                </div>

                <div class="signup_info">
                    <dl>
                        <dt>${joinSuccess_text6}</dt>
                        <dd>
                            <p class="txt_id">${joinSuccess_text7} : ${member.MEMBER_ID}</p>
                            <p class="txt_date">${joinSuccess_text8} : ${member.CRT_DT}</p>
                        </dd>
                    </dl>
                </div>
            </div>

            <div class="btn_area">
                <a href="/" class="btn btn_ok">${joinSuccess_text9}</a>
            </div>
        </fieldset>
    </div>
</div>
