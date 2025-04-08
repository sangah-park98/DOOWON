package egovframework.dw.cmmn.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SaveMsgVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("msgMapper")
public interface MsgMapper {

	List<?> selectPfMsgList(SearchVO vo);

	int selectPfMsgListCnt(SearchVO vo);

	void insertPfMsgInfo(SaveMsgVO vo);

}