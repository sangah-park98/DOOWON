package egovframework.dw.cmmn.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SaveMemberUpateVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

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