package egovframework.pf.rpt.service;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;

/**
 * @Class Name : KPIService.java
 * @Description : KPIService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.04         	이재성         			최초 생성
 *
 * @author 이재성
 * @since 2024.04.04
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

public interface KPIService {
	
	// 수입 정확성 관리
	List<?> selectKpiImportList(SearchVO vo)throws Exception;
	
	// 수입 정확성 관리 갯수
	int selectKpiImportListCnt(SearchVO vo)throws Exception;
		
	// 수출 정확성 관리
	List<?> selectKpiExportList(SearchVO vo)throws Exception;
	
	// 수출 정확성 관리 갯수
	int selectKpiExportListCnt(SearchVO vo)throws Exception;
	
	// 수입신고 LeadTime
	List<?> selectKpiLeadtimeList(SearchVO vo)throws Exception;
	
	// 수입신고 LeadTime 겟수
	int selectKpiLeadtimeListCnt(SearchVO vo)throws Exception;
}
