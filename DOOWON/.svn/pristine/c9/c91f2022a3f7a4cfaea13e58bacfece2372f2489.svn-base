package egovframework.ms.item.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



/**
 * 아이템 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.02.16
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		  수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.16                      권예지          				최초 생성
 *
 * </pre>
 */
@Mapper("itemMapper")
public interface ItemMapper {

	List<?> selectItemViewList(SearchVO vo)throws Exception;

	int selectItemViewListCnt(SearchVO vo)throws Exception;

	List<?>selectItemViewLanList(SearchVO vo)throws Exception;

	List<?> selectItemViewSpecList(SearchVO vo)throws Exception;

	List<?> selectItemViewimportList(SearchVO vo)throws Exception;

	int selectItemViewimportListCnt(SearchVO vo)throws Exception;

	List<?> selectItemViewExportList(SearchVO vo)throws Exception;

	int selectItemViewExportListCnt(SearchVO vo)throws Exception;

	List<?> selectItemViewLanImportList(SearchVO vo)throws Exception;

	List<?> selectItemViewLanExportList(SearchVO vo)throws Exception;

	List<?> selectitemViewLanList2(SearchVO vo)throws Exception;

	List<?> selectitemViewLanImportList2(SearchVO vo)throws Exception;

	List<?> selectitemViewLanExportList2(SearchVO vo)throws Exception;

	List<?> selectDuplicationItemViewList(SearchVO vo)throws Exception;

	int selectDuplicationItemViewListCnt(SearchVO vo)throws Exception;

	List<?> selectDuplicationItemViewimportList(SearchVO vo)throws Exception;

	int selectDuplicationItemViewimportListCnt(SearchVO vo)throws Exception;

	List<?> selectDuplicationItemViewExportList(SearchVO vo)throws Exception;

	int selectDuplicationItemViewExportListCnt(SearchVO vo)throws Exception;

}