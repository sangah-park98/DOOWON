package egovframework.dw.cmmn.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SaveMemberUpateVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("CompanyMapper")
public interface CompanyMapper {
	
	// 사업자 목록 조회
	List<?> selectCmpnyList(SearchVO vo)throws Exception;
	// 사업자 갯수 조회
	int selectCmpnyListCnt(SearchVO vo)throws Exception;
	// 사업자 등록
	void insertCompny(SaveMemberUpateVO vo)throws Exception;
	// 사업자 - 지사 목록 조회
	List<?> selectCmpnyBranchInfo(SearchVO vo)throws Exception;
	// 사업자 - 지사 갯수 조회
	int selectCmpnyBranchInfoCnt(SearchVO vo)throws Exception;
	// 사업자 - 지사 등록
	void insertCmpnyBranchInfo(SaveMemberUpateVO vo)throws Exception;
	
}