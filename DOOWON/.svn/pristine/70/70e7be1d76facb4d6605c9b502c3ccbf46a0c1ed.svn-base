package egovframework.pf.docu.service;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.SaveExpFileVO;


public interface pfDocumentService {

	List<?> selectDocumentViewListByRptNo(String rptNo) throws Exception;

	List<?> selectDocumentImpViewList(SearchVO vo) throws Exception;
	
	List<?> selectDocuImpModalUpdateList(SearchVO vo) throws Exception;

	int selectDocuViewImpTotCnt(SearchVO vo) throws Exception;

	int selectDocuViewExpTotCnt(SearchVO vo) throws Exception;

	List<?> selectDocumentExpViewList(SearchVO vo) throws Exception;

	void insertImpDocuFilesInfo(SaveDocuFileVO vo) throws Exception;
	
	void dropDocuImpModalFile(SearchVO vo) throws Exception;

	void dropDocuExpModalFile(SearchVO vo) throws Exception;
	
	void insertExpDocuFilesInfo(SaveDocuFileVO vo) throws Exception;
	
	List<?> selectDownloadFileList(Object paramMap) throws Exception;

	List<?> selectDocuExpModalUpdateList(SearchVO vo) throws Exception;

	void deleteDocuFile(SearchVO vo) throws Exception;

	void docuPopupDeleteList(SearchVO vo) throws Exception;
	
}