package egovframework.dw.cmmn.service;

import java.util.List;

public interface MsgService {

	List<?> selectPfMsgList(SearchVO vo)throws Exception;

	int selectPfMsgListCnt(SearchVO vo)throws Exception;

	void insertPfMsgInfo(List<SaveMsgVO> voList, UserSessionVO userVO)throws Exception;

}