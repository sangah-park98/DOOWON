package egovframework.pf.cmmn.service;

import java.util.List;

/**
 * @Class Name : CmmnCdService.java
 * @Description : CmmnCdService Class
 * @Modification Information
 * @
 * @         수정일            			수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.16          	권예지        			 최초 생성
 *
 * @author 권예지
 * @since 2024.04.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */
public interface CmmnCdService {
	//공통코드 리스트
	List<?> selectPfCmmnCdList(SearchVO vo)throws Exception;
	//공통코드 총갯수 
	int selectPfCmmnCdListCnt(SearchVO vo)throws Exception;
	// 등록,편집 그룹코드 드롭다운
	List<?> selectCmmnGrpDropdown()throws Exception;
	//저장
	void savePfCmmnCdInfo(List<SaveCmmnCdVO> voList, UserSessionVO userVO)throws Exception;


}