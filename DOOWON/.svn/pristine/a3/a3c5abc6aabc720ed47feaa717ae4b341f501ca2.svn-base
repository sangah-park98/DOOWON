package egovframework.pf.member.sevice;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import egovframework.pf.cmmn.service.SearchVO;

/**
 * @Class Name : MemberService.java
 * @Description : MemberService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.01.17          	권예지         			최초 생성
 *
 * @author 권예지
 * @since 2024.01.17
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

public interface MemberService {
	// id 중복 체크
	public int idcheck(String usrId) throws Exception;
	// 이메일 인증번호 저장
	public String insertCertNumber(Map<String, Object> param)throws Exception;
	// 인증 메일 발송 (타이틀) 
	public Map<String, Object> getMailCode(Map<String, Object> param)throws Exception;
	// 이메일 인증시간 초과
	public int updateCertTimeout(String email)throws Exception;
	// 이메일 인증번호 검증
	public int certNumberConfirm(Map<String, Object> param);
	public int updateCertNumber(Map<String, Object> param);
	// 회사 검증
	public int companyCheck(Map<String, Object> param);
	// 회원가입
	public int memberJoin(SaveMemberVO member, SaveCompnyVO compny, List<String> compNames, List<String> compRegNos)throws Exception;
	// 회사 매니저 이메일
	public List compnyManagerEmail(SaveMemberVO member, SaveCompnyVO compny, List<String> compNames,
			List<String> compRegNos);
	// 기존회원 체크
	public int memberCheck(Map<String, Object> param);
	//메일로 아이디 발송
	public String idSendEmail(Map<String, Object> param)throws Exception;
	//메일로 새 비밀번호 발송
	public String pwSendEmail(Map<String, Object> param)throws Exception;
	// 마이페이지 리스트 = user_info 
	public List<?> selectMyPageUserInfo(SaveMemberVO vo)throws Exception;
	// 마이페이지 리스트 = cmpny_info
	public List<?> selectMyPageCmpnyInfo(SaveCompnyVO cmyvo)throws Exception;
	
	public int passCheck(Map<String, Object> param)throws Exception;
	// 마이페이지 update
	public int myPageUpdate(SaveMemberVO member, SaveCompnyVO compny, List<String> compNames, List<String> compRegNos)throws Exception;
	// 사업자 체킹
	public int comRegNoConfirm(String compRegNo)throws Exception;
	// 사업자 조회
	public List<?> selectCmpnyInfo(String compRegNo)throws Exception;
	// 마이페이지 메일로 인증번호 발송
	public String insertCertNumberMyPage(Map<String, Object> param)throws Exception;
	public String managerApprove(String id, String email)throws Exception;
	// 회사에 매니저가 없을때 처음 회원가입한 이메일insert
	public void insertMangerEmail(SaveMemberVO member, SaveCompnyVO compny, List<String> compNames,
			List<String> compRegNos);
}
