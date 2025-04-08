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
import egovframework.dw.cmmn.service.MsgService;
import egovframework.dw.cmmn.service.SaveMsgVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;

@Controller
public class MsgController {

	@Resource(name = "msgService")
	private MsgService msgService;

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	//메시지 화면 호출
	@RequestMapping(value = "/cmmn/pfmsg.do")
	public String ftamsg(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());
		return "cmmn/pfmsg";
	}

	//메시지 목록 조회
	@RequestMapping(value = "/cmmn/selectPfMsgList.do")
	public ModelAndView selectFtaMsgList(@ModelAttribute("searchVO") SearchVO vo, ModelMap model) throws Exception {
		List<?> resultList = msgService.selectPfMsgList(vo);
		model.addAttribute("resultList", resultList);
		int totCnt = msgService.selectPfMsgListCnt(vo);
		model.addAttribute("totCnt", totCnt);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//메시지 목록 저장
	@RequestMapping(value = "/cmmn/savePfMsgInfo.do")
	@ResponseBody
	public String saveFtaMsgInfo(@RequestBody List<SaveMsgVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		msgService.insertPfMsgInfo(voList, userVO);
		return "success" ;
	}

}