<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tiles/inc/taglib.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<title>KORD-RMS</title>
		<meta charset="UTF-8">
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- 공통 js -->
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/login/loginCommon.js"></script>
		<link href="/fta/css/3rd/themes/lite-blue.min.css" rel="stylesheet">
		<!-- jquery -->
		<script src="/fta/js/3rd/plugins/jquery-3.3.1.min.js"></script> 
		<!-- jquery.blockUi.js -->
		<script src="/fta/js/jquery.blockUI.js"></script>

		<!-- 로그인/회원가입전용 css-->
		<link rel="stylesheet" href="/css/login.css">
		<!-- 메인 대시보트 차트 js -->
		<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
	</head>	
	<script>
		<%= request.getAttribute("javascriptCode") %>
	</script>
	<body>
        <tiles:insertAttribute name="body"/>
	</body>
</html>
