package egovframework.pf.dashboard.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 대시보드 매퍼 클래스
 *
 * @author  심창무
 * @since 2020.01.15
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일            수정자           수정내용
 *     ----------------    ------------    ---------------------------
 *       2020.01.15          심창무          최초 생성
 *
 * </pre>
 */
@Mapper("dashboardMapper")
public interface DashboardMapper {

	EgovMap selectDashNoticeInfo(SearchVO vo) throws Exception;

	List<?> selectDashboardInfoImp1(SearchVO vo) throws Exception;
	
	List<?> selectDashboardInfoExp1(SearchVO vo) throws Exception;
	
	List<?> selectDashboardInfoImp2(SearchVO vo) throws Exception;
	
	List<?> selectDashboardInfoExp2(SearchVO vo) throws Exception;
	
	List<?> selectDashboardInfoImp3(SearchVO vo) throws Exception;
	
	List<?> selectDashboardInfoExp3(SearchVO vo) throws Exception;
	
	List<?> selectDashboardNoticeList(SearchVO vo) throws Exception;
	
	List<?> selectDashboardNewsList(SearchVO vo) throws Exception;

	List<?> selectDashNoticeViewList(SearchVO vo) throws Exception;

}