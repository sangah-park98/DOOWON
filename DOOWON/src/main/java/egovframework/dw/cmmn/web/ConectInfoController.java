package egovframework.dw.cmmn.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.ConectInfoService;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;


@Controller
public class ConectInfoController {

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "conectionInfoService")
	private ConectInfoService conectInfoService;

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
		return "cmmn/pfconectinfo";
	}

}