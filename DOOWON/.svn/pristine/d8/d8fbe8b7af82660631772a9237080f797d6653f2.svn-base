package egovframework.pf.member.sevice;

import java.util.List;
import java.util.Map;

public interface MemberCodeService {

	public List<Map<String,Object>> getCodeGroupList(Object obj) throws Exception;			//시스템 그룹코드 리스트
	public int getCodeGroupCount(Object obj) throws Exception;								//시스템 그룹코드 카운트
	public List<Map<String,Object>> getCodeCommonList(Object obj) throws Exception;			//시스템 공통코드 리스트
	public int getCodeCommonCount(Object obj) throws Exception;								//시스템 공통코드 카운트
	public int insertGroupCode(Object obj) throws Exception;								//시스템 그룹등록
	public int insertCommonCode(Object obj) throws Exception;								//시스템 공통등록
	public int updateGroupCode(Object obj) throws Exception;								//시스템 그룹수정 
	public int updateCommonStatusCode(Object obj) throws Exception;							//시스템 공통 상태 수정 
	public int updateCommonCode(Object obj) throws Exception;								//시스템 공통수정 
	public List<Map<String,Object>> getCodeWord(Object obj) throws Exception ;				//메뉴에서 사용할 단어
	public int checkGroupCodeId(Object obj) throws Exception;								//시스템 그룹코드 중복체크
	public int checkCommonCodeId(Object obj) throws Exception;								//시스템 공통코드 중복체크
	public List<Map<String, Object>> dataHeaderCode(Object obj) throws Exception;			//data headerCode List

	public Map<String, Object> getMailCode(Map<String, Object> obj) throws Exception;		//메일 타이틀
	
	public Map<String, Object> getOneCode(Map<String, Object> obj) throws Exception;		// 원코드
}
