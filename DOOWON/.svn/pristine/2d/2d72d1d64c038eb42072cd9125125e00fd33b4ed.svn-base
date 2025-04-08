package egovframework.pf.cmmn.service;

import java.util.List;

/**
 * @Class Name : CompanyService.java
 * @Description : CompanyService Class
 * @Modification Information
 * @
 * @         수정일                          수정자                              수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.05          권예지                                최초 생성
 *
 * @author 권예지
 * @since 2024.01.30
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

public interface CompanyService {
		
	// 회사정보 목록 조회
	List<?> selectCmpnyList(SearchVO vo)throws Exception;
	
	// 회사 정보 총 갯수 조회 
	int selectCmpnyListCnt(SearchVO vo)throws Exception;
	
	// 회사정보 저장
	void saveCompnyInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO)throws Exception;

}
