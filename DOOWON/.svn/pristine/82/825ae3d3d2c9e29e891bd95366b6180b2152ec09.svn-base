package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveConectInfoVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 접속정보 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.02.13
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일            		    수정자                                      수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.13                      권예지         			최초 생성
 *
 * </pre>
 */
@Mapper("conectionInfoMapper")
public interface ConectInfoMapper {

	//접속 목록 조회
	List<?> selectConectList(SearchVO vo) throws Exception;

	//접속 총 갯수 조회
	int selectConectListCnt(SearchVO vo) throws Exception;

	//접속 정보 저장
	void insertConectInfo(SaveConectInfoVO vo) throws Exception;

}