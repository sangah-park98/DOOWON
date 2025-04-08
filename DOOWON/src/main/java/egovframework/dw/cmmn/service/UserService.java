package egovframework.dw.cmmn.service;

import java.util.List;

public interface UserService {

	// 사용자정보 목록 조회
	List<?> selectUserInfoList(SearchVO vo) throws Exception;

	// 사용자정보 총 갯수 조회
	int selectUserInfoListCnt(SearchVO vo) throws Exception;

	// 사용자정보 정보 저장
	void saveUserInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO) throws Exception;
}