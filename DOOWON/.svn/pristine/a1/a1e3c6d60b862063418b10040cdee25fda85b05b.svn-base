<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	//템플레이트 XML 파일 경로
	String templatePath = "/Jasper/Blank_A4.jrxml";   //JRXML을 읽어들이기 위한 경로를 작성하세요.";
// 	String templatePath = "/Jasper/UnicodeReport.jrxml";

	 // 출력할 PDF 파일 경로
	 String destPath = "/Jasper/exportPdfTest2.pdf";      //"PDF로 변환되어 설치될 경로를 작성하세요.";
	
// 	 Connection con = null;

	 try {

	  // (1)템플레이트 XML 컴파일
	  JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);

	  // (2)파라메타 생성	  
	  Map paramMap = new HashMap();
	  //paramMap.put("JasperReport 에서의 파라미터값을 작성(중요)",웹에서 받을 파라미터값을 작성);	  

	  // (3)데이타소스 생성
// 	  Class.forName("com.mysql.jdbc.Driver");
// 	  con = DriverManager.getConnection("jdbc:mysql://localhost/behind", "project","123qwe");

	  // (4)데이타의 동적 바인드
	  //JasperPrint print = JasperFillManager.fillReport(jasperReport, paramMap, con);
	  JasperPrint print = JasperFillManager.fillReport(jasperReport, paramMap);

	  // (5) PDF로 출력
	  JasperExportManager.exportReportToPdfFile(print, destPath);	

	 } catch (Exception ex) {

	      ex.printStackTrace();

	 }

	 finally{

// 	  try {

// 	   if(con.isClosed() == false){
// 	                con.close();
//          }

// 	  } catch (SQLException e) {

// 	   e.printStackTrace();

// 	  }

	 }
%>

</body>
</html>