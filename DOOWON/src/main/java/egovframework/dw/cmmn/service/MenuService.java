package egovframework.dw.cmmn.service;

import java.util.List;

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