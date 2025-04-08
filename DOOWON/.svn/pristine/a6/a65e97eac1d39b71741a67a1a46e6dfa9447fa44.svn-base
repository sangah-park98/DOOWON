package egovframework.pf.rpt.service.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.rpt.service.AnalysisExcelService;
import egovframework.pf.rpt.service.AnalysisService;
import egovframework.pf.util.ExcelUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : AnalysisController.java
 * @Description : 통계분석 컨트롤러
 * @Modification Information
 * @
 * @  수정일          			 수정자              			 수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.04.15			이재성              				 최초생성
 *
 * @author 이재성
 * @since 2024.04.15
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class AnalysisController {
	private static final Logger log = LoggerFactory.getLogger(KPIController.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
	@Resource(name = "analysisService")
	private AnalysisService analysisService;
	
	@Resource(name = "analysisExcelService")
	private AnalysisExcelService analysisExcelService;
	
	// 통계분석 화면 호출
	@RequestMapping(value = "/rpt/analysis.do")
	public String analysisView(HttpServletRequest request, Model model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		vo.setCmpnyCd(userVO.getCmpnyCd());
		model.addAttribute("lang", lang);
		model.addAttribute("userCmpnyCd", userVO.getCmpnyCd());
			
		return "rpt/analysis";
	}
	
	// 수입실적
	@RequestMapping(value = "/rpt/analysis1.do")
	public ModelAndView selectAnalysis1List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis1List(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 수출실적
	@RequestMapping(value = "/rpt/analysis2.do")
	public ModelAndView selectAnalysis2List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis2List(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 해외거래처별 수입실적
	@RequestMapping(value = "/rpt/analysis3.do")
	public ModelAndView selectAnalysis3List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis3List(vo);
	    totCnt = analysisService.selectAnalysis3ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 해외거래처별 수출실적
	@RequestMapping(value = "/rpt/analysis4.do")
	public ModelAndView selectAnalysis4List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis4List(vo);
	    totCnt = analysisService.selectAnalysis4ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 운임 비교
	@RequestMapping(value = "/rpt/analysis5.do")
	public ModelAndView selectAnalysis5List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis5List(vo);
	    totCnt = analysisService.selectAnalysis5ListCnt(vo);
	    
	    for(Object obj : resultList) {
	    	EgovMap map = (EgovMap)obj;
	    	SearchVO subVo = new SearchVO();
	    	List<?> subResultList = null;
	    	
	    	subVo.setCorpNo(userVO.getCorpNo());
	    	subVo.setSrch1(vo.getSrch2());
	    	subVo.setSrch2(vo.getSrch3());
	    	subVo.setSrch3((String)map.get("fodMark"));
	    	subVo.setSrch4((String)map.get("title"));
	    	subVo.setSrch5((String)map.get("traMet"));
	    	subVo.setSrch6((String)map.get("conCod"));
	    	
	    	subResultList = analysisService.selectAnalysis5SubList(subVo);
	    	
	    	map.put("__children", subResultList);
	    }
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 보험료 비교
	@RequestMapping(value = "/rpt/analysis6.do")
	public ModelAndView selectAnalysis6List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis6List(vo);
	    totCnt = analysisService.selectAnalysis6ListCnt(vo);
	    
	    for(Object obj : resultList) {
	    	EgovMap map = (EgovMap)obj;
	    	SearchVO subVo = new SearchVO();
	    	List<?> subResultList = null;
	    	
	    	subVo.setCorpNo(userVO.getCorpNo());
	    	subVo.setSrch1(vo.getSrch2());
	    	subVo.setSrch2(vo.getSrch3());
	    	subVo.setSrch3((String)map.get("fodMark"));
	    	subVo.setSrch4((String)map.get("title"));
	    	subVo.setSrch5((String)map.get("traMet"));
	    	subVo.setSrch6((String)map.get("conCod"));
	    	
	    	subResultList = analysisService.selectAnalysis6SubList(subVo);
	    	
	    	map.put("__children", subResultList);
	    }
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 외환신고대상 수출 건 
	@RequestMapping(value = "/rpt/analysis7.do")
	public ModelAndView selectAnalysis7List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectAnalysis7List(vo);
	    totCnt = analysisService.selectAnalysis7ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 단가분석 데이터 조회
	@RequestMapping(value = "/rpt/analysisCost1.do")
	public ModelAndView selectCost1List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectCost1List(vo);
    	totCnt = analysisService.selectCost1ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 단가분석 차트 데이터 조회
	@RequestMapping(value = "/rpt/analysisCost1Chart.do")
	public ModelAndView selectCost1Chart(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    
	    resultList = analysisService.selectCost1Chart(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		                                                
		return mav;                                     
	}
	
	// 유무상 수입건 과세가격 비교
	@RequestMapping(value = "/rpt/analysisCost2.do")
	public ModelAndView selectCost2List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectCost2List(vo);
		totCnt = analysisService.selectCost2ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 단가분석 차트 데이터 조회
	@RequestMapping(value = "/rpt/analysisCost2Chart.do")
	public ModelAndView selectCost2Chart(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    
	    resultList = analysisService.selectCost2Chart(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		                                                
		return mav;                                     
	}
	
	// 동일거래, 결제통화 변경점검
	@RequestMapping(value = "/rpt/analysisCost3.do")
	public ModelAndView selectCost3List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectCost3List(vo);
		totCnt = analysisService.selectCost3ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 동일자재코드 품목분류 상이점검
	@RequestMapping(value = "/rpt/analysisEtc1.do")
	public ModelAndView selectEtc1List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectEtc1List(vo);
		totCnt = analysisService.selectEtc1ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 동일자재코드 관세구분 상이점검
	@RequestMapping(value = "/rpt/analysisEtc2.do")
	public ModelAndView selectEtc2List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectEtc2List(vo);
		totCnt = analysisService.selectEtc2ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// 감면 적용 일관성 검토
	@RequestMapping(value = "/rpt/analysisEtc3.do")
	public ModelAndView selectEtc3List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectEtc3List(vo);
		totCnt = analysisService.selectEtc3ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	// FTA 적정성(직접운송원칙)
	@RequestMapping(value = "/rpt/analysisEtc4.do")
	public ModelAndView selectEtc4List(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		
		List<?> resultList = null;
	    int totCnt = 0;
	    
	    resultList = analysisService.selectEtc4List(vo);
		totCnt = analysisService.selectEtc4ListCnt(vo);
		
	    ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("resultList", resultList);
		mav.addObject("totCnt", totCnt);
		                                                
		return mav;                                     
	}
	
	@RequestMapping(value = "/analysis/downloadExcel.do")
	public ModelAndView downloadExcel(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());      
		vo.setCorpNo(userVO.getCorpNo());
		vo.setRecordCountPerPage(99999999);
		vo.setStartPage(0);
		
		ModelAndView mv = new ModelAndView("jsonView");
		String resultCode="200";
		
		try {
			ModelAndView dataMv = new ModelAndView();
			List<?> reslutList = new ArrayList<>();
	    
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
				
				Boolean summary = false;
				ArrayList<Double> summaryDats = null;
				
				XSSFSheet sheet = ExcelUtil.createSheetWithTitleRow(workBook, divName, colUnion[unionIdx].split("\\|\\|").length);
				
				SearchVO sheetSearchVo = new SearchVO();
				sheetSearchVo.setLang(userVO.getLang());      
				sheetSearchVo.setCorpNo(userVO.getCorpNo());
				sheetSearchVo.setRecordCountPerPage(99999999);
				sheetSearchVo.setStartPage(0);
				
				sheetSearchVo.setSrch2((String) vo.getSrch2());
				sheetSearchVo.setSrch3((String) vo.getSrch3());
				sheetSearchVo.setSrch4((String) vo.getSrch4());
				
				
				if("01".equals(vo.getExType())) {
				
					switch (divIdx) {
					case "1":
						dataMv = this.selectAnalysis1List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.analysis1TopSummary(reslutList, sheet, vo, userVO);
						summary = true; 
						break;
					case "2":
						dataMv = this.selectAnalysis2List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.analysis2TopSummary(reslutList, sheet, vo, userVO);
						summary = true;
						break;
					case "3":
						dataMv = this.selectAnalysis3List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.analysis3TopSummary(reslutList, sheet, vo, userVO);
						summary = true;
						break;
					case "4":
						dataMv = this.selectAnalysis4List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						
						sheet = analysisExcelService.analysis4TopSummary(reslutList, sheet, vo, userVO);
						summary = true;
						break;
					case "5":
						dataMv = this.selectAnalysis5List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						List<EgovMap> tempList5 = new ArrayList<EgovMap>();
						
						double freKrwSum5 = 0;
						double totWtSum5 = 0;
						double totTaxKrwSum5 = 0;
						
						for(Object obj : reslutList) {
							EgovMap map = (EgovMap) obj;
							
							String freKrw5 = ((String) map.get("freKrw")).replaceAll(",", "");
							String totWt5 = ((String) map.get("totWt")).replaceAll(",", "");
							String totTaxKrw5 = ((String) map.get("totTaxKrw")).replaceAll(",", "");
							
							freKrwSum5 += Double.parseDouble(freKrw5);
							totWtSum5 += Double.parseDouble(totWt5);
							totTaxKrwSum5 += Double.parseDouble(totTaxKrw5);
							
							tempList5.add(map);
							List<EgovMap> children = (List<EgovMap>)map.get("Children");
							tempList5.addAll(children);
						}
						
						summaryDats = new ArrayList<Double>(9);
						for(int i=0; i < 9 ; i++) {
							summaryDats.add(null);
						}
						
						summaryDats.set(4, freKrwSum5);
						summaryDats.set(5, totWtSum5);
						summaryDats.set(6, totTaxKrwSum5);
						
						
						reslutList = tempList5;
						summary = true;
						
						break;
					case "6":
						dataMv = this.selectAnalysis6List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						List<EgovMap> tempList6 = new ArrayList<EgovMap>();
						
						double insuKrSum6 = 0;
						double totWtSum6 = 0;
						double totTaxKrwSum6 = 0;
						
						for(Object obj : reslutList) {
							EgovMap map = (EgovMap) obj;
							
							String insuKrw6 = ((String) map.get("insuKrw")).replaceAll(",", "");
							String totWt6 = ((String) map.get("totWt")).replaceAll(",", "");
							String totTaxKrw6 = ((String) map.get("totTaxKrw")).replaceAll(",", "");
							
							insuKrw6 += Double.parseDouble(insuKrw6);
							totWtSum6 += Double.parseDouble(totWt6);
							totTaxKrwSum6 += Double.parseDouble(totTaxKrw6);
							
							tempList6.add(map);
							List<EgovMap> children = (List<EgovMap>)map.get("Children");
							tempList6.addAll(children);
						}
						
						summaryDats = new ArrayList<Double>(9);
						for(int i=0; i < 9 ; i++) {
							summaryDats.add(null);
						}
						
						summaryDats.set(4, insuKrSum6);
						summaryDats.set(5, totWtSum6);
						summaryDats.set(6, totTaxKrwSum6);
						
						
						reslutList = tempList6;
						summary = true;
						
						break;
					case "7":
						dataMv = this.selectAnalysis7List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.analysis7TopSummary(reslutList, sheet, vo, userVO);
						break;
					default:
						break;
					}
				} else if("02".equals(vo.getExType())) {
					
					switch (divIdx) {
					case "1":
						dataMv = this.selectCost1List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.cost1TopSummary(reslutList, sheet, vo, userVO);
						break;
					case "2":
						dataMv = this.selectCost2List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.cost2TopSummary(reslutList, sheet, vo, userVO);
						break;
					case "3":
						dataMv = this.selectCost3List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.cost3TopSummary(reslutList, sheet, vo, userVO);
						break;
					default:
						break;
					}
					
				} else if("03".equals(vo.getExType())) {
					
					switch (divIdx) {
					case "1":
						dataMv = this.selectEtc1List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.etc1TopSummary(reslutList, sheet, vo, userVO);
						break;
					case "2":
						dataMv = this.selectEtc2List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.etc2TopSummary(reslutList, sheet, vo, userVO);
						break;
					case "3":
						dataMv = this.selectEtc3List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.etc3TopSummary(reslutList, sheet, vo, userVO);
						
						break;
					case "4":
						dataMv = this.selectEtc4List(sheetSearchVo, request, new ModelMap());
						reslutList = (List<?>) dataMv.getModel().get("resultList");
						sheet = analysisExcelService.etc4TopSummary(reslutList, sheet, vo, userVO);
						break;
					default:
						break;
					}
				}
				
				ArrayList<String> conts = new ArrayList<String>();
				conts.add("1");
				//sheet = ExcelUtil.createSummaryCont(sheet, conts);
				
				sheetSearchVo.setExCol(colUnion[unionIdx]);
				sheetSearchVo.setExTit(haedUnion[unionIdx]);
				sheet = ExcelUtil.createMainTable(sheet, reslutList, sheetSearchVo);
				
				// data건수가 0이면  summary 동작안함
				if(summary && reslutList != null && reslutList.size() > 0) {
					if(summaryDats == null) {
						sheet = ExcelUtil.createSummary(sheet);
					}else {
						sheet = ExcelUtil.createSummary(sheet, summaryDats);
					}
				}
				
				unionIdx++;
			}
			
			// cell 너비 조정 및 하단 타임 스탬프
			int sheetCnt = workBook.getNumberOfSheets();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();         
			String nowTime = sdf1.format(now);
			
			for(int i=0; i < sheetCnt; i++) {
				XSSFSheet tempSheet = workBook.getSheetAt(i);
				int cellCnt = tempSheet.getPhysicalNumberOfRows();
				
				for(int j=1; j < cellCnt; j++) {
					tempSheet.autoSizeColumn(j);
				}
				
				tempSheet.createRow(tempSheet.getLastRowNum() +1);
				XSSFRow row = tempSheet.createRow(tempSheet.getLastRowNum() +1);
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(nowTime);
			}
			
			ExcelUtil.generateExcelFile(workBook, userVO.getCmpnyCd().concat(" ").concat(vo.getSrch40().replace("_", " ")), response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("resultCode", resultCode);
		return mv;
	}
}