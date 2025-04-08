package egovframework.pf.cmmn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;

import egovframework.pf.cmmn.service.SaveMenuVO;
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.CompanyService;
import egovframework.pf.cmmn.service.MenuService;
import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.UserService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : MenuController.java
 * @Description : 메뉴 컨트롤러
 * @Modification Information
 * @
 * @  수정일                           수정자                                      수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.04.13		        권예지                                        최초생성
 *
 * @author 권예지
 * @since 2024.04.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class MenuController {

	//private static final Logger logger = LoggerFactory.getLogger(FtaUserController.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "menuService")
	private MenuService menuService;

	//사용자 화면 호출
	@RequestMapping(value = "/cmmn/pfmenu.do")
	public String ftauser(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());

		//메시지 호출
	/*	vo.setSrch2("ftauser");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}*/


		System.out.println("userAuther>>"+userVO.getGrpCd());
		model.addAttribute("userAuther", userVO.getGrpCd());
		return "cmmn/pfmenu";
	}

	//메뉴 목록 조회 
	@RequestMapping(value = "/cmmn/selectPfMenuList.do")
	public ModelAndView selectCompnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		/*vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setGrpCd(userVO.getGrpCd());*/
		System.out.println("메뉴명 : "+vo.getSrch1());
		List<?> resultList = menuService.selectMenuList(vo);
		model.addAttribute("resultList", resultList);
		System.out.println("resultList >>"+resultList);
		int totCnt = menuService.selectMenuListCnt(vo);
		model.addAttribute("totCnt", totCnt);
		System.out.println("totCnt >>"+totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	//상위메뉴 Dropdown
	@RequestMapping(value="/cmmn/selectUpprMenuDropdown.do")
	public ModelAndView selectUppereMenuDropdown(ModelMap model)throws Exception{
		List<?> resultList = menuService.selectUpprMenuDropdown();
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);			
		
		return mav;
	}

	
	
	//메뉴 목록 저장
	@RequestMapping(value = "/cmmn/savePfMenuInfo.do")
	@ResponseBody
	public String saveMenuInfo(@RequestBody List<SaveMenuVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
	
		menuService.savePfMenuInfo(voList, userVO);
		return "success" ;
	}
	
	
	
	/*//사용자정보 정보 저장
	@RequestMapping(value = "/cmmn/saveCompnyInfo.do")
	@ResponseBody
	public String saveUserInfo(@RequestBody List<SaveMemberUpateVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("voList"+voList);
		
	        SaveMemberUpateVO firstVo = voList.get(0);
	        // 검색구분
	        String cdtp = firstVo.getCdTp();
	        // 읽기,편집,등록
	        String mntp = firstVo.getMnTp();
	        CompanyService.saveCompnyInfo(voList, userVO);

	        return "success";
	   
	}*/
	
}