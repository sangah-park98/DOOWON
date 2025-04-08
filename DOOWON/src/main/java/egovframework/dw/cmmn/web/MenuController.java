package egovframework.dw.cmmn.web;

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

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.MenuService;
import egovframework.dw.cmmn.service.SaveMenuVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;


@Controller
public class MenuController {

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
		model.addAttribute("userAuther", userVO.getGrpCd());
		return "cmmn/pfmenu";
	}

	//메뉴 목록 조회 
	@RequestMapping(value = "/cmmn/selectPfMenuList.do")
	public ModelAndView selectCompnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
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
	
}