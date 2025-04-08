package egovframework.pf.cmmn.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 공통 매퍼 클래스
 *
 * @author  심창무
 * @since 2020.01.15
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일            			수정자          				수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.13        		 권예지        				최초 생성
 *
 * </pre>
 */
@Mapper("CmmnMapper")
public interface CmmnMapper {

	//로그인체크
	Map<String, String> selectCmpnyIdCheck(SearchVO searchVO) throws Exception;

	//회사목록 조회
	List<?> selectUsrCmpnyList(SearchVO vo) throws Exception;

	//대메뉴 조회
	List<?> selectLargeMenuList(SearchVO vo) throws Exception;

	//소메뉴 조회
	List<?> selectSmallMenuList(SearchVO vo) throws Exception;

	//특정메뉴정보 조회
	List<?> selectDashboardInfo(SearchVO vo) throws Exception;

	//메시지 조회
	List<?> selectMsgList(SearchVO vo) throws Exception;

	//공통코드 조회(팝업)
	List<?> selectCmmnCdPop(SearchVO vo) throws Exception;

	//공통코드 총 갯수 조회(팝업)
	int selectCmmnCdPopCnt(SearchVO vo) throws Exception;

	//공통팝업 테이블 정보 조회(팝업)
	List<?> selectCmmnTableInfoList(SearchVO vo) throws Exception;

	//공통팝업 테이블 정보 갯수 조회(팝업)
	int selectCmmnTableInfoListCnt(SearchVO vo) throws Exception;

	//공통코드 조회
	List<?> selectCmmnCdList(SearchVO vo) throws Exception;

	//작성권한 체크
	String selectWriteCheck(SearchVO vo) throws Exception;
	
	//협정별 국가정보코드 리스트(콤보박스용)
	List<?> selectFtaCmmnCdList(SearchVO vo) throws Exception;
	
	//협정정보
	List<?> selectFtaList(SearchVO VO) throws Exception;
	
	//HSVER
	List<?> selectHsVerList(SearchVO VO) throws Exception;
	

}