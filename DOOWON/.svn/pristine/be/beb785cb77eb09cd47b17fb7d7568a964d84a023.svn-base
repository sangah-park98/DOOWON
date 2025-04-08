package egovframework.pf.cmmn.service;

import java.util.List;

/**
 * @Class Name : AuthorService.java
 * @Description : AuthorService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          			 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.07         	 권예지          			 최초 생성
 *
 * @author 권예지
 * @since 2024.02.07
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */
public interface AuthorService {

	//권한정보 목록 조회
	List<?> selectAuthorList(SearchVO vo) throws Exception;

	//권한정보 총 갯수 조회
	int selectAuthorListCnt(SearchVO vo) throws Exception;

	//권한정보 정보 저장
	void saveAuthorInfo(List<SaveAuthorVO> voList, UserSessionVO userVO) throws Exception;
	// menuId 드롭다운
	List<?> selectMenuIdDropdown()throws Exception;
	// 그룹코드 드롭다운
	List<?> selectGroupCodeDropdown()throws Exception;

	List<?> selectMenuNameDropdown()throws Exception;
}