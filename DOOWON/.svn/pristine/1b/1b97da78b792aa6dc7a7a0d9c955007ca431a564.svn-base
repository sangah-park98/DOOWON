package egovframework.pf.cmmn.service;

import java.util.List;


/**
 * @Class Name : UserService.java
 * @Description : serService Class
 * @Modification Information
 * @
 * @         수정일                          수정자                              수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.01.30          권예지                                최초 생성
 *
 * @author 권예지
 * @since 2024.01.30
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface UserService {

	// 사용자정보 목록 조회
	List<?> selectUserInfoList(SearchVO vo) throws Exception;

	// 사용자정보 총 갯수 조회
	int selectUserInfoListCnt(SearchVO vo) throws Exception;

	// 사용자정보 정보 저장
	void saveUserInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO) throws Exception;
	
	
}