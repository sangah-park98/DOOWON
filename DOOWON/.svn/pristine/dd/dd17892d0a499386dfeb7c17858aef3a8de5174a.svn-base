package egovframework.pf.rpt.service;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;

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

public interface CalculService {
	
	
	
	String saveCalExcel(List<SaveCalculateVO> voList, UserSessionVO userVO) throws Exception;
	
	String saveCalCodeList(List<SaveCalCodeVO> calList, UserSessionVO userVO) throws Exception;
	
	List<?> selectCalculPartnList(SearchVO vo) throws Exception;
	
	List<?> selectCalculCodeList(SearchVO vo) throws Exception;
	
	List<?> selectCmmnCodeList(SearchVO vo) throws Exception;
	
	List<?> selectCalCodeList(SearchVO vo) throws Exception;
	
	List<?> selectCalculInfo(SearchVO vo) throws Exception;
	
	List<?> selectCalculDetailInfo(SearchVO vo) throws Exception;
	
	List<?> selectCalculDetailViewInfo(SearchVO vo) throws Exception;
	
	String partnCmpnySave(SearchVO vo, UserSessionVO userVO) throws Exception;
	
	String calCodeSave(SearchVO vo, UserSessionVO userVO) throws Exception;
	
}
