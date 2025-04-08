package egovframework.dw.remains.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.remains.service.remainsInfoVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("remainsQtyMapper")
public interface remainsQtyMapper {

	List<?> selectRemainsViewList(SearchVO vo) throws Exception;

	List<?> selectRemainsRptNoList(SearchVO vo) throws Exception;

	List<?> selectRemainsInputList(SearchVO vo) throws Exception;

	void insertRemainsInputList(remainsInfoVO rvo) throws Exception;

	List<?> getImporterList() throws Exception;

	void deleteRemainsInputList(remainsInfoVO vo) throws Exception;
}