package egovframework.ms.docu.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 서류관리 매퍼 클래스
 *
 * @author  박상아
 * @since 2024.02.26
 * @version 1.0
 * @param <DocumentMapper>
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		  수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.26                      박상아          				최초 생성
 *
 * </pre>
 */
@Mapper("documentMapper")
public interface DocumentMapper {

	List<?> selectDocumentViewList(SearchVO vo) throws Exception;

	List<?> selectDocumentViewListByRptNo(String rptNo) throws Exception;


}