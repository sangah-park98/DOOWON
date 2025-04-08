package egovframework.dw.cmmn.service;

import java.util.List;
import java.util.Map;

public interface CmmnService {

	//로그인체크
	List<Map<String, String>> selectCmpnyIdCheck(SearchVO vo) throws Exception;

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

	//코드 조회(팝업)
	List<?> selectCmmnCdPop(SearchVO vo) throws Exception;

	//공통코드 갯수 조회(팝업)
	int selectCmmnCdPopCnt(SearchVO vo) throws Exception;

	//공통코드 조회
	List<?> selectCmmnCdList(SearchVO vo) throws Exception;

	//작성권한 체크
	String selectWriteCheck(String param, UserSessionVO userVO) throws Exception;

	List<?> selectAllCmpnyList(SearchVO vo) throws Exception;
}

