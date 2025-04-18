package egovframework.dw.util;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public class importUpdate_ExcelUtil {
	
	// 엑셀파일 생성
	public static void generateExcelFile(XSSFWorkbook wb, String fileName, HttpServletResponse response) throws Exception {
		boolean resultType = true;
	
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String fileNameDt = sdf.format(date);
	
		fileName = fileName+"_"+fileNameDt+".xlsx";
		//타입 및 파일명 지정
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; filename="+fileName);
		try (OutputStream outputStream = response.getOutputStream()) {
	        wb.write(outputStream);
	        outputStream.flush();
		} catch(Exception e) {
			resultType = false;
		} finally {
			if (!resultType) {
				response.reset();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
	
				PrintWriter outC = response.getWriter();
				outC.println("<script>alert('파일생성에 문제가 발생했습니다.'); history.back();</script>");
				outC.flush();
			}
	
			if (wb != null) {
				wb.close();
			}
		}
	}
	
	// sheet 생성 및 메인 타이틀 생성
	public static XSSFSheet createSheetWithTitleRow(XSSFWorkbook wb, String sheetName, int colSize) {
	   
		XSSFSheet sheet = wb.createSheet(sheetName);
		XSSFRow row = sheet.createRow(0);
	   
		XSSFCell cell = row.createCell(0);
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
	   
		font.setFontHeightInPoints((short)18);
		font.setFontName("맑은 고딕");
		font.setBold(true);
		font.setUnderline(XSSFFont.U_SINGLE);
	   
		style.setAlignment(HorizontalAlignment.CENTER); 
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(font);
	   
		cell.setCellStyle(style);
		cell.setCellValue(sheetName);
	   
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colSize));
	   
		return sheet;
	}
	
	// main title 하단에 summaryContent 생성
	public static XSSFSheet createSummaryCont(XSSFSheet sheet, ArrayList<String> conts) {
		sheet.createRow(sheet.getLastRowNum() +1); // 서머리 콘텐츠 상단에 빈줄 삽입
		// 오늘 날짜 포맷 설정
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
		for(String cont : conts) {
			XSSFRow row = sheet.createRow(sheet.getLastRowNum() +1);
			XSSFCell cell = row.createCell(0);
		   
			cell.setCellValue("출력일 : " + currentDate);
		}
	   
		return sheet;
	};
    
	// summaryContent 하단에 MainTable생성 
	// 헤더 + 데이터부
	public static XSSFSheet createMainTable(XSSFSheet sheet, List<?> resultList, SearchVO vo) {
		XSSFWorkbook wb = sheet.getWorkbook();
		XSSFRow row = sheet.createRow(sheet.getLastRowNum() +1); // 메인 테이블 상단에 빈줄 삽입
		XSSFCell cell = null;
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		XSSFDataFormat df = wb.createDataFormat();
	   
		// 헤더부
		for(String str : vo.getExTit().split("\\|\\|\\|")) {
			String[] header = str.split("\\|\\|");
			row = sheet.createRow(sheet.getLastRowNum() +1);
			row.setHeight((short)400);
		   
			XSSFCell firstCell = row.createCell(0);
		   
			font.setFontHeightInPoints((short)10);
			font.setFontName("맑은 고딕");
			font.setBold(true);
	       
			style.setFont(font);
			style.setAlignment(HorizontalAlignment.CENTER); 
			style.setVerticalAlignment(VerticalAlignment.CENTER); 
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
	       
			firstCell.setCellStyle(style);
			
			for(String headerOptions : header) {
				String[] valueAndOption = headerOptions.split("\\|");
				System.out.println("valueAndOption[1] : " + Arrays.toString(valueAndOption));
				System.out.println("valueAndOption[1] : " + valueAndOption[1]);
				valueAndOption[1] = "".equals(valueAndOption[1]) ? "0" : valueAndOption[1];
				cell = row.createCell(row.getLastCellNum());
			   
				cell.setCellStyle(style);
				cell.setCellValue("null".equals(valueAndOption[0]) ? "" : valueAndOption[0]);
				sheet.setColumnWidth(cell.getColumnIndex(), 5000);
				int mergeCnt = 0;
		       
				if(!"null".equals(valueAndOption[1])) {
					mergeCnt = Integer.parseInt(valueAndOption[1]);   
		       }
		       if(mergeCnt > 1) {
		    	   int startIdx = cell.getColumnIndex();
		    	   
		    	   for(int i=0; i < (mergeCnt -1); i++) {
		    		   cell = row.createCell(row.getLastCellNum());
		    	   }
		    	   //System.out.println(row.getRowNum()+" , "+ row.getRowNum()+" , "+ startIdx +" , "+ cell.getColumnIndex());
		    	   
		    	   sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), startIdx, cell.getColumnIndex()));
		       };
			};
		};
	   System.out.println("11212121");
		// 데이터부
		if(resultList == null || resultList.size() < 1) {
			row = sheet.createRow(sheet.getLastRowNum() +1);
			cell = row.createCell(0);
			cell.setCellValue("조회된 데이터가 없습니다.");
		};
		
		
		String[] colOptios = vo.getExCol().split("\\|\\|");
		boolean completeSetWidth = false;
		int rowNum = 1;
		style = wb.createCellStyle();
		font = wb.createFont();
		df = wb.createDataFormat();
	   System.out.println("style :"+style);
	   System.out.println("font :"+font);
	   System.out.println("df :"+df);
	   System.out.println("resultList :"+resultList);
		for(Object result : resultList) {
			EgovMap map = (EgovMap) result;
			row = sheet.createRow(sheet.getLastRowNum() +1);
			
			XSSFCell firstCell = row.createCell(0);
			style = wb.createCellStyle();
			font = wb.createFont();
			
			font.setFontHeightInPoints((short)9);
			font.setFontName("맑은 고딕");
			font.setBold(true);
	       
			style.setFont(font);
			style.setAlignment(HorizontalAlignment.CENTER); 
			style.setVerticalAlignment(VerticalAlignment.CENTER); 
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
	       
			firstCell.setCellStyle(style);
			firstCell.setCellValue(String.valueOf(rowNum));
			
			sheet.setColumnWidth(0, 1200);
		   
			for(String options : colOptios) {
			System.out.println("options"+options);
			System.out.println("colOptios"+colOptios);
				String[] attrs = options.split("\\|");
				System.out.println("attrs : " + attrs);
				System.out.println("options : " + options);
				System.out.println("colOptios : " + colOptios);
				cell = row.createCell(row.getLastCellNum());
				
				style = wb.createCellStyle();
				font = wb.createFont();
				df = wb.createDataFormat();
				
				font.setFontHeightInPoints((short)9);
				font.setFontName("맑은 고딕");
				
				style.setFont(font);
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderBottom(BorderStyle.THIN);
			   System.out.println("attrs[1]"+attrs[1]);
				switch (attrs[1]) {
					case "htCenter":
						style.setAlignment(HorizontalAlignment.CENTER);
						cell.setCellStyle(style);
						/*cell.setCellValue(map.containsKey(attrs[0]) ? (String) map.get(attrs[0]) : "");*/
						cell.setCellValue(map.containsKey(attrs[0]) ? String.valueOf(map.get(attrs[0])) : "");

						break;
					case "htLeft":
						style.setAlignment(HorizontalAlignment.LEFT);
						cell.setCellStyle(style);
						/*cell.setCellValue(map.containsKey(attrs[0]) ? (String) map.get(attrs[0]) : "");*/
						cell.setCellValue(map.containsKey(attrs[0]) ? String.valueOf(map.get(attrs[0])) : "");

						break;
					case "htRight":
						 BigDecimal rightVal = map.containsKey(attrs[0]) ? (BigDecimal) map.get(attrs[0]) : BigDecimal.ZERO;
						    String dVal = rightVal.toString();
						
						/*String rightVal = map.containsKey(attrs[0]) ? (String) map.get(attrs[0]) : "";
						Double dVal = (double) 0;*/
						
						/*if(rightVal.contains("%")) {
							rightVal = rightVal.replaceAll("%", "");
							rightVal = StringUtils.isNotEmpty(rightVal) ? rightVal : "0";
							style.setDataFormat(df.getFormat("0.00%"));
							
							if(Double.parseDouble(rightVal) > 0) {
								dVal = Double.parseDouble(rightVal) / 100;
							};
							
						} else {
							rightVal = rightVal.replaceAll(",", "");
							dVal = Double.parseDouble(StringUtils.isNotEmpty(rightVal) ? rightVal : "0");
							style.setDataFormat(df.getFormat("#,##0.00"));
						}*/
						
						style.setAlignment(HorizontalAlignment.RIGHT);
						cell.setCellType(CellType.NUMERIC);
						
						cell.setCellStyle(style);
						cell.setCellValue(dVal);
						break;
					default:
						style.setAlignment(HorizontalAlignment.CENTER);
						cell.setCellStyle(style);
						cell.setCellValue(map.containsKey(attrs[0]) ? (String) map.get(attrs[0]) : "");
						break;
				}
				
				if(!completeSetWidth) {
					sheet.setColumnWidth(cell.getColumnIndex(), Integer.parseInt(attrs[2]) * 50);
				}
				
			}
			completeSetWidth = true;
			rowNum++;
		}
		return sheet;
	};
	
	// 데이터부 하단에 합계표시
	// 0,1번째 셀을 제외한 모든컴럼 표시
	public static XSSFSheet createSummary(XSSFSheet sheet) {
		XSSFWorkbook wb = sheet.getWorkbook();
		XSSFRow row = sheet.createRow(sheet.getLastRowNum() +1);
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		XSSFDataFormat df = wb.createDataFormat();
		
		style = wb.createCellStyle();
		font = wb.createFont();
		
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은 고딕");
		font.setBold(true);
       
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); 
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("합계");
		
		row.createCell(1);
		
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
		
		XSSFCell tempCell = null;
		int startRowNum = 0;
		
		for(int i=sheet.getLastRowNum()-1; i > 0; i--) {
			tempCell = sheet.getRow(i).getCell(0);
			
			if("1".equals(tempCell.getStringCellValue())) {
				startRowNum = i;
				break;
			}
		}
		
		style = wb.createCellStyle();
		font = wb.createFont();
		
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은 고딕");
		font.setBold(true);
       
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.RIGHT); 
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setDataFormat(df.getFormat("#,##0.00"));
		
		for(int i=2; i < sheet.getRow(sheet.getLastRowNum()-1).getLastCellNum(); i++) {
			XSSFCell formulaCell = row.createCell(i);
			String startRef = sheet.getRow(startRowNum).getCell(i).getReference();
			String endRef = sheet.getRow(sheet.getLastRowNum() - 1).getCell(i).getReference();
			
			formulaCell.setCellStyle(style);
			formulaCell.setCellFormula("SUM(".concat(startRef).concat(":").concat(endRef).concat(")"));
			formulaCell.setCellValue("SUM(".concat(startRef).concat(":").concat(endRef).concat(")"));
		}
		return sheet;
	}
	
	public static XSSFSheet createSummary(XSSFSheet sheet, ArrayList<Double> summaryDats) {
		XSSFWorkbook wb = sheet.getWorkbook();
		XSSFRow row = sheet.createRow(sheet.getLastRowNum() +1);
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		XSSFDataFormat df = wb.createDataFormat();
		
		style = wb.createCellStyle();
		font = wb.createFont();
		
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은 고딕");
		font.setBold(true);
       
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); 
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("합계");
		
		cell = row.createCell(1);
		
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
		
		
		font = wb.createFont();
		
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은 고딕");
		font.setBold(true);
       
		for(int i=0; i < summaryDats.size(); i++) {
			cell = row.createCell(i +2);
			style = wb.createCellStyle();
			
			if(summaryDats.get(i) == null) {
				style.setFont(font);
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderBottom(BorderStyle.THIN);
				style.setAlignment(HorizontalAlignment.CENTER);
				
				cell.setCellStyle(style);
				cell.setCellType(CellType.STRING);
				cell.setCellValue("");
			} else {
				style.setDataFormat(df.getFormat("#,##0.00"));
				style.setFont(font);
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderBottom(BorderStyle.THIN);
				style.setAlignment(HorizontalAlignment.RIGHT);
				
				cell.setCellStyle(style);
				cell.setCellType(CellType.NUMERIC);
				cell.setCellValue(summaryDats.get(i));
			}
		}
		return sheet;
	}
}
