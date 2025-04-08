package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 사용자정보 매퍼 클래스
 *
 * @author  권예지
 * @since 2024.01.31
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일                            수정자                                   수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.01.31            권예지                                    최초 생성
 *
 * </pre>
 */
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