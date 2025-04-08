package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveCmmnCdVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 공통코드 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.04.16
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		   수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.04.16                     권예지          			최초 생성
 *
 * </pre>
 */
@Mapper("cmmnCdMapper")
public interface CmmnCdMapper {

	List<?> selectPfCmmnCdList(SearchVO vo);

	int selectPfCmmnCdListCnt(SearchVO vo);

	List<?> selectCmmnGrpDropdown();

	void insertPfCmmnCd(SaveCmmnCdVO vo);

	
}