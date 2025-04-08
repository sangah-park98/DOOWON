package egovframework.pf.exp.service;

import java.util.List;
import java.util.Map;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;

/**
 * @Class Name : ExportService.java
 * @Description : ExportService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.01.10          	박상아         			최초 생성
 *
 */

public interface pfExportService {

	List<?> selectExportInList(SearchVO vo) throws Exception;
	
	List<?> selectExpViewFilesList(SearchVO vo) throws Exception;
	
	void saveExportFileInfo(SaveExpFileVO vo) throws Exception;
	
	void saveMakeInFile(SaveExpFileVO vo) throws Exception;
	
	void insertExportFilesInfo(SaveExpFileVO vo) throws Exception;
	
	List<?> selectInFilesList(SearchVO vo) throws Exception;
	
	int selectExportInTotCnt(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInTradeList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInAprPortList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInNationList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInUOMList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkInCurrencyList(SearchVO vo) throws Exception;
	
	List<?> selectExportMkPLtotCntList(SearchVO vo) throws Exception;
	
	void saveInvoiceMainList(List<SaveExpMainVO> voList, UserSessionVO userVO) throws Exception;
	
	void saveTempExpMakeInList(List<SaveExpMainVO> voList, UserSessionVO userVO) throws Exception;
	
	void saveTempExpMakeInSubList(List<SaveExpMainVO> voList, UserSessionVO userVO, String mainSeq) throws Exception;
	
	String selectTempInvoiceMainIdex(String index) throws Exception;
	
	String checkTempInvoiceNumber(SearchVO schVo) throws Exception;
	
	String selectInvoiceMainIdex(String index) throws Exception;
	
	void saveInvoiceSubList(List<SaveExpMainVO> voList, UserSessionVO userVO, String index) throws Exception;
	
	void savePackingListMainList(List<SaveExpMainVO> voList, UserSessionVO userVO) throws Exception;
	
	String selectPackingListMainIdex(String index) throws Exception;
	
	void insertPackingListSubList(List<SaveExpMainVO> voList, UserSessionVO userVO, String mainSeq) throws Exception;
	
	List<?> selectExportUpdateList(SearchVO vo) throws Exception;

	List<?> selectExportViewSpecList(SearchVO vo) throws Exception;

	List<?> selectExportViewList(SearchVO vo) throws Exception;

	List<?> selectExportViewLanList(SearchVO vo) throws Exception;

	int selectExportViewTotCnt(SearchVO vo) throws Exception;

	int selectExportUpdateTotCnt(SearchVO vo) throws Exception;
	
	String checkInvoiceNumber(SearchVO schVo) throws Exception;
	
	void updateManufactPackList(SearchVO schVo) throws Exception;
	
	void updateTempManufactPlList(SearchVO schVo) throws Exception;
	
	String selectTempPlMainIdex(String index) throws Exception;
	
	void saveTempExpMakePlSubList(List<SaveExpMainVO> voList, UserSessionVO userVO, String mainSeq) throws Exception;

	List<?> selectTempInvoiceMainList(SearchVO vo) throws Exception;

	void deleteTempExpMakeInList(SearchVO vo) throws Exception;
	
	void deleteTempExpMakeInSubList(SearchVO vo) throws Exception;
	
	List<?> selectTempInvoiceSubList(SearchVO vo) throws Exception;

	void expPopupDeleteList(SearchVO vo) throws Exception;

	void deleteExpInFile(SearchVO vo) throws Exception;

	void saveExpUserMemo(SearchVO vo) throws Exception;

	void expRequestBl(SearchVO vo) throws Exception;
	
}