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

import egovframework.pf.cmmn.service.AuthorService;
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SaveAuthorVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : AuthorController.java
 * @Description : 권한 컨트롤러
 * @Modification Information
 * @
 * @  수정일          			수정자              				 수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.02.07			권예지            				  최초생성
 *
 * @author 권예지	
 * @since 2024.02.07
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */

@Controller
public class AuthorController {

	//private static final Logger logger = LoggerFactory.getLogger(FtaAuthorController.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "AuthorService")
	private AuthorService AuthorService;

	//권한 화면 호출
	@RequestMapping(value = "/cmmn/pfauthor.do")
	public String ftaauthor(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);
		System.out.println("1111");
	/*	//메시지 호출
		vo.setSrch2("ftaauthor");
		List<?> msgList = ftaCmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}

		//메뉴타입 공통코드 호출
		vo.setSrch10("MENUTP");
		List<?> menuList = ftaCmmnService.selectCmmnCdList(vo);
		model.addAttribute("menuList", menuList);

		//그룹코드 조회
		vo.setStrSelect("GRP_CD, GRP_NM");
		vo.setStrFrom("USER_GRP_INFO");
		vo.setStrWhere("DEL_YN = 'N'");
		vo.setStrOrderBy("GRP_CD");
		List<?> grpList = ftaCmmnService.selectCmmnCdPop(vo);
		model.addAttribute("grpList", grpList);*/

		/*String strWhere = vo.getStrWhere();
		vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));*/

		return "cmmn/pfauthor";
	}

	//권한정보 목록 조회
	@RequestMapping(value = "/cmmn/selectAuthorList.do")
	public ModelAndView selectAuthorList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());

		List<?> resultList = AuthorService.selectAuthorList(vo);
		model.addAttribute("resultList", resultList);
		int totCnt = AuthorService.selectAuthorListCnt(vo);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//권한정보 정보 저장
	@RequestMapping(value = "/cmmn/saveAuthorInfo.do")
	@ResponseBody
	public String saveAuthorInfo(@RequestBody List<SaveAuthorVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		 // voList 안에 있는 값 출력
	    for (SaveAuthorVO voItem : voList) {
	        System.out.println("grpCd: " + voItem.getGrpCd());
	        System.out.println("MenuId: " + voItem.getMenuId());
	        System.out.println("menuNm: " + voItem.getMenuNm());
	        // 나머지 속성들에 대해서도 필요한대로 출력
	    }
	    
		AuthorService.saveAuthorInfo(voList, userVO);
		return "success";
	}
	
	//Dropdown MenuId
	@RequestMapping(value="/cmmn/selectMenuIdDropdown.do")
	public ModelAndView selectMenuIdDropdown(ModelMap model)throws Exception{
		List<?>resultList = AuthorService.selectMenuIdDropdown();
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);	
	
		return mav;
	}
	
	@RequestMapping(value="/cmmn/selectGroupCodeDropdown.do")
	public ModelAndView selectGroupCodeDropdown(ModelMap model)throws Exception{
		List<?>resultList = AuthorService.selectGroupCodeDropdown();
		model.addAttribute("resultList",resultList);
		ModelAndView mav = new ModelAndView("jsonView",model);
		return mav;
	}
	
	@RequestMapping(value="/cmmn/selectMenuNameDropdown.do")
	public ModelAndView selectMenuNameDropdown(ModelMap model)throws Exception{
		List<?>resultList = AuthorService.selectMenuNameDropdown();
		model.addAttribute("resultList",resultList);
		ModelAndView mav = new ModelAndView("jsonView",model);
		return mav;
	}

}