package egovframework.pf.notice.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.notice.service.saveNoticeVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 수입 매퍼 클래스
 *
 * @author  서인석
 * @since 2024.01.10
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		  수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.01.10                      서인석          				최초 생성
 *
 * </pre>
 */
@Mapper("pfNoticeMapper")
public interface pfNoticeMapper {

	List<?> selectMainNoticeViewList(SearchVO vo) throws Exception;
	
	int selectMainNoticeViewCnt(SearchVO vo) throws Exception;

	List<?> selectModalViewList(SearchVO vo) throws Exception;

	void insertNoticeInputList(saveNoticeVO nvo) throws Exception;

	void deleteNoticeViewList(SearchVO vo) throws Exception;

	void updateNoticeViewList(SearchVO vo) throws Exception;

}