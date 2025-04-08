package egovframework.pf.news.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.news.service.pfNewsService;

/**
 * @Class Name : PurchaseController.java
 * @Description : 구매원장 컨트롤러
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
public class NewsController {

	@Resource(name = "pfNewsService")
	private pfNewsService pfnewsService;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@RequestMapping(value = "/cmmn/news.do")
	public String news(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());
		
		List<?> resultList = null;
		int cnt = 0;
		vo.setRecordCountPerPage(0);
		resultList = pfnewsService.selectNewsViewList(vo);
		System.out.println(resultList);
		cnt = pfnewsService.selectNewsViewtotCnt(vo);
		model.addAttribute("totCnt", cnt);
	    model.addAttribute("resultList", resultList);

	    return "cmmn/news";
	}
	
	@RequestMapping(value = "/cmmn/selectNewsViewList.do")
	public ModelAndView selectNewsViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		
		List<?> resultList = null;
		resultList = pfnewsService.selectNewsViewList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
	
	@RequestMapping(value = "/cmmn/selectNewsModalViewList.do")
	public ModelAndView selectNewsModalViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		
		List<?> resultList = null;
		resultList = pfnewsService.selectNewsModalViewList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
}

