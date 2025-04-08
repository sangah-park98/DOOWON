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
import egovframework.dw.cmmn.service.CompanyService;
import egovframework.dw.cmmn.service.SaveMemberUpateVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;

@Controller
public class CompanyController {

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "CompanyService")
	private CompanyService CompanyService;

	//사용자 화면 호출
	@RequestMapping(value = "/cmmn/pfcompny.do")
	public String ftauser(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());
		System.out.println("userAuther>>"+userVO.getGrpCd());
		model.addAttribute("userAuther", userVO.getGrpCd());
		return "cmmn/pfcompany";
	}

	//회사정보 목록 조회
	@RequestMapping(value = "/cmmn/selectCompnyList.do")
	public ModelAndView selectCompnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setGrpCd(userVO.getGrpCd());
		System.out.println("vo.getAlignItem();"+vo.getAlignItem());
		System.out.println("vo.setLang ="+vo.getLang());
		System.out.println("vo.setCmpnyCd ="+vo.getCmpnyCd());
		System.out.println("vo.setGrpCd ="+vo.getGrpCd());
		
		List<?> resultList = CompanyService.selectCmpnyList(vo);
		model.addAttribute("resultList", resultList);
		System.out.println("resultList >>"+resultList);
		int totCnt = CompanyService.selectCmpnyListCnt(vo);
		model.addAttribute("totCnt", totCnt);
		System.out.println("totCnt >>"+totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//사용자정보 정보 저장
	@RequestMapping(value = "/cmmn/saveCompnyInfo.do")
	@ResponseBody
	public String saveUserInfo(@RequestBody List<SaveMemberUpateVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
        CompanyService.saveCompnyInfo(voList, userVO);
        return "success";
	   
	}
	
}