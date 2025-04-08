package egovframework.pf.rpt.service;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;

/**
 * @Class Name : fundSettleService.java
 * @Description : fundSettleService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2025.02.17        	권예지         			최초 생성
 *
 * @author 권예지
 * @since 2025.02.17
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

public interface fundSettleService {

	List<?> selectMasterInfo(SearchVO vo)throws Exception;

	void savefundSettle(List<SaveFundSettleVO> voList, UserSessionVO userVO)throws Exception;

	List<?> selectfundSettle(SearchVO vo)throws Exception;

	String selectfrKey(SearchVO vo)throws Exception;

	String selectmrnNo(String frKey)throws Exception;

	List<?> selectfundSettleDetail(SearchVO vo)throws Exception;

	List<?> selectCustomsList()throws Exception;

	List<?> selectforwordList()throws Exception;

	List<?> selectTransportationList()throws Exception;

	List<?> selectWarehouseList()throws Exception;

	List<?> selectPremiumList()throws Exception;

	void savefundSettleDetail(List<SaveFundSettledetailVO> voList, UserSessionVO userVO)throws Exception;

	List<?> selectfeeList()throws Exception;

	List<?> selectMasterList()throws Exception;

	void savefundSettleEtc(List<SaveFundSettledetailVO> voList, UserSessionVO userVO)throws Exception;

	void insertDeadlineYn(List<SaveFundSettledetailVO> setVoList, UserSessionVO userVO)throws Exception;
;



}
