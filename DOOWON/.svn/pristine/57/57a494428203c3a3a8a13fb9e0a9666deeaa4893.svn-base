package egovframework.pf.exp.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;

import egovframework.pf.util.FileUtil;
import egovframework.pf.util.importUpdate_ExcelUtil;
import egovframework.ms.exp.service.ExportService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.SaveExpFileVO;
import egovframework.pf.exp.service.SaveExpMainVO;
import egovframework.pf.exp.service.pfExportService;
import egovframework.pf.member.utill.EmailUtill;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;


@Controller
public class ExportController {

	@Resource(name = "exportService")
	private ExportService exportService;
	
	@Resource(name = "pfExportService")
	private pfExportService pfexportService;
	
	private Connection conn;
	
	@Resource(name = "fileProperties")
	private Properties fileProperties;
	
	@RequestMapping(value = "/export/exportIn.do")
	public String exportIn(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		/*model.addAttribute("writable", "Y".equals(userVO.getAdminYn()) ? "Y"
				: ftaCmmnService.selectWriteCheck(request.getServletPath(), userVO));*/
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());

		return "export/exportIn";
	}
	
	// invoice 생성 호출
	@RequestMapping(value = "/export/exportMakeIn.do")
	public String exportMakeIn(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
		
		return "export/exportMakeIn";
	}
	
	@RequestMapping(value = "/export/exportMakePk.do")
	public String exportMakePk(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		return "export/exportMakePk";
	}
	
	// invoice 저장
	@RequestMapping(value = "/export/saveInvoice.do")
	@ResponseBody
	public String saveInvoice(@RequestBody List<SaveExpMainVO>voList, HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		
		SearchVO schVo = new SearchVO();
		schVo.setSrch1(voList.get(0).getInvoiceNo());
		String result = pfexportService.checkInvoiceNumber(schVo);
		
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
		if(result == null) {
			pfexportService.saveInvoiceMainList(voList,userVO);
			String index = voList.get(0).getInvoiceNo();
			System.out.println("index: "+index);
			String mainSeq = pfexportService.selectInvoiceMainIdex(index);
			
			System.out.println("mainSeq: "+mainSeq);
			pfexportService.saveInvoiceSubList(voList,userVO,mainSeq);
			return "success";	
		} else { 
			return "fail";
		}
	}
	
	// 임시저장
	@RequestMapping(value = "/export/saveTempExpMakeInList.do")
	@ResponseBody
	public String saveTempExpMakeInList(@RequestBody List<SaveExpMainVO>voList, HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		SearchVO schVo = new SearchVO();
		SearchVO schVo2 = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		schVo.setSrch10(voList.get(0).getInvoiceNo());
		
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
		
		String mainSeq = pfexportService.checkTempInvoiceNumber(schVo);
		System.out.println(mainSeq);
		schVo2.setSrch1(mainSeq);
		
		if(mainSeq == null) {
			pfexportService.saveTempExpMakeInList(voList,userVO);
			String index = voList.get(0).getInvoiceNo();
			String mainSeq2 = pfexportService.selectTempInvoiceMainIdex(index);
			
			pfexportService.saveTempExpMakeInSubList(voList,userVO,mainSeq2);
			return "success";	
		} else { // 덧붙이기
			pfexportService.deleteTempExpMakeInList(schVo2);
			pfexportService.deleteTempExpMakeInSubList(schVo2);
			
			pfexportService.saveTempExpMakeInList(voList,userVO);
			pfexportService.saveTempExpMakeInSubList(voList,userVO,mainSeq);
			return "fail";
		}
	}
	
	@RequestMapping(value = "/export/selectTempInvoiceMainList.do")
	public ModelAndView selectTempInvoiceMainList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setCmpnyCd(userVO.getCmpnyCd());
			vo.setCorpNo(userVO.getCorpNo());
		}
		System.out.println("srch1 Temp: " + vo.getSrch1());
		List<?> resultList = null;
		List<?> resultList2 = null;
	   
	    resultList = pfexportService.selectTempInvoiceMainList(vo);
		model.addAttribute("resultList", resultList);
		System.out.println("invoice temp main: " + resultList);
		
		resultList2 = pfexportService.selectTempInvoiceSubList(vo);
		model.addAttribute("resultList2", resultList2);
		System.out.println("invoice temp sub: " + resultList2);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@RequestMapping(value = "/export/savePackingList.do")
	@ResponseBody
	public String savePackingList(@RequestBody List<SaveExpMainVO>voList, HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		System.out.println("-------------packing List-------------");
	
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
		
		String index = voList.get(0).getInvoiceNo();
		SearchVO schVo = new SearchVO();
		schVo.setSrch1(voList.get(0).getManufact());
		schVo.setSrch2(voList.get(0).getPlLoadPort());
		schVo.setSrch3(voList.get(0).getPlDestination());
		schVo.setSrch4(voList.get(0).getPlDepDate());
		schVo.setSrch5(voList.get(0).getPlFlight());
		schVo.setSrch6(voList.get(0).getTotalQuantity());
		schVo.setSrch7(voList.get(0).getTotalNet());
		schVo.setSrch8(voList.get(0).getTotalGross());
		schVo.setSrch9("KG");
		schVo.setSrch11(voList.get(0).getTotalPlCnt());
		schVo.setSrch12(voList.get(0).getPlComments());
		schVo.setSrch10(index);
		
		pfexportService.updateManufactPackList(schVo);
		System.out.println("index: " + index);
		
		String mainSeq = pfexportService.selectPackingListMainIdex(index);
		System.out.println("mainSeq: " + mainSeq);
		
		String result = pfexportService.checkInvoiceNumber(schVo);
		System.out.println("result: " + result);
		
		pfexportService.insertPackingListSubList(voList, userVO, mainSeq);

		return "success";
	}

	@RequestMapping(value = "/export/saveTempExpMakePlList.do")
	@ResponseBody
	public String saveTempExpMakePlList(@RequestBody List<SaveExpMainVO>voList, HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		SearchVO schVo = new SearchVO();
		String lang = userVO.getLang();
		String index = voList.get(0).getInvoiceNo();
	
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
		
		schVo.setSrch1(voList.get(0).getManufact());
		schVo.setSrch2(voList.get(0).getPlLoadPort());
		schVo.setSrch3(voList.get(0).getPlDestination());
		schVo.setSrch4(voList.get(0).getPlDepDate());
		schVo.setSrch5(voList.get(0).getPlFlight());
		schVo.setSrch6(voList.get(0).getTotalQuantity());
		schVo.setSrch7(voList.get(0).getTotalNet());
		schVo.setSrch8(voList.get(0).getTotalGross());
		schVo.setSrch9("KG");
		schVo.setSrch10(index);
		schVo.setSrch11(voList.get(0).getTotalPlCnt());
		schVo.setSrch12(voList.get(0).getPlComments());
		System.out.println("plLoad: " + voList.get(0).getPlLoadPort());
		System.out.println("final: " + voList.get(0).getPlDestination());
		System.out.println("flight: " + voList.get(0).getPlFlight());
		System.out.println("quantity: " + voList.get(0).getTotalQuantity());
		System.out.println("net: " + voList.get(0).getTotalNet());
		System.out.println("gross: " + voList.get(0).getTotalGross());
		System.out.println("kg: " + voList.get(0).getTotalKg());
		pfexportService.updateTempManufactPlList(schVo);
		
		String mainSeq = pfexportService.selectTempPlMainIdex(index);
		System.out.println("mainSeq: " + mainSeq);
		
		String result = pfexportService.checkTempInvoiceNumber(schVo);
		System.out.println("result: " + result);
		
		pfexportService.saveTempExpMakePlSubList(voList, userVO, mainSeq);

		return "success";
	}
	
	// Invoice 등록 호출
	@RequestMapping(value = "/export/selectExportInList.do")
	public ModelAndView selectExportInList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setCmpnyCd(userVO.getCmpnyCd());
			vo.setCorpNo(userVO.getCorpNo());
		}
		System.out.println("srch4: " + vo.getSrch4());
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = pfexportService.selectExportInList(vo);
		totCnt = pfexportService.selectExportInTotCnt(vo);
		model.addAttribute("resultList", resultList);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// Invoice 등록 '읽기' PDF 돋보기 팝업창 호출
	@RequestMapping(value = "/export/selectInFilesList.do")
	public ModelAndView selectInFilesList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> expInList = pfexportService.selectInFilesList(vo);
		model.addAttribute("expInList", expInList);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// 수출신고현황 rptNo fileList popUp
	@RequestMapping(value = "/export/selectExpViewFilesList.do")
	public ModelAndView selectExpViewFilesList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> expViewList = pfexportService.selectExpViewFilesList(vo);
		model.addAttribute("expViewList", expViewList);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@PostMapping(value = "/export/expViewZipCreate.do")
	public void expViewZipCreate(@RequestBody List<ZipFileDownload> downloadFile,
	        @ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model,
	        HttpServletResponse response) throws Exception {
	    System.out.println("---------------expViewZipCreate---------------");
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());

		String saveDir = "/home/files";
		String zipFileName = downloadFile.get(0).getRptNo() + ".zip";
		System.out.println(downloadFile.get(0).getRptNo());
		System.out.println(zipFileName);

		try {
			FileOutputStream fos = new FileOutputStream(saveDir + File.separator + zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            // 파일 목록을 순회하며 압축 파일에 추가
            for (ZipFileDownload file : downloadFile) {
                addFileToZip(saveDir, file.getDocuFile(), zipOut);
            }
	        zipOut.close(); // ZIP 출력 스트림 닫기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
	}
	
	@RequestMapping(value = "/export/downloadViewFile.do")
  	public void downloadViewFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String zipName = request.getParameter("expViewZipDown"); // jsp name="expViewZipDown"
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
	
	@PostMapping(value = "/export/downLoadZipFileInList.do")
	public void downLoadZipFileBlList(@RequestBody List<ZipFileDownload> downloadFile,
			@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model,
			HttpServletResponse response) throws Exception {
		System.out.println("downLoadZipFileInList_____________");
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());

		String saveDir = "/home/files";
		String zipFileName = downloadFile.get(0).getInvoiceNo() + ".zip";
		System.out.println(zipFileName);

		try {
			FileOutputStream fos = new FileOutputStream(saveDir + File.separator + zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            // 파일 목록을 순회하며 압축 파일에 추가
            for (ZipFileDownload file : downloadFile) {
                addFileToZip(saveDir, file.getDocuFile(), zipOut);
            }
	        zipOut.close(); // ZIP 출력 스트림 닫기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
	}
	
	 // 파일을 ZIP 파일에 추가하는 메서드
    private void addFileToZip(String directoryPath, String fileName, ZipOutputStream zipOut) throws IOException {
        File file = new File(directoryPath, fileName);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }

	// Invoice 라디오 편집 버튼 PDF 파일 저장
	@RequestMapping(value = "/export/saveExportFilesInfo.do")
	public ModelAndView saveExportFilesInfo(@RequestParam("BL") MultipartFile[] BL,
			@RequestParam("CI") MultipartFile[] CI, @RequestParam("PL") MultipartFile[] PL,
			@RequestParam("exportInNo") String exportInNo, @RequestParam("exportRptNo") String rptNo,
			HttpServletRequest request, ModelMap model) {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("exportInNo: " + exportInNo);
		
		try {
			for (MultipartFile file : CI) {
				String orgFileName = file.getOriginalFilename();
				if (orgFileName != null && !orgFileName.isEmpty()) {
					String name = file.getName();
					String fileName = file.getOriginalFilename();
					String directory = "/home/files";
					String filepath = Paths.get(directory, fileName).toString();
					System.out.println("filepath: " + filepath);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					stream.write(file.getBytes());
					stream.close();

					SaveExpFileVO vo = new SaveExpFileVO();
					vo.setOrgFileName(orgFileName);
					vo.setName(name);
					vo.setFileName(fileName);
					vo.setExportInNo(exportInNo);
					System.out.println("orgFileName1111: " + orgFileName);
					System.out.println("name1111: " + name);
					System.out.println("편집_fileName1111: " + fileName);
					System.out.println("exportInNo1111: " + exportInNo);

					pfexportService.saveExportFileInfo(vo);
				}
			}

			for (MultipartFile file : BL) {
				String orgFileName = file.getOriginalFilename();
				if (orgFileName != null && !orgFileName.isEmpty()) {
					String name = file.getName();
					String fileName = file.getOriginalFilename();
					String directory = "/home/files";
					String filepath = Paths.get(directory, fileName).toString();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					stream.write(file.getBytes());
					stream.close();

					SaveExpFileVO vo = new SaveExpFileVO();

					vo.setOrgFileName(orgFileName);
					vo.setName(name);
					vo.setFileName(fileName);
					vo.setExportInNo(exportInNo);
					System.out.println("orgFileName2222: " + orgFileName);
					System.out.println("name2222: " + name);
					System.out.println("fileName2222: " + fileName);
					System.out.println("exportInNo2222: " + exportInNo);

					pfexportService.saveExportFileInfo(vo);
				}
			}
			for (MultipartFile file : PL) {
				String orgFileName = file.getOriginalFilename();
				if (orgFileName != null && !orgFileName.isEmpty()) {
					String name = file.getName();
					String fileName = file.getOriginalFilename();
					String directory = "/home/files";
					String filepath = Paths.get(directory, fileName).toString();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					stream.write(file.getBytes());
					stream.close();

					SaveExpFileVO vo = new SaveExpFileVO();
					vo.setOrgFileName(orgFileName);
					vo.setName(name);
					vo.setFileName(fileName);
					vo.setExportInNo(exportInNo);
					System.out.println("orgFileName3333: " + orgFileName);
					System.out.println("name3333: " + name);
					System.out.println("fileName3333: " + fileName);
					System.out.println("exportInNo3333: " + exportInNo);

					pfexportService.saveExportFileInfo(vo);
				}
			}
			model.addAttribute("result", "success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("result", "error");
		}
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// --------------------------------------------------------------------------------

	private String extractInvoiceNumber(String orgFileName) {
		if (orgFileName != null && !orgFileName.isEmpty()) {
			String fileNameWithoutExtension = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
			return fileNameWithoutExtension.substring(fileNameWithoutExtension.indexOf("CI_") + 3);
		}
		return "";
	}

	// Invoice 읽기 버튼 'Invoice 등록' 파일 저장
	@RequestMapping(value = "/export/insertExportFilesInfo.do")
	public ModelAndView insertExportFilesInfo(
			@RequestParam("fileBl[]") MultipartFile[] filesBl,
			@RequestParam("fileIn[]") MultipartFile[] filesIn,
			@RequestParam("filePl[]") MultipartFile[] filesPl,
			@RequestParam("fileOt[]") MultipartFile[] filesOt,
			@RequestParam("invoiceNo") String invoice,
			@RequestParam("rptNo") String rpt,
			HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("회사명: " + userVO.getCmpnyCd());
		System.out.println("invoice: " + invoice);
		System.out.println("rpt: " + rpt);
		
		String invoiceNo = "";
		String cmpnyCd = userVO.getCmpnyCd();
		String regId = userVO.getId();
		String expInvoiceNumber = "";
		
		for (MultipartFile file : filesIn) {
			  System.out.println("Received file In: " + file.getOriginalFilename());
			  	String name = file.getName();
				String fileName = file.getOriginalFilename();
				String directory = "/home/files";
				expInvoiceNumber = extractInvoiceNumber(fileName);
				String filepath = Paths.get(directory, fileName).toString();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(file.getBytes());
				stream.close();
				
				SaveExpFileVO vo = new SaveExpFileVO();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar date = Calendar.getInstance();
				String uploadDt = sdf.format(date.getTime());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				Calendar date2 = Calendar.getInstance();
				String regDt = sdf2.format(date2.getTime());
				
				vo.setOrgFileName(fileName);
				vo.setName("CI");
				vo.setFileName(fileName);
				if(invoice.equals("")) {
					invoiceNo = expInvoiceNumber;
				} else {
					invoiceNo = invoice;
				}
				vo.setInvoiceNo(invoiceNo);
				vo.setRptNo(rpt);
				vo.setUploadDt(uploadDt);
				vo.setRegDt(regDt);
				vo.setRegId(regId);
				vo.setCmpnyCd(cmpnyCd);
				
				pfexportService.insertExportFilesInfo(vo);
		  }
		
		 for (MultipartFile file : filesBl) {
			  
	            System.out.println("Received file Bl: " + file.getOriginalFilename());
	            String name = file.getName();
				String fileName = file.getOriginalFilename();
				String directory = "/home/files";
				String filepath = Paths.get(directory, fileName).toString();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(file.getBytes());
				stream.close();
				
				SaveExpFileVO vo = new SaveExpFileVO();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar date = Calendar.getInstance();
				String uploadDt = sdf.format(date.getTime());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				Calendar date2 = Calendar.getInstance();
				String regDt = sdf2.format(date2.getTime());
				
				vo.setOrgFileName(fileName);
				vo.setName("BL");
				vo.setFileName(fileName);
				if(invoice.equals("")) {
					invoiceNo = expInvoiceNumber;
				} else {
					invoiceNo = invoice;
				}
				vo.setInvoiceNo(invoiceNo);
				vo.setRptNo(rpt);
				vo.setUploadDt(uploadDt);
				vo.setRegDt(regDt);
				vo.setRegId(regId);
				vo.setCmpnyCd(cmpnyCd);
				
				pfexportService.insertExportFilesInfo(vo);
	      }
		 
		  for (MultipartFile file : filesPl) {
			  System.out.println("Received file PL: " + file.getOriginalFilename());
			  	String name = file.getName();
				String fileName = file.getOriginalFilename();
				String directory = "/home/files";
				String filepath = Paths.get(directory, fileName).toString();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(file.getBytes());
				stream.close();
				
				SaveExpFileVO vo = new SaveExpFileVO();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar date = Calendar.getInstance();
				String uploadDt = sdf.format(date.getTime());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				Calendar date2 = Calendar.getInstance();
				String regDt = sdf2.format(date2.getTime());
				
				vo.setOrgFileName(fileName);
				vo.setName("PL");
				vo.setFileName(fileName);
				if(invoice.equals("")) {
					invoiceNo = expInvoiceNumber;
				} else {
					invoiceNo = invoice;
				}
				vo.setInvoiceNo(invoiceNo);
				vo.setRptNo(rpt);
				vo.setUploadDt(uploadDt);
				vo.setRegDt(regDt);
				vo.setRegId(regId);
				vo.setCmpnyCd(cmpnyCd);
				
				pfexportService.insertExportFilesInfo(vo);
		  }
		  
		  for (MultipartFile file : filesOt) {
			  System.out.println("Received file Re: " + file.getOriginalFilename());
			  	String name = file.getName();
				String fileName = file.getOriginalFilename();
				String directory = "/home/files";
				String filepath = Paths.get(directory, fileName).toString();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(file.getBytes());
				stream.close();
				
				SaveExpFileVO vo = new SaveExpFileVO();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar date = Calendar.getInstance();
				String uploadDt = sdf.format(date.getTime());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				Calendar date2 = Calendar.getInstance();
				String regDt = sdf2.format(date2.getTime());
				
				vo.setOrgFileName(fileName);
				vo.setName("OT");
				vo.setFileName(fileName);
				if(invoice.equals("")) {
					invoiceNo = expInvoiceNumber;
				} else {
					invoiceNo = invoice;
				}
				vo.setInvoiceNo(invoiceNo);
				vo.setRptNo(rpt);
				vo.setUploadDt(uploadDt);
				vo.setRegDt(regDt);
				vo.setRegId(regId);
				vo.setCmpnyCd(cmpnyCd);
				
				pfexportService.insertExportFilesInfo(vo);
		  }
		
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// 수출신고현황 호출
	@RequestMapping(value = "/export/exportView.do")
	public String exportView(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		/*model.addAttribute("writable", "Y".equals(userVO.getAdminYn()) ? "Y"
				: ftaCmmnService.selectWriteCheck(request.getServletPath(), userVO));*/
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());

		return "export/exportView";
	}
	
	// 수출신고현황 데이터 리스트 불러오기
	@RequestMapping(value = "/export/selectExportViewList.do")
	public ModelAndView selectExportViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setCmpnyCd(userVO.getCmpnyCd());
			vo.setCorpNo(userVO.getCorpNo());
		}
		
		List<?> resultList = null;
	    int totCnt = 0;
	    // 페이징 처리 
        resultList = pfexportService.selectExportViewList(vo);
    	totCnt = pfexportService.selectExportViewTotCnt(vo);
	    ModelAndView mav = new ModelAndView("jsonView");
	    mav.addObject("resultList", resultList);
	    mav.addObject("totCnt", totCnt);

	    return mav;
	}

	// 신고번호 클릭 시 아래에 란 폼 나오게 하기
	@RequestMapping(value = "/export/selectExportViewLanList.do")
	public ModelAndView selectExportViewLanList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());

		List<?> resultList = pfexportService.selectExportViewLanList(vo);
		model.addAttribute("resultList", resultList);

		int totCnt = pfexportService.selectExportViewTotCnt(vo);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// 신고번호 클릭 시 아래에 규격 폼 나오게 하기
	@RequestMapping(value = "/export/selectExportViewSpecList.do")
	public ModelAndView selectExportViewSpecList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());

		List<?> resultList = pfexportService.selectExportViewSpecList(vo);
		model.addAttribute("resultList", resultList);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	// 수출신고정정
	@RequestMapping(value = "/export/exportUpdate.do")
	public String exportUpdate(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		//model.addAttribute("writable", "Y".equals(userVO.getAdminYn()) ? "Y": CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());

		return "export/exportUpdate";
	}

	// 수출신고정정 데이터 리스트 불러오기
	@RequestMapping(value = "/export/selectExportUpdateList.do")
	public ModelAndView selectExportUpdateList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setCmpnyCd(userVO.getCmpnyCd());
			vo.setCorpNo(userVO.getCorpNo());
		}
		
		List<?> resultList = null;
	    int totCnt = 0;
	    // 페이징 처리 
        resultList = pfexportService.selectExportUpdateList(vo);
    	totCnt = pfexportService.selectExportUpdateTotCnt(vo);
	    ModelAndView mav = new ModelAndView("jsonView");
	    mav.addObject("resultList", resultList);
	    mav.addObject("totCnt", totCnt);

	    return mav;
	}
	// ----------------------------------------------------------
	// Invoice 생성 페이지의 LOADING PORT 데이터 가져오기
	@RequestMapping(value = "/export/selectExportMkInLoadList.do")
	public ModelAndView selectExportMkInList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
	    List<?> resultList = pfexportService.selectExportMkInList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("load Port: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	// Invoice 생성 페이지의 TERMS OF TRADE 데이터 가져오기
	@RequestMapping(value = "/export/selectExportMkInTradeList.do")
	public ModelAndView selectExportMkInTradeList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkInTradeList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("terms of trade: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	// Invoice 생성 페이지의 FINAL DESTINATION 데이터 가져오기
	@RequestMapping(value = "/export/selectExportMkInAprPortList.do")
	public ModelAndView selectExportMkInAprPortList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkInAprPortList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("도착 항구: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	// Invoice 생성 페이지의 '원산지' 가져오기
	@RequestMapping(value = "/export/selectExportMkInNationList.do")
	public ModelAndView selectExportMkInNationList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkInNationList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("원산지: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	// Invoice 생성 페이지의 UOM(단위) 데이터 가져오기
	@RequestMapping(value = "/export/selectExportMkInUOMList.do")
	public ModelAndView selectExportMkInUOMList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkInUOMList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("UOM_단위: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	// Invoice 생성 페이지의 UOM(단위) 데이터 가져오기
	@RequestMapping(value = "/export/selectExportMkInCurrencyList.do")
	public ModelAndView selectExportMkInCurrencyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkInCurrencyList(vo);
		model.addAttribute("resultList", resultList);
		// System.out.println("통화 단위: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@RequestMapping(value = "/export/selectExportMkPLtotCntList.do")
	public ModelAndView selectExportMkPLtotCntList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList = pfexportService.selectExportMkPLtotCntList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	// ----------------------------------------------------------
	
	@RequestMapping(value = "/export/downloadInFile.do")
  	public void downloadInFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String zipName = request.getParameter("zipInName");
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
	
	@RequestMapping(value = "/export/makePdfExcel.do")
	public String makePdfExcel(@RequestBody String invoiceNo, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		Map parameters = new HashMap();
		String cmpny = userVO.getCmpnyCd();
		String reportName = "";
		List allPrint = new ArrayList();
		String addReportName = "";
		JasperReport jasperReport;
		JasperPrint jasperPrint;

		JasperPrint allJasperPrint;
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		String tempDate = formatter.format(new java.util.Date());

	    String ul = request.getServletContext().getRealPath("");
	    System.out.println("======================================================================== start");
	    
	    
	    OutputStream os = null;
	    JRPdfExporter exp = new JRPdfExporter();
	    
	    String pdfUrl = fileProperties.getProperty("pdf.url");
		String path = pdfUrl + "CI_"+invoiceNo+".pdf";
	    
	    parameters.put("i_prm1", invoiceNo);
	    parameters.put("i_prm3", ul);
	    
			System.out.println(parameters);
			try {
				
				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
				List annexList = new ArrayList();
				annexList.add("Invoice");
				annexList.add("PackingList");
				for(int j=0; j<annexList.size(); j++) {
					System.out.println("Crtfissuhist : " + annexList.get(j).toString());
				
				//reportName = selectReportName(vo);
				reportName = annexList.get(j).toString();
				//reportName = "2_Annex_DO";
				System.out.println(parameters);
				String reportPath = ul + "/templet/"+reportName+".jrxml";
				JasperDesign jasperd = JRXmlLoader.load(reportPath);  // 레포트 파일을 Load
			    jasperReport = JasperCompileManager.compileReport(jasperd);

			    System.out.println("start1");
				System.out.println("start2");

				BeanFactory factory = new XmlBeanFactory(new ClassPathResource("egovframework/spring/context-datasource.xml"));
				DataSource ds = (DataSource) factory.getBean("dataSource");
				conn = ds.getConnection();

				jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
				allPrint.add(jasperPrint);
				
				}
			} catch (JRException e) {
				System.err.println(e.getMessage());
			} finally {
				if(os != null) try{ os.close(); }catch(Exception x) { conn.close(); }
			}
			System.out.println("======================================================================== end");
			
			
		
		System.out.println("======================================================================== end");
		System.out.println("allPrint : " + allPrint);

		//PDFmerger.mergeDocuments();
		exp.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, allPrint);
		exp.setParameter(JRPdfExporterParameter.OUTPUT_FILE, new File(ul+path));
		exp.exportReport();
		
		String pafPath = fileProperties.getProperty("pdf.path");
		// 설정된 폴더로 생성된 pdf 파일 복사
		
		if ( System.getProperty("os.name").toLowerCase().indexOf("win")>=0) {
			pafPath = "c:\\home\\files\\"  ;
		} 
		
		FileUtil.copyFile(ul+path, pafPath + path.replaceAll(pdfUrl, ""));
		
		
		SaveExpFileVO vo = new SaveExpFileVO();
		vo.setInvoiceNo(invoiceNo);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setOrgFileName("CI_"+invoiceNo+".pdf");
		vo.setUploadDt(tempDate);
		pfexportService.saveMakeInFile(vo);
		
		
		return "success";
	}
	
/*	@RequestMapping(value = "/export/makePdfExcel.do")
	public String makePdfExcel(@RequestBody String invoiceNo, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		Map parameters = new HashMap();
		String cmpny = userVO.getCmpnyCd();
		String reportName = "IV_" + invoiceNo;
		List annexList = new ArrayList();
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HHmmss");
		
		String ul = request.getServletContext().getRealPath("");
		System.out.println("======================================================================== start");
		parameters.put("i_prm1", invoiceNo);
		parameters.put("i_prm3", ul);
		
		System.out.println(parameters);
		try {
			
			BeanFactory factory = new XmlBeanFactory(new ClassPathResource("egovframework/spring/context-datasource.xml"));
			DataSource ds = (DataSource) factory.getBean("dataSource");
			conn = ds.getConnection();
			
			List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
			
			for(int j=0; j<annexList.size(); j++) {
					System.out.println("Crtfissuhist : " + annexList.get(j).toString());
				reportName = annexList.get(j).toString() + "_EXCEL";
			JasperFillManager.fillReportToFile(ul + "/templet/Invoice.jasper", "/home/files/"+ cmpny + "_" + reportName + ".jrprint", parameters, conn);	
			
			File sourceFile = new File("/home/files/"+ cmpny + "_" +reportName+".jrprint");
			
			JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);
			
			jasperPrintList.add(jasperPrint);
			//}
			
			
			File destFile = new File("/home/files/", reportName);
			
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			
			exporter.exportReport();
			long start = System.currentTimeMillis();
			System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			
		}
		System.out.println("======================================================================== end");
		
		
		
		System.out.println(annexList.size());
		if (annexList.size() == 0 ) {
			return "false";
		} else {
		return "success";
		//}
	}
	
*/	@RequestMapping(value = "/docu/downloadAnnex.do", method = RequestMethod.POST)
	public void downloadAnnex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String tempTime= formatter.format(new java.util.Date());
		String cmpny = userVO.getCmpnyCd();
		
		String reportName = "Statement of origin.xls";
		String saveDir = "/home/files";
		
		File file = new File(saveDir +  "/" + cmpny + "_" + reportName);
		response.setContentType("Application/Msexcel");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","ATTachment; Filename=\"" +tempTime + "_" + cmpny + "_"  + reportName );
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
		response.getOutputStream().close();
	
	}
	
	@RequestMapping(value = "/export/exportSendEmail.do")
  	public void exportSendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String sendInvoiceNo = request.getParameter("sendInvoiceNo");
  		String sendCmpnyCd = request.getParameter("sendCmpnyCd");
  		System.out.println("sendInvoiceNo : " + sendInvoiceNo);
  		System.out.println("sendCmpnyCd : " + sendCmpnyCd);
  		SearchVO vo = new SearchVO();
  		vo.setSrch1(sendInvoiceNo);
  		
  		pfexportService.expRequestBl(vo); // 통관의뢰 -> 통관진행중
  		List<?> expInList = pfexportService.selectInFilesList(vo);
  		
  		String saveDir = "/home/files";
		String zipFileName = sendInvoiceNo + ".zip";

		try {
			FileOutputStream fos = new FileOutputStream(saveDir + File.separator + zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            
            for (Object obj : expInList) {
     			 if (obj instanceof Map) {
     		        Map<?, ?> map = (Map<?, ?>) obj;
     		        String docuFile = (String) map.get("docuFile");
     		        System.out.println(docuFile);
     		        addFileToZip(saveDir, docuFile, zipOut);
     		    }
     		}
	            zipOut.close();
	            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
  		
  		EmailUtill.sendEmailWithFile(sendInvoiceNo, sendCmpnyCd, "isseo@kordsystems.com", "EXPORT", null, "kr", zipFileName);
  	}
	
	
	@RequestMapping(value = "/export/deleteExpInFile.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleteExpInFile(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		
		pfexportService.deleteExpInFile(vo);
		model.addAttribute("SaveStatus", "SaveStatus");
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	
	@RequestMapping(value = "/export/expPopupDeleteList.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView expPopupDeleteList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		
		System.out.println(vo.getSrch1());
		
		pfexportService.expPopupDeleteList(vo);
		model.addAttribute("SaveStatus", "SaveStatus");
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@RequestMapping(value = "/export/saveExpUserMemo.do" , method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveExpUserMemo(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setCorpNo(userVO.getCorpNo());
		pfexportService.saveExpUserMemo(vo);
		
		model.addAttribute("SaveStatus", "success");
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	@RequestMapping(value="/export/exportViewdownloadExcel.do")
	public ModelAndView expViewDowloadExcel(@ModelAttribute("searchVO")SearchVO vo, HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		vo.setRecordCountPerPage(99999999);
		vo.setStartPage(0);
		ModelAndView mv = new ModelAndView("jsonView");
		ModelAndView dataMv = new ModelAndView();
		String resultCode="200";
		String sheetName;
		String name;
		
		switch (vo.getExType()) {
		case "01":
			sheetName = "수출신고현황";
			name = "_수출신고현황";
			break;
		case "02":
			sheetName = "수출신고현황(수리)";
			name = "_수출신고현황(수리)";
			break;
		case "03":
			sheetName = "수출신고현황(미결)";
			name = "_수출신고현황(미결)";
			break;
		case "04":
			sheetName = "수출신고현황(승인)";
			name = "_수출신고현황(승인)";
			break;
		default:
			sheetName = "수출신고현황";
			name = "_수출신고현황";
			break;
		}
		
		try {
				dataMv = this.selectExportViewList(vo, request, new ModelMap());
				List<?> resultList = (List<?>) dataMv.getModel().get("resultList"); 
				System.out.println("resultList111"+resultList);
				XSSFWorkbook workBook = new XSSFWorkbook();
				XSSFSheet sheet = importUpdate_ExcelUtil.createSheetWithTitleRow(workBook, sheetName, vo.getExCol().split("\\|\\|").length);
				ArrayList<String> conts = new ArrayList<String>();
				conts.add("1");
				sheet = importUpdate_ExcelUtil.createSummaryCont(sheet, conts);
				sheet = importUpdate_ExcelUtil.createMainTable(sheet, resultList, vo);
				
				importUpdate_ExcelUtil.generateExcelFile(workBook, userVO.getCmpnyCd().concat(name), response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mv.addObject("resultCode", resultCode);
		return mv;
		}
	
	
	@RequestMapping(value="/export/exportUpdatedownloadExcel.do")
	public ModelAndView exportUpdatedownloadExcel(@ModelAttribute("searchVO")SearchVO vo, HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		vo.setRecordCountPerPage(99999999);
		vo.setStartPage(0);
		ModelAndView mv = new ModelAndView("jsonView");
		ModelAndView dataMv = new ModelAndView();
		String resultCode="200";
		String sheetName;
		String name;
		
		switch (vo.getExType()) {
		case "01":
			sheetName = "수출신고정정";
			name = "_수출신고정정";
			break;
		case "02":
			sheetName = "수출신고정정(전체)";
			name = "_수출신고정정(전체)";
			break;
		case "03":
			sheetName = "수출신고정정(미결)";
			name = "_수출신고정정(미결)";
			break;
		case "04":
			sheetName = "수출신고정정(승인)";
			name = "_수출신고정정(승인)";
			break;
		default:
			sheetName = "수출신고정정";
			name = "_수출신고정정";
			break;
		}
		
		try {
				dataMv = this.selectExportUpdateList(vo, request, new ModelMap());
				List<?> resultList = (List<?>) dataMv.getModel().get("resultList"); 
				System.out.println("resultList111"+resultList);
				XSSFWorkbook workBook = new XSSFWorkbook();
				XSSFSheet sheet = importUpdate_ExcelUtil.createSheetWithTitleRow(workBook, sheetName, vo.getExCol().split("\\|\\|").length);
				ArrayList<String> conts = new ArrayList<String>();
				conts.add("1");
				sheet = importUpdate_ExcelUtil.createSummaryCont(sheet, conts);
				sheet = importUpdate_ExcelUtil.createMainTable(sheet, resultList, vo);
				
				importUpdate_ExcelUtil.generateExcelFile(workBook, userVO.getCmpnyCd().concat(name), response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mv.addObject("resultCode", resultCode);
		return mv;
		}
}
