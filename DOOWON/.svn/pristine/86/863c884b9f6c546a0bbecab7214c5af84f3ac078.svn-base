package egovframework.pf.imp.web;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.SaveExpFileVO;
import egovframework.pf.exp.web.ZipFileDownload;
import egovframework.pf.imp.service.ImportService;
import egovframework.pf.imp.service.CusImpUploadService;
import egovframework.pf.member.utill.EmailUtill;
import egovframework.pf.util.ExcelUtil;
import egovframework.pf.util.importUpdate_ExcelUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;



@Controller
public class CusImpController {

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
	@Resource(name = "cusImpUploadService")
	private CusImpUploadService cusImpUploadService;
	

	
	//타관세사 데이터 호출
	@RequestMapping(value = "/cusImp/cusImpUpload.do")
	public String customsImportUpdate(HttpServletRequest request, Model model) throws Exception {
		return "import/cusImpUpload";
	}
	
	
	@RequestMapping(value = "/cusImp/selectCusImpViewList.do")
	public ModelAndView selectCusImpViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setList(userVO.getCorpNos());
		}
		System.out.println("srch6"+vo.getSrch6());
		if(vo.getSrch1().equals("01")) {
			List<?> resultList = cusImpUploadService.selectCusImpViewList(vo);
			model.addAttribute("resultList", resultList);
		}else if(vo.getSrch1().equals("02")) {
			List<?> resultList = cusImpUploadService.selectCusImpFileList(vo);
			model.addAttribute("resultList", resultList);
		}
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	@RequestMapping(value = "/cusImp/selectCusImpViewLanList.do")
		public ModelAndView selectCusImpViewLanList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
			List<?> resultList = cusImpUploadService.selectCusImpViewLanList(vo);
			model.addAttribute("resultList", resultList);
			ModelAndView mav = new ModelAndView("jsonView", model);
			return mav ;
		}
	@RequestMapping(value = "/cusImp/selectCusImpViewSpecList.do")
	public ModelAndView selectCusImpViewSpecList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		List<?> resultList = cusImpUploadService.selectCusImpViewSpecList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	//타관세사 데이터 업로드
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/cusImp/fileUploadTemp.do")
	public Map<String, Object> fileUploadTemp (@RequestParam("files") MultipartFile[] excelFiles, HttpServletRequest request, ModelMap model, @RequestParam("type")String type){
		HttpSession httpSession = request.getSession(true);
		UserSessionVO loginUser = (UserSessionVO) httpSession.getAttribute("USER"); //로그인정보 
		System.out.println("type"+type);

		Map<String, Integer> returnData = new HashMap<String, Integer>();
		Map<String,Object> resultData = new HashMap<String, Object>();
		Map<String,Object> excelData = new HashMap<String, Object>();
		try {	 
	            excelData = ExcelUtil.excelUpload(excelFiles, loginUser);           //엑셀데이터 가공
	            
	            if(type.equals("01")) {
	        	   System.out.println("FEDEX");
	        	   returnData = cusImpUploadService.insertFedexExcelData(excelData, loginUser);
	           }else if(type.equals("02")) {
	        	   System.out.println("DHL");
	        	   returnData = cusImpUploadService.insertDhlExcelData(excelData, loginUser);
	           }else if(type.equals("03")) {
	        	   System.out.println("UPS");
	        	   returnData = cusImpUploadService.insertUpsExcelData(excelData, loginUser);
	           }else if(type.equals("04")) {
	        	   System.out.println("레디");
	        	   returnData = cusImpUploadService.insertReadyExcelData(excelData, loginUser);
	           }else if(type.equals("05")) {
	        	   System.out.println("엔컴");
	        	   returnData = cusImpUploadService.insertEncomExcelData(excelData, loginUser);
	           }else {
	        	   
	           }
	            
	            /*else if(type.equals("04")) {
	        	   System.out.println("TNT");
	        	   returnData = cusImpUploadService.insertTntExcelData(excelData, loginUser);
	           }else {
	        	   //System.out.println("기본");
	        	  returnData = cusImpUploadService.insertTempExcelData(excelData, loginUser);     
	           }*/
	            System.out.println("returnData"+returnData);
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
	@RequestMapping(value = "/cusImp/deleteTempData.do", method = RequestMethod.POST)
	 public int deleteTempData (HttpServletRequest request) throws  Exception{
        Map<String, Object> loginUser = (Map<String, Object>) request.getSession().getAttribute("USER");
        return cusImpUploadService.deleteTempData(loginUser);
    }	
	
	//view 데이터 삭제
	@ResponseBody
    @RequestMapping(value = "/cusImp/deleteImportView.do", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> deleteImportView(@RequestBody List<SearchVO> customsData) {
	            for (SearchVO vo : customsData) {
	                cusImpUploadService.deleteImportView(vo);
	            }
	            Map<String, String> response = new HashMap<>();
	            response.put("status", "success");
	            return ResponseEntity.ok(response);
	    }
	
	
	}
