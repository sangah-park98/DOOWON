<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tiles/inc/taglib.jsp"%>


<c:if test="${empty(loginUser.MEMBER_ID)}">
	<script>
		window.location.href = '/';
	</script>
</c:if>


<!--  header S-->
<header id="top-menu">
	<div class="menu-wrapper">
		<div class="topMenu">
			<div class="wrapper">
				<ul>
					<!-- 회사선택 --> 
					<li>
						<span>${loginUser.COMP_NAME}</span>
					</li>
					<li>
						<span id="logout" onclick="logout()" style="cursor:pointer"></span>
					</li>
				</ul>
			</div>
		</div>
		<!-- web 용 -->
		<div class="nav gnb m-hide" id="nav">
			<div class="logo">
				<a href="/main"><img src="/images/KORD_RMS.png"></a>
			</div>
			<ul class="topNav">
				<c:forEach var="largeMenu" items="${userMenuList}">
					<c:if test="${largeMenu.MENU_LEVEL eq '1'}">
						<li>
							<span> 
								<a href="javascript:void(0)" class="mMenu"><img src="${largeMenu.MENU_ICON}"><p>${largeMenu.MENU_NAME }</p></a>
							</span>
							<div class="subOutter" style="height: 254px; top: 61.8125px; display: none;">
								<ol>
									<c:forEach var="smallMenu" items="${userMenuList}">
										<c:if test="${largeMenu.MENU_NO eq smallMenu.MENU_PARENT_NO}">
											<li><a href="#" id="${fn:split(smallMenu.MENU_LINK, '/')[1] }" class="${smallMenu.MENU_LINK}"><p>${smallMenu.MENU_NAME}</p></a></li>
										</c:if>
									</c:forEach>
								</ol>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="bg" style="top: 0px; height: 341.625px; display: none;"></div>
		
		<!-- moblie 용 -->
		<nav class="navigation pc-hide" id="mGnb">
			<span class="hamburger-menu">KORD FTA <span class="burger-1"></span>
				<span class="burger-2"></span> <span class="burger-3"></span>
			</span>
			<ul class="core-menu" style="display: none;">
				<c:forEach var="largeMenu" items="${userMenuList}">
					<c:if test="${largeMenu.MENU_LEVEL eq '1'}">
						<li>
							<a href="javascript:void(0)" class="mMenu"><img src="${largeMenu.MENU_ICON}"><p>${largeMenu.MENU_NAME }</p></a>
							<ul class="dropdown" style="display: none;">
								<c:forEach var="smallMenu" items="${userMenuList}">
									<c:if test="${largeMenu.MENU_NO eq smallMenu.MENU_PARENT_NO}">
										<li class="sub"><a href="#" id="${fn:split(smallMenu.MENU_LINK, '/')[1] }" class="${smallMenu.MENU_LINK}">${smallMenu.MENU_NAME}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</nav>
	</div>
</header>
<!--  header E-->