package egovframework.pf.exp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.SaveExpFileVO;
import egovframework.pf.exp.service.SaveExpMainVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("cusExpUploadMapper")
public interface CusExpUploadMapper {
	
	// 레디 수출 공통 insert
	int insertReadyExportDataA1(Map<String, Object> data);
	// 레디 수출 란 insert
	int insertReadyExportDataB1(Map<String, Object> data);
	// 레디 수출 규격 insert
	int insertReadyExportDataC1(Map<String, Object> data);

	Map<String, String> insertReadyExportDataA1Seq(String rptNo);

	Map<String, String> insertReadyExportDataB1Seq(@Param("rptNo") String rptNo, @Param("ranNo") String ranNo);

	Map<String, String> insertReadyExportDataC1Seq(@Param("rptNo") String rptNo, @Param("ranNo") String ranNo, @Param("sil") String sil);
	// 엔컴 수출 공통 insert
	int insertEncomExportDataA1(Map<String, Object> data);
	// 엔컴 수출 란 insert
	int insertEncomExportDataB1(Map<String, Object> data);
	// 엔컴 수출 규격 insert
	int insertEncomExportDataC1(Map<String, Object> data);
	// 공통 내역 리스트
	List<?> selectCusExpViewList(SearchVO vo);
	// 파일내역 리스트
	List<?> selectCusFileList(SearchVO vo);

	List<?> selectCusExpViewLanList(SearchVO vo);

	List<?> selectCusExpViewSpecList(SearchVO vo);

	void deleteCusExpDataA1(SearchVO vo);

	void deleteCusExpDataB1(SearchVO vo);

	void deleteCusExpDataC1(SearchVO vo);
	
	// DHL 수출 공통 insert 
	int insertDHLExportDataA1(Map<String, Object> data);
	// DHL 수출 란 insert 
	int insertDHLExportDataB1(Map<String, Object> data);
	// DHL 수출 규격 insert 
	int insertDHLExportDataC1(Map<String, Object> data);


	
}