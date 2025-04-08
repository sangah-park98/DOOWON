package egovframework.pf.rpt.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



/**
 * 기한관리 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.03.25
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		  수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.03.25                    권예지          				최초 생성
 *
 * </pre>
 */
@Mapper("deadLineMapper")
public interface deadLineMapper {

	List<?> selectImportdeadLineList(SearchVO vo)throws Exception;

	int selectImportdeadLineListCnt(SearchVO vo)throws Exception;

	List<?> selectExportdeadLineList(SearchVO vo)throws Exception;

	int selectExportdeadLineListCnt(SearchVO vo)throws Exception;


}