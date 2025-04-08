package egovframework.pf.item.service;

import java.util.List;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
/**
 * @Class Name : ItemService.java
 * @Description : ItemService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.27          	권예지         			최초 생성
 *
 * @author 권예지
 * @since 2024.02.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

public interface pfItemService {

	List<?> selectItemViewSpecList2(SearchVO vo)throws Exception;

	List<?> selectItemViewMemoList(SearchVO vo)throws Exception;

	void saveItemViewSpec(List<SaveSpecVO> voList, UserSessionVO userVO) throws Exception;

	List<?> selecteditItemViewMemoList(SearchVO vo, UserSessionVO userVO) throws Exception;

	void saveItemViewMemo(List<SaveMemoVO> voList, UserSessionVO userVO) throws Exception;
	// 중복허용 x 수입,수출 전체 아이템 조회
	List<?> selectItemViewList(SearchVO vo)throws Exception;
	// 중복허용 x 수입,수출 전체 아이템 갯수
	int selectItemViewListCnt(SearchVO vo)throws Exception;
	// 중복허용 x 수입 아이템조회
	List<?> selectItemViewimportList(SearchVO vo)throws Exception;
	// 중복허용 x 수입 아이템 갯수
	int selectItemViewimportListCnt(SearchVO vo)throws Exception;
	// 중복허용 x 수출 아이템조회
	List<?> selectItemViewExportList(SearchVO vo)throws Exception;
	// 중복허용 x 수출 아이템 갯수
	int selectItemViewExportListCnt(SearchVO vo)throws Exception;
	// 중복허용O 수입,수출 전체 아이템 조회
	List<?> selectDuplicationItemViewList(SearchVO vo)throws Exception;
	// 중복허용O 수입,수출 전체 아이템 갯수 
	int selectDuplicationItemViewListCnt(SearchVO vo)throws Exception;
	// 중복허용O 수입  아이템 조회
	List<?> selectDuplicationItemViewimportList(SearchVO vo)throws Exception;
	// 중복허용O 수입  아이템 갯수
	int selectDuplicationItemViewimportListCnt(SearchVO vo)throws Exception;
	// 중복허용O 수출  아이템 조회
	List<?> selectDuplicationItemViewExportList(SearchVO vo)throws Exception;
	// 중복허용O 수출  아이템 갯수
	int selectDuplicationItemViewExportListCnt(SearchVO vo)throws Exception;
	// 통관정보
	List<?> selectItemViewLanList(SearchVO vo)throws Exception;
	// 통관정보 검색
	List<?> selectitemViewLanList2(SearchVO vo)throws Exception;
	// 수입통관정보
	List<?> selectItemViewLanImportList(SearchVO vo)throws Exception;
	// 수출통관정보
	List<?> selectItemViewLanExportList(SearchVO vo)throws Exception;
	// 수입통관정보 검색
	List<?> selectitemViewLanImportList2(SearchVO vo)throws Exception;
	// 수출통관정보 검색
	List<?> selectitemViewLanExportList2(SearchVO vo)throws Exception;
	// 요건정보
	List<?> selectItemViewSpecList(SearchVO vo)throws Exception;
	// edit 일때 요건정보 (내가 쓴 요건정보만 보이게 작업)
	List<?> selectEditItemViewSpecList(SearchVO vo, UserSessionVO userVO)throws Exception;

	int selectItemViewLanImportListCnt(SearchVO vo)throws Exception;

	int selectItemViewLanExportListCnt(SearchVO vo)throws Exception;

	int selectItemViewLanListCnt(SearchVO vo)throws Exception;
	//엑셀다운로드 요건정보
	List<?> selectItemViewSpecExcelList(SearchVO vo)throws Exception;
	//엑셀다운로드 메모정보
	List<?> selectItemViewMemoExcelList(SearchVO vo)throws Exception;


	

}