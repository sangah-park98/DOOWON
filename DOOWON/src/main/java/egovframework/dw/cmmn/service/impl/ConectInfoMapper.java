package egovframework.dw.cmmn.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SaveConectInfoVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("conectionInfoMapper")
public interface ConectInfoMapper {

	List<?> selectConectList(SearchVO vo) throws Exception;

	int selectConectListCnt(SearchVO vo) throws Exception;

	void insertConectInfo(SaveConectInfoVO vo) throws Exception;

}