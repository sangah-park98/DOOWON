package egovframework.pf.cmmn.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.UserService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.member.utill.EmailUtill;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import freemarker.core.ReturnInstruction.Return;

/**
 * @Class Name : UserController.java
 * @Description : 사용자 컨트롤러
 * @Modification Information
 * @
 * @  수정일                           수정자                                      수정내용
 * @ ---------        ----------     -------------------------------
 * @ 2024.01.30		        권예지                                        최초생성
 *
 * @author 권예지
 * @since 2024.01.30
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class UserController {

	//private static final Logger logger = LoggerFactory.getLogger(FtaUserController.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Resource(name = "UserService")
	private UserService UserService;

	//사용자 화면 호출
	@RequestMapping(value = "/cmmn/pfuser.do")
	public String ftauser(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		model.addAttribute("writable","Y".equals(userVO.getAdminYn())?"Y":CmmnService.selectWriteCheck(request.getServletPath(), userVO));
		SearchVO vo = new SearchVO();
		vo.setLang(userVO.getLang());

		//메시지 호출
	/*	vo.setSrch2("ftauser");
		List<?> msgList = CmmnService.selectMsgList(vo);
		for(int i=0; i<msgList.size(); i++) {
			EgovMap map = (EgovMap)msgList.get(i);
			model.addAttribute((String)map.get("msgId"), map.get("msgNm"));
		}*/

		//공통코드 조회(업체상태코드)
	/*	vo.setSrch10("STSCD");
		List<?> codeList = CmmnService.selectCmmnCdList(vo);
		model.addAttribute("stsList", codeList);
		List<String> stsCdList = new ArrayList<String>();
		for(int i=0; i<codeList.size(); i++) {
			EgovMap map = (EgovMap)codeList.get(i);
			stsCdList.add((String)map.get("cmmnCd"));
		}
		model.addAttribute("stsCdList", stsCdList);*/

		//그룹코드 조회
/*		List<?> grpList = CmmnService.selectGroupCdList(vo, userVO);
		model.addAttribute("grpList", grpList);
		List<String> grpCdList = new ArrayList<String>();
		List<String> grpTempCdList = new ArrayList<String>();
		for(int i=0; i<grpList.size(); i++) {
			EgovMap map = (EgovMap)grpList.get(i);
			grpTempCdList.add((String)map.get("cd"));
		}
		for(int i=0; i<grpTempCdList.size(); i++) {  
			if(userVO.getGrpCd().equals(grpTempCdList.get(i))) {
				break;
			}
			grpCdList.add(grpTempCdList.get(i));
		}
		model.addAttribute("grpCdList", grpCdList);*/

		//플렌트코드 조회
	/*	List<?> plntList = CmmnService.selectPlntCdList(vo, userVO);
		model.addAttribute("plntList", plntList);
		List<String> plntCdList = new ArrayList<String>();
		for(int i=0; i<plntList.size(); i++) {
			EgovMap map = (EgovMap)plntList.get(i);
			plntCdList.add((String)map.get("cd"));
		}
		model.addAttribute("plntCdList", plntCdList);
		*/
		System.out.println("userAuther>>"+userVO.getGrpCd());
		model.addAttribute("userAuther", userVO.getGrpCd());
		return "cmmn/pfuser";
	}

	//사용자정보 목록 조회
	@RequestMapping(value = "/cmmn/selectUserInfoList.do")
	public ModelAndView selectUserInfoList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		vo.setGrpCd(userVO.getGrpCd());
		System.out.println("vo.getAlignItem();"+vo.getAlignItem());
		System.out.println("vo.setLang ="+vo.getLang());
		System.out.println("vo.setCmpnyCd ="+vo.getCmpnyCd());
		System.out.println("vo.setGrpCd ="+vo.getGrpCd());
		
		List<?> resultList = UserService.selectUserInfoList(vo);
		model.addAttribute("resultList", resultList);
		int totCnt = UserService.selectUserInfoListCnt(vo);
		model.addAttribute("totCnt", totCnt);


		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav ;
	}

	//사용자정보 정보 저장
	@RequestMapping(value = "/cmmn/saveUserInfo.do")
	@ResponseBody
	public String saveUserInfo(@RequestBody List<SaveMemberUpateVO> voList, HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("voList"+voList);
		
	        SaveMemberUpateVO firstVo = voList.get(0);
	        // 검색구분
	        String cdtp = firstVo.getCdTp();
	        // 읽기,편집,등록
	        String mntp = firstVo.getMnTp();
	        UserService.saveUserInfo(voList, userVO);

	        return "success";
	   
	}
	
	
	@RequestMapping(value="/cmmn/sendApprovalEmail.do", method = RequestMethod.POST)
	@ResponseBody
	public String sendApprovalEmail(@RequestBody SaveMemberUpateVO[] voList, HttpServletRequest request) throws Exception {
	    for (SaveMemberUpateVO vo : voList) {
	        String name = vo.getMemberName();
	        String id = vo.getMemberId();
	        String email = vo.getMemberEmail();
	        String type = "APPROVAL";
	        String text = null;
	        String lang = null;
	        
	        // 각 필드에 접근하여 원하는 작업 수행
	        System.out.println("Name: " + name + ", ID: " + id + ", Email: " + email);

	        EmailUtill.sendEmail(name, id, email, "APPROVAL",null,"kr");	
	        
	    }
	    
	    return "success";
	  		
	}
	
}