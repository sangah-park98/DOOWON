package egovframework.dw.cmmn.service;

import java.util.List;


public interface CompanyService {
		
	// 회사정보 목록 조회
	List<?> selectCmpnyList(SearchVO vo)throws Exception;
	
	// 회사 정보 총 갯수 조회 
	int selectCmpnyListCnt(SearchVO vo)throws Exception;
	
	// 회사정보 저장
	void saveCompnyInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO)throws Exception;

}
