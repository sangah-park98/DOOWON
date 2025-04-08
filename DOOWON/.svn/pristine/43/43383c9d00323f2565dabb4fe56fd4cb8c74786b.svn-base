package egovframework.pf.dashboard.web;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.dashboard.service.DashboardService;
import egovframework.pf.notice.service.pfNoticeService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : DashBoardController.java
 * @Description : 대시보드 컨트롤러
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
public class dashBoardController {

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "dashboardService")
	private DashboardService dashboardService;

	//대시보드 화면 호출
	@RequestMapping(value = "/dash/dashboard.do")
	public String dashboard(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		String author = userVO.getGrpCd();
		
		model.addAttribute("author", author);
		
		
		System.out.println("회사 : " + userVO.getCmpnyCd());
		System.out.println("번호 : " + userVO.getCorpNo());
		System.out.println("권한 : " + author);

		//메시지 호출
		vo.setSrch2("dashboard");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}

		//공지사항 조회정보
		SearchVO srchVO = new SearchVO();
		srchVO.setId(userVO.getId());
		srchVO.setCmpnyCd(userVO.getCmpnyCd());
		
		List<?> noticeList = null;
		noticeList = dashboardService.selectDashboardNoticeList(vo);
		model.addAttribute("noticeList", noticeList);
		
		List<?> newsList = null;
		newsList = dashboardService.selectDashboardNewsList(vo);
		model.addAttribute("newsList", newsList);
		
		
		//String result = dashboardService.selectNoticeReadInfo(srchVO);
		//model.addAttribute("noticeCheckList", result);

		//1-2.판정요약
		/*EgovMap jdgMap = dashboardService.selectJdgmntInfo(vo);
		model.addAttribute("jdgMap", jdgMap);*/

		return "dash/dashboard";
	}

	//대시보드 정보검색
	@RequestMapping(value = "/dash/selectDashboardInfo1.do")
	public ModelAndView selectDashboardInfo1(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		if(!userVO.getCorpNo().equals("00000000000")) {
			vo.setCorpNo(userVO.getCorpNo());
		}
		List<?> resultList = null;
		List<?> resultList2 = null;
		List<?> resultList3 = null;
		
		if(vo.getSrch1().equals("01")) {
			resultList = dashboardService.selectDashboardInfoExp1(vo);
			resultList2 = dashboardService.selectDashboardInfoImp1(vo);
			//resultList2 = dashboardService.selectDashboardInfoExp2(vo);
			//resultList3 = dashboardService.selectDashboardInfoExp3(vo);
		} else {
			resultList = dashboardService.selectDashboardInfoExp1(vo);
			resultList2 = dashboardService.selectDashboardInfoImp1(vo);
			//resultList2 = dashboardService.selectDashboardInfoImp2(vo);
			//resultList3 = dashboardService.selectDashboardInfoImp3(vo);
		}
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultList2", resultList2);
		model.addAttribute("resultList3", resultList3);
		

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	

	//대시보드 공지사항정보 조회
	@RequestMapping(value = "/dash/selectDashNoticeInfo.do")
	public ModelAndView selectDashNoticeInfo(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());

/*		EgovMap resultMap = dashboardService.selectDashNoticeInfo(vo);
		model.addAttribute("result", resultMap);
*/
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//대시보드 공지사항 파일 다운로드
	@RequestMapping(value = "/dash/downDashNoticeFile.do")
	public void downDashNoticeFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileNm = request.getParameter("dashFileNm");
		String fileOrgNm = request.getParameter("dashFileOrgNm");
		fileOrgNm = new String(fileOrgNm.getBytes("UTF-8"), "ISO-8859-1");
		String saveDir = "/home/files";
		File file = new File(saveDir + "/" + fileNm);

		response.setHeader("Content-Disposition","attachment;filename=\"" + fileOrgNm + "\";");

		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();

		byte b [] = new byte[1024];
		int data = 0;

		while((data=(fileInputStream.read(b, 0, b.length))) != -1)
		{
			servletOutputStream.write(b, 0, data);
		}

		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}


/*	//공지사항 조회정보
	@RequestMapping(value = "/base/updateReadNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateReadNotice(@RequestBody SearchVO vo, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");

		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setId(userVO.getId());
		noticeService.updateReadNoticeInfo(vo);

		return "success";
	}
*/

	//공지사항 조회 List
	@RequestMapping(value = "/base/selectMoreNoticeList.do", method = RequestMethod.POST)
	public ModelAndView selectMoreNoticeList(@RequestParam("startPoint") int startPage, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		SearchVO vo = new SearchVO();
		vo.setStartPoint(startPage);
		vo.setLang(userVO.getLang());
		//공지사항 개수 조회
		/*int totCnt = noticeService.selectNoticeListCnt(vo);
		model.addAttribute("totCnt", totCnt);*/

		//1-1.공지사항목록 호출
		/*List<?> noticeList = noticeService.selectDashNoticeList(vo);
		model.addAttribute("noticeList", noticeList);*/


		ModelAndView mav = new ModelAndView("jsonView", model);

		return mav;
	}
	
	@RequestMapping(value = "/base/selectDashNoticeViewList.do")
	public ModelAndView selectDashNoticeViewList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		
		List<?> resultList = null;
		resultList = dashboardService.selectDashNoticeViewList(vo);
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}
	
	@RequestMapping(value = "/cmmn/dashFileDown.do")
  	public void dashFileDown(
  			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileOrgNm = request.getParameter("dashFileDown");
  		String saveDir = "/home/files";
  		File file = new File(saveDir + "/" + fileOrgNm);
  		fileOrgNm = new String(fileOrgNm.getBytes("UTF-8"), "ISO-8859-1");
  		response.setHeader("Content-Disposition","attachment;filename=\"" + fileOrgNm + "\";");

  		FileInputStream fileInputStream = new FileInputStream(file);
  		ServletOutputStream servletOutputStream = response.getOutputStream();

  		byte b [] = new byte[1024];
  		int data = 0;

  		while((data=(fileInputStream.read(b, 0, b.length))) != -1)
  		{
  			servletOutputStream.write(b, 0, data);
  		}
  		servletOutputStream.flush();
  		servletOutputStream.close();
  		fileInputStream.close();
  	}

}