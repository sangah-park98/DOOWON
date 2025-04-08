package egovframework.pf.cmmn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import egovframework.pf.cmmn.service.ConectInfoService;
import egovframework.pf.cmmn.service.ChangeHistService;
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : ConectInfoController.java
 * @Description : 접속정보 컨트롤러
 * @Modification Information
 * @
 * @  수정일          			수정자             				  수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.02.13			권예지              				 최초생성
 *
 * @author 권예지
 * @since 2024.02.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class ConectInfoController {

	//private static final Logger logger = LoggerFactory.getLogger(ConectInfoController.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "conectionInfoService")
	private ConectInfoService conectInfoService;

	@Resource(name = "changeHistoryService")
	private ChangeHistService changeHistService;

	//접속정보 화면 호출
	@RequestMapping(value = "/cmmn/conectinfo.do")
	public String conectinfo(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("admin>>"+userVO.getAdminYn());
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		String lang = userVO.getLang();
		vo.setLang(lang);

		//메시지 호출
		/*vo.setSrch2("conectInfo");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}*/

		return "cmmn/pfconectinfo";
	}

	//접속정보 목록 조회
	@RequestMapping(value = "/cmmn/selectConectList.do")
	public ModelAndView selectConectList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());

		List<?> resultList;
		int totCnt;
		String searchType = vo.getSrch1();
		System.out.println("searchType>>"+searchType);
		if("01".equals(searchType)) {
			resultList = conectInfoService.selectConectList(vo);
			totCnt = conectInfoService.selectConectListCnt(vo);
		}else {
			resultList = changeHistService.selectChangeHistList(vo);
			totCnt = changeHistService.selectChangeHistListCnt(vo);
		}
		model.addAttribute("resultList", resultList);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

}