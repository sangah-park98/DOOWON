package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveChangeHistVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 변경이력 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.02.03
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일            		    수정자                                   수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.03            권예지                                 최초 생성
 *
 * </pre>
 */
@Mapper("changeHistoryMapper")
public interface ChangeHistMapper {

	//변경이력 목록 조회
	List<?> selectChangeHistList(SearchVO vo) throws Exception;

	//변경이력 총 갯수 조회
	int selectChangeHistListCnt(SearchVO vo) throws Exception;

	//변경이력 정보 저장
	void insertChangeHistInfo(SaveChangeHistVO vo) throws Exception;

}