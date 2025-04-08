package egovframework.dw.remains.service;

import java.util.List;

import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;

public interface remainsQtyService {

	List<?> selectRemainsViewList(SearchVO vo) throws Exception;

	List<?> selectRemainsRptNoList(SearchVO vo) throws Exception;

	List<?> selectRemainsInputList(SearchVO vo) throws Exception;

	void insertRemainsInputList(List<remainsInfoVO> voList, UserSessionVO userVO) throws Exception;

	List<?> getImporterList() throws Exception;

	void deleteRemainsInputList(remainsInfoVO vo) throws Exception;
}