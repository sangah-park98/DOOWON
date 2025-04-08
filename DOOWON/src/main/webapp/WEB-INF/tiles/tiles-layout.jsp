<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tiles/inc/taglib.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<title>KORD-RMS</title>
		<meta charset="UTF-8">
		<meta name="description" content="">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<!-- 공통 js -->
		<script type="text/javascript" src="/js/common.js"></script>
		
		<!-- 공통 css -->
		<link rel="stylesheet" href="/css/common.css">
		
		<!-- fta파일 -->
		<link rel="stylesheet" href="/fta/css/jquery-ui.css">
		<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/handsontable@7.4.2/dist/handsontable.full.min.js"></script>
		<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/handsontable@7.4.2/dist/handsontable.full.min.css">
		
		<link href="https://fonts.googleapis.com/css?family=Nunito:300,400,400i,600,700,800,900" rel="stylesheet">
		
		<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap" rel="stylesheet">
		<link href="/fta/css/3rd/themes/lite-blue.min.css" rel="stylesheet">
		<link href="/fta/css/3rd/plugins/perfect-scrollbar.min.css" rel="stylesheet">
		<link href="/fta/css/custom.css" rel="stylesheet">
		<link href="/fta/css/3rd/chosen.css" rel="stylesheet">
		<link href="/fta/css/3rd/plugins/nuslider.min.css" rel="stylesheet">
		<script src="/fta/js/3rd/plugins/jquery-3.3.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>
		<script src="/fta/js/3rd/plugins/bootstrap.bundle.min.js"></script>
		<script src="/fta/js/3rd/plugins/perfect-scrollbar.min.js"></script>
		<script src="/fta/js/3rd/scripts/script.min.js"></script>
		<script src="/fta/js/3rd/plugins/echarts.min.js"></script>
		<script src="/fta/js/3rd/scripts/echart.options.min.js"></script>
		<script src="/fta/js/3rd/scripts/dashboard.v1.script.min.js"></script>
		<script src="/fta/js/3rd/scripts/customizer.script.min.js"></script>
		<script src="/fta/js/3rd/chosen.jquery.js"></script>
		<script src="/fta/js/jquery-ui.js"></script>
		<script src="/fta/js/3rd/jquery.number.min.js"></script>
		<script src="/fta/js/cmmn/comUtil.js"></script>
		<script src="/fta/js/calendar.full.min.js"></script>

		
		<script src="/fta/js/3rd/plugins/echarts.min.js"></script>
		<script src="/fta/js/3rd/scripts/echarts.script.min.js"></script>
		<script src="/fta/js/3rd/plugins/apexcharts.min.js"></script>
		<script src="/fta/js/3rd/plugins/apexcharts.dataseries.js"></script>
		<script src="/fta/js/function.js"></script>

		<!-- jquery.blockUi.js -->
		<script src="/fta/js/jquery.blockUI.js"></script>

        <!-- jquery.colResizable.js -->
        <script src="/fta/js/colResizable-1.6.min.js"></script>
        <script src="/fta/js/jquery.mtz.monthpicker.js"></script>

		<!-- main.js -->
		<script src="/fta/js/base/main.js" charset="UTF-8"></script>

		<!-- Dropzone -->
		<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css"/>
		
		<script>
			<%= request.getAttribute("javascriptCode") %>
		</script>
	</head>
	<body class="text-left" id="main">
		<div class="app-admin-wrap layout-sidebar-large">
		    <tiles:insertAttribute name="header"/>
		    <tiles:insertAttribute name="body"/>
		</div>
		<footer>
			<tiles:insertAttribute name="footer"/>
		</footer>
	</body>
</html>
