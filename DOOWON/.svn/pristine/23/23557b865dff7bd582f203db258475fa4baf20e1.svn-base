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

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.cmmn.service.CmmnCdService;
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SaveCmmnCdVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : FtaCmmnCdController.java
 * @Description : 공통코드 컨트롤러
 * @Modification Information
 * @
 * @  수정일          수정자               수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2020.01.10		심창무               최초생성
 *
 * @author 심창무
 * @since 2020.01.10
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class CmmnCdController {

	//private static final Logger logger = LoggerFactory.getLogger(FtaCmmnCdController.class);

	@Resource(name = "cmmnCdService")
	private CmmnCdService cmmnCdService;

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	//공통코드 화면 호출
	@RequestMapping(value = "/cmmn/pfcmmncd.do")
	public String ftacmmncd(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());

		//메시지 호출
	/*	vo.setSrch2("ftacmmncd");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}*/

		return "cmmn/pfcmmncd";
	}

	//공통코드 목록 조회
	@RequestMapping(value = "/cmmn/selectPfCmmnCdList.do")
	public ModelAndView selectFtaCmmnCdList(@ModelAttribute("searchVO") SearchVO vo, ModelMap model) throws Exception {
		List<?> resultList = cmmnCdService.selectPfCmmnCdList(vo);
		model.addAttribute("resultList", resultList);
		int totCnt = cmmnCdService.selectPfCmmnCdListCnt(vo);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//공통코드 정보 저장
	@RequestMapping(value = "/cmmn/savePfCmmnCdInfo.do")
	@ResponseBody
	public String saveFtaCmmnCdInfo(@RequestBody List<SaveCmmnCdVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		cmmnCdService.savePfCmmnCdInfo(voList, userVO);
		return "success" ;
	}

	//공통그룹코드 Dropdown
	@RequestMapping(value = "/cmmn/selectCmmnGrpDropdown.do")
	public ModelAndView selectCmmnGrpDropdown(ModelMap model) throws Exception {
		List<?> resultList = cmmnCdService.selectCmmnGrpDropdown();
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

}