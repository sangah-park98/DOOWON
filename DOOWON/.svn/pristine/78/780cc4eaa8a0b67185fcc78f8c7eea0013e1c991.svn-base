package egovframework.pf.rpt.service.impl;



import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.rpt.service.SaveFundSettleVO;
import egovframework.pf.rpt.service.SaveFundSettledetailVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;




/**
 * 자금정산 매퍼 클래스
 *
 * @author  권예지
 * @since 2025.02.17
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2025.02.17          	권예지         			최초 생성
 *
 * </pre>
 */
@Mapper("fundSettleMapper")
public interface fundSettleMapper {

	List<?> selectMasterInfo(SearchVO vo)throws Exception;

	void savefundSettle(SaveFundSettleVO vo)throws Exception;

	void updatefundSettle(SaveFundSettleVO vo)throws Exception;

	List<?> selectfundSettle(SearchVO vo)throws Exception;

	String selectfrKey(SearchVO vo)throws Exception;

	String selectmrnNo(String frKey)throws Exception;

	List<?> selectfundSettleDetail(SearchVO vo)throws Exception;

	List<?> selectCustomsList()throws Exception;

	List<?> selectforwordList()throws Exception;

	List<?> selectTransportationList()throws Exception;

	List<?> selectWarehouseList()throws Exception;

	List<?> selectPremiumList()throws Exception;

	void savefundSettleDetail(SaveFundSettledetailVO vo)throws Exception;

	List<?> selectfeeList()throws Exception;

	List<?> selectMasterList()throws Exception;

	void insertfundSettleEtc(SaveFundSettledetailVO vo)throws Exception;

	void insertDeadlineYn(SaveFundSettledetailVO vo)throws Exception;
	
}