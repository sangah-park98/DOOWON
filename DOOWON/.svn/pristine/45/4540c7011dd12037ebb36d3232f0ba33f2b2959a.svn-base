package egovframework.pf.rpt.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



/**
 * KPI 매퍼 클래스
 *
 * @author  이재성
 * @since 2024.04.04
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.04          	이재성         			최초 생성
 *
 * </pre>
 */
@Mapper("kpiMapper")
public interface KPIMapper {

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
	
	// 수입신고 LeadTime 갯수
	int selectKpiLeadtimeListCnt(SearchVO vo)throws Exception;
}