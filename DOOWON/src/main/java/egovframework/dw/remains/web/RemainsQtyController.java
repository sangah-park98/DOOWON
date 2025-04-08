package egovframework.dw.remains.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
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
	public String exportView(HttpServletRequest request, Model model) throws Exception {
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
		response.setHeader("Content-Disposition", "attachment;filename=\"" + encodedFileName + "\";");

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
	
}
