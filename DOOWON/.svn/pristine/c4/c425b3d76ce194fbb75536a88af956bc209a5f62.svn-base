package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveAuthorVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 권한정보 매퍼 클래스
 *
 * @author  권예지	
 * @since 2024.02.07
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일           		     수정자         				  수정내용
 *     ----------------    ------------    ---------------------------
 *       2024.02.07                      권예지     				 최초 생성
 *
 * </pre>
 */
@Mapper("AuthorMapper")
public interface AuthorMapper {

	//사용자그룹 목록 조회
	List<?> selectUserGrpInfoList(SearchVO vo) throws Exception;

	//사용자그룹 총 갯수 조회
	int selectUserGrpInfoListCnt(SearchVO vo) throws Exception;

	//사용자그룹 정보 저장
	void insertUserGrpInfo(SaveAuthorVO vo) throws Exception;

	//메뉴별권한 목록 조회
	List<?> selectMenuAuthorList(SearchVO vo) throws Exception;

	//메뉴별권한 총 갯수 조회
	int selectMenuAuthorListCnt(SearchVO vo) throws Exception;

	//메뉴별권한 정보 저장
	void insertMenuAuthor(SaveAuthorVO vo) throws Exception;

	//신규사용자 매뉴등록
	void insertNewMenuAuthor(SaveAuthorVO vo) throws Exception;

	String selectAuthorMember(SearchVO vo);
	// menuId 드롭다운
	List<?> selectMenuIdDropdown();
	// 그룹코드 드롭다운
	List<?> selectGroupCodeDropdown();
	// 메뉴이름 드롭다운
	List<?> selectMenuNameDropdown();

	void insertGroupAuthor(SaveAuthorVO vo);
}