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

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.MsgService;
import egovframework.pf.cmmn.service.SaveMsgVO;
import egovframework.pf.cmmn.service.UserSessionVO;


/**
 * @Class Name : MsgController.java
 * @Description : 메시지 컨트롤러
 * @Modification Information
 * @
 * @  수정일         			 수정자               		    수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.04.19			권예지              			     최초생성
 *
 * @author 권예지
 * @since 2024.04.19
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */

@Controller
public class MsgController {

	/*private static final Logger logger = LoggerFactory.getLogger(FtaMenuController.class);*/

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

		/*//메시지 호출
		vo.setSrch2("ftamsg");
		List<?> msgList = ftaCmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}
*/
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