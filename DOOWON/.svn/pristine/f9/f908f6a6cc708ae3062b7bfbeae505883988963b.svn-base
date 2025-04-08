package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveMsgVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 메시지 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.04.19
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일            		 수정자           					수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.04.19                   권예지         				        최초 생성
 *
 * </pre>
 */
@Mapper("msgMapper")
public interface MsgMapper {

	List<?> selectPfMsgList(SearchVO vo);

	int selectPfMsgListCnt(SearchVO vo);

	void insertPfMsgInfo(SaveMsgVO vo);


}