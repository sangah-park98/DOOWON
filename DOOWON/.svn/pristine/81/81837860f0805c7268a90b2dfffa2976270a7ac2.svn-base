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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import egovframework.pf.util.ExcelUtil;
import egovframework.pf.util.FileUtil;
import egovframework.pf.util.importUpdate_ExcelUtil;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.CusExpUploadService;
import egovframework.pf.exp.service.SaveExpFileVO;
import egovframework.pf.exp.service.SaveExpMainVO;
import egovframework.pf.exp.service.pfExportService;
import egovframework.pf.imp.service.CusImpUploadService;
import egovframework.pf.imp.service.ImportService;
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
public class CusExpController {

	@Resource(name = "pfExportService")
	private pfExportService pfexportService;
	
	@Resource(name = "cusExpUploadService")
	private CusExpUploadService cusExpUploadService;
	
	
	@RequestMapping(value = "/cusExp/cusExpUpload.do")
	public String cusExpUpload(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("corpNos", userVO.getCorpNos());
		return "export/cusExpUpload";
	}
	
	//타관세사 데이터 업로드
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/cusExp/fileUpload.do")
	public Map<String,Object> fileUploadTemp (@RequestParam("files") MultipartFile[] excelFiles, HttpServletRequest request, ModelMap model, @RequestParam("type")String type){
		
		HttpSession httpSession = request.getSession(true);
		UserSessionVO loginUser = (UserSessionVO) httpSession.getAttribute("USER"); //로그인정보 
		Map<String, Integer> returnData = new HashMap<String, Integer>();
		Map<String,Object> resultData = new HashMap<String, Object>();
		Map<String,Object> excelData = new HashMap<String, Object>();
		try {
	            excelData = ExcelUtil.excelUpload(excelFiles, loginUser);           //엑셀데이터 가공
	            if(type.equals("01")) {
	            	System.out.println("레디");
	            	returnData = cusExpUploadService.insertExpReadyExcelData(excelData, loginUser);
	            }else if(type.equals("02")) {
	            	System.out.println("엔컴");
	            	returnData = cusExpUploadService.insertExpEncomExcelData(excelData, loginUser);
	            }else if(type.equals("03")) {
	            	System.out.println("DHL");
	            	returnData = cusExpUploadService.insertDHLExportData(excelData, loginUser);
	            }
	            //returnData = cusExpUploadService.insertExportTempsExcelData(excelData, loginUser);                     //데이터 insert
	            // System.out.println("returnData"+returnData);
	            //int resultCnt = cusImpUploadService.insertTempDataUploadLog(excelData, returnData, loginUser);  //데이터 로그
	           
	            if (returnData.containsKey("error") && returnData.get("error") == 1) {
	                resultData.put("fileName", excelFiles[0].getOriginalFilename());
	                resultData.put("success", 0);
	                resultData.put("fail", 1);
	                resultData.put("failReason", "조건에 맞지 않는 데이터입니다.");
	                resultData.put("fileLogId", 0); // 필요시 추가 정보
	            }else if( returnData.get("failReason") != 0){
	            Integer failReason = (Integer) returnData.get("failReason");    
	            resultData.put("fileName", excelFiles[0].getOriginalFilename());
	            resultData.put("success", 0);
	            resultData.put("fail", 1);
	            // failReason 값에 따른 메시지 설정
	            switch (failReason) {
	                case 1:
	                    resultData.put("failReason", "열의 개수가 맞지 않습니다.");
	                    break;
	                case 2:
	                    resultData.put("failReason", "사업자번호가 다릅니다.");
	                    break;
	                case 3:
	                    resultData.put("failReason", "신고번호가 누락되었습니다.");
	                    break;
	                default:
	                    resultData.put("failReason", "오류가 발생했습니다.");
	                    break;
	            	}
	            }else {
	            	resultData.put("fileName", excelFiles[0].getOriginalFilename());
		            resultData.put("success", '0');
		            resultData.put("fail", '0');
		            resultData.put("failReason", "NOT_FILE_FORMAT");
		            resultData.put("main", returnData.get("main"));
		            resultData.put("lan", returnData.get("lan"));
		            resultData.put("spec", returnData.get("spec"));
	            }
	            

	        return resultData;
	        
		} catch (Exception e) {
			resultData.put("fileName", excelFiles[0].getOriginalFilename());
			resultData.put("success", '0');
			resultData.put("fail", '0');
			resultData.put("failReason", "NOT_FILE_FORMAT");
			resultData.put("fileLogId", 0);

            return resultData ;
	           
		}
	}
	//데이터 삭제
	@ResponseBody
	@RequestMapping(value = "/cusExp/deleteTempData.do", method = RequestMethod.POST)
	 public int deleteTempData (HttpServletRequest request) throws  Exception{
        Map<String, Object> loginUser = (Map<String, Object>) request.getSession().getAttribute("USER");
        return cusExpUploadService.deleteTempData(loginUser);
    }
	// 타관세사 데이터(수출) 리스트 
	@RequestMapping(value = "/cusExp/selectCusExpViewList.do")
	public ModelAndView selectCusExpViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setList(userVO.getCorpNos());
		}
		if(vo.getSrch1().equals("01")) {
			List<?> resultList = cusExpUploadService.selectCusExpViewList(vo);
			model.addAttribute("resultList", resultList);
		}else {
			List<?> resultList = cusExpUploadService.selectCusFileList(vo);
			model.addAttribute("resultList", resultList);
		}
		
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	//타관세사 데이터(수출) 란 리스트 
	@RequestMapping(value = "/cusExp/selectCusExpViewLanList.do")
	public ModelAndView selectCusExpViewLanList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		List<?> resultList = cusExpUploadService.selectCusExpViewLanList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	//타관세사 데이터(수출) 규격 리스트 
	@RequestMapping(value = "/cusExp/selectCusExpViewSpecList.do")
	public ModelAndView selectCusExpViewSpecList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		List<?> resultList = cusExpUploadService.selectCusExpViewSpecList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	//view 데이터 삭제
	@ResponseBody
    @RequestMapping(value = "/cusExp/deleteExportView.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> deleteImportView(@RequestBody List<SearchVO> customsData) {
	            for (SearchVO vo : customsData) {
	                cusExpUploadService.deleteExportView(vo);
	            }
	            Map<String, String> response = new HashMap<>();
	            response.put("status", "success");
	            return ResponseEntity.ok(response);
	    }

	
}
