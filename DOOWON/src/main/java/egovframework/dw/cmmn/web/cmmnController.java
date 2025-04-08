package egovframework.dw.cmmn.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.ConectInfoService;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Controller
public class cmmnController {

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	@Resource(name = "conectionInfoService")
	private ConectInfoService ConectInfoService;

	//로그인 화면 호출
	@RequestMapping(value = "/login.do")
	public String login(Model model) throws Exception {
		return "cmmn/login";
	}

	@RequestMapping(value = "/relogin.do")
	public String relogin(Model model) throws Exception {
		return "cmmn/relogin";
	}

	//로그인 체크
	@RequestMapping(value = "/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
	    String result = "SUCCESS";

	    if (vo == null) {
	        result = "ERROR";
	    } else {
	        String id = vo.getId(); // email
	        String ip = request.getHeader("X-FORWARDED-FOR"); // ip
	        if (ip == null) ip = request.getRemoteAddr();

	        List<Map<String, String>> resultList = CmmnService.selectCmpnyIdCheck(vo);
	        if (resultList == null || resultList.isEmpty()) {
	            result = "ERROR";
	        } else {
	            List<String> corpNos = new ArrayList<>();
	            List<String> cmpnyCds = new ArrayList<>();
	            UserSessionVO userVO = new UserSessionVO();

	            Map<String, String> firstResult = resultList.get(0);
	            userVO.setUsrNm(firstResult.get("usrNm"));
	            userVO.setManerYn(firstResult.get("manerYn"));
	            userVO.setGrpCd(firstResult.get("grpCd"));
	            userVO.setId(id);
	            userVO.setIp(ip);

	            if ("admin".equalsIgnoreCase(userVO.getGrpCd())) {
	                userVO.setAdminYn("Y");
	            } else {
	                userVO.setAdminYn("N");
	            }

	            for (Map<String, String> resultMap : resultList) {
	                cmpnyCds.add(resultMap.get("cmpnyNm"));
	                corpNos.add(resultMap.get("cmpnyCd"));
	            }

	            userVO.setCmpnyCds(cmpnyCds);
	            userVO.setCorpNos(corpNos);

	            HttpSession httpSession = request.getSession(true);
	            httpSession.setAttribute("USER", userVO);

	            System.out.println("username: " + userVO.getUsrNm());
	            System.out.println("useradmin: " + userVO.getAdminYn());
	            System.out.println("userManer: " + userVO.getManerYn());
	            System.out.println("userGrpCd: " + userVO.getGrpCd());
	            System.out.println("userID: " + userVO.getId());
	            System.out.println("userIp: " + userVO.getIp());
	            System.out.println("userCmpny: " + userVO.getCmpnyCds());
	            System.out.println("userCorpNo: " + userVO.getCorpNos());

	            // 접속정보 저장
	            ConectInfoService.saveConectInfo(userVO);
	        }
	    }

	    model.addAttribute("result", result);
	    return new ModelAndView("jsonView", model);
	}

	//로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/index.jsp";
	}

	//메인화면 호출
	@RequestMapping(value = "/cmmn/main.do")
	public String main(HttpServletRequest request, HttpServletResponse response,  ModelMap model) throws Exception {
		
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		if ( userVO == null ) {
			httpSession.invalidate();
			response.sendRedirect("/comm/login.do");
			return "" ;
		}
		
	    httpSession.setAttribute("USER", userVO);
		
		SearchVO vo = new SearchVO();
		vo.setId(userVO.getId());
		vo.setAdminYn(userVO.getAdminYn());
		vo.setGrpCd(userVO.getGrpCd());
		model.addAttribute("currCmpnyCd", userVO.getCmpnyCd());
		
		String author = userVO.getGrpCd();
		String corpNo = userVO.getCorpNo();
		
		model.addAttribute("corpNo", corpNo);
		model.addAttribute("author", author);
		vo.setId(userVO.getId());
		vo.setManerYn(userVO.getManerYn());
		
		return "cmmn/main";
	}
	
	// 모달 회사리스트 띄우기
	@RequestMapping(value = "/cmmn/selectSearchCmpnyList.do")
	public ModelAndView selectSearchCmpnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setId(userVO.getId());;
		if(userVO.getGrpCd().equals("KORD Mst")) {
			List<?> resultList =  CmmnService.selectAllCmpnyList(vo);
			model.addAttribute("resultList", resultList);
		}else {
			List<?> resultList =  CmmnService.selectUsrCmpnyList(vo);
			model.addAttribute("resultList", resultList);
		}
		
		
		// System.out.println("도착 항구: " + resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}

	@RequestMapping(value = "/cmmn/saveCmpnySession.do", method = RequestMethod.POST)
	public String saveCmpnySession(
	        @RequestParam("taxNo") List<String> taxNos,
	        @RequestParam("cmpnyNm") List<String> cmpnyNms,
	        HttpServletRequest request) throws Exception {

	    HttpSession httpSession = request.getSession(true);
	    UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
	    
	    if (!taxNos.isEmpty() && !cmpnyNms.isEmpty()) {
	    	userVO.setCmpnyCd(cmpnyNms.get(0));
	    	userVO.setCorpNo(taxNos.get(0));
	        userVO.setCmpnyCds(cmpnyNms);
	        userVO.setCorpNos(taxNos);
	    }
	    return "redirect:/cmmn/main.do";
	}
	
	//공통팝업 항목정보 호출
	@RequestMapping(value = "/cmmn/selectPopInfo.do")
	public ModelAndView selectPopInfo(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());

		//메시지 호출
		vo.setSrch2("cmmnPopup");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}


	//공통팝업 목록 조회
	@RequestMapping(value = "/cmmn/selectCmmnPopList.do")
	public ModelAndView selectCmmnPopList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());

		List<?> resultList = CmmnService.selectCmmnCdPop(vo);
		model.addAttribute("resultList", resultList);
		int totCnt = CmmnService.selectCmmnCdPopCnt(vo);
		model.addAttribute("totCnt", totCnt);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

}