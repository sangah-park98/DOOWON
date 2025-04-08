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
public interface MenuService {
	// 메뉴 조회
	List<?> selectMenuList(SearchVO vo)throws Exception;
	// 메뉴 갯수 조회
	int selectMenuListCnt(SearchVO vo)throws Exception;
	// 상위메뉴 작업 
	List<?> selectUpprMenuDropdown()throws Exception;
	// 메뉴 저장 
	void savePfMenuInfo(List<SaveMenuVO> voList, UserSessionVO userVO);


	
	
}