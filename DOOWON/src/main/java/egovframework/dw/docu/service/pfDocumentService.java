package egovframework.dw.docu.service;

import java.util.List;

import egovframework.dw.cmmn.service.SearchVO;


public interface pfDocumentService {

	List<?> selectDocumentViewListByRptNo(String rptNo) throws Exception;

	List<?> selectDocumentImpViewList(SearchVO vo) throws Exception;
	
	List<?> selectDocuImpModalUpdateList(SearchVO vo) throws Exception;

	int selectDocuViewImpTotCnt(SearchVO vo) throws Exception;

	int selectDocuViewExpTotCnt(SearchVO vo) throws Exception;

	List<?> selectDocumentExpViewList(SearchVO vo) throws Exception;

	void insertImpDocuFilesInfo(SaveDocuFileVO vo) throws Exception;
	
	void insertExpDocuFilesInfo(SaveDocuFileVO vo) throws Exception;
	
	List<?> selectDownloadFileList(Object paramMap) throws Exception;

	List<?> selectDocuExpModalUpdateList(SearchVO vo) throws Exception;

	void deleteDocuFile(SearchVO vo) throws Exception;

}