package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 사용자정보 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.01.31
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일                            수정자                                   수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.01.31            권예지                                    최초 생성
 *
 * </pre>
 */
@Mapper("UserMapper")
public interface UserMapper {

	// 사용자 목록 조회
	List<?> selectUserList(SearchVO vo) throws Exception;

	// 사용자 목록 갯수 조회
	int selectUserListCnt(SearchVO vo) throws Exception;
	
	// 회사 유무
	int selectCmpny(SaveMemberUpateVO vo);
	
	// 사용자 정보 저장
	void insertUserInfo(SaveMemberUpateVO vo) throws Exception;
	
	// 회사 정보 저장(user_cmpny_info)
	void insertCmpnyInfo(SaveMemberUpateVO vo) throws Exception;
	
	// 회사 정보 저장(cmpny_info)
	void insertCmpny(SaveMemberUpateVO vo)throws Exception;
	
	// 사용자 - 사업자 목록 조회
	List<?> selectUserCompnyList(SearchVO vo)throws Exception;
	
	// 사용자 - 사업자 목록 갯수 조회 
	int selectUserCompnyListCnt(SearchVO vo)throws Exception;
	
	
	
	

	
	


	
	


	

}