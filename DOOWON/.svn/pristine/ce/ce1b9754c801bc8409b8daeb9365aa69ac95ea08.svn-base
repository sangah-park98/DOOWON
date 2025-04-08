package egovframework.pf.member.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoCounter;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.member.sevice.MemberService;
import egovframework.pf.member.sevice.SaveCompnyVO;
import egovframework.pf.member.sevice.SaveMemberVO;
import egovframework.pf.member.utill.EmailUtill;


@Controller
public class MemberController {

	//private static final Logger logger = LoggerFactory.getLogger(FtaCmmnController.class);

	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	//회원가입 호출
   @GetMapping("member/insertMember.do")
    public String memberjoin(HttpServletRequest request, Model model) throws Exception {
    	         // lang 파라미터를 이용하여 필요한 작업 수행
         //model.addAttribute("lang", lang); 
         //System.out.println("lang"+lang);
        // 회원가입 페이지로 이동
        return "member/join";
    }
   //아이디,비밀번호 찾기 호출
   @GetMapping("/member/searchIdAndPw.do")
   public String searchIdAndPw(HttpServletRequest request, Model model) throws Exception {
        // lang 파라미터를 이용하여 필요한 작업 수행
	    HttpSession httpSession = request.getSession(true);
		SearchVO vo = new SearchVO();

        // 회원가입 페이지로 이동
        return "member/searchIdAndPw";
    }
   // 마이페이지 이동
   @GetMapping("/member/myPage.do")
   public String myPage(HttpServletRequest request,ModelMap model)throws Exception{
	   HttpSession httpSession = request.getSession(true);
	   UserSessionVO userVO = (UserSessionVO)httpSession.getAttribute("USER");
	   SaveMemberVO vo = new SaveMemberVO();
	   SaveCompnyVO cmyvo = new SaveCompnyVO();
	   vo.setMEMBER_ID(userVO.getId());
	   cmyvo.setMEMBER_ID(userVO.getId());
	  // user_info 테이블
	   List<?>userInfo = memberService.selectMyPageUserInfo(vo);
	   // user_cmpny_info 태이블
	   List<?>cmpnyInfo = memberService.selectMyPageCmpnyInfo(cmyvo);
	   
	   model.addAttribute("userInfo", userInfo);
	   model.addAttribute("cmpnyInfo", cmpnyInfo);
	  
	   
	   System.out.println("userInfo>"+userInfo);
	   System.out.println("cmpnyInfo>"+cmpnyInfo);
	   
	   return "member/myPage";
   }

   @RequestMapping(value = "/member/selectSearchCmpnyList.do")
   public ModelAndView selectSearchCmpnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		vo.setLang(userVO.getLang());
		vo.setCmpnyCd(userVO.getCmpnyCd());
		List<?> resultList =  CmmnService.selectUsrCmpnyList(vo);
		String count = vo.getSrch2();
		model.addAttribute("resultList", resultList);
		model.addAttribute("count", count);

		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
   
   @RequestMapping(value="/member/comRegNoConfirm.do")
   public ModelAndView comRegNoConfirm(@ModelAttribute("compRegNo") String compRegNo,HttpServletRequest request,
			ModelMap model)throws Exception{
	   System.out.println("11111");
	   System.out.println("compRegNo"+compRegNo);
	   if(compRegNo.equals("")) {
		   return new ModelAndView("fail");
	   }
	   int comRegNo = memberService.comRegNoConfirm(compRegNo);
	   System.out.println("comRegNo"+comRegNo);
	   if (comRegNo!= 0) {
		   List<?> resultList = memberService.selectCmpnyInfo(compRegNo);
		   System.out.println("resultList"+resultList);
		   ModelAndView mav = new ModelAndView("jsonView", model);
		   model.addAttribute("resultList", resultList);
		   return mav;
	   }else {
		   return new ModelAndView("fail");
	   }
   }
   
   @RequestMapping(value = "/member/selectJoinSearchCmpnyList.do")
   public ModelAndView selectJoinSearchCmpnyList(@ModelAttribute("searchVO") SearchVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {
		HttpSession httpSession = request.getSession(true);
		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
		System.out.println("111");
		List<?> resultList =  CmmnService.selectUsrCmpnyList(vo);
		System.out.println("333");
		model.addAttribute("resultList", resultList);
		ModelAndView mav = new ModelAndView("jsonView", model);
		return mav;
	}
   
  // 아이디중복체크
   @ResponseBody
   @PostMapping(value = "/member/idCheck.do")
   public int idCheck(@RequestParam("usrId") String usrId) throws Exception {
       System.out.println("idcheck" + usrId);
       return memberService.idcheck(usrId);
   }
   
   @RequestMapping(value="/member/myPageJoin.do",method = RequestMethod.POST)
   public String myPage(HttpServletRequest request,SaveMemberVO member,@ModelAttribute SaveCompnyVO compny,
		    @RequestParam(name = "alarmEmail", defaultValue = "false") String alarmEmail,
	        @RequestParam(name = "alarmSMS", defaultValue = "false") String alarmSMS,
	        @RequestParam(name = "alarmKakao", defaultValue = "false") String alarmKakao
	        )throws Exception{

	   		HttpSession httpSession = request.getSession(true);
	   		UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
	   		String usrId = userVO.getId();   
	   		   member.setMEMBER_ID(usrId);
	   		   compny.setMEMBER_ID(usrId);
			   member.setAlarmEmail(alarmEmail);
			   member.setAlarmSMS(alarmSMS);
			   member.setAlarmKakao(alarmKakao);
			   
			   List<String> compNames = compny.getCOMP_NAME();
		       List<String> compRegNos = compny.getCOMP_REG_NO();
		       
		       
		       System.out.println("compNames"+compNames);
		       System.out.println("compRegNos"+compRegNos);
		    		   
		    
		       int result = memberService.myPageUpdate(member,compny,compNames,compRegNos);
		       
			   
		       return "redirect:/cmmn/main.do";
   			}
   
   //마이페이지 - 업체정보 select 
   @ResponseBody
   @PostMapping(value="/member/cmpnyInfo.do")
   public ModelAndView cmpnyInfo(HttpServletRequest request, ModelMap model) throws Exception{
	  System.out.println("111111");
	   HttpSession session = request.getSession();
       UserSessionVO userVO = (UserSessionVO) session.getAttribute("USER");
       String usrId = userVO.getId();
       SaveCompnyVO cmyvo = new SaveCompnyVO();
	   cmyvo.setMEMBER_ID(userVO.getId());
	   // user_cmpny_info 태이블
	   List<?>cmpnyInfo = memberService.selectMyPageCmpnyInfo(cmyvo);
	   model.addAttribute("resultList", cmpnyInfo);
	  
	   ModelAndView mav = new ModelAndView("jsonView", model);
	   return mav;
   }
   
   //마이페이지 - 현재 비밀번호 체크
   @ResponseBody
   @PostMapping(value="/member/passCheck.do")
   public int passCheck(HttpServletRequest request, @RequestParam("usrPwd") String usrPwd) throws Exception {
       HttpSession session = request.getSession();
       UserSessionVO userVO = (UserSessionVO) session.getAttribute("USER");
       String usrId = userVO.getId();
       Map<String, Object> param = new HashMap<>();
       param.put("usrPwd", usrPwd);
       param.put("usrId", usrId);
       
	return memberService.passCheck(param);
   }
   
   //회원 가입 - 이메일 인증번호 발송
   @ResponseBody
   @PostMapping(value="/member/certNumberSend.do")
   public String certificationNumberSend(@RequestBody Map<String, Object> param)throws Exception{
	
	   System.out.println("email: " + param.get("email"));
	    System.out.println("lang: " + param.get("lang"));
	   
	   return memberService.insertCertNumber(param);
   }
   
   // 마이페이지 - 이메일 인증번호 발송
   @ResponseBody
   @PostMapping(value= "/member/myPageCertNumberSend.do")
   public String myPageCertificationNumberSend(@RequestBody Map<String,Object> param)throws Exception{
	   return memberService.insertCertNumberMyPage(param);
   }
   
   @ResponseBody
   @PostMapping(value="/member/certTimeOut.do")
   public int certificationNumberTimeOut(@RequestParam("email")String email)throws Exception{
	
	   return memberService.updateCertTimeout(email);
   }
   
   
   @ResponseBody
   @PostMapping(value="/member/certNumberConfirm.do")
   public String certificationNumberConfirm(@RequestBody Map<String, Object> param)throws Exception{
	   
	   if(memberService.certNumberConfirm(param) == 0) {
		   return "notFoundData";
	   }else {
		   return memberService.updateCertNumber(param) == 0 ? "Timeout" : "certSuccess"; 
	   }
   }
   
   @ResponseBody
   @PostMapping(value="/member/companyCheck.do")
   public int companyCheck(@RequestBody Map<String, Object> param)throws Exception{
	 return memberService.companyCheck(param);
   }
   
   @RequestMapping(value="/member/memberjoin.do", method = RequestMethod.POST)
   public String memberJoin(SaveMemberVO member, @ModelAttribute  SaveCompnyVO compny,Model model,
	    @RequestParam(name = "alarmEmail", defaultValue = "false") String alarmEmail,
        @RequestParam(name = "alarmSMS",  defaultValue = "false") String alarmSMS,
        @RequestParam(name = "alarmKakao",  defaultValue = "false") String alarmKakao,
        @RequestParam(name = "SHINHAN_AGREE",  defaultValue = "false")String shinhan_agree,
        @RequestParam(name = "PRIVACY_AGREE",  defaultValue = "false")String privacy_agree
	   )throws Exception {
	   System.out.println("멤버회원가입");
	   
	   member.setAlarmEmail(alarmEmail);
	   member.setAlarmSMS(alarmSMS);
	   member.setAlarmKakao(alarmKakao);
	   compny.setAgreeYn(shinhan_agree);
	   
	   List<String> compNames = compny.getCOMP_NAME();
       List<String> compRegNos = compny.getCOMP_REG_NO();

	  int result = memberService.memberJoin(member,compny,compNames,compRegNos);
	   model.addAttribute("result", result);
	   System.out.println("result>>"+result);
	   if(result !=0) {
	   	  String resultText;
		  List<String> emailList = memberService.compnyManagerEmail(member,compny,compNames,compRegNos);
		  System.out.println("emailList"+emailList);
			   if (emailList.isEmpty() || emailList == null) {
			        // 회사 매니저가 없을 때 => 관리자에게 메일 보내기
				   System.out.println("회사매니저 X");
			          resultText = EmailUtill.sendEmail(member.getMEMBER_NAME(),
			                member.getMEMBER_ID(),
			                member.getMEMBER_EMAIL(),
			                "JOIN1",
			                null,
			                "kr");
			    }else {
				 // 회사매니저가 있을때 => 관리자, 회사매니저에게 메일 보내기
				 //emailList.add("ioom@customsservice.co.kr"); //관리자메일
				 System.out.println("회사매니저 O");
				 for (String adminOrManager : emailList) {
			        System.out.println("adminOrManager"+adminOrManager);  

					   resultText = EmailUtill.sendEmail(member.getMEMBER_NAME(),
							   member.getMEMBER_ID(),
							   adminOrManager,
							   "JOIN2",
							   null,
							   "kr");
				 		}
				 
			    	 }
			   // 사업자 번호에 매니저가 없는 경우 회원가입 한 이메일로 매니저 이메일로 insert
		      memberService.insertMangerEmail(member,compny,compNames,compRegNos);
	   			}
	 
	   return "redirect:/login.do";
	}
   

@ResponseBody
@RequestMapping(value="/member/memberCheck.do",method=RequestMethod.POST)
public int memberCheck(@RequestBody Map<String,Object>param)throws Exception{
	System.out.println("param"+param);
	return memberService.memberCheck(param);
}

@ResponseBody
@RequestMapping(value="/member/idSendEmail.do",method=RequestMethod.POST)
public String idSendEmail(@RequestBody Map<String,Object>param)throws Exception{
	return memberService.idSendEmail(param);
}

@ResponseBody
@RequestMapping(value="/member/pwSendEmail.do",method=RequestMethod.POST)
public String pwSendEmail(@RequestBody Map<String,Object>param)throws Exception{
	return memberService.pwSendEmail(param);
}


@RequestMapping(value="/member/managerapprove.do")
public String managerapprove(SaveMemberVO member,@RequestParam("name")String name,@RequestParam("id")String id,@RequestParam("email")String email)throws Exception{
	member.setMEMBER_ID(id);
	member.setMEMBER_EMAIL(email);
	member.setMEMBER_NAME(name);
	System.out.println("id"+member.getMEMBER_ID());
	System.out.println("email"+member.getMEMBER_EMAIL());
	System.out.println("name"+member.getMEMBER_NAME());
	// 이음 관리자에게 승인 메일 보내기 
	 String resultText = EmailUtill.sendEmail(member.getMEMBER_NAME(),
             member.getMEMBER_ID(),
             member.getMEMBER_EMAIL(),
             "JOIN1",
             null,
             "kr");
	 
	 memberService.managerApprove(id,email);
	 
	 return "member/approve";
	
}

}