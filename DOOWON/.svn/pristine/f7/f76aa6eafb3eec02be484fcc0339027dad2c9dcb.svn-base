package egovframework.pf.imp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 타관세사 데이터(수입) 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.07.31
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		  수정자          				 수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.07.31                    권예지          				최초 생성
 *
 * </pre>
 */
@Mapper("cusImpUploadMapper")
public interface CusImpUploadMapper {

	int insertReadyImportDataA1(Map<String, Object> data);

	int insertReadyImportDataB1(Map<String, Object> data);

	int insertReadyImportDataC1(Map<String, Object> data);
	// 레디 공통 insert
	Map<String, String> insertReadyImportDataA1Seq(String rptNo);
	// 레디 란 insert
	Map<String, String> insertReadyImportDataB1Seq(@Param("rptNo") String rptNo, @Param("ranNo") String ranNo);
	// 레디 규격 insert
	Map<String, String> insertReadyImportDataC1Seq(@Param("rptNo") String rptNo, @Param("ranNo") String ranNo, @Param("sil") String sil);
	// 타관세사 파일 업로드 현황내역
	List<?> selectCusImpViewList(SearchVO vo);
	// 타관세사 파일 업로드 정보
	List<?> selectCusImpFileList(SearchVO vo);
	// 타관세사 파일 업로드 란내역
	List<?> selectCusImpViewLanList(SearchVO vo);
	// 타관세사 파일 업로드 규격내역
	List<?> selectCusImpViewSpecList(SearchVO vo);
	// 엔컴 공통 insert
	int insertEncomImportDataA1(Map<String, Object> data);
	// 엔컴 란 insert
	int insertEncomImportDataB1(Map<String, Object> data);
	// 엔컴 규격 insert
	int insertEncomImportDataC1(Map<String, Object> data);

	void deleteCusImpDataA1(SearchVO vo);

	void deleteCusImpDataB1(SearchVO vo);

	void deleteCusImpDataC1(SearchVO vo);

	// FEDEX 공통 insert
	int insertFedexImportDataB1(Map<String, Object> data);
	// FEDEX 란 insert
	int insertFedexImportDataC1(Map<String, Object> data);
	// FEDEX 규격 insert
	int insertFedexImportDataA1(Map<String, Object> data);
	// DHL 공통 insert
	int insertDHLImportDataA1(Map<String, Object> data);
	// DHL 란 insert
	int insertDHLImportDataB1(Map<String, Object> data);
	// DHL 규격 insert
	int insertDHLImportDataC1(Map<String, Object> data);
	// UPS 공통 insert
	int insertUPSImportDataA1(Map<String, Object> data);
	// UPS 란 insert
	int insertUPSImportDataB1(Map<String, Object> data);
	// UPS 규격 insert
	int insertUPSImportDataC1(Map<String, Object> data);
	


}