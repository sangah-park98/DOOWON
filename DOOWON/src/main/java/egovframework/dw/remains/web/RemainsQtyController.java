package egovframework.dw.remains.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.dw.remains.service.remainsInfoVO;
import egovframework.dw.remains.service.remainsQtyService;


@Controller
public class RemainsQtyController {

	@Resource(name = "remainsQtyService")
	private remainsQtyService remainsqtyService;
	
	@Resource(name = "fileProperties")
	private Properties fileProperties;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
	@RequestMapping(value = "/remains/remainsQty.do")
	public String remainsQtyView(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("grpCd", userVO.getGrpCd());
		return "remains/remainsQty";
	}

	@RequestMapping(value = "/remains/selectRemainsViewList.do", method = RequestMethod.POST)
	public ModelAndView selectRemainsViewList(@RequestBody SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setList(userVO.getCorpNos());
		List<?> resultList = remainsqtyService.selectRemainsViewList(vo);
	    ModelAndView mav = new ModelAndView("jsonView");
	    mav.addObject("resultList", resultList);
	    return mav;
	}
	
	@RequestMapping(value = "/remains/selectRemainsRptNoList.do")
	public ModelAndView selectRemainsRptNoList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		List<?> resultList = remainsqtyService.selectRemainsRptNoList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@RequestMapping(value = "/remains/selectRemainsInputList.do", method = RequestMethod.POST)
	public ModelAndView selectRemainsInputList(@RequestBody SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setList(userVO.getCorpNos());
		List<?> resultList = remainsqtyService.selectRemainsInputList(vo);
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@RequestMapping(value = "/remains/getImporterList.do", method = RequestMethod.POST)
	public ModelAndView getImporterList(HttpServletRequest request, ModelMap model) throws Exception {
		List<?> resultList = remainsqtyService.getImporterList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@RequestMapping(value = "/remains/getExpFirmList.do", method = RequestMethod.POST)
	public ModelAndView getExpFirmList(HttpServletRequest request, ModelMap model) throws Exception {
		List<?> resultList = remainsqtyService.getExpFirmList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@RequestMapping(value = "/remains/getTaStIsoList.do", method = RequestMethod.POST)
	public ModelAndView getTaStIsoList(HttpServletRequest request, ModelMap model) throws Exception {
		List<?> resultList = remainsqtyService.getTaStIsoList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@RequestMapping(value = "/remains/getCaseTypeList.do", method = RequestMethod.POST)
	public ModelAndView getCaseTypeList(HttpServletRequest request, ModelMap model) throws Exception {
		List<?> resultList = remainsqtyService.getCaseTypeList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@PostMapping("/remains/deleteRemainsInputList.do")
	@ResponseBody
	public Map<String, Object> deleteRemainsInputList(@RequestBody List<remainsInfoVO> list, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		Map<String, Object> response = new HashMap<>();
	    try {
	        for (remainsInfoVO vo : list) {
	        	vo.setRemainsQty(vo.getRemainsQty());
	            vo.setExpFirm(vo.getExpFirm());
	            vo.setImporter(vo.getImporter());
	            vo.setRptNo(vo.getRptNo());
	            vo.setUsedDt(vo.getUsedDt());
	            vo.setUsedQty(vo.getUsedQty().replace(",", ""));
	            vo.setLanNo(vo.getLanNo());
	            vo.setSil(vo.getSil());
	            vo.setRegId(userVO.getId());
	            remainsqtyService.deleteRemainsInputList(vo);
	        }
	        response.put("status", "success");
	    } catch (Exception e) {}
	    return response;
	}

	@ResponseBody
	@RequestMapping(value = "/remains/insertRemainsInputList.do", method = RequestMethod.POST)
	public String insertRemainsInputList(@RequestBody List<remainsInfoVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		remainsqtyService.insertRemainsInputList(voList, userVO);
		return "success";
	}
	
	@RequestMapping(value = "/remains/downloadFile.do")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String docuPath = request.getParameter("docuPath");
		System.out.println(docuPath);
		String docuFile = request.getParameter("docuFile");
		String docuOrgFile = request.getParameter("docuOrgFile");

		String saveDir = docuPath;
		File file = new File(saveDir + "/" + docuFile);
		String encodedFileName = URLEncoder.encode(docuOrgFile, "UTF-8").replaceAll("\\+", "%20");
		// response.setHeader("Content-Disposition", "attachment;filename=\"" + encodedFileName + "\";");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		
		
		/*FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();

		byte b [] = new byte[1024];
		int data = 0;

		while((data=(fileInputStream.read(b, 0, b.length))) != -1)
		{
			servletOutputStream.write(b, 0, data);
		}

		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();*/
		
		try (FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream()) {

			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				servletOutputStream.write(buffer, 0, bytesRead);
			}

			servletOutputStream.flush();
		}
	}
	
	@PostMapping(value = "/remains/remainsZipFileCreate.do")
	public void remainsZipFileCreate(@RequestBody List<ZipFileDownload> downloadFile,
	        @ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model,
	        HttpServletResponse response) throws Exception {
		String saveDir = "/home/files";
		String saveDir2 = "";
		String zipFileName = downloadFile.get(0).getInvoiceNo() + "_" + downloadFile.get(0).getRptNo() + ".zip";
		try {
			FileOutputStream fos = new FileOutputStream(saveDir + File.separator + zipFileName);
			ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(fos);
            // 파일 목록을 순회하며 압축 파일에 추가
            for (ZipFileDownload file : downloadFile) {
        		saveDir2 = file.getDocuPath();
                addFileToZip(saveDir2, file.getDocuFile(), zipOut, file.getDocuOrgFile());
            }
	        zipOut.close(); // ZIP 출력 스트림 닫기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
	}

	private void addFileToZip(String directoryPath, String fileName, ZipArchiveOutputStream zipOut, String fileOrgName) throws IOException {
	    String docuFile = fileName;
	    String docuOrgFile = fileOrgName;
	    System.out.println("docuFile: "+docuFile);
	    System.out.println("docuOrgFile: "+docuOrgFile);
	    File file = new File(directoryPath, docuFile);
	    FileInputStream fis = new FileInputStream(file);
	    // 한글 파일명을 UTF-8로 인코딩
	    ZipArchiveEntry zipEntry = new ZipArchiveEntry(file, docuOrgFile);
	    zipOut.putArchiveEntry(zipEntry);
	    
	    byte[] bytes = new byte[1024];
	    int length;
	    while ((length = fis.read(bytes)) >= 0) {
	        zipOut.write(bytes, 0, length);
	    }

	    zipOut.closeArchiveEntry();
	    fis.close();
	}
	
	@RequestMapping(value = "/remains/rptNoFileListDown.do")
  	public void rptNoFileListDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String zipName = request.getParameter("remainsRptNoZipDown");
  		System.out.println("zipName : " + zipName);
  		String saveDir = "/home/files";
  		File file = new File(saveDir + "/" + zipName + ".zip");
  		response.setHeader("Content-Disposition","attachment;filename=\"" + zipName + ".zip\";");

  		FileInputStream fileInputStream = new FileInputStream(file);
  		ServletOutputStream servletOutputStream = response.getOutputStream();

  		byte b [] = new byte[1024];
  		int data = 0;

  		while((data=(fileInputStream.read(b, 0, b.length))) != -1)
  		{
  			servletOutputStream.write(b, 0, data);
  		}
  		servletOutputStream.flush();
  		servletOutputStream.close();
  		fileInputStream.close();
  	}
	
	@RequestMapping(value = "/remains/remainsQtyExcelDown.do")
	public ModelAndView remainsQtyExcelDown(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		ModelAndView mv = new ModelAndView("jsonView");
		String resultCode="200";
		
		try {
			ModelAndView dataMv = new ModelAndView();
			List<?> resultList = new ArrayList<>();
	    
			XSSFWorkbook workBook = new XSSFWorkbook();
			String[] colUnion = {};
			String[] haedUnion =  {};
			String[] divUnion = {};
			int unionIdx = 0;
				
			colUnion = vo.getExCol().split("\\|\\|\\|");
			haedUnion = vo.getExTit().split("\\|\\|\\|\\|");
			divUnion = vo.getExTitDiv().split("\\|\\|", -1);
			
			for(String div : divUnion) {
				String divIdx = div.split("\\|")[0];
				String divName = div.split("\\|")[1];
				
				XSSFSheet sheet = egovframework.dw.util.ExcelUtil.createSheetWithTitleRow(workBook, divName, colUnion[unionIdx].split("\\|\\|").length);
				
				SearchVO sheetSearchVo = new SearchVO();
				sheetSearchVo.setList(userVO.getCorpNos());
				sheetSearchVo.setRecordCountPerPage(99999999);
				sheetSearchVo.setStartPage(0);
				
				sheetSearchVo.setSrch2((String) vo.getSrch2());
				sheetSearchVo.setSrch3((String) vo.getSrch3());
				sheetSearchVo.setSrch4((String) vo.getSrch4());
				sheetSearchVo.setSrch5((String) vo.getSrch5());
				sheetSearchVo.setSrch8((String) vo.getSrch8());
				
				
				switch (divIdx) {
					case "1":
						dataMv = this.selectRemainsViewList(sheetSearchVo, request, new ModelMap());
						resultList = (List<?>) dataMv.getModel().get("resultList");
						break;
					default:
						break;
				}
				
				ArrayList<String> conts = new ArrayList<String>();
				conts.add("1");
				sheetSearchVo.setExCol(colUnion[unionIdx]);
				sheetSearchVo.setExTit(haedUnion[unionIdx]);
				sheet = egovframework.dw.util.ExcelUtil.createMainTable(sheet, resultList, sheetSearchVo);
				
				unionIdx++;
			}
			
			// cell 너비 조정 및 하단 타임 스탬프
			int sheetCnt = workBook.getNumberOfSheets();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String nowTime = sdf1.format(now);
			
			for(int i=0; i < sheetCnt; i++) {
				XSSFSheet tempSheet = workBook.getSheetAt(i);
				int columnToHide1 = 1;
			    int columnToHide2 = 2;
			    tempSheet.setColumnHidden(columnToHide1, true);
			    tempSheet.setColumnHidden(columnToHide2, true);
				int cellCnt = tempSheet.getPhysicalNumberOfRows();
				
				for(int j=1; j < cellCnt; j++) {
					tempSheet.autoSizeColumn(j);
				}
				
				tempSheet.createRow(tempSheet.getLastRowNum() +1);
				XSSFRow row = tempSheet.createRow(tempSheet.getLastRowNum() +1);
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(nowTime);
			}
			egovframework.dw.util.ExcelUtil.generateExcelFile(workBook, (vo.getSrch40().replace("_", " ")), response);

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("resultCode", resultCode);
		return mv;
	}
}
