package egovframework.dw.cmmn.service;

import java.util.List;

public interface ConectInfoService {

	//접속 목록 조회
	List<?> selectConectList(SearchVO vo) throws Exception;

	//접속 총 갯수 조회
	int selectConectListCnt(SearchVO vo) throws Exception;

	//접속 정보 저장
	void saveConectInfo(UserSessionVO userVO) throws Exception;

}